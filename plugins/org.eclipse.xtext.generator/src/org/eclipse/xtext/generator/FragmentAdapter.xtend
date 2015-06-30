/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator

import com.google.common.collect.Maps
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xpand2.XpandExecutionContextImpl
import org.eclipse.xpand2.output.Outlet
import org.eclipse.xpand2.output.OutputImpl
import org.eclipse.xpand2.output.PostProcessor
import org.eclipse.xtend.expression.Variable
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.xtext.generator.IGeneratorFragment2
import org.eclipse.xtext.xtext.generator.LanguageConfig2
import org.eclipse.xtext.xtext.generator.model.CodeConfig
import org.eclipse.xtext.xtext.generator.model.FileSystemAccess
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.model.ManifestAccess

class FragmentAdapter implements IGeneratorFragment2 {
	
	@Inject IXtextProjectConfig projectConfig
	
	@Inject LanguageConfig2 languageConfig2
	
	@Inject CodeConfig codeConfig
	
	@Inject IEncodingProvider encodingProvider
	
	@Inject Provider<ResourceSet> resourceSetProvider
	
	@Accessors
	IGeneratorFragment fragment
	
	val List<PostProcessor> postProcessors = newArrayList
	
	def void addPostProcessor(PostProcessor postProcessor) {
		this.postProcessors.add(postProcessor)
	}
	
	override generate() {
		val naming = createNaming()
		val ctx = createExecutionContext(naming)
		if (fragment instanceof IGeneratorFragmentExtension2) {
			val config = createLanguageConfig(naming)
			fragment.generate(config, ctx)
		} else {
			fragment.generate(languageConfig2.grammar, ctx)
		}
	}
	
	protected def Naming createNaming() {
		return new Naming => [
			projectNameRt = projectConfig.runtimeManifest?.pluginPath
			projectNameIde = projectConfig.genericIdeManifest?.pluginPath
			projectNameUi = projectConfig.eclipsePluginManifest?.pluginPath
			if (projectNameIde === null && projectNameUi !== null)
				ideBasePackage = projectNameUi
			else
				ideBasePackage = projectNameIde
			uiBasePackage = projectNameUi
			activatorName = getActivator
			pathTestProject = projectConfig.runtimeTestManifest.pluginPath
			fileHeader = codeConfig.fileHeader
			classAnnotations = codeConfig.classAnnotationsAsString
			annotationImports = codeConfig.annotationImportsAsString
			hasUI = projectNameUi !== null
			hasIde = projectNameIde !== null
		]
	}
	
	protected def LanguageConfig createLanguageConfig(Naming naming) {
		val config = new LanguageConfig
		for (resource : languageConfig2.loadedResources) {
			config.addLoadedResource(resource)
		}
		config.forcedResourceSet = resourceSetProvider.get
		config.fileExtensions = languageConfig2.fileExtensions.join(',')
		config.uri = languageConfig2.uri
		config.registerNaming(naming)
		return config
	}

	protected def XpandExecutionContext createExecutionContext(Naming naming) {
		val encoding = encodingProvider.getEncoding(null)
		val output = new OutputImpl

		val projectNameRt = projectConfig.runtimeManifest.pluginPath
		output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_RT, false, projectNameRt))
		output.addOutlet(createOutlet(false, encoding, Generator.SRC, false, projectConfig.runtimeSrc.path))
		output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN, true, projectConfig.runtimeSrcGen.path))
		output.addOutlet(createOutlet(false, encoding, Generator.MODEL, false, projectConfig.runtimeManifest.pluginPath + "/model"))
		if (projectConfig.eclipsePluginManifest !== null) {
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_UI, false, projectConfig.eclipsePluginManifest.pluginPath))
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_UI, false, projectConfig.eclipsePluginSrc.path))
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_UI, true, projectConfig.eclipsePluginSrcGen.path))
		}
		if (projectConfig.genericIdeManifest !== null) {
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_IDE, false, projectConfig.genericIdeManifest.pluginPath))
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_IDE, false, projectConfig.genericIdeSrc.path))
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, projectConfig.genericIdeSrcGen.path))
		}
		if (projectConfig.runtimeTestManifest !== null) {
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_TEST, false, projectConfig.runtimeTestManifest.pluginPath));
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_TEST, false, projectConfig.runtimeTestSrc.path));
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_TEST, true, projectConfig.runtimeTestSrcGen.path));
		}
		val Map<String, Variable> globalVars = Maps.newHashMap();
		globalVars.put(Naming.GLOBAL_VAR_NAME, new Variable(Naming.GLOBAL_VAR_NAME, naming))

		var execCtx = new XpandExecutionContextImpl(output, null, globalVars, null, null)
		execCtx.getResourceManager().setFileEncoding('ISO-8859-1')
		execCtx.registerMetaModel(new JavaBeansMetaModel())
		execCtx = execCtx.cloneWithVariable(new Variable('modelPluginID', projectNameRt)) as XpandExecutionContextImpl
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

	protected def String getActivator(Naming naming) {
		val grammar = languageConfig2.grammar
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