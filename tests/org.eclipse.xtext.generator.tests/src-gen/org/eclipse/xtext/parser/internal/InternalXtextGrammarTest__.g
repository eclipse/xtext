lexer grammar InternalXtextGrammarTest;
@header {
package org.eclipse.xtext.parser.internal;
}

T11 : 'lexing' ;
T12 : ':' ;
T13 : 'generate' ;
T14 : 'as' ;
T15 : 'import' ;
T16 : 'returns' ;
T17 : ';' ;
T18 : '::' ;
T19 : '|' ;
T20 : '?' ;
T21 : '*' ;
T22 : '+' ;
T23 : '+=' ;
T24 : '=' ;
T25 : '?=' ;
T26 : '{' ;
T27 : 'current' ;
T28 : '.' ;
T29 : '}' ;
T30 : '(' ;
T31 : ')' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 281
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 283
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 285
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 288
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 290
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 292
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 294
RULE_INT : ('0'..'9')+;


