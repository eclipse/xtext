lexer grammar InternalTestLanguage;
@header {
package org.eclipse.xtext.ui.core.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'stuff' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g" 160
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g" 162
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g" 164
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g" 166
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g" 168
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g" 170
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g" 172
RULE_ANY_OTHER : .;


