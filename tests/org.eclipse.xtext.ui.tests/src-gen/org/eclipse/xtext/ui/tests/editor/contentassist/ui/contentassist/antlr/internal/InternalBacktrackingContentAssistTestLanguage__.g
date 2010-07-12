lexer grammar InternalBacktrackingContentAssistTestLanguage;
@header {
package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : '.' ;
T12 : '->' ;
T13 : '^^' ;
T14 : '^' ;
T15 : 'e' ;
T16 : 'E' ;
T17 : '+' ;
T18 : '-' ;
T19 : 'Boolean' ;
T20 : 'Integer' ;
T21 : 'Real' ;
T22 : 'String' ;
T23 : 'UnlimitedNatural' ;
T24 : 'OclAny' ;
T25 : 'OclInvalid' ;
T26 : 'OclVoid' ;
T27 : 'Set' ;
T28 : 'Bag' ;
T29 : 'Sequence' ;
T30 : 'Collection' ;
T31 : 'OrderedSet' ;
T32 : 'false' ;
T33 : '=' ;
T34 : '<>' ;
T35 : '>' ;
T36 : '<' ;
T37 : '>=' ;
T38 : '<=' ;
T39 : '*' ;
T40 : '/' ;
T41 : 'not' ;
T42 : 'body' ;
T43 : ':' ;
T44 : 'context' ;
T45 : 'def' ;
T46 : '(' ;
T47 : ')' ;
T48 : ',' ;
T49 : 'derive' ;
T50 : 'init' ;
T51 : 'inv' ;
T52 : 'package' ;
T53 : 'endpackage' ;
T54 : 'post' ;
T55 : 'pre' ;
T56 : '::' ;
T57 : '?' ;
T58 : '{' ;
T59 : '}' ;
T60 : '..' ;
T61 : 'Tuple' ;
T62 : 'invalid' ;
T63 : 'null' ;
T64 : '@' ;
T65 : '|' ;
T66 : ';' ;
T67 : '[' ;
T68 : ']' ;
T69 : 'self' ;
T70 : 'if' ;
T71 : 'then' ;
T72 : 'else' ;
T73 : 'endif' ;
T74 : 'let' ;
T75 : 'in' ;
T76 : 'static' ;
T77 : 'true' ;
T78 : 'implies' ;
T79 : 'xor' ;
T80 : 'or' ;
T81 : 'and' ;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 14653
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 14655
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 14657
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 14659
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 14661
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 14663
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g" 14665
RULE_ANY_OTHER : .;


