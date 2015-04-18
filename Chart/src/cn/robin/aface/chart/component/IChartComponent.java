package cn.robin.aface.chart.component;

import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;
import cn.robin.aface.core.runtime.IAdaptable;

/**
 * Created by robin on 15-3-21.
 */
public interface IChartComponent extends IAdaptable{

    public ViewPortManager getViewPortManager();

    public Transformer getTransformer();

//    public int getOffsetLeft();
//
//    public int getOffsetRight();
//
//    public int getOffsetTop();
//
//    public int getOffsetBottom();

}
