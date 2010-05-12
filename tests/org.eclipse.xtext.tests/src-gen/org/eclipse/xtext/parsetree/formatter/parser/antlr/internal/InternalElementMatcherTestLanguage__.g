lexer grammar InternalElementMatcherTestLanguage;
@header {
package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '#1' ;
T12 : 'kw1' ;
T13 : '.' ;
T14 : '#2' ;
T15 : 'sub' ;
T16 : 'ass1' ;
T17 : 'ass2' ;
T18 : '#3' ;
T19 : 'sub2' ;
T20 : 'sub3' ;
T21 : '#4' ;
T22 : '{' ;
T23 : '}' ;
T24 : ';' ;
T25 : '#5' ;
T26 : 'gr' ;
T27 : '#6' ;
T28 : '+' ;
T29 : '*' ;
T30 : '(' ;
T31 : ',' ;
T32 : ')' ;
T33 : '=>' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g" 1508
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g" 1510
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g" 1512
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g" 1514
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g" 1516
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g" 1518
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g" 1520
RULE_ANY_OTHER : .;


