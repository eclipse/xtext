lexer grammar InternalBug292245TestLanguage;
@header {
package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T7 : 'FIX' ;
T8 : 'ERROR' ;
T9 : 'TICK' ;
T10 : '^' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g" 434
RULE_APOSTROPHE_CHAR : '\'';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g" 436
RULE_CHAR : ('A'..'Z'|'0'..'9');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g" 438
RULE_WS : (' '|'\t'|'\r'|'\n')+;


