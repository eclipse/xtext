/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.rt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;
import org.eclipse.xtext.conversion.impl.IgnoreCaseIDValueConverter;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.generator.parser.antlr.ex.common.AbstractAntlrGeneratorFragmentEx;
import org.eclipse.xtext.generator.parser.antlr.ex.common.KeywordHelper;
import org.eclipse.xtext.generator.parser.antlr.ex.common.MutableTokenDefProvider;
import org.eclipse.xtext.parser.ITokenToStringConverter;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.UnorderedGroupHelper;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.IgnoreCaseKeywordSerializer;


/**
 * Converts the Xtext grammar to an AntLR grammar runs the AntLR generator. 
 * Additionally generates some parser/lexer related services
 *  
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrGeneratorFragment extends AbstractAntlrGeneratorFragmentEx {
	
	@Override
	public void generate(final Grammar grammar, XpandExecutionContext ctx) {
		KeywordHelper helper = new KeywordHelper(grammar, getOptions().isIgnoreCase());
		super.generate(grammar, ctx);
		final String srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath();
		String libPath = srcGenPath + "/" + getFragmentHelper().getLexerGrammarFileName(grammar).replace('.', '/');
		libPath = libPath.substring(0, libPath.lastIndexOf('/'));
		String absoluteLexerFileName = srcGenPath+"/"+getFragmentHelper().getLexerGrammarFileName(grammar).replace('.', '/')+".g";
		String absoluteParserFileName = srcGenPath+"/"+getFragmentHelper().getParserGrammarFileName(grammar).replace('.', '/')+".g";
		getAntlrTool().runWithParams(absoluteLexerFileName, getAntlrParams());
		addAntlrParam("-lib");
		addAntlrParam(libPath);
		getAntlrTool().runWithParams(absoluteParserFileName, getAntlrParams());
		simplifyUnorderedGroupPredicatesIfRequired(grammar, absoluteParserFileName);
		splitParserAndLexerIfEnabled(absoluteLexerFileName, absoluteParserFileName);
		suppressWarnings(absoluteLexerFileName, absoluteParserFileName);
		
		MutableTokenDefProvider provider = new MutableTokenDefProvider();
		provider.setAntlrTokenFileProvider(new IAntlrTokenFileProvider() {
			public InputStream getAntlrTokenFile() {
				try {
					return new FileInputStream(srcGenPath+"/"+getFragmentHelper().getLexerGrammarFileName(grammar).replace('.', '/') + ".tokens");
				}
				catch (FileNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
		});
		for(Map.Entry<Integer, String> entry: provider.getTokenDefMap().entrySet()) {
			String value = entry.getValue();
			if(helper.isKeywordRule(value)) {
				String keywordAsAntlrString = AntlrGrammarGenUtil.toAntlrString(helper.getKeywordValue(value));
				entry.setValue("'" + keywordAsAntlrString + "'");
			} else if (value.startsWith("'")) {
				value = AntlrGrammarGenUtil.toAntlrString(value);
				entry.setValue("'" + value + "'");
			}
		}
		try {
			provider.writeTokenFile(new PrintWriter(new File(srcGenPath+"/"+getFragmentHelper().getParserGrammarFileName(grammar).replace('.', '/') + ".tokens")));
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		helper.discardHelper(grammar);
	}
	
	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[]{
				getNaming().basePackageRuntime(grammar) + ".parser.antlr",
				getNaming().basePackageRuntime(grammar) + ".parser.antlr.internal",
				getNaming().basePackageRuntime(grammar) + ".parser.antlr.lexer"
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
			.addTypeToType(IAntlrParser.class.getName(),getFragmentHelper().getParserClassName(grammar))
			.addTypeToType(ITokenToStringConverter.class.getName(),AntlrTokenToStringConverter.class.getName())
			.addTypeToType(IAntlrTokenFileProvider.class.getName(),getFragmentHelper().getAntlrTokenFileProviderClassName(grammar))
			.addTypeToType(Lexer.class.getName(), getFragmentHelper().getLexerClassName(grammar))
			.addTypeToProviderInstance(getFragmentHelper().getLexerClassName(grammar), "org.eclipse.xtext.parser.antlr.LexerProvider.create(" + getFragmentHelper().getLexerClassName(grammar) + ".class)")
			.addConfiguredBinding("RuntimeLexer", 
					"binder.bind(" + Lexer.class.getName() + ".class)"+
					".annotatedWith(com.google.inject.name.Names.named(" +
					"org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME" +
					")).to(" + getFragmentHelper().getLexerClassName(grammar) +".class)")
			.addTypeToType(ITokenDefProvider.class.getName(),AntlrTokenDefProvider.class.getName());
		if (containsUnorderedGroup(grammar))
			factory = factory.addTypeToType(IUnorderedGroupHelper.class.getName(), UnorderedGroupHelper.class.getName());
		if (getOptions().isIgnoreCase()) {
			factory = factory
				.addTypeToType(ITokenSerializer.IKeywordSerializer.class.getName(), IgnoreCaseKeywordSerializer.class.getName())
				.addTypeToType(AbstractIDValueConverter.class.getName(), IgnoreCaseIDValueConverter.class.getName());
		}
		return factory.getBindings();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.jface.text.rules.ITokenScanner","org.eclipse.xtext.ui.editor.syntaxcoloring.antlr.AntlrTokenScanner")
			.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper", "org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper")
			.addTypeToType("org.eclipse.xtext.ui.editor.IDamagerRepairer", "org.eclipse.xtext.ui.editor.XtextDamagerRepairer")
			.addConfiguredBinding("HighlightingLexer", 
					"binder.bind(" + Lexer.class.getName() + ".class)"+
					".annotatedWith(com.google.inject.name.Names.named(" +
					"org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING" +
					")).to(" + getFragmentHelper().getLexerClassName(grammar) +".class)")
			.addConfiguredBinding("HighlightingTokenDefProvider", 
					"binder.bind(" + ITokenDefProvider.class.getName() + ".class)"+
					".annotatedWith(com.google.inject.name.Names.named(" +
					"org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING" +
					")).to(" + AntlrTokenDefProvider.class.getName() +".class)")
			.getBindings();
	}
	
	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if(getOptions().isBacktrackLexer() && getOptions().isIgnoreCase())
			issues.addError("Backtracking lexer and ignorecase cannot be combined for now.");
	}
	
}
