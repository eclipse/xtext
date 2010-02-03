lexer grammar InternalBug287941TestLanguage;
@header {
package org.eclipse.xtext.ui.tests.editor.contentassist.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'false' ;
T12 : '<' ;
T13 : '>' ;
T14 : '<=' ;
T15 : '>=' ;
T16 : '=' ;
T17 : '!=' ;
T18 : 'like' ;
T19 : 'notlike' ;
T20 : 'import' ;
T21 : 'select' ;
T22 : 'from' ;
T23 : ',' ;
T24 : 'where' ;
T25 : '.' ;
T26 : 'as' ;
T27 : 'in' ;
T28 : 'resources' ;
T29 : '{' ;
T30 : '}' ;
T31 : 'elements' ;
T32 : 'or' ;
T33 : 'and' ;
T34 : '(' ;
T35 : ')' ;
T36 : 'null' ;
T37 : 'withoutsubtypes' ;
T38 : 'not' ;
T39 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalBug287941TestLanguage.g" 4194
RULE_SINGED_LONG : '-'? ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalBug287941TestLanguage.g" 4196
RULE_SIGNED_DOUBLE : '-'? ('0'..'9')+ ('.' ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalBug287941TestLanguage.g" 4198
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalBug287941TestLanguage.g" 4200
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalBug287941TestLanguage.g" 4202
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalBug287941TestLanguage.g" 4204
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalBug287941TestLanguage.g" 4206
RULE_WS : (' '|'\t'|'\r'|'\n')+;


