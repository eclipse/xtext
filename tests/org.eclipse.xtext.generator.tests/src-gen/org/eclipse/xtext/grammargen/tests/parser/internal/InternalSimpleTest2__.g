lexer grammar InternalSimpleTest2;
@header {
package org.eclipse.xtext.grammargen.tests.parser.internal;
}

T12 : 'optional' ;
T13 : 'keyword' ;
T14 : '{' ;
T15 : '}' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 145
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 147
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 149
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 152
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 154
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 156
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 158
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 160
RULE_ANY_OTHER : .;


