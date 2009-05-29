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
T25 : 'GR\u00DCN' ;
T26 : 'type' ;

// $ANTLR src "../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 714
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 716
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 718
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 720
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 722
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 724
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g" 726
RULE_ANY_OTHER : .;


