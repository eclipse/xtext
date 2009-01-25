lexer grammar InternalBug250313;
@header {
package org.eclipse.xtext.valueconverter.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '#2' ;
T12 : 'mykeyword1' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 125
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 127
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 129
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 131
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 133
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 135
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g" 137
RULE_ANY_OTHER : .;


