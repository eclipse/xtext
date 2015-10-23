/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.refactoring

import com.google.inject.Inject
import com.google.inject.name.Names
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment
import org.eclipse.xtext.xtext.generator.model.TypeReference

/**
 * Contributes the registration of element renaming infrastructure.
 *  
 * @author Christian Schneider - Initial contribution and API
 */
class RefactorElementNameFragment2 extends AbstractXtextGeneratorFragment {

	@Inject
	extension XtextGeneratorNaming

	@Inject
	extension XbaseUsageDetector

	@Accessors
	private Boolean useJdtRefactoring = null; // no default (depends on whether xbase is used or not)	

	protected def isUseJdtRefactoring(Grammar grammar) {
		if (useJdtRefactoring == null) {
			grammar.inheritsXbase
		} else {
			return useJdtRefactoring.booleanValue()
		}
	}

	override generate() {
		if (projectConfig.eclipsePlugin?.manifest != null) {
			projectConfig.eclipsePlugin.manifest.requiredBundles += "org.eclipse.xtext.ui"
		}

		val bindings = new GuiceModuleAccess.BindingFactory()
			.addTypeToType(
					"org.eclipse.xtext.ui.refactoring.IRenameStrategy".typeRef, 
					"org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy".typeRef)
					
			.addTypeToType(
					"org.eclipse.xtext.ui.refactoring.IReferenceUpdater".typeRef, 
					"org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater".typeRef)
					
			.addConfiguredBinding(
					"org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer".typeRef.simpleNames.join("."),
					'''
						binder.bind(«"org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer".typeRef».class)
							.annotatedWith(«Names».named("RefactoringPreferences"))
							.to(«new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "RefactoringPreferences.Initializer")».class);
					''')
				
		if (grammar.useJdtRefactoring) {
			bindings
				.addTypeToType(
						"org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory".typeRef,
						"org.eclipse.xtext.common.types.ui.refactoring.JdtRefactoringContextFactory".typeRef)

				.addTypeToType(
						"org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider".typeRef,
						"org.eclipse.xtext.common.types.ui.refactoring.JvmRenameRefactoringProvider".typeRef)

				.addTypeToType(
						new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "IRenameSupport.Factory"),
						new TypeReference("org.eclipse.xtext.common.types.ui.refactoring", "JdtRenameSupport.Factory"))

				.addTypeToType(
						new TypeReference("org.eclipse.xtext.ui.refactoring", "IRenameStrategy.Provider"),
						new TypeReference("org.eclipse.xtext.common.types.ui.refactoring.participant", "JvmMemberRenameStrategy.Provider"))

				.addConfiguredBinding(
						"JvmMemberRenameStrategy.Provider.Delegate",
						'''
							binder.bind(«new TypeReference("org.eclipse.xtext.ui.refactoring", "IRenameStrategy.Provider")
								».class).annotatedWith(«
								new TypeReference("org.eclipse.xtext.common.types.ui.refactoring.participant", "JvmMemberRenameStrategy.Provider.Delegate")
								».class).to(«"org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategyProvider".typeRef
								».class);
						''')
		} else {
			bindings
				.addTypeToType(
						"org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider".typeRef,
						"org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider".typeRef)
						
				.addTypeToType(
						new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "IRenameSupport.Factory"),
						new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "DefaultRenameSupport.Factory"))
		}

		bindings.contributeTo(language.eclipsePluginGenModule);
		
		if (projectConfig.eclipsePlugin?.pluginXml != null) {
			projectConfig.eclipsePlugin.pluginXml.entries += '''
				<!-- Rename Refactoring -->
				<extension point="org.eclipse.ui.handlers">
					<handler 
						class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.refactoring.ui.DefaultRenameElementHandler"
						commandId="org.eclipse.xtext.ui.refactoring.RenameElement">
						<activeWhen>
							<reference
								definitionId="«grammar.name».Editor.opened">
							</reference>
						</activeWhen>
					</handler>
				</extension>
				<extension point="org.eclipse.ui.menus">
					<menuContribution
						locationURI="popup:#TextEditorContext?after=group.edit">
						<command commandId="org.eclipse.xtext.ui.refactoring.RenameElement"
							style="push">
							<visibleWhen checkEnabled="false">
								<reference
									definitionId="«grammar.name».Editor.opened">
								</reference>
							</visibleWhen>
						</command>
					</menuContribution>
				</extension>
				<extension point="org.eclipse.ui.preferencePages">
					<page
						category="«grammar.name»"
						class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferencePage"
						id="«grammar.name».refactoring"
						name="Refactoring">
						<keywordReference id="«grammar.runtimeBasePackage + ".ui.keyword_"+grammar.simpleName»"/>
					</page>
				</extension>
			'''
		}
	}
}