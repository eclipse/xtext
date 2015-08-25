package org.eclipse.xtext.xtext.wizard;

public enum BuildSystem {
	ECLIPSE(true, false, false),
	MAVEN(false, true, false),
	TYCHO(true, true, false),
	GRADLE(false, false, true);

	private final boolean needsEclipseMetadata;
	private final boolean needsPom;
	private final boolean needsBuildGradle;

	private BuildSystem(boolean needsEclipseMetadata, boolean needsPom, boolean needsBuildGradle) {
		this.needsEclipseMetadata = needsEclipseMetadata;
		this.needsPom = needsPom;
		this.needsBuildGradle = needsBuildGradle;
	}

	public boolean needsEclipseMetadata() {
		return needsEclipseMetadata;
	}
	
	public boolean needsPom() {
		return needsPom;
	}
	
	public boolean needsBuildGradle() {
		return needsBuildGradle;
	}
}
