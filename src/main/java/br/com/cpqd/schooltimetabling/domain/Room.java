package br.com.cpqd.schooltimetabling.domain;

public class Room {
	
	private String name;
	
	private Room() {
	}

	public Room(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
	
}
