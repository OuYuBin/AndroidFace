package cn.robin.aface.chart.component;

import cn.robin.aface.chart.font.FontStyle;
import cn.robin.aface.core.annotations.TypeArrayAnnotation;
//
// import cn.robin.aface.core.annotations.TypeArrayAnnotation;

import java.util.List;

/**
 * Created by robin on 15-3-27.
 */
public class XAxisComponent extends AxisComponent {

    private float mXMinVal;

    private float mXMaxVal;

    //--间隔系数
    //@TypeArrayAnnotation(name = "modulus", desc = "Modulus", type = "Integer")
    private int mModulus;

    //@TypeArrayAnnotation(name = "bottomOffset", desc = "BottomOffset", type = "float[]")
    private float[] mOffsets;

    @TypeArrayAnnotation(name = "fontSize", desc = "XAixFontSize", type = "Integer")
    private  int mFontSize;


    public XAxisComponent() {
        //super(adapter);
    }

    public int getModulus() {
        return 10;
    }

    public float[] getOffsets() {
        float[] offsets = new float[]{
                0f, 20f
        };
        return offsets;
    }

    public FontStyle getFontStyle(){
        return new FontStyle(18);
    }


//    public void setModulus(float modulus) {
//        this.mModulus = modulus;
//    }
//
//
//    public float getXMinVal() {
//        return mXMinVal;
//    }
//
//    public void setXMinVal(float xMinVal) {
//        this.mXMinVal = xMinVal;
//    }
//
//    public float getXMaxVal() {
//        return mXMaxVal;
//    }
//
//    public void setXMaxVal(float xMaxVal) {
//        this.mXMaxVal = xMaxVal;
//    }
//
//    public List<String> getEntries() {
//        return mEntries;
//    }
//
//    public void setEntries(List<String> entries) {
//        this.mEntries = entries;
//    }
//
//    @Override
//    public Object getAdapter(Class adapter) {
//        if (adapter.equals(XAxisComponentAdapter.class)) {
//            return new XAxisComponentAdapter(this);
//        }
//        return null;
//    }


}
