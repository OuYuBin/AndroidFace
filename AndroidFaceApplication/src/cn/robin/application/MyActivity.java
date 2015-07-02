package cn.robin.application;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import cn.robin.aface.chart.model.ChartData;
import cn.robin.aface.chart.model.ChartDataSet;
import cn.robin.aface.chart.model.ChartEntry;
import cn.robin.aface.chart.providers.BaseLineChartAxisProvider;
import cn.robin.aface.chart.providers.LineChartContentProvider;
import cn.robin.aface.chart.providers.BaseLineChartStyleLabelProvider;
import cn.robin.aface.chart.view.LineChartView;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LineChartView lineChart= (LineChartView) findViewById(R.id.test);
        //lineChart.setChartContentProvider(new LineChartContentProvider());
        //lineChart.setChartLabelProvider(new BaseLineChartStyleLabelProvider());
        lineChart.setChartAxisProvider(new BaseLineChartAxisProvider());
        lineChart.setModel(createModel());
        lineChart.invalidate();
    }

    public ChartDataSet createModel(){
        List list=new ArrayList();
        for(int i=0;i<60;i++){
            double k=Math.random()*100;
            Log.d("MyActivity", k + "");
            list.add(new ChartEntry(k,i));
        }
        ChartData chartData1=new ChartData(list);

        List list1=new ArrayList();
        for(int i=0;i<80;i++){
            list1.add(new ChartEntry(Math.random()*100,i));
        }
        ChartData chartData2=new ChartData(list1);

        List dataList=new ArrayList();
        dataList.add(chartData1);
        dataList.add(chartData2);
        ChartDataSet dataSet=new ChartDataSet(dataList);


        return dataSet;
    }
}
