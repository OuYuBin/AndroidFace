package cn.robin.aface.chart.adapter;

import cn.robin.aface.chart.component.IChartComponent;

/**
 * Created by robin on 15-4-17.
 */
public class BaseAxisAdapter extends BaseChartComponentAdapter{

    private String mLongestLabel;


    public BaseAxisAdapter(IChartComponent chartComponent) {
        super(chartComponent);
    }

    public String getLongestLabel() {
        return mLongestLabel;
    }

    public void setLongestLabel(String longestLabel) {
        this.mLongestLabel = longestLabel;
    }
}
