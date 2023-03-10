package org.eclipse.xtext.ui.codetemplates.lexer;

// Use our own Lexer superclass by means of import2. 
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CodetemplatesLexer extends Lexer {
    public static final int DollarSignDollarSign=7;
    public static final int DollarSignLeftCurlyBracket=8;
    public static final int Templates=4;
    public static final int RULE_STRING=19;
    public static final int Comma=14;
    public static final int LeftParenthesis=12;
    public static final int Colon=16;
    public static final int RightCurlyBracket=17;
    public static final int EOF=-1;
    public static final int FullStop=15;
    public static final int ReverseSolidusLessThanSignLessThanSign=5;
    public static final int RULE_ID=18;
    public static final int RULE_WS=20;
    public static final int For=6;
    public static final int RightParenthesis=13;
    public static final int RULE_ANY_OTHER=21;
    public static final int GreaterThanSignGreaterThanSign=10;
    public static final int DollarSign=11;
    public static final int LessThanSignLessThanSign=9;

      private boolean literal = false;
      private boolean templateVariable = false;
      
      public void initialize(boolean literal, boolean templateVariable) {
        this.literal = literal;
        this.templateVariable = templateVariable;
      }


    // delegates
    // delegators

    public CodetemplatesLexer() {;} 
    public CodetemplatesLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CodetemplatesLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "CodetemplatesLexer.g"; }

    // $ANTLR start "Templates"
    public final void mTemplates() throws RecognitionException {
        try {
            int _type = Templates;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodetemplatesLexer.g:25:11: ({...}? => 'templates' )
            // CodetemplatesLexer.g:25:13: {...}? => 'templates'
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

    // $ANTLR start "ReverseSolidusLessThanSignLessThanSign"
    public final void mReverseSolidusLessThanSignLessThanSign() throws RecognitionException {
        try {
            int _type = ReverseSolidusLessThanSignLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodetemplatesLexer.g:27:40: ( '\\\\<<' )
            // CodetemplatesLexer.g:27:42: '\\\\<<'
            {
            match("\\<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ReverseSolidusLessThanSignLessThanSign"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodetemplatesLexer.g:29:5: ({...}? => 'for' )
            // CodetemplatesLexer.g:29:7: {...}? => 'for'
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
            // CodetemplatesLexer.g:31:22: ( '$$' )
            // CodetemplatesLexer.g:31:24: '$$'
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
            // CodetemplatesLexer.g:33:28: ( '${' )
            // CodetemplatesLexer.g:33:30: '${'
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

    // $ANTLR start "LessThanSignLessThanSign"
    public final void mLessThanSignLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodetemplatesLexer.g:35:26: ( '<<' )
            // CodetemplatesLexer.g:35:28: '<<'
            {
            match("<<"); 

             if (literal) literal = false; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignLessThanSign"

    // $ANTLR start "GreaterThanSignGreaterThanSign"
    public final void mGreaterThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodetemplatesLexer.g:37:32: ({...}? => '>>' )
            // CodetemplatesLexer.g:37:34: {...}? => '>>'
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
            // CodetemplatesLexer.g:39:12: ( '$' )
            // CodetemplatesLexer.g:39:14: '$'
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
            // CodetemplatesLexer.g:41:17: ({...}? => '(' )
            // CodetemplatesLexer.g:41:19: {...}? => '('
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
            // CodetemplatesLexer.g:43:18: ({...}? => ')' )
            // CodetemplatesLexer.g:43:20: {...}? => ')'
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
            // CodetemplatesLexer.g:45:7: ({...}? => ',' )
            // CodetemplatesLexer.g:45:9: {...}? => ','
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
            // CodetemplatesLexer.g:47:10: ({...}? => '.' )
            // CodetemplatesLexer.g:47:12: {...}? => '.'
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
            // CodetemplatesLexer.g:49:7: ({...}? => ':' )
            // CodetemplatesLexer.g:49:9: {...}? => ':'
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
            // CodetemplatesLexer.g:51:19: ({...}? => '}' )
            // CodetemplatesLexer.g:51:21: {...}? => '}'
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
            // CodetemplatesLexer.g:55:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // CodetemplatesLexer.g:55:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // CodetemplatesLexer.g:55:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // CodetemplatesLexer.g:55:11: '^'
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

            // CodetemplatesLexer.g:55:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // CodetemplatesLexer.g:
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
            // CodetemplatesLexer.g:57:13: ({...}? => ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // CodetemplatesLexer.g:57:15: {...}? => ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "RULE_STRING", "!literal || templateVariable");
            }
            // CodetemplatesLexer.g:57:48: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // CodetemplatesLexer.g:57:50: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // CodetemplatesLexer.g:57:55: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
            	    // CodetemplatesLexer.g:57:56: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // CodetemplatesLexer.g:57:97: ~ ( ( '\\\\' | '\\'' ) )
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
            // CodetemplatesLexer.g:59:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // CodetemplatesLexer.g:59:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // CodetemplatesLexer.g:59:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // CodetemplatesLexer.g:
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
            // CodetemplatesLexer.g:61:16: ( . )
            // CodetemplatesLexer.g:61:18: .
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
        // CodetemplatesLexer.g:1:8: ( Templates | ReverseSolidusLessThanSignLessThanSign | For | DollarSignDollarSign | DollarSignLeftCurlyBracket | LessThanSignLessThanSign | GreaterThanSignGreaterThanSign | DollarSign | LeftParenthesis | RightParenthesis | Comma | FullStop | Colon | RightCurlyBracket | RULE_ID | RULE_STRING | RULE_WS | RULE_ANY_OTHER )
        int alt5=18;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // CodetemplatesLexer.g:1:10: Templates
                {
                mTemplates(); 

                }
                break;
            case 2 :
                // CodetemplatesLexer.g:1:20: ReverseSolidusLessThanSignLessThanSign
                {
                mReverseSolidusLessThanSignLessThanSign(); 

                }
                break;
            case 3 :
                // CodetemplatesLexer.g:1:59: For
                {
                mFor(); 

                }
                break;
            case 4 :
                // CodetemplatesLexer.g:1:63: DollarSignDollarSign
                {
                mDollarSignDollarSign(); 

                }
                break;
            case 5 :
                // CodetemplatesLexer.g:1:84: DollarSignLeftCurlyBracket
                {
                mDollarSignLeftCurlyBracket(); 

                }
                break;
            case 6 :
                // CodetemplatesLexer.g:1:111: LessThanSignLessThanSign
                {
                mLessThanSignLessThanSign(); 

                }
                break;
            case 7 :
                // CodetemplatesLexer.g:1:136: GreaterThanSignGreaterThanSign
                {
                mGreaterThanSignGreaterThanSign(); 

                }
                break;
            case 8 :
                // CodetemplatesLexer.g:1:167: DollarSign
                {
                mDollarSign(); 

                }
                break;
            case 9 :
                // CodetemplatesLexer.g:1:178: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 10 :
                // CodetemplatesLexer.g:1:194: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 11 :
                // CodetemplatesLexer.g:1:211: Comma
                {
                mComma(); 

                }
                break;
            case 12 :
                // CodetemplatesLexer.g:1:217: FullStop
                {
                mFullStop(); 

                }
                break;
            case 13 :
                // CodetemplatesLexer.g:1:226: Colon
                {
                mColon(); 

                }
                break;
            case 14 :
                // CodetemplatesLexer.g:1:232: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 15 :
                // CodetemplatesLexer.g:1:250: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 16 :
                // CodetemplatesLexer.g:1:258: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 17 :
                // CodetemplatesLexer.g:1:270: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 18 :
                // CodetemplatesLexer.g:1:278: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\1\23\1\21\1\23\1\30\2\21\1\33\1\34\1\35\1\36\1\37\1\40\1\21\1\uffff\1\21\2\uffff\1\23\2\uffff\1\23\15\uffff\1\23\1\54\6\uffff\1\23\1\uffff\1\23\1\uffff\3\23\1\63\2\uffff";
    static final String DFA5_eofS =
        "\65\uffff";
    static final String DFA5_minS =
        "\1\0\1\145\1\74\1\157\1\44\1\74\1\76\6\0\1\101\1\uffff\1\0\2\uffff\1\155\2\uffff\1\162\5\uffff\6\0\2\uffff\1\160\1\60\6\uffff\1\154\1\0\1\141\1\uffff\1\164\1\145\1\163\1\60\1\0\1\uffff";
    static final String DFA5_maxS =
        "\1\uffff\1\145\1\74\1\157\1\173\1\74\1\76\6\0\1\172\1\uffff\1\uffff\2\uffff\1\155\2\uffff\1\162\5\uffff\6\0\2\uffff\1\160\1\172\6\uffff\1\154\1\0\1\141\1\uffff\1\164\1\145\1\163\1\172\1\0\1\uffff";
    static final String DFA5_acceptS =
        "\16\uffff\1\17\1\uffff\1\21\1\22\1\uffff\1\17\1\2\1\uffff\1\4\1\5\1\10\1\6\1\7\6\uffff\1\20\1\21\2\uffff\1\11\1\12\1\13\1\14\1\15\1\16\3\uffff\1\3\5\uffff\1\1";
    static final String DFA5_specialS =
        "\1\7\5\uffff\1\6\10\uffff\1\5\13\uffff\1\12\1\0\1\1\1\2\1\3\1\4\13\uffff\1\11\6\uffff\1\10\1\uffff}>";
    static final String[] DFA5_transitionS = {
            "\11\21\2\20\2\21\1\20\22\21\1\20\3\21\1\4\2\21\1\17\1\7\1\10\2\21\1\11\1\21\1\12\13\21\1\13\1\21\1\5\1\21\1\6\2\21\32\16\1\21\1\2\1\21\1\15\1\16\1\21\5\16\1\3\15\16\1\1\6\16\2\21\1\14\uff82\21",
            "\1\22",
            "\1\24",
            "\1\25",
            "\1\26\126\uffff\1\27",
            "\1\31",
            "\1\32",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "\0\41",
            "",
            "",
            "\1\43",
            "",
            "",
            "\1\44",
            "",
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
            "\1\53",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55",
            "\1\uffff",
            "\1\57",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
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
            return "1:1: Tokens : ( Templates | ReverseSolidusLessThanSignLessThanSign | For | DollarSignDollarSign | DollarSignLeftCurlyBracket | LessThanSignLessThanSign | GreaterThanSignGreaterThanSign | DollarSign | LeftParenthesis | RightParenthesis | Comma | FullStop | Colon | RightCurlyBracket | RULE_ID | RULE_STRING | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_28 = input.LA(1);

                         
                        int index5_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 38;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_28);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_29 = input.LA(1);

                         
                        int index5_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 39;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_29);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_30 = input.LA(1);

                         
                        int index5_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 40;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_30);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_31 = input.LA(1);

                         
                        int index5_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 41;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_31);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_32 = input.LA(1);

                         
                        int index5_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 42;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_32);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_15 = input.LA(1);

                         
                        int index5_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA5_15>='\u0000' && LA5_15<='\uFFFF')) && ((!literal || templateVariable))) {s = 33;}

                        else s = 17;

                         
                        input.seek(index5_15);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_6=='>') && ((!literal || templateVariable))) {s = 26;}

                        else s = 17;

                         
                        input.seek(index5_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA5_0 = input.LA(1);

                        s = -1;
                        if ( (LA5_0=='t') ) {s = 1;}

                        else if ( (LA5_0=='\\') ) {s = 2;}

                        else if ( (LA5_0=='f') ) {s = 3;}

                        else if ( (LA5_0=='$') ) {s = 4;}

                        else if ( (LA5_0=='<') ) {s = 5;}

                        else if ( (LA5_0=='>') ) {s = 6;}

                        else if ( (LA5_0=='(') ) {s = 7;}

                        else if ( (LA5_0==')') ) {s = 8;}

                        else if ( (LA5_0==',') ) {s = 9;}

                        else if ( (LA5_0=='.') ) {s = 10;}

                        else if ( (LA5_0==':') ) {s = 11;}

                        else if ( (LA5_0=='}') ) {s = 12;}

                        else if ( (LA5_0=='^') ) {s = 13;}

                        else if ( ((LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='e')||(LA5_0>='g' && LA5_0<='s')||(LA5_0>='u' && LA5_0<='z')) ) {s = 14;}

                        else if ( (LA5_0=='\'') ) {s = 15;}

                        else if ( ((LA5_0>='\t' && LA5_0<='\n')||LA5_0=='\r'||LA5_0==' ') ) {s = 16;}

                        else if ( ((LA5_0>='\u0000' && LA5_0<='\b')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\u001F')||(LA5_0>='!' && LA5_0<='#')||(LA5_0>='%' && LA5_0<='&')||(LA5_0>='*' && LA5_0<='+')||LA5_0=='-'||(LA5_0>='/' && LA5_0<='9')||LA5_0==';'||LA5_0=='='||(LA5_0>='?' && LA5_0<='@')||LA5_0=='['||LA5_0==']'||LA5_0=='`'||(LA5_0>='{' && LA5_0<='|')||(LA5_0>='~' && LA5_0<='\uFFFF')) ) {s = 17;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA5_51 = input.LA(1);

                         
                        int index5_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 52;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index5_51);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA5_44 = input.LA(1);

                         
                        int index5_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 46;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index5_44);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA5_27 = input.LA(1);

                         
                        int index5_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 37;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_27);
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