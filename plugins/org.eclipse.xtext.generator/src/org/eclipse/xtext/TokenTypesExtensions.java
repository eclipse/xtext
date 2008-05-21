/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.WrappedException;

/**
 * 
 * @author koehnlein
 */
public class TokenTypesExtensions {
	
	private static Map<Object,String> tokenTypeMap;

	public static String getAntlrTokenName(Object antlrTokenId) {
		return tokenTypeMap.get(antlrTokenId);
	}
	
	public static Set<Object> getAntlrTokenTypes() {
		return tokenTypeMap.keySet();
	}
	
	public static Map<Object, String> loadTokenTypeNames(String srcGen, String languageNamespace, String languageName) {
		try {
			tokenTypeMap = new HashMap<Object, String>();
			File file = new File(srcGen + "/" + languageNamespace + "/parser/internal/Internal" + languageName + ".tokens");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			Pattern pattern = Pattern.compile("(.*)=(\\d+)");
			while (line != null) {
				Matcher m = pattern.matcher(line);
				if (!m.matches()) {
					throw new IllegalStateException("Couldn't match line : '" + line + "'");
				}
				
				String tokenTypeId = m.group(2);
				String token = m.group(1);
				tokenTypeMap.put(Integer.parseInt(tokenTypeId), token);
				line = br.readLine();
			}
			return tokenTypeMap;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
	
	private static String char2Identifier(char x) {
		switch (x) {
		case '+':
			return "Plus";
		case '-':
			return "Minus";
		case '*':
			return "Asterisk";
		case '/':
			return "Slash";
		case '(':
			return "OpeningParenthesis";
		case ')':
			return "ClosingParenthesis";
		case '[':
			return "OpeningSquareBracket";
		case ']':
			return "ClosingSquareBracket";
		case '{':
			return "OpeningCurlyBracket";
		case '}':
			return "ClosingCurlyBracket";
		case '=':
			return "Equals";
		case '!':
			return "ExplanationMark";
		case '?':
			return "QuestionMark";
		case ':':
			return "Colon";
		case ';':
			return "SemiColon";
		case '.':
			return "Dot";
		case ',':
			return "Comma";
		case '|':
			return "Bar";
		case '\\':
			return "BackSlash";
		case '\'':
			return "SingleQuote";
		case '"':
			return "DoubleQuote";
		default:
			return "_" + (int) x;
		}
	}
}
