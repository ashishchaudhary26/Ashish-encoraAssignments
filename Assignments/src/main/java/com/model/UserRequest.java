package com.model;

import org.hibernate.annotations.AnyDiscriminator;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
@Entity
public class UserRequest {
	@NotBlank
	private String name;
	
	@Min(18)
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
}
