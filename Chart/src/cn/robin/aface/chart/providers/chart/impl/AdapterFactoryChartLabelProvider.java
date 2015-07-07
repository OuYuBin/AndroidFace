package cn.robin.aface.chart.providers.chart.impl;

import cn.robin.aface.chart.adapter.ChartComponentAdapterFactory;
import cn.robin.aface.chart.providers.chart.IChartStyleProvider;

/**
 * Created by robin on 15-5-30.
 * 工厂提供器
 */
public class AdapterFactoryChartLabelProvider implements IChartStyleProvider {

    ChartComponentAdapterFactory chartComponentAdapterFactory;

    public AdapterFactoryChartLabelProvider(ChartComponentAdapterFactory chartComponentAdapterFactory) {
        this.chartComponentAdapterFactory = chartComponentAdapterFactory;
    }

}