package com.meijiatest.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.DisabledRetryAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class OverrideIAnnotationTransformer implements IAnnotationTransformer {
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {
        Class<? extends IRetryAnalyzer> retry = annotation.getRetryAnalyzerClass();
        if (retry == DisabledRetryAnalyzer.class) {
            annotation.setRetryAnalyzer(RetryListener.class);
        }
    }
}
