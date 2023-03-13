/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.LineSeparatorHarmonizer;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.parser.antlr.ContentAssistGrammarNaming;
import org.eclipse.xtext.xtext.generator.parser.antlr.GrammarNaming;

import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Christian Dietrich - Port to new Generator infrastructure
 */
public class JFlexGeneratorFragment2 extends AbstractXtextGeneratorFragment {

	private JFlexMain main;

	private String patternPath;

	private String additionalRulePath;

	private boolean ui = false;

	@Mandatory
	public void setJFlexMain(JFlexMain main) {
		this.main = main;
	}

	@Inject
	JFlexGeneratorFragmentTemplate templatex = new JFlexGeneratorFragmentTemplate();

	@Inject
	GrammarNaming productionNaming;
	@Inject
	ContentAssistGrammarNaming contentAssistNaming;

	//	@Mandatory
	//	public void setJFlexMain(JFlexGeneratorFragmentTemplate main) {
	//		this.templatex = main;
	//	}

	@Inject
	CodeConfig codeConfig;

	public void setUi(boolean ui) {
		this.ui = ui;
	}

	@Override
	public void generate() {
		Grammar grammar = getGrammar();
		String macros = read(patternPath);
		String rules = read(additionalRulePath);
		final String encoding = codeConfig.getEncoding();
		String fileName = "Internal" + GrammarUtil.getSimpleName(grammar) + "Flexer.flex";
		
		final IXtextGeneratorFileSystemAccess fsa;
		final GrammarNaming grammarNaming;
		
		if (ui) {
			grammarNaming = contentAssistNaming;
			fsa = this.getProjectConfig().getGenericIde().getSrcGen();
			
		} else {
			grammarNaming = productionNaming;
			fsa = this.getProjectConfig().getRuntime().getSrcGen();
		}
		
		String srcGenPath = fsa.getPath();
		String parserName = grammarNaming.getInternalParserClass(grammar).getName();
		String baseName = grammarNaming.getParserGrammar(grammar).getGrammarFileName();
		baseName = baseName.substring(0, baseName.lastIndexOf('/'));
		String directory = srcGenPath + "/" + baseName;
		String contents = templatex.generateFlexer(grammar, parserName, macros, rules, codeConfig);
		fsa.generateFile(baseName + "/" + fileName, contents);
		String javaFileName = directory + "/" + "Internal" + GrammarUtil.getSimpleName(grammar) + "Flexer.java";
		String[] args = new String[] { "-d", directory, directory + "/" + fileName };
		main.runJFlex(args);
		Charset charset = Charset.forName(encoding);
		String javaCode = readFileIntoString(javaFileName, charset);
		javaCode = new NewlineNormalizer(codeConfig.getLineDelimiter()).normalizeLineDelimiters(javaCode);
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

	private String readFileIntoString(String filename, Charset encoding) {
		try {
			String result = Files.asCharSource(new File(filename), encoding).read();
			return result;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	private void writeStringIntoFile(String filename, String content, Charset encoding) {
		try {
			Files.asCharSink(new File(filename), encoding).write(content);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public static class NewlineNormalizer extends LineSeparatorHarmonizer {

		private final String lineDelimiterToUse;

		public NewlineNormalizer(String lineDelimiterToUse) {
			this.lineDelimiterToUse = lineDelimiterToUse;
		}

		/**
		 * Converts the given content into a {@link CharSequence} that uses only the configured {@link #lineDelimiterToUse}
		 */
		public String normalizeLineDelimiters(CharSequence content) {
			return replaceLineSeparators(content, lineDelimiterToUse);
		}

	}

}
