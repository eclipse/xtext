lexer grammar InternalKeywordsUiTestLanguage;
@header {
package org.eclipse.xtext.parser.keywords.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'foo\\bar' ;
T12 : 'foo\\' ;
T13 : '\\bar' ;
T14 : '\\' ;
T15 : '"a"' ;
T16 : '\'b\'' ;
T17 : '\'c\'' ;
T18 : '"d"' ;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsUiTestLanguage.g" 267
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsUiTestLanguage.g" 269
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsUiTestLanguage.g" 271
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsUiTestLanguage.g" 273
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsUiTestLanguage.g" 275
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsUiTestLanguage.g" 277
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsUiTestLanguage.g" 279
RULE_ANY_OTHER : .;


