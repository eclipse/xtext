lexer grammar InternalSimpleBeeLangTestLanguage;
@header {
package org.eclipse.xtext.testlanguages.backtracking.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T13 : 'unit' ;
T14 : '=' ;
T15 : '+=' ;
T16 : '-=' ;
T17 : '*=' ;
T18 : '/=' ;
T19 : '%=' ;
T20 : '~=' ;
T21 : '==' ;
T22 : '===' ;
T23 : '!=' ;
T24 : '!==' ;
T25 : '>=' ;
T26 : '<=' ;
T27 : '>' ;
T28 : '<' ;
T29 : 'var' ;
T30 : '+' ;
T31 : '-' ;
T32 : '*' ;
T33 : '/' ;
T34 : '%' ;
T35 : '!' ;
T36 : '++' ;
T37 : '--' ;
T38 : 'input' ;
T39 : 'output' ;
T40 : 'source' ;
T41 : 'properties' ;
T42 : 'builder' ;
T43 : 'this' ;
T44 : '{' ;
T45 : '}' ;
T46 : 'version' ;
T47 : 'implements' ;
T48 : ',' ;
T49 : ':' ;
T50 : ';' ;
T51 : 'provides' ;
T52 : 'requires' ;
T53 : 'env' ;
T54 : 'when' ;
T55 : 'name' ;
T56 : 'as' ;
T57 : 'requires-min' ;
T58 : 'requires-max' ;
T59 : 'function' ;
T60 : '(' ;
T61 : ')' ;
T62 : '=>' ;
T63 : 'cached' ;
T64 : '||' ;
T65 : '&&' ;
T66 : '.' ;
T67 : '[' ;
T68 : ']' ;
T69 : 'with' ;
T70 : 'context' ;
T71 : 'new' ;
T72 : '|' ;
T73 : 'greedy' ;
T74 : 'final' ;
T75 : '...' ;
T76 : 'val' ;
T77 : '..' ;

// $ANTLR src "../org.eclipse.xtext.testlanguages.ui/src-gen/org/eclipse/xtext/testlanguages/backtracking/ui/contentassist/antlr/internal/InternalSimpleBeeLangTestLanguage.g" 16395
RULE_DOCUMENTATION : '/**' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.testlanguages.ui/src-gen/org/eclipse/xtext/testlanguages/backtracking/ui/contentassist/antlr/internal/InternalSimpleBeeLangTestLanguage.g" 16397
RULE_HEX : '0' ('x'|'X') ('0'..'9'|'a'..'f'|'A'..'F')+;

// $ANTLR src "../org.eclipse.xtext.testlanguages.ui/src-gen/org/eclipse/xtext/testlanguages/backtracking/ui/contentassist/antlr/internal/InternalSimpleBeeLangTestLanguage.g" 16399
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.testlanguages.ui/src-gen/org/eclipse/xtext/testlanguages/backtracking/ui/contentassist/antlr/internal/InternalSimpleBeeLangTestLanguage.g" 16401
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.testlanguages.ui/src-gen/org/eclipse/xtext/testlanguages/backtracking/ui/contentassist/antlr/internal/InternalSimpleBeeLangTestLanguage.g" 16403
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.testlanguages.ui/src-gen/org/eclipse/xtext/testlanguages/backtracking/ui/contentassist/antlr/internal/InternalSimpleBeeLangTestLanguage.g" 16405
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.testlanguages.ui/src-gen/org/eclipse/xtext/testlanguages/backtracking/ui/contentassist/antlr/internal/InternalSimpleBeeLangTestLanguage.g" 16407
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.testlanguages.ui/src-gen/org/eclipse/xtext/testlanguages/backtracking/ui/contentassist/antlr/internal/InternalSimpleBeeLangTestLanguage.g" 16409
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.testlanguages.ui/src-gen/org/eclipse/xtext/testlanguages/backtracking/ui/contentassist/antlr/internal/InternalSimpleBeeLangTestLanguage.g" 16411
RULE_ANY_OTHER : .;


