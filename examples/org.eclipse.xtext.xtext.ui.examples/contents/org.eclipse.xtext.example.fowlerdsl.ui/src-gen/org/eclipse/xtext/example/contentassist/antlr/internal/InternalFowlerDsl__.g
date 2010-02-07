lexer grammar InternalFowlerDsl;
@header {
package org.eclipse.xtext.example.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'events' ;
T12 : 'end' ;
T13 : 'commands' ;
T14 : 'state' ;
T15 : 'actions' ;
T16 : '{' ;
T17 : '}' ;
T18 : '=>' ;
T19 : 'resetting' ;

// $ANTLR src "../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g" 920
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g" 922
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g" 924
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g" 926
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g" 928
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g" 930
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g" 932
RULE_ANY_OTHER : .;


