lexer grammar InternalTerminalRulesTestLanguage;
@header {
package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g" 265
RULE_ID : '^'? (('a'..'z'|'A'..'Z')|'_') ((('a'..'z'|'A'..'Z')|'_')|'0'..'9')*;



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g" 269
RULE_INT : ('0'..'9')+;



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g" 273
RULE_STRING : ('\"' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\"')))* '\"'|'\'' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\'')))* '\'');



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g" 277
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g" 281
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g" 285
RULE_WS : (((' '|'\t')|'\r')|'\n')+;



// $ANTLR src "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g" 289
RULE_ANY_OTHER : .;




