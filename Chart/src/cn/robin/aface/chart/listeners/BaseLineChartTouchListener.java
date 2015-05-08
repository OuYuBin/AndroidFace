package cn.robin.aface.chart.listeners;

import android.graphics.PointF;
import android.util.EventLog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import cn.robin.aface.chart.matrix.ChartMatrix;
import cn.robin.aface.chart.utils.ViewPortManager;
import cn.robin.aface.chart.view.BaseChartView;
import cn.robin.aface.core.runtime.IAdaptable;

/**
 * Created by robin on 15-3-22.
 */
public class BaseLineChartTouchListener implements IChartOnTouchListener {

    private float mXDist = 0f;
    private float mYDist = 0f;
    private float mPointDist = 1f;

    private int mTouchMode = NONE;
    private ViewPortManager mViewPortManager;

    //--原始图表矩阵对象
    private ChartMatrix mChartMatrix = new ChartMatrix();

    private ChartMatrix mSavedChartMatrix = new ChartMatrix();
    private PointF mTouchStartPointF = new PointF();
    private PointF mTouchPointCenter = new PointF();
    private IAdaptable mAdapter;


    public BaseLineChartTouchListener(IAdaptable adapter) {
        this.mAdapter = adapter;
        this.mViewPortManager = (ViewPortManager) adapter.getAdapter(ViewPortManager.class);
        //--获取原始矩阵
        this.mChartMatrix = mViewPortManager.getTouchMatrix();

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            //Log.d("ChartListener", String.valueOf((event.getAction() & MotionEvent.ACTION_MASK)));
            case MotionEvent.ACTION_DOWN:
                saveCurrentOfTouch(event);
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                if (event.getPointerCount() >= 2) {
                    ((BaseChartView) mAdapter).disableScroll();
                    //--记录当前
                    saveCurrentOfTouch(event);
                    mXDist = getXDist(event);
                    mYDist = getYDist(event);
                    //判断双指滑动操作
                    //--若x方向指尖距离无明显变化,判定为双指拖放
                    Log.d("ChartListener", "+++++" + mXDist + "++++" + mYDist);
                    if (mXDist <= 60F) {
                        mTouchMode = DRAG;
                        break;
                    }
                    mPointDist = getPointDist(event);
                    //--两指缩放
                    if (mPointDist > 10f) {
                        mTouchMode = PINCH_ZOOM;
//                        if (mXDist > mYDist) {
//                            mTouchMode = X_ZOOM;
//                        } else {
//                            mTouchMode = Y_ZOOM;
//                        }
                    }
                    calcMidPoint(mTouchPointCenter, event);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("ChartListener", "+++++" + mTouchMode + "");
                ((BaseChartView) mAdapter).disableScroll();
                if (mTouchMode == X_ZOOM || mTouchMode == Y_ZOOM || mTouchMode == PINCH_ZOOM) {
                    onZoom(event);
                }
                else if (mTouchMode == DRAG) {
                    onDrag(event);
                    //Log.d("ChartListener", "+++++" + DRAG+"");
                }
                break;
        }
        this.mChartMatrix = (ChartMatrix) this.mViewPortManager.refresh(mChartMatrix, (BaseChartView) mAdapter, true);
        return true;
    }

    private void onDrag(MotionEvent event) {
        if (event.getPointerCount() >= 2) {
            mChartMatrix.set(mSavedChartMatrix);
            mChartMatrix.postTranslate(event.getX() - mTouchStartPointF.x, event.getY() - mTouchStartPointF.y);
        }

    }


    private void saveCurrentOfTouch(MotionEvent event) {
        //--保存当前矩阵状态
        mSavedChartMatrix.set(mChartMatrix);
        mTouchStartPointF.set(event.getX(), event.getY());
    }

    private static void calcMidPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2f, y / 2f);
    }

    private void onZoom(MotionEvent event) {
        //Log.d("chartDemo", "mTouchMode" + mTouchMode + " " + event.toString());
        if (event.getPointerCount() >= 2) {
            //--再次计算手势中两指间的距离
            float pointDist = getPointDist(event);
            //--获取两指中心点位置在图表中的实际位置
            PointF t = new PointF(mTouchPointCenter.x, mTouchPointCenter.y);
            if (pointDist > 10f) {
                if (mTouchMode == PINCH_ZOOM) {
                    float scale = pointDist / mPointDist;
                    float scaleX = scale;
                    float scaleY = scale;
                    mChartMatrix.set(mSavedChartMatrix);
                    mChartMatrix.postScale(scaleX, scaleY, t.x, t.y);
                } else if (mTouchMode == X_ZOOM) {
                    float xDist = getXDist(event);
                    float scaleX = xDist / mXDist;
                    mChartMatrix.set(mSavedChartMatrix);
                    mChartMatrix.postScale(scaleX, 1f, t.x, t.y);
                } else if (mTouchMode == Y_ZOOM) {
                    float yDist = getYDist(event);
                    float scaleY = yDist / mYDist;
                    mChartMatrix.set(mSavedChartMatrix);
                    mChartMatrix.postScale(1f, scaleY, t.x, t.y);
                }
            }
        }


    }

    public float getXDist(MotionEvent event) {
        float x = Math.abs(event.getX(0) - event.getX(1));
        return x;
    }

    public float getYDist(MotionEvent event) {
        float y = Math.abs(event.getY(0) - event.getY(1));
        return y;
    }

    public float getPointDist(MotionEvent event) {
        return (float) Math.sqrt(getXDist(event) * getXDist(event) + getYDist(event) * getYDist(event));
    }
}
