/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import java.nio.charset.Charset;
import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ITokenToStringConverter;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.UnorderedGroupHelper;

/**
 * Converts the Xtext grammar to an AntLR grammar runs the AntLR generator.
 * Additionally generates some parser/lexer related services
 *
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@SuppressWarnings("deprecation")
public class XtextAntlrGeneratorFragment extends AbstractAntlrGeneratorFragment {

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		String srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath();
		final String encoding = getEncoding(ctx, Generator.SRC_GEN);
		String absoluteGrammarFileName = srcGenPath+"/"+getGrammarFileName(grammar, getNaming()).replace('.', '/')+".g";
		addAntlrParam("-fo");
		addAntlrParam(absoluteGrammarFileName.substring(0, absoluteGrammarFileName.lastIndexOf('/')));
		getAntlrTool().runWithEncodingAndParams(absoluteGrammarFileName, encoding, getAntlrParams());
		Charset charset = Charset.forName(encoding);
		simplifyUnorderedGroupPredicatesIfRequired(grammar, absoluteGrammarFileName, charset);
		splitParserAndLexerIfEnabled(absoluteGrammarFileName, charset);
		suppressWarnings(absoluteGrammarFileName, charset);
		normalizeLineDelimiters(absoluteGrammarFileName, charset);
		normalizeTokens(absoluteGrammarFileName, charset);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (getOptions().isBacktrackLexer()) {
			issues.addError("This fragment does not support the option 'backtracking' for the lexer. Use 'org.eclipse.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment' instead");
		}
		if (getOptions().isIgnoreCase()) {
			issues.addError("This fragment does not support the option 'ignorecase'. Use 'org.eclipse.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment' instead");
		}
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[]{
				getNaming().basePackageRuntime(grammar) + ".parser.antlr",
				getNaming().basePackageRuntime(grammar) + ".parser.antlr.internal"
		};
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[]{
				"org.antlr.runtime"
		};
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		BindFactory factory = new BindFactory()
			.addTypeToType(IParser.class.getName(),getParserClassName(grammar, getNaming()))
			.addTypeToType(ITokenToStringConverter.class.getName(),AntlrTokenToStringConverter.class.getName())
			.addTypeToType(IAntlrTokenFileProvider.class.getName(),getAntlrTokenFileProviderClassName(grammar, getNaming()))
			.addTypeToType(Lexer.class.getName(), getLexerClassName(grammar, getNaming()))
			.addTypeToProviderInstance(getLexerClassName(grammar, getNaming()), "org.eclipse.xtext.parser.antlr.LexerProvider.create(" + getLexerClassName(grammar, getNaming()) + ".class)")
			.addConfiguredBinding("RuntimeLexer",
					"binder.bind(" + Lexer.class.getName() + ".class)"+
					".annotatedWith(com.google.inject.name.Names.named(" +
					"org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME" +
					")).to(" + getLexerClassName(grammar, getNaming()) +".class)")
			.addTypeToType(ITokenDefProvider.class.getName(), AntlrTokenDefProvider.class.getName());
		if (containsUnorderedGroup(grammar))
			factory = factory.addTypeToType(IUnorderedGroupHelper.class.getName(), UnorderedGroupHelper.class.getName());
		return factory.getBindings();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		BindFactory binder = new BindFactory();
			binder.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper", "org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper");
			if(getNaming().hasIde()){
				binder.addConfiguredBinding("HighlightingLexer",
						"binder.bind(" + Lexer.class.getName() + ".class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING" +
						")).to(" + getLexerClassName(grammar, getNaming()) +".class)")
					   .addConfiguredBinding("HighlightingTokenDefProvider",
						"binder.bind(" + ITokenDefProvider.class.getName() + ".class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING" +
						")).to(" + AntlrTokenDefProvider.class.getName() +".class)");
			} else {
				binder.addConfiguredBinding("HighlightingLexer",
						"binder.bind(" + Lexer.class.getName() + ".class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING" +
						")).to(" + getLexerClassName(grammar, getNaming()) +".class)")
					   .addConfiguredBinding("HighlightingTokenDefProvider",
						"binder.bind(" + ITokenDefProvider.class.getName() + ".class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING" +
						")).to(" + AntlrTokenDefProvider.class.getName() +".class)");
			}
			return binder.getBindings();
	}

	public static String getAntlrTokenFileProviderClassName(Grammar grammar, Naming naming) {
		return naming.basePackageRuntime(grammar) + ".parser.antlr." + GrammarUtil.getSimpleName(grammar)	+ "AntlrTokenFileProvider";
	}

	public static String getLexerClassName(Grammar g, Naming naming) {
		return naming.basePackageRuntime(g) + ".parser.antlr.internal.Internal" + GrammarUtil.getSimpleName(g)	+ "Lexer";
	}

	public static String getParserClassName(Grammar g, Naming naming) {
		return naming.basePackageRuntime(g) + ".parser.antlr." + GrammarUtil.getSimpleName(g) + "Parser";
	}

	public static String getInternalParserClassName(Grammar g, Naming naming) {
		return naming.basePackageRuntime(g) + ".parser.antlr.internal.Internal" + GrammarUtil.getSimpleName(g) + "Parser";
	}

	public static String getGrammarFileName(Grammar g, Naming naming) {
		return naming.basePackageRuntime(g) + ".parser.antlr.internal.Internal" + GrammarUtil.getSimpleName(g);
	}

}
