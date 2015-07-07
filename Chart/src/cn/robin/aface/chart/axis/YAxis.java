package cn.robin.aface.chart.axis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import cn.robin.aface.chart.adapter.YAxisComponentAdapter;
import cn.robin.aface.chart.component.YAxisComponent;
import cn.robin.aface.chart.view.IChartView;

/**
 * Created by robin on 15-3-21.
 * <p/>
 * Y轴控件的显示对象
 */
public class YAxis extends BaseAxis {

    private Paint mYAxisPaint;

    private Paint mYAxisLablePaint;

    private YAxisComponentAdapter mYAxisComponentAdapter;


    public YAxis(IChartView parent) {
        super(parent, new YAxisComponent());
    }

    public void paintComponent(Canvas canvas) {
        super.paintComponent(canvas);
        mYAxisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mYAxisPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mYAxisPaint.setColor(Color.rgb(50, 50, 50));
        canvas.drawLine(mViewPortManager.chartContentLeft(), mViewPortManager.chartContentTop(), mViewPortManager.chartContentLeft(), mViewPortManager.chartContentBottom(), mYAxisPaint);
        drawAxisLabels(canvas);

    }


    public void drawAxisLabels(Canvas canvas) {
        mYAxisComponentAdapter = (YAxisComponentAdapter) mChartComponentAdapterFactory.adapter(getComponent(), YAxisComponentAdapter.class);
        float[] labels = mYAxisComponentAdapter.getEntries(getComponent());
        //--根据刻度数值折算像素点
        int count = labels.length;
        float[] positions = new float[count * 2];
        for (int i = 0; i < positions.length; i += 2) {
            positions[i + 1] = labels[i / 2];
        }
        mTransformer.pointValuesToPixel(positions);

        drawAxisLabels(canvas, positions);

    }

    private void drawAxisLabels(Canvas canvas, float[] positions) {
        mYAxisLablePaint = new Paint();
        mYAxisLablePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mYAxisLablePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mYAxisLablePaint.setTextSize(mYAxisComponentAdapter.getFontStyle(getComponent()).getFontSize());
        mYAxisLablePaint.setTypeface(mYAxisComponentAdapter.getFontStyle(getComponent()).getTypeface());
        mYAxisLablePaint.setColor(Color.WHITE);
        mYAxisLablePaint.setTextAlign(Paint.Align.RIGHT);
        float offset = 2.0f;
        for (int i = 0; i < mYAxisComponentAdapter.getEntries(getComponent()).length; i++) {
            String text = String.valueOf(mYAxisComponentAdapter.getEntries(getComponent())[i]);
            if (positions[2 * i + 1] <= mViewPortManager.chartContentBottom())
                canvas.drawText(text, mViewPortManager.chartContentLeft() - offset, positions[2 * i + 1], mYAxisLablePaint);
            if (i > 0)
                canvas.drawLine(mViewPortManager.chartContentLeft(), positions[2 * i + 1], mViewPortManager.chartContentRight(), positions[2 * i + 1], mYAxisPaint);
        }
    }


}
