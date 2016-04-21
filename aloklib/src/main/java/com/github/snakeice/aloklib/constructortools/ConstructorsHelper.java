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

    public Constructor findByParam(Object... objects){
        List<Class> types;
        types = new ArrayList<>();
        for (Object o:objects) {
            types.add(o.getClass());
        }
        for (Constructor c:constructors) {
            if (Arrays.equals(c.getParameterTypes(), types.toArray())){
                return c;
            }
        }
        return constructors[0];
    }
    @SuppressWarnings("All")
    public T newInstance(Object... objects){
        try {
           return (T) findByParam(objects).newInstance(objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return (T) constructors[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
