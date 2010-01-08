lexer grammar InternalEcore2XtextTest;
@header {
package org.eclipse.xtext.xtext.ui.ecore2xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'Root' ;
T12 : '{' ;
T13 : 'classes' ;
T14 : ',' ;
T15 : '}' ;
T16 : 'Concrete0' ;
T17 : 'Concrete1' ;
T18 : 'INT' ;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g" 438
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g" 440
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g" 442
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g" 444
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g" 446
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g" 448
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g" 450
RULE_ANY_OTHER : .;


