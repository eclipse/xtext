// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g 2008-06-03 10:36:03

package org.eclipse.xtext.testlanguages.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLexerLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int Tokens=12;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=10;


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

    public InternalLexerLanguageLexer() {;} 
    public InternalLexerLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g"; }

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:149:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:149:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:149:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:149:12: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:149:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:151:10: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:151:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:151:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:151:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:153:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:153:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:153:24: ( options {greedy=false; } : . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='*') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='/') ) {
                        alt4=2;
                    }
                    else if ( ((LA4_1>='\u0000' && LA4_1<='.')||(LA4_1>='0' && LA4_1<='\uFFFE')) ) {
                        alt4=1;
                    }


                }
                else if ( ((LA4_0>='\u0000' && LA4_0<=')')||(LA4_0>='+' && LA4_0<='\uFFFE')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:153:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match("*/"); 

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:155:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:155:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:155:24: (~ ( '\\n' | '\\r' ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\uFFFE')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:155:24: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:155:38: ( '\\r' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:155:38: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:157:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:157:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:157:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_LEXER_BODY
    public final void mRULE_LEXER_BODY() throws RecognitionException {
        try {
            int _type = RULE_LEXER_BODY;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:159:17: ( '<#' ( '.' )* '#>' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:159:19: '<#' ( '.' )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:159:24: ( '.' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='.') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:159:24: '.'
            	    {
            	    match('.'); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("#>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_LEXER_BODY

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:161:16: ( . )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:161:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:8: ( RULE_STRING | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_LEXER_BODY | RULE_ANY_OTHER )
        int alt9=7;
        int LA9_0 = input.LA(1);

        if ( (LA9_0=='^') ) {
            int LA9_1 = input.LA(2);

            if ( ((LA9_1>='A' && LA9_1<='Z')||LA9_1=='_'||(LA9_1>='a' && LA9_1<='z')) ) {
                alt9=1;
            }
            else {
                alt9=7;}
        }
        else if ( ((LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
            alt9=1;
        }
        else if ( ((LA9_0>='0' && LA9_0<='9')) ) {
            alt9=2;
        }
        else if ( (LA9_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt9=4;
                }
                break;
            case '*':
                {
                alt9=3;
                }
                break;
            default:
                alt9=7;}

        }
        else if ( ((LA9_0>='\t' && LA9_0<='\n')||LA9_0=='\r'||LA9_0==' ') ) {
            alt9=5;
        }
        else if ( (LA9_0=='<') ) {
            int LA9_6 = input.LA(2);

            if ( (LA9_6=='#') ) {
                alt9=6;
            }
            else {
                alt9=7;}
        }
        else if ( ((LA9_0>='\u0000' && LA9_0<='\b')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\u001F')||(LA9_0>='!' && LA9_0<='.')||(LA9_0>=':' && LA9_0<=';')||(LA9_0>='=' && LA9_0<='@')||(LA9_0>='[' && LA9_0<=']')||LA9_0=='`'||(LA9_0>='{' && LA9_0<='\uFFFE')) ) {
            alt9=7;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( RULE_STRING | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_LEXER_BODY | RULE_ANY_OTHER );", 9, 0, input);

            throw nvae;
        }
        switch (alt9) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:10: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:22: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:31: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:47: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:63: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:71: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:87: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}