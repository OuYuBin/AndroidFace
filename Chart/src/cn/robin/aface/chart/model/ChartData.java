package cn.robin.aface.chart.model;

import cn.robin.aface.chart.model.vistor.IChartDataVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 15-3-21.
 */
public class ChartData<T extends ChartEntry> implements  IChartChartData{

    List<T> mChartEntries=new ArrayList<T>();

    public ChartData(List<T> chartEntries){
        this.mChartEntries=chartEntries;
    }

    public ChartData(Object[] objects){
        this(arrayToArrayList(objects));
    }

    private static List arrayToArrayList(Object[] objects) {
        List list=new ArrayList();
        for(int i=0;i<objects.length;i++){
            list.add(objects[i]);
        }
        return list;
    }

    public List<T> getChartEntries() {
        return mChartEntries;
    }

    public void accept(IChartDataVisitor chartDataVistor) {
        chartDataVistor.visit(this);
    }
}
