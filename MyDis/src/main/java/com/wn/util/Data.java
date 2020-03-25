//package com.wn.util;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//
//@Aspect
//public class Data {
//	public static int serviceid = 0;
//	@Before("execution (* com.wn.service.TestService.*(..))")
//	public void befor(JoinPoint join) {
//		String name = join.getSignature().getName();
//		System.out.println(name);
//	}
//	@After("execution  (* com.wn.service.TestService.*(..))")
//	public void after() {
//		System.out.println("方法执行之后");
//		serviceid++;
//		//System.out.println(serviceid);
//	}
//}
