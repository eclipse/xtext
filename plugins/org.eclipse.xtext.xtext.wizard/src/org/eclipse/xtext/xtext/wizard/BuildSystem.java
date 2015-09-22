package org.eclipse.xtext.xtext.wizard;

public enum BuildSystem {
	ECLIPSE("Eclipse"),
	MAVEN("Maven"),
	GRADLE("Gradle");
	
	private String humanReadableName;
	
	private BuildSystem(String humanReadableName) {
		this.humanReadableName = humanReadableName;
	}
	public String toString() {
		return humanReadableName;
	}
}
