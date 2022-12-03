/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Condition;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Heiko Behrens
 */
@Deprecated(forRemoval = true)
public class AntlrGrammarGenUtil {
	
	/**
	 * Returns the effective rule name for the generated Antlr grammar.
	 * Inherited rules may be prefixed by {@code super[0..9]*}. Otherwise the
	 * prefix {@code rule or RULE_} is used.
	 * @since 2.9
	 */
	public static String getRuleName(AbstractRule rule) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getRuleName(rule);
	}
	
	/**
	 * @since 2.9
	 */
	public static String getEntryRuleName(ParserRule rule) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getEntryRuleName(rule);
	}
	
	/**
	 * @since 2.9
	 */
	public static boolean isValidEntryRule(ParserRule rule) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.isValidEntryRule(rule);
	}
	/**
	 * @since 2.9
	 */
	public static <T extends EObject> T getOriginalElement(T obj) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getOriginalElement(obj);
	}

	/**
	 * @since 2.9
	 */
	public static int getParameterConfig(ParserRule rule) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getParameterConfig(rule);
	}
	
	/**
	 * @since 2.9
	 */
	public static String getParameterList(ParserRule rule, Boolean skipCurrent) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getParameterList(rule, skipCurrent, "EObject");
	}
	
	/**
	 * @since 2.9
	 */
	public static String getArgumentList(final RuleCall ruleCall, final Boolean skipCurrent) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getArgumentList(ruleCall, skipCurrent);
	}
	
	/**
	 * @since 2.9
	 */
	public static String conditionToAntlr(Condition condition, final boolean includeRuleName) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.conditionToAntlr(condition, includeRuleName);
	}
	
	/**
	 * @since 2.9
	 */
	public static String getDefaultArgumentList(ParserRule rule) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getDefaultArgumentList(rule);
	}

	/**
	 * @since 2.9
	 */
	public static String guardConditionToAntlr(Group group) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.guardConditionToAntlr(group);
	}

	/**
	 * @since 2.9
	 */
	public static AbstractElement getPredicatedElement(AbstractElement element) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getPredicatedElement(element);
	}
	
	/**
	 * @since 2.9
	 */
	public static String getQualifiedNameAsString(RuleCall ruleCall) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getQualifiedNameAsString(ruleCall);
	}
	
	public static String toAntlrString(String string) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.toAntlrString(string);
	}
	
	/**
	 * Returns the first-set of the given abstractElement. That is, all keywords
	 * with distinct values and all rule calls to distinct terminals.
	 * @since 2.6
	 */
	public static List<AbstractElement> getFirstSet(AbstractElement element) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getFirstSet(element);
	}

	public static String toStringInAntlrAction(String string) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.toStringInAntlrAction(string);
	}

	public static String toAntlrStringIgnoreCase(String string) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.toAntlrStringIgnoreCase(string);
	}

	public static String getClasspathURI(Grammar grammar, EObject object) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.getClasspathURI(grammar, object);
	}
}