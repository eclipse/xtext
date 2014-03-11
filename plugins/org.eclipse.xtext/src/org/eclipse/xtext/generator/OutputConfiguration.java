/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.Objects;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class OutputConfiguration {

	/**
	 * a unique name identifying this outlet configuration.
	 */
	private String name;

	/**
	 * a description to be shown in the UI.
	 */
	private String description;

	/**
	 * the project relative path to the output directory
	 */
	private String outputDirectory;

	/**
	 * whether the output directory should be created if t doesn't already exist.
	 */
	private boolean createOutputDirectory;

	/**
	 * whether derived resources should be deleted on clean.
	 */
	private boolean cleanUpDerivedResources = true;

	/**
	 * whether existing resources should be overridden.
	 */
	private boolean overrideExistingResources = true;

	/**
	 * whether the resources should be flagged as 'derived' <b>Only used if the underlying file system implementation
	 * supports such a property</b>
	 */
	private boolean setDerivedProperty = true;

	/**
	 * whether the whole outputDirectory can be cleared. This is usually used in a CLEAN build.
	 */
	private boolean canClearOutputDirectory = false;

	/**
	 * whether the DSL files should be registered as primary source files for debugging in the generated
	 * Java-class-files. If false, the Java source is registered as primary source and the DSL files are registered as
	 * secondary source via JSR-045 (SMAP).
	 */
	private boolean installDslAsPrimarySource = false;

	/**
	 * whether debug information should be removed from the class files for synthetic local variables. Synthetic
	 * variables are the ones that have not been declared in the DSL but have been introduced by the compiler. This flag
	 * is only used when {@link #isInstallDslAsPrimarySource()} is true.
	 */
	private boolean hideSyntheticLocalVariables = true;

	/**
	 * whether local history should be kept for generated files.
	 */
	private boolean keepLocalHistory = false;

	/**
	 * Whether to allow specifying output directories on a per sourcefolder basis
	 */
	private boolean useOutputPerSourceFolder = false;

	private Set<SourceMapping> sourceMappings = Sets.newHashSet();

	public OutputConfiguration(String name) {
		super();
		this.name = name;
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

	public boolean isCleanUpDerivedResources() {
		return cleanUpDerivedResources;
	}

	public void setCleanUpDerivedResources(boolean cleanUpDerivedResources) {
		this.cleanUpDerivedResources = cleanUpDerivedResources;
	}

	public boolean isOverrideExistingResources() {
		return overrideExistingResources;
	}

	public void setOverrideExistingResources(boolean overrideExistingResources) {
		this.overrideExistingResources = overrideExistingResources;
	}

	public boolean isSetDerivedProperty() {
		return setDerivedProperty;
	}

	public void setSetDerivedProperty(boolean setDerivedProperty) {
		this.setDerivedProperty = setDerivedProperty;
	}

	public boolean isCreateOutputDirectory() {
		return createOutputDirectory;
	}

	public void setCreateOutputDirectory(boolean createOutputDirectory) {
		this.createOutputDirectory = createOutputDirectory;
	}

	public boolean isCanClearOutputDirectory() {
		return canClearOutputDirectory;
	}

	public void setCanClearOutputDirectory(boolean canClearOutputDirectory) {
		this.canClearOutputDirectory = canClearOutputDirectory;
	}

	/**
	 * @since 2.4
	 */
	public boolean isInstallDslAsPrimarySource() {
		return installDslAsPrimarySource;
	}

	/**
	 * @since 2.4
	 */
	public void setInstallDslAsPrimarySource(boolean installDslAsPrimarySource) {
		this.installDslAsPrimarySource = installDslAsPrimarySource;
	}

	/**
	 * @since 2.4
	 */
	public boolean isHideSyntheticLocalVariables() {
		return hideSyntheticLocalVariables;
	}

	/**
	 * @since 2.4
	 */
	public void setHideSyntheticLocalVariables(boolean hideSyntheticLocalVariables) {
		this.hideSyntheticLocalVariables = hideSyntheticLocalVariables;
	}

	/**
	 * @since 2.5
	 */
	public Boolean isKeepLocalHistory() {
		return keepLocalHistory;
	}

	/**
	 * @since 2.5
	 */
	public void setKeepLocalHistory(Boolean keepLocalHistory) {
		this.keepLocalHistory = keepLocalHistory;
	}

	/**
	 * @since 2.6
	 */
	public boolean isUseOutputPerSourceFolder() {
		return useOutputPerSourceFolder;
	}

	/**
	 * @since 2.6
	 */
	public void setUseOutputPerSourceFolder(boolean useOutputPerSourceFolder) {
		this.useOutputPerSourceFolder = useOutputPerSourceFolder;
	}

	/**
	 * @since 2.6
	 */
	public Set<SourceMapping> getSourceMappings() {
		return sourceMappings;
	}

	/**
	 * @since 2.6
	 */
	public String getOutputDirectory(String sourceFolder) {
		if (useOutputPerSourceFolder) {
			for (SourceMapping mapping : sourceMappings) {
				if (mapping.getSourceFolder().equals(sourceFolder) && mapping.getOutputDirectory() != null) {
					return mapping.getOutputDirectory();
				}
			}
		}
		return getOutputDirectory();
	}
	
	public Set<String> getSourceFolders() {
		Set<String> sourceFolders = Sets.newLinkedHashSet();
		for (SourceMapping mapping : getSourceMappings()) {
			sourceFolders.add(mapping.getSourceFolder());
		}
		return sourceFolders;
	}
	
	public Set<String> getOutputDirectories() {
		Set<String> outputDirectories = Sets.newLinkedHashSet();
		if (isUseOutputPerSourceFolder()) {
			for (SourceMapping mapping : getSourceMappings()) {
				outputDirectories.add(getOutputDirectory(mapping.getSourceFolder()));
			}
		} else {
			outputDirectories.add(getOutputDirectory());
		}
		return outputDirectories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutputConfiguration other = (OutputConfiguration) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Specifies the output folder for a source folder (may be null, in which case the output folder of the enclosing
	 * {@link OutputConfiguration} is used). A source folder may also be set to be ignored in the UI. This makes it
	 * clear to the user that he does not have to specify an output directory for that source folder.
	 * 
	 * @since 2.6
	 */
	public static class SourceMapping {
		private String sourceFolder;
		private String outputDirectory;
		private boolean ignore;

		public SourceMapping(String sourceFolder) {
			this.sourceFolder = sourceFolder;
		}

		public String getSourceFolder() {
			return sourceFolder;
		}

		public String getOutputDirectory() {
			return outputDirectory;
		}

		public void setOutputDirectory(String outputDirectory) {
			this.outputDirectory = outputDirectory;
		}

		public boolean isIgnore() {
			return ignore;
		}

		public void setIgnore(boolean ignore) {
			this.ignore = ignore;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof SourceMapping) {
				SourceMapping other = (SourceMapping) obj;
				return Objects.equals(sourceFolder, other.sourceFolder);
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(sourceFolder);
		}
	}
}
