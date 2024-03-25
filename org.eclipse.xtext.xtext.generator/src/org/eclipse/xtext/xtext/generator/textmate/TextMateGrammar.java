/**
 * Copyright (c) 2024 Sigasi (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.textmate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TerminalRule;

import com.google.common.base.Joiner;
import com.google.gson.annotations.Expose;

/**
 * A TextMate grammar with some additional, optional properties that can be assigned from MWE2 to configure
 * how rules are inferred.
 * 
 * @author David Medina
 * @author Sebastian Zarnekow
 * @since 2.35
 */
public class TextMateGrammar {

	@Expose	private final List<TextMateRule> patterns;
	@Expose private String scopeName;
	@Expose private Map<String, TextMateRule> repository;
	private boolean inferPatterns = true;
	private boolean ignoreCase = false;
	private TerminalRuleToTextMateRule generator = new TerminalRuleToTextMateRule(); 
	
	public TextMateGrammar() {
		this.patterns = new ArrayList<>();
	}

	public String getScopeName() {
		return scopeName;
	}

	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}
	
	public boolean isInferPatterns() {
		return inferPatterns;
	}

	public void setInferPatterns(boolean inferPatterns) {
		this.inferPatterns = inferPatterns;
	}
	
	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	public void setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}

	public TerminalRuleToTextMateRule getGenerator() {
		return generator;
	}

	public void setGenerator(TerminalRuleToTextMateRule generator) {
		this.generator = generator;
	}

	public void addSkip(SkippedRule rule) {
		this.patterns.add(rule);
	}
	
	public void addAuto(AutoRule rule) {
		this.patterns.add(rule);
	}
	
	public void addMatch(MatchRule rule) {
		this.patterns.add(rule);
	}
	
	public void addInclude(String include) {
		this.patterns.add(new IncludeRule(include));
	}
	
	public void addBeginEnd(BeginEndRule rule) {
		this.patterns.add(rule);
	}
	
	public void addRepositoryMatch(MatchRule rule) {
		if (repository == null) {
			repository = new TreeMap<>();
		}
		this.repository.put(rule.getName(), rule);
		rule.setName(null);
	}
	
	public void addRepositoryBeginEnd(BeginEndRule rule) {
		if (repository == null) {
			repository = new TreeMap<>();
		}
		this.repository.put(rule.getName(), rule);
		rule.setName(null);
	}
	
	public void addRule(TextMateRule rule) {
		this.patterns.add(rule);
	}

	protected TextMateGrammar init(Grammar grammar) {
		String scopeName = this.scopeName;
		if (scopeName == null) {
			scopeName = "source." + getLanguageName(grammar);
		}
		TextMateGrammar result = new TextMateGrammar();
		result.setScopeName(scopeName);
		TextMateRule keywords = getKeywordControlRule(grammar, ignoreCase);
		result.addRule(keywords);
		
		Set<String> seenTerminalRules = new HashSet<>();
		for(TextMateRule pattern: patterns) {
			seenTerminalRules.add(pattern.getTerminalRule());
			if (pattern instanceof SkippedRule) {
				continue;
			}
			if (pattern instanceof AutoRule) {
				((AutoRule)pattern).init(grammar, ignoreCase, generator).ifPresent(result::addRule);
			} else {
				result.addRule(pattern);
			}
		}
		if (inferPatterns) {
			List<TerminalRule> terminals = GrammarUtil.allTerminalRules(grammar)
					.stream()
					.filter(r -> !r.isFragment())
					.collect(Collectors.toList());
			for(TerminalRule terminal: terminals) {
				if (!seenTerminalRules.add(terminal.getName())) {
					continue;
				}
				AutoRule auto = newAutoRule();
				auto.setTerminalRule(terminal.getName());
				auto.init(grammar, ignoreCase, generator).ifPresent(result::addRule);
			}
		}
		return result;
	}

	protected AutoRule newAutoRule() {
		return new AutoRule();
	}

	protected String getLanguageName(Grammar grammar) {
		return GrammarUtil.getSimpleName(grammar).toLowerCase(Locale.ROOT);
	}
	
	protected TextMateRule getKeywordControlRule(Grammar grammar, boolean ignoreCase) {
		StringBuilder matchBuilder = new StringBuilder();
		if (ignoreCase) {
			matchBuilder.append("(?i)");
		}
		matchBuilder.append("\\b(");
		List<String> allKeywords = GrammarUtil.getAllKeywords(grammar)
				.stream()
				.filter(s->s.matches("\\w+"))
				.sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
		matchBuilder.append(Joiner.on("|").join(allKeywords));
		matchBuilder.append(")\\b");
		MatchRule result = new MatchRule();
		result.setName("keyword.control." + getLanguageName(grammar));
		result.setMatch(matchBuilder.toString());
		return result;
	}

}
