package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUnicodeTestLanguageLexer extends Lexer {
    public static final int RULE_GERMAN_STRING=4;
    public static final int RULE_ID=6;
    public static final int RULE_WS=10;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_INT=7;
    public static final int RULE_ML_COMMENT=8;
    public static final int EOF=-1;

    // delegates
    // delegators

    public InternalUnicodeTestLanguageLexer() {;} 
    public InternalUnicodeTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalUnicodeTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalUnicodeTestLanguage.g"; }

    // $ANTLR start "RULE_GERMAN_STRING"
    public final void mRULE_GERMAN_STRING() throws RecognitionException {
        try {
            int _type = RULE_GERMAN_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnicodeTestLanguage.g:223:20: ( ( 'A' .. 'Z' | 'a' .. 'z' | '\\u00C4' | '\\u00D6' | '\\u00DC' | '\\u00E4' | '\\u00F6' | '\\u00FC' | '\\u1E9E' )* )
            // InternalUnicodeTestLanguage.g:223:22: ( 'A' .. 'Z' | 'a' .. 'z' | '\\u00C4' | '\\u00D6' | '\\u00DC' | '\\u00E4' | '\\u00F6' | '\\u00FC' | '\\u1E9E' )*
            {
            // InternalUnicodeTestLanguage.g:223:22: ( 'A' .. 'Z' | 'a' .. 'z' | '\\u00C4' | '\\u00D6' | '\\u00DC' | '\\u00E4' | '\\u00F6' | '\\u00FC' | '\\u1E9E' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')||LA1_0=='\u00C4'||LA1_0=='\u00D6'||LA1_0=='\u00DC'||LA1_0=='\u00E4'||LA1_0=='\u00F6'||LA1_0=='\u00FC'||LA1_0=='\u1E9E') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalUnicodeTestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00C4'||input.LA(1)=='\u00D6'||input.LA(1)=='\u00DC'||input.LA(1)=='\u00E4'||input.LA(1)=='\u00F6'||input.LA(1)=='\u00FC'||input.LA(1)=='\u1E9E' ) {
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
    // $ANTLR end "RULE_GERMAN_STRING"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnicodeTestLanguage.g:225:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalUnicodeTestLanguage.g:225:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalUnicodeTestLanguage.g:225:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalUnicodeTestLanguage.g:225:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalUnicodeTestLanguage.g:225:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalUnicodeTestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnicodeTestLanguage.g:227:10: ( ( '0' .. '9' )+ )
            // InternalUnicodeTestLanguage.g:227:12: ( '0' .. '9' )+
            {
            // InternalUnicodeTestLanguage.g:227:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalUnicodeTestLanguage.g:227:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnicodeTestLanguage.g:229:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalUnicodeTestLanguage.g:229:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalUnicodeTestLanguage.g:229:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\"') ) {
                alt7=1;
            }
            else if ( (LA7_0=='\'') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalUnicodeTestLanguage.g:229:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalUnicodeTestLanguage.g:229:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalUnicodeTestLanguage.g:229:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalUnicodeTestLanguage.g:229:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalUnicodeTestLanguage.g:229:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalUnicodeTestLanguage.g:229:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalUnicodeTestLanguage.g:229:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalUnicodeTestLanguage.g:229:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\''); 

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
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnicodeTestLanguage.g:231:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalUnicodeTestLanguage.g:231:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalUnicodeTestLanguage.g:231:24: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalUnicodeTestLanguage.g:231:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnicodeTestLanguage.g:233:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalUnicodeTestLanguage.g:233:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalUnicodeTestLanguage.g:233:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalUnicodeTestLanguage.g:233:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop9;
                }
            } while (true);

            // InternalUnicodeTestLanguage.g:233:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalUnicodeTestLanguage.g:233:41: ( '\\r' )? '\\n'
                    {
                    // InternalUnicodeTestLanguage.g:233:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalUnicodeTestLanguage.g:233:41: '\\r'
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnicodeTestLanguage.g:235:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalUnicodeTestLanguage.g:235:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalUnicodeTestLanguage.g:235:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalUnicodeTestLanguage.g:
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
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
            // InternalUnicodeTestLanguage.g:237:16: ( . )
            // InternalUnicodeTestLanguage.g:237:18: .
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
        // InternalUnicodeTestLanguage.g:1:8: ( RULE_GERMAN_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=8;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // InternalUnicodeTestLanguage.g:1:10: RULE_GERMAN_STRING
                {
                mRULE_GERMAN_STRING(); 

                }
                break;
            case 2 :
                // InternalUnicodeTestLanguage.g:1:29: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 3 :
                // InternalUnicodeTestLanguage.g:1:37: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 4 :
                // InternalUnicodeTestLanguage.g:1:46: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 5 :
                // InternalUnicodeTestLanguage.g:1:58: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 6 :
                // InternalUnicodeTestLanguage.g:1:74: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 7 :
                // InternalUnicodeTestLanguage.g:1:90: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 8 :
                // InternalUnicodeTestLanguage.g:1:98: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\2\2\1\uffff\1\13\3\uffff\3\13\2\uffff\1\2\6\uffff";
    static final String DFA13_eofS =
        "\23\uffff";
    static final String DFA13_minS =
        "\1\0\1\60\1\uffff\1\101\3\uffff\2\0\1\52\2\uffff\1\60\6\uffff";
    static final String DFA13_maxS =
        "\1\uffff\1\172\1\uffff\1\172\3\uffff\2\uffff\1\57\2\uffff\1\172\6\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\1\1\uffff\1\1\1\2\1\3\3\uffff\1\7\1\10\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7";
    static final String DFA13_specialS =
        "\1\0\6\uffff\1\1\1\2\12\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\13\2\12\2\13\1\12\22\13\1\12\1\13\1\7\4\13\1\10\7\13\1\11\12\6\7\13\32\1\3\13\1\3\1\5\1\13\32\1\111\13\1\4\21\13\1\4\5\13\1\4\7\13\1\4\21\13\1\4\5\13\1\4\u1da1\13\1\4\ue161\13",
            "\12\15\7\uffff\32\14\4\uffff\1\15\1\uffff\32\14",
            "",
            "\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "",
            "",
            "\0\17",
            "\0\17",
            "\1\20\4\uffff\1\21",
            "",
            "",
            "\12\15\7\uffff\32\14\4\uffff\1\15\1\uffff\32\14",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    static class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_GERMAN_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( ((LA13_0>='A' && LA13_0<='Z')||(LA13_0>='a' && LA13_0<='z')) ) {s = 1;}

                        else if ( (LA13_0=='^') ) {s = 3;}

                        else if ( (LA13_0=='\u00C4'||LA13_0=='\u00D6'||LA13_0=='\u00DC'||LA13_0=='\u00E4'||LA13_0=='\u00F6'||LA13_0=='\u00FC'||LA13_0=='\u1E9E') ) {s = 4;}

                        else if ( (LA13_0=='_') ) {s = 5;}

                        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {s = 6;}

                        else if ( (LA13_0=='\"') ) {s = 7;}

                        else if ( (LA13_0=='\'') ) {s = 8;}

                        else if ( (LA13_0=='/') ) {s = 9;}

                        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {s = 10;}

                        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||(LA13_0>='#' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='.')||(LA13_0>=':' && LA13_0<='@')||(LA13_0>='[' && LA13_0<=']')||LA13_0=='`'||(LA13_0>='{' && LA13_0<='\u00C3')||(LA13_0>='\u00C5' && LA13_0<='\u00D5')||(LA13_0>='\u00D7' && LA13_0<='\u00DB')||(LA13_0>='\u00DD' && LA13_0<='\u00E3')||(LA13_0>='\u00E5' && LA13_0<='\u00F5')||(LA13_0>='\u00F7' && LA13_0<='\u00FB')||(LA13_0>='\u00FD' && LA13_0<='\u1E9D')||(LA13_0>='\u1E9F' && LA13_0<='\uFFFF')) ) {s = 11;}

                        else s = 2;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_7 = input.LA(1);

                        s = -1;
                        if ( ((LA13_7>='\u0000' && LA13_7<='\uFFFF')) ) {s = 15;}

                        else s = 11;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_8 = input.LA(1);

                        s = -1;
                        if ( ((LA13_8>='\u0000' && LA13_8<='\uFFFF')) ) {s = 15;}

                        else s = 11;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}