// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g 2008-05-20 14:21:23

package org.eclipse.xtext.lexer.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLexerLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=9;
    public static final int RULE_ID=4;
    public static final int RULE_WS=12;
    public static final int RULE_IMPLICITTOKENTYPE=6;
    public static final int EOF=-1;
    public static final int RULE_INT=10;
    public static final int RULE_STRING=7;
    public static final int Tokens=14;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_EXPLICITTOKENTYPE=5;
    public static final int RULE_LEXER_BODY=8;
    public InternalLexerLanguageLexer() {;} 
    public InternalLexerLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g"; }

    // $ANTLR start RULE_EXPLICITTOKENTYPE
    public final void mRULE_EXPLICITTOKENTYPE() throws RecognitionException {
        try {
            int _type = RULE_EXPLICITTOKENTYPE;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:181:24: ( ( 'A' )+ )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:181:27: ( 'A' )+
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:181:27: ( 'A' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='A') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:181:28: 'A'
            	    {
            	    match('A'); 

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
    // $ANTLR end RULE_EXPLICITTOKENTYPE

    // $ANTLR start RULE_IMPLICITTOKENTYPE
    public final void mRULE_IMPLICITTOKENTYPE() throws RecognitionException {
        try {
            int _type = RULE_IMPLICITTOKENTYPE;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:183:24: ( ( 'C' )+ )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:183:27: ( 'C' )+
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:183:27: ( 'C' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='C') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:183:28: 'C'
            	    {
            	    match('C'); 

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
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:185:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:185:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:185:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:185:12: '^'
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

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:185:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
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
            	    break loop4;
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
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:187:17: ( '<#' ( options {greedy=false; } : . )* '#>' )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:187:19: '<#' ( options {greedy=false; } : . )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:187:24: ( options {greedy=false; } : . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='#') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='>') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='=')||(LA5_1>='?' && LA5_1<='\uFFFE')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='\"')||(LA5_0>='$' && LA5_0<='\uFFFE')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:187:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
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

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:189:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:189:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:189:24: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFE')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:189:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
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

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:193:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:193:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:193:24: (~ ( '\\n' | '\\r' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:193:24: ~ ( '\\n' | '\\r' )
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
            	    break loop8;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:193:38: ( '\\r' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:193:38: '\\r'
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

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:195:13: ( ( 'B' )+ )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:195:16: ( 'B' )+
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:195:16: ( 'B' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='B') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:195:17: 'B'
            	    {
            	    match('B'); 

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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:197:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:197:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:197:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

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
        // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:8: ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE | RULE_ID | RULE_LEXER_BODY | RULE_ML_COMMENT | RULE_INT | RULE_SL_COMMENT | RULE_STRING | RULE_WS | RULE_ANY_OTHER )
        int alt12=10;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:10: RULE_EXPLICITTOKENTYPE
                {
                mRULE_EXPLICITTOKENTYPE(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:33: RULE_IMPLICITTOKENTYPE
                {
                mRULE_IMPLICITTOKENTYPE(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:56: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:64: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:80: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:96: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:105: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:121: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:1:133: RULE_WS
                {
                mRULE_WS(); 

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
        "\1\uffff\1\14\1\17\1\12\1\15\2\12\4\uffff\1\14\2\uffff\1\17\1\uffff"+
        "\1\15\5\uffff";
    static final String DFA12_eofS =
        "\26\uffff";
    static final String DFA12_minS =
        "\1\0\2\60\1\101\1\102\1\43\1\52\4\uffff\1\60\2\uffff\1\60\1\uffff"+
        "\1\102\5\uffff";
    static final String DFA12_maxS =
        "\1\ufffe\3\172\1\102\1\43\1\57\4\uffff\1\172\2\uffff\1\172\1\uffff"+
        "\1\102\5\uffff";
    static final String DFA12_acceptS =
        "\7\uffff\1\6\1\3\1\11\1\12\1\uffff\1\1\1\3\1\uffff\1\2\1\uffff\1"+
        "\4\1\7\1\5\1\6\1\11";
    static final String DFA12_specialS =
        "\26\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\12\2\11\2\12\1\11\22\12\1\11\16\12\1\6\12\7\2\12\1\5\4\12"+
            "\1\1\1\4\1\2\27\10\3\12\1\3\1\10\1\12\32\10\uff84\12",
            "\12\15\7\uffff\1\13\31\15\4\uffff\1\15\1\uffff\32\15",
            "\12\15\7\uffff\2\15\1\16\27\15\4\uffff\1\15\1\uffff\32\15",
            "\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\20",
            "\1\21",
            "\1\23\4\uffff\1\22",
            "",
            "",
            "",
            "",
            "\12\15\7\uffff\1\13\31\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "",
            "\12\15\7\uffff\2\15\1\16\27\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "\1\20",
            "",
            "",
            "",
            "",
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
            return "1:1: Tokens : ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE | RULE_ID | RULE_LEXER_BODY | RULE_ML_COMMENT | RULE_INT | RULE_SL_COMMENT | RULE_STRING | RULE_WS | RULE_ANY_OTHER );";
        }
    }
 

}