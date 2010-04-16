lexer grammar InternalDomainmodel;
@header {
package org.eclipse.xtext.example.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'public' ;
T12 : 'private' ;
T13 : 'protected' ;
T14 : 'import' ;
T15 : 'package' ;
T16 : '{' ;
T17 : '}' ;
T18 : 'datatype' ;
T19 : 'entity' ;
T20 : 'extends' ;
T21 : 'attr' ;
T22 : ':' ;
T23 : 'ref' ;
T24 : 'opposite' ;
T25 : 'op' ;
T26 : '(' ;
T27 : ')' ;
T28 : ',' ;
T29 : '.*' ;
T30 : '.' ;

// $ANTLR src "../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g" 1975
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g" 1977
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g" 1979
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g" 1981
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g" 1983
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g" 1985
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g" 1987
RULE_ANY_OTHER : .;


