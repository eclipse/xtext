package org.eclipse.xtext.m2e;

public class SourceMapping {
	private String outputDirectory;

	private String sourceFolder;

	public String getOutputDirectory() {
		return this.outputDirectory;
	}

	public String getSourceFolder() {
		return this.sourceFolder;
	}

	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	public void setSourceFolder(String sourceFolder) {
		this.sourceFolder = sourceFolder;
	}
}
