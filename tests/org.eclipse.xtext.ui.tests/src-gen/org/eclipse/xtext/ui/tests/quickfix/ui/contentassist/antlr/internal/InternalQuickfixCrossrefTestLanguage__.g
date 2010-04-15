lexer grammar InternalQuickfixCrossrefTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.quickfix.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : '{' ;
T12 : '}' ;
T13 : 'ref' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 329
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 331
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 333
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 335
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 337
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 339
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 341
RULE_ANY_OTHER : .;


