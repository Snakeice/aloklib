package com.github.snakeice.aloklib.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Rodrigo on 09/04/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EBean {
    enum Type {Singleton, Normal}

    Type type();

    Class klzz() default EBean.class;
}
