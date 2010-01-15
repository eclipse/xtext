lexer grammar InternalXbase;
@header {
package org.eclipse.xtext.xbase.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'import' ;
T13 : '.' ;
T14 : '*' ;
T15 : 'private' ;
T16 : 'final' ;
T17 : '<' ;
T18 : ',' ;
T19 : '>' ;
T20 : '(' ;
T21 : ')' ;
T22 : 'if' ;
T23 : ':' ;
T24 : ';' ;
T25 : '=' ;
T26 : '+=' ;
T27 : '||' ;
T28 : '&&' ;
T29 : '==' ;
T30 : '!=' ;
T31 : 'instanceof' ;
T32 : '>=' ;
T33 : '<=' ;
T34 : '+' ;
T35 : '-' ;
T36 : '/' ;
T37 : '%' ;
T38 : '..' ;
T39 : '!' ;
T40 : '|' ;
T41 : 'else' ;
T42 : 'switch' ;
T43 : '{' ;
T44 : 'default' ;
T45 : '}' ;
T46 : 'while' ;
T47 : 'case' ;
T48 : 'def' ;
T49 : ':=' ;
T50 : 'new' ;
T51 : 'false' ;
T52 : 'true' ;
T53 : 'null' ;
T54 : 'class' ;
T55 : '=>' ;
T56 : '?' ;
T57 : 'extends' ;
T58 : 'super' ;
T59 : '&' ;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4201
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4203
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4205
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4207
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4209
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4211
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4213
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4215
RULE_ANY_OTHER : .;


