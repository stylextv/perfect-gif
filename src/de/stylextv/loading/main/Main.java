package de.stylextv.loading.main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.stream.FileImageOutputStream;

import de.stylextv.loading.output.GifSequenceWriter;
import de.stylextv.loading.render.MainRenderer;
import de.stylextv.loading.render.RenderUtil;

public class Main {
	
	public static void main(String[] args) {
		try {
			
			String fileName="out.gif";
			GifSequenceWriter writer=new GifSequenceWriter(new FileImageOutputStream(new File(fileName)), BufferedImage.TYPE_INT_RGB, 17, true);
			
			int width=600;
			int height=600;
			
			MainRenderer.setup(width,height);
			
			BufferedImage canvas=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics=(Graphics2D) canvas.getGraphics();
			RenderUtil.setRenderingHints(graphics);
			
			MainRenderer.canvas=canvas;
			MainRenderer.graphics=graphics;
			MainRenderer.width=width;
			MainRenderer.height=height;
			
			int frames=50+20;
			int maxPercent=0;
			System.out.println("0%");
			for(int i=0; i<frames; i++) {
				MainRenderer.frameIndex=i;
				MainRenderer.renderFrame();
				
				writer.writeToSequence(canvas);
				int percent=(int)((double)(i+1)/(frames)*100);
				if(percent%5==0&&percent>maxPercent) {
					maxPercent=percent;
					System.out.println(percent+"%");
				}
			}
			
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		
	}
	
}
