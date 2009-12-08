lexer grammar InternalCrossReferenceProposalTestLanguage;
@header {
package org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : '{' ;
T12 : '}' ;
T13 : '<-' ;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g" 292
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g" 294
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g" 296
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g" 298
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g" 300
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g" 302
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalCrossReferenceProposalTestLanguage.g" 304
RULE_ANY_OTHER : .;


