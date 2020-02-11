/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TokenTool {
	/**
	 * @param t the token
	 * @return the parsed text or <code>null</code> if the {@link Token} t was <code>null</code> or the token's text was <code>null</code>.
	 */
	public static String getText(Token t) {
		return t!=null ? t.getText() : null;
	}
	
	/**
	 * @param t the token
	 * @return the line of the token or <code>-1</code> if the {@link Token} t was <code>null</code> or the token did not provide line information.
	 */
	public static int getLine(Token t) {
		return  t!=null ? t.getLine() : -1;
	}
	
	/**
	 * @param t the token
	 * @return the offset of the token or <code>-1</code> if the {@link Token} t was <code>null</code> or the token did not provide offset information.
	 */
	public static int getOffset(Token t) {
		if (t instanceof CommonToken) {
			return ((CommonToken)t).getStartIndex();
		}
		return -1;
	}
	
	/**
	 * @param t the token
	 * @return the length of the token or <code>0</code> if the {@link Token} t was <code>null</code> or the token did not provide line information.
	 */
	public static int getLength(Token t) {
		String text = getText(t);
		return text!=null ? text.length() : 0;
	}
	
	public static final String LEXER_RULE_PREFIX = "RULE_";
	
	private static final Pattern superRulePattern = Pattern.compile("^(SUPER_(\\d+_)?).*$");
	
	public static boolean isLexerRule(String antlrTokenDef) {
		return antlrTokenDef.startsWith(LEXER_RULE_PREFIX);
	}
	
	public static String getLexerRuleName(String antlrTokenDef) {
		if (antlrTokenDef.startsWith(LEXER_RULE_PREFIX))
			return antlrTokenDef.substring(LEXER_RULE_PREFIX.length());
		Matcher matcher = superRulePattern.matcher(antlrTokenDef);
		if (matcher.matches()) {
			return antlrTokenDef.substring(matcher.group(1).length());
		}
		return antlrTokenDef;
	}

}
