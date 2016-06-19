package org.eclipse.xtext.grammarinheritance.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalInheritanceTest3LanguageLexer extends Lexer {
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int SUPER_ID=4;
    public static final int RULE_INT=8;
    public static final int RULE_ML_COMMENT=9;
    public static final int SUPER_1_ID=5;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators

    public InternalInheritanceTest3LanguageLexer() {;} 
    public InternalInheritanceTest3LanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalInheritanceTest3LanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalInheritanceTest3Language.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalInheritanceTest3Language.g:11:7: ( 'element' )
            // InternalInheritanceTest3Language.g:11:9: 'element'
            {
            match("element"); 


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
            // InternalInheritanceTest3Language.g:12:7: ( 'model' )
            // InternalInheritanceTest3Language.g:12:9: 'model'
            {
            match("model"); 


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
            // InternalInheritanceTest3Language.g:13:7: ( '{' )
            // InternalInheritanceTest3Language.g:13:9: '{'
            {
            match('{'); 

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
            // InternalInheritanceTest3Language.g:14:7: ( '}' )
            // InternalInheritanceTest3Language.g:14:9: '}'
            {
            match('}'); 

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
            // InternalInheritanceTest3Language.g:327:9: ( 'id' )
            // InternalInheritanceTest3Language.g:327:11: 'id'
            {
            match("id"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "SUPER_ID"
    public final void mSUPER_ID() throws RecognitionException {
        try {
            int _type = SUPER_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalInheritanceTest3Language.g:329:10: ( ( 'a' .. 'z' )+ )
            // InternalInheritanceTest3Language.g:329:12: ( 'a' .. 'z' )+
            {
            // InternalInheritanceTest3Language.g:329:12: ( 'a' .. 'z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalInheritanceTest3Language.g:329:13: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

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
    // $ANTLR end "SUPER_ID"

    // $ANTLR start "SUPER_1_ID"
    public final void mSUPER_1_ID() throws RecognitionException {
        try {
            int _type = SUPER_1_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalInheritanceTest3Language.g:331:12: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalInheritanceTest3Language.g:331:14: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalInheritanceTest3Language.g:331:14: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalInheritanceTest3Language.g:331:14: '^'
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

            // InternalInheritanceTest3Language.g:331:43: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalInheritanceTest3Language.g:
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
    // $ANTLR end "SUPER_1_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalInheritanceTest3Language.g:333:10: ( ( '0' .. '9' )+ )
            // InternalInheritanceTest3Language.g:333:12: ( '0' .. '9' )+
            {
            // InternalInheritanceTest3Language.g:333:12: ( '0' .. '9' )+
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
            	    // InternalInheritanceTest3Language.g:333:13: '0' .. '9'
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
            // InternalInheritanceTest3Language.g:335:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalInheritanceTest3Language.g:335:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalInheritanceTest3Language.g:335:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalInheritanceTest3Language.g:335:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalInheritanceTest3Language.g:335:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalInheritanceTest3Language.g:335:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalInheritanceTest3Language.g:335:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalInheritanceTest3Language.g:335:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalInheritanceTest3Language.g:335:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalInheritanceTest3Language.g:335:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalInheritanceTest3Language.g:335:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalInheritanceTest3Language.g:337:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalInheritanceTest3Language.g:337:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalInheritanceTest3Language.g:337:24: ( options {greedy=false; } : . )*
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
            	    // InternalInheritanceTest3Language.g:337:52: .
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
            // InternalInheritanceTest3Language.g:339:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalInheritanceTest3Language.g:339:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalInheritanceTest3Language.g:339:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalInheritanceTest3Language.g:339:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalInheritanceTest3Language.g:339:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalInheritanceTest3Language.g:339:41: ( '\\r' )? '\\n'
                    {
                    // InternalInheritanceTest3Language.g:339:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalInheritanceTest3Language.g:339:41: '\\r'
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
            // InternalInheritanceTest3Language.g:341:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalInheritanceTest3Language.g:341:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalInheritanceTest3Language.g:341:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalInheritanceTest3Language.g:
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
            // InternalInheritanceTest3Language.g:343:16: ( . )
            // InternalInheritanceTest3Language.g:343:18: .
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
        // InternalInheritanceTest3Language.g:1:8: ( T__13 | T__14 | T__15 | T__16 | RULE_ID | SUPER_ID | SUPER_1_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=13;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // InternalInheritanceTest3Language.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalInheritanceTest3Language.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalInheritanceTest3Language.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalInheritanceTest3Language.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalInheritanceTest3Language.g:1:34: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 6 :
                // InternalInheritanceTest3Language.g:1:42: SUPER_ID
                {
                mSUPER_ID(); 

                }
                break;
            case 7 :
                // InternalInheritanceTest3Language.g:1:51: SUPER_1_ID
                {
                mSUPER_1_ID(); 

                }
                break;
            case 8 :
                // InternalInheritanceTest3Language.g:1:62: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 9 :
                // InternalInheritanceTest3Language.g:1:71: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 10 :
                // InternalInheritanceTest3Language.g:1:83: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 11 :
                // InternalInheritanceTest3Language.g:1:99: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 12 :
                // InternalInheritanceTest3Language.g:1:115: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 13 :
                // InternalInheritanceTest3Language.g:1:123: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\2\20\2\uffff\2\20\1\16\2\uffff\3\16\2\uffff\1\20\1\uffff\1\20\1\uffff\1\20\2\uffff\1\36\5\uffff\2\20\1\uffff\3\20\1\44\1\20\1\uffff\1\46\1\uffff";
    static final String DFA13_eofS =
        "\47\uffff";
    static final String DFA13_minS =
        "\1\0\2\60\2\uffff\2\60\1\101\2\uffff\2\0\1\52\2\uffff\1\60\1\uffff\1\60\1\uffff\1\60\2\uffff\1\60\5\uffff\2\60\1\uffff\5\60\1\uffff\1\60\1\uffff";
    static final String DFA13_maxS =
        "\1\uffff\2\172\2\uffff\3\172\2\uffff\2\uffff\1\57\2\uffff\1\172\1\uffff\1\172\1\uffff\1\172\2\uffff\1\172\5\uffff\2\172\1\uffff\5\172\1\uffff\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\3\uffff\1\3\1\4\3\uffff\1\7\1\10\3\uffff\1\14\1\15\1\uffff\1\6\1\uffff\1\7\1\uffff\1\3\1\4\1\uffff\1\10\1\11\1\12\1\13\1\14\2\uffff\1\5\5\uffff\1\2\1\uffff\1\1";
    static final String DFA13_specialS =
        "\1\1\11\uffff\1\0\1\2\33\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\16\2\15\2\16\1\15\22\16\1\15\1\16\1\12\4\16\1\13\7\16\1\14\12\11\7\16\32\10\3\16\1\7\1\10\1\16\4\6\1\1\3\6\1\5\3\6\1\2\15\6\1\3\1\16\1\4\uff82\16",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\13\21\1\17\16\21",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\16\21\1\23\13\21",
            "",
            "",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\3\21\1\26\26\21",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\21",
            "\32\22\4\uffff\1\22\1\uffff\32\22",
            "",
            "",
            "\0\30",
            "\0\30",
            "\1\31\4\uffff\1\32",
            "",
            "",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\4\21\1\34\25\21",
            "",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\21",
            "",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\3\21\1\35\26\21",
            "",
            "",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\21",
            "",
            "",
            "",
            "",
            "",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\14\21\1\37\15\21",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\4\21\1\40\25\21",
            "",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\4\21\1\41\25\21",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\13\21\1\42\16\21",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\15\21\1\43\14\21",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\21",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\23\21\1\45\6\21",
            "",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\21",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | RULE_ID | SUPER_ID | SUPER_1_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_10 = input.LA(1);

                        s = -1;
                        if ( ((LA13_10>='\u0000' && LA13_10<='\uFFFF')) ) {s = 24;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( (LA13_0=='e') ) {s = 1;}

                        else if ( (LA13_0=='m') ) {s = 2;}

                        else if ( (LA13_0=='{') ) {s = 3;}

                        else if ( (LA13_0=='}') ) {s = 4;}

                        else if ( (LA13_0=='i') ) {s = 5;}

                        else if ( ((LA13_0>='a' && LA13_0<='d')||(LA13_0>='f' && LA13_0<='h')||(LA13_0>='j' && LA13_0<='l')||(LA13_0>='n' && LA13_0<='z')) ) {s = 6;}

                        else if ( (LA13_0=='^') ) {s = 7;}

                        else if ( ((LA13_0>='A' && LA13_0<='Z')||LA13_0=='_') ) {s = 8;}

                        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {s = 9;}

                        else if ( (LA13_0=='\"') ) {s = 10;}

                        else if ( (LA13_0=='\'') ) {s = 11;}

                        else if ( (LA13_0=='/') ) {s = 12;}

                        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {s = 13;}

                        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||(LA13_0>='#' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='.')||(LA13_0>=':' && LA13_0<='@')||(LA13_0>='[' && LA13_0<=']')||LA13_0=='`'||LA13_0=='|'||(LA13_0>='~' && LA13_0<='\uFFFF')) ) {s = 14;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_11 = input.LA(1);

                        s = -1;
                        if ( ((LA13_11>='\u0000' && LA13_11<='\uFFFF')) ) {s = 24;}

                        else s = 14;

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