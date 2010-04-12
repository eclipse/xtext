lexer grammar InternalIgnoreCaseNamespacesTestLanguage;
@header {
package org.eclipse.xtext.linking.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '{' ;
T12 : '}' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g" 287
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g" 289
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g" 291
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g" 293
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g" 295
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g" 297
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalIgnoreCaseNamespacesTestLanguage.g" 299
RULE_ANY_OTHER : .;


