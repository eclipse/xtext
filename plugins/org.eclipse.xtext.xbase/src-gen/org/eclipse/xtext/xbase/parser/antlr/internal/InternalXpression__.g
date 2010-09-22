lexer grammar InternalXpression;
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
T42 : '}' ;
T43 : 'case' ;
T44 : 'while' ;
T45 : ';' ;
T46 : 'var' ;
T47 : 'val' ;
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

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3729
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3731
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3733
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3735
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3737
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3739
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3741
RULE_ANY_OTHER : .;


