lexer grammar InternalContentAssistTestLanguage;
@header {
package org.eclipse.xtext.common.types.xtext.ui.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'default' ;
T12 : 'custom' ;
T13 : 'subtype' ;
T14 : 'import' ;
T15 : '.*' ;
T16 : '.' ;

// $ANTLR src "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 835
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 837
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 839
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 841
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 843
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 845
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g" 847
RULE_ANY_OTHER : .;


