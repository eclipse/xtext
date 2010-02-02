lexer grammar InternalContentAssistTestLanguage;
@header {
package org.eclipse.xtext.testlanguages.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'abstract rules' ;
T12 : 'end' ;
T13 : '(' ;
T14 : ')' ;
T15 : ';' ;
T16 : 'rule' ;
T17 : ':' ;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 606
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 608
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 610
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 612
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 614
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 616
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 618
RULE_ANY_OTHER : .;


