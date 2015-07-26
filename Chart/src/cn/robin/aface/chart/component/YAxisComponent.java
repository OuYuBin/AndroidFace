package cn.robin.aface.chart.component;

import android.graphics.Color;
import cn.robin.aface.chart.adapter.YAxisComponentAdapter;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.core.annotations.TypeArrayAnnotation;
import cn.robin.aface.core.runtime.IAdaptable;

/**
 * Created by robin on 15-3-25.
 * <p/>
 * Y轴模型对象
 */
public class YAxisComponent extends AxisComponent {

    //@TypeArrayAnnotation(name = "labelCount", desc = "LabelCount", type = "Integer")
    public int mLabelCount;

    private int mColor;

    private int mGridColor;

    //--上边距
    @TypeArrayAnnotation(name = "yAxisLeftOffset", desc = "YAxisLeftOffset", type = "Integer")
    protected int mOffsetLeft;

    //--下边距
    @TypeArrayAnnotation(name = "yAxisRightOffset", desc = "YAxisRightOffset", type = "Integer")
    protected int mOffsetRight;

    //--字体大小
    @TypeArrayAnnotation(name = "yAxisFontSize", desc = "YAxisFontSize", type = "Integer")
    private int mFontSize;

    public YAxisComponent() {
        super();
    }

    public FontStyle getFontStyle() {
        return new FontStyle(mFontSize);
    }

    public int getOffsetLeft() {
        return mOffsetLeft;
    }

    public int getOffsetRight() {
        return mOffsetRight;
    }

    public int getLabelCount() {
        return 5;
    }


    public int getColor() {
        return Color.WHITE;
    }

    public int getGridColor() {
        return Color.WHITE;
    }

}
