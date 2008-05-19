lexer grammar InternalSimpleReconstrTest;
@header {
package org.eclipse.xtext.parsetree.reconstr.parser.internal;
}

T12 : '(' ;
T13 : ')' ;
T14 : '!' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g" 166
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g" 168
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g" 170
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g" 172
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g" 175
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g" 177
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g" 179
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g" 181
RULE_ANY_OTHER : .;


