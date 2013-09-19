/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static com.google.common.collect.Sets.*;

import java.util.Set;

import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
@Singleton
public class OutputConfigurationProvider implements IOutputConfigurationProvider {
	private Set<OutputConfiguration> outputConfigurations;

	/**
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	public Set<OutputConfiguration> getOutputConfigurations() {
		if (outputConfigurations == null) {
			outputConfigurations = newHashSet();
			OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
			defaultOutput.setDescription("Output Folder");
			defaultOutput.setOutputDirectory("./src-gen");
			defaultOutput.setOverrideExistingResources(true);
			defaultOutput.setCreateOutputDirectory(true);
			defaultOutput.setCleanUpDerivedResources(true);
			defaultOutput.setSetDerivedProperty(true);
			outputConfigurations.add(defaultOutput);
		}
		return outputConfigurations;
	}

	/**
	 * @since 2.5
	 */
	public void setOutputConfigurations(Set<OutputConfiguration> outputConfigurations) {
		this.outputConfigurations = outputConfigurations;
	}
}
