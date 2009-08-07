lexer grammar InternalFormatterTestLanguage;
@header {
package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'test' ;
T12 : ';' ;
T13 : '=' ;
T14 : '+=' ;
T15 : '[' ;
T16 : ',' ;
T17 : ']' ;
T18 : 'void' ;
T19 : '(' ;
T20 : ')' ;
T21 : ':' ;
T22 : 'linewrap' ;
T23 : 'indentation' ;
T24 : '{' ;
T25 : '}' ;
T26 : 'fqn' ;
T27 : '.' ;
T28 : 'fqnref' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 810
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 812
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 814
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 816
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 818
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 820
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 822
RULE_ANY_OTHER : .;


