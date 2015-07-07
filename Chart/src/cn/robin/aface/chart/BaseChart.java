package cn.robin.aface.chart;

import android.graphics.Canvas;
import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.providers.axis.IChartAxisProvider;
import cn.robin.aface.chart.providers.chart.IChartContentProvider;
import cn.robin.aface.chart.view.IChartView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 15-3-21.
 */
public abstract class BaseChart extends BaseChartControl {


    private List<BaseChartControl> children = new ArrayList<BaseChartControl>();


    public BaseChart(IChartView chartView, IChartComponent chartComponent) {
        super(chartView, chartComponent);
    }


    public void addChild(BaseChartControl element) {
        children.add(element);
    }

    public List<BaseChartControl> getChildren() {
        return children;
    }

    public void paintComponent(Canvas canvas) {
        for (int i = 0; i < getChildren().size(); i++) {
            getChildren().get(i).paintComponent(canvas);
        }
    }
}
