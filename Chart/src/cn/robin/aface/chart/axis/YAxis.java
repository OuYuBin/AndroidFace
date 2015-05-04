package cn.robin.aface.chart.axis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import cn.robin.aface.chart.adapter.YAxisAdapter;
import cn.robin.aface.chart.component.YAxisComponent;
import cn.robin.aface.chart.utils.FontUtil;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;

/**
 * Created by robin on 15-3-21.
 * <p/>
 * Y轴控件的显示对象
 */
public class YAxis extends BaseAxis {


    private Paint mYAxisPaint;

    private Paint mYAxisLablePaint;

    private YAxisAdapter yAxisAdapter;

    private ViewPortManager viewPortManager;


    public void paintComponent(Canvas canvas) {
        mYAxisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mYAxisPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mYAxisPaint.setColor(Color.rgb(50,50,50));
        yAxisAdapter = (YAxisAdapter) getChartComponentAdapter(YAxisAdapter.class);
        viewPortManager = mChartComponent.getViewPortManager();
        canvas.drawLine(viewPortManager.chartContentLeft(), viewPortManager.chartContentTop(), viewPortManager.chartContentLeft(), viewPortManager.chartContentBottom(), mYAxisPaint);
        drawAxisLabels(canvas);

    }


    public void drawAxisLabels(Canvas canvas) {

        float[] labels = yAxisAdapter.getEntries();
        //--根据刻度数值折算像素点
        int count = labels.length;
        float[] positions = new float[count * 2];
        for (int i = 0; i < positions.length; i += 2) {
            positions[i + 1] = labels[i / 2];
        }
        Transformer transformer = mChartComponent.getTransformer();
        transformer.pointValuesToPixel(positions);

        drawAxisLabels(canvas, positions);

    }

    private void drawAxisLabels(Canvas canvas, float[] positions) {

        YAxisComponent yAxisComponent = (YAxisComponent) mChartComponent;
        mYAxisLablePaint = new Paint();
        mYAxisLablePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mYAxisLablePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mYAxisLablePaint.setTypeface(yAxisComponent.getFontStyle().getTypeface());
        mYAxisLablePaint.setTextSize(yAxisComponent.getFontStyle().getFontSize());
        mYAxisLablePaint.setColor(Color.WHITE);
        mYAxisLablePaint.setTextAlign(Paint.Align.CENTER);
        float offset = FontUtil.calcFontWidth(yAxisComponent.getFontStyle(), yAxisAdapter.getLongestLabel());
        for (int i = 0; i < yAxisAdapter.getEntries().length; i++) {
            String text = String.valueOf(yAxisAdapter.getEntries()[i]);
            canvas.drawText(text, viewPortManager.chartContentLeft() - offset - 5, positions[2 * i + 1], mYAxisLablePaint);
            if(i>0)
            canvas.drawLine(viewPortManager.chartContentLeft(), positions[2 * i + 1], viewPortManager.chartContentRight(), positions[2 * i + 1], mYAxisPaint);
        }
    }


}
