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
T23 : '+' ;
T24 : '-' ;
T25 : '*' ;
T26 : '/' ;
T27 : '%' ;
T28 : '->' ;
T29 : '..' ;
T30 : '!' ;
T31 : '(' ;
T32 : ')' ;
T33 : '.' ;
T34 : ',' ;
T35 : '|' ;
T36 : 'if' ;
T37 : 'else' ;
T38 : 'switch' ;
T39 : '{' ;
T40 : 'default' ;
T41 : ':' ;
T42 : '}' ;
T43 : 'while' ;
T44 : 'case' ;
T45 : ';' ;
T46 : 'def' ;
T47 : 'new' ;
T48 : 'false' ;
T49 : 'true' ;
T50 : 'null' ;
T51 : 'class' ;
T52 : '=>' ;
T53 : '?' ;
T54 : 'extends' ;
T55 : 'super' ;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3584
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3586
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3588
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3590
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3592
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3594
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3596
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g" 3598
RULE_ANY_OTHER : .;


