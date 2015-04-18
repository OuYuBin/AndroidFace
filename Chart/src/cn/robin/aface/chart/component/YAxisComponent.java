package cn.robin.aface.chart.component;

import cn.robin.aface.chart.IBaseChartElement;
import cn.robin.aface.chart.adapter.YAxisAdapter;
import cn.robin.aface.core.runtime.IAdaptable;

/**
 * Created by robin on 15-3-25.
 * <p/>
 * Y轴模型对象
 */
public class YAxisComponent extends AxisComponent {


    public float mYMaxVal;

    public float mYMinVal;

    public int mLabelCount;


    public YAxisComponent(IAdaptable adapter) {
        super(adapter);
    }

    public float getYMaxVal() {
        return mYMaxVal;
    }

    public void setYMaxVal(float mYMaxVal) {
        this.mYMaxVal = mYMaxVal;
    }

    public float getYMinVal() {
        return mYMinVal;
    }

    public void setYMinVal(float mYMinVal) {
        this.mYMinVal = mYMinVal;
    }

    public int getLabelCount() {
        return mLabelCount;
    }

    public void setLabelCount(int labelCount) {
        this.mLabelCount = labelCount;
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (adapter.equals(YAxisAdapter.class)) {
            return new YAxisAdapter(this);
        }
        return null;
    }
}
