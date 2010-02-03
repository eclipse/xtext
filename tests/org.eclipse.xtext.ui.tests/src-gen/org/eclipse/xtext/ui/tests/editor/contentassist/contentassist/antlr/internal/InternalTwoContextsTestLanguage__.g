lexer grammar InternalTwoContextsTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.editor.contentassist.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : ';' ;
T12 : 'refersTo' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g" 270
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g" 272
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g" 274
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g" 276
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g" 278
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g" 280
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g" 282
RULE_ANY_OTHER : .;


