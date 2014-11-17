package org.eclipse.xtext.idea.generator.parser.antlr

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.Alternatives
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CompoundElement
import org.eclipse.xtext.EnumLiteralDeclaration
import org.eclipse.xtext.EnumRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Group
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.UnorderedGroup
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*

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

	dispatch def ruleName(ParserRule it) { 'rule' + name }

	dispatch def ruleName(EnumRule it) { 'rule' + name }

	dispatch def ruleName(TerminalRule it) { 'RULE_' + name.toUpperCase() }

	dispatch def ruleName(AbstractRule it) { 'Unsupported' }

	def entryRuleName(ParserRule it) { 'entryRule' + name }

	def isCalled(AbstractRule rule, Grammar grammar) {
		val allRules = grammar.allRules
		allRules.indexOf(rule) == 0 || allRules.map [
			eAllContentsAsList
		].flatten.filter(RuleCall).filter[rule != null].map[rule].toList.contains(rule)
	}

	def definesUnorderedGroups(ParserRule it, AntlrOptions options) {
		options.backtrack && !eAllContentsAsList.typeSelect(UnorderedGroup).empty
	}

	dispatch def mustBeParenthesized(AbstractElement it) { true }

	dispatch def mustBeParenthesized(Group it) { true }

	dispatch def mustBeParenthesized(UnorderedGroup it) { true }

	dispatch def mustBeParenthesized(Alternatives it) { true }

	dispatch def mustBeParenthesized(EnumLiteralDeclaration it) { true }

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

	dispatch def AbstractElement predicatedElement(AbstractElement it) { it }

	dispatch def AbstractElement predicatedElement(Assignment it) { if(predicated) it else terminal.predicatedElement }

	dispatch def AbstractElement predicatedElement(RuleCall it) {
		if (predicated) {
			it
		} else {
			(rule.alternatives as Group).elements.head.predicatedElement
		}
	}

	def localVar(Assignment it, AbstractElement terminal) {
		'lv_' + feature + '_' + containingParserRule.contentsAsList.indexOf(it) + '_' +
			eAllContentsAsList.indexOf(terminal)
	}

	dispatch def localVar(RuleCall it) {
		'this_' + rule.name + '_' + containingParserRule.contentsAsList.indexOf(it)
	}

	dispatch def localVar(AbstractElement it) {
		val index = containingParserRule.contentsAsList.indexOf(it)
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

	def isBoolean(Assignment it) {
		operator == "?="
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
