lexer grammar InternalSimpleTest2;
@header {
package org.eclipse.xtext.grammargen.tests.parser.internal;
}

T12 : 'optional' ;
T13 : 'keyword' ;
T14 : '{' ;
T15 : '}' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 179
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 181
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 183
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 185
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 187
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 189
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 191
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g" 193
RULE_ANY_OTHER : .;


