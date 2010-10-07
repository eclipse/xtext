lexer grammar InternalXbase;
@header {
package org.eclipse.xtext.xbase.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '=' ;
T12 : '+=' ;
T13 : '||' ;
T14 : '&&' ;
T15 : '==' ;
T16 : '!=' ;
T17 : 'instanceof' ;
T18 : '>=' ;
T19 : '<=' ;
T20 : '>' ;
T21 : '<' ;
T22 : '->' ;
T23 : '..' ;
T24 : '+' ;
T25 : '-' ;
T26 : '*' ;
T27 : '**' ;
T28 : '/' ;
T29 : '%' ;
T30 : '!' ;
T31 : '.' ;
T32 : '(' ;
T33 : ',' ;
T34 : ')' ;
T35 : '|' ;
T36 : 'if' ;
T37 : 'else' ;
T38 : 'switch' ;
T39 : '{' ;
T40 : 'default' ;
T41 : ':' ;
T42 : ';' ;
T43 : '}' ;
T44 : 'case' ;
T45 : 'while' ;
T46 : 'do' ;
T47 : 'var' ;
T48 : 'val' ;
T49 : 'new' ;
T50 : 'false' ;
T51 : 'true' ;
T52 : 'null' ;
T53 : 'class' ;
T54 : 'throw' ;
T55 : 'try' ;
T56 : 'finally' ;
T57 : 'catch' ;
T58 : '=>' ;
T59 : '?' ;
T60 : 'extends' ;
T61 : '&' ;
T62 : 'super' ;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4174
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4176
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4178
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4180
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4182
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4184
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 4186
RULE_ANY_OTHER : .;


