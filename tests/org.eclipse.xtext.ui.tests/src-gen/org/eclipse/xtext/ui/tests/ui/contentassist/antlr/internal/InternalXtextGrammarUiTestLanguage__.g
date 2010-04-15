lexer grammar InternalXtextGrammarUiTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : '?' ;
T12 : '*' ;
T13 : '+' ;
T14 : '=' ;
T15 : '+=' ;
T16 : '?=' ;
T17 : 'grammar' ;
T18 : 'with' ;
T19 : ',' ;
T20 : '(' ;
T21 : ')' ;
T22 : '.' ;
T23 : 'generate' ;
T24 : 'as' ;
T25 : 'import' ;
T26 : ':' ;
T27 : ';' ;
T28 : 'returns' ;
T29 : '::' ;
T30 : '|' ;
T31 : '{' ;
T32 : '}' ;
T33 : 'current' ;
T34 : '[' ;
T35 : ']' ;
T36 : 'terminal' ;
T37 : '!' ;
T38 : '->' ;
T39 : '..' ;
T40 : 'enum' ;
T41 : 'hidden' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g" 5600
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g" 5602
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g" 5604
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g" 5606
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g" 5608
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g" 5610
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g" 5612
RULE_ANY_OTHER : .;


