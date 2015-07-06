/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Provider
import com.google.inject.Singleton
import com.google.inject.name.Names
import org.eclipse.xtext.Constants
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.ISetupExtension
import org.eclipse.xtext.XtextPackage
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl
import org.eclipse.xtext.service.SingletonBinding
import org.eclipse.xtext.xtext.generator.model.CodeConfig
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess
import org.eclipse.xtext.xtext.generator.model.TextFileAccess

@Singleton
class XtextGeneratorTemplates {
	
	@Inject extension XtextGeneratorNaming
	
	@Inject CodeConfig codeConfig
	
	@Inject IEncodingProvider encodingProvider
	
	def TextFileAccess createPluginXml(PluginXmlAccess pluginXml) {
		val file = new TextFileAccess
		file.encodingProvider = encodingProvider
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
	
	def JavaFileAccess createRuntimeSetup(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.runtimeSetup, codeConfig)
		javaFile.encodingProvider = encodingProvider
		
		javaFile.typeComment = '''
			/**
			 * Initialization support for running Xtext languages without Equinox extension registry.
			 */
		 '''
		 javaFile.javaContent = '''
			 public class «g.runtimeSetup.simpleName» extends «g.runtimeGenSetup»{
			 
			 	public static void doSetup() {
			 		new «g.runtimeSetup.simpleName»().createInjectorAndDoEMFRegistration();
			 	}
			 
			 }
		 '''
		 return javaFile
	}
	
	def JavaFileAccess createRuntimeGenSetup(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.runtimeGenSetup, codeConfig)
		javaFile.encodingProvider = encodingProvider
		
		javaFile.javaContent = '''
			public class «g.runtimeGenSetup.simpleName» implements «ISetup», «ISetupExtension» {
			
				@Override
				public «'java.util.List'»<String> getFileExtensions() {
					return «'java.util.Arrays'».asList(«FOR fileExtension : langConfig.fileExtensions SEPARATOR ','»"«fileExtension»"«ENDFOR»);
				}
			
				@Override
				public «Injector» createInjectorAndDoEMFRegistration() {
					«FOR usedGrammar : g.usedGrammars»
						«usedGrammar.runtimeSetup».doSetup();
					«ENDFOR»
					«IF g.usedGrammars.isEmpty»
						// register default ePackages
						if (!«'org.eclipse.emf.ecore.resource.Resource'».Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
							«'org.eclipse.emf.ecore.resource.Resource'».Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
								"ecore", new «'org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl'»());
						if (!«'org.eclipse.emf.ecore.resource.Resource'».Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
							«'org.eclipse.emf.ecore.resource.Resource'».Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
								"xmi", new «'org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl'»());
						if (!«'org.eclipse.emf.ecore.resource.Resource'».Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xtextbin"))
							«'org.eclipse.emf.ecore.resource.Resource'».Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
								"xtextbin", new «BinaryGrammarResourceFactoryImpl»());
						if (!«'org.eclipse.emf.ecore.EPackage'».Registry.INSTANCE.containsKey(«XtextPackage».eNS_URI))
							«'org.eclipse.emf.ecore.EPackage'».Registry.INSTANCE.put(«XtextPackage».eNS_URI, «XtextPackage».eINSTANCE);
					«ENDIF»
			
					«Injector» injector = createInjector();
					register(injector);
					return injector;
				}
			
					public «Injector» createInjector() {
					return «Guice».createInjector(new «g.runtimeModule»());
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
	
	private def createBindingMethod(GuiceModuleAccess.Binding it) '''
		«IF !value.provider && value.statements.isEmpty»
			// contributed by «contributedBy»
			«IF key.singleton»@«SingletonBinding»«IF key.eagerSingleton»(eager=true)«ENDIF»«ENDIF»
			public «IF value.expression === null»Class<? extends «key.type»>«ELSE»«key.type»«ENDIF» «bindMethodName»() {
				return «IF value.expression !== null»«value.expression»«ELSE»«value.typeName».class«ENDIF»;
			}
		«ELSEIF value.statements.isEmpty»
			// contributed by «contributedBy»
			«IF key.singleton»@«SingletonBinding»«IF key.eagerSingleton»(eager=true)«ENDIF»«ENDIF»
			public «IF value.expression==null»Class<? extends «Provider»<«key.type»>>«ELSE»«Provider»<«key.type»>«ENDIF» «bindMethodName»() {
				return «IF value.expression!=null»«value.expression»«ELSE»«value.typeName».class«ENDIF»;
			}
		«ELSE»
			// contributed by «contributedBy»
			public void «bindMethodName»(«Binder» binder) {
			«FOR statement : value.statements»
				«statement»«IF !statement.endsWith(';')»;«ENDIF»
			«ENDFOR»
			}
		«ENDIF»
	'''
	
	def JavaFileAccess createRuntimeModule(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.runtimeModule, codeConfig)
		javaFile.encodingProvider = encodingProvider
		javaFile.typeComment = '''
			/**
			 * Use this class to register components to be used at runtime / without the Equinox extension registry.
			 */
		'''
		javaFile.javaContent = '''
			public class «g.runtimeModule.simpleName» extends «g.runtimeGenModule» {
			
			}
		'''
		return javaFile
	}
	
	def JavaFileAccess createRuntimeGenModule(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.runtimeGenModule, codeConfig)
		javaFile.encodingProvider = encodingProvider
		
		javaFile.typeComment = '''
			/**
			 * Manual modifications go to {@link «g.runtimeModule.simpleName»}.
			 */
		'''
		javaFile.javaContent = '''
			public abstract class «g.runtimeGenModule.simpleName» extends «g.runtimeDefaultModule» {
			
				protected «'java.util.Properties'» properties = null;
			
				@Override
				public void configure(«Binder» binder) {
					properties = tryBindProperties(binder, "«g.name.replaceAll("\\.","/")».properties");
					super.configure(binder);
				}
				
				public void configureLanguageName(«Binder» binder) {
					binder.bind(String.class).annotatedWith(«Names».named(«Constants».LANGUAGE_NAME)).toInstance("«g.name»");
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
	
	def JavaFileAccess createEclipsePluginModule(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.eclipsePluginModule, codeConfig)
		javaFile.encodingProvider = encodingProvider
		javaFile.typeComment = '''
			/**
			 * Use this class to register components to be used within the Eclipse IDE.
			 */
		'''
		javaFile.javaContent = '''
			public class «g.eclipsePluginModule.simpleName» extends «g.eclipsePluginGenModule» {
				public «g.eclipsePluginModule.simpleName»(«'org.eclipse.ui.plugin.AbstractUIPlugin'» plugin) {
					super(plugin);
				}
			}
		'''
		return javaFile
	}
	
	def JavaFileAccess createEclipsePluginGenModule(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.eclipsePluginGenModule, codeConfig)
		javaFile.encodingProvider = encodingProvider
		
		javaFile.typeComment = '''
			/**
			 * Manual modifications go to {@link «g.eclipsePluginModule.simpleName»}.
			 */
		'''
		javaFile.javaContent = '''
			public abstract class «g.eclipsePluginGenModule.simpleName» extends «g.eclipsePluginDefaultModule» {
			
				public «g.eclipsePluginGenModule.simpleName»(«'org.eclipse.ui.plugin.AbstractUIPlugin'» plugin) {
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
	
	def JavaFileAccess createEclipsePluginExecutableExtensionFactory(LanguageConfig2 langConfig) {
		val g = langConfig.grammar
		val javaFile = new JavaFileAccess(g.eclipsePluginExecutableExtensionFactory, codeConfig)
		javaFile.encodingProvider = encodingProvider
		
		javaFile.typeComment = '''
			/**
			 * This class was generated. Customizations should only happen in a newly
			 * introduced subclass. 
			 */
		'''
		javaFile.javaContent = '''
			public class «g.eclipsePluginExecutableExtensionFactory.simpleName» extends «'org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory'» {
			
				@Override
				protected «'org.osgi.framework.Bundle'» getBundle() {
					return «g.eclipsePluginActivator».getInstance().getBundle();
				}
				
				@Override
				protected «Injector» getInjector() {
					return «g.eclipsePluginActivator».getInstance().getInjector(«g.eclipsePluginActivator».«g.name.toUpperCase.replaceAll('\\.', '_')»);
				}
				
			}
		'''
		javaFile.markedAsGenerated = true
		return javaFile
	}
	
}