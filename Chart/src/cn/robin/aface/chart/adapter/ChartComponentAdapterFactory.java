package cn.robin.aface.chart.adapter;

import cn.robin.aface.chart.component.IChartComponent;
import cn.robin.aface.chart.view.IChartView;
import cn.robin.aface.core.annotations.AnnotationUtils;
import cn.robin.aface.core.annotations.TypeArrayAnnotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by robin on 15-5-30.
 */
public class ChartComponentAdapterFactory {

    public Collection<Object> supportedChartCompontentAdapter = new ArrayList<Object>();

    private IChartView mChartView;

    public ChartComponentAdapterFactory(IChartView chartView) {
        this.mChartView = chartView;
        //supportedChartCompontentAdapter.add(IXAxisComponentAdapter.class);
        //supportedChartCompontentAdapter.add(IChartComponentAdapter.class);
        supportedChartCompontentAdapter.add(XAxisComponentAdapter.class);
        supportedChartCompontentAdapter.add(YAxisComponentAdapter.class);
        supportedChartCompontentAdapter.add(LineChartComponentAdapter.class);
    }


    //--通过适配器工厂将模型与适配绑定返回模型适配器供界面控件使用
    public IChartComponentAdapter adapter(Object object, Object type) {
        IChartComponentAdapter chartComponentAdapter = null;
        if (object instanceof IChartComponent) {
            //--注入当前视图所携带的数据模型对象
            //((IChartComponent) object).setChartDataSet(mChartView.getModel());

            //--将界面相关自定义属性落入模型对象
            //--数据模型填充需要处理1.通过自定义


            //--根据属性名称通过annotation中的描述对属性值进行注入
            Field[] fields = object.getClass().getDeclaredFields();
            Map typeArray = mChartView.getProperties();
            for (Field field : fields) {
                TypeArrayAnnotation annotation = field.getAnnotation(TypeArrayAnnotation.class);
                if (annotation != null) {
                    String typeName = annotation.name();
                    Object value = typeArray.get(typeName);
                    if (value != null) {
                        AnnotationUtils.setValue(object, field, value);
                    }
                }
            }

            if (type instanceof Class) {
                try {
                    if (supportedChartCompontentAdapter.contains(type)) {
                        chartComponentAdapter = (IChartComponentAdapter) ((Class) type).newInstance();
                        return chartComponentAdapter;
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }
        }
        return chartComponentAdapter;
    }

    public IChartView getChartView() {
        return mChartView;
    }

}
