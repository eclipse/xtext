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
T50 : 'while' ;
T51 : 'var' ;
T52 : 'val' ;
T53 : 'new' ;
T54 : 'false' ;
T55 : 'true' ;
T56 : 'null' ;
T57 : '=>' ;
T58 : '?' ;
T59 : '&' ;
T60 : 'super' ;

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 4525
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 4527
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 4529
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 4531
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 4533
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 4535
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g" 4537
RULE_ANY_OTHER : .;


