package cn.robin.aface.chart.model;

/**
 *
 * Created by robin on 15-3-21.
 */
public class ChartEntry {

    public Object mObject;

    public int mIndex;

    public ChartEntry(Object object,int index){
        this.mObject=object;
        this.mIndex=index;
    }

    public Object getObject() {
        return mObject;
    }

    public int getIndex() {
        return mIndex;
    }
}
