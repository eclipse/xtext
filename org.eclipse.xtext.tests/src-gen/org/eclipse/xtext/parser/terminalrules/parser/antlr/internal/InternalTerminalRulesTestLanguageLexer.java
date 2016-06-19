package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTerminalRulesTestLanguageLexer extends Lexer {
    public static final int RULE_RICH_STRING=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ESCAPED_CHAR=12;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_IN_RICH_STRING=13;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=8;
    public static final int EOF=-1;

    // delegates
    // delegators

    public InternalTerminalRulesTestLanguageLexer() {;} 
    public InternalTerminalRulesTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalTerminalRulesTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalTerminalRulesTestLanguage.g"; }

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTerminalRulesTestLanguage.g:238:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalTerminalRulesTestLanguage.g:238:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalTerminalRulesTestLanguage.g:238:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalTerminalRulesTestLanguage.g:238:11: '^'
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

            // InternalTerminalRulesTestLanguage.g:238:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTerminalRulesTestLanguage.g:
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
            // InternalTerminalRulesTestLanguage.g:240:10: ( ( '0' .. '9' )+ )
            // InternalTerminalRulesTestLanguage.g:240:12: ( '0' .. '9' )+
            {
            // InternalTerminalRulesTestLanguage.g:240:12: ( '0' .. '9' )+
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
            	    // InternalTerminalRulesTestLanguage.g:240:13: '0' .. '9'
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
            // InternalTerminalRulesTestLanguage.g:242:13: ( ( '\"' ( RULE_ESCAPED_CHAR | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( RULE_ESCAPED_CHAR | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalTerminalRulesTestLanguage.g:242:15: ( '\"' ( RULE_ESCAPED_CHAR | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( RULE_ESCAPED_CHAR | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalTerminalRulesTestLanguage.g:242:15: ( '\"' ( RULE_ESCAPED_CHAR | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( RULE_ESCAPED_CHAR | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalTerminalRulesTestLanguage.g:242:16: '\"' ( RULE_ESCAPED_CHAR | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalTerminalRulesTestLanguage.g:242:20: ( RULE_ESCAPED_CHAR | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalTerminalRulesTestLanguage.g:242:21: RULE_ESCAPED_CHAR
                    	    {
                    	    mRULE_ESCAPED_CHAR(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTerminalRulesTestLanguage.g:242:39: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalTerminalRulesTestLanguage.g:242:59: '\\'' ( RULE_ESCAPED_CHAR | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalTerminalRulesTestLanguage.g:242:64: ( RULE_ESCAPED_CHAR | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalTerminalRulesTestLanguage.g:242:65: RULE_ESCAPED_CHAR
                    	    {
                    	    mRULE_ESCAPED_CHAR(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTerminalRulesTestLanguage.g:242:83: ~ ( ( '\\\\' | '\\'' ) )
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

    // $ANTLR start "RULE_RICH_STRING"
    public final void mRULE_RICH_STRING() throws RecognitionException {
        try {
            int _type = RULE_RICH_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTerminalRulesTestLanguage.g:244:18: ( '\\'\\'\\'' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // InternalTerminalRulesTestLanguage.g:244:20: '\\'\\'\\'' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match("'''"); 

            // InternalTerminalRulesTestLanguage.g:244:29: ( RULE_IN_RICH_STRING )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\'') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='\'') ) {
                        int LA7_4 = input.LA(3);

                        if ( ((LA7_4>='\u0000' && LA7_4<='&')||(LA7_4>='(' && LA7_4<='\u00AA')||(LA7_4>='\u00AC' && LA7_4<='\uFFFF')) ) {
                            alt7=1;
                        }


                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='&')||(LA7_1>='(' && LA7_1<='\u00AA')||(LA7_1>='\u00AC' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='\u00AA')||(LA7_0>='\u00AC' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalTerminalRulesTestLanguage.g:244:29: RULE_IN_RICH_STRING
            	    {
            	    mRULE_IN_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalTerminalRulesTestLanguage.g:244:50: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\'') ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1=='\'') ) {
                    int LA10_3 = input.LA(3);

                    if ( (LA10_3=='\'') ) {
                        alt10=1;
                    }
                    else {
                        alt10=2;}
                }
                else {
                    alt10=2;}
            }
            else {
                alt10=2;}
            switch (alt10) {
                case 1 :
                    // InternalTerminalRulesTestLanguage.g:244:51: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // InternalTerminalRulesTestLanguage.g:244:60: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // InternalTerminalRulesTestLanguage.g:244:60: ( '\\'' ( '\\'' )? )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\'') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalTerminalRulesTestLanguage.g:244:61: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // InternalTerminalRulesTestLanguage.g:244:66: ( '\\'' )?
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( (LA8_0=='\'') ) {
                                alt8=1;
                            }
                            switch (alt8) {
                                case 1 :
                                    // InternalTerminalRulesTestLanguage.g:244:66: '\\''
                                    {
                                    match('\''); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    match(EOF); 

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
    // $ANTLR end "RULE_RICH_STRING"

    // $ANTLR start "RULE_IN_RICH_STRING"
    public final void mRULE_IN_RICH_STRING() throws RecognitionException {
        try {
            // InternalTerminalRulesTestLanguage.g:246:30: ( ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) ) )
            // InternalTerminalRulesTestLanguage.g:246:32: ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) )
            {
            // InternalTerminalRulesTestLanguage.g:246:32: ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) )
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\'') ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1=='\'') ) {
                    alt11=1;
                }
                else if ( ((LA11_1>='\u0000' && LA11_1<='&')||(LA11_1>='(' && LA11_1<='\u00AA')||(LA11_1>='\u00AC' && LA11_1<='\uFFFF')) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA11_0>='\u0000' && LA11_0<='&')||(LA11_0>='(' && LA11_0<='\u00AA')||(LA11_0>='\u00AC' && LA11_0<='\uFFFF')) ) {
                alt11=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalTerminalRulesTestLanguage.g:246:33: '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) )
                    {
                    match("''"); 

                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\u00AA')||(input.LA(1)>='\u00AC' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // InternalTerminalRulesTestLanguage.g:246:59: '\\'' ~ ( ( '\\u00AB' | '\\'' ) )
                    {
                    match('\''); 
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\u00AA')||(input.LA(1)>='\u00AC' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 3 :
                    // InternalTerminalRulesTestLanguage.g:246:83: ~ ( ( '\\u00AB' | '\\'' ) )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\u00AA')||(input.LA(1)>='\u00AC' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_IN_RICH_STRING"

    // $ANTLR start "RULE_ESCAPED_CHAR"
    public final void mRULE_ESCAPED_CHAR() throws RecognitionException {
        try {
            // InternalTerminalRulesTestLanguage.g:248:28: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) )
            // InternalTerminalRulesTestLanguage.g:248:30: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
            {
            match('\\'); 
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
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
    // $ANTLR end "RULE_ESCAPED_CHAR"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTerminalRulesTestLanguage.g:250:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalTerminalRulesTestLanguage.g:250:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalTerminalRulesTestLanguage.g:250:24: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='*') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1=='/') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_1>='\u0000' && LA12_1<='.')||(LA12_1>='0' && LA12_1<='\uFFFF')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalTerminalRulesTestLanguage.g:250:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
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
            // InternalTerminalRulesTestLanguage.g:252:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalTerminalRulesTestLanguage.g:252:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalTerminalRulesTestLanguage.g:252:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalTerminalRulesTestLanguage.g:252:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop13;
                }
            } while (true);

            // InternalTerminalRulesTestLanguage.g:252:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTerminalRulesTestLanguage.g:252:41: ( '\\r' )? '\\n'
                    {
                    // InternalTerminalRulesTestLanguage.g:252:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalTerminalRulesTestLanguage.g:252:41: '\\r'
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
            // InternalTerminalRulesTestLanguage.g:254:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalTerminalRulesTestLanguage.g:254:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalTerminalRulesTestLanguage.g:254:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalTerminalRulesTestLanguage.g:
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
            // InternalTerminalRulesTestLanguage.g:256:16: ( . )
            // InternalTerminalRulesTestLanguage.g:256:18: .
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
        // InternalTerminalRulesTestLanguage.g:1:8: ( RULE_ID | RULE_INT | RULE_STRING | RULE_RICH_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt17=8;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // InternalTerminalRulesTestLanguage.g:1:10: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 2 :
                // InternalTerminalRulesTestLanguage.g:1:18: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 3 :
                // InternalTerminalRulesTestLanguage.g:1:27: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 4 :
                // InternalTerminalRulesTestLanguage.g:1:39: RULE_RICH_STRING
                {
                mRULE_RICH_STRING(); 

                }
                break;
            case 5 :
                // InternalTerminalRulesTestLanguage.g:1:56: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 6 :
                // InternalTerminalRulesTestLanguage.g:1:72: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 7 :
                // InternalTerminalRulesTestLanguage.g:1:88: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 8 :
                // InternalTerminalRulesTestLanguage.g:1:96: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\1\uffff\1\10\2\uffff\3\10\5\uffff\1\13\4\uffff";
    static final String DFA17_eofS =
        "\21\uffff";
    static final String DFA17_minS =
        "\1\0\1\101\2\uffff\2\0\1\52\5\uffff\1\47\4\uffff";
    static final String DFA17_maxS =
        "\1\uffff\1\172\2\uffff\2\uffff\1\57\5\uffff\1\47\4\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\1\1\2\3\uffff\1\7\1\10\1\1\1\2\1\3\1\uffff\1\5\1\6\1\7\1\4";
    static final String DFA17_specialS =
        "\1\2\3\uffff\1\0\1\1\13\uffff}>";
    static final String[] DFA17_transitionS = {
            "\11\10\2\7\2\10\1\7\22\10\1\7\1\10\1\4\4\10\1\5\7\10\1\6\12\3\7\10\32\2\3\10\1\1\1\2\1\10\32\2\uff85\10",
            "\32\11\4\uffff\1\11\1\uffff\32\11",
            "",
            "",
            "\0\13",
            "\47\13\1\14\uffd8\13",
            "\1\15\4\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "\1\20",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    static class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_ID | RULE_INT | RULE_STRING | RULE_RICH_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_4 = input.LA(1);

                        s = -1;
                        if ( ((LA17_4>='\u0000' && LA17_4<='\uFFFF')) ) {s = 11;}

                        else s = 8;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_5 = input.LA(1);

                        s = -1;
                        if ( (LA17_5=='\'') ) {s = 12;}

                        else if ( ((LA17_5>='\u0000' && LA17_5<='&')||(LA17_5>='(' && LA17_5<='\uFFFF')) ) {s = 11;}

                        else s = 8;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_0 = input.LA(1);

                        s = -1;
                        if ( (LA17_0=='^') ) {s = 1;}

                        else if ( ((LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {s = 2;}

                        else if ( ((LA17_0>='0' && LA17_0<='9')) ) {s = 3;}

                        else if ( (LA17_0=='\"') ) {s = 4;}

                        else if ( (LA17_0=='\'') ) {s = 5;}

                        else if ( (LA17_0=='/') ) {s = 6;}

                        else if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {s = 7;}

                        else if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||LA17_0=='!'||(LA17_0>='#' && LA17_0<='&')||(LA17_0>='(' && LA17_0<='.')||(LA17_0>=':' && LA17_0<='@')||(LA17_0>='[' && LA17_0<=']')||LA17_0=='`'||(LA17_0>='{' && LA17_0<='\uFFFF')) ) {s = 8;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}