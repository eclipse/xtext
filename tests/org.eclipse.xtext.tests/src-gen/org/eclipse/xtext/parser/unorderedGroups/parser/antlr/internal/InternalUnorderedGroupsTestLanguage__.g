lexer grammar InternalUnorderedGroupsTestLanguage;
@header {
package org.eclipse.xtext.parser.unorderedGroups.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '1' ;
T12 : 'a' ;
T13 : 'b' ;
T14 : '2' ;
T15 : 'c' ;
T16 : 'd' ;
T17 : '3' ;
T18 : '4' ;
T19 : '5' ;
T20 : '6' ;
T21 : '7' ;
T22 : '8' ;
T23 : '9' ;
T24 : '10' ;
T25 : '11' ;
T26 : '12' ;
T27 : '13' ;
T28 : '14' ;
T29 : 'datatypes' ;
T30 : 'serialization' ;
T31 : 'bug302585' ;
T32 : 'nested' ;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g" 3322
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g" 3324
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g" 3326
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g" 3328
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g" 3330
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g" 3332
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g" 3334
RULE_ANY_OTHER : .;


