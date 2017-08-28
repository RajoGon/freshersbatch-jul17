package com.springtest;


import org.aspectj.lang.*;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

public class StringAspect{

	public void getExcep(JoinPoint joinPoint,Exception ex){
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("Exception " + ex+" thrown for method ,"+methodName);
	}
}
