package org.eclipse.xtext.parsetree.unassignedtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUnassignedTextTestLanguageLexer extends Lexer {
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__19=19;
    public static final int RULE_MULTI2=10;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int RULE_PLURAL=6;
    public static final int EOF=-1;
    public static final int RULE_ID=9;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_MULTI=7;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int RULE_CASEINSENSITIVEKEYWORD=4;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalUnassignedTextTestLanguageLexer() {;} 
    public InternalUnassignedTextTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalUnassignedTextTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalUnassignedTextTestLanguage.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnassignedTextTestLanguage.g:11:7: ( 'contents:' )
            // InternalUnassignedTextTestLanguage.g:11:9: 'contents:'
            {
            match("contents:"); 


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
            // InternalUnassignedTextTestLanguage.g:12:7: ( 'multi' )
            // InternalUnassignedTextTestLanguage.g:12:9: 'multi'
            {
            match("multi"); 


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
            // InternalUnassignedTextTestLanguage.g:13:7: ( 'datatype' )
            // InternalUnassignedTextTestLanguage.g:13:9: 'datatype'
            {
            match("datatype"); 


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
            // InternalUnassignedTextTestLanguage.g:14:7: ( 'str' )
            // InternalUnassignedTextTestLanguage.g:14:9: 'str'
            {
            match("str"); 


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
            // InternalUnassignedTextTestLanguage.g:15:7: ( 'terminals' )
            // InternalUnassignedTextTestLanguage.g:15:9: 'terminals'
            {
            match("terminals"); 


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
            // InternalUnassignedTextTestLanguage.g:16:7: ( 'group' )
            // InternalUnassignedTextTestLanguage.g:16:9: 'group'
            {
            match("group"); 


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
            // InternalUnassignedTextTestLanguage.g:17:7: ( 'this' )
            // InternalUnassignedTextTestLanguage.g:17:9: 'this'
            {
            match("this"); 


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
            // InternalUnassignedTextTestLanguage.g:18:7: ( 'is' )
            // InternalUnassignedTextTestLanguage.g:18:9: 'is'
            {
            match("is"); 


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
            // InternalUnassignedTextTestLanguage.g:19:7: ( 'a' )
            // InternalUnassignedTextTestLanguage.g:19:9: 'a'
            {
            match('a'); 

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
            // InternalUnassignedTextTestLanguage.g:20:7: ( 'test' )
            // InternalUnassignedTextTestLanguage.g:20:9: 'test'
            {
            match("test"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "RULE_CASEINSENSITIVEKEYWORD"
    public final void mRULE_CASEINSENSITIVEKEYWORD() throws RecognitionException {
        try {
            int _type = RULE_CASEINSENSITIVEKEYWORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnassignedTextTestLanguage.g:523:29: ( ( 'k' | 'K' ) ( 'e' | 'E' ) ( 'y' | 'Y' ) ( 'w' | 'W' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'd' | 'D' ) )
            // InternalUnassignedTextTestLanguage.g:523:31: ( 'k' | 'K' ) ( 'e' | 'E' ) ( 'y' | 'Y' ) ( 'w' | 'W' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
    // $ANTLR end "RULE_CASEINSENSITIVEKEYWORD"

    // $ANTLR start "RULE_PLURAL"
    public final void mRULE_PLURAL() throws RecognitionException {
        try {
            int _type = RULE_PLURAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnassignedTextTestLanguage.g:525:13: ( ( 'item' | 'items' ) )
            // InternalUnassignedTextTestLanguage.g:525:15: ( 'item' | 'items' )
            {
            // InternalUnassignedTextTestLanguage.g:525:15: ( 'item' | 'items' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='i') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='t') ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2=='e') ) {
                        int LA1_3 = input.LA(4);

                        if ( (LA1_3=='m') ) {
                            int LA1_4 = input.LA(5);

                            if ( (LA1_4=='s') ) {
                                alt1=2;
                            }
                            else {
                                alt1=1;}
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalUnassignedTextTestLanguage.g:525:16: 'item'
                    {
                    match("item"); 


                    }
                    break;
                case 2 :
                    // InternalUnassignedTextTestLanguage.g:525:23: 'items'
                    {
                    match("items"); 


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
    // $ANTLR end "RULE_PLURAL"

    // $ANTLR start "RULE_MULTI"
    public final void mRULE_MULTI() throws RecognitionException {
        try {
            int _type = RULE_MULTI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnassignedTextTestLanguage.g:527:12: ( 'a' ( 'b' )? ( 'c' )+ ( 'd' )* ( 'e' | 'f' ) ( ( 'g' | 'h' ) | ( 'i' )+ ) RULE_MULTI2 '0' .. '9' ( '0' .. '9' )+ )
            // InternalUnassignedTextTestLanguage.g:527:14: 'a' ( 'b' )? ( 'c' )+ ( 'd' )* ( 'e' | 'f' ) ( ( 'g' | 'h' ) | ( 'i' )+ ) RULE_MULTI2 '0' .. '9' ( '0' .. '9' )+
            {
            match('a'); 
            // InternalUnassignedTextTestLanguage.g:527:18: ( 'b' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='b') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalUnassignedTextTestLanguage.g:527:18: 'b'
                    {
                    match('b'); 

                    }
                    break;

            }

            // InternalUnassignedTextTestLanguage.g:527:23: ( 'c' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='c') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalUnassignedTextTestLanguage.g:527:23: 'c'
            	    {
            	    match('c'); 

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

            // InternalUnassignedTextTestLanguage.g:527:28: ( 'd' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='d') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalUnassignedTextTestLanguage.g:527:28: 'd'
            	    {
            	    match('d'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            if ( (input.LA(1)>='e' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalUnassignedTextTestLanguage.g:527:43: ( ( 'g' | 'h' ) | ( 'i' )+ )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>='g' && LA6_0<='h')) ) {
                alt6=1;
            }
            else if ( (LA6_0=='i') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalUnassignedTextTestLanguage.g:527:44: ( 'g' | 'h' )
                    {
                    if ( (input.LA(1)>='g' && input.LA(1)<='h') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // InternalUnassignedTextTestLanguage.g:527:54: ( 'i' )+
                    {
                    // InternalUnassignedTextTestLanguage.g:527:54: ( 'i' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='i') ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalUnassignedTextTestLanguage.g:527:54: 'i'
                    	    {
                    	    match('i'); 

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
                    break;

            }

            mRULE_MULTI2(); 
            matchRange('0','9'); 
            // InternalUnassignedTextTestLanguage.g:527:81: ( '0' .. '9' )+
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
            	    // InternalUnassignedTextTestLanguage.g:527:82: '0' .. '9'
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MULTI"

    // $ANTLR start "RULE_MULTI2"
    public final void mRULE_MULTI2() throws RecognitionException {
        try {
            // InternalUnassignedTextTestLanguage.g:529:22: ( 'j' )
            // InternalUnassignedTextTestLanguage.g:529:24: 'j'
            {
            match('j'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_MULTI2"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnassignedTextTestLanguage.g:531:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalUnassignedTextTestLanguage.g:531:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalUnassignedTextTestLanguage.g:531:11: ( '^' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='^') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalUnassignedTextTestLanguage.g:531:11: '^'
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

            // InternalUnassignedTextTestLanguage.g:531:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalUnassignedTextTestLanguage.g:
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
            	    break loop9;
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
            // InternalUnassignedTextTestLanguage.g:533:10: ( ( '0' .. '9' )+ )
            // InternalUnassignedTextTestLanguage.g:533:12: ( '0' .. '9' )+
            {
            // InternalUnassignedTextTestLanguage.g:533:12: ( '0' .. '9' )+
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
            	    // InternalUnassignedTextTestLanguage.g:533:13: '0' .. '9'
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
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnassignedTextTestLanguage.g:535:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalUnassignedTextTestLanguage.g:535:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalUnassignedTextTestLanguage.g:535:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\"') ) {
                alt13=1;
            }
            else if ( (LA13_0=='\'') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalUnassignedTextTestLanguage.g:535:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalUnassignedTextTestLanguage.g:535:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop11:
                    do {
                        int alt11=3;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='\\') ) {
                            alt11=1;
                        }
                        else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                            alt11=2;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalUnassignedTextTestLanguage.g:535:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalUnassignedTextTestLanguage.g:535:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop11;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalUnassignedTextTestLanguage.g:535:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalUnassignedTextTestLanguage.g:535:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\\') ) {
                            alt12=1;
                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalUnassignedTextTestLanguage.g:535:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalUnassignedTextTestLanguage.g:535:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop12;
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
            // InternalUnassignedTextTestLanguage.g:537:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalUnassignedTextTestLanguage.g:537:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalUnassignedTextTestLanguage.g:537:24: ( options {greedy=false; } : . )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='*') ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1=='/') ) {
                        alt14=2;
                    }
                    else if ( ((LA14_1>='\u0000' && LA14_1<='.')||(LA14_1>='0' && LA14_1<='\uFFFF')) ) {
                        alt14=1;
                    }


                }
                else if ( ((LA14_0>='\u0000' && LA14_0<=')')||(LA14_0>='+' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalUnassignedTextTestLanguage.g:537:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop14;
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
            // InternalUnassignedTextTestLanguage.g:539:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalUnassignedTextTestLanguage.g:539:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalUnassignedTextTestLanguage.g:539:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalUnassignedTextTestLanguage.g:539:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop15;
                }
            } while (true);

            // InternalUnassignedTextTestLanguage.g:539:40: ( ( '\\r' )? '\\n' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\n'||LA17_0=='\r') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalUnassignedTextTestLanguage.g:539:41: ( '\\r' )? '\\n'
                    {
                    // InternalUnassignedTextTestLanguage.g:539:41: ( '\\r' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='\r') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalUnassignedTextTestLanguage.g:539:41: '\\r'
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
            // InternalUnassignedTextTestLanguage.g:541:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalUnassignedTextTestLanguage.g:541:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalUnassignedTextTestLanguage.g:541:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalUnassignedTextTestLanguage.g:
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
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
            // InternalUnassignedTextTestLanguage.g:543:16: ( . )
            // InternalUnassignedTextTestLanguage.g:543:18: .
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
        // InternalUnassignedTextTestLanguage.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | RULE_CASEINSENSITIVEKEYWORD | RULE_PLURAL | RULE_MULTI | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt19=20;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // InternalUnassignedTextTestLanguage.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // InternalUnassignedTextTestLanguage.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // InternalUnassignedTextTestLanguage.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // InternalUnassignedTextTestLanguage.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // InternalUnassignedTextTestLanguage.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // InternalUnassignedTextTestLanguage.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // InternalUnassignedTextTestLanguage.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // InternalUnassignedTextTestLanguage.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // InternalUnassignedTextTestLanguage.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // InternalUnassignedTextTestLanguage.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // InternalUnassignedTextTestLanguage.g:1:70: RULE_CASEINSENSITIVEKEYWORD
                {
                mRULE_CASEINSENSITIVEKEYWORD(); 

                }
                break;
            case 12 :
                // InternalUnassignedTextTestLanguage.g:1:98: RULE_PLURAL
                {
                mRULE_PLURAL(); 

                }
                break;
            case 13 :
                // InternalUnassignedTextTestLanguage.g:1:110: RULE_MULTI
                {
                mRULE_MULTI(); 

                }
                break;
            case 14 :
                // InternalUnassignedTextTestLanguage.g:1:121: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 15 :
                // InternalUnassignedTextTestLanguage.g:1:129: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 16 :
                // InternalUnassignedTextTestLanguage.g:1:138: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 17 :
                // InternalUnassignedTextTestLanguage.g:1:150: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 18 :
                // InternalUnassignedTextTestLanguage.g:1:166: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 19 :
                // InternalUnassignedTextTestLanguage.g:1:182: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 20 :
                // InternalUnassignedTextTestLanguage.g:1:190: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\1\uffff\7\23\1\35\1\23\1\21\2\uffff\3\21\2\uffff\1\23\1\uffff\6\23\1\55\2\23\1\uffff\2\23\5\uffff\3\23\1\65\4\23\1\uffff\7\23\1\uffff\1\23\1\102\1\103\1\23\1\106\4\23\1\112\2\23\2\uffff\1\115\1\106\1\uffff\3\23\1\uffff\2\23\1\uffff\5\23\1\130\1\131\1\23\1\133\1\23\4\uffff\1\135\1\uffff";
    static final String DFA19_eofS =
        "\136\uffff";
    static final String DFA19_minS =
        "\1\0\1\157\1\165\1\141\1\164\1\145\1\162\1\163\1\60\1\105\1\101\2\uffff\2\0\1\52\2\uffff\1\156\1\uffff\1\154\1\164\2\162\1\151\1\157\1\60\1\145\1\143\1\uffff\1\143\1\131\5\uffff\2\164\1\141\1\60\1\155\1\164\1\163\1\165\1\uffff\1\155\1\144\1\147\1\127\1\145\1\151\1\164\1\uffff\1\151\2\60\1\160\1\60\1\152\1\151\1\117\1\156\1\60\1\171\1\156\2\uffff\2\60\1\uffff\1\60\1\122\1\164\1\uffff\1\160\1\141\1\uffff\1\60\1\104\1\163\1\145\1\154\2\60\1\72\1\60\1\163\4\uffff\1\60\1\uffff";
    static final String DFA19_maxS =
        "\1\uffff\1\157\1\165\1\141\1\164\1\150\1\162\1\164\1\172\1\145\1\172\2\uffff\2\uffff\1\57\2\uffff\1\156\1\uffff\1\154\1\164\1\162\1\163\1\151\1\157\1\172\1\145\1\143\1\uffff\1\146\1\171\5\uffff\2\164\1\141\1\172\1\155\1\164\1\163\1\165\1\uffff\1\155\1\146\1\151\1\167\1\145\1\151\1\164\1\uffff\1\151\2\172\1\160\1\172\2\152\1\157\1\156\1\172\1\171\1\156\2\uffff\2\172\1\uffff\1\71\1\162\1\164\1\uffff\1\160\1\141\1\uffff\1\71\1\144\1\163\1\145\1\154\2\172\1\72\1\172\1\163\4\uffff\1\172\1\uffff";
    static final String DFA19_acceptS =
        "\13\uffff\1\16\1\17\3\uffff\1\23\1\24\1\uffff\1\16\11\uffff\1\11\2\uffff\1\17\1\20\1\21\1\22\1\23\10\uffff\1\10\7\uffff\1\4\14\uffff\1\12\1\7\2\uffff\1\14\3\uffff\1\2\2\uffff\1\6\12\uffff\1\15\1\13\1\1\1\3\1\uffff\1\5";
    static final String DFA19_specialS =
        "\1\0\14\uffff\1\1\1\2\117\uffff}>";
    static final String[] DFA19_transitionS = DFA19_transitionS_.DFA19_transitionS;
    private static final class DFA19_transitionS_ {
        static final String[] DFA19_transitionS = {
                "\11\21\2\20\2\21\1\20\22\21\1\20\1\21\1\15\4\21\1\16\7\21\1\17\12\14\7\21\12\13\1\11\17\13\3\21\1\12\1\13\1\21\1\10\1\13\1\1\1\3\2\13\1\6\1\13\1\7\1\13\1\11\1\13\1\2\5\13\1\4\1\5\6\13\uff85\21",
                "\1\22",
                "\1\24",
                "\1\25",
                "\1\26",
                "\1\27\2\uffff\1\30",
                "\1\31",
                "\1\32\1\33",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\1\23\1\34\1\36\27\23",
                "\1\37\37\uffff\1\37",
                "\32\23\4\uffff\1\23\1\uffff\32\23",
                "",
                "",
                "\0\41",
                "\0\41",
                "\1\42\4\uffff\1\43",
                "",
                "",
                "\1\45",
                "",
                "\1\46",
                "\1\47",
                "\1\50",
                "\1\51\1\52",
                "\1\53",
                "\1\54",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                "\1\56",
                "\1\36",
                "",
                "\1\36\1\57\2\60",
                "\1\61\37\uffff\1\61",
                "",
                "",
                "",
                "",
                "",
                "\1\62",
                "\1\63",
                "\1\64",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                "\1\66",
                "\1\67",
                "\1\70",
                "\1\71",
                "",
                "\1\72",
                "\1\57\2\60",
                "\2\73\1\74",
                "\1\75\37\uffff\1\75",
                "\1\76",
                "\1\77",
                "\1\100",
                "",
                "\1\101",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                "\1\104",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\22\23\1\105\7\23",
                "\1\107",
                "\1\74\1\107",
                "\1\110\37\uffff\1\110",
                "\1\111",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                "\1\113",
                "\1\114",
                "",
                "",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                "",
                "\12\116",
                "\1\117\37\uffff\1\117",
                "\1\120",
                "",
                "\1\121",
                "\1\122",
                "",
                "\12\123",
                "\1\124\37\uffff\1\124",
                "\1\125",
                "\1\126",
                "\1\127",
                "\12\123\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                "\1\132",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                "\1\134",
                "",
                "",
                "",
                "",
                "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
                ""
        };
    }

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    static class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | RULE_CASEINSENSITIVEKEYWORD | RULE_PLURAL | RULE_MULTI | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_0 = input.LA(1);

                        s = -1;
                        if ( (LA19_0=='c') ) {s = 1;}

                        else if ( (LA19_0=='m') ) {s = 2;}

                        else if ( (LA19_0=='d') ) {s = 3;}

                        else if ( (LA19_0=='s') ) {s = 4;}

                        else if ( (LA19_0=='t') ) {s = 5;}

                        else if ( (LA19_0=='g') ) {s = 6;}

                        else if ( (LA19_0=='i') ) {s = 7;}

                        else if ( (LA19_0=='a') ) {s = 8;}

                        else if ( (LA19_0=='K'||LA19_0=='k') ) {s = 9;}

                        else if ( (LA19_0=='^') ) {s = 10;}

                        else if ( ((LA19_0>='A' && LA19_0<='J')||(LA19_0>='L' && LA19_0<='Z')||LA19_0=='_'||LA19_0=='b'||(LA19_0>='e' && LA19_0<='f')||LA19_0=='h'||LA19_0=='j'||LA19_0=='l'||(LA19_0>='n' && LA19_0<='r')||(LA19_0>='u' && LA19_0<='z')) ) {s = 11;}

                        else if ( ((LA19_0>='0' && LA19_0<='9')) ) {s = 12;}

                        else if ( (LA19_0=='\"') ) {s = 13;}

                        else if ( (LA19_0=='\'') ) {s = 14;}

                        else if ( (LA19_0=='/') ) {s = 15;}

                        else if ( ((LA19_0>='\t' && LA19_0<='\n')||LA19_0=='\r'||LA19_0==' ') ) {s = 16;}

                        else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||LA19_0=='!'||(LA19_0>='#' && LA19_0<='&')||(LA19_0>='(' && LA19_0<='.')||(LA19_0>=':' && LA19_0<='@')||(LA19_0>='[' && LA19_0<=']')||LA19_0=='`'||(LA19_0>='{' && LA19_0<='\uFFFF')) ) {s = 17;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_13 = input.LA(1);

                        s = -1;
                        if ( ((LA19_13>='\u0000' && LA19_13<='\uFFFF')) ) {s = 33;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_14 = input.LA(1);

                        s = -1;
                        if ( ((LA19_14>='\u0000' && LA19_14<='\uFFFF')) ) {s = 33;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}