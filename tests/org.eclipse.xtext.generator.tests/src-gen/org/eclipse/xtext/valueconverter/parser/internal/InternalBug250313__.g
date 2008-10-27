lexer grammar InternalBug250313;
@header {
package org.eclipse.xtext.valueconverter.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '#2' ;
T12 : 'mykeyword1' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/internal/InternalBug250313.g" 109
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/internal/InternalBug250313.g" 111
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/internal/InternalBug250313.g" 113
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/internal/InternalBug250313.g" 115
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/internal/InternalBug250313.g" 117
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/internal/InternalBug250313.g" 119
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/valueconverter/parser/internal/InternalBug250313.g" 121
RULE_ANY_OTHER : .;


