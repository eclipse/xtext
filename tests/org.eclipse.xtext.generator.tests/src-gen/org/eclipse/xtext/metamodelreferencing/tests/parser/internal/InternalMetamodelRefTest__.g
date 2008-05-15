lexer grammar InternalMetamodelRefTest;
@header {
package org.eclipse.xtext.metamodelreferencing.tests.parser.internal;
}

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 96
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 98
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 100
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 102
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 104
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 106
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 109
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 111
RULE_ANY_OTHER : .;


