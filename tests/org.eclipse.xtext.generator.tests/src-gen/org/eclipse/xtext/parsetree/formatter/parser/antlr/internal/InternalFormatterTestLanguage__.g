lexer grammar InternalFormatterTestLanguage;
@header {
package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'test' ;
T12 : ';' ;
T13 : 'linewrap' ;
T14 : 'indentation' ;
T15 : '{' ;
T16 : '}' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 301
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 303
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 305
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 307
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 309
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 311
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g" 313
RULE_ANY_OTHER : .;


