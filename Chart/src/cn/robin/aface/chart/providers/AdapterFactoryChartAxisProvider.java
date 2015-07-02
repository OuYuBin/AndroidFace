package cn.robin.aface.chart.providers;

import cn.robin.aface.chart.adapter.ChartComponentAdapterFactory;
import cn.robin.aface.chart.adapter.XAxisComponentAdapter;

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


}