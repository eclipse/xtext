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
T45 : ';' ;
T46 : 'case' ;
T47 : 'for' ;
T48 : 'while' ;
T49 : 'do' ;
T50 : 'new' ;
T51 : 'false' ;
T52 : 'null' ;
T53 : 'class' ;
T54 : 'throw' ;
T55 : 'try' ;
T56 : 'finally' ;
T57 : 'catch' ;
T58 : '=>' ;
T59 : '?' ;
T60 : 'extends' ;
T61 : '&' ;
T62 : 'super' ;
T63 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 9847
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 9849
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 9851
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 9853
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 9855
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 9857
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 9859
RULE_ANY_OTHER : .;


