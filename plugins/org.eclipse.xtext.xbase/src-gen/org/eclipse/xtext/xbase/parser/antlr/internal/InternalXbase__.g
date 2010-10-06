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
T42 : '}' ;
T43 : 'case' ;
T44 : 'while' ;
T45 : 'do' ;
T46 : ';' ;
T47 : 'var' ;
T48 : 'val' ;
T49 : 'new' ;
T50 : 'false' ;
T51 : 'true' ;
T52 : 'null' ;
T53 : 'class' ;
T54 : '=>' ;
T55 : '?' ;
T56 : 'extends' ;
T57 : '&' ;
T58 : 'super' ;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3829
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3831
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3833
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3835
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3837
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3839
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g" 3841
RULE_ANY_OTHER : .;


