lexer grammar InternalConcreteSyntaxValidationTestLanguage;
@header {
package org.eclipse.xtext.validation.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '#1' ;
T12 : '#2' ;
T13 : 'kw1' ;
T14 : 'kw2' ;
T15 : '#3' ;
T16 : 'kw3' ;
T17 : '#4' ;
T18 : '#5' ;
T19 : 'kw4' ;
T20 : 'kw5' ;
T21 : '#6' ;
T22 : '#7' ;
T23 : '#8' ;
T24 : '#9' ;
T25 : '#10' ;
T26 : '#11' ;
T27 : '#12' ;
T28 : '#13' ;
T29 : '#14' ;
T30 : '#15' ;
T31 : '#16' ;
T32 : 'group' ;
T33 : '#17' ;
T34 : ',' ;
T35 : '#18' ;
T36 : '#19' ;
T37 : '#20' ;
T38 : '#21' ;
T39 : '#22' ;
T40 : '#23' ;
T41 : 'kw' ;
T42 : '#24' ;
T43 : '#25' ;
T44 : '#26' ;
T45 : 'lit1' ;
T46 : 'lit2' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g" 3813
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g" 3815
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g" 3817
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g" 3819
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g" 3821
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g" 3823
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g" 3825
RULE_ANY_OTHER : .;


