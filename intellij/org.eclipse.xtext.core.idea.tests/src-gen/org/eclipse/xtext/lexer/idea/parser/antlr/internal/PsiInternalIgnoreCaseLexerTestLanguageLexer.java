package org.eclipse.xtext.lexer.idea.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalIgnoreCaseLexerTestLanguageLexer extends Lexer {
    public static final int RULE_WS=4;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=5;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int T__6=6;

    // delegates
    // delegators

    public PsiInternalIgnoreCaseLexerTestLanguageLexer() {;} 
    public PsiInternalIgnoreCaseLexerTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PsiInternalIgnoreCaseLexerTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "PsiInternalIgnoreCaseLexerTestLanguage.g"; }

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalIgnoreCaseLexerTestLanguage.g:11:6: ( 'case' )
            // PsiInternalIgnoreCaseLexerTestLanguage.g:11:8: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalIgnoreCaseLexerTestLanguage.g:12:6: ( 'foo' )
            // PsiInternalIgnoreCaseLexerTestLanguage.g:12:8: 'foo'
            {
            match("foo"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalIgnoreCaseLexerTestLanguage.g:13:6: ( 'CaSe' )
            // PsiInternalIgnoreCaseLexerTestLanguage.g:13:8: 'CaSe'
            {
            match("CaSe"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalIgnoreCaseLexerTestLanguage.g:98:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // PsiInternalIgnoreCaseLexerTestLanguage.g:98:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // PsiInternalIgnoreCaseLexerTestLanguage.g:98:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalIgnoreCaseLexerTestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalIgnoreCaseLexerTestLanguage.g:100:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // PsiInternalIgnoreCaseLexerTestLanguage.g:100:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // PsiInternalIgnoreCaseLexerTestLanguage.g:100:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalIgnoreCaseLexerTestLanguage.g:100:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // PsiInternalIgnoreCaseLexerTestLanguage.g:100:40: ( ( '\\r' )? '\\n' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\n'||LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalIgnoreCaseLexerTestLanguage.g:100:41: ( '\\r' )? '\\n'
                    {
                    // PsiInternalIgnoreCaseLexerTestLanguage.g:100:41: ( '\\r' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // PsiInternalIgnoreCaseLexerTestLanguage.g:100:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    public void mTokens() throws RecognitionException {
        // PsiInternalIgnoreCaseLexerTestLanguage.g:1:8: ( T__6 | T__7 | T__8 | RULE_WS | RULE_SL_COMMENT )
        int alt5=5;
        switch ( input.LA(1) ) {
        case 'c':
            {
            alt5=1;
            }
            break;
        case 'f':
            {
            alt5=2;
            }
            break;
        case 'C':
            {
            alt5=3;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt5=4;
            }
            break;
        case '/':
            {
            alt5=5;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;
        }

        switch (alt5) {
            case 1 :
                // PsiInternalIgnoreCaseLexerTestLanguage.g:1:10: T__6
                {
                mT__6(); 

                }
                break;
            case 2 :
                // PsiInternalIgnoreCaseLexerTestLanguage.g:1:15: T__7
                {
                mT__7(); 

                }
                break;
            case 3 :
                // PsiInternalIgnoreCaseLexerTestLanguage.g:1:20: T__8
                {
                mT__8(); 

                }
                break;
            case 4 :
                // PsiInternalIgnoreCaseLexerTestLanguage.g:1:25: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 5 :
                // PsiInternalIgnoreCaseLexerTestLanguage.g:1:33: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


 

}