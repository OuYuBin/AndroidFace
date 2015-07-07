package cn.robin.aface.chart.axis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import cn.robin.aface.chart.adapter.XAxisComponentAdapter;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.utils.FontUtil;
import cn.robin.aface.chart.view.IChartView;

/**
 * Created by robin on 15-3-27.
 */
public class XAxis extends BaseAxis {

    protected Paint mXAxisLinePaint;

    protected Paint mXAxisLabelPaint;

    protected XAxisComponentAdapter mXAxisComponentAdapter;


    public XAxis(IChartView parent) {
        super(parent, new XAxisComponent());
    }

    public void paintComponent(Canvas canvas) {
        super.paintComponent(canvas);
        mXAxisLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mXAxisLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mXAxisLinePaint.setColor(Color.rgb(50, 50, 50));
        canvas.drawLine(mViewPortManager.chartContentLeft(), mViewPortManager.chartContentBottom(), mViewPortManager.chartContentRight(), mViewPortManager.chartContentBottom(), mXAxisLinePaint);
        drawAxisLabels(canvas);

    }

    public void drawAxisLabels(Canvas canvas) {
        float modulus=chartAxisProvider.getXAxisModulus(getComponent());
//        mXAxisComponentAdapter = (XAxisComponentAdapter) mChartComponentAdapterFactory.adapter(getComponent(), XAxisComponentAdapter.class);
//        String[] labels = mXAxisComponentAdapter.getEntries(getComponent());
        String[] labels=chartAxisProvider.getXAxisEntries(getComponent());

        //float modulus = mXAxisComponentAdapter.getXAxisModulus(getComponent());

        //--坐标生成
        float[] positions = new float[labels.length * 2];
        float value = 0;
        for (int i = 0; i < positions.length; i += 2, value += modulus) {
            positions[i] = value;
        }
        mTransformer.pointValuesToPixel(positions);
        drawAxisLabels(canvas, positions, labels);
    }

    private void drawAxisLabels(Canvas canvas, float[] positions, String[] labels) {
        mXAxisLabelPaint = new Paint();
        mXAxisLabelPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mXAxisLabelPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mXAxisLabelPaint.setTextSize(15);
        //mXAxisLabelPaint.setTypeface(mXAxisComponentAdapter.getFontStyle(getComponent()).getTypeface());
        mXAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        mXAxisLabelPaint.setColor(Color.WHITE);
        Paint mXAxisGridLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mXAxisGridLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mXAxisGridLinePaint.setColor(Color.rgb(50, 50, 50));

        int offset=10;
        //int offset = FontUtil.calcFontHeight(mXAxisComponentAdapter.getFontStyle(getComponent()));
        for (int i = 0; i < labels.length; i++) {
            float x = positions[2 * i];
            if (x <= mViewPortManager.chartContentRight() && x >= mViewPortManager.chartContentLeft()) {
                String label = labels[i];
                canvas.drawText(label, positions[2 * i], mViewPortManager.chartContentBottom() + offset + 5, mXAxisLabelPaint);
                canvas.drawLine(positions[2 * i], mViewPortManager.chartContentBottom(), positions[2 * i], mViewPortManager.chartContentTop(), mXAxisGridLinePaint);
            }
        }
    }
}
