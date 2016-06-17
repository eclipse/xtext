package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug303200TestLanguageLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int RULE_WS=6;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int RULE_LT=4;

    // delegates
    // delegators

    public InternalBug303200TestLanguageLexer() {;} 
    public InternalBug303200TestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBug303200TestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBug303200TestLanguage.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:11:6: ( ';' )
            // InternalBug303200TestLanguage.g:11:8: ';'
            {
            match(';'); 

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
            // InternalBug303200TestLanguage.g:12:6: ( 'function' )
            // InternalBug303200TestLanguage.g:12:8: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:13:6: ( '[' )
            // InternalBug303200TestLanguage.g:13:8: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:14:7: ( ']' )
            // InternalBug303200TestLanguage.g:14:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:15:7: ( '(' )
            // InternalBug303200TestLanguage.g:15:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:16:7: ( ')' )
            // InternalBug303200TestLanguage.g:16:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:17:7: ( ',' )
            // InternalBug303200TestLanguage.g:17:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:18:7: ( '{' )
            // InternalBug303200TestLanguage.g:18:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:19:7: ( '}' )
            // InternalBug303200TestLanguage.g:19:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:20:7: ( '.' )
            // InternalBug303200TestLanguage.g:20:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:3213:9: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // InternalBug303200TestLanguage.g:3213:11: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // InternalBug303200TestLanguage.g:3213:11: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:3215:9: ( ( ' ' | '\\t' )+ )
            // InternalBug303200TestLanguage.g:3215:11: ( ' ' | '\\t' )+
            {
            // InternalBug303200TestLanguage.g:3215:11: ( ' ' | '\\t' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\t'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
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

    // $ANTLR start "RULE_LT"
    public final void mRULE_LT() throws RecognitionException {
        try {
            int _type = RULE_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug303200TestLanguage.g:3217:9: ( ( '\\r' | '\\n' ) )
            // InternalBug303200TestLanguage.g:3217:11: ( '\\r' | '\\n' )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LT"

    public void mTokens() throws RecognitionException {
        // InternalBug303200TestLanguage.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | RULE_ID | RULE_WS | RULE_LT )
        int alt3=13;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // InternalBug303200TestLanguage.g:1:10: T__7
                {
                mT__7(); 

                }
                break;
            case 2 :
                // InternalBug303200TestLanguage.g:1:15: T__8
                {
                mT__8(); 

                }
                break;
            case 3 :
                // InternalBug303200TestLanguage.g:1:20: T__9
                {
                mT__9(); 

                }
                break;
            case 4 :
                // InternalBug303200TestLanguage.g:1:25: T__10
                {
                mT__10(); 

                }
                break;
            case 5 :
                // InternalBug303200TestLanguage.g:1:31: T__11
                {
                mT__11(); 

                }
                break;
            case 6 :
                // InternalBug303200TestLanguage.g:1:37: T__12
                {
                mT__12(); 

                }
                break;
            case 7 :
                // InternalBug303200TestLanguage.g:1:43: T__13
                {
                mT__13(); 

                }
                break;
            case 8 :
                // InternalBug303200TestLanguage.g:1:49: T__14
                {
                mT__14(); 

                }
                break;
            case 9 :
                // InternalBug303200TestLanguage.g:1:55: T__15
                {
                mT__15(); 

                }
                break;
            case 10 :
                // InternalBug303200TestLanguage.g:1:61: T__16
                {
                mT__16(); 

                }
                break;
            case 11 :
                // InternalBug303200TestLanguage.g:1:67: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 12 :
                // InternalBug303200TestLanguage.g:1:75: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 13 :
                // InternalBug303200TestLanguage.g:1:83: RULE_LT
                {
                mRULE_LT(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\2\uffff\1\13\13\uffff\6\13\1\25\1\uffff";
    static final String DFA3_eofS =
        "\26\uffff";
    static final String DFA3_minS =
        "\1\11\1\uffff\1\165\13\uffff\1\156\1\143\1\164\1\151\1\157\1\156\1\101\1\uffff";
    static final String DFA3_maxS =
        "\1\175\1\uffff\1\165\13\uffff\1\156\1\143\1\164\1\151\1\157\1\156\1\172\1\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\7\uffff\1\2";
    static final String DFA3_specialS =
        "\26\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\14\1\15\2\uffff\1\15\22\uffff\1\14\7\uffff\1\5\1\6\2\uffff\1\7\1\uffff\1\12\14\uffff\1\1\5\uffff\32\13\1\3\1\uffff\1\4\3\uffff\5\13\1\2\24\13\1\10\1\uffff\1\11",
            "",
            "\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\32\13\6\uffff\32\13",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | RULE_ID | RULE_WS | RULE_LT );";
        }
    }
 

}