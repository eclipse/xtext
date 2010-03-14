lexer grammar InternalLocationProviderTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'element' ;
T12 : 'singleref' ;
T13 : 'multiref' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalLocationProviderTestLanguage.g" 210
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalLocationProviderTestLanguage.g" 212
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalLocationProviderTestLanguage.g" 214
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalLocationProviderTestLanguage.g" 216
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalLocationProviderTestLanguage.g" 218
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalLocationProviderTestLanguage.g" 220
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalLocationProviderTestLanguage.g" 222
RULE_ANY_OTHER : .;


