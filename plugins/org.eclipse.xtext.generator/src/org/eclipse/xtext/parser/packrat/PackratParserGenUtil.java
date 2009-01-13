/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
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
		String name = Strings.emptyIfNull(rule.getName());
		boolean wasUnderscore = false;
		boolean wasUppercase = true;
		boolean wasDigit = false;
		StringBuilder result = new StringBuilder(name.length());
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
		if (result.length() == 0) // name is a single underscore or empty
			if (Strings.isEmpty(name))
				return "consumer";
			else 
				return "_Consumer";
		return result.toString() + "Consumer";
	}
	
	public static String getConsumeMethodName(AbstractElement element) {
		AbstractRule rule = EcoreUtil2.getContainerOfType(element, AbstractRule.class);
		List<EObject> allContents = EcoreUtil2.eAllContentsAsList(rule);
		return "consume" + element.eClass().getName()+ '$' + Integer.toString(allContents.indexOf(element));
	}
	
	public static boolean canBeFollowedByIdentifier(Keyword keyword) {
		String value = keyword.getValue();
		return !XtextBuiltinIDConsumer.IDConsumer$$2.matches(value.charAt(value.length() - 1));
	}
	
	public static List<AbstractElement> getFollowElements(AbstractElement element) {
		final List<AbstractElement> result = new ArrayList<AbstractElement>();
		if (!(element instanceof Keyword) && !((element instanceof RuleCall) && (((RuleCall) element).getRule() instanceof LexerRule)))
			throw new IllegalArgumentException("element: " + element);
		if (GrammarUtil.isMultipleCardinality(element))
			result.add(element);
		
		return result;
	}

}
