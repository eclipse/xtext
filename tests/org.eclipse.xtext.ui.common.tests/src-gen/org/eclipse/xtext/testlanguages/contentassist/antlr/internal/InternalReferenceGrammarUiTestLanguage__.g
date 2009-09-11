lexer grammar InternalReferenceGrammarUiTestLanguage;
@header {
package org.eclipse.xtext.testlanguages.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
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

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1268
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1270
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1272
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1274
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1276
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1278
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g" 1280
RULE_ANY_OTHER : .;


