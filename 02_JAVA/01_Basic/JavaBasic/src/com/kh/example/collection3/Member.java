package com.kh.example.collection3;

import java.util.Objects;

public class Member {
	private String password;
	private String name;
	
	public Member() {
		super();
	}

	public Member(String password, String name) {
		super();
		this.password = password;
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [password=" + password + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, password);
	}
	
/*
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member mem = (Member)obj;
			return this.name.equals(mem.getName()) && this.password.equals(mem.getPassword());
		}
		return super.equals(obj);
	}
*/	
}
