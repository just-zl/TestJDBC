package com.zl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJunit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//测试方法一定在方法顶部要加上@Test注解
	//Junit的测试方法必须是public的，不能有返回值，不能有参数，可以抛出异常
	@Test
	public void testJunit() {
		System.out.println("hello junit");
	}
	@Before
	public void testBefore() {
		System.out.println("Before");
	}
	@After
	public void testAfter() {
		System.out.println("After");
	}
 
}
