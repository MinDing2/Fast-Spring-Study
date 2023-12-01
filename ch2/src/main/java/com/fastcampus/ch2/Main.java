package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception{
//		Hello hello = new Hello();
//		hello.main(); //private이라서 호출 불가 
		
		// Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능제공 
		// java.lang.reflect 패키지 제공 
		// Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // Class객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true);	//private인 main()을 호출가능하게 한다
	
		//Hello클래스의 main -> hello.main()
		main.invoke(hello);
		
		//Hello 클래스에서 접근제어자를 private를 사용해도
		//호출되었던이유 
		//바로 스프링 프레임워크가 Reflection API 를 사용하기 때문이다. 
	}
}
