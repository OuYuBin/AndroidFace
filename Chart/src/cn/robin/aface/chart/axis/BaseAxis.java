package cn.robin.aface.chart.axis;

import cn.robin.aface.chart.BaseChartControl;
import cn.robin.aface.chart.IBaseChartControl;
import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.view.IChartView;

/**
 * Created by robin on 15-3-26.
 */
public abstract class BaseAxis extends BaseChartControl implements IBaseChartControl {

    public BaseAxis() {
        super();
    }

    public BaseAxis(IChartView chartView, IChartComponent chartComponent) {
        super(chartView, chartComponent);
    }



}
