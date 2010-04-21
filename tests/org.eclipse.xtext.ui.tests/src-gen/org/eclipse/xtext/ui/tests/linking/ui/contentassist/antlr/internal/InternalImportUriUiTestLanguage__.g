lexer grammar InternalImportUriUiTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.linking.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'import' ;
T12 : 'type' ;
T13 : 'extends' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g" 479
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g" 481
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g" 483
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g" 485
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g" 487
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g" 489
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g" 491
RULE_ANY_OTHER : .;


