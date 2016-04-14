package com.github.snakeice.aloklib.constructortools;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rodrigo on 10/04/2016.
 */
public class ConstructorsHelper<T> {
    Constructor[] constructors;

    public ConstructorsHelper(Constructor[] constructors) {
        this.constructors = constructors;
    }

    public Constructor findByParam(Object... objects) {
        List<Class> types;
        types = new ArrayList<>();
        for (Object o : objects) {
            types.add(o.getClass());
        }
        for (Constructor c : constructors) {
            if (Arrays.equals(c.getParameterTypes(), types.toArray())) {
                return c;
            }
        }
        return null;
    }

    @SuppressWarnings("All")
    public T newInstance(Object... objects) {
        try {
            Constructor constructor = findByParam(objects);
            if (constructor == null) {
                constructor = constructors[0];
            }
            return (T) constructor.newInstance(objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
