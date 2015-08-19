/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.normalization;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.Condition;
import org.eclipse.xtext.Conjunction;
import org.eclipse.xtext.Disjunction;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.LiteralCondition;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.Negation;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParameterReference;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FlattenedGrammarProvider {

	static class Adapter extends AdapterImpl {
		private Grammar flattened;
		
		Adapter(Grammar flattened) {
			this.flattened = flattened;
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return FlattenedGrammarProvider.class.equals(type);
		}
		
		public Grammar getFlattenedGrammar() {
			return flattened;
		}
	}
	
	public static Grammar getFlattenedGrammar(Grammar input) {
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(input.eAdapters(), FlattenedGrammarProvider.class);
		return adapter.getFlattenedGrammar();
	}
	
	public static AbstractRule getOriginalRule(AbstractRule flattenedRule) {
		ParameterValues paramValues = (ParameterValues) EcoreUtil.getAdapter(flattenedRule.eAdapters(), ParameterValues.class);
		return paramValues.getOriginal();
	}
	
	public static Grammar flatten(Grammar grammar, final RuleNames names, RuleFilter filter) {
		Grammar result = copy(grammar);
		result.setName(grammar.getName());
		
		Map<AbstractRule, AbstractRule> copyToOrig = Maps.newLinkedHashMap();
		Map<ParameterValues, AbstractRule> origToCopy = Maps.newLinkedHashMap();
		copyRuleStubs(names, copyToOrig, origToCopy, filter.getRules(grammar));
		result.getRules().addAll(copyToOrig.keySet());
		
		Multimap<TerminalRule, AbstractRule> calledFrom = copyRuleBodies(copyToOrig, origToCopy);
		
		markAsFragment(calledFrom);
		setHiddenTokens(grammar, result, origToCopy);
		
		return result;
	}

	private static void setHiddenTokens(Grammar grammar, Grammar result,
			final Map<ParameterValues, AbstractRule> origToCopy) {
		result.setDefinesHiddenTokens(true);
		while(grammar != null && !grammar.isDefinesHiddenTokens()) {
			if (grammar.getUsedGrammars().size() > 0) {
				grammar = grammar.getUsedGrammars().get(0);
			} else {
				grammar = null;
			}
		}
		if (grammar != null) {
			for(AbstractRule hidden: grammar.getHiddenTokens()) {
				AbstractRule copy = origToCopy.get(new ParameterValues(hidden));
				result.getHiddenTokens().add(copy);
			}
		}
	}

	private static void markAsFragment(final Multimap<TerminalRule, AbstractRule> calledFrom) {
		for(TerminalRule terminal: calledFrom.keySet()) {
			if (!terminal.isFragment()) {
				Collection<AbstractRule> callers = calledFrom.get(terminal);
				if (allAreTerminalRules(callers)) {
					terminal.setFragment(true);
				}
			}
		}
	}

	private static Multimap<TerminalRule, AbstractRule> copyRuleBodies(Map<AbstractRule, AbstractRule> copyToOrig,
			final Map<ParameterValues, AbstractRule> origToCopy) {
		final Multimap<TerminalRule, AbstractRule> calledFrom = HashMultimap.create();
		for(final AbstractRule copy: copyToOrig.keySet()) {
			AbstractRule orig = copyToOrig.get(copy);
			final Set<Parameter> paramValues = getParamValues(copy);
			EcoreUtil.Copier copier = new EcoreUtil.Copier() {
				private static final long serialVersionUID = 1L;
				@Override
				protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
					if (eReference == XtextPackage.Literals.RULE_CALL__RULE) {
						RuleCall origRuleCall = (RuleCall) eObject;
						RuleCall copyRuleCall = (RuleCall) copyEObject;
						AbstractRule calledCopy = origToCopy.get(new ParameterValues(origRuleCall.getRule(), getParameterConfig(origRuleCall, copyRuleCall)));
						copyRuleCall.setRule(calledCopy);
						if (calledCopy instanceof TerminalRule) {
							calledFrom.put((TerminalRule) calledCopy, copy);
						}
						return;
					}
					super.copyReference(eReference, eObject, copyEObject);
				}
				private Set<Parameter> getParameterConfig(RuleCall origRuleCall, RuleCall copyRuleCall) {
					if (origRuleCall.getArguments().isEmpty())
						return Collections.emptySet();
					Set<Parameter> result = Sets.newHashSet();
					for(NamedArgument argument: origRuleCall.getArguments()) {
						if (evaluate(argument.getValue())) {
							result.add(argument.getParameter());
						}
					}
					return result;
				}
				@Override
				protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
					if (eReference == XtextPackage.Literals.RULE_CALL__ARGUMENTS) {
						return;
					}
					if (eReference == XtextPackage.Literals.GROUP__GUARD_CONDITION) {
						return;
					}
					super.copyContainment(eReference, eObject, copyEObject);
				}
				@Override
				public EObject copy(EObject eObject) {
					if (eObject instanceof Group) {
						Group group = (Group) eObject;
						if (group.getGuardCondition() != null) {
							if (!evaluate(group.getGuardCondition())) {
								return null;
							}
						}
					}
					EObject result = super.copy(eObject);
					if (result instanceof CompoundElement) {
						List<AbstractElement> elements = ((CompoundElement) result).getElements();
						if (elements.size() == 1) {
							AbstractElement element = elements.get(0);
							element.setCardinality(mergeCardinalities(element, (AbstractElement) result));
							return element;
						}
					}
					return result;					
				}
				private String mergeCardinalities(AbstractElement first, AbstractElement second) {
					String firstCardinality = first.getCardinality();
					if (firstCardinality != null) {
						String secondCardinality = second.getCardinality();
						if (secondCardinality != null) {
							if ("*".equals(secondCardinality)) {
								return "*";
							} else if ("*".equals(firstCardinality)) {
								return "*";
							} else if ("+".equals(firstCardinality)) {
								if ("?".equals(secondCardinality)) {
									return "*";	
								}
							} else if ("?".equals(firstCardinality)) {
								if ("+".equals(secondCardinality)) {
									return "*";
								}
							}
						}
						return firstCardinality;
					} else {
						return second.getCardinality();
					}
				}
				private boolean evaluate(Condition condition) {
					Boolean result = new XtextSwitch<Boolean>() {
						@Override
						public Boolean caseDisjunction(Disjunction object) {
							return doSwitch(object.getLeft()) || doSwitch(object.getRight());
						}
						@Override
						public Boolean caseConjunction(Conjunction object) {
							return doSwitch(object.getLeft()) && doSwitch(object.getRight());
						}
						@Override
						public Boolean caseNegation(Negation object) {
							return !doSwitch(object.getValue());
						}
						@Override
						public Boolean caseParameterReference(ParameterReference object) {
							return paramValues.contains(object.getParameter());
						}
						@Override
						public Boolean caseLiteralCondition(LiteralCondition object) {
							return object.isTrue();
						}
					}.doSwitch(condition);
					return result;
				}
			};
			AbstractElement copiedBody = (AbstractElement) copier.copy(orig.getAlternatives());
			copier.copyReferences();
			copy.setAlternatives(copiedBody);
			if (orig instanceof ParserRule) {
				ParserRule casted = (ParserRule) orig;
				ParserRule castedCopy = (ParserRule) copy;
				if (casted.isDefinesHiddenTokens()) {
					castedCopy.setDefinesHiddenTokens(true);
					for(AbstractRule rule: casted.getHiddenTokens()) {
						AbstractRule hidden = origToCopy.get(new ParameterValues(rule));
						castedCopy.getHiddenTokens().add(hidden);
					}
				}
			}
		}
		return calledFrom;
	}

	private static Set<Parameter> getParamValues(AbstractRule copy) {
		ParameterValues paramValues = (ParameterValues) EcoreUtil.getAdapter(copy.eAdapters(), ParameterValues.class);
		return paramValues.getParamValues();
	}
	
	private static class ParameterValues extends AdapterImpl {
		private AbstractRule original;
		private Set<Parameter> paramValues;
		
		ParameterValues(AbstractRule original, Set<Parameter> paramValues) {
			this.original = original;
			this.paramValues = paramValues;
		}
		ParameterValues(AbstractRule original) {
			this(original, Collections.<Parameter>emptySet());
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return ParameterValues.class.equals(type);
		}
		
		public Set<Parameter> getParamValues() {
			return paramValues;
		}
		
		public AbstractRule getOriginal() {
			return original;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((original == null) ? 0 : original.hashCode());
			result = prime * result + ((paramValues == null) ? 0 : paramValues.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ParameterValues other = (ParameterValues) obj;
			if (original == null) {
				if (other.original != null)
					return false;
			} else if (!original.equals(other.original))
				return false;
			if (paramValues == null) {
				if (other.paramValues != null)
					return false;
			} else if (!paramValues.equals(other.paramValues))
				return false;
			return true;
		}
		
	}

	private static void copyRuleStubs(final RuleNames names, Map<AbstractRule, AbstractRule> copyToOrig,
			final Map<ParameterValues, AbstractRule> origToCopy, List<AbstractRule> rulesToCopy) {
		for(AbstractRule rule: rulesToCopy) {
			String ruleName = names.getAntlrRuleName(rule);
			if (rule instanceof ParserRule) {
				ParserRule orig = (ParserRule) rule;
				List<Parameter> params = orig.getParameters();
				if (params.isEmpty()) {
					ParserRule copy = copy(orig);
					copy.setName(ruleName);
					copy.setFragment(orig.isFragment());
					copy.setWildcard(orig.isWildcard());
					copyToOrig.put(copy, rule);
					ParameterValues parameterValues = new ParameterValues(orig);
					origToCopy.put(parameterValues, copy);
					copy.eAdapters().add(parameterValues);
				} else {
					Set<Set<Parameter>> parameterConfigs = Sets.powerSet(ImmutableSet.copyOf(params));
					int i = 0;
					for(Set<Parameter> parameterConfig: parameterConfigs) {
						ParameterValues parameterValues = new ParameterValues(orig, parameterConfig);
						ParserRule copy = copy(orig);
						copy.setFragment(orig.isFragment());
						copy.setWildcard(orig.isWildcard());
						
						copy.setName(names.getAntlrRuleName(rule, i));
						copyToOrig.put(copy, rule);
						origToCopy.put(parameterValues, copy);
						copy.eAdapters().add(parameterValues);
						i++;
					}
				}
			} else if (rule instanceof TerminalRule) {
				TerminalRule orig = (TerminalRule) rule;
				TerminalRule copy = copy(orig);
				copy.setName(ruleName);
				copy.setFragment(orig.isFragment());
				copyToOrig.put(copy, rule);
				ParameterValues parameterValues = new ParameterValues(orig);
				origToCopy.put(parameterValues, copy);
				copy.eAdapters().add(parameterValues);
			} else {
				EnumRule copy = copy((EnumRule) rule);
				copy.setName(ruleName);
				copyToOrig.put(copy, rule);
				ParameterValues parameterValues = new ParameterValues(rule);
				origToCopy.put(parameterValues, copy);
				copy.eAdapters().add(parameterValues);
			}
		}
	}

	private static boolean allAreTerminalRules(Collection<AbstractRule> callers) {
		for(AbstractRule rule: callers) {
			if (!(rule instanceof TerminalRule)) {
				return false;
			}
		}
		return true;
	}

	private static <T extends EObject> T copy(T t) {
		@SuppressWarnings("unchecked")
		T result = (T) EcoreUtil.create(t.eClass());
		return result;
	}

}
