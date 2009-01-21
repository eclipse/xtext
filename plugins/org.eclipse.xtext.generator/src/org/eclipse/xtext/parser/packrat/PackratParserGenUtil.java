/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import static org.eclipse.xtext.util.CollectionUtils.filter;
import static org.eclipse.xtext.util.CollectionUtils.indexes;
import static org.eclipse.xtext.util.CollectionUtils.list;
import static org.eclipse.xtext.util.CollectionUtils.map;
import static org.eclipse.xtext.util.CollectionUtils.next;
import static org.eclipse.xtext.util.CollectionUtils.nextOrNull;
import static org.eclipse.xtext.util.CollectionUtils.typeFilter;
import static org.eclipse.xtext.util.CollectionUtils.unique;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.StringWithOffset;
import org.eclipse.xtext.util.CollectionUtils;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.Strings;

/**
 * Various utilities for the parser generator.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class PackratParserGenUtil {

	private PackratParserGenUtil() {
		throw new UnsupportedOperationException(getClass().getName() + " may not be initialized.");
	}
	
	/**
	 * @param rule - the rule
	 * @return <code>firstLetterToUpper(rule.name) + "Consumer"</code>
	 */
	public static String getConsumerClassName(AbstractRule rule) {
		Grammar grammar = GrammarUtil.getGrammar(rule);
		return (grammar != null ? GrammarUtil.getName(grammar) : "") + 
			(rule.getName() == null ? "Consumer" : Strings.toFirstUpper(rule.getName()) + "Consumer");
	}

	/**
	 * The result is best described by example:
	 * <ul>
	 * <li><code>ML_COMMENT = mlCommentConsumer</code></li>
	 * <li><code>ML__COMMENT = ml_commentConsumer</code></li>
	 * <li><code>ml_comment = mlCommentConsumer</code></li>
	 * <li><code>_ = _Consumer</code></li>
	 * <li><code>__ = __Consumer</code></li>
	 * <li><code>___ = ___Consumer </code></li>
	 * <li><code>__12 = __12Consumer</code></li>
	 * <li><code>_12 = _12Consumer</code></li>
	 * <li><code>Grammar = grammarConsumer</code></li>
	 * <li><code>grammar = grammarConsumer</code></li>
	 * <li><code>ID = idConsumer</code></li>
	 * <li><code>STRING = stringConsumer</code></li>
	 * <li><code>AbstractRule = abstractRuleConsuemr</code></li>
	 * <li><code>AbstractID = abstractIdConsumer</code></li>
	 * <li><code>AbstractIDElement = abstractIdElement</code></li>
	 * <li><code>IDElement = idElementConsumer</code></li>
	 * <li><code>IElement = iElementConsumer</code></li>
	 * <li><code>a1 = a1Consumer</code></li>
	 * <li><code>A1234 = a1234Consumer</code></li>
	 * <li><code>A1234TEST = a1234TestConsumer</code></li>
	 * <li><code>A1234Test = a1234TestConsumer</code></li>
	 * <li><code>A1234test = a1234TestConsumer</code></li>
	 * <li><code>A1234T = a1234TConsumer</code></li>
	 * <li><code>A1234IElement = a1234IElementConsumer</code></li>
	 * <li><code>A1234t = a1234TConsumer</code></li>
	 * <li><code>A1234iElement = a1234IElementConsumer</code></li>
	 * <li><code>null = consumer</code></li>
	 * <li><code><> = consumer</code></li>
	 * <li><code>Root = rootConsumer</code></li>
	 * </ul>
	 * @param rule
	 * @return
	 */
	public static String getConsumerFieldName(AbstractRule rule) {
		return getFieldName(rule.getName(), "consumer");
	}

	private static String getFieldName(String name, String suffix) {
		String result = getAsFieldName(name);
		if (result.length() == 0) // name is a single underscore or empty
			if (Strings.isEmpty(name))
				return suffix;
			else 
				return "_" + Strings.toFirstUpper(suffix);
		return result.toString() + Strings.toFirstUpper(suffix);
	}

	private static String getAsFieldName(String name) {
		name = Strings.emptyIfNull(name);
		StringBuilder result = new StringBuilder(name.length());
		boolean wasUnderscore = false;
		boolean wasUppercase = true;
		boolean wasDigit = false;
		for(int i=0; i<name.length(); i++) {
			char c = name.charAt(i);
			if (c == '_') {
				if (wasUnderscore) { // we may not strip more then one underscore in the middle
					if (result.length() == 0) 
						result.append('_');
					result.append('_');
					wasUppercase = true;
				} else {
					wasUppercase = false;
				}
				wasUnderscore = true;
			} else {
				if (Character.isDigit(c)) {
					if (result.length() == 0) // we skipped an underscore
						result.append('_');
					result.append(c);
				} else {
					if (wasDigit) {
						result.append(Character.toUpperCase(c));
					} else if (Character.isUpperCase(c)) {
						if (wasUppercase) {
							if (i!=0 && i != name.length() - 1) {
								char next = name.charAt(i + 1);
								if (Character.isLetter(next) && Character.isLowerCase(next)) {
									result.append(c);
								} else {
									result.append(Character.toLowerCase(c));
								}
							} else {
								result.append(Character.toLowerCase(c));
							}
						} else {
							result.append(c);
						}
					} else {
						if (wasUnderscore) {
							result.append(Character.toUpperCase(c));
						} else {
							result.append(c);
						}
					}
				}
				wasUppercase = Character.isUpperCase(c);
				wasDigit = Character.isDigit(c);
				wasUnderscore = false;
			}
		}
		return result.toString();
	}
	
	public static String getConsumeMethodName(AbstractElement element) {
		return "consume" + element.eClass().getName()+ getElementIndex(element);
	}

	private static String getElementIndex(AbstractElement element) {
		final AbstractRule rule = EcoreUtil2.getContainerOfType(element, AbstractRule.class);
		return getElementIndex(element, rule);
	}
	
	private static String getElementIndex(AbstractElement element, EObject parent) {
		return '$' + Integer.toString(next(indexes(EcoreUtil.getAllContents(parent, true), Filter.Util.<Object>same(element))));
	}
	
	public static String getDelimiterFieldName(AbstractElement element) {
		return getFieldName(element.eClass().getName(), getElementIndex(element) + "$Delimiter");
	}
	
	public static String getGlobalDelimiterFieldName(AbstractElement element) {
		// TODO make upperCase -> UPPER_CASE$1$DELIMITER
		return getFieldName(element.eClass().getName(), getElementIndex(element, GrammarUtil.getGrammar(element)) + "$Delimiter");
	}
	
	public static Iterable<Keyword> getConflictingKeywords(final AbstractRule rule, final Iterable<Keyword> allKeywords) {
		return CollectionUtils.filter(allKeywords, new Filter<Keyword>() {
			public boolean matches(Keyword param) {
				final ParserRule containerRule = EcoreUtil2.getContainerOfType(param, ParserRule.class);
				if (containerRule != null && containerRule.isTerminal())
					return false;
				if (rule instanceof LexerRule) {
					if (rule.getName().equals("ID")) {
						final StringWithOffset input = new StringWithOffset(param.getValue());
						return new XtextBuiltinIDConsumer(input, input, null).consume();
					}
				} else {
					ParserRule parserRule = (ParserRule) rule;
					if (!parserRule.isTerminal())
						throw new IllegalArgumentException(rule + " is not a terminal rule.");
					TerminalRuleInterpreter interpreter = new TerminalRuleInterpreter(param);
					return interpreter.matches(parserRule);
				}
				return false;
			}
		});
	}
	
	// TODO SZ: replace return value with ICharacterClass or similar
	public static List<AbstractRule> getConflictingLexerRules(final Keyword keyword, final Grammar grammar) {
		AbstractRule rule = (AbstractRule) GrammarUtil.findRuleForName(grammar, "ID");
		if (rule != null) {
			// TODO SZ: use interpreter
			final StringWithOffset input = new StringWithOffset(keyword.getValue());
			if (new XtextBuiltinIDConsumer(input, input, null).consume()) {
				return Collections.singletonList(rule);
			}
		}
		return Collections.emptyList();
	}
	
	public static List<String> getConflictingKeywords(final AbstractElement element, final Grammar grammar) {
		if (element instanceof RuleCall) {
			if (((RuleCall) element).getRule() instanceof AbstractRule) {
				AbstractRule rule = (AbstractRule) ((RuleCall) element).getRule();
				if (rule instanceof LexerRule || ((ParserRule) rule).isTerminal())
					return getConflictingKeywordsImpl(grammar, rule);
			}
		} else if (element instanceof CrossReference) {
			if (((CrossReference) element).getRule() instanceof AbstractRule) {
				AbstractRule rule = (AbstractRule) ((CrossReference) element).getRule();
				if (rule instanceof LexerRule || ((ParserRule) rule).isTerminal())
					return getConflictingKeywordsImpl(grammar, rule);
			}
		}
		return null;
	}

	private static List<String> getConflictingKeywordsImpl(final Grammar grammar, AbstractRule rule) {
		final Iterable<Keyword> conflictingKeywords = getConflictingKeywords(rule, typeFilter(
				EcoreUtil.getAllContents(grammar, true), Keyword.class));
		return list(unique(map(conflictingKeywords, new Function<Keyword, String>() {
			public String exec(Keyword param) {
				return param.getValue();
			}
		})));
	}
	
	// TODO think about super grammar
	public static AbstractElement findFirstWithSameConflicts(final AbstractElement element, final Grammar grammar) {
		final List<String> conflicting = getConflictingKeywords(element, grammar);
		AbstractElement result = nextOrNull(filter(typeFilter(EcoreUtil.getAllContents(grammar, true), AbstractElement.class), new Filter<AbstractElement>() {
			public boolean matches(AbstractElement param) {
				final List<String> otherConflicting = getConflictingKeywords(param, grammar);
				return otherConflicting != null && otherConflicting.equals(conflicting);
			}
		}));
		if (result == null)
			return element;
		return result;
	}

	// TODO think about super grammar
	public static Keyword findFirstKeywordWithSameConflicts(final Keyword element, final Grammar grammar) {
		final List<AbstractRule> conflicting = getConflictingLexerRules(element, grammar);
		Keyword result = nextOrNull(filter(typeFilter(EcoreUtil.getAllContents(grammar, true), Keyword.class), new Filter<Keyword>() {
			public boolean matches(Keyword param) {
				final List<AbstractRule> otherConflicting = getConflictingLexerRules(param, grammar);
				return otherConflicting != null && otherConflicting.equals(conflicting);
			}
		}));
		if (result == null)
			return element;
		return result;
	}

}
