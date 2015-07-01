/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.model.CodeConfig
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.TextFileAccess

class XtextGeneratorTemplates {
	
	@Inject extension XtextGeneratorNaming
	
	@Inject LanguageConfig2 langConfig
	
	@Inject CodeConfig codeConfig
	
	def startPluginXml(TextFileAccess file) {
		file.codeFragments += '''
			<?xml version="1.0" encoding="UTF-8"?>
			<?eclipse version="3.0"?>
			
			<plugin>
		'''
	}
	
	def void finishPluginXml(TextFileAccess file) {
		file.codeFragments += '''
			</plugin>
		'''
	}
	
	def getRuntimeSetup() {
		val grammar = langConfig.grammar
		val javaFile = new JavaFileAccess(grammar.runtimeBasePackage, codeConfig)
		val runtimeSetupImpl = javaFile.imported(grammar.runtimeSetupImplFull)
		
		javaFile.typeComment = '''
			/**
			 * Initialization support for running Xtext languages without Equinox extension registry.
			 */
		 '''
		 javaFile.codeFragments += '''
			 public class «grammar.runtimeSetupSimple» extends «runtimeSetupImpl»{
			 
			 	public static void doSetup() {
			 		new «grammar.runtimeSetupSimple»().createInjectorAndDoEMFRegistration();
			 	}
			 
			 }
		 '''
	}
	
	def startRuntimeSetupImpl() {
		val grammar = langConfig.grammar
		val javaFile = new JavaFileAccess(grammar.runtimeBasePackage, codeConfig)
		javaFile.imported('org.eclipse.emf.ecore.EPackage')
		javaFile.imported('org.eclipse.emf.ecore.resource.Resource')
		javaFile.imported('org.eclipse.xtext.ISetup')
		javaFile.imported('org.eclipse.xtext.ISetupExtension')
		javaFile.imported('com.google.inject.Guice')
		javaFile.imported('com.google.inject.Injector')
		javaFile.imported('java.util.List')
		javaFile.imported('java.util.Arrays')
		val runtimeGuiceModule = javaFile.imported(grammar.runtimeGuiceModuleFull)
		val usedRuntimeSetups = grammar.usedGrammars.map[javaFile.imported(runtimeSetupFull)]
		
		javaFile.codeFragments += '''
			public class «grammar.runtimeSetupImplFull» implements ISetup, ISetupExtension {
			
				@Override
				public List<String> getFileExtensions() {
					return Arrays.asList(«FOR fileExtension : langConfig.fileExtensions SEPARATOR ','»"«fileExtension»"«ENDFOR»);
				}
			
				@Override
				public Injector createInjectorAndDoEMFRegistration() {
					«FOR usedSetup : usedRuntimeSetups»
						«usedSetup».doSetup();
					«ENDFOR»
					«IF grammar.usedGrammars.isEmpty»
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
	}
	
	def void finishRuntimeSetupImpl(JavaFileAccess javaFile) {
		javaFile.codeFragments += '''
				}
			}
		'''
	}
	
}