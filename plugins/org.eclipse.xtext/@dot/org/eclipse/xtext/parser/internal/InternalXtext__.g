lexer grammar InternalXtext;
@header {
package org.eclipse.xtext.parser.internal;
}

T12 : 'lexing' ;
T13 : ':' ;
T14 : 'generate' ;
T15 : 'as' ;
T16 : 'import' ;
T17 : 'returns' ;
T18 : ';' ;
T19 : '::' ;
T20 : '|' ;
T21 : '?' ;
T22 : '*' ;
T23 : '+' ;
T24 : '+=' ;
T25 : '=' ;
T26 : '?=' ;
T27 : '{' ;
T28 : 'current' ;
T29 : '.' ;
T30 : '}' ;
T31 : '(' ;
T32 : ')' ;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 519
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 521
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 523
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 525
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 527
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 529
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 531
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 534
RULE_ANY_OTHER : .;


