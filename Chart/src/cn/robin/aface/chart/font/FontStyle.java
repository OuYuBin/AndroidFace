package cn.robin.aface.chart.font;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by robin on 15-4-17.
 */
public class FontStyle {

    int mFontSize;
    Typeface mTypeface;
    int mFontColor;
    Paint.Align mTextAlign;

    public FontStyle(int fontSize) {
        this(fontSize, Color.WHITE, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), Paint.Align.CENTER);
        this.mFontSize = fontSize;
    }

    public FontStyle(int fontSize, int fontColor) {
        this(fontSize, fontColor, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), Paint.Align.CENTER);
        this.mFontSize = fontSize;
    }

    public FontStyle(int fontSize, int fontColor, Paint.Align align) {
        this(fontSize, fontColor, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), align);
        this.mFontSize = fontSize;
    }

    public FontStyle(int fontSize, int fontColor, Typeface typeface, Paint.Align align) {
        this.mFontSize = fontSize;
        this.mTypeface = typeface;
        this.mFontColor = fontColor;
        this.mTextAlign = align;
    }


    public int getFontSize() {
        return mFontSize;
    }

    public void setFontSize(int fontSize) {
        this.mFontSize = fontSize;
    }

    public Typeface getTypeface() {
        return mTypeface;
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
    }

    public int getFontColor() {
        return mFontColor;
    }

    public void setFontColor(int fontColor) {
        this.mFontColor = fontColor;
    }

    public Paint.Align getTextAlign() {
        return mTextAlign;
    }

    public void setTextAlign(Paint.Align textAlign) {
        this.mTextAlign = textAlign;
    }
}
