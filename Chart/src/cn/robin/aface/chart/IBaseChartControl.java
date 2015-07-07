package cn.robin.aface.chart;

import android.graphics.Canvas;
import cn.robin.aface.chart.component.IChartComponent;

/**
 * Created by robin on 15-3-22.
 */
public interface IBaseChartControl {

    void setComponent(IChartComponent chartComponent);

    IChartComponent getComponent();

    void paintComponent(Canvas canvas);

}
