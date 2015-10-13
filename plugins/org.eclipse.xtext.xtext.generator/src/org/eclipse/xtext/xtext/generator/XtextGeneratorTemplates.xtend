/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.common.collect.Maps
import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Module
import com.google.inject.Provider
import com.google.inject.Singleton
import com.google.inject.name.Names
import com.google.inject.util.Modules
import java.util.Collections
import java.util.List
import java.util.Map
import java.util.Properties
import java.util.concurrent.ExecutorService
import org.apache.log4j.Logger
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.Constants
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.XtextPackage
import org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl
import org.eclipse.xtext.service.SingletonBinding
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.model.annotations.SuppressWarningsAnnotation

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

@Singleton
class XtextGeneratorTemplates {
	
	@Inject FileAccessFactory fileAccessFactory
	
	@Inject extension XtextGeneratorNaming naming
	
	def JavaFileAccess createRuntimeSetup(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		return fileAccessFactory.createXtendFile(runtimeSetup,'''
			/**
			 * Initialization support for running Xtext languages without Equinox extension registry.
			 */
			class «runtimeSetup.simpleName» extends «runtimeGenSetup» {
			
				def static void doSetup() {
					new «runtimeSetup.simpleName»().createInjectorAndDoEMFRegistration()
				}
			
			}
		 ''')
	}
	
	def JavaFileAccess createRuntimeGenSetup(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val file = fileAccessFactory.createGeneratedJavaFile(runtimeGenSetup)
		// The following imports are added for backwards-compatibility
		for (type : langConfig.runtimeGenSetup.imports) {
			file.importType(type)
		}
		
		file.annotations += new SuppressWarningsAnnotation
		file.content = '''
			public class «runtimeGenSetup.simpleName» implements «ISetup» {
			
				@Override
				public «Injector» createInjectorAndDoEMFRegistration() {
					«FOR usedGrammar : langConfig.grammar.usedGrammars»
						«usedGrammar.runtimeSetup».doSetup();
					«ENDFOR»
					«IF langConfig.grammar.usedGrammars.isEmpty»
						// register default ePackages
						if (!«'org.eclipse.emf.ecore.resource.Resource'.typeRef».Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
							«'org.eclipse.emf.ecore.resource.Resource'.typeRef».Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
								"ecore", new «'org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl'.typeRef»());
						if (!«'org.eclipse.emf.ecore.resource.Resource'.typeRef».Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
							«'org.eclipse.emf.ecore.resource.Resource'.typeRef».Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
								"xmi", new «'org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl'.typeRef»());
						if (!«'org.eclipse.emf.ecore.resource.Resource'.typeRef».Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xtextbin"))
							«'org.eclipse.emf.ecore.resource.Resource'.typeRef».Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
								"xtextbin", new «BinaryGrammarResourceFactoryImpl»());
						if (!«'org.eclipse.emf.ecore.EPackage'.typeRef».Registry.INSTANCE.containsKey(«XtextPackage».eNS_URI))
							«'org.eclipse.emf.ecore.EPackage'.typeRef».Registry.INSTANCE.put(«XtextPackage».eNS_URI, «XtextPackage».eINSTANCE);
					«ENDIF»
			
					«Injector» injector = createInjector();
					register(injector);
					return injector;
				}
				
				public «Injector» createInjector() {
					return «Guice».createInjector(new «runtimeModule»());
				}
				
				public void register(«Injector» injector) {
					«FOR reg : langConfig.runtimeGenSetup.registrations»
						«reg»
					«ENDFOR»
				}
			}
		 '''
		 return file
	}
	
	private def getBindMethodName(GuiceModuleAccess.Binding it) {
		'''«IF !value.provider && value.statements.isEmpty
			»bind«
		ELSEIF value.statements.isEmpty
			»provide«
		ELSE
			»configure«
		ENDIF
		»«key.name?.replace('.', '$') ?: key.type.simpleMethodName
		»«IF value.expression !== null && !value.provider»ToInstance«ENDIF»'''
	}
	
	private def String getSimpleMethodName(TypeReference type) {
		type.simpleNames.join('$') + type.typeArguments.join('$', '$', '', [simpleMethodName])
	}
	
	private def StringConcatenationClient createBindingMethod(GuiceModuleAccess.Binding it) '''
		«IF !value.provider && value.statements.isEmpty»
			// contributed by «contributedBy»
			«IF key.singleton»@«SingletonBinding»«IF key.eagerSingleton»(eager=true)«ENDIF»«ENDIF»
			public «IF value.expression === null»Class<? extends «key.type»>«ELSE»«key.type»«ENDIF» «bindMethodName»() {
				return «IF value.expression !== null»«value.expression»«ELSE»«value.type».class«ENDIF»;
			}
		«ELSEIF value.statements.isEmpty»
			// contributed by «contributedBy»
			«IF key.singleton»@«SingletonBinding»«IF key.eagerSingleton»(eager=true)«ENDIF»«ENDIF»
			public «IF value.expression==null»Class<? extends «Provider»<«key.type»>>«ELSE»«Provider»<«key.type»>«ENDIF» «bindMethodName»() {
				return «IF value.expression!=null»«value.expression»«ELSE»«value.type».class«ENDIF»;
			}
		«ELSE»
			// contributed by «contributedBy»
			public void «bindMethodName»(«Binder» binder) {
				«FOR statement : value.statements»
					«statement»
				«ENDFOR»
			}
		«ENDIF»
	'''
	
	def JavaFileAccess createRuntimeModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		return fileAccessFactory.createXtendFile(runtimeModule,'''
			/**
			 * Use this class to register components to be used at runtime / without the Equinox extension registry.
			 */
			class «runtimeModule.simpleName» extends «runtimeGenModule» {
			}
		''')
	}
	
	def JavaFileAccess createRuntimeGenModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val superClass = langConfig.runtimeGenModule.superClass ?: runtimeDefaultModule
		val file = fileAccessFactory.createGeneratedJavaFile(runtimeGenModule)
		file.importNestedTypeThreshold = JavaFileAccess.DONT_IMPORT_NESTED_TYPES
		
		file.typeComment = '''
			/**
			 * Manual modifications go to {@link «runtimeModule.simpleName»}.
			 */
		'''
		file.annotations += new SuppressWarningsAnnotation
		file.content = '''
			public abstract class «runtimeGenModule.simpleName» extends «superClass» {
			
				protected «Properties» properties = null;
			
				@Override
				public void configure(«Binder» binder) {
					properties = tryBindProperties(binder, "«langConfig.grammar.name.replaceAll("\\.","/")».properties");
					super.configure(binder);
				}
				
				public void configureLanguageName(«Binder» binder) {
					binder.bind(String.class).annotatedWith(«Names».named(«Constants».LANGUAGE_NAME)).toInstance("«langConfig.grammar.name»");
				}
				
				public void configureFileExtensions(«Binder» binder) {
					if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)
						binder.bind(String.class).annotatedWith(«Names».named(«Constants».FILE_EXTENSIONS)).toInstance("«langConfig.fileExtensions.join(',')»");
				}
				
				«FOR binding : langConfig.runtimeGenModule.bindings»
					«binding.createBindingMethod»
					
				«ENDFOR»
			}
		'''
		file.markedAsGenerated = true
		return file
	}
	
	def JavaFileAccess createEclipsePluginModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		return fileAccessFactory.createXtendFile(eclipsePluginModule,'''
			/**
			 * Use this class to register components to be used within the Eclipse IDE.
			 */
			@«FinalFieldsConstructor» class «eclipsePluginModule.simpleName» extends «eclipsePluginGenModule» {
			}
		''')
	}
	
	def JavaFileAccess createEclipsePluginGenModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val superClass = langConfig.eclipsePluginGenModule.superClass ?: eclipsePluginDefaultModule
		val file = fileAccessFactory.createGeneratedJavaFile(eclipsePluginGenModule)
		file.importNestedTypeThreshold = JavaFileAccess.DONT_IMPORT_NESTED_TYPES
		
		file.typeComment = '''
			/**
			 * Manual modifications go to {@link «eclipsePluginModule.simpleName»}.
			 */
		'''
		file.annotations += new SuppressWarningsAnnotation
		file.content = '''
			public abstract class «eclipsePluginGenModule.simpleName» extends «superClass» {
			
				public «eclipsePluginGenModule.simpleName»(«'org.eclipse.ui.plugin.AbstractUIPlugin'.typeRef» plugin) {
					super(plugin);
				}
				
				«FOR binding : langConfig.eclipsePluginGenModule.bindings»
					«binding.createBindingMethod»
					
				«ENDFOR»
			}
		'''
		file.markedAsGenerated = true
		return file
	}
	
	def JavaFileAccess createIdeaModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		return fileAccessFactory.createXtendFile(ideaModule,'''
			/**
			 * Use this class to register components to be used within IntelliJ IDEA.
			 */
			class «ideaModule.simpleName» extends «ideaGenModule» {
			}
		''')
	}
	
	def JavaFileAccess createIdeaGenModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val superClass = langConfig.ideaGenModule.superClass ?: ideaDefaultModule
		val file = fileAccessFactory.createGeneratedJavaFile(ideaGenModule)
		file.importNestedTypeThreshold = JavaFileAccess.DONT_IMPORT_NESTED_TYPES
		
		file.typeComment = '''
			/**
			 * Manual modifications go to {@link «ideaModule.simpleName»}.
			 */
		'''
		file.annotations += new SuppressWarningsAnnotation
		file.content = '''
			public abstract class «ideaGenModule.simpleName» extends «superClass» {
				
				«FOR binding : langConfig.ideaGenModule.bindings»
					«binding.createBindingMethod»
					
				«ENDFOR»
			}
		'''
		return file
	}
	
	def JavaFileAccess createWebModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		return fileAccessFactory.createXtendFile(webModule,'''
			/**
			 * Use this class to register additional components to be used within the web application.
			 */
			@«FinalFieldsConstructor» class «webModule.simpleName» extends «webGenModule» {
			}
		''')
	}
	
	def JavaFileAccess createWebGenModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val superClass = langConfig.webGenModule.superClass ?: webDefaultModule
		val file = fileAccessFactory.createGeneratedJavaFile(webGenModule)
		file.importNestedTypeThreshold = JavaFileAccess.DONT_IMPORT_NESTED_TYPES
		file.typeComment = '''
			/**
			 * Manual modifications go to {@link «webModule.simpleName»}.
			 */
		'''
		file.annotations += new SuppressWarningsAnnotation
		file.content = '''
			public abstract class «webGenModule.simpleName» extends «superClass» {
			
				public «webGenModule.simpleName»(«Provider»<«ExecutorService»> executorServiceProvider) {
					super(executorServiceProvider);
				}
				
				«FOR binding : langConfig.webGenModule.bindings»
					«binding.createBindingMethod»
					
				«ENDFOR»
			}
		'''
		file.markedAsGenerated = true
		return file
	}
	
	def JavaFileAccess createWebSetup(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		return fileAccessFactory.createXtendFile(webSetup, '''
			/**
			 * Initialization support for running Xtext languages in web applications.
			 */
			@«FinalFieldsConstructor» class «webSetup.simpleName» extends «runtimeSetup» {
				
				val «Provider»<«ExecutorService»> executorServiceProvider;
				
				override «Injector» createInjector() {
					val runtimeModule = new «runtimeModule»()
					val webModule = new «webModule»(executorServiceProvider)
					return «Guice».createInjector(«Modules».override(runtimeModule).with(webModule))
				}
				
			}
		 ''')
	}

	
	def JavaFileAccess createEclipsePluginExecutableExtensionFactory(ILanguageConfig langConfig, ILanguageConfig activatorLanguage) {
		val grammar = langConfig.grammar
		val activatorGrammar = activatorLanguage.grammar
		val file = fileAccessFactory.createGeneratedJavaFile(grammar.eclipsePluginExecutableExtensionFactory)
		file.typeComment = '''
			/**
			 * This class was generated. Customizations should only happen in a newly
			 * introduced subclass. 
			 */
		'''
		file.content = '''
			public class «grammar.eclipsePluginExecutableExtensionFactory.simpleName» extends «'org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory'.typeRef» {
			
				@Override
				protected «'org.osgi.framework.Bundle'.typeRef» getBundle() {
					return «activatorGrammar.eclipsePluginActivator».getInstance().getBundle();
				}
				
				@Override
				protected «Injector» getInjector() {
					return «activatorGrammar.eclipsePluginActivator».getInstance().getInjector(«activatorGrammar.eclipsePluginActivator».«langConfig.grammar.name.toUpperCase.replaceAll('\\.', '_')»);
				}
				
			}
		'''
		return file
	}
	
	def JavaFileAccess createEclipsePluginActivator(List<? extends ILanguageConfig> langConfigs) {
		val activator = getEclipsePluginActivator(langConfigs.head.grammar)
		val file = fileAccessFactory.createGeneratedJavaFile(activator)
		
		file.typeComment = '''
			/**
			 * This class was generated. Customizations should only happen in a newly
			 * introduced subclass. 
			 */
		'''
		file.content = '''
			public class «activator.simpleName» extends «'org.eclipse.ui.plugin.AbstractUIPlugin'» {
			
				«FOR lang : langConfigs»
					public static final String «lang.grammar.name.toUpperCase.replaceAll('\\.', '_')» = "«lang.grammar.name»";
				«ENDFOR»
				
				private static final «Logger» logger = «Logger».getLogger(«activator.simpleName».class);
				
				private static «activator.simpleName» INSTANCE;
				
				private «Map»<String, «Injector»> injectors = «Collections».synchronizedMap(«Maps».<String, «Injector»> newHashMapWithExpectedSize(1));
				
				@Override
				public void start(«'org.osgi.framework.BundleContext'.typeRef» context) throws Exception {
					super.start(context);
					INSTANCE = this;
				}
				
				@Override
				public void stop(«'org.osgi.framework.BundleContext'.typeRef» context) throws Exception {
					injectors.clear();
					INSTANCE = null;
					super.stop(context);
				}
				
				public static «activator.simpleName» getInstance() {
					return INSTANCE;
				}
				
				public «Injector» getInjector(String language) {
					synchronized (injectors) {
						«Injector» injector = injectors.get(language);
						if (injector == null) {
							injectors.put(language, injector = createInjector(language));
						}
						return injector;
					}
				}
				
				protected «Injector» createInjector(String language) {
					try {
						«Module» runtimeModule = getRuntimeModule(language);
						«Module» sharedStateModule = getSharedStateModule();
						«Module» uiModule = getUiModule(language);
						«Module» mergedModule = «Modules2».mixin(runtimeModule, sharedStateModule, uiModule);
						return «Guice».createInjector(mergedModule);
					} catch (Exception e) {
						logger.error("Failed to create injector for " + language);
						logger.error(e.getMessage(), e);
						throw new RuntimeException("Failed to create injector for " + language, e);
					}
				}
				
				protected Module getRuntimeModule(String grammar) {
					«FOR lang : langConfigs»
						if («lang.grammar.name.toUpperCase.replaceAll('\\.', '_')».equals(grammar)) {
							return new «getRuntimeModule(lang.grammar)»();
						}
					«ENDFOR»
					throw new IllegalArgumentException(grammar);
				}
				
				protected «Module» getUiModule(String grammar) {
					«FOR lang : langConfigs»
						if («lang.grammar.name.toUpperCase.replaceAll('\\.', '_')».equals(grammar)) {
							return new «getEclipsePluginModule(lang.grammar)»(this);
						}
					«ENDFOR»
					throw new IllegalArgumentException(grammar);
				}
				
				protected «Module» getSharedStateModule() {
					return new «'org.eclipse.xtext.ui.shared.SharedStateModule'.typeRef»();
				}
				
			}
		'''
		return file
	}
	
}