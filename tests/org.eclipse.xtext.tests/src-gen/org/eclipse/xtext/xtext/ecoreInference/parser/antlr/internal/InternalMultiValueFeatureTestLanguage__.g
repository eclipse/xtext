lexer grammar InternalMultiValueFeatureTestLanguage;
@header {
package org.eclipse.xtext.xtext.ecoreInference.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 118
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 120
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 122
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 124
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 126
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 128
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g" 130
RULE_ANY_OTHER : .;


