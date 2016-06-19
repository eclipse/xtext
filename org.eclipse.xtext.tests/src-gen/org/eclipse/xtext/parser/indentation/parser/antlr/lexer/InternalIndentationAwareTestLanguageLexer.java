package org.eclipse.xtext.parser.indentation.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIndentationAwareTestLanguageLexer extends Lexer {
    public static final int RULE_DEDENT=6;
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_STRING=9;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_SL_COMMENT=4;
    public static final int RULE_INT=8;
    public static final int RULE_ML_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_INDENT=5;

    // delegates
    // delegators

    public InternalIndentationAwareTestLanguageLexer() {;} 
    public InternalIndentationAwareTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalIndentationAwareTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalIndentationAwareTestLanguageLexer.g"; }

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIndentationAwareTestLanguageLexer.g:21:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalIndentationAwareTestLanguageLexer.g:21:19: '//' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match("//"); 

            // InternalIndentationAwareTestLanguageLexer.g:21:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIndentationAwareTestLanguageLexer.g:21:24: ~ ( ( '\\n' | '\\r' ) )
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
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_INDENT"
    public final void mRULE_INDENT() throws RecognitionException {
        try {
            // InternalIndentationAwareTestLanguageLexer.g:23:22: ()
            // InternalIndentationAwareTestLanguageLexer.g:23:24: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_INDENT"

    // $ANTLR start "RULE_DEDENT"
    public final void mRULE_DEDENT() throws RecognitionException {
        try {
            // InternalIndentationAwareTestLanguageLexer.g:25:22: ()
            // InternalIndentationAwareTestLanguageLexer.g:25:24: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DEDENT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIndentationAwareTestLanguageLexer.g:27:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalIndentationAwareTestLanguageLexer.g:27:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalIndentationAwareTestLanguageLexer.g:27:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalIndentationAwareTestLanguageLexer.g:27:11: '^'
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

            // InternalIndentationAwareTestLanguageLexer.g:27:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalIndentationAwareTestLanguageLexer.g:
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
            // InternalIndentationAwareTestLanguageLexer.g:29:10: ( ( '0' .. '9' )+ )
            // InternalIndentationAwareTestLanguageLexer.g:29:12: ( '0' .. '9' )+
            {
            // InternalIndentationAwareTestLanguageLexer.g:29:12: ( '0' .. '9' )+
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
            	    // InternalIndentationAwareTestLanguageLexer.g:29:13: '0' .. '9'
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
            // InternalIndentationAwareTestLanguageLexer.g:31:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalIndentationAwareTestLanguageLexer.g:31:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalIndentationAwareTestLanguageLexer.g:31:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalIndentationAwareTestLanguageLexer.g:31:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalIndentationAwareTestLanguageLexer.g:31:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalIndentationAwareTestLanguageLexer.g:31:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalIndentationAwareTestLanguageLexer.g:31:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalIndentationAwareTestLanguageLexer.g:31:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalIndentationAwareTestLanguageLexer.g:31:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalIndentationAwareTestLanguageLexer.g:31:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalIndentationAwareTestLanguageLexer.g:31:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalIndentationAwareTestLanguageLexer.g:33:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalIndentationAwareTestLanguageLexer.g:33:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalIndentationAwareTestLanguageLexer.g:33:24: ( options {greedy=false; } : . )*
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
            	    // InternalIndentationAwareTestLanguageLexer.g:33:52: .
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIndentationAwareTestLanguageLexer.g:35:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalIndentationAwareTestLanguageLexer.g:35:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalIndentationAwareTestLanguageLexer.g:35:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\t' && LA9_0<='\n')||LA9_0=='\r'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalIndentationAwareTestLanguageLexer.g:
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
            // InternalIndentationAwareTestLanguageLexer.g:37:16: ( . )
            // InternalIndentationAwareTestLanguageLexer.g:37:18: .
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
        // InternalIndentationAwareTestLanguageLexer.g:1:8: ( RULE_SL_COMMENT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt10=7;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // InternalIndentationAwareTestLanguageLexer.g:1:10: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 2 :
                // InternalIndentationAwareTestLanguageLexer.g:1:26: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 3 :
                // InternalIndentationAwareTestLanguageLexer.g:1:34: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 4 :
                // InternalIndentationAwareTestLanguageLexer.g:1:43: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 5 :
                // InternalIndentationAwareTestLanguageLexer.g:1:55: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 6 :
                // InternalIndentationAwareTestLanguageLexer.g:1:71: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 7 :
                // InternalIndentationAwareTestLanguageLexer.g:1:79: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\uffff\2\10\2\uffff\2\10\10\uffff";
    static final String DFA10_eofS =
        "\17\uffff";
    static final String DFA10_minS =
        "\1\0\1\52\1\101\2\uffff\2\0\10\uffff";
    static final String DFA10_maxS =
        "\1\uffff\1\57\1\172\2\uffff\2\uffff\10\uffff";
    static final String DFA10_acceptS =
        "\3\uffff\1\2\1\3\2\uffff\1\6\1\7\1\1\1\5\1\2\1\3\1\4\1\6";
    static final String DFA10_specialS =
        "\1\2\4\uffff\1\0\1\1\10\uffff}>";
    static final String[] DFA10_transitionS = {
            "\11\10\2\7\2\10\1\7\22\10\1\7\1\10\1\5\4\10\1\6\7\10\1\1\12\4\7\10\32\3\3\10\1\2\1\3\1\10\32\3\uff85\10",
            "\1\12\4\uffff\1\11",
            "\32\13\4\uffff\1\13\1\uffff\32\13",
            "",
            "",
            "\0\15",
            "\0\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    static class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_SL_COMMENT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_5 = input.LA(1);

                        s = -1;
                        if ( ((LA10_5>='\u0000' && LA10_5<='\uFFFF')) ) {s = 13;}

                        else s = 8;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_6 = input.LA(1);

                        s = -1;
                        if ( ((LA10_6>='\u0000' && LA10_6<='\uFFFF')) ) {s = 13;}

                        else s = 8;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_0 = input.LA(1);

                        s = -1;
                        if ( (LA10_0=='/') ) {s = 1;}

                        else if ( (LA10_0=='^') ) {s = 2;}

                        else if ( ((LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {s = 3;}

                        else if ( ((LA10_0>='0' && LA10_0<='9')) ) {s = 4;}

                        else if ( (LA10_0=='\"') ) {s = 5;}

                        else if ( (LA10_0=='\'') ) {s = 6;}

                        else if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {s = 7;}

                        else if ( ((LA10_0>='\u0000' && LA10_0<='\b')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\u001F')||LA10_0=='!'||(LA10_0>='#' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='.')||(LA10_0>=':' && LA10_0<='@')||(LA10_0>='[' && LA10_0<=']')||LA10_0=='`'||(LA10_0>='{' && LA10_0<='\uFFFF')) ) {s = 8;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}