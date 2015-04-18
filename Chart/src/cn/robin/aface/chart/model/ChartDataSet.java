package cn.robin.aface.chart.model;

import cn.robin.aface.chart.model.vistor.IChartDataVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 15-3-21.
 */
public class ChartDataSet<T extends ChartData> implements IChartChartData {

    List<T> mChartDatas = new ArrayList<T>();


    public ChartDataSet(List<T> chartDatas) {
        this.mChartDatas = chartDatas;
    }


    @Override
    public void accept(IChartDataVisitor chartDataVisitor) {
        chartDataVisitor.visit(this);
    }

    public List<T> getChartDatas() {
        return mChartDatas;
    }


}
