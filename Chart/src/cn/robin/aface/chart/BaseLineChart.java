package cn.robin.aface.chart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import cn.robin.aface.chart.adapter.ChartAdapter;
import cn.robin.aface.chart.axis.XAxis;
import cn.robin.aface.chart.axis.YAxis;
import cn.robin.aface.chart.component.LineChartComponent;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.component.YAxisComponent;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.view.IBaseChartView;
import cn.robin.aface.core.runtime.IAdaptable;

import java.util.List;

/**
 * Created by robin on 15-3-21.
 */
public class BaseLineChart extends BaseChart {

    private YAxis mYAxis;

    private XAxis mXAxis;

    public BaseLineChart() {
        mYAxis = new YAxis();
        mXAxis = new XAxis();
    }

    //--图表元件数据填充
    public void setContent(IAdaptable adapter) {
        LineChartComponent lineChartComponent = new LineChartComponent(adapter);
        this.setComponent(lineChartComponent);

        XAxisComponent xAxisComponent = new XAxisComponent(adapter);
        mXAxis.setComponent(xAxisComponent);

        YAxisComponent yAxisComponent = new YAxisComponent(adapter);
        mYAxis.setComponent(yAxisComponent);
    }


    @Override
    public void paintComponent(Canvas canvas) {
        drawXAxis(canvas);
        drawYAxis(canvas);
        drawData(canvas);
    }

    public void drawXAxis(Canvas canvas) {
        mXAxis.paintComponent(canvas);
    }

    public void drawYAxis(Canvas canvas) {
        mYAxis.paintComponent(canvas);
    }

    private void drawData(Canvas canvas) {
        ChartAdapter chartAdapter = (ChartAdapter) mChartComponent.getAdapter(ChartAdapter.class);
        List entries = chartAdapter.getEntries();

        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.BLUE);

        for (int i = 0; i < entries.size(); i++) {
            float[] pts = (float[]) entries.get(i);
            Transformer transformer = mChartComponent.getTransformer();
            transformer.pointValuesToPixel(pts);
            for (int j = 0; j < pts.length; j += 2) {
                if (j + 3 > pts.length)
                    break;

                canvas.drawLine(pts[j], pts[j + 1], pts[j + 2], pts[j + 3], mPaint);
            }
        }
    }

    public YAxis getYAxis() {
        return mYAxis;
    }

    public XAxis getXAxis() {
        return mXAxis;
    }
}
