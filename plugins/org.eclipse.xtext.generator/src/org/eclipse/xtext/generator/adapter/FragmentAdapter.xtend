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
import com.google.inject.Provider
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xpand2.XpandExecutionContextImpl
import org.eclipse.xpand2.output.Outlet
import org.eclipse.xpand2.output.PostProcessor
import org.eclipse.xtend.expression.Variable
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.generator.Binding
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorFragment
import org.eclipse.xtext.generator.IGeneratorFragmentExtension2
import org.eclipse.xtext.generator.LanguageConfig
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.NewlineNormalizer
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.xtext.generator.IGeneratorFragment2
import org.eclipse.xtext.xtext.generator.LanguageConfig2
import org.eclipse.xtext.xtext.generator.model.CodeConfig
import org.eclipse.xtext.xtext.generator.model.FileSystemAccess
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.model.ManifestAccess

class FragmentAdapter implements IGeneratorFragment2 {
	
	@Inject IXtextProjectConfig projectConfig
	
	@Inject CodeConfig codeConfig
	
	@Inject IEncodingProvider encodingProvider
	
	@Inject Provider<ResourceSet> resourceSetProvider
	
	@Accessors
	IGeneratorFragment fragment
	
	@Accessors
	Naming naming
	
	val List<PostProcessor> postProcessors = newArrayList
	
	def void addPostProcessor(PostProcessor postProcessor) {
		this.postProcessors.add(postProcessor)
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
			config2.runtimeSetup.codeFragments += result
		} finally {
			ctx.output.closeFile()
		}
	}
	
	private def generateGuiceModuleRt(LanguageConfig config1, LanguageConfig2 config2, XpandExecutionContext ctx) {
		config2.runtimeModule.bindings.addAll(fragment.getGuiceBindingsRt(config1.grammar).map[translateBinding])
	}
	
	private def generateGuiceModuleUi(LanguageConfig config1, LanguageConfig2 config2, XpandExecutionContext ctx) {
		config2.eclipsePluginModule.bindings.addAll(fragment.getGuiceBindingsUi(config1.grammar).map[translateBinding])
	}
	
	private def translateBinding(Binding it) {
		val newKey = new GuiceModuleAccess.BindKey(key.type, key.singleton, key.eagerSingleton)
		val newValue = new GuiceModuleAccess.BindValue(value.expression, value.typeName, value.provider, value.statements)
		new GuiceModuleAccess.Binding(newKey, newValue, contributedBy, final)
	}
	
	private def void generatePluginXmlRt(LanguageConfig config1, XpandExecutionContext ctx) {
		ctx.output.openFile(null, StringConcatOutputImpl.STRING_OUTLET)
		try {
			if (fragment instanceof IGeneratorFragmentExtension2) {
				fragment.addToPluginXmlRt(config1, ctx)
			} else {
				fragment.addToPluginXmlRt(config1.grammar, ctx)
			}
			val result = (ctx.output as StringConcatOutputImpl).stringOutlet
			projectConfig.runtimePluginXml.codeFragments += result
		} finally {
			ctx.output.closeFile()
		}
	}
	
	protected def Naming createNaming(LanguageConfig2 config2) {
		return new Naming => [
			projectNameRt = projectConfig.runtimeManifest?.pluginPath
			projectNameIde = projectConfig.genericIdeManifest?.pluginPath
			projectNameUi = projectConfig.eclipsePluginManifest?.pluginPath
			if (projectNameIde === null && projectNameUi !== null)
				ideBasePackage = projectNameUi
			else
				ideBasePackage = projectNameIde
			uiBasePackage = projectNameUi
			activatorName = getActivator(config2.grammar)
			pathTestProject = projectConfig.runtimeTestManifest.pluginPath
			fileHeader = codeConfig.fileHeader
			classAnnotations = codeConfig.classAnnotationsAsString
			annotationImports = codeConfig.annotationImportsAsString
			hasUI = projectNameUi !== null
			hasIde = projectNameIde !== null
		]
	}
	
	protected def LanguageConfig createLanguageConfig(LanguageConfig2 config2) {
		val config = new LanguageConfig
		for (resource : config2.loadedResources) {
			config.addLoadedResource(resource)
		}
		config.forcedResourceSet = resourceSetProvider.get
		config.fileExtensions = config2.fileExtensions.join(',')
		config.uri = config2.uri
		config.registerNaming(naming)
		return config
	}

	protected def XpandExecutionContext createExecutionContext() {
		val encoding = encodingProvider.getEncoding(null)
		val output = new StringConcatOutputImpl

		output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_RT, false, naming.projectNameRt))
		if (projectConfig.runtimeSrc !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC, false, projectConfig.runtimeSrc.path))
		if (projectConfig.runtimeSrcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN, true, projectConfig.runtimeSrcGen.path))
		output.addOutlet(createOutlet(false, encoding, Generator.MODEL, false, naming.projectNameRt + "/model"))
		if (naming.projectNameUi !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_UI, false, naming.projectNameUi))
		if (projectConfig.eclipsePluginSrc !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_UI, false, projectConfig.eclipsePluginSrc.path))
		if (projectConfig.eclipsePluginSrcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_UI, true, projectConfig.eclipsePluginSrcGen.path))
		if (naming.projectNameIde !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_IDE, false, naming.projectNameIde))
		if (projectConfig.genericIdeSrc !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_IDE, false, projectConfig.genericIdeSrc.path))
		if (projectConfig.genericIdeSrcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, projectConfig.genericIdeSrcGen.path))
		if (naming.pathTestProject !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_TEST, false, naming.pathTestProject))
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

	protected def String getActivator(Grammar grammar) {
		return naming.basePackageUi(grammar) + '.internal.' + GrammarUtil.getName(grammar) + 'Activator'
	}
	
	protected def String getPath(IFileSystemAccess2 fsa) {
		if (fsa instanceof FileSystemAccess)
			return fsa.path
		else
			return fsa.getURI('').toPlatformString(true)
	}
	
	protected def String getPluginPath(ManifestAccess manifest) {
		val metaInfIndex = manifest.path.indexOf('/META-INF')
		return manifest.path.substring(0, metaInfIndex)
	}
	
}
															