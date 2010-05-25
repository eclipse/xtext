lexer grammar InternalBug297105TestLanguage;
@header {
package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : '+' ;
T13 : '.' ;

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug297105TestLanguage.g" 471
RULE_EXT_INT : RULE_INT ('e'|'E') ('-'|'+') RULE_INT;

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug297105TestLanguage.g" 473
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug297105TestLanguage.g" 475
RULE_INT : ('0'..'9')+;

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug297105TestLanguage.g" 477
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug297105TestLanguage.g" 479
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug297105TestLanguage.g" 481
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug297105TestLanguage.g" 483
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug297105TestLanguage.g" 485
RULE_ANY_OTHER : .;


