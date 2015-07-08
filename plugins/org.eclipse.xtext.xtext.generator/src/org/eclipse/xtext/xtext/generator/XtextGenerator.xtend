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
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.HashMap
import java.util.List
import org.eclipse.emf.mwe.core.WorkflowContext
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.util.MergeableManifest
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

/**
 * The Xtext language infrastructure generator. Can be configured with {@link IGeneratorFragment}
 * instances as well as with some properties declared via setter or adder methods.
 * 
 * <p><b>NOTE: This is a reimplementation of org.eclipse.xtext.generator.Generator</b></p>
 */
@Log
class XtextGenerator extends AbstractWorkflowComponent2 implements IGuiceAwareGeneratorComponent {

	@Accessors
	DefaultGeneratorModule configuration
	
	@Accessors
	val List<LanguageConfig2> languageConfigs = newArrayList
	
	Injector injector
	
	@Inject IXtextProjectConfig projectConfig
	
	@Inject XtextGeneratorTemplates templates
	
	new() {
		new XtextStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
	
	/**
	 * Add a language configuration to be included in the code generation process.
	 */
	def void addLanguage(LanguageConfig2 language) {
		this.languageConfigs.add(language)
	}
	
	override protected checkConfigurationInternal(Issues issues) {
		createInjector()
		if (configuration !== null) {
			configuration.checkConfiguration(this, issues)
		}
		val uris = new HashMap<String, Grammar>
		for (language : languageConfigs) {
			language.checkConfiguration(this, issues)
			for (generatedMetamodel : EcoreUtil2.typeSelect(language.grammar.metamodelDeclarations, GeneratedMetamodel)) {
				val nsURI = generatedMetamodel.EPackage.nsURI
				if (uris.containsKey(nsURI)) {
					issues.addError(this, "Duplicate generated grammar with nsURI '" + nsURI + "' in "
							+ uris.get(nsURI).name + " and " + language.grammar.name)
				} else {
					uris.put(nsURI, language.grammar)
				}
			}
		}
	}
	
	protected def Injector createInjector() {
		if (injector === null) {
			LOG.info('Initializing Xtext generator')
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
		for (language : languageConfigs) {
			language.initialize(injector)
		}
		injector.getInstance(CodeConfig) => [ codeConfig |
			codeConfig.initialize(injector)
		]
	}
	
	protected override invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		createInjector()
		for (language : languageConfigs) {
			LOG.info('Generating ' + language.grammar.name)
			language.generate(language)
			language.generateRuntimeSetup()
			language.generateModules()
			language.generateExecutableExtensionFactory()
		}
		LOG.info('Generating common infrastructure')
		generatePluginXmls()
		generateManifests()
		generateActivator()
	}
	
	protected def generateRuntimeSetup(LanguageConfig2 language) {
		templates.createRuntimeGenSetup(language).writeTo(projectConfig.runtimeSrcGen)
		if (!projectConfig.runtimeSrc.isFile(language.naming.runtimeSetup.path))
			templates.createRuntimeSetup(language).writeTo(projectConfig.runtimeSrc)
	}
	
	protected def generateModules(LanguageConfig2 language) {
		templates.createRuntimeGenModule(language).writeTo(projectConfig.runtimeSrcGen)
		if (!projectConfig.runtimeSrc.isFile(language.naming.runtimeModule.path))
			templates.createRuntimeModule(language).writeTo(projectConfig.runtimeSrc)
		if (projectConfig.eclipsePluginSrcGen !== null)
			templates.createEclipsePluginGenModule(language).writeTo(projectConfig.eclipsePluginSrcGen)
		if (projectConfig.eclipsePluginSrc !== null && !projectConfig.eclipsePluginSrc.isFile(language.naming.eclipsePluginModule.path))
			templates.createEclipsePluginModule(language).writeTo(projectConfig.eclipsePluginSrc)
	}
	
	protected def generateExecutableExtensionFactory(LanguageConfig2 language) {
		if (projectConfig.eclipsePluginSrcGen !== null)
			templates.createEclipsePluginExecutableExtensionFactory(language).writeTo(projectConfig.eclipsePluginSrcGen)
	}
	
	protected def generateManifests() {
		val manifests = #{
			projectConfig.runtimeManifest,
			projectConfig.runtimeTestManifest,
			projectConfig.genericIdeManifest,
			projectConfig.genericIdeTestManifest,
			projectConfig.eclipsePluginManifest,
			projectConfig.eclipsePluginTestManifest,
			projectConfig.ideaPluginManifest,
			projectConfig.ideaPluginTestManifest,
			projectConfig.webManifest,
			projectConfig.webTestManifest
		}
		manifests.filterNull.sortBy[path].forEach[ manifest |
			if (manifest.bundleName === null) {
				val segments = manifest.path.split('/')
				if (segments.length >= 3 && segments.get(segments.length - 2) == 'META-INF')
					manifest.bundleName = segments.get(segments.length - 3)
			}
			var TypeReference activator
			if (manifest === projectConfig.eclipsePluginManifest) {
				activator = languageConfigs.head?.naming?.eclipsePluginActivator
			}
			val file = new File(manifest.path)
			if (file.exists) {
				if (manifest.merge) {
					mergeManifest(manifest, file, activator)
				} else if (manifest.path.endsWith('.MF')) {
					manifest.path = manifest.path + '_gen'
					templates.createManifest(manifest, activator).writeToFile()
				}
			} else {
				templates.createManifest(manifest, activator).writeToFile()
			}
		]
	}

	protected def mergeManifest(ManifestAccess manifest, File file, TypeReference activator) throws IOException {
		var InputStream in
		var OutputStream out
		try {
			in = new FileInputStream(file)
			val merge = new MergeableManifest(in, manifest.bundleName)
			merge.addExportedPackages(manifest.exportedPackages)
			merge.addRequiredBundles(manifest.requiredBundles)
			merge.addImportedPackages(manifest.importedPackages)
			if (activator !== null && !merge.mainAttributes.containsKey(MergeableManifest.BUNDLE_ACTIVATOR)) {
				merge.mainAttributes.put(MergeableManifest.BUNDLE_ACTIVATOR, activator.name)
			}
			if (merge.isModified) {
				out = new FileOutputStream(file)
				merge.write(out)
			}
		} finally {
			if (in !== null)
				in.close()
			if (out != null)
				out.close()
		}
	}
	
	protected def generateActivator() {
		if (projectConfig.eclipsePluginSrcGen !== null && !languageConfigs.empty)
			templates.createEclipsePluginActivator(languageConfigs).writeTo(projectConfig.eclipsePluginSrcGen)
	}
	
	protected def generatePluginXmls() {
		val pluginXmls = #{
			projectConfig.runtimePluginXml,
			projectConfig.runtimeTestPluginXml,
			projectConfig.genericIdePluginXml,
			projectConfig.genericIdeTestPluginXml,
			projectConfig.eclipsePluginPluginXml,
			projectConfig.eclipsePluginTestPluginXml,
			projectConfig.ideaPluginPluginXml,
			projectConfig.ideaPluginTestPluginXml,
			projectConfig.webPluginXml,
			projectConfig.webTestPluginXml
		}
		pluginXmls.filterNull.sortBy[path].forEach[ pluginXml |
			if (new File(pluginXml.path).exists) {
				if (pluginXml.path.endsWith('.xml')) {
					pluginXml.path = pluginXml.path + '_gen'
					templates.createPluginXml(pluginXml).writeToFile()
				}
			} else {
				templates.createPluginXml(pluginXml).writeToFile()
			}
		]
	}
	
}