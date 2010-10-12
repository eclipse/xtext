lexer grammar InternalXcss;
@header {
package org.eclipse.xtext.example.css.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : ':' ;
T12 : '||' ;
T13 : '&&' ;
T14 : 'font' ;
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
T32 : 'em' ;
T33 : 'pt' ;
T34 : 'px' ;
T35 : '{' ;
T36 : '}' ;
T37 : '[' ;
T38 : ']' ;
T39 : ';' ;
T40 : '#' ;
T41 : 'instanceof' ;
T42 : '.' ;
T43 : '(' ;
T44 : ')' ;
T45 : ',' ;
T46 : '|' ;
T47 : 'if' ;
T48 : 'else' ;
T49 : 'switch' ;
T50 : 'default' ;
T51 : 'case' ;
T52 : 'for' ;
T53 : 'while' ;
T54 : 'do' ;
T55 : '=' ;
T56 : 'new' ;
T57 : 'false' ;
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
T69 : 'I' ;
T70 : 'B' ;
T71 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.example.css.ui/src-gen/org/eclipse/xtext/example/css/ui/contentassist/antlr/internal/InternalXcss.g" 11648
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.example.css.ui/src-gen/org/eclipse/xtext/example/css/ui/contentassist/antlr/internal/InternalXcss.g" 11650
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.example.css.ui/src-gen/org/eclipse/xtext/example/css/ui/contentassist/antlr/internal/InternalXcss.g" 11652
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.example.css.ui/src-gen/org/eclipse/xtext/example/css/ui/contentassist/antlr/internal/InternalXcss.g" 11654
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.example.css.ui/src-gen/org/eclipse/xtext/example/css/ui/contentassist/antlr/internal/InternalXcss.g" 11656
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.example.css.ui/src-gen/org/eclipse/xtext/example/css/ui/contentassist/antlr/internal/InternalXcss.g" 11658
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.example.css.ui/src-gen/org/eclipse/xtext/example/css/ui/contentassist/antlr/internal/InternalXcss.g" 11660
RULE_ANY_OTHER : .;


