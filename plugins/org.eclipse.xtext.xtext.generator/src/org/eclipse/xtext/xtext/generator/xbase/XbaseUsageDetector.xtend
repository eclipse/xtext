package org.eclipse.xtext.xtext.generator.xbase

import java.util.Set
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.xtext.UsedRulesFinder
import static extension org.eclipse.xtext.xtext.generator.util.GrammarUtil2.*
class XbaseUsageDetector {
	
	def boolean inheritsXtype(Grammar grammar) {
		grammar.inherits('org.eclipse.xtext.xbase.Xtype')
	}
	
	def boolean inheritsXbase(Grammar grammar) {
		grammar.inherits('org.eclipse.xtext.xbase.Xbase')
	}

	def boolean inheritsXbaseWithAnnotations(Grammar grammar) {
		grammar.inherits('org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations')
	}

	def boolean usesXImportSection(Grammar grammar) {
		val Set<AbstractRule> usedRules = newHashSet
		new UsedRulesFinder(usedRules).compute(grammar)
		return usedRules.exists [
			name == 'XImportSection' && GrammarUtil.getGrammar(it).name == 'org.eclipse.xtext.xbase.Xtype'
		]
	}

}