lexer grammar InternalEcoreDsl;
@header {
package org.eclipse.xtext.example.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : '=' ;
T13 : ';' ;
T14 : 'package' ;
T15 : 'nsURI' ;
T16 : 'nsPrefix' ;
T17 : '{' ;
T18 : '}' ;
T19 : '!serializable' ;
T20 : 'datatype' ;
T21 : ':' ;
T22 : '@' ;
T23 : '(' ;
T24 : ',' ;
T25 : ')' ;
T26 : 'abstract' ;
T27 : 'interface' ;
T28 : 'class' ;
T29 : '<' ;
T30 : '>' ;
T31 : 'extends' ;
T32 : 'ID' ;
T33 : 'bag' ;
T34 : 'random' ;
T35 : 'readonly' ;
T36 : 'volatile' ;
T37 : 'transient' ;
T38 : 'unsettable' ;
T39 : 'derived' ;
T40 : 'attr' ;
T41 : '[' ;
T42 : '..' ;
T43 : ']' ;
T44 : 'local' ;
T45 : 'val' ;
T46 : 'ref' ;
T47 : '#' ;
T48 : 'enum' ;
T49 : '?' ;
T50 : 'super' ;
T51 : 'op' ;
T52 : 'void' ;
T53 : 'throws' ;
T54 : '.' ;
T55 : '$' ;
T56 : '-' ;

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g" 3005
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g" 3007
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g" 3009
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g" 3011
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g" 3013
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g" 3015
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g" 3017
RULE_ANY_OTHER : .;


