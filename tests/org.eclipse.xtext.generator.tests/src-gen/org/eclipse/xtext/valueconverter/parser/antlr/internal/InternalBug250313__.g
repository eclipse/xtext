lexer grammar InternalBug250313;
@header {
package org.eclipse.xtext.valueconverter.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '#2' ;
T12 : 'mykeyword1' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 122
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 124
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 126
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 128
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 130
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 132
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 134
RULE_ANY_OTHER : .;


