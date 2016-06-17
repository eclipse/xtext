package org.eclipse.xtext.parser.epatch.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEpatchTestLanguageLexer extends Lexer {
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_FRAGMENT=6;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalEpatchTestLanguageLexer() {;} 
    public InternalEpatchTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalEpatchTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalEpatchTestLanguage.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:11:7: ( 'epatch' )
            // InternalEpatchTestLanguage.g:11:9: 'epatch'
            {
            match("epatch"); 


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
            // InternalEpatchTestLanguage.g:12:7: ( '{' )
            // InternalEpatchTestLanguage.g:12:9: '{'
            {
            match('{'); 

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
            // InternalEpatchTestLanguage.g:13:7: ( '}' )
            // InternalEpatchTestLanguage.g:13:9: '}'
            {
            match('}'); 

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
            // InternalEpatchTestLanguage.g:14:7: ( 'import' )
            // InternalEpatchTestLanguage.g:14:9: 'import'
            {
            match("import"); 


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
            // InternalEpatchTestLanguage.g:15:7: ( 'uri' )
            // InternalEpatchTestLanguage.g:15:9: 'uri'
            {
            match("uri"); 


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
            // InternalEpatchTestLanguage.g:16:7: ( 'ns' )
            // InternalEpatchTestLanguage.g:16:9: 'ns'
            {
            match("ns"); 


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
            // InternalEpatchTestLanguage.g:17:7: ( 'java' )
            // InternalEpatchTestLanguage.g:17:9: 'java'
            {
            match("java"); 


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
            // InternalEpatchTestLanguage.g:18:7: ( '.' )
            // InternalEpatchTestLanguage.g:18:9: '.'
            {
            match('.'); 

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
            // InternalEpatchTestLanguage.g:19:7: ( 'extension' )
            // InternalEpatchTestLanguage.g:19:9: 'extension'
            {
            match("extension"); 


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
            // InternalEpatchTestLanguage.g:20:7: ( '::' )
            // InternalEpatchTestLanguage.g:20:9: '::'
            {
            match("::"); 


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
            // InternalEpatchTestLanguage.g:21:7: ( 'resource' )
            // InternalEpatchTestLanguage.g:21:9: 'resource'
            {
            match("resource"); 


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
            // InternalEpatchTestLanguage.g:22:7: ( 'left' )
            // InternalEpatchTestLanguage.g:22:9: 'left'
            {
            match("left"); 


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
            // InternalEpatchTestLanguage.g:23:7: ( ';' )
            // InternalEpatchTestLanguage.g:23:9: ';'
            {
            match(';'); 

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
            // InternalEpatchTestLanguage.g:24:7: ( 'right' )
            // InternalEpatchTestLanguage.g:24:9: 'right'
            {
            match("right"); 


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
            // InternalEpatchTestLanguage.g:25:7: ( 'object' )
            // InternalEpatchTestLanguage.g:25:9: 'object'
            {
            match("object"); 


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
            // InternalEpatchTestLanguage.g:26:7: ( '=' )
            // InternalEpatchTestLanguage.g:26:9: '='
            {
            match('='); 

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
            // InternalEpatchTestLanguage.g:27:7: ( '|' )
            // InternalEpatchTestLanguage.g:27:9: '|'
            {
            match('|'); 

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
            // InternalEpatchTestLanguage.g:28:7: ( '[' )
            // InternalEpatchTestLanguage.g:28:9: '['
            {
            match('['); 

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
            // InternalEpatchTestLanguage.g:29:7: ( ',' )
            // InternalEpatchTestLanguage.g:29:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:30:7: ( ']' )
            // InternalEpatchTestLanguage.g:30:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:31:7: ( ':' )
            // InternalEpatchTestLanguage.g:31:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:32:7: ( 'null' )
            // InternalEpatchTestLanguage.g:32:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:33:7: ( 'new' )
            // InternalEpatchTestLanguage.g:33:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:34:7: ( 'copy' )
            // InternalEpatchTestLanguage.g:34:9: 'copy'
            {
            match("copy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:35:7: ( 'migrate' )
            // InternalEpatchTestLanguage.g:35:9: 'migrate'
            {
            match("migrate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:36:7: ( 'as' )
            // InternalEpatchTestLanguage.g:36:9: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:37:7: ( 'each' )
            // InternalEpatchTestLanguage.g:37:9: 'each'
            {
            match("each"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:38:7: ( '(' )
            // InternalEpatchTestLanguage.g:38:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:39:7: ( ')' )
            // InternalEpatchTestLanguage.g:39:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "RULE_FRAGMENT"
    public final void mRULE_FRAGMENT() throws RecognitionException {
        try {
            int _type = RULE_FRAGMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:2284:15: ( '#' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '[' | ']' | '{' | '}' | '.' | '@' )+ )
            // InternalEpatchTestLanguage.g:2284:17: '#' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '[' | ']' | '{' | '}' | '.' | '@' )+
            {
            match('#'); 
            // InternalEpatchTestLanguage.g:2284:21: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '[' | ']' | '{' | '}' | '.' | '@' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='.' && LA1_0<='9')||(LA1_0>='@' && LA1_0<='[')||LA1_0==']'||LA1_0=='_'||(LA1_0>='a' && LA1_0<='{')||LA1_0=='}') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalEpatchTestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='.' && input.LA(1)<='9')||(input.LA(1)>='@' && input.LA(1)<='[')||input.LA(1)==']'||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='{')||input.LA(1)=='}' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
    // $ANTLR end "RULE_FRAGMENT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEpatchTestLanguage.g:2286:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalEpatchTestLanguage.g:2286:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalEpatchTestLanguage.g:2286:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalEpatchTestLanguage.g:2286:11: '^'
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

            // InternalEpatchTestLanguage.g:2286:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalEpatchTestLanguage.g:
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
            // InternalEpatchTestLanguage.g:2288:10: ( ( '0' .. '9' )+ )
            // InternalEpatchTestLanguage.g:2288:12: ( '0' .. '9' )+
            {
            // InternalEpatchTestLanguage.g:2288:12: ( '0' .. '9' )+
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
            	    // InternalEpatchTestLanguage.g:2288:13: '0' .. '9'
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
            // InternalEpatchTestLanguage.g:2290:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalEpatchTestLanguage.g:2290:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalEpatchTestLanguage.g:2290:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalEpatchTestLanguage.g:2290:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalEpatchTestLanguage.g:2290:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalEpatchTestLanguage.g:2290:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalEpatchTestLanguage.g:2290:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalEpatchTestLanguage.g:2290:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalEpatchTestLanguage.g:2290:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalEpatchTestLanguage.g:2290:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalEpatchTestLanguage.g:2290:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalEpatchTestLanguage.g:2292:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalEpatchTestLanguage.g:2292:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalEpatchTestLanguage.g:2292:24: ( options {greedy=false; } : . )*
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
            	    // InternalEpatchTestLanguage.g:2292:52: .
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
            // InternalEpatchTestLanguage.g:2294:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalEpatchTestLanguage.g:2294:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalEpatchTestLanguage.g:2294:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalEpatchTestLanguage.g:2294:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalEpatchTestLanguage.g:2294:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalEpatchTestLanguage.g:2294:41: ( '\\r' )? '\\n'
                    {
                    // InternalEpatchTestLanguage.g:2294:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalEpatchTestLanguage.g:2294:41: '\\r'
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
            // InternalEpatchTestLanguage.g:2296:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalEpatchTestLanguage.g:2296:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalEpatchTestLanguage.g:2296:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalEpatchTestLanguage.g:
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
            // InternalEpatchTestLanguage.g:2298:16: ( . )
            // InternalEpatchTestLanguage.g:2298:18: .
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
        // InternalEpatchTestLanguage.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | RULE_FRAGMENT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=37;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // InternalEpatchTestLanguage.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // InternalEpatchTestLanguage.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // InternalEpatchTestLanguage.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // InternalEpatchTestLanguage.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // InternalEpatchTestLanguage.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // InternalEpatchTestLanguage.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // InternalEpatchTestLanguage.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // InternalEpatchTestLanguage.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // InternalEpatchTestLanguage.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // InternalEpatchTestLanguage.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // InternalEpatchTestLanguage.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // InternalEpatchTestLanguage.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // InternalEpatchTestLanguage.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // InternalEpatchTestLanguage.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // InternalEpatchTestLanguage.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // InternalEpatchTestLanguage.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // InternalEpatchTestLanguage.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // InternalEpatchTestLanguage.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // InternalEpatchTestLanguage.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // InternalEpatchTestLanguage.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // InternalEpatchTestLanguage.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // InternalEpatchTestLanguage.g:1:136: T__33
                {
                mT__33(); 

                }
                break;
            case 23 :
                // InternalEpatchTestLanguage.g:1:142: T__34
                {
                mT__34(); 

                }
                break;
            case 24 :
                // InternalEpatchTestLanguage.g:1:148: T__35
                {
                mT__35(); 

                }
                break;
            case 25 :
                // InternalEpatchTestLanguage.g:1:154: T__36
                {
                mT__36(); 

                }
                break;
            case 26 :
                // InternalEpatchTestLanguage.g:1:160: T__37
                {
                mT__37(); 

                }
                break;
            case 27 :
                // InternalEpatchTestLanguage.g:1:166: T__38
                {
                mT__38(); 

                }
                break;
            case 28 :
                // InternalEpatchTestLanguage.g:1:172: T__39
                {
                mT__39(); 

                }
                break;
            case 29 :
                // InternalEpatchTestLanguage.g:1:178: T__40
                {
                mT__40(); 

                }
                break;
            case 30 :
                // InternalEpatchTestLanguage.g:1:184: RULE_FRAGMENT
                {
                mRULE_FRAGMENT(); 

                }
                break;
            case 31 :
                // InternalEpatchTestLanguage.g:1:198: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 32 :
                // InternalEpatchTestLanguage.g:1:206: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 33 :
                // InternalEpatchTestLanguage.g:1:215: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 34 :
                // InternalEpatchTestLanguage.g:1:227: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 35 :
                // InternalEpatchTestLanguage.g:1:243: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 36 :
                // InternalEpatchTestLanguage.g:1:259: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 37 :
                // InternalEpatchTestLanguage.g:1:267: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\1\44\2\uffff\4\44\1\uffff\1\57\2\44\1\uffff\1\44\5\uffff\3\44\2\uffff\2\40\2\uffff\3\40\2\uffff\3\44\3\uffff\2\44\1\112\3\44\3\uffff\3\44\1\uffff\1\44\5\uffff\2\44\1\124\10\uffff\4\44\1\131\1\uffff\1\44\1\133\7\44\1\uffff\2\44\1\145\1\44\1\uffff\1\147\1\uffff\1\150\2\44\1\153\1\44\1\155\3\44\1\uffff\1\44\2\uffff\1\44\1\163\1\uffff\1\44\1\uffff\1\44\1\166\1\44\1\170\1\44\1\uffff\1\172\1\44\1\uffff\1\44\1\uffff\1\44\1\uffff\1\176\1\44\1\u0080\1\uffff\1\u0081\2\uffff";
    static final String DFA13_eofS =
        "\u0082\uffff";
    static final String DFA13_minS =
        "\1\0\1\141\2\uffff\1\155\1\162\1\145\1\141\1\uffff\1\72\2\145\1\uffff\1\142\5\uffff\1\157\1\151\1\163\2\uffff\1\56\1\101\2\uffff\2\0\1\52\2\uffff\1\141\1\164\1\143\3\uffff\1\160\1\151\1\60\1\154\1\167\1\166\3\uffff\1\163\1\147\1\146\1\uffff\1\152\5\uffff\1\160\1\147\1\60\10\uffff\1\164\1\145\1\150\1\157\1\60\1\uffff\1\154\1\60\1\141\1\157\1\150\1\164\1\145\1\171\1\162\1\uffff\1\143\1\156\1\60\1\162\1\uffff\1\60\1\uffff\1\60\1\165\1\164\1\60\1\143\1\60\1\141\1\150\1\163\1\uffff\1\164\2\uffff\1\162\1\60\1\uffff\1\164\1\uffff\1\164\1\60\1\151\1\60\1\143\1\uffff\1\60\1\145\1\uffff\1\157\1\uffff\1\145\1\uffff\1\60\1\156\1\60\1\uffff\1\60\2\uffff";
    static final String DFA13_maxS =
        "\1\uffff\1\170\2\uffff\1\155\1\162\1\165\1\141\1\uffff\1\72\1\151\1\145\1\uffff\1\142\5\uffff\1\157\1\151\1\163\2\uffff\1\175\1\172\2\uffff\2\uffff\1\57\2\uffff\1\141\1\164\1\143\3\uffff\1\160\1\151\1\172\1\154\1\167\1\166\3\uffff\1\163\1\147\1\146\1\uffff\1\152\5\uffff\1\160\1\147\1\172\10\uffff\1\164\1\145\1\150\1\157\1\172\1\uffff\1\154\1\172\1\141\1\157\1\150\1\164\1\145\1\171\1\162\1\uffff\1\143\1\156\1\172\1\162\1\uffff\1\172\1\uffff\1\172\1\165\1\164\1\172\1\143\1\172\1\141\1\150\1\163\1\uffff\1\164\2\uffff\1\162\1\172\1\uffff\1\164\1\uffff\1\164\1\172\1\151\1\172\1\143\1\uffff\1\172\1\145\1\uffff\1\157\1\uffff\1\145\1\uffff\1\172\1\156\1\172\1\uffff\1\172\2\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\2\1\3\4\uffff\1\10\3\uffff\1\15\1\uffff\1\20\1\21\1\22\1\23\1\24\3\uffff\1\34\1\35\2\uffff\1\37\1\40\3\uffff\1\44\1\45\3\uffff\1\37\1\2\1\3\6\uffff\1\10\1\12\1\25\3\uffff\1\15\1\uffff\1\20\1\21\1\22\1\23\1\24\3\uffff\1\34\1\35\1\36\1\40\1\41\1\42\1\43\1\44\5\uffff\1\6\11\uffff\1\32\4\uffff\1\5\1\uffff\1\27\11\uffff\1\33\1\uffff\1\26\1\7\2\uffff\1\14\1\uffff\1\30\5\uffff\1\16\2\uffff\1\1\1\uffff\1\4\1\uffff\1\17\3\uffff\1\31\1\uffff\1\13\1\11";
    static final String DFA13_specialS =
        "\1\1\33\uffff\1\0\1\2\144\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\40\2\37\2\40\1\37\22\40\1\37\1\40\1\34\1\30\3\40\1\35\1\26\1\27\2\40\1\21\1\40\1\10\1\36\12\33\1\11\1\14\1\40\1\16\3\40\32\32\1\20\1\40\1\22\1\31\1\32\1\40\1\25\1\32\1\23\1\32\1\1\3\32\1\4\1\7\1\32\1\13\1\24\1\6\1\15\2\32\1\12\2\32\1\5\5\32\1\2\1\17\1\3\uff82\40",
            "\1\43\16\uffff\1\41\7\uffff\1\42",
            "",
            "",
            "\1\47",
            "\1\50",
            "\1\53\15\uffff\1\51\1\uffff\1\52",
            "\1\54",
            "",
            "\1\56",
            "\1\60\3\uffff\1\61",
            "\1\62",
            "",
            "\1\64",
            "",
            "",
            "",
            "",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "\14\77\6\uffff\34\77\1\uffff\1\77\1\uffff\1\77\1\uffff\33\77\1\uffff\1\77",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\0\101",
            "\0\101",
            "\1\102\4\uffff\1\103",
            "",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "",
            "",
            "",
            "\1\110",
            "\1\111",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\113",
            "\1\114",
            "\1\115",
            "",
            "",
            "",
            "\1\116",
            "\1\117",
            "\1\120",
            "",
            "\1\121",
            "",
            "",
            "",
            "",
            "",
            "\1\122",
            "\1\123",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\132",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "",
            "\1\143",
            "\1\144",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\146",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\151",
            "\1\152",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\154",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\156",
            "\1\157",
            "\1\160",
            "",
            "\1\161",
            "",
            "",
            "\1\162",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\164",
            "",
            "\1\165",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\167",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\171",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\173",
            "",
            "\1\174",
            "",
            "\1\175",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\177",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
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
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | RULE_FRAGMENT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_28 = input.LA(1);

                        s = -1;
                        if ( ((LA13_28>='\u0000' && LA13_28<='\uFFFF')) ) {s = 65;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( (LA13_0=='e') ) {s = 1;}

                        else if ( (LA13_0=='{') ) {s = 2;}

                        else if ( (LA13_0=='}') ) {s = 3;}

                        else if ( (LA13_0=='i') ) {s = 4;}

                        else if ( (LA13_0=='u') ) {s = 5;}

                        else if ( (LA13_0=='n') ) {s = 6;}

                        else if ( (LA13_0=='j') ) {s = 7;}

                        else if ( (LA13_0=='.') ) {s = 8;}

                        else if ( (LA13_0==':') ) {s = 9;}

                        else if ( (LA13_0=='r') ) {s = 10;}

                        else if ( (LA13_0=='l') ) {s = 11;}

                        else if ( (LA13_0==';') ) {s = 12;}

                        else if ( (LA13_0=='o') ) {s = 13;}

                        else if ( (LA13_0=='=') ) {s = 14;}

                        else if ( (LA13_0=='|') ) {s = 15;}

                        else if ( (LA13_0=='[') ) {s = 16;}

                        else if ( (LA13_0==',') ) {s = 17;}

                        else if ( (LA13_0==']') ) {s = 18;}

                        else if ( (LA13_0=='c') ) {s = 19;}

                        else if ( (LA13_0=='m') ) {s = 20;}

                        else if ( (LA13_0=='a') ) {s = 21;}

                        else if ( (LA13_0=='(') ) {s = 22;}

                        else if ( (LA13_0==')') ) {s = 23;}

                        else if ( (LA13_0=='#') ) {s = 24;}

                        else if ( (LA13_0=='^') ) {s = 25;}

                        else if ( ((LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||LA13_0=='b'||LA13_0=='d'||(LA13_0>='f' && LA13_0<='h')||LA13_0=='k'||(LA13_0>='p' && LA13_0<='q')||(LA13_0>='s' && LA13_0<='t')||(LA13_0>='v' && LA13_0<='z')) ) {s = 26;}

                        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {s = 27;}

                        else if ( (LA13_0=='\"') ) {s = 28;}

                        else if ( (LA13_0=='\'') ) {s = 29;}

                        else if ( (LA13_0=='/') ) {s = 30;}

                        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {s = 31;}

                        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||(LA13_0>='$' && LA13_0<='&')||(LA13_0>='*' && LA13_0<='+')||LA13_0=='-'||LA13_0=='<'||(LA13_0>='>' && LA13_0<='@')||LA13_0=='\\'||LA13_0=='`'||(LA13_0>='~' && LA13_0<='\uFFFF')) ) {s = 32;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_29 = input.LA(1);

                        s = -1;
                        if ( ((LA13_29>='\u0000' && LA13_29<='\uFFFF')) ) {s = 65;}

                        else s = 32;

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