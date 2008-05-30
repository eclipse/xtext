lexer grammar InternalComplexReconstrTest;
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
package org.eclipse.xtext.parsetree.reconstr.parser.internal;
}

T12 : '+' ;
T13 : '-' ;
T14 : '(' ;
T15 : ')' ;
T16 : '!' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 231
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 233
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 235
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 237
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 239
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 241
RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 243
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g" 245
RULE_ANY_OTHER : .;


