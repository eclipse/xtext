lexer grammar InternalBug311337TestLanguage;
@header {
package org.eclipse.xtext.linking.lazy.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '(def)' ;
T12 : ':' ;
T13 : '(child)' ;
T14 : '(ref)' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g" 370
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g" 372
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g" 374
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g" 376
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g" 378
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g" 380
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g" 382
RULE_ANY_OTHER : .;


