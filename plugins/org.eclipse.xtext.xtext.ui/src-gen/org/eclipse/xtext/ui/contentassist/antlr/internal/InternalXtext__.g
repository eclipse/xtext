lexer grammar InternalXtext;
@header {
package org.eclipse.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : '?' ;
T12 : '*' ;
T13 : '+' ;
T14 : '=' ;
T15 : '+=' ;
T16 : '?=' ;
T17 : 'grammar' ;
T18 : 'with' ;
T19 : ',' ;
T20 : '(' ;
T21 : ')' ;
T22 : '.' ;
T23 : 'generate' ;
T24 : 'as' ;
T25 : 'import' ;
T26 : ':' ;
T27 : ';' ;
T28 : 'returns' ;
T29 : '::' ;
T30 : '|' ;
T31 : '&' ;
T32 : '{' ;
T33 : '}' ;
T34 : 'current' ;
T35 : '[' ;
T36 : ']' ;
T37 : 'terminal' ;
T38 : '!' ;
T39 : '->' ;
T40 : '..' ;
T41 : 'enum' ;
T42 : 'hidden' ;

// $ANTLR src "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g" 5503
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g" 5505
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g" 5507
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g" 5509
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g" 5511
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g" 5513
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g" 5515
RULE_ANY_OTHER : .;


