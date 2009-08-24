lexer grammar InternalBug286935TestLanguage;
@header {
package org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'NORMAL' ;
T12 : 'cond' ;
T13 : 'reference' ;
T14 : 'textual' ;
T15 : 'state' ;
T16 : 'init' ;
T17 : 'final' ;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug286935TestLanguage.g" 556
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug286935TestLanguage.g" 558
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug286935TestLanguage.g" 560
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug286935TestLanguage.g" 562
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug286935TestLanguage.g" 564
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug286935TestLanguage.g" 566
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug286935TestLanguage.g" 568
RULE_ANY_OTHER : .;


