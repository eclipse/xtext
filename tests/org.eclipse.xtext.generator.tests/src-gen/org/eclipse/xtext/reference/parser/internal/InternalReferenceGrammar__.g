lexer grammar InternalReferenceGrammar;
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
package org.eclipse.xtext.reference.parser.internal;
}

T12 : 'spielplatz' ;
T13 : '{' ;
T14 : '}' ;
T15 : 'kind' ;
T16 : '(' ;
T17 : ')' ;
T18 : 'erwachsener' ;
T19 : 'spielzeug' ;
T20 : 'ROT' ;
T21 : 'BLAU' ;
T22 : 'GELB' ;
T23 : 'GRÜN' ;

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g" 343
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g" 345
RULE_INT : ('0'..'9')+;

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g" 347
RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g" 349
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g" 351
RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n'{$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g" 353
RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g" 355
RULE_LEXER_BODY : '<#' '.'* '#>';

// $ANTLR src "./src-gen/org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.g" 357
RULE_ANY_OTHER : .;


