package com.peng.wen.lee.autoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestA {
	@Autowired
	private TestB testB;
	public void say() {
		testB.test();
		System.out.println("Test my Spring.");
	}
}
