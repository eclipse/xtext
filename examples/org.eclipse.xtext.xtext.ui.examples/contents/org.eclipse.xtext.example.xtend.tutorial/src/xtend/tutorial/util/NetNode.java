package xtend.tutorial.util;

import static java.util.Collections.*;

public class NetNode {
	private String name;
	private Iterable<NetNode> references = emptySet();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Iterable<NetNode> getReferences() {
		return references;
	}
	
	public void setReferences(Iterable<NetNode> references) {
		this.references = references;
	}
	
}
