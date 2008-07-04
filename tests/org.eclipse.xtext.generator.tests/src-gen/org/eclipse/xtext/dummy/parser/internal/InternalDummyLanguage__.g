lexer grammar InternalDummyLanguage;
@header {
package org.eclipse.xtext.dummy.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'optional' ;
T13 : 'element' ;
T14 : ';' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 151
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 153
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 155
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 157
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 159
RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 161
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 163
RULE_LEXER_BODY : '<#' '.'* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g" 165
RULE_ANY_OTHER : .;


