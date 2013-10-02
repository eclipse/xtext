package org.eclipse.xtext.maven;

import org.eclipse.xtext.generator.IFileSystemAccess;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class OutputConfiguration {

	/**
	 * a unique name identifying this outlet configuration.
	 * 
	 * @property default-value="DEFAULT_OUTPUT"
	 */
	private String name = IFileSystemAccess.DEFAULT_OUTPUT;

	/**
	 * a description to be shown in the UI.
	 * @property
	 */
	private String description;

	/**
	 * the project relative path to the output directory
	 * 
	 * @property
	 * @required
	 */
	private String outputDirectory;

	/**
	 * whether the output directory should be created if t doesn't already
	 * exist.
	 * @property
	 */
	private boolean createOutputDirectory = true;

	/**
	 * whether existing resources should be overridden.
	 * @property
	 */
	private boolean overrideExistingResources = true;

	/**
	 * whether the DSL files should be registered as primary source files for
	 * debugging in the generated Java-class-files. If false, the Java source is
	 * registered as primary source and the DSL files are registered as
	 * secondary source via JSR-045 (SMAP).
	 * 
	 * This property is only support for languages using Xbase.
	 * 
	 * @property
	 */
	private boolean installDslAsPrimarySource = false;

	/**
	 * whether debug information should be removed from the class files for
	 * synthetic local variables. Synthetic variables are the ones that have not
	 * been declared in the DSL but have been introduced by the compiler. This
	 * flag is only used when {@link #isInstallDslAsPrimarySource()} is true.
	 * 
	 * This property is only support for languages using Xbase.
	 * 
	 * @property
	 */
	private boolean hideSyntheticLocalVariables = true;

	public OutputConfiguration() {
		super();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOutputDirectory() {
		return outputDirectory;
	}

	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	public boolean isOverrideExistingResources() {
		return overrideExistingResources;
	}

	public void setOverrideExistingResources(boolean overrideExistingResources) {
		this.overrideExistingResources = overrideExistingResources;
	}

	public boolean isCreateOutputDirectory() {
		return createOutputDirectory;
	}

	public void setCreateOutputDirectory(boolean createOutputDirectory) {
		this.createOutputDirectory = createOutputDirectory;
	}

	public boolean isInstallDslAsPrimarySource() {
		return installDslAsPrimarySource;
	}

	public void setInstallDslAsPrimarySource(boolean installDslAsPrimarySource) {
		this.installDslAsPrimarySource = installDslAsPrimarySource;
	}

	public boolean isHideSyntheticLocalVariables() {
		return hideSyntheticLocalVariables;
	}

	public void setHideSyntheticLocalVariables(boolean hideSyntheticLocalVariables) {
		this.hideSyntheticLocalVariables = hideSyntheticLocalVariables;
	}

	public org.eclipse.xtext.generator.OutputConfiguration toOutputConfiguration() {
		org.eclipse.xtext.generator.OutputConfiguration copy = new org.eclipse.xtext.generator.OutputConfiguration(name);
		copy.setCreateOutputDirectory(createOutputDirectory);
		copy.setDescription(description);
		copy.setHideSyntheticLocalVariables(hideSyntheticLocalVariables);
		copy.setInstallDslAsPrimarySource(installDslAsPrimarySource);
		copy.setOutputDirectory(outputDirectory);
		copy.setOverrideExistingResources(overrideExistingResources);
		return copy;
	}

}
