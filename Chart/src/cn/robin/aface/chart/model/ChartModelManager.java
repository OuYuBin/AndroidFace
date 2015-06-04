package cn.robin.aface.chart.model;

import cn.robin.aface.chart.model.vistor.ChartDataVisitor;
import cn.robin.aface.chart.view.IChartView;

/**
 *
 * Created by robin on 15-3-21.
 */
public class ChartModelManager {

    public static void calculateChartModel(IChartView chartView,ChartDataSet chartDataSet){
        ChartDataVisitor chartDataVisitor=new ChartDataVisitor(chartView);
        chartDataSet.accept(chartDataVisitor);
    }
}
