package cn.robin.aface.chart.providers;

import cn.robin.aface.chart.font.FontStyle;

/**
 * Created by robin on 15-4-17.
 * 开放给开发人员关于线图中轴信息的提供器接口,包括各轴边距等
 */
public interface ILineChartAxisProvider {

    public static final float AXIS_OFFSET_LEFT=10f;

    public static final float AXIS_OFFSET_RIGHT=30f;

    public static final float AXIS_OFFSET_TOP=30f;

    public static final float AXIS_OFFSET_BOTTOM=20f;

    //--X轴边距
    public float[] getXAxisOffsets();

    //--Y轴边距
    public float[] getYAxisOffsets();

    public FontStyle getFontStyle();

}
