lexer grammar InternalReferenceGrammar;
@header {
package org.eclipse.xtext.reference.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'spielplatz' ;
T12 : '{' ;
T13 : '}' ;
T14 : 'kind' ;
T15 : '(' ;
T16 : ')' ;
T17 : 'erwachsener' ;
T18 : 'spielzeug' ;
T19 : 'familie' ;
T20 : 'keyword' ;
T21 : ',' ;
T22 : 'ROT' ;
T23 : 'BLAU' ;
T24 : 'GELB' ;
T25 : 'GRÜN' ;
T26 : 'type' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 707
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 709
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 711
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 713
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 715
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 717
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 719
RULE_ANY_OTHER : .;


