/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Singleton
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static org.eclipse.xtext.GrammarUtil.*

@Singleton
class XtextGeneratorNaming {
	
	static val Map<String, XtextGeneratorNaming> registry = newHashMap
	
	static def XtextGeneratorNaming naming(Grammar g) {
		synchronized (registry) {
			if (registry.containsKey(g.name))
				return registry.get(g.name)
		}
		val naming = new XtextGeneratorNaming
		naming.setGrammar(g)
		return naming
	}
	
	Grammar grammar
	
	@Accessors(PUBLIC_SETTER)
	String eclipsePluginActivator
	
	@Accessors(PUBLIC_SETTER)
	String runtimeBasePackage
	
	@Accessors(PUBLIC_SETTER)
	String eclipsePluginBasePackage
	
	@Accessors(PUBLIC_SETTER)
	String genericIdeBasePackage
	
	protected def void setGrammar(Grammar grammar) {
		this.grammar = grammar
		synchronized (registry) {
			registry.put(grammar.name, this)
		}
	}
	
	def getRuntimeBasePackage() {
		if (runtimeBasePackage === null)
			runtimeBasePackage = getNamespace(grammar)
		return runtimeBasePackage
	}
	
	def getRuntimeModule() {
		new TypeReference(getRuntimeBasePackage, getName(grammar) + 'RuntimeModule')
	}
	
	def getRuntimeGenModule() {
		new TypeReference(getRuntimeBasePackage, 'Abstract' + getName(grammar) + 'RuntimeModule')
	}
	
	def getRuntimeDefaultModule() {
		new TypeReference('org.eclipse.xtext.service.DefaultRuntimeModule')
	}
	
	def getRuntimeSetup() {
		new TypeReference(getRuntimeBasePackage, getName(grammar) + 'StandaloneSetup')
	}
	
	def getRuntimeGenSetup() {
		new TypeReference(getRuntimeBasePackage, getName(grammar) + 'StandaloneSetupGenerated')
	}
	
	def getEclipsePluginBasePackage() {
		if (eclipsePluginBasePackage === null)
			eclipsePluginBasePackage = getNamespace(grammar) + '.ui'
		return eclipsePluginBasePackage
	}
	
	def getEclipsePluginModule() {
		new TypeReference(getEclipsePluginBasePackage, getName(grammar) + 'UiModule')
	}
	
	def getEclipsePluginGenModule() {
		new TypeReference(getEclipsePluginBasePackage, 'Abstract' + getName(grammar) + 'UiModule')
	}
	
	def getEclipsePluginDefaultModule() {
		new TypeReference('org.eclipse.xtext.ui.DefaultUiModule')
	}
	
	def getEclipsePluginExecutableExtensionFactory() {
		new TypeReference(getEclipsePluginBasePackage, getName(grammar) + 'ExecutableExtensionFactory')
	}
	
	def getEclipsePluginActivator() {
		if (eclipsePluginActivator === null) {
			eclipsePluginActivator = getEclipsePluginBasePackage + '.internal.' + getName(grammar) + 'Activator'
		}
		return new TypeReference(eclipsePluginActivator)
	}
	
	def getGenericIdeBasePackage() {
		if (genericIdeBasePackage === null)
			genericIdeBasePackage = getNamespace(grammar) + '.ide'
		return genericIdeBasePackage
	}
	
	def getGenericIdeModule() {
		new TypeReference(getGenericIdeBasePackage, getName(grammar) + 'IdeModule')
	}
	
	def getGenericIdeGenModule() {
		new TypeReference(getGenericIdeBasePackage, 'Abstract' + getName(grammar) + 'IdeModule')
	}
	
}