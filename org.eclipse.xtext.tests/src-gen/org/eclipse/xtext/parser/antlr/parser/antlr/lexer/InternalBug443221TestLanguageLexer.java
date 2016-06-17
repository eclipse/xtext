package org.eclipse.xtext.parser.antlr.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug443221TestLanguageLexer extends Lexer {
    public static final int RULE_ID=11;
    public static final int RULE_WS=16;
    public static final int KW___dummy___1=4;
    public static final int RULE_STRING=13;
    public static final int RULE_ANY_OTHER=17;
    public static final int DollarSign_1=5;
    public static final int KW__dummy_=7;
    public static final int KW__=10;
    public static final int RULE_SL_COMMENT=15;
    public static final int KW___dummy__=6;
    public static final int RULE_INT=12;
    public static final int DollarSign=9;
    public static final int RULE_ML_COMMENT=14;
    public static final int EOF=-1;
    public static final int Dummy=8;

    // delegates
    // delegators

    public InternalBug443221TestLanguageLexer() {;} 
    public InternalBug443221TestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBug443221TestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBug443221TestLanguageLexer.g"; }

    // $ANTLR start "KW___dummy___1"
    public final void mKW___dummy___1() throws RecognitionException {
        try {
            int _type = KW___dummy___1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug443221TestLanguageLexer.g:19:16: ( '$__dummy__' )
            // InternalBug443221TestLanguageLexer.g:19:18: '$__dummy__'
            {
            match("$__dummy__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW___dummy___1"

    // $ANTLR start "DollarSign_1"
    public final void mDollarSign_1() throws RecognitionException {
        try {
            int _type = DollarSign_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug443221TestLanguageLexer.g:21:14: ( 'DollarSign' )
            // InternalBug443221TestLanguageLexer.g:21:16: 'DollarSign'
            {
            match("DollarSign"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DollarSign_1"

    // $ANTLR start "KW___dummy__"
    public final void mKW___dummy__() throws RecognitionException {
        try {
            int _type = KW___dummy__;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug443221TestLanguageLexer.g:23:14: ( '__dummy__' )
            // InternalBug443221TestLanguageLexer.g:23:16: '__dummy__'
            {
            match("__dummy__"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW___dummy__"

    // $ANTLR start "KW__dummy_"
    public final void mKW__dummy_() throws RecognitionException {
        try {
            int _type = KW__dummy_;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug443221TestLanguageLexer.g:25:12: ( '_dummy_' )
            // InternalBug443221TestLanguageLexer.g:25:14: '_dummy_'
            {
            match("_dummy_"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW__dummy_"

    // $ANTLR start "Dummy"
    public final void mDummy() throws RecognitionException {
        try {
            int _type = Dummy;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug443221TestLanguageLexer.g:27:7: ( 'dummy' )
            // InternalBug443221TestLanguageLexer.g:27:9: 'dummy'
            {
            match("dummy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Dummy"

    // $ANTLR start "DollarSign"
    public final void mDollarSign() throws RecognitionException {
        try {
            int _type = DollarSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug443221TestLanguageLexer.g:29:12: ( '$' )
            // InternalBug443221TestLanguageLexer.g:29:14: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DollarSign"

    // $ANTLR start "KW__"
    public final void mKW__() throws RecognitionException {
        try {
            int _type = KW__;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug443221TestLanguageLexer.g:31:6: ( '_' )
            // InternalBug443221TestLanguageLexer.g:31:8: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW__"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug443221TestLanguageLexer.g:35:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalBug443221TestLanguageLexer.g:35:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalBug443221TestLanguageLexer.g:35:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug443221TestLanguageLexer.g:35:11: '^'
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

            // InternalBug443221TestLanguageLexer.g:35:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug443221TestLanguageLexer.g:
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug443221TestLanguageLexer.g:37:10: ( ( '0' .. '9' )+ )
            // InternalBug443221TestLanguageLexer.g:37:12: ( '0' .. '9' )+
            {
            // InternalBug443221TestLanguageLexer.g:37:12: ( '0' .. '9' )+
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
            	    // InternalBug443221TestLanguageLexer.g:37:13: '0' .. '9'
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
            // InternalBug443221TestLanguageLexer.g:39:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalBug443221TestLanguageLexer.g:39:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalBug443221TestLanguageLexer.g:39:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBug443221TestLanguageLexer.g:39:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalBug443221TestLanguageLexer.g:39:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalBug443221TestLanguageLexer.g:39:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBug443221TestLanguageLexer.g:39:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalBug443221TestLanguageLexer.g:39:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalBug443221TestLanguageLexer.g:39:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalBug443221TestLanguageLexer.g:39:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBug443221TestLanguageLexer.g:39:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop5;
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
            // InternalBug443221TestLanguageLexer.g:41:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalBug443221TestLanguageLexer.g:41:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalBug443221TestLanguageLexer.g:41:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBug443221TestLanguageLexer.g:41:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // InternalBug443221TestLanguageLexer.g:43:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalBug443221TestLanguageLexer.g:43:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalBug443221TestLanguageLexer.g:43:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBug443221TestLanguageLexer.g:43:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop8;
                }
            } while (true);

            // InternalBug443221TestLanguageLexer.g:43:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBug443221TestLanguageLexer.g:43:41: ( '\\r' )? '\\n'
                    {
                    // InternalBug443221TestLanguageLexer.g:43:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalBug443221TestLanguageLexer.g:43:41: '\\r'
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
            // InternalBug443221TestLanguageLexer.g:45:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalBug443221TestLanguageLexer.g:45:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalBug443221TestLanguageLexer.g:45:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug443221TestLanguageLexer.g:
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            // InternalBug443221TestLanguageLexer.g:47:16: ( . )
            // InternalBug443221TestLanguageLexer.g:47:18: .
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
        // InternalBug443221TestLanguageLexer.g:1:8: ( KW___dummy___1 | DollarSign_1 | KW___dummy__ | KW__dummy_ | Dummy | DollarSign | KW__ | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=14;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalBug443221TestLanguageLexer.g:1:10: KW___dummy___1
                {
                mKW___dummy___1(); 

                }
                break;
            case 2 :
                // InternalBug443221TestLanguageLexer.g:1:25: DollarSign_1
                {
                mDollarSign_1(); 

                }
                break;
            case 3 :
                // InternalBug443221TestLanguageLexer.g:1:38: KW___dummy__
                {
                mKW___dummy__(); 

                }
                break;
            case 4 :
                // InternalBug443221TestLanguageLexer.g:1:51: KW__dummy_
                {
                mKW__dummy_(); 

                }
                break;
            case 5 :
                // InternalBug443221TestLanguageLexer.g:1:62: Dummy
                {
                mDummy(); 

                }
                break;
            case 6 :
                // InternalBug443221TestLanguageLexer.g:1:68: DollarSign
                {
                mDollarSign(); 

                }
                break;
            case 7 :
                // InternalBug443221TestLanguageLexer.g:1:79: KW__
                {
                mKW__(); 

                }
                break;
            case 8 :
                // InternalBug443221TestLanguageLexer.g:1:84: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 9 :
                // InternalBug443221TestLanguageLexer.g:1:92: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 10 :
                // InternalBug443221TestLanguageLexer.g:1:101: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 11 :
                // InternalBug443221TestLanguageLexer.g:1:113: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 12 :
                // InternalBug443221TestLanguageLexer.g:1:129: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 13 :
                // InternalBug443221TestLanguageLexer.g:1:145: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 14 :
                // InternalBug443221TestLanguageLexer.g:1:153: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\16\1\20\1\23\1\20\1\14\2\uffff\3\14\4\uffff\1\20\1\uffff\2\20\1\uffff\1\20\5\uffff\13\20\1\51\3\20\1\uffff\2\20\1\57\2\20\1\uffff\1\20\1\63\1\64\2\uffff";
    static final String DFA12_eofS =
        "\65\uffff";
    static final String DFA12_minS =
        "\1\0\1\137\1\157\1\60\1\165\1\101\2\uffff\2\0\1\52\4\uffff\1\154\1\uffff\1\144\1\165\1\uffff\1\155\5\uffff\1\154\1\165\2\155\1\141\2\155\1\171\1\162\1\155\1\171\1\60\1\123\1\171\1\137\1\uffff\1\151\1\137\1\60\1\147\1\137\1\uffff\1\156\2\60\2\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\137\1\157\1\172\1\165\1\172\2\uffff\2\uffff\1\57\4\uffff\1\154\1\uffff\1\144\1\165\1\uffff\1\155\5\uffff\1\154\1\165\2\155\1\141\2\155\1\171\1\162\1\155\1\171\1\172\1\123\1\171\1\137\1\uffff\1\151\1\137\1\172\1\147\1\137\1\uffff\1\156\2\172\2\uffff";
    static final String DFA12_acceptS =
        "\6\uffff\1\10\1\11\3\uffff\1\15\1\16\1\1\1\6\1\uffff\1\10\2\uffff\1\7\1\uffff\1\11\1\12\1\13\1\14\1\15\17\uffff\1\5\5\uffff\1\4\3\uffff\1\3\1\2";
    static final String DFA12_specialS =
        "\1\2\7\uffff\1\0\1\1\53\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\14\2\13\2\14\1\13\22\14\1\13\1\14\1\10\1\14\1\1\2\14\1\11\7\14\1\12\12\7\7\14\3\6\1\2\26\6\3\14\1\5\1\3\1\14\3\6\1\4\26\6\uff85\14",
            "\1\15",
            "\1\17",
            "\12\20\7\uffff\32\20\4\uffff\1\21\1\uffff\3\20\1\22\26\20",
            "\1\24",
            "\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "",
            "\0\26",
            "\0\26",
            "\1\27\4\uffff\1\30",
            "",
            "",
            "",
            "",
            "\1\32",
            "",
            "\1\33",
            "\1\34",
            "",
            "\1\35",
            "",
            "",
            "",
            "",
            "",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\52",
            "\1\53",
            "\1\54",
            "",
            "\1\55",
            "\1\56",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\60",
            "\1\61",
            "",
            "\1\62",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    static class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( KW___dummy___1 | DollarSign_1 | KW___dummy__ | KW__dummy_ | Dummy | DollarSign | KW__ | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_8 = input.LA(1);

                        s = -1;
                        if ( ((LA12_8>='\u0000' && LA12_8<='\uFFFF')) ) {s = 22;}

                        else s = 12;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_9 = input.LA(1);

                        s = -1;
                        if ( ((LA12_9>='\u0000' && LA12_9<='\uFFFF')) ) {s = 22;}

                        else s = 12;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='$') ) {s = 1;}

                        else if ( (LA12_0=='D') ) {s = 2;}

                        else if ( (LA12_0=='_') ) {s = 3;}

                        else if ( (LA12_0=='d') ) {s = 4;}

                        else if ( (LA12_0=='^') ) {s = 5;}

                        else if ( ((LA12_0>='A' && LA12_0<='C')||(LA12_0>='E' && LA12_0<='Z')||(LA12_0>='a' && LA12_0<='c')||(LA12_0>='e' && LA12_0<='z')) ) {s = 6;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 7;}

                        else if ( (LA12_0=='\"') ) {s = 8;}

                        else if ( (LA12_0=='\'') ) {s = 9;}

                        else if ( (LA12_0=='/') ) {s = 10;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 11;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||LA12_0=='#'||(LA12_0>='%' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}