package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.EntityTextured3D;
import entities.Light;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;
import toolBox.MousePicker;

public class GameTestWithObjects {
	
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		Loader 	     loader   = new Loader();
		StaticShader shader   = new StaticShader();
		Renderer     renderer = new Renderer(shader);
		
		RawModel model = OBJLoader.loadObjModel("dragon", loader);
		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("white")));
		
		EntityTextured3D entity = new EntityTextured3D(staticModel, new Vector3f(0,0,-20),0,0,0,1);
		Light  light  = new Light(new Vector3f(0,10,-20), new Vector3f(1,1,1));
		Camera camera = new Camera(new Vector3f(0,0,0));
		
		//new GuiEditor(300,200);
		
		MousePicker picker = new MousePicker(camera, renderer.getProjectionMatrix());
		
		SceneController controller = new SceneController(entity, camera);
		
		while(!Display.isCloseRequested()) {
			controller.updateEntity();
			camera.move();
			picker.update();
			System.out.println(picker.getCurrentRay());
			entity.move();
			renderer.prepare();
			shader.start();
			shader.loadLight(light);
			shader.loadViewMatrix(camera);
			renderer.render(entity, shader);
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
