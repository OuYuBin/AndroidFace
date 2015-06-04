package cn.robin.aface.chart;

import android.graphics.Canvas;
import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.providers.IChartLabelProvider;
import cn.robin.aface.core.runtime.IAdaptable;

import java.util.Map;

/**
 * Created by robin on 15-3-22.
 */
public interface IBaseChartControl {

    public void setComponent(IChartComponent chartComponent);

    public IChartComponent getComponent();

    public void paintComponent(Canvas canvas);

}
