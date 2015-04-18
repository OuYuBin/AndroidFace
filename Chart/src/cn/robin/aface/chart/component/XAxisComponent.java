package cn.robin.aface.chart.component;

import cn.robin.aface.chart.IBaseChartElement;
import cn.robin.aface.chart.adapter.XAxisAdapter;
import cn.robin.aface.chart.adapter.YAxisAdapter;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.model.ChartData;
import cn.robin.aface.core.runtime.IAdaptable;

import java.util.List;

/**
 * Created by robin on 15-3-27.
 */
public class XAxisComponent extends AxisComponent {

    private float mXMinVal;

    private float mXMaxVal;

    //--间隔系数
    private float mModulus;


    private List<String> mEntries;

    public float getModulus() {
        return mModulus;
    }

    public void setModulus(float modulus) {
        this.mModulus = modulus;
    }

    public XAxisComponent(IAdaptable adapter) {
        super(adapter);
    }

    public float getXMinVal() {
        return mXMinVal;
    }

    public void setXMinVal(float xMinVal) {
        this.mXMinVal = xMinVal;
    }

    public float getXMaxVal() {
        return mXMaxVal;
    }

    public void setXMaxVal(float xMaxVal) {
        this.mXMaxVal = xMaxVal;
    }

    public List<String> getEntries() {
        return mEntries;
    }

    public void setEntries(List<String> entries) {
        this.mEntries = entries;
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (adapter.equals(XAxisAdapter.class)) {
            return new XAxisAdapter(this);
        }
        return null;
    }


}
