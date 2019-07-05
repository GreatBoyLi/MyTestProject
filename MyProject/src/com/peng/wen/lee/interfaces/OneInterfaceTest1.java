package com.peng.wen.lee.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class OneInterfaceTest1 extends UnitTestBase {

	public OneInterfaceTest1() {
		super("classpath*:applicationContext.xml");
	}
	
	@Test
	public void testHello() {
		//OneInterface one = super.getBean("oneInterface");
		System.out.println("llllllll122222");
	}

}
