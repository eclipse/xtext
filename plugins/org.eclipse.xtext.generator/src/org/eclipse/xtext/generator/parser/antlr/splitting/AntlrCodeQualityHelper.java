/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.splitting;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

import com.google.common.io.Files;
import static org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrCodeQualityHelper.*;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public class AntlrCodeQualityHelper {

	private String keepBitsets;
	private String keptName;
	private boolean stripAllComments = false;
	private boolean enabled = true;
	
	/**
	 * Optionally set a pattern for bitset names that should not be replaced by a simple variant.
	 */
	public void setKeepBitsets(String keepBitsets) {
		this.keepBitsets = keepBitsets;
	}
	
	/**
	 * Optionally set a replacement string for the kept bitset names.
	 */
	public void setKeptName(String keptName) {
		this.keptName = keptName;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void setStripAllComments(boolean stripAllComments) {
		this.stripAllComments = stripAllComments;
	}
	
	public boolean isStripAllComments() {
		return stripAllComments;
	}
	
	/**
	 * Remove all unnecessary comments from the java code that was produced by Antlr
	 */
	public void stripUnnecessaryComments(String javaFile, Charset encoding) throws IOException {
		String content = Files.toString(new File(javaFile), encoding);
		content = stripUnnecessaryComments(content);
		Files.write(content, new File(javaFile), encoding);
	}

	protected String stripUnnecessaryComments(String fileContent) {
		fileContent = fileContent.replaceAll(
				"(?m)^(\\s+)// .*/(\\w+\\.g:.*)$",
				"$1// $2");
		fileContent = fileContent.replaceAll(
				"(public String getGrammarFileName\\(\\) \\{ return \").*/(\\w+\\.g)(\"; \\})",
				"$1$2$3");
		return fileContent;
	}
	
	protected void stripAllComments(String javaFile, Charset encoding) throws IOException {
		String content = Files.toString(new File(javaFile), encoding);
		String newContent = stripAllComments(content);
		Files.write(newContent, new File(javaFile), encoding);
	}
	
	protected String stripAllComments(String fileContent) {
		fileContent = fileContent.replaceAll("(?m)^\\s+//.*$\\n\\r?", "");
		return fileContent;
	}

	/**
	 * Remove all unnecessary comments from the lexer and the parser
	 */
	public void stripUnnecessaryComments(String lexer, String parser, Charset encoding) {
		if (!enabled) {
			return;
		}
		try {
			stripUnnecessaryComments(lexer, encoding);
			stripUnnecessaryComments(parser, encoding);
			if (stripAllComments) {
				stripAllComments(parser, encoding);
				stripAllComments(lexer, encoding);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Remove duplicate bitset declarations to reduce the size of the static initializer but keep the bitsets
	 * that match the given pattern with a normalized name.
	 */
	public void removeDuplicateBitsets(String javaFile, Charset encoding) {
		if (!enabled) {
			return;
		}
		try {
			String content = Files.toString(new File(javaFile), encoding);
			CharSequence newContent = removeDuplicateFields(
					content, followsetPattern, 1, 2, "\\bFOLLOW_\\w+\\b", "FOLLOW_%d", keepBitsets, keptName);
			Files.write(newContent, new File(javaFile), encoding);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static final Pattern dfaPattern = Pattern.compile(
			"static final short\\[]\\[] (DFA\\d+_transition);\\s+static \\{[^{]*\\{[^}]*\\}[^}]*\\}", Pattern.DOTALL);
	
	private static final String replacement= "static final short[][] $1 = unpackEncodedStringArray($1S);";
	
	/**
	 * Remove duplicate bitset declarations to reduce the size of the static initializer but keep the bitsets
	 * that match the given pattern with a normalized name.
	 */
	public void removeDuplicateDFAs(String javaFile, Charset encoding) {
		if (!enabled) {
			return;
		}
		try {
			String content = Files.toString(new File(javaFile), encoding);
			CharSequence newContent = dfaPattern.matcher(content).replaceAll(replacement);
			newContent = removeDuplicateFields(
					newContent, dfaStringPattern, 1, 2, "\\bDFA\\d+_\\w+\\b", "dfa_%ds", null, null);
			newContent = removeDuplicateFields(
					newContent, dfaUnpackPattern, 1, 2, "\\bDFA\\d+_\\w+\\b", "dfa_%d", null, null);
			
			Files.write(newContent, new File(javaFile), encoding);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
