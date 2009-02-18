lexer grammar InternalXtextBuiltin;
@header {
package org.eclipse.xtext.builtin.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/builtin/parser/antlr/internal/InternalXtextBuiltin.g" 69
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/builtin/parser/antlr/internal/InternalXtextBuiltin.g" 71
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/builtin/parser/antlr/internal/InternalXtextBuiltin.g" 73
RULE_STRING : 
			  '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | 
              '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\''
              ;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/builtin/parser/antlr/internal/InternalXtextBuiltin.g" 78
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/';

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/builtin/parser/antlr/internal/InternalXtextBuiltin.g" 80
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/builtin/parser/antlr/internal/InternalXtextBuiltin.g" 82
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext/src-gen/org/eclipse/xtext/builtin/parser/antlr/internal/InternalXtextBuiltin.g" 84
RULE_ANY_OTHER : .;


