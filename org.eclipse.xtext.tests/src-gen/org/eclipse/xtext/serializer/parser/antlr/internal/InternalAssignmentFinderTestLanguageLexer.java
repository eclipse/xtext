package org.eclipse.xtext.serializer.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAssignmentFinderTestLanguageLexer extends Lexer {
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int RULE_TERMINAL1=4;
    public static final int RULE_TERMINAL2=5;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_ID=6;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalAssignmentFinderTestLanguageLexer() {;} 
    public InternalAssignmentFinderTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalAssignmentFinderTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalAssignmentFinderTestLanguage.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:11:7: ( '#00' )
            // InternalAssignmentFinderTestLanguage.g:11:9: '#00'
            {
            match("#00"); 


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
            // InternalAssignmentFinderTestLanguage.g:12:7: ( '#01' )
            // InternalAssignmentFinderTestLanguage.g:12:9: '#01'
            {
            match("#01"); 


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
            // InternalAssignmentFinderTestLanguage.g:13:7: ( '#02' )
            // InternalAssignmentFinderTestLanguage.g:13:9: '#02'
            {
            match("#02"); 


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
            // InternalAssignmentFinderTestLanguage.g:14:7: ( '#03' )
            // InternalAssignmentFinderTestLanguage.g:14:9: '#03'
            {
            match("#03"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:15:7: ( '#04' )
            // InternalAssignmentFinderTestLanguage.g:15:9: '#04'
            {
            match("#04"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:16:7: ( '#05' )
            // InternalAssignmentFinderTestLanguage.g:16:9: '#05'
            {
            match("#05"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:17:7: ( '#06' )
            // InternalAssignmentFinderTestLanguage.g:17:9: '#06'
            {
            match("#06"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:18:7: ( '#07' )
            // InternalAssignmentFinderTestLanguage.g:18:9: '#07'
            {
            match("#07"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:19:7: ( '#08' )
            // InternalAssignmentFinderTestLanguage.g:19:9: '#08'
            {
            match("#08"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:20:7: ( '#09' )
            // InternalAssignmentFinderTestLanguage.g:20:9: '#09'
            {
            match("#09"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:21:7: ( 'kw1' )
            // InternalAssignmentFinderTestLanguage.g:21:9: 'kw1'
            {
            match("kw1"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:22:7: ( 'kw2' )
            // InternalAssignmentFinderTestLanguage.g:22:9: 'kw2'
            {
            match("kw2"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:23:7: ( '%foo' )
            // InternalAssignmentFinderTestLanguage.g:23:9: '%foo'
            {
            match("%foo"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:24:7: ( 'true' )
            // InternalAssignmentFinderTestLanguage.g:24:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:25:7: ( 'false' )
            // InternalAssignmentFinderTestLanguage.g:25:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:26:7: ( 'lit3' )
            // InternalAssignmentFinderTestLanguage.g:26:9: 'lit3'
            {
            match("lit3"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:27:7: ( 'lit1' )
            // InternalAssignmentFinderTestLanguage.g:27:9: 'lit1'
            {
            match("lit1"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:28:7: ( 'lit2' )
            // InternalAssignmentFinderTestLanguage.g:28:9: 'lit2'
            {
            match("lit2"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "RULE_TERMINAL1"
    public final void mRULE_TERMINAL1() throws RecognitionException {
        try {
            int _type = RULE_TERMINAL1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:1115:16: ( '%' ( 'A' .. 'Z' )* )
            // InternalAssignmentFinderTestLanguage.g:1115:18: '%' ( 'A' .. 'Z' )*
            {
            match('%'); 
            // InternalAssignmentFinderTestLanguage.g:1115:22: ( 'A' .. 'Z' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalAssignmentFinderTestLanguage.g:1115:23: 'A' .. 'Z'
            	    {
            	    matchRange('A','Z'); 

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
    // $ANTLR end "RULE_TERMINAL1"

    // $ANTLR start "RULE_TERMINAL2"
    public final void mRULE_TERMINAL2() throws RecognitionException {
        try {
            int _type = RULE_TERMINAL2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:1117:16: ( '%' ( 'a' .. 'z' )* )
            // InternalAssignmentFinderTestLanguage.g:1117:18: '%' ( 'a' .. 'z' )*
            {
            match('%'); 
            // InternalAssignmentFinderTestLanguage.g:1117:22: ( 'a' .. 'z' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalAssignmentFinderTestLanguage.g:1117:23: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

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
    // $ANTLR end "RULE_TERMINAL2"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssignmentFinderTestLanguage.g:1119:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalAssignmentFinderTestLanguage.g:1119:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalAssignmentFinderTestLanguage.g:1119:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:1119:11: '^'
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

            // InternalAssignmentFinderTestLanguage.g:1119:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalAssignmentFinderTestLanguage.g:
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
            	    break loop4;
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
            // InternalAssignmentFinderTestLanguage.g:1121:10: ( ( '0' .. '9' )+ )
            // InternalAssignmentFinderTestLanguage.g:1121:12: ( '0' .. '9' )+
            {
            // InternalAssignmentFinderTestLanguage.g:1121:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalAssignmentFinderTestLanguage.g:1121:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // InternalAssignmentFinderTestLanguage.g:1123:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalAssignmentFinderTestLanguage.g:1123:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalAssignmentFinderTestLanguage.g:1123:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:1123:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalAssignmentFinderTestLanguage.g:1123:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalAssignmentFinderTestLanguage.g:1123:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalAssignmentFinderTestLanguage.g:1123:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:1123:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalAssignmentFinderTestLanguage.g:1123:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalAssignmentFinderTestLanguage.g:1123:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalAssignmentFinderTestLanguage.g:1123:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop7;
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
            // InternalAssignmentFinderTestLanguage.g:1125:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalAssignmentFinderTestLanguage.g:1125:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalAssignmentFinderTestLanguage.g:1125:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalAssignmentFinderTestLanguage.g:1125:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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
            // InternalAssignmentFinderTestLanguage.g:1127:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalAssignmentFinderTestLanguage.g:1127:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalAssignmentFinderTestLanguage.g:1127:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalAssignmentFinderTestLanguage.g:1127:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop10;
                }
            } while (true);

            // InternalAssignmentFinderTestLanguage.g:1127:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:1127:41: ( '\\r' )? '\\n'
                    {
                    // InternalAssignmentFinderTestLanguage.g:1127:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalAssignmentFinderTestLanguage.g:1127:41: '\\r'
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
            // InternalAssignmentFinderTestLanguage.g:1129:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalAssignmentFinderTestLanguage.g:1129:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalAssignmentFinderTestLanguage.g:1129:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalAssignmentFinderTestLanguage.g:
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
            // InternalAssignmentFinderTestLanguage.g:1131:16: ( . )
            // InternalAssignmentFinderTestLanguage.g:1131:18: .
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
        // InternalAssignmentFinderTestLanguage.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | RULE_TERMINAL1 | RULE_TERMINAL2 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=27;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // InternalAssignmentFinderTestLanguage.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalAssignmentFinderTestLanguage.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalAssignmentFinderTestLanguage.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalAssignmentFinderTestLanguage.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalAssignmentFinderTestLanguage.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalAssignmentFinderTestLanguage.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalAssignmentFinderTestLanguage.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalAssignmentFinderTestLanguage.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalAssignmentFinderTestLanguage.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalAssignmentFinderTestLanguage.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalAssignmentFinderTestLanguage.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalAssignmentFinderTestLanguage.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalAssignmentFinderTestLanguage.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalAssignmentFinderTestLanguage.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalAssignmentFinderTestLanguage.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalAssignmentFinderTestLanguage.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalAssignmentFinderTestLanguage.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalAssignmentFinderTestLanguage.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalAssignmentFinderTestLanguage.g:1:118: RULE_TERMINAL1
                {
                mRULE_TERMINAL1(); 

                }
                break;
            case 20 :
                // InternalAssignmentFinderTestLanguage.g:1:133: RULE_TERMINAL2
                {
                mRULE_TERMINAL2(); 

                }
                break;
            case 21 :
                // InternalAssignmentFinderTestLanguage.g:1:148: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 22 :
                // InternalAssignmentFinderTestLanguage.g:1:156: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 23 :
                // InternalAssignmentFinderTestLanguage.g:1:165: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 24 :
                // InternalAssignmentFinderTestLanguage.g:1:177: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 25 :
                // InternalAssignmentFinderTestLanguage.g:1:193: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 26 :
                // InternalAssignmentFinderTestLanguage.g:1:209: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 27 :
                // InternalAssignmentFinderTestLanguage.g:1:217: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\16\1\21\1\24\3\21\1\16\2\uffff\3\16\3\uffff\1\21\1\uffff\1\23\2\uffff\3\21\17\uffff\1\55\1\56\1\23\3\21\2\uffff\1\65\1\66\1\21\1\70\1\71\1\72\2\uffff\1\73\4\uffff";
    static final String DFA14_eofS =
        "\74\uffff";
    static final String DFA14_minS =
        "\1\0\1\60\1\167\1\141\1\162\1\141\1\151\1\101\2\uffff\2\0\1\52\2\uffff\1\60\1\61\1\uffff\1\157\2\uffff\1\165\1\154\1\164\17\uffff\2\60\1\157\1\145\1\163\1\61\2\uffff\1\141\1\60\1\145\3\60\2\uffff\1\60\4\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\60\1\167\1\172\1\162\1\141\1\151\1\172\2\uffff\2\uffff\1\57\2\uffff\1\71\1\62\1\uffff\1\157\2\uffff\1\165\1\154\1\164\17\uffff\2\172\1\157\1\145\1\163\1\63\2\uffff\2\172\1\145\3\172\2\uffff\1\172\4\uffff";
    static final String DFA14_acceptS =
        "\10\uffff\1\25\1\26\3\uffff\1\32\1\33\2\uffff\1\25\1\uffff\1\24\1\23\3\uffff\1\26\1\27\1\30\1\31\1\32\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\6\uffff\1\13\1\14\6\uffff\1\15\1\16\1\uffff\1\20\1\21\1\22\1\17";
    static final String DFA14_specialS =
        "\1\1\11\uffff\1\0\1\2\60\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\16\2\15\2\16\1\15\22\16\1\15\1\16\1\12\1\1\1\16\1\3\1\16\1\13\7\16\1\14\12\11\7\16\32\10\3\16\1\7\1\10\1\16\5\10\1\5\4\10\1\2\1\6\7\10\1\4\6\10\uff85\16",
            "\1\17",
            "\1\20",
            "\5\23\1\22\24\23",
            "\1\25",
            "\1\26",
            "\1\27",
            "\32\21\4\uffff\1\21\1\uffff\32\21",
            "",
            "",
            "\0\31",
            "\0\31",
            "\1\32\4\uffff\1\33",
            "",
            "",
            "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46",
            "\1\47\1\50",
            "",
            "\1\51",
            "",
            "",
            "\1\52",
            "\1\53",
            "\1\54",
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
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\63\1\64\1\62",
            "",
            "",
            "\32\23",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\1\67",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "",
            "",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    static class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | RULE_TERMINAL1 | RULE_TERMINAL2 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_10 = input.LA(1);

                        s = -1;
                        if ( ((LA14_10>='\u0000' && LA14_10<='\uFFFF')) ) {s = 25;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='#') ) {s = 1;}

                        else if ( (LA14_0=='k') ) {s = 2;}

                        else if ( (LA14_0=='%') ) {s = 3;}

                        else if ( (LA14_0=='t') ) {s = 4;}

                        else if ( (LA14_0=='f') ) {s = 5;}

                        else if ( (LA14_0=='l') ) {s = 6;}

                        else if ( (LA14_0=='^') ) {s = 7;}

                        else if ( ((LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='e')||(LA14_0>='g' && LA14_0<='j')||(LA14_0>='m' && LA14_0<='s')||(LA14_0>='u' && LA14_0<='z')) ) {s = 8;}

                        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {s = 9;}

                        else if ( (LA14_0=='\"') ) {s = 10;}

                        else if ( (LA14_0=='\'') ) {s = 11;}

                        else if ( (LA14_0=='/') ) {s = 12;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 13;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||LA14_0=='$'||LA14_0=='&'||(LA14_0>='(' && LA14_0<='.')||(LA14_0>=':' && LA14_0<='@')||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||(LA14_0>='{' && LA14_0<='\uFFFF')) ) {s = 14;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_11 = input.LA(1);

                        s = -1;
                        if ( ((LA14_11>='\u0000' && LA14_11<='\uFFFF')) ) {s = 25;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}