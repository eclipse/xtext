lexer grammar InternalLexerLanguage;
@header {
package org.eclipse.xtext.lexer.parser.internal;
}

// $ANTLR src "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g" 181
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g" 183
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g" 185
RULE_IMPLICITTOKENTYPE :  ('C')+ ;

// $ANTLR src "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g" 187
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g" 189
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g" 191
RULE_STRING :  ('B')+ ;

// $ANTLR src "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g" 193
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g" 195
RULE_EXPLICITTOKENTYPE :  ('A')+ ;

// $ANTLR src "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g" 197
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g" 199
RULE_ANY_OTHER : .;


