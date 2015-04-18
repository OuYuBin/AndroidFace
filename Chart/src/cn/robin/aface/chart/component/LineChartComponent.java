package cn.robin.aface.chart.component;

import cn.robin.aface.chart.adapter.ChartAdapter;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.view.IBaseChartView;
import cn.robin.aface.core.runtime.IAdaptable;

/**
 * Created by robin on 15-3-26.
 */
public class LineChartComponent extends BaseChartComponent {

    protected float mYDeltaVal;

    protected float mXDeltaVal;

    protected float mXMinVal;

    protected float mYMinVal;

    public boolean isInvert() {
        return mIsInvert;
    }

    public void setIsInvert(boolean isInvert) {
        this.mIsInvert = isInvert;
    }

    protected boolean mIsInvert;

    protected ChartDataSet mChartDataSet;

    public LineChartComponent(IAdaptable chartView) {
        super(chartView);
    }

    public void setYDeltaVal(float yDeltaVal) {
        this.mYDeltaVal = yDeltaVal;
    }

    public void setXMinVal(float xMinVal) {
        this.mXMinVal = xMinVal;
    }

    public void setYMinVal(float yMinVal) {
        this.mYMinVal = yMinVal;
    }

    public void setXDeltaVal(float xDeltaVal) {
        this.mXDeltaVal = xDeltaVal;
    }


    public void prepareMatrix() {
        if (mTransformer != null) {
            mTransformer.prepareMatrixOffset(true);
            mTransformer.prepareMatrixValuePx(mXMinVal, mXDeltaVal, mYMinVal, mYDeltaVal);
        }
    }

    public ChartDataSet getChartDataSet() {
        return mChartDataSet;
    }

    public void setChartDataSet(ChartDataSet chartDataSet) {
        this.mChartDataSet = chartDataSet;
    }

    @Override
    public Object getAdapter(Class adapter) {
        if(adapter.equals(ChartAdapter.class)){
            return new ChartAdapter(this);
        }
        return null;
    }
}
