/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.generator

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Provider
import com.google.inject.name.Names
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.generator.GeneratorDelegate
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.Issues
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.generator.GeneratorContext

class GeneratorFragment2 extends AbstractStubGeneratingFragment {
	
	@Inject CodeConfig codeConfig
	
	@Inject FileAccessFactory fileAccessFactory
	
	@Inject extension XtextGeneratorNaming
	@Inject extension XbaseUsageDetector
	
	@Accessors(PUBLIC_SETTER)
	boolean generateMwe = false
	
	@Accessors(PUBLIC_SETTER)
	boolean generateJavaMain = false
	
	@Accessors(PUBLIC_SETTER)
	boolean generateXtendMain = false
	
	override boolean isGenerateStub() {
		!grammar.inheritsXbase && super.isGenerateStub
	}
	
	def boolean isGenerateJavaMain() {
		!grammar.inheritsXbase && generateJavaMain
	}
	
	def boolean isGenerateXtendMain() {
		!grammar.inheritsXbase && generateXtendMain
	}
	
	def boolean isGenerateMwe() {
		!grammar.inheritsXbase && generateMwe
	}
	
	protected def TypeReference getGeneratorStub(Grammar grammar) {
		new TypeReference(grammar.runtimeBasePackage + '.generator.' + GrammarUtil.getSimpleName(grammar) + 'Generator')
	}
	
	protected def TypeReference getJavaMain(Grammar grammar) {
		new TypeReference(grammar.generatorStub.packageName + '.Main')
	}
	
	override checkConfiguration(Issues issues) {
		if (generateJavaMain && generateXtendMain) {
			issues.addWarning(
				"Options 'generateJavaMain' and 'generateXtendMain' are mutually exclusive. Generating Xtend only.", this)
			generateJavaMain = false
		}
	}
	
	override generate() {
		if (isGenerateStub) {
			new GuiceModuleAccess.BindingFactory()
				.addTypeToType(IGenerator2.typeRef, language.grammar.generatorStub)
				.contributeTo(language.runtimeGenModule)
			if (projectConfig.runtime.manifest !== null)
				projectConfig.runtime.manifest.requiredBundles += 'org.eclipse.xtext.xbase.lib;bundle-version="'+projectConfig.runtime.xbaseLibVersionLowerBound+'"'

			if (generateXtendStub) {
				doGenerateXtendStubFile
			} else {
				doGenerateJavaStubFile
			}
		}
		if (isGenerateStub || isGenerateJavaMain) {
			if (projectConfig.runtime.manifest !== null)
				projectConfig.runtime.manifest.exportedPackages += language.grammar.generatorStub.packageName
		}
		
		if (isGenerateJavaMain)
			doGenerateJavaMain
		if (isGenerateXtendMain)
			doGenerateXtendMain
		if (isGenerateMwe)
			doGenerateMweFile
		
		contributeEclipsePluginGuiceBindings
		if (projectConfig.eclipsePlugin.manifest !== null)
			projectConfig.eclipsePlugin.manifest.requiredBundles += 'org.eclipse.xtext.builder'
		if (projectConfig.eclipsePlugin.pluginXml !== null)
			contributeEclipsePluginExtensions
	}
	
	protected def contributeEclipsePluginGuiceBindings() {
		val StringConcatenationClient expression = '''«'org.eclipse.core.resources.ResourcesPlugin'.typeRef».getWorkspace().getRoot()'''
		val StringConcatenationClient statement =
			'''
				binder.bind(«'org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer'.typeRef».class)
					.annotatedWith(«Names».named("builderPreferenceInitializer"))
					.to(«new TypeReference('org.eclipse.xtext.builder.preferences', 'BuilderPreferenceAccess.Initializer')».class);
			'''
		new GuiceModuleAccess.BindingFactory()
			.addTypeToType('org.eclipse.xtext.builder.IXtextBuilderParticipant'.typeRef,
					'org.eclipse.xtext.builder.BuilderParticipant'.typeRef)
			.addTypeToInstance('org.eclipse.core.resources.IWorkspaceRoot'.typeRef, expression)
			.addConfiguredBinding('BuilderPreferenceStoreInitializer', statement)
			.contributeTo(language.eclipsePluginGenModule)
	}

	protected def void doGenerateXtendStubFile() {
		fileAccessFactory.createXtendFile(grammar.generatorStub, '''
			/**
			 * Generates code from your model files on save.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
			 */
			class «language.grammar.generatorStub.simpleName» extends «AbstractGenerator» {
			
				override void doGenerate(«Resource» resource, «IFileSystemAccess2» fsa, «IGeneratorContext» context) {
			//		fsa.generateFile('greetings.txt', 'People to greet: ' + 
			//			resource.allContents
			//				.filter(Greeting)
			//				.map[name]
			//				.join(', '))
				}
			}
		''').writeTo(projectConfig.runtime.src)
	}

	protected def void doGenerateJavaStubFile() {
		fileAccessFactory.createJavaFile(grammar.generatorStub, '''
			/**
			 * Generates code from your model files on save.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
			 */
			public class «language.grammar.generatorStub.simpleName» extends «AbstractGenerator» {

				@«Override»
				public void doGenerate(«Resource» resource, «IFileSystemAccess2» fsa, «IGeneratorContext» context) {
			//		Iterator<Greeting> filtered = Iterators.filter(resource.getAllContents(), Greeting.class);
			//		Iterator<String> names = Iterators.transform(filtered, new Function<Greeting, String>() {
			//
			//			@«Override»
			//			public String apply(Greeting greeting) {
			//				return greeting.getName();
			//			}
			//		});
			//		fsa.generateFile("greetings.txt", "People to greet: " + IteratorExtensions.join(names, ", "));
				}
			}
		''').writeTo(projectConfig.runtime.src)
	}

	protected def void doGenerateJavaMain() {
		fileAccessFactory.createJavaFile(grammar.javaMain, '''
			public class Main {
			
				public static void main(String[] args) {
					if (args.length == 0) {
						System.err.println("Aborting: no path to EMF resource provided!");
						return;
					}
					«Injector» injector = new «grammar.runtimeSetup»().createInjectorAndDoEMFRegistration();
					Main main = injector.getInstance(Main.class);
					main.runGenerator(args[0]);
				}
			
				@«Inject»
				private «Provider»<«ResourceSet»> resourceSetProvider;
			
				@«Inject»
				private «IResourceValidator» validator;
			
				@«Inject»
				private «GeneratorDelegate» generator;
			
				@«Inject» 
				private «JavaIoFileSystemAccess» fileAccess;
			
				protected void runGenerator(String string) {
					// Load the resource
					«ResourceSet» set = resourceSetProvider.get();
					«Resource» resource = set.getResource(«URI».createFileURI(string), true);
			
					// Validate the resource
					«List»<«Issue»> list = validator.validate(resource, «CheckMode».ALL, «CancelIndicator».NullImpl);
					if (!list.isEmpty()) {
						for («Issue» issue : list) {
							System.err.println(issue);
						}
						return;
					}
			
					// Configure and start the generator
					fileAccess.setOutputPath("src-gen/");
					«GeneratorContext» context = new «GeneratorContext»();
					context.setCancelIndicator(«CancelIndicator».NullImpl);
					generator.generate(resource, fileAccess, context);
			
					System.out.println("Code generation finished.");
				}
			}
		''').writeTo(projectConfig.runtime.src)
	}

	protected def void doGenerateXtendMain() {
		fileAccessFactory.createXtendFile(grammar.javaMain, '''
			class Main {
			
				def static main(String[] args) {
					if (args.empty) {
						System::err.println('Aborting: no path to EMF resource provided!')
						return
					}
					val injector = new «grammar.runtimeSetup»().createInjectorAndDoEMFRegistration
					val main = injector.getInstance(Main)
					main.runGenerator(args.get(0))
				}
			
				@«Inject» «Provider»<«ResourceSet»> resourceSetProvider
			
				@«Inject» «IResourceValidator» validator
			
				@«Inject» «GeneratorDelegate» generator
			
				@«Inject» «JavaIoFileSystemAccess» fileAccess
			
				def protected runGenerator(String string) {
					// Load the resource
					val set = resourceSetProvider.get
					val resource = set.getResource(«URI».createFileURI(string), true)
			
					// Validate the resource
					val issues = validator.validate(resource, «CheckMode».ALL, «CancelIndicator».NullImpl)
					if (!issues.empty) {
						issues.forEach[System.err.println(it)]
						return
					}
			
					// Configure and start the generator
					fileAccess.outputPath = 'src-gen/'
					val context = new «GeneratorContext» => [
						cancelIndicator = «CancelIndicator».NullImpl
					]
					generator.generate(resource, fileAccess, context)
					System.out.println('Code generation finished.')
				}
			}
		''').writeTo(projectConfig.runtime.src)
	}
	
	protected def void doGenerateMweFile() {
		fileAccessFactory.createTextFile(language.grammar.generatorStub.path + 'MWE.mwe2', '''
			«codeConfig.fileHeader»
			module «language.grammar.generatorStub.name»MWE
			
			import org.eclipse.emf.mwe.utils.*
			import «grammar.runtimeSetup.packageName».*
			
			var targetDir
			var modelPath
			
			Workflow {
			
				component = org.eclipse.xtext.mwe.Reader {
					// lookup all resources on the classpath
					// useJavaClassPath = true
			
					// or define search scope explicitly
					path = modelPath
			
					// this class will be generated by the xtext generator 
					register = «grammar.runtimeSetup.simpleName» {}
					loadResource = {
						slot = "model"
					}
				}
			
				component = org.eclipse.xtext.generator.GeneratorComponent {
					register = «grammar.runtimeSetup.simpleName» {}
					slot = 'model'
					outlet = {
						path = targetDir
					}
				}
			}
		''').writeTo(projectConfig.runtime.src)
	}
	
	protected def contributeEclipsePluginExtensions() {
		val name = language.grammar.name
		projectConfig.eclipsePlugin.pluginXml.entries += '''
			<extension point="org.eclipse.xtext.builder.participant">
				<participant
					class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.builder.IXtextBuilderParticipant"
					fileExtensions="«language.fileExtensions.join(',')»"/>
			</extension>
			<extension point="org.eclipse.ui.preferencePages">
				<page
					category="«name»"
					class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.builder.preferences.BuilderPreferencePage"
					id="«name».compiler.preferencePage"
					name="Compiler">
					<keywordReference id="«GrammarUtil.getNamespace(language.grammar) + ".ui.keyword_" + GrammarUtil.getSimpleName(language.grammar)»"/>
				</page>
			</extension>
			<extension point="org.eclipse.ui.propertyPages">
				<page
					category="«name»"
					class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.builder.preferences.BuilderPreferencePage"
					id="«name».compiler.propertyPage"
					name="Compiler">
					<keywordReference id="«GrammarUtil.getNamespace(language.grammar) + ".ui.keyword_" + GrammarUtil.getSimpleName(language.grammar)»"/>
					<enabledWhen>
						<adapt type="org.eclipse.core.resources.IProject"/>
					</enabledWhen>
					<filter name="projectNature" value="org.eclipse.xtext.ui.shared.xtextNature"/>
				</page>
			</extension>
			<extension point="org.eclipse.ui.menus">
				<menuContribution locationURI="popup:#TextEditorContext?after=xtext.ui.openDeclaration">
					<command
						commandId="org.eclipse.xtext.ui.OpenGeneratedFileCommand"
						id="«name».OpenGeneratedCode"
						style="push">
						<visibleWhen checkEnabled="false">
							<reference definitionId="«name».Editor.opened" />
						</visibleWhen>
					</command>
				</menuContribution>
			</extension>
			<extension point="org.eclipse.ui.handlers">
				<handler
					class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.generator.trace.OpenGeneratedFileHandler"
					commandId="org.eclipse.xtext.ui.OpenGeneratedFileCommand">
					<activeWhen>
						<reference definitionId="«name».Editor.opened" />
					</activeWhen>
				</handler>
			</extension>
		'''
	}
	
}
