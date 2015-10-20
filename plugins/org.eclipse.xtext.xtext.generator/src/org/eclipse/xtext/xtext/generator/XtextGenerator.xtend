/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.common.collect.Maps
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Injector
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.HashMap
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.mwe.core.WorkflowContext
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.util.MergeableManifest
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess

/**
 * The Xtext language infrastructure generator. Can be configured with {@link IXtextGeneratorFragment}
 * instances as well as with some properties declared via setter or adder methods.
 * 
 * <p><b>NOTE: This is a reimplementation of org.eclipse.xtext.generator.Generator</b></p>
 */
 //TODO make Generator independent of mwe and add a thin wrapper (GeneratorComponent)
 //TODO only implement mwe2.IWorkflowComponent, get rid of "Issues", just logging/exceptions?
@Log
class XtextGenerator extends AbstractWorkflowComponent2 {

	@Accessors
	DefaultGeneratorModule configuration = new DefaultGeneratorModule
	
	@Accessors
	val List<XtextGeneratorLanguage> languageConfigs = newArrayList
	
	@Accessors
	XtextDirectoryCleaner cleaner = new XtextDirectoryCleaner
	
	@Accessors
	XtextGeneratorStandaloneSetup standaloneSetup = new XtextGeneratorStandaloneSetup
	
	Injector injector
	
	@Inject IXtextProjectConfig projectConfig
	
	@Inject XtextGeneratorTemplates templates
	
	@Inject XtextGeneratorNaming naming
	
	new() {
		new XtextStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
	
	/**
	 * Add a language configuration to be included in the code generation process.
	 */
	def void addLanguage(XtextGeneratorLanguage language) {
		this.languageConfigs.add(language)
	}
	
	override protected checkConfigurationInternal(org.eclipse.emf.mwe.core.issues.Issues issues) {
		initialize
		val generatorIssues = new MweIssues(this, issues)
		configuration.checkConfiguration(generatorIssues)
		val uris = new HashMap<String, Grammar>
		for (language : languageConfigs) {
			language.checkConfiguration(generatorIssues)
			for (generatedMetamodel : language.grammar.metamodelDeclarations.filter(GeneratedMetamodel)) {
				val nsURI = generatedMetamodel.EPackage.nsURI
				if (uris.containsKey(nsURI)) {
					generatorIssues.addError("Duplicate generated grammar with nsURI '" + nsURI + "' in "
							+ uris.get(nsURI).name + " and " + language.grammar.name)
				} else {
					uris.put(nsURI, language.grammar)
				}
			}
		}
	}
	
	def void initialize() {
		if (injector === null) {
			LOG.info('Initializing Xtext generator')
			new StandaloneSetup().addRegisterGeneratedEPackage('org.eclipse.xtext.common.types.TypesPackage')
			injector = createInjector
			injector.injectMembers(this)
			injector.getInstance(CodeConfig) => [initialize(injector)]
			projectConfig.initialize(injector)
			cleaner.initialize(injector)
			standaloneSetup.initialize(injector)
			for (language : languageConfigs) {
				val languageInjector = injector.createLanguageInjector(language)
				language.initialize(languageInjector)
			}
		}
	}
	
	protected def Injector createInjector() {
		Guice.createInjector(configuration)
	}
	
	protected def Injector createLanguageInjector(Injector parent, XtextGeneratorLanguage language) {
		parent.createChildInjector(new LanguageModule(language))
	}
	
	protected override invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, org.eclipse.emf.mwe.core.issues.Issues issues) {
		initialize
		cleaner.clean
		for (language : languageConfigs) {
			LOG.info('Generating ' + language.grammar.name)
			language.generate
			language.generateSetups
			language.generateModules
			language.generateExecutableExtensionFactory
		}
		LOG.info('Generating common infrastructure')
		generatePluginXmls
		generateManifests
		generateActivator
	}
	
	protected def generateSetups(IXtextGeneratorLanguage language) {
		templates.createRuntimeGenSetup(language).writeTo(projectConfig.runtime.srcGen)
		templates.createRuntimeSetup(language).writeTo(projectConfig.runtime.src)
		templates.createWebSetup(language).writeTo(projectConfig.web.src)
	}
	
	protected def generateModules(IXtextGeneratorLanguage language) {
		templates.createRuntimeGenModule(language).writeTo(projectConfig.runtime.srcGen)
		templates.createRuntimeModule(language).writeTo(projectConfig.runtime.src)
		templates.createEclipsePluginGenModule(language).writeTo(projectConfig.eclipsePlugin.srcGen)
		templates.createEclipsePluginModule(language).writeTo(projectConfig.eclipsePlugin.src)
		templates.createIdeaGenModule(language).writeTo(projectConfig.ideaPlugin.srcGen)
		templates.createIdeaModule(language).writeTo(projectConfig.ideaPlugin.src)
		templates.createWebGenModule(language).writeTo(projectConfig.web.srcGen)
		templates.createWebModule(language).writeTo(projectConfig.web.src)
	}
	
	protected def generateExecutableExtensionFactory(IXtextGeneratorLanguage language) {
		if (projectConfig.eclipsePlugin.srcGen !== null)
			templates.createEclipsePluginExecutableExtensionFactory(language, languageConfigs.head).writeTo(projectConfig.eclipsePlugin.srcGen)
	}
	
	protected def generateManifests() {
		val manifests = projectConfig.enabledProjects.filter(BundleProjectConfig)
			.map[Tuples.create(manifest, metaInf, name)].toList
		// Filter null values and merge duplicate entries
		val uri2Manifest = Maps.<URI, ManifestAccess>newHashMapWithExpectedSize(manifests.size)
		val manifestIter = manifests.listIterator
		while (manifestIter.hasNext) {
			val entry = manifestIter.next
			val manifest = entry.first
			val metaInf = entry.second
			if (manifest === null || metaInf === null) {
				manifestIter.remove()
			} else {
				val uri = metaInf.getURI(manifest.path)
				if (uri2Manifest.containsKey(uri)) {
					uri2Manifest.get(uri).merge(manifest)
					manifestIter.remove()
				} else {
					uri2Manifest.put(uri, manifest)
				}
			}
		}
		
		for (entry : manifests) {
			val manifest = entry.first
			val metaInf = entry.second
			if (manifest.bundleName === null) {
				manifest.bundleName = entry.third
			}
			if (manifest === projectConfig.eclipsePlugin.manifest) {
				val firstLanguage = languageConfigs.head
				manifest.activator = naming?.getEclipsePluginActivator(firstLanguage.grammar)
			}
			if (metaInf.isFile(manifest.path)) {
				if (manifest.merge) {
					mergeManifest(manifest, metaInf)
				} else if (manifest.path.endsWith('.MF')) {
					manifest.path = manifest.path + '_gen'
					manifest.writeTo(metaInf)
				}
			} else {
				manifest.writeTo(metaInf)
			}
		}
	}

	protected def mergeManifest(ManifestAccess manifest, IXtextGeneratorFileSystemAccess metaInf) throws IOException {
		var InputStream in
		try {
			in = metaInf.readBinaryFile(manifest.path)
			val merge = new MergeableManifest(in, manifest.bundleName)
			merge.addExportedPackages(manifest.exportedPackages)
			merge.addRequiredBundles(manifest.requiredBundles)
			merge.addImportedPackages(manifest.importedPackages)
			if (manifest.activator !== null && !merge.mainAttributes.containsKey(MergeableManifest.BUNDLE_ACTIVATOR)) {
				merge.mainAttributes.put(MergeableManifest.BUNDLE_ACTIVATOR, manifest.activator.name)
			}
			if (merge.isModified) {
				val out = new ByteArrayOutputStream
				merge.write(out)
				metaInf.generateFile(manifest.path, new ByteArrayInputStream(out.toByteArray))
			}
		} finally {
			if (in !== null)
				in.close()
		}
	}
	
	protected def generateActivator() {
		if (projectConfig.eclipsePlugin.srcGen !== null && !languageConfigs.empty)
			templates.createEclipsePluginActivator(languageConfigs).writeTo(projectConfig.eclipsePlugin.srcGen)
	}
	
	protected def generatePluginXmls() {
		val pluginXmls = projectConfig.enabledProjects.filter(BundleProjectConfig).map[pluginXml -> root].toList
		// Filter null values and merge duplicate entries
		val uri2PluginXml = Maps.<URI, PluginXmlAccess>newHashMapWithExpectedSize(pluginXmls.size)
		val pluginXmlIter = pluginXmls.listIterator
		while (pluginXmlIter.hasNext) {
			val entry = pluginXmlIter.next
			val pluginXml = entry.key
			val root = entry.value
			if (pluginXml === null || root === null) {
				pluginXmlIter.remove()
			} else {
				val uri = root.getURI(pluginXml.path)
				if (uri2PluginXml.containsKey(uri)) {
					uri2PluginXml.get(uri).merge(pluginXml)
					pluginXmlIter.remove()
				} else {
					uri2PluginXml.put(uri, pluginXml)
				}
			}
		}
		
		for (entry : pluginXmls) {
			val pluginXml = entry.key
			val root = entry.value
			if (root.isFile(pluginXml.path)) { 
				// only write plugin.xml_gen if entries exist and content differs
				if (!pluginXml.entries.isEmpty
					&& root.readTextFile(pluginXml.path) != pluginXml.getContent 
					&& pluginXml.path.endsWith('.xml')) {
						pluginXml.path = pluginXml.path + '_gen'
						pluginXml.writeTo(root)
				}
			} else {
				pluginXml.writeTo(root)
			}
		}
	}
	
}