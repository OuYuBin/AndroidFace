package cn.robin.aface.chart.providers;

import cn.robin.aface.chart.adapter.ChartComponentAdapterFactory;
import cn.robin.aface.chart.adapter.IChartComponentAdapter;
import cn.robin.aface.chart.adapter.LineChartComponentAdapter;
import cn.robin.aface.chart.adapter.XAxisComponentAdapter;
import cn.robin.aface.chart.component.LineChartComponent;
import cn.robin.aface.chart.component.XAxisComponent;
import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.chart.model.ChartData;
import cn.robin.aface.chart.view.BaseChartView;
import cn.robin.aface.chart.view.IChartView;
import cn.robin.aface.chart.view.LineChartView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 15-5-30.
 * 工厂适配的内容提供器适配工厂
 */
public class AdapterFactoryChartContentProvider implements ILineChartContentProvider {

    ChartComponentAdapterFactory chartComponentAdapterFactory;

    IChartView chartView;

    public AdapterFactoryChartContentProvider(BaseChartView chartView) {
        this.chartView = chartView;
        this.chartComponentAdapterFactory = chartView.getChartComponentAdapterFactory();
    }

//    public XAxisComponentAdapter getAdatper(Object object) {
//        return (XAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
//    }


    //--指定X坐标间距系数
    public int getXAxisModulus(Object object) {
        XAxisComponentAdapter xAxisComponentAdapter =(XAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);;
        return xAxisComponentAdapter.getXAxisModulus(object);
    }

//    public String[] getXVals(Object object) {
//        XAxisComponentAdapter xAxisComponentAdapter = (XAxisComponentAdapter) chartComponentAdapterFactory.adapter(object, XAxisComponentAdapter.class);
//        return xAxisComponentAdapter.getXVals();
//    }


    public int getDeltaX(Object object) {
        LineChartComponentAdapter lineChartComponentAdapter = (LineChartComponentAdapter) chartComponentAdapterFactory.adapter(object, LineChartComponentAdapter.class);
        return lineChartComponentAdapter.getDeltaX(object);
    }

    public float getDeltaY(Object object) {
        LineChartComponentAdapter lineChartComponentAdapter = (LineChartComponentAdapter) chartComponentAdapterFactory.adapter(object, LineChartComponentAdapter.class);
        return lineChartComponentAdapter.getDeltaY(object);
    }


    @Override
    public float[] getXAxisOffsets(Object object) {
        LineChartComponentAdapter lineChartComponentAdapter = (LineChartComponentAdapter) chartComponentAdapterFactory.adapter(object, LineChartComponentAdapter.class);
        return lineChartComponentAdapter.getXAxisOffsets(object);
    }

    @Override
    public float[] getYAxisOffsets(Object object) {
        LineChartComponentAdapter lineChartComponentAdapter = (LineChartComponentAdapter) chartComponentAdapterFactory.adapter(object, LineChartComponentAdapter.class);
        return lineChartComponentAdapter.getYAxisOffsets(object);
    }


    public FontStyle getXAixFontStyle(Object object) {
        LineChartComponentAdapter lineChartComponentAdapter = (LineChartComponentAdapter) chartComponentAdapterFactory.adapter(object, LineChartComponentAdapter.class);
        return lineChartComponentAdapter.getXAixFontStyle(object);
    }

    public int getYAxisCount(Object[] objects) {
        return 5;
    }


    //    public int getXAxisCount(Object[] objects) {
//        int xAxisCount = 0;
//        for (Object object : objects) {
//            if (object instanceof ChartData) {
//                ChartData chartData = (ChartData) object;
//                int currentAxisCount = chartData.getChartEntries().size();
//                if (currentAxisCount > xAxisCount) {
//                    xAxisCount = currentAxisCount;
//                    referenceObject = chartData;
//                }
//            }
//        }
//        return xAxisCount;
//    }

//    public List<String> getXVals(Object[] objects) {
//        List<String> list = new ArrayList<String>();
//        int count = getXAxisCount(objects);
//        if (referenceObject instanceof ChartData) {
//            for (int i = 0; i < count; i++) {
//                list.add(i + "");
//            }
//            return list;
//        }
//        return list;
//    }

}
