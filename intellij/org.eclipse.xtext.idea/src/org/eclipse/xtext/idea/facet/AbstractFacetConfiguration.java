/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.facet;

import org.jdom.Element;

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

	@SuppressWarnings("deprecation")
	@Override
	public void readExternal(Element element) throws InvalidDataException {
	}

	@SuppressWarnings("deprecation")
	@Override
	public void writeExternal(Element element) throws WriteExternalException {
	}

	@Override
	public FacetEditorTab[] createEditorTabs(FacetEditorContext editorContext, FacetValidatorsManager validatorsManager) {
		GeneratorFacetEditorTab<AbstractFacetConfiguration> sdomainFacetEditorTab = new GeneratorFacetEditorTab<AbstractFacetConfiguration>(
				editorContext.getFacet(), getTabTitle());
		return new FacetEditorTab[] { sdomainFacetEditorTab };
	}

	protected abstract String getTabTitle();

	@Override
	public GeneratorConfigurationState getState() {
		if (this.state == null) {
			this.state = createDefaultSet();
		}
		return this.state;
	}

	protected GeneratorConfigurationState createDefaultSet() {
		GeneratorConfigurationState state = new GeneratorConfigurationState();
		state.setActivated(true);
		return state;
	}

	@Override
	public void loadState(GeneratorConfigurationState state) {
		this.state = state;
	}

}
