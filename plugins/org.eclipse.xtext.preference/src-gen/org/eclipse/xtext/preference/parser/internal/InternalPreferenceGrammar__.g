lexer grammar InternalPreferenceGrammar;
@header {
package org.eclipse.xtext.preference.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'commonprefix' ;
T12 : 'page' ;
T13 : '{' ;
T14 : '}' ;
T15 : ';' ;
T16 : '#' ;
T17 : '?' ;
T18 : '[' ;
T19 : ',' ;
T20 : ']' ;
T21 : '.' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g" 718
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g" 720
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g" 722
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g" 724
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g" 726
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g" 728
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g" 730
RULE_ANY_OTHER : .;


