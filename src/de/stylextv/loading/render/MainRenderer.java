package de.stylextv.loading.render;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class MainRenderer {
	
	public static BufferedImage canvas;
	public static Graphics2D graphics;
	public static int frameIndex,width,height;
	
	private static double ratio;
	
	public static void setup(int width, int height) {
		ratio=width/500.0;
	}
	
	public static void renderFrame() {
		graphics.setColor(new Color(0,0,0));
		graphics.fillRect(0, 0, width, height);
		
		graphics.setColor(new Color(255,255,255));
		
		double dGlobal=frameIndex/(50+20.0);
		
		double h1=130*ratio+(225-130)*ratio*dGlobal;
		double w1=h1/0.577777778;
		double rot1=-45+90*dGlobal;
		double d1=(dGlobal-0.25)/0.75;
		if(d1<0)d1=0;
		double gap=300*ratio*Math.pow(d1, 2);
		graphics.rotate(Math.toRadians(rot1),width/2,height/2);
		graphics.fill(new Rectangle2D.Double(width/2-w1/2.0-gap, height/2-h1/2.0, w1/3.0+1, h1));
		graphics.fill(new Rectangle2D.Double(width/2-w1/2.0+w1/3.0, height/2-h1/2.0, w1/3.0+1, h1));
		graphics.fill(new Rectangle2D.Double(width/2-w1/2.0+w1/3.0*2+gap, height/2-h1/2.0, w1/3.0, h1));
		graphics.rotate(Math.toRadians(-rot1),width/2,height/2);
	}
	
}
