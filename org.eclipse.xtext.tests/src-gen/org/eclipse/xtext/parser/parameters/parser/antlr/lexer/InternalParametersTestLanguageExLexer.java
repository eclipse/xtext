package org.eclipse.xtext.parser.parameters.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalParametersTestLanguageExLexer extends Lexer {
    public static final int NumberSignDigitSeven=14;
    public static final int NumberSignDigitThree=10;
    public static final int NumberSignDigitFive=12;
    public static final int NumberSignDigitNine=16;
    public static final int NumberSignDigitOneDigitOne=6;
    public static final int RULE_STRING=19;
    public static final int NumberSignDigitEight=15;
    public static final int RULE_SL_COMMENT=21;
    public static final int NumberSignDigitFour=11;
    public static final int EOF=-1;
    public static final int NumberSignDigitOneDigitZero=5;
    public static final int Keyword=4;
    public static final int RULE_ID=17;
    public static final int RULE_WS=22;
    public static final int NumberSignDigitTwo=9;
    public static final int RULE_ANY_OTHER=23;
    public static final int NumberSignDigitOneDigitTwo=7;
    public static final int RULE_INT=18;
    public static final int RULE_ML_COMMENT=20;
    public static final int NumberSignDigitSix=13;
    public static final int NumberSignDigitOne=8;

    // delegates
    // delegators

    public InternalParametersTestLanguageExLexer() {;} 
    public InternalParametersTestLanguageExLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalParametersTestLanguageExLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalParametersTestLanguageExLexer.g"; }

    // $ANTLR start "Keyword"
    public final void mKeyword() throws RecognitionException {
        try {
            int _type = Keyword;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:19:9: ( 'keyword' )
            // InternalParametersTestLanguageExLexer.g:19:11: 'keyword'
            {
            match("keyword"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Keyword"

    // $ANTLR start "NumberSignDigitOneDigitZero"
    public final void mNumberSignDigitOneDigitZero() throws RecognitionException {
        try {
            int _type = NumberSignDigitOneDigitZero;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:21:29: ( '#10' )
            // InternalParametersTestLanguageExLexer.g:21:31: '#10'
            {
            match("#10"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitOneDigitZero"

    // $ANTLR start "NumberSignDigitOneDigitOne"
    public final void mNumberSignDigitOneDigitOne() throws RecognitionException {
        try {
            int _type = NumberSignDigitOneDigitOne;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:23:28: ( '#11' )
            // InternalParametersTestLanguageExLexer.g:23:30: '#11'
            {
            match("#11"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitOneDigitOne"

    // $ANTLR start "NumberSignDigitOneDigitTwo"
    public final void mNumberSignDigitOneDigitTwo() throws RecognitionException {
        try {
            int _type = NumberSignDigitOneDigitTwo;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:25:28: ( '#12' )
            // InternalParametersTestLanguageExLexer.g:25:30: '#12'
            {
            match("#12"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitOneDigitTwo"

    // $ANTLR start "NumberSignDigitOne"
    public final void mNumberSignDigitOne() throws RecognitionException {
        try {
            int _type = NumberSignDigitOne;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:27:20: ( '#1' )
            // InternalParametersTestLanguageExLexer.g:27:22: '#1'
            {
            match("#1"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitOne"

    // $ANTLR start "NumberSignDigitTwo"
    public final void mNumberSignDigitTwo() throws RecognitionException {
        try {
            int _type = NumberSignDigitTwo;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:29:20: ( '#2' )
            // InternalParametersTestLanguageExLexer.g:29:22: '#2'
            {
            match("#2"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitTwo"

    // $ANTLR start "NumberSignDigitThree"
    public final void mNumberSignDigitThree() throws RecognitionException {
        try {
            int _type = NumberSignDigitThree;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:31:22: ( '#3' )
            // InternalParametersTestLanguageExLexer.g:31:24: '#3'
            {
            match("#3"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitThree"

    // $ANTLR start "NumberSignDigitFour"
    public final void mNumberSignDigitFour() throws RecognitionException {
        try {
            int _type = NumberSignDigitFour;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:33:21: ( '#4' )
            // InternalParametersTestLanguageExLexer.g:33:23: '#4'
            {
            match("#4"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitFour"

    // $ANTLR start "NumberSignDigitFive"
    public final void mNumberSignDigitFive() throws RecognitionException {
        try {
            int _type = NumberSignDigitFive;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:35:21: ( '#5' )
            // InternalParametersTestLanguageExLexer.g:35:23: '#5'
            {
            match("#5"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitFive"

    // $ANTLR start "NumberSignDigitSix"
    public final void mNumberSignDigitSix() throws RecognitionException {
        try {
            int _type = NumberSignDigitSix;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:37:20: ( '#6' )
            // InternalParametersTestLanguageExLexer.g:37:22: '#6'
            {
            match("#6"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitSix"

    // $ANTLR start "NumberSignDigitSeven"
    public final void mNumberSignDigitSeven() throws RecognitionException {
        try {
            int _type = NumberSignDigitSeven;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:39:22: ( '#7' )
            // InternalParametersTestLanguageExLexer.g:39:24: '#7'
            {
            match("#7"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitSeven"

    // $ANTLR start "NumberSignDigitEight"
    public final void mNumberSignDigitEight() throws RecognitionException {
        try {
            int _type = NumberSignDigitEight;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:41:22: ( '#8' )
            // InternalParametersTestLanguageExLexer.g:41:24: '#8'
            {
            match("#8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitEight"

    // $ANTLR start "NumberSignDigitNine"
    public final void mNumberSignDigitNine() throws RecognitionException {
        try {
            int _type = NumberSignDigitNine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:43:21: ( '#9' )
            // InternalParametersTestLanguageExLexer.g:43:23: '#9'
            {
            match("#9"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitNine"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:47:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalParametersTestLanguageExLexer.g:47:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalParametersTestLanguageExLexer.g:47:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalParametersTestLanguageExLexer.g:47:11: '^'
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

            // InternalParametersTestLanguageExLexer.g:47:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalParametersTestLanguageExLexer.g:
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
            // InternalParametersTestLanguageExLexer.g:49:10: ( ( '0' .. '9' )+ )
            // InternalParametersTestLanguageExLexer.g:49:12: ( '0' .. '9' )+
            {
            // InternalParametersTestLanguageExLexer.g:49:12: ( '0' .. '9' )+
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
            	    // InternalParametersTestLanguageExLexer.g:49:13: '0' .. '9'
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
            // InternalParametersTestLanguageExLexer.g:51:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalParametersTestLanguageExLexer.g:51:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalParametersTestLanguageExLexer.g:51:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalParametersTestLanguageExLexer.g:51:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalParametersTestLanguageExLexer.g:51:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalParametersTestLanguageExLexer.g:51:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalParametersTestLanguageExLexer.g:51:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalParametersTestLanguageExLexer.g:51:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalParametersTestLanguageExLexer.g:51:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalParametersTestLanguageExLexer.g:51:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalParametersTestLanguageExLexer.g:51:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalParametersTestLanguageExLexer.g:53:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalParametersTestLanguageExLexer.g:53:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalParametersTestLanguageExLexer.g:53:24: ( options {greedy=false; } : . )*
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
            	    // InternalParametersTestLanguageExLexer.g:53:52: .
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
            // InternalParametersTestLanguageExLexer.g:55:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalParametersTestLanguageExLexer.g:55:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalParametersTestLanguageExLexer.g:55:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalParametersTestLanguageExLexer.g:55:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalParametersTestLanguageExLexer.g:55:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalParametersTestLanguageExLexer.g:55:41: ( '\\r' )? '\\n'
                    {
                    // InternalParametersTestLanguageExLexer.g:55:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalParametersTestLanguageExLexer.g:55:41: '\\r'
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
            // InternalParametersTestLanguageExLexer.g:57:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalParametersTestLanguageExLexer.g:57:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalParametersTestLanguageExLexer.g:57:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalParametersTestLanguageExLexer.g:
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
            // InternalParametersTestLanguageExLexer.g:59:16: ( . )
            // InternalParametersTestLanguageExLexer.g:59:18: .
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
        // InternalParametersTestLanguageExLexer.g:1:8: ( Keyword | NumberSignDigitOneDigitZero | NumberSignDigitOneDigitOne | NumberSignDigitOneDigitTwo | NumberSignDigitOne | NumberSignDigitTwo | NumberSignDigitThree | NumberSignDigitFour | NumberSignDigitFive | NumberSignDigitSix | NumberSignDigitSeven | NumberSignDigitEight | NumberSignDigitNine | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=20;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalParametersTestLanguageExLexer.g:1:10: Keyword
                {
                mKeyword(); 

                }
                break;
            case 2 :
                // InternalParametersTestLanguageExLexer.g:1:18: NumberSignDigitOneDigitZero
                {
                mNumberSignDigitOneDigitZero(); 

                }
                break;
            case 3 :
                // InternalParametersTestLanguageExLexer.g:1:46: NumberSignDigitOneDigitOne
                {
                mNumberSignDigitOneDigitOne(); 

                }
                break;
            case 4 :
                // InternalParametersTestLanguageExLexer.g:1:73: NumberSignDigitOneDigitTwo
                {
                mNumberSignDigitOneDigitTwo(); 

                }
                break;
            case 5 :
                // InternalParametersTestLanguageExLexer.g:1:100: NumberSignDigitOne
                {
                mNumberSignDigitOne(); 

                }
                break;
            case 6 :
                // InternalParametersTestLanguageExLexer.g:1:119: NumberSignDigitTwo
                {
                mNumberSignDigitTwo(); 

                }
                break;
            case 7 :
                // InternalParametersTestLanguageExLexer.g:1:138: NumberSignDigitThree
                {
                mNumberSignDigitThree(); 

                }
                break;
            case 8 :
                // InternalParametersTestLanguageExLexer.g:1:159: NumberSignDigitFour
                {
                mNumberSignDigitFour(); 

                }
                break;
            case 9 :
                // InternalParametersTestLanguageExLexer.g:1:179: NumberSignDigitFive
                {
                mNumberSignDigitFive(); 

                }
                break;
            case 10 :
                // InternalParametersTestLanguageExLexer.g:1:199: NumberSignDigitSix
                {
                mNumberSignDigitSix(); 

                }
                break;
            case 11 :
                // InternalParametersTestLanguageExLexer.g:1:218: NumberSignDigitSeven
                {
                mNumberSignDigitSeven(); 

                }
                break;
            case 12 :
                // InternalParametersTestLanguageExLexer.g:1:239: NumberSignDigitEight
                {
                mNumberSignDigitEight(); 

                }
                break;
            case 13 :
                // InternalParametersTestLanguageExLexer.g:1:260: NumberSignDigitNine
                {
                mNumberSignDigitNine(); 

                }
                break;
            case 14 :
                // InternalParametersTestLanguageExLexer.g:1:280: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 15 :
                // InternalParametersTestLanguageExLexer.g:1:288: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 16 :
                // InternalParametersTestLanguageExLexer.g:1:297: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 17 :
                // InternalParametersTestLanguageExLexer.g:1:309: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 18 :
                // InternalParametersTestLanguageExLexer.g:1:325: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 19 :
                // InternalParametersTestLanguageExLexer.g:1:341: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 20 :
                // InternalParametersTestLanguageExLexer.g:1:349: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\14\2\12\2\uffff\3\12\2\uffff\1\14\1\uffff\1\37\15\uffff\1\14\4\uffff\3\14\1\44\1\uffff";
    static final String DFA12_eofS =
        "\45\uffff";
    static final String DFA12_minS =
        "\1\0\1\145\1\61\1\101\2\uffff\2\0\1\52\2\uffff\1\171\1\uffff\1\60\15\uffff\1\167\4\uffff\1\157\1\162\1\144\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\145\1\71\1\172\2\uffff\2\uffff\1\57\2\uffff\1\171\1\uffff\1\62\15\uffff\1\167\4\uffff\1\157\1\162\1\144\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\4\uffff\1\16\1\17\3\uffff\1\23\1\24\1\uffff\1\16\1\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\17\1\20\1\21\1\22\1\23\1\uffff\1\2\1\3\1\4\1\5\4\uffff\1\1";
    static final String DFA12_specialS =
        "\1\1\5\uffff\1\2\1\0\35\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\12\2\11\2\12\1\11\22\12\1\11\1\12\1\6\1\2\3\12\1\7\7\12\1\10\12\5\7\12\32\4\3\12\1\3\1\4\1\12\12\4\1\1\17\4\uff85\12",
            "\1\13",
            "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25",
            "\32\14\4\uffff\1\14\1\uffff\32\14",
            "",
            "",
            "\0\27",
            "\0\27",
            "\1\30\4\uffff\1\31",
            "",
            "",
            "\1\33",
            "",
            "\1\34\1\35\1\36",
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
            "",
            "",
            "\1\40",
            "",
            "",
            "",
            "",
            "\1\41",
            "\1\42",
            "\1\43",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
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
            return "1:1: Tokens : ( Keyword | NumberSignDigitOneDigitZero | NumberSignDigitOneDigitOne | NumberSignDigitOneDigitTwo | NumberSignDigitOne | NumberSignDigitTwo | NumberSignDigitThree | NumberSignDigitFour | NumberSignDigitFive | NumberSignDigitSix | NumberSignDigitSeven | NumberSignDigitEight | NumberSignDigitNine | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_7 = input.LA(1);

                        s = -1;
                        if ( ((LA12_7>='\u0000' && LA12_7<='\uFFFF')) ) {s = 23;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='k') ) {s = 1;}

                        else if ( (LA12_0=='#') ) {s = 2;}

                        else if ( (LA12_0=='^') ) {s = 3;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='j')||(LA12_0>='l' && LA12_0<='z')) ) {s = 4;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 5;}

                        else if ( (LA12_0=='\"') ) {s = 6;}

                        else if ( (LA12_0=='\'') ) {s = 7;}

                        else if ( (LA12_0=='/') ) {s = 8;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 9;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='$' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 10;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_6 = input.LA(1);

                        s = -1;
                        if ( ((LA12_6>='\u0000' && LA12_6<='\uFFFF')) ) {s = 23;}

                        else s = 10;

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