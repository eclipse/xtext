lexer grammar CodetemplatesLexer;

options {
	tokenVocab=InternalCodetemplatesLexer;
}

@header {
package org.eclipse.xtext.ui.codetemplates.lexer;

// Use our own Lexer superclass by means of import. 
import org.eclipse.xtext.parser.antlr.Lexer;
}

@members{
  private boolean literal = false;
  private boolean templateVariable = false;
  
  public void initialize(boolean literal, boolean templateVariable) {
    this.literal = literal;
    this.templateVariable = templateVariable;
  }
}


KEYWORD_14 : {!literal || templateVariable}?=>'templates';

KEYWORD_12 : '\\<<';

KEYWORD_13 : {!literal || templateVariable}?=>'for';

KEYWORD_8 : '$$';

KEYWORD_9 : '${' {templateVariable = true;};

KEYWORD_10 : '<<' { if (literal) literal = false; };

KEYWORD_11 : {!literal || templateVariable}?=>'>>' { if (!literal) literal = true; };

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




