package com.peng.wen.lee.interfaces;

public class OneInterfaceImpl implements OneInterface {
	
	private BoyDao boyDao1;
	
	private GirlDao girlDao;
	
	public OneInterfaceImpl(BoyDao boyDao123,GirlDao girlDao) {
		this.boyDao1 = boyDao123;
		this.girlDao = girlDao;
	}
	

	public void setboyDao1(BoyDao boyDao111) {
		this.boyDao1 = boyDao111;
	}

	@Override
	public String hello(String word) {
		boyDao1.say(word);
		this.girlDao.say();
		return "Word from interface \"OneInterface\" " + word;
	}
	
	
	public void start() {
		System.out.println("¿ªÊ¼");
	}
	
	public void stop() {
		System.out.println("½áÊø");
	}

}
