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
		binder.bind(LanguageConfig2).toInstance(language)
	}
	
	def configureNaming(Binder binder) {
		binder.bind(XtextGeneratorNaming).toInstance(language.naming)
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