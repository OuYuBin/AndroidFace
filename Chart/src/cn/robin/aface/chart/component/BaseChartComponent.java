package cn.robin.aface.chart.component;

import cn.robin.aface.chart.IBaseChartElement;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;
import cn.robin.aface.chart.view.IBaseChartView;
import cn.robin.aface.core.runtime.IAdaptable;

/**
 * Created by robin on 15-3-21.
 */
public abstract class BaseChartComponent implements IChartComponent {

    private IAdaptable mAdapter;

    protected ViewPortManager mViewPortManager;

    protected Transformer mTransformer;

    protected float mOffsetLeft=0f;

    protected float mOffsetRight=0f;

    protected float mOffsetBottom=0f;

    protected float mOffsetTop=0f;

    public BaseChartComponent(IAdaptable adapter) {
        this.mAdapter = adapter;
        this.mViewPortManager = (ViewPortManager) mAdapter.getAdapter(ViewPortManager.class);
        this.mTransformer = (Transformer) mAdapter.getAdapter(Transformer.class);
    }

    public ViewPortManager getViewPortManager() {
        return mViewPortManager;
    }

    public Transformer getTransformer() {
        return mTransformer;
    }

    public float getOffsetLeft() {
        return mOffsetLeft;
    }

    public void setOffsetLeft(float offsetLeft) {
        this.mOffsetLeft = offsetLeft;
    }

    public float getOffsetRight() {
        return mOffsetRight;
    }

    public void setOffsetRight(float offsetRight) {
        this.mOffsetRight = offsetRight;
    }

    public float getOffsetBottom() {
        return mOffsetBottom;
    }

    public void setOffsetBottom(float offsetBottom) {
        this.mOffsetBottom = offsetBottom;
    }

    public float getOffsetTop() {
        return mOffsetTop;
    }

    public void setOffsetTop(float offsetTop) {
        this.mOffsetTop = offsetTop;
    }
}
