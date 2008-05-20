lexer grammar InternalTestLanguage;
@header {
package org.eclipse.xtext.test.parser.internal;
}

T12 : 'choice' ;
T13 : 'optional' ;
T14 : 'reducible' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g" 194
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g" 196
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g" 198
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g" 200
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g" 202
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g" 204
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g" 206
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g" 209
RULE_ANY_OTHER : .;


