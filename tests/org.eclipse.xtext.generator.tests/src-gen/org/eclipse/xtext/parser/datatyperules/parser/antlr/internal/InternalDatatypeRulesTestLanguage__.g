lexer grammar InternalDatatypeRulesTestLanguage;
@header {
package org.eclipse.xtext.parser.datatyperules.parser.antlr.internal;

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

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g" 472
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g" 474
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g" 476
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g" 478
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g" 480
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g" 482
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/datatyperules/parser/antlr/internal/InternalDatatypeRulesTestLanguage.g" 484
RULE_ANY_OTHER : .;


