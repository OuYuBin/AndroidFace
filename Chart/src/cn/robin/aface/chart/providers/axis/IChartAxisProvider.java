package cn.robin.aface.chart.providers.axis;

import android.graphics.Color;
import cn.robin.aface.chart.component.LineChartComponent;
import cn.robin.aface.chart.font.FontStyle;

/**
 * Created by robin on 15-5-30.
 */
public interface IChartAxisProvider {

    //--x坐标轴间距系数
    int getXAxisModulus(Object object);

    //--x坐标显示信息
    String[] getXAxisEntries(Object object);

    float[] getYAxisEntries(Object object);;

    //--x轴边距偏移量
    float[] getXAxisOffsets(Object object);

    //--Y轴边距
    float[] getYAxisOffsets(Object object);

    //--x轴字体显示样式
    FontStyle getXAxisFontStyle(Object object);

    //--y轴字体显示样式
    FontStyle getYAxisFontStyle(Object object);

    //--x轴颜色
    int getXAxisColor(Object object);

    //--y轴颜色
    int getYAxisColor(Object object);

    int getXGridColor(Object object);

    int getYGridColor(Object object);

}
