// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g 2008-05-21 10:06:43

package org.eclipse.xtext.testlanguages.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLexerLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_ID=4;
    public static final int RULE_WS=12;
    public static final int RULE_IMPLICITTOKENTYPE=6;
    public static final int EOF=-1;
    public static final int RULE_INT=9;
    public static final int RULE_STRING=7;
    public static final int Tokens=14;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_EXPLICITTOKENTYPE=5;
    public static final int RULE_LEXER_BODY=11;
    public InternalLexerLanguageLexer() {;} 
    public InternalLexerLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g"; }

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:196:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:196:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:196:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:196:12: '^'
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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:196:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:
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
            	    break loop2;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:198:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:198:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:198:24: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFE')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:198:24: ~ ( '\\n' | '\\r' )
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
            	    break loop3;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:198:38: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:198:38: '\\r'
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

    // $ANTLR start RULE_EXPLICITTOKENTYPE
    public final void mRULE_EXPLICITTOKENTYPE() throws RecognitionException {
        try {
            int _type = RULE_EXPLICITTOKENTYPE;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:200:24: ( '#' ( 'A' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:200:27: '#' ( 'A' )+
            {
            match('#'); 
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:200:31: ( 'A' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='A') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:200:32: 'A'
            	    {
            	    match('A'); 

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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_EXPLICITTOKENTYPE

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:202:10: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:202:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:202:12: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:202:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:204:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:204:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:204:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFE')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:204:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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

    // $ANTLR start RULE_LEXER_BODY
    public final void mRULE_LEXER_BODY() throws RecognitionException {
        try {
            int _type = RULE_LEXER_BODY;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:206:17: ( '<#' ( options {greedy=false; } : . )* '#>' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:206:19: '<#' ( options {greedy=false; } : . )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:206:24: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='#') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='>') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='=')||(LA8_1>='?' && LA8_1<='\uFFFE')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='\"')||(LA8_0>='$' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:206:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
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

    // $ANTLR start RULE_IMPLICITTOKENTYPE
    public final void mRULE_IMPLICITTOKENTYPE() throws RecognitionException {
        try {
            int _type = RULE_IMPLICITTOKENTYPE;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:208:24: ( '#' ( 'C' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:208:27: '#' ( 'C' )+
            {
            match('#'); 
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:208:31: ( 'C' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='C') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:208:32: 'C'
            	    {
            	    match('C'); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_IMPLICITTOKENTYPE

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:210:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:210:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:210:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:
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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:212:13: ( '#' ( 'B' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:212:16: '#' ( 'B' )+
            {
            match('#'); 
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:212:20: ( 'B' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='B') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:212:21: 'B'
            	    {
            	    match('B'); 

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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:214:16: ( . )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:214:18: .
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
        // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:8: ( RULE_ID | RULE_SL_COMMENT | RULE_EXPLICITTOKENTYPE | RULE_INT | RULE_ML_COMMENT | RULE_LEXER_BODY | RULE_IMPLICITTOKENTYPE | RULE_WS | RULE_STRING | RULE_ANY_OTHER )
        int alt12=10;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='^') ) {
            int LA12_1 = input.LA(2);

            if ( ((LA12_1>='A' && LA12_1<='Z')||LA12_1=='_'||(LA12_1>='a' && LA12_1<='z')) ) {
                alt12=1;
            }
            else {
                alt12=10;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
            alt12=1;
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=2;
                }
                break;
            case '*':
                {
                alt12=5;
                }
                break;
            default:
                alt12=10;}

        }
        else if ( (LA12_0=='#') ) {
            switch ( input.LA(2) ) {
            case 'A':
                {
                alt12=3;
                }
                break;
            case 'C':
                {
                alt12=7;
                }
                break;
            case 'B':
                {
                alt12=9;
                }
                break;
            default:
                alt12=10;}

        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=4;
        }
        else if ( (LA12_0=='<') ) {
            int LA12_6 = input.LA(2);

            if ( (LA12_6=='#') ) {
                alt12=6;
            }
            else {
                alt12=10;}
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=8;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='!' && LA12_0<='\"')||(LA12_0>='$' && LA12_0<='.')||(LA12_0>=':' && LA12_0<=';')||(LA12_0>='=' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12=10;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( RULE_ID | RULE_SL_COMMENT | RULE_EXPLICITTOKENTYPE | RULE_INT | RULE_ML_COMMENT | RULE_LEXER_BODY | RULE_IMPLICITTOKENTYPE | RULE_WS | RULE_STRING | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:10: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:18: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:34: RULE_EXPLICITTOKENTYPE
                {
                mRULE_EXPLICITTOKENTYPE(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:57: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:66: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:82: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:98: RULE_IMPLICITTOKENTYPE
                {
                mRULE_IMPLICITTOKENTYPE(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:121: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:129: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:1:141: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}