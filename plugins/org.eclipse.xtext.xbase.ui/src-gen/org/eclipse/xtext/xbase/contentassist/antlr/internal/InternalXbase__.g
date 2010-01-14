lexer grammar InternalXbase;
@header {
package org.eclipse.xtext.xbase.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T12 : '==' ;
T13 : '!=' ;
T14 : '>=' ;
T15 : '<=' ;
T16 : '>' ;
T17 : '<' ;
T18 : '+' ;
T19 : '-' ;
T20 : '*' ;
T21 : '/' ;
T22 : '+=' ;
T23 : '..' ;
T24 : '!' ;
T25 : 'def' ;
T26 : 'import' ;
T27 : '.' ;
T28 : '(' ;
T29 : ')' ;
T30 : ',' ;
T31 : 'if' ;
T32 : ':' ;
T33 : ';' ;
T34 : '|' ;
T35 : '=' ;
T36 : 'else' ;
T37 : 'switch' ;
T38 : '{' ;
T39 : '}' ;
T40 : 'default' ;
T41 : 'while' ;
T42 : 'case' ;
T43 : ':=' ;
T44 : 'new' ;
T45 : 'false' ;
T46 : 'null' ;
T47 : '=>' ;
T48 : '?' ;
T49 : 'extends' ;
T50 : 'super' ;
T51 : '&' ;
T52 : 'private' ;
T53 : 'final' ;
T54 : '||' ;
T55 : '&&' ;
T56 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7029
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7031
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7033
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7035
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7037
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7039
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7041
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7043
RULE_ANY_OTHER : .;


