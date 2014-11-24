package sfw.elasticsearch.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document( indexName = "person" , type = "user")
public class Person {

	@Id
	private String id;
	
	
	private String name;
	
	@Field(type = FieldType.Nested)
	private List<Car> car;

	
	//setters-getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Car> getCar() {
		return car;
	}
	public void setCar(List<Car> car) {
		this.car = car;
	}
	
	@Override
	public String toString() {
		return "Person:[id=" + id + " name=" + name +" "+ car.get(0).toString() + "]";
	}
}
