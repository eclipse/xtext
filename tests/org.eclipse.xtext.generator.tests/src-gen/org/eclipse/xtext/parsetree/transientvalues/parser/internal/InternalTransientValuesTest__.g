lexer grammar InternalTransientValuesTest;
@header {
package org.eclipse.xtext.parsetree.transientvalues.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'test' ;
T12 : 'required' ;
T13 : 'optional' ;
T14 : ':' ;
T15 : 'list' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g" 286
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g" 288
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g" 290
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g" 292
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g" 294
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g" 296
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g" 298
RULE_ANY_OTHER : .;


