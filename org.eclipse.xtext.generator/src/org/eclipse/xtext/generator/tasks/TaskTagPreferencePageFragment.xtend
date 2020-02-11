/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.tasks

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.BindFactory
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@Deprecated
class TaskTagPreferencePageFragment extends Xtend2GeneratorFragment {

	@Inject Grammar grammar

	@Inject extension Naming naming

	override addToPluginXmlUi(Xtend2ExecutionContext ctx) {
		ctx.append(
			'''
				<!-- task preference page for «grammar.name» -->
				<extension
					point="org.eclipse.ui.preferencePages">
					<page
						category="«grammar.name»"
						class="«grammar.executableExtensionFactory»:org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferencePage"
						id="«grammar.name».task.preferencePage"
						name="Task Tags">
						<keywordReference id="«grammar.name.toPackageName + ".ui.keyword_" + grammar.name.toSimpleName»"/>
					</page>
				</extension>
				<extension
					point="org.eclipse.ui.propertyPages">
					<page
						category="«grammar.name»"
						class="«grammar.executableExtensionFactory»:org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferencePage"
						id="«grammar.name».task.propertyPage"
						name="Task Tags">
						<keywordReference id="«grammar.name.toPackageName + ".ui.keyword_" + grammar.name.toSimpleName»"/>
						<enabledWhen>
							<adapt type="org.eclipse.core.resources.IProject"/>
						</enabledWhen>
						<filter name="projectNature" value="org.eclipse.xtext.ui.shared.xtextNature"/>
					</page>
				</extension>
			''')
	}

	override getGuiceBindingsRt(Grammar grammar) {
		val bind = new BindFactory()
		bind.addTypeToType("org.eclipse.xtext.tasks.ITaskTagProvider",
			"org.eclipse.xtext.tasks.PreferenceTaskTagProvider")
		bind.bindings
	}

	override getGuiceBindingsUi(Grammar grammar) {
		val bind = new BindFactory()
		bind.addConfiguredBinding(
			"TaskTagPreferenceStoreInitializer",
			'''
				binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class)
				.annotatedWith(com.google.inject.name.Names.named("taskTagPreferenceInitializer"))
				.to(org.eclipse.xtext.ui.tasks.preferences.TaskTagPreferenceInitializer.class)
			'''
		)
		bind.bindings
	}
}
