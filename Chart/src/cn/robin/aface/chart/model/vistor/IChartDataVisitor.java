package cn.robin.aface.chart.model.vistor;

import cn.robin.aface.chart.model.ChartData;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.model.ChartEntry;

/**
 * Created by robin on 15-3-21.
 */
public interface IChartDataVisitor {

    public void visit(ChartDataSet chartDataSet);

    public void visit(ChartData chartData);
}
