lexer grammar InternalXtext;
@header {
package org.eclipse.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'abstract language' ;
T12 : 'language' ;
T13 : '.' ;
T14 : 'extends' ;
T15 : 'hidden' ;
T16 : '(' ;
T17 : ',' ;
T18 : ')' ;
T19 : 'generate' ;
T20 : 'as' ;
T21 : 'import' ;
T22 : 'native' ;
T23 : 'lexer' ;
T24 : 'returns' ;
T25 : ':' ;
T26 : ';' ;
T27 : 'terminal' ;
T28 : '::' ;
T29 : '|' ;
T30 : '?' ;
T31 : '*' ;
T32 : '+' ;
T33 : '+=' ;
T34 : '=' ;
T35 : '?=' ;
T36 : '{' ;
T37 : 'current' ;
T38 : '}' ;
T39 : '!' ;
T40 : '->' ;
T41 : '..' ;
T42 : '[' ;
T43 : ']' ;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g" 2279
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g" 2281
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g" 2283
RULE_STRING : 
			  '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | 
              '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\''
              ;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g" 2288
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/';

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g" 2290
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g" 2292
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g" 2294
RULE_ANY_OTHER : .;


