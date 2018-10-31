package com.kn.qa.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransfamer implements IAnnotationTransformer {
	
	public void transform(ITestAnnotation annotation, Class myclass, Constructor mycons, Method mymethod){
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
