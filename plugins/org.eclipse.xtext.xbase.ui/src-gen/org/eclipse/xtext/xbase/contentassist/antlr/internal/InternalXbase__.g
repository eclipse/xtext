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
T20 : '->' ;
T21 : '..' ;
T22 : '+' ;
T23 : '-' ;
T24 : '*' ;
T25 : '**' ;
T26 : '/' ;
T27 : '%' ;
T28 : '!' ;
T29 : 'def' ;
T30 : 'import' ;
T31 : '.' ;
T32 : 'class' ;
T33 : '{' ;
T34 : '}' ;
T35 : 'extends' ;
T36 : 'implements' ;
T37 : '(' ;
T38 : ')' ;
T39 : ',' ;
T40 : ':' ;
T41 : ';' ;
T42 : 'instanceof' ;
T43 : '|' ;
T44 : 'if' ;
T45 : 'else' ;
T46 : 'switch' ;
T47 : 'default' ;
T48 : 'while' ;
T49 : 'case' ;
T50 : 'new' ;
T51 : 'false' ;
T52 : 'null' ;
T53 : '=>' ;
T54 : '?' ;
T55 : 'super' ;
T56 : '&' ;
T57 : 'private' ;
T58 : '||' ;
T59 : '&&' ;
T60 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7651
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7653
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7655
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7657
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7659
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7661
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7663
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g" 7665
RULE_ANY_OTHER : .;


