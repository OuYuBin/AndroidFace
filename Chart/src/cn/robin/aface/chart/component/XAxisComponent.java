package cn.robin.aface.chart.component;

import android.graphics.Color;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.core.annotations.TypeArrayAnnotation;
//
// import cn.robin.aface.core.annotations.TypeArrayAnnotation;

import java.util.List;

/**
 * Created by robin on 15-3-27.
 */
public class XAxisComponent extends AxisComponent {


    //--上边距
    @TypeArrayAnnotation(name = "xAxisTopOffset", desc = "XAxisTopOffset", type = "Integer")
    protected int mOffsetTop;

    //--下边距
    @TypeArrayAnnotation(name = "xAxisBottomOffset", desc = "XAxisBottomOffset", type = "Integer")
    protected int mOffsetBottom;

    //--间隔系数
    @TypeArrayAnnotation(name = "xAxisModulus", desc = "XAxisModulus", type = "Integer")
    private int mModulus;

    //--字体大小
    @TypeArrayAnnotation(name = "xAxisFontSize", desc = "XAxisFontSize", type = "Integer")
    private int mFontSize;


    private int mColor;

    private int mGridColor;

    public XAxisComponent() {
    }

    public int getModulus() {
        return mModulus;
    }

    public FontStyle getFontStyle() {
        return new FontStyle(mFontSize);
    }

    public int getOffsetBottom() {
        return mOffsetBottom;
    }

    public int getOffsetTop() {
        return mOffsetTop;
    }

    public int getColor() {
        return Color.WHITE;
    }

    public int getGridColor() {
        return Color.WHITE;
    }

}
