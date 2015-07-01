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
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;

/**
 * @author dhuebner - Initial contribution and API
 */
public abstract class AbstractFacetConfiguration implements FacetConfiguration, PersistentStateComponent<GeneratorConfigurationState> {
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

	@Override
	public GeneratorConfigurationState getState() {
		if (this.state == null) {
			this.state = createNewDefaultState();
		}
		return this.state;
	}

	@Override
	public void loadState(GeneratorConfigurationState state) {
		this.state = state;
	}

	protected GeneratorConfigurationState createNewDefaultState() {
		GeneratorConfigurationState state = new GeneratorConfigurationState();
		initDefaults(state);
		return state;
	}

	/**
	 * presets defaults using values of {@link IFileSystemAccess#DEFAULT_OUTPUT} from the
	 * {@link IOutputConfigurationProvider}
	 * 
	 * @param state
	 *            state to modify
	 */
	protected void initDefaults(GeneratorConfigurationState state) {
		OutputConfiguration defOutput = Iterables.find(outputConfigDefaults.getOutputConfigurations(), new Predicate<OutputConfiguration>() {
			@Override
			public boolean apply(OutputConfiguration conf) {
				return IFileSystemAccess.DEFAULT_OUTPUT.equals(conf.getName());
			}
		});
		state.setActivated(true);
		if (defOutput != null) {
			state.setOutputDirectory(defOutput.getOutputDirectory());
			state.setTestOutputDirectory(defOutput.getOutputDirectory());
			state.setCreateDirectory(defOutput.isCreateOutputDirectory());
			state.setDeleteGenerated(defOutput.isCanClearOutputDirectory());
			state.setOverwriteExisting(defOutput.isOverrideExistingResources());
		}
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
