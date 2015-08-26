/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static org.eclipse.xtext.GrammarUtil.*

// TODO discuss API (remove setters?)
class XtextGeneratorNaming {
	
	@Accessors(PUBLIC_SETTER)
	String eclipsePluginActivator
	
	@Accessors(PUBLIC_SETTER)
	String runtimeBasePackage
	
	@Accessors(PUBLIC_SETTER)
	String eclipsePluginBasePackage
	
	@Accessors(PUBLIC_SETTER)
	String genericIdeBasePackage
	
	@Accessors(PUBLIC_SETTER)
	String ideaBasePackage
	
	Grammar myGrammar
	
	package def setGrammar(Grammar grammar) {
		myGrammar = grammar
	}
	
	def getRuntimeBasePackage(Grammar grammar) {
		if (grammar != myGrammar || runtimeBasePackage === null)
			return getNamespace(grammar)
		return runtimeBasePackage
	}
	
	def getRuntimeModule(Grammar grammar) {
		new TypeReference(grammar.runtimeBasePackage, getSimpleName(grammar) + 'RuntimeModule')
	}
	
	def getRuntimeGenModule(Grammar grammar) {
		new TypeReference(grammar.runtimeBasePackage, 'Abstract' + getSimpleName(grammar) + 'RuntimeModule')
	}
	
	def getRuntimeDefaultModule(Grammar grammar) {
		new TypeReference('org.eclipse.xtext.service.DefaultRuntimeModule')
	}
	
	def getRuntimeSetup(Grammar grammar) {
		new TypeReference(grammar.runtimeBasePackage, getSimpleName(grammar) + 'StandaloneSetup')
	}
	
	def getRuntimeGenSetup(Grammar grammar) {
		new TypeReference(grammar.runtimeBasePackage, getSimpleName(grammar) + 'StandaloneSetupGenerated')
	}
	
	def getEclipsePluginBasePackage(Grammar grammar) {
		if (grammar != myGrammar || eclipsePluginBasePackage === null)
			return getNamespace(grammar) + '.ui'
		return eclipsePluginBasePackage
	}
	
	def getEclipsePluginModule(Grammar grammar) {
		new TypeReference(grammar.eclipsePluginBasePackage, getSimpleName(grammar) + 'UiModule')
	}
	
	def getEclipsePluginGenModule(Grammar grammar) {
		new TypeReference(grammar.eclipsePluginBasePackage, 'Abstract' + getSimpleName(grammar) + 'UiModule')
	}
	
	def getEclipsePluginDefaultModule(Grammar grammar) {
		new TypeReference('org.eclipse.xtext.ui.DefaultUiModule')
	}
	
	def getEclipsePluginExecutableExtensionFactory(Grammar grammar) {
		new TypeReference(grammar.eclipsePluginBasePackage, getSimpleName(grammar) + 'ExecutableExtensionFactory')
	}
	
	def getEclipsePluginActivator(Grammar grammar) {
		if (grammar != myGrammar || eclipsePluginActivator === null) {
			return new TypeReference(grammar.eclipsePluginBasePackage + '.internal',getSimpleName(grammar) + 'Activator')
		}
		return new TypeReference(eclipsePluginActivator)
	}
	
	def getGenericIdeBasePackage(Grammar grammar) {
		if (grammar != myGrammar || genericIdeBasePackage === null)
			return getNamespace(grammar) + '.ide'
		return genericIdeBasePackage
	}
	
	def getGenericIdeModule(Grammar grammar) {
		new TypeReference(grammar.genericIdeBasePackage, getSimpleName(grammar) + 'IdeModule')
	}
	
	def getGenericIdeGenModule(Grammar grammar) {
		new TypeReference(grammar.genericIdeBasePackage, 'Abstract' + getSimpleName(grammar) + 'IdeModule')
	}
	
	def getIdeaBasePackage(Grammar grammar) {
		if (grammar != myGrammar || ideaBasePackage === null)
			return getNamespace(grammar) + ".idea"
		return ideaBasePackage
	}
	
	def getIdeaModule(Grammar grammar) {
		new TypeReference(grammar.ideaBasePackage, getSimpleName(grammar) + 'IdeaModule')
	}
	
	def getIdeaDefaultModule(Grammar grammar) {
		new TypeReference('org.eclipse.xtext.idea.DefaultIdeaModule')
	}
	
	def getIdeaGenModule(Grammar grammar) {
		new TypeReference(grammar.ideaBasePackage, 'Abstract' + getSimpleName(grammar) + 'IdeaModule')
	}
	
	def getIdeaStandaloneSetup(Grammar grammar) {
		new TypeReference(grammar.ideaBasePackage, getSimpleName(grammar) + "StandaloneSetupIdea")
	}
}