lexer grammar InternalLexerLanguage;
@members {

  public Token nextToken() {
        while (true) {
            this.token = null;
            this.channel = Token.DEFAULT_CHANNEL;
            this.tokenStartCharIndex = input.index();
            this.tokenStartCharPositionInLine = input.getCharPositionInLine();
            this.tokenStartLine = input.getLine();
            this.text = null;
            if ( input.LA(1)==CharStream.EOF ) {
                return Token.EOF_TOKEN;
            }
            try {
                mTokens();
                if ( this.token==null ) {
                    emit();
                }
                else if ( this.token==Token.SKIP_TOKEN ) {
                    continue;
                }
                return this.token;
            }
            catch (RecognitionException re) {
                reportError(re);
                if ( re instanceof NoViableAltException ) { recover(re); }
                                // create token that holds mismatched char
                Token t = new CommonToken(input, Token.INVALID_TOKEN_TYPE,
                                          Token.HIDDEN_CHANNEL,
                                          this.tokenStartCharIndex,
                                          getCharIndex()-1);
                t.setLine(this.tokenStartLine);
                t.setCharPositionInLine(this.tokenStartCharPositionInLine);
                emit(t);
                return this.token;
            }
        }
    }
}
@header {
package org.eclipse.xtext.testlanguages.parser.internal;
}

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 323
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 325
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 327
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 329
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 331
RULE_EXPLICITTOKENTYPE :  '#' ('A')+ ;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 333
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 335
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 337
RULE_STRING :  '#' ('B')+ ;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 339
RULE_IMPLICITTOKENTYPE :  '#' ('C')+ ;

// $ANTLR src "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g" 341
RULE_ANY_OTHER : .;


