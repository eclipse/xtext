lexer grammar InternalLookaheadLanguage;
@header {
package org.eclipse.xtext.testlanguages.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'bar' ;
T12 : 'a' ;
T13 : 'foo' ;
T14 : 'b' ;
T15 : 'd' ;
T16 : 'c' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g" 394
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g" 396
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g" 398
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g" 400
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g" 402
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g" 404
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g" 406
RULE_ANY_OTHER : .;


