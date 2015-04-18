package cn.robin.aface.chart.model;

import cn.robin.aface.chart.BaseLineChart;
import cn.robin.aface.chart.IBaseChartElement;
import cn.robin.aface.chart.component.LineChartComponent;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.component.YAxisComponent;
import cn.robin.aface.chart.model.vistor.ChartDataVisitor;
import cn.robin.aface.chart.providers.ILineChartAxisProvider;
import cn.robin.aface.chart.providers.ILineChartContentProvider;
import cn.robin.aface.chart.providers.ILineChartLabelProvider;
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
        //int xLableHeight=lineChartAxisProvider.getFontStyle();
        chartView.getViewPortManager().restrainViewPort(yAxisOffset[0], xAxisOffset[0], yAxisOffset[1], xAxisOffset[1]);


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
//        int[] xAxisOffsets = lineChartAxisProvider.getXAxisOffsets();
//        xAxisComponent.setOffsetTop(xAxisOffsets[0]);
//        xAxisComponent.setOffsetLeft(xAxisOffsets[1]);
//        xAxisComponent.setOffsetRight(xAxisOffsets[2]);
//        xAxisComponent.setOffsetBottom(xAxisOffsets[3]);
        xAxisComponent.setFontStyle(lineChartAxisProvider.getFontStyle());
        //xAxisComponent.setOffset(lineChartLabelProvider.getXAxisOffset());
        xAxisComponent.setEntries(list);

        YAxisComponent yAxisComponent = (YAxisComponent) ((BaseLineChart) chartElement).getYAxis().getComponent();
        yAxisComponent.setYMaxVal(yMaxVal);
        yAxisComponent.setYMinVal(yMinVal);
        yAxisComponent.setLabelCount(lineChartContentProvider.getYAxisCount(objects));
//        int[] yAxisOffsets = lineChartAxisProvider.getYAxisOffsets();
//        yAxisComponent.setOffsetTop(yAxisOffsets[0]);
//        yAxisComponent.setOffsetLeft(yAxisOffsets[1]);
//        yAxisComponent.setOffsetRight(yAxisOffsets[2]);
//        yAxisComponent.setOffsetBottom(yAxisOffsets[3]);

        //yAxisComponent.setOffset(lineChartLabelProvider.getYAxisOffset());
    }
}
