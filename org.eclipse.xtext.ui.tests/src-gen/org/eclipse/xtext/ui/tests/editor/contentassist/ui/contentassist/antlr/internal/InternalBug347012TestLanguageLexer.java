package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug347012TestLanguageLexer extends Lexer {
    public static final int RULE_ESCAPE=11;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_LT=4;
    public static final int T__19=19;
    public static final int RULE_HEX=12;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_NUMBER=6;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_IDPLAINCHAR=8;
    public static final int RULE_WS=10;
    public static final int RULE_DIGIT=9;

    // delegates
    // delegators

    public InternalBug347012TestLanguageLexer() {;} 
    public InternalBug347012TestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBug347012TestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBug347012TestLanguage.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug347012TestLanguage.g:11:7: ( ';' )
            // InternalBug347012TestLanguage.g:11:9: ';'
            {
            match(';'); 

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
            // InternalBug347012TestLanguage.g:12:7: ( '.' )
            // InternalBug347012TestLanguage.g:12:9: '.'
            {
            match('.'); 

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
            // InternalBug347012TestLanguage.g:13:7: ( 'package' )
            // InternalBug347012TestLanguage.g:13:9: 'package'
            {
            match("package"); 


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
            // InternalBug347012TestLanguage.g:14:7: ( '{' )
            // InternalBug347012TestLanguage.g:14:9: '{'
            {
            match('{'); 

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
            // InternalBug347012TestLanguage.g:15:7: ( '}' )
            // InternalBug347012TestLanguage.g:15:9: '}'
            {
            match('}'); 

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
            // InternalBug347012TestLanguage.g:16:7: ( 'public' )
            // InternalBug347012TestLanguage.g:16:9: 'public'
            {
            match("public"); 


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
            // InternalBug347012TestLanguage.g:17:7: ( 'class' )
            // InternalBug347012TestLanguage.g:17:9: 'class'
            {
            match("class"); 


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
            // InternalBug347012TestLanguage.g:18:7: ( 'var' )
            // InternalBug347012TestLanguage.g:18:9: 'var'
            {
            match("var"); 


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
            // InternalBug347012TestLanguage.g:19:7: ( ',' )
            // InternalBug347012TestLanguage.g:19:9: ','
            {
            match(','); 

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
            // InternalBug347012TestLanguage.g:20:7: ( ':' )
            // InternalBug347012TestLanguage.g:20:9: ':'
            {
            match(':'); 

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
            // InternalBug347012TestLanguage.g:21:7: ( '=' )
            // InternalBug347012TestLanguage.g:21:9: '='
            {
            match('='); 

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
            // InternalBug347012TestLanguage.g:22:7: ( 'true' )
            // InternalBug347012TestLanguage.g:22:9: 'true'
            {
            match("true"); 


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
            // InternalBug347012TestLanguage.g:23:7: ( 'false' )
            // InternalBug347012TestLanguage.g:23:9: 'false'
            {
            match("false"); 


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
            // InternalBug347012TestLanguage.g:24:7: ( 'private' )
            // InternalBug347012TestLanguage.g:24:9: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug347012TestLanguage.g:2508:9: ( RULE_IDPLAINCHAR ( RULE_IDPLAINCHAR | RULE_DIGIT )* )
            // InternalBug347012TestLanguage.g:2508:11: RULE_IDPLAINCHAR ( RULE_IDPLAINCHAR | RULE_DIGIT )*
            {
            mRULE_IDPLAINCHAR(); 
            // InternalBug347012TestLanguage.g:2508:28: ( RULE_IDPLAINCHAR | RULE_DIGIT )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='$'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_LT"
    public final void mRULE_LT() throws RecognitionException {
        try {
            int _type = RULE_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug347012TestLanguage.g:2510:9: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // InternalBug347012TestLanguage.g:2510:11: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // InternalBug347012TestLanguage.g:2510:11: ( '\\r' '\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') ) {
                    alt2=1;
                }
                else {
                    alt2=2;}
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug347012TestLanguage.g:2510:12: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:2510:22: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // InternalBug347012TestLanguage.g:2510:27: '\\n'
                    {
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
    // $ANTLR end "RULE_LT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug347012TestLanguage.g:2512:9: ( ( ' ' | '\\t' )+ )
            // InternalBug347012TestLanguage.g:2512:11: ( ' ' | '\\t' )+
            {
            // InternalBug347012TestLanguage.g:2512:11: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug347012TestLanguage.g:2514:13: ( '\"' ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalBug347012TestLanguage.g:2514:15: '\"' ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // InternalBug347012TestLanguage.g:2514:19: ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\"' ) ) )*
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
            	    // InternalBug347012TestLanguage.g:2514:20: '\\\\' RULE_ESCAPE
            	    {
            	    match('\\'); 
            	    mRULE_ESCAPE(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalBug347012TestLanguage.g:2514:37: ~ ( ( '\\\\' | '\"' ) )
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_NUMBER"
    public final void mRULE_NUMBER() throws RecognitionException {
        try {
            int _type = RULE_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug347012TestLanguage.g:2516:13: ( ( ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )+ )? | '.' ( RULE_DIGIT )+ ) )
            // InternalBug347012TestLanguage.g:2516:15: ( ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )+ )? | '.' ( RULE_DIGIT )+ )
            {
            // InternalBug347012TestLanguage.g:2516:15: ( ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )+ )? | '.' ( RULE_DIGIT )+ )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                alt9=1;
            }
            else if ( (LA9_0=='.') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBug347012TestLanguage.g:2516:16: ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )+ )?
                    {
                    // InternalBug347012TestLanguage.g:2516:16: ( RULE_DIGIT )+
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
                    	    // InternalBug347012TestLanguage.g:2516:16: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

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

                    // InternalBug347012TestLanguage.g:2516:28: ( '.' ( RULE_DIGIT )+ )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='.') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalBug347012TestLanguage.g:2516:29: '.' ( RULE_DIGIT )+
                            {
                            match('.'); 
                            // InternalBug347012TestLanguage.g:2516:33: ( RULE_DIGIT )+
                            int cnt6=0;
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // InternalBug347012TestLanguage.g:2516:33: RULE_DIGIT
                            	    {
                            	    mRULE_DIGIT(); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt6 >= 1 ) break loop6;
                                        EarlyExitException eee =
                                            new EarlyExitException(6, input);
                                        throw eee;
                                }
                                cnt6++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:2516:47: '.' ( RULE_DIGIT )+
                    {
                    match('.'); 
                    // InternalBug347012TestLanguage.g:2516:51: ( RULE_DIGIT )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalBug347012TestLanguage.g:2516:51: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

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
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NUMBER"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:2518:21: ( '0' .. '9' )
            // InternalBug347012TestLanguage.g:2518:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:2520:19: ( ( RULE_DIGIT | 'A' .. 'F' | 'a' .. 'f' ) )
            // InternalBug347012TestLanguage.g:2520:21: ( RULE_DIGIT | 'A' .. 'F' | 'a' .. 'f' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_ESCAPE"
    public final void mRULE_ESCAPE() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:2522:22: ( ( 'b' | 't' | 'n' | 'f' | 'v' | 'r' | '\"' | '\\'' | '\\\\' | 'u' RULE_HEX RULE_HEX RULE_HEX RULE_HEX ) )
            // InternalBug347012TestLanguage.g:2522:24: ( 'b' | 't' | 'n' | 'f' | 'v' | 'r' | '\"' | '\\'' | '\\\\' | 'u' RULE_HEX RULE_HEX RULE_HEX RULE_HEX )
            {
            // InternalBug347012TestLanguage.g:2522:24: ( 'b' | 't' | 'n' | 'f' | 'v' | 'r' | '\"' | '\\'' | '\\\\' | 'u' RULE_HEX RULE_HEX RULE_HEX RULE_HEX )
            int alt10=10;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt10=1;
                }
                break;
            case 't':
                {
                alt10=2;
                }
                break;
            case 'n':
                {
                alt10=3;
                }
                break;
            case 'f':
                {
                alt10=4;
                }
                break;
            case 'v':
                {
                alt10=5;
                }
                break;
            case 'r':
                {
                alt10=6;
                }
                break;
            case '\"':
                {
                alt10=7;
                }
                break;
            case '\'':
                {
                alt10=8;
                }
                break;
            case '\\':
                {
                alt10=9;
                }
                break;
            case 'u':
                {
                alt10=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalBug347012TestLanguage.g:2522:25: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:2522:29: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 3 :
                    // InternalBug347012TestLanguage.g:2522:33: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 4 :
                    // InternalBug347012TestLanguage.g:2522:37: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 5 :
                    // InternalBug347012TestLanguage.g:2522:41: 'v'
                    {
                    match('v'); 

                    }
                    break;
                case 6 :
                    // InternalBug347012TestLanguage.g:2522:45: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 7 :
                    // InternalBug347012TestLanguage.g:2522:49: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 8 :
                    // InternalBug347012TestLanguage.g:2522:53: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 9 :
                    // InternalBug347012TestLanguage.g:2522:58: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 10 :
                    // InternalBug347012TestLanguage.g:2522:63: 'u' RULE_HEX RULE_HEX RULE_HEX RULE_HEX
                    {
                    match('u'); 
                    mRULE_HEX(); 
                    mRULE_HEX(); 
                    mRULE_HEX(); 
                    mRULE_HEX(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ESCAPE"

    // $ANTLR start "RULE_IDPLAINCHAR"
    public final void mRULE_IDPLAINCHAR() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:2524:27: ( ( '$' | 'A' .. 'Z' | '_' | 'a' .. 'z' ) )
            // InternalBug347012TestLanguage.g:2524:29: ( '$' | 'A' .. 'Z' | '_' | 'a' .. 'z' )
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_IDPLAINCHAR"

    public void mTokens() throws RecognitionException {
        // InternalBug347012TestLanguage.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | RULE_ID | RULE_LT | RULE_WS | RULE_STRING | RULE_NUMBER )
        int alt11=19;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // InternalBug347012TestLanguage.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalBug347012TestLanguage.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalBug347012TestLanguage.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalBug347012TestLanguage.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalBug347012TestLanguage.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalBug347012TestLanguage.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalBug347012TestLanguage.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalBug347012TestLanguage.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalBug347012TestLanguage.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalBug347012TestLanguage.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalBug347012TestLanguage.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalBug347012TestLanguage.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalBug347012TestLanguage.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalBug347012TestLanguage.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalBug347012TestLanguage.g:1:94: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 16 :
                // InternalBug347012TestLanguage.g:1:102: RULE_LT
                {
                mRULE_LT(); 

                }
                break;
            case 17 :
                // InternalBug347012TestLanguage.g:1:110: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 18 :
                // InternalBug347012TestLanguage.g:1:118: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 19 :
                // InternalBug347012TestLanguage.g:1:130: RULE_NUMBER
                {
                mRULE_NUMBER(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\2\uffff\1\22\1\15\2\uffff\2\15\3\uffff\2\15\6\uffff\13\15\1\45\6\15\1\uffff\1\54\4\15\1\61\1\uffff\1\62\1\15\1\64\1\15\2\uffff\1\66\1\uffff\1\67\2\uffff";
    static final String DFA11_eofS =
        "\70\uffff";
    static final String DFA11_minS =
        "\1\11\1\uffff\1\60\1\141\2\uffff\1\154\1\141\3\uffff\1\162\1\141\6\uffff\1\143\1\142\1\151\1\141\1\162\1\165\1\154\1\153\1\154\1\166\1\163\1\44\1\145\1\163\1\141\1\151\1\141\1\163\1\uffff\1\44\1\145\1\147\1\143\1\164\1\44\1\uffff\1\44\1\145\1\44\1\145\2\uffff\1\44\1\uffff\1\44\2\uffff";
    static final String DFA11_maxS =
        "\1\175\1\uffff\1\71\1\165\2\uffff\1\154\1\141\3\uffff\1\162\1\141\6\uffff\1\143\1\142\1\151\1\141\1\162\1\165\1\154\1\153\1\154\1\166\1\163\1\172\1\145\1\163\1\141\1\151\1\141\1\163\1\uffff\1\172\1\145\1\147\1\143\1\164\1\172\1\uffff\1\172\1\145\1\172\1\145\2\uffff\1\172\1\uffff\1\172\2\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\2\uffff\1\11\1\12\1\13\2\uffff\1\17\1\20\1\21\1\22\1\23\1\2\22\uffff\1\10\6\uffff\1\14\4\uffff\1\7\1\15\1\uffff\1\6\1\uffff\1\3\1\16";
    static final String DFA11_specialS =
        "\70\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\17\1\16\2\uffff\1\16\22\uffff\1\17\1\uffff\1\20\1\uffff\1\15\7\uffff\1\10\1\uffff\1\2\1\uffff\12\21\1\11\1\1\1\uffff\1\12\3\uffff\32\15\4\uffff\1\15\1\uffff\2\15\1\6\2\15\1\14\11\15\1\3\3\15\1\13\1\15\1\7\4\15\1\4\1\uffff\1\5",
            "",
            "\12\21",
            "\1\23\20\uffff\1\25\2\uffff\1\24",
            "",
            "",
            "\1\26",
            "\1\27",
            "",
            "",
            "",
            "\1\30",
            "\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\15\13\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "",
            "\1\15\13\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\15\13\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "\1\15\13\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\63",
            "\1\15\13\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\65",
            "",
            "",
            "\1\15\13\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "\1\15\13\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | RULE_ID | RULE_LT | RULE_WS | RULE_STRING | RULE_NUMBER );";
        }
    }
 

}