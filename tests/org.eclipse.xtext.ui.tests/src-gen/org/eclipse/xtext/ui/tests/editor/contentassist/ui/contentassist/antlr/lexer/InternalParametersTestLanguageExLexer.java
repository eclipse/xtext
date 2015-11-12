package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalParametersTestLanguageExLexer extends Lexer {
    public static final int RULE_ID=24;
    public static final int NumberSignDigitNine=23;
    public static final int Trailing=7;
    public static final int Keyword=9;
    public static final int NumberSignDigitOneDigitFour=14;
    public static final int NumberSignDigitEight=22;
    public static final int RULE_ANY_OTHER=30;
    public static final int Scenario4=5;
    public static final int Scenario5=6;
    public static final int NumberSignDigitSeven=21;
    public static final int NumberSignDigitOneDigitZero=10;
    public static final int Scenario3=4;
    public static final int RULE_SL_COMMENT=28;
    public static final int EOF=-1;
    public static final int NumberSignDigitThree=17;
    public static final int Include=8;
    public static final int RULE_ML_COMMENT=27;
    public static final int NumberSignDigitOneDigitThree=13;
    public static final int NumberSignDigitOneDigitOne=11;
    public static final int RULE_STRING=26;
    public static final int NumberSignDigitOne=15;
    public static final int NumberSignDigitTwo=16;
    public static final int NumberSignDigitOneDigitTwo=12;
    public static final int RULE_INT=25;
    public static final int NumberSignDigitFour=18;
    public static final int NumberSignDigitSix=20;
    public static final int RULE_WS=29;
    public static final int NumberSignDigitFive=19;

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

    // $ANTLR start "Scenario3"
    public final void mScenario3() throws RecognitionException {
        try {
            int _type = Scenario3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:19:11: ( 'scenario3' )
            // InternalParametersTestLanguageExLexer.g:19:13: 'scenario3'
            {
            match("scenario3"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Scenario3"

    // $ANTLR start "Scenario4"
    public final void mScenario4() throws RecognitionException {
        try {
            int _type = Scenario4;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:21:11: ( 'scenario4' )
            // InternalParametersTestLanguageExLexer.g:21:13: 'scenario4'
            {
            match("scenario4"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Scenario4"

    // $ANTLR start "Scenario5"
    public final void mScenario5() throws RecognitionException {
        try {
            int _type = Scenario5;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:23:11: ( 'scenario5' )
            // InternalParametersTestLanguageExLexer.g:23:13: 'scenario5'
            {
            match("scenario5"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Scenario5"

    // $ANTLR start "Trailing"
    public final void mTrailing() throws RecognitionException {
        try {
            int _type = Trailing;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:25:10: ( 'trailing' )
            // InternalParametersTestLanguageExLexer.g:25:12: 'trailing'
            {
            match("trailing"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Trailing"

    // $ANTLR start "Include"
    public final void mInclude() throws RecognitionException {
        try {
            int _type = Include;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:27:9: ( 'include' )
            // InternalParametersTestLanguageExLexer.g:27:11: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Include"

    // $ANTLR start "Keyword"
    public final void mKeyword() throws RecognitionException {
        try {
            int _type = Keyword;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:29:9: ( 'keyword' )
            // InternalParametersTestLanguageExLexer.g:29:11: 'keyword'
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
            // InternalParametersTestLanguageExLexer.g:31:29: ( '#10' )
            // InternalParametersTestLanguageExLexer.g:31:31: '#10'
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
            // InternalParametersTestLanguageExLexer.g:33:28: ( '#11' )
            // InternalParametersTestLanguageExLexer.g:33:30: '#11'
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
            // InternalParametersTestLanguageExLexer.g:35:28: ( '#12' )
            // InternalParametersTestLanguageExLexer.g:35:30: '#12'
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

    // $ANTLR start "NumberSignDigitOneDigitThree"
    public final void mNumberSignDigitOneDigitThree() throws RecognitionException {
        try {
            int _type = NumberSignDigitOneDigitThree;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:37:30: ( '#13' )
            // InternalParametersTestLanguageExLexer.g:37:32: '#13'
            {
            match("#13"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitOneDigitThree"

    // $ANTLR start "NumberSignDigitOneDigitFour"
    public final void mNumberSignDigitOneDigitFour() throws RecognitionException {
        try {
            int _type = NumberSignDigitOneDigitFour;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:39:29: ( '#14' )
            // InternalParametersTestLanguageExLexer.g:39:31: '#14'
            {
            match("#14"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSignDigitOneDigitFour"

    // $ANTLR start "NumberSignDigitOne"
    public final void mNumberSignDigitOne() throws RecognitionException {
        try {
            int _type = NumberSignDigitOne;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalParametersTestLanguageExLexer.g:41:20: ( '#1' )
            // InternalParametersTestLanguageExLexer.g:41:22: '#1'
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
            // InternalParametersTestLanguageExLexer.g:43:20: ( '#2' )
            // InternalParametersTestLanguageExLexer.g:43:22: '#2'
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
            // InternalParametersTestLanguageExLexer.g:45:22: ( '#3' )
            // InternalParametersTestLanguageExLexer.g:45:24: '#3'
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
            // InternalParametersTestLanguageExLexer.g:47:21: ( '#4' )
            // InternalParametersTestLanguageExLexer.g:47:23: '#4'
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
            // InternalParametersTestLanguageExLexer.g:49:21: ( '#5' )
            // InternalParametersTestLanguageExLexer.g:49:23: '#5'
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
            // InternalParametersTestLanguageExLexer.g:51:20: ( '#6' )
            // InternalParametersTestLanguageExLexer.g:51:22: '#6'
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
            // InternalParametersTestLanguageExLexer.g:53:22: ( '#7' )
            // InternalParametersTestLanguageExLexer.g:53:24: '#7'
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
            // InternalParametersTestLanguageExLexer.g:55:22: ( '#8' )
            // InternalParametersTestLanguageExLexer.g:55:24: '#8'
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
            // InternalParametersTestLanguageExLexer.g:57:21: ( '#9' )
            // InternalParametersTestLanguageExLexer.g:57:23: '#9'
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
            // InternalParametersTestLanguageExLexer.g:61:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalParametersTestLanguageExLexer.g:61:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalParametersTestLanguageExLexer.g:61:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalParametersTestLanguageExLexer.g:61:11: '^'
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

            // InternalParametersTestLanguageExLexer.g:61:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // InternalParametersTestLanguageExLexer.g:63:10: ( ( '0' .. '9' )+ )
            // InternalParametersTestLanguageExLexer.g:63:12: ( '0' .. '9' )+
            {
            // InternalParametersTestLanguageExLexer.g:63:12: ( '0' .. '9' )+
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
            	    // InternalParametersTestLanguageExLexer.g:63:13: '0' .. '9'
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
            // InternalParametersTestLanguageExLexer.g:65:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalParametersTestLanguageExLexer.g:65:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalParametersTestLanguageExLexer.g:65:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalParametersTestLanguageExLexer.g:65:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalParametersTestLanguageExLexer.g:65:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalParametersTestLanguageExLexer.g:65:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalParametersTestLanguageExLexer.g:65:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalParametersTestLanguageExLexer.g:65:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalParametersTestLanguageExLexer.g:65:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalParametersTestLanguageExLexer.g:65:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalParametersTestLanguageExLexer.g:65:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalParametersTestLanguageExLexer.g:67:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalParametersTestLanguageExLexer.g:67:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalParametersTestLanguageExLexer.g:67:24: ( options {greedy=false; } : . )*
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
            	    // InternalParametersTestLanguageExLexer.g:67:52: .
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
            // InternalParametersTestLanguageExLexer.g:69:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalParametersTestLanguageExLexer.g:69:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalParametersTestLanguageExLexer.g:69:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalParametersTestLanguageExLexer.g:69:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalParametersTestLanguageExLexer.g:69:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalParametersTestLanguageExLexer.g:69:41: ( '\\r' )? '\\n'
                    {
                    // InternalParametersTestLanguageExLexer.g:69:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalParametersTestLanguageExLexer.g:69:41: '\\r'
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
            // InternalParametersTestLanguageExLexer.g:71:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalParametersTestLanguageExLexer.g:71:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalParametersTestLanguageExLexer.g:71:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // InternalParametersTestLanguageExLexer.g:73:16: ( . )
            // InternalParametersTestLanguageExLexer.g:73:18: .
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
        // InternalParametersTestLanguageExLexer.g:1:8: ( Scenario3 | Scenario4 | Scenario5 | Trailing | Include | Keyword | NumberSignDigitOneDigitZero | NumberSignDigitOneDigitOne | NumberSignDigitOneDigitTwo | NumberSignDigitOneDigitThree | NumberSignDigitOneDigitFour | NumberSignDigitOne | NumberSignDigitTwo | NumberSignDigitThree | NumberSignDigitFour | NumberSignDigitFive | NumberSignDigitSix | NumberSignDigitSeven | NumberSignDigitEight | NumberSignDigitNine | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=27;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalParametersTestLanguageExLexer.g:1:10: Scenario3
                {
                mScenario3(); 

                }
                break;
            case 2 :
                // InternalParametersTestLanguageExLexer.g:1:20: Scenario4
                {
                mScenario4(); 

                }
                break;
            case 3 :
                // InternalParametersTestLanguageExLexer.g:1:30: Scenario5
                {
                mScenario5(); 

                }
                break;
            case 4 :
                // InternalParametersTestLanguageExLexer.g:1:40: Trailing
                {
                mTrailing(); 

                }
                break;
            case 5 :
                // InternalParametersTestLanguageExLexer.g:1:49: Include
                {
                mInclude(); 

                }
                break;
            case 6 :
                // InternalParametersTestLanguageExLexer.g:1:57: Keyword
                {
                mKeyword(); 

                }
                break;
            case 7 :
                // InternalParametersTestLanguageExLexer.g:1:65: NumberSignDigitOneDigitZero
                {
                mNumberSignDigitOneDigitZero(); 

                }
                break;
            case 8 :
                // InternalParametersTestLanguageExLexer.g:1:93: NumberSignDigitOneDigitOne
                {
                mNumberSignDigitOneDigitOne(); 

                }
                break;
            case 9 :
                // InternalParametersTestLanguageExLexer.g:1:120: NumberSignDigitOneDigitTwo
                {
                mNumberSignDigitOneDigitTwo(); 

                }
                break;
            case 10 :
                // InternalParametersTestLanguageExLexer.g:1:147: NumberSignDigitOneDigitThree
                {
                mNumberSignDigitOneDigitThree(); 

                }
                break;
            case 11 :
                // InternalParametersTestLanguageExLexer.g:1:176: NumberSignDigitOneDigitFour
                {
                mNumberSignDigitOneDigitFour(); 

                }
                break;
            case 12 :
                // InternalParametersTestLanguageExLexer.g:1:204: NumberSignDigitOne
                {
                mNumberSignDigitOne(); 

                }
                break;
            case 13 :
                // InternalParametersTestLanguageExLexer.g:1:223: NumberSignDigitTwo
                {
                mNumberSignDigitTwo(); 

                }
                break;
            case 14 :
                // InternalParametersTestLanguageExLexer.g:1:242: NumberSignDigitThree
                {
                mNumberSignDigitThree(); 

                }
                break;
            case 15 :
                // InternalParametersTestLanguageExLexer.g:1:263: NumberSignDigitFour
                {
                mNumberSignDigitFour(); 

                }
                break;
            case 16 :
                // InternalParametersTestLanguageExLexer.g:1:283: NumberSignDigitFive
                {
                mNumberSignDigitFive(); 

                }
                break;
            case 17 :
                // InternalParametersTestLanguageExLexer.g:1:303: NumberSignDigitSix
                {
                mNumberSignDigitSix(); 

                }
                break;
            case 18 :
                // InternalParametersTestLanguageExLexer.g:1:322: NumberSignDigitSeven
                {
                mNumberSignDigitSeven(); 

                }
                break;
            case 19 :
                // InternalParametersTestLanguageExLexer.g:1:343: NumberSignDigitEight
                {
                mNumberSignDigitEight(); 

                }
                break;
            case 20 :
                // InternalParametersTestLanguageExLexer.g:1:364: NumberSignDigitNine
                {
                mNumberSignDigitNine(); 

                }
                break;
            case 21 :
                // InternalParametersTestLanguageExLexer.g:1:384: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 22 :
                // InternalParametersTestLanguageExLexer.g:1:392: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 23 :
                // InternalParametersTestLanguageExLexer.g:1:401: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 24 :
                // InternalParametersTestLanguageExLexer.g:1:413: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 25 :
                // InternalParametersTestLanguageExLexer.g:1:429: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 26 :
                // InternalParametersTestLanguageExLexer.g:1:445: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 27 :
                // InternalParametersTestLanguageExLexer.g:1:453: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\4\17\2\15\2\uffff\3\15\2\uffff\1\17\1\uffff\3\17\1\52\15\uffff\4\17\6\uffff\16\17\1\75\1\76\1\17\1\102\2\uffff\1\103\1\104\1\105\4\uffff";
    static final String DFA12_eofS =
        "\106\uffff";
    static final String DFA12_minS =
        "\1\0\1\143\1\162\1\156\1\145\1\61\1\101\2\uffff\2\0\1\52\2\uffff\1\145\1\uffff\1\141\1\143\1\171\1\60\15\uffff\1\156\1\151\1\154\1\167\6\uffff\1\141\1\154\1\165\1\157\1\162\1\151\1\144\1\162\1\151\1\156\1\145\1\144\1\157\1\147\2\60\1\63\1\60\2\uffff\3\60\4\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\143\1\162\1\156\1\145\1\71\1\172\2\uffff\2\uffff\1\57\2\uffff\1\145\1\uffff\1\141\1\143\1\171\1\64\15\uffff\1\156\1\151\1\154\1\167\6\uffff\1\141\1\154\1\165\1\157\1\162\1\151\1\144\1\162\1\151\1\156\1\145\1\144\1\157\1\147\2\172\1\65\1\172\2\uffff\3\172\4\uffff";
    static final String DFA12_acceptS =
        "\7\uffff\1\25\1\26\3\uffff\1\32\1\33\1\uffff\1\25\4\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\26\1\27\1\30\1\31\1\32\4\uffff\1\7\1\10\1\11\1\12\1\13\1\14\22\uffff\1\5\1\6\3\uffff\1\4\1\1\1\2\1\3";
    static final String DFA12_specialS =
        "\1\1\10\uffff\1\2\1\0\73\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\15\2\14\2\15\1\14\22\15\1\14\1\15\1\11\1\5\3\15\1\12\7\15\1\13\12\10\7\15\32\7\3\15\1\6\1\7\1\15\10\7\1\3\1\7\1\4\7\7\1\1\1\2\6\7\uff85\15",
            "\1\16",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33",
            "\32\17\4\uffff\1\17\1\uffff\32\17",
            "",
            "",
            "\0\35",
            "\0\35",
            "\1\36\4\uffff\1\37",
            "",
            "",
            "\1\41",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45\1\46\1\47\1\50\1\51",
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
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            "\1\77\1\100\1\101",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            "",
            "",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
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
            return "1:1: Tokens : ( Scenario3 | Scenario4 | Scenario5 | Trailing | Include | Keyword | NumberSignDigitOneDigitZero | NumberSignDigitOneDigitOne | NumberSignDigitOneDigitTwo | NumberSignDigitOneDigitThree | NumberSignDigitOneDigitFour | NumberSignDigitOne | NumberSignDigitTwo | NumberSignDigitThree | NumberSignDigitFour | NumberSignDigitFive | NumberSignDigitSix | NumberSignDigitSeven | NumberSignDigitEight | NumberSignDigitNine | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_10 = input.LA(1);

                        s = -1;
                        if ( ((LA12_10>='\u0000' && LA12_10<='\uFFFF')) ) {s = 29;}

                        else s = 13;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='s') ) {s = 1;}

                        else if ( (LA12_0=='t') ) {s = 2;}

                        else if ( (LA12_0=='i') ) {s = 3;}

                        else if ( (LA12_0=='k') ) {s = 4;}

                        else if ( (LA12_0=='#') ) {s = 5;}

                        else if ( (LA12_0=='^') ) {s = 6;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='h')||LA12_0=='j'||(LA12_0>='l' && LA12_0<='r')||(LA12_0>='u' && LA12_0<='z')) ) {s = 7;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 8;}

                        else if ( (LA12_0=='\"') ) {s = 9;}

                        else if ( (LA12_0=='\'') ) {s = 10;}

                        else if ( (LA12_0=='/') ) {s = 11;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 12;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='$' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 13;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_9 = input.LA(1);

                        s = -1;
                        if ( ((LA12_9>='\u0000' && LA12_9<='\uFFFF')) ) {s = 29;}

                        else s = 13;

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