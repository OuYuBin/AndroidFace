package cn.robin.aface.chart.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import cn.robin.aface.chart.BaseLineChart;
import cn.robin.aface.chart.R;
import cn.robin.aface.chart.listeners.BaseLineChartTouchListener;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.model.ChartModelManager;

/**
 * Created by robin on 15-3-29.
 */
public class LineChartView extends BaseChartView {

    protected ChartDataSet mChartDataSet;

    public float xAxisLeftOffset;

    public LineChartView(Context context) {
        super(context);
    }

    public LineChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void init() {
        super.init();
        mChartTouchListener = new BaseLineChartTouchListener(this);
        //--构建所需图表元件
        createControl();
    }

    @Override
    public TypedArray getTypeArray(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.LineChart);
        return typedArray;
    }

    @Override
    public void configureView(TypedArray typedArray) {
        setPropertyType("xAxisBottomOffset", typedArray.getInteger(R.styleable.LineChart_xAxisBottomOffset, 20));
        setPropertyType("xAxisTopOffset", typedArray.getInteger(R.styleable.LineChart_xAxisTopOffset, 20));
        setPropertyType("xAxisFontSize", typedArray.getInteger(R.styleable.LineChart_xAxisFontSize, 18));
        setPropertyType("xAxisModulus", typedArray.getInteger(R.styleable.LineChart_xAxisModulus, 5));

        setPropertyType("yAxisLeftOffset", typedArray.getInteger(R.styleable.LineChart_yAxisLeftOffset, 20));
        setPropertyType("yAxisRightOffset", typedArray.getInteger(R.styleable.LineChart_yAxisRightOffset, 20));
        setPropertyType("yAxisFontSize", typedArray.getInteger(R.styleable.LineChart_yAxisFontSize, 18));
    }

    private void createControl() {
        mChartElement = new BaseLineChart(this);
    }

    public void setModel(ChartDataSet chartDataSet) {
        this.mChartDataSet = chartDataSet;
        notifyDataSetChange();
    }

    @Override
    public ChartDataSet getModel() {
        return this.mChartDataSet;
    }


    public void notifyDataSetChange() {
        //--对基本元件数据对象进行赋值填充
        ChartModelManager.calculateChartModel(this, mChartDataSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            return;
        }
        canvas.drawColor(Color.rgb(32, 32, 32));
        drawChart(canvas);
    }

    private void drawChart(Canvas canvas) {
        mChartElement.paintComponent(canvas);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (isInEditMode()) {
            return;
        }
        if (w > 0 && h > 0) {
            mViewPortManager.setChartDimensions(w, h);
        }
        notifyDataSetChange();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if (mChartTouchListener != null) {
            //Log.d("LineChartView",event.toString());
            mChartTouchListener.onTouch(this, event);
        }
        return true;
    }


    @Override
    public Object getAdapter(Class adapter) {
        return super.getAdapter(adapter);
    }
}
