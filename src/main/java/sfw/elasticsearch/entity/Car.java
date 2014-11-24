package sfw.elasticsearch.entity;

public class Car {

	private String name;
	private String model;

	
	//setters-getters
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Car:[id=" + model + " name=" + name + "]";
	}
}
