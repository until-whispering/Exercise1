package cn.task.exercise1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

import cn.task.exercise1.inject.Autowired;

public class InjectUtils {
    public static void injectAutowired(Activity activity){
        Class<? extends Activity> cls = activity.getClass();
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null){
            return;
        }


        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Autowired.class)){
                Autowired autowired = field.getAnnotation(Autowired.class);
                String key = TextUtils.isEmpty(autowired.value()) ? field.getName() : autowired.value();

                if (extras.containsKey(key)){
                    Object obj = extras.get(key);

                    Class<?> componentType = field.getType().getComponentType();
                    if (field.getType().isArray() && Parcelable.class.isAssignableFrom(componentType)){
                        Object[] objects = (Object[]) obj;

                        Object[] objects1 = Arrays.copyOf(objects,objects.length,(Class<? extends Object[]>) field.getType() );
                        obj = objects1;
                    }
                    field.setAccessible(true);
                    try {
                        field.set(activity,obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
