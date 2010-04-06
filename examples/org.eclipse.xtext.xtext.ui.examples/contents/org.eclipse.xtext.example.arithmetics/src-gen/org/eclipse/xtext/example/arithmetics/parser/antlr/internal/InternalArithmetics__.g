lexer grammar InternalArithmetics;
@header {
package org.eclipse.xtext.example.arithmetics.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'module' ;
T13 : 'import' ;
T14 : '.' ;
T15 : '*' ;
T16 : 'def' ;
T17 : '(' ;
T18 : ',' ;
T19 : ')' ;
T20 : ':' ;
T21 : ';' ;
T22 : '+' ;
T23 : '-' ;
T24 : '/' ;

// $ANTLR src "../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g" 941
RULE_NUMBER : ('0'..'9')* ('.' ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g" 943
RULE_INT : 'this one has been deactivated';

// $ANTLR src "../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g" 945
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g" 947
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g" 949
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g" 951
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g" 953
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g" 955
RULE_ANY_OTHER : .;


