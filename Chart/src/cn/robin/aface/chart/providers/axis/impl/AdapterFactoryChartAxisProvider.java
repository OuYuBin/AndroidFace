package cn.robin.aface.chart.providers.axis.impl;

import android.graphics.Color;
import cn.robin.aface.chart.adapter.ChartComponentAdapterFactory;
import cn.robin.aface.chart.adapter.LineChartComponentAdapter;
import cn.robin.aface.chart.adapter.XAxisComponentAdapter;
import cn.robin.aface.chart.adapter.YAxisComponentAdapter;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.providers.axis.ILineChartAxisProvider;

/**
 * Created by robin on 15-5-30.
 * 轴工厂提供器
 */
public class AdapterFactoryChartAxisProvider implements ILineChartAxisProvider {

    ChartComponentAdapterFactory mChartComponentAdapterFactory;

    public AdapterFactoryChartAxisProvider(ChartComponentAdapterFactory chartComponentAdapterFactory) {
        this.mChartComponentAdapterFactory = chartComponentAdapterFactory;
    }

    @Override
    public int getXAxisModulus(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getXAxisModulus(object);
    }

    @Override
    public String[] getXAxisEntries(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getEntries(object);
    }

    @Override
    public float[] getYAxisEntries(Object object) {
        YAxisComponentAdapter yAxisComponentAdapter = (YAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, YAxisComponentAdapter.class);
        return yAxisComponentAdapter.getEntries(object);
    }

    @Override
    public int[] getXAxisOffsets(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getXAxisOffsets(object);
    }

    @Override
    public int[] getYAxisOffsets(Object object) {
        YAxisComponentAdapter yAxisComponentAdapter = (YAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, YAxisComponentAdapter.class);
        return yAxisComponentAdapter.getYAxisOffsets(object);
    }

    @Override
    public FontStyle getXAxisFontStyle(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getFontStyle(object);
    }

    @Override
    public FontStyle getYAxisFontStyle(Object object) {
        YAxisComponentAdapter yAxisComponentAdapter = (YAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, YAxisComponentAdapter.class);
        return yAxisComponentAdapter.getFontStyle(object);
    }

    @Override
    public int getXAxisColor(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getColor(object);
    }

    @Override
    public int getYAxisColor(Object object) {
        YAxisComponentAdapter yAxisComponentAdapter = (YAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, YAxisComponentAdapter.class);
        return yAxisComponentAdapter.getColor(object);
    }

    @Override
    public int getXGridColor(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getGridColor(object);
    }

    @Override
    public int getYGridColor(Object object) {
        YAxisComponentAdapter yAxisComponentAdapter = (YAxisComponentAdapter) mChartComponentAdapterFactory.adapter(object, YAxisComponentAdapter.class);
        return yAxisComponentAdapter.getGridColor(object);
    }


}