/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.tasks

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
class TaskTagPreferencePageFragment2 extends AbstractXtextGeneratorFragment {

	@Inject Grammar grammar

	@Inject
	extension XtextGeneratorNaming

	override generate() {
		val rtBindings = new GuiceModuleAccess.BindingFactory()
			.addTypeToType(
				"org.eclipse.xtext.tasks.ITaskTagProvider".typeRef,
				"org.eclipse.xtext.tasks.PreferenceTaskTagProvider".typeRef)
		rtBindings.contributeTo(language.runtimeGenModule);
				
		val eclipseBindings = new GuiceModuleAccess.BindingFactory()
			.addConfiguredBinding(
				"TaskTagPreferenceStoreInitializer", '''
					binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class)
					.annotatedWith(com.google.inject.name.Names.named("taskTagPreferenceInitializer"))
					.to(org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferenceInitializer.class);
				''')
		eclipseBindings.contributeTo(language.eclipsePluginGenModule);

		if (projectConfig.eclipsePlugin?.pluginXml !== null) {
			projectConfig.eclipsePlugin.pluginXml.entries += '''
				<!-- task preference page for «grammar.name» -->
				<extension
				point="org.eclipse.ui.preferencePages">
				<page
					category="«grammar.name»"
					class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferencePage"
					id="«grammar.name».task.preferencePage"
					name="Task Tags">
					<keywordReference id="«grammar.runtimeBasePackage + ".ui.keyword_" + grammar.simpleName»"/>
				</page>
				</extension>
				<extension
				point="org.eclipse.ui.propertyPages">
				<page
					category="«grammar.name»"
					class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferencePage"
					id="«grammar.name».task.propertyPage"
					name="Task Tags">
					<keywordReference id="«grammar.runtimeBasePackage + ".ui.keyword_" + grammar.simpleName»"/>
					<enabledWhen>
						<adapt type="org.eclipse.core.resources.IProject"/>
					</enabledWhen>
					<filter name="projectNature" value="org.eclipse.xtext.ui.shared.xtextNature"/>
				</page>
				</extension>
			'''
		}
	}
}

