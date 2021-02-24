package engineTester;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import entities.Camera;
import entities.Scene;


// TODO: Scene Controller Send Object In inf Loop
public class SceneController {
	
	Scene scene;
	Camera camera;

	// Input Pressed
	boolean x, y, z, e, r, mouse_right, mouse_left;
	
	// Position or Rotation Mode
	boolean pos = true;
	boolean rot = false;
	
	// Mouse Values
	int mouse_x, mouse_y, mouse_middle;
	int x_last = 0;
	int y_last = 0;
	int mouse_last = 0;
	
	// Moiuse
	float sensitivity = 0.05f;
	float posSensitivity = 0.5f;
	
	public SceneController(Scene scene, Camera camera) {
		this.scene = scene;
		this.camera = camera;
	}
	
	private void updateInput() {
		x = Keyboard.isKeyDown(Keyboard.KEY_X);
		y = Keyboard.isKeyDown(Keyboard.KEY_Y);
		z = Keyboard.isKeyDown(Keyboard.KEY_Z);
		e = Keyboard.isKeyDown(Keyboard.KEY_E);
		r = Keyboard.isKeyDown(Keyboard.KEY_R);
		if(e && !r) {
			pos = true;
			rot = false;
		} else if (r && !e) {
			rot = true;
			pos = false;
		} else if (r && !e) {
			rot = true;
			pos = false;
		}
		mouse_right = Mouse.isButtonDown(1);
		mouse_left = Mouse.isButtonDown(0);
		mouse_x = Mouse.getX();
		mouse_y = Mouse.getY();
		mouse_middle = Mouse.getDWheel();
	}
	
	public void updateScene() {
		updateInput();
			// Mouse Control Position with No Axis
			if(mouse_left && pos && !x && !y && !z) {
				scene.increasePosition((mouse_x - x_last)*sensitivity*posSensitivity , (mouse_y - y_last)*sensitivity*posSensitivity, 0);
			}
			// Mouse Control Rotation with No Axis
			if(mouse_left && rot && !x && !y && !z) {
				scene.increaseRotation((mouse_y - y_last)*sensitivity, (mouse_x - x_last)*sensitivity , 0);
			}
			
			if(mouse_left && rot && x && !y && !z) {
				scene.increaseRotation((mouse_y - y_last)*sensitivity,0, 0);
			}
			if(mouse_left && rot && !x && y && !z) {
				scene.increaseRotation(0,(mouse_y - y_last)*sensitivity, 0);
			}
			if(mouse_left && rot && !x && !y && z) {
				scene.increaseRotation(0,0,(mouse_y - y_last)*sensitivity);
			}
			
			if(mouse_left && pos && x && !y && !z) {
				scene.increasePosition((mouse_y - y_last)*sensitivity*posSensitivity,0, 0);
			}
			if(mouse_left && pos && !x && y && !z) {
				scene.increasePosition(0,(mouse_y - y_last)*sensitivity*posSensitivity, 0);
			}
			if(mouse_left && pos && !x && !y && z) {
				scene.increasePosition(0,0,(mouse_y - y_last)*sensitivity*posSensitivity);
			}
			
			if(mouse_right) {
				if(mouse_left && pos && !x && !y && !z) {
					camera.increasePosition((mouse_x - x_last)*sensitivity*posSensitivity , (mouse_y - y_last)*sensitivity*posSensitivity, 0);
				}
				// Mouse Control Rotation with No Axis
				if(mouse_left && rot && !x && !y && !z) {
					camera.increaseRotation((mouse_y - y_last)*sensitivity, (mouse_x - x_last)*sensitivity);
				}
				
				if(mouse_left && rot && x && !y && !z) {
					camera.increaseRotation((mouse_y - y_last)*sensitivity,0);
				}
				if(mouse_left && rot && !x && y && !z) {
					camera.increaseRotation(0,(mouse_y - y_last)*sensitivity);
				}
				
				if(mouse_left && pos && x && !y && !z) {
					camera.increasePosition((mouse_y - y_last)*sensitivity*posSensitivity,0, 0);
				}
				if(mouse_left && pos && !x && y && !z) {
					camera.increasePosition(0,(mouse_y - y_last)*sensitivity*posSensitivity, 0);
				}
				if(mouse_left && pos && !x && !y && z) {
					camera.increasePosition(0,0,(mouse_y - y_last)*sensitivity*posSensitivity);
				}
			}
		
		x_last = mouse_x;
		y_last = mouse_y;
		mouse_last = mouse_middle;
	}
	
}
