lexer grammar InternalUnassignedRuleCallTestLanguage;
@header {
package org.eclipse.xtext.xtext.ecoreInference.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'model' ;
T12 : 'feature' ;
T13 : ';' ;
T14 : 'keyword' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g" 231
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g" 233
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g" 235
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g" 237
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g" 239
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g" 241
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g" 243
RULE_ANY_OTHER : .;


