/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.rt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
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
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ITokenToStringConverter;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter;
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
@Deprecated(forRemoval = true)
public class AntlrGeneratorFragment extends AbstractAntlrGeneratorFragmentEx {

	@Override
	public void generate(final Grammar grammar, XpandExecutionContext ctx) {
		KeywordHelper helper = new KeywordHelper(grammar, getOptions().isIgnoreCase());
		super.generate(grammar, ctx);
		final String srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath();
		final String encoding = getEncoding(ctx, Generator.SRC_GEN);
		final String lexerBaseFileName = srcGenPath+"/"+getFragmentHelper().getLexerGrammarFileName(grammar).replace('.', '/');
		String libPath = lexerBaseFileName;
		libPath = libPath.substring(0, libPath.lastIndexOf('/'));
		String absoluteLexerFileName = lexerBaseFileName + ".g";
		String absoluteParserFileName = srcGenPath+"/"+getFragmentHelper().getParserGrammarFileName(grammar).replace('.', '/')+".g";
		addAntlrParam("-fo");
		addAntlrParam(absoluteParserFileName.substring(0, absoluteParserFileName.lastIndexOf('/')));
		String[] lexerAntlrParams = getAntlrParams();
		lexerAntlrParams[lexerAntlrParams.length - 1] = absoluteLexerFileName.substring(0, absoluteLexerFileName.lastIndexOf('/'));
		getAntlrTool().runWithEncodingAndParams(absoluteLexerFileName, encoding, lexerAntlrParams);
		cleanupLexerTokensFile(lexerBaseFileName, helper, encoding);
		addAntlrParam("-lib");
		addAntlrParam(libPath);
		getAntlrTool().runWithEncodingAndParams(absoluteParserFileName, encoding, getAntlrParams());
		Charset charset = Charset.forName(encoding);
		simplifyUnorderedGroupPredicatesIfRequired(grammar, absoluteParserFileName, charset);
		splitParserAndLexerIfEnabled(absoluteLexerFileName, absoluteParserFileName, charset);
		suppressWarnings(absoluteLexerFileName, absoluteParserFileName, charset);
		normalizeLineDelimiters(absoluteLexerFileName, absoluteParserFileName, charset);
		normalizeTokens(absoluteParserFileName, charset);
		MutableTokenDefProvider provider = createLexerTokensProvider(lexerBaseFileName, helper, charset);
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
			provider.writeTokenFile(new PrintWriter(new File(srcGenPath+"/"+getFragmentHelper().getParserGrammarFileName(grammar).replace('.', '/') + ".tokens"), encoding));
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		normalizeTokens(absoluteLexerFileName, charset);
		helper.discardHelper(grammar);
	}
	
	/**
	 * @deprecated use {@link #createLexerTokensProvider(String, KeywordHelper, Charset)} instead
	 */
	@Deprecated(forRemoval = true)
	protected MutableTokenDefProvider createLexerTokensProvider(final String lexerBaseFileName) {
		return createLexerTokensProvider(lexerBaseFileName, null, Charset.defaultCharset());
	}

	/**
	 * @since 2.7
	 */
	protected MutableTokenDefProvider createLexerTokensProvider(final String lexerBaseFileName, KeywordHelper helper, Charset encoding) {
		MutableTokenDefProvider provider = new MutableTokenDefProvider(helper, encoding);
		provider.setAntlrTokenFileProvider(new IAntlrTokenFileProvider() {
			@Override
			public InputStream getAntlrTokenFile() {
				try {
					return new FileInputStream(lexerBaseFileName + ".tokens");
				}
				catch (FileNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
		});
		return provider;
	}
	
	/**
	 * @deprecated use {@link #cleanupLexerTokensFile(String, KeywordHelper, String)} instead.
	 */
	@Deprecated(forRemoval = true)
	protected void cleanupLexerTokensFile(String lexerBaseFileName) {
		if (getOptions().isBacktrackLexer()) {
			MutableTokenDefProvider provider = createLexerTokensProvider(lexerBaseFileName, null, Charset.defaultCharset());
			Iterator<Entry<Integer, String>> entries = provider.getTokenDefMap().entrySet().iterator();
			while(entries.hasNext()) {
				String value = entries.next().getValue();
				if (!value.startsWith("KEYWORD_") && !value.startsWith("RULE_") && !value.startsWith("SUPER_"))
					entries.remove();
			}
			try {
				provider.writeTokenFile(new PrintWriter(new File(lexerBaseFileName + ".tokens"), Charset.defaultCharset().name()));
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * @since 2.7
	 */
	protected void cleanupLexerTokensFile(String lexerBaseFileName, KeywordHelper helper, String encoding) {
		if (getOptions().isBacktrackLexer()) {
			MutableTokenDefProvider provider = createLexerTokensProvider(lexerBaseFileName, helper, Charset.forName(encoding));
			Iterator<Entry<Integer, String>> entries = provider.getTokenDefMap().entrySet().iterator();
			while(entries.hasNext()) {
				String value = entries.next().getValue();
				if (!helper.isKeywordRule(value) && !value.startsWith("RULE_") && !value.startsWith("SUPER_"))
					entries.remove();
			}
			try {
				provider.writeTokenFile(new PrintWriter(new File(lexerBaseFileName + ".tokens"), encoding));
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
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
			.addTypeToType(IParser.class.getName(),getFragmentHelper().getParserClassName(grammar))
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
			.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper", "org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper")
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
