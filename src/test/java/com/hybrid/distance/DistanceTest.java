package com.hybrid.distance;

public class DistanceTest {

	public static void main(String[] args) {

		DistanceOfPoints d = new DistanceOfPoints(5400 , 34, 120, 60, 20) ; 
		
//		d.calculate(); 
		
		System.out.println( " Theta = " + d.getTheta() + " radian" ) ; 
		System.out.println(" Length = " + d.getLength() + " km");
		
	}

}
