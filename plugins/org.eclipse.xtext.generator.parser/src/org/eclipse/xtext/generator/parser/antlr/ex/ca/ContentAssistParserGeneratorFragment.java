/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.ca;

import java.util.Set;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.ex.common.AbstractAntlrGeneratorFragmentEx;
import org.eclipse.xtext.generator.parser.antlr.ex.common.KeywordHelper;


/**
 * A {@link IGeneratorFragment} to generate a lightweight AntLR based parser used in content assist.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistParserGeneratorFragment extends AbstractAntlrGeneratorFragmentEx {

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		KeywordHelper helper = new KeywordHelper(grammar, getOptions().isIgnoreCase());
		super.generate(grammar, ctx);
		final String srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN_UI).getPath();
		String libPath = srcGenPath + "/" + getFragmentHelper().getContentAssistLexerGrammarFileName(grammar).replace('.', '/');
		libPath = libPath.substring(0, libPath.lastIndexOf('/'));
		String absoluteLexerFileName = srcGenPath+"/"+getFragmentHelper().getContentAssistLexerGrammarFileName(grammar).replace('.', '/')+".g";
		String absoluteParserFileName = srcGenPath+"/"+getFragmentHelper().getContentAssistParserGrammarFileName(grammar).replace('.', '/')+".g";
		getAntlrTool().runWithParams(absoluteLexerFileName, getAntlrParams());
		addAntlrParam("-lib");
		addAntlrParam(libPath);
		getAntlrTool().runWithParams(absoluteParserFileName, getAntlrParams());
		simplifyUnorderedGroupPredicatesIfRequired(grammar, absoluteParserFileName);
		splitParserAndLexerIfEnabled(absoluteLexerFileName, absoluteParserFileName);
		suppressWarnings(absoluteLexerFileName, absoluteParserFileName);
		helper.discardHelper(grammar);
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(
					"org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory",
					"org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory")
			.addTypeToType(
					"org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser",
					getFragmentHelper().getContentAssistParserClassName(grammar))
			.addConfiguredBinding("ContentAssistLexerProvider", 
					"binder.bind(" + getFragmentHelper().getInternalContentAssistLexerClassName(grammar) +".class)"+
					".toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(" + getFragmentHelper().getInternalContentAssistLexerClassName(grammar) + ".class))")
			.addConfiguredBinding("ContentAssistLexer", 
					"binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class)"+
					".annotatedWith(com.google.inject.name.Names.named(" +
					"org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST" +
					")).to(" + getFragmentHelper().getInternalContentAssistLexerClassName(grammar) +".class)")
			.getBindings();
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.antlr.runtime" };
	}

}
