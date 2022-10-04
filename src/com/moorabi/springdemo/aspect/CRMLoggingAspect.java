package com.moorabi.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.moorabi.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	@Pointcut("execution(* com.moorabi.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	@Pointcut("execution(* com.moorabi.springdemo.doa.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info(theMethod);
		Object agrs[]=theJoinPoint.getArgs();
		for (Object object : agrs) {
			myLogger.info(object.toString());
		}
	}
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("@AfterReturning"+theMethod);
		
		myLogger.info("result" + theResult);
	}
	
}
