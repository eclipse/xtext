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
import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.xtext.RuleNames

/**
 * Language-specific Guice module that is used in a child injector of the global injector
 * derived from {@link DefaultGeneratorModule}.
 */
@FinalFieldsConstructor
package class LanguageModule extends AbstractGenericModule {
	
	val XtextGeneratorLanguage language
	
	def void configureLanguage(Binder binder) {
		binder.bind(IXtextGeneratorLanguage).toProvider[language]
	}
	
	def void configureGrammar(Binder binder) {
		binder.bind(Grammar).toProvider[language.grammar]
	}
	
	def void configureRuleNames(Binder binder) {
		binder.bind(RuleNames).toProvider[language.ruleNames]
	}
	
	def void configureAdditionalBindings(Binder binder) {
		binder.install(language.guiceModule)
	}
	
}