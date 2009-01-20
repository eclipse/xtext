lexer grammar InternalTestLanguage;
@header {
package org.eclipse.xtext.testlanguages.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'choice' ;
T12 : 'optional' ;
T13 : 'reducible' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g" 341
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g" 343
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g" 345
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g" 347
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g" 349
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g" 351
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g" 353
RULE_ANY_OTHER : .;


