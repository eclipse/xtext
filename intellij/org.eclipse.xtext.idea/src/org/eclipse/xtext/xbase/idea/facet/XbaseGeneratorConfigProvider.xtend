/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.facet

import com.google.inject.Inject
import com.intellij.openapi.module.Module
import com.intellij.openapi.util.Computable
import com.intellij.pom.java.LanguageLevel
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.idea.facet.FacetProvider
import org.eclipse.xtext.idea.resource.ModuleProvider
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.compiler.JavaVersion

import static com.intellij.openapi.application.ApplicationManager.*

import static extension com.intellij.openapi.module.EffectiveLanguageLevelUtil.*
import com.intellij.openapi.diagnostic.Logger
import org.eclipse.xtext.LanguageInfo

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XbaseGeneratorConfigProvider implements IGeneratorConfigProvider {
	
	@Inject FacetProvider facetProvider
	@Inject LanguageInfo languageInfo
	
	override get(EObject context) {
		val module = ModuleProvider.findModule(context.eResource.resourceSet)
		val facet = facetProvider.getFacet(module)
		val facetConfiguration = facet?.configuration
		if(facetConfiguration instanceof XbaseFacetConfiguration) {
			val state = facetConfiguration.state
			return new GeneratorConfig => [
				generatedAnnotationComment = state.generatedAnnotationComment
				generateGeneratedAnnotation = state.generateGeneratedAnnotation
				generateSyntheticSuppressWarnings = state.generateSuppressWarnings
				includeDateInGeneratedAnnotation = state.includeDateInGenerated
				javaSourceVersion = getTargetJavaVersion(state, module)
			]
		}
		return new GeneratorConfig
	}
	
	protected def getTargetJavaVersion(XbaseGeneratorConfigurationState state, Module module) {
		val version = state.targetJavaVersion
		val languageLevel = 
			if(version == null || version.equals('Module default')) {
				val Computable<LanguageLevel> action = [  
					module.effectiveLanguageLevel
				]
				application.runReadAction(action)
			}
			else
				LanguageLevel.values.findFirst[presentableText == version]
		switch languageLevel {
			case JDK_1_3, case JDK_1_4: {
				Logger.getInstance(class).warn(languageInfo.shortName + ' requires Java language level 1.5 or higher. Using Java 1.5.')
				JavaVersion.JAVA5
			} 
			case JDK_1_5: JavaVersion.JAVA5
			case JDK_1_6: JavaVersion.JAVA6
			case JDK_1_7: JavaVersion.JAVA7
			default: JavaVersion.JAVA8
		}
	}
}
