package cn.robin.aface.chart.component;

import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.model.ChartDataSet;

/**
 * Created by robin on 15-3-26.
 */
public class LineChartComponent extends BaseChartComponent {


    public float[] getXAxisOffsets() {
        float[] offsets = new float[]{
                20f, 20f
        };
        return offsets;
    }

    public float[] getYAxisOffsets() {
        float[] offsets = new float[]{
                0f, 20f
        };
        return offsets;
    }

    public int getYAxisLabelCount() {
        return 5;
    }

    public FontStyle getXAxisFontStyle() {
        return new FontStyle(18);
    }

    public FontStyle getYAxisFontStyle() {
        return new FontStyle(18);
    }


//    protected float mYDeltaVal;
//
//    protected float mXDeltaVal;
//
//    protected float mXMinVal;
//
//    protected float mYMinVal;
//
//    public boolean isInvert() {
//        return mIsInvert;
//    }
//
//    public void setIsInvert(boolean isInvert) {
//        this.mIsInvert = isInvert;
//    }
//
//    protected boolean mIsInvert;
//
//    protected ChartDataSet mChartDataSet;
//
//    public LineChartComponent() {
//        super();
//    }
//
//    public void setYDeltaVal(float yDeltaVal) {
//        this.mYDeltaVal = yDeltaVal;
//    }
//
//    public void setXMinVal(float xMinVal) {
//        this.mXMinVal = xMinVal;
//    }
//
//    public void setYMinVal(float yMinVal) {
//        this.mYMinVal = yMinVal;
//    }
//
//    public void setXDeltaVal(float xDeltaVal) {
//        this.mXDeltaVal = xDeltaVal;
//    }
//
//
//    public void prepareMatrix() {
//        if (mTransformer != null) {
//            mTransformer.prepareMatrixOffset(true);
//            mTransformer.prepareMatrixValuePx(mXMinVal, mXDeltaVal, mYMinVal, mYDeltaVal);
//        }
//    }
//
//    public ChartDataSet getChartDataSet() {
//        return mChartDataSet;
//    }
//
//    public void setChartDataSet(ChartDataSet chartDataSet) {
//        this.mChartDataSet = chartDataSet;
//    }
//
//    @Override
//    public Object getAdapter(Class adapter) {
//        if(adapter.equals(ChartAdapter.class)){
//            return new ChartAdapter(this);
//        }
//        return null;
//    }
}
