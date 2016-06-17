package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug348199TestLanguageLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_NL=4;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__19=19;
    public static final int RULE_STRING=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=7;

    // delegates
    // delegators

    public InternalBug348199TestLanguageLexer() {;} 
    public InternalBug348199TestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBug348199TestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBug348199TestLanguage.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug348199TestLanguage.g:11:7: ( 'define' )
            // InternalBug348199TestLanguage.g:11:9: 'define'
            {
            match("define"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug348199TestLanguage.g:12:7: ( 'timeperiod' )
            // InternalBug348199TestLanguage.g:12:9: 'timeperiod'
            {
            match("timeperiod"); 


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
            // InternalBug348199TestLanguage.g:13:7: ( '1' )
            // InternalBug348199TestLanguage.g:13:9: '1'
            {
            match('1'); 

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
            // InternalBug348199TestLanguage.g:14:7: ( '{' )
            // InternalBug348199TestLanguage.g:14:9: '{'
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
            // InternalBug348199TestLanguage.g:15:7: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:15:9: 'timeperiod_name'
            {
            match("timeperiod_name"); 


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
            // InternalBug348199TestLanguage.g:16:7: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:16:9: 'otherelement'
            {
            match("otherelement"); 


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
            // InternalBug348199TestLanguage.g:17:7: ( '}' )
            // InternalBug348199TestLanguage.g:17:9: '}'
            {
            match('}'); 

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
            // InternalBug348199TestLanguage.g:18:7: ( '2' )
            // InternalBug348199TestLanguage.g:18:9: '2'
            {
            match('2'); 

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
            // InternalBug348199TestLanguage.g:19:7: ( '3' )
            // InternalBug348199TestLanguage.g:19:9: '3'
            {
            match('3'); 

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
            // InternalBug348199TestLanguage.g:20:7: ( '4' )
            // InternalBug348199TestLanguage.g:20:9: '4'
            {
            match('4'); 

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
            // InternalBug348199TestLanguage.g:21:7: ( '5' )
            // InternalBug348199TestLanguage.g:21:9: '5'
            {
            match('5'); 

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
            // InternalBug348199TestLanguage.g:22:7: ( '6' )
            // InternalBug348199TestLanguage.g:22:9: '6'
            {
            match('6'); 

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
            // InternalBug348199TestLanguage.g:23:7: ( '7' )
            // InternalBug348199TestLanguage.g:23:9: '7'
            {
            match('7'); 

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
            // InternalBug348199TestLanguage.g:24:7: ( '8' )
            // InternalBug348199TestLanguage.g:24:9: '8'
            {
            match('8'); 

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
            // InternalBug348199TestLanguage.g:25:7: ( 'july' )
            // InternalBug348199TestLanguage.g:25:9: 'july'
            {
            match("july"); 


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
            // InternalBug348199TestLanguage.g:26:7: ( 'august' )
            // InternalBug348199TestLanguage.g:26:9: 'august'
            {
            match("august"); 


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
            // InternalBug348199TestLanguage.g:27:7: ( 'september' )
            // InternalBug348199TestLanguage.g:27:9: 'september'
            {
            match("september"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "RULE_NL"
    public final void mRULE_NL() throws RecognitionException {
        try {
            int _type = RULE_NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug348199TestLanguage.g:1397:9: ( ( '\\r' )? '\\n' )
            // InternalBug348199TestLanguage.g:1397:11: ( '\\r' )? '\\n'
            {
            // InternalBug348199TestLanguage.g:1397:11: ( '\\r' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\r') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug348199TestLanguage.g:1397:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NL"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug348199TestLanguage.g:1399:9: ( ( ' ' | '\\t' ) )
            // InternalBug348199TestLanguage.g:1399:11: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug348199TestLanguage.g:1401:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalBug348199TestLanguage.g:1401:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalBug348199TestLanguage.g:1401:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug348199TestLanguage.g:1401:11: '^'
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

            // InternalBug348199TestLanguage.g:1401:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:
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
            // InternalBug348199TestLanguage.g:1403:10: ( ( '0' .. '9' )+ )
            // InternalBug348199TestLanguage.g:1403:12: ( '0' .. '9' )+
            {
            // InternalBug348199TestLanguage.g:1403:12: ( '0' .. '9' )+
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
            	    // InternalBug348199TestLanguage.g:1403:13: '0' .. '9'
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
            // InternalBug348199TestLanguage.g:1405:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalBug348199TestLanguage.g:1405:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalBug348199TestLanguage.g:1405:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalBug348199TestLanguage.g:1405:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalBug348199TestLanguage.g:1405:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalBug348199TestLanguage.g:1405:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBug348199TestLanguage.g:1405:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalBug348199TestLanguage.g:1405:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalBug348199TestLanguage.g:1405:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalBug348199TestLanguage.g:1405:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBug348199TestLanguage.g:1405:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalBug348199TestLanguage.g:1407:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalBug348199TestLanguage.g:1407:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalBug348199TestLanguage.g:1407:24: ( options {greedy=false; } : . )*
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
            	    // InternalBug348199TestLanguage.g:1407:52: .
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
            // InternalBug348199TestLanguage.g:1409:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalBug348199TestLanguage.g:1409:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalBug348199TestLanguage.g:1409:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1409:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalBug348199TestLanguage.g:1409:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalBug348199TestLanguage.g:1409:41: ( '\\r' )? '\\n'
                    {
                    // InternalBug348199TestLanguage.g:1409:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalBug348199TestLanguage.g:1409:41: '\\r'
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

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug348199TestLanguage.g:1411:16: ( . )
            // InternalBug348199TestLanguage.g:1411:18: .
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
        // InternalBug348199TestLanguage.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | RULE_NL | RULE_WS | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_ANY_OTHER )
        int alt12=25;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalBug348199TestLanguage.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // InternalBug348199TestLanguage.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // InternalBug348199TestLanguage.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // InternalBug348199TestLanguage.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // InternalBug348199TestLanguage.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // InternalBug348199TestLanguage.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // InternalBug348199TestLanguage.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // InternalBug348199TestLanguage.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // InternalBug348199TestLanguage.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // InternalBug348199TestLanguage.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // InternalBug348199TestLanguage.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // InternalBug348199TestLanguage.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // InternalBug348199TestLanguage.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // InternalBug348199TestLanguage.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // InternalBug348199TestLanguage.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // InternalBug348199TestLanguage.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // InternalBug348199TestLanguage.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // InternalBug348199TestLanguage.g:1:112: RULE_NL
                {
                mRULE_NL(); 

                }
                break;
            case 19 :
                // InternalBug348199TestLanguage.g:1:120: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 20 :
                // InternalBug348199TestLanguage.g:1:128: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 21 :
                // InternalBug348199TestLanguage.g:1:136: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 22 :
                // InternalBug348199TestLanguage.g:1:145: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 23 :
                // InternalBug348199TestLanguage.g:1:157: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 24 :
                // InternalBug348199TestLanguage.g:1:173: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 25 :
                // InternalBug348199TestLanguage.g:1:189: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\2\34\1\36\1\uffff\1\34\1\uffff\1\43\1\44\1\45\1\46\1\47\1\50\1\51\3\34\1\32\2\uffff\1\32\2\uffff\3\32\1\uffff\1\34\1\uffff\1\34\3\uffff\1\34\10\uffff\3\34\5\uffff\11\34\1\101\5\34\1\uffff\2\34\1\111\2\34\1\114\1\34\1\uffff\2\34\1\uffff\6\34\1\126\1\130\1\34\1\uffff\1\34\1\uffff\2\34\1\135\1\34\1\uffff\1\34\1\140\1\uffff";
    static final String DFA12_eofS =
        "\141\uffff";
    static final String DFA12_minS =
        "\1\0\1\145\1\151\1\60\1\uffff\1\164\1\uffff\7\60\2\165\1\145\1\12\2\uffff\1\101\2\uffff\2\0\1\52\1\uffff\1\146\1\uffff\1\155\3\uffff\1\150\10\uffff\1\154\1\147\1\160\5\uffff\1\151\2\145\1\171\1\165\1\164\1\156\1\160\1\162\1\60\1\163\4\145\1\uffff\1\164\1\155\1\60\1\162\1\154\1\60\1\142\1\uffff\1\151\1\145\1\uffff\1\145\1\157\1\155\1\162\1\144\1\145\2\60\1\156\1\uffff\1\156\1\uffff\1\164\1\141\1\60\1\155\1\uffff\1\145\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\145\1\151\1\71\1\uffff\1\164\1\uffff\7\71\2\165\1\145\1\12\2\uffff\1\172\2\uffff\2\uffff\1\57\1\uffff\1\146\1\uffff\1\155\3\uffff\1\150\10\uffff\1\154\1\147\1\160\5\uffff\1\151\2\145\1\171\1\165\1\164\1\156\1\160\1\162\1\172\1\163\4\145\1\uffff\1\164\1\155\1\172\1\162\1\154\1\172\1\142\1\uffff\1\151\1\145\1\uffff\1\145\1\157\1\155\1\162\1\144\1\145\2\172\1\156\1\uffff\1\156\1\uffff\1\164\1\141\1\172\1\155\1\uffff\1\145\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\4\uffff\1\4\1\uffff\1\7\13\uffff\1\22\1\23\1\uffff\1\24\1\25\3\uffff\1\31\1\uffff\1\24\1\uffff\1\3\1\25\1\4\1\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\3\uffff\1\22\1\23\1\26\1\27\1\30\17\uffff\1\17\7\uffff\1\1\2\uffff\1\20\11\uffff\1\21\1\uffff\1\2\4\uffff\1\6\2\uffff\1\5";
    static final String DFA12_specialS =
        "\1\1\26\uffff\1\0\1\2\110\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\32\1\23\1\22\2\32\1\21\22\32\1\23\1\32\1\27\4\32\1\30\7\32\1\31\1\26\1\3\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\26\7\32\32\25\3\32\1\24\1\25\1\32\1\17\2\25\1\1\5\25\1\16\4\25\1\5\3\25\1\20\1\2\6\25\1\4\1\32\1\6\uff82\32",
            "\1\33",
            "\1\35",
            "\12\37",
            "",
            "\1\41",
            "",
            "\12\37",
            "\12\37",
            "\12\37",
            "\12\37",
            "\12\37",
            "\12\37",
            "\12\37",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "",
            "",
            "\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\0\57",
            "\0\57",
            "\1\60\4\uffff\1\61",
            "",
            "\1\62",
            "",
            "\1\63",
            "",
            "",
            "",
            "\1\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "",
            "",
            "",
            "",
            "",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "",
            "\1\107",
            "\1\110",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\112",
            "\1\113",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\115",
            "",
            "\1\116",
            "\1\117",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\127\1\uffff\32\34",
            "\1\131",
            "",
            "\1\132",
            "",
            "\1\133",
            "\1\134",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\136",
            "",
            "\1\137",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
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
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | RULE_NL | RULE_WS | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_23 = input.LA(1);

                        s = -1;
                        if ( ((LA12_23>='\u0000' && LA12_23<='\uFFFF')) ) {s = 47;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='d') ) {s = 1;}

                        else if ( (LA12_0=='t') ) {s = 2;}

                        else if ( (LA12_0=='1') ) {s = 3;}

                        else if ( (LA12_0=='{') ) {s = 4;}

                        else if ( (LA12_0=='o') ) {s = 5;}

                        else if ( (LA12_0=='}') ) {s = 6;}

                        else if ( (LA12_0=='2') ) {s = 7;}

                        else if ( (LA12_0=='3') ) {s = 8;}

                        else if ( (LA12_0=='4') ) {s = 9;}

                        else if ( (LA12_0=='5') ) {s = 10;}

                        else if ( (LA12_0=='6') ) {s = 11;}

                        else if ( (LA12_0=='7') ) {s = 12;}

                        else if ( (LA12_0=='8') ) {s = 13;}

                        else if ( (LA12_0=='j') ) {s = 14;}

                        else if ( (LA12_0=='a') ) {s = 15;}

                        else if ( (LA12_0=='s') ) {s = 16;}

                        else if ( (LA12_0=='\r') ) {s = 17;}

                        else if ( (LA12_0=='\n') ) {s = 18;}

                        else if ( (LA12_0=='\t'||LA12_0==' ') ) {s = 19;}

                        else if ( (LA12_0=='^') ) {s = 20;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='b' && LA12_0<='c')||(LA12_0>='e' && LA12_0<='i')||(LA12_0>='k' && LA12_0<='n')||(LA12_0>='p' && LA12_0<='r')||(LA12_0>='u' && LA12_0<='z')) ) {s = 21;}

                        else if ( (LA12_0=='0'||LA12_0=='9') ) {s = 22;}

                        else if ( (LA12_0=='\"') ) {s = 23;}

                        else if ( (LA12_0=='\'') ) {s = 24;}

                        else if ( (LA12_0=='/') ) {s = 25;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 26;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_24 = input.LA(1);

                        s = -1;
                        if ( ((LA12_24>='\u0000' && LA12_24<='\uFFFF')) ) {s = 47;}

                        else s = 26;

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