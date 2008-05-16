lexer grammar InternalXtext;
@header {
package org.eclipse.xtext.parser.internal;
}

T12 : 'lexing' ;
T13 : ':' ;
T14 : 'generate' ;
T15 : 'as' ;
T16 : 'import' ;
T17 : 'tokentype' ;
T18 : 'returns' ;
T19 : ';' ;
T20 : '::' ;
T21 : '|' ;
T22 : '?' ;
T23 : '*' ;
T24 : '+' ;
T25 : '+=' ;
T26 : '=' ;
T27 : '?=' ;
T28 : '{' ;
T29 : 'current' ;
T30 : '.' ;
T31 : '}' ;
T32 : '(' ;
T33 : ')' ;

// $ANTLR src "../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 592
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 594
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 596
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 598
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 600
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 603
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 605
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 607
RULE_ANY_OTHER : .;


