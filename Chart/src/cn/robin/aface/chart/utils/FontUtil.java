package cn.robin.aface.chart.utils;

import android.graphics.Paint;
import android.graphics.Rect;
import cn.robin.aface.chart.font.FontStyle;

/**
 * Created by robin on 15-4-17.
 */
public class FontUtil {

    public static int getFontHeight(FontStyle fontStyle) {
        int fontSize = fontStyle.getFontSize();
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        paint.setTypeface(fontStyle.getTypeface());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public static int getFontWidth(FontStyle fontStyle) {
        int fontSize = fontStyle.getFontSize();
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        paint.setTypeface(fontStyle.getTypeface());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public static int calcFontHeight(FontStyle fontStyle) {
        int fontSize = fontStyle.getFontSize();
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        paint.setTypeface(fontStyle.getTypeface());
        Rect rect = new Rect();
        paint.getTextBounds("Q", 0, 1, rect);
        return rect.height();
    }

    public static float calcFontWidth(FontStyle fontStyle, String text) {
        int fontSize = fontStyle.getFontSize();
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        paint.setTypeface(fontStyle.getTypeface());
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect.width();
    }

    public static String getTheLongestLabel(float[] values){
        String longestLabel=null;
        int maxLength=0;
        for(float value:values){
            int length=String.valueOf(value).length();
            if(length>maxLength){
                maxLength=length;
                longestLabel=String.valueOf(value);
            }
        }

        return longestLabel;
    }
}
