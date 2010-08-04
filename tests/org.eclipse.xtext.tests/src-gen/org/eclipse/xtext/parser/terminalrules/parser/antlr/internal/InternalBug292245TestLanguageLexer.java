package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug292245TestLanguageLexer extends Lexer {
    public static final int RULE_APOSTROPHE_CHAR=4;
    public static final int T7=7;
    public static final int T10=10;
    public static final int RULE_CHAR=5;
    public static final int T8=8;
    public static final int T9=9;
    public static final int RULE_WS=6;
    public static final int Tokens=11;
    public static final int EOF=-1;
    public InternalBug292245TestLanguageLexer() {;} 
    public InternalBug292245TestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g"; }

    // $ANTLR start T7
    public final void mT7() throws RecognitionException {
        try {
            int _type = T7;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:10:4: ( 'FIX' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:10:6: 'FIX'
            {
            match("FIX"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T7

    // $ANTLR start T8
    public final void mT8() throws RecognitionException {
        try {
            int _type = T8;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:11:4: ( 'ERROR' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:11:6: 'ERROR'
            {
            match("ERROR"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T8

    // $ANTLR start T9
    public final void mT9() throws RecognitionException {
        try {
            int _type = T9;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:12:4: ( 'TICK' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:12:6: 'TICK'
            {
            match("TICK"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T9

    // $ANTLR start T10
    public final void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:13:5: ( '^' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:13:7: '^'
            {
            match('^'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start RULE_APOSTROPHE_CHAR
    public final void mRULE_APOSTROPHE_CHAR() throws RecognitionException {
        try {
            int _type = RULE_APOSTROPHE_CHAR;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:439:22: ( '\\'' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:439:24: '\\''
            {
            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_APOSTROPHE_CHAR

    // $ANTLR start RULE_CHAR
    public final void mRULE_CHAR() throws RecognitionException {
        try {
            int _type = RULE_CHAR;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:441:11: ( ( 'A' .. 'Z' | '0' .. '9' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:441:13: ( 'A' .. 'Z' | '0' .. '9' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_CHAR

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:443:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:443:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:443:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:1:8: ( T7 | T8 | T9 | T10 | RULE_APOSTROPHE_CHAR | RULE_CHAR | RULE_WS )
        int alt2=7;
        switch ( input.LA(1) ) {
        case 'F':
            {
            int LA2_1 = input.LA(2);

            if ( (LA2_1=='I') ) {
                alt2=1;
            }
            else {
                alt2=6;}
            }
            break;
        case 'E':
            {
            int LA2_2 = input.LA(2);

            if ( (LA2_2=='R') ) {
                alt2=2;
            }
            else {
                alt2=6;}
            }
            break;
        case 'T':
            {
            int LA2_3 = input.LA(2);

            if ( (LA2_3=='I') ) {
                alt2=3;
            }
            else {
                alt2=6;}
            }
            break;
        case '^':
            {
            alt2=4;
            }
            break;
        case '\'':
            {
            alt2=5;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
            {
            alt2=6;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt2=7;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T7 | T8 | T9 | T10 | RULE_APOSTROPHE_CHAR | RULE_CHAR | RULE_WS );", 2, 0, input);

            throw nvae;
        }

        switch (alt2) {
            case 1 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:1:10: T7
                {
                mT7(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:1:13: T8
                {
                mT8(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:1:16: T9
                {
                mT9(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:1:19: T10
                {
                mT10(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:1:23: RULE_APOSTROPHE_CHAR
                {
                mRULE_APOSTROPHE_CHAR(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:1:44: RULE_CHAR
                {
                mRULE_CHAR(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:1:54: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


 

}