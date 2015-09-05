package org.eclipse.xtext.grammarinheritance.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConcreteTestLanguageLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int SUPER_ID=8;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__19=19;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_REAL=4;
    public static final int RULE_WS=11;

    // delegates
    // delegators

    public InternalConcreteTestLanguageLexer() {;} 
    public InternalConcreteTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalConcreteTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalConcreteTestLanguage.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteTestLanguage.g:11:7: ( 'model' )
            // InternalConcreteTestLanguage.g:11:9: 'model'
            {
            match("model"); 


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
            // InternalConcreteTestLanguage.g:12:7: ( ':' )
            // InternalConcreteTestLanguage.g:12:9: ':'
            {
            match(':'); 

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
            // InternalConcreteTestLanguage.g:13:7: ( 'overriddenelement' )
            // InternalConcreteTestLanguage.g:13:9: 'overriddenelement'
            {
            match("overriddenelement"); 


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
            // InternalConcreteTestLanguage.g:14:7: ( 'overridden other element' )
            // InternalConcreteTestLanguage.g:14:9: 'overridden other element'
            {
            match("overridden other element"); 


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
            // InternalConcreteTestLanguage.g:15:7: ( '-' )
            // InternalConcreteTestLanguage.g:15:9: '-'
            {
            match('-'); 

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
            // InternalConcreteTestLanguage.g:16:7: ( 'subrule1' )
            // InternalConcreteTestLanguage.g:16:9: 'subrule1'
            {
            match("subrule1"); 


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
            // InternalConcreteTestLanguage.g:17:7: ( 'subrule3' )
            // InternalConcreteTestLanguage.g:17:9: 'subrule3'
            {
            match("subrule3"); 


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
            // InternalConcreteTestLanguage.g:18:7: ( 'element' )
            // InternalConcreteTestLanguage.g:18:9: 'element'
            {
            match("element"); 


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
            // InternalConcreteTestLanguage.g:19:7: ( 'overridemodel' )
            // InternalConcreteTestLanguage.g:19:9: 'overridemodel'
            {
            match("overridemodel"); 


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
            // InternalConcreteTestLanguage.g:20:7: ( 'extendedmodel' )
            // InternalConcreteTestLanguage.g:20:9: 'extendedmodel'
            {
            match("extendedmodel"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteTestLanguage.g:739:9: ( SUPER_ID )
            // InternalConcreteTestLanguage.g:739:11: SUPER_ID
            {
            mSUPER_ID(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_REAL"
    public final void mRULE_REAL() throws RecognitionException {
        try {
            int _type = RULE_REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteTestLanguage.g:741:11: ( RULE_INT '.' RULE_INT )
            // InternalConcreteTestLanguage.g:741:13: RULE_INT '.' RULE_INT
            {
            mRULE_INT(); 
            match('.'); 
            mRULE_INT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_REAL"

    // $ANTLR start "SUPER_ID"
    public final void mSUPER_ID() throws RecognitionException {
        try {
            int _type = SUPER_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteTestLanguage.g:743:10: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '\\u00F6' | '\\u00E4' | '\\u00FC' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalConcreteTestLanguage.g:743:12: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '\\u00F6' | '\\u00E4' | '\\u00FC' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalConcreteTestLanguage.g:743:12: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalConcreteTestLanguage.g:743:12: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00E4'||input.LA(1)=='\u00F6'||input.LA(1)=='\u00FC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalConcreteTestLanguage.g:743:68: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalConcreteTestLanguage.g:
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
    // $ANTLR end "SUPER_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteTestLanguage.g:745:10: ( ( '0' .. '9' )+ )
            // InternalConcreteTestLanguage.g:745:12: ( '0' .. '9' )+
            {
            // InternalConcreteTestLanguage.g:745:12: ( '0' .. '9' )+
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
            	    // InternalConcreteTestLanguage.g:745:13: '0' .. '9'
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
            // InternalConcreteTestLanguage.g:747:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalConcreteTestLanguage.g:747:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalConcreteTestLanguage.g:747:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalConcreteTestLanguage.g:747:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalConcreteTestLanguage.g:747:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalConcreteTestLanguage.g:747:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalConcreteTestLanguage.g:747:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalConcreteTestLanguage.g:747:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalConcreteTestLanguage.g:747:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalConcreteTestLanguage.g:747:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalConcreteTestLanguage.g:747:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalConcreteTestLanguage.g:749:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalConcreteTestLanguage.g:749:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalConcreteTestLanguage.g:749:24: ( options {greedy=false; } : . )*
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
            	    // InternalConcreteTestLanguage.g:749:52: .
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
            // InternalConcreteTestLanguage.g:751:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalConcreteTestLanguage.g:751:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalConcreteTestLanguage.g:751:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalConcreteTestLanguage.g:751:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalConcreteTestLanguage.g:751:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalConcreteTestLanguage.g:751:41: ( '\\r' )? '\\n'
                    {
                    // InternalConcreteTestLanguage.g:751:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalConcreteTestLanguage.g:751:41: '\\r'
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
            // InternalConcreteTestLanguage.g:753:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalConcreteTestLanguage.g:753:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalConcreteTestLanguage.g:753:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalConcreteTestLanguage.g:
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
            // InternalConcreteTestLanguage.g:755:16: ( . )
            // InternalConcreteTestLanguage.g:755:18: .
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
        // InternalConcreteTestLanguage.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | RULE_ID | RULE_REAL | SUPER_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=19;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalConcreteTestLanguage.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalConcreteTestLanguage.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalConcreteTestLanguage.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalConcreteTestLanguage.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalConcreteTestLanguage.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalConcreteTestLanguage.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalConcreteTestLanguage.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalConcreteTestLanguage.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalConcreteTestLanguage.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalConcreteTestLanguage.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalConcreteTestLanguage.g:1:70: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 12 :
                // InternalConcreteTestLanguage.g:1:78: RULE_REAL
                {
                mRULE_REAL(); 

                }
                break;
            case 13 :
                // InternalConcreteTestLanguage.g:1:88: SUPER_ID
                {
                mSUPER_ID(); 

                }
                break;
            case 14 :
                // InternalConcreteTestLanguage.g:1:97: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 15 :
                // InternalConcreteTestLanguage.g:1:106: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 16 :
                // InternalConcreteTestLanguage.g:1:118: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 17 :
                // InternalConcreteTestLanguage.g:1:134: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 18 :
                // InternalConcreteTestLanguage.g:1:150: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 19 :
                // InternalConcreteTestLanguage.g:1:158: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\21\1\uffff\1\21\1\uffff\2\21\1\16\1\21\1\31\3\16\2\uffff\2\21\2\uffff\1\21\1\uffff\4\21\2\uffff\1\31\4\uffff\12\21\1\57\4\21\1\uffff\6\21\1\74\3\21\1\100\1\101\1\uffff\3\21\2\uffff\5\21\1\uffff\6\21\1\121\1\122\1\21\2\uffff\2\21\1\126\1\uffff";
    static final String DFA12_eofS =
        "\127\uffff";
    static final String DFA12_minS =
        "\1\0\1\60\1\uffff\1\60\1\uffff\2\60\1\101\1\60\1\56\2\0\1\52\2\uffff\2\60\2\uffff\1\60\1\uffff\4\60\2\uffff\1\56\4\uffff\17\60\1\uffff\14\60\1\uffff\3\60\2\uffff\1\60\1\40\3\60\1\uffff\11\60\2\uffff\3\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\172\1\uffff\1\172\1\uffff\2\172\1\u00fc\1\172\1\71\2\uffff\1\57\2\uffff\2\172\2\uffff\1\172\1\uffff\4\172\2\uffff\1\71\4\uffff\17\172\1\uffff\14\172\1\uffff\3\172\2\uffff\5\172\1\uffff\11\172\2\uffff\3\172\1\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\uffff\1\5\10\uffff\1\22\1\23\2\uffff\1\13\1\2\1\uffff\1\5\4\uffff\1\16\1\14\1\uffff\1\17\1\20\1\21\1\22\17\uffff\1\1\14\uffff\1\10\3\uffff\1\6\1\7\5\uffff\1\4\11\uffff\1\11\1\12\3\uffff\1\3";
    static final String DFA12_specialS =
        "\1\0\11\uffff\1\2\1\1\113\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\16\2\15\2\16\1\15\22\16\1\15\1\16\1\12\4\16\1\13\5\16\1\4\1\16\1\14\12\11\1\2\6\16\32\10\3\16\1\7\1\10\1\16\4\10\1\6\7\10\1\1\1\10\1\3\3\10\1\5\7\10\151\16\1\10\21\16\1\10\5\16\1\10\uff03\16",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\16\20\1\17\13\20",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\25\20\1\23\4\20",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\24\20\1\25\5\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\13\20\1\26\13\20\1\27\2\20",
            "\32\30\4\uffff\1\30\1\uffff\32\30\151\uffff\1\30\21\uffff\1\30\5\uffff\1\30",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\32\1\uffff\12\33",
            "\0\34",
            "\0\34",
            "\1\35\4\uffff\1\36",
            "",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\3\20\1\40\26\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\41\25\20",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\1\20\1\42\30\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\43\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\23\20\1\44\6\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "",
            "\1\32\1\uffff\12\33",
            "",
            "",
            "",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\45\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\21\20\1\46\10\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\21\20\1\47\10\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\14\20\1\50\15\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\51\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\13\20\1\52\16\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\21\20\1\53\10\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\24\20\1\54\5\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\55\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\15\20\1\56\14\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\10\20\1\60\21\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\13\20\1\61\16\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\15\20\1\62\14\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\3\20\1\63\26\20",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\3\20\1\64\26\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\65\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\23\20\1\66\6\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\67\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\3\20\1\70\1\71\25\20",
            "\1\20\1\72\1\20\1\73\6\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\3\20\1\75\26\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\76\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\14\20\1\77\15\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\14\20\1\102\15\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\15\20\1\103\14\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\16\20\1\104\13\20",
            "",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\16\20\1\105\13\20",
            "\1\107\17\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\106\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\3\20\1\110\26\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\3\20\1\111\26\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\13\20\1\112\16\20",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\113\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\114\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\115\25\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\13\20\1\116\16\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\13\20\1\117\16\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\14\20\1\120\15\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\4\20\1\123\25\20",
            "",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\15\20\1\124\14\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\23\20\1\125\6\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | RULE_ID | RULE_REAL | SUPER_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='m') ) {s = 1;}

                        else if ( (LA12_0==':') ) {s = 2;}

                        else if ( (LA12_0=='o') ) {s = 3;}

                        else if ( (LA12_0=='-') ) {s = 4;}

                        else if ( (LA12_0=='s') ) {s = 5;}

                        else if ( (LA12_0=='e') ) {s = 6;}

                        else if ( (LA12_0=='^') ) {s = 7;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='d')||(LA12_0>='f' && LA12_0<='l')||LA12_0=='n'||(LA12_0>='p' && LA12_0<='r')||(LA12_0>='t' && LA12_0<='z')||LA12_0=='\u00E4'||LA12_0=='\u00F6'||LA12_0=='\u00FC') ) {s = 8;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 9;}

                        else if ( (LA12_0=='\"') ) {s = 10;}

                        else if ( (LA12_0=='\'') ) {s = 11;}

                        else if ( (LA12_0=='/') ) {s = 12;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 13;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<=',')||LA12_0=='.'||(LA12_0>=';' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\u00E3')||(LA12_0>='\u00E5' && LA12_0<='\u00F5')||(LA12_0>='\u00F7' && LA12_0<='\u00FB')||(LA12_0>='\u00FD' && LA12_0<='\uFFFF')) ) {s = 14;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_11 = input.LA(1);

                        s = -1;
                        if ( ((LA12_11>='\u0000' && LA12_11<='\uFFFF')) ) {s = 28;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_10 = input.LA(1);

                        s = -1;
                        if ( ((LA12_10>='\u0000' && LA12_10<='\uFFFF')) ) {s = 28;}

                        else s = 14;

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