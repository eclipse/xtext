lexer grammar InternalEnumRulesTestLanguage;
@header {
package org.eclipse.xtext.enumrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'existing' ;
T12 : 'generated' ;
T13 : 'SameName' ;
T14 : 'overridden' ;
T15 : 'DifferentLiteral' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g" 233
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g" 235
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g" 237
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g" 239
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g" 241
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g" 243
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g" 245
RULE_ANY_OTHER : .;


