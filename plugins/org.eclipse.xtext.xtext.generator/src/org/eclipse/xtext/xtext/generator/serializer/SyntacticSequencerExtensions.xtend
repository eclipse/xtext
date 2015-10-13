/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.serializer

import com.google.inject.Inject
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias
import org.eclipse.xtext.serializer.analysis.IContextPDAProvider
import org.eclipse.xtext.serializer.analysis.IContextTypePDAProvider
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynFollowerOwner
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions

class SyntacticSequencerExtensions {
	
	@Inject IContextPDAProvider contextPDAProvider
	@Inject IContextTypePDAProvider contextTypePDAProvider
	@Inject ISyntacticSequencerPDAProvider pdaProvider
	@Inject extension GrammarAccessExtensions
	@Inject Grammar grammar
	@Inject InjectableRuleNames ruleNames

	List<EqualAmbiguousTransitions> ambiguousTransitions

	def protected List<ISynAbsorberState> getAllPDAs() {
		var List<ISynAbsorberState> result = newArrayList
		for (context : contextPDAProvider.getAllContexts(grammar)) {
			for (type : contextTypePDAProvider.getTypesForContext(grammar, context)) {
				result.add(pdaProvider.getPDA(context, type))
			}
		}
		return result
	}

	def protected void collectAllAmbiguousTransitions(ISynFollowerOwner state, Set<ISynTransition> result,
			Set<Object> visited) {
		if (!visited.add(state))
			return;
		if (state instanceof ISynTransition && (state as ISynTransition).isSyntacticallyAmbiguous)
			result.add(state as ISynTransition)
		if (state instanceof ISynAbsorberState) {
			for (trans : state.outTransitions) {
				collectAllAmbiguousTransitions(trans, result, visited)
			}
		} else {
			for (follower : state.followers) {
				collectAllAmbiguousTransitions(follower, result, visited)
			}
		}
	}

	def Set<ISynTransition> getAllAmbiguousTransitions() {
		val Set<ISynTransition> result = newLinkedHashSet
		for (start : allPDAs)
			collectAllAmbiguousTransitions(start, result, newHashSet)
		return result
	}

	def List<EqualAmbiguousTransitions> getAllAmbiguousTransitionsBySyntax() {
		if (ambiguousTransitions !== null)
			return ambiguousTransitions
		val Map<AbstractElementAlias, EqualAmbiguousTransitions> result = newHashMap
		for (transition : allAmbiguousTransitions) {
			for (syntax : transition.ambiguousSyntaxes) {
				var list = result.get(syntax)
				if (list === null) {
					list = new EqualAmbiguousTransitions(elementAliasToIdentifier(syntax), syntax)
					result.put(syntax, list)
				}
				list.transitions.add(transition)
			}
		}
		ambiguousTransitions = newArrayList(result.values)
		ambiguousTransitions.sortInplace
		return ambiguousTransitions
	}

	def protected String elementAliasToIdentifier(AbstractElementAlias alias, Set<String> rules, boolean isNested) {
		var card =
			if (alias.isMany && alias.isOptional)
				'a'
			else if (alias.isMany)
				'p'
			else if (alias.isOptional)
				'q'
		if (alias instanceof TokenAlias) {
			rules.add(ruleNames.getUniqueRuleName(GrammarUtil.containingRule(alias.token)))
			card = if (card === null) '' else '_' + card
			return alias.token.gaElementIdentifier + card
		} else if (alias instanceof GroupAlias) {
			val List<String> children = newArrayList
			for (child : alias.children) {
				children.add(elementAliasToIdentifier(child, rules, true))
			}
			val body = children.join('_')
			if (isNested || card !== null) {
				card = card ?: ''
				return '__' + body + '__' + card
			} else
				return body
		} else if (alias instanceof AlternativeAlias) {
			val List<String> children = newArrayList
			for (child : alias.children) {
				children.add(elementAliasToIdentifier(child, rules, true))
			}
			children.sortInplace
			val body = children.join('_or_')
			if (isNested || card !== null) {
				card = card ?: ''
				return '__' + body + '__' + card
			} else
				return body
		}
		throw new RuntimeException('unknown element')
	}

	def StringConcatenationClient elementAliasToConstructor(AbstractElementAlias alias) {
		val many = String.valueOf(alias.isMany)
		val optional = String.valueOf(alias.isOptional)
		if (alias instanceof TokenAlias) {
			return '''new «TokenAlias»(«many», «optional», grammarAccess.«alias.token.gaAccessor»)'''
		} else if (alias instanceof GroupAlias) {
			val List<StringConcatenationClient> children = newArrayList
			for (child : alias.children) {
				children.add(elementAliasToConstructor(child))
			}
			return '''new «GroupAlias»(«many», «optional», «FOR c : children SEPARATOR ', '»«c»«ENDFOR»)'''
		} else if (alias instanceof AlternativeAlias) {
			val List<StringConcatenationClient> children = newArrayList
			for (child : alias.children) {
				children.add(elementAliasToConstructor(child))
			}
			children.sortInplaceBy['''«it»''']
			return '''new «AlternativeAlias»(«many», «optional», «FOR c : children SEPARATOR ', '»«c»«ENDFOR»)'''
		}
		throw new RuntimeException('unknown element')
	}

	def protected String elementAliasToIdentifier(AbstractElementAlias alias) {
		val Set<String> rulesSet = newHashSet
		val body = elementAliasToIdentifier(alias, rulesSet, false)
		val List<String> rulesList = newArrayList(rulesSet)
		rulesList.sortInplace
		val rule = rulesList.join('_')
		return rule + '_' + body
	}
	
}
