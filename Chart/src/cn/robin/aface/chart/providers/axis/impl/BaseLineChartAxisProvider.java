package cn.robin.aface.chart.providers.axis.impl;


import android.graphics.Color;
import cn.robin.aface.chart.adapter.ChartComponentAdapterFactory;
import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.component.YAxisComponent;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.model.ChartData;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.model.ChartEntry;
import cn.robin.aface.chart.model.IUserChartData;
import cn.robin.aface.chart.providers.axis.ILineChartAxisProvider;
import cn.robin.aface.chart.utils.MathUtil;

/**
 * Created by robin on 15-4-17.
 * 自定义图表轴提供器基类
 */
public class BaseLineChartAxisProvider implements ILineChartAxisProvider {

    @Override
    public float[] getYAxisEntries(Object object) {
        IChartComponent chartComponent = (IChartComponent) object;
        ChartDataSet chartDataSet = chartComponent.getChartDataSet();
        float tmpValue;
        float yMaxVal = 0f;
        float yMinVal = 0f;
        for (Object chartData : chartDataSet.getChartDatas().toArray()) {
            int size = ((ChartData) chartData).getChartEntries().size();
            for (int i = 0; i < size; i++) {
                ChartEntry entry = (ChartEntry) ((ChartData) chartData).getChartEntries().get(i);
                Object entryObject = entry.getObject();
                if (entryObject instanceof IUserChartData) {
                    tmpValue = ((IUserChartData) entryObject).toValue();
                } else if (entryObject instanceof Float) {
                    tmpValue = ((Float) entryObject).floatValue();
                } else {
                    tmpValue = Float.valueOf(entryObject.toString());
                }
                if (tmpValue > yMaxVal) {
                    yMaxVal = tmpValue;
                } else if (tmpValue < yMinVal) {
                    yMinVal = tmpValue;
                }
            }
        }

        int count = ((YAxisComponent) chartComponent).getLabelCount();
        double range = Math.abs(yMaxVal - yMinVal);
        double rawInterval = range / count;
        double interval = MathUtil.roundToNextSignificant(rawInterval);
        double intervalMagnitude = Math.pow(10, Math.log10(interval));
        int intervalSigDigit = (int) (interval / intervalMagnitude);

        double first = Math.ceil(yMinVal / interval) * interval;
        double last = Math.floor(yMaxVal / interval) * interval;

        double value;
        int n = 0;
        int i;
        for (value = first; value <= last; value += interval) {
            ++n;
        }
        //setEntries(new float[n]);
        float[] entries = new float[n];

        for (i = 0, value = first; i < n; value += interval, ++i) {
            entries[i] = (float) value;
        }
        return entries;
    }

    @Override
    public int getXAxisModulus(Object object) {
        return 5;
    }

    @Override
    public String[] getXAxisEntries(Object object) {
        ChartData referenceObject = null;
        XAxisComponent xAxisComponent = (XAxisComponent) object;
        ChartDataSet chartDataSet = xAxisComponent.getChartDataSet();
        int xAxisCount = 0;
        for (Object chartData : chartDataSet.getChartDatas().toArray()) {
            int currentAxisCount = ((ChartData) chartData).getChartEntries().size();
            if (currentAxisCount > xAxisCount) {
                xAxisCount = currentAxisCount;
                referenceObject = (ChartData) chartData;
            }
        }
        int xMaxVal = referenceObject.getChartEntries().size();
        int xModulus = getXAxisModulus(object);
        int n = 0;
        for (float i = 0; i < xMaxVal; i += xModulus) {
            ++n;
        }
        String[] entries = new String[n];
        int index = 0;
        for (int j = 0; j < n; ++j, index += xModulus) {
            entries[j] = index + "";
        }
        return entries;
    }

    @Override
    public int[] getXAxisOffsets(Object object) {
        int[] offsets = new int[]{
                0, AXIS_OFFSET_BOTTOM
        };
        return offsets;
    }

    @Override
    public int[] getYAxisOffsets(Object object) {
        int[] offsets = new int[]{
                0, AXIS_OFFSET_BOTTOM
        };
        return offsets;
    }


    public FontStyle getXAxisFontStyle(Object object) {
        FontStyle fontStyle = new FontStyle(18);
        return fontStyle;
    }

    public FontStyle getYAxisFontStyle(Object object) {
        FontStyle fontStyle = new FontStyle(18);
        return fontStyle;
    }

    @Override
    public int getXAxisColor(Object object) {
        return Color.BLUE;
    }

    @Override
    public int getXGridColor(Object object) {
        return Color.WHITE;
    }

    @Override
    public int getYAxisColor(Object object) {
        return Color.BLUE;
    }

    @Override
    public int getYGridColor(Object object) {
        return Color.WHITE;
    }

}
