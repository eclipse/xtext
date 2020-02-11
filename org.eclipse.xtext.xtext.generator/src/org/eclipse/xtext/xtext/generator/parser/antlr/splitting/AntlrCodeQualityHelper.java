/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class AntlrCodeQualityHelper {

	protected String stripMachineDependentPaths(String fileContent) {
		fileContent = fileContent.replaceAll(
				"(?m)^(\\s*)// .*/(\\w+\\.g:.*)$",
				"$1// $2");
		fileContent = fileContent.replaceAll(
				"(public String getGrammarFileName\\(\\) \\{ return \").*(/|\\\\)(\\w+\\.g)(\"; \\})",
				"$1$3$4");
		return fileContent;
	}

	protected String stripAllComments(String fileContent) {
		fileContent = fileContent.replaceAll("(?m)^\\s*//.*$\\r?\\n", "");
		return fileContent;
	}

	/**
	 * Remove all unnecessary comments from a lexer or parser file
	 */
	public String stripUnnecessaryComments(String javaContent, AntlrOptions options) {
		if (!options.isOptimizeCodeQuality()) {
			return javaContent;
		}
		javaContent = stripMachineDependentPaths(javaContent);
		if (options.isStripAllComments()) {
			javaContent = stripAllComments(javaContent);
		}
		return javaContent;
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
	public String removeDuplicateBitsets(String javaContent, AntlrOptions options) {
		if (!options.isOptimizeCodeQuality()) {
			return javaContent;
		}

		return removeDuplicateFields(javaContent, followsetPattern, 1, 2, "\\bFOLLOW_\\w+\\b", "FOLLOW_%d", options.getKeptBitSetsPattern(), options.getKeptBitSetName());
	}

	/**
	 * @param lookupPattern the regular expression pattern that we try to find
	 */
	public static String removeDuplicateFields(String content, Pattern lookupPattern, int origNameGroup, int initGroup, String rawClientPattern, String synName, String keepPattern, String keptName) {
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
					newContent.append(";");
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
		return newContent.toString();
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
	public String removeDuplicateDFAs(String content, AntlrOptions options) {
		if (!options.isOptimizeCodeQuality()) {
			return content;
		}
		String newContent = dfaPattern.matcher(content).replaceAll(replacement);
		newContent = removeDuplicateFields(
				newContent, dfaStringPattern, 1, 2, "\\bDFA\\d+_\\w+\\b", "dfa_%ds", null, null);
		newContent = removeDuplicateFields(
				newContent, dfaUnpackPattern, 1, 2, "\\bDFA\\d+_\\w+\\b", "dfa_%d", null, null);
		return newContent;
	}

}
