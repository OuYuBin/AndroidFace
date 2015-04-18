package cn.robin.aface.chart.utils;

/**
 * Created by robin on 15-3-23.
 */
public class MathUtil {


    public static float roundToNextSignificant(double number){
        float logNumber= (float) Math.log10(number<0?-number:number);
        float ceilNumber= (float) Math.ceil(logNumber);
        final int pw = 1-(int) ceilNumber;
        float magnitude= (float) Math.pow(10,pw);
        long shifted=Math.round(number*magnitude);
        number=shifted/magnitude;
        return (float) number;
    }
}
