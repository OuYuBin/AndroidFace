package cn.robin.aface.chart.component;

import cn.robin.aface.chart.adapter.IChartComponentAdapter;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;
import cn.robin.aface.core.runtime.IAdaptable;

/**
 * Created by robin on 15-3-21.
 */
public abstract class BaseChartComponent implements IChartComponent {

    protected ChartDataSet mChartDataSet;

    public BaseChartComponent() {
    }


    public void setChartDataSet(ChartDataSet chartDataSet) {
        this.mChartDataSet = chartDataSet;
    }

    public ChartDataSet getChartDataSet() {
        return mChartDataSet;
    }

}
