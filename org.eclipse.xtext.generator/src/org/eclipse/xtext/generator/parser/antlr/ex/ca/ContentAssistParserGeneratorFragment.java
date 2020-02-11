/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.ca;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.ex.common.AbstractAntlrGeneratorFragmentEx;
import org.eclipse.xtext.generator.parser.antlr.ex.common.KeywordHelper;

import com.google.common.collect.ImmutableList;

/**
 * A {@link IGeneratorFragment} to generate a lightweight AntLR based parser used in content assist.
 *
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class ContentAssistParserGeneratorFragment extends AbstractAntlrGeneratorFragmentEx {
	
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

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		KeywordHelper helper = new KeywordHelper(grammar, getOptions().isIgnoreCase());
		super.generate(grammar, ctx);
		final String srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN_IDE).getPath();
		final String encoding = getEncoding(ctx, Generator.SRC_GEN_IDE);
		String libPath = srcGenPath + "/" + getFragmentHelper().getContentAssistLexerGrammarFileName(grammar).replace('.', '/');
		libPath = libPath.substring(0, libPath.lastIndexOf('/'));
		String absoluteLexerFileName = srcGenPath+"/"+getFragmentHelper().getContentAssistLexerGrammarFileName(grammar).replace('.', '/')+".g";
		String absoluteParserFileName = srcGenPath+"/"+getFragmentHelper().getContentAssistParserGrammarFileName(grammar).replace('.', '/')+".g";
		addAntlrParam("-fo");
		addAntlrParam(absoluteParserFileName.substring(0, absoluteParserFileName.lastIndexOf('/')));
		String[] lexerAntlrParams = getAntlrParams();
		lexerAntlrParams[lexerAntlrParams.length - 1] = absoluteLexerFileName.substring(0, absoluteLexerFileName.lastIndexOf('/'));
		getAntlrTool().runWithEncodingAndParams(absoluteLexerFileName, encoding, lexerAntlrParams);
		addAntlrParam("-lib");
		addAntlrParam(libPath);
		getAntlrTool().runWithEncodingAndParams(absoluteParserFileName, encoding, getAntlrParams());
		Charset charset = Charset.forName(encoding);
		simplifyUnorderedGroupPredicatesIfRequired(grammar, absoluteParserFileName, charset);
		splitParserAndLexerIfEnabled(absoluteLexerFileName, absoluteParserFileName, charset);
		suppressWarnings(absoluteLexerFileName, absoluteParserFileName, charset);
		normalizeLineDelimiters(absoluteLexerFileName, absoluteParserFileName, charset);
		normalizeTokens(absoluteLexerFileName, charset);
		normalizeTokens(absoluteParserFileName, charset);
		helper.discardHelper(grammar);
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		BindFactory binder = new BindFactory();
		if(getNaming().hasIde()){
			binder.addTypeToType(
					"org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory",
					"org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory")
			.addTypeToType(
					"org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser",
					getFragmentHelper().getContentAssistParserClassName(grammar));
		} else {
			binder.addTypeToType(
					"org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory",
					"org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory")
			.addTypeToType(
					"org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser",
					getFragmentHelper().getContentAssistParserClassName(grammar));
		}
		binder.addConfiguredBinding("ContentAssistLexerProvider",
				"binder.bind(" + getFragmentHelper().getInternalContentAssistLexerClassName(grammar) +".class)"+
				".toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(" + getFragmentHelper().getInternalContentAssistLexerClassName(grammar) + ".class))");
		if(getNaming().hasIde()){
			binder.addConfiguredBinding("ContentAssistLexer",
					"binder.bind(org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer.class)"+
					".annotatedWith(com.google.inject.name.Names.named(" +
					"org.eclipse.xtext.ide.LexerIdeBindings.CONTENT_ASSIST" +
					")).to(" + getFragmentHelper().getInternalContentAssistLexerClassName(grammar) +".class)");
		} else {
			binder.addConfiguredBinding("ContentAssistLexer",
					"binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class)"+
					".annotatedWith(com.google.inject.name.Names.named(" +
					"org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST" +
					")).to(" + getFragmentHelper().getInternalContentAssistLexerClassName(grammar) +".class)");
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
	public String[] getRequiredBundlesIde(Grammar grammar) {
		return new String[] { "org.antlr.runtime" };
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return ImmutableList.of(getOptions(), getFragmentHelper(), partialParsing, getNaming().hasIde());
	}

}
