/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

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
	 * whether the resources should be flagged as 'derived'
	 * <b>Only used if the underlying file system implementation supports such a property</b>
	 */
	private boolean setDerivedProperty = true;
	
	/**
	 * whether the whole outputDirectory can be cleared.
	 * This is usually used in a CLEAN build.
	 */
	private boolean canClearOutputDirectory = false;
	
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
	
}
