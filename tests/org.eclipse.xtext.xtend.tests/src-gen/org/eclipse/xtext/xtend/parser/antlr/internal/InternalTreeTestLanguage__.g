lexer grammar InternalTreeTestLanguage;
@header {
package org.eclipse.xtext.xtend.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '(' ;
T12 : ')' ;
T13 : '{' ;
T14 : '};' ;

// $ANTLR src "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g" 234
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g" 236
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g" 238
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g" 240
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g" 242
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g" 244
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g" 246
RULE_ANY_OTHER : .;


