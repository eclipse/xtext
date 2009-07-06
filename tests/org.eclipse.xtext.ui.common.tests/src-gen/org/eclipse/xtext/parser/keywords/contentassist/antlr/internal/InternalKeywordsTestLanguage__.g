lexer grammar InternalKeywordsTestLanguage;
@header {
package org.eclipse.xtext.parser.keywords.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'foo\\bar' ;
T12 : 'foo\\' ;
T13 : '\\bar' ;
T14 : '\\' ;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g" 211
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g" 213
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g" 215
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g" 217
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g" 219
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g" 221
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/keywords/contentassist/antlr/internal/InternalKeywordsTestLanguage.g" 223
RULE_ANY_OTHER : .;


