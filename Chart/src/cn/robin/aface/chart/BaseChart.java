package cn.robin.aface.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.model.ChartModelManager;
import cn.robin.aface.chart.providers.IChartContentProvider;
import cn.robin.aface.chart.providers.IChartLabelProvider;

/**
 * Created by robin on 15-3-21.
 */
public abstract class BaseChart implements IBaseChartElement {


    protected IChartComponent mChartComponent;


    public BaseChart() {
    }


    @Override
    public void setComponent(IChartComponent chartComponent) {
        this.mChartComponent = chartComponent;
    }

    @Override
    public IChartComponent getComponent() {
        return mChartComponent;
    }


}
