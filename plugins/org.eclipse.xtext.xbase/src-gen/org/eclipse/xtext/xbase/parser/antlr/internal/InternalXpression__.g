lexer grammar InternalXpression;
@header {
package org.eclipse.xtext.xbase.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : '=' ;
T13 : '+=' ;
T14 : '||' ;
T15 : '&&' ;
T16 : '==' ;
T17 : '!=' ;
T18 : 'instanceof' ;
T19 : '>=' ;
T20 : '<=' ;
T21 : '>' ;
T22 : '<' ;
T23 : '->' ;
T24 : '..' ;
T25 : '+' ;
T26 : '-' ;
T27 : '*' ;
T28 : '**' ;
T29 : '/' ;
T30 : '%' ;
T31 : '!' ;
T32 : '(' ;
T33 : ')' ;
T34 : '.' ;
T35 : ',' ;
T36 : '|' ;
T37 : 'if' ;
T38 : 'else' ;
T39 : 'switch' ;
T40 : '{' ;
T41 : 'default' ;
T42 : ':' ;
T43 : '}' ;
T44 : 'while' ;
T45 : 'case' ;
T46 : ';' ;
T47 : 'def' ;
T48 : 'new' ;
T49 : 'false' ;
T50 : 'true' ;
T51 : 'null' ;
T52 : 'class' ;
T53 : '=>' ;
T54 : '?' ;
T55 : 'extends' ;
T56 : '&' ;
T57 : 'super' ;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3799
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3801
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3803
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3805
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3807
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3809
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3811
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3813
RULE_ANY_OTHER : .;


