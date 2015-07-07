package cn.robin.aface.chart.providers.chart;

import cn.robin.aface.chart.providers.chart.IChartContentProvider;

/**
 * Created by robin on 15-3-28.
 * 线性图标内容提供器
 */
public interface ILineChartContentProvider extends IChartContentProvider {

    //public int getXAxisCount(Object[] objects);

    //public List<String> getXVals(Object[] objects);

    public int getXAxisModulus(Object objects);

    //public int getYAxisCount(Object[] objects);

    //public float[] getXAxisOffsets(Object object);


   // public float[] getYAxisOffsets(Object object);

    int getDeltaX(Object object);

    float getDeltaY(Object object);
}
