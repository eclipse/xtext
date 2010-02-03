lexer grammar InternalBmTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.editor.bracketmatching.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : '[' ;
T12 : ']' ;
T13 : '(' ;
T14 : ')' ;
T15 : 'begin' ;
T16 : 'end' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/contentassist/antlr/internal/InternalBmTestLanguage.g" 571
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/contentassist/antlr/internal/InternalBmTestLanguage.g" 573
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/contentassist/antlr/internal/InternalBmTestLanguage.g" 575
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/contentassist/antlr/internal/InternalBmTestLanguage.g" 577
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/contentassist/antlr/internal/InternalBmTestLanguage.g" 579
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/contentassist/antlr/internal/InternalBmTestLanguage.g" 581
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/contentassist/antlr/internal/InternalBmTestLanguage.g" 583
RULE_ANY_OTHER : .;


