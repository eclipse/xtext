/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.index

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xtext.AnnotationNames
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

/**
 * @author Holger Schill - Initial contribution and API
 */
class ResourceDescriptionStrategyFragment extends AbstractStubGeneratingFragment {
	
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
	
	protected def getStubResourceDescriptionStrategyClass(){
		return new TypeReference(grammar.runtimeBasePackage + '.resource.' + grammar.simpleName + 'ResourceDescriptionStrategy')
	}
	
	protected def getDefaultResourceDescriptionSuperClass(){
		return new TypeReference("org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy");
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
			generateResourceDescriptionStrategy(exportedRules)
			generateResourceDescriptionStrategyStub(exportedRules)
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
		fileAccessFactory.createJavaFile(abstractResourceDescriptionStrategyClass, generateResourceDescriptionStrategyContent(superTypeRef,exportedRules)).writeTo(projectConfig.runtime.srcGen)
	}
	
	protected def StringConcatenationClient generateResourceDescriptionStrategyContent(TypeReference superTypeRef, Iterable<AbstractRule> exportedRules) 
	'''
		public class «superTypeRef.simpleName» extends «defaultResourceDescriptionSuperClass» {
			public boolean createEObjectDescriptions(«EObject» eObject, «IAcceptor»<«IEObjectDescription»> acceptor) {
				«FOR exportedRule : exportedRules»
					if(eObject instanceof «new TypeReference(exportedRule.type.classifier as EClass, grammar.eResource.resourceSet)») {
						return createEObjectDescriptionsFor«exportedRule.type.classifier.name»(eObject, acceptor);
					}
				«ENDFOR»
				return true;
			}
		
			«FOR exportedRule : exportedRules»
				protected boolean createEObjectDescriptionsFor«exportedRule.type.classifier.name»(«EObject» eObject, «IAcceptor»<«IEObjectDescription»> acceptor) {
					return super.createEObjectDescriptions(eObject, acceptor);
				}
			«ENDFOR»
		}
	'''
		
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
		return rule.getAnnotations().stream().anyMatch(e | AnnotationNames.EXPORTED.equals(e.getName()));
	}
	
}