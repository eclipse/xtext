lexer grammar InternalLexerTestLanguage;
@header {
package org.eclipse.xtext.testlanguages.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g" 185
RULE_STRING : '#' 'B'+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g" 187
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g" 189
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g" 191
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g" 193
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g" 195
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g" 197
RULE_ANY_OTHER : .;


