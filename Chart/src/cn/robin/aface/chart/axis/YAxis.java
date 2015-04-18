package cn.robin.aface.chart.axis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import cn.robin.aface.chart.adapter.YAxisAdapter;
import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.component.YAxisComponent;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;

/**
 * Created by robin on 15-3-21.
 * <p/>
 * Y轴控件的显示对象
 */
public class YAxis extends BaseAxis {


    private Paint mYAxisPaint;

    private YAxisAdapter yAxisAdapter;


    public void paintComponent(Canvas canvas) {
        mYAxisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mYAxisPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mYAxisPaint.setColor(Color.GREEN);

        yAxisAdapter = (YAxisAdapter) getChartComponentAdapter(YAxisAdapter.class);
        ViewPortManager viewPortManager = mChartComponent.getViewPortManager();
        YAxisComponent yAxisComponent = (YAxisComponent) mChartComponent;

        //--偏移量带入进行绘制
        int offset=0;

        canvas.drawLine(viewPortManager.chartContentLeft()+yAxisComponent.getOffsetLeft(), viewPortManager.chartContentTop()-yAxisComponent.getOffsetTop(), viewPortManager.chartContentLeft()+yAxisComponent.getOffsetLeft(), viewPortManager.chartContentBottom()-yAxisComponent.getOffsetBottom(), mYAxisPaint);
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
        int offset=0;
        drawAxisLabels(canvas, offset*2, positions);

    }

    private void drawAxisLabels(Canvas canvas, int offset, float[] positions) {
        for (int i = 0; i < yAxisAdapter.getEntries().length; i++) {
            String text = String.valueOf(yAxisAdapter.getEntries()[i]);
            canvas.drawText(text, offset, positions[2 * i + 1], mYAxisPaint);
        }
    }


}
