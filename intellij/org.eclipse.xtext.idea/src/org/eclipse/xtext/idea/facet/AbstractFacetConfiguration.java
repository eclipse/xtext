/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.facet;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.jdom.Element;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;

/**
 * @author dhuebner - Initial contribution and API
 */
public abstract class AbstractFacetConfiguration implements FacetConfiguration {
	private GeneratorConfigurationState state;
	@Inject
	private IOutputConfigurationProvider outputConfigDefaults;

	@Override
	@SuppressWarnings("unchecked")
	public FacetEditorTab[] createEditorTabs(FacetEditorContext editorContext, FacetValidatorsManager validatorsManager) {
		GeneratorFacetForm uiForm = new GeneratorFacetForm(editorContext.getFacet().getModule());
		GeneratorFacetEditorTab<AbstractFacetConfiguration> facetEditorTab = new GeneratorFacetEditorTab<AbstractFacetConfiguration>(editorContext.getFacet(),
				uiForm);
		return new FacetEditorTab[] { facetEditorTab };
	}

	public GeneratorConfigurationState getState() {
		if (this.state == null) {
			this.state = createNewDefaultState();
		}
		return this.state;
	}

	public void loadState(GeneratorConfigurationState state) {
		this.state = state;
	}

	protected GeneratorConfigurationState createNewDefaultState() {
		OutputConfiguration defOutput = findDefaultOutputConfiguration();
		return new GeneratorConfigurationState(defOutput);
	}

	protected OutputConfiguration findDefaultOutputConfiguration() {
		OutputConfiguration defOutput = Iterables.find(outputConfigDefaults.getOutputConfigurations(), new Predicate<OutputConfiguration>() {
			@Override
			public boolean apply(OutputConfiguration conf) {
				return IFileSystemAccess.DEFAULT_OUTPUT.equals(conf.getName());
			}
		});
		return defOutput;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void readExternal(Element element) throws InvalidDataException {
	}

	@SuppressWarnings("deprecation")
	@Override
	public void writeExternal(Element element) throws WriteExternalException {
	}

}
