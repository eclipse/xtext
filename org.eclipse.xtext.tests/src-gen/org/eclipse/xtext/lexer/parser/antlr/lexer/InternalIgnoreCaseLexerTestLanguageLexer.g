/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
lexer grammar InternalIgnoreCaseLexerTestLanguageLexer;

@header {
package org.eclipse.xtext.lexer.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

Case : ('C'|'c')('A'|'a')('S'|'s')('E'|'e');

Foo : ('F'|'f')('O'|'o')('O'|'o');

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;
