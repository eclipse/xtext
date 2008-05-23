/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.parser.ITokenTypes;

/**
 * 
 * @author koehnlein
 *
 */
public class BuiltinRules {

	public static final LexerRule BUILTIN_ID;
	public static final LexerRule BUILTIN_INT;
	public static final LexerRule BUILTIN_LEXER_BODY;
	public static final LexerRule BUILTIN_STRING;
	public static final LexerRule BUILTIN_ML_COMMENT;
	public static final LexerRule BUILTIN_SL_COMMENT;
	public static final LexerRule BUILTIN_WS;
	public static final LexerRule BUILTIN_ANY_OTHER;

	public static final List<LexerRule> BUILTIN_LEXER_RULES;

	private static final String BS = "\\";
	private static final String BS2 = BS + BS;
	private static final String DQ = "\"";
	
	static {
		BUILTIN_ID = XtextFactory.eINSTANCE.createLexerRule();
		BUILTIN_ID.setName("ID");
		BUILTIN_ID.setTokenType(ITokenTypes.IDENTIFIER);
		BUILTIN_ID
				.setBody("('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*");
		BUILTIN_INT = XtextFactory.eINSTANCE.createLexerRule();
		BUILTIN_INT.setName("INT");
		BUILTIN_INT.setTokenType(ITokenTypes.INTEGER);
		BUILTIN_INT.setBody("('0'..'9')+");
		BUILTIN_LEXER_BODY = XtextFactory.eINSTANCE.createLexerRule();
		BUILTIN_LEXER_BODY.setName("LEXER_BODY");
		BUILTIN_LEXER_BODY.setTokenType(ITokenTypes.STRINGLITERAL);
		BUILTIN_LEXER_BODY
				.setBody("'<#' ( options {greedy=false;} : . )* '#>'");
		BUILTIN_STRING = XtextFactory.eINSTANCE.createLexerRule();
		BUILTIN_STRING.setName("STRING");
		BUILTIN_STRING.setTokenType(ITokenTypes.STRINGLITERAL);
		BUILTIN_STRING.setBody("'" + DQ + "' ( '" + BS2
				+ "' ('b'|'t'|'n'|'f'|'r'|'" + BS + "" + DQ + "'|'" + BS
				+ "''|'" + BS2 + "') | ~('" + BS2 + "'|'" + DQ + "') )* '" + DQ
				+ "' | '" + BS + "'' ( '" + BS2 + "' ('b'|'t'|'n'|'f'|'r'|'"
				+ BS + "" + DQ + "'|'" + BS + "''|'" + BS2 + "') | ~('" + BS2
				+ "'|'" + BS + "'') )* '" + BS + "''");
		BUILTIN_ML_COMMENT = XtextFactory.eINSTANCE.createLexerRule();
		BUILTIN_ML_COMMENT.setName("ML_COMMENT");
		BUILTIN_ML_COMMENT.setTokenType(ITokenTypes.COMMENT);
		BUILTIN_ML_COMMENT
				.setBody("'/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}");
		BUILTIN_SL_COMMENT = XtextFactory.eINSTANCE.createLexerRule();
		BUILTIN_SL_COMMENT.setName("SL_COMMENT");
		BUILTIN_SL_COMMENT.setTokenType(ITokenTypes.COMMENT);
		BUILTIN_SL_COMMENT.setBody("'//' ~('" + BS + "n'|'" + BS + "r')* '"
				+ BS + "r'? '" + BS + "n' {$channel=HIDDEN;}");
		BUILTIN_WS = XtextFactory.eINSTANCE.createLexerRule();
		BUILTIN_WS.setName("WS");
		BUILTIN_WS.setTokenType(ITokenTypes.WHITESPACE);
		BUILTIN_WS.setBody("(' '|'" + BS + "t'|'" + BS + "r'|'" + BS
				+ "n')+ {$channel=HIDDEN;}");

		BUILTIN_ANY_OTHER = XtextFactory.eINSTANCE.createLexerRule();
		BUILTIN_ANY_OTHER.setName("ANY_OTHER");
		BUILTIN_ANY_OTHER.setTokenType(ITokenTypes.ANYOTHER);
		BUILTIN_ANY_OTHER.setBody(".");

		BUILTIN_LEXER_RULES = Collections.unmodifiableList(Arrays
				.asList(new LexerRule[] { BUILTIN_ID, BUILTIN_INT,
						BUILTIN_STRING, BUILTIN_LEXER_BODY, BUILTIN_ML_COMMENT,
						BUILTIN_SL_COMMENT, BUILTIN_WS, BUILTIN_ANY_OTHER }));
	}

	public static List<LexerRule> getBuiltinLexerRules() {
		return BUILTIN_LEXER_RULES;
	}

	public static LexerRule BuiltinAnyOther() {
		return BUILTIN_ANY_OTHER;
	}
}
