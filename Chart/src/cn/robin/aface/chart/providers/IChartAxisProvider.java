package cn.robin.aface.chart.providers;

/**
 * Created by robin on 15-5-30.
 */
public interface IChartAxisProvider {

    //--x坐标间距系数
    public int getXAxisModulus(Object object);

    //--X轴边距
    //public float[] getXAxisOffsets(Object object);

    //--Y轴边距
    //public float[] getYAxisOffsets(Object object);
}
