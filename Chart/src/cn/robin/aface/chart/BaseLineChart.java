package cn.robin.aface.chart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import cn.robin.aface.chart.adapter.LineChartComponentAdapter;
import cn.robin.aface.chart.axis.XAxis;
import cn.robin.aface.chart.axis.YAxis;
import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.component.LineChartComponent;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.providers.axis.IChartAxisProvider;
import cn.robin.aface.chart.providers.axis.ILineChartAxisProvider;
import cn.robin.aface.chart.providers.chart.ILineChartContentProvider;
import cn.robin.aface.chart.utils.FontUtil;
import cn.robin.aface.chart.view.IChartView;

import java.util.List;

/**
 * Created by robin on 15-3-21.
 */
public class BaseLineChart extends BaseChart {

    LineChartComponentAdapter mLineChartComponentAdapter;

    ILineChartAxisProvider lineChartAxisProvider;

    ILineChartContentProvider lineChartContentProvider;

    XAxis xAxis;

    YAxis yAxis;

    public BaseLineChart(IChartView parent) {
        super(parent, new LineChartComponent());
        xAxis = new XAxis(parent);
        addChild(xAxis);
        yAxis = new YAxis(parent);
        addChild(yAxis);

    }

    @Override
    public void paintComponent(Canvas canvas) {
        lineChartContentProvider = (ILineChartContentProvider) getChartView().getChartContentProvider();
        lineChartAxisProvider = (ILineChartAxisProvider) getChartView().getChartAxisProvider();
        IChartComponent xAxisComponent = xAxis.getComponent();
        xAxisComponent.setChartDataSet(getChartView().getModel());
        int[] xAxisOffsets = lineChartAxisProvider.getXAxisOffsets(xAxisComponent);
        FontStyle xAxisFontStyle = lineChartAxisProvider.getXAxisFontStyle(xAxisComponent);
        IChartComponent yAxisComponent = yAxis.getComponent();
        yAxisComponent.setChartDataSet(getChartView().getModel());
        int[] yAxisOffsets = lineChartAxisProvider.getYAxisOffsets(yAxisComponent);
        FontStyle yAxisFontStyle = lineChartAxisProvider.getYAxisFontStyle(yAxisComponent);
        float labelHeight = FontUtil.getFontHeight(xAxisFontStyle);
        String longestLabel = FontUtil.getTheLongestLabel(lineChartAxisProvider.getYAxisEntries(yAxisComponent));
        float labelWidth = FontUtil.calcFontWidth(yAxisFontStyle, longestLabel);
        mViewPortManager.restrainViewPort(yAxisOffsets[0] + labelWidth, xAxisOffsets[0], yAxisOffsets[1], xAxisOffsets[1] + labelHeight);
        mTransformer.prepareMatrixOffset(true);

        IChartComponent lineChartComponent = getComponent();
        lineChartComponent.setChartDataSet(getChartView().getModel());
        mTransformer.prepareMatrixValuePx(0, lineChartContentProvider.getDeltaX(lineChartComponent), 0, lineChartContentProvider.getDeltaY(lineChartComponent));

        super.paintComponent(canvas);
        int clipRestoreCount = canvas.save();
        canvas.clipRect(getViewPortManager().getChartContentRect());
        drawData(canvas);
        canvas.restoreToCount(clipRestoreCount);
    }


    private void drawData(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
        List entries = lineChartContentProvider.getEntries(getComponent());
        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);
        mPaint.setSubpixelText(true);
        mPaint.setFilterBitmap(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.rgb(0, 144, 255));
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2.0f);

        Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setAntiAlias(true);
        circlePaint.setSubpixelText(true);
        circlePaint.setFilterBitmap(true);
        circlePaint.setColor(Color.WHITE);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(2.0f);

        for (int i = 0; i < entries.size(); i++) {
            float[] pts = (float[]) entries.get(i);
            mTransformer.pointValuesToPixel(pts);

            if (i > 0) {
                mPaint.setColor(Color.rgb(255, 148, 0));
            }

            for (int j = 0; j < pts.length; j += 2) {

                if (j != 0 && mViewPortManager.isOffContentLeft(pts[j - 1])
                        && mViewPortManager.isOffContentTop(pts[j + 1])
                        && mViewPortManager.isOffContentBottom(pts[j + 1]))
                    continue;
                canvas.drawCircle(pts[j], pts[j + 1], 7.0f, circlePaint);
                canvas.drawCircle(pts[j], pts[j + 1], 5.0f, mPaint);

                if (j + 3 > pts.length) {
                    break;
                }


                canvas.drawLine(pts[j], pts[j + 1], pts[j + 2], pts[j + 3], mPaint);
            }
        }

    }

}
