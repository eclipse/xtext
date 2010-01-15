lexer grammar InternalXbase;
@header {
package org.eclipse.xtext.xbase.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T12 : '=' ;
T13 : '+=' ;
T14 : '==' ;
T15 : '!=' ;
T16 : '>=' ;
T17 : '<=' ;
T18 : '>' ;
T19 : '<' ;
T20 : '+' ;
T21 : '-' ;
T22 : '*' ;
T23 : '/' ;
T24 : '%' ;
T25 : '..' ;
T26 : '!' ;
T27 : 'def' ;
T28 : 'import' ;
T29 : '.' ;
T30 : '(' ;
T31 : ')' ;
T32 : ',' ;
T33 : 'if' ;
T34 : ':' ;
T35 : ';' ;
T36 : 'instanceof' ;
T37 : '|' ;
T38 : 'else' ;
T39 : 'switch' ;
T40 : '{' ;
T41 : '}' ;
T42 : 'default' ;
T43 : 'while' ;
T44 : 'case' ;
T45 : ':=' ;
T46 : 'new' ;
T47 : 'false' ;
T48 : 'null' ;
T49 : 'class' ;
T50 : '=>' ;
T51 : '?' ;
T52 : 'extends' ;
T53 : 'super' ;
T54 : '&' ;
T55 : 'private' ;
T56 : 'final' ;
T57 : '||' ;
T58 : '&&' ;
T59 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7414
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7416
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7418
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7420
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7422
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7424
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7426
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7428
RULE_ANY_OTHER : .;


