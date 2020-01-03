package de.stylextv.loading.math;

import java.util.Random;

public class MathUtil {
	
	private static Random random=new Random();
	public static Random getRandom() {
		return random;
	}
	
	public static double sigmoid(double x) {
		return (1/( 1 + Math.pow(Math.E,(-1*(x*16-8)))));
	}
	public static double sine(double x) {
		return Math.sin(x*(Math.PI));
	}
	
}
