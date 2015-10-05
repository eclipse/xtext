/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.normalization

import com.google.common.collect.HashMultimap
import com.google.common.collect.ImmutableSet
import com.google.common.collect.Maps
import com.google.common.collect.Multimap
import com.google.common.collect.Sets
import java.util.Collection
import java.util.Collections
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.CompoundElement
import org.eclipse.xtext.Condition
import org.eclipse.xtext.EnumRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Group
import org.eclipse.xtext.Parameter
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.XtextPackage
import org.eclipse.xtext.util.internal.EmfAdaptable
import org.eclipse.xtext.xtext.ConditionEvaluator
import org.eclipse.xtext.xtext.RuleNames
import org.eclipse.xtext.xtext.UsedRulesFinder

import static extension org.eclipse.xtext.xtext.generator.normalization.RuleWithParameterValues.*

/** 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@EmfAdaptable
class FlattenedGrammarAccess {

	@Accessors
	val Grammar flattenedGrammar

	new(RuleNames names, RuleFilter filter) {
		val grammar = names.contextGrammar
		var flattenedGrammar = copy(grammar)
		flattenedGrammar.name = grammar.name
		var origToCopy = Maps.newLinkedHashMap()
		val copies = copyRuleStubs(names, origToCopy, filter.getRules(grammar))
		flattenedGrammar.rules += copies
		var calledFrom = copyRuleBodies(copies, origToCopy)
		flattenedGrammar.setHiddenTokens(grammar, origToCopy)
		markAsFragment(calledFrom)
		if (filter.isDiscardUnreachableRules()) {
			var Set<AbstractRule> usedRules = newHashSet()
			if (!filter.isDiscardTerminalRules()) {
				usedRules.addAll(GrammarUtil.allTerminalRules(flattenedGrammar))
			}
			var UsedRulesFinder finder = new UsedRulesFinder(usedRules)
			finder.compute(flattenedGrammar)
			flattenedGrammar.rules.retainAll(usedRules)
		}
		this.flattenedGrammar = flattenedGrammar
		new OriginalGrammar(grammar).attachToEmfObject(flattenedGrammar)
	}

	def private void setHiddenTokens(
			Grammar copy, Grammar orig,
			Map<RuleWithParameterValues, AbstractRule> origToCopy
	) {
		if (orig === null) {
			copy.definesHiddenTokens = true
		} else if (!orig.isDefinesHiddenTokens) {
			copy.setHiddenTokens(orig.usedGrammars.head, origToCopy)
		} else {
			copy.definesHiddenTokens = true
			copy.hiddenTokens += orig.hiddenTokens.map [ hidden |
				origToCopy.get(new RuleWithParameterValues(hidden)) 
			]
		}
	}

	def private void markAsFragment(Multimap<TerminalRule, AbstractRule> calledFrom) {
		calledFrom.keySet.filter[
			!isFragment
		].filter[
			allAreTerminalRules(calledFrom.get(it))
		].filter[
			!(it.eContainer as Grammar).hiddenTokens.contains(it)
		].forEach[
			fragment=true
		]
	}

	def private Multimap<TerminalRule, AbstractRule> copyRuleBodies(
			List<AbstractRule> copies,
			Map<RuleWithParameterValues, AbstractRule> origToCopy
	) {
		val calledFrom = HashMultimap.create()
		for (copy : copies) {
			var orig = copy.originalRule
			val paramValues = copy.paramValues
			var EcoreUtil.Copier copier = new EcoreUtil.Copier() {
				override protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
					if (eReference === XtextPackage.Literals.RULE_CALL__RULE) {
						var origRuleCall = eObject as RuleCall
						var copyRuleCall = copyEObject as RuleCall
						var calledCopy = origToCopy.get(
							new RuleWithParameterValues(origRuleCall.getRule(),	getParameterConfig(origRuleCall, copyRuleCall)))
						copyRuleCall.rule = calledCopy
						if (calledCopy instanceof TerminalRule) {
							calledFrom.put(calledCopy, copy)
						}
					} else {
						super.copyReference(eReference, eObject, copyEObject)
					}
				}

				def private Set<Parameter> getParameterConfig(RuleCall origRuleCall, RuleCall copyRuleCall) {
					if(origRuleCall.getArguments().isEmpty())
						return Collections.emptySet()
					var result = origRuleCall.arguments.filter [ value.evaluate ].map[ parameter ].toSet
					return result
				}

				override protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
					switch(eReference) {
						case XtextPackage.Literals.RULE_CALL__ARGUMENTS,
						case XtextPackage.Literals.GROUP__GUARD_CONDITION: return
						default: super.copyContainment(eReference, eObject, copyEObject)  
					}
				}

				override EObject copy(EObject eObject) {
					if (eObject instanceof Group) {
						var Group group = eObject
						if (group.getGuardCondition() !== null) {
							if (!evaluate(group.getGuardCondition())) {
								return null
							}

						}
					}
					var result = super.copy(eObject)
					if (result instanceof CompoundElement) {
						var List<AbstractElement> elements = result.getElements()
						if (elements.size() === 1) {
							if (!result.isFirstSetPredicated && !result.isPredicated) {
								var element = elements.get(0)
								element.mergeCardinalities(result)
								element.mergePredicates(result)
								return element
							} else {
								var element = elements.get(0)
								result.mergeCardinalities(element)
								result.mergePredicates(element)
								element.firstSetPredicated = false
								element.predicated = false
							}
						}
					}
					if (eObject instanceof AbstractElement) {
						var original = new OriginalElement(eObject)
						if (eObject.eClass != result.eClass) {
							throw new IllegalStateException("copy is: '" + result.eClass.name + "' but original was: '" + eObject.eClass.name + "'")
						}
						original.attachToEmfObject(result)
					}
					return result
				}

				def private void mergePredicates(AbstractElement into, AbstractElement from) {
					if (from.isPredicated()) {
						into.setPredicated(true)
						into.setFirstSetPredicated(false)
					} else if (!into.isPredicated() && from.isFirstSetPredicated()) {
						into.setFirstSetPredicated(true)
					}
				}

				def private void mergeCardinalities(AbstractElement into, AbstractElement from) {
					var c1 = into.cardinality
					var c2 = from.cardinality
					into.cardinality = switch c1 {
						case c1 == '*' || c2 == '*',
						case c1 == '+' && c2 == '?',
						case c1 == '?' && c2 == '+': '*'
						case null: c2
						default: c1 
					}
				}

				def private boolean evaluate(Condition condition) {
					var result = new ConditionEvaluator(paramValues).evaluate(condition)
					return result
				}
			}
			var copiedBody = copier.copy(orig.alternatives) as AbstractElement
			copier.copyReferences()
			copy.alternatives = copiedBody
			if (orig instanceof ParserRule) {
				var ParserRule castedCopy = copy as ParserRule
				if (orig.isDefinesHiddenTokens) {
					castedCopy.definesHiddenTokens = true
					for (AbstractRule rule : orig.hiddenTokens) {
						val copiedTerminalRule = origToCopy.get(new RuleWithParameterValues(rule))
						castedCopy.hiddenTokens += copiedTerminalRule
						calledFrom.put(copiedTerminalRule as TerminalRule, castedCopy)
					}
				}
			}
		}
		return calledFrom
	}

	def private copyRuleStubs(
		RuleNames names,
		Map<RuleWithParameterValues, AbstractRule> origToCopy,
		List<AbstractRule> rulesToCopy
	) {
		val result = <AbstractRule>newArrayList
		for (AbstractRule rule : rulesToCopy) {
			var String ruleName = names.getAntlrRuleName(rule)
			switch rule {
				ParserRule: {
					var List<Parameter> params = rule.parameters
					if (params.isEmpty) {
						var copy = copy(rule)
						copy.name = ruleName
						copy.fragment = rule.isFragment
						copy.wildcard = rule.isWildcard
						copy.attachTo(rule, origToCopy)
						result += copy
					} else {
						Sets.powerSet(ImmutableSet.copyOf(params)).forEach[ parameterConfig, i |
							var parameterValues = new RuleWithParameterValues(rule, parameterConfig)
							var copy = copy(rule)
							copy.name = names.getAntlrRuleName(rule, i)
							copy.fragment = rule.isFragment
							copy.wildcard = rule.isWildcard
							origToCopy.put(parameterValues, copy)
							parameterValues.attachToEmfObject(copy)
							result += copy
						]
					}
				}
				TerminalRule: {
					var orig = rule
					var copy = copy(orig)
					copy.name = ruleName
					copy.fragment = orig.isFragment
					copy.attachTo(orig, origToCopy)
					result += copy
				}
				EnumRule: {
					var copy = copy(rule)
					copy.name = ruleName
					copy.attachTo(rule, origToCopy)
					result += copy
				}
			}
		}
		return result
	}
	
	def private attachTo(AbstractRule copy, AbstractRule orig, Map<RuleWithParameterValues, AbstractRule> origToCopy) {
		var parameterValues = new RuleWithParameterValues(orig)
		parameterValues.attachToEmfObject(copy)
		origToCopy.put(parameterValues, copy)
	}

	def private boolean allAreTerminalRules(Collection<AbstractRule> callers) {
		return callers.forall[ it instanceof TerminalRule ]
	}

	def private <T extends EObject> T copy(T t) {
		var T result = EcoreUtil.create(t.eClass()) as T
		return result
	}

}
