/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.NamingAware;
import org.eclipse.xtext.generator.NewlineNormalizer;
import org.eclipse.xtext.generator.parser.antlr.AntlrToolFacade;
import org.eclipse.xtext.generator.parser.antlr.postProcessing.SuppressWarningsProcessor;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrLexerSplitter;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.internal.LexerSpecialStateTransitionSplitter;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class ExternalAntlrLexerFragment extends DefaultGeneratorFragment implements NamingAware {

	private String lexerGrammar;

	private boolean highlighting;

	private boolean runtime;

	private boolean contentAssist;
	
	private boolean classSplitting = false;
	
	private boolean specialStateSwitchSplitting = false;
	
	private int casesPerSpecialStateSwitch = LexerSpecialStateTransitionSplitter.CASES_PER_SPECIAL_STATE_SWITCH;

	private List<String> antlrParams = Lists.newArrayList();
	
	private Naming naming;

	/**
	 * @since 2.7
	 */
	@Override
	public void registerNaming(Naming naming) {
		this.naming = naming;
	}
	
	private String getLineDelimiter() {
		return naming.getLineDelimiter();
	}
	
	public void addAntlrParam(String param) {
		antlrParams.add(param);
	}

	public String[] getAntlrParams() {
		ArrayList<String> params = new ArrayList<String>(antlrParams);
		// setting the default conversion timeout to 100secs.
		// There seem to be no practical situations where the NFA conversion would hang,
		// so Terence suggested here [1] to remove the option all together
		// [1] - http://antlr.1301665.n2.nabble.com/Xconversiontimeout-td5294411.html
		if (!params.contains("-Xconversiontimeout")) {
			params.add("-Xconversiontimeout");
			params.add("100000");
		}
		String[] result = params.toArray(new String[params.size()]);
		return result;
	}

	private AntlrToolFacade antlrTool = new AntlrToolFacade();

	public void setAntlrTool(AntlrToolFacade facade) {
		this.antlrTool = facade;
	}

	public AntlrToolFacade getAntlrTool() {
		return antlrTool;
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		String srcGen = Generator.SRC_GEN;
		String src = Generator.SRC;
		if (contentAssist || highlighting) {
			srcGen = Generator.SRC_GEN_IDE;
			src = Generator.SRC_IDE;
		}
		String srcGenPath = ctx.getOutput().getOutlet(srcGen).getPath();
		String srcPath = ctx.getOutput().getOutlet(src).getPath();
		String grammarFile = srcPath + "/" + getLexerGrammar().replace('.', '/') + ".g";
		String generateTo = "";
		if (lexerGrammar.lastIndexOf('.') != -1) {
			generateTo = lexerGrammar.substring(0, lexerGrammar.lastIndexOf('.'));
		}
		generateTo = srcGenPath + "/" + generateTo.replace('.', '/');
		addAntlrParam("-fo");
		addAntlrParam(generateTo);
		final String encoding = getEncoding(ctx, srcGen);
		getAntlrTool().runWithEncodingAndParams(grammarFile, encoding, getAntlrParams());
		Charset charset = Charset.forName(encoding);
		String javaFile = srcGenPath+"/"+getLexerGrammar().replace('.', '/')+".java";
		splitLexerIfEnabled(javaFile, charset);
		suppressWarningsImpl(javaFile, charset);
		normalizeLineDelimiters(javaFile, charset);
		normalizeTokens(javaFile, charset);
	}
	
	/**
	 * @since 2.9
	 */
	protected void splitLexerIfEnabled(String lexerJavaFile, Charset encoding) {
		if (isClassSplitting()) {
			String content = readFileIntoString(lexerJavaFile, encoding);
			AntlrLexerSplitter splitter = new AntlrLexerSplitter(content);
			splitter.setAllowDFAStaticClasses(false);
			splitter.setCasesPerSpecialStateSwitch(casesPerSpecialStateSwitch);
			writeStringIntoFile(lexerJavaFile, splitter.transform(), encoding);
		}
	}
	
	private void normalizeTokens(String grammarFileName, Charset encoding) {
		String tokenFile = toTokenFileName(grammarFileName);
		String content = readFileIntoString(tokenFile, encoding);
		content = new NewlineNormalizer(getLineDelimiter()).normalizeLineDelimiters(content);
		List<String> splitted = Strings.split(content, getLineDelimiter());
		Collections.sort(splitted);
		content = Strings.concat(getLineDelimiter(), splitted) + getLineDelimiter();
		writeStringIntoFile(tokenFile, content, encoding);
	}
	
	private void normalizeLineDelimiters(String textFile, Charset encoding) {
		String content = readFileIntoString(textFile, encoding);
		content = new NewlineNormalizer(getLineDelimiter()) {
			// Antlr tries to outsmart us by using a line length that depends on the system
			// line delimiter when it splits a very long String (encoded DFA) into a
			// string concatenation
			// Here we join these lines again.
			@Override
			public String normalizeLineDelimiters(CharSequence content) {
				String result = super.normalizeLineDelimiters(content);
				result = result.replaceAll("\"\\+(\\r)?\\n\\s+\"", "");
				return result;
			}
		}.normalizeLineDelimiters(content);
		writeStringIntoFile(textFile, content, encoding);
	}
	
	private String toTokenFileName(String grammarFileName) {
		return grammarFileName.replaceAll("\\.java$", ".tokens");
	}
	
	private String getEncoding(XpandExecutionContext xpt, String outlet) {
		return xpt.getOutput().getOutlet(outlet).getFileEncoding();
	}
	
	/**
	 * @deprecated use {@link #suppressWarningsImpl(String, Charset)} instead
	 */
	@Deprecated(forRemoval = true)
	protected void suppressWarningsImpl(String javaFile) {
		suppressWarningsImpl(javaFile, Charset.defaultCharset());
	}

	/**
	 * @since 2.7
	 */
	protected void suppressWarningsImpl(String javaFile, Charset encoding) {
		String content = readFileIntoString(javaFile, encoding);
		content = new SuppressWarningsProcessor().process(content);
		writeStringIntoFile(javaFile, content, encoding);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		if (contentAssist && highlighting || runtime && highlighting || contentAssist && runtime) {
			issues.addError("Only one of those flags is allowed: contentAssist, runtime, highlighting flag");
		}
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		if (runtime)
			return new BindFactory()
				.addConfiguredBinding("RuntimeLexer",
						"binder.bind(" + Lexer.class.getName() + ".class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME" +
						")).to(" + lexerGrammar +".class)")
				.getBindings();
		return Collections.emptySet();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if (highlighting) {
			if(naming.hasIde()){
				return new BindFactory()
					.addConfiguredBinding("HighlightingLexer",
							"binder.bind(" + Lexer.class.getName() + ".class)"+
							".annotatedWith(com.google.inject.name.Names.named(" +
							"org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING" +
							")).to(" + lexerGrammar +".class)")
					.getBindings();
			} else {
				return new BindFactory()
				.addConfiguredBinding("HighlightingLexer",
						"binder.bind(" + Lexer.class.getName() + ".class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING" +
						")).to(" + lexerGrammar +".class)")
				.getBindings();
			}
		}
		if (contentAssist) {
			if(naming.hasIde()){
				return new BindFactory()
					.addConfiguredBinding("ContentAssistLexer",
							"binder.bind(org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer.class)"+
							".annotatedWith(com.google.inject.name.Names.named(" +
							"org.eclipse.xtext.ide.LexerIdeBindings.CONTENT_ASSIST" +
							")).to(" + lexerGrammar +".class)")
					.getBindings();
			} else {
				return new BindFactory()
				.addConfiguredBinding("ContentAssistLexer",
						"binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST" +
						")).to(" + lexerGrammar +".class)")
				.getBindings();
			}
		}
		return Collections.emptySet();

	}

	public void setLexerGrammar(String lexerGrammar) {
		this.lexerGrammar = lexerGrammar;
	}

	public String getLexerGrammar() {
		return lexerGrammar;
	}

	public void setHighlighting(boolean highlighting) {
		this.highlighting = highlighting;
	}

	public boolean isHighlighting() {
		return highlighting;
	}

	public void setRuntime(boolean runtime) {
		this.runtime = runtime;
	}

	public boolean isRuntime() {
		return runtime;
	}

	public void setContentAssist(boolean contentAssist) {
		this.contentAssist = contentAssist;
	}

	public boolean isContentAssist() {
		return contentAssist;
	}
	
	/**
	 * @since 2.9
	 */
	public boolean isClassSplitting() {
		return classSplitting;
	}
	
	/**
	 * @since 2.9
	 */
	public void setClassSplitting(boolean value) {
		this.classSplitting = value;
	}
	
	/**
	 * @since 2.9
	 */
	public boolean isSpecialStateSwitchSplitting() {
		return specialStateSwitchSplitting;
	}
	
	/**
	 * @since 2.9
	 */
	public void setSpecialStateSwitchSplitting(boolean value) {
		this.specialStateSwitchSplitting = value;
	}

	/**
	 * @since 2.9
	 */
	public int getCasesPerSpecialStateSwitch(){
		return casesPerSpecialStateSwitch;
	}
	
	/**
	 * @since 2.9
	 */
	public void setCasesPerSpecialStateSwitch(final String casesPerSpecialStateSwitch){
	    int _parseInt = Integer.parseInt(casesPerSpecialStateSwitch);
	    this.casesPerSpecialStateSwitch = _parseInt;
	}
	
	private String readFileIntoString(String filename, Charset encoding) {
		try {
			String result = Files.toString(new File(filename), encoding);
			return result;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	private void writeStringIntoFile(String filename, String content, Charset encoding) {
		try {
			Files.write(content, new File(filename), encoding);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

}
