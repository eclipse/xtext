/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Module
import java.util.List
import org.eclipse.emf.mwe.core.WorkflowContext
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.xtext.generator.model.CodeConfig
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.model.XtextProjectConfig

/**
 * The Xtext language infrastructure generator. Can be configured with {@link IGeneratorFragment}
 * instances as well as with some properties declared via setter or adder methods.
 * 
 * <p><b>NOTE: This is a reimplementation of org.eclipse.xtext.generator.Generator</b></p>
 */
class XtextGenerator extends AbstractWorkflowComponent2 {
	
	@Accessors
	XtextProjectConfig projectConfig
	
	@Accessors
	CodeConfig codeConfig
	
	val List<Module> modules = newArrayList
	
	val List<LanguageConfig2> languageConfigs = newArrayList
	
	new() {
		new XtextStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
	
	/**
	 * Add a language configuration to be included in the code generation process.
	 */
	def void addLanguage(LanguageConfig2 language) {
		this.languageConfigs.add(language)
	}
	
	/**
	 * Add Guice modules to customize the behavior of the generator.
	 */
	def void addModule(Module module) {
		this.modules.add(module)
	}
	
	protected override invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		var IXtextProjectConfig project = projectConfig
		for (language : languageConfigs) {
			val injector = language.createInjector()
			language.generate()
			if (project === null)
				project = injector.getInstance(IXtextProjectConfig)
		}
		if (project !== null) {
			project.generateManifests()
			project.generatePluginXmls()
			project.generateModules()
		}
	}
	
	protected def generateManifests(IXtextProjectConfig project) {
		project.runtimeManifest?.generate()
		project.runtimeTestManifest?.generate()
		project.genericIdeManifest?.generate()
		project.genericIdeTestManifest?.generate()
		project.eclipsePluginManifest?.generate()
		project.eclipsePluginTestManifest?.generate()
		project.ideaPluginManifest?.generate()
		project.ideaPluginTestManifest?.generate()
		project.webManifest?.generate()
		project.webTestManifest?.generate()
	}
	
	protected def generatePluginXmls(IXtextProjectConfig project) {
		project.runtimePluginXml?.generate()
		project.runtimeTestPluginXml?.generate()
		project.genericIdePluginXml?.generate()
		project.genericIdeTestPluginXml?.generate()
		project.eclipsePluginPluginXml?.generate()
		project.eclipsePluginTestPluginXml?.generate()
		project.ideaPluginPluginXml?.generate()
		project.ideaPluginTestPluginXml?.generate()
		project.webPluginXml?.generate()
		project.webTestPluginXml?.generate()
	}
	
	protected def generateModules(IXtextProjectConfig project) {
		project.runtimeModule?.generate()
		project.runtimeTestModule?.generate()
		project.genericIdeModule?.generate()
		project.genericIdeTestModule?.generate()
		project.eclipsePluginModule?.generate()
		project.eclipsePluginTestModule?.generate()
		project.ideaPluginModule?.generate()
		project.ideaPluginTestModule?.generate()
		project.webModule?.generate()
		project.webTestModule?.generate()
	}
	
	protected def Injector createInjector(LanguageConfig2 languageConfig) {
		val guiceConfig = <Module>newArrayList(new DefaultGeneratorModule)
		guiceConfig.addAll(modules)
		guiceConfig.add([
			bind(LanguageConfig2).toInstance(languageConfig)
		])
		if (projectConfig !== null) {
			guiceConfig.add([
				bind(IXtextProjectConfig).toInstance(projectConfig)
			])
		}
		if (codeConfig !== null) {
			guiceConfig.add([
				bind(CodeConfig).toInstance(codeConfig)
			])
		}
		val injector = Guice.createInjector(Modules2.mixin(guiceConfig))
		
		injector.injectMembers(languageConfig)
		languageConfig.initialize()
		if (projectConfig !== null) {
			injector.injectMembers(projectConfig)
			projectConfig.initialize()
		}
		if (codeConfig !== null) {
			injector.injectMembers(codeConfig)
			codeConfig.initialize()
		}
		return injector
	}
	
}