lexer grammar InternalQuickfixCrossrefTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.quickfix.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '{' ;
T12 : 'ref' ;
T13 : '}' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 215
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 217
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 219
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 221
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 223
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 225
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g" 227
RULE_ANY_OTHER : .;


