lexer grammar InternalSimpleReconstrTestLanguage;
@header {
package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '(' ;
T12 : ')' ;
T13 : '!' ;
T14 : '#' ;
T15 : '=' ;
T16 : 'type' ;
T17 : 'extends' ;
T18 : '#2' ;
T19 : 'mykeyword1' ;
T20 : 'mykeyword2' ;
T21 : '#3' ;
T22 : '.' ;
T23 : '#4' ;
T24 : 'myoption' ;
T25 : 'kw' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 799
RULE_ID : '^'? (('a'..'z'|'A'..'Z')|'_') ((('a'..'z'|'A'..'Z')|'_')|'0'..'9')*;



// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 803
RULE_INT : ('0'..'9')+;



// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 807
RULE_STRING : ('\"' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\"')))* '\"'|'\'' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\'')))* '\'');



// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 811
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';



// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 815
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;



// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 819
RULE_WS : (((' '|'\t')|'\r')|'\n')+;



// $ANTLR src "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g" 823
RULE_ANY_OTHER : .;




