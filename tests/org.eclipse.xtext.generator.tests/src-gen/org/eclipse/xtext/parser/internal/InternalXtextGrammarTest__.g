lexer grammar InternalXtextGrammarTest;
@header {
package org.eclipse.xtext.parser.internal;
}

T12 : 'lexing' ;
T13 : ':' ;
T14 : 'generate' ;
T15 : 'as' ;
T16 : 'import' ;
T17 : 'tokentype' ;
T18 : 'returns' ;
T19 : ';' ;
T20 : '::' ;
T21 : '|' ;
T22 : '?' ;
T23 : '*' ;
T24 : '+' ;
T25 : '+=' ;
T26 : '=' ;
T27 : '?=' ;
T28 : '{' ;
T29 : 'current' ;
T30 : '.' ;
T31 : '}' ;
T32 : '(' ;
T33 : ')' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 788
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 790
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 792
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 794
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 796
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 798
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 800
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g" 802
RULE_ANY_OTHER : .;


