lexer grammar InternalXbase;
@header {
package org.eclipse.xtext.xbase.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '||' ;
T13 : '&&' ;
T14 : '=' ;
T15 : '+=' ;
T16 : '==' ;
T17 : '!=' ;
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
T31 : 'package' ;
T32 : 'import' ;
T33 : '.' ;
T34 : 'class' ;
T35 : '{' ;
T36 : '}' ;
T37 : ',' ;
T38 : 'extends' ;
T39 : 'implements' ;
T40 : '(' ;
T41 : ')' ;
T42 : ':' ;
T43 : ';' ;
T44 : 'instanceof' ;
T45 : '|' ;
T46 : 'if' ;
T47 : 'else' ;
T48 : 'switch' ;
T49 : 'default' ;
T50 : 'while' ;
T51 : 'case' ;
T52 : 'def' ;
T53 : 'new' ;
T54 : 'false' ;
T55 : 'null' ;
T56 : '=>' ;
T57 : '?' ;
T58 : '&' ;
T59 : 'super' ;
T60 : 'true' ;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 10956
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'\u00AB'|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 10958
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 10960
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 10962
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 10964
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 10966
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 10968
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/ui/contentassist/antlr/internal/InternalXbase.g" 10970
RULE_ANY_OTHER : .;


