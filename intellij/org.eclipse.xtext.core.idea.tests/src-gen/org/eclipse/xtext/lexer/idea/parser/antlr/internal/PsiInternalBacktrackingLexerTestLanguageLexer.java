package org.eclipse.xtext.lexer.idea.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBacktrackingLexerTestLanguageLexer extends Lexer {
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int RULE_CHARX=8;
    public static final int RULE_YC=4;
    public static final int RULE_CHARY=5;
    public static final int RULE_CHARA=6;
    public static final int RULE_WS=10;
    public static final int RULE_CHARB=7;
    public static final int RULE_SL_COMMENT=11;
    public static final int EOF=-1;
    public static final int RULE_CHARC=9;

    // delegates
    // delegators

    public PsiInternalBacktrackingLexerTestLanguageLexer() {;} 
    public PsiInternalBacktrackingLexerTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PsiInternalBacktrackingLexerTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "PsiInternalBacktrackingLexerTestLanguage.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalBacktrackingLexerTestLanguage.g:11:7: ( 'Abc' )
            // PsiInternalBacktrackingLexerTestLanguage.g:11:9: 'Abc'
            {
            match("Abc"); 


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
            // PsiInternalBacktrackingLexerTestLanguage.g:12:7: ( 'Efg' )
            // PsiInternalBacktrackingLexerTestLanguage.g:12:9: 'Efg'
            {
            match("Efg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "RULE_CHARA"
    public final void mRULE_CHARA() throws RecognitionException {
        try {
            int _type = RULE_CHARA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalBacktrackingLexerTestLanguage.g:229:12: ( 'A' )
            // PsiInternalBacktrackingLexerTestLanguage.g:229:14: 'A'
            {
            match('A'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARA"

    // $ANTLR start "RULE_CHARB"
    public final void mRULE_CHARB() throws RecognitionException {
        try {
            int _type = RULE_CHARB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalBacktrackingLexerTestLanguage.g:231:12: ( 'b' )
            // PsiInternalBacktrackingLexerTestLanguage.g:231:14: 'b'
            {
            match('b'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARB"

    // $ANTLR start "RULE_CHARX"
    public final void mRULE_CHARX() throws RecognitionException {
        try {
            int _type = RULE_CHARX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalBacktrackingLexerTestLanguage.g:233:12: ( 'X' )
            // PsiInternalBacktrackingLexerTestLanguage.g:233:14: 'X'
            {
            match('X'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARX"

    // $ANTLR start "RULE_YC"
    public final void mRULE_YC() throws RecognitionException {
        try {
            int _type = RULE_YC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalBacktrackingLexerTestLanguage.g:235:9: ( RULE_CHARY RULE_CHARC )
            // PsiInternalBacktrackingLexerTestLanguage.g:235:11: RULE_CHARY RULE_CHARC
            {
            mRULE_CHARY(); 
            mRULE_CHARC(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_YC"

    // $ANTLR start "RULE_CHARY"
    public final void mRULE_CHARY() throws RecognitionException {
        try {
            int _type = RULE_CHARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalBacktrackingLexerTestLanguage.g:237:12: ( 'Y' )
            // PsiInternalBacktrackingLexerTestLanguage.g:237:14: 'Y'
            {
            match('Y'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARY"

    // $ANTLR start "RULE_CHARC"
    public final void mRULE_CHARC() throws RecognitionException {
        try {
            int _type = RULE_CHARC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalBacktrackingLexerTestLanguage.g:239:12: ( 'c' )
            // PsiInternalBacktrackingLexerTestLanguage.g:239:14: 'c'
            {
            match('c'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARC"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalBacktrackingLexerTestLanguage.g:241:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // PsiInternalBacktrackingLexerTestLanguage.g:241:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:241:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // PsiInternalBacktrackingLexerTestLanguage.g:
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
            // PsiInternalBacktrackingLexerTestLanguage.g:243:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // PsiInternalBacktrackingLexerTestLanguage.g:243:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // PsiInternalBacktrackingLexerTestLanguage.g:243:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalBacktrackingLexerTestLanguage.g:243:24: ~ ( ( '\\n' | '\\r' ) )
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

            // PsiInternalBacktrackingLexerTestLanguage.g:243:40: ( ( '\\r' )? '\\n' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\n'||LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalBacktrackingLexerTestLanguage.g:243:41: ( '\\r' )? '\\n'
                    {
                    // PsiInternalBacktrackingLexerTestLanguage.g:243:41: ( '\\r' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // PsiInternalBacktrackingLexerTestLanguage.g:243:41: '\\r'
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
        // PsiInternalBacktrackingLexerTestLanguage.g:1:8: ( T__12 | T__13 | RULE_CHARA | RULE_CHARB | RULE_CHARX | RULE_YC | RULE_CHARY | RULE_CHARC | RULE_WS | RULE_SL_COMMENT )
        int alt5=10;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:22: RULE_CHARA
                {
                mRULE_CHARA(); 

                }
                break;
            case 4 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:33: RULE_CHARB
                {
                mRULE_CHARB(); 

                }
                break;
            case 5 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:44: RULE_CHARX
                {
                mRULE_CHARX(); 

                }
                break;
            case 6 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:55: RULE_YC
                {
                mRULE_YC(); 

                }
                break;
            case 7 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:63: RULE_CHARY
                {
                mRULE_CHARY(); 

                }
                break;
            case 8 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:74: RULE_CHARC
                {
                mRULE_CHARC(); 

                }
                break;
            case 9 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:85: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 10 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:93: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\1\12\3\uffff\1\13\7\uffff";
    static final String DFA5_eofS =
        "\15\uffff";
    static final String DFA5_minS =
        "\1\11\1\142\3\uffff\1\143\7\uffff";
    static final String DFA5_maxS =
        "\1\143\1\142\3\uffff\1\143\7\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\4\1\5\1\uffff\1\10\1\11\1\12\1\1\1\3\1\7\1\6";
    static final String DFA5_specialS =
        "\15\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\7\2\uffff\1\7\22\uffff\1\7\16\uffff\1\10\21\uffff\1\1\3\uffff\1\2\22\uffff\1\4\1\5\10\uffff\1\3\1\6",
            "\1\11",
            "",
            "",
            "",
            "\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | RULE_CHARA | RULE_CHARB | RULE_CHARX | RULE_YC | RULE_CHARY | RULE_CHARC | RULE_WS | RULE_SL_COMMENT );";
        }
    }
 

}