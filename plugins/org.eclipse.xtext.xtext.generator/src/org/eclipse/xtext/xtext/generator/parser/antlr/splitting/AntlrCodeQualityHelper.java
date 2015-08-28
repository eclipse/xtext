/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	/**
	 * Remove all unnecessary comments from the java code that was produced by Antlr
	 */
	public String stripUnnecessaryComments(String javaFileContent, AntlrOptions options) {
		if (!options.isOptimizeCodeQuality())
			return javaFileContent;
		javaFileContent = javaFileContent.replaceAll(
				"(?m)^(\\s+)// .*/(\\w+\\.g:.*)$",
				"$1// $2");
		javaFileContent = javaFileContent.replaceAll(
				"(public String getGrammarFileName\\(\\) \\{ return \").*/(\\w+\\.g)(\"; \\})",
				"$1$2$3");
		return javaFileContent;
	}

	// public static final BitSet FOLLOW_Symbol_in_synpred90_InternalMyDslParser17129 = new BitSet(new
	// long[]{0x0000000000000002L});
	// ...........................1- ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 2-
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	private static final Pattern bitsetPattern = Pattern.compile("^\\s+public static final BitSet (FOLLOW_\\w+) = (.*);$", Pattern.MULTILINE);

	
	/**
	 * Remove duplicate bitset declarations to reduce the size of the static initializer but keep the bitsets
	 * that match the given pattern with a normalized name.
	 */
	public String removeDuplicateBitsets(String javaFileContent, AntlrOptions options) {
		if (!options.isOptimizeCodeQuality()) {
			return javaFileContent;
		}
		Pattern bitsetsToKeep = null;
		Set<String> doNotReplace = Sets.newHashSet();
		if (options.getKeptBitSetsPattern() != null) {
			bitsetsToKeep = Pattern.compile(options.getKeptBitSetsPattern());
		}
		StringBuilder newContent = new StringBuilder(javaFileContent.length());
		Matcher matcher = bitsetPattern.matcher(javaFileContent);
		int offset = 0;
		Map<String, String> bitsets = Maps.newHashMap();
		Map<String, String> namesToReplace = Maps.newHashMap();
		while (matcher.find(offset)) {
			String originalFieldName = matcher.group(1);
			String synthesizedFieldName = "FOLLOW_" + (bitsets.size() + 1);
			String bitset = matcher.group(2);
			String existing = putIfAbsent(bitsets, bitset, synthesizedFieldName);
			if (existing == null) {
				existing = synthesizedFieldName;
				newContent.append(javaFileContent, offset, matcher.start(1));
				newContent.append(synthesizedFieldName);
				newContent.append(" = ");
				newContent.append(bitset);
			}
			namesToReplace.put(originalFieldName, existing);
			if (bitsetsToKeep != null) {
				Matcher keepMatcher = bitsetsToKeep.matcher(originalFieldName);
				if (keepMatcher.matches()) {
					newContent.append(javaFileContent, offset, matcher.start(1));
					String simpleName = options.getKeptBitSetName() != null ? keepMatcher.replaceFirst(options.getKeptBitSetName()) : originalFieldName;
					newContent.append(simpleName);
					doNotReplace.add(simpleName);
					newContent.append(" = ");
					newContent.append(existing);
				}
			}
			offset = matcher.end(2);
		}
		newContent.append(javaFileContent, offset, javaFileContent.length());
		javaFileContent = newContent.toString();
		newContent = new StringBuilder(javaFileContent.length());
		String rawFollowPattern = "\\bFOLLOW_\\w+\\b";
		Pattern followPattern = Pattern.compile(rawFollowPattern);
		Matcher followMatcher = followPattern.matcher(javaFileContent);
		doNotReplace.addAll(bitsets.values());
		offset = 0;
		while (followMatcher.find(offset)) {
			String replaceMe = followMatcher.group();
			String replaceBy = namesToReplace.get(replaceMe);
			if (replaceBy == null) {
				if (!doNotReplace.contains(replaceMe))
					throw new IllegalStateException(replaceMe);
				replaceBy = replaceMe;
			}
			newContent.append(javaFileContent, offset, followMatcher.start());
			newContent.append(replaceBy);
			offset = followMatcher.end();
		}
		newContent.append(javaFileContent, offset, javaFileContent.length());
		return newContent.toString();
	}
	
	private <K, V> V putIfAbsent(Map<K, V> map, K key, V value) {
        V v = map.get(key);
        if (v == null) {
            v = map.put(key, value);
        }
        return v;
    }
}
