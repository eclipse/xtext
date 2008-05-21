// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g 2008-05-21 10:06:43

package org.eclipse.xtext.parsetree.reconstr.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalComplexReconstrTestLexer extends Lexer {
    public static final int RULE_ML_COMMENT=8;
    public static final int T14=14;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int T15=15;
    public static final int EOF=-1;
    public static final int RULE_INT=7;
    public static final int RULE_STRING=6;
    public static final int T12=12;
    public static final int Tokens=17;
    public static final int RULE_ANY_OTHER=11;
    public static final int T16=16;
    public static final int RULE_SL_COMMENT=5;
    public static final int T13=13;
    public static final int RULE_LEXER_BODY=9;
    public InternalComplexReconstrTestLexer() {;} 
    public InternalComplexReconstrTestLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:6:5: ( '+' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:6:7: '+'
            {
            match('+'); 

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
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:7:5: ( '-' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:7:7: '-'
            {
            match('-'); 

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
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:8:5: ( '(' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:8:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:9:5: ( ')' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:9:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:10:5: ( '!' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:10:7: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:233:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:233:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:233:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:233:12: '^'
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

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:233:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:
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
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:235:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:235:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:235:24: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFE')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:235:24: ~ ( '\\n' | '\\r' )
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

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:235:38: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:235:38: '\\r'
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
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\"') ) {
                alt7=1;
            }
            else if ( (LA7_0=='\'') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("237:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:65: ~ ( '\\\\' | '\"' )
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
                    	    break loop5;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFE')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:93: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:137: ~ ( '\\\\' | '\\'' )
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
                    	    break loop6;
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
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:239:10: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:239:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:239:12: ( '0' .. '9' )+
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
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:239:13: '0' .. '9'
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
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:241:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:241:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:241:24: ( options {greedy=false; } : . )*
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
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:241:52: .
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

    // $ANTLR start RULE_LEXER_BODY
    public final void mRULE_LEXER_BODY() throws RecognitionException {
        try {
            int _type = RULE_LEXER_BODY;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:17: ( '<#' ( options {greedy=false; } : . )* '#>' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:19: '<#' ( options {greedy=false; } : . )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:24: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='#') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='>') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='=')||(LA10_1>='?' && LA10_1<='\uFFFE')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<='\"')||(LA10_0>='$' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
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
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:245:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:245:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:245:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:
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
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:247:16: ( . )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:247:18: .
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
        // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:8: ( T12 | T13 | T14 | T15 | T16 | RULE_ID | RULE_SL_COMMENT | RULE_STRING | RULE_INT | RULE_ML_COMMENT | RULE_LEXER_BODY | RULE_WS | RULE_ANY_OTHER )
        int alt12=13;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='+') ) {
            alt12=1;
        }
        else if ( (LA12_0=='-') ) {
            alt12=2;
        }
        else if ( (LA12_0=='(') ) {
            alt12=3;
        }
        else if ( (LA12_0==')') ) {
            alt12=4;
        }
        else if ( (LA12_0=='!') ) {
            alt12=5;
        }
        else if ( (LA12_0=='^') ) {
            int LA12_6 = input.LA(2);

            if ( ((LA12_6>='A' && LA12_6<='Z')||LA12_6=='_'||(LA12_6>='a' && LA12_6<='z')) ) {
                alt12=6;
            }
            else {
                alt12=13;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
            alt12=6;
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=7;
                }
                break;
            case '*':
                {
                alt12=10;
                }
                break;
            default:
                alt12=13;}

        }
        else if ( (LA12_0=='\"') ) {
            int LA12_9 = input.LA(2);

            if ( ((LA12_9>='\u0000' && LA12_9<='\uFFFE')) ) {
                alt12=8;
            }
            else {
                alt12=13;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_10 = input.LA(2);

            if ( ((LA12_10>='\u0000' && LA12_10<='\uFFFE')) ) {
                alt12=8;
            }
            else {
                alt12=13;}
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=9;
        }
        else if ( (LA12_0=='<') ) {
            int LA12_12 = input.LA(2);

            if ( (LA12_12=='#') ) {
                alt12=11;
            }
            else {
                alt12=13;}
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=12;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='#' && LA12_0<='&')||LA12_0=='*'||LA12_0==','||LA12_0=='.'||(LA12_0>=':' && LA12_0<=';')||(LA12_0>='=' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12=13;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | RULE_ID | RULE_SL_COMMENT | RULE_STRING | RULE_INT | RULE_ML_COMMENT | RULE_LEXER_BODY | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:30: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:38: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:54: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:66: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:75: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 11 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:91: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 12 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:107: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 13 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:115: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}