package com.hybrid.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WrapperTest {

	public static void main(String[] args) {
		
		List<Map<String, String>> list = new ArrayList<>(); 
		
		List<Map<String, List<Integer>>> list2 = new ArrayList<>(); 

//		primitive type 
		byte b = 20 ; 	// 1 byte 
		short s = 10 ; 	// 2 byte 
		char c = 30 ;  // 2 byte 
		int i = 10 ;  // 4 byte 
		long l = 20 ;  // 8 byte 
		float f = 10.5f ; // 4 byte 
		double d = 10.6 ;  // 8 byte 
		
// 		Wrapper type 
		Byte B = null ; // Boxing 이라 한다. 아래와 같은 형태로 정의된다고 보면 된다. 
		Byte B1 = Byte.valueOf("10") ; // 이와 
		
		Character C = null ; 
		Short S = null ;
		Integer I = null ;
		Long L = null ;  // 200L
		Float F = null ;  // 200f 와 같이 숫자 뒤에 f를 붙인다. 
		Double D = null ; // 300.
		
		
		d = D  ; // Unboxing 의 개념 , primitive data 에 wrapper type을 넣기 전에
		// type 변환이 발생 , 아래와 같은 방식으로 전환되는 것을 알 수 있다. 
		d = D.doubleValue();
		
		
//		Double D2 = null ; 
//		d = D2 ;
//		System.out.println("d = " + d); 
		
	}

}












