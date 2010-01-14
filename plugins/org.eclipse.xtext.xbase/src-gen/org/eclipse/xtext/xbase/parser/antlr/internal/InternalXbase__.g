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
T25 : '|' ;
T26 : '=' ;
T27 : '||' ;
T28 : '&&' ;
T29 : '==' ;
T30 : '!=' ;
T31 : '>=' ;
T32 : '<=' ;
T33 : '+' ;
T34 : '-' ;
T35 : '/' ;
T36 : '+=' ;
T37 : '..' ;
T38 : '!' ;
T39 : 'else' ;
T40 : 'switch' ;
T41 : '{' ;
T42 : 'default' ;
T43 : '}' ;
T44 : 'while' ;
T45 : 'case' ;
T46 : 'def' ;
T47 : ':=' ;
T48 : 'new' ;
T49 : 'false' ;
T50 : 'true' ;
T51 : 'null' ;
T52 : '=>' ;
T53 : '?' ;
T54 : 'extends' ;
T55 : 'super' ;
T56 : '&' ;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3972
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3974
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3976
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3978
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3980
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3982
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3984
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3986
RULE_ANY_OTHER : .;


