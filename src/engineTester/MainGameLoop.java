package engineTester;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.EntityTextured3D;
import entities.Light;
import entities.Scene;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import toolBox.MousePicker;

public class MainGameLoop {
	
	public static void main(String[] args) {
		
		double delta = 0.0;
		double current = 0.0;
		double last = 0.0;
		double second = 0;
		
		DisplayManager.createDisplay();
		
		Loader 	     loader   = new Loader();
		StaticShader shader   = new StaticShader();
		Renderer     renderer = new Renderer(shader);
		
		EntityTextured3D dragon = new EntityTextured3D("dragon","CannibalCorpseNeck",new Vector3f(0,0,-20),0,0,0,1);
		//EntityTextured3D stall = new EntityTextured3D("stall","stallTexture",new Vector3f(7,0,-20),0,0,0,1);
		
		Light  light  = new Light(new Vector3f(0,10,-20), new Vector3f(1,1,1));
		Camera camera = new Camera(new Vector3f(0,0,0));
		
		Scene scene = new Scene();
		scene.addEntityTextured3D(dragon);
		//scene.addEntityTextured3D(stall);
		
		//new GuiEditor(300,200);
		
		MousePicker picker = new MousePicker(camera, renderer.getProjectionMatrix());
		
		//SceneController controller = new SceneController(scene, camera);
		
		while(!Display.isCloseRequested()) {
			camera.move();
			picker.update();
			renderer.prepare();
			shader.start();
			shader.loadLight(light);
			shader.loadViewMatrix(camera);
			renderer.renderScene(scene, shader);
			DisplayManager.updateDisplay();
			
			current = getTime();
			delta = current - last;
			if (second >= 60.0f) {
				System.out.println((int)(1000.0 / (current - last)));
			}
			last = current;
			second+= delta;
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
	
	public static double getTime()
    {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

}





