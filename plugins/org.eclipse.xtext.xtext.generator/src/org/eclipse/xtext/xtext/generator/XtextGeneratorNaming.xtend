/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtext.Grammar

import static org.eclipse.xtext.GrammarUtil.*

class XtextGeneratorNaming {
	
	def getRuntimeBasePackage(Grammar grammar) {
		getNamespace(grammar)
	}
	
	def getRuntimeGuiceModuleSimple(Grammar grammar) {
		getName(grammar) + 'RuntimeModule'
	}
	
	def getRuntimeGuiceModuleFull(Grammar grammar) {
		grammar.runtimeBasePackage + grammar.runtimeGuiceModuleSimple
	}
	
	def getRuntimeSetupSimple(Grammar grammar) {
		getName(grammar) + 'StandaloneSetup'
	}
	
	def getRuntimeSetupFull(Grammar grammar) {
		grammar.runtimeBasePackage + grammar.runtimeSetupSimple
	}
	
	def getRuntimeSetupImplSimple(Grammar grammar) {
		getName(grammar) + 'StandaloneSetupGenerated'
	}
	
	def getRuntimeSetupImplFull(Grammar grammar) {
		grammar.runtimeBasePackage + grammar.runtimeSetupImplSimple
	}
	
}