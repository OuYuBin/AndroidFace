package cn.robin.aface.chart.adapter;

import android.graphics.Typeface;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.utils.FontUtil;
import cn.robin.aface.chart.utils.MathUtil;

import java.util.List;

/**
 * Created by robin on 15-3-27.
 */
public class XAxisAdapter extends BaseAxisAdapter {

    public String[] mEntries;

    public XAxisAdapter(XAxisComponent xAxisComponent) {
        super(xAxisComponent);
        computeXAxisOffset();
        computeXAxis();
    }

    private void computeXAxisOffset() {
        XAxisComponent xAxisComponent = (XAxisComponent) mChartComponent;
        FontStyle fontStyle=xAxisComponent.getFontStyle();
        int fontHeight=FontUtil.getFontHeight(fontStyle);
        //setAxisOffset(fontHeight+xAxisComponent.getOffsetBottom());
    }

    private void computeXAxis() {
        XAxisComponent xAxisComponent = (XAxisComponent) mChartComponent;
        float xMinVal = xAxisComponent.getXMinVal();
        float xMaxVal = xAxisComponent.getXMaxVal();
        float xModulus = xAxisComponent.getModulus();
        List<String> labels = xAxisComponent.getEntries();
        computeXAxis(xMaxVal, xMinVal, xModulus, labels);
    }

    private void computeXAxis(float xMaxVal, float xMinVal, float xModulus, List<String> labels) {
        //--根据步进系数计算需要显示的信息
        int n = 0;
        for (float i = xMinVal; i < xMaxVal; i += xModulus) {
            ++n;
        }
        setEntries(new String[n]);
        int index = 0;
        for (int j = 0; j < n; ++j, index += xModulus) {
            mEntries[j] = index+"";
        }
    }

    public String[] getEntries() {
        return mEntries;
    }

    public void setEntries(String[] entries) {
        this.mEntries = entries;
    }
}
