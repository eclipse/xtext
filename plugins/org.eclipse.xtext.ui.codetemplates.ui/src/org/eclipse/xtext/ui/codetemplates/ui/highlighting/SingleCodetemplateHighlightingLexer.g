lexer grammar SingleCodetemplateHighlightingLexer;

@header {
package org.eclipse.xtext.ui.codetemplates.ui.highlighting;

// Use our own Lexer superclass by means of import. 
import org.eclipse.xtext.parser.antlr.Lexer;
}

// Templates
KEYWORD_TEMPLATES : 'templates';
KEYWORD_FOR : 'for';

// Template
KEYWORD_OPENBRACE : '(';
KEYWORD_CLOSINGBRACE : ')';

// FQN
KEYWORD_DOT : '.';

RULE_BODY : '>>'  RULE_ANY_OTHER*;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;

