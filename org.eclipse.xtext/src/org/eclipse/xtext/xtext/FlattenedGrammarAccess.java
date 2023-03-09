/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.*;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.Condition;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FlattenedGrammarAccess {
	private final Grammar flattenedGrammar;

	public FlattenedGrammarAccess(RuleNames names, RuleFilter filter) {
		Grammar grammar = names.getContextGrammar();
		Grammar flattenedGrammar = copy(grammar);
		flattenedGrammar.setName(grammar.getName());
		Map<RuleWithParameterValues, AbstractRule> origToCopy = new LinkedHashMap<>();
		List<AbstractRule> copies = copyRuleStubs(names, origToCopy, filter.getRules(grammar),
				filter.isDiscardRuleTypeRef());
		addAll(flattenedGrammar.getRules(), copies);
		Multimap<TerminalRule, AbstractRule> calledFrom = copyRuleBodies(copies, origToCopy);
		setHiddenTokens(flattenedGrammar, grammar, origToCopy);
		markAsFragment(calledFrom);
		if (filter.isDiscardUnreachableRules()) {
			Set<AbstractRule> usedRules = new HashSet<>();
			if (!filter.isDiscardTerminalRules())
				usedRules.addAll(GrammarUtil.allTerminalRules(flattenedGrammar));
			UsedRulesFinder finder = new UsedRulesFinder(usedRules);
			finder.compute(flattenedGrammar);
			flattenedGrammar.getRules().retainAll(usedRules);
		}
		this.flattenedGrammar = flattenedGrammar;
		new OriginalGrammar(grammar).attachToEmfObject(flattenedGrammar);
	}

	private void setHiddenTokens(Grammar copy, Grammar orig, Map<RuleWithParameterValues, AbstractRule> origToCopy) {
		if (orig == null) {
			copy.setDefinesHiddenTokens(true);
			return;
		}
		if (!orig.isDefinesHiddenTokens()) {
			setHiddenTokens(copy, head(orig.getUsedGrammars()), origToCopy);
			return;
		}
		copy.setDefinesHiddenTokens(true);
		addAll(copy.getHiddenTokens(), Lists.transform(orig.getHiddenTokens(),
				hidden -> origToCopy.get(new RuleWithParameterValues(hidden))));
	}

	private void markAsFragment(Multimap<TerminalRule, AbstractRule> calledFrom) {
		FluentIterable.from(calledFrom.keySet()).filter(it -> !it.isFragment())
				.filter(it -> allAreTerminalRules(calledFrom.get(it)))
				.filter(it -> !((Grammar) it.eContainer()).getHiddenTokens().contains(it))
				.forEach(it -> it.setFragment(true));
	}

	private Multimap<TerminalRule, AbstractRule> copyRuleBodies(List<AbstractRule> copies,
			Map<RuleWithParameterValues, AbstractRule> origToCopy) {
		HashMultimap<TerminalRule, AbstractRule> calledFrom = HashMultimap.create();
		for (AbstractRule copy : copies) {
			AbstractRule orig = RuleWithParameterValues.getOriginalRule(copy);
			Set<Parameter> paramValues = RuleWithParameterValues.getParamValues(copy);
			@SuppressWarnings("serial")
			EcoreUtil.Copier copier = new EcoreUtil.Copier() {
				@Override
				protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
					if (XtextPackage.Literals.RULE_CALL__RULE == eReference) {
						RuleCall origRuleCall = (RuleCall) eObject;
						RuleCall copyRuleCall = (RuleCall) copyEObject;
						AbstractRule calledCopy = origToCopy.get(new RuleWithParameterValues(origRuleCall.getRule(),
								getParameterConfig(origRuleCall, copyRuleCall)));
						copyRuleCall.setRule(calledCopy);
						if (calledCopy instanceof TerminalRule)
							calledFrom.put((TerminalRule) calledCopy, copy);
					} else {
						super.copyReference(eReference, eObject, copyEObject);
					}
				}

				Set<Parameter> getParameterConfig(RuleCall origRuleCall, RuleCall copyRuleCall) {
					if (origRuleCall.getArguments().isEmpty())
						return Collections.emptySet();
					return toSet(transform(filter(origRuleCall.getArguments(), it -> evaluate(it.getValue())),
							it -> it.getParameter()));
				}

				@Override
				protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
					if (XtextPackage.Literals.RULE_CALL__ARGUMENTS == eReference
							|| XtextPackage.Literals.GROUP__GUARD_CONDITION == eReference)
						return;
					super.copyContainment(eReference, eObject, copyEObject);
				}

				@Override
				public EObject copy(EObject eObject) {
					if (eObject instanceof Group && ((Group) eObject).getGuardCondition() != null
							&& !evaluate(((Group) eObject).getGuardCondition()))
						return null;
					EObject result = super.copy(eObject);
					if (result instanceof CompoundElement) {
						CompoundElement compoundElement = (CompoundElement) result;
						List<AbstractElement> elements = compoundElement.getElements();
						if (elements.size() == 1) {
							if (!compoundElement.isFirstSetPredicated() && !compoundElement.isPredicated()) {
								AbstractElement firstElement = elements.get(0);
								mergeCardinalities(firstElement, compoundElement);
								mergePredicates(firstElement, compoundElement);
								return firstElement;
							} else {
								AbstractElement firstElement = elements.get(0);
								mergePredicates(compoundElement, firstElement);
								firstElement.setFirstSetPredicated(false);
								firstElement.setPredicated(false);
							}
						}
					}
					if ((eObject instanceof AbstractElement)) {
						AbstractElement abstractElement = (AbstractElement) eObject;
						if (!abstractElement.eClass().equals(result.eClass())) {
							throw new IllegalStateException("copy is: \'" + result.eClass().getName()
									+ "\' but original was: \'" + abstractElement.eClass().getName() + "\'");
						}
						new OriginalElement(abstractElement).attachToEmfObject(result);
					}
					return result;
				}

				void mergePredicates(AbstractElement into, AbstractElement from) {
					if (from.isPredicated()) {
						into.setPredicated(true);
						into.setFirstSetPredicated(false);
					} else {
						if (!into.isPredicated() && from.isFirstSetPredicated())
							into.setFirstSetPredicated(true);
					}
				}

				void mergeCardinalities(AbstractElement into, AbstractElement from) {
					String c1 = into.getCardinality();
					String c2 = from.getCardinality();
					String resultCardinality = c1 == null ? c2 : c1;
					if (("*".equals(c1) || "*".equals(c2)) || ("+".equals(c1) && "?".equals(c2))
							|| ("?".equals(c1) && "+".equals(c2)))
						resultCardinality = "*";
					into.setCardinality(resultCardinality);
				}

				boolean evaluate(final Condition condition) {
					return new ConditionEvaluator(paramValues).evaluate(condition);
				}
			};
			AbstractElement copiedBody = (AbstractElement) copier.copy(orig.getAlternatives());
			copier.copyReferences();
			copy.setAlternatives(copiedBody);
			if (orig instanceof ParserRule) {
				ParserRule castedCopy = ((ParserRule) copy);
				if (((ParserRule) orig).isDefinesHiddenTokens()) {
					castedCopy.setDefinesHiddenTokens(true);
					for (AbstractRule rule : ((ParserRule) orig).getHiddenTokens()) {
						AbstractRule copiedTerminalRule = origToCopy.get(new RuleWithParameterValues(rule));
						castedCopy.getHiddenTokens().add(copiedTerminalRule);
						calledFrom.put((TerminalRule) copiedTerminalRule, castedCopy);
					}
				}
			}
		}
		return calledFrom;
	}

	private TypeRef copyTypeRef(TypeRef ref) {
		if (ref == null)
			return null;
		TypeRef copy = copy(ref);
		copy.setClassifier(ref.getClassifier());
		return copy;
	}

	private List<AbstractRule> copyRuleStubs(RuleNames names, Map<RuleWithParameterValues, AbstractRule> origToCopy,
			List<AbstractRule> rulesToCopy, boolean discardTypeRef) {
		List<AbstractRule> result = new ArrayList<>();
		for (AbstractRule rule : rulesToCopy) {
			String ruleName = names.getAntlrRuleName(rule);
			if (rule instanceof ParserRule) {
				List<Parameter> params = ((ParserRule) rule).getParameters();
				if (params.isEmpty()) {
					ParserRule copy = copy((ParserRule) rule);
					copy.setName(ruleName);
					copy.setFragment(((ParserRule) rule).isFragment());
					copy.setWildcard(((ParserRule) rule).isWildcard());
					if (!discardTypeRef)
						copy.setType(copyTypeRef(((ParserRule) rule).getType()));
					attachTo(copy, rule, origToCopy);
					result.add(copy);
				} else {
					forEach(Sets.powerSet(ImmutableSet.copyOf(params)), (parameterConfig, i) -> {
						RuleWithParameterValues parameterValues = new RuleWithParameterValues(rule, parameterConfig);
						ParserRule copy = copy((ParserRule) rule);
						copy.setName(names.getAntlrRuleName(rule, i.intValue()));
						copy.setFragment(((ParserRule) rule).isFragment());
						copy.setWildcard(((ParserRule) rule).isWildcard());
						if (!discardTypeRef)
							copy.setType(copyTypeRef(((ParserRule) rule).getType()));
						origToCopy.put(parameterValues, copy);
						parameterValues.attachToEmfObject(copy);
						result.add(copy);
					});
				}
			} else if (rule instanceof TerminalRule) {
				TerminalRule orig = ((TerminalRule) rule);
				TerminalRule copy = copy(orig);
				copy.setName(ruleName);
				copy.setFragment(orig.isFragment());
				attachTo(copy, orig, origToCopy);
				result.add(copy);
			} else if (rule instanceof EnumRule) {
				EnumRule copy = copy((EnumRule) rule);
				copy.setName(ruleName);
				attachTo(copy, rule, origToCopy);
				result.add(copy);
			}
		}
		return result;
	}

	private AbstractRule attachTo(AbstractRule copy, AbstractRule orig,
			Map<RuleWithParameterValues, AbstractRule> origToCopy) {
		RuleWithParameterValues parameterValues = new RuleWithParameterValues(orig);
		parameterValues.attachToEmfObject(copy);
		return origToCopy.put(parameterValues, copy);
	}

	private boolean allAreTerminalRules(Collection<AbstractRule> callers) {
		return forall(callers, it -> it instanceof TerminalRule);
	}

	@SuppressWarnings("unchecked")
	private <T extends EObject> T copy(final T t) {
		return (T) EcoreUtil.create(t.eClass());
	}

	public static FlattenedGrammarAccess findInEmfObject(Notifier emfObject) {
		for (Adapter adapter : emfObject.eAdapters()) {
			if (adapter instanceof FlattenedGrammarAccessAdapter)
				return ((FlattenedGrammarAccessAdapter) adapter).get();
		}
		return null;
	}

	public static FlattenedGrammarAccess removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0; i < adapters.size(); i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof FlattenedGrammarAccessAdapter)
				return ((FlattenedGrammarAccessAdapter) emfObject.eAdapters().remove(i)).get();
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		if (findInEmfObject(emfObject) != null)
			throw new IllegalStateException(
					"The given EMF object already contains an adapter for FlattenedGrammarAccess");
		emfObject.eAdapters().add(new FlattenedGrammarAccess.FlattenedGrammarAccessAdapter(this));
	}

	public Grammar getFlattenedGrammar() {
		return flattenedGrammar;
	}

	public static class FlattenedGrammarAccessAdapter extends AdapterImpl {
		private FlattenedGrammarAccess element;

		public FlattenedGrammarAccessAdapter(FlattenedGrammarAccess element) {
			this.element = element;
		}

		public FlattenedGrammarAccess get() {
			return element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == FlattenedGrammarAccess.class;
		}
	}
}
