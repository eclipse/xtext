lexer grammar InternalPartialParserTestLanguage;
@header {
package org.eclipse.xtext.testlanguages.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'container' ;
T12 : '{' ;
T13 : '}' ;
T14 : 'nested' ;
T15 : 'children' ;
T16 : ',' ;
T17 : '->' ;
T18 : 'C' ;
T19 : '(' ;
T20 : ')' ;
T21 : 'abstract children' ;
T22 : 'F' ;
T23 : 'S' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g" 688
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g" 690
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g" 692
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g" 694
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g" 696
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g" 698
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g" 700
RULE_ANY_OTHER : .;


