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
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.Files;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public class AntlrCodeQualityHelper {

	private String keepBitsets;
	private String keptName;
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
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// public static final BitSet FOLLOW_Symbol_in_synpred90_InternalMyDslParser17129 = new BitSet(new
	// long[]{0x0000000000000002L});
	// ...........................1- ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 2-
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	private static final Pattern bitsetPattern = Pattern.compile(
			"^\\s+public static final BitSet (FOLLOW_\\w+) = (.*);$", Pattern.MULTILINE);

	
	/**
	 * Remove duplicate bitset declarations to reduce the size of the static initializer but keep the bitsets
	 * that match the given pattern with a normalized name.
	 */
	public void removeDuplicateBitsets(String javaFile, Charset encoding) {
		if (!enabled) {
			return;
		}
		try {
			Pattern bitsetsToKeep = null;
			Set<String> doNotReplace = Sets.newHashSet();
			if (keepBitsets != null) {
				bitsetsToKeep = Pattern.compile(keepBitsets);
			}
			String content = Files.toString(new File(javaFile), encoding);
			StringBuilder newContent = new StringBuilder(content.length());
			Matcher matcher = bitsetPattern.matcher(content);
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
					newContent.append(content, offset, matcher.start(1));
					newContent.append(synthesizedFieldName);
					newContent.append(" = ");
					newContent.append(bitset);
				}
				namesToReplace.put(originalFieldName, existing);
				if (bitsetsToKeep != null) {
					Matcher keepMatcher = bitsetsToKeep.matcher(originalFieldName);
					if (keepMatcher.matches()) {
						newContent.append(content, offset, matcher.start(1));
						String simpleName = keptName != null ? keepMatcher.replaceFirst(keptName) : originalFieldName;
						newContent.append(simpleName);
						doNotReplace.add(simpleName);
						newContent.append(" = ");
						newContent.append(existing);
					}
				}
				offset = matcher.end(2);
			}
			newContent.append(content, offset, content.length());
			content = newContent.toString();
			newContent = new StringBuilder(content.length());
			String rawFollowPattern = "\\bFOLLOW_\\w+\\b";
			Pattern followPattern = Pattern.compile(rawFollowPattern);
			Matcher followMatcher = followPattern.matcher(content);
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
				newContent.append(content, offset, followMatcher.start());
				newContent.append(replaceBy);
				offset = followMatcher.end();
			}
			newContent.append(content, offset, content.length());
			Files.write(newContent, new File(javaFile), encoding);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private <K, V> V putIfAbsent(Map<K, V> map, K key, V value) {
        V v = map.get(key);
        if (v == null) {
            v = map.put(key, value);
        }
        return v;
    }
}
