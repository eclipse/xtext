/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.packrat;

import static org.eclipse.xtext.GrammarUtil.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.parser.packrat.consumers.TerminalsIDConsumer;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.matching.StringWithOffset;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Various utilities for the parser generator.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public final class PackratParserGenUtil {

	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	private static final class MyTerminalConsumerConfiguration implements ITerminalConsumerConfiguration {
		private final StringWithOffset input;

		private MyTerminalConsumerConfiguration(StringWithOffset input) {
			this.input = input;
		}

		@Override
		public ICharSequenceWithOffset getInput() {
			return input;
		}

		@Override
		public IParsedTokenAcceptor getTokenAcceptor() {
			return null;
		}
	}

	private PackratParserGenUtil() {
		throw new UnsupportedOperationException(getClass().getName() + " may not be initialized.");
	}

	/**
	 * @param rule
	 *            - the rule
	 * @return <code>firstLetterToUpper(rule.name) + "Consumer"</code>
	 */
	public static String getConsumerClassName(AbstractRule rule) {
		Grammar grammar = GrammarUtil.getGrammar(rule);
		return (grammar != null ? GrammarUtil.getSimpleName(grammar) : "")
				+ (rule.getName() == null ? "Consumer" : Strings.toFirstUpper(rule.getName()) + "Consumer");
	}

	/**
	 * @param g
	 *            {@link Grammar}
	 * @return Parser name
	 */
	public static String getGeneratedParser(Grammar g, Naming naming) {
		return naming.basePackageRuntime(g) + ".parser.packrat." + getSimpleName(g) + "PackratParser";
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
	 * <li><code>&lt;&gt; = consumer</code></li>
	 * <li><code>Root = rootConsumer</code></li>
	 * </ul>
	 * 
	 * @param rule
	 * @return {@link String}
	 */
	public static String getConsumerFieldName(AbstractRule rule) {
		return getFieldName(rule.getName(), "consumer");
	}

	private static String getFieldName(String name, String suffix) {
		String result = getAsFieldName(name);
		if (result.length() == 0) { // name is a single underscore or empty
			if (Strings.isEmpty(name))
				return suffix;
			return "_" + Strings.toFirstUpper(suffix);
		}
		return result.toString() + Strings.toFirstUpper(suffix);
	}

	private static String getAsFieldName(String name) {
		String myName = Strings.emptyIfNull(name);
		StringBuilder result = new StringBuilder(myName.length());
		boolean wasUnderscore = false;
		boolean wasUppercase = true;
		boolean wasDigit = false;
		for (int i = 0; i < myName.length(); i++) {
			char c = myName.charAt(i);
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
							if (i != 0 && i != myName.length() - 1) {
								char next = myName.charAt(i + 1);
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
		return "consume" + element.eClass().getName() + getElementIndex(element);
	}

	private static String getElementIndex(AbstractElement element) {
		final AbstractRule rule = EcoreUtil2.getContainerOfType(element, AbstractRule.class);
		return getElementIndex(element, rule);
	}

	private static String getElementIndex(AbstractElement element, EObject parent) {
		List<EObject> elements = EcoreUtil2.eAllContentsAsList(parent);
		return '$' + Integer.toString(elements.indexOf(element));
	}

	public static String getDelimiterFieldName(AbstractElement element) {
		return getFieldName(element.eClass().getName(), getElementIndex(element) + "$Delimiter");
	}

	public static String getConsumerFieldName(AbstractElement element) {
		return getFieldName(element.eClass().getName(), getElementIndex(element) + "$Consumer");
	}

	public static String getGlobalDelimiterFieldName(AbstractElement element) {
		// TODO make upperCase -> UPPER_CASE$1$DELIMITER
		return getFieldName(element.eClass().getName(), getElementIndex(element, GrammarUtil.getGrammar(element))
				+ "$Delimiter");
	}

	public static Iterator<Keyword> getConflictingKeywords(final TerminalRule rule, final Iterator<Keyword> allKeywords) {
		return Iterators.filter(allKeywords, new Predicate<Keyword>() {
			@Override
			public boolean apply(Keyword param) {
				final ParserRule containerRule = EcoreUtil2.getContainerOfType(param, ParserRule.class);
				if (containerRule == null)
					return false;
				TerminalRuleInterpreter interpreter = new TerminalRuleInterpreter(param);
				return interpreter.matches(rule);
			}
		});
	}

	// TODO SZ: replace return value with ICharacterClass or similar
	public static List<AbstractRule> getConflictingLexerRules(final Keyword keyword, final Grammar grammar) {
		AbstractRule rule = GrammarUtil.findRuleForName(grammar, "ID");
		if (rule != null) {
			// TODO SZ: use interpreter
			final StringWithOffset input = new StringWithOffset(keyword.getValue());
			if (new TerminalsIDConsumer(new MyTerminalConsumerConfiguration(input)).consume() == ConsumeResult.SUCCESS) {
				return Collections.singletonList(rule);
			}
		}
		return Collections.emptyList();
	}

	public static List<String> getConflictingKeywords(final AbstractElement element, final Grammar grammar) {
		if (element instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) element).getRule();
			if (rule instanceof TerminalRule)
				return getConflictingKeywordsImpl(grammar, (TerminalRule) rule);
		}
		return null;
	}

	private static List<String> getConflictingKeywordsImpl(final Grammar grammar, TerminalRule rule) {
		final Iterator<Keyword> conflictingKeywords = getConflictingKeywords(rule,
				Iterators.filter(EcoreUtil.getAllContents(grammar, true), Keyword.class));
		Set<String> res = Sets.newLinkedHashSet();
		Iterators.addAll(res, Iterators.transform(conflictingKeywords, new Function<Keyword, String>() {
			@Override
			public String apply(Keyword param) {
				return param.getValue();
			}
		}));
		return Lists.newArrayList(res);
	}

	// TODO think about super grammar
	public static AbstractElement findFirstWithSameConflicts(final AbstractElement element, final Grammar grammar) {
		final List<String> conflicting = getConflictingKeywords(element, grammar);
		AbstractElement result = element;
		Iterator<AbstractElement> iterator = Iterators.filter(
				Iterators.filter(EcoreUtil.getAllContents(grammar, true), AbstractElement.class),
				new Predicate<AbstractElement>() {
					@Override
					public boolean apply(AbstractElement param) {
						final List<String> otherConflicting = getConflictingKeywords(param, grammar);
						return otherConflicting != null && otherConflicting.equals(conflicting);
					}
				});
		if (iterator.hasNext())
			result = iterator.next();

		return result;
	}

	// TODO think about super grammar
	public static Keyword findFirstKeywordWithSameConflicts(final Keyword element, final Grammar grammar) {
		final List<AbstractRule> conflicting = getConflictingLexerRules(element, grammar);
		Keyword result = element;
		Iterator<Keyword> iterator = Iterators.filter(
				Iterators.filter(EcoreUtil.getAllContents(grammar, true), Keyword.class), new Predicate<Keyword>() {
					@Override
					public boolean apply(Keyword param) {
						if (GrammarUtil.containingParserRule(param) == null)
							return false;
						final List<AbstractRule> otherConflicting = getConflictingLexerRules(param, grammar);
						return otherConflicting != null && otherConflicting.equals(conflicting);
					}
				});
		if (iterator.hasNext())
			result = iterator.next();

		return result;
	}

}
