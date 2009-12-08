lexer grammar InternalBug288432TestLanguage;
@header {
package org.eclipse.xtext.parser.assignments.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '(' ;
T12 : ',' ;
T13 : ')' ;
T14 : 'body' ;
T15 : 'end body' ;
T16 : 'content' ;
T17 : 'end content' ;
T18 : 'element' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g" 543
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g" 545
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g" 547
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g" 549
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g" 551
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g" 553
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g" 555
RULE_ANY_OTHER : .;


