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
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xtext.AnnotationNames
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Holger Schill - Initial contribution and API
 */
class ResourceDescriptionStrategyFragment extends AbstractXtextGeneratorFragment {
	@Accessors
	boolean isGenerateStub = true;
	
	@Accessors
	boolean isGenerateXtendStub;
	
	@Inject extension XtextGeneratorNaming
	@Inject FileAccessFactory fileAccessFactory
	
	protected def getSuperResourceDescriptionStrategyClass(){
		return new TypeReference(grammar.runtimeBasePackage + '.index.' + grammar.simpleName + 'GeneratedResourceDescriptionStrategy')
	}
	
	protected def getStubResourceDescriptionStrategyClass(){
		return new TypeReference(grammar.runtimeBasePackage + '.index.' + grammar.simpleName + 'ResourceDescriptionStrategy')
	}
	
	protected def getDefaultResourceDescriptionSuperClass(){
		return new TypeReference("org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy");
	}
	
	protected def contributeRuntimeGuiceBindings() {
		val bindingFactory = new GuiceModuleAccess.BindingFactory
		if(generateStub || generateXtendStub){
			bindingFactory.addTypeToType(IDefaultResourceDescriptionStrategy.typeRef(), getStubResourceDescriptionStrategyClass);
		} else {
			bindingFactory.addTypeToType(IDefaultResourceDescriptionStrategy.typeRef(), superResourceDescriptionStrategyClass);
		}
		bindingFactory.contributeTo(language.runtimeGenModule)
	}
	
	protected def getExportedRulesFromGrammar(){
		grammar.rules.filter[isExported]
	}
	
	override generate() {
		val exportedRules = exportedRulesFromGrammar;
		if(exportedRules.shouldGenerate) {
			contributeRuntimeGuiceBindings
			generateResourceDescriptionStrategy(exportedRules)
		}
	}
	
	protected def shouldGenerate(Iterable<AbstractRule> exportedRules) {
		return !exportedRules.empty
	}
	
	protected def StringConcatenationClient generateSuperResourceDescriptionStrategyContent(Iterable<AbstractRule> exportedRules) {
		'''
			public class «superResourceDescriptionStrategyClass.simpleName» extends «defaultResourceDescriptionSuperClass» {
				public boolean createEObjectDescriptions(«EObject» eObject, «IAcceptor»<«IEObjectDescription»> acceptor) {
					«FOR exportedRule : exportedRules»
						if(eObject instanceof «new TypeReference(exportedRule.type.classifier as EClass, grammar.eResource.resourceSet)») {
							return createEObjectDescriptionsFor«exportedRule.type.classifier.name»(eObject, acceptor);
						}
					«ENDFOR»
					return true;
				}
			
				«FOR exportedRule : exportedRules»
					protected boolean createEObjectDescriptionsFor«exportedRule.type.classifier.name»(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
						return super.createEObjectDescriptions(eObject, acceptor);
					}
				«ENDFOR»
			}
		'''
	}
		
	protected def generateResourceDescriptionStrategy(Iterable<AbstractRule> exportedRules) {
			fileAccessFactory.createJavaFile(superResourceDescriptionStrategyClass, generateSuperResourceDescriptionStrategyContent(exportedRules)).writeTo(projectConfig.runtime.srcGen)
			if(generateStub && !generateXtendStub){
				fileAccessFactory.createJavaFile(stubResourceDescriptionStrategyClass,'''
					public class «stubResourceDescriptionStrategyClass.simpleName» extends «superResourceDescriptionStrategyClass»{
					
					}
				''').writeTo(projectConfig.runtime.src)
			} else if(generateXtendStub) {
				fileAccessFactory.createXtendFile(stubResourceDescriptionStrategyClass,'''
					class «stubResourceDescriptionStrategyClass» extends «superResourceDescriptionStrategyClass»{
					
					}
				''').writeTo(projectConfig.runtime.src)
			}
	}
	
	protected def boolean isExported(AbstractRule rule) {
		return rule.getAnnotations().stream().anyMatch(e | AnnotationNames.EXPORTED.equals(e.getName()));
	}
	
}