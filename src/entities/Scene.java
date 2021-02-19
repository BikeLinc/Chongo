package entities;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

public class Scene {
	
	private List<EntityTextured3D> entityTextured3Ds = new ArrayList<>();
	Vector3f position = new Vector3f(0,0,0);
	Vector3f rotation = new Vector3f(0,0,0);
	
	public void update() {
		for(EntityTextured3D entity : getEntityTextured3Ds()) {
			entity.increasePosition(position.x, position.y, position.z);
			entity.increaseRotation(rotation.x, rotation.y, rotation.z);
		}
	}
	
	public void increasePosition(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}
	
	public void increaseRotation(float dx, float dy, float dz) {
		this.rotation.x += dx;
		this.rotation.y += dy;
		this.rotation.z += dz;
	}
	
	public void addEntityTextured3D(EntityTextured3D entity) {
		this.entityTextured3Ds.add(entity);
	}
	
	public List<EntityTextured3D> getEntityTextured3Ds() {
		return entityTextured3Ds;
	}
 }
