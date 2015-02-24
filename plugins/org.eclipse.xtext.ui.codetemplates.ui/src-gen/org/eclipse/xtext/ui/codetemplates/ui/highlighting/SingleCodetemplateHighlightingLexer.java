package org.eclipse.xtext.ui.codetemplates.ui.highlighting;

// Use our own Lexer superclass by means of import. 
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SingleCodetemplateHighlightingLexer extends Lexer {
    public static final int RULE_ID=11;
    public static final int RULE_STRING=12;
    public static final int RULE_BODY=10;
    public static final int KEYWORD_DOT=8;
    public static final int RULE_ANY_OTHER=9;
    public static final int KEYWORD_OPENBRACE=6;
    public static final int KEYWORD_FOR=5;
    public static final int RULE_WS=13;
    public static final int EOF=-1;
    public static final int KEYWORD_TEMPLATES=4;
    public static final int KEYWORD_CLOSINGBRACE=7;

    // delegates
    // delegators

    public SingleCodetemplateHighlightingLexer() {;} 
    public SingleCodetemplateHighlightingLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SingleCodetemplateHighlightingLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g"; }

    // $ANTLR start "KEYWORD_TEMPLATES"
    public final void mKEYWORD_TEMPLATES() throws RecognitionException {
        try {
            int _type = KEYWORD_TEMPLATES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:11:19: ( 'templates' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:11:21: 'templates'
            {
            match("templates"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_TEMPLATES"

    // $ANTLR start "KEYWORD_FOR"
    public final void mKEYWORD_FOR() throws RecognitionException {
        try {
            int _type = KEYWORD_FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:12:13: ( 'for' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:12:15: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_FOR"

    // $ANTLR start "KEYWORD_OPENBRACE"
    public final void mKEYWORD_OPENBRACE() throws RecognitionException {
        try {
            int _type = KEYWORD_OPENBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:15:19: ( '(' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:15:21: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_OPENBRACE"

    // $ANTLR start "KEYWORD_CLOSINGBRACE"
    public final void mKEYWORD_CLOSINGBRACE() throws RecognitionException {
        try {
            int _type = KEYWORD_CLOSINGBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:16:22: ( ')' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:16:24: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_CLOSINGBRACE"

    // $ANTLR start "KEYWORD_DOT"
    public final void mKEYWORD_DOT() throws RecognitionException {
        try {
            int _type = KEYWORD_DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:19:13: ( '.' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:19:15: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_DOT"

    // $ANTLR start "RULE_BODY"
    public final void mRULE_BODY() throws RecognitionException {
        try {
            int _type = RULE_BODY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:21:11: ( '>>' ( RULE_ANY_OTHER )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:21:13: '>>' ( RULE_ANY_OTHER )*
            {
            match(">>"); 

            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:21:19: ( RULE_ANY_OTHER )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:21:19: RULE_ANY_OTHER
            	    {
            	    mRULE_ANY_OTHER(); 

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
    // $ANTLR end "RULE_BODY"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:23:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:23:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:23:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:23:11: '^'
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

            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:23:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:
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

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:25:13: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:25:15: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:25:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:25:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:25:62: ~ ( ( '\\\\' | '\\'' ) )
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
            	    break loop4;
                }
            } while (true);

            match('\''); 

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
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:27:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:27:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:27:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\t' && LA5_0<='\n')||LA5_0=='\r'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:
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
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:29:16: ( . )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:29:18: .
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
        // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:8: ( KEYWORD_TEMPLATES | KEYWORD_FOR | KEYWORD_OPENBRACE | KEYWORD_CLOSINGBRACE | KEYWORD_DOT | RULE_BODY | RULE_ID | RULE_STRING | RULE_WS | RULE_ANY_OTHER )
        int alt6=10;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:10: KEYWORD_TEMPLATES
                {
                mKEYWORD_TEMPLATES(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:28: KEYWORD_FOR
                {
                mKEYWORD_FOR(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:40: KEYWORD_OPENBRACE
                {
                mKEYWORD_OPENBRACE(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:58: KEYWORD_CLOSINGBRACE
                {
                mKEYWORD_CLOSINGBRACE(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:79: KEYWORD_DOT
                {
                mKEYWORD_DOT(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:91: RULE_BODY
                {
                mRULE_BODY(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:101: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:109: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:121: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/highlighting/SingleCodetemplateHighlightingLexer.g:1:129: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\2\15\3\uffff\2\13\1\uffff\1\13\2\uffff\1\15\1\uffff\1\15"+
        "\6\uffff\1\15\1\30\1\15\1\uffff\4\15\1\36\1\uffff";
    static final String DFA6_eofS =
        "\37\uffff";
    static final String DFA6_minS =
        "\1\0\1\145\1\157\3\uffff\1\76\1\101\1\uffff\1\0\2\uffff\1\155\1"+
        "\uffff\1\162\6\uffff\1\160\1\60\1\154\1\uffff\1\141\1\164\1\145"+
        "\1\163\1\60\1\uffff";
    static final String DFA6_maxS =
        "\1\uffff\1\145\1\157\3\uffff\1\76\1\172\1\uffff\1\uffff\2\uffff"+
        "\1\155\1\uffff\1\162\6\uffff\1\160\1\172\1\154\1\uffff\1\141\1\164"+
        "\1\145\1\163\1\172\1\uffff";
    static final String DFA6_acceptS =
        "\3\uffff\1\3\1\4\1\5\2\uffff\1\7\1\uffff\1\11\1\12\1\uffff\1\7\1"+
        "\uffff\1\3\1\4\1\5\1\6\1\10\1\11\3\uffff\1\2\5\uffff\1\1";
    static final String DFA6_specialS =
        "\1\1\10\uffff\1\0\25\uffff}>";
    static final String[] DFA6_transitionS = {
            "\11\13\2\12\2\13\1\12\22\13\1\12\6\13\1\11\1\3\1\4\4\13\1\5"+
            "\17\13\1\6\2\13\32\10\3\13\1\7\1\10\1\13\5\10\1\2\15\10\1\1"+
            "\6\10\uff85\13",
            "\1\14",
            "\1\16",
            "",
            "",
            "",
            "\1\22",
            "\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "\0\23",
            "",
            "",
            "\1\25",
            "",
            "\1\26",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\27",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\31",
            "",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( KEYWORD_TEMPLATES | KEYWORD_FOR | KEYWORD_OPENBRACE | KEYWORD_CLOSINGBRACE | KEYWORD_DOT | RULE_BODY | RULE_ID | RULE_STRING | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_9 = input.LA(1);

                        s = -1;
                        if ( ((LA6_9>='\u0000' && LA6_9<='\uFFFF')) ) {s = 19;}

                        else s = 11;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_0 = input.LA(1);

                        s = -1;
                        if ( (LA6_0=='t') ) {s = 1;}

                        else if ( (LA6_0=='f') ) {s = 2;}

                        else if ( (LA6_0=='(') ) {s = 3;}

                        else if ( (LA6_0==')') ) {s = 4;}

                        else if ( (LA6_0=='.') ) {s = 5;}

                        else if ( (LA6_0=='>') ) {s = 6;}

                        else if ( (LA6_0=='^') ) {s = 7;}

                        else if ( ((LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='e')||(LA6_0>='g' && LA6_0<='s')||(LA6_0>='u' && LA6_0<='z')) ) {s = 8;}

                        else if ( (LA6_0=='\'') ) {s = 9;}

                        else if ( ((LA6_0>='\t' && LA6_0<='\n')||LA6_0=='\r'||LA6_0==' ') ) {s = 10;}

                        else if ( ((LA6_0>='\u0000' && LA6_0<='\b')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\u001F')||(LA6_0>='!' && LA6_0<='&')||(LA6_0>='*' && LA6_0<='-')||(LA6_0>='/' && LA6_0<='=')||(LA6_0>='?' && LA6_0<='@')||(LA6_0>='[' && LA6_0<=']')||LA6_0=='`'||(LA6_0>='{' && LA6_0<='\uFFFF')) ) {s = 11;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}