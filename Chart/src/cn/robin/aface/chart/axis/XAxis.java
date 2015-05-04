package cn.robin.aface.chart.axis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import cn.robin.aface.chart.adapter.XAxisAdapter;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.utils.FontUtil;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;

/**
 * Created by robin on 15-3-27.
 */
public class XAxis extends BaseAxis {

    protected Paint mXAxisLinePaint;

    protected Paint mXAxisLabelPaint;

    protected XAxisAdapter xAxisAdapter;

    ViewPortManager viewPortManager;

    public void paintComponent(Canvas canvas) {
        xAxisAdapter = (XAxisAdapter) getChartComponentAdapter(XAxisAdapter.class);
        XAxisComponent xAxisComponent = (XAxisComponent) mChartComponent;
        viewPortManager = xAxisComponent.getViewPortManager();
        mXAxisLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mXAxisLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mXAxisLinePaint.setColor(Color.BLACK);

        canvas.drawLine(viewPortManager.chartContentLeft(), viewPortManager.chartContentBottom(), viewPortManager.chartContentRight(), viewPortManager.chartContentBottom(), mXAxisLinePaint);
        drawAxisLabels(canvas);

    }

    public void drawAxisLabels(Canvas canvas) {
        XAxisComponent xAxisComponent = (XAxisComponent) mChartComponent;
        String[] labels = xAxisAdapter.getEntries();
        float modulus = xAxisComponent.getModulus();

        //--坐标生成
        float[] positions = new float[labels.length * 2];
        float value = 0;
        for (int i = 0; i < positions.length; i += 2, value += modulus) {
            positions[i] = value;
        }
        Transformer transformer = xAxisComponent.getTransformer();
        transformer.pointValuesToPixel(positions);
        //viewPortManager.
        drawAxisLabels(canvas, positions, labels);
    }

    private void drawAxisLabels(Canvas canvas, float[] positions, String[] labels) {
        XAxisComponent xAxisComponent = (XAxisComponent) mChartComponent;
        mXAxisLabelPaint = new Paint();
        mXAxisLabelPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mXAxisLabelPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mXAxisLabelPaint.setTypeface(xAxisComponent.getFontStyle().getTypeface());
        mXAxisLabelPaint.setTextSize(xAxisComponent.getFontStyle().getFontSize());
        mXAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        mXAxisLabelPaint.setColor(Color.WHITE);
        Paint mXAxisGridLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mXAxisGridLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mXAxisGridLinePaint.setColor(Color.rgb(50,50,50));

        int offset = FontUtil.calcFontHeight(xAxisComponent.getFontStyle());
        for (int i = 0; i < labels.length; i++) {
            float x = positions[2 * i];
            if (x <= viewPortManager.chartContentRight() && x >= viewPortManager.chartContentLeft()) {
                String label = labels[i];
                canvas.drawText(label, positions[2 * i], positions[2 * i + 1]+offset+5, mXAxisLabelPaint);
                canvas.drawLine(positions[2 * i],positions[2 * i + 1],positions[2 * i],viewPortManager.chartContentTop(),mXAxisGridLinePaint);
            }
        }
    }
}
