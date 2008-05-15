lexer grammar InternalSimpleTest;
@header {
package org.eclipse.xtext.grammargen.tests.parser.internal;
}

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g" 92
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g" 94
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g" 96
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g" 98
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g" 100
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g" 103
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g" 105
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g" 107
RULE_ANY_OTHER : .;


