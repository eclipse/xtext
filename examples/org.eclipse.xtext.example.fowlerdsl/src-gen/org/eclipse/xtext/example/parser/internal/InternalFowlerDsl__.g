lexer grammar InternalFowlerDsl;
@header {
package org.eclipse.xtext.example.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'events' ;
T12 : 'end' ;
T13 : 'commands' ;
T14 : 'resetting' ;
T15 : 'state' ;
T16 : 'actions' ;
T17 : '{' ;
T18 : '}' ;
T19 : '=>' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalFowlerDsl.g" 444
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalFowlerDsl.g" 446
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalFowlerDsl.g" 448
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalFowlerDsl.g" 450
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalFowlerDsl.g" 452
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalFowlerDsl.g" 454
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalFowlerDsl.g" 456
RULE_ANY_OTHER : .;


