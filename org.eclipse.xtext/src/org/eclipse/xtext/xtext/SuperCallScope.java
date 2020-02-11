/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.ForwardingEObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SuperCallScope implements IScope {

	static final String SUPER = "super";

	/**
	 * Used during linking to set the {@link RuleCall#isExplicitlyCalled() flag}
	 * which keeps track of explicitly chosen rules.
	 * @author zarnekow - Initial contribution and API
	 */
	public static class ExplicitCallDescription extends ForwardingEObjectDescription {

		private RuleCall ruleCall;

		public ExplicitCallDescription(IEObjectDescription delegate, RuleCall ruleCall) {
			super(delegate);
			this.ruleCall = ruleCall;
		}
		
		@Override
		public EObject getEObjectOrProxy() {
			ruleCall.setExplicitlyCalled(true);
			return super.getEObjectOrProxy();
		}
		
	}
	
	private EObject context;

	public SuperCallScope(EObject context) {
		this.context = context;
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		IEObjectDescription result = doGetSingleElement(name);
		if (result != null && context instanceof RuleCall) {
			return new ExplicitCallDescription(result, (RuleCall) context);
		}
		return result;
	}

	private IEObjectDescription doGetSingleElement(QualifiedName qn) {
		if (qn.getSegmentCount() == 1) {
			if (SUPER.equals(qn.getFirstSegment())) {
				AbstractRule containingRule = GrammarUtil.containingRule(context);
				if (containingRule != null) {
					Grammar grammar = GrammarUtil.getGrammar(containingRule);
					for(Grammar parent: grammar.getUsedGrammars()) {
						AbstractRule superRule = GrammarUtil.findRuleForName(parent, containingRule.getName());
						if (superRule != null) {
							return EObjectDescription.create(qn, superRule);
						}
					}
				}
			}
		} else if (qn.getSegmentCount() > 1) {
			Grammar grammar = GrammarUtil.getGrammar(context);
			if (grammar != null) {
				String firstSegment = qn.getFirstSegment();
				if (qn.getSegmentCount() == 2) {
					String ruleName = qn.getLastSegment();
					if (SUPER.equals(firstSegment)) {
						for(Grammar parent: grammar.getUsedGrammars()) {
							AbstractRule superRule = GrammarUtil.findRuleForName(parent, ruleName);
							if (superRule != null) {
								return EObjectDescription.create(qn, superRule);
							}
						}
					}
					if (firstSegment.equals(GrammarUtil.getSimpleName(grammar))) {
						AbstractRule rule = GrammarUtil.findRuleForName(grammar, grammar.getName() + "." + ruleName);
						if (rule != null) {
							return EObjectDescription.create(qn, rule);
						}
					}
					for(Grammar usedGrammar: GrammarUtil.allUsedGrammars(grammar)) {
						if (firstSegment.equals(GrammarUtil.getSimpleName(usedGrammar))) {
							AbstractRule rule = GrammarUtil.findRuleForName(usedGrammar, usedGrammar.getName() + "." + ruleName);
							if (rule != null) {
								return EObjectDescription.create(qn, rule);
							}
						}	
					}
				}
				AbstractRule result = GrammarUtil.findRuleForName(grammar, qn.toString());
				if (result != null) {
					return EObjectDescription.create(qn, result);
				}
			}
		}
		return null;
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		IEObjectDescription result = doGetSingleElement(name);
		if (result != null) {
			return Collections.singletonList(result);
		}
		return Collections.emptyList();
	}

	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		return Iterables.getFirst(getElements(object), null);
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		if (object instanceof AbstractRule) {
			Grammar grammar = GrammarUtil.getGrammar(context);
			AbstractRule rule = (AbstractRule) object;
			if (GrammarUtil.getGrammar(rule) == grammar) {
				return Lists.newArrayList(
						EObjectDescription.create(GrammarUtil.getSimpleName(grammar) + "." + rule.getName(), rule),
						EObjectDescription.create(grammar.getName() + "." + rule.getName(), rule));
			}
			List<IEObjectDescription> result = Lists.newArrayList(
					EObjectDescription.create(SUPER + "." + rule.getName(), rule),
					EObjectDescription.create(GrammarUtil.getSimpleName(grammar) + "." + rule.getName(), rule),
					EObjectDescription.create(grammar.getName() + "." + rule.getName(), rule));
			AbstractRule contextRule = GrammarUtil.containingRule(context);
			if (contextRule != null && contextRule.getName().equals(rule.getName())) {
				result.add(0, EObjectDescription.create(SUPER, rule));
			}
			return result;
		}
		return Collections.emptyList();
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		AbstractRule contextRule = GrammarUtil.containingRule(context);
		Grammar grammar = contextRule != null ? GrammarUtil.getGrammar(contextRule) : GrammarUtil.getGrammar(context);
		Map<QualifiedName, IEObjectDescription> result = Maps.newLinkedHashMap();
		if (grammar != null) {
			String shortName = GrammarUtil.getSimpleName(grammar) + ".";
			String longName = grammar.getName() + ".";
			for(AbstractRule rule: grammar.getRules()) {
				putIfAbsent(EObjectDescription.create(shortName + rule.getName(), rule), result);
				putIfAbsent(EObjectDescription.create(longName + rule.getName(), rule), result);
			}
			boolean waitingForSuper = contextRule != null;
			for(Grammar usedGrammar: GrammarUtil.allUsedGrammars(grammar)) {
				shortName = GrammarUtil.getSimpleName(usedGrammar) + ".";
				longName = usedGrammar.getName() + ".";
				for(AbstractRule rule: usedGrammar.getRules()) {
					if (waitingForSuper) {
						assert contextRule != null;
						if (rule.getName().equals(contextRule.getName())) {
							putIfAbsent(EObjectDescription.create(SUPER, rule), result);
							waitingForSuper = false;
						}
					}
					putIfAbsent(EObjectDescription.create(SUPER + "." + rule.getName(), rule), result);
					putIfAbsent(EObjectDescription.create(shortName + rule.getName(), rule), result);
					putIfAbsent(EObjectDescription.create(longName + rule.getName(), rule), result);
				}	
			}
		}
		return Lists.newArrayList(result.values());
	}

	private void putIfAbsent(IEObjectDescription desc, Map<QualifiedName, IEObjectDescription> result) {
		if (!result.containsKey(desc.getName())) {
			result.put(desc.getName(), desc);
		}
	}

}
