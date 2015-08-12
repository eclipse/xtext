package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEcoreTerminalsTestLanguageLexer extends Lexer {
    public static final int RULE_EDATE=6;
    public static final int RULE_EDOUBLE=5;
    public static final int T__10=10;
    public static final int RULE_EINT=4;
    public static final int RULE_WS=7;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;

    // delegates
    // delegators

    public InternalEcoreTerminalsTestLanguageLexer() {;} 
    public InternalEcoreTerminalsTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalEcoreTerminalsTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:11:6: ( 'int' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:11:8: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:12:6: ( 'double' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:12:8: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:13:7: ( 'date' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:13:9: 'date'
            {
            match("date"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "RULE_EDOUBLE"
    public final void mRULE_EDOUBLE() throws RecognitionException {
        try {
            int _type = RULE_EDOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:14: ( ( '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )* ) ( ( 'E' | 'e' ) ( '-' | ( '+' )? ) ( '0' .. '9' )+ )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:16: ( '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )* ) ( ( 'E' | 'e' ) ( '-' | ( '+' )? ) ( '0' .. '9' )+ )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:16: ( '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )* )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.') ) {
                alt4=1;
            }
            else if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:17: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:21: ( '0' .. '9' )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:22: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:33: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:33: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:34: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    match('.'); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:49: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:50: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:62: ( ( 'E' | 'e' ) ( '-' | ( '+' )? ) ( '0' .. '9' )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='E'||LA8_0=='e') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:63: ( 'E' | 'e' ) ( '-' | ( '+' )? ) ( '0' .. '9' )+
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:73: ( '-' | ( '+' )? )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='-') ) {
                        alt6=1;
                    }
                    else if ( (LA6_0=='+'||(LA6_0>='0' && LA6_0<='9')) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:74: '-'
                            {
                            match('-'); 

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:78: ( '+' )?
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:78: ( '+' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0=='+') ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:78: '+'
                                    {
                                    match('+'); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:84: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:85: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EDOUBLE"

    // $ANTLR start "RULE_EDATE"
    public final void mRULE_EDATE() throws RecognitionException {
        try {
            int _type = RULE_EDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:157:12: ( '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' 'T' '0' .. '9' '0' .. '9' ':' '0' .. '9' '0' .. '9' ':' '0' .. '9' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' ( '+' | '-' ) '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:157:14: '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' 'T' '0' .. '9' '0' .. '9' ':' '0' .. '9' '0' .. '9' ':' '0' .. '9' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' ( '+' | '-' ) '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9'
            {
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('-'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('-'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('T'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match(':'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match(':'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('.'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EDATE"

    // $ANTLR start "RULE_EINT"
    public final void mRULE_EINT() throws RecognitionException {
        try {
            int _type = RULE_EINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:159:11: ( ( '-' )? ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:159:13: ( '-' )? ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:159:13: ( '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='-') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:159:13: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:159:18: ( '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:159:19: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EINT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:161:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:161:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:161:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:
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

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:8: ( T__8 | T__9 | T__10 | RULE_EDOUBLE | RULE_EDATE | RULE_EINT | RULE_WS )
        int alt12=7;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:10: T__8
                {
                mT__8(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:15: T__9
                {
                mT__9(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:20: T__10
                {
                mT__10(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:26: RULE_EDOUBLE
                {
                mRULE_EDOUBLE(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:39: RULE_EDATE
                {
                mRULE_EDATE(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:50: RULE_EINT
                {
                mRULE_EINT(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:60: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\4\uffff\1\5\4\uffff\3\5\1\uffff\1\5";
    static final String DFA12_eofS =
        "\16\uffff";
    static final String DFA12_minS =
        "\1\11\1\uffff\1\141\1\uffff\1\56\4\uffff\2\56\1\55\1\uffff\1\56";
    static final String DFA12_maxS =
        "\1\151\1\uffff\1\157\1\uffff\1\71\4\uffff\3\71\1\uffff\1\71";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\uffff\1\6\1\7\1\2\1\3\3\uffff\1\5\1\uffff";
    static final String DFA12_specialS =
        "\16\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\6\2\uffff\1\6\22\uffff\1\6\14\uffff\1\5\1\3\1\uffff\12\4\52\uffff\1\2\4\uffff\1\1",
            "",
            "\1\10\15\uffff\1\7",
            "",
            "\1\3\1\uffff\12\11",
            "",
            "",
            "",
            "",
            "\1\3\1\uffff\12\12",
            "\1\3\1\uffff\12\13",
            "\1\14\1\3\1\uffff\12\15",
            "",
            "\1\3\1\uffff\12\15"
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

    class DFA12 extends DFA {

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
            return "1:1: Tokens : ( T__8 | T__9 | T__10 | RULE_EDOUBLE | RULE_EDATE | RULE_EINT | RULE_WS );";
        }
    }
 

}