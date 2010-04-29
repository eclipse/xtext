lexer grammar InternalSimpleReconstrTestLanguage;
@header {
package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '(' ;
T12 : ')' ;
T13 : '!' ;
T14 : '#' ;
T15 : '=' ;
T16 : 'type' ;
T17 : 'extends' ;
T18 : '#2' ;
T19 : 'mykeyword1' ;
T20 : 'mykeyword2' ;
T21 : '#3' ;
T22 : '.' ;
T23 : '#4' ;
T24 : 'myoption' ;
T25 : 'kw' ;
T26 : '#5' ;
T27 : '*' ;
T28 : ',' ;
T29 : '#6' ;
T30 : 'v1' ;
T31 : 'v2' ;
T32 : '#7' ;
T33 : 'kw0' ;
T34 : '#8' ;
T35 : 'kw1' ;
T36 : 'kw2' ;
T37 : 'kw30' ;
T38 : '#9' ;
T39 : 'kw3' ;
T40 : 'kw4' ;
T41 : 'kw5' ;
T42 : 'kw6' ;
T43 : '#10' ;
T44 : '#11' ;
T45 : 'kw7' ;
T46 : '#12' ;
T47 : 'interface' ;
T48 : 'class' ;
T49 : '#13' ;
T50 : 'static' ;
T51 : 'final' ;
T52 : 'transient' ;
T53 : '#14' ;
T54 : 'item' ;
T55 : '#15' ;
T56 : '#16' ;
T57 : 'refs' ;
T58 : '#17' ;
T59 : '#18' ;
T60 : 'ka' ;
T61 : 'kb' ;
T62 : '#19' ;
T63 : 'kx' ;
T64 : 'ky' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 2764
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 2766
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 2768
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 2770
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 2772
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 2774
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 2776
RULE_ANY_OTHER : .;


