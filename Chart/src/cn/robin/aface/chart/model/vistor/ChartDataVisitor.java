package cn.robin.aface.chart.model.vistor;

import cn.robin.aface.chart.model.*;
import cn.robin.aface.chart.view.IChartView;

/**
 * Created by robin on 15-3-21.
 * 图表对象结构访问器,分离计算统计算法与模型对象
 * 同时该类还作为数据数据主体直接将计算数值结果直接通知图表控件,进行属性变更,使源数据模型更为简要
 */
public class ChartDataVisitor implements IChartDataVisitor {

    private IChartView mChartView;

    private ChartDataSet mChartDataSet;

    private float mYMaxVal = 0f;

    private float mYMinVal = 0f;

    public ChartDataVisitor(IChartView chartView) {
        this.mChartView = chartView;
    }

    @Override
    public void visit(ChartDataSet chartDataSet) {
        this.mChartDataSet = chartDataSet;
        for (int i = 0; i < mChartDataSet.getChartDatas().size(); i++) {
            ChartData chartData = (ChartData) mChartDataSet.getChartDatas().get(i);
            chartData.accept(this);
        }
        ChartModelBuildFactory.parserModeToChartElement(this);
    }


    @Override
    public void visit(ChartData chartData) {
        calculateYAixMaxMin(chartData);
    }

    private void calculateYAixMaxMin(ChartData chartData) {
        float value;
        int size = chartData.getChartEntries().size();
        for (int i = 0; i < size; i++) {
            ChartEntry entry = (ChartEntry) chartData.getChartEntries().get(i);
            Object object = entry.getObject();
            if (object instanceof IUserChartData) {
                value = ((IUserChartData) object).toValue();
            } else if (object instanceof Float) {
                value = ((Float) object).floatValue();
            } else {
                value = Float.valueOf(object.toString());
            }
            if (value > mYMaxVal) {
                mYMaxVal = value;
            } else if (value < mYMinVal) {
                mYMinVal = value;
            }
        }

    }

    public IChartView getChartView() {
        return mChartView;
    }

    public float getYMaxVal() {
        return mYMaxVal;
    }

    public float getYMinVal() {
        return mYMinVal;
    }

    public ChartDataSet getChartDataSet() {
        return mChartDataSet;
    }
}
