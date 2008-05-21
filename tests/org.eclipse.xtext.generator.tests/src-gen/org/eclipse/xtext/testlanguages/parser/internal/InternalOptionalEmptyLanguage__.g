lexer grammar InternalOptionalEmptyLanguage;
@header {
package org.eclipse.xtext.testlanguages.parser.internal;
}

T12 : 'hallo' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g" 148
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g" 150
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g" 152
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g" 154
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g" 156
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g" 158
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g" 160
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g" 162
RULE_ANY_OTHER : .;


