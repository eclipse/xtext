lexer grammar InternalXtext;
@header {
package org.eclipse.xtext.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'abstract language' ;
T12 : 'language' ;
T13 : '.' ;
T14 : 'extends' ;
T15 : 'lexing' ;
T16 : ':' ;
T17 : 'generate' ;
T18 : 'as' ;
T19 : 'import' ;
T20 : 'returns' ;
T21 : ';' ;
T22 : '::' ;
T23 : '|' ;
T24 : '?' ;
T25 : '*' ;
T26 : '+' ;
T27 : '+=' ;
T28 : '=' ;
T29 : '?=' ;
T30 : '{' ;
T31 : 'current' ;
T32 : '}' ;
T33 : '(' ;
T34 : ')' ;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 1069
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 1071
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 1073
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 1075
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 1077
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 1079
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g" 1081
RULE_ANY_OTHER : .;


