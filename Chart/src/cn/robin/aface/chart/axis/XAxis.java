package cn.robin.aface.chart.axis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import cn.robin.aface.chart.adapter.XAxisAdapter;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.utils.FontUtil;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;

/**
 * Created by robin on 15-3-27.
 */
public class XAxis extends BaseAxis {

    protected Paint mXAxisPaint;

    protected XAxisAdapter xAxisAdapter;

    public void paintComponent(Canvas canvas) {
        xAxisAdapter = (XAxisAdapter) getChartComponentAdapter(XAxisAdapter.class);
        XAxisComponent xAxisComponent = (XAxisComponent) mChartComponent;
        ViewPortManager viewPortManager = xAxisComponent.getViewPortManager();

        mXAxisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mXAxisPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mXAxisPaint.setColor(Color.BLACK);
        mXAxisPaint.setTypeface(xAxisComponent.getFontStyle().getTypeface());
        mXAxisPaint.setTextSize(xAxisComponent.getFontStyle().getFontSize());


        canvas.drawLine(viewPortManager.chartContentLeft(), viewPortManager.chartContentBottom() , viewPortManager.chartContentRight() , viewPortManager.chartContentBottom() , mXAxisPaint);
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
        FontStyle fontStyle=xAxisComponent.getFontStyle();
        Paint.FontMetrics fontMetrics=mXAxisPaint.getFontMetrics();
        int fontHeight= FontUtil.getFontHeight(fontStyle);
        ViewPortManager viewPortManager = xAxisComponent.getViewPortManager();
//        canvas.drawLine(viewPortManager.chartContentLeft() +xAxisComponent.getOffsetLeft(), viewPortManager.chartContentBottom() -xAxisAdapter.getAxisOffset()-fontHeight, viewPortManager.chartContentRight() - xAxisComponent.getOffsetRight(), viewPortManager.chartContentBottom() -xAxisAdapter.getAxisOffset()- fontHeight, mXAxisPaint);
        int baseLine=xAxisAdapter.getAxisOffset()-fontHeight;
        int offset = xAxisAdapter.getAxisOffset()-fontHeight/2;
        drawAxisLabels(canvas, offset, positions, labels);
    }

    private void drawAxisLabels(Canvas canvas, int offset, float[] positions, String[] labels) {
        //XAxisComponent xAxisComponent = (XAxisComponent) mChartComponent;

        for (int i = 0; i < labels.length; i++) {
            String label = labels[i];
            canvas.drawText(label, positions[2 * i], positions[2 * i + 1] - offset, mXAxisPaint);
        }
    }
}
