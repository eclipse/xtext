lexer grammar InternalEnumRulesUiTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.enumrules.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'SameName' ;
T12 : 'overridden' ;
T13 : 'DifferentLiteral' ;
T14 : 'existing' ;
T15 : 'generated' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g" 396
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g" 398
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g" 400
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g" 402
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g" 404
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g" 406
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g" 408
RULE_ANY_OTHER : .;


