lexer grammar InternalXtextTerminalsTestLanguage;
@header {
package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'abstract language' ;
T12 : 'language' ;
T13 : '.' ;
T14 : 'extends' ;
T15 : 'generate' ;
T16 : 'as' ;
T17 : 'import' ;
T18 : 'native' ;
T19 : 'lexer' ;
T20 : 'returns' ;
T21 : ':' ;
T22 : ';' ;
T23 : 'hidden' ;
T24 : '(' ;
T25 : ',' ;
T26 : ')' ;
T27 : 'terminal' ;
T28 : '::' ;
T29 : '|' ;
T30 : '?' ;
T31 : '*' ;
T32 : '+' ;
T33 : '+=' ;
T34 : '=' ;
T35 : '?=' ;
T36 : '{' ;
T37 : 'current' ;
T38 : '}' ;
T39 : '!' ;
T40 : '->' ;
T41 : '..' ;
T42 : '[' ;
T43 : ']' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g" 2237
RULE_ID : '^'? (('a'..'z'|'A'..'Z')|'_') ((('a'..'z'|'A'..'Z')|'_')|'0'..'9')*;



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g" 2241
RULE_INT : ('0'..'9')+;



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g" 2245
RULE_STRING : ('\"' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\"')))* '\"'|'\'' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\'')))* '\'');



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g" 2249
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g" 2253
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g" 2257
RULE_WS : (((' '|'\t')|'\r')|'\n')+;



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g" 2261
RULE_ANY_OTHER : .;




