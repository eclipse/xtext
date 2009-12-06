lexer grammar InternalBug296889TestLanguage;
@header {
package org.eclipse.xtext.parser.antlr.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'Model' ;
T12 : 'DataType' ;
T13 : '--' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g" 565
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g" 567
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g" 569
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g" 571
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g" 573
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g" 575
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g" 577
RULE_ANY_OTHER : .;


