lexer grammar InternalComplexReconstrTest;
@header {
package org.eclipse.xtext.parsetree.reconstr.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : '+' ;
T13 : '-' ;
T14 : '(' ;
T15 : ')' ;
T16 : '!' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 256
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 258
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 260
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 262
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 264
RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 266
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 268
RULE_LEXER_BODY : '<#' '.'* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 270
RULE_ANY_OTHER : .;


