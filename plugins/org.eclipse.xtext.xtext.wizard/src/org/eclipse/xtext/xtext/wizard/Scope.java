package org.eclipse.xtext.xtext.wizard;

public enum Scope {
	COMPILE("compile", "compile"), 
	TESTCOMPILE("test", "testCompile"), 
	PROVIDED("provided", "providedCompile");

	private String mavenNotation;
	private String gradleNotation;

	private Scope(String mavenNotation, String gradleNotation) {
		this.mavenNotation = mavenNotation;
		this.gradleNotation = gradleNotation;
	}

	public String getMavenNotation() {
		return mavenNotation;
	}

	public String getGradleNotation() {
		return gradleNotation;
	}
}
