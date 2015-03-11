package org.eclipse.xtext.m2e;

import java.util.List;

import org.eclipse.xtext.generator.IFileSystemAccess;

import com.google.common.collect.Lists;

public class OutputConfiguration {
	private boolean canClearOutputDirectory = false;

	private boolean cleanUpDerivedResources = true;

	private boolean createOutputDirectory = true;

	private String description = "";

	private boolean hideSyntheticLocalVariables = true;

	private boolean installDslAsPrimarySource = false;

	private String name = IFileSystemAccess.DEFAULT_OUTPUT;

	private String outputDirectory;

	private boolean overrideExistingResources = true;

	private List<SourceMapping> sourceMappings = Lists
			.<SourceMapping> newArrayList();

	public String getDescription() {
		return this.description;
	}

	public String getName() {
		return this.name;
	}

	public String getOutputDirectory() {
		return this.outputDirectory;
	}

	public List<SourceMapping> getSourceMappings() {
		return this.sourceMappings;
	}

	public boolean isCanClearOutputDirectory() {
		return this.canClearOutputDirectory;
	}

	public boolean isCleanUpDerivedResources() {
		return this.cleanUpDerivedResources;
	}

	public boolean isCreateOutputDirectory() {
		return this.createOutputDirectory;
	}

	public boolean isHideSyntheticLocalVariables() {
		return this.hideSyntheticLocalVariables;
	}

	public boolean isInstallDslAsPrimarySource() {
		return this.installDslAsPrimarySource;
	}

	public boolean isOverrideExistingResources() {
		return this.overrideExistingResources;
	}

	public void setCanClearOutputDirectory(boolean canClearOutputDirectory) {
		this.canClearOutputDirectory = canClearOutputDirectory;
	}

	public void setCleanUpDerivedResources(boolean cleanUpDerivedResources) {
		this.cleanUpDerivedResources = cleanUpDerivedResources;
	}

	public void setCreateOutputDirectory(boolean createOutputDirectory) {
		this.createOutputDirectory = createOutputDirectory;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHideSyntheticLocalVariables(
			boolean hideSyntheticLocalVariables) {
		this.hideSyntheticLocalVariables = hideSyntheticLocalVariables;
	}

	public void setInstallDslAsPrimarySource(boolean installDslAsPrimarySource) {
		this.installDslAsPrimarySource = installDslAsPrimarySource;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	public void setOverrideExistingResources(boolean overrideExistingResources) {
		this.overrideExistingResources = overrideExistingResources;
	}

	public void setSourceMappings(List<SourceMapping> sourceMappings) {
		this.sourceMappings = sourceMappings;
	}

	public org.eclipse.xtext.generator.OutputConfiguration toGeneratorConfiguration() {
		org.eclipse.xtext.generator.OutputConfiguration copy = new org.eclipse.xtext.generator.OutputConfiguration(
				name);
		copy.setDescription(description);
		copy.setOutputDirectory(outputDirectory);
		copy.setCreateOutputDirectory(createOutputDirectory);
		copy.setOverrideExistingResources(overrideExistingResources);
		copy.setInstallDslAsPrimarySource(installDslAsPrimarySource);
		copy.setHideSyntheticLocalVariables(hideSyntheticLocalVariables);
		copy.setCanClearOutputDirectory(canClearOutputDirectory);
		copy.setCleanUpDerivedResources(cleanUpDerivedResources);
		if (!sourceMappings.isEmpty()) {
			copy.setUseOutputPerSourceFolder(true);
			for (SourceMapping mapping : getSourceMappings()) {
				org.eclipse.xtext.generator.OutputConfiguration.SourceMapping mappingCopy = new org.eclipse.xtext.generator.OutputConfiguration.SourceMapping(
						mapping.getSourceFolder());
				mappingCopy.setOutputDirectory(mapping.getOutputDirectory());
				copy.getSourceMappings().add(mappingCopy);
			}
		}
		return copy;
	}
}
