/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.normalization;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

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
	
	private static final XtextFactory factory = XtextFactory.eINSTANCE;
	
	private static <T extends EObject> T copy(T t) {
		@SuppressWarnings("unchecked")
		T result = (T) EcoreUtil.create(t.eClass());
		return result;
	}
	
	public static Grammar flatten(Grammar grammar, final RuleNames names, RuleFilter filter) {
		Grammar result = copy(grammar);
		result.setName(grammar.getName());
		
		List<AbstractRule> rulesToCopy = filter.getRules(grammar);
		Map<AbstractRule, AbstractRule> copyToOrig = Maps.newHashMap();
		final Map<Pair<AbstractRule, Integer>, AbstractRule> origToCopy = Maps.newHashMap();
		for(AbstractRule rule: rulesToCopy) {
			if (rule instanceof ParserRule) {
				ParserRule orig = (ParserRule) rule;
				List<Parameter> params = orig.getParameters();
				if (params.isEmpty()) {
					ParserRule copy = copy(orig);
					copy.setName(names.getAntlrRuleName(rule));
					copy.setFragment(orig.isFragment());
					copy.setWildcard(orig.isWildcard());
					result.getRules().add(copy);
					copyToOrig.put(copy, rule);
					origToCopy.put(Tuples.<AbstractRule, Integer>create(orig, 0), copy);
				} else {
					// could overflow for more than 32 args - should never happen in practice
					for(int i = 0; i < 1 << params.size(); i++) {
						Pair<AbstractRule, Integer> pair = Tuples.<AbstractRule, Integer>create(orig, i);
						ParserRule copy = copy(orig);
						copy.setFragment(orig.isFragment());
						copy.setWildcard(orig.isWildcard());
						copy.setName(names.getAntlrRuleName(rule) + "__" + i);
						result.getRules().add(copy);
						copyToOrig.put(copy, rule);
						origToCopy.put(pair, copy);
					}
				}
			} else if (rule instanceof TerminalRule) {
				TerminalRule orig = (TerminalRule) rule;
				TerminalRule copy = copy(orig);
				copy.setName(names.getAntlrRuleName(rule));
				copy.setFragment(orig.isFragment());
				result.getRules().add(copy);
				copyToOrig.put(copy, rule);
				origToCopy.put(Tuples.<AbstractRule, Integer>create(orig, 0), copy);
			} else {
				EnumRule copy = copy((EnumRule) rule);
				copy.setName(names.getAntlrRuleName(rule));
				result.getRules().add(copy);
				copyToOrig.put(copy, rule);
				origToCopy.put(Tuples.<AbstractRule, Integer>create(rule, 0), copy);
			}
		}
		final Multimap<TerminalRule, AbstractRule> calledFrom = HashMultimap.create();
		for(final AbstractRule copy: result.getRules()) {
			AbstractRule orig = copyToOrig.get(copy);
			EcoreUtil.Copier copier = new EcoreUtil.Copier() {
				private static final long serialVersionUID = 1L;
				@Override
				protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
					if (eReference == XtextPackage.Literals.RULE_CALL__RULE) {
						RuleCall origRuleCall = (RuleCall) eObject;
						RuleCall copyRuleCall = (RuleCall) copyEObject;
						int paramConfig = getParameterConfig(origRuleCall, copyRuleCall);
						AbstractRule calledCopy = origToCopy.get(Tuples.create(origRuleCall.getRule(), paramConfig));
						copyRuleCall.setRule(calledCopy);
						if (calledCopy instanceof TerminalRule) {
							calledFrom.put((TerminalRule) calledCopy, copy);
						}
						return;
					}
					super.copyReference(eReference, eObject, copyEObject);
				}
				private int getParameterConfig(RuleCall origRuleCall, RuleCall copyRuleCall) {
					return 0;
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
				protected EObject createCopy(EObject eObject) {
					if (eObject instanceof Group) {
						Group group = (Group) eObject;
						if (group.getGuardCondition() != null) {
							// check configuration of copy and orig -> filter group
						}
					}
					return super.createCopy(eObject);
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
						AbstractRule hidden = origToCopy.get(Tuples.create(rule, 0));
						castedCopy.getHiddenTokens().add(hidden);
					}
				}
			}
		}
		for(TerminalRule terminal: calledFrom.keySet()) {
			if (!terminal.isFragment()) {
				Collection<AbstractRule> callers = calledFrom.get(terminal);
				if (allAreTerminalRules(callers)) {
					terminal.setFragment(true);
				}
			}
		}
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
				AbstractRule copy = origToCopy.get(Tuples.create(hidden, 0));
				result.getHiddenTokens().add(copy);
			}
		}
		return result;
	}

	private static boolean allAreTerminalRules(Collection<AbstractRule> callers) {
		for(AbstractRule rule: callers) {
			if (!(rule instanceof TerminalRule)) {
				return false;
			}
		}
		return true;
	}
	
}
