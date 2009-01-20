lexer grammar InternalMultiValueFeatureTestLanguage;
@header {
package org.eclipse.xtext.resource.metamodel.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 111
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 113
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 115
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 117
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 119
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 121
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 123
RULE_ANY_OTHER : .;


