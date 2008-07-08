lexer grammar InternalPreference;
@header {
package org.eclipse.xtext.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'commonprefix' ;
T13 : 'page' ;
T14 : '{' ;
T15 : '}' ;
T16 : ';' ;
T17 : '#' ;
T18 : '?' ;
T19 : '[' ;
T20 : ',' ;
T21 : ']' ;
T22 : '.' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalPreference.g" 716
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalPreference.g" 718
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalPreference.g" 720
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalPreference.g" 722
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalPreference.g" 724
RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalPreference.g" 726
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalPreference.g" 728
RULE_LEXER_BODY : '<#' '.'* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalPreference.g" 730
RULE_ANY_OTHER : .;


