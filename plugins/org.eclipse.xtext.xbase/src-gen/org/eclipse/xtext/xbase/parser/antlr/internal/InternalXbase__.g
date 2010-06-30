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
T15 : 'class' ;
T16 : 'extends' ;
T17 : 'implements' ;
T18 : '{' ;
T19 : '}' ;
T20 : 'private' ;
T21 : '<' ;
T22 : ',' ;
T23 : '>' ;
T24 : '(' ;
T25 : ')' ;
T26 : ':' ;
T27 : ';' ;
T28 : '=' ;
T29 : '+=' ;
T30 : '||' ;
T31 : '&&' ;
T32 : '==' ;
T33 : '!=' ;
T34 : 'instanceof' ;
T35 : '>=' ;
T36 : '<=' ;
T37 : '->' ;
T38 : '..' ;
T39 : '+' ;
T40 : '-' ;
T41 : '**' ;
T42 : '/' ;
T43 : '%' ;
T44 : '!' ;
T45 : '|' ;
T46 : 'if' ;
T47 : 'else' ;
T48 : 'switch' ;
T49 : 'default' ;
T50 : 'while' ;
T51 : 'case' ;
T52 : 'def' ;
T53 : 'new' ;
T54 : 'false' ;
T55 : 'true' ;
T56 : 'null' ;
T57 : '=>' ;
T58 : '?' ;
T59 : '&' ;
T60 : 'super' ;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4517
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4519
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4521
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4523
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4525
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4527
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4529
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4531
RULE_ANY_OTHER : .;


