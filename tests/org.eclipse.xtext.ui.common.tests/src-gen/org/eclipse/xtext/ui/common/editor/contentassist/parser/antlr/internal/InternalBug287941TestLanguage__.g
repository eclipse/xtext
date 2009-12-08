lexer grammar InternalBug287941TestLanguage;
@header {
package org.eclipse.xtext.ui.common.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : 'select' ;
T13 : ',' ;
T14 : 'from' ;
T15 : 'where' ;
T16 : '.' ;
T17 : 'withoutsubtypes' ;
T18 : 'as' ;
T19 : 'not' ;
T20 : 'in' ;
T21 : 'resources' ;
T22 : '{' ;
T23 : '}' ;
T24 : 'elements' ;
T25 : 'or' ;
T26 : 'and' ;
T27 : '(' ;
T28 : ')' ;
T29 : 'true' ;
T30 : 'false' ;
T31 : 'null' ;
T32 : '=' ;
T33 : '<' ;
T34 : '>' ;
T35 : '<=' ;
T36 : '>=' ;
T37 : '!=' ;
T38 : 'like' ;
T39 : 'notlike' ;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g" 2135
RULE_SINGED_LONG : '-'? ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g" 2137
RULE_SIGNED_DOUBLE : '-'? ('0'..'9')+ ('.' ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g" 2139
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g" 2141
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g" 2143
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g" 2145
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g" 2147
RULE_WS : (' '|'\t'|'\r'|'\n')+;


