package cn.robin.aface.chart.component;

import android.graphics.Color;
import cn.robin.aface.chart.adapter.YAxisComponentAdapter;
import cn.robin.aface.chart.font.FontStyle;
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

    public YAxisComponent() {
        super();
    }

    public int getLabelCount() {
        return 5;
    }

    public int getColor(){
        return Color.WHITE;
    }

    public int getGridColor(){
        return Color.rgb(50,50,50);
    }

    public float[] getOffsets() {
        float[] offsets = new float[]{
                10f, 20f
        };
        return offsets;
    }

    public FontStyle getFontStyle(){
        return new FontStyle(18);
    }

}
