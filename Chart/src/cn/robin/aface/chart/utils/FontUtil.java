package cn.robin.aface.chart.utils;

import android.graphics.Paint;
import cn.robin.aface.chart.font.FontStyle;

/**
 * Created by robin on 15-4-17.
 */
public class FontUtil {

    public static int getFontHeight(FontStyle fontStyle){
        int fontSize=fontStyle.getFontSize();
        Paint paint=new Paint();
        paint.setTextSize(fontSize);
        paint.setTypeface(fontStyle.getTypeface());
        Paint.FontMetrics fontMetrics=paint.getFontMetrics();
        return (int)Math.ceil(fontMetrics.descent-fontMetrics.ascent);
    }

    public static int getFontWidth(FontStyle fontStyle){
        int fontSize=fontStyle.getFontSize();
        Paint paint=new Paint();
        paint.setTextSize(fontSize);
        paint.setTypeface(fontStyle.getTypeface());
        Paint.FontMetrics fontMetrics=paint.getFontMetrics();
        return (int)Math.ceil(fontMetrics.descent-fontMetrics.ascent);
    }
}
