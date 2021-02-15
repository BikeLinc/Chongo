package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

import de.matthiasmann.twl.GUI;

public class DisplayManager {

	private static final int WIDTH   = 1280;
	private static final int HEIGHT  = 720;
	private static final int FPS_CAP = 120;
	
	public static void createDisplay() {
		ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true); // Basic LWJGL Settings
		// Creates Display or Terminates
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
		} catch (LWJGLException e) {
			e.printStackTrace();
			return;
		} 
		
		Display.setTitle("Game - ChongoEngine");
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT); // Tells OpenGL To Use Entire Display
	}
	
	public static void updateDisplay() {
		Display.sync(FPS_CAP); // Runs Game At Steady FPS
		Display.update();
	}
	
	public static void closeDisplay() {
		Display.destroy();
		System.exit(0);
	}
}
