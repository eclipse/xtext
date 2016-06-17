package org.eclipse.xtext.parser.fragments.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFragmentTestLanguageExLexer extends Lexer {
    public static final int NumberSignDigitThree=8;
    public static final int NumberSignDigitNine=11;
    public static final int NumberSignDigitOneDigitOne=5;
    public static final int RULE_STRING=21;
    public static final int NumberSignDigitEight=10;
    public static final int RULE_SL_COMMENT=23;
    public static final int HyphenMinus=16;
    public static final int LeftParenthesis=14;
    public static final int NumberSignDigitFour=9;
    public static final int Colon=18;
    public static final int EOF=-1;
    public static final int NumberSignDigitOneDigitZero=4;
    public static final int FullStop=17;
    public static final int RULE_ID=19;
    public static final int RULE_WS=24;
    public static final int NumberSignDigitTwo=7;
    public static final int RightParenthesis=15;
    public static final int RULE_ANY_OTHER=25;
    public static final int RULE_INT=20;
    public static final int LessThanSignHyphenMinus=13;
    public static final int RULE_ML_COMMENT=22;
    public static final int HyphenMinusGreaterThanSign=12;
    public static final int NumberSignDigitOne=6;

    // delegates
    // delegators

    public InternalFragmentTestLanguageExLexer() {;} 
    public InternalFragmentTestLanguageExLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalFragmentTestLanguageExLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalFragmentTestLanguageExLexer.g"; }

    // $ANTLR start "NumberSignDigitOneDigitZero"
    public final void mNumberSignDigitOneDigitZero() throws RecognitionException {
        try {
            int _type = NumberSignDigitOneDigitZero;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:19:29: ( '#10' )
            // InternalFragmentTestLanguageExLexer.g:19:31: '#10'
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
            // InternalFragmentTestLanguageExLexer.g:21:28: ( '#11' )
            // InternalFragmentTestLanguageExLexer.g:21:30: '#11'
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

    // $ANTLR start "NumberSignDigitOne"
    public final void mNumberSignDigitOne() throws RecognitionException {
        try {
            int _type = NumberSignDigitOne;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:23:20: ( '#1' )
            // InternalFragmentTestLanguageExLexer.g:23:22: '#1'
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
            // InternalFragmentTestLanguageExLexer.g:25:20: ( '#2' )
            // InternalFragmentTestLanguageExLexer.g:25:22: '#2'
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
            // InternalFragmentTestLanguageExLexer.g:27:22: ( '#3' )
            // InternalFragmentTestLanguageExLexer.g:27:24: '#3'
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
            // InternalFragmentTestLanguageExLexer.g:29:21: ( '#4' )
            // InternalFragmentTestLanguageExLexer.g:29:23: '#4'
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

    // $ANTLR start "NumberSignDigitEight"
    public final void mNumberSignDigitEight() throws RecognitionException {
        try {
            int _type = NumberSignDigitEight;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:31:22: ( '#8' )
            // InternalFragmentTestLanguageExLexer.g:31:24: '#8'
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
            // InternalFragmentTestLanguageExLexer.g:33:21: ( '#9' )
            // InternalFragmentTestLanguageExLexer.g:33:23: '#9'
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

    // $ANTLR start "HyphenMinusGreaterThanSign"
    public final void mHyphenMinusGreaterThanSign() throws RecognitionException {
        try {
            int _type = HyphenMinusGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:35:28: ( '->' )
            // InternalFragmentTestLanguageExLexer.g:35:30: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusGreaterThanSign"

    // $ANTLR start "LessThanSignHyphenMinus"
    public final void mLessThanSignHyphenMinus() throws RecognitionException {
        try {
            int _type = LessThanSignHyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:37:25: ( '<-' )
            // InternalFragmentTestLanguageExLexer.g:37:27: '<-'
            {
            match("<-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignHyphenMinus"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:39:17: ( '(' )
            // InternalFragmentTestLanguageExLexer.g:39:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:41:18: ( ')' )
            // InternalFragmentTestLanguageExLexer.g:41:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "HyphenMinus"
    public final void mHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:43:13: ( '-' )
            // InternalFragmentTestLanguageExLexer.g:43:15: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinus"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:45:10: ( '.' )
            // InternalFragmentTestLanguageExLexer.g:45:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStop"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:47:7: ( ':' )
            // InternalFragmentTestLanguageExLexer.g:47:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFragmentTestLanguageExLexer.g:51:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalFragmentTestLanguageExLexer.g:51:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalFragmentTestLanguageExLexer.g:51:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalFragmentTestLanguageExLexer.g:51:11: '^'
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

            // InternalFragmentTestLanguageExLexer.g:51:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFragmentTestLanguageExLexer.g:
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
            // InternalFragmentTestLanguageExLexer.g:53:10: ( ( '0' .. '9' )+ )
            // InternalFragmentTestLanguageExLexer.g:53:12: ( '0' .. '9' )+
            {
            // InternalFragmentTestLanguageExLexer.g:53:12: ( '0' .. '9' )+
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
            	    // InternalFragmentTestLanguageExLexer.g:53:13: '0' .. '9'
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
            // InternalFragmentTestLanguageExLexer.g:55:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalFragmentTestLanguageExLexer.g:55:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalFragmentTestLanguageExLexer.g:55:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalFragmentTestLanguageExLexer.g:55:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalFragmentTestLanguageExLexer.g:55:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalFragmentTestLanguageExLexer.g:55:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalFragmentTestLanguageExLexer.g:55:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalFragmentTestLanguageExLexer.g:55:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalFragmentTestLanguageExLexer.g:55:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalFragmentTestLanguageExLexer.g:55:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalFragmentTestLanguageExLexer.g:55:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalFragmentTestLanguageExLexer.g:57:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalFragmentTestLanguageExLexer.g:57:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalFragmentTestLanguageExLexer.g:57:24: ( options {greedy=false; } : . )*
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
            	    // InternalFragmentTestLanguageExLexer.g:57:52: .
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
            // InternalFragmentTestLanguageExLexer.g:59:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalFragmentTestLanguageExLexer.g:59:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalFragmentTestLanguageExLexer.g:59:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFragmentTestLanguageExLexer.g:59:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalFragmentTestLanguageExLexer.g:59:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalFragmentTestLanguageExLexer.g:59:41: ( '\\r' )? '\\n'
                    {
                    // InternalFragmentTestLanguageExLexer.g:59:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalFragmentTestLanguageExLexer.g:59:41: '\\r'
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
            // InternalFragmentTestLanguageExLexer.g:61:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalFragmentTestLanguageExLexer.g:61:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalFragmentTestLanguageExLexer.g:61:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalFragmentTestLanguageExLexer.g:
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
            // InternalFragmentTestLanguageExLexer.g:63:16: ( . )
            // InternalFragmentTestLanguageExLexer.g:63:18: .
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
        // InternalFragmentTestLanguageExLexer.g:1:8: ( NumberSignDigitOneDigitZero | NumberSignDigitOneDigitOne | NumberSignDigitOne | NumberSignDigitTwo | NumberSignDigitThree | NumberSignDigitFour | NumberSignDigitEight | NumberSignDigitNine | HyphenMinusGreaterThanSign | LessThanSignHyphenMinus | LeftParenthesis | RightParenthesis | HyphenMinus | FullStop | Colon | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=22;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalFragmentTestLanguageExLexer.g:1:10: NumberSignDigitOneDigitZero
                {
                mNumberSignDigitOneDigitZero(); 

                }
                break;
            case 2 :
                // InternalFragmentTestLanguageExLexer.g:1:38: NumberSignDigitOneDigitOne
                {
                mNumberSignDigitOneDigitOne(); 

                }
                break;
            case 3 :
                // InternalFragmentTestLanguageExLexer.g:1:65: NumberSignDigitOne
                {
                mNumberSignDigitOne(); 

                }
                break;
            case 4 :
                // InternalFragmentTestLanguageExLexer.g:1:84: NumberSignDigitTwo
                {
                mNumberSignDigitTwo(); 

                }
                break;
            case 5 :
                // InternalFragmentTestLanguageExLexer.g:1:103: NumberSignDigitThree
                {
                mNumberSignDigitThree(); 

                }
                break;
            case 6 :
                // InternalFragmentTestLanguageExLexer.g:1:124: NumberSignDigitFour
                {
                mNumberSignDigitFour(); 

                }
                break;
            case 7 :
                // InternalFragmentTestLanguageExLexer.g:1:144: NumberSignDigitEight
                {
                mNumberSignDigitEight(); 

                }
                break;
            case 8 :
                // InternalFragmentTestLanguageExLexer.g:1:165: NumberSignDigitNine
                {
                mNumberSignDigitNine(); 

                }
                break;
            case 9 :
                // InternalFragmentTestLanguageExLexer.g:1:185: HyphenMinusGreaterThanSign
                {
                mHyphenMinusGreaterThanSign(); 

                }
                break;
            case 10 :
                // InternalFragmentTestLanguageExLexer.g:1:212: LessThanSignHyphenMinus
                {
                mLessThanSignHyphenMinus(); 

                }
                break;
            case 11 :
                // InternalFragmentTestLanguageExLexer.g:1:236: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 12 :
                // InternalFragmentTestLanguageExLexer.g:1:252: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 13 :
                // InternalFragmentTestLanguageExLexer.g:1:269: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 14 :
                // InternalFragmentTestLanguageExLexer.g:1:281: FullStop
                {
                mFullStop(); 

                }
                break;
            case 15 :
                // InternalFragmentTestLanguageExLexer.g:1:290: Colon
                {
                mColon(); 

                }
                break;
            case 16 :
                // InternalFragmentTestLanguageExLexer.g:1:296: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 17 :
                // InternalFragmentTestLanguageExLexer.g:1:304: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 18 :
                // InternalFragmentTestLanguageExLexer.g:1:313: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 19 :
                // InternalFragmentTestLanguageExLexer.g:1:325: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 20 :
                // InternalFragmentTestLanguageExLexer.g:1:341: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 21 :
                // InternalFragmentTestLanguageExLexer.g:1:357: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 22 :
                // InternalFragmentTestLanguageExLexer.g:1:365: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\17\1\27\1\17\4\uffff\1\17\2\uffff\3\17\2\uffff\1\45\25\uffff";
    static final String DFA12_eofS =
        "\46\uffff";
    static final String DFA12_minS =
        "\1\0\1\61\1\76\1\55\4\uffff\1\101\2\uffff\2\0\1\52\2\uffff\1\60\25\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\71\1\76\1\55\4\uffff\1\172\2\uffff\2\uffff\1\57\2\uffff\1\61\25\uffff";
    static final String DFA12_acceptS =
        "\4\uffff\1\13\1\14\1\16\1\17\1\uffff\1\20\1\21\3\uffff\1\25\1\26\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\15\1\12\1\13\1\14\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\1\1\2\1\3";
    static final String DFA12_specialS =
        "\1\1\12\uffff\1\0\1\2\31\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\17\2\16\2\17\1\16\22\17\1\16\1\17\1\13\1\1\3\17\1\14\1\4\1\5\3\17\1\2\1\6\1\15\12\12\1\7\1\17\1\3\4\17\32\11\3\17\1\10\1\11\1\17\32\11\uff85\17",
            "\1\20\1\21\1\22\1\23\3\uffff\1\24\1\25",
            "\1\26",
            "\1\30",
            "",
            "",
            "",
            "",
            "\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "",
            "\0\37",
            "\0\37",
            "\1\40\4\uffff\1\41",
            "",
            "",
            "\1\43\1\44",
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
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "1:1: Tokens : ( NumberSignDigitOneDigitZero | NumberSignDigitOneDigitOne | NumberSignDigitOne | NumberSignDigitTwo | NumberSignDigitThree | NumberSignDigitFour | NumberSignDigitEight | NumberSignDigitNine | HyphenMinusGreaterThanSign | LessThanSignHyphenMinus | LeftParenthesis | RightParenthesis | HyphenMinus | FullStop | Colon | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_11 = input.LA(1);

                        s = -1;
                        if ( ((LA12_11>='\u0000' && LA12_11<='\uFFFF')) ) {s = 31;}

                        else s = 15;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='#') ) {s = 1;}

                        else if ( (LA12_0=='-') ) {s = 2;}

                        else if ( (LA12_0=='<') ) {s = 3;}

                        else if ( (LA12_0=='(') ) {s = 4;}

                        else if ( (LA12_0==')') ) {s = 5;}

                        else if ( (LA12_0=='.') ) {s = 6;}

                        else if ( (LA12_0==':') ) {s = 7;}

                        else if ( (LA12_0=='^') ) {s = 8;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {s = 9;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 10;}

                        else if ( (LA12_0=='\"') ) {s = 11;}

                        else if ( (LA12_0=='\'') ) {s = 12;}

                        else if ( (LA12_0=='/') ) {s = 13;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 14;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='$' && LA12_0<='&')||(LA12_0>='*' && LA12_0<=',')||LA12_0==';'||(LA12_0>='=' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 15;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_12 = input.LA(1);

                        s = -1;
                        if ( ((LA12_12>='\u0000' && LA12_12<='\uFFFF')) ) {s = 31;}

                        else s = 15;

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