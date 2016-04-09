package com.github.snakeice.aloklib.classtools;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Rodrigo on 09/04/2016.
 */
public class ClassFactory {
    public static <T> T getInstance(Class<T> klass, Object... objects) {
        T instance = null;
        Constructor[] constructors = klass.getConstructors();
        try {
            instance = (T) constructors[0].newInstance(objects);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                instance = klass.newInstance();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }
        return instance;
    }
}
