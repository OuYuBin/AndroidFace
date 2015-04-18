package cn.robin.aface.chart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import cn.robin.aface.chart.IBaseChartElement;
import cn.robin.aface.chart.listeners.IChartOnTouchListener;
import cn.robin.aface.chart.providers.IChartContentProvider;
import cn.robin.aface.chart.providers.IChartLabelProvider;
import cn.robin.aface.chart.providers.ILineChartAxisProvider;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;

/**
 * Created by robin on 15-3-30.
 */
public class BaseChartView extends View implements IBaseChartView {

    private IChartLabelProvider mChartLabelProvider;

    private IChartContentProvider mChartContentProvider;

    private ILineChartAxisProvider mChartAxisProvider;



    protected IBaseChartElement mChartElement;

    protected ViewPortManager mViewPortManager;

    protected Transformer mTransformer;

    protected IChartOnTouchListener mChartTouchListener;

    public BaseChartView(Context context) {
        super(context);
        init();
    }

    public BaseChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {
        mViewPortManager=new ViewPortManager();
        mTransformer=new Transformer(mViewPortManager);
    }

    public IBaseChartElement getChartElement() {
        return mChartElement;
    }

    public void setChartElement(IBaseChartElement chartElement) {
        this.mChartElement = chartElement;
    }

    public IChartLabelProvider getChartLabelProvider() {
        return mChartLabelProvider;
    }

    public void setChartLabelProvider(IChartLabelProvider chartLabelProvider) {
        this.mChartLabelProvider = chartLabelProvider;
    }

    public IChartContentProvider getChartContentProvider() {
        return mChartContentProvider;
    }

    public void setChartContentProvider(IChartContentProvider chartContentProvider) {
        this.mChartContentProvider = chartContentProvider;
    }

    public ILineChartAxisProvider getChartAxisProvider() {
        return mChartAxisProvider;
    }

    public void setChartAxisProvider(ILineChartAxisProvider chartAxisProvider) {
        this.mChartAxisProvider = chartAxisProvider;
    }

    @Override
    public Object getAdapter(Class adapter) {
        if(adapter.equals(ViewPortManager.class)){
            return mViewPortManager;
        }else if(adapter.equals(Transformer.class)){
            return mTransformer;
        }
        return null;
    }

    public ViewPortManager getViewPortManager() {
        return mViewPortManager;
    }
}
