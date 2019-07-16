package org.eclipse.xtext.ui.tests.xmleditor;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CustomInternalXmlHighlightingLexer extends Lexer {
    public static final int RULE_ID=9;
    public static final int RULE_WS=11;
    public static final int RULE_TAG_CLOSE=6;
    public static final int RULE_PCDATA=12;
    public static final int RULE_STRING=10;
    public static final int RULE_TAG_START_OPEN=4;
    public static final int RULE_TAG_EMPTY_CLOSE=7;
    public static final int RULE_ATTR_EQ=8;
    public static final int RULE_TAG_END_OPEN=5;
    public static final int EOF=-1;

    	boolean tagMode = false;


    // delegates
    // delegators

    public CustomInternalXmlHighlightingLexer() {;} 
    public CustomInternalXmlHighlightingLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CustomInternalXmlHighlightingLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g"; }

    // $ANTLR start "RULE_TAG_START_OPEN"
    public final void mRULE_TAG_START_OPEN() throws RecognitionException {
        try {
            int _type = RULE_TAG_START_OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:15:21: ( '<' )
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:15:23: '<'
            {
            match('<'); 
             tagMode = true; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAG_START_OPEN"

    // $ANTLR start "RULE_TAG_END_OPEN"
    public final void mRULE_TAG_END_OPEN() throws RecognitionException {
        try {
            int _type = RULE_TAG_END_OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:17:19: ( '</' )
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:17:21: '</'
            {
            match("</"); 

             tagMode = true; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAG_END_OPEN"

    // $ANTLR start "RULE_TAG_CLOSE"
    public final void mRULE_TAG_CLOSE() throws RecognitionException {
        try {
            int _type = RULE_TAG_CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:19:16: ({...}? => '>' )
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:19:18: {...}? => '>'
            {
            if ( !(( tagMode )) ) {
                throw new FailedPredicateException(input, "RULE_TAG_CLOSE", " tagMode ");
            }
            match('>'); 
             tagMode = false; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAG_CLOSE"

    // $ANTLR start "RULE_TAG_EMPTY_CLOSE"
    public final void mRULE_TAG_EMPTY_CLOSE() throws RecognitionException {
        try {
            int _type = RULE_TAG_EMPTY_CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:21:22: ({...}? => '/>' )
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:21:24: {...}? => '/>'
            {
            if ( !(( tagMode )) ) {
                throw new FailedPredicateException(input, "RULE_TAG_EMPTY_CLOSE", " tagMode ");
            }
            match("/>"); 

             tagMode = false; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAG_EMPTY_CLOSE"

    // $ANTLR start "RULE_ATTR_EQ"
    public final void mRULE_ATTR_EQ() throws RecognitionException {
        try {
            int _type = RULE_ATTR_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:23:14: ({...}? => '=' )
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:23:16: {...}? => '='
            {
            if ( !(( tagMode )) ) {
                throw new FailedPredicateException(input, "RULE_ATTR_EQ", " tagMode ");
            }
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ATTR_EQ"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:25:9: ({...}? => ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:25:11: {...}? => ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( !(( tagMode )) ) {
                throw new FailedPredicateException(input, "RULE_ID", " tagMode ");
            }
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:25:27: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:25:27: '^'
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

            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:25:56: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:
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
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:13: ({...}? => ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:15: {...}? => ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            if ( !(( tagMode )) ) {
                throw new FailedPredicateException(input, "RULE_STRING", " tagMode ");
            }
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:31: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\"') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\'') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:32: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:36: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:37: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:44: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop3;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:64: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:69: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:70: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:27:77: ~ ( ( '\\\\' | '\\'' ) )
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:29:9: ({...}? => ( ' ' | '\\r' | '\\t' | '\\f' | '\\n' )+ )
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:29:11: {...}? => ( ' ' | '\\r' | '\\t' | '\\f' | '\\n' )+
            {
            if ( !(( tagMode )) ) {
                throw new FailedPredicateException(input, "RULE_WS", " tagMode ");
            }
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:29:27: ( ' ' | '\\r' | '\\t' | '\\f' | '\\n' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||(LA6_0>='\f' && LA6_0<='\r')||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_PCDATA"
    public final void mRULE_PCDATA() throws RecognitionException {
        try {
            int _type = RULE_PCDATA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:31:13: ({...}? => (~ ( '<' ) )+ )
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:31:15: {...}? => (~ ( '<' ) )+
            {
            if ( !(( !tagMode )) ) {
                throw new FailedPredicateException(input, "RULE_PCDATA", " !tagMode ");
            }
            // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:31:32: (~ ( '<' ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<=';')||(LA7_0>='=' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:31:32: ~ ( '<' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<=';')||(input.LA(1)>='=' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PCDATA"

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:1:8: ( RULE_TAG_START_OPEN | RULE_TAG_END_OPEN | RULE_TAG_CLOSE | RULE_TAG_EMPTY_CLOSE | RULE_ATTR_EQ | RULE_ID | RULE_STRING | RULE_WS | RULE_PCDATA )
        int alt8=9;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:1:10: RULE_TAG_START_OPEN
                {
                mRULE_TAG_START_OPEN(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:1:30: RULE_TAG_END_OPEN
                {
                mRULE_TAG_END_OPEN(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:1:48: RULE_TAG_CLOSE
                {
                mRULE_TAG_CLOSE(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:1:63: RULE_TAG_EMPTY_CLOSE
                {
                mRULE_TAG_EMPTY_CLOSE(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:1:84: RULE_ATTR_EQ
                {
                mRULE_ATTR_EQ(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:1:97: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:1:105: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:1:117: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.ui.tests/src/org/eclipse/xtext/ui/tests/xmleditor/CustomInternalXmlHighlightingLexer.g:1:125: RULE_PCDATA
                {
                mRULE_PCDATA(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\1\14\1\15\1\12\1\17\1\12\1\20\2\12\1\31\4\uffff\1\33\2"+
        "\uffff\1\20\2\12\1\37\1\uffff\2\12\1\37\5\uffff\1\12\1\uffff\1\12"+
        "\2\uffff";
    static final String DFA8_eofS =
        "\43\uffff";
    static final String DFA8_minS =
        "\1\0\1\57\1\0\1\76\1\0\1\101\4\0\3\uffff\10\0\1\uffff\4\0\1\uffff"+
        "\1\0\2\uffff\3\0\2\uffff";
    static final String DFA8_maxS =
        "\1\uffff\1\57\1\uffff\1\76\1\uffff\1\172\4\uffff\3\uffff\1\0\1"+
        "\uffff\2\0\4\uffff\1\uffff\3\uffff\1\0\1\uffff\1\0\2\uffff\1\uffff"+
        "\1\0\1\uffff\2\uffff";
    static final String DFA8_acceptS =
        "\12\uffff\1\11\1\2\1\1\10\uffff\1\7\4\uffff\1\3\1\uffff\1\5\1\6"+
        "\3\uffff\1\10\1\4";
    static final String DFA8_specialS =
        "\1\6\1\uffff\1\10\1\27\1\4\1\3\1\0\1\2\1\17\1\20\3\uffff\1\7\1"+
        "\24\1\12\1\13\1\25\1\14\1\22\1\1\1\uffff\1\23\1\30\1\5\1\16\1\uffff"+
        "\1\11\2\uffff\1\21\1\15\1\26\2\uffff}>";
    static final String[] DFA8_transitionS = {
            "\11\12\2\11\1\12\2\11\22\12\1\11\1\12\1\7\4\12\1\10\7\12\1"+
            "\3\14\12\1\1\1\4\1\2\2\12\32\6\3\12\1\5\1\6\1\12\32\6\uff85"+
            "\12",
            "\1\13",
            "\74\12\1\uffff\uffc3\12",
            "\1\16",
            "\74\12\1\uffff\uffc3\12",
            "\32\6\4\uffff\1\6\1\uffff\32\6",
            "\60\12\12\21\2\12\1\uffff\4\12\32\21\4\12\1\21\1\12\32\21"+
            "\uff85\12",
            "\42\23\1\24\31\23\1\25\37\23\1\22\uffa3\23",
            "\47\27\1\30\24\27\1\25\37\27\1\26\uffa3\27",
            "\11\12\2\11\1\12\2\11\22\12\1\11\33\12\1\uffff\uffc3\12",
            "",
            "",
            "",
            "\1\uffff",
            "\74\12\1\uffff\uffc3\12",
            "\1\uffff",
            "\1\uffff",
            "\60\12\12\21\2\12\1\uffff\4\12\32\21\4\12\1\21\1\12\32\21"+
            "\uff85\12",
            "\74\36\1\25\uffc3\36",
            "\42\23\1\24\31\23\1\25\37\23\1\22\uffa3\23",
            "\74\12\1\uffff\uffc3\12",
            "",
            "\74\40\1\25\uffc3\40",
            "\47\27\1\30\24\27\1\25\37\27\1\26\uffa3\27",
            "\74\12\1\uffff\uffc3\12",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "\42\23\1\24\31\23\1\25\37\23\1\22\uffa3\23",
            "\1\uffff",
            "\47\27\1\30\24\27\1\25\37\27\1\26\uffa3\27",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_TAG_START_OPEN | RULE_TAG_END_OPEN | RULE_TAG_CLOSE | RULE_TAG_EMPTY_CLOSE | RULE_ATTR_EQ | RULE_ID | RULE_STRING | RULE_WS | RULE_PCDATA );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_6 = input.LA(1);

                         
                        int index8_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_6>='0' && LA8_6<='9')||(LA8_6>='A' && LA8_6<='Z')||LA8_6=='_'||(LA8_6>='a' && LA8_6<='z')) && ((( tagMode )||( !tagMode )))) {s = 17;}

                        else if ( ((LA8_6>='\u0000' && LA8_6<='/')||(LA8_6>=':' && LA8_6<=';')||(LA8_6>='=' && LA8_6<='@')||(LA8_6>='[' && LA8_6<='^')||LA8_6=='`'||(LA8_6>='{' && LA8_6<='\uFFFF')) && (( !tagMode ))) {s = 10;}

                        else s = 16;

                         
                        input.seek(index8_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_20 = input.LA(1);

                         
                        int index8_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_20>='\u0000' && LA8_20<=';')||(LA8_20>='=' && LA8_20<='\uFFFF')) && (( !tagMode ))) {s = 10;}

                        else s = 31;

                         
                        input.seek(index8_20);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_7 = input.LA(1);

                         
                        int index8_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_7=='\\') && ((( tagMode )||( !tagMode )))) {s = 18;}

                        else if ( ((LA8_7>='\u0000' && LA8_7<='!')||(LA8_7>='#' && LA8_7<=';')||(LA8_7>='=' && LA8_7<='[')||(LA8_7>=']' && LA8_7<='\uFFFF')) && ((( tagMode )||( !tagMode )))) {s = 19;}

                        else if ( (LA8_7=='\"') && ((( tagMode )||( !tagMode )))) {s = 20;}

                        else if ( (LA8_7=='<') && (( tagMode ))) {s = 21;}

                        else s = 10;

                         
                        input.seek(index8_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA8_5 = input.LA(1);

                         
                        int index8_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_5>='A' && LA8_5<='Z')||LA8_5=='_'||(LA8_5>='a' && LA8_5<='z')) && ((( tagMode )||( !tagMode )))) {s = 6;}

                        else s = 10;

                         
                        input.seek(index8_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA8_4 = input.LA(1);

                         
                        int index8_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_4>='\u0000' && LA8_4<=';')||(LA8_4>='=' && LA8_4<='\uFFFF')) && (( !tagMode ))) {s = 10;}

                        else s = 15;

                         
                        input.seek(index8_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA8_24 = input.LA(1);

                         
                        int index8_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_24>='\u0000' && LA8_24<=';')||(LA8_24>='=' && LA8_24<='\uFFFF')) && (( !tagMode ))) {s = 10;}

                        else s = 31;

                         
                        input.seek(index8_24);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA8_0 = input.LA(1);

                         
                        int index8_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_0=='<') ) {s = 1;}

                        else if ( (LA8_0=='>') && ((( tagMode )||( !tagMode )))) {s = 2;}

                        else if ( (LA8_0=='/') && ((( tagMode )||( !tagMode )))) {s = 3;}

                        else if ( (LA8_0=='=') && ((( tagMode )||( !tagMode )))) {s = 4;}

                        else if ( (LA8_0=='^') && ((( tagMode )||( !tagMode )))) {s = 5;}

                        else if ( ((LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) && ((( tagMode )||( !tagMode )))) {s = 6;}

                        else if ( (LA8_0=='\"') && ((( tagMode )||( !tagMode )))) {s = 7;}

                        else if ( (LA8_0=='\'') && ((( tagMode )||( !tagMode )))) {s = 8;}

                        else if ( ((LA8_0>='\t' && LA8_0<='\n')||(LA8_0>='\f' && LA8_0<='\r')||LA8_0==' ') && ((( tagMode )||( !tagMode )))) {s = 9;}

                        else if ( ((LA8_0>='\u0000' && LA8_0<='\b')||LA8_0=='\u000B'||(LA8_0>='\u000E' && LA8_0<='\u001F')||LA8_0=='!'||(LA8_0>='#' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='.')||(LA8_0>='0' && LA8_0<=';')||(LA8_0>='?' && LA8_0<='@')||(LA8_0>='[' && LA8_0<=']')||LA8_0=='`'||(LA8_0>='{' && LA8_0<='\uFFFF')) && (( !tagMode ))) {s = 10;}

                         
                        input.seek(index8_0);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA8_13 = input.LA(1);

                         
                        int index8_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( tagMode )) ) {s = 26;}

                        else if ( (( !tagMode )) ) {s = 10;}

                         
                        input.seek(index8_13);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA8_2 = input.LA(1);

                         
                        int index8_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_2>='\u0000' && LA8_2<=';')||(LA8_2>='=' && LA8_2<='\uFFFF')) && (( !tagMode ))) {s = 10;}

                        else s = 13;

                         
                        input.seek(index8_2);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA8_27 = input.LA(1);

                         
                        int index8_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( tagMode )) ) {s = 34;}

                        else if ( (( !tagMode )) ) {s = 10;}

                         
                        input.seek(index8_27);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA8_15 = input.LA(1);

                         
                        int index8_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( tagMode )) ) {s = 28;}

                        else if ( (( !tagMode )) ) {s = 10;}

                         
                        input.seek(index8_15);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA8_16 = input.LA(1);

                         
                        int index8_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( tagMode )) ) {s = 29;}

                        else if ( (( !tagMode )) ) {s = 10;}

                         
                        input.seek(index8_16);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA8_18 = input.LA(1);

                         
                        int index8_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_18>='\u0000' && LA8_18<=';')||(LA8_18>='=' && LA8_18<='\uFFFF')) && ((( tagMode )||( !tagMode )))) {s = 30;}

                        else if ( (LA8_18=='<') && (( tagMode ))) {s = 21;}

                        else s = 10;

                         
                        input.seek(index8_18);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA8_31 = input.LA(1);

                         
                        int index8_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( tagMode )) ) {s = 21;}

                        else if ( (( !tagMode )) ) {s = 10;}

                         
                        input.seek(index8_31);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA8_25 = input.LA(1);

                         
                        int index8_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( tagMode )) ) {s = 33;}

                        else if ( (( !tagMode )) ) {s = 10;}

                         
                        input.seek(index8_25);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA8_8 = input.LA(1);

                         
                        int index8_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_8=='\\') && ((( tagMode )||( !tagMode )))) {s = 22;}

                        else if ( ((LA8_8>='\u0000' && LA8_8<='&')||(LA8_8>='(' && LA8_8<=';')||(LA8_8>='=' && LA8_8<='[')||(LA8_8>=']' && LA8_8<='\uFFFF')) && ((( tagMode )||( !tagMode )))) {s = 23;}

                        else if ( (LA8_8=='\'') && ((( tagMode )||( !tagMode )))) {s = 24;}

                        else if ( (LA8_8=='<') && (( tagMode ))) {s = 21;}

                        else s = 10;

                         
                        input.seek(index8_8);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA8_9 = input.LA(1);

                         
                        int index8_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_9>='\t' && LA8_9<='\n')||(LA8_9>='\f' && LA8_9<='\r')||LA8_9==' ') && ((( tagMode )||( !tagMode )))) {s = 9;}

                        else if ( ((LA8_9>='\u0000' && LA8_9<='\b')||LA8_9=='\u000B'||(LA8_9>='\u000E' && LA8_9<='\u001F')||(LA8_9>='!' && LA8_9<=';')||(LA8_9>='=' && LA8_9<='\uFFFF')) && (( !tagMode ))) {s = 10;}

                        else s = 25;

                         
                        input.seek(index8_9);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA8_30 = input.LA(1);

                         
                        int index8_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_30=='\"') && ((( tagMode )||( !tagMode )))) {s = 20;}

                        else if ( (LA8_30=='\\') && ((( tagMode )||( !tagMode )))) {s = 18;}

                        else if ( ((LA8_30>='\u0000' && LA8_30<='!')||(LA8_30>='#' && LA8_30<=';')||(LA8_30>='=' && LA8_30<='[')||(LA8_30>=']' && LA8_30<='\uFFFF')) && ((( tagMode )||( !tagMode )))) {s = 19;}

                        else if ( (LA8_30=='<') && (( tagMode ))) {s = 21;}

                        else s = 10;

                         
                        input.seek(index8_30);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA8_19 = input.LA(1);

                         
                        int index8_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_19=='\"') && ((( tagMode )||( !tagMode )))) {s = 20;}

                        else if ( (LA8_19=='\\') && ((( tagMode )||( !tagMode )))) {s = 18;}

                        else if ( ((LA8_19>='\u0000' && LA8_19<='!')||(LA8_19>='#' && LA8_19<=';')||(LA8_19>='=' && LA8_19<='[')||(LA8_19>=']' && LA8_19<='\uFFFF')) && ((( tagMode )||( !tagMode )))) {s = 19;}

                        else if ( (LA8_19=='<') && (( tagMode ))) {s = 21;}

                        else s = 10;

                         
                        input.seek(index8_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA8_22 = input.LA(1);

                         
                        int index8_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_22>='\u0000' && LA8_22<=';')||(LA8_22>='=' && LA8_22<='\uFFFF')) && ((( tagMode )||( !tagMode )))) {s = 32;}

                        else if ( (LA8_22=='<') && (( tagMode ))) {s = 21;}

                        else s = 10;

                         
                        input.seek(index8_22);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA8_14 = input.LA(1);

                         
                        int index8_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_14>='\u0000' && LA8_14<=';')||(LA8_14>='=' && LA8_14<='\uFFFF')) && (( !tagMode ))) {s = 10;}

                        else s = 27;

                         
                        input.seek(index8_14);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA8_17 = input.LA(1);

                         
                        int index8_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA8_17>='0' && LA8_17<='9')||(LA8_17>='A' && LA8_17<='Z')||LA8_17=='_'||(LA8_17>='a' && LA8_17<='z')) && ((( tagMode )||( !tagMode )))) {s = 17;}

                        else if ( ((LA8_17>='\u0000' && LA8_17<='/')||(LA8_17>=':' && LA8_17<=';')||(LA8_17>='=' && LA8_17<='@')||(LA8_17>='[' && LA8_17<='^')||LA8_17=='`'||(LA8_17>='{' && LA8_17<='\uFFFF')) && (( !tagMode ))) {s = 10;}

                        else s = 16;

                         
                        input.seek(index8_17);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA8_32 = input.LA(1);

                         
                        int index8_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_32=='\'') && ((( tagMode )||( !tagMode )))) {s = 24;}

                        else if ( (LA8_32=='\\') && ((( tagMode )||( !tagMode )))) {s = 22;}

                        else if ( ((LA8_32>='\u0000' && LA8_32<='&')||(LA8_32>='(' && LA8_32<=';')||(LA8_32>='=' && LA8_32<='[')||(LA8_32>=']' && LA8_32<='\uFFFF')) && ((( tagMode )||( !tagMode )))) {s = 23;}

                        else if ( (LA8_32=='<') && (( tagMode ))) {s = 21;}

                        else s = 10;

                         
                        input.seek(index8_32);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA8_3 = input.LA(1);

                         
                        int index8_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_3=='>') && ((( tagMode )||( !tagMode )))) {s = 14;}

                        else s = 10;

                         
                        input.seek(index8_3);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA8_23 = input.LA(1);

                         
                        int index8_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_23=='\'') && ((( tagMode )||( !tagMode )))) {s = 24;}

                        else if ( (LA8_23=='\\') && ((( tagMode )||( !tagMode )))) {s = 22;}

                        else if ( ((LA8_23>='\u0000' && LA8_23<='&')||(LA8_23>='(' && LA8_23<=';')||(LA8_23>='=' && LA8_23<='[')||(LA8_23>=']' && LA8_23<='\uFFFF')) && ((( tagMode )||( !tagMode )))) {s = 23;}

                        else if ( (LA8_23=='<') && (( tagMode ))) {s = 21;}

                        else s = 10;

                         
                        input.seek(index8_23);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}