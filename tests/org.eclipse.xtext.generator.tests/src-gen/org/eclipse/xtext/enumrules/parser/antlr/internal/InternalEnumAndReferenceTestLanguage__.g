lexer grammar InternalEnumAndReferenceTestLanguage;
@header {
package org.eclipse.xtext.enumrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'reference' ;
T12 : 'kindOfKeyword' ;
T13 : 'anotherEnumLiteral' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 175
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 177
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 179
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 181
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 183
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 185
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g" 187
RULE_ANY_OTHER : .;


