/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.NewlineNormalizer;
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment;

import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JFlexGeneratorFragment extends AbstractGeneratorFragment {
	
	private JFlexMain main;
	
	private String patternPath;
	
	private String additionalRulePath;
	
	private boolean ui = false;
	
	@Mandatory
	public void setJFlexMain(JFlexMain main) {
		this.main = main;
	}
	
	public void setUi(boolean ui) {
		this.ui = ui;
	}
	
	/**
	 * @since 2.7
	 */
	protected String getEncoding(XpandExecutionContext xpt, String outlet) {
		return xpt.getOutput().getOutlet(outlet).getFileEncoding();
	}
	
	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		final String srcGenPath;
		final String directory;
		final String template;
		final String encoding; 
		if (!ui) {
			srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath();
			directory = srcGenPath + '/' + getNaming().asPath(getNaming().basePackageRuntime(grammar) + ".parser.antlr.internal");
			template = getTemplate() + "::generate";
			encoding = getEncoding(ctx, Generator.SRC_GEN);
		} else {
			srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN_IDE).getPath();
			directory = srcGenPath + '/' + getNaming().asPath(getNaming().basePackageIde(grammar) + ".contentassist.antlr.internal");
			template = getTemplate() + "::generateUI";
			encoding = getEncoding(ctx, Generator.SRC_GEN_IDE);
		}
		XpandFacade.create(ctx).evaluate2(template, grammar, getParameters(grammar));
		String fileName = "Internal" + GrammarUtil.getSimpleName(grammar)	+ "Flexer.flex";
		String javaFileName = directory + "/" + "Internal" + GrammarUtil.getSimpleName(grammar) + "Flexer.java";
		main.runJFlex(new String[] {
				"-d",
				directory,
				directory + "/" + fileName
		});
		Charset charset = Charset.forName(encoding);
		String javaCode = readFileIntoString(javaFileName, charset);
		javaCode = new NewlineNormalizer(getNaming().getLineDelimiter()).normalizeLineDelimiters(javaCode);
		javaCode = removeTimestamps(javaCode);
		writeStringIntoFile(javaFileName, javaCode, charset);
	}
	
	private String removeTimestamps(String javaCode) {
		int timestampEnd = javaCode.indexOf("*/");
		int commentStart = javaCode.indexOf("/*", timestampEnd);
		String result = javaCode.substring(commentStart);
		int timestampStart = result.indexOf("* on");
		timestampEnd = result.indexOf("from the specification file", timestampStart);
		result = result.substring(0, timestampStart + 2) + result.substring(timestampEnd);
		return result;
	}

	public void setPatternPath(String patternPath) {
		this.patternPath = patternPath;
	}
	
	public void setAdditionalRulePath(String rulePath) {
		this.additionalRulePath = rulePath;
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		String parserName = ui 
				? XtextAntlrUiGeneratorFragment.getGrammarFileName(grammar, getNaming())
				: XtextAntlrGeneratorFragment.getGrammarFileName(grammar, getNaming());
		return Lists.<Object>newArrayList(read(patternPath), read(additionalRulePath), parserName);
	}

	private String read(final String path) {
		if (path != null) {
			try {
				InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream(path), "ISO-8859-1");
				try {
					String patterns = CharStreams.toString(reader);
					return patterns;
				} finally {
					reader.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
	
}
