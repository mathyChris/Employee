package com.hybrid.distance;

public class DistanceOfPoints {
	
	
//	alpha : latitude ; 
//	beta : longitude ; 
	
	private double alpha_1 , alpha_2 ; 
	private double beta_1, beta_2 ; 
	private double R ; 
	private double theta ; 
	private double length ; 
	
	
	public DistanceOfPoints(double R , double alpha_1, double beta_1 , double alpha_2, double beta_2) {

		this.alpha_1 = alpha_1 * (3.14) / 180 ; 
		this.alpha_2 = alpha_2 * (3.14) / 180 ; 
		this.beta_1 = beta_1 * (3.14) / 180 ; 
		this.beta_2 = beta_2 * (3.14) / 180 ; 
		this.R = R ;
		
		calculate(); 
		
	}
	
	
	public void calculate(){
		
		double x1 = R * Math.cos(alpha_1) * Math.cos(beta_1) ; 
		double y1 = R * Math.cos(alpha_1) * Math.sin(beta_1) ; 
		double z1 = R * Math.sin(beta_1) ;
		
		double x2 = R * Math.cos(alpha_2) * Math.cos(beta_2) ; 
		double y2 = R * Math.cos(alpha_2) * Math.sin(beta_2) ; 
		double z2 = R * Math.sin(beta_2) ;
		
		theta = Math.acos(
				(x1*x2 + y1*y2 + z1*z2) 
				/ 
				( Math.pow( (Math.pow(x1, 2) + Math.pow(y1, 2) + Math.pow(z1, 2)) , 0.5 ) *
				  Math.pow( (Math.pow(x2, 2) + Math.pow(y2, 2) + Math.pow(z2, 2)) , 0.5 ) )
				) ; 
		

		
//		System.out.println( x1*x2 + y1*y2 + z1*z2 );
//		System.out.println( Math.pow( (Math.pow(x1, 2) + Math.pow(y1, 2) + Math.pow(z1, 2)) , 0.5 ) );
//		System.out.println( Math.pow( (Math.pow(x2, 2) + Math.pow(y2, 2) + Math.pow(z2, 2)) , 0.5 ) );
		
		length = R * theta ; 
		
//		System.out.println(" length1 = " + length);
		
/*	
		theta = Math.acos(	

			(

			( R * Math.cos(alpha_1) * Math.cos(beta_1) ) * ( R * Math.cos(alpha_2) * Math.cos(beta_2) ) + 
			( R * Math.cos(alpha_1) * Math.sin(beta_1) ) * ( R * Math.cos(alpha_2) * Math.sin(beta_2) ) + 
			( R * Math.sin(alpha_1) ) * ( R * Math.sin(alpha_2) ) 

			) 
			
			/ 

			(

			Math.pow(( Math.pow( ( R * Math.cos(alpha_1) * Math.cos(beta_1) ), 2) + Math.pow(( R* Math.cos(alpha_1) * Math.sin(beta_1) ) , 2)  + Math.pow((R * Math.sin(alpha_1)),2) ), 0.5) * 
			Math.pow(( Math.pow( ( R * Math.cos(alpha_2) * Math.cos(beta_2) ), 2) + Math.pow(( R* Math.cos(alpha_2) * Math.sin(beta_2) ) , 2)  + Math.pow((R * Math.sin(alpha_2)),2) ), 0.5)

			) 
			
				); 
		
		
		System.out.println(
				
				(

						( R * Math.cos(alpha_1) * Math.cos(beta_1) ) * ( R * Math.cos(alpha_2) * Math.cos(beta_2) ) + 
						( R * Math.cos(alpha_1) * Math.sin(beta_1) ) * ( R * Math.cos(alpha_2) * Math.sin(beta_2) ) + 
						( R * Math.sin(alpha_1) ) * ( R * Math.sin(alpha_2) ) 

						) 
				
				
				);
		
		
		System.out.println(
				
				Math.pow(( Math.pow( ( R * Math.cos(alpha_1) * Math.cos(beta_1) ), 2) + Math.pow(( R* Math.cos(alpha_1) * Math.sin(beta_1) ) , 2)  + Math.pow((R * Math.sin(alpha_1)),2) ), 0.5)
	
				
				);
		
		System.out.println(
				
				Math.pow(( Math.pow( ( R * Math.cos(alpha_2) * Math.cos(beta_2) ), 2) + Math.pow(( R* Math.cos(alpha_2) * Math.sin(beta_2) ) , 2)  + Math.pow((R * Math.sin(alpha_2)),2) ), 0.5)
				
				);
	
		
		length = R * theta ; 
		
		System.out.println(" length2 = " + length);
		*/
	}


	public double getAlpha_1() {
		return alpha_1;
	}


	public void setAlpha_1(double alpha_1) {
		this.alpha_1 = alpha_1;
	}


	public double getAlpha_2() {
		return alpha_2;
	}


	public void setAlpha_2(double alpha_2) {
		this.alpha_2 = alpha_2;
	}


	public double getBeta_1() {
		return beta_1;
	}


	public void setBeta_1(double beta_1) {
		this.beta_1 = beta_1;
	}


	public double getBeta_2() {
		return beta_2;
	}


	public void setBeta_2(double beta_2) {
		this.beta_2 = beta_2;
	}


	public double getR() {
		return R;
	}


	public void setR(double r) {
		R = r;
	}


	public double getTheta() {
		return theta;
	}


	public void setTheta(double theta) {
		this.theta = theta;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}
	
	

}
