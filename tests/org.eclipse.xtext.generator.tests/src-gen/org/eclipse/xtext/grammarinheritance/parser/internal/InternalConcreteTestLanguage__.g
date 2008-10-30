lexer grammar InternalConcreteTestLanguage;
@header {
package org.eclipse.xtext.grammarinheritance.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'model' ;
T13 : ':' ;
T14 : 'element' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g" 155
RULE_REAL : RULE_INT '.' RULE_INT;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g" 157
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'ö'|'ä'|'ü'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g" 159
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g" 161
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g" 163
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g" 165
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g" 167
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g" 169
RULE_ANY_OTHER : .;


