package cn.robin.aface.chart.adapter;

import cn.robin.aface.chart.component.IChartComponent;

/**
 * Created by robin on 15-4-17.
 */
public class BaseAxisAdapter extends BaseChartComponentAdapter{

    private int mAxisOffset;


    public BaseAxisAdapter(IChartComponent chartComponent) {
        super(chartComponent);
    }

    public int getAxisOffset() {
        return mAxisOffset;
    }

    public void setAxisOffset(int axisOffset) {
        this.mAxisOffset = axisOffset;
    }
}
