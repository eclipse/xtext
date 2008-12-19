lexer grammar InternalMultiValueFeatureTestLanguage;
@header {
package org.eclipse.xtext.resource.metamodel.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

// $ANTLR src "./src-gen/org/eclipse/xtext/resource/metamodel/parser/internal/InternalMultiValueFeatureTestLanguage.g" 103
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/resource/metamodel/parser/internal/InternalMultiValueFeatureTestLanguage.g" 105
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/resource/metamodel/parser/internal/InternalMultiValueFeatureTestLanguage.g" 107
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/resource/metamodel/parser/internal/InternalMultiValueFeatureTestLanguage.g" 109
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/resource/metamodel/parser/internal/InternalMultiValueFeatureTestLanguage.g" 111
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/resource/metamodel/parser/internal/InternalMultiValueFeatureTestLanguage.g" 113
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/resource/metamodel/parser/internal/InternalMultiValueFeatureTestLanguage.g" 115
RULE_ANY_OTHER : .;


