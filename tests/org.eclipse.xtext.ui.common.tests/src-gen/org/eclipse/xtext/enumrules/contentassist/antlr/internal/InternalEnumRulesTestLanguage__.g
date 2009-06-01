lexer grammar InternalEnumRulesTestLanguage;
@header {
package org.eclipse.xtext.enumrules.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'SameName' ;
T12 : 'overridden' ;
T13 : 'DifferentLiteral' ;
T14 : 'existing' ;
T15 : 'generated' ;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g" 274
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g" 276
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g" 278
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g" 280
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g" 282
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g" 284
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g" 286
RULE_ANY_OTHER : .;


