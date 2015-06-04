package cn.robin.aface.chart.adapter;

import cn.robin.aface.chart.component.BaseChartComponent;
import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.component.LineChartComponent;
import cn.robin.aface.chart.model.ChartData;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.model.ChartEntry;
import cn.robin.aface.chart.model.IUserChartData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 15-3-29.
 */
public class ChartComponentAdapter extends BaseChartComponentAdapter {


    public ChartComponentAdapter() {
        super();
    }

    public List getEntries(Object object) {
        List entries = new ArrayList();
        IChartComponent chartComponent = (IChartComponent) object;
        ChartDataSet chartDataSet = chartComponent.getChartDataSet();
        for (int i = 0; i < chartDataSet.getChartDatas().size(); i++) {
            {
                ChartData chartData = (ChartData) chartDataSet.getChartDatas().get(i);
                int count = chartData.getChartEntries().size();
                float[] values = new float[count * 2];
                for (int j = 0; j < count; j++) {
                    ChartEntry chartEntry = (ChartEntry) chartData.getChartEntries().get(j);
                    int index = chartEntry.getIndex();
                    values[j * 2] = index;
                    Object entryObject = chartEntry.getObject();
                    float value;
                    if (entryObject instanceof IUserChartData) {
                        value = ((IUserChartData) entryObject).toValue();
                    } else if (entryObject instanceof Float) {
                        value = ((Float) entryObject).floatValue();
                    } else {
                        value = Float.valueOf(entryObject.toString());
                    }
                    values[j * 2 + 1] = value;
                }
                entries.add(values);
            }
        }
        return entries;
    }



}
