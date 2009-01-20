lexer grammar InternalTransientValuesTest;
@header {
package org.eclipse.xtext.parsetree.transientvalues.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'test' ;
T12 : 'required' ;
T13 : 'optional' ;
T14 : ':' ;
T15 : 'list' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g" 312
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g" 314
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g" 316
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g" 318
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g" 320
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g" 322
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g" 324
RULE_ANY_OTHER : .;


