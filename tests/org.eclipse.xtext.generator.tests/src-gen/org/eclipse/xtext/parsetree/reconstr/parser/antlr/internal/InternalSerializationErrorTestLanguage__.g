lexer grammar InternalSerializationErrorTestLanguage;
@header {
package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '(' ;
T12 : ')' ;
T13 : 'tworequired' ;
T14 : 'twooptions' ;
T15 : 'one' ;
T16 : 'two' ;
T17 : '{' ;
T18 : '}' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g" 485
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g" 487
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g" 489
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g" 491
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g" 493
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g" 495
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g" 497
RULE_ANY_OTHER : .;


