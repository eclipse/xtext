lexer grammar InternalTestLanguage;
@header {
package org.eclipse.xtext.ui.integration.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'stuff' ;

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g" 158
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g" 160
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g" 162
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g" 164
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g" 166
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g" 168
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g" 170
RULE_ANY_OTHER : .;


