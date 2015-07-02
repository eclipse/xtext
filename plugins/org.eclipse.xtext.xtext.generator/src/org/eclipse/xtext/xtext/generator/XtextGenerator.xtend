/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Injector
import java.io.File
import java.util.List
import org.eclipse.emf.mwe.core.WorkflowContext
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.xtext.generator.model.CodeConfig
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.model.TextFileAccess

/**
 * The Xtext language infrastructure generator. Can be configured with {@link IGeneratorFragment}
 * instances as well as with some properties declared via setter or adder methods.
 * 
 * <p><b>NOTE: This is a reimplementation of org.eclipse.xtext.generator.Generator</b></p>
 */
class XtextGenerator extends AbstractWorkflowComponent2 implements IGuiceAwareGeneratorComponent {

	@Accessors
	DefaultGeneratorModule configuration
	
	@Accessors
	String activator
	
	val List<LanguageConfig2> languageConfigs = newArrayList
	
	Injector injector
	
	@Inject IXtextProjectConfig projectConfig
	
	@Inject XtextGeneratorTemplates templates
	
	@Inject IEncodingProvider encodingProvider
	
	new() {
		new XtextStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
	
	/**
	 * Add a language configuration to be included in the code generation process.
	 */
	def void addLanguage(LanguageConfig2 language) {
		this.languageConfigs.add(language)
	}
	
	protected def Injector createInjector() {
		if (injector === null) {
			if (configuration === null)
				configuration = new DefaultGeneratorModule
			injector = Guice.createInjector(configuration)
			initialize(injector)
		}
		return injector
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
		projectConfig.initialize(injector)
		injector.getInstance(CodeConfig) => [ codeConfig |
			codeConfig.initialize(injector)
		]
		injector.getInstance(XtextGeneratorNaming) => [ naming |
			naming.eclipsePluginActivator = activator
		]
	}
	
	protected override invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		val injector = createInjector()
		for (language : languageConfigs) {
			language.initialize(injector)
			language.generate(language)
			language.generateRuntimeSetup()
			language.generateModules()
			language.generateExecutableExtensionFactory()
		}
		generatePluginXmls()
		generateManifests()
	}
	
	protected def generateRuntimeSetup(LanguageConfig2 language) {
		templates.getRuntimeSetup(language).writeTo(projectConfig.runtimeSrc)
		templates.finishRuntimeGenSetup(language.runtimeSetup).writeTo(projectConfig.runtimeSrcGen)
	}
	
	protected def generateModules(LanguageConfig2 language) {
		templates.getRuntimeModule(language).writeTo(projectConfig.runtimeSrc)
		templates.finishGenModule(language.runtimeModule).writeTo(projectConfig.runtimeSrcGen)
		if (projectConfig.eclipsePluginSrc !== null)
			templates.getEclipsePluginModule(language).writeTo(projectConfig.eclipsePluginSrc)
		if (projectConfig.eclipsePluginSrcGen !== null)
			templates.finishGenModule(language.eclipsePluginModule).writeTo(projectConfig.eclipsePluginSrcGen)
	}
	
	protected def generateExecutableExtensionFactory(LanguageConfig2 language) {
		if (projectConfig.eclipsePluginSrcGen !== null)
			templates.getEclipsePluginExecutableExtensionFactory(language).writeTo(projectConfig.eclipsePluginSrcGen)
	}
	
	protected def generateManifests() {
		projectConfig.runtimeManifest?.generate()
		projectConfig.runtimeTestManifest?.generate()
		projectConfig.genericIdeManifest?.generate()
		projectConfig.genericIdeTestManifest?.generate()
		projectConfig.eclipsePluginManifest?.generate()
		projectConfig.eclipsePluginTestManifest?.generate()
		projectConfig.ideaPluginManifest?.generate()
		projectConfig.ideaPluginTestManifest?.generate()
		projectConfig.webManifest?.generate()
		projectConfig.webTestManifest?.generate()
	}
	
	protected def generatePluginXmls() {
		generatePluginXml(projectConfig.runtimePluginXml, encodingProvider)
		generatePluginXml(projectConfig.runtimeTestPluginXml, encodingProvider)
		generatePluginXml(projectConfig.genericIdePluginXml, encodingProvider)
		generatePluginXml(projectConfig.genericIdeTestPluginXml, encodingProvider)
		generatePluginXml(projectConfig.eclipsePluginPluginXml, encodingProvider)
		generatePluginXml(projectConfig.eclipsePluginTestPluginXml, encodingProvider)
		generatePluginXml(projectConfig.ideaPluginPluginXml, encodingProvider)
		generatePluginXml(projectConfig.ideaPluginTestPluginXml, encodingProvider)
		generatePluginXml(projectConfig.webPluginXml, encodingProvider)
		generatePluginXml(projectConfig.webTestPluginXml, encodingProvider)
	}
	
	protected def generatePluginXml(TextFileAccess pluginXml, IEncodingProvider encodingProvider) {
		if (pluginXml !== null) {
			pluginXml.encodingProvider = encodingProvider
			if (new File(pluginXml.path).exists) {
				if (pluginXml.path.endsWith('.xml')) {
					pluginXml.path = pluginXml.path + '_gen'
					pluginXml.writeToFile()
				}
			} else {
				pluginXml.writeToFile()
			}
		}
	}
	
}