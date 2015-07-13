package cn.robin.aface.chart.adapter;

import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.component.YAxisComponent;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.model.ChartData;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.model.ChartEntry;
import cn.robin.aface.chart.model.IUserChartData;
import cn.robin.aface.chart.utils.MathUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by robin on 15-3-23.
 * Y轴适配器,根据提供提供对模型进行属性填充后通过该适配器进行对应适配供给图形使用
 */
public class YAxisComponentAdapter extends BaseAxisComponentAdapter {


    public float[] mEntries;

    public YAxisComponentAdapter() {
        super();
    }

    public float[] getYAxisOffsets(Object object) {
        YAxisComponent yAxisComponent = (YAxisComponent) object;
        return yAxisComponent.getOffsets();
    }

    //--等分切割轴线
    public float[] getEntries(Object object) {
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
        setEntries(new float[n]);

        for (i = 0, value = first; i < n; value += interval, ++i) {
            mEntries[i] = (float) value;
        }
        return mEntries;
    }

    private void setEntries(float[] entries) {
        this.mEntries = entries;
    }


    public FontStyle getFontStyle(Object object) {
        YAxisComponent yAxisComponent = (YAxisComponent) object;
        return yAxisComponent.getFontStyle();
    }

    public int getColor(Object object){
        YAxisComponent yAxisComponent = (YAxisComponent) object;
        return yAxisComponent.getColor();
    }

    public int getGridColor(Object object){
        YAxisComponent yAxisComponent = (YAxisComponent) object;
        return yAxisComponent.getGridColor();
    }


//    public float[] getEntries() {
//        float max=yAxisComponent.getYMaxVal();
//        float min=yAxisComponent.getYMinVal();
//        int count=yAxisComponent.getLabelCount();
//        double range=Math.abs(max - min);
//        double rawInterval=range/count;
//        double interval= MathUtil.roundToNextSignificant(rawInterval);
//        double intervalMagnitude=Math.pow(10,Math.log10(interval));
//        int intervalSigDigit = (int) (interval / intervalMagnitude);
//
//        double first=Math.ceil(min/interval)*interval;
//        double last=Math.floor(max/interval)*interval;
//
//        double value;
//        int n=0;
//        int i;
//        for(value=first;value<=last;value+=interval){
//            ++n;
//        }
//        setEntries(new float[n]);
//
//        for(i=0,value=first;i<n;value+=interval,++i){
//            getEntries()[i]= (float) value;
//        }
//    }

    //--适配图形最大最小点位
//    public void computeAxis() {
//        YAxisComponent yAxisComponent= (YAxisComponent)mChartComponent;
//        yAxisComponent.getFontStyle();
//        computeValueAxis(yAxisComponent);
//    }


}
