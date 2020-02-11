/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.MergeableManifest2
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess
import org.eclipse.xtext.xtext.generator.model.TextFileAccess
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig

/**
 * The Xtext language infrastructure generator. Use the {@code configuration} block to add general
 * configuration for your Xtext project and the generated code, e.g.
 * <pre>
 * configuration = {
 *     project = model.project.StandardProjectConfig {
 *         baseName = "org.example.language"
 *         rootPath = ".."
 *     }
 *     code = {
 *         encoding = 'ISO-8859-1'
 *     }
 * }
 * </pre>
 * You can generate code for one or more Xtext languages within the same project. For each language,
 * add a {@code language} block, e.g.
 * <pre>
 * language = StandardLanguage {
 *     name = "org.example.language.MyExampleLanguage"
 * }
 * </pre>
 * 
 * @noextend This class should not be extended by clients.
 */
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
	
	@Accessors
	String grammarEncoding
	
	Injector injector
	
	@Inject IXtextProjectConfig projectConfig
	
	@Inject XtextGeneratorTemplates templates
	
	@Inject XtextGeneratorNaming naming
	
	@Inject CodeConfig codeConfig
	
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
			initializeEncoding
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
	
	protected def initializeEncoding() {
		val serviceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE
		val serviceProvider = serviceProviderRegistry.extensionToFactoryMap.get('xtext') as IResourceServiceProvider
		val encoding = grammarEncoding ?: configuration.code.encoding
		if (serviceProvider !== null && encoding !== null) {
			val encodingProvider = serviceProvider.get(IEncodingProvider)
			if (encodingProvider instanceof IEncodingProvider.Runtime)
				encodingProvider.defaultEncoding = encoding
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
		try {
			cleaner.clean
			for (language : languageConfigs) {
				try {
					LOG.info('Generating ' + language.grammar.name)
					language.generate
					language.generateSetups
					language.generateModules
					language.generateExecutableExtensionFactory
				} catch(Exception e) {
					handleException(e, issues)
				}
			}
			LOG.info('Generating common infrastructure')
			generatePluginXmls
			generateManifests
			generateActivator
			generateServices
		} catch (Exception e) {
			handleException(e, issues)
		}
	}
	
	private def void handleException(Exception ex, org.eclipse.emf.mwe.core.issues.Issues issues) {
		if (ex instanceof CompositeGeneratorException) {
			ex.exceptions.forEach[handleException(issues)]
		} else {
			issues.addError(this, "GeneratorException: ", null, ex, null)
		}
	}
	
	protected def generateSetups(IXtextGeneratorLanguage language) {
		templates.createRuntimeGenSetup(language).writeTo(projectConfig.runtime.srcGen)
		templates.createRuntimeSetup(language).writeTo(projectConfig.runtime.src)
		templates.createIdeSetup(language).writeTo(projectConfig.genericIde.src)
		templates.createWebSetup(language).writeTo(projectConfig.web.src)
	}
	
	protected def generateModules(IXtextGeneratorLanguage language) {
		templates.createRuntimeGenModule(language).writeTo(projectConfig.runtime.srcGen)
		templates.createRuntimeModule(language).writeTo(projectConfig.runtime.src)
		templates.createIdeModule(language).writeTo(projectConfig.genericIde.src)
		templates.createIdeGenModule(language).writeTo(projectConfig.genericIde.srcGen)
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
				if (manifest.activator === null && manifest === projectConfig.eclipsePlugin.manifest) {
					manifest.activator = naming.eclipsePluginActivator
				}
				
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
			val merge = new MergeableManifest2(in, manifest.bundleName)
			merge.lineDelimiter = codeConfig.lineDelimiter
			merge.addExportedPackages(manifest.exportedPackages)
			merge.addRequiredBundles(manifest.requiredBundles)
			merge.addImportedPackages(manifest.importedPackages)
			
			if (manifest.activator !== null && merge.bundleActivator.isNullOrEmpty) {
				merge.bundleActivator = manifest.activator.name
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
	
	protected def void generateServices() {
		if (projectConfig.genericIde.srcGen === null || languageConfigs.empty) {
			return
		}
		val file = new TextFileAccess()
		file.path = "META-INF/services/org.eclipse.xtext.ISetup"
		file.content = '''
			«FOR lang : languageConfigs»
				«naming.getGenericIdeSetup(lang.grammar)»
			«ENDFOR»
		'''
		file.writeTo(projectConfig.genericIde.srcGen)
	}
	
	protected def void generateActivator() {
		if (projectConfig.eclipsePlugin.srcGen !== null && !languageConfigs.empty)
			templates.createEclipsePluginActivator(projectConfig, languageConfigs).writeTo(projectConfig.eclipsePlugin.srcGen)
	}
	
	protected def void generatePluginXmls() {
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
					&& root.readTextFile(pluginXml.path)?.toString != pluginXml.getContentString
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
