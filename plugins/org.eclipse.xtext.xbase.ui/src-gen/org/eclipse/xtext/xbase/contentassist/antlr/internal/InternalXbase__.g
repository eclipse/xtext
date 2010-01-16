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
T25 : '->' ;
T26 : '..' ;
T27 : '!' ;
T28 : 'def' ;
T29 : 'import' ;
T30 : '.' ;
T31 : 'class' ;
T32 : '{' ;
T33 : '}' ;
T34 : 'extends' ;
T35 : 'implements' ;
T36 : '(' ;
T37 : ')' ;
T38 : ',' ;
T39 : ':' ;
T40 : ';' ;
T41 : 'instanceof' ;
T42 : '|' ;
T43 : 'if' ;
T44 : 'else' ;
T45 : 'switch' ;
T46 : 'default' ;
T47 : 'while' ;
T48 : 'case' ;
T49 : 'new' ;
T50 : 'false' ;
T51 : 'null' ;
T52 : '=>' ;
T53 : '?' ;
T54 : 'super' ;
T55 : '&' ;
T56 : 'private' ;
T57 : '||' ;
T58 : '&&' ;
T59 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7643
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7645
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7647
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7649
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7651
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7653
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7655
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7657
RULE_ANY_OTHER : .;


