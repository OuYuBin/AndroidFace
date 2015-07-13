package cn.robin.aface.chart.providers.axis.impl;


import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.providers.axis.ILineChartAxisProvider;

/**
 * Created by robin on 15-4-17.
 * 自定义图表轴提供器基类
 */
public class BaseLineChartAxisProvider implements ILineChartAxisProvider {

    @Override
    public float[] getYAxisEntries(Object object) {
        return new float[0];
    }

    @Override
    public int getXAxisModulus(Object object) {
        return 5;
    }

    @Override
    public String[] getXAxisEntries(Object object) {
        return new String[0];
    }


    //@Override
    public String[] getEntries(Object object) {
        return new String[0];
    }


    @Override
    public float[] getXAxisOffsets(Object object) {
        float[] offsets = new float[]{
                0f, AXIS_OFFSET_BOTTOM
        };
        return offsets;
    }

    @Override
    public float[] getYAxisOffsets(Object object) {
        float[] offsets = new float[]{
                0f, AXIS_OFFSET_BOTTOM
        };
        return offsets;
    }


    public FontStyle getXAxisFontStyle(Object object) {
        FontStyle fontStyle = new FontStyle(15);
        return fontStyle;
    }

    public FontStyle getYAxisFontStyle(Object object) {
        FontStyle fontStyle = new FontStyle(15);
        return fontStyle;
    }

    @Override
    public int getXAxisColor(Object object) {
        return 0;
    }

    @Override
    public int getYAxisColor(Object object) {
        return 0;
    }

    @Override
    public int getXGridColor(Object object) {
        return 0;
    }

    @Override
    public int getYGridColor(Object object) {
        return 0;
    }
}
