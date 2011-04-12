package xtend.tutorial.util;

import java.util.Set;

public class Person {
	
	private String forename;
	private String name;
	private Set<Person> friends;
	
	public Person(String forename, String name) {
		super();
		this.forename = forename;
		this.name = name;
	}
	
	public Person() {
	}
	
	public Set<Person> getFriends() {
		return friends;
	}
	
	public void setFriends(Set<Person> friends) {
		this.friends = friends;
	}

	public String getForename() {
		return forename;
	}
	
	public void setForename(String forename) {
		this.forename = forename;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
