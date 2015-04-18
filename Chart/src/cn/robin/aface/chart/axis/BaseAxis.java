package cn.robin.aface.chart.axis;

import cn.robin.aface.chart.BaseChartElement;
import cn.robin.aface.chart.IBaseChartElement;
import cn.robin.aface.chart.adapter.IChartComponentAdapter;
import cn.robin.aface.chart.component.IChartComponent;

/**
 * Created by robin on 15-3-26.
 */
public abstract class BaseAxis extends BaseChartElement implements IBaseChartElement {

    protected IChartComponent mChartComponent;


    public IChartComponentAdapter getChartComponentAdapter(Class clazz) {
        if (mChartComponent != null) {
            IChartComponentAdapter adapter = (IChartComponentAdapter) mChartComponent.getAdapter(clazz);
            return adapter;
        } else {
            return null;
        }
    }


    public void setComponent(IChartComponent chartComponent) {
        this.mChartComponent = chartComponent;

    }

    @Override
    public IChartComponent getComponent() {
        return mChartComponent;
    }


}
