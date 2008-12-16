lexer grammar InternalTestLanguage;
@header {
package org.eclipse.xtext.ui.core.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'stuff' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g" 144
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g" 146
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g" 148
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g" 150
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g" 152
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g" 154
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g" 156
RULE_ANY_OTHER : .;


