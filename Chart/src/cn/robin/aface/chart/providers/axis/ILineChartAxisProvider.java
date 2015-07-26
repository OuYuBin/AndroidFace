package cn.robin.aface.chart.providers.axis;

import cn.robin.aface.chart.adapter.ChartComponentAdapterFactory;
import cn.robin.aface.chart.font.FontStyle;

/**
 * Created by robin on 15-4-17.
 * 开放给开发人员关于线图中轴信息的提供器接口,包括各轴边距等
 */
public interface ILineChartAxisProvider extends IChartAxisProvider{

    public static final int AXIS_OFFSET_LEFT=20;

    public static final int AXIS_OFFSET_RIGHT=20;

    public static final int AXIS_OFFSET_TOP=20;

    public static final int AXIS_OFFSET_BOTTOM=20;



}
