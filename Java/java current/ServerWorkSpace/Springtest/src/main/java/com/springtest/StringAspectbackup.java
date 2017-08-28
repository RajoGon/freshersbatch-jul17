package com.springtest;


import org.aspectj.lang.*;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class StringAspectbackup{


	
	@Pointcut("execution(* StringOperations.*(..))"  )
	public void getException(){}
	
	@AfterThrowing(pointcut = "getException()", throwing="ex")
	public void getExcep(JoinPoint joinPoint,Exception ex){
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("Exception " + ex+" thrown for method ,"+methodName);
	}
}
