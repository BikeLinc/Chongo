package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import models.RawModel;
import models.TexturedModel;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import textures.ModelTexture;

public class EntityTextured3D {

	private TexturedModel model;
	private Vector3f position;
	private float rotX, rotY, rotZ;
	private float scale;
	
	public EntityTextured3D(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}
	
	public EntityTextured3D(String obj, String texture, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		Loader loader = new Loader();
		RawModel model = OBJLoader.loadObjModel(obj, loader);
		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture(texture)));
		this.model = staticModel;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}
	
	public void increasePosition(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}
	
	public void increaseRotation(float dx, float dy, float dz) {
		this.rotX += dx;
		this.rotY += dy;
		this.rotZ += dz;
	}
	
	public void move() {
		// X
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD1) && Keyboard.isKeyDown(Keyboard.KEY_ADD)) {
			position.x += 0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD1) && Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT)) {
			position.x -= 0.02f;
		}
		// Y
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2) && Keyboard.isKeyDown(Keyboard.KEY_ADD)) {
			position.y += 0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2) && Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT)) {
			position.y -= 0.02f;
		}
		// Z
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD3) && Keyboard.isKeyDown(Keyboard.KEY_ADD)) {
			position.z += 0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD3) && Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT)) {
			position.z -= 0.02f;
		}
		
		//Rotation
		// X
				if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4) && Keyboard.isKeyDown(Keyboard.KEY_ADD)) {
					rotX += 0.2f;
				}
				if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4) && Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT)) {
					rotX -= 0.2f;
				}
				// Y
				if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD5) && Keyboard.isKeyDown(Keyboard.KEY_ADD)) {
					rotY += 0.2f;
				}
				if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD5) && Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT)) {
					rotY -= 0.2f;
				}
				// Z
				if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6) && Keyboard.isKeyDown(Keyboard.KEY_ADD)) {
					rotZ += 0.2f;
				}
				if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6) && Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT)) {
					rotZ -= 0.2f;
				}
		
	}
	
	public TexturedModel getModel() {
		return model;
	}
	public Vector3f getPosition() {
		return position;
	}
	public float getRotX() {
		return rotX;
	}
	public float getRotY() {
		return rotY;
	}
	public float getRotZ() {
		return rotZ;
	}
	public float getScale() {
		return scale;
	}
	
	
		
}
