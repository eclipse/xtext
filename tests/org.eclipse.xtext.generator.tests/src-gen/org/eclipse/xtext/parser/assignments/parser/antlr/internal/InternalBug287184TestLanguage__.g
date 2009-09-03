lexer grammar InternalBug287184TestLanguage;
@header {
package org.eclipse.xtext.parser.assignments.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'model' ;
T12 : 'detail' ;
T13 : 'private' ;
T14 : 'protected' ;
T15 : 'public' ;
T16 : 'associated' ;
T17 : ';' ;
T18 : '.' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g" 412
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g" 414
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g" 416
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g" 418
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g" 420
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g" 422
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug287184TestLanguage.g" 424
RULE_ANY_OTHER : .;


