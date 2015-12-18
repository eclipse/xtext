/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.facet

import com.intellij.facet.ui.FacetEditorContext
import com.intellij.facet.ui.FacetEditorTab
import com.intellij.facet.ui.FacetValidatorsManager
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration
import org.eclipse.xtext.idea.facet.GeneratorFacetEditorTab

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XbaseFacetConfiguration extends AbstractFacetConfiguration {

	override FacetEditorTab[] createEditorTabs(
		FacetEditorContext editorContext,
		FacetValidatorsManager validatorsManager
	) {
		val uiForm = new XbaseFacetForm(editorContext.getFacet().getModule(), validatorsManager);
		val facetEditorTab = new GeneratorFacetEditorTab<XbaseFacetConfiguration>(editorContext.getFacet(),
			uiForm);
		return #[facetEditorTab];
	}

	override XbaseGeneratorConfigurationState getState() {
		return super.state as XbaseGeneratorConfigurationState
	}

	override protected XbaseGeneratorConfigurationState createNewDefaultState() {
		var defOutput = findDefaultOutputConfiguration()
		return new XbaseGeneratorConfigurationState(defOutput)
	}

	def void loadState(XbaseGeneratorConfigurationState state) {
		super.loadState(state);
	}

}