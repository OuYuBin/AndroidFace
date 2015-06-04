package cn.robin.aface.chart.providers;

import cn.robin.aface.chart.adapter.ChartComponentAdapterFactory;

/**
 * Created by robin on 15-5-30.
 * 工厂提供器
 */
public class AdapterFactoryChartLabelProvider implements IChartLabelProvider {

    ChartComponentAdapterFactory chartComponentAdapterFactory;

    public AdapterFactoryChartLabelProvider(ChartComponentAdapterFactory chartComponentAdapterFactory) {
        this.chartComponentAdapterFactory = chartComponentAdapterFactory;
    }

}