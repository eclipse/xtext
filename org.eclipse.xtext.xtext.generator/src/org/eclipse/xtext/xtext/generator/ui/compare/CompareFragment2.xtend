/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.compare

import com.google.inject.Inject
import com.google.inject.name.Names
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*

/**
 * Contributes the registration of compare infrastructure. 
 * 
 * @author Christian Schneider - Initial contribution and API
 */
class CompareFragment2 extends AbstractXtextGeneratorFragment {

	@Inject
	extension XtextGeneratorNaming

	override generate() {
		if (projectConfig.eclipsePlugin?.manifest !== null) {
			projectConfig.eclipsePlugin.manifest.requiredBundles += #[
				"org.eclipse.compare", "org.eclipse.xtext.ui"
			]
		}
		val StringConcatenationClient statement =
			'''binder.bind(«String».class).annotatedWith(«Names».named(«new TypeReference("org.eclipse.xtext.ui.UIBindings")».COMPARE_VIEWER_TITLE)).toInstance("«grammar.simpleName» Compare");'''
		new GuiceModuleAccess.BindingFactory()
				.addTypeToType(
					new TypeReference("org.eclipse.compare.IViewerCreator"),
					new TypeReference("org.eclipse.xtext.ui.compare.DefaultViewerCreator")
				).addConfiguredBinding("CompareViewerTitle", statement).contributeTo(language.eclipsePluginGenModule);

		if (projectConfig.eclipsePlugin?.pluginXml !== null) {
			projectConfig.eclipsePlugin.pluginXml.entries += '''
			<extension point="org.eclipse.compare.contentViewers">
				<viewer id="«grammar.name».compare.contentViewers"
					class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.compare.InjectableViewerCreator"
					extensions="«language.fileExtensions.join(",")»">
				</viewer>
				<contentTypeBinding
					contentTypeId="«grammar.name».contenttype"
					contentViewerId="«grammar.name».compare.contentViewers" />
			</extension>
			<extension point="org.eclipse.compare.contentMergeViewers">
				<viewer id="«grammar.name».compare.contentMergeViewers"
					class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.compare.InjectableViewerCreator"
					extensions="«language.fileExtensions.join(",")»" label="«grammar.simpleName» Compare">
				</viewer>
				<contentTypeBinding
					contentTypeId="«grammar.name».contenttype"
					contentMergeViewerId="«grammar.name».compare.contentMergeViewers" />
			</extension>
			<extension point="org.eclipse.ui.editors.documentProviders">
				<provider id="«grammar.name».editors.documentProviders"
					class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.model.XtextDocumentProvider"
					extensions="«language.fileExtensions.join(",")»">
				</provider>
			</extension>
			<extension point="org.eclipse.team.core.fileTypes">
				«FOR modelFileExtension : language.fileExtensions»
				<fileTypes
					extension="«modelFileExtension»"
					type="text">
				</fileTypes>
				«ENDFOR» 
			</extension>
			'''
		}
	}	
}
