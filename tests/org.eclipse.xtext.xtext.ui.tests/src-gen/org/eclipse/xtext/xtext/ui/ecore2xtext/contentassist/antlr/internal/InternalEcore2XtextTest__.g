lexer grammar InternalEcore2XtextTest;
@header {
package org.eclipse.xtext.xtext.ui.ecore2xtext.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'INT' ;
T12 : 'Root' ;
T13 : '{' ;
T14 : '}' ;
T15 : 'name' ;
T16 : 'classes' ;
T17 : ',' ;
T18 : 'Concrete0' ;
T19 : 'Concrete1' ;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g" 792
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g" 794
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g" 796
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g" 798
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g" 800
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g" 802
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/contentassist/antlr/internal/InternalEcore2XtextTest.g" 804
RULE_ANY_OTHER : .;


