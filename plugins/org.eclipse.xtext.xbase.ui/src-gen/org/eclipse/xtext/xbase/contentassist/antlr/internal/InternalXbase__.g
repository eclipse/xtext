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
T31 : '(' ;
T32 : ')' ;
T33 : ',' ;
T34 : ':' ;
T35 : ';' ;
T36 : 'instanceof' ;
T37 : '|' ;
T38 : 'if' ;
T39 : 'else' ;
T40 : 'switch' ;
T41 : '{' ;
T42 : '}' ;
T43 : 'default' ;
T44 : 'while' ;
T45 : 'case' ;
T46 : ':=' ;
T47 : 'new' ;
T48 : 'false' ;
T49 : 'null' ;
T50 : 'class' ;
T51 : '=>' ;
T52 : '?' ;
T53 : 'extends' ;
T54 : 'super' ;
T55 : '&' ;
T56 : 'private' ;
T57 : '||' ;
T58 : '&&' ;
T59 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7293
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7295
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7297
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7299
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7301
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7303
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7305
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7307
RULE_ANY_OTHER : .;


