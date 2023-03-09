/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.resource.containers.IAllContainersState
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

/**
 * The ImplicitFragment is added in the first slot to all language configurations.
 */
package class ImplicitFragment extends AbstractStubGeneratingFragment {
	
	@Inject extension XbaseUsageDetector
	
	@Inject extension XtextGeneratorNaming naming
	
	override generate() {
		if (projectConfig.runtime.manifest !== null) {
			projectConfig.runtime.manifest.requiredBundles.addAll(#[
				'org.eclipse.xtext', 'org.eclipse.xtext.util'
			])
			
			if (generateXtendStub) {
				projectConfig.runtime.manifest.requiredBundles += 'org.eclipse.xtend.lib;bundle-version="'+projectConfig.runtime.xtendLibVersionLowerBound+'"'
			}
			
			projectConfig.runtime.manifest.importedPackages.add('org.apache.log4j')
		}
		
		if (projectConfig.eclipsePlugin.manifest !== null) {
			projectConfig.eclipsePlugin.manifest.requiredBundles.addAll(#[
				'org.eclipse.xtext.ui', 'org.eclipse.xtext.ui.shared', 'org.eclipse.ui.editors', 'org.eclipse.ui'
			])
			
			if (generateXtendStub) {
				projectConfig.eclipsePlugin.manifest.requiredBundles += 'org.eclipse.xtend.lib;bundle-version="'+projectConfig.runtime.xtendLibVersionLowerBound+'"'
			}
			
			projectConfig.eclipsePlugin.manifest.importedPackages.add('org.apache.log4j')
		}
		
		if (projectConfig.eclipsePlugin.pluginXml !== null) {
			projectConfig.eclipsePlugin.pluginXml.entries += grammar.implicitPluginXmlEnties
		}
		
		val StringConcatenationClient expression = '''«'org.eclipse.xtext.ui.shared.Access'.typeRef».getJavaProjectsState()'''
		val bindingFactory = new GuiceModuleAccess.BindingFactory()
			.addTypeToProviderInstance(IAllContainersState.typeRef, expression)
		
		if (inheritsXbase(grammar)) {
			bindingFactory.addTypeToType('org.eclipse.xtext.ui.editor.model.XtextDocumentProvider'.typeRef,
					'org.eclipse.xtext.xbase.ui.editor.XbaseDocumentProvider'.typeRef)
				.addTypeToType('org.eclipse.xtext.ui.generator.trace.OpenGeneratedFileHandler'.typeRef,
					'org.eclipse.xtext.xbase.ui.generator.trace.XbaseOpenGeneratedFileHandler'.typeRef)
		}
		bindingFactory.contributeTo(language.eclipsePluginGenModule)
	}
	
	def getImplicitPluginXmlEnties(Grammar it) '''
		<extension
			point="org.eclipse.ui.editors">
			<editor
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.XtextEditor"
				contributorClass="org.eclipse.ui.editors.text.TextEditorActionContributor"
				default="true"
				extensions="«language.fileExtensions.join(",")»"
				id="«name»"
				«IF grammar.inheritsXbase»
					matchingStrategy="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.xbase.ui.editor.JavaEditorInputMatcher"
				«ENDIF»
				name="«it.simpleName» Editor">
			</editor>
		</extension>
		<extension
			point="org.eclipse.ui.handlers">
			<handler
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.hyperlinking.OpenDeclarationHandler"
				commandId="org.eclipse.xtext.ui.editor.hyperlinking.OpenDeclaration">
				<activeWhen>
					<reference
						definitionId="«name».Editor.opened">
					</reference>
				</activeWhen>
			</handler>
			<handler
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.handler.ValidateActionHandler"
				commandId="«name».validate">
				<activeWhen>
					<reference
						definitionId="«name».Editor.opened">
					</reference>
				</activeWhen>
			</handler>
			<!-- copy qualified name -->
			<handler
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.copyqualifiedname.EditorCopyQualifiedNameHandler"
				commandId="org.eclipse.xtext.ui.editor.copyqualifiedname.EditorCopyQualifiedName">
				<activeWhen>
					<reference definitionId="«name».Editor.opened" />
				</activeWhen>
			</handler>
			<handler
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.copyqualifiedname.OutlineCopyQualifiedNameHandler"
				commandId="org.eclipse.xtext.ui.editor.copyqualifiedname.OutlineCopyQualifiedName">
				<activeWhen>
					<and>
						<reference definitionId="«name».XtextEditor.opened" />
						<iterate>
							<adapt type="org.eclipse.xtext.ui.editor.outline.IOutlineNode" />
						</iterate>
					</and>
				</activeWhen>
			</handler>
		</extension>
		<extension point="org.eclipse.core.expressions.definitions">
			<definition id="«name».Editor.opened">
				<and>
					<reference definitionId="isActiveEditorAnInstanceOfXtextEditor"/>
					<with variable="activeEditor">
						<test property="org.eclipse.xtext.ui.editor.XtextEditor.languageName"
							value="«name»"
							forcePluginActivation="true"/>
					</with>
				</and>
			</definition>
			<definition id="«name».XtextEditor.opened">
				<and>
					<reference definitionId="isXtextEditorActive"/>
					<with variable="activeEditor">
						<test property="org.eclipse.xtext.ui.editor.XtextEditor.languageName"
							value="«name»"
							forcePluginActivation="true"/>
					</with>
				</and>
			</definition>
		</extension>
		<extension
				point="org.eclipse.ui.preferencePages">
			<page
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage"
				id="«name»"
				name="«simpleName»">
				<keywordReference id="«namespace + ".ui.keyword_"+simpleName»"/>
			</page>
			<page
				category="«name»"
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.syntaxcoloring.SyntaxColoringPreferencePage"
				id="«name».coloring"
				name="Syntax Coloring">
				<keywordReference id="«namespace + ".ui.keyword_"+simpleName»"/>
			</page>
			<page
				category="«name»"
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage"
				id="«name».templates"
				name="Templates">
				<keywordReference id="«namespace + ".ui.keyword_"+simpleName»"/>
			</page>
		</extension>
		<extension
				point="org.eclipse.ui.propertyPages">
			<page
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage"
				id="«name»"
				name="«simpleName»">
				<keywordReference id="«namespace + ".ui.keyword_"+simpleName»"/>
				<enabledWhen>
					<adapt type="org.eclipse.core.resources.IProject"/>
				</enabledWhen>
				<filter name="projectNature" value="org.eclipse.xtext.ui.shared.xtextNature"/>
			</page>
		</extension>
		<extension
			point="org.eclipse.ui.keywords">
			<keyword
				id="«namespace + ".ui.keyword_"+simpleName»"
				label="«simpleName»"/>
		</extension>
		<extension
			point="org.eclipse.ui.commands">
			<command
				description="Trigger expensive validation"
				id="«name».validate"
				name="Validate">
			</command>
			<!-- copy qualified name -->
			<command
				id="org.eclipse.xtext.ui.editor.copyqualifiedname.EditorCopyQualifiedName"
				categoryId="org.eclipse.ui.category.edit"
				description="Copy the qualified name for the selected element"
				name="Copy Qualified Name">
			</command>
			<command
				id="org.eclipse.xtext.ui.editor.copyqualifiedname.OutlineCopyQualifiedName"
				categoryId="org.eclipse.ui.category.edit"
				description="Copy the qualified name for the selected element"
				name="Copy Qualified Name">
			</command>
		</extension>
		<extension point="org.eclipse.ui.menus">
			<menuContribution
				locationURI="popup:#TextEditorContext?after=group.edit">
				<command
					commandId="«name».validate"
					style="push"
					tooltip="Trigger expensive validation">
					<visibleWhen checkEnabled="false">
						<reference
							definitionId="«name».Editor.opened">
						</reference>
					</visibleWhen>
				</command>
			</menuContribution>
			<!-- copy qualified name -->
			<menuContribution locationURI="popup:#TextEditorContext?after=copy">
				<command commandId="org.eclipse.xtext.ui.editor.copyqualifiedname.EditorCopyQualifiedName"
					style="push" tooltip="Copy Qualified Name">
					<visibleWhen checkEnabled="false">
						<reference definitionId="«name».Editor.opened" />
					</visibleWhen>
				</command>
			</menuContribution>
			<menuContribution locationURI="menu:edit?after=copy">
				<command commandId="org.eclipse.xtext.ui.editor.copyqualifiedname.EditorCopyQualifiedName"
					style="push" tooltip="Copy Qualified Name">
					<visibleWhen checkEnabled="false">
						<reference definitionId="«name».Editor.opened" />
					</visibleWhen>
				</command>
			</menuContribution>
			<menuContribution locationURI="popup:org.eclipse.xtext.ui.outline?after=additions">
				<command commandId="org.eclipse.xtext.ui.editor.copyqualifiedname.OutlineCopyQualifiedName"
					style="push" tooltip="Copy Qualified Name">
					<visibleWhen checkEnabled="false">
						<and>
							<reference definitionId="«name».XtextEditor.opened" />
							<iterate>
								<adapt type="org.eclipse.xtext.ui.editor.outline.IOutlineNode" />
							</iterate>
						</and>
					</visibleWhen>
				</command>
			</menuContribution>
		</extension>
		<extension point="org.eclipse.ui.menus">
			<menuContribution locationURI="popup:#TextEditorContext?endof=group.find">
				<command commandId="org.eclipse.xtext.ui.editor.FindReferences">
					<visibleWhen checkEnabled="false">
						<reference definitionId="«name».Editor.opened">
						</reference>
					</visibleWhen>
				</command>
			</menuContribution>
		</extension>
		<extension point="org.eclipse.ui.handlers">
			<handler
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler"
				commandId="org.eclipse.xtext.ui.editor.FindReferences">
				<activeWhen>
					<reference
						definitionId="«name».Editor.opened">
					</reference>
				</activeWhen>
			</handler>
		</extension>
		<extension point="org.eclipse.core.contenttype.contentTypes">
			<content-type
				base-type="org.eclipse.core.runtime.text"
				file-extensions="«language.fileExtensions.join(",")»"
				id="«name».contenttype"
				name="«it.simpleName» File"
				priority="normal">
			</content-type>
		</extension>
	'''
	
}
