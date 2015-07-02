/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtext.xtext.generator.model.CodeConfig
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.TextFileAccess

@Singleton
class XtextGeneratorTemplates {
	
	@Inject extension XtextGeneratorNaming
	
	@Inject CodeConfig codeConfig
	
	def TextFileAccess startPluginXml(TextFileAccess file) {
		file.path = 'plugin.xml'
		file.codeFragments += '''
			<?xml version="1.0" encoding="UTF-8"?>
			<?eclipse version="3.0"?>
			
			<plugin>
		'''
		return file
	}
	
	def TextFileAccess finishPluginXml(TextFileAccess file) {
		file.codeFragments += '''
			</plugin>
		'''
		return file
	}
	
	def JavaFileAccess getRuntimeSetup(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.runtimeSetup, codeConfig)
		val runtimeSetupImpl = javaFile.imported(g.runtimeGenSetup)
		
		javaFile.typeComment = '''
			/**
			 * Initialization support for running Xtext languages without Equinox extension registry.
			 */
		 '''
		 javaFile.codeFragments += '''
			 public class «g.runtimeSetup.simple» extends «runtimeSetupImpl»{
			 
			 	public static void doSetup() {
			 		new «g.runtimeSetup.simple»().createInjectorAndDoEMFRegistration();
			 	}
			 
			 }
		 '''
		 return javaFile
	}
	
	def JavaFileAccess startRuntimeGenSetup(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.runtimeGenSetup, codeConfig)
		javaFile.imported('org.eclipse.emf.ecore.EPackage')
		javaFile.imported('org.eclipse.emf.ecore.resource.Resource')
		javaFile.imported('org.eclipse.xtext.ISetup')
		javaFile.imported('org.eclipse.xtext.ISetupExtension')
		javaFile.imported('com.google.inject.Guice')
		javaFile.imported('com.google.inject.Injector')
		javaFile.imported('java.util.List')
		javaFile.imported('java.util.Arrays')
		val runtimeGuiceModule = javaFile.imported(g.runtimeModule)
		val usedRuntimeSetups = g.usedGrammars.map[javaFile.imported(it.runtimeSetup)]
		
		javaFile.codeFragments += '''
			public class «g.runtimeGenSetup.simple» implements ISetup, ISetupExtension {
			
				@Override
				public List<String> getFileExtensions() {
					return Arrays.asList(«FOR fileExtension : langConfig.fileExtensions SEPARATOR ','»"«fileExtension»"«ENDFOR»);
				}
			
				@Override
				public Injector createInjectorAndDoEMFRegistration() {
					«FOR usedSetup : usedRuntimeSetups»
						«usedSetup».doSetup();
					«ENDFOR»
					«IF g.usedGrammars.isEmpty»
						// register default ePackages
						if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
							Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
								"ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
						if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
							Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
								"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
						if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xtextbin"))
							Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
								"xtextbin", new org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl());
						if (!EPackage.Registry.INSTANCE.containsKey(org.eclipse.xtext.XtextPackage.eNS_URI))
							EPackage.Registry.INSTANCE.put(org.eclipse.xtext.XtextPackage.eNS_URI, org.eclipse.xtext.XtextPackage.eINSTANCE);
					«ENDIF»
			
					Injector injector = createInjector();
					register(injector);
					return injector;
				}
			
					public Injector createInjector() {
					return Guice.createInjector(new «runtimeGuiceModule»());
				}
			
				public void register(Injector injector) {
		 '''
		 javaFile.markedAsGenerated = true
		 return javaFile
	}
	
	def JavaFileAccess finishRuntimeGenSetup(JavaFileAccess javaFile) {
		javaFile.codeFragments += '''
				}
			}
		'''
		return javaFile
	}
	
	private def getBindMethodName(GuiceModuleAccess.Binding it) {
		(if (!value.provider && value.statements.isEmpty)
			'bind'
		else if (value.statements.isEmpty)
			'provide'
		else 'configure')
			+ getSimpleMethodName(key.type)
			+ if (value.expression !== null && !value.provider) 'ToInstance' else ''
	}
	
	private def getSimpleMethodName(String qn) {
		qn.replaceAll('<', '\\.').replaceAll('>', '\\.').split('\\.').filter[matches('[A-Z].*')].join('$')
	}
	
	private def endsWith(CharSequence sequence, char c) {
		sequence.length > 0 && sequence.charAt(sequence.length - 1) == c
	}
	
	def JavaFileAccess getRuntimeModule(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.runtimeModule, codeConfig)
		val runtimeGeneratedModule = javaFile.imported(g.runtimeGenModule)
		javaFile.typeComment = '''
			/**
			 * Use this class to register components to be used at runtime / without the Equinox extension registry.
			 */
		'''
		javaFile.codeFragments += '''
			public class «g.runtimeModule.simple» extends «runtimeGeneratedModule» {
			
			}
		'''
		return javaFile
	}
	
	def GuiceModuleAccess startRuntimeGenModule(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val module = new GuiceModuleAccess(g.runtimeGenModule, codeConfig)
		module.imported('java.util.Properties')
		module.imported('org.eclipse.xtext.Constants')
		module.imported('com.google.inject.Binder')
		module.imported('com.google.inject.name.Names')
		val runtimeDefaultModule = module.imported(g.runtimeDefaultModule)
		
		module.typeComment = '''
			/**
			 * Manual modifications go to {@link «g.runtimeModule.simple»}.
			 */
		'''
		module.codeFragments += '''
			public abstract class «g.runtimeGenModule.simple» extends «runtimeDefaultModule» {
			
				protected Properties properties = null;
			
				@Override
				public void configure(Binder binder) {
					properties = tryBindProperties(binder, "«g.name.replaceAll("\\.","/")».properties");
					super.configure(binder);
				}
				
				public void configureLanguageName(Binder binder) {
					binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance("«g.name»");
				}
				
				public void configureFileExtensions(Binder binder) {
					if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)
						binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("«langConfig.fileExtensions.join(',')»");
				}
		'''
		module.markedAsGenerated = true
		return module
	}
	
	def JavaFileAccess getEclipsePluginModule(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.eclipsePluginModule, codeConfig)
		val eclipsePluginGenGuiceModule = javaFile.imported(g.eclipsePluginGenModule)
		javaFile.imported('org.eclipse.ui.plugin.AbstractUIPlugin')
		javaFile.typeComment = '''
			/**
			 * Use this class to register components to be used within the Eclipse IDE.
			 */
		'''
		javaFile.codeFragments += '''
			public class «g.eclipsePluginModule.simple» extends «eclipsePluginGenGuiceModule» {
				public «g.eclipsePluginModule.simple»(AbstractUIPlugin plugin) {
					super(plugin);
				}
			}
		'''
		return javaFile
	}
	
	def GuiceModuleAccess startEclipsePluginGenModule(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val module = new GuiceModuleAccess(g.eclipsePluginGenModule, codeConfig)
		module.imported('org.eclipse.ui.plugin.AbstractUIPlugin')
		val eclipsePluginDefaultModule = module.imported(g.eclipsePluginDefaultModule)
		
		module.typeComment = '''
			/**
			 * Manual modifications go to {@link «g.eclipsePluginModule.simple»}.
			 */
		'''
		module.codeFragments += '''
			public abstract class «g.eclipsePluginGenModule.simple» extends «eclipsePluginDefaultModule» {
			
				public «g.eclipsePluginGenModule.simple»(AbstractUIPlugin plugin) {
					super(plugin);
				}
		'''
		module.markedAsGenerated = true
		return module
	}
	
	def GuiceModuleAccess finishGenModule(GuiceModuleAccess module) {
		val binder = module.imported('com.google.inject.Binder')
		val provider = module.imported('com.google.inject.Provider')
		val singletonBinding = module.imported('org.eclipse.xtext.service.SingletonBinding')
		for (it : module.bindings) {
			module.codeFragments += '''
				«IF !value.provider && value.statements.isEmpty»
					// contributed by «contributedBy»
					«IF key.singleton»@«singletonBinding»«IF key.eagerSingleton»(eager=true)«ENDIF»«ENDIF»
					public «IF value.expression === null»Class<? extends «module.imported(key.type)»>«ELSE»«module.imported(key.type)»«ENDIF» «bindMethodName»() {
						return «IF value.expression !== null»«value.expression»«ELSE»«value.typeName».class«ENDIF»;
					}
				«ELSEIF value.statements.isEmpty»
					// contributed by «contributedBy»
					«IF key.singleton»@«singletonBinding»«IF key.eagerSingleton»(eager=true)«ENDIF»«ENDIF»
					public «IF value.expression==null»Class<? extends «provider»<«key.type»>>«ELSE»«provider»<«key.type»>«ENDIF» «bindMethodName»() {
						return «IF value.expression!=null»«value.expression»«ELSE»«value.typeName».class«ENDIF»;
					}
				«ELSE»
					// contributed by «contributedBy»
					public void «bindMethodName»(«binder» binder) {
					«FOR statement : value.statements»
						«statement»«IF !statement.endsWith(';')»;«ENDIF»
					«ENDFOR»
					}
				«ENDIF»
			'''
		}
		module.codeFragments += '''
			}
		'''
		return module
	}
	
	def JavaFileAccess getEclipsePluginExecutableExtensionFactory(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.eclipsePluginExecutableExtensionFactory, codeConfig)
		javaFile.imported('org.osgi.framework.Bundle')
		javaFile.imported('com.google.inject.Injector')
		val superClass = javaFile.imported('org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory')
		val activator = javaFile.imported(g.eclipsePluginActivator)
		
		javaFile.typeComment = '''
			/**
			 * This class was generated. Customizations should only happen in a newly
			 * introduced subclass. 
			 */
		'''
		javaFile.codeFragments += '''
			public class «g.eclipsePluginExecutableExtensionFactory.simple» extends «superClass» {
			
				@Override
				protected Bundle getBundle() {
					return «activator».getInstance().getBundle();
				}
				
				@Override
				protected Injector getInjector() {
					return «activator».getInstance().getInjector(«activator».«g.name.toUpperCase.replaceAll('\\.', '_')»);
				}
				
			}
		'''
		javaFile.markedAsGenerated = true
		return javaFile
	}
	
}