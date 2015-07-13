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

    ChartComponentAdapterFactory chartComponentAdapterFactory;

    public AdapterFactoryChartAxisProvider(ChartComponentAdapterFactory chartComponentAdapterFactory) {
        this.chartComponentAdapterFactory = chartComponentAdapterFactory;
    }

    public int getXAxisModulus(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getXAxisModulus(object);
    }

    public String[] getXAxisEntries(Object object){
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getEntries(object);
    }

    public float[] getYAxisEntries(Object object){
        YAxisComponentAdapter yAxisComponentAdapter = (YAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, YAxisComponentAdapter.class);
        return yAxisComponentAdapter.getEntries(object);
    }

    @Override
    public float[] getXAxisOffsets(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getXAxisOffsets(object);
    }

    @Override
    public float[] getYAxisOffsets(Object object) {
        YAxisComponentAdapter yAxisComponentAdapter = (YAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, YAxisComponentAdapter.class);
        return yAxisComponentAdapter.getYAxisOffsets(object);
    }

    @Override
    public FontStyle getXAxisFontStyle(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getFontStyle(object);
    }

    @Override
    public FontStyle getYAxisFontStyle(Object object) {
        YAxisComponentAdapter yAxisComponentAdapter = (YAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, YAxisComponentAdapter.class);
        return yAxisComponentAdapter.getFontStyle(object);
    }

    @Override
    public int getXAxisColor(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getColor(object);
    }

    @Override
    public int getYAxisColor(Object object) {
        YAxisComponentAdapter yAxisComponentAdapter = (YAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, YAxisComponentAdapter.class);
        return yAxisComponentAdapter.getColor(object);
    }

    @Override
    public int getXGridColor(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
        return xAxisComponentAdapter.getGridColor(object);
    }

    @Override
    public int getYGridColor(Object object) {
        YAxisComponentAdapter yAxisComponentAdapter = (YAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, YAxisComponentAdapter.class);
        return yAxisComponentAdapter.getGridColor(object);
    }


}