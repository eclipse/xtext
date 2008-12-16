lexer grammar InternalLangATestLanguage;
@header {
package org.eclipse.xtext.crossrefs.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : 'type' ;
T13 : 'extends' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangATestLanguage.g" 226
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangATestLanguage.g" 228
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangATestLanguage.g" 230
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangATestLanguage.g" 232
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangATestLanguage.g" 234
RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangATestLanguage.g" 236
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangATestLanguage.g" 238
RULE_ANY_OTHER : .;


