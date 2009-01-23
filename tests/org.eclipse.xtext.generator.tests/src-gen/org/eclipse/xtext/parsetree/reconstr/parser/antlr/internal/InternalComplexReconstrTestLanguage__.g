lexer grammar InternalComplexReconstrTestLanguage;
@header {
package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '+' ;
T12 : '-' ;
T13 : '(' ;
T14 : ')' ;
T15 : '!' ;
T16 : 'TG' ;
T17 : '[' ;
T18 : ',' ;
T19 : ']' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g" 623
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g" 625
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g" 627
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g" 629
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g" 631
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g" 633
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.g" 635
RULE_ANY_OTHER : .;


