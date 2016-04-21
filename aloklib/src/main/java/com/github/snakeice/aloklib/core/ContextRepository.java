package com.github.snakeice.aloklib.core;

import com.github.snakeice.aloklib.annotations.EBean;
import com.github.snakeice.aloklib.annotations.Inject;
import com.github.snakeice.aloklib.classtools.ClassFactory;
import com.github.snakeice.aloklib.singleton.SingletonController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Contexto
 * Created by Rodrigo on 09/04/2016.
 */
public class ContextRepository {
    private static List<Class> repository = new ArrayList<>();

    @SafeVarargs
    public static <T>void register(Class<T>... classes) {
        for (Class<T> klazz : classes) {
            if (beanValidator(klazz) && !repository.contains(klazz)) {
                if (klazz.getAnnotation(EBean.class).klzz() == EBean.class) {
                    repository.add(klazz);
                } else {
                    repository.add(klazz.getAnnotation(EBean.class).klzz());
                }
                if (klazz.getAnnotation(EBean.class).type().equals(EBean.Type.Singleton)) {
                    SingletonController.registerInstance(new ClassFactory().getInstance(klazz));
                }
            }
        }
    }

    public static void bind(Class klazz) {
        for (Field f : klazz.getFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);
                try {
                    f.set(klazz, getInstance(klazz));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static <T> T getInstance(Class<T> klzz, Object... objects) {
        if (klzz.isAnnotationPresent(EBean.class)) {
            Class registredClass = (klzz.getAnnotation(EBean.class).klzz() != EBean.class) ?
                    klzz.getAnnotation(EBean.class).klzz() : klzz;
            if (repository.contains(registredClass)) {
                if (klzz.getAnnotation(EBean.class).type().equals(EBean.Type.Singleton)) {
                    return SingletonController.getInstance(registredClass);
                } else
                    return new ClassFactory().getInstance(klzz, objects);
            } else {
                throw new RuntimeException("Class " + klzz.getName() + " not registered");
            }
        } else
            throw new RuntimeException("Class " + klzz.getName() + " don't have @EBean anootation");
    }

    private static Boolean beanValidator(Class klzz) {
        if (klzz.isAnnotationPresent(EBean.class)) {
            return Boolean.TRUE;
        } else {
            throw new RuntimeException("Class " + klzz.getName() + " don't have @EBean anootation");
        }

    }
}
