package org.eclipse.xtext.ui.tests.xmleditor.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXmlLexer extends Lexer {
    public static final int RULE_ID=9;
    public static final int RULE_WS=11;
    public static final int RULE_TAG_CLOSE=6;
    public static final int RULE_PCDATA=12;
    public static final int RULE_STRING=10;
    public static final int RULE_TAG_START_OPEN=4;
    public static final int RULE_TAG_EMPTY_CLOSE=7;
    public static final int RULE_ATTR_EQ=8;
    public static final int RULE_TAG_END_OPEN=5;
    public static final int EOF=-1;

    // delegates
    // delegators

    public InternalXmlLexer() {;} 
    public InternalXmlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalXmlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalXmlLexer.g"; }

    // $ANTLR start "RULE_TAG_START_OPEN"
    public final void mRULE_TAG_START_OPEN() throws RecognitionException {
        try {
            int _type = RULE_TAG_START_OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmlLexer.g:14:21: ( '<' )
            // InternalXmlLexer.g:14:23: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAG_START_OPEN"

    // $ANTLR start "RULE_TAG_END_OPEN"
    public final void mRULE_TAG_END_OPEN() throws RecognitionException {
        try {
            int _type = RULE_TAG_END_OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmlLexer.g:16:19: ( '</' )
            // InternalXmlLexer.g:16:21: '</'
            {
            match("</"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAG_END_OPEN"

    // $ANTLR start "RULE_TAG_CLOSE"
    public final void mRULE_TAG_CLOSE() throws RecognitionException {
        try {
            int _type = RULE_TAG_CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmlLexer.g:18:16: ( '>' )
            // InternalXmlLexer.g:18:18: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAG_CLOSE"

    // $ANTLR start "RULE_TAG_EMPTY_CLOSE"
    public final void mRULE_TAG_EMPTY_CLOSE() throws RecognitionException {
        try {
            int _type = RULE_TAG_EMPTY_CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmlLexer.g:20:22: ( '/>' )
            // InternalXmlLexer.g:20:24: '/>'
            {
            match("/>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAG_EMPTY_CLOSE"

    // $ANTLR start "RULE_ATTR_EQ"
    public final void mRULE_ATTR_EQ() throws RecognitionException {
        try {
            int _type = RULE_ATTR_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmlLexer.g:22:14: ( '=' )
            // InternalXmlLexer.g:22:16: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ATTR_EQ"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmlLexer.g:24:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalXmlLexer.g:24:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalXmlLexer.g:24:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalXmlLexer.g:24:11: '^'
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

            // InternalXmlLexer.g:24:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalXmlLexer.g:
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
            	    break loop2;
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

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmlLexer.g:26:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalXmlLexer.g:26:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalXmlLexer.g:26:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\"') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\'') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXmlLexer.g:26:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalXmlLexer.g:26:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalXmlLexer.g:26:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXmlLexer.g:26:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop3;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalXmlLexer.g:26:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalXmlLexer.g:26:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalXmlLexer.g:26:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXmlLexer.g:26:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop4;
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmlLexer.g:28:9: ( ( ' ' | '\\r' | '\\t' | '\\f' | '\\n' )+ )
            // InternalXmlLexer.g:28:11: ( ' ' | '\\r' | '\\t' | '\\f' | '\\n' )+
            {
            // InternalXmlLexer.g:28:11: ( ' ' | '\\r' | '\\t' | '\\f' | '\\n' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||(LA6_0>='\f' && LA6_0<='\r')||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalXmlLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_PCDATA"
    public final void mRULE_PCDATA() throws RecognitionException {
        try {
            int _type = RULE_PCDATA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmlLexer.g:30:13: ( (~ ( '<' ) )+ )
            // InternalXmlLexer.g:30:15: (~ ( '<' ) )+
            {
            // InternalXmlLexer.g:30:15: (~ ( '<' ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<=';')||(LA7_0>='=' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXmlLexer.g:30:15: ~ ( '<' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<=';')||(input.LA(1)>='=' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PCDATA"

    public void mTokens() throws RecognitionException {
        // InternalXmlLexer.g:1:8: ( RULE_TAG_START_OPEN | RULE_TAG_END_OPEN | RULE_TAG_CLOSE | RULE_TAG_EMPTY_CLOSE | RULE_ATTR_EQ | RULE_ID | RULE_STRING | RULE_WS | RULE_PCDATA )
        int alt8=9;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // InternalXmlLexer.g:1:10: RULE_TAG_START_OPEN
                {
                mRULE_TAG_START_OPEN(); 

                }
                break;
            case 2 :
                // InternalXmlLexer.g:1:30: RULE_TAG_END_OPEN
                {
                mRULE_TAG_END_OPEN(); 

                }
                break;
            case 3 :
                // InternalXmlLexer.g:1:48: RULE_TAG_CLOSE
                {
                mRULE_TAG_CLOSE(); 

                }
                break;
            case 4 :
                // InternalXmlLexer.g:1:63: RULE_TAG_EMPTY_CLOSE
                {
                mRULE_TAG_EMPTY_CLOSE(); 

                }
                break;
            case 5 :
                // InternalXmlLexer.g:1:84: RULE_ATTR_EQ
                {
                mRULE_ATTR_EQ(); 

                }
                break;
            case 6 :
                // InternalXmlLexer.g:1:97: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 7 :
                // InternalXmlLexer.g:1:105: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 8 :
                // InternalXmlLexer.g:1:117: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 9 :
                // InternalXmlLexer.g:1:125: RULE_PCDATA
                {
                mRULE_PCDATA(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\1\14\1\15\1\12\1\17\1\12\1\21\2\12\1\31\4\uffff\1\32\1\uffff\1\21\1\uffff\2\12\1\25\1\uffff\2\12\1\25\2\uffff\2\12";
    static final String DFA8_eofS =
        "\35\uffff";
    static final String DFA8_minS =
        "\1\0\1\57\1\0\1\76\1\0\1\101\4\0\4\uffff\1\0\1\uffff\1\0\1\uffff\3\0\1\uffff\3\0\2\uffff\2\0";
    static final String DFA8_maxS =
        "\1\uffff\1\57\1\uffff\1\76\1\uffff\1\172\4\uffff\4\uffff\1\uffff\1\uffff\1\uffff\1\uffff\3\uffff\1\uffff\3\uffff\2\uffff\2\uffff";
    static final String DFA8_acceptS =
        "\12\uffff\1\11\1\2\1\1\1\3\1\uffff\1\5\1\uffff\1\6\3\uffff\1\7\3\uffff\1\10\1\4\2\uffff";
    static final String DFA8_specialS =
        "\1\2\1\uffff\1\0\1\uffff\1\7\1\uffff\1\15\1\16\1\6\1\12\4\uffff\1\5\1\uffff\1\3\1\uffff\1\4\1\14\1\13\1\uffff\1\10\1\20\1\1\2\uffff\1\11\1\17}>";
    static final String[] DFA8_transitionS = {
            "\11\12\2\11\1\12\2\11\22\12\1\11\1\12\1\7\4\12\1\10\7\12\1\3\14\12\1\1\1\4\1\2\2\12\32\6\3\12\1\5\1\6\1\12\32\6\uff85\12",
            "\1\13",
            "\74\12\1\uffff\uffc3\12",
            "\1\16",
            "\74\12\1\uffff\uffc3\12",
            "\32\6\4\uffff\1\6\1\uffff\32\6",
            "\60\12\12\20\2\12\1\uffff\4\12\32\20\4\12\1\20\1\12\32\20\uff85\12",
            "\42\23\1\24\31\23\1\25\37\23\1\22\uffa3\23",
            "\47\27\1\30\24\27\1\25\37\27\1\26\uffa3\27",
            "\11\12\2\11\1\12\2\11\22\12\1\11\33\12\1\uffff\uffc3\12",
            "",
            "",
            "",
            "",
            "\74\12\1\uffff\uffc3\12",
            "",
            "\60\12\12\20\2\12\1\uffff\4\12\32\20\4\12\1\20\1\12\32\20\uff85\12",
            "",
            "\74\33\1\25\uffc3\33",
            "\42\23\1\24\31\23\1\25\37\23\1\22\uffa3\23",
            "\74\12\1\uffff\uffc3\12",
            "",
            "\74\34\1\25\uffc3\34",
            "\47\27\1\30\24\27\1\25\37\27\1\26\uffa3\27",
            "\74\12\1\uffff\uffc3\12",
            "",
            "",
            "\42\23\1\24\31\23\1\25\37\23\1\22\uffa3\23",
            "\47\27\1\30\24\27\1\25\37\27\1\26\uffa3\27"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_TAG_START_OPEN | RULE_TAG_END_OPEN | RULE_TAG_CLOSE | RULE_TAG_EMPTY_CLOSE | RULE_ATTR_EQ | RULE_ID | RULE_STRING | RULE_WS | RULE_PCDATA );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_2 = input.LA(1);

                        s = -1;
                        if ( ((LA8_2>='\u0000' && LA8_2<=';')||(LA8_2>='=' && LA8_2<='\uFFFF')) ) {s = 10;}

                        else s = 13;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_24 = input.LA(1);

                        s = -1;
                        if ( ((LA8_24>='\u0000' && LA8_24<=';')||(LA8_24>='=' && LA8_24<='\uFFFF')) ) {s = 10;}

                        else s = 21;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_0 = input.LA(1);

                        s = -1;
                        if ( (LA8_0=='<') ) {s = 1;}

                        else if ( (LA8_0=='>') ) {s = 2;}

                        else if ( (LA8_0=='/') ) {s = 3;}

                        else if ( (LA8_0=='=') ) {s = 4;}

                        else if ( (LA8_0=='^') ) {s = 5;}

                        else if ( ((LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {s = 6;}

                        else if ( (LA8_0=='\"') ) {s = 7;}

                        else if ( (LA8_0=='\'') ) {s = 8;}

                        else if ( ((LA8_0>='\t' && LA8_0<='\n')||(LA8_0>='\f' && LA8_0<='\r')||LA8_0==' ') ) {s = 9;}

                        else if ( ((LA8_0>='\u0000' && LA8_0<='\b')||LA8_0=='\u000B'||(LA8_0>='\u000E' && LA8_0<='\u001F')||LA8_0=='!'||(LA8_0>='#' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='.')||(LA8_0>='0' && LA8_0<=';')||(LA8_0>='?' && LA8_0<='@')||(LA8_0>='[' && LA8_0<=']')||LA8_0=='`'||(LA8_0>='{' && LA8_0<='\uFFFF')) ) {s = 10;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA8_16 = input.LA(1);

                        s = -1;
                        if ( ((LA8_16>='0' && LA8_16<='9')||(LA8_16>='A' && LA8_16<='Z')||LA8_16=='_'||(LA8_16>='a' && LA8_16<='z')) ) {s = 16;}

                        else if ( ((LA8_16>='\u0000' && LA8_16<='/')||(LA8_16>=':' && LA8_16<=';')||(LA8_16>='=' && LA8_16<='@')||(LA8_16>='[' && LA8_16<='^')||LA8_16=='`'||(LA8_16>='{' && LA8_16<='\uFFFF')) ) {s = 10;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA8_18 = input.LA(1);

                        s = -1;
                        if ( ((LA8_18>='\u0000' && LA8_18<=';')||(LA8_18>='=' && LA8_18<='\uFFFF')) ) {s = 27;}

                        else if ( (LA8_18=='<') ) {s = 21;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA8_14 = input.LA(1);

                        s = -1;
                        if ( ((LA8_14>='\u0000' && LA8_14<=';')||(LA8_14>='=' && LA8_14<='\uFFFF')) ) {s = 10;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA8_8 = input.LA(1);

                        s = -1;
                        if ( (LA8_8=='\\') ) {s = 22;}

                        else if ( ((LA8_8>='\u0000' && LA8_8<='&')||(LA8_8>='(' && LA8_8<=';')||(LA8_8>='=' && LA8_8<='[')||(LA8_8>=']' && LA8_8<='\uFFFF')) ) {s = 23;}

                        else if ( (LA8_8=='\'') ) {s = 24;}

                        else if ( (LA8_8=='<') ) {s = 21;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA8_4 = input.LA(1);

                        s = -1;
                        if ( ((LA8_4>='\u0000' && LA8_4<=';')||(LA8_4>='=' && LA8_4<='\uFFFF')) ) {s = 10;}

                        else s = 15;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA8_22 = input.LA(1);

                        s = -1;
                        if ( ((LA8_22>='\u0000' && LA8_22<=';')||(LA8_22>='=' && LA8_22<='\uFFFF')) ) {s = 28;}

                        else if ( (LA8_22=='<') ) {s = 21;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA8_27 = input.LA(1);

                        s = -1;
                        if ( (LA8_27=='\"') ) {s = 20;}

                        else if ( (LA8_27=='\\') ) {s = 18;}

                        else if ( ((LA8_27>='\u0000' && LA8_27<='!')||(LA8_27>='#' && LA8_27<=';')||(LA8_27>='=' && LA8_27<='[')||(LA8_27>=']' && LA8_27<='\uFFFF')) ) {s = 19;}

                        else if ( (LA8_27=='<') ) {s = 21;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA8_9 = input.LA(1);

                        s = -1;
                        if ( ((LA8_9>='\t' && LA8_9<='\n')||(LA8_9>='\f' && LA8_9<='\r')||LA8_9==' ') ) {s = 9;}

                        else if ( ((LA8_9>='\u0000' && LA8_9<='\b')||LA8_9=='\u000B'||(LA8_9>='\u000E' && LA8_9<='\u001F')||(LA8_9>='!' && LA8_9<=';')||(LA8_9>='=' && LA8_9<='\uFFFF')) ) {s = 10;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA8_20 = input.LA(1);

                        s = -1;
                        if ( ((LA8_20>='\u0000' && LA8_20<=';')||(LA8_20>='=' && LA8_20<='\uFFFF')) ) {s = 10;}

                        else s = 21;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA8_19 = input.LA(1);

                        s = -1;
                        if ( (LA8_19=='\"') ) {s = 20;}

                        else if ( (LA8_19=='\\') ) {s = 18;}

                        else if ( ((LA8_19>='\u0000' && LA8_19<='!')||(LA8_19>='#' && LA8_19<=';')||(LA8_19>='=' && LA8_19<='[')||(LA8_19>=']' && LA8_19<='\uFFFF')) ) {s = 19;}

                        else if ( (LA8_19=='<') ) {s = 21;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA8_6 = input.LA(1);

                        s = -1;
                        if ( ((LA8_6>='0' && LA8_6<='9')||(LA8_6>='A' && LA8_6<='Z')||LA8_6=='_'||(LA8_6>='a' && LA8_6<='z')) ) {s = 16;}

                        else if ( ((LA8_6>='\u0000' && LA8_6<='/')||(LA8_6>=':' && LA8_6<=';')||(LA8_6>='=' && LA8_6<='@')||(LA8_6>='[' && LA8_6<='^')||LA8_6=='`'||(LA8_6>='{' && LA8_6<='\uFFFF')) ) {s = 10;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA8_7 = input.LA(1);

                        s = -1;
                        if ( (LA8_7=='\\') ) {s = 18;}

                        else if ( ((LA8_7>='\u0000' && LA8_7<='!')||(LA8_7>='#' && LA8_7<=';')||(LA8_7>='=' && LA8_7<='[')||(LA8_7>=']' && LA8_7<='\uFFFF')) ) {s = 19;}

                        else if ( (LA8_7=='\"') ) {s = 20;}

                        else if ( (LA8_7=='<') ) {s = 21;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA8_28 = input.LA(1);

                        s = -1;
                        if ( (LA8_28=='\'') ) {s = 24;}

                        else if ( (LA8_28=='\\') ) {s = 22;}

                        else if ( ((LA8_28>='\u0000' && LA8_28<='&')||(LA8_28>='(' && LA8_28<=';')||(LA8_28>='=' && LA8_28<='[')||(LA8_28>=']' && LA8_28<='\uFFFF')) ) {s = 23;}

                        else if ( (LA8_28=='<') ) {s = 21;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA8_23 = input.LA(1);

                        s = -1;
                        if ( (LA8_23=='\'') ) {s = 24;}

                        else if ( (LA8_23=='\\') ) {s = 22;}

                        else if ( ((LA8_23>='\u0000' && LA8_23<='&')||(LA8_23>='(' && LA8_23<=';')||(LA8_23>='=' && LA8_23<='[')||(LA8_23>=']' && LA8_23<='\uFFFF')) ) {s = 23;}

                        else if ( (LA8_23=='<') ) {s = 21;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}