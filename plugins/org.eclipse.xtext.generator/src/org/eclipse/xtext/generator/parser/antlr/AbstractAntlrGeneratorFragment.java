/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.postProcessing.SuppressWarningsProcessor;
import org.eclipse.xtext.generator.parser.antlr.splitting.AntlrLexerSplitter;
import org.eclipse.xtext.generator.parser.antlr.splitting.AntlrParserSplitter;
import org.eclipse.xtext.generator.parser.antlr.splitting.UnorderedGroupsSplitter;
import org.eclipse.xtext.generator.parser.packrat.PackratParserFragment;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractAntlrGeneratorFragment extends AbstractGeneratorFragment {
	
	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (!antlrTool.isWorkable()) {
			issues.addError("\n\n*ATTENTION*\nIt is highly recommended to use ANTLR's parser generator (get it from 'http://xtext.itemis.com/'). \nAs an alternative to ANTLR you could also use the alternative implementation shipped with Xtext.\nTo do so use the generator fragment '"+PackratParserFragment.class.getName()+"' in your mwe2 file instead.");
		}
	}
	
	private AntlrToolFacade antlrTool = new AntlrToolFacade();
	
	public void setAntlrTool(AntlrToolFacade facade) {
		this.antlrTool = facade;
	}
	
	public AntlrToolFacade getAntlrTool() {
		return antlrTool;
	}

	private AntlrOptions options = new AntlrOptions();

	public void setOptions(AntlrOptions options) {
		this.options = options;
	}
	
	public AntlrOptions getOptions() {
		return options;
	}
	
	private List<String> antlrParams = Lists.newArrayList();
	
	public void addAntlrParam(String param) {
		antlrParams.add(param);
	}
	
	public String[] getAntlrParams() {
		String[] result = antlrParams.toArray(new String[antlrParams.size()]);
		return result;
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.singletonList((Object)options);
	}
	
	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		AbstractRule firstRule = grammar.getRules().get(0);
		if (!(firstRule instanceof ParserRule) || GrammarUtil.isDatatypeRule((ParserRule) firstRule))
			throw new IllegalArgumentException("You may not generate an ANTLR parser for a grammar without production rules.");
		super.generate(grammar, ctx);
	}
	
	protected String readFileIntoString(String filename) throws IOException {
		FileInputStream inputStream = new FileInputStream(filename);
		try {
			byte[] buffer = new byte[2048];
			int bytesRead = 0;
			StringBuffer b = new StringBuffer();
			do {
				bytesRead = inputStream.read(buffer);
				if (bytesRead != -1)
					b.append(new String(buffer, 0, bytesRead));
			} while (bytesRead != -1);
			return b.toString();
		} finally {
			inputStream.close();
		}
	}
	
	protected void writeStringIntoFile(String filename, String content) throws IOException {
		FileWriter writer = new FileWriter(filename);
		try {
			writer.append(content);
		} finally {
			writer.close();
		}
	}
	
	protected void splitLexerClassFile(String filename) throws IOException {
		String content = readFileIntoString(filename);
		AntlrLexerSplitter splitter = new AntlrLexerSplitter(content);
		writeStringIntoFile(filename, splitter.transform());
	}

	protected void splitParserClassFile(String filename) throws IOException {
		String content = readFileIntoString(filename);
		AntlrParserSplitter splitter = new AntlrParserSplitter(content);
		writeStringIntoFile(filename, splitter.transform());
	}
	
	protected void simplifyUnorderedGroupPredicatesIfRequired(Grammar grammar, String absoluteParserFileName) {
		try {
			if (containsUnorderedGroup(grammar)) {
				String javaFile = absoluteParserFileName.replaceAll("\\.g$", "Parser.java");
				simplifyUnorderedGroupPredicates(javaFile);
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void simplifyUnorderedGroupPredicates(String javaFile) throws IOException {
		String content = readFileIntoString(javaFile);
		UnorderedGroupsSplitter splitter = new UnorderedGroupsSplitter(content);
		writeStringIntoFile(javaFile, splitter.transform());
	}
	
	private void suppressWarningsImpl(String javaFile) throws IOException {
		String content = readFileIntoString(javaFile);
		content = new SuppressWarningsProcessor().process(content);
		writeStringIntoFile(javaFile, content);
	}
	
	protected void suppressWarnings(String grammarFileName) {
		suppressWarnings(grammarFileName, grammarFileName);
	}
	
	protected void suppressWarnings(String absoluteLexerGrammarFileName,
			String absoluteParserGrammarFileName) {
		try {
			suppressWarningsImpl(absoluteLexerGrammarFileName.replaceAll("\\.g$", "Lexer.java"));
			suppressWarningsImpl(absoluteParserGrammarFileName.replaceAll("\\.g$", "Parser.java"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void splitParserAndLexerIfEnabled(String absoluteLexerGrammarFileName,
			String absoluteParserGrammarFileName) {
		
		if(getOptions().isClassSplitting()) {
			try {
				splitLexerClassFile(absoluteLexerGrammarFileName.replaceAll("\\.g$", "Lexer.java"));
				splitParserClassFile(absoluteParserGrammarFileName.replaceAll("\\.g$", "Parser.java"));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	protected void splitParserAndLexerIfEnabled(String absoluteGrammarFileName) {
		splitParserAndLexerIfEnabled(absoluteGrammarFileName, absoluteGrammarFileName);
	}
	
	protected boolean containsUnorderedGroup(Grammar grammar) {
		for(ParserRule rule: GrammarUtil.allParserRules(grammar)) {
			if (Iterators.filter(rule.eAllContents(), UnorderedGroup.class).hasNext()) {
				return true;
			}
		}
		return false;
	}

}