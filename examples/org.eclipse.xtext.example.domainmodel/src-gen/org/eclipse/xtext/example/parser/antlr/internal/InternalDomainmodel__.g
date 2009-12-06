lexer grammar InternalDomainmodel;
@header {
package org.eclipse.xtext.example.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : 'package' ;
T13 : '{' ;
T14 : '}' ;
T15 : 'datatype' ;
T16 : 'entity' ;
T17 : 'extends' ;
T18 : 'attr' ;
T19 : ':' ;
T20 : 'ref' ;
T21 : 'opposite' ;
T22 : 'op' ;
T23 : '(' ;
T24 : ',' ;
T25 : ')' ;
T26 : '.*' ;
T27 : '.' ;
T28 : 'public' ;
T29 : 'private' ;
T30 : 'protected' ;

// $ANTLR src "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g" 1158
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g" 1160
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g" 1162
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g" 1164
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g" 1166
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g" 1168
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g" 1170
RULE_ANY_OTHER : .;


