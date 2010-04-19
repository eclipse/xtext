lexer grammar InternalEcore2XtextTest;
@header {
package org.eclipse.xtext.xtext.ui.ecore2xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'INT' ;
T12 : 'Root' ;
T13 : '{' ;
T14 : '}' ;
T15 : 'classes' ;
T16 : ',' ;
T17 : 'concrete0' ;
T18 : 'Concrete0' ;
T19 : 'Concrete1' ;
T20 : 'DiamondInheritance' ;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g" 992
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g" 994
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g" 996
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g" 998
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g" 1000
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g" 1002
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/ui/contentassist/antlr/internal/InternalEcore2XtextTest.g" 1004
RULE_ANY_OTHER : .;


