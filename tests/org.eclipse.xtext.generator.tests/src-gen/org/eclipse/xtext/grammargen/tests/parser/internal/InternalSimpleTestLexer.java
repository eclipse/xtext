// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g 2008-05-15 15:24:02

package org.eclipse.xtext.grammargen.tests.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleTestLexer extends Lexer {
    public static final int RULE_ML_COMMENT=9;
    public static final int RULE_ID=4;
    public static final int RULE_WS=5;
    public static final int EOF=-1;
    public static final int RULE_INT=8;
    public static final int RULE_STRING=6;
    public static final int Tokens=12;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_LEXER_BODY=7;
    public InternalSimpleTestLexer() {;} 
    public InternalSimpleTestLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g"; }

    // $ANTLR start RULE_WS
    public void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:99:11: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:99:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:99:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:
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

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_STRING
    public void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:101:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\"') ) {
                alt4=1;
            }
            else if ( (LA4_0=='\'') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("101:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:101:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:101:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
                    loop2:
                    do {
                        int alt2=3;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\\') ) {
                            alt2=1;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFE')) ) {
                            alt2=2;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:101:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:101:65: ~ ( '\\\\' | '\"' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
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

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:102:2: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:102:7: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFE')) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:102:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:102:53: ~ ( '\\\\' | '\\'' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
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

                    match('\''); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ID
    public void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:104:11: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:104:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:104:11: ( '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='^') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:104:12: '^'
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

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:104:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:
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
            	    break loop6;
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
    public void mRULE_LEXER_BODY() throws RecognitionException {
        try {
            int _type = RULE_LEXER_BODY;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:106:19: ( '<#' ( options {greedy=false; } : . )* '#>' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:106:19: '<#' ( options {greedy=false; } : . )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:106:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='#') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='>') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='=')||(LA7_1>='?' && LA7_1<='\uFFFE')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='\"')||(LA7_0>='$' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:106:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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

    // $ANTLR start RULE_INT
    public void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:108:12: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:108:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:108:12: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:108:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_ML_COMMENT
    public void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:110:19: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:110:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:110:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFE')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:110:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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

    // $ANTLR start RULE_SL_COMMENT
    public void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:112:19: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:112:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:112:24: (~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:112:24: ~ ( '\\n' | '\\r' )
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
            	    break loop10;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:112:38: ( '\\r' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:112:38: '\\r'
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

    // $ANTLR start RULE_ANY_OTHER
    public void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:114:18: ( . )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:114:18: .
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
        // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:1:10: ( RULE_WS | RULE_STRING | RULE_ID | RULE_LEXER_BODY | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_ANY_OTHER )
        int alt12=8;
        int LA12_0 = input.LA(1);

        if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=1;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_2 = input.LA(2);

            if ( ((LA12_2>='\u0000' && LA12_2<='\uFFFE')) ) {
                alt12=2;
            }
            else {
                alt12=8;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_3 = input.LA(2);

            if ( ((LA12_3>='\u0000' && LA12_3<='\uFFFE')) ) {
                alt12=2;
            }
            else {
                alt12=8;}
        }
        else if ( (LA12_0=='^') ) {
            int LA12_4 = input.LA(2);

            if ( ((LA12_4>='A' && LA12_4<='Z')||LA12_4=='_'||(LA12_4>='a' && LA12_4<='z')) ) {
                alt12=3;
            }
            else {
                alt12=8;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
            alt12=3;
        }
        else if ( (LA12_0=='<') ) {
            int LA12_6 = input.LA(2);

            if ( (LA12_6=='#') ) {
                alt12=4;
            }
            else {
                alt12=8;}
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=5;
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt12=6;
                }
                break;
            case '/':
                {
                alt12=7;
                }
                break;
            default:
                alt12=8;}

        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<=';')||(LA12_0>='=' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12=8;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( RULE_WS | RULE_STRING | RULE_ID | RULE_LEXER_BODY | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:1:10: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:1:18: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:1:30: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:1:38: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:1:54: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:1:63: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:1:79: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:1:95: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}