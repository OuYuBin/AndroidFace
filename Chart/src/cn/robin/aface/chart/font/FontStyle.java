package cn.robin.aface.chart.font;

import android.graphics.Typeface;

/**
 * Created by robin on 15-4-17.
 */
public class FontStyle {

    int mFontSize;
    Typeface mTypeface;


    public FontStyle(int fontSize) {
        this(fontSize, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        this.mFontSize = fontSize;
    }

    public FontStyle(int fontSize, Typeface typeface) {
        this.mFontSize = fontSize;
        this.mTypeface = typeface;
    }


    public int getFontSize() {
        return mFontSize;
    }

    public void setFontSize(int fontSize) {
        this.mFontSize =fontSize;
    }

    public Typeface getTypeface() {
        return mTypeface;
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
    }
}
