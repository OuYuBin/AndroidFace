package cn.robin.application;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import cn.robin.aface.chart.providers.IChartLabelProvider;
import cn.robin.aface.chart.BaseLineChart;
import cn.robin.aface.chart.view.LineChartView;

/**
 * Created by robin on 15-3-21.
 */
public class SampleChart extends LineChartView {

    public SampleChart(Context context) {
        super(context);
    }

    public SampleChart(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public SampleChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
    }
}
