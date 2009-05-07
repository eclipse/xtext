lexer grammar InternalGeneratorTestLanguage;
@header {
package org.eclipse.xtext.generator.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'x' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g" 593
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g" 595
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g" 597
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g" 599
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g" 601
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g" 603
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g" 605
RULE_ANY_OTHER : .;


