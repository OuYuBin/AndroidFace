package cn.robin.aface.chart.component;

import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.core.runtime.IAdaptable;

/**
 * Created by robin on 15-4-17.
 */
public abstract class AxisComponent extends BaseChartComponent {

    //protected int mOffsetTop;

//    protected int mOffsetLeft;
//
//    protected int mOffsetRight;
//
//    protected int mOffsetBottom;

    protected FontStyle mFontStyle;

    public AxisComponent(IAdaptable adapter) {
        super(adapter);
    }

    public FontStyle getFontStyle() {
        return mFontStyle;
    }

    public void setFontStyle(FontStyle fontStyle) {
        this.mFontStyle = fontStyle;
    }

}