lexer grammar InternalLangATestLanguage;
@header {
package org.eclipse.xtext.linking.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : 'type' ;
T13 : 'extends' ;
T14 : 'implements' ;
T15 : ',' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g" 298
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g" 300
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g" 302
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g" 304
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g" 306
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g" 308
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalLangATestLanguage.g" 310
RULE_ANY_OTHER : .;


