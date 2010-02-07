lexer grammar InternalBmTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.editor.bracketmatching.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '[' ;
T12 : ']' ;
T13 : '(' ;
T14 : ')' ;
T15 : 'begin' ;
T16 : 'end' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g" 370
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g" 372
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g" 374
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g" 376
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g" 378
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g" 380
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/parser/antlr/internal/InternalBmTestLanguage.g" 382
RULE_ANY_OTHER : .;


