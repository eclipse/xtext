lexer grammar SingleCodetemplateContentAssistLexer;

options {
	tokenVocab=InternalSingleCodetemplateLexer;
}

@header {
package org.eclipse.xtext.ui.codetemplates.ui.contentassist;

// Use our own Lexer superclass by means of import. 
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@members{
  private boolean literal = false;
  private boolean templateVariable = false;
}


KEYWORD_12 : {!literal || templateVariable}?=>'templates';

KEYWORD_11 : {!literal || templateVariable}?=>'for';

KEYWORD_8 : '$$';

KEYWORD_9 : '${' {templateVariable = true;};

KEYWORD_10 : {!literal || templateVariable}?=>'>>' { if (!literal) literal = true; };

KEYWORD_1 : '$';

KEYWORD_2 : {!literal || templateVariable}?=>'(';

KEYWORD_3 : {!literal || templateVariable}?=>')';

KEYWORD_4 : {!literal || templateVariable}?=>',';

KEYWORD_5 : {!literal || templateVariable}?=>'.';

KEYWORD_6 : {!literal || templateVariable}?=>':';

KEYWORD_7 : {!literal || templateVariable}?=>'}' {templateVariable = false;};



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : {!literal || templateVariable}?=>( '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'' );

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;