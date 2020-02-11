/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static com.google.common.collect.Sets.*;

import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class OutputConfigurationProvider implements IOutputConfigurationProvider, IContextualOutputConfigurationProvider, IContextualOutputConfigurationProvider2 {
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;
	/**
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	@Override
	public Set<OutputConfiguration> getOutputConfigurations() {
		OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
		defaultOutput.setDescription("Output Folder");
		defaultOutput.setOutputDirectory("./src-gen");
		defaultOutput.setOverrideExistingResources(true);
		defaultOutput.setCreateOutputDirectory(true);
		defaultOutput.setCleanUpDerivedResources(true);
		defaultOutput.setSetDerivedProperty(true);
		defaultOutput.setKeepLocalHistory(true);
		return newHashSet(defaultOutput);
	}

	/**
	 * @since 2.8
	 */
	@Override
	public Set<OutputConfiguration> getOutputConfigurations(Resource context) {
		return getOutputConfigurations(context.getResourceSet());
	}
	
	/**
	 * @since 2.9
	 */
	@Override
	public Set<OutputConfiguration> getOutputConfigurations(ResourceSet context) {
		EList<Adapter> adapters = context.eAdapters();
		OutputConfigurationAdapter adapter = (OutputConfigurationAdapter) EcoreUtil.getAdapter(adapters, OutputConfigurationAdapter.class);
		if (adapter == null) {
			return getOutputConfigurations();
		} else {
			Set<OutputConfiguration> outputConfigurations = adapter.getOutputConfigurationsPerLanguage().get(languageName);
			return outputConfigurations == null ? getOutputConfigurations() : outputConfigurations;
		}
	}
}
