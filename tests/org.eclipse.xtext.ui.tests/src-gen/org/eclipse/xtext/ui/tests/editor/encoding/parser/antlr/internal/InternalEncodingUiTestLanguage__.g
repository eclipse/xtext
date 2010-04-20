lexer grammar InternalEncodingUiTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.editor.encoding.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g" 170
RULE_LEXEME : ('a'..'z'|'A'..'Z'|'0'..'9'|'\u2030'|'\u02C6'|'\u00B8'|'\uFB02'|'\u0192'|'\u00F7'|'\u2039')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g" 172
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g" 174
RULE_ANY_OTHER : .;


