/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Singleton
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar

import static org.eclipse.xtext.GrammarUtil.*

@Singleton
class XtextGeneratorNaming {
	
	@Accessors(PUBLIC_SETTER)
	String eclipsePluginActivator
	
	def getPackage(String qualifiedName) {
		qualifiedName.substring(0, qualifiedName.lastIndexOf('.'))
	}
	
	def getSimple(String qualifiedName) {
		qualifiedName.substring(qualifiedName.lastIndexOf('.'))
	}
	
	def getRuntimeBasePackage(Grammar grammar) {
		getNamespace(grammar)
	}
	
	def getRuntimeModule(Grammar grammar) {
		grammar.runtimeBasePackage + '.' + getName(grammar) + 'RuntimeModule'
	}
	
	def getRuntimeGenModule(Grammar grammar) {
		grammar.runtimeBasePackage + '.Abstract' + getName(grammar) + 'RuntimeModule'
	}
	
	def getRuntimeDefaultModule(Grammar grammar) {
		'org.eclipse.xtext.service.DefaultRuntimeModule'
	}
	
	def getRuntimeSetup(Grammar grammar) {
		grammar.runtimeBasePackage + '.' + getName(grammar) + 'StandaloneSetup'
	}
	
	def getRuntimeGenSetup(Grammar grammar) {
		grammar.runtimeBasePackage + '.' + getName(grammar) + 'StandaloneSetupGenerated'
	}
	
	def getEclipsePluginBasePackage(Grammar grammar) {
		getNamespace(grammar) + '.ui'
	}
	
	def getEclipsePluginModule(Grammar grammar) {
		grammar.eclipsePluginBasePackage + '.' + getName(grammar) + 'UiModule'
	}
	
	def getEclipsePluginGenModule(Grammar grammar) {
		grammar.eclipsePluginBasePackage + '.' + 'Abstract' + getName(grammar) + 'UiModule'
	}
	
	def getEclipsePluginDefaultModule(Grammar grammar) {
		'org.eclipse.xtext.ui.DefaultUiModule'
	}
	
	def getEclipsePluginExecutableExtensionFactory(Grammar grammar) {
		grammar.eclipsePluginBasePackage + '.' + getName(grammar) + 'ExecutableExtensionFactory'
	}
	
	def getEclipsePluginActivator(Grammar grammar) {
		if (eclipsePluginActivator === null) {
			eclipsePluginActivator = grammar.eclipsePluginBasePackage + '.internal.' + getName(grammar) + 'Activator'
		}
		return eclipsePluginActivator
	}
	
}