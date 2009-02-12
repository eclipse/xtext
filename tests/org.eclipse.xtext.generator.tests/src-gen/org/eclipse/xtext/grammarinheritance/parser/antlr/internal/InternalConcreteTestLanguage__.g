lexer grammar InternalConcreteTestLanguage;
@header {
package org.eclipse.xtext.grammarinheritance.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'model' ;
T13 : ':' ;
T14 : 'overriddenelement' ;
T15 : 'overridden other element' ;
T16 : '-' ;
T17 : 'subrule1' ;
T18 : 'subrule3' ;
T19 : 'element' ;
T20 : 'overridemodel' ;
T21 : 'extendedmodel' ;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 816
RULE_REAL : RULE_INT '.' RULE_INT;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 818
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'ö'|'ä'|'ü'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 820
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 822
RULE_STRING : 
			  '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | 
              '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\''
              ;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 827
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/';

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 829
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 831
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 833
RULE_ANY_OTHER : .;


