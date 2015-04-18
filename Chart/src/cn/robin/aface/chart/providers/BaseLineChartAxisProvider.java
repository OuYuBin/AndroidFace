package cn.robin.aface.chart.providers;

import cn.robin.aface.chart.font.FontStyle;

/**
 * Created by robin on 15-4-17.
 *
 */
public class BaseLineChartAxisProvider implements ILineChartAxisProvider {


    @Override
    public float[] getXAxisOffsets() {
        float[] offsets = new float[] {
                0,AXIS_OFFSET_BOTTOM
        } ;
        return offsets;
    }

    @Override
    public float[] getYAxisOffsets() {
        float[] offsets = new float[]{
                AXIS_OFFSET_LEFT,0
        } ;
        return offsets;
    }


    public FontStyle getFontStyle(){
        FontStyle fontStyle=new FontStyle(20);
        return fontStyle;
    }
}
