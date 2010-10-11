lexer grammar InternalXtend2;
@header {
package org.eclipse.xtext.xtend2.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : '||' ;
T12 : '&&' ;
T13 : '=' ;
T14 : '+=' ;
T15 : '==' ;
T16 : '!=' ;
T17 : '>=' ;
T18 : '<=' ;
T19 : '>' ;
T20 : '<' ;
T21 : '->' ;
T22 : '..' ;
T23 : '+' ;
T24 : '-' ;
T25 : '*' ;
T26 : '**' ;
T27 : '/' ;
T28 : '%' ;
T29 : '!' ;
T30 : 'var' ;
T31 : 'val' ;
T32 : 'package' ;
T33 : 'import' ;
T34 : '.' ;
T35 : 'class' ;
T36 : '{' ;
T37 : '}' ;
T38 : ',' ;
T39 : 'extends' ;
T40 : 'implements' ;
T41 : '(' ;
T42 : ')' ;
T43 : ':' ;
T44 : ';' ;
T45 : 'instanceof' ;
T46 : '|' ;
T47 : 'if' ;
T48 : 'else' ;
T49 : 'switch' ;
T50 : 'default' ;
T51 : 'case' ;
T52 : 'for' ;
T53 : 'while' ;
T54 : 'do' ;
T55 : 'new' ;
T56 : 'false' ;
T57 : 'null' ;
T58 : 'throw' ;
T59 : 'try' ;
T60 : 'finally' ;
T61 : 'catch' ;
T62 : '=>' ;
T63 : '?' ;
T64 : '&' ;
T65 : 'super' ;
T66 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g" 12047
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g" 12049
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g" 12051
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g" 12053
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g" 12055
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g" 12057
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g" 12059
RULE_ANY_OTHER : .;


