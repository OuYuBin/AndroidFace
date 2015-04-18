package cn.robin.aface.chart.utils;

import android.graphics.Matrix;

/**
 * Created by robin on 15-3-22.
 * 图形矩阵管理转换对象
 */
public class Transformer {

    protected Matrix mMatrixValueToPx = new Matrix();


    protected Matrix mMatrixOffset = new Matrix();

    protected ViewPortManager mViewPortManager;

    public Transformer(ViewPortManager viewPortManager) {
        this.mViewPortManager = viewPortManager;
    }


    public ChartPoint getValueByPoint(float x, float y) {
        float[] pts = new float[2];
        pts[0] = x;
        pts[1] = y;

        Matrix matrix = new Matrix();

        //--做仿射坐标处理
        mMatrixValueToPx.invert(matrix);
        matrix.mapPoints(pts);

        double xPointVal = pts[0];
        double yPointVal = pts[1];

        return new ChartPoint(xPointVal, yPointVal);
    }

    //--数据信息向图形像素进行矩阵适配
    public void prepareMatrixValuePx(float xChartMin, float deltaX, float yChartMin,float deltaY) {

        //--计算缩放比例
        float scaleX = (float) (mViewPortManager.getChartWidth() / deltaX);
        float scaleY = (float) (mViewPortManager.getChartHeight() / deltaY);

        mMatrixValueToPx.reset();
        //--图形向指定坐标方向平移
        mMatrixValueToPx.postTranslate(-xChartMin, -yChartMin);
        //--向负轴方向进行比例缩放
        mMatrixValueToPx.postScale(scaleX, -scaleY);

//        //--偏移量生成
//        mMatrixOffset.reset();
//        mMatrixOffset.postTranslate(0, mViewPortManager.getChartHeight());
        prepareMatrixOffset(false);
    }

    public void prepareMatrixOffset(boolean inverted){
        mMatrixOffset.reset();
        mMatrixOffset.postTranslate(mViewPortManager.chartContentLeft(), mViewPortManager.chartContentBottom());
        //mMatrixOffset.postScale(1.0f,-1.0f);
    }

    public void pointValuesToPixel(float[] pts) {
        mMatrixValueToPx.mapPoints(pts);
        mViewPortManager.getTouchMatrix().mapPoints(pts);
        mMatrixOffset.mapPoints(pts);
    }

}
