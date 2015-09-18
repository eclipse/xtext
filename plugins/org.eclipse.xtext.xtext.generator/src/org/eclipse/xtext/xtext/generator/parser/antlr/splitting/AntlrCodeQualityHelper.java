/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

import static org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrCodeQualityHelper.dfaStringPattern;
import static org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrCodeQualityHelper.dfaUnpackPattern;
import static org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrCodeQualityHelper.removeDuplicateFields;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

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
	
	/**
	 * Remove all unnecessary comments from the java code that was produced by Antlr
	 */
	public void stripUnnecessaryComments(IXtextGeneratorFileSystemAccess fsa, String javaFile) {
		String content = fsa.readTextFile(javaFile).toString();
		content = stripUnnecessaryComments(content);
		fsa.generateFile(javaFile, content);
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

	protected void stripAllComments(IXtextGeneratorFileSystemAccess fsa, String javaFile) {
		String content = fsa.readTextFile(javaFile).toString();
		content = stripAllComments(content);
		fsa.generateFile(javaFile, content);
	}
	
	protected String stripAllComments(String fileContent) {
		fileContent = fileContent.replaceAll("(?m)^\\s+//.*$\\R", "");
		return fileContent;
	}
	
	/**
	 * Remove all unnecessary comments from the lexer and the parser
	 */
	public void stripUnnecessaryComments(IXtextGeneratorFileSystemAccess fsa, String lexer, String parser) {
		if (!enabled) {
			return;
		}
		stripUnnecessaryComments(fsa, lexer);
		stripUnnecessaryComments(fsa, parser);
		if (stripAllComments) {
			stripAllComments(fsa, parser);
			stripAllComments(fsa, lexer);
		}
	}

	// public static final BitSet FOLLOW_Symbol_in_synpred90_InternalMyDslParser17129 = new BitSet(new
	// long[]{0x0000000000000002L});
	// ...........................1- ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 2-
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	public static final Pattern followsetPattern = Pattern.compile(
			"\\s+public static final BitSet (FOLLOW_\\w+) = (.*);$", Pattern.MULTILINE);
	
	public static final Pattern dfaStringPattern = Pattern.compile(
			"\\s+static final String\\[?]? (DFA\\d+_\\w+) =\\s+([^;]*);$", Pattern.MULTILINE | Pattern.DOTALL);
	
	public static final Pattern dfaUnpackPattern = Pattern.compile(
			"\\s+static final (?:short|char)\\[?]?\\[?]? (DFA\\d+_\\w+) = (\\w+(\\.\\w+)?\\(dfa_\\d+s\\));$", Pattern.MULTILINE | Pattern.DOTALL);
	/**
	 * Remove duplicate bitset declarations to reduce the size of the static initializer but keep the bitsets
	 * that match the given pattern with a normalized name.
	 */
	public void removeDuplicateBitsets(IXtextGeneratorFileSystemAccess fsa, String javaFile) {
		if (!enabled) {
			return;
		}
		String content = fsa.readTextFile(javaFile).toString();
		
		CharSequence newContent = removeDuplicateFields(
				content, followsetPattern, 1, 2, "\\bFOLLOW_\\w+\\b", "FOLLOW_%d", keepBitsets, keptName);
		
		fsa.generateFile(javaFile, newContent);
	}

	/**
	 * 
	 * @param content
	 * @param lookupPattern the regular expression pattern that we try to find
	 * @param synName
	 * @param keepPattern
	 * @param keptName
	 * @return
	 */
	public static CharSequence removeDuplicateFields(CharSequence content, Pattern lookupPattern, int origNameGroup, int initGroup, String rawClientPattern, String synName, String keepPattern, String keptName) {
		Pattern fieldnamesToKeep = null;
		Set<String> doNotReplace = Sets.newHashSet();
		if (keepPattern != null) {
			fieldnamesToKeep = Pattern.compile(keepPattern);
		}
		StringBuilder newContent = new StringBuilder(content.length());
		Matcher matcher = lookupPattern.matcher(content);
		int offset = 0;
		Map<String, String> fields = Maps.newHashMap();
		Map<String, String> namesToReplace = Maps.newHashMap();
		while (matcher.find(offset)) {
			String originalFieldName = matcher.group(origNameGroup);
			String synthesizedFieldName = String.format(synName, fields.size() + 1);
			String initializer = matcher.group(initGroup);
			String existing = putIfAbsent(fields, initializer, synthesizedFieldName);
			if (existing == null) {
				existing = synthesizedFieldName;
				newContent.append(content, offset, matcher.start(origNameGroup));
				newContent.append(synthesizedFieldName);
				newContent.append(" = ");
				newContent.append(initializer);
				newContent.append(content, matcher.end(initGroup), matcher.end());
			} else {
				newContent.append(content, offset, matcher.start());
			}
			namesToReplace.put(originalFieldName, existing);
			if (fieldnamesToKeep != null) {
				Matcher keepMatcher = fieldnamesToKeep.matcher(originalFieldName);
				if (keepMatcher.matches()) {
					newContent.append(content, offset, matcher.start(origNameGroup));
					String simpleName = keptName != null ? keepMatcher.replaceFirst(keptName) : originalFieldName;
					newContent.append(simpleName);
					doNotReplace.add(simpleName);
					newContent.append(" = ");
					newContent.append(existing);
				}
			}
			offset = matcher.end();
		}
		newContent.append(content, offset, content.length());
		content = newContent.toString();
		newContent = new StringBuilder(content.length());
		Pattern clientPattern = Pattern.compile(rawClientPattern);
		Matcher clientMatcher = clientPattern.matcher(content);
		doNotReplace.addAll(fields.values());
		offset = 0;
		while (clientMatcher.find(offset)) {
			String replaceMe = clientMatcher.group();
			String replaceBy = namesToReplace.get(replaceMe);
			if (replaceBy == null) {
				replaceBy = replaceMe;
			}
			newContent.append(content, offset, clientMatcher.start());
			newContent.append(replaceBy);
			offset = clientMatcher.end();
		}
		newContent.append(content, offset, content.length());
		return newContent;
	}
	
	private static <K, V> V putIfAbsent(Map<K, V> map, K key, V value) {
        V v = map.get(key);
        if (v == null) {
            v = map.put(key, value);
        }
        return v;
    }
	
	private static final Pattern dfaPattern = Pattern.compile(
			"static final short\\[]\\[] (DFA\\d+_transition);\\s+static \\{[^{]*\\{[^}]*\\}[^}]*\\}", Pattern.DOTALL);
	
	private static final String replacement= "static final short[][] $1 = unpackEncodedStringArray($1S);";
	
	/**
	 * Remove duplicate bitset declarations to reduce the size of the static initializer but keep the bitsets
	 * that match the given pattern with a normalized name.
	 */
	public void removeDuplicateDFAs(IXtextGeneratorFileSystemAccess fsa, String javaFile) {
		if (!enabled) {
			return;
		}
		String content = fsa.readTextFile(javaFile).toString();
		CharSequence newContent = dfaPattern.matcher(content).replaceAll(replacement);
		newContent = removeDuplicateFields(
				newContent, dfaStringPattern, 1, 2, "\\bDFA\\d+_\\w+\\b", "dfa_%ds", null, null);
		newContent = removeDuplicateFields(
				newContent, dfaUnpackPattern, 1, 2, "\\bDFA\\d+_\\w+\\b", "dfa_%d", null, null);
		fsa.generateFile(javaFile, newContent);
	}
	
}
