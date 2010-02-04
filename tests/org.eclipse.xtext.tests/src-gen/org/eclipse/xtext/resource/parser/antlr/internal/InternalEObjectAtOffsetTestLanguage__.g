lexer grammar InternalEObjectAtOffsetTestLanguage;
@header {
package org.eclipse.xtext.resource.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'foobar' ;
T12 : 'bar' ;
T13 : ',' ;
T14 : 'foo' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g" 343
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g" 345
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g" 347
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g" 349
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g" 351
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g" 353
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g" 355
RULE_ANY_OTHER : .;


