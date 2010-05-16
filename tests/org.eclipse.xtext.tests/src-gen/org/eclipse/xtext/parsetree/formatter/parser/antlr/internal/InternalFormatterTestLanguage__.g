lexer grammar InternalFormatterTestLanguage;
@header {
package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'test' ;
T12 : 'post' ;
T13 : ';' ;
T14 : '=' ;
T15 : '+=' ;
T16 : '[' ;
T17 : ',' ;
T18 : ']' ;
T19 : 'void' ;
T20 : '(' ;
T21 : ')' ;
T22 : ':' ;
T23 : 'space' ;
T24 : 'linewrap' ;
T25 : 'wrapminmax' ;
T26 : 'indentation' ;
T27 : '{' ;
T28 : '}' ;
T29 : 'fqn' ;
T30 : '.' ;
T31 : 'fqnref' ;
T32 : 'enum' ;
T33 : '`' ;
T34 : '%' ;
T35 : '<' ;
T36 : '>' ;
T37 : 'datatypes' ;
T38 : 'kw1' ;
T39 : 'kw3' ;
T40 : 'lit1' ;
T41 : 'lit2' ;
T42 : 'lit3' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 1627
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 1629
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 1631
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 1633
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 1635
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 1637
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 1639
RULE_ANY_OTHER : .;


