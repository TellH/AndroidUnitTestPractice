package com.tellh.unittestpractice.rule;

import android.content.Context;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.mockito.internal.util.reflection.FieldSetter;
import org.robolectric.RuntimeEnvironment;

import java.lang.reflect.Field;

/**
 * Created by tlh on 2017/4/20 :)
 */

public class ContextRule implements MethodRule {
    @Override
    public Statement apply(final Statement base, FrameworkMethod method, final Object target) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                injectContextObj(target);
                base.evaluate();
            }
        };
    }

    private void injectContextObj(Object target) {
        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (!field.getType().equals(Context.class))
                    continue;
                new FieldSetter(target, field).set(RuntimeEnvironment.application);
            } catch (Exception e) {
            }
        }
    }
}
