/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.index

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xtext.AnnotationNames
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.util.GrammarUtil2.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import org.eclipse.xtext.xtext.generator.AbstractInheritingFragment
import org.eclipse.xtext.Grammar

/**
 * By default the @link DefaultResourceDescriptionStrategy exposes all model element that have a name.
 * That means a given ParserRule with a corresponding model type with a name gets stored to the index by default.
 * Normally one would bind a custom impl of @link IDefaultResourceDescriptionStrategy to filter.
 * By using this fragment and @Exported on a AbstractRule in the Xtext grammar the corresponding model element gets explicitly visible
 * stored to the index and all others don't.
 * 
 * @author Holger Schill - Initial contribution and API
 */
class ResourceDescriptionStrategyFragment extends AbstractInheritingFragment {
	
	/**
	 * if this flag is set to false nothing get's generated or bound
	 */
	@Accessors
	boolean generate = true;
	
	@Inject extension XtextGeneratorNaming
	@Inject FileAccessFactory fileAccessFactory
	
	protected def getDefaultResourceDescriptionStrategyClass(){
		return new TypeReference(grammar.runtimeBasePackage + '.resource.' + grammar.simpleName + 'DefaultResourceDescriptionStrategy')
	}
	
	protected def getAbstractResourceDescriptionStrategyClass(){
		return new TypeReference(grammar.runtimeBasePackage + '.resource.' + grammar.simpleName + 'AbstractResourceDescriptionStrategy')
	}

	protected def getResourceDescriptionStrategyClass(Grammar grammar){
		return new TypeReference(grammar.runtimeBasePackage + '.resource.' + grammar.simpleName + 'ResourceDescriptionStrategy')
	}

	protected def getStubResourceDescriptionStrategyClass(){
		return getResourceDescriptionStrategyClass(grammar)
	}

    protected def needsToInvokeSuperResourceDescriptionStrategy(){
		inheritImplementation && grammar.nonTerminalsSuperGrammar !== null
    }

	protected def getResourceDescriptionSuperClass(){
		val superGrammar = grammar.nonTerminalsSuperGrammar
		if (inheritImplementation && superGrammar !== null)
			return getResourceDescriptionStrategyClass(superGrammar)
		else
			return new TypeReference("org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy")
	}

	protected def contributeRuntimeGuiceBindings() {
		val bindingFactory = new GuiceModuleAccess.BindingFactory
		if(isGenerateStub || isGenerateXtendStub){
			bindingFactory.addTypeToType(IDefaultResourceDescriptionStrategy.typeRef(), getStubResourceDescriptionStrategyClass);
		} else {
			bindingFactory.addTypeToType(IDefaultResourceDescriptionStrategy.typeRef(), defaultResourceDescriptionStrategyClass);
		}
		bindingFactory.contributeTo(language.runtimeGenModule)
	}
	
	protected def getExportedRulesFromGrammar(){
		val alreadyCollected = newHashSet
		grammar.rules.filter[isExported && alreadyCollected.add(it.type.classifier)].toList
	}
	
	override generate() {
		val exportedRules = exportedRulesFromGrammar;
		if(exportedRules.shouldGenerateArtefacts) {
			contributeRuntimeGuiceBindings

			generateResourceDescriptionStrategy(exportedRules).writeTo(projectConfig.runtime.srcGen)
			generateResourceDescriptionStrategyStub(exportedRules)

			if (projectConfig.runtime.manifest !== null) {
				projectConfig.runtime.manifest.exportedPackages += grammar.resourceDescriptionStrategyClass.packageName
			}
		}
	}
	
	protected def shouldGenerateArtefacts(Iterable<AbstractRule> exportedRules) {
		return generate && !exportedRules.empty
	}
	
	protected def getSuperTypeRef(){
		if(isGenerateStub || isGenerateXtendStub) {
			abstractResourceDescriptionStrategyClass
		} else {
			defaultResourceDescriptionStrategyClass
		}
	}
	
	protected def generateResourceDescriptionStrategy(Iterable<AbstractRule> exportedRules){
		fileAccessFactory.createJavaFile(abstractResourceDescriptionStrategyClass, '''
		public class «superTypeRef.simpleName» extends «getResourceDescriptionSuperClass» {
			public boolean createEObjectDescriptions(«EObject» eObject, «IAcceptor»<«IEObjectDescription»> acceptor) {
				«FOR exportedRule : exportedRules»
					if(eObject instanceof «new TypeReference(exportedRule.type.classifier as EClass, grammar.eResource.resourceSet)») {
						return createEObjectDescriptionsFor«exportedRule.type.classifier.name»(eObject, acceptor);
					}
				«ENDFOR»
				«IF needsToInvokeSuperResourceDescriptionStrategy»
					return super.createEObjectDescriptions(eObject, acceptor);
				«ELSE»
					return true;
				«ENDIF»
			}
		
			«FOR exportedRule : exportedRules»
				protected boolean createEObjectDescriptionsFor«exportedRule.type.classifier.name»(«EObject» eObject, «IAcceptor»<«IEObjectDescription»> acceptor) {
					return super.createEObjectDescriptions(eObject, acceptor);
				}
			«ENDFOR»
		}
	''')
	}
		
	protected def generateResourceDescriptionStrategyStub(Iterable<AbstractRule> exportedRules) {
			if(isGenerateStub || isGenerateXtendStub){
				fileAccessFactory.createJavaFile(stubResourceDescriptionStrategyClass,'''
					public class «stubResourceDescriptionStrategyClass.simpleName» extends «abstractResourceDescriptionStrategyClass»{
					
					}
				''').writeTo(projectConfig.runtime.src)
			} else if(generateXtendStub) {
				fileAccessFactory.createXtendFile(stubResourceDescriptionStrategyClass,'''
					class «stubResourceDescriptionStrategyClass» extends «abstractResourceDescriptionStrategyClass»{
					
					}
				''').writeTo(projectConfig.runtime.src)
			}
	}
	
	protected def boolean isExported(AbstractRule rule) {
		return rule.getAnnotations().exists[AnnotationNames.EXPORTED.equals(name)];
	}
	
}