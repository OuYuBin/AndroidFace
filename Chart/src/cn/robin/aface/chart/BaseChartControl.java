package cn.robin.aface.chart;

import cn.robin.aface.chart.adapter.ChartComponentAdapterFactory;
import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;
import cn.robin.aface.chart.view.IChartView;

/**
 * Created by robin on 15-3-27.
 * 关于视图元件基本对象的定义
 */
public abstract class BaseChartControl implements IBaseChartControl {

    private IChartComponent mChartComponent;



    private IChartView mChartView;

    protected ViewPortManager mViewPortManager;

    protected Transformer mTransformer;

    protected ChartComponentAdapterFactory mChartComponentAdapterFactory;

    public BaseChartControl() {

    }

    public BaseChartControl(IChartView chartView, IChartComponent chartComponent) {
        this.mChartView = chartView;
        this.mChartComponent = chartComponent;
        this.mViewPortManager = (ViewPortManager) mChartView.getAdapter(ViewPortManager.class);
        this.mTransformer = (Transformer) mChartView.getAdapter(Transformer.class);
        this.mChartComponentAdapterFactory=mChartView.getChartComponentAdapterFactory();
    }

    public void setComponent(IChartComponent chartComponent) {
        this.mChartComponent = chartComponent;
    }

    public IChartComponent getComponent() {
        return mChartComponent;
    }

    public ViewPortManager getViewPortManager() {
        return mViewPortManager;
    }

    public Transformer getTransformer() {
        return mTransformer;
    }

    public IChartView getChartView() {
        return mChartView;
    }
}
