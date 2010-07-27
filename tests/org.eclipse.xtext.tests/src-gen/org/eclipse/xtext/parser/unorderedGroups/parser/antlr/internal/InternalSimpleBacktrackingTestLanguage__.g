lexer grammar InternalSimpleBacktrackingTestLanguage;
@header {
package org.eclipse.xtext.parser.unorderedGroups.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T13 : 'unit' ;
T14 : 'version' ;
T15 : 'implements' ;
T16 : ',' ;
T17 : '{' ;
T18 : 'source' ;
T19 : ':' ;
T20 : ';' ;
T21 : 'output' ;
T22 : 'provides' ;
T23 : 'requires' ;
T24 : 'env' ;
T25 : '}' ;
T26 : 'when' ;
T27 : 'name' ;
T28 : 'as' ;
T29 : 'greedy' ;
T30 : 'requires-min' ;
T31 : 'requires-max' ;
T32 : '/' ;
T33 : 'final' ;
T34 : 'function' ;
T35 : '(' ;
T36 : '...' ;
T37 : ')' ;
T38 : '=' ;
T39 : '+=' ;
T40 : '-=' ;
T41 : '*=' ;
T42 : '/=' ;
T43 : '%=' ;
T44 : '~=' ;
T45 : '==' ;
T46 : '===' ;
T47 : '!=' ;
T48 : '!==' ;
T49 : '>=' ;
T50 : '<=' ;
T51 : '>' ;
T52 : '<' ;
T53 : 'var' ;
T54 : 'val' ;
T55 : '=>' ;
T56 : 'cached' ;
T57 : '||' ;
T58 : '&&' ;
T59 : '+' ;
T60 : '-' ;
T61 : '*' ;
T62 : '%' ;
T63 : '..' ;
T64 : '!' ;
T65 : '++' ;
T66 : '--' ;
T67 : '.' ;
T68 : '[' ;
T69 : ']' ;
T70 : 'with' ;
T71 : 'context' ;
T72 : 'input' ;
T73 : 'properties' ;
T74 : 'builder' ;
T75 : 'this' ;
T76 : 'new' ;
T77 : '|' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleBacktrackingTestLanguage.g" 6797
RULE_DOCUMENTATION : '/**' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleBacktrackingTestLanguage.g" 6799
RULE_HEX : '0' ('x'|'X') ('0'..'9'|'a'..'f'|'A'..'F')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleBacktrackingTestLanguage.g" 6801
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleBacktrackingTestLanguage.g" 6803
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleBacktrackingTestLanguage.g" 6805
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleBacktrackingTestLanguage.g" 6807
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleBacktrackingTestLanguage.g" 6809
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleBacktrackingTestLanguage.g" 6811
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleBacktrackingTestLanguage.g" 6813
RULE_ANY_OTHER : .;


