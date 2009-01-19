lexer grammar InternalDummyTestLanguage;
@header {
package org.eclipse.xtext.dummy.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'optional' ;
T12 : 'element' ;
T13 : ';' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g" 199
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g" 201
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g" 203
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g" 205
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g" 207
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g" 209
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g" 211
RULE_ANY_OTHER : .;


