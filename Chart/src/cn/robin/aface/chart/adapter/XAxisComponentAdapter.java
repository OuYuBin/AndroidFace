package cn.robin.aface.chart.adapter;

import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.model.ChartData;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.model.ChartEntry;
import cn.robin.aface.chart.model.IUserChartData;

import java.util.List;

/**
 * Created by robin on 15-3-27.
 */
public class XAxisComponentAdapter extends BaseAxisComponentAdapter {

    public String[] mEntries;

    public XAxisComponentAdapter() {
    }

    public int getXAxisModulus(Object object) {
        XAxisComponent xAxisComponent = (XAxisComponent) object;
        return xAxisComponent.getModulus();
    }


    public float[] getXAxisOffsets(Object object) {
        XAxisComponent xAxisComponent = (XAxisComponent) object;
        return xAxisComponent.getOffsets();
    }


    public String[] getEntries(Object object) {

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
        int xModulus = xAxisComponent.getModulus();
        int n = 0;
        for (float i = 0; i < xMaxVal; i += xModulus) {
            ++n;
        }
        mEntries = new String[n];
        int index = 0;
        for (int j = 0; j < n; ++j, index += xModulus) {
            mEntries[j] = index + "";
        }
        return mEntries;
    }

    public FontStyle getFontStyle(Object object){
        XAxisComponent xAxisComponent = (XAxisComponent) object;
        return xAxisComponent.getFontStyle();
    }
}
