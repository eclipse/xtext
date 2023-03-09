lexer grammar SingleCodetemplateLexer;

options {
	tokenVocab=InternalSingleCodetemplateLexer;
}

@header {
package org.eclipse.xtext.ui.codetemplates.lexer;

// Use our own Lexer superclass by means of import4. 
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


Templates : {!literal || templateVariable}?=>'templates';

For : {!literal || templateVariable}?=>'for';

DollarSignDollarSign : '$$';

DollarSignLeftCurlyBracket : '${' {templateVariable = true;};

GreaterThanSignGreaterThanSign : {!literal || templateVariable}?=>'>>' { if (!literal) literal = true; };

DollarSign : '$';

LeftParenthesis : {!literal || templateVariable}?=>'(';

RightParenthesis : {!literal || templateVariable}?=>')';

Comma : {!literal || templateVariable}?=>',';

FullStop : {!literal || templateVariable}?=>'.';

Colon : {!literal || templateVariable}?=>':';

RightCurlyBracket : {!literal || templateVariable}?=>'}' {templateVariable = false;};



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : {!literal || templateVariable}?=>( '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'' );

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;




