lexer grammar InternalReferenceGrammarUiTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.testlanguages.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'ROT' ;
T12 : 'BLAU' ;
T13 : 'GELB' ;
T14 : 'GR\u00DCN' ;
T15 : 'keyword' ;
T16 : 'spielplatz' ;
T17 : '{' ;
T18 : '}' ;
T19 : 'kind' ;
T20 : '(' ;
T21 : ')' ;
T22 : 'erwachsener' ;
T23 : 'spielzeug' ;
T24 : 'familie' ;
T25 : ',' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1617
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1619
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1621
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1623
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1625
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1627
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1629
RULE_ANY_OTHER : .;


