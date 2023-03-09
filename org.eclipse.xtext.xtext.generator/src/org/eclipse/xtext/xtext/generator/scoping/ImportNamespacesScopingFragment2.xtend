/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.scoping

import com.google.inject.Inject
import com.google.inject.name.Names
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.scoping.IgnoreCaseLinking
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider
import org.eclipse.xtext.scoping.impl.DelegatingScopeProvider
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider
import org.eclipse.xtext.xtext.generator.AbstractInheritingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

import static org.eclipse.xtext.GrammarUtil.*

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import static extension org.eclipse.xtext.xtext.generator.util.GrammarUtil2.*

class ImportNamespacesScopingFragment2 extends AbstractInheritingFragment {
	
	@Inject extension XtextGeneratorNaming
	@Inject extension XbaseUsageDetector
	@Inject FileAccessFactory fileAccessFactory

	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER)
	boolean ignoreCase = false
	
	protected def TypeReference getScopeProviderClass(Grammar grammar) {
		if (grammar.name == 'org.eclipse.xtext.xbase.Xbase')
			return 'org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider'.typeRef
		if (grammar.name == 'org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations')
			return 'org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider'.typeRef
		return new TypeReference(grammar.runtimeBasePackage + '.scoping.' + getSimpleName(grammar) + 'ScopeProvider')
	}
	
	protected def TypeReference getAbstractScopeProviderClass(Grammar grammar) {
		return new TypeReference(grammar.runtimeBasePackage + '.scoping.' + 'Abstract'+ getSimpleName(grammar) + 'ScopeProvider')
	}
	
	protected def TypeReference getScopeProviderSuperClass(Grammar grammar) {
		val superGrammar = grammar.nonTerminalsSuperGrammar
		if (inheritImplementation && superGrammar !== null) 
			return superGrammar.scopeProviderClass
		else 
			return defaultScopeProviderSuperClass
	}

	protected def TypeReference getDefaultScopeProviderSuperClass() {
		if (language.grammar.inheritsXbase) {
			"org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider".typeRef
		} else {
			DelegatingScopeProvider.typeRef
		}
	}
	
	protected def TypeReference getDelegateScopeProvider() {
		if (language.grammar.inheritsXbase)
			'org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider'.typeRef
		else
			ImportedNamespaceAwareLocalScopeProvider.typeRef
	}
	
	protected def TypeReference getGlobalScopeProvider() {
		DefaultGlobalScopeProvider.typeRef
	}
	
	override generate() {
		contributeRuntimeGuiceBindings()
		
		generateGenScopeProvider()

		if (isGenerateStub) {
			
			if (generateXtendStub)
				generateXtendScopeProvider()
			else
				generateJavaScopeProvider()
			
			if (projectConfig.runtime.manifest !== null) {
				projectConfig.runtime.manifest.exportedPackages += grammar.scopeProviderClass.packageName
				if (generateXtendStub)
					projectConfig.runtime.manifest.requiredBundles += 'org.eclipse.xtext.xbase.lib;bundle-version="'+projectConfig.runtime.xbaseLibVersionLowerBound+'"'
			}
		}
	}
	
	
	protected def contributeRuntimeGuiceBindings() {
		val bindingFactory = new GuiceModuleAccess.BindingFactory
		val targetType = if (language.grammar.inheritsXbase) {
			"org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider".typeRef
		} else {
			IScopeProvider.typeRef
		}
		bindingFactory.addTypeToType(targetType, grammar.scopeProviderClass)
		
		bindingFactory.addConfiguredBinding(IScopeProvider.simpleName + 'Delegate', 
				'''binder.bind(«IScopeProvider».class).annotatedWith(«Names».named(«AbstractDeclarativeScopeProvider».NAMED_DELEGATE)).to(«getDelegateScopeProvider».class);''')
		bindingFactory.addTypeToType(IGlobalScopeProvider.typeRef, globalScopeProvider)
		bindingFactory.addConfiguredBinding(IgnoreCaseLinking.simpleName, 
				'''binder.bindConstant().annotatedWith(«IgnoreCaseLinking».class).to(«ignoreCase»);''')
		bindingFactory.contributeTo(language.runtimeGenModule)
	}
	
	protected def generateGenScopeProvider() {
		val genClass = if (isGenerateStub) grammar.abstractScopeProviderClass else grammar.scopeProviderClass		
		val file = fileAccessFactory.createGeneratedJavaFile(genClass)
		
		file.content = '''
			public «IF isGenerateStub»abstract «ENDIF»class «genClass.simpleName» extends «grammar.scopeProviderSuperClass» {
			}
		'''
		file.writeTo(projectConfig.runtime.srcGen)
	}
	
	protected def generateJavaScopeProvider() {
		fileAccessFactory.createJavaFile(grammar.scopeProviderClass, '''
			/**
			 * This class contains custom scoping description.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
			 * on how and when to use it.
			 */
			public class «grammar.scopeProviderClass.simpleName» extends «grammar.abstractScopeProviderClass» {
			
			}
		''').writeTo(projectConfig.runtime.src)
	}
	
	protected def generateXtendScopeProvider() {
		fileAccessFactory.createXtendFile(grammar.scopeProviderClass, '''
			/**
			 * This class contains custom scoping description.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
			 * on how and when to use it.
			 */
			class «grammar.scopeProviderClass.simpleName» extends «grammar.abstractScopeProviderClass» {
			
			}
		''').writeTo(projectConfig.runtime.src)
	}
	
}
