lexer grammar InternalDomainmodel;
@header {
package org.eclipse.xtext.example.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : 'package' ;
T13 : '{' ;
T14 : '}' ;
T15 : 'datatype' ;
T16 : 'entity' ;
T17 : 'extends' ;
T18 : 'attr' ;
T19 : ':' ;
T20 : 'ref' ;
T21 : 'opposite' ;
T22 : 'op' ;
T23 : '(' ;
T24 : ',' ;
T25 : ')' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g" 886
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ('.' ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*)*;

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g" 888
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g" 890
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g" 892
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g" 894
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g" 896
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g" 898
RULE_ANY_OTHER : .;


