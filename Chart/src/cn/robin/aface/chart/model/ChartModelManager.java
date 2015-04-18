package cn.robin.aface.chart.model;

import android.view.View;
import cn.robin.aface.chart.IBaseChartElement;
import cn.robin.aface.chart.model.vistor.ChartDataVisitor;
import cn.robin.aface.chart.view.IBaseChartView;

/**
 *
 * Created by robin on 15-3-21.
 */
public class ChartModelManager {

    public static void calculateChartModel(IBaseChartView chartView,ChartDataSet chartDataSet){
        ChartDataVisitor chartDataVisitor=new ChartDataVisitor(chartView);
        chartDataSet.accept(chartDataVisitor);
    }
}
