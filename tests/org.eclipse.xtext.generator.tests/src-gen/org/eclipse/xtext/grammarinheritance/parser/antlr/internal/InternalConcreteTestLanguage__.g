lexer grammar InternalConcreteTestLanguage;
@header {
package org.eclipse.xtext.grammarinheritance.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'model' ;
T13 : ':' ;
T14 : 'element' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 183
RULE_REAL : RULE_INT '.' RULE_INT;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 185
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'ö'|'ä'|'ü'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 187
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 189
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 191
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 193
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 195
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g" 197
RULE_ANY_OTHER : .;


