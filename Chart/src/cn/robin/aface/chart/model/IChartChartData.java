package cn.robin.aface.chart.model;

import cn.robin.aface.chart.model.vistor.IChartDataVisitor;

/**
 * Created by robin on 15-3-21.
 */
public interface IChartChartData {
    
    public void accept(IChartDataVisitor chartDataVistor);


}
