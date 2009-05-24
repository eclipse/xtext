lexer grammar InternalIndexTestLanguage;
@header {
package org.eclipse.xtext.index.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : '.' ;
T13 : '{' ;
T14 : '}' ;
T15 : 'entity' ;
T16 : 'datatype' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g" 548
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g" 550
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g" 552
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g" 554
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g" 556
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g" 558
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g" 560
RULE_ANY_OTHER : .;


