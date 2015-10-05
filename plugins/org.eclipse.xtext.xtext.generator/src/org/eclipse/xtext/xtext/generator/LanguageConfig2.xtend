/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.common.base.Joiner
import com.google.common.collect.Lists
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Module
import com.google.inject.Provider
import java.util.Collections
import java.util.HashMap
import java.util.List
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.common.util.WrappedException
import org.eclipse.emf.ecore.EValidator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.mwe2.runtime.Mandatory
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.ReferencedMetamodel
import org.eclipse.xtext.XtextPackage
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.containers.IAllContainersState
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.xtext.RuleNames
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

@Log
class LanguageConfig2 extends CompositeGeneratorFragment2 implements ILanguageConfig {
	
	@Accessors(PUBLIC_GETTER)
	String uri
	
	@Accessors(PUBLIC_GETTER)
	Grammar grammar
	
	@Accessors(PUBLIC_GETTER)
	RuleNames ruleNames
	
	@Accessors(PUBLIC_GETTER)
	List<String> fileExtensions
	
	@Accessors
	ResourceSet resourceSet
	
	@Accessors
	Module guiceModule = [] 
	
	@Accessors
	val List<String> loadedResources = newArrayList
	
	@Accessors
	val runtimeGenSetup = new StandaloneSetupAccess
	
	@Accessors
	val runtimeGenModule = new GuiceModuleAccess
	
	@Accessors
	val eclipsePluginGenModule = new GuiceModuleAccess
	
	@Accessors
	val ideaGenModule = new GuiceModuleAccess
	
	@Accessors
	val webGenModule = new GuiceModuleAccess
	
	@Inject Provider<ResourceSet> resourceSetProvider
	
	@Inject IXtextProjectConfig projectConfig
	
	@Inject extension XbaseUsageDetector
	
	@Inject extension XtextGeneratorNaming naming
	
	@Mandatory
	def void setUri(String uri) {
		this.uri = uri
	}
	
	def void setFileExtensions(String fileExtensions) {
		this.fileExtensions = fileExtensions.trim.split('\\s*,\\s*').toList
	}
	
	override getFileExtensions() {
		if (fileExtensions === null || fileExtensions.empty) {
			val lowerCase = GrammarUtil.getSimpleName(grammar).toLowerCase
			LOG.info("No explicit fileExtensions configured. Using '*." + lowerCase + "'.")
			return Collections.singletonList(lowerCase)
		}
		return fileExtensions
	}
	
	def void addLoadedResource(String uri) {
		this.loadedResources.add(uri)
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
		if (resourceSet === null)
			resourceSet = resourceSetProvider.get()
		for (String loadedResource : loadedResources) {
			val loadedResourceUri = URI.createURI(loadedResource)
			switch (loadedResourceUri.fileExtension) {
				case 'genmodel': {
					val resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResourceUri)
					if (resourceServiceProvider === null) {
						try {
							val genModelSupport = Class.forName('org.eclipse.emf.codegen.ecore.xtext.GenModelSupport')
							val instance = genModelSupport.newInstance()
							genModelSupport.getDeclaredMethod('createInjectorAndDoEMFRegistration').invoke(instance)
						} catch (ClassNotFoundException e) {
							LOG.error("Couldn't initialize GenModel support. Is it on the classpath?")
							LOG.debug(e.getMessage(), e)
						} catch (Exception e) {
							LOG.error("Couldn't initialize GenModel support.", e)
						}
					}
				}
				case 'ecore': {
					val resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResourceUri)
					if (resourceServiceProvider === null) {
						EcoreSupportStandaloneSetup.setup()
					}
				}
				case 'xcore': {
					val resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResourceUri)
					if (resourceServiceProvider === null) {
						try {
							val xcore = Class.forName('org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup')
							xcore.getDeclaredMethod('doSetup', #[]).invoke(null)
						} catch (ClassNotFoundException e) {
							LOG.error("Couldn't initialize Xcore support. Is it on the classpath?")
							LOG.debug(e.getMessage(), e)
						} catch (Exception e) {
							LOG.error("Couldn't initialize Xcore support.", e)
						}
					}
					val xcoreLangURI = URI.createPlatformResourceURI('/org.eclipse.emf.ecore.xcore.lib/model/XcoreLang.xcore', true)
					try {
						resourceSet.getResource(xcoreLangURI, true)
					} catch (WrappedException e) {
						LOG.error("Could not load XcoreLang.xcore.", e)
						val brokenResource = resourceSet.getResource(xcoreLangURI, false)
						resourceSet.resources.remove(brokenResource)
					}
				}
			}
			resourceSet.getResource(loadedResourceUri, true)
			
		}
		if (!resourceSet.resources.isEmpty) {
			installIndex()
			for (var i = 0, var size = resourceSet.resources.size; i < size; i++) {
				val res = resourceSet.resources.get(i)
				if (res.getContents().isEmpty())
					LOG.error("Error loading '" + res.getURI() + "'")
				else if (!res.getErrors().isEmpty())
					LOG.error("Error loading '" + res.getURI() + "':\n" + Joiner.on('\n').join(res.getErrors()))	
			}
			EcoreUtil.resolveAll(resourceSet)
		}
		val resource = resourceSet.getResource(URI.createURI(uri), true) as XtextResource
		if (resource.contents.isEmpty) {
			throw new IllegalArgumentException("Couldn't load grammar for '" + uri + "'.")
		}
		if (!resource.errors.isEmpty) {
			LOG.error(resource.errors)
			throw new IllegalStateException("Problem parsing '" + uri + "':\n" + Joiner.on('\n').join(resource.getErrors()))
		}

		val grammar = resource.contents.get(0) as Grammar
		validateGrammar(grammar)
		this.grammar = grammar
		this.ruleNames = RuleNames.getRuleNames(grammar, true)
		for (fragment : fragments) {
			fragment.initialize(injector)
		}
	}
	
	private def void installIndex() {
		val index = new ResourceDescriptionsData(Collections.emptyList)
		val resources = Lists.newArrayList(resourceSet.resources)
		for (resource : resources) {
			index(resource, resource.URI, index)
		}
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index)
	}

	private def void index(Resource resource, URI uri, ResourceDescriptionsData index) {
		val serviceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri)
		if (serviceProvider != null) {
			val resourceDescription = serviceProvider.resourceDescriptionManager.getResourceDescription(resource)
			if (resourceDescription != null) {
				index.addDescription(uri, resourceDescription)
			}
		}
	}
	
	protected def void validateGrammar(Grammar grammar) {
		validateAllImports(grammar)
		val validator = EValidator.Registry.INSTANCE.getEValidator(XtextPackage.eINSTANCE)
		if (validator !== null) {
			val chain = new DiagnosticChain() {

				override add(Diagnostic diagnostic) {
					if (diagnostic.severity == Diagnostic.ERROR) {
						if (diagnostic.exception == null)
							throw new IllegalStateException(diagnostic.message)
						else
							throw new IllegalStateException(diagnostic.message, diagnostic.exception)
					}
				}

				override addAll(Diagnostic diagnostic) {
					add(diagnostic)
				}

				override merge(Diagnostic diagnostic) {
					throw new UnsupportedOperationException
				}
			}
			validator.validate(grammar, chain, null)
			val iterator = grammar.eAllContents
			while (iterator.hasNext) {
				validator.validate(iterator.next, chain, new HashMap);
			}
		}
	}
	
	protected def void validateAllImports(Grammar grammar) {
		for (amd : GrammarUtil.allMetamodelDeclarations(grammar)) {
			if (amd instanceof ReferencedMetamodel)
				validateReferencedMetamodel(amd)
		}
	}

	protected def void validateReferencedMetamodel(ReferencedMetamodel ref) {
		if (ref.EPackage != null && !ref.EPackage.eIsProxy) {
			return
		}
		val eref = XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE
		val nodes = NodeModelUtils.findNodesForFeature(ref, eref)
		val refName = if (nodes.empty) '(unknown)' else NodeModelUtils.getTokenText(nodes.get(0))
		val grammarName = GrammarUtil.getGrammar(ref).name
		val msg = "The EPackage " + refName + " in grammar " + grammarName + " could not be found. "
			+ "You might want to register that EPackage in your workflow file."
		throw new IllegalStateException(msg)
	}
	
	override generate() {
		addImplicitContributions()
		super.generate()
	}
	
	protected def void addImplicitContributions() {
		//TODO move this logic into its own class
		if (projectConfig.runtimeManifest !== null) {
			projectConfig.runtimeManifest.requiredBundles.addAll(#[
				'org.eclipse.xtext', 'org.eclipse.xtext.util', 'org.eclipse.xtend.lib'
			])
			projectConfig.runtimeManifest.importedPackages.add('org.apache.log4j')
		}
		if (projectConfig.eclipsePluginManifest !== null) {
			projectConfig.eclipsePluginManifest.requiredBundles.addAll(#[
				'org.eclipse.xtext.ui', 'org.eclipse.xtext.ui.shared', 'org.eclipse.ui.editors', 'org.eclipse.ui', 'org.eclipse.xtend.lib'
			])
		}
		if (projectConfig.eclipsePluginPluginXml !== null) {
			projectConfig.eclipsePluginPluginXml.entries += grammar.implicitPluginXmlEnties
		}
		
		val StringConcatenationClient expression = '''«'org.eclipse.xtext.ui.shared.Access'.typeRef».getJavaProjectsState()'''
		val bindingFactory = new GuiceModuleAccess.BindingFactory()
			.addTypeToProviderInstance(IAllContainersState.typeRef, expression)
		if (inheritsXbase(grammar)) {
			bindingFactory.addTypeToType('org.eclipse.xtext.ui.editor.XtextEditor'.typeRef,
					'org.eclipse.xtext.xbase.ui.editor.XbaseEditor'.typeRef)
				.addTypeToType('org.eclipse.xtext.ui.editor.model.XtextDocumentProvider'.typeRef,
					'org.eclipse.xtext.xbase.ui.editor.XbaseDocumentProvider'.typeRef)
				.addTypeToType('org.eclipse.xtext.ui.generator.trace.OpenGeneratedFileHandler'.typeRef,
					'org.eclipse.xtext.xbase.ui.generator.trace.XbaseOpenGeneratedFileHandler'.typeRef)
		}
		bindingFactory.contributeTo(eclipsePluginGenModule)
	}
	
	def getImplicitPluginXmlEnties(Grammar it) '''
		<extension
			point="org.eclipse.ui.editors">
			<editor
				class="«eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.editor.XtextEditor"
				contributorClass="org.eclipse.ui.editors.text.TextEditorActionContributor"
				default="true"
				extensions="«fileExtensions.join(",")»"
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
			!-- copy qualified name -->
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
	'''
	
}