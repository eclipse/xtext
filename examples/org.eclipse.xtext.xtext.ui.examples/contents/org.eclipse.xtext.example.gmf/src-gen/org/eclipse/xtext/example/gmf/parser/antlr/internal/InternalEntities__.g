lexer grammar InternalEntities;
@header {
package org.eclipse.xtext.example.gmf.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : 'type' ;
T13 : 'entity' ;
T14 : 'extends' ;
T15 : '{' ;
T16 : '}' ;
T17 : 'property' ;
T18 : ':' ;
T19 : '[]' ;
T20 : 'reference' ;

// $ANTLR src "../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g" 625
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g" 627
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g" 629
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g" 631
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g" 633
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g" 635
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g" 637
RULE_ANY_OTHER : .;


