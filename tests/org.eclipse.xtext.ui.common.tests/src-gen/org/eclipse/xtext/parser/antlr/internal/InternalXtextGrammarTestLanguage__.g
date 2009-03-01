lexer grammar InternalXtextGrammarTestLanguage;
@header {
package org.eclipse.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'grammar' ;
T12 : 'extends' ;
T13 : 'hidden' ;
T14 : '(' ;
T15 : ',' ;
T16 : ')' ;
T17 : '.' ;
T18 : 'generate' ;
T19 : 'as' ;
T20 : 'import' ;
T21 : 'native' ;
T22 : 'lexer' ;
T23 : 'returns' ;
T24 : ':' ;
T25 : ';' ;
T26 : 'terminal' ;
T27 : '::' ;
T28 : '|' ;
T29 : '?' ;
T30 : '*' ;
T31 : '+' ;
T32 : '+=' ;
T33 : '=' ;
T34 : '?=' ;
T35 : '{' ;
T36 : 'current' ;
T37 : '}' ;
T38 : '!' ;
T39 : '->' ;
T40 : '..' ;
T41 : '[' ;
T42 : ']' ;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g" 2327
RULE_ID : '^'? (('a'..'z'|'A'..'Z')|'_') ((('a'..'z'|'A'..'Z')|'_')|'0'..'9')*;



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g" 2331
RULE_INT : ('0'..'9')+;



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g" 2335
RULE_STRING : ('\"' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\"')))* '\"'|'\'' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\'')))* '\'');



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g" 2339
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g" 2343
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g" 2347
RULE_WS : (((' '|'\t')|'\r')|'\n')+;



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g" 2351
RULE_ANY_OTHER : .;




