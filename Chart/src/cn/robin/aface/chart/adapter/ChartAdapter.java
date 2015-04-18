package cn.robin.aface.chart.adapter;

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
public class ChartAdapter extends BaseChartComponentAdapter {

    List mEntries = new ArrayList();

    public ChartAdapter(IChartComponent chartComponent) {
        super(chartComponent);
        computeDatas();
    }

    public List getEntries() {
        return mEntries;
    }

    private void computeDatas() {
        LineChartComponent lineChartComponent = (LineChartComponent) mChartComponent;
        ChartDataSet chartDataSet = lineChartComponent.getChartDataSet();
        for (int i = 0; i < chartDataSet.getChartDatas().size(); i++) {
            {
                ChartData chartData = (ChartData) chartDataSet.getChartDatas().get(i);
                int count = chartData.getChartEntries().size();
                float[] values = new float[count * 2];
                for (int j = 0; j < count; j++) {
                    ChartEntry chartEntry = (ChartEntry) chartData.getChartEntries().get(j);
                    int index = chartEntry.getIndex();
                    values[j * 2] = index;
                    Object object = chartEntry.getObject();
                    float value;
                    if (object instanceof IUserChartData) {
                        value = ((IUserChartData) object).toValue();
                    } else if (object instanceof Float) {
                        value = ((Float) object).floatValue();
                    } else {
                        value = Float.valueOf(object.toString());
                    }
                    values[j * 2 + 1] = value;
                }
                mEntries.add(values);
            }
        }

    }


}
