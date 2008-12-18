lexer grammar InternalDatatypeRulesTestLanguage;
@header {
package org.eclipse.xtext.parser.datatyperules.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : ':' ;
T12 : '#' ;
T13 : '+' ;
T14 : ';' ;
T15 : '.' ;
T16 : '/' ;
T17 : '(' ;
T18 : ')' ;
T19 : '..' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g" 430
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g" 432
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g" 434
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g" 436
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g" 438
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g" 440
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.g" 442
RULE_ANY_OTHER : .;


