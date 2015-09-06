/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.generator.parser.antlr

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CompoundElement
import org.eclipse.xtext.EnumLiteralDeclaration
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Group
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.UnorderedGroup
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*
import org.eclipse.xtext.RuleNames

@Singleton
class GrammarAccessExtensions {

	@Inject
	extension GrammarAccess

	dispatch def grammarElementIdentifier(EObject it) {
		"Unsupported : grammarElementIdentifier for: " + toString
	}

	dispatch def grammarElementIdentifier(AbstractRule it) {
		gaRuleIdentifyer
	}

	dispatch def String grammarElementIdentifier(AbstractElement it) {
		containingRule.grammarElementIdentifier + '_' +  gaElementIdentifyer
	}

	dispatch def grammarElementAccess(EObject it) {
		"Unsupported : grammarElementAccess for: " + toString
	}

	dispatch def grammarElementAccess(AbstractRule it) {
		gaRuleAccessor
	}

	dispatch def grammarElementAccess(AbstractElement it) {
		gaRuleElementAccessor
	}

	def List<String> initialHiddenTokens(Grammar it) {
		if (definesHiddenTokens) {
			return hiddenTokens.map[ruleName].toList
		}
		if (usedGrammars.size == 1) {
			return initialHiddenTokens(usedGrammars.head)
		}
		emptyList
	}

	def ruleName(AbstractRule rule) {
		val ruleNames = RuleNames.tryGetRuleNames(rule)
		return ruleNames?.getAntlrRuleName(rule)?:AntlrGrammarGenUtil.getRuleName(rule)
	}

	def entryRuleName(ParserRule rule) {
		return AntlrGrammarGenUtil.getEntryRuleName(rule)
	}

	def isCalled(AbstractRule rule, Grammar grammar) {
		val allRules = grammar.allRules
		allRules.indexOf(rule) == 0 || allRules.map [
			GrammarUtil.containedRuleCalls(it)
		].flatten.exists[ruleCall | ruleCall.rule == rule]
	}

	def definesUnorderedGroups(ParserRule it, AntlrOptions options) {
		options.backtrack && !eAllContentsAsList.typeSelect(UnorderedGroup).empty
	}

	dispatch def mustBeParenthesized(AbstractElement it) { true }

	dispatch def mustBeParenthesized(Keyword it) { predicated() || firstSetPredicated || cardinality != null }

	dispatch def mustBeParenthesized(RuleCall it) { predicated() || firstSetPredicated || cardinality != null }
	
	dispatch def boolean predicated(AbstractElement it) {
		predicated
	}
	
	dispatch def boolean predicated(Assignment it) {
		predicated || terminal.predicated()
	}
	
	dispatch def boolean predicated(RuleCall it) {
		predicated || {
			val group  = rule.alternatives
			if (group instanceof Group) {
				group.elements.head.predicated()
			} else {
				false
			}
		}
	}

	def AbstractElement predicatedElement(AbstractElement it) {
		return AntlrGrammarGenUtil.getPredicatedElement(it)
	}

	def localVar(Assignment it, AbstractElement terminal) {
		'lv_' + feature + '_' + containingParserRule.contentsAsList.indexOf(it) + '_' +
			eAllContentsAsList.indexOf(terminal)
	}

	dispatch def localVar(RuleCall it) {
		'this_' + (rule.originalElement as AbstractRule).name + '_' + containingParserRule.contentsAsList.indexOf(it)
	}

	dispatch def localVar(AbstractElement it) {
		val rule = containingParserRule
		val index = rule.contentsAsList.indexOf(it)
		'otherlv_' + index
	}

	dispatch def localVar(EnumLiteralDeclaration it) {
		'enumLiteral_' + containingEnumRule.alternatives.contentsAsList.indexOf(it)
	}

	dispatch def List<AbstractElement> contentsAsList(ParserRule it) {
		alternatives.contentsAsList
	}

	dispatch def List<AbstractElement> contentsAsList(AbstractElement it) {
		newArrayList(it)
	}

	dispatch def List<AbstractElement> contentsAsList(CompoundElement it) {
		elements.map[contentsAsList].flatten.toList
	}

	dispatch def List<AbstractElement> contentsAsList(UnorderedGroup it) {
		val result = <AbstractElement>newArrayList(it)
		result += elements.map[contentsAsList].flatten.toList
		result
	}

	def setOrAdd(Action it) {
		if(operator == '+=') 'add' else 'set'
	}

	def setOrAdd(Assignment it) {
		if(operator == '+=') 'add' else 'set'
	}

	def toStringLiteral(AbstractElement it) {
		switch it {
			RuleCall case rule != null: '''"«rule.name»"'''
			Keyword: '''"«value.toStringInAntlrAction»"'''
			default:
				"null"
		}
	}

}
