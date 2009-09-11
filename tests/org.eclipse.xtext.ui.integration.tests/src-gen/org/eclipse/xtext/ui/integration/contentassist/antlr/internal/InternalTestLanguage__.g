lexer grammar InternalTestLanguage;
@header {
package org.eclipse.xtext.ui.integration.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'stuff' ;

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g" 188
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g" 190
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g" 192
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g" 194
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g" 196
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g" 198
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g" 200
RULE_ANY_OTHER : .;


