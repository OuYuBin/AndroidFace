package cn.robin.aface.chart.model;

import cn.robin.aface.chart.BaseLineChart;
import cn.robin.aface.chart.IBaseChartElement;
import cn.robin.aface.chart.component.LineChartComponent;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.component.YAxisComponent;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.model.vistor.ChartDataVisitor;
import cn.robin.aface.chart.providers.ILineChartAxisProvider;
import cn.robin.aface.chart.providers.ILineChartContentProvider;
import cn.robin.aface.chart.providers.ILineChartLabelProvider;
import cn.robin.aface.chart.utils.FontUtil;
import cn.robin.aface.chart.view.IBaseChartView;
import cn.robin.aface.chart.view.LineChartView;

import java.util.List;

/**
 * Created by robin on 15-3-28.
 */
public class ModelParserFactory {

    public static void parserModeToChartElement(ChartDataVisitor chartDataVisitor) {
        IBaseChartView chartView = chartDataVisitor.getChartView();
        ChartDataSet chartDataSet = chartDataVisitor.getChartDataSet();
        float yMaxVal = chartDataVisitor.getYMaxVal();
        float yMinVal = chartDataVisitor.getYMinVal();

        updateChartComponents(chartView, chartDataSet, yMaxVal, yMinVal);
    }


    private static void updateChartComponents(IBaseChartView chartView, ChartDataSet chartDataSet, float yMaxVal, float yMinVal) {
        if (chartView instanceof LineChartView) {
            updateLineChartComponent((LineChartView) chartView, chartDataSet, yMaxVal, yMinVal);
        }

    }

    private static void updateLineChartComponent(LineChartView chartView, ChartDataSet chartDataSet, float yMaxVal, float yMinVal) {

        //--根据用户自定义provider来完成自定义数据信息获取
        ILineChartContentProvider lineChartContentProvider = (ILineChartContentProvider) chartView.getChartContentProvider();
        ILineChartAxisProvider lineChartAxisProvider = (ILineChartAxisProvider) chartView.getChartAxisProvider();
        ILineChartLabelProvider lineChartLabelProvider = (ILineChartLabelProvider) chartView.getChartLabelProvider();

        IBaseChartElement chartElement = chartView.getChartElement();

        Object[] objects = chartDataSet.getChartDatas().toArray(new Object[0]);
        int xAxisValue = lineChartContentProvider.getXAxisCount(objects);
        int xDeltaVal = xAxisValue - 0;

        //--根据偏移量及轴字体高度重新定义图表矩形对象参数
        float[] xAxisOffset = lineChartAxisProvider.getXAxisOffsets();
        float[] yAxisOffset = lineChartAxisProvider.getYAxisOffsets();

        FontStyle fontStyle = lineChartAxisProvider.getFontStyle();
        float labelHeight = FontUtil.calcFontHeight(fontStyle);
        float labelWidth = FontUtil.calcFontWidth(fontStyle, String.valueOf(yMaxVal));
        chartView.getViewPortManager().restrainViewPort(yAxisOffset[0] + labelWidth, xAxisOffset[0], yAxisOffset[1], xAxisOffset[1] + labelHeight);


        LineChartComponent lineChartComponent = (LineChartComponent) chartElement.getComponent();
        lineChartComponent.setChartDataSet(chartDataSet);
        lineChartComponent.setXDeltaVal(xDeltaVal);
        lineChartComponent.setYDeltaVal(Math.abs(yMaxVal - yMinVal));
        lineChartComponent.setXMinVal(0);
        lineChartComponent.setYMinVal(0);
        lineChartComponent.prepareMatrix();


        XAxisComponent xAxisComponent = (XAxisComponent) ((BaseLineChart) chartElement).getXAxis().getComponent();
        List<String> list = lineChartContentProvider.getXVals(objects);
        xAxisComponent.setModulus(lineChartContentProvider.getXAxisModulus(objects));
        xAxisComponent.setXMaxVal(xAxisValue);
        xAxisComponent.setFontStyle(lineChartAxisProvider.getFontStyle());
        //xAxisComponent.setOffset(lineChartLabelProvider.getXAxisOffset());
        xAxisComponent.setEntries(list);

        YAxisComponent yAxisComponent = (YAxisComponent) ((BaseLineChart) chartElement).getYAxis().getComponent();
        yAxisComponent.setYMaxVal(yMaxVal);
        yAxisComponent.setYMinVal(yMinVal);
        yAxisComponent.setFontStyle(lineChartAxisProvider.getFontStyle());
        yAxisComponent.setLabelCount(lineChartContentProvider.getYAxisCount(objects));
    }
}
