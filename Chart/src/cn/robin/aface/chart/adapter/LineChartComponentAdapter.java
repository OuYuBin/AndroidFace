package cn.robin.aface.chart.adapter;

import cn.robin.aface.chart.component.LineChartComponent;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.component.YAxisComponent;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.model.ChartData;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.model.ChartEntry;
import cn.robin.aface.chart.model.IUserChartData;

/**
 * Created by robin on 15-6-2.
 */
public class LineChartComponentAdapter extends ChartComponentAdapter {

    public LineChartComponentAdapter() {
    }


    private int getXAxisCount(Object object) {
        LineChartComponent lineChartComponent = (LineChartComponent) object;
        ChartDataSet chartDataSet = lineChartComponent.getChartDataSet();
        int xAxisCount = 0;
        for (Object chartData : chartDataSet.getChartDatas().toArray()) {
            int currentAxisCount = ((ChartData) chartData).getChartEntries().size();
            if (currentAxisCount > xAxisCount) {
                xAxisCount = currentAxisCount;
            }
        }
        return xAxisCount;
    }


    public int getDeltaX(Object object) {
        return getXAxisCount(object);
    }


    public float getDeltaY(Object object) {
        float value;
        float yMaxVal = 0f;
        float yMinVal = 0f;
        LineChartComponent lineChartComponent = (LineChartComponent) object;
        ChartDataSet chartDataSet = lineChartComponent.getChartDataSet();
        int xAxisCount = 0;
        for (Object chartData : chartDataSet.getChartDatas().toArray()) {
            int size = ((ChartData) chartData).getChartEntries().size();
            for (int i = 0; i < size; i++) {
                ChartEntry entry = (ChartEntry) ((ChartData) chartData).getChartEntries().get(i);
                Object entryObject = entry.getObject();
                if (entryObject instanceof IUserChartData) {
                    value = ((IUserChartData) entryObject).toValue();
                } else if (entryObject instanceof Float) {
                    value = ((Float) entryObject).floatValue();
                } else {
                    value = Float.valueOf(entryObject.toString());
                }
                if (value > yMaxVal) {
                    yMaxVal = value;
                } else if (value < yMinVal) {
                    yMinVal = value;
                }
            }
        }
        //if(yMinVal>0)
        return Math.abs(yMaxVal - yMinVal);
    }

    public float getYMaxVal(Object object){
        float value;
        float yMaxVal = 0f;
        LineChartComponent lineChartComponent = (LineChartComponent) object;
        ChartDataSet chartDataSet = lineChartComponent.getChartDataSet();
        for (Object chartData : chartDataSet.getChartDatas().toArray()) {
            int size = ((ChartData) chartData).getChartEntries().size();
            for (int i = 0; i < size; i++) {
                ChartEntry entry = (ChartEntry) ((ChartData) chartData).getChartEntries().get(i);
                Object entryObject = entry.getObject();
                if (entryObject instanceof IUserChartData) {
                    value = ((IUserChartData) entryObject).toValue();
                } else if (entryObject instanceof Float) {
                    value = ((Float) entryObject).floatValue();
                } else {
                    value = Float.valueOf(entryObject.toString());
                }
                if (value > yMaxVal) {
                    yMaxVal = value;
                }
            }
        }
        return yMaxVal;
    }


    public float[] getXAxisOffsets(Object object){
        LineChartComponent lineChartComponent = (LineChartComponent) object;
        return lineChartComponent.getXAxisOffsets();
    }

    public float[] getYAxisOffsets(Object object){
        LineChartComponent lineChartComponent = (LineChartComponent) object;
        return lineChartComponent.getYAxisOffsets();
    }

    public FontStyle getXAixFontStyle(Object object){
        LineChartComponent lineChartComponent = (LineChartComponent) object;
        return lineChartComponent.getFontStyle();
    }

    public FontStyle getYAixFontStyle(Object object){
        LineChartComponent lineChartComponent = (LineChartComponent) object;
        return lineChartComponent.getFontStyle();
    }
}
