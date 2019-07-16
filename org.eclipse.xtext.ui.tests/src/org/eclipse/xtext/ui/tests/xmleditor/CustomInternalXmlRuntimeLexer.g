lexer grammar CustomInternalXmlRuntimeLexer;

@header {
package org.eclipse.xtext.ui.tests.xmleditor;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@members {
	boolean tagMode = false;
}

RULE_TAG_START_OPEN : '<' { tagMode = true; };

RULE_TAG_END_OPEN : '</' { tagMode = true; };

RULE_TAG_CLOSE : { tagMode }? => '>' { tagMode = false; };

RULE_TAG_EMPTY_CLOSE : { tagMode }? => '/>' { tagMode = false; };

RULE_ATTR_EQ : { tagMode }? => '=';

RULE_ID : { tagMode }? => '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : { tagMode }? => ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_WS : { tagMode }? => (' '|'\r'|'\t'|'\f'|'\n')+;

RULE_PCDATA : { !tagMode }? => ~('<')+;