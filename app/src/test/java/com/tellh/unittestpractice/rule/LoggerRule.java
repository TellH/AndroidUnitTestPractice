package com.tellh.unittestpractice.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by tlh on 2017/4/20 :)
 */

public class LoggerRule implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                String methodName = description.getMethodName();
                String className = description.getClassName();
                base.evaluate();
                System.out.println(className + " :: " + methodName);
            }
        };
    }
}
