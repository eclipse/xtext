/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static org.eclipse.xtext.GrammarUtil.*

/**
 * @noreference
 */
class XtextGeneratorNaming {
	
	def getRuntimeBasePackage(Grammar grammar) {
		return getNamespace(grammar)
	}
	
	def getRuntimeTestBasePackage(Grammar grammar) {
		grammar.runtimeBasePackage + ".tests"
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
		return getNamespace(grammar) + '.ui'
	}
	
	def getEclipsePluginTestBasePackage(Grammar grammar) {
		grammar.eclipsePluginBasePackage + ".tests"
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
		return new TypeReference(grammar.eclipsePluginBasePackage + '.internal',getSimpleName(grammar) + 'Activator')
	}
	
	def getGenericIdeBasePackage(Grammar grammar) {
		return getNamespace(grammar) + '.ide'
	}
	
	def getGenericIdeModule(Grammar grammar) {
		new TypeReference(grammar.genericIdeBasePackage, getSimpleName(grammar) + 'IdeModule')
	}
	
	def getGenericIdeGenModule(Grammar grammar) {
		new TypeReference(grammar.genericIdeBasePackage, 'Abstract' + getSimpleName(grammar) + 'IdeModule')
	}
	
	def getIdeaBasePackage(Grammar grammar) {
		return getNamespace(grammar) + ".idea"
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
	
	def getWebBasePackage(Grammar grammar) {
		return getNamespace(grammar) + ".web"
	}
	
	def getWebModule(Grammar grammar) {
		new TypeReference(grammar.webBasePackage, getSimpleName(grammar) + 'WebModule')
	}
	
	def getWebDefaultModule(Grammar grammar) {
		new TypeReference('org.eclipse.xtext.web.server.DefaultWebModule')
	}
	
	def getWebGenModule(Grammar grammar) {
		new TypeReference(grammar.webBasePackage, 'Abstract' + getSimpleName(grammar) + 'WebModule')
	}
	
	def getWebSetup(Grammar grammar) {
		new TypeReference(grammar.webBasePackage, getSimpleName(grammar) + 'WebSetup')
	}
	
}