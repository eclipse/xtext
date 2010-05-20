lexer grammar InternalSimpleExpressions;
@header {
package org.eclipse.xtext.generator.parser.packrat.antlr.splitting.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'else' ;
T12 : 'if' ;
T13 : '(' ;
T14 : ')' ;
T15 : '{' ;
T16 : '||' ;
T17 : '&&' ;
T18 : '==' ;
T19 : '<=' ;
T20 : '>=' ;
T21 : '!' ;
T22 : ',' ;
T23 : '.' ;

// $ANTLR src "../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g" 878
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g" 880
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g" 882
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g" 884
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g" 886
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g" 888
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g" 890
RULE_ANY_OTHER : .;


