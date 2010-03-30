lexer grammar InternalArithmetics;
@header {
package org.eclipse.xtext.example.arithmetics.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : 'module' ;
T13 : 'import' ;
T14 : '.' ;
T15 : '*' ;
T16 : 'def' ;
T17 : ':' ;
T18 : ';' ;
T19 : '(' ;
T20 : ')' ;
T21 : ',' ;
T22 : '+' ;
T23 : '-' ;
T24 : '/' ;
T25 : '\u00B9' ;

// $ANTLR src "../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g" 1873
RULE_NUMBER : ('0'..'9')* ('.' ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g" 1875
RULE_INT : 'this one has been deactivated';

// $ANTLR src "../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g" 1877
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g" 1879
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g" 1881
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g" 1883
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g" 1885
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g" 1887
RULE_ANY_OTHER : .;


