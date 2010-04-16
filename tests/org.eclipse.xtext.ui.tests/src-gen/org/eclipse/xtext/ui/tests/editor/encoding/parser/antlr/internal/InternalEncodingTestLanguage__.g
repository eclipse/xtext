lexer grammar InternalEncodingTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.editor.encoding.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g" 123
RULE_WORD : ('a'..'z'|'A'..'Z'|'0'..'9'|'\u00E4'|'\u00F6'|'\u00FC'|'\u00DF'|'\u00C4'|'\u00D6'|'\u00DC')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g" 125
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g" 127
RULE_ANY_OTHER : .;


