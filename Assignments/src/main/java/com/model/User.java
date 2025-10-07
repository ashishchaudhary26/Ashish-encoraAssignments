package com.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	private String uname;
	private String upass;
	
	@Id
	private long id;
	
	public User() {
		
	}
	

	public User(long id,String uname) {
		this.uname = uname;
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", upass=" + upass + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, uname, upass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(uname, other.uname) && Objects.equals(upass, other.upass);
	}

	
	
	
}