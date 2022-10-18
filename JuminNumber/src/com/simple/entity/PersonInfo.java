package com.simple.entity;

public class PersonInfo {
	private String id;
	private String name=null;
	
	public PersonInfo() {
		// default constructor
		this.id = "000000-0000000";
		this.name = "홍길동";
	}
	
	public PersonInfo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonInfo [id=" + id + ", name=" + name + "]";
	}
}
