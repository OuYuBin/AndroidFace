package cn.robin.aface.chart.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import cn.robin.aface.chart.matrix.ChartMatrix;
import cn.robin.aface.chart.view.BaseChartView;

/**
 * Created by robin on 15-3-21.
 * 视图屏幕参数管理对象

 */
public class ViewPortManager {



    protected ChartMatrix mTouchMatrix=new ChartMatrix();

    RectF mChartContentRect=new RectF();

    float mChartHeight=0f;

    float mChartWidth=0f;

    private float mMinScaleX=1f;

    private float mMinScaleY=1f;

    private float mScaleX =1f;

    private float mScaleY=1f;

    private float mTransOffsetX = 0f;

    private float mTransOffsetY = 0f;

    public void setChartDimensions(float width,float height) {
        mChartWidth=width;
        mChartHeight=height;
        if(mChartContentRect.width()<=0||mChartContentRect.height()<=0){
            mChartContentRect.set(0,0,width,height);
        }
    }

    public void restrainViewPort(float offsetLeft,float offsetTop,float offsetRight,float offsetBottom){
        mChartContentRect.set(offsetLeft,offsetTop,mChartWidth-offsetRight,mChartHeight-offsetBottom);
    }

    public float chartContentTop(){
        return mChartContentRect.top;
    }

    public float chartContentLeft(){
        return mChartContentRect.left;
    }

    public float chartContentBottom(){
        return mChartContentRect.bottom;
    }

    public float chartContentRight(){
        return mChartContentRect.right;
    }

    public float getChartHeight() {
        return mChartHeight;
    }


    public float getChartWidth() {
        return mChartWidth;
    }

    public RectF getChartContentRect() {
        return mChartContentRect;
    }

    public ChartMatrix getTouchMatrix() {
        return mTouchMatrix;
    }

    public void setTouchMatrix(ChartMatrix mTouchMatrix) {
        this.mTouchMatrix = mTouchMatrix;
    }

    public Matrix refresh(Matrix newMatrix, BaseChartView chart, boolean invalidate) {

        mTouchMatrix.set(newMatrix);

        //--限制无限缩小的窘境
        limitTransAndScale(mTouchMatrix, mChartContentRect);

        chart.invalidate();

        newMatrix.set(mTouchMatrix);
        return newMatrix;
    }


    public void limitTransAndScale(Matrix matrix,RectF content){
        float[] vals=new float[9];
        matrix.getValues(vals);
        float currentScaleX=vals[Matrix.MSCALE_X];
        float currentTransX=vals[Matrix.MTRANS_X];
        float currentScaleY=vals[Matrix.MSCALE_Y];
        float currentTransY=vals[Matrix.MTRANS_Y];
        mScaleX =Math.max(mMinScaleX,currentScaleX);
        mScaleY=Math.max(mMinScaleY,currentScaleY);

        float width=0f;
        float height=0f;
        if(content!=null) {
            width = content.width();
            height = content.height();
        }
        //--当缩小至1时,最大平移度降至0
        float maxTransX=-width*(mScaleX -1f);
        float newTransX = Math.min(Math.max(currentTransX, maxTransX - mTransOffsetX), mTransOffsetX);
        //--当缩小至1时,最大平移度降至0
        float maxTransY=height*(mScaleY-1f);
        float newTransY = Math.max(Math.min(currentTransY, maxTransY + mTransOffsetY), -mTransOffsetY);
        vals[Matrix.MSCALE_X]= mScaleX;
        vals[Matrix.MSCALE_Y]=mScaleY;
        vals[Matrix.MTRANS_X]=newTransX;
        vals[Matrix.MTRANS_Y]=newTransY;
        matrix.setValues(vals);
    }
}
