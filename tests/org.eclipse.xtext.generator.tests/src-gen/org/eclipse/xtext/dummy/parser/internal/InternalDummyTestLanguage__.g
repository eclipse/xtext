lexer grammar InternalDummyTestLanguage;
@header {
package org.eclipse.xtext.dummy.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'optional' ;
T12 : 'element' ;
T13 : ';' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyTestLanguage.g" 190
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyTestLanguage.g" 192
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyTestLanguage.g" 194
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyTestLanguage.g" 196
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyTestLanguage.g" 198
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyTestLanguage.g" 200
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyTestLanguage.g" 202
RULE_ANY_OTHER : .;


