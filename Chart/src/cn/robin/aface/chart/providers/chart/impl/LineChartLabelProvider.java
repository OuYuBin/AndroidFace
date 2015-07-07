package cn.robin.aface.chart.providers.chart.impl;

import cn.robin.aface.chart.adapter.LineChartComponentAdapter;

/**
 * Created by robin on 15-7-4.
 */
public class LineChartLabelProvider extends BaseChartLabelProvider{

    public LineChartLabelProvider(){

    }


    public float[] getXAxisOffsets(Object object) {
        return new float[]{0,0};

    }

    public float[] getYAxisOffsets(Object object) {
       return new float[]{0,0};
    }
}
