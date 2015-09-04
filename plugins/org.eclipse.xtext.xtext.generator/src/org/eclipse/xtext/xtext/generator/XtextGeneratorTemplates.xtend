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
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess
import org.eclipse.xtext.xtext.generator.model.TextFileAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.model.annotations.SuppressWarningsAnnotation

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

@Singleton
class XtextGeneratorTemplates {
	
	@Inject FileAccessFactory fileAccessFactory
	
	def TextFileAccess createPluginXml(PluginXmlAccess pluginXml) {
		if (pluginXml.entries.empty)
			return null
		
		val file = fileAccessFactory.createTextFile()
		file.path = pluginXml.path
		file.content = '''
			<?xml version="1.0" encoding="UTF-8"?>
			<?eclipse version="3.0"?>
			
			<plugin>
				«FOR entry : pluginXml.entries»
					«entry»
				«ENDFOR»
			</plugin>
		'''
		return file
	}
	
	def JavaFileAccess createRuntimeSetup(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val extension naming = langConfig.naming
		val javaFile = fileAccessFactory.createJavaFile(runtimeSetup)
		
		javaFile.typeComment = '''
			/**
			 * Initialization support for running Xtext languages without Equinox extension registry.
			 */
		 '''
		 javaFile.javaContent = '''
			 public class «runtimeSetup.simpleName» extends «runtimeGenSetup» {
			 
			 	public static void doSetup() {
			 		new «runtimeSetup.simpleName»().createInjectorAndDoEMFRegistration();
			 	}
			 
			 }
		 '''
		 return javaFile
	}
	
	def JavaFileAccess createRuntimeGenSetup(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val extension naming = langConfig.naming
		val javaFile = fileAccessFactory.createJavaFile(runtimeGenSetup)
		for (type : langConfig.runtimeGenSetup.imports) {
			javaFile.importType(type)
		}
		
		javaFile.annotations += new SuppressWarningsAnnotation
		javaFile.javaContent = '''
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
		 javaFile.markedAsGenerated = true
		 return javaFile
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
		val extension naming = langConfig.naming
		val javaFile = fileAccessFactory.createJavaFile(runtimeModule)
		javaFile.typeComment = '''
			/**
			 * Use this class to register components to be used at runtime / without the Equinox extension registry.
			 */
		'''
		javaFile.javaContent = '''
			public class «runtimeModule.simpleName» extends «runtimeGenModule» {
			
			}
		'''
		return javaFile
	}
	
	def JavaFileAccess createRuntimeGenModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val extension naming = langConfig.naming
		val superClass = langConfig.runtimeGenModule.superClass ?: runtimeDefaultModule
		val javaFile = fileAccessFactory.createJavaFile(runtimeGenModule)
		javaFile.importNestedTypeThreshold = JavaFileAccess.DONT_IMPORT_NESTED_TYPES
		
		javaFile.typeComment = '''
			/**
			 * Manual modifications go to {@link «runtimeModule.simpleName»}.
			 */
		'''
		javaFile.annotations += new SuppressWarningsAnnotation
		javaFile.javaContent = '''
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
		javaFile.markedAsGenerated = true
		return javaFile
	}
	
	def JavaFileAccess createEclipsePluginModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val extension naming = langConfig.naming
		val javaFile = fileAccessFactory.createJavaFile(eclipsePluginModule)
		javaFile.typeComment = '''
			/**
			 * Use this class to register components to be used within the Eclipse IDE.
			 */
		'''
		javaFile.javaContent = '''
			public class «eclipsePluginModule.simpleName» extends «eclipsePluginGenModule» {
				
				public «eclipsePluginModule.simpleName»(«'org.eclipse.ui.plugin.AbstractUIPlugin'.typeRef» plugin) {
					super(plugin);
				}
				
			}
		'''
		return javaFile
	}
	
	def JavaFileAccess createEclipsePluginGenModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val extension naming = langConfig.naming
		val superClass = langConfig.eclipsePluginGenModule.superClass ?: eclipsePluginDefaultModule
		val javaFile = fileAccessFactory.createJavaFile(eclipsePluginGenModule)
		javaFile.importNestedTypeThreshold = JavaFileAccess.DONT_IMPORT_NESTED_TYPES
		
		javaFile.typeComment = '''
			/**
			 * Manual modifications go to {@link «eclipsePluginModule.simpleName»}.
			 */
		'''
		javaFile.annotations += new SuppressWarningsAnnotation
		javaFile.javaContent = '''
			public abstract class «eclipsePluginGenModule.simpleName» extends «superClass» {
			
				public «eclipsePluginGenModule.simpleName»(«'org.eclipse.ui.plugin.AbstractUIPlugin'.typeRef» plugin) {
					super(plugin);
				}
				
				«FOR binding : langConfig.eclipsePluginGenModule.bindings»
					«binding.createBindingMethod»
					
				«ENDFOR»
			}
		'''
		javaFile.markedAsGenerated = true
		return javaFile
	}
	
	def JavaFileAccess createIdeaModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val extension naming = langConfig.naming
		val javaFile = fileAccessFactory.createJavaFile(ideaModule)
		javaFile.typeComment = '''
			/**
			 * Use this class to register components to be used within the IntelliJ IDEA.
			 */
		'''
		javaFile.javaContent = '''
			public class «ideaModule.simpleName» extends «ideaGenModule» {
			}
		'''
		return javaFile
	}
	
	def JavaFileAccess createIdeaGenModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val extension naming = langConfig.naming
		val superClass = langConfig.ideaGenModule.superClass ?: ideaDefaultModule
		val javaFile = fileAccessFactory.createJavaFile(ideaGenModule)
		javaFile.importNestedTypeThreshold = JavaFileAccess.DONT_IMPORT_NESTED_TYPES
		
		javaFile.typeComment = '''
			/**
			 * Manual modifications go to {@link «ideaModule.simpleName»}.
			 */
		'''
		javaFile.annotations += new SuppressWarningsAnnotation
		javaFile.javaContent = '''
			public abstract class «ideaGenModule.simpleName» extends «superClass» {
				
				«FOR binding : langConfig.ideaGenModule.bindings»
					«binding.createBindingMethod»
					
				«ENDFOR»
			}
		'''
		javaFile.markedAsGenerated = true
		return javaFile
	}
	
	def JavaFileAccess createWebModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val extension naming = langConfig.naming
		val javaFile = fileAccessFactory.createJavaFile(webModule)
		javaFile.typeComment = '''
			/**
			 * Use this class to register components to be used within the web application.
			 */
		'''
		javaFile.javaContent = '''
			public class «webModule.simpleName» extends «webGenModule» {
				
				public «webModule.simpleName»(«Provider»<«ExecutorService»> executorServiceProvider) {
					super(executorServiceProvider);
				}
				
			}
		'''
		return javaFile
	}
	
	def JavaFileAccess createWebGenModule(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val extension naming = langConfig.naming
		val superClass = langConfig.webGenModule.superClass ?: webDefaultModule
		val javaFile = fileAccessFactory.createJavaFile(webGenModule)
		javaFile.importNestedTypeThreshold = JavaFileAccess.DONT_IMPORT_NESTED_TYPES
		
		javaFile.typeComment = '''
			/**
			 * Manual modifications go to {@link «webModule.simpleName»}.
			 */
		'''
		javaFile.annotations += new SuppressWarningsAnnotation
		javaFile.javaContent = '''
			public abstract class «webGenModule.simpleName» extends «superClass» {
			
				public «webGenModule.simpleName»(«Provider»<«ExecutorService»> executorServiceProvider) {
					super(executorServiceProvider);
				}
				
				«FOR binding : langConfig.webGenModule.bindings»
					«binding.createBindingMethod»
					
				«ENDFOR»
			}
		'''
		javaFile.markedAsGenerated = true
		return javaFile
	}
	
	def JavaFileAccess createWebSetup(ILanguageConfig langConfig) {
		val it = langConfig.grammar
		val extension naming = langConfig.naming
		val javaFile = fileAccessFactory.createJavaFile(webSetup)
		
		javaFile.typeComment = '''
			/**
			 * Initialization support for running Xtext languages in web applications.
			 */
		 '''
		 javaFile.javaContent = '''
			public class «webSetup.simpleName» extends «runtimeSetup» {
				
				private final «Provider»<«ExecutorService»> executorServiceProvider;
				
				public «webSetup.simpleName»(«Provider»<«ExecutorService»> executorServiceProvider) {
					this.executorServiceProvider = executorServiceProvider;
				}
				
				@Override
				public «Injector» createInjector() {
					«Module» runtimeModule = new «runtimeModule»();
					«Module» webModule = new «webModule»(executorServiceProvider);
					return «Guice».createInjector(«Modules».override(runtimeModule).with(webModule));
				}
				
			}
		 '''
		 return javaFile
	}
	
	def TextFileAccess createManifest(ManifestAccess manifest, TypeReference activator) {
		val file = fileAccessFactory.createTextFile()
		file.path = manifest.path
		file.content = '''
			Manifest-Version: 1.0
			Bundle-ManifestVersion: 2
			Bundle-Name: «manifest.bundleName»
			Bundle-SymbolicName: «manifest.symbolicName ?: manifest.bundleName»; singleton:=true
			«IF !manifest.version.nullOrEmpty»
				Bundle-Version: «manifest.version»
			«ENDIF»
			Bundle-RequiredExecutionEnvironment: JavaSE-1.6
			Bundle-ActivationPolicy: lazy
			«IF !manifest.exportedPackages.empty»
				Export-Package: «FOR pack : manifest.exportedPackages.sort SEPARATOR ',\n '»«pack»«ENDFOR»
			«ENDIF»
			«IF !manifest.requiredBundles.empty»
				Require-Bundle: «FOR bundle : manifest.requiredBundles.sort SEPARATOR ',\n '»«bundle»«ENDFOR»
			«ENDIF»
			«IF !manifest.importedPackages.empty»
				Import-Package: «FOR pack : manifest.importedPackages.sort SEPARATOR ',\n '»«pack»«ENDFOR»
			«ENDIF»
			«IF activator !== null»
				Bundle-Activator: «activator»
			«ENDIF»
		'''
		return file
	}
	
	def JavaFileAccess createEclipsePluginExecutableExtensionFactory(ILanguageConfig langConfig, ILanguageConfig activatorLanguage) {
		val grammar = langConfig.grammar
		val activatorGrammar = activatorLanguage.grammar
		val extension naming = langConfig.naming
		val javaFile = fileAccessFactory.createJavaFile(grammar.eclipsePluginExecutableExtensionFactory)
		
		javaFile.typeComment = '''
			/**
			 * This class was generated. Customizations should only happen in a newly
			 * introduced subclass. 
			 */
		'''
		javaFile.javaContent = '''
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
		javaFile.markedAsGenerated = true
		return javaFile
	}
	
	def JavaFileAccess createEclipsePluginActivator(List<? extends ILanguageConfig> langConfigs) {
		val activator = langConfigs.head.naming.getEclipsePluginActivator(langConfigs.head.grammar)
		val javaFile = fileAccessFactory.createJavaFile(activator)
		
		javaFile.typeComment = '''
			/**
			 * This class was generated. Customizations should only happen in a newly
			 * introduced subclass. 
			 */
		'''
		javaFile.javaContent = '''
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
							return new «lang.naming.getRuntimeModule(lang.grammar)»();
						}
					«ENDFOR»
					throw new IllegalArgumentException(grammar);
				}
				
				protected «Module» getUiModule(String grammar) {
					«FOR lang : langConfigs»
						if («lang.grammar.name.toUpperCase.replaceAll('\\.', '_')».equals(grammar)) {
							return new «lang.naming.getEclipsePluginModule(lang.grammar)»(this);
						}
					«ENDFOR»
					throw new IllegalArgumentException(grammar);
				}
				
				protected «Module» getSharedStateModule() {
					return new «'org.eclipse.xtext.ui.shared.SharedStateModule'.typeRef»();
				}
				
			}
		'''
		javaFile.markedAsGenerated = true
		return javaFile
	}
	
}