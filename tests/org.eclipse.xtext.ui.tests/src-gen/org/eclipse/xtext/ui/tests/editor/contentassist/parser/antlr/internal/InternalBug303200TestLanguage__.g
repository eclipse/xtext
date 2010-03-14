lexer grammar InternalBug303200TestLanguage;
@header {
package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T7 : 'function' ;
T8 : '[' ;
T9 : ']' ;
T10 : '(' ;
T11 : ',' ;
T12 : ')' ;
T13 : '{' ;
T14 : '}' ;
T15 : ';' ;
T16 : '.' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug303200TestLanguage.g" 1170
RULE_ID : ('a'..'z'|'A'..'Z')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug303200TestLanguage.g" 1172
RULE_WS : (' '|'\t')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug303200TestLanguage.g" 1174
RULE_LT : ('\r'|'\n');


