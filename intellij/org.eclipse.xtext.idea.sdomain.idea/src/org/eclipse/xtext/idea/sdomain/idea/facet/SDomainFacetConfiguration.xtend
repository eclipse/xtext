/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.facet

import com.google.inject.Inject
import com.intellij.facet.FacetConfiguration
import com.intellij.facet.ui.FacetEditorContext
import com.intellij.facet.ui.FacetEditorTab
import com.intellij.facet.ui.FacetValidatorsManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.StorageScheme
import com.intellij.openapi.util.InvalidDataException
import com.intellij.openapi.util.WriteExternalException
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.jdom.Element
import org.eclipse.xtext.generator.IFileSystemAccess

/** 
 * @author dhuebner - Initial contribution and API
 */
@State(name="SDomainGenerator", storages=#[
	@Storage(id="ipr", file="$PROJECT_FILE$"),
	@Storage(id="prjDir", file="${PROJECT_CONFIG_DIR$/SDomainGeneratorConfig.xml", scheme=StorageScheme.
		DIRECTORY_BASED)
])
class SDomainFacetConfiguration implements FacetConfiguration, PersistentStateComponent<SDomainGeneratorConfigurationState> {
	@Inject
	IOutputConfigurationProvider outputConfiguration;
	SDomainGeneratorConfigurationState state

	override FacetEditorTab[] createEditorTabs(FacetEditorContext editorContext,
		FacetValidatorsManager validatorsManager) {
		var sdomainFacetEditorTab = new SDomainFacetEditorTab((editorContext.getFacet() as SDomainFacet),
			"SDomain facet")
		return #[sdomainFacetEditorTab]
	}

	override SDomainGeneratorConfigurationState getState() {
		if (this.state == null) {
			this.state = createDefaultSet();
		}
		return this.state
	}

	def createDefaultSet() {
		val state = new SDomainGeneratorConfigurationState
		state.activated = true
		if (outputConfiguration != null) {
			val defaults = outputConfiguration.outputConfigurations.findFirst[name === IFileSystemAccess.DEFAULT_OUTPUT]
			state.overwriteExisting = defaults.overrideExistingResources
			state.createDirectory = defaults.createOutputDirectory
			state.deleteGenerated = defaults.canClearOutputDirectory
			state.directory = defaults.outputDirectory
		}
		return state
	}

	override void loadState(SDomainGeneratorConfigurationState state) {
		this.state = state
	}

	override void readExternal(Element element) throws InvalidDataException {
	}

	override void writeExternal(Element element) throws WriteExternalException {
	}

}
	