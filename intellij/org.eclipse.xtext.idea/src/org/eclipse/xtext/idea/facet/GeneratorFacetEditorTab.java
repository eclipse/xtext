/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.facet;

import javax.swing.JComponent;

import com.intellij.facet.Facet;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.openapi.options.ConfigurationException;

public class GeneratorFacetEditorTab<C extends AbstractFacetConfiguration> extends FacetEditorTab {
	private GeneratorFacetForm<GeneratorConfigurationState> form = new GeneratorFacetForm<GeneratorConfigurationState>();

	private String title;

	private Facet<C> facet;

	public GeneratorFacetEditorTab(final Facet<C> facet, final String title) {
		this.facet = facet;
		this.title = title;
	}

	@Override
	public JComponent createComponent() {
		return this.form.getRootComponent();
	}

	@Override
	public String getDisplayName() {
		return this.title;
	}

	@Override
	public void disposeUIResources() {
	}

	@Override
	public boolean isModified() {
		return this.form.isModified(this.facet.getConfiguration().getState());
	}

	@Override
	public void reset() {
		this.form.setData(this.facet.getConfiguration().getState());
	}

	@Override
	public void apply() throws ConfigurationException {
		this.form.getData(this.facet.getConfiguration().getState());
	}
}