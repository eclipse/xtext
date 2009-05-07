lexer grammar InternalEnumAndReferenceTestLanguage;
@header {
package org.eclipse.xtext.enumrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'kindOfKeyword' ;
T12 : 'reference' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 136
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 138
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 140
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 142
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 144
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 146
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 148
RULE_ANY_OTHER : .;


