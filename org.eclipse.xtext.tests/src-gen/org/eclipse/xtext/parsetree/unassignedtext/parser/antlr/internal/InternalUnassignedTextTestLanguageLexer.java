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
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_CASEINSENSITIVEKEYWORD=4;

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

    // $ANTLR start "RULE_CASEINSENSITIVEKEYWORD"
    public final void mRULE_CASEINSENSITIVEKEYWORD() throws RecognitionException {
        try {
            int _type = RULE_CASEINSENSITIVEKEYWORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUnassignedTextTestLanguage.g:462:29: ( ( 'k' | 'K' ) ( 'e' | 'E' ) ( 'y' | 'Y' ) ( 'w' | 'W' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'd' | 'D' ) )
            // InternalUnassignedTextTestLanguage.g:462:31: ( 'k' | 'K' ) ( 'e' | 'E' ) ( 'y' | 'Y' ) ( 'w' | 'W' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'd' | 'D' )
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
            // InternalUnassignedTextTestLanguage.g:464:13: ( ( 'item' | 'items' ) )
            // InternalUnassignedTextTestLanguage.g:464:15: ( 'item' | 'items' )
            {
            // InternalUnassignedTextTestLanguage.g:464:15: ( 'item' | 'items' )
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
                    // InternalUnassignedTextTestLanguage.g:464:16: 'item'
                    {
                    match("item"); 


                    }
                    break;
                case 2 :
                    // InternalUnassignedTextTestLanguage.g:464:23: 'items'
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
            // InternalUnassignedTextTestLanguage.g:466:12: ( 'a' ( 'b' )? ( 'c' )+ ( 'd' )* ( 'e' | 'f' ) ( ( 'g' | 'h' ) | ( 'i' )+ ) RULE_MULTI2 '0' .. '9' ( '0' .. '9' )+ )
            // InternalUnassignedTextTestLanguage.g:466:14: 'a' ( 'b' )? ( 'c' )+ ( 'd' )* ( 'e' | 'f' ) ( ( 'g' | 'h' ) | ( 'i' )+ ) RULE_MULTI2 '0' .. '9' ( '0' .. '9' )+
            {
            match('a'); 
            // InternalUnassignedTextTestLanguage.g:466:18: ( 'b' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='b') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalUnassignedTextTestLanguage.g:466:18: 'b'
                    {
                    match('b'); 

                    }
                    break;

            }

            // InternalUnassignedTextTestLanguage.g:466:23: ( 'c' )+
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
            	    // InternalUnassignedTextTestLanguage.g:466:23: 'c'
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

            // InternalUnassignedTextTestLanguage.g:466:28: ( 'd' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='d') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalUnassignedTextTestLanguage.g:466:28: 'd'
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

            // InternalUnassignedTextTestLanguage.g:466:43: ( ( 'g' | 'h' ) | ( 'i' )+ )
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
                    // InternalUnassignedTextTestLanguage.g:466:44: ( 'g' | 'h' )
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
                    // InternalUnassignedTextTestLanguage.g:466:54: ( 'i' )+
                    {
                    // InternalUnassignedTextTestLanguage.g:466:54: ( 'i' )+
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
                    	    // InternalUnassignedTextTestLanguage.g:466:54: 'i'
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
            // InternalUnassignedTextTestLanguage.g:466:81: ( '0' .. '9' )+
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
            	    // InternalUnassignedTextTestLanguage.g:466:82: '0' .. '9'
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
            // InternalUnassignedTextTestLanguage.g:468:22: ( 'j' )
            // InternalUnassignedTextTestLanguage.g:468:24: 'j'
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
            // InternalUnassignedTextTestLanguage.g:470:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalUnassignedTextTestLanguage.g:470:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalUnassignedTextTestLanguage.g:470:11: ( '^' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='^') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalUnassignedTextTestLanguage.g:470:11: '^'
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

            // InternalUnassignedTextTestLanguage.g:470:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // InternalUnassignedTextTestLanguage.g:472:10: ( ( '0' .. '9' )+ )
            // InternalUnassignedTextTestLanguage.g:472:12: ( '0' .. '9' )+
            {
            // InternalUnassignedTextTestLanguage.g:472:12: ( '0' .. '9' )+
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
            	    // InternalUnassignedTextTestLanguage.g:472:13: '0' .. '9'
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
            // InternalUnassignedTextTestLanguage.g:474:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalUnassignedTextTestLanguage.g:474:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalUnassignedTextTestLanguage.g:474:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalUnassignedTextTestLanguage.g:474:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalUnassignedTextTestLanguage.g:474:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalUnassignedTextTestLanguage.g:474:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalUnassignedTextTestLanguage.g:474:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalUnassignedTextTestLanguage.g:474:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalUnassignedTextTestLanguage.g:474:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalUnassignedTextTestLanguage.g:474:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalUnassignedTextTestLanguage.g:474:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalUnassignedTextTestLanguage.g:476:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalUnassignedTextTestLanguage.g:476:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalUnassignedTextTestLanguage.g:476:24: ( options {greedy=false; } : . )*
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
            	    // InternalUnassignedTextTestLanguage.g:476:52: .
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
            // InternalUnassignedTextTestLanguage.g:478:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalUnassignedTextTestLanguage.g:478:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalUnassignedTextTestLanguage.g:478:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalUnassignedTextTestLanguage.g:478:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalUnassignedTextTestLanguage.g:478:40: ( ( '\\r' )? '\\n' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\n'||LA17_0=='\r') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalUnassignedTextTestLanguage.g:478:41: ( '\\r' )? '\\n'
                    {
                    // InternalUnassignedTextTestLanguage.g:478:41: ( '\\r' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='\r') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalUnassignedTextTestLanguage.g:478:41: '\\r'
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
            // InternalUnassignedTextTestLanguage.g:480:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalUnassignedTextTestLanguage.g:480:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalUnassignedTextTestLanguage.g:480:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // InternalUnassignedTextTestLanguage.g:482:16: ( . )
            // InternalUnassignedTextTestLanguage.g:482:18: .
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
        // InternalUnassignedTextTestLanguage.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | RULE_CASEINSENSITIVEKEYWORD | RULE_PLURAL | RULE_MULTI | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt19=15;
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
                // InternalUnassignedTextTestLanguage.g:1:40: RULE_CASEINSENSITIVEKEYWORD
                {
                mRULE_CASEINSENSITIVEKEYWORD(); 

                }
                break;
            case 7 :
                // InternalUnassignedTextTestLanguage.g:1:68: RULE_PLURAL
                {
                mRULE_PLURAL(); 

                }
                break;
            case 8 :
                // InternalUnassignedTextTestLanguage.g:1:80: RULE_MULTI
                {
                mRULE_MULTI(); 

                }
                break;
            case 9 :
                // InternalUnassignedTextTestLanguage.g:1:91: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 10 :
                // InternalUnassignedTextTestLanguage.g:1:99: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 11 :
                // InternalUnassignedTextTestLanguage.g:1:108: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 12 :
                // InternalUnassignedTextTestLanguage.g:1:120: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 13 :
                // InternalUnassignedTextTestLanguage.g:1:136: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 14 :
                // InternalUnassignedTextTestLanguage.g:1:152: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 15 :
                // InternalUnassignedTextTestLanguage.g:1:160: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\1\uffff\10\22\1\20\2\uffff\3\20\2\uffff\1\22\1\uffff\10\22\5\uffff\3\22\1\54\10\22\1\uffff\2\22\1\70\3\22\1\73\3\22\1\70\1\uffff\2\22\1\uffff\7\22\1\110\1\111\1\22\1\113\1\22\4\uffff\1\115\1\uffff";
    static final String DFA19_eofS =
        "\116\uffff";
    static final String DFA19_minS =
        "\1\0\1\157\1\165\1\141\1\164\1\145\1\105\1\164\1\142\1\101\2\uffff\2\0\1\52\2\uffff\1\156\1\uffff\1\154\1\164\2\162\1\131\1\145\2\143\5\uffff\2\164\1\141\1\60\1\155\1\127\1\155\1\144\1\147\1\145\1\151\1\164\1\uffff\1\151\1\117\1\60\1\152\1\151\1\156\1\60\1\171\1\156\1\122\1\60\1\uffff\1\60\1\164\1\uffff\1\160\1\141\1\104\1\60\1\163\1\145\1\154\2\60\1\72\1\60\1\163\4\uffff\1\60\1\uffff";
    static final String DFA19_maxS =
        "\1\uffff\1\157\1\165\1\141\1\164\2\145\1\164\1\143\1\172\2\uffff\2\uffff\1\57\2\uffff\1\156\1\uffff\1\154\1\164\2\162\1\171\1\145\1\143\1\146\5\uffff\2\164\1\141\1\172\1\155\1\167\1\155\1\146\1\151\1\145\1\151\1\164\1\uffff\1\151\1\157\1\172\2\152\1\156\1\172\1\171\1\156\1\162\1\172\1\uffff\1\71\1\164\1\uffff\1\160\1\141\1\144\1\71\1\163\1\145\1\154\2\172\1\72\1\172\1\163\4\uffff\1\172\1\uffff";
    static final String DFA19_acceptS =
        "\12\uffff\1\11\1\12\3\uffff\1\16\1\17\1\uffff\1\11\10\uffff\1\12\1\13\1\14\1\15\1\16\14\uffff\1\4\13\uffff\1\7\2\uffff\1\2\14\uffff\1\6\1\10\1\1\1\3\1\uffff\1\5";
    static final String DFA19_specialS =
        "\1\1\13\uffff\1\0\1\2\100\uffff}>";
    static final String[] DFA19_transitionS = {
            "\11\20\2\17\2\20\1\17\22\20\1\17\1\20\1\14\4\20\1\15\7\20\1\16\12\13\7\20\12\12\1\6\17\12\3\20\1\11\1\12\1\20\1\10\1\12\1\1\1\3\4\12\1\7\1\12\1\6\1\12\1\2\5\12\1\4\1\5\6\12\uff85\20",
            "\1\21",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27\37\uffff\1\27",
            "\1\30",
            "\1\31\1\32",
            "\32\22\4\uffff\1\22\1\uffff\32\22",
            "",
            "",
            "\0\34",
            "\0\34",
            "\1\35\4\uffff\1\36",
            "",
            "",
            "\1\40",
            "",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45\37\uffff\1\45",
            "\1\46",
            "\1\32",
            "\1\32\1\47\2\50",
            "",
            "",
            "",
            "",
            "",
            "\1\51",
            "\1\52",
            "\1\53",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "\1\55",
            "\1\56\37\uffff\1\56",
            "\1\57",
            "\1\47\2\50",
            "\2\60\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "\1\65",
            "\1\66\37\uffff\1\66",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\22\22\1\67\7\22",
            "\1\71",
            "\1\61\1\71",
            "\1\72",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "\1\74",
            "\1\75",
            "\1\76\37\uffff\1\76",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "",
            "\12\77",
            "\1\100",
            "",
            "\1\101",
            "\1\102",
            "\1\103\37\uffff\1\103",
            "\12\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "\12\104\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "\1\112",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "\1\114",
            "",
            "",
            "",
            "",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            ""
    };

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
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | RULE_CASEINSENSITIVEKEYWORD | RULE_PLURAL | RULE_MULTI | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_12 = input.LA(1);

                        s = -1;
                        if ( ((LA19_12>='\u0000' && LA19_12<='\uFFFF')) ) {s = 28;}

                        else s = 16;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_0 = input.LA(1);

                        s = -1;
                        if ( (LA19_0=='c') ) {s = 1;}

                        else if ( (LA19_0=='m') ) {s = 2;}

                        else if ( (LA19_0=='d') ) {s = 3;}

                        else if ( (LA19_0=='s') ) {s = 4;}

                        else if ( (LA19_0=='t') ) {s = 5;}

                        else if ( (LA19_0=='K'||LA19_0=='k') ) {s = 6;}

                        else if ( (LA19_0=='i') ) {s = 7;}

                        else if ( (LA19_0=='a') ) {s = 8;}

                        else if ( (LA19_0=='^') ) {s = 9;}

                        else if ( ((LA19_0>='A' && LA19_0<='J')||(LA19_0>='L' && LA19_0<='Z')||LA19_0=='_'||LA19_0=='b'||(LA19_0>='e' && LA19_0<='h')||LA19_0=='j'||LA19_0=='l'||(LA19_0>='n' && LA19_0<='r')||(LA19_0>='u' && LA19_0<='z')) ) {s = 10;}

                        else if ( ((LA19_0>='0' && LA19_0<='9')) ) {s = 11;}

                        else if ( (LA19_0=='\"') ) {s = 12;}

                        else if ( (LA19_0=='\'') ) {s = 13;}

                        else if ( (LA19_0=='/') ) {s = 14;}

                        else if ( ((LA19_0>='\t' && LA19_0<='\n')||LA19_0=='\r'||LA19_0==' ') ) {s = 15;}

                        else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||LA19_0=='!'||(LA19_0>='#' && LA19_0<='&')||(LA19_0>='(' && LA19_0<='.')||(LA19_0>=':' && LA19_0<='@')||(LA19_0>='[' && LA19_0<=']')||LA19_0=='`'||(LA19_0>='{' && LA19_0<='\uFFFF')) ) {s = 16;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_13 = input.LA(1);

                        s = -1;
                        if ( ((LA19_13>='\u0000' && LA19_13<='\uFFFF')) ) {s = 28;}

                        else s = 16;

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