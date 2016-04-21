package com.github.snakeice.aloklib.classtools;

import com.github.snakeice.aloklib.constructortools.ConstructorsHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Rodrigo on 09/04/2016.
 */
public class ClassFactory {
    public  <T> T getInstance(Class<T> klass, Object... objects) {
        Constructor[] constructors = klass.getConstructors();
        ConstructorsHelper<T> ch = new ConstructorsHelper<>(constructors);
        return ch.newInstance(objects);
    }
}
