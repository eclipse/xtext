/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.NamingAware;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

/**
 * The fragment helper will be passed to the extended Antlr grammar template and allows to
 * override certain aspects. This is an attempt to circumvent the limitations of static java
 * extensions.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class AntlrFragmentHelper implements NamingAware {

	private Naming naming;

	public AntlrFragmentHelper(Naming naming) {
		this.naming = naming;
	}

	/**
	 * @since 2.8
	 */
	public AntlrFragmentHelper() {
	}
	
	/**
	 * @since 2.8
	 */
	@Override
	public void registerNaming(Naming n) {
		this.naming = n;
	}

	public String getAntlrTokenFileProviderClassName(Grammar grammar) {
		return naming.basePackageRuntime(grammar) + ".parser.antlr." + GrammarUtil.getSimpleName(grammar)	+ "AntlrTokenFileProvider";
	}

	public String getLexerClassName(Grammar g) {
		return getLexerGrammarFileName(g);
	}

	public String getParserClassName(Grammar g) {
		return naming.basePackageRuntime(g) + ".parser.antlr." + GrammarUtil.getSimpleName(g) + "Parser";
	}
	
	/**
	 * @since 2.8
	 */
	public String getTokenSourceClassName(Grammar g) {
		return naming.basePackageRuntime(g) + ".parser.antlr." + GrammarUtil.getSimpleName(g) + "TokenSource";
	}

	public String getInternalParserClassName(Grammar g) {
		return getParserGrammarFileName(g);
	}

	public String getLexerGrammarFileName(Grammar g) {
		return naming.basePackageRuntime(g) + ".parser.antlr.lexer.Internal" + GrammarUtil.getSimpleName(g) + "Lexer";
	}

	public String getParserGrammarFileName(Grammar g) {
		return naming.basePackageRuntime(g) + ".parser.antlr.internal.Internal" + GrammarUtil.getSimpleName(g) + "Parser";
	}

	public String getContentAssistParserClassName(Grammar g) {
		return naming.basePackageIde(g) + ".contentassist.antlr." + GrammarUtil.getSimpleName(g) + "Parser";
	}
	
	/**
	 * @since 2.8
	 */
	public String getContentAssistTokenSourceClassName(Grammar g) {
		return naming.basePackageIde(g) + ".parser.antlr." + GrammarUtil.getSimpleName(g) + "TokenSource";
	}

	public String getInternalContentAssistLexerClassName(Grammar g) {
		return getContentAssistLexerGrammarFileName(g);
	}

	public String getLexerSuperClass(Grammar g) {
		return "org.eclipse.xtext.parser.antlr.Lexer";
	}

	public String getContentAssistLexerSuperClass(Grammar g) {
		if(naming.hasIde())
			return "org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer";
		else
			return "org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer";
	}

	public String getInternalContentAssistParserClassName(Grammar g) {
		return getContentAssistParserGrammarFileName(g);
	}

	public String getContentAssistLexerGrammarFileName(Grammar g) {
		return naming.basePackageIde(g) + ".contentassist.antlr.lexer.Internal" + GrammarUtil.getSimpleName(g) + "Lexer";
	}

	public String getContentAssistParserGrammarFileName(Grammar g) {
		return naming.basePackageIde(g) + ".contentassist.antlr.internal.Internal" + GrammarUtil.getSimpleName(g) + "Parser";
	}

	public Collection<? extends AbstractElement> getAllAlternatives(Grammar g) {
		return getAllElementsByType(g, Alternatives.class);
	}

	public Collection<? extends AbstractElement> getAllGroups(Grammar g) {
		return getAllElementsByType(g, Group.class);
	}

	public Collection<? extends AbstractElement> getAllUnorderedGroups(Grammar g) {
		return getAllElementsByType(g, UnorderedGroup.class);
	}

	public Collection<? extends AbstractElement> getAllAssignments(Grammar g) {
		return getAllElementsByType(g, Assignment.class);
	}

	public Collection<? extends AbstractElement> getAllPredicatedElements(Grammar g) {
		Collection<AbstractElement> unfiltered = getAllElementsByType(g, AbstractElement.class);
		Collection<AbstractElement> result = Collections2.filter(unfiltered, new Predicate<AbstractElement>() {
			@Override
			public boolean apply(AbstractElement input) {
				return input.isPredicated();
			}
		});
		return result;
	}

	/**
	 * Synthetic terminal rules are rules which will not lead to a real terminal
	 * rule in the generated lexer grammar but only provide the respective token types
	 * instead.
	 * @return <code>true</code> if this rule should not get an own lexer body.
	 */
	public boolean isSyntheticTerminalRule(TerminalRule rule) {
		return false;
	}

	protected <T extends AbstractElement> Collection<T> getAllElementsByType(Grammar g, Class<T> type) {
		Collection<ParserRule> allParserRules = GrammarUtil.allParserRules(g);
		List<T> result = new ArrayList<T>(30);
		for (ParserRule rule : allParserRules) {
			result.addAll(EcoreUtil2.getAllContentsOfType(rule, type));
		}
		Collection<EnumRule> allEnumRules = GrammarUtil.allEnumRules(g);
		for (EnumRule rule : allEnumRules) {
			result.addAll(EcoreUtil2.getAllContentsOfType(rule, type));
		}
		return result;
	}

}
