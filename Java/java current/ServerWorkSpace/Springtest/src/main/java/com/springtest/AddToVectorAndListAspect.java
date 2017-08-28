package com.springtest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AddToVectorAndListAspect {

	
	@Pointcut("execution(* AddToVectorAndList.*(..))" )
	public void timeit(){}
	
	@Around("timeit()")
	public void getTimeToExecute(ProceedingJoinPoint joinPoint) throws Throwable{
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Method, "+joinPoint.getSignature().getName()+" executed in, "+elapsedTime+ " milliseconds" );

	}
}
