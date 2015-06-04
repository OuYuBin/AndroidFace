package cn.robin.aface.chart.model;

import cn.robin.aface.chart.model.vistor.ChartDataVisitor;
import cn.robin.aface.chart.providers.*;
import cn.robin.aface.chart.view.IChartView;
import cn.robin.aface.chart.view.LineChartView;

/**
 * Created by robin on 15-3-28.
 */
public class ChartModelBuildFactory {

    public static void parserModeToChartElement(ChartDataVisitor chartDataVisitor) {
        IChartView chartView = chartDataVisitor.getChartView();
        ChartDataSet chartDataSet = chartDataVisitor.getChartDataSet();
        float yMaxVal = chartDataVisitor.getYMaxVal();
        float yMinVal = chartDataVisitor.getYMinVal();

        updateChartComponents(chartView, chartDataSet, yMaxVal, yMinVal);
    }


    private static void updateChartComponents(IChartView chartView, ChartDataSet chartDataSet, float yMaxVal, float yMinVal) {
        if (chartView instanceof LineChartView) {
            updateLineChartComponent((LineChartView) chartView, chartDataSet, yMaxVal, yMinVal);
        }

    }

    private static void updateLineChartComponent(LineChartView chartView, ChartDataSet chartDataSet, float yMaxVal, float yMinVal) {

        //--此处需要重写,通过已存在的提供器完成向元件的适配

        //--根据用户自定义provider来完成自定义数据信息获取
        ILineChartContentProvider lineChartContentProvider = (ILineChartContentProvider) chartView.getChartContentProvider();
        ILineChartAxisProvider lineChartAxisProvider = (ILineChartAxisProvider) chartView.getChartAxisProvider();
        ILineChartLabelProvider lineChartLabelProvider = (ILineChartLabelProvider) chartView.getChartLabelProvider();

        //--如果发现开发人员未通过提供器完成属性设置,则需要通过工厂适配器层直接完成元件对象适配器的属性配置
        if (lineChartAxisProvider == null) {
            //chartView.setChartContentProvider(new AdapterFactoryChartContentProvider(chartView.getChartComponentAdapterFactory()));
        }
        if (lineChartLabelProvider == null) {
            //chartView.setChartlabelProvider(new AdapterFactoryChartLabelProvider(chartView.getChartComponentAdapterFactory()));
        }
        if (lineChartAxisProvider == null) {
            chartView.setChartAxisProvider(new AdapterFactoryChartAxisProvider(chartView.getChartComponentAdapterFactory()));
        }


//        IBaseChartControl chartElement = chartView.getChartElement();
//
//        Object[] objects = chartDataSet.getChartDatas().toArray(new Object[0]);
//        int xAxisValue = lineChartContentProvider.getXAxisCount(objects);
//        int xDeltaVal = xAxisValue - 0;
//
//        //--根据偏移量及轴字体高度重新定义图表矩形对象参数
//        float[] xAxisOffset = lineChartAxisProvider.getXAxisOffsets();
//        float[] yAxisOffset = lineChartAxisProvider.getYAxisOffsets();
//
//        FontStyle fontStyle = lineChartAxisProvider.getFontStyle();
//        float labelHeight = FontUtil.calcFontHeight(fontStyle);
//        float labelWidth = FontUtil.calcFontWidth(fontStyle, String.valueOf(yMaxVal));
//        chartView.getViewPortManager().restrainViewPort(yAxisOffset[0] + labelWidth, xAxisOffset[0], yAxisOffset[1], xAxisOffset[1] + labelHeight);
//
//
//        LineChartComponent lineChartComponent = (LineChartComponent) chartElement.getComponent();
//        lineChartComponent.setChartDataSet(chartDataSet);
//        lineChartComponent.setXDeltaVal(xDeltaVal);
//        lineChartComponent.setYDeltaVal(Math.abs(yMaxVal - yMinVal));
//        lineChartComponent.setXMinVal(0);
//        lineChartComponent.setYMinVal(0);
//        lineChartComponent.prepareMatrix();
//
//
//        XAxisComponent xAxisComponent = (XAxisComponent) ((BaseLineChart) chartElement).getXAxis().getComponent();
//        List<String> list = lineChartContentProvider.getXVals(objects);
//        xAxisComponent.setModulus(lineChartContentProvider.getXAxisModulus(objects));
//        xAxisComponent.setXMaxVal(xAxisValue);
//        xAxisComponent.setFontStyle(lineChartAxisProvider.getFontStyle());
//        //xAxisComponent.setOffset(lineChartLabelProvider.getXAxisOffset());
//        xAxisComponent.setEntries(list);
//
//        YAxisComponent yAxisComponent = (YAxisComponent) ((BaseLineChart) chartElement).getYAxis().getComponent();
//        yAxisComponent.setYMaxVal(yMaxVal);
//        yAxisComponent.setYMinVal(yMinVal);
//        yAxisComponent.setFontStyle(lineChartAxisProvider.getFontStyle());
//        yAxisComponent.setLabelCount(lineChartContentProvider.getYAxisCount(objects));
    }
}
