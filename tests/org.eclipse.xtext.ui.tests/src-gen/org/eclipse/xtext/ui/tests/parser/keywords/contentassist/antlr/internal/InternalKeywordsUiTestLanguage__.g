lexer grammar InternalKeywordsUiTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.parser.keywords.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'foo\\bar' ;
T12 : 'foo\\' ;
T13 : '\\bar' ;
T14 : '\\' ;
T15 : '"a"' ;
T16 : '\'b\'' ;
T17 : '\'c\'' ;
T18 : '"d"' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g" 333
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g" 335
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g" 337
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g" 339
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g" 341
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g" 343
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/keywords/contentassist/antlr/internal/InternalKeywordsUiTestLanguage.g" 345
RULE_ANY_OTHER : .;


