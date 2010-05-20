/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.parser.antlr.AntlrToolFacade;
import org.eclipse.xtext.parser.antlr.Lexer;

import com.google.common.collect.Lists;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExternalAntlrLexerFragment extends DefaultGeneratorFragment {

	private String lexerGrammar;
	
	private boolean highlighting;
	
	private boolean runtime;
	
	private boolean contentAssist;
	
	private List<String> antlrParams = Lists.newArrayList();
	
	public void addAntlrParam(String param) {
		antlrParams.add(param);
	}
	
	public String[] getAntlrParams() {
		String[] result = antlrParams.toArray(new String[antlrParams.size()]);
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
			srcGen = Generator.SRC_GEN_UI;
			src = Generator.SRC_UI;
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
		getAntlrTool().runWithParams(grammarFile, getAntlrParams());
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
						")).to(" + lexerGrammar +"Lexer.class)")
				.getBindings();
		return Collections.emptySet();
	}
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if (highlighting)
			return new BindFactory()
				.addConfiguredBinding("HighlightingLexer", 
						"binder.bind(" + Lexer.class.getName() + ".class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING" +
						")).to(" + lexerGrammar +"Lexer.class)")
				.getBindings();
		if (contentAssist)
			return new BindFactory()
				.addConfiguredBinding("ContentAssistLexer", 
						"binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class)"+
						".annotatedWith(com.google.inject.name.Names.named(" +
						"org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST" +
						")).to(" + lexerGrammar +"Lexer.class)")
				.getBindings();
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
	
}
