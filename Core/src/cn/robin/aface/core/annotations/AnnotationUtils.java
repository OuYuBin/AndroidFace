package cn.robin.aface.core.annotations;

import java.lang.reflect.Field;

/**
 * Created by robin on 15-6-1.
 */
public class AnnotationUtils {

    public static void setValue(Object object, Field field, Object value) {
        try {
            TypeArrayAnnotation annotation = field.getAnnotation(TypeArrayAnnotation.class);
            String type = annotation.type();
            field.setAccessible(true);
            if (type.equals("Float")) {
                field.setFloat(object, (Float) value);
            } else if (type.equals("String")) {
                field.set(object, value);
            }else if(type.equals("Integer")){
                field.set(object,(Integer)value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
