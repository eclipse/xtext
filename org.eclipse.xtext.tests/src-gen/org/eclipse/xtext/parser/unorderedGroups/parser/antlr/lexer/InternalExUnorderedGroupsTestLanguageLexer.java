package org.eclipse.xtext.parser.unorderedGroups.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExUnorderedGroupsTestLanguageLexer extends Lexer {
    public static final int DigitTwo=14;
    public static final int DigitNine=21;
    public static final int A=22;
    public static final int Bug302585=5;
    public static final int B=23;
    public static final int C=24;
    public static final int DigitFive=17;
    public static final int D=25;
    public static final int Nested=7;
    public static final int DigitFour=16;
    public static final int DigitEight=20;
    public static final int RULE_STRING=28;
    public static final int DigitThree=15;
    public static final int DigitOneDigitTwo=10;
    public static final int DigitSeven=19;
    public static final int RULE_SL_COMMENT=30;
    public static final int DigitOneDigitZero=8;
    public static final int Datatypes=6;
    public static final int DigitOneDigitThree=11;
    public static final int EOF=-1;
    public static final int DigitOneDigitOne=9;
    public static final int RULE_ID=26;
    public static final int RULE_WS=31;
    public static final int DigitOneDigitFour=12;
    public static final int DigitOne=13;
    public static final int DigitSix=18;
    public static final int RULE_ANY_OTHER=32;
    public static final int Serialization=4;
    public static final int RULE_INT=27;
    public static final int RULE_ML_COMMENT=29;

    // delegates
    // delegators

    public InternalExUnorderedGroupsTestLanguageLexer() {;} 
    public InternalExUnorderedGroupsTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalExUnorderedGroupsTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalExUnorderedGroupsTestLanguageLexer.g"; }

    // $ANTLR start "Serialization"
    public final void mSerialization() throws RecognitionException {
        try {
            int _type = Serialization;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:19:15: ( 'serialization' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:19:17: 'serialization'
            {
            match("serialization"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Serialization"

    // $ANTLR start "Bug302585"
    public final void mBug302585() throws RecognitionException {
        try {
            int _type = Bug302585;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:21:11: ( 'bug302585' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:21:13: 'bug302585'
            {
            match("bug302585"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Bug302585"

    // $ANTLR start "Datatypes"
    public final void mDatatypes() throws RecognitionException {
        try {
            int _type = Datatypes;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:23:11: ( 'datatypes' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:23:13: 'datatypes'
            {
            match("datatypes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Datatypes"

    // $ANTLR start "Nested"
    public final void mNested() throws RecognitionException {
        try {
            int _type = Nested;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:25:8: ( 'nested' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:25:10: 'nested'
            {
            match("nested"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Nested"

    // $ANTLR start "DigitOneDigitZero"
    public final void mDigitOneDigitZero() throws RecognitionException {
        try {
            int _type = DigitOneDigitZero;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:27:19: ( '10' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:27:21: '10'
            {
            match("10"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitOneDigitZero"

    // $ANTLR start "DigitOneDigitOne"
    public final void mDigitOneDigitOne() throws RecognitionException {
        try {
            int _type = DigitOneDigitOne;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:29:18: ( '11' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:29:20: '11'
            {
            match("11"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitOneDigitOne"

    // $ANTLR start "DigitOneDigitTwo"
    public final void mDigitOneDigitTwo() throws RecognitionException {
        try {
            int _type = DigitOneDigitTwo;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:31:18: ( '12' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:31:20: '12'
            {
            match("12"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitOneDigitTwo"

    // $ANTLR start "DigitOneDigitThree"
    public final void mDigitOneDigitThree() throws RecognitionException {
        try {
            int _type = DigitOneDigitThree;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:33:20: ( '13' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:33:22: '13'
            {
            match("13"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitOneDigitThree"

    // $ANTLR start "DigitOneDigitFour"
    public final void mDigitOneDigitFour() throws RecognitionException {
        try {
            int _type = DigitOneDigitFour;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:35:19: ( '14' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:35:21: '14'
            {
            match("14"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitOneDigitFour"

    // $ANTLR start "DigitOne"
    public final void mDigitOne() throws RecognitionException {
        try {
            int _type = DigitOne;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:37:10: ( '1' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:37:12: '1'
            {
            match('1'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitOne"

    // $ANTLR start "DigitTwo"
    public final void mDigitTwo() throws RecognitionException {
        try {
            int _type = DigitTwo;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:39:10: ( '2' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:39:12: '2'
            {
            match('2'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitTwo"

    // $ANTLR start "DigitThree"
    public final void mDigitThree() throws RecognitionException {
        try {
            int _type = DigitThree;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:41:12: ( '3' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:41:14: '3'
            {
            match('3'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitThree"

    // $ANTLR start "DigitFour"
    public final void mDigitFour() throws RecognitionException {
        try {
            int _type = DigitFour;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:43:11: ( '4' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:43:13: '4'
            {
            match('4'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitFour"

    // $ANTLR start "DigitFive"
    public final void mDigitFive() throws RecognitionException {
        try {
            int _type = DigitFive;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:45:11: ( '5' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:45:13: '5'
            {
            match('5'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitFive"

    // $ANTLR start "DigitSix"
    public final void mDigitSix() throws RecognitionException {
        try {
            int _type = DigitSix;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:47:10: ( '6' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:47:12: '6'
            {
            match('6'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitSix"

    // $ANTLR start "DigitSeven"
    public final void mDigitSeven() throws RecognitionException {
        try {
            int _type = DigitSeven;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:49:12: ( '7' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:49:14: '7'
            {
            match('7'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitSeven"

    // $ANTLR start "DigitEight"
    public final void mDigitEight() throws RecognitionException {
        try {
            int _type = DigitEight;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:51:12: ( '8' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:51:14: '8'
            {
            match('8'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitEight"

    // $ANTLR start "DigitNine"
    public final void mDigitNine() throws RecognitionException {
        try {
            int _type = DigitNine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:53:11: ( '9' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:53:13: '9'
            {
            match('9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitNine"

    // $ANTLR start "A"
    public final void mA() throws RecognitionException {
        try {
            int _type = A;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:55:3: ( 'a' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:55:5: 'a'
            {
            match('a'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "A"

    // $ANTLR start "B"
    public final void mB() throws RecognitionException {
        try {
            int _type = B;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:57:3: ( 'b' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:57:5: 'b'
            {
            match('b'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "B"

    // $ANTLR start "C"
    public final void mC() throws RecognitionException {
        try {
            int _type = C;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:59:3: ( 'c' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:59:5: 'c'
            {
            match('c'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "C"

    // $ANTLR start "D"
    public final void mD() throws RecognitionException {
        try {
            int _type = D;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:61:3: ( 'd' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:61:5: 'd'
            {
            match('d'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "D"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExUnorderedGroupsTestLanguageLexer.g:65:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalExUnorderedGroupsTestLanguageLexer.g:65:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalExUnorderedGroupsTestLanguageLexer.g:65:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalExUnorderedGroupsTestLanguageLexer.g:65:11: '^'
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

            // InternalExUnorderedGroupsTestLanguageLexer.g:65:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalExUnorderedGroupsTestLanguageLexer.g:
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
            // InternalExUnorderedGroupsTestLanguageLexer.g:67:10: ( ( '0' .. '9' )+ )
            // InternalExUnorderedGroupsTestLanguageLexer.g:67:12: ( '0' .. '9' )+
            {
            // InternalExUnorderedGroupsTestLanguageLexer.g:67:12: ( '0' .. '9' )+
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
            	    // InternalExUnorderedGroupsTestLanguageLexer.g:67:13: '0' .. '9'
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
            // InternalExUnorderedGroupsTestLanguageLexer.g:69:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalExUnorderedGroupsTestLanguageLexer.g:69:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalExUnorderedGroupsTestLanguageLexer.g:69:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalExUnorderedGroupsTestLanguageLexer.g:69:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalExUnorderedGroupsTestLanguageLexer.g:69:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalExUnorderedGroupsTestLanguageLexer.g:69:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalExUnorderedGroupsTestLanguageLexer.g:69:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalExUnorderedGroupsTestLanguageLexer.g:69:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalExUnorderedGroupsTestLanguageLexer.g:69:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalExUnorderedGroupsTestLanguageLexer.g:69:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalExUnorderedGroupsTestLanguageLexer.g:69:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalExUnorderedGroupsTestLanguageLexer.g:71:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalExUnorderedGroupsTestLanguageLexer.g:71:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalExUnorderedGroupsTestLanguageLexer.g:71:24: ( options {greedy=false; } : . )*
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
            	    // InternalExUnorderedGroupsTestLanguageLexer.g:71:52: .
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
            // InternalExUnorderedGroupsTestLanguageLexer.g:73:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalExUnorderedGroupsTestLanguageLexer.g:73:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalExUnorderedGroupsTestLanguageLexer.g:73:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalExUnorderedGroupsTestLanguageLexer.g:73:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalExUnorderedGroupsTestLanguageLexer.g:73:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalExUnorderedGroupsTestLanguageLexer.g:73:41: ( '\\r' )? '\\n'
                    {
                    // InternalExUnorderedGroupsTestLanguageLexer.g:73:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalExUnorderedGroupsTestLanguageLexer.g:73:41: '\\r'
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
            // InternalExUnorderedGroupsTestLanguageLexer.g:75:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalExUnorderedGroupsTestLanguageLexer.g:75:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalExUnorderedGroupsTestLanguageLexer.g:75:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalExUnorderedGroupsTestLanguageLexer.g:
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
            // InternalExUnorderedGroupsTestLanguageLexer.g:77:16: ( . )
            // InternalExUnorderedGroupsTestLanguageLexer.g:77:18: .
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
        // InternalExUnorderedGroupsTestLanguageLexer.g:1:8: ( Serialization | Bug302585 | Datatypes | Nested | DigitOneDigitZero | DigitOneDigitOne | DigitOneDigitTwo | DigitOneDigitThree | DigitOneDigitFour | DigitOne | DigitTwo | DigitThree | DigitFour | DigitFive | DigitSix | DigitSeven | DigitEight | DigitNine | A | B | C | D | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=29;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:10: Serialization
                {
                mSerialization(); 

                }
                break;
            case 2 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:24: Bug302585
                {
                mBug302585(); 

                }
                break;
            case 3 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:34: Datatypes
                {
                mDatatypes(); 

                }
                break;
            case 4 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:44: Nested
                {
                mNested(); 

                }
                break;
            case 5 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:51: DigitOneDigitZero
                {
                mDigitOneDigitZero(); 

                }
                break;
            case 6 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:69: DigitOneDigitOne
                {
                mDigitOneDigitOne(); 

                }
                break;
            case 7 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:86: DigitOneDigitTwo
                {
                mDigitOneDigitTwo(); 

                }
                break;
            case 8 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:103: DigitOneDigitThree
                {
                mDigitOneDigitThree(); 

                }
                break;
            case 9 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:122: DigitOneDigitFour
                {
                mDigitOneDigitFour(); 

                }
                break;
            case 10 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:140: DigitOne
                {
                mDigitOne(); 

                }
                break;
            case 11 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:149: DigitTwo
                {
                mDigitTwo(); 

                }
                break;
            case 12 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:158: DigitThree
                {
                mDigitThree(); 

                }
                break;
            case 13 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:169: DigitFour
                {
                mDigitFour(); 

                }
                break;
            case 14 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:179: DigitFive
                {
                mDigitFive(); 

                }
                break;
            case 15 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:189: DigitSix
                {
                mDigitSix(); 

                }
                break;
            case 16 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:198: DigitSeven
                {
                mDigitSeven(); 

                }
                break;
            case 17 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:209: DigitEight
                {
                mDigitEight(); 

                }
                break;
            case 18 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:220: DigitNine
                {
                mDigitNine(); 

                }
                break;
            case 19 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:230: A
                {
                mA(); 

                }
                break;
            case 20 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:232: B
                {
                mB(); 

                }
                break;
            case 21 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:234: C
                {
                mC(); 

                }
                break;
            case 22 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:236: D
                {
                mD(); 

                }
                break;
            case 23 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:238: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 24 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:246: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 25 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:255: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 26 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:267: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 27 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:283: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 28 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:299: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 29 :
                // InternalExUnorderedGroupsTestLanguageLexer.g:1:307: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\31\1\33\1\35\1\31\1\44\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\27\2\uffff\3\27\2\uffff\1\31\1\uffff\1\31\1\uffff\1\31\1\uffff\1\31\1\70\1\71\1\72\1\73\1\74\20\uffff\4\31\5\uffff\13\31\1\114\3\31\1\uffff\4\31\1\124\1\125\1\31\2\uffff\2\31\1\131\1\uffff";
    static final String DFA12_eofS =
        "\132\uffff";
    static final String DFA12_minS =
        "\1\0\1\145\2\60\1\145\13\60\1\101\2\uffff\2\0\1\52\2\uffff\1\162\1\uffff\1\147\1\uffff\1\164\1\uffff\1\163\5\60\20\uffff\1\151\1\63\1\141\1\164\5\uffff\1\141\1\60\1\164\1\145\1\154\1\62\1\171\1\144\1\151\1\65\1\160\1\60\1\172\1\70\1\145\1\uffff\1\141\1\65\1\163\1\164\2\60\1\151\2\uffff\1\157\1\156\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\145\2\172\1\145\11\71\3\172\2\uffff\2\uffff\1\57\2\uffff\1\162\1\uffff\1\147\1\uffff\1\164\1\uffff\1\163\5\71\20\uffff\1\151\1\63\1\141\1\164\5\uffff\1\141\1\60\1\164\1\145\1\154\1\62\1\171\1\144\1\151\1\65\1\160\2\172\1\70\1\145\1\uffff\1\141\1\65\1\163\1\164\2\172\1\151\2\uffff\1\157\1\156\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\21\uffff\1\27\1\30\3\uffff\1\34\1\35\1\uffff\1\27\1\uffff\1\24\1\uffff\1\26\6\uffff\1\12\1\30\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\25\1\31\1\32\1\33\1\34\4\uffff\1\5\1\6\1\7\1\10\1\11\17\uffff\1\4\7\uffff\1\2\1\3\3\uffff\1\1";
    static final String DFA12_specialS =
        "\1\2\22\uffff\1\0\1\1\105\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\27\2\26\2\27\1\26\22\27\1\26\1\27\1\23\4\27\1\24\7\27\1\25\1\22\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\7\27\32\21\3\27\1\20\1\21\1\27\1\16\1\2\1\17\1\3\11\21\1\4\4\21\1\1\7\21\uff85\27",
            "\1\30",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\24\31\1\32\5\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\1\34\31\31",
            "\1\36",
            "\1\37\1\40\1\41\1\42\1\43\5\45",
            "\12\45",
            "\12\45",
            "\12\45",
            "\12\45",
            "\12\45",
            "\12\45",
            "\12\45",
            "\12\45",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "\0\60",
            "\0\60",
            "\1\61\4\uffff\1\62",
            "",
            "",
            "\1\64",
            "",
            "\1\65",
            "",
            "\1\66",
            "",
            "\1\67",
            "\12\45",
            "\12\45",
            "\12\45",
            "\12\45",
            "\12\45",
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
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "",
            "",
            "",
            "",
            "",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\115",
            "\1\116",
            "\1\117",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\126",
            "",
            "",
            "\1\127",
            "\1\130",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
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
            return "1:1: Tokens : ( Serialization | Bug302585 | Datatypes | Nested | DigitOneDigitZero | DigitOneDigitOne | DigitOneDigitTwo | DigitOneDigitThree | DigitOneDigitFour | DigitOne | DigitTwo | DigitThree | DigitFour | DigitFive | DigitSix | DigitSeven | DigitEight | DigitNine | A | B | C | D | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_19 = input.LA(1);

                        s = -1;
                        if ( ((LA12_19>='\u0000' && LA12_19<='\uFFFF')) ) {s = 48;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_20 = input.LA(1);

                        s = -1;
                        if ( ((LA12_20>='\u0000' && LA12_20<='\uFFFF')) ) {s = 48;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='s') ) {s = 1;}

                        else if ( (LA12_0=='b') ) {s = 2;}

                        else if ( (LA12_0=='d') ) {s = 3;}

                        else if ( (LA12_0=='n') ) {s = 4;}

                        else if ( (LA12_0=='1') ) {s = 5;}

                        else if ( (LA12_0=='2') ) {s = 6;}

                        else if ( (LA12_0=='3') ) {s = 7;}

                        else if ( (LA12_0=='4') ) {s = 8;}

                        else if ( (LA12_0=='5') ) {s = 9;}

                        else if ( (LA12_0=='6') ) {s = 10;}

                        else if ( (LA12_0=='7') ) {s = 11;}

                        else if ( (LA12_0=='8') ) {s = 12;}

                        else if ( (LA12_0=='9') ) {s = 13;}

                        else if ( (LA12_0=='a') ) {s = 14;}

                        else if ( (LA12_0=='c') ) {s = 15;}

                        else if ( (LA12_0=='^') ) {s = 16;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='e' && LA12_0<='m')||(LA12_0>='o' && LA12_0<='r')||(LA12_0>='t' && LA12_0<='z')) ) {s = 17;}

                        else if ( (LA12_0=='0') ) {s = 18;}

                        else if ( (LA12_0=='\"') ) {s = 19;}

                        else if ( (LA12_0=='\'') ) {s = 20;}

                        else if ( (LA12_0=='/') ) {s = 21;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 22;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 23;}

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