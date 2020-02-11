/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.adapter

import com.google.common.collect.Maps
import com.google.inject.Inject
import java.io.File
import java.util.List
import java.util.Map
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
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.Issues
import org.eclipse.xtext.xtext.generator.MweIssues
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.guessTypeRef

/**
 * @since 2.9
 * 
 * @deprecated please rewrite your fragment with the new generator infrastructure.
 */
@Deprecated
class FragmentAdapter extends AbstractXtextGeneratorFragment {
	
	@Inject CodeConfig codeConfig
	
	@Inject IEncodingProvider encodingProvider
	
	@Inject extension XtextGeneratorNaming
	
	@Accessors
	IGeneratorFragment fragment
	
	@Accessors
	Naming naming
	
	val List<PostProcessor> postProcessors = newArrayList
	
	new() {
	}
	
	new(IGeneratorFragment fragment) {
		setFragment(fragment)
	}
	
	def void addPostProcessor(PostProcessor postProcessor) {
		this.postProcessors.add(postProcessor)
	}
	
	override checkConfiguration(Issues issues) {
		if (naming === null)
			naming = createNaming()
		if (fragment === null)
			issues.addError('The property \'fragment\' must be set.', this)
		else
			fragment.checkConfiguration((issues as MweIssues).delegate)
	}
	
	override generate() {
		if (naming === null)
			naming = createNaming()
		val ctx = createExecutionContext()
		val config1 = createLanguageConfig()
		if (fragment instanceof IGeneratorFragmentExtension2) {
			fragment.generate(config1, ctx)
		} else {
			fragment.generate(config1.grammar, ctx)
		}
		generateStandaloneSetup(config1, ctx)
		generateGuiceModuleRt(config1, ctx)
		generateGuiceModuleUi(config1, ctx)
		generatePluginXmlRt(config1, ctx)
		generateManifestRt(config1, ctx)
		generatePluginXmlUi(config1, ctx)
		generateManifestUi(config1, ctx)
		generateManifestIde(config1, ctx)
		generateManifestTests(config1, ctx)
	}
	
	private def void generateStandaloneSetup(LanguageConfig config1, XpandExecutionContext ctx) {
		ctx.output.openFile(null, StringConcatOutputImpl.STRING_OUTLET)
		try {
			val config2 = language
			if (fragment instanceof IGeneratorFragmentExtension2) {
				fragment.addToStandaloneSetup(config1, ctx)
			} else {
				fragment.addToStandaloneSetup(config1.grammar, ctx)
			}
			val result = (ctx.output as StringConcatOutputImpl).stringOutlet
			config2.runtimeGenSetup.registrations.add('''«result.toString.decreaseIndentation(2)»''')
			config2.runtimeGenSetup.imports += new TypeReference('org.eclipse.emf.ecore.EPackage')
			config2.runtimeGenSetup.imports += new TypeReference('org.eclipse.emf.ecore.resource.Resource')
		} finally {
			ctx.output.closeFile()
		}
	}
	
	private def generateGuiceModuleRt(LanguageConfig config1, XpandExecutionContext ctx) {
		val config2 = language
		val bindings = fragment.getGuiceBindingsRt(config1.grammar)
		if (bindings !== null)
			config2.runtimeGenModule.addAll(bindings.map[translateBinding])
		if (fragment instanceof IGeneratorFragmentExtension4) {
			val superClass = fragment.getDefaultRuntimeModuleClassName(config1.grammar)
			if (superClass !== null)
				config2.runtimeGenModule.superClass = new TypeReference(superClass)
		}
	}
	
	private def generateGuiceModuleUi(LanguageConfig config1, XpandExecutionContext ctx) {
		val config2 = language
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
				new GuiceModuleAccess.BindKey(null, key.type?.guessTypeRef, key.singleton, key.eagerSingleton)
			else
				new GuiceModuleAccess.BindKey(key.type.className, null, key.singleton, key.eagerSingleton)
		val newValue = new GuiceModuleAccess.BindValue(value.expression, value.typeName?.guessTypeRef,
				value.provider, value.statements.map[s | if (s.endsWith(';')) s else s + ';'])
		new GuiceModuleAccess.Binding(newKey, newValue, final, contributedBy)
	}
	
	private def getClassName(String qualifiedName) {
		var classStart = qualifiedName.length
		for (var i = qualifiedName.length - 1; i >= 0; i--) {
			if (qualifiedName.charAt(i).matches('.')) {
				if (Character.isLowerCase(qualifiedName.charAt(i + 1)))
					return qualifiedName.substring(classStart)
				else
					classStart = i + 1
			}
		}
		return qualifiedName
	}
	
	private def void generatePluginXmlRt(LanguageConfig config1, XpandExecutionContext ctx) {
		if (projectConfig.runtime.pluginXml !== null) {
			ctx.output.openFile(null, StringConcatOutputImpl.STRING_OUTLET)
			try {
				if (fragment instanceof IGeneratorFragmentExtension2) {
					fragment.addToPluginXmlRt(config1, ctx)
				} else {
					fragment.addToPluginXmlRt(config1.grammar, ctx)
				}
				val result = (ctx.output as StringConcatOutputImpl).stringOutlet
				val entry = result.toString.decreaseIndentation(1)
				if (!entry.toString.trim.isEmpty)
					projectConfig.runtime.pluginXml.entries += entry 
			} finally {
				ctx.output.closeFile()
			}
		}
	}
	
	private def void generatePluginXmlUi(LanguageConfig config1, XpandExecutionContext ctx) {
		if (projectConfig.eclipsePlugin.pluginXml !== null) {
			ctx.output.openFile(null, StringConcatOutputImpl.STRING_OUTLET)
			try {
				if (fragment instanceof IGeneratorFragmentExtension2) {
					fragment.addToPluginXmlUi(config1, ctx)
				} else {
					fragment.addToPluginXmlUi(config1.grammar, ctx)
				}
				val result = (ctx.output as StringConcatOutputImpl).stringOutlet
				val entry = result.toString.decreaseIndentation(1)
				if (!entry.toString.trim.isEmpty)
					projectConfig.eclipsePlugin.pluginXml.entries += entry
			} finally {
				ctx.output.closeFile()
			}
		}
	}
	
	private def void generateManifestRt(LanguageConfig config1, XpandExecutionContext ctx) {
		if (projectConfig.runtime.manifest !== null) {
			val exported = fragment.getExportedPackagesRt(config1.grammar)
			if (exported !== null)
				projectConfig.runtime.manifest.exportedPackages.addAll(exported)
			val required = fragment.getRequiredBundlesRt(config1.grammar)
			if (required !== null)
				projectConfig.runtime.manifest.requiredBundles.addAll(required)
			val imported = fragment.getImportedPackagesRt(config1.grammar)
			if (imported !== null)
				projectConfig.runtime.manifest.importedPackages.addAll(imported)
		}
	}
	
	private def void generateManifestUi(LanguageConfig config1, XpandExecutionContext ctx) {
		if (projectConfig.eclipsePlugin.manifest !== null) {
			val exported = fragment.getExportedPackagesUi(config1.grammar)
			if (exported !== null)
				projectConfig.eclipsePlugin.manifest.exportedPackages.addAll(exported)
			val required = fragment.getRequiredBundlesUi(config1.grammar)
			if (required !== null)
				projectConfig.eclipsePlugin.manifest.requiredBundles.addAll(required)
			val imported = fragment.getImportedPackagesUi(config1.grammar)
			if (imported !== null)
				projectConfig.eclipsePlugin.manifest.importedPackages.addAll(imported)
		}
	}
	
	private def void generateManifestIde(LanguageConfig config1, XpandExecutionContext ctx) {
		if (fragment instanceof IGeneratorFragmentExtension3 && projectConfig.genericIde.manifest !== null) {
			val fr = fragment as IGeneratorFragmentExtension3
			val exported = fr.getExportedPackagesIde(config1.grammar)
			if (exported !== null)
				projectConfig.genericIde.manifest.exportedPackages.addAll(exported)
			val required = fr.getRequiredBundlesIde(config1.grammar)
			if (required !== null)
				projectConfig.genericIde.manifest.requiredBundles.addAll(required)
			val imported = fr.getImportedPackagesIde(config1.grammar)
			if (imported !== null)
				projectConfig.genericIde.manifest.importedPackages.addAll(imported)
		}
	}
	
	private def void generateManifestTests(LanguageConfig config1, XpandExecutionContext ctx) {
		if (fragment instanceof IGeneratorFragmentExtension && projectConfig.runtimeTest.manifest !== null) {
			val fr = fragment as IGeneratorFragmentExtension
			val exported = fr.getExportedPackagesTests(config1.grammar)
			if (exported !== null)
				projectConfig.runtimeTest.manifest.exportedPackages.addAll(exported)
			val required = fr.getRequiredBundlesTests(config1.grammar)
			if (required !== null)
				projectConfig.runtimeTest.manifest.requiredBundles.addAll(required)
			val imported = fr.getImportedPackagesTests(config1.grammar)
			if (imported !== null)
				projectConfig.runtimeTest.manifest.importedPackages.addAll(imported)
		}
	}
	
	protected def Naming createNaming() {
		val config2 = language
		val result = new Naming => [
			projectNameRt = projectConfig.runtime.root?.path.lastSegment
			projectNameIde = projectConfig.genericIde.root?.path.lastSegment
			projectNameUi = projectConfig.eclipsePlugin.root?.path.lastSegment
			ideBasePackage = config2.grammar.genericIdeBasePackage
			uiBasePackage = config2.grammar.eclipsePluginBasePackage
			activatorName = eclipsePluginActivator?.name
			pathTestProject = projectConfig.runtimeTest.root?.path
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
	
	protected def LanguageConfig createLanguageConfig() {
		val config2 = language as XtextGeneratorLanguage
		val config = new LanguageConfig
		config.forcedResourceSet = config2.resourceSet
		config.fileExtensions = config2.fileExtensions.join(',')
		config.uri = config2.grammarUri
		config.registerNaming(naming)
		return config
	}

	protected def XpandExecutionContext createExecutionContext() {
		val encoding = encodingProvider.getEncoding(null)
		val output = new StringConcatOutputImpl

		if (projectConfig.runtime.root !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_RT, false, projectConfig.runtime.root.path))
		if (projectConfig.runtime.src !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC, false, projectConfig.runtime.src.path))
		if (projectConfig.runtime.srcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN, true, projectConfig.runtime.srcGen.path))
		if (projectConfig.runtime.root !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.MODEL, false, projectConfig.runtime.root.path + "/model"))
		if (projectConfig.eclipsePlugin.root !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_UI, false, projectConfig.eclipsePlugin.root.path))
		else if (projectConfig.runtime.root !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_UI, false, projectConfig.runtime.root.path))
		if (projectConfig.eclipsePlugin.src !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_UI, false, projectConfig.eclipsePlugin.src.path))
		else if (projectConfig.runtime.src !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_UI, false, projectConfig.runtime.src.path))
		if (projectConfig.eclipsePlugin.srcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_UI, true, projectConfig.eclipsePlugin.srcGen.path))
		else if (projectConfig.runtime.srcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_UI, true, projectConfig.runtime.srcGen.path))
		if (projectConfig.genericIde.root !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_IDE, false, projectConfig.genericIde.root.path))
		else if (projectConfig.eclipsePlugin.root !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_IDE, false, projectConfig.eclipsePlugin.root.path))
		else if (projectConfig.runtime.root !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_IDE, false, projectConfig.runtime.root.path))
		if (projectConfig.genericIde.src !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_IDE, false, projectConfig.genericIde.src.path))
		else if (projectConfig.eclipsePlugin.src !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_IDE, false, projectConfig.eclipsePlugin.src.path))
		else if (projectConfig.runtime.src !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_IDE, false, projectConfig.runtime.src.path))
		if (projectConfig.genericIde.srcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, projectConfig.genericIde.srcGen.path))
		else if (projectConfig.eclipsePlugin.srcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, projectConfig.eclipsePlugin.srcGen.path))
		else if (projectConfig.runtime.srcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, projectConfig.runtime.srcGen.path))
		if (projectConfig.runtimeTest.root !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_TEST, false, projectConfig.runtimeTest.root.path))
		else if (projectConfig.runtime.root !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_TEST, false, projectConfig.runtime.root.path))
		if (projectConfig.runtimeTest.src !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_TEST, false, projectConfig.runtimeTest.src.path))
		else if (projectConfig.runtime.src !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_TEST, false, projectConfig.runtime.src.path))
		if (projectConfig.runtimeTest.srcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_TEST, true, projectConfig.runtimeTest.srcGen.path))
		else if (projectConfig.runtime.srcGen !== null)
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_TEST, true, projectConfig.runtime.srcGen.path))
		val Map<String, Variable> globalVars = Maps.newHashMap
		globalVars.put(Naming.GLOBAL_VAR_NAME, new Variable(Naming.GLOBAL_VAR_NAME, naming))

		var execCtx = new XpandExecutionContextImpl(output, null, globalVars, null, null)
		execCtx.resourceManager.setFileEncoding('ISO-8859-1')
		execCtx.registerMetaModel(new JavaBeansMetaModel)
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
															