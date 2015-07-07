package cn.robin.aface.chart.view;

import cn.robin.aface.chart.adapter.ChartComponentAdapterFactory;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.providers.axis.IChartAxisProvider;
import cn.robin.aface.chart.providers.chart.IChartContentProvider;
import cn.robin.aface.core.runtime.IAdaptable;

import java.util.Map;

/**
 * Created by robin on 15-3-30.
 */
public interface IChartView extends IAdaptable{

    public static final int XAXIS=1;

    //public IChartLabelProvider getChartLabelProvider();

    public IChartContentProvider getChartContentProvider();

    public IChartAxisProvider getChartAxisProvider();

    public ChartComponentAdapterFactory getChartComponentAdapterFactory();

    public ChartDataSet getModel();

    public Map getProperties();

}
