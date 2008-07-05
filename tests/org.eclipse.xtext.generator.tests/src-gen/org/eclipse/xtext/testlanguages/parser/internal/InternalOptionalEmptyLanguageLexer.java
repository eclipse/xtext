// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g 2008-07-05 20:00:21

package org.eclipse.xtext.testlanguages.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalOptionalEmptyLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int T12=12;
    public static final int Tokens=13;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=10;
    public InternalOptionalEmptyLanguageLexer() {;} 
    public InternalOptionalEmptyLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:10:5: ( 'hallo' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:10:7: 'hallo'
            {
            match("hallo"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:130:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:130:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:130:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:130:12: '^'
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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:130:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:
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
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:132:10: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:132:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:132:12: ( '0' .. '9' )+
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:132:13: '0' .. '9'
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

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:134:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("134:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:134:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:134:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:134:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:134:65: ~ ( '\\\\' | '\"' )
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
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:134:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:134:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:134:93: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:134:137: ~ ( '\\\\' | '\\'' )
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
                    	    break loop5;
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

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:136:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:136:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:136:24: ( options {greedy=false; } : . )*
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:136:52: .
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

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' ) )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:19: '//' (~ ( '\\n' | '\\r' ) )* ( ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' ) )?
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:24: (~ ( '\\n' | '\\r' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:26: ~ ( '\\n' | '\\r' )
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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:41: ( ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:42: ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:42: ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' )
                    int alt9=3;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1=='\n') ) {
                            alt9=1;
                        }
                        else {
                            alt9=2;}
                    }
                    else if ( (LA9_0=='\n') ) {
                        alt9=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("138:42: ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' )", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:65: '\\r\\n'
                            {
                            match("\r\n"); 


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:74: '\\r'
                            {
                            match('\r'); 

                            }
                            break;
                        case 3 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:138:81: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                    }
                    break;

            }

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:140:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:140:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:140:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:
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

    // $ANTLR start RULE_LEXER_BODY
    public final void mRULE_LEXER_BODY() throws RecognitionException {
        try {
            int _type = RULE_LEXER_BODY;
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:142:17: ( '<#' ( '.' )* '#>' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:142:19: '<#' ( '.' )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:142:24: ( '.' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='.') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:142:24: '.'
            	    {
            	    match('.'); 

            	    }
            	    break;

            	default :
            	    break loop12;
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
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:144:16: ( . )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:144:18: .
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
        // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:1:8: ( T12 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_LEXER_BODY | RULE_ANY_OTHER )
        int alt13=9;
        int LA13_0 = input.LA(1);

        if ( (LA13_0=='h') ) {
            int LA13_1 = input.LA(2);

            if ( (LA13_1=='a') ) {
                int LA13_11 = input.LA(3);

                if ( (LA13_11=='l') ) {
                    int LA13_19 = input.LA(4);

                    if ( (LA13_19=='l') ) {
                        int LA13_20 = input.LA(5);

                        if ( (LA13_20=='o') ) {
                            int LA13_21 = input.LA(6);

                            if ( ((LA13_21>='0' && LA13_21<='9')||(LA13_21>='A' && LA13_21<='Z')||LA13_21=='_'||(LA13_21>='a' && LA13_21<='z')) ) {
                                alt13=2;
                            }
                            else {
                                alt13=1;}
                        }
                        else {
                            alt13=2;}
                    }
                    else {
                        alt13=2;}
                }
                else {
                    alt13=2;}
            }
            else {
                alt13=2;}
        }
        else if ( (LA13_0=='^') ) {
            int LA13_2 = input.LA(2);

            if ( ((LA13_2>='A' && LA13_2<='Z')||LA13_2=='_'||(LA13_2>='a' && LA13_2<='z')) ) {
                alt13=2;
            }
            else {
                alt13=9;}
        }
        else if ( ((LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='g')||(LA13_0>='i' && LA13_0<='z')) ) {
            alt13=2;
        }
        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {
            alt13=3;
        }
        else if ( (LA13_0=='\"') ) {
            int LA13_5 = input.LA(2);

            if ( ((LA13_5>='\u0000' && LA13_5<='\uFFFE')) ) {
                alt13=4;
            }
            else {
                alt13=9;}
        }
        else if ( (LA13_0=='\'') ) {
            int LA13_6 = input.LA(2);

            if ( ((LA13_6>='\u0000' && LA13_6<='\uFFFE')) ) {
                alt13=4;
            }
            else {
                alt13=9;}
        }
        else if ( (LA13_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt13=6;
                }
                break;
            case '*':
                {
                alt13=5;
                }
                break;
            default:
                alt13=9;}

        }
        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
            alt13=7;
        }
        else if ( (LA13_0=='<') ) {
            int LA13_9 = input.LA(2);

            if ( (LA13_9=='#') ) {
                alt13=8;
            }
            else {
                alt13=9;}
        }
        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||(LA13_0>='#' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='.')||(LA13_0>=':' && LA13_0<=';')||(LA13_0>='=' && LA13_0<='@')||(LA13_0>='[' && LA13_0<=']')||LA13_0=='`'||(LA13_0>='{' && LA13_0<='\uFFFE')) ) {
            alt13=9;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T12 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_LEXER_BODY | RULE_ANY_OTHER );", 13, 0, input);

            throw nvae;
        }
        switch (alt13) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:1:14: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:1:22: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:1:31: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:1:43: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:1:59: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:1:75: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:1:83: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:1:99: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}