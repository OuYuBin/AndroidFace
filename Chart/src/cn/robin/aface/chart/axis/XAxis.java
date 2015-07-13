package cn.robin.aface.chart.axis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import cn.robin.aface.chart.adapter.XAxisComponentAdapter;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.font.FontStyle;
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
        mXAxisLinePaint.setColor(chartAxisProvider.getXAxisColor(getComponent()));
        canvas.drawLine(mViewPortManager.chartContentLeft(), mViewPortManager.chartContentBottom(), mViewPortManager.chartContentRight(), mViewPortManager.chartContentBottom(), mXAxisLinePaint);
        drawAxisLabels(canvas);

    }

    public void drawAxisLabels(Canvas canvas) {
        //--间隔系数
        float modulus=chartAxisProvider.getXAxisModulus(getComponent());
        String[] labels=chartAxisProvider.getXAxisEntries(getComponent());
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
        FontStyle fontStyle=chartAxisProvider.getXAxisFontStyle(getComponent());
        mXAxisLabelPaint.setTextSize(fontStyle.getFontSize());
        mXAxisLabelPaint.setTypeface(fontStyle.getTypeface());
        mXAxisLabelPaint.setTextAlign(fontStyle.getTextAlign());
        mXAxisLabelPaint.setColor(fontStyle.getFontColor());
        Paint mXAxisGridLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mXAxisGridLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mXAxisGridLinePaint.setColor(chartAxisProvider.getXGridColor(getComponent()));

        int offset = FontUtil.calcFontHeight(fontStyle);
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
