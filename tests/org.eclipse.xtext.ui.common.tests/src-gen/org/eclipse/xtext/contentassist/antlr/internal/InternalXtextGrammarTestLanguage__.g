lexer grammar InternalXtextGrammarTestLanguage;
@header {
package org.eclipse.xtext.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
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
T20 : 'hidden' ;
T21 : '(' ;
T22 : ')' ;
T23 : '.' ;
T24 : 'generate' ;
T25 : 'as' ;
T26 : 'import' ;
T27 : ':' ;
T28 : ';' ;
T29 : 'returns' ;
T30 : '::' ;
T31 : '|' ;
T32 : '{' ;
T33 : '}' ;
T34 : 'current' ;
T35 : '[' ;
T36 : ']' ;
T37 : 'terminal' ;
T38 : '!' ;
T39 : '->' ;
T40 : '..' ;
T41 : 'enum' ;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g" 3184
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g" 3186
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g" 3188
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g" 3190
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g" 3192
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g" 3194
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g" 3196
RULE_ANY_OTHER : .;


