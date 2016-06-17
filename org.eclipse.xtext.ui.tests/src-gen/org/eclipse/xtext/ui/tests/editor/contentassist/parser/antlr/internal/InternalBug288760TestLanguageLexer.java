package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug288760TestLanguageLexer extends Lexer {
    public static final int RULE_ID=8;
    public static final int RULE_STRING=10;
    public static final int RULE_END_TAG=7;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_GT=6;
    public static final int RULE_EQ=9;
    public static final int RULE_INT=14;
    public static final int RULE_WS=15;
    public static final int EOF=-1;
    public static final int RULE_END_TAG_START=13;
    public static final int RULE_END_TAG_SHORT=5;
    public static final int RULE_START_TAG=4;
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_LT=12;

    // delegates
    // delegators

    public InternalBug288760TestLanguageLexer() {;} 
    public InternalBug288760TestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBug288760TestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBug288760TestLanguage.g"; }

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug288760TestLanguage.g:265:17: ( '<!--' ( options {greedy=false; } : . )* '-->' )
            // InternalBug288760TestLanguage.g:265:19: '<!--' ( options {greedy=false; } : . )* '-->'
            {
            match("<!--"); 

            // InternalBug288760TestLanguage.g:265:26: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='-') ) {
                        int LA1_3 = input.LA(3);

                        if ( (LA1_3=='>') ) {
                            alt1=2;
                        }
                        else if ( ((LA1_3>='\u0000' && LA1_3<='=')||(LA1_3>='?' && LA1_3<='\uFFFF')) ) {
                            alt1=1;
                        }


                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<=',')||(LA1_1>='.' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=',')||(LA1_0>='.' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug288760TestLanguage.g:265:54: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match("-->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_START_TAG"
    public final void mRULE_START_TAG() throws RecognitionException {
        try {
            int _type = RULE_START_TAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug288760TestLanguage.g:267:16: ( RULE_LT RULE_ID )
            // InternalBug288760TestLanguage.g:267:18: RULE_LT RULE_ID
            {
            mRULE_LT(); 
            mRULE_ID(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_START_TAG"

    // $ANTLR start "RULE_LT"
    public final void mRULE_LT() throws RecognitionException {
        try {
            // InternalBug288760TestLanguage.g:269:18: ( '<' )
            // InternalBug288760TestLanguage.g:269:20: '<'
            {
            match('<'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LT"

    // $ANTLR start "RULE_GT"
    public final void mRULE_GT() throws RecognitionException {
        try {
            int _type = RULE_GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug288760TestLanguage.g:271:9: ( '>' )
            // InternalBug288760TestLanguage.g:271:11: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_GT"

    // $ANTLR start "RULE_EQ"
    public final void mRULE_EQ() throws RecognitionException {
        try {
            int _type = RULE_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug288760TestLanguage.g:273:9: ( '=' )
            // InternalBug288760TestLanguage.g:273:11: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EQ"

    // $ANTLR start "RULE_END_TAG_SHORT"
    public final void mRULE_END_TAG_SHORT() throws RecognitionException {
        try {
            int _type = RULE_END_TAG_SHORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug288760TestLanguage.g:275:20: ( '/>' )
            // InternalBug288760TestLanguage.g:275:22: '/>'
            {
            match("/>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_END_TAG_SHORT"

    // $ANTLR start "RULE_END_TAG_START"
    public final void mRULE_END_TAG_START() throws RecognitionException {
        try {
            // InternalBug288760TestLanguage.g:277:29: ( '</' )
            // InternalBug288760TestLanguage.g:277:31: '</'
            {
            match("</"); 


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_END_TAG_START"

    // $ANTLR start "RULE_END_TAG"
    public final void mRULE_END_TAG() throws RecognitionException {
        try {
            int _type = RULE_END_TAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug288760TestLanguage.g:279:14: ( RULE_END_TAG_START RULE_ID RULE_GT )
            // InternalBug288760TestLanguage.g:279:16: RULE_END_TAG_START RULE_ID RULE_GT
            {
            mRULE_END_TAG_START(); 
            mRULE_ID(); 
            mRULE_GT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_END_TAG"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug288760TestLanguage.g:281:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalBug288760TestLanguage.g:281:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalBug288760TestLanguage.g:281:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug288760TestLanguage.g:281:11: '^'
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

            // InternalBug288760TestLanguage.g:281:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug288760TestLanguage.g:
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
            // InternalBug288760TestLanguage.g:283:10: ( ( '0' .. '9' )+ )
            // InternalBug288760TestLanguage.g:283:12: ( '0' .. '9' )+
            {
            // InternalBug288760TestLanguage.g:283:12: ( '0' .. '9' )+
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
            	    // InternalBug288760TestLanguage.g:283:13: '0' .. '9'
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
            // InternalBug288760TestLanguage.g:285:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalBug288760TestLanguage.g:285:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalBug288760TestLanguage.g:285:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalBug288760TestLanguage.g:285:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalBug288760TestLanguage.g:285:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalBug288760TestLanguage.g:285:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBug288760TestLanguage.g:285:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalBug288760TestLanguage.g:285:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalBug288760TestLanguage.g:285:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalBug288760TestLanguage.g:285:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBug288760TestLanguage.g:285:129: ~ ( ( '\\\\' | '\\'' ) )
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug288760TestLanguage.g:287:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalBug288760TestLanguage.g:287:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalBug288760TestLanguage.g:287:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0=='\r'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBug288760TestLanguage.g:
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
            // InternalBug288760TestLanguage.g:289:16: ( . )
            // InternalBug288760TestLanguage.g:289:18: .
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
        // InternalBug288760TestLanguage.g:1:8: ( RULE_ML_COMMENT | RULE_START_TAG | RULE_GT | RULE_EQ | RULE_END_TAG_SHORT | RULE_END_TAG | RULE_ID | RULE_INT | RULE_STRING | RULE_WS | RULE_ANY_OTHER )
        int alt9=11;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // InternalBug288760TestLanguage.g:1:10: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 2 :
                // InternalBug288760TestLanguage.g:1:26: RULE_START_TAG
                {
                mRULE_START_TAG(); 

                }
                break;
            case 3 :
                // InternalBug288760TestLanguage.g:1:41: RULE_GT
                {
                mRULE_GT(); 

                }
                break;
            case 4 :
                // InternalBug288760TestLanguage.g:1:49: RULE_EQ
                {
                mRULE_EQ(); 

                }
                break;
            case 5 :
                // InternalBug288760TestLanguage.g:1:57: RULE_END_TAG_SHORT
                {
                mRULE_END_TAG_SHORT(); 

                }
                break;
            case 6 :
                // InternalBug288760TestLanguage.g:1:76: RULE_END_TAG
                {
                mRULE_END_TAG(); 

                }
                break;
            case 7 :
                // InternalBug288760TestLanguage.g:1:89: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 8 :
                // InternalBug288760TestLanguage.g:1:97: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 9 :
                // InternalBug288760TestLanguage.g:1:106: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 10 :
                // InternalBug288760TestLanguage.g:1:118: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 11 :
                // InternalBug288760TestLanguage.g:1:126: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\1\13\2\uffff\2\13\2\uffff\2\13\14\uffff";
    static final String DFA9_eofS =
        "\26\uffff";
    static final String DFA9_minS =
        "\1\0\1\41\2\uffff\1\76\1\101\2\uffff\2\0\14\uffff";
    static final String DFA9_maxS =
        "\1\uffff\1\172\2\uffff\1\76\1\172\2\uffff\2\uffff\14\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\3\1\4\2\uffff\1\7\1\10\2\uffff\1\12\1\13\1\1\1\6\1\2\1\3\1\4\1\5\1\7\1\10\1\11\1\12";
    static final String DFA9_specialS =
        "\1\2\7\uffff\1\0\1\1\14\uffff}>";
    static final String[] DFA9_transitionS = {
            "\11\13\2\12\2\13\1\12\22\13\1\12\1\13\1\10\4\13\1\11\7\13\1\4\12\7\2\13\1\1\1\3\1\2\2\13\32\6\3\13\1\5\1\6\1\13\32\6\uff85\13",
            "\1\14\15\uffff\1\15\21\uffff\32\16\3\uffff\2\16\1\uffff\32\16",
            "",
            "",
            "\1\21",
            "\32\22\4\uffff\1\22\1\uffff\32\22",
            "",
            "",
            "\0\24",
            "\0\24",
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
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    static class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_ML_COMMENT | RULE_START_TAG | RULE_GT | RULE_EQ | RULE_END_TAG_SHORT | RULE_END_TAG | RULE_ID | RULE_INT | RULE_STRING | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_8 = input.LA(1);

                        s = -1;
                        if ( ((LA9_8>='\u0000' && LA9_8<='\uFFFF')) ) {s = 20;}

                        else s = 11;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_9 = input.LA(1);

                        s = -1;
                        if ( ((LA9_9>='\u0000' && LA9_9<='\uFFFF')) ) {s = 20;}

                        else s = 11;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_0 = input.LA(1);

                        s = -1;
                        if ( (LA9_0=='<') ) {s = 1;}

                        else if ( (LA9_0=='>') ) {s = 2;}

                        else if ( (LA9_0=='=') ) {s = 3;}

                        else if ( (LA9_0=='/') ) {s = 4;}

                        else if ( (LA9_0=='^') ) {s = 5;}

                        else if ( ((LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {s = 6;}

                        else if ( ((LA9_0>='0' && LA9_0<='9')) ) {s = 7;}

                        else if ( (LA9_0=='\"') ) {s = 8;}

                        else if ( (LA9_0=='\'') ) {s = 9;}

                        else if ( ((LA9_0>='\t' && LA9_0<='\n')||LA9_0=='\r'||LA9_0==' ') ) {s = 10;}

                        else if ( ((LA9_0>='\u0000' && LA9_0<='\b')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\u001F')||LA9_0=='!'||(LA9_0>='#' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='.')||(LA9_0>=':' && LA9_0<=';')||(LA9_0>='?' && LA9_0<='@')||(LA9_0>='[' && LA9_0<=']')||LA9_0=='`'||(LA9_0>='{' && LA9_0<='\uFFFF')) ) {s = 11;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}