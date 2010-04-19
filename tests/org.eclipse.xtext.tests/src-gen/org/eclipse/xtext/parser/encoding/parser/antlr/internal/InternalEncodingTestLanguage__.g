lexer grammar InternalEncodingTestLanguage;
@header {
package org.eclipse.xtext.parser.encoding.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g" 170
RULE_LEXEME : ('a'..'z'|'A'..'Z'|'0'..'9'|'\u00E4'|'\u00F6'|'\u00FC'|'\u00DF'|'\u00C4'|'\u00D6'|'\u00DC')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g" 172
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g" 174
RULE_ANY_OTHER : .;


