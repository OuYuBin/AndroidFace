package cn.robin.aface.chart.view;

import cn.robin.aface.chart.providers.IChartContentProvider;
import cn.robin.aface.chart.providers.IChartLabelProvider;
import cn.robin.aface.core.runtime.IAdaptable;

/**
 * Created by robin on 15-3-30.
 */
public interface IBaseChartView extends IAdaptable{

    public IChartLabelProvider getChartLabelProvider();

    public IChartContentProvider getChartContentProvider();

}
