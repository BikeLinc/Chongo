package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	private Vector3f position;
	private float pitch;
	private float yaw;
	private float roll;
	
	float mouseX;
	float mouseY;
	
	public Camera(Vector3f position) {
		this.position = position;
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
	}
	
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			position.z -= 0.2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			position.z += 0.2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.x += 0.2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			position.x -= 0.2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_V)) {
			pitch -= 0.1f * (mouseY - Mouse.getY());
			yaw -= 0.5f * (mouseX - Mouse.getX());
		}
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
	}
	
	public void increasePosition(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}
	
	public void increaseRotation(float dx, float dy) {
		this.pitch += dx;
		this.yaw += dy;
	}
	
	public Vector3f getPosition() {
		return position;
	}
	public float getPitch() {
		return pitch;
	}
	public float getYaw() {
		return yaw;
	}
	public float getRoll() {
		return roll;
	}

}
