package org.eclipse.xtext.parser.encoding.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEncodingTestLanguageLexer extends Lexer {
    public static final int RULE_WS=5;
    public static final int RULE_LEXEME=4;
    public static final int RULE_ANY_OTHER=6;
    public static final int EOF=-1;

    // delegates
    // delegators

    public InternalEncodingTestLanguageLexer() {;} 
    public InternalEncodingTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalEncodingTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalEncodingTestLanguage.g"; }

    // $ANTLR start "RULE_LEXEME"
    public final void mRULE_LEXEME() throws RecognitionException {
        try {
            int _type = RULE_LEXEME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEncodingTestLanguage.g:144:13: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '\\u00E4' | '\\u00F6' | '\\u00FC' | '\\u00DF' | '\\u00C4' | '\\u00D6' | '\\u00DC' )* )
            // InternalEncodingTestLanguage.g:144:15: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '\\u00E4' | '\\u00F6' | '\\u00FC' | '\\u00DF' | '\\u00C4' | '\\u00D6' | '\\u00DC' )*
            {
            // InternalEncodingTestLanguage.g:144:15: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '\\u00E4' | '\\u00F6' | '\\u00FC' | '\\u00DF' | '\\u00C4' | '\\u00D6' | '\\u00DC' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')||LA1_0=='\u00C4'||LA1_0=='\u00D6'||LA1_0=='\u00DC'||LA1_0=='\u00DF'||LA1_0=='\u00E4'||LA1_0=='\u00F6'||LA1_0=='\u00FC') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalEncodingTestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00C4'||input.LA(1)=='\u00D6'||input.LA(1)=='\u00DC'||input.LA(1)=='\u00DF'||input.LA(1)=='\u00E4'||input.LA(1)=='\u00F6'||input.LA(1)=='\u00FC' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LEXEME"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEncodingTestLanguage.g:146:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalEncodingTestLanguage.g:146:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalEncodingTestLanguage.g:146:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\t' && LA2_0<='\n')||LA2_0=='\r'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalEncodingTestLanguage.g:
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEncodingTestLanguage.g:148:16: ( . )
            // InternalEncodingTestLanguage.g:148:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalEncodingTestLanguage.g:1:8: ( RULE_LEXEME | RULE_WS | RULE_ANY_OTHER )
        int alt3=3;
        int LA3_0 = input.LA(1);

        if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')||LA3_0=='\u00C4'||LA3_0=='\u00D6'||LA3_0=='\u00DC'||LA3_0=='\u00DF'||LA3_0=='\u00E4'||LA3_0=='\u00F6'||LA3_0=='\u00FC') ) {
            alt3 = mTokensHelper001();
        }
        else if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
            alt3 = mTokensHelper002();
        }
        else if ( ((LA3_0>='\u0000' && LA3_0<='\b')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\u001F')||(LA3_0>='!' && LA3_0<='/')||(LA3_0>=':' && LA3_0<='@')||(LA3_0>='[' && LA3_0<='`')||(LA3_0>='{' && LA3_0<='\u00C3')||(LA3_0>='\u00C5' && LA3_0<='\u00D5')||(LA3_0>='\u00D7' && LA3_0<='\u00DB')||(LA3_0>='\u00DD' && LA3_0<='\u00DE')||(LA3_0>='\u00E0' && LA3_0<='\u00E3')||(LA3_0>='\u00E5' && LA3_0<='\u00F5')||(LA3_0>='\u00F7' && LA3_0<='\u00FB')||(LA3_0>='\u00FD' && LA3_0<='\uFFFF')) ) {
            alt3 = mTokensHelper003();
        }
        else {
            alt3 = mTokensHelper004();}
        switch (alt3) {
            case 1 :
                // InternalEncodingTestLanguage.g:1:10: RULE_LEXEME
                {
                mRULE_LEXEME(); 

                }
                break;
            case 2 :
                // InternalEncodingTestLanguage.g:1:22: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 3 :
                // InternalEncodingTestLanguage.g:1:30: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        return 1;
    }

    private int mTokensHelper002() throws RecognitionException {
        return 2;
    }

    private int mTokensHelper003() throws RecognitionException {
        return 3;
    }

    private int mTokensHelper004() throws RecognitionException {
        return 1;
    }



 

}