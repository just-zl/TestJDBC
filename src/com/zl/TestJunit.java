package com.zl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJunit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//���Է���һ���ڷ�������Ҫ����@Testע��
	//Junit�Ĳ��Է���������public�ģ������з���ֵ�������в����������׳��쳣
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
