package cn.robin.aface.chart.providers.axis.impl;


import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.providers.axis.ILineChartAxisProvider;

/**
 * Created by robin on 15-4-17.
 *自定义图表轴提供器基类
 */
public class BaseLineChartAxisProvider implements ILineChartAxisProvider {

    @Override
    public int getXAxisModulus(Object object) {
        return 5;
    }

    @Override
    public String[] getXAxisEntries(Object object) {
        return new String[0];
    }


    //@Override
    public String[] getEntries(Object object) {
        return new String[0];
    }

    @Override
    public float[] getXAxisOffsets(Object object) {
        return new float[0];
    }

    @Override
    public float[] getYAxisOffsets(Object object) {
        return new float[0];
    }

    @Override
    public FontStyle getXAixFontStyle(Object object) {
        return new FontStyle(18);
    }

    @Override
    public FontStyle getYAixFontStyle(Object object) {
        return new FontStyle(18);
    }

    //    public float[] getXAxisOffsets(Object object) {
//        float[] offsets = new float[] {
//                0f,AXIS_OFFSET_BOTTOM
//        } ;
//        return offsets;
//    }

//    public float[] getYAxisOffsets(Object object) {
//        float[] offsets = new float[]{
//                0f,AXIS_OFFSET_RIGHT
//        } ;
//        return offsets;
//    }
//
//
//    public FontStyle getFontStyle(){
//        FontStyle fontStyle=new FontStyle(15);
//        return fontStyle;
//    }
}
