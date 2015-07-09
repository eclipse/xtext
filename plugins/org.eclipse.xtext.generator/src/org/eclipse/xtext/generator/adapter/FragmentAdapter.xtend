/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.adapter

import com.google.common.collect.Maps
import com.google.inject.Inject
import com.google.inject.Injector
import java.io.File
import java.util.List
import java.util.Map
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xpand2.XpandExecutionContextImpl
import org.eclipse.xpand2.output.Outlet
import org.eclipse.xpand2.output.PostProcessor
import org.eclipse.xtend.expression.Variable
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel
import org.eclipse.xtext.generator.Binding
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorFragment
import org.eclipse.xtext.generator.IGeneratorFragmentExtension
import org.eclipse.xtext.generator.IGeneratorFragmentExtension2
import org.eclipse.xtext.generator.IGeneratorFragmentExtension3
import org.eclipse.xtext.generator.IGeneratorFragmentExtension4
import org.eclipse.xtext.generator.LanguageConfig
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.NamingAware
import org.eclipse.xtext.generator.NewlineNormalizer
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.IGeneratorFragment2
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.LanguageConfig2
import org.eclipse.xtext.xtext.generator.XtextGenerator
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

/**
 * @since 2.9
 */
class FragmentAdapter implements IGeneratorFragment2 {
	
	@Inject IXtextProjectConfig projectConfig
	
	@Inject CodeConfig codeConfig
	
	@Inject IEncodingProvider encodingProvider
	
	@Accessors
	IGeneratorFragment fragment
	
	@Accessors
	Naming naming
	
	val List<PostProcessor> postProcessors = newArrayList
	
	def void addPostProcessor(PostProcessor postProcessor) {
		this.postProcessors.add(postProcessor)
	}
	
	override checkConfiguration(XtextGenerator generator, Issues issues) {
		if (naming === null)
			naming = createNaming(generator.languageConfigs.head)
		if (fragment === null)
			issues.addError(generator, 'The property \'fragment\' must be set.', this)
		else
			fragment.checkConfiguration(issues)
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
	}
	
	override generate(LanguageConfig2 config2) {
		if (naming === null)
			naming = createNaming(config2)
		val ctx = createExecutionContext()
		val config1 = createLanguageConfig(config2)
		if (fragment instanceof IGeneratorFragmentExtension2) {
			fragment.generate(config1, ctx)
		} else {
			fragment.generate(config1.grammar, ctx)
		}
		generateStandaloneSetup(config1, config2, ctx)
		generateGuiceModuleRt(config1, config2, ctx)
		generateGuiceModuleUi(config1, config2, ctx)
		generatePluginXmlRt(config1, ctx)
		generateManifestRt(config1, ctx)
		generatePluginXmlUi(config1, ctx)
		generateManifestUi(config1, ctx)
		generateManifestIde(config1, ctx)
		generateManifestTests(config1, ctx)
	}
	
	private def void generateStandaloneSetup(LanguageConfig config1, LanguageConfig2 config2, XpandExecutionContext ctx) {
		ctx.output.openFile(null, StringConcatOutputImpl.STRING_OUTLET)
		try {
			if (fragment instanceof IGeneratorFragmentExtension2) {
				fragment.addToStandaloneSetup(config1, ctx)
			} else {
				fragment.addToStandaloneSetup(config1.grammar, ctx)
			}
			val result = (ctx.output as StringConcatOutputImpl).stringOutlet
			config2.runtimeGenSetup.registrations += result.toString.decreaseIndentation(2)
			config2.runtimeGenSetup.imports += new TypeReference('org.eclipse.emf.ecore.EPackage')
			config2.runtimeGenSetup.imports += new TypeReference('org.eclipse.emf.ecore.resource.Resource')
		} finally {
			ctx.output.closeFile()
		}
	}
	
	private def generateGuiceModuleRt(LanguageConfig config1, LanguageConfig2 config2, XpandExecutionContext ctx) {
		val bindings = fragment.getGuiceBindingsRt(config1.grammar)
		if (bindings !== null)
			config2.runtimeGenModule.addAll(bindings.map[translateBinding])
		if (fragment instanceof IGeneratorFragmentExtension4) {
			val superClass = fragment.getDefaultRuntimeModuleClassName(config1.grammar)
			if (superClass !== null)
				config2.runtimeGenModule.superClass = new TypeReference(superClass)
		}
	}
	
	private def generateGuiceModuleUi(LanguageConfig config1, LanguageConfig2 config2, XpandExecutionContext ctx) {
		val bindings = fragment.getGuiceBindingsUi(config1.grammar)
		if (bindings !== null)
			config2.eclipsePluginGenModule.addAll(bindings.map[translateBinding])
		if (fragment instanceof IGeneratorFragmentExtension4) {
			val superClass = fragment.getDefaultUiModuleClassName(config1.grammar)
			if (superClass !== null)
				config2.eclipsePluginGenModule.superClass = new TypeReference(superClass)
		}
	}
	
	private def translateBinding(Binding it) {
		val newKey =
			if (value.statements === null || value.statements.empty)
				new GuiceModuleAccess.BindKey(null, key.type?.typeRef, key.singleton, key.eagerSingleton)
			else {
				val nameIndex = key.type.lastIndexOf('.')
				new GuiceModuleAccess.BindKey(key.type.substring(nameIndex + 1), null, key.singleton, key.eagerSingleton)
			}
		val newValue = new GuiceModuleAccess.BindValue(value.expression, value.typeName?.typeRef,
				value.provider, value.statements.map[s | if (s.endsWith(';')) s else s + ';'])
		new GuiceModuleAccess.Binding(newKey, newValue, final, contributedBy)
	}
	
	private def void generatePluginXmlRt(LanguageConfig config1, XpandExecutionContext ctx) {
		if (projectConfig.runtimePluginXml !== null) {
			ctx.output.openFile(null, StringConcatOutputImpl.STRING_OUTLET)
			try {
				if (fragment instanceof IGeneratorFragmentExtension2) {
					fragment.addToPluginXmlRt(config1, ctx)
				} else {
					fragment.addToPluginXmlRt(config1.grammar, ctx)
				}
				val result = (ctx.output as StringConcatOutputImpl).stringOutlet
				projectConfig.runtimePluginXml.entries += result.toString.decreaseIndentation(1)
			} finally {
				ctx.output.closeFile()
			}
		}
	}
	
	private def void generatePluginXmlUi(LanguageConfig config1, XpandExecutionContext ctx) {
		if (projectConfig.eclipsePluginPluginXml !== null) {
			ctx.output.openFile(null, StringConcatOutputImpl.STRING_OUTLET)
			try {
				if (fragment instanceof IGeneratorFragmentExtension2) {
					fragment.addToPluginXmlUi(config1, ctx)
				} else {
					fragment.addToPluginXmlUi(config1.grammar, ctx)
				}
				val result = (ctx.output as StringConcatOutputImpl).stringOutlet
				projectConfig.eclipsePluginPluginXml.entries += result.toString.decreaseIndentation(1)
			} finally {
				ctx.output.closeFile()
			}
		}
	}
	
	private def void generateManifestRt(LanguageConfig config1, XpandExecutionContext ctx) {
		if (projectConfig.runtimeManifest !== null) {
			val exported = fragment.getExportedPackagesRt(config1.grammar)
			if (exported !== null)
				projectConfig.runtimeManifest.exportedPackages.addAll(exported)
			val required = fragment.getRequiredBundlesRt(config1.grammar)
			if (required !== null)
				projectConfig.runtimeManifest.requiredBundles.addAll(required)
			val imported = fragment.getImportedPackagesRt(config1.grammar)
			if (imported !== null)
				projectConfig.runtimeManifest.importedPackages.addAll(imported)
		}
	}
	
	private def void generateManifestUi(LanguageConfig config1, XpandExecutionContext ctx) {
		if (projectConfig.eclipsePluginManifest !== null) {
			val exported = fragment.getExportedPackagesUi(config1.grammar)
			if (exported !== null)
				projectConfig.eclipsePluginManifest.exportedPackages.addAll(exported)
			val required = fragment.getRequiredBundlesUi(config1.grammar)
			if (required !== null)
				projectConfig.eclipsePluginManifest.requiredBundles.addAll(required)
			val imported = fragment.getImportedPackagesUi(config1.grammar)
			if (imported !== null)
				projectConfig.eclipsePluginManifest.importedPackages.addAll(imported)
		}
	}
	
	private def void generateManifestIde(LanguageConfig config1, XpandExecutionContext ctx) {
		if (fragment instanceof IGeneratorFragmentExtension3 && projectConfig.genericIdeManifest !== null) {
			val fr = fragment as IGeneratorFragmentExtension3
			val exported = fr.getExportedPackagesIde(config1.grammar)
			if (exported !== null)
				projectConfig.genericIdeManifest.exportedPackages.addAll(exported)
			val required = fr.getRequiredBundlesIde(config1.grammar)
			if (required !== null)
				projectConfig.genericIdeManifest.requiredBundles.addAll(required)
			val imported = fr.getImportedPackagesIde(config1.grammar)
			if (imported !== null)
				projectConfig.genericIdeManifest.importedPackages.addAll(imported)
		}
	}
	
	private def void generateManifestTests(LanguageConfig config1, XpandExecutionContext ctx) {
		if (fragment instanceof IGeneratorFragmentExtension && projectConfig.runtimeTestManifest !== null) {
			val fr = fragment as IGeneratorFragmentExtension
			val exported = fr.getExportedPackagesTests(config1.grammar)
			if (exported !== null)
				projectConfig.runtimeTestManifest.exportedPackages.addAll(exported)
			val required = fr.getRequiredBundlesTests(config1.grammar)
			if (required !== null)
				projectConfig.runtimeTestManifest.requiredBundles.addAll(required)
			val imported = fr.getImportedPackagesTests(config1.grammar)
			if (imported !== null)
				projectConfig.runtimeTestManifest.importedPackages.addAll(imported)
		}
	}
	
	protected def Naming createNaming(LanguageConfig2 config2) {
		val result = new Naming => [
			projectNameRt = projectConfig.runtimeManifest?.pluginPath.lastSegment
			projectNameIde = projectConfig.genericIdeManifest?.pluginPath.lastSegment
			projectNameUi = projectConfig.eclipsePluginManifest?.pluginPath.lastSegment
			ideBasePackage = config2.naming.genericIdeBasePackage
			uiBasePackage = config2.naming.eclipsePluginBasePackage
			activatorName = config2.naming.eclipsePluginActivator.name
			pathTestProject = projectConfig.runtimeTestManifest?.pluginPath
			lineDelimiter = codeConfig.lineDelimiter
			fileHeader = codeConfig.fileHeader
			classAnnotations = codeConfig.classAnnotationsAsString
			annotationImports = codeConfig.annotationImportsAsString
			hasUI = projectNameUi !== null
			hasIde = projectNameIde !== null
			grammarId = config2.grammar.name
		]
		if (fragment instanceof NamingAware)
			fragment.registerNaming(result)
		return result
	}
	
	protected def LanguageConfig createLanguageConfig(LanguageConfig2 config2) {
		val config = new LanguageConfig
		for (resource : config2.loadedResources) {
			config.addLoadedResource(resource)
		}
		config.forcedResourceSet = config2.resourceSet
		config.fileExtensions = config2.fileExtensions.join(',')
		config.uri = config2.uri
		config.registerNaming(naming)
		return config
	}

	protected def XpandExecutionContext createExecutionContext() {
		val encoding = encodingProvider.getEncoding(null)
		val output = new StringConcatOutputImpl

		if (projectConfig.runtimeManifest !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_RT, false, projectConfig.runtimeManifest.pluginPath))
		if (projectConfig.runtimeSrc !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC, false, projectConfig.runtimeSrc.path))
		if (projectConfig.runtimeSrcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN, true, projectConfig.runtimeSrcGen.path))
		if (projectConfig.runtimeManifest !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.MODEL, false, projectConfig.runtimeManifest.pluginPath + "/model"))
		if (projectConfig.eclipsePluginManifest !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_UI, false, projectConfig.eclipsePluginManifest.pluginPath))
		if (projectConfig.eclipsePluginSrc !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_UI, false, projectConfig.eclipsePluginSrc.path))
		if (projectConfig.eclipsePluginSrcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_UI, true, projectConfig.eclipsePluginSrcGen.path))
		if (projectConfig.genericIdeManifest !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_IDE, false, projectConfig.genericIdeManifest.pluginPath))
		if (projectConfig.genericIdeSrc !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_IDE, false, projectConfig.genericIdeSrc.path))
		if (projectConfig.genericIdeSrcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, projectConfig.genericIdeSrcGen.path))
		if (projectConfig.runtimeTestManifest !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_TEST, false, projectConfig.runtimeTestManifest.pluginPath))
		if (projectConfig.runtimeTestSrc !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_TEST, false, projectConfig.runtimeTestSrc.path))
		if (projectConfig.runtimeTestSrcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_TEST, true, projectConfig.runtimeTestSrcGen.path))
		val Map<String, Variable> globalVars = Maps.newHashMap
		globalVars.put(Naming.GLOBAL_VAR_NAME, new Variable(Naming.GLOBAL_VAR_NAME, naming))

		var execCtx = new XpandExecutionContextImpl(output, null, globalVars, null, null)
		execCtx.getResourceManager().setFileEncoding('ISO-8859-1')
		execCtx.registerMetaModel(new JavaBeansMetaModel())
		execCtx = execCtx.cloneWithVariable(new Variable('modelPluginID', naming.projectNameRt)) as XpandExecutionContextImpl
		return execCtx
	}

	protected def Outlet createOutlet(boolean append, String encoding, String name, boolean overwrite, String path) {
		val outlet = new Outlet(append, encoding, name, overwrite, path)
		outlet.addPostprocessor(new NewlineNormalizer(codeConfig.lineDelimiter))
		for (PostProcessor pp : postProcessors) {
			outlet.addPostprocessor(pp)
		}
		return outlet;
	}

	protected def String getPath(IFileSystemAccess2 fsa) {
		val path = fsa.getURI('').toFileString
		if (path.endsWith(File.separator))
			return path.substring(0, path.length - 1)
		else
			return path
	}
	
	protected def String getPluginPath(ManifestAccess manifest) {
		val metaInfIndex = manifest.path.indexOf('/META-INF')
		return manifest.path.substring(0, metaInfIndex)
	}
	
	private def getLastSegment(String path) {
		path?.substring(path.lastIndexOf('/') + 1)
	}
	
	private def decreaseIndentation(String text, int level) {
		val result = new StringBuilder(text.length)
		var newLine = true
		var skippedSpaces = 0
		var skippedTabs = 0
		for (var i = 0; i < text.length; i++) {
			val c = text.charAt(i)
			var append = false
			if (c.matches('\n', '\r')) {
				newLine = true
				append = true
				skippedTabs = 0
				skippedSpaces = 0
			} else if (newLine) {
				if (c.matches(' ')) {
					skippedSpaces++
					if (skippedSpaces >= 4) {
						skippedSpaces = 0
						skippedTabs++
					}
				} else if (c.matches('\t')) {
					skippedSpaces = 0
					skippedTabs++
				} else {
					newLine = false
					append = true
				}
				if (skippedTabs >= level) {
					newLine = false
				}
			} else {
				append = true
			}
			
			if (append)
				result.append(c)
		}
		return result
	}
	
	private def matches(char c, char... m) {
		for (var i = 0; i < m.length; i++) {
			if (c == m.get(i))
				return true
		}
		return false
	}
	
}
															