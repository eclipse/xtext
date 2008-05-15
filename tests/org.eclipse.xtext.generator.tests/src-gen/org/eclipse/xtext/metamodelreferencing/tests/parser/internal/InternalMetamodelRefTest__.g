lexer grammar InternalMetamodelRefTest;
@header {
package org.eclipse.xtext.metamodelreferencing.tests.parser.internal;
}

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 119
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 121
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 123
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 125
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 127
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 129
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 131
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g" 134
RULE_ANY_OTHER : .;


