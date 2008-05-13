// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g 2008-05-13 15:03:39

package org.eclipse.xtext.grammargen.tests.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleTest2Lexer extends Lexer {
    public static final int RULE_ML_COMMENT=9;
    public static final int T14=14;
    public static final int RULE_ID=4;
    public static final int RULE_WS=8;
    public static final int T11=11;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=10;
    public static final int T12=12;
    public static final int Tokens=15;
    public static final int RULE_SL_COMMENT=6;
    public static final int T13=13;
    public static final int RULE_LEXER_BODY=7;
    public InternalSimpleTest2Lexer() {;} 
    public InternalSimpleTest2Lexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g"; }

    // $ANTLR start T11
    public void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:6:7: ( 'optional' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:6:7: 'optional'
            {
            match("optional"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:7:7: ( 'keyword' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:7:7: 'keyword'
            {
            match("keyword"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:8:7: ( '{' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:8:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:9:7: ( '}' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:9:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start RULE_ID
    public void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:59:11: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:59:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:59:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:59:12: '^'
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

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:59:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:
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

    // $ANTLR start RULE_INT
    public void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:61:12: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:61:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:61:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:61:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_SL_COMMENT
    public void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:63:19: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:63:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:63:24: (~ ( '\\n' | '\\r' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFE')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:63:24: ~ ( '\\n' | '\\r' )
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
            	    break loop4;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:63:38: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:63:38: '\\r'
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

    // $ANTLR start RULE_LEXER_BODY
    public void mRULE_LEXER_BODY() throws RecognitionException {
        try {
            int _type = RULE_LEXER_BODY;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:65:19: ( '<#' ( options {greedy=false; } : . )* '#>' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:65:19: '<#' ( options {greedy=false; } : . )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:65:24: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='#') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='>') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='=')||(LA6_1>='?' && LA6_1<='\uFFFE')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='\"')||(LA6_0>='$' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:65:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
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

    // $ANTLR start RULE_WS
    public void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:67:11: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:67:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:67:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:
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
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ML_COMMENT
    public void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:69:19: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:69:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:69:24: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFE')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:69:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
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

    // $ANTLR start RULE_STRING
    public void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:71:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\"') ) {
                alt11=1;
            }
            else if ( (LA11_0=='\'') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("71:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:71:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:71:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFE')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:71:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:71:65: ~ ( '\\\\' | '\"' )
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
                    	    break loop9;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:72:2: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:72:7: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
                    loop10:
                    do {
                        int alt10=3;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='\\') ) {
                            alt10=1;
                        }
                        else if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFE')) ) {
                            alt10=2;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:72:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:72:53: ~ ( '\\\\' | '\\'' )
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
                    	    break loop10;
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

    public void mTokens() throws RecognitionException {
        // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:10: ( T11 | T12 | T13 | T14 | RULE_ID | RULE_INT | RULE_SL_COMMENT | RULE_LEXER_BODY | RULE_WS | RULE_ML_COMMENT | RULE_STRING )
        int alt12=11;
        switch ( input.LA(1) ) {
        case 'o':
            {
            int LA12_1 = input.LA(2);

            if ( (LA12_1=='p') ) {
                int LA12_11 = input.LA(3);

                if ( (LA12_11=='t') ) {
                    int LA12_15 = input.LA(4);

                    if ( (LA12_15=='i') ) {
                        int LA12_17 = input.LA(5);

                        if ( (LA12_17=='o') ) {
                            int LA12_19 = input.LA(6);

                            if ( (LA12_19=='n') ) {
                                int LA12_21 = input.LA(7);

                                if ( (LA12_21=='a') ) {
                                    int LA12_23 = input.LA(8);

                                    if ( (LA12_23=='l') ) {
                                        int LA12_25 = input.LA(9);

                                        if ( ((LA12_25>='0' && LA12_25<='9')||(LA12_25>='A' && LA12_25<='Z')||LA12_25=='_'||(LA12_25>='a' && LA12_25<='z')) ) {
                                            alt12=5;
                                        }
                                        else {
                                            alt12=1;}
                                    }
                                    else {
                                        alt12=5;}
                                }
                                else {
                                    alt12=5;}
                            }
                            else {
                                alt12=5;}
                        }
                        else {
                            alt12=5;}
                    }
                    else {
                        alt12=5;}
                }
                else {
                    alt12=5;}
            }
            else {
                alt12=5;}
            }
            break;
        case 'k':
            {
            int LA12_2 = input.LA(2);

            if ( (LA12_2=='e') ) {
                int LA12_12 = input.LA(3);

                if ( (LA12_12=='y') ) {
                    int LA12_16 = input.LA(4);

                    if ( (LA12_16=='w') ) {
                        int LA12_18 = input.LA(5);

                        if ( (LA12_18=='o') ) {
                            int LA12_20 = input.LA(6);

                            if ( (LA12_20=='r') ) {
                                int LA12_22 = input.LA(7);

                                if ( (LA12_22=='d') ) {
                                    int LA12_24 = input.LA(8);

                                    if ( ((LA12_24>='0' && LA12_24<='9')||(LA12_24>='A' && LA12_24<='Z')||LA12_24=='_'||(LA12_24>='a' && LA12_24<='z')) ) {
                                        alt12=5;
                                    }
                                    else {
                                        alt12=2;}
                                }
                                else {
                                    alt12=5;}
                            }
                            else {
                                alt12=5;}
                        }
                        else {
                            alt12=5;}
                    }
                    else {
                        alt12=5;}
                }
                else {
                    alt12=5;}
            }
            else {
                alt12=5;}
            }
            break;
        case '{':
            {
            alt12=3;
            }
            break;
        case '}':
            {
            alt12=4;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
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
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '^':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'l':
        case 'm':
        case 'n':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt12=5;
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
            {
            alt12=6;
            }
            break;
        case '/':
            {
            int LA12_7 = input.LA(2);

            if ( (LA12_7=='/') ) {
                alt12=7;
            }
            else if ( (LA12_7=='*') ) {
                alt12=10;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | RULE_ID | RULE_INT | RULE_SL_COMMENT | RULE_LEXER_BODY | RULE_WS | RULE_ML_COMMENT | RULE_STRING );", 12, 7, input);

                throw nvae;
            }
            }
            break;
        case '<':
            {
            alt12=8;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt12=9;
            }
            break;
        case '\"':
        case '\'':
            {
            alt12=11;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | RULE_ID | RULE_INT | RULE_SL_COMMENT | RULE_LEXER_BODY | RULE_WS | RULE_ML_COMMENT | RULE_STRING );", 12, 0, input);

            throw nvae;
        }

        switch (alt12) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:26: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:34: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:43: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:59: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:75: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:83: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 11 :
                // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:1:99: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;

        }

    }


 

}