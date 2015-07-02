package cn.robin.aface.chart.providers;

/**
 * Created by robin on 15-4-17.
 *自定义图表轴提供器
 */
public class BaseLineChartAxisProvider implements ILineChartAxisProvider {


    public int getXAxisModulus(Object object) {
        return 5;
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
