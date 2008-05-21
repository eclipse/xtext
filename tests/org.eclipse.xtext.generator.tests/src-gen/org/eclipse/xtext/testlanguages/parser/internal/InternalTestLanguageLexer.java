// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g 2008-05-21 11:52:56

package org.eclipse.xtext.testlanguages.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTestLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=7;
    public static final int T14=14;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int T12=12;
    public static final int Tokens=15;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=10;
    public static final int T13=13;
    public static final int RULE_LEXER_BODY=8;
    public InternalTestLanguageLexer() {;} 
    public InternalTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:6:5: ( 'choice' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:6:7: 'choice'
            {
            match("choice"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:7:5: ( 'optional' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:7:7: 'optional'
            {
            match("optional"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:8:5: ( 'reducible' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:8:7: 'reducible'
            {
            match("reducible"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:227:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\"') ) {
                alt3=1;
            }
            else if ( (LA3_0=='\'') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("227:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:227:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:227:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
                    loop1:
                    do {
                        int alt1=3;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0=='\\') ) {
                            alt1=1;
                        }
                        else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFE')) ) {
                            alt1=2;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:227:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:227:65: ~ ( '\\\\' | '\"' )
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
                    	    break loop1;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:227:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:227:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
                    loop2:
                    do {
                        int alt2=3;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\\') ) {
                            alt2=1;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFE')) ) {
                            alt2=2;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:227:93: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:227:137: ~ ( '\\\\' | '\\'' )
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
                    	    break loop2;
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

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:229:10: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:229:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:229:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:229:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:231:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:231:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:231:24: ( options {greedy=false; } : . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='*') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='/') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='.')||(LA5_1>='0' && LA5_1<='\uFFFE')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<=')')||(LA5_0>='+' && LA5_0<='\uFFFE')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:231:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
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
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:233:17: ( '<#' ( options {greedy=false; } : . )* '#>' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:233:19: '<#' ( options {greedy=false; } : . )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:233:24: ( options {greedy=false; } : . )*
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:233:52: .
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

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:235:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:235:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:235:11: ( '^' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='^') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:235:12: '^'
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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:235:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:
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
            	    break loop8;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:237:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:237:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:237:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\t' && LA9_0<='\n')||LA9_0=='\r'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:24: (~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:24: ~ ( '\\n' | '\\r' )
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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:38: ( '\\r' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:38: '\\r'
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
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:241:16: ( . )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:241:18: .
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
        // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:8: ( T12 | T13 | T14 | RULE_STRING | RULE_INT | RULE_ML_COMMENT | RULE_LEXER_BODY | RULE_ID | RULE_WS | RULE_SL_COMMENT | RULE_ANY_OTHER )
        int alt12=11;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='c') ) {
            int LA12_1 = input.LA(2);

            if ( (LA12_1=='h') ) {
                int LA12_13 = input.LA(3);

                if ( (LA12_13=='o') ) {
                    int LA12_23 = input.LA(4);

                    if ( (LA12_23=='i') ) {
                        int LA12_26 = input.LA(5);

                        if ( (LA12_26=='c') ) {
                            int LA12_29 = input.LA(6);

                            if ( (LA12_29=='e') ) {
                                int LA12_32 = input.LA(7);

                                if ( ((LA12_32>='0' && LA12_32<='9')||(LA12_32>='A' && LA12_32<='Z')||LA12_32=='_'||(LA12_32>='a' && LA12_32<='z')) ) {
                                    alt12=8;
                                }
                                else {
                                    alt12=1;}
                            }
                            else {
                                alt12=8;}
                        }
                        else {
                            alt12=8;}
                    }
                    else {
                        alt12=8;}
                }
                else {
                    alt12=8;}
            }
            else {
                alt12=8;}
        }
        else if ( (LA12_0=='o') ) {
            int LA12_2 = input.LA(2);

            if ( (LA12_2=='p') ) {
                int LA12_15 = input.LA(3);

                if ( (LA12_15=='t') ) {
                    int LA12_24 = input.LA(4);

                    if ( (LA12_24=='i') ) {
                        int LA12_27 = input.LA(5);

                        if ( (LA12_27=='o') ) {
                            int LA12_30 = input.LA(6);

                            if ( (LA12_30=='n') ) {
                                int LA12_33 = input.LA(7);

                                if ( (LA12_33=='a') ) {
                                    int LA12_36 = input.LA(8);

                                    if ( (LA12_36=='l') ) {
                                        int LA12_38 = input.LA(9);

                                        if ( ((LA12_38>='0' && LA12_38<='9')||(LA12_38>='A' && LA12_38<='Z')||LA12_38=='_'||(LA12_38>='a' && LA12_38<='z')) ) {
                                            alt12=8;
                                        }
                                        else {
                                            alt12=2;}
                                    }
                                    else {
                                        alt12=8;}
                                }
                                else {
                                    alt12=8;}
                            }
                            else {
                                alt12=8;}
                        }
                        else {
                            alt12=8;}
                    }
                    else {
                        alt12=8;}
                }
                else {
                    alt12=8;}
            }
            else {
                alt12=8;}
        }
        else if ( (LA12_0=='r') ) {
            int LA12_3 = input.LA(2);

            if ( (LA12_3=='e') ) {
                int LA12_16 = input.LA(3);

                if ( (LA12_16=='d') ) {
                    int LA12_25 = input.LA(4);

                    if ( (LA12_25=='u') ) {
                        int LA12_28 = input.LA(5);

                        if ( (LA12_28=='c') ) {
                            int LA12_31 = input.LA(6);

                            if ( (LA12_31=='i') ) {
                                int LA12_34 = input.LA(7);

                                if ( (LA12_34=='b') ) {
                                    int LA12_37 = input.LA(8);

                                    if ( (LA12_37=='l') ) {
                                        int LA12_39 = input.LA(9);

                                        if ( (LA12_39=='e') ) {
                                            int LA12_41 = input.LA(10);

                                            if ( ((LA12_41>='0' && LA12_41<='9')||(LA12_41>='A' && LA12_41<='Z')||LA12_41=='_'||(LA12_41>='a' && LA12_41<='z')) ) {
                                                alt12=8;
                                            }
                                            else {
                                                alt12=3;}
                                        }
                                        else {
                                            alt12=8;}
                                    }
                                    else {
                                        alt12=8;}
                                }
                                else {
                                    alt12=8;}
                            }
                            else {
                                alt12=8;}
                        }
                        else {
                            alt12=8;}
                    }
                    else {
                        alt12=8;}
                }
                else {
                    alt12=8;}
            }
            else {
                alt12=8;}
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_4 = input.LA(2);

            if ( ((LA12_4>='\u0000' && LA12_4<='\uFFFE')) ) {
                alt12=4;
            }
            else {
                alt12=11;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_5 = input.LA(2);

            if ( ((LA12_5>='\u0000' && LA12_5<='\uFFFE')) ) {
                alt12=4;
            }
            else {
                alt12=11;}
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=5;
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=10;
                }
                break;
            case '*':
                {
                alt12=6;
                }
                break;
            default:
                alt12=11;}

        }
        else if ( (LA12_0=='<') ) {
            int LA12_8 = input.LA(2);

            if ( (LA12_8=='#') ) {
                alt12=7;
            }
            else {
                alt12=11;}
        }
        else if ( (LA12_0=='^') ) {
            int LA12_9 = input.LA(2);

            if ( ((LA12_9>='A' && LA12_9<='Z')||LA12_9=='_'||(LA12_9>='a' && LA12_9<='z')) ) {
                alt12=8;
            }
            else {
                alt12=11;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='b')||(LA12_0>='d' && LA12_0<='n')||(LA12_0>='p' && LA12_0<='q')||(LA12_0>='s' && LA12_0<='z')) ) {
            alt12=8;
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=9;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<=';')||(LA12_0>='=' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12=11;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T12 | T13 | T14 | RULE_STRING | RULE_INT | RULE_ML_COMMENT | RULE_LEXER_BODY | RULE_ID | RULE_WS | RULE_SL_COMMENT | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:22: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:34: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:43: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:59: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:75: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:83: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:91: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 11 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:1:107: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}