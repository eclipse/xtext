// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g 2008-05-20 13:54:32

package org.eclipse.xtext.lexer.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLexerLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_IMPLICITTOKENTYPE=6;
    public static final int EOF=-1;
    public static final int RULE_INT=11;
    public static final int RULE_STRING=7;
    public static final int Tokens=14;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_EXPLICITTOKENTYPE=5;
    public static final int RULE_LEXER_BODY=12;
    public InternalLexerLanguageLexer() {;} 
    public InternalLexerLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g"; }

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:181:13: ( ( 'B' )+ )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:181:16: ( 'B' )+
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:181:16: ( 'B' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='B') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:181:17: 'B'
            	    {
            	    match('B'); 

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
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:183:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:183:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:183:24: ( options {greedy=false; } : . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='.')||(LA2_1>='0' && LA2_1<='\uFFFE')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFE')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:183:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("*/"); 

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:185:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:185:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:185:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_EXPLICITTOKENTYPE
    public final void mRULE_EXPLICITTOKENTYPE() throws RecognitionException {
        try {
            int _type = RULE_EXPLICITTOKENTYPE;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:187:24: ( ( 'A' )+ )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:187:27: ( 'A' )+
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:187:27: ( 'A' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='A') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:187:28: 'A'
            	    {
            	    match('A'); 

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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_EXPLICITTOKENTYPE

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:189:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:189:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:189:24: (~ ( '\\n' | '\\r' ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\uFFFE')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:189:24: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
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
            	    break loop5;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:189:38: ( '\\r' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:189:38: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:191:10: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:191:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:191:12: ( '0' .. '9' )+
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
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:191:13: '0' .. '9'
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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_IMPLICITTOKENTYPE
    public final void mRULE_IMPLICITTOKENTYPE() throws RecognitionException {
        try {
            int _type = RULE_IMPLICITTOKENTYPE;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:193:24: ( ( 'C' )+ )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:193:27: ( 'C' )+
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:193:27: ( 'C' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='C') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:193:28: 'C'
            	    {
            	    match('C'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_IMPLICITTOKENTYPE

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:195:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:195:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:195:11: ( '^' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='^') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:195:12: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:195:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
            	    break loop10;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_LEXER_BODY
    public final void mRULE_LEXER_BODY() throws RecognitionException {
        try {
            int _type = RULE_LEXER_BODY;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:197:17: ( '<#' ( options {greedy=false; } : . )* '#>' )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:197:19: '<#' ( options {greedy=false; } : . )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:197:24: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='#') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='>') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='=')||(LA11_1>='?' && LA11_1<='\uFFFE')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='\"')||(LA11_0>='$' && LA11_0<='\uFFFE')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:197:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match("#>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_LEXER_BODY

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:199:16: ( . )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:199:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:8: ( RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_EXPLICITTOKENTYPE | RULE_SL_COMMENT | RULE_INT | RULE_IMPLICITTOKENTYPE | RULE_ID | RULE_LEXER_BODY | RULE_ANY_OTHER )
        int alt12=10;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:10: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:22: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:38: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:46: RULE_EXPLICITTOKENTYPE
                {
                mRULE_EXPLICITTOKENTYPE(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:69: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:85: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:94: RULE_IMPLICITTOKENTYPE
                {
                mRULE_IMPLICITTOKENTYPE(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:117: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:125: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:141: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\13\1\12\1\uffff\1\21\1\uffff\1\24\1\12\1\uffff\1\12\2"+
        "\uffff\1\13\5\uffff\1\21\2\uffff\1\24\1\uffff";
    static final String DFA12_eofS =
        "\27\uffff";
    static final String DFA12_minS =
        "\1\0\1\60\1\52\1\uffff\1\60\1\uffff\1\60\1\101\1\uffff\1\43\2\uffff"+
        "\1\60\5\uffff\1\60\2\uffff\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\ufffe\1\172\1\57\1\uffff\1\172\1\uffff\2\172\1\uffff\1\43\2\uffff"+
        "\1\172\5\uffff\1\172\2\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\3\uffff\1\3\1\uffff\1\6\2\uffff\1\10\1\uffff\1\12\1\1\1\uffff\1"+
        "\10\1\2\1\5\1\3\1\4\1\uffff\1\6\1\7\1\uffff\1\11";
    static final String DFA12_specialS =
        "\27\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\12\2\3\2\12\1\3\22\12\1\3\16\12\1\2\12\5\2\12\1\11\4\12"+
            "\1\4\1\1\1\6\27\10\3\12\1\7\1\10\1\12\32\10\uff84\12",
            "\12\15\7\uffff\1\15\1\14\30\15\4\uffff\1\15\1\uffff\32\15",
            "\1\16\4\uffff\1\17",
            "",
            "\12\15\7\uffff\1\22\31\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "\12\15\7\uffff\2\15\1\25\27\15\4\uffff\1\15\1\uffff\32\15",
            "\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "\1\26",
            "",
            "",
            "\12\15\7\uffff\1\15\1\14\30\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "",
            "",
            "",
            "",
            "\12\15\7\uffff\1\22\31\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "",
            "\12\15\7\uffff\2\15\1\25\27\15\4\uffff\1\15\1\uffff\32\15",
            ""
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
            return "1:1: Tokens : ( RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_EXPLICITTOKENTYPE | RULE_SL_COMMENT | RULE_INT | RULE_IMPLICITTOKENTYPE | RULE_ID | RULE_LEXER_BODY | RULE_ANY_OTHER );";
        }
    }
 

}