/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;

public class SyntacticPredicateFixup {
	//	ruleIdOrKeyword($ruleScenario3.p_AllowKeyword, $ruleScenario3.p_Xyz && $ruleScenario3.p_AllowKeyword);
	public static final Pattern INVALID_ARG_PATTERN = Pattern.compile("^(\\s*rule\\w+)\\(([^;]*\\$rule\\w+\\.p_\\w+[^;]*)\\);$", Pattern.MULTILINE);
	public static final Pattern SINGLE_ARG = Pattern.compile("\\$rule\\w+\\.(p_\\w+)");
	
	private final String content;
	
	public SyntacticPredicateFixup(String content) {
		this.content = content;
	}
	
	public String transform() {
		String result = content;
		int idx = 0;
		while(true) {
			Matcher m = INVALID_ARG_PATTERN.matcher(result);
			if (m.find(idx)) {
				String argumentList = m.group(2);
				idx = m.start();
				String validArguments = toValidArguments(argumentList);
				String parameterList = toParameterList(argumentList);
				result = m.replaceFirst("$1(" + validArguments + ");");
				result = insertParameter(result, parameterList, idx); 
			} else {
				return result;
			}
		}
	}
	
	private String toValidArguments(String argumentList) {
		Matcher matcher = SINGLE_ARG.matcher(argumentList);
		String result = matcher.replaceAll("$1");
		return result;
	}
	
	private String toParameterList(String argumentList) {
		Matcher matcher = SINGLE_ARG.matcher(argumentList);
		Set<String> names = Sets.newLinkedHashSet();
		while(matcher.find()) {
			names.add(matcher.group(1));
		}
		StringBuilder result = new StringBuilder("boolean ");
		Joiner.on(", boolean ").appendTo(result, names);
		return result.toString();
	}

	private String insertParameter(String result, String parameterList, int idx) {
		String argumentList = parameterList.replaceAll("\\bboolean \\b", "");
		String call;
		{
			int paramListStart = result.lastIndexOf("() throws ", idx);
			int methodNameStart = result.lastIndexOf("synpred", paramListStart);
			int paramIdx = paramListStart + 1;
			result = result.substring(0, paramIdx) + parameterList + result.substring(paramIdx);
			call = result.substring(methodNameStart, paramIdx);
			int callIdx = result.indexOf(call + ")");
			result = result.substring(0, callIdx + call.length()) + argumentList + result.substring(callIdx + call.length());
		}
		{
			call = call.substring(0, call.length() - "_fragment(".length());
			result = result.replace(call + "() {", call + "(" + parameterList + ") {");
			result = result.replace(call + "()", call + "(" + argumentList+ ")");
		}
		return result;
	}
}
