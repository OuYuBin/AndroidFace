package cn.robin.aface.chart.adapter;

import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;

/**
 * Created by robin on 15-3-23.
 * 图表元件基础适配器,用于管理图标元件在屏幕上的显示与元件对象本身属性的适配
 * 适配器所持有的属性在元件绘制过程中被调用,则属性值填充则需要在构造器中就完成
 */
public class BaseChartComponentAdapter implements IChartComponentAdapter{

    protected ViewPortManager mViewPortManager;

    protected Transformer mTransformer;

    protected IChartComponent mChartComponent;

    public BaseChartComponentAdapter(IChartComponent chartComponent) {
        this.mChartComponent = chartComponent;
        this.mViewPortManager = this.mChartComponent.getViewPortManager();
        this.mTransformer = this.mChartComponent.getTransformer();
    }

}
