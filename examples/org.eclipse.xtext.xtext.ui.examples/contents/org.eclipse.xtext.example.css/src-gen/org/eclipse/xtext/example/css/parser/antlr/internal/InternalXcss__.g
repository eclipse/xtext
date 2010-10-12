lexer grammar InternalXcss;
@header {
package org.eclipse.xtext.example.css.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '{' ;
T12 : '}' ;
T13 : '*' ;
T14 : '[' ;
T15 : ']' ;
T16 : ';' ;
T17 : ':' ;
T18 : 'font' ;
T19 : 'I' ;
T20 : 'B' ;
T21 : '#' ;
T22 : '||' ;
T23 : '&&' ;
T24 : '==' ;
T25 : '!=' ;
T26 : 'instanceof' ;
T27 : '>=' ;
T28 : '<=' ;
T29 : '>' ;
T30 : '<' ;
T31 : '->' ;
T32 : '..' ;
T33 : '+' ;
T34 : '-' ;
T35 : '**' ;
T36 : '/' ;
T37 : '%' ;
T38 : '!' ;
T39 : '.' ;
T40 : '(' ;
T41 : ',' ;
T42 : ')' ;
T43 : '|' ;
T44 : 'if' ;
T45 : 'else' ;
T46 : 'switch' ;
T47 : 'default' ;
T48 : 'case' ;
T49 : 'for' ;
T50 : 'while' ;
T51 : 'do' ;
T52 : 'var' ;
T53 : 'val' ;
T54 : '=' ;
T55 : 'new' ;
T56 : 'false' ;
T57 : 'true' ;
T58 : 'null' ;
T59 : 'class' ;
T60 : 'throw' ;
T61 : 'try' ;
T62 : 'finally' ;
T63 : 'catch' ;
T64 : '=>' ;
T65 : '?' ;
T66 : 'extends' ;
T67 : '&' ;
T68 : 'super' ;
T69 : 'em' ;
T70 : 'pt' ;
T71 : 'px' ;

// $ANTLR src "../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g" 5389
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g" 5391
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g" 5393
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g" 5395
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g" 5397
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g" 5399
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g" 5401
RULE_ANY_OTHER : .;


