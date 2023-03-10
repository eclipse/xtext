package org.eclipse.xtext.ui.codetemplates.lexer;

// Use our own Lexer superclass by means of import4. 
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SingleCodetemplateLexer extends Lexer {
    public static final int DollarSignDollarSign=6;
    public static final int DollarSignLeftCurlyBracket=7;
    public static final int Templates=4;
    public static final int RULE_STRING=17;
    public static final int Comma=12;
    public static final int LeftParenthesis=10;
    public static final int Colon=14;
    public static final int RightCurlyBracket=15;
    public static final int EOF=-1;
    public static final int FullStop=13;
    public static final int RULE_ID=16;
    public static final int RULE_WS=18;
    public static final int For=5;
    public static final int RightParenthesis=11;
    public static final int RULE_ANY_OTHER=19;
    public static final int GreaterThanSignGreaterThanSign=8;
    public static final int DollarSign=9;

      private boolean literal = false;
      private boolean templateVariable = false;
      
      public void initialize(boolean literal, boolean templateVariable) {
        this.literal = literal;
        this.templateVariable = templateVariable;
      }


    // delegates
    // delegators

    public SingleCodetemplateLexer() {;} 
    public SingleCodetemplateLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SingleCodetemplateLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "SingleCodetemplateLexer.g"; }

    // $ANTLR start "Templates"
    public final void mTemplates() throws RecognitionException {
        try {
            int _type = Templates;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:25:11: ({...}? => 'templates' )
            // SingleCodetemplateLexer.g:25:13: {...}? => 'templates'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "Templates", "!literal || templateVariable");
            }
            match("templates"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Templates"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:27:5: ({...}? => 'for' )
            // SingleCodetemplateLexer.g:27:7: {...}? => 'for'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "For", "!literal || templateVariable");
            }
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "For"

    // $ANTLR start "DollarSignDollarSign"
    public final void mDollarSignDollarSign() throws RecognitionException {
        try {
            int _type = DollarSignDollarSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:29:22: ( '$$' )
            // SingleCodetemplateLexer.g:29:24: '$$'
            {
            match("$$"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DollarSignDollarSign"

    // $ANTLR start "DollarSignLeftCurlyBracket"
    public final void mDollarSignLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = DollarSignLeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:31:28: ( '${' )
            // SingleCodetemplateLexer.g:31:30: '${'
            {
            match("${"); 

            templateVariable = true;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DollarSignLeftCurlyBracket"

    // $ANTLR start "GreaterThanSignGreaterThanSign"
    public final void mGreaterThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:33:32: ({...}? => '>>' )
            // SingleCodetemplateLexer.g:33:34: {...}? => '>>'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "GreaterThanSignGreaterThanSign", "!literal || templateVariable");
            }
            match(">>"); 

             if (!literal) literal = true; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignGreaterThanSign"

    // $ANTLR start "DollarSign"
    public final void mDollarSign() throws RecognitionException {
        try {
            int _type = DollarSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:35:12: ( '$' )
            // SingleCodetemplateLexer.g:35:14: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DollarSign"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:37:17: ({...}? => '(' )
            // SingleCodetemplateLexer.g:37:19: {...}? => '('
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "LeftParenthesis", "!literal || templateVariable");
            }
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
            // SingleCodetemplateLexer.g:39:18: ({...}? => ')' )
            // SingleCodetemplateLexer.g:39:20: {...}? => ')'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "RightParenthesis", "!literal || templateVariable");
            }
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:41:7: ({...}? => ',' )
            // SingleCodetemplateLexer.g:41:9: {...}? => ','
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "Comma", "!literal || templateVariable");
            }
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:43:10: ({...}? => '.' )
            // SingleCodetemplateLexer.g:43:12: {...}? => '.'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "FullStop", "!literal || templateVariable");
            }
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
            // SingleCodetemplateLexer.g:45:7: ({...}? => ':' )
            // SingleCodetemplateLexer.g:45:9: {...}? => ':'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "Colon", "!literal || templateVariable");
            }
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:47:19: ({...}? => '}' )
            // SingleCodetemplateLexer.g:47:21: {...}? => '}'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "RightCurlyBracket", "!literal || templateVariable");
            }
            match('}'); 
            templateVariable = false;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:51:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // SingleCodetemplateLexer.g:51:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // SingleCodetemplateLexer.g:51:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // SingleCodetemplateLexer.g:51:11: '^'
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

            // SingleCodetemplateLexer.g:51:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SingleCodetemplateLexer.g:
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

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:53:13: ({...}? => ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // SingleCodetemplateLexer.g:53:15: {...}? => ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "RULE_STRING", "!literal || templateVariable");
            }
            // SingleCodetemplateLexer.g:53:48: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // SingleCodetemplateLexer.g:53:50: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // SingleCodetemplateLexer.g:53:55: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    alt3=1;
                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // SingleCodetemplateLexer.g:53:56: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    break;
            	case 2 :
            	    // SingleCodetemplateLexer.g:53:97: ~ ( ( '\\\\' | '\\'' ) )
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
            	    break loop3;
                }
            } while (true);

            match('\''); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:55:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // SingleCodetemplateLexer.g:55:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // SingleCodetemplateLexer.g:55:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\t' && LA4_0<='\n')||LA4_0=='\r'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // SingleCodetemplateLexer.g:
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
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SingleCodetemplateLexer.g:57:16: ( . )
            // SingleCodetemplateLexer.g:57:18: .
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
        // SingleCodetemplateLexer.g:1:8: ( Templates | For | DollarSignDollarSign | DollarSignLeftCurlyBracket | GreaterThanSignGreaterThanSign | DollarSign | LeftParenthesis | RightParenthesis | Comma | FullStop | Colon | RightCurlyBracket | RULE_ID | RULE_STRING | RULE_WS | RULE_ANY_OTHER )
        int alt5=16;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // SingleCodetemplateLexer.g:1:10: Templates
                {
                mTemplates(); 

                }
                break;
            case 2 :
                // SingleCodetemplateLexer.g:1:20: For
                {
                mFor(); 

                }
                break;
            case 3 :
                // SingleCodetemplateLexer.g:1:24: DollarSignDollarSign
                {
                mDollarSignDollarSign(); 

                }
                break;
            case 4 :
                // SingleCodetemplateLexer.g:1:45: DollarSignLeftCurlyBracket
                {
                mDollarSignLeftCurlyBracket(); 

                }
                break;
            case 5 :
                // SingleCodetemplateLexer.g:1:72: GreaterThanSignGreaterThanSign
                {
                mGreaterThanSignGreaterThanSign(); 

                }
                break;
            case 6 :
                // SingleCodetemplateLexer.g:1:103: DollarSign
                {
                mDollarSign(); 

                }
                break;
            case 7 :
                // SingleCodetemplateLexer.g:1:114: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 8 :
                // SingleCodetemplateLexer.g:1:130: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 9 :
                // SingleCodetemplateLexer.g:1:147: Comma
                {
                mComma(); 

                }
                break;
            case 10 :
                // SingleCodetemplateLexer.g:1:153: FullStop
                {
                mFullStop(); 

                }
                break;
            case 11 :
                // SingleCodetemplateLexer.g:1:162: Colon
                {
                mColon(); 

                }
                break;
            case 12 :
                // SingleCodetemplateLexer.g:1:168: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 13 :
                // SingleCodetemplateLexer.g:1:186: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 14 :
                // SingleCodetemplateLexer.g:1:194: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 15 :
                // SingleCodetemplateLexer.g:1:206: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 16 :
                // SingleCodetemplateLexer.g:1:214: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\2\21\1\25\1\17\1\27\1\30\1\31\1\32\1\33\1\34\1\17\1\uffff\1\17\2\uffff\1\21\1\uffff\1\21\14\uffff\1\21\1\50\6\uffff\1\21\1\uffff\1\21\1\uffff\3\21\1\57\2\uffff";
    static final String DFA5_eofS =
        "\61\uffff";
    static final String DFA5_minS =
        "\1\0\1\145\1\157\1\44\1\76\6\0\1\101\1\uffff\1\0\2\uffff\1\155\1\uffff\1\162\4\uffff\6\0\2\uffff\1\160\1\60\6\uffff\1\154\1\0\1\141\1\uffff\1\164\1\145\1\163\1\60\1\0\1\uffff";
    static final String DFA5_maxS =
        "\1\uffff\1\145\1\157\1\173\1\76\6\0\1\172\1\uffff\1\uffff\2\uffff\1\155\1\uffff\1\162\4\uffff\6\0\2\uffff\1\160\1\172\6\uffff\1\154\1\0\1\141\1\uffff\1\164\1\145\1\163\1\172\1\0\1\uffff";
    static final String DFA5_acceptS =
        "\14\uffff\1\15\1\uffff\1\17\1\20\1\uffff\1\15\1\uffff\1\3\1\4\1\6\1\5\6\uffff\1\16\1\17\2\uffff\1\7\1\10\1\11\1\12\1\13\1\14\3\uffff\1\2\5\uffff\1\1";
    static final String DFA5_specialS =
        "\1\12\3\uffff\1\11\10\uffff\1\0\11\uffff\1\3\1\4\1\5\1\6\1\7\1\10\13\uffff\1\2\6\uffff\1\1\1\uffff}>";
    static final String[] DFA5_transitionS = {
            "\11\17\2\16\2\17\1\16\22\17\1\16\3\17\1\3\2\17\1\15\1\5\1\6\2\17\1\7\1\17\1\10\13\17\1\11\3\17\1\4\2\17\32\14\3\17\1\13\1\14\1\17\5\14\1\2\15\14\1\1\6\14\2\17\1\12\uff82\17",
            "\1\20",
            "\1\22",
            "\1\23\126\uffff\1\24",
            "\1\26",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\32\21\4\uffff\1\21\1\uffff\32\21",
            "",
            "\0\35",
            "",
            "",
            "\1\37",
            "",
            "\1\40",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\47",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\51",
            "\1\uffff",
            "\1\53",
            "",
            "\1\54",
            "\1\55",
            "\1\56",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\1\uffff",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Templates | For | DollarSignDollarSign | DollarSignLeftCurlyBracket | GreaterThanSignGreaterThanSign | DollarSign | LeftParenthesis | RightParenthesis | Comma | FullStop | Colon | RightCurlyBracket | RULE_ID | RULE_STRING | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_13 = input.LA(1);

                         
                        int index5_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA5_13>='\u0000' && LA5_13<='\uFFFF')) && ((!literal || templateVariable))) {s = 29;}

                        else s = 15;

                         
                        input.seek(index5_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_47 = input.LA(1);

                         
                        int index5_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 48;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_47);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_40 = input.LA(1);

                         
                        int index5_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 42;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_40);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_23 = input.LA(1);

                         
                        int index5_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 33;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index5_23);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_24 = input.LA(1);

                         
                        int index5_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 34;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index5_24);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_25 = input.LA(1);

                         
                        int index5_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 35;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index5_25);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA5_26 = input.LA(1);

                         
                        int index5_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 36;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index5_26);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA5_27 = input.LA(1);

                         
                        int index5_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 37;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index5_27);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA5_28 = input.LA(1);

                         
                        int index5_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 38;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index5_28);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA5_4 = input.LA(1);

                         
                        int index5_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_4=='>') && ((!literal || templateVariable))) {s = 22;}

                        else s = 15;

                         
                        input.seek(index5_4);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA5_0 = input.LA(1);

                        s = -1;
                        if ( (LA5_0=='t') ) {s = 1;}

                        else if ( (LA5_0=='f') ) {s = 2;}

                        else if ( (LA5_0=='$') ) {s = 3;}

                        else if ( (LA5_0=='>') ) {s = 4;}

                        else if ( (LA5_0=='(') ) {s = 5;}

                        else if ( (LA5_0==')') ) {s = 6;}

                        else if ( (LA5_0==',') ) {s = 7;}

                        else if ( (LA5_0=='.') ) {s = 8;}

                        else if ( (LA5_0==':') ) {s = 9;}

                        else if ( (LA5_0=='}') ) {s = 10;}

                        else if ( (LA5_0=='^') ) {s = 11;}

                        else if ( ((LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='e')||(LA5_0>='g' && LA5_0<='s')||(LA5_0>='u' && LA5_0<='z')) ) {s = 12;}

                        else if ( (LA5_0=='\'') ) {s = 13;}

                        else if ( ((LA5_0>='\t' && LA5_0<='\n')||LA5_0=='\r'||LA5_0==' ') ) {s = 14;}

                        else if ( ((LA5_0>='\u0000' && LA5_0<='\b')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\u001F')||(LA5_0>='!' && LA5_0<='#')||(LA5_0>='%' && LA5_0<='&')||(LA5_0>='*' && LA5_0<='+')||LA5_0=='-'||(LA5_0>='/' && LA5_0<='9')||(LA5_0>=';' && LA5_0<='=')||(LA5_0>='?' && LA5_0<='@')||(LA5_0>='[' && LA5_0<=']')||LA5_0=='`'||(LA5_0>='{' && LA5_0<='|')||(LA5_0>='~' && LA5_0<='\uFFFF')) ) {s = 15;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}