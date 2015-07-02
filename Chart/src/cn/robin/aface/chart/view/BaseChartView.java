package cn.robin.aface.chart.view;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import cn.robin.aface.chart.IBaseChartControl;
import cn.robin.aface.chart.adapter.ChartComponentAdapterFactory;
import cn.robin.aface.chart.listeners.IChartOnTouchListener;
import cn.robin.aface.chart.providers.IChartAxisProvider;
import cn.robin.aface.chart.providers.IChartContentProvider;
import cn.robin.aface.chart.providers.IChartLabelProvider;
import cn.robin.aface.chart.utils.Transformer;
import cn.robin.aface.chart.utils.ViewPortManager;

/**
 * Created by robin on 15-3-30.
 */
public abstract class BaseChartView extends View implements IChartView {

    private IChartLabelProvider mChartLabelProvider;

    private IChartContentProvider mChartContentProvider;

    private IChartAxisProvider mChartAxisProvider;

    private ChartComponentAdapterFactory mChartComponentAdapterFactory;

    protected IBaseChartControl mChartElement;

    protected ViewPortManager mViewPortManager;

    protected Transformer mTransformer;

    protected IChartOnTouchListener mChartTouchListener;

    protected Map mPropertyTypes;

    public BaseChartView(Context context) {
        super(context);
        init();
    }

    public BaseChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(isInEditMode()) {
        	return;
        }
        TypedArray typedArray = getTypeArray(attrs);
        configureView(typedArray);
        //--元件适配器工厂
        mChartComponentAdapterFactory = new ChartComponentAdapterFactory(this);
        init();
        typedArray.recycle();
    }


    public BaseChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if(isInEditMode()) {
        	return;
        }
        TypedArray typedArray = getTypeArray(attrs);
        configureView(typedArray);
        //--元件适配器工厂
        mChartComponentAdapterFactory = new ChartComponentAdapterFactory(this);
        init();
        typedArray.recycle();
    }

    public abstract void configureView(TypedArray typedArray);

    public abstract TypedArray getTypeArray(AttributeSet attrs);

    public void init() {
        mViewPortManager = new ViewPortManager();
        mTransformer = new Transformer(mViewPortManager);
    }

    public IBaseChartControl getChartElement() {
        return mChartElement;
    }

    public void setChartElement(IBaseChartControl chartElement) {
        this.mChartElement = chartElement;
    }

    @Override
	public IChartLabelProvider getChartLabelProvider() {
        return mChartLabelProvider;
    }

    public void setChartLabelProvider(IChartLabelProvider chartLabelProvider) {
        this.mChartLabelProvider = chartLabelProvider;
    }

    @Override
	public IChartContentProvider getChartContentProvider() {
        return mChartContentProvider;
    }

    public void setChartContentProvider(IChartContentProvider chartContentProvider) {
        this.mChartContentProvider = chartContentProvider;
    }

    @Override
	public IChartAxisProvider getChartAxisProvider() {
        return mChartAxisProvider;
    }

    public void setChartAxisProvider(IChartAxisProvider chartAxisProvider) {
        this.mChartAxisProvider = chartAxisProvider;
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (adapter.equals(ViewPortManager.class)) {
            return mViewPortManager;
        } else if (adapter.equals(Transformer.class)) {
            return mTransformer;
        }
        return null;
    }

    public ViewPortManager getViewPortManager() {
        return mViewPortManager;
    }


    public void disableScroll() {
        ViewParent parent = this.getParent();
        if (parent != null)
            parent.requestDisallowInterceptTouchEvent(false);
    }

    @Override
	public ChartComponentAdapterFactory getChartComponentAdapterFactory() {
        return mChartComponentAdapterFactory;
    }

    @Override
	public Map getProperties() {
        return mPropertyTypes;
    }

    public void setPropertyType(String key, Object value) {
        if (mPropertyTypes == null) {
            mPropertyTypes = new HashMap();
        }
        if (value != null) {
            mPropertyTypes.put(key, value);
        }
    }
}
