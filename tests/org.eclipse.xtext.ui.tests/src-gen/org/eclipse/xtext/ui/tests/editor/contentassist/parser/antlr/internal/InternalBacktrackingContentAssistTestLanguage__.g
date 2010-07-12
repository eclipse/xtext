lexer grammar InternalBacktrackingContentAssistTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'body' ;
T12 : ':' ;
T13 : 'context' ;
T14 : 'static' ;
T15 : 'def' ;
T16 : '(' ;
T17 : ',' ;
T18 : ')' ;
T19 : '=' ;
T20 : 'derive' ;
T21 : 'init' ;
T22 : 'inv' ;
T23 : 'package' ;
T24 : 'endpackage' ;
T25 : 'post' ;
T26 : 'pre' ;
T27 : '::' ;
T28 : '.' ;
T29 : '->' ;
T30 : '^^' ;
T31 : '^' ;
T32 : '?' ;
T33 : 'e' ;
T34 : 'E' ;
T35 : '+' ;
T36 : '-' ;
T37 : 'Boolean' ;
T38 : 'Integer' ;
T39 : 'Real' ;
T40 : 'String' ;
T41 : 'UnlimitedNatural' ;
T42 : 'OclAny' ;
T43 : 'OclInvalid' ;
T44 : 'OclVoid' ;
T45 : 'Set' ;
T46 : 'Bag' ;
T47 : 'Sequence' ;
T48 : 'Collection' ;
T49 : 'OrderedSet' ;
T50 : 'Tuple' ;
T51 : '{' ;
T52 : '}' ;
T53 : '..' ;
T54 : 'true' ;
T55 : 'false' ;
T56 : 'invalid' ;
T57 : 'null' ;
T58 : 'implies' ;
T59 : 'xor' ;
T60 : 'or' ;
T61 : 'and' ;
T62 : '<>' ;
T63 : '>' ;
T64 : '<' ;
T65 : '>=' ;
T66 : '<=' ;
T67 : '*' ;
T68 : '/' ;
T69 : 'not' ;
T70 : '@' ;
T71 : ';' ;
T72 : '|' ;
T73 : '[' ;
T74 : ']' ;
T75 : 'self' ;
T76 : 'if' ;
T77 : 'then' ;
T78 : 'else' ;
T79 : 'endif' ;
T80 : 'let' ;
T81 : 'in' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 6917
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 6919
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 6921
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 6923
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 6925
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 6927
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 6929
RULE_ANY_OTHER : .;


