package cn.robin.aface.chart.listeners;

import android.view.View;

/**
 * Created by robin on 15-3-22.
 */
public interface IChartOnTouchListener extends View.OnTouchListener{

    public static final int NONE = 0;
    public static final int DRAG = 1;

    public static final int X_ZOOM = 2;
    public static final int Y_ZOOM = 3;
    public static final int PINCH_ZOOM = 4;
}
