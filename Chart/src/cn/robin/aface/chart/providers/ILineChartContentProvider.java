package cn.robin.aface.chart.providers;

import java.util.List;
import java.util.Objects;

/**
 * Created by robin on 15-3-28.
 */
public interface ILineChartContentProvider extends IChartContentProvider{

    //public int getXAxisCount(Object[] objects);

    //public List<String> getXVals(Object[] objects);

    public int getXAxisModulus(Object objects);

    //public int getYAxisCount(Object[] objects);

    public float[] getXAxisOffsets(Object object);


    public float[] getYAxisOffsets(Object object);
}
