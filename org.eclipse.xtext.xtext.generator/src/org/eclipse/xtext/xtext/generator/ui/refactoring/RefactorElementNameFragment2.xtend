/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.refactoring

import com.google.inject.Inject
import com.google.inject.name.Names
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.util.BooleanGeneratorOption
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import org.eclipse.xtext.xtext.generator.Issues

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

	val useJdtRefactoring = new BooleanGeneratorOption
	
	val useChangeSerializer = new BooleanGeneratorOption

	protected def isUseJdtRefactoring(Grammar grammar) {
		if (useJdtRefactoring.isSet)
			useJdtRefactoring.get
		else
			grammar.inheritsXbase
	}
	
	def void setUseJdtRefactoring(boolean useJdtRefactoring) {
		this.useJdtRefactoring.set(useJdtRefactoring)
	}

	protected def isUseChangeSerializer(Grammar grammer) {
		if (useChangeSerializer.isSet)
			useChangeSerializer.get
		else 
			false
	}

	/**
	 * Use the newer rename infrastructure based on the change serializer also in Eclipse.
	 * This is only applicable for non-Xbase languages. 
	 */
	def void setUseChangeSerializer(boolean useChangeSerializer) {
		this.useChangeSerializer.set(useChangeSerializer)		
	}
	
	override checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		if(useJdtRefactoring.isSet && useChangeSerializer.isSet)
			issues.addError("IChangeSerializer-based refactoring doesn't work with JDT")
	}

	override generate() {
		if (projectConfig.eclipsePlugin?.manifest !== null) {
			projectConfig.eclipsePlugin.manifest.requiredBundles += "org.eclipse.xtext.ui"
		}

		val uiBindings = new GuiceModuleAccess.BindingFactory()
		uiBindings				
			.addConfiguredBinding(
						"org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer".typeRef.simpleNames.join("."),
						'''
							binder.bind(«"org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer".typeRef».class)
								.annotatedWith(«Names».named("RefactoringPreferences"))
								.to(«new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "RefactoringPreferences.Initializer")».class);
						''')
		
		if (isUseChangeSerializer(grammar)) {
			uiBindings
				.addTypeToType(
						"org.eclipse.xtext.ide.refactoring.IRenameStrategy2".typeRef, 
						new TypeReference("org.eclipse.xtext.ide.refactoring", "IRenameStrategy2.DefaultImpl"))

				.addTypeToType(
						"org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor".typeRef, 
						"org.eclipse.xtext.ui.refactoring2.rename.RenameElementProcessor2".typeRef)
						
				.addTypeToType(
						"org.eclipse.xtext.ui.refactoring.ILinkedPositionGroupCalculator".typeRef, 
						"org.eclipse.xtext.ui.refactoring2.rename.DefaultLinkedPositionGroupCalculator2".typeRef)
						
		} else {
			uiBindings
				.addTypeToType(
						"org.eclipse.xtext.ui.refactoring.IRenameStrategy".typeRef, 
						"org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy".typeRef)
						
				.addTypeToType(
						"org.eclipse.xtext.ui.refactoring.IReferenceUpdater".typeRef, 
						"org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater".typeRef)
		}
				
		if (grammar.useJdtRefactoring) {
			uiBindings
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
			uiBindings
				.addTypeToType(
						"org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider".typeRef,
						"org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider".typeRef)
						
				.addTypeToType(
						new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "IRenameSupport.Factory"),
						new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "DefaultRenameSupport.Factory"))
		}

		uiBindings.contributeTo(language.eclipsePluginGenModule);
		
		if (projectConfig.eclipsePlugin?.pluginXml !== null) {
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
		
		if (projectConfig.genericIde.enabled) {
			val ideBindings = new GuiceModuleAccess.BindingFactory()
			ideBindings.addTypeToType(
				'org.eclipse.xtext.ide.server.rename.IRenameService2'.typeRef,
				'org.eclipse.xtext.ide.server.rename.RenameService2'.typeRef)
			ideBindings.addTypeToType(
				'org.eclipse.xtext.ide.refactoring.IRenameStrategy2'.typeRef,
				new TypeReference('org.eclipse.xtext.ide.refactoring', 'IRenameStrategy2.DefaultImpl'))
			ideBindings.contributeTo(language.ideGenModule)
		}
	}
}
