/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TerminalRule;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Different kinds of name mapping for rules in a grammar.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
@Singleton
public class RuleNames {

	static class Adapter extends AdapterImpl {
		private RuleNames ruleNames;
		
		Adapter(RuleNames ruleNames) {
			this.ruleNames = ruleNames;
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return RuleNames.class.equals(type);
		}
		
		public RuleNames getRuleNames() {
			return ruleNames;
		}
	}
	
	private final Grammar contextGrammar;
	
	/**
	 * All rules by simple name.
	 */
	private final ListMultimap<String, AbstractRule> simpleNameToRules;
	/**
	 * A mapping from qualified name to rule.
	 */
	private final Map<String, AbstractRule> qualifiedNameToRule;
	/**
	 * The name that is unique or qualified depending on the occurrence.
	 * It may either be a mapping from {@code ID} to rule or {@code com.acme.ID} to
	 * rule depending on the fact if the ID rule is overridden in the context grammar.
	 */
	private final BiMap<String, AbstractRule> nameToRule;
	/**
	 * The name that is used in code, e.g. the grammar access method names.
	 */
	private final BiMap<String, AbstractRule> uniqueNameToRule;
	/**
	 * The name that is used in the generated Antlr grammar.
	 */
	private final BiMap<String, AbstractRule> antlrNameToRule;
	
	private final List<AbstractRule> allRules;
	
	public static RuleNames getRuleNames(Grammar grammar, boolean cache) {
		if (cache) {
			Adapter adapter = (Adapter) EcoreUtil.getAdapter(grammar.eAdapters(), RuleNames.class);
			if (adapter == null) {
				return new RuleNames(grammar, true);
			}
			return adapter.getRuleNames();
		}
		return new RuleNames(grammar, false);
	}
	
	public static RuleNames getRuleNames(AbstractRule rule) {
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(rule.eAdapters(), RuleNames.class);
		if (adapter == null) {
			throw new IllegalStateException("Cannot find adapter");
		}
		return adapter.getRuleNames();
	}
	
	public static RuleNames tryGetRuleNames(AbstractRule rule) {
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(rule.eAdapters(), RuleNames.class);
		if (adapter == null) {
			return null;
		}
		return adapter.getRuleNames();
	}
	
	public static void ensureAdapterInstalled(Grammar grammar) {
		getRuleNames(grammar, true);
	}
	
	@Inject
	public RuleNames(IGrammarAccess grammarAccess) {
		this(grammarAccess.getGrammar(), false);
	}
	
	public RuleNames(Grammar grammar, boolean installAdapter) {
		this.contextGrammar = grammar;
		Adapter adapter = new Adapter(this);
		if (installAdapter) {
			installAdapterIfMissing(adapter, grammar);
		}
		List<AbstractRule> allRules = GrammarUtil.allRules(grammar);
		ImmutableListMultimap.Builder<String, AbstractRule> simpleNameToRulesBuilder = ImmutableListMultimap.builder();
		ImmutableMap.Builder<String, AbstractRule> qualifiedNameToRuleBuilder = ImmutableMap.builder();
		ImmutableBiMap.Builder<String, AbstractRule> uniqueNameToRuleBuilder = ImmutableBiMap.builder();
		ImmutableBiMap.Builder<String, AbstractRule> antlrNameToRuleBuilder = ImmutableBiMap.builder();
		
		Map<String, AbstractRule> names = Maps.newHashMap();
		Set<String> usedAntlrNames = Sets.newHashSet();
		Set<String> usedUniqueNames = Sets.newHashSet();
		for(AbstractRule rule: allRules) {
			String name = rule.getName();
			simpleNameToRulesBuilder.put(name, rule);
			String qualifiedName = getQualifiedName(rule);
			qualifiedNameToRuleBuilder.put(qualifiedName, rule);
			String uniqueName = name;
			String antlrRuleName;
			if (names.containsKey(name)) {
				name = qualifiedName;
				uniqueName = getInheritedUniqueName(rule, usedUniqueNames);
				antlrRuleName = getInheritedAntlrRuleName(rule, usedAntlrNames);
			} else {
				antlrRuleName = getDefaultAntlrRuleName(rule);
			}
			names.put(name, rule);
			if (!usedUniqueNames.add(uniqueName)) {
				throw new IllegalStateException(uniqueName);
			}
			uniqueNameToRuleBuilder.put(uniqueName, rule);
			if (!usedAntlrNames.add(antlrRuleName)) {
				throw new IllegalStateException(antlrRuleName);
			}
			antlrNameToRuleBuilder.put(antlrRuleName, rule);
			if (installAdapter) {
				installAdapterIfMissing(adapter, rule);
			}
		}
		simpleNameToRules = simpleNameToRulesBuilder.build();
		qualifiedNameToRule = qualifiedNameToRuleBuilder.build();
		nameToRule = ImmutableBiMap.copyOf(names);
		uniqueNameToRule = uniqueNameToRuleBuilder.build();
		antlrNameToRule = antlrNameToRuleBuilder.build();
		this.allRules = ImmutableList.copyOf(allRules);
	}

	private void installAdapterIfMissing(Adapter adapter, EObject context) {
		if (EcoreUtil.getAdapter(context.eAdapters(), RuleNames.class) == null) {
			context.eAdapters().add(adapter);
		} else {
			throw new IllegalStateException("Duplicate adapter");
		}
	}
	
	public List<AbstractRule> getRulesBySimpleName(String name) {
		return simpleNameToRules.get(name);
	}
	
	public AbstractRule getRuleByQualifiedName(String name) {
		return qualifiedNameToRule.get(name);
	}
	
	public String getQualifiedName(AbstractRule rule) {
		return GrammarUtil.getGrammar(rule).getName() + "." + rule.getName();
	}
	
	public String getUniqueRuleName(AbstractRule rule) {
		return uniqueNameToRule.inverse().get(rule);
	}
	
	public AbstractRule getRuleByUniqueName(String uniqueName) {
		return uniqueNameToRule.get(uniqueName);
	}
	
	public String getAntlrRuleName(AbstractRule rule) {
		return antlrNameToRule.inverse().get(rule);
	}
	
	public String getAntlrRuleName(AbstractRule rule, int paramConfig) {
		String result = antlrNameToRule.inverse().get(rule);
		int idx;
		if (result.startsWith("super")) {
			idx = 5;
		} else if (result.startsWith("rule")) {
			idx = 4;
		} else {
			throw new IllegalArgumentException(result);
		}
		if (paramConfig != 0) {
			result = (idx == 4 ? "norm" : "normSuper") + paramConfig + "_" + result.substring(idx);
		}
		return result;
	}
	
	public AbstractRule getRuleByAntlrName(String name) {
		return antlrNameToRule.get(name);
	}
	
	public String getBestRuleName(AbstractRule rule) {
		return nameToRule.inverse().get(rule);
	}
	
	public Grammar getContextGrammar() {
		return contextGrammar;
	}
	
	public List<AbstractRule> getAllRules() {
		return allRules;
	}
	
	public Iterable<ParserRule> getAllParserRules() {
		return Iterables.filter(allRules, ParserRule.class);
	}
	
	private String getInheritedAntlrRuleName(AbstractRule rule, Set<String> usedNames) {
		if (rule instanceof ParserRule || rule instanceof EnumRule) {
			String candidate = "super" + rule.getName();
			int i = 1;
			while(usedNames.contains(candidate)) {
				candidate = "super" + i + rule.getName();
				i++;
			}
			return candidate;
		}
		if (rule instanceof TerminalRule) {
			String candidate = "SUPER_" + rule.getName();
			int i = 1;
			while(usedNames.contains(candidate)) {
				candidate = "SUPER_" + i + "_" + rule.getName();
				i++;
			}
			return candidate;
		}
		throw new IllegalArgumentException(rule.eClass().getName());
	}
	
	private String getInheritedUniqueName(AbstractRule rule, Set<String> usedNames) {
		String grammarName = GrammarUtil.getSimpleName(GrammarUtil.getGrammar(rule));
		String candidate = grammarName + rule.getName();
		int i = 1;
		while(usedNames.contains(candidate)) {
			candidate = grammarName + i + rule.getName();
			i++;
		}
		return candidate;
	}
	
	private String getDefaultAntlrRuleName(AbstractRule rule) {
		if (rule instanceof ParserRule || rule instanceof EnumRule) {
			return "rule" + rule.getName();
		}
		if (rule instanceof TerminalRule) {
			return "RULE_" + rule.getName().toUpperCase();
		}
		throw new IllegalArgumentException(rule.eClass().getName());
	}
	
}
