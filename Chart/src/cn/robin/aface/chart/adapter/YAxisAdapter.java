package cn.robin.aface.chart.adapter;

import cn.robin.aface.chart.axis.YAxis;
import cn.robin.aface.chart.component.YAxisComponent;
import cn.robin.aface.chart.utils.MathUtil;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;


/**
 * Created by robin on 15-3-23.
 * Y轴适配器,根据提供提供对模型进行属性填充后通过该适配器进行对应适配供给图形使用
 */
public class YAxisAdapter extends BaseChartComponentAdapter {


    public float[] mEntries;

    public YAxisAdapter(YAxisComponent yAxisComponent) {
        super(yAxisComponent);
        //--在构造函数中就对模型信息进行适配
        computeAxis();
    }

    //--适配图形最大最小点位
    public void computeAxis() {
        YAxisComponent yAxisComponent= (YAxisComponent)mChartComponent;
        yAxisComponent.getFontStyle();
        computeValueAxis(yAxisComponent);
    }








    //--等分切割轴线
    private void computeValueAxis(YAxisComponent yAxisComponent) {
        float max=yAxisComponent.getYMaxVal();
        float min=yAxisComponent.getYMinVal();
        int count=yAxisComponent.getLabelCount();
        double range=Math.abs(max - min);
        double rawInterval=range/count;
        double interval= MathUtil.roundToNextSignificant(rawInterval);
        double intervalMagnitude=Math.pow(10,Math.log10(interval));
        int intervalSigDigit = (int) (interval / intervalMagnitude);

        double first=Math.ceil(min/interval)*interval;
        double last=Math.floor(max/interval)*interval;

        double value;
        int n=0;
        int i;
        for(value=first;value<=last;value+=interval){
            ++n;
        }
        setEntries(new float[n]);

        for(i=0,value=first;i<n;value+=interval,++i){
            getEntries()[i]= (float) value;
        }
    }

    public float[] getEntries() {
        return mEntries;
    }

    public void setEntries(float[] entries) {
        this.mEntries = entries;
    }


}
