lexer grammar InternalLexerLanguage;
@header {
package org.eclipse.xtext.testlanguages.parser.internal;
}

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 263
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 265
RULE_IMPLICITTOKENTYPE :  '#' ('C')+ ;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 267
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 269
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 271
RULE_EXPLICITTOKENTYPE :  '#' ('A')+ ;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 273
RULE_STRING :  '#' ('B')+ ;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 275
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 277
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 279
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 281
RULE_ANY_OTHER : .;


