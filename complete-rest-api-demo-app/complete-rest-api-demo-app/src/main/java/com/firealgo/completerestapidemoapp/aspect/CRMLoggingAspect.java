package com.firealgo.completerestapidemoapp.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* com.firealgo.completerestapidemoapp.rest.*.*(..))")
	private void forControllerPackage() {
	}

	// do the same for service and dao
	@Pointcut("execution(* com.firealgo.completerestapidemoapp.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.firealgo.completerestapidemoapp.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}
	
	@Pointcut("execution(* com.firealgo.completerestapidemoapp.rest.*.add(..))")
	private void forAddMethodInController() {
		
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling method: " + theMethod);

		// display the arguments to the method

		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop thru and display args
		for (Object tempArg : args) {
			myLogger.info("=====>> argument: " + tempArg);
		}

	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);

		// display data returned
		myLogger.info("=====>> result: " + theResult);

	}

	// for throw

	@AfterThrowing(pointcut = "forAppFlow()", throwing = "ex")
	public void doRecoveryActions(JoinPoint theJoinPoint, RuntimeException ex) {
		// ...
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterThrowing: from method: " + theMethod);
	}
	
	//Additional : 
	@Before("forAddMethodInController()")
	public void doAddMethodInController(JoinPoint theJoinPoint) {
		// ...
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before for forSpecialMethodInController: from method: " + theMethod);
	}

}
