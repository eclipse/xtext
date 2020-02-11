/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import java.nio.charset.Charset;
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
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.BacktrackingGuardRemover;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

/**
 * A {@link IGeneratorFragment} to generate a lightweight AntLR based parser used in content assist.
 *
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class XtextAntlrUiGeneratorFragment extends AbstractAntlrGeneratorFragment {
	
	private boolean removeBacktrackingGuards = false;
	private int lookaheadThreshold = Integer.MAX_VALUE;
	private boolean partialParsing;
	
	/**
	 * Whether to use a partial parsing approach, improving performance for large files. 
	 * This will generally not work for grammars containing unordered groups.
	 * @since 2.7
	 */
	public void setPartialParsing(boolean partialParsing) {
		this.partialParsing = partialParsing;
	}
	/**
	 * @since 2.7
	 */
	public boolean isPartialParsing() {
		return partialParsing;
	}
	
	/**
	 * @since 2.4
	 */
	public void setRemoveBacktrackingGuards(boolean removeBacktrackingGuards) {
		this.removeBacktrackingGuards = removeBacktrackingGuards;
	}
	
	
	/**
	 * @since 2.4
	 */
	public void setLookaheadThreshold(String lookaheadThreshold) {
		this.lookaheadThreshold = Integer.parseInt(lookaheadThreshold);
	}

	/**
	 * @since 2.4
	 * @deprecated use {@link #removeBacktrackingGuardsIfEnabled(String, Charset)} instead
	 */
	@Deprecated
	protected void removeBacktrackingGuardsIfEnabled(String absoluteGrammarFileName) {
		removeBacktrackingGuardsIfEnabled(absoluteGrammarFileName, Charset.defaultCharset());
	}
	
	/**
	 * @since 2.7
	 */
	protected void removeBacktrackingGuardsIfEnabled(String absoluteGrammarFileName, Charset encoding) {
		if (removeBacktrackingGuards) {
			String javaFile = absoluteGrammarFileName.replaceAll("\\.g$", getParserFileNameSuffix());
			String content = readFileIntoString(javaFile, encoding);
			BacktrackingGuardRemover remover = new BacktrackingGuardRemover(content, lookaheadThreshold);
			String newContent = remover.transform();
			writeStringIntoFile(javaFile, newContent, encoding);
		}
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		String srcUiGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN_IDE).getPath();
		final String encoding = getEncoding(ctx, Generator.SRC_GEN_IDE);
		String absoluteGrammarFileName = srcUiGenPath + "/" + getGrammarFileName(grammar, getNaming()).replace('.', '/') + ".g";
		addAntlrParam("-fo");
		addAntlrParam(absoluteGrammarFileName.substring(0, absoluteGrammarFileName.lastIndexOf('/')));
		getAntlrTool().runWithEncodingAndParams(absoluteGrammarFileName, encoding, getAntlrParams());
		Charset charset = Charset.forName(getEncoding(ctx, Generator.SRC_GEN_IDE));
		simplifyUnorderedGroupPredicatesIfRequired(grammar, absoluteGrammarFileName, charset);
		splitParserAndLexerIfEnabled(absoluteGrammarFileName, charset);
		suppressWarnings(absoluteGrammarFileName, charset);
		removeBacktrackingGuardsIfEnabled(absoluteGrammarFileName, charset);
		normalizeLineDelimiters(absoluteGrammarFileName, charset);
		normalizeTokens(absoluteGrammarFileName, charset);
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
		BindFactory binder = new BindFactory();
			if(getNaming().hasIde()){
				binder.addTypeToType(
						"org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory",
						"org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory");
				binder.addTypeToType(
						"org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser",
						getParserClassName(grammar, getNaming()));
			} else {
				binder.addTypeToType(
						"org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory",
						"org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory");
				binder.addTypeToType(
						"org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser",
						getParserClassName(grammar, getNaming()));
			}
			binder.addConfiguredBinding("ContentAssistLexerProvider",
					"binder.bind(" + getInternalLexerClassName(grammar, getNaming()) +".class)"+
					".toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(" + getInternalLexerClassName(grammar, getNaming()) + ".class))");
			if(getNaming().hasIde()){
				binder.addConfiguredBinding("ContentAssistLexer",
						"binder.bind(org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer.class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.ide.LexerIdeBindings.CONTENT_ASSIST" +
						")).to(" + getInternalLexerClassName(grammar, getNaming()) +".class)");
			} else {
				binder.addConfiguredBinding("ContentAssistLexer",
						"binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST" +
						")).to(" + getInternalLexerClassName(grammar, getNaming()) +".class)");
			}
		if (partialParsing) {
			if(getNaming().hasIde()){
				binder.addTypeToType(
					"org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory", 
					"org.eclipse.xtext.ide.editor.contentassist.antlr.PartialContentAssistContextFactory");
			} else {
				binder.addTypeToType(
					 "org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory", 
					 "org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.PartialStatefulFactory");
			}
		}
		return binder.getBindings();
	}

	@Override
	public String[] getExportedPackagesIde(Grammar grammar) {
		String caAntlrpackage = getNaming().basePackageIde(grammar) + ".contentassist.antlr";
		return new String[] { caAntlrpackage, caAntlrpackage + ".internal" };
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return ImmutableList.of(getOptions(), partialParsing, getNaming().hasIde());
	}

	public static String getParserClassName(Grammar g, Naming naming) {
		return naming.basePackageIde(g) + ".contentassist.antlr." + GrammarUtil.getSimpleName(g) + "Parser";
	}

	public static String getInternalLexerClassName(Grammar g, Naming naming) {
		return naming.basePackageIde(g) + ".contentassist.antlr.internal.Internal" + GrammarUtil.getSimpleName(g)
				+ "Lexer";
	}

	public static String getInternalParserClassName(Grammar g, Naming naming) {
		return  naming.basePackageIde(g) + ".contentassist.antlr.internal.Internal" + GrammarUtil.getSimpleName(g)
				+ "Parser";
	}

	public static String getGrammarFileName(Grammar g, Naming naming) {
		return naming.basePackageIde(g) + ".contentassist.antlr.internal.Internal" + GrammarUtil.getSimpleName(g);
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

	public static Collection<AbstractElement> getAllPredicatedElements(Grammar g) {
		Collection<AbstractElement> unfiltered = getAllElementsByType(g, AbstractElement.class);
		Collection<AbstractElement> result = Collections2.filter(unfiltered, new Predicate<AbstractElement>() {
			@Override
			public boolean apply(AbstractElement input) {
				return input.isPredicated() || input.isFirstSetPredicated();
			}
		});
		return result;
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
