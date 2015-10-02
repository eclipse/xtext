/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Binder
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.RuleNames
import org.eclipse.xtext.service.AbstractGenericModule

@FinalFieldsConstructor
class LanguageModule extends AbstractGenericModule {
	
	val LanguageConfig2 language
	
	def configureLanguage(Binder binder) {
		binder.bind(ILanguageConfig).toInstance(language)
	}
	
	def configureGrammar(Binder binder) {
		binder.bind(Grammar).toProvider[language.grammar]
	}
	
	def configureRuleNames(Binder binder) {
		binder.bind(RuleNames).toProvider[language.ruleNames]
	}
	
	def configureAdditionalBindings(Binder binder) {
		binder.install(language.guiceModule)
	}
	
}