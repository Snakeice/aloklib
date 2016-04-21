package com.github.snakeice.aloklib.singleton;

import com.github.snakeice.aloklib.annotations.EBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Constrole de singletons
 * Created by Rodrigo on 17/04/2016.
 */
public class SingletonController<T> {
    private static Map<Class, Object> mInstances = new HashMap<>();

    public static <T> void registerInstance(T instance) {
        if (instance != null && !mInstances.containsKey(instance.getClass())) {
            if (instance.getClass().getAnnotation(EBean.class).klzz() != EBean.class) {
                mInstances.put(instance.getClass().getAnnotation(EBean.class).klzz(), instance);
            } else
                mInstances.put(instance.getClass(), instance);
        }
    }

    public static <T> T getInstance(Class klzz) {
        return (T) mInstances.get(klzz);
    }

    public static void removeInstance(Class klzz) {
        mInstances.remove(klzz);
    }
}
