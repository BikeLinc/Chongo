package engineTester;

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
		DisplayManager.createDisplay();
		Loader 	     loader   = new Loader();
		StaticShader shader   = new StaticShader();
		Renderer     renderer = new Renderer(shader);
		
		EntityTextured3D dragon = new EntityTextured3D("dragon","white",new Vector3f(0,0,-20),0,0,0,1);
		EntityTextured3D stall = new EntityTextured3D("stall","stallTexture",new Vector3f(7,0,-20),0,0,0,1);
		
		Light  light  = new Light(new Vector3f(0,10,-20), new Vector3f(1,1,1));
		Camera camera = new Camera(new Vector3f(0,0,0));
		
		Scene scene = new Scene();
		scene.addEntityTextured3D(dragon);
		scene.addEntityTextured3D(stall);
		
		//new GuiEditor(300,200);
		
		MousePicker picker = new MousePicker(camera, renderer.getProjectionMatrix());
		
		SceneController controller = new SceneController(scene, camera);
		
		while(!Display.isCloseRequested()) {
			controller.updateScene();
			camera.move();
			picker.update();
//			entity.move();
			renderer.prepare();
			shader.start();
			shader.loadLight(light);
			shader.loadViewMatrix(camera);
			renderer.renderScene(scene, shader);
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
