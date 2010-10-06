lexer grammar InternalXbase;
@header {
package org.eclipse.xtext.xbase.ui.contentassist.antlr.internal;

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
T32 : 'instanceof' ;
T33 : '.' ;
T34 : '(' ;
T35 : ')' ;
T36 : ',' ;
T37 : '|' ;
T38 : 'if' ;
T39 : 'else' ;
T40 : 'switch' ;
T41 : '{' ;
T42 : '}' ;
T43 : 'default' ;
T44 : ':' ;
T45 : 'case' ;
T46 : 'while' ;
T47 : 'do' ;
T48 : ';' ;
T49 : 'new' ;
T50 : 'false' ;
T51 : 'null' ;
T52 : 'class' ;
T53 : '=>' ;
T54 : '?' ;
T55 : 'extends' ;
T56 : '&' ;
T57 : 'super' ;
T58 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 8508
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 8510
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 8512
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 8514
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 8516
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 8518
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 8520
RULE_ANY_OTHER : .;


