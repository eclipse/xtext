lexer grammar InternalLexerLanguage;
@header {
package org.eclipse.xtext.testlanguages.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 144
RULE_STRING :  '#' ('B')+ ;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 146
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 148
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 150
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 152
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 154
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 156
RULE_ANY_OTHER : .;


