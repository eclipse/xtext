lexer grammar InternalDummyLanguage;
@header {
package org.eclipse.xtext.dummy.parser.internal;
}

T12 : 'optional' ;
T13 : 'element' ;
T14 : ';' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 151
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 153
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 155
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 158
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 160
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 162
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 164
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 166
RULE_ANY_OTHER : .;


