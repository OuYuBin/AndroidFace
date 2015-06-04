package cn.robin.aface.chart.adapter;

import cn.robin.aface.chart.component.IChartComponent;

/**
 * Created by robin on 15-4-17.
 */
public class BaseAxisComponentAdapter extends BaseChartComponentAdapter implements IXAxisComponentAdapter {

    private String mLongestLabel;


    public BaseAxisComponentAdapter() {
        super();
    }

    public String getLongestLabel() {
        return mLongestLabel;
    }

    public void setLongestLabel(String longestLabel) {
        this.mLongestLabel = longestLabel;
    }
}
