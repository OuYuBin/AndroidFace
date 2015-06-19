package cn.robin.aface.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by robin on 15-6-1.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeArrayAnnotation {

    public String name();

    public String desc();

    public String type();

    public String defaultValue() default "";
}
