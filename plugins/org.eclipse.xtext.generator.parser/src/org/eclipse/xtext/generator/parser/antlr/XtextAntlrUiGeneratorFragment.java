/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Naming;

/**
 * A {@link IGeneratorFragment} to generate a lightweight AntLR based parser used in content assist.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextAntlrUiGeneratorFragment extends AbstractAntlrGeneratorFragment {

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		String srcUiGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN_UI).getPath();
		String absoluteGrammarFileName = srcUiGenPath + "/" + getGrammarFileName(grammar, getNaming()).replace('.', '/') + ".g";
		getAntlrTool().runWithParams(absoluteGrammarFileName, getAntlrParams());
		simplifyUnorderedGroupPredicatesIfRequired(grammar, absoluteGrammarFileName);
		splitParserAndLexerIfEnabled(absoluteGrammarFileName);
		suppressWarnings(absoluteGrammarFileName);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (getOptions().isBacktrackLexer()) {
			issues.addError("This fragment does not support the option 'backtracking' for the lexer. Use 'org.eclipse.xtext.generator.parser.antlr.ex.ca.ContentAssistParserGeneratorFragment' instead");
		}
		if (getOptions().isIgnoreCase()) {
			issues.addError("This fragment does not support the option 'ignoreCase'. Use 'org.eclipse.xtext.generator.parser.antlr.ex.ca.ContentAssistParserGeneratorFragment' instead");
		}
	}
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(
					"org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory",
					"org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory")
			.addTypeToType(
					"org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser",
					getParserClassName(grammar, getNaming()))
			.addConfiguredBinding("ContentAssistLexerProvider", 
					"binder.bind(" + getInternalLexerClassName(grammar, getNaming()) +".class)"+
					".toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(" + getInternalLexerClassName(grammar, getNaming()) + ".class))")
			.addConfiguredBinding("ContentAssistLexer", 
					"binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class)"+
					".annotatedWith(com.google.inject.name.Names.named(" +
					"org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST" +
					")).to(" + getInternalLexerClassName(grammar, getNaming()) +".class)")
			.getBindings();
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.antlr.runtime" };
	}

	@Override
	public String[] getExportedPackagesUi(Grammar grammar) {
		return new String[] { getNaming().basePackageUi(grammar) + ".contentassist.antlr" };
	}

	public static String getParserClassName(Grammar g, Naming naming) {
		return naming.basePackageUi(g) + ".contentassist.antlr." + GrammarUtil.getName(g) + "Parser";
	}

	public static String getInternalLexerClassName(Grammar g, Naming naming) {
		return naming.basePackageUi(g) + ".contentassist.antlr.internal.Internal" + GrammarUtil.getName(g)
				+ "Lexer";
	}

	public static String getInternalParserClassName(Grammar g, Naming naming) {
		return  naming.basePackageUi(g) + ".contentassist.antlr.internal.Internal" + GrammarUtil.getName(g)
				+ "Parser";
	}

	public static String getGrammarFileName(Grammar g, Naming naming) {
		return naming.basePackageUi(g) + ".contentassist.antlr.internal.Internal" + GrammarUtil.getName(g);
	}

	public static Collection<Alternatives> getAllAlternatives(Grammar g) {
		return getAllElementsByType(g, Alternatives.class);
	}
	
	public static Collection<UnorderedGroup> getAllUnorderedGroups(Grammar g) {
		return getAllElementsByType(g, UnorderedGroup.class);
	}

	public static Collection<Group> getAllGroups(Grammar g) {
		return getAllElementsByType(g, Group.class);
	}
	
	public static Collection<Assignment> getAllAssignments(Grammar g) {
		return getAllElementsByType(g, Assignment.class);
	}

	private static <T extends AbstractElement> Collection<T> getAllElementsByType(Grammar g, Class<T> type) {
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
