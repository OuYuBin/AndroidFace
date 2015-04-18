package cn.robin.aface.chart.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import cn.robin.aface.chart.BaseLineChart;
import cn.robin.aface.chart.listeners.BaseLineChartTouchListener;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.model.ChartModelManager;
import cn.robin.aface.core.runtime.IAdaptable;

/**
 * Created by robin on 15-3-29.
 */
public class LineChartView extends BaseChartView {

    protected ChartDataSet mChartDataSet;

    public LineChartView(Context context) {
        super(context);
    }

    public LineChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void init() {
        super.init();
        mChartTouchListener=new BaseLineChartTouchListener(this);
        //--构建所需图表元件
        createControl();
        //--填充元件模型
        setContent(this);
    }

    private void createControl() {
        mChartElement = new BaseLineChart();
    }

    public void setModel(ChartDataSet chartDataSet) {
        this.mChartDataSet = chartDataSet;
        notifyDataSetChange();
    }

    public void notifyDataSetChange() {
        //--对基本元件数据对象进行赋值填充
        ChartModelManager.calculateChartModel(this, mChartDataSet);
    }

    private void setContent(IAdaptable adapter) {
        ((BaseLineChart) mChartElement).setContent(adapter);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        drawChart(canvas);
    }

    private void drawChart(Canvas canvas) {
        mChartElement.paintComponent(canvas);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w > 0 && h > 0) {
            mViewPortManager.setChartDimensions(w, h);
        }
        notifyDataSetChange();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public boolean onTouchEvent(MotionEvent event){
        super.onTouchEvent(event);
        if(mChartTouchListener!=null){
            //Log.d("LineChartView",event.toString());
            mChartTouchListener.onTouch(this, event);
        }
        return true;
    }


}
