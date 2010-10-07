lexer grammar InternalXtend2;
@header {
package org.eclipse.xtext.xtend2.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'package' ;
T12 : 'import' ;
T13 : '.' ;
T14 : '*' ;
T15 : '<' ;
T16 : ',' ;
T17 : '>' ;
T18 : 'class' ;
T19 : 'extends' ;
T20 : 'implements' ;
T21 : '{' ;
T22 : '}' ;
T23 : '(' ;
T24 : ')' ;
T25 : ':' ;
T26 : ';' ;
T27 : '=' ;
T28 : '+=' ;
T29 : '||' ;
T30 : '&&' ;
T31 : '==' ;
T32 : '!=' ;
T33 : 'instanceof' ;
T34 : '>=' ;
T35 : '<=' ;
T36 : '->' ;
T37 : '..' ;
T38 : '+' ;
T39 : '-' ;
T40 : '**' ;
T41 : '/' ;
T42 : '%' ;
T43 : '!' ;
T44 : '|' ;
T45 : 'if' ;
T46 : 'else' ;
T47 : 'switch' ;
T48 : 'default' ;
T49 : 'case' ;
T50 : 'for' ;
T51 : 'while' ;
T52 : 'do' ;
T53 : 'var' ;
T54 : 'val' ;
T55 : 'new' ;
T56 : 'false' ;
T57 : 'true' ;
T58 : 'null' ;
T59 : 'throw' ;
T60 : 'try' ;
T61 : 'finally' ;
T62 : 'catch' ;
T63 : '=>' ;
T64 : '?' ;
T65 : '&' ;
T66 : 'super' ;

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 5094
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 5096
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 5098
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 5100
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 5102
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 5104
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 5106
RULE_ANY_OTHER : .;


