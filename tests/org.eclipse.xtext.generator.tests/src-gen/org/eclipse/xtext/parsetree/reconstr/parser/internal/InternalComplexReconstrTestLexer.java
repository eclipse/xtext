// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g 2008-05-21 14:00:32

package org.eclipse.xtext.parsetree.reconstr.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalComplexReconstrTestLexer extends Lexer {
    public static final int RULE_ML_COMMENT=5;
    public static final int T14=14;
    public static final int RULE_ID=4;
    public static final int RULE_WS=8;
    public static final int T15=15;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=9;
    public static final int T12=12;
    public static final int Tokens=17;
    public static final int RULE_ANY_OTHER=11;
    public static final int T16=16;
    public static final int RULE_SL_COMMENT=10;
    public static final int T13=13;
    public static final int RULE_LEXER_BODY=7;
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

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:233:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:233:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:233:24: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='.')||(LA1_1>='0' && LA1_1<='\uFFFE')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=')')||(LA1_0>='+' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:233:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
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
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:235:10: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:235:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:235:12: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:235:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:12: '^'
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

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:237:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
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
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:239:17: ( '<#' ( options {greedy=false; } : . )* '#>' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:239:19: '<#' ( options {greedy=false; } : . )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:239:24: ( options {greedy=false; } : . )*
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
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:239:52: .
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

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:241:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:241:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:241:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||LA6_0=='\r'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\'') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("243:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFE')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:65: ~ ( '\\\\' | '\"' )
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
                    	    break loop7;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFE')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:93: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:137: ~ ( '\\\\' | '\\'' )
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
                    	    break loop8;
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

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:245:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:245:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:245:24: (~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:245:24: ~ ( '\\n' | '\\r' )
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

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:245:38: ( '\\r' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:245:38: '\\r'
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
        // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:8: ( T12 | T13 | T14 | T15 | T16 | RULE_ML_COMMENT | RULE_INT | RULE_ID | RULE_LEXER_BODY | RULE_WS | RULE_STRING | RULE_SL_COMMENT | RULE_ANY_OTHER )
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
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt12=6;
                }
                break;
            case '/':
                {
                alt12=12;
                }
                break;
            default:
                alt12=13;}

        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=7;
        }
        else if ( (LA12_0=='^') ) {
            int LA12_8 = input.LA(2);

            if ( ((LA12_8>='A' && LA12_8<='Z')||LA12_8=='_'||(LA12_8>='a' && LA12_8<='z')) ) {
                alt12=8;
            }
            else {
                alt12=13;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
            alt12=8;
        }
        else if ( (LA12_0=='<') ) {
            int LA12_10 = input.LA(2);

            if ( (LA12_10=='#') ) {
                alt12=9;
            }
            else {
                alt12=13;}
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=10;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_12 = input.LA(2);

            if ( ((LA12_12>='\u0000' && LA12_12<='\uFFFE')) ) {
                alt12=11;
            }
            else {
                alt12=13;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_13 = input.LA(2);

            if ( ((LA12_13>='\u0000' && LA12_13<='\uFFFE')) ) {
                alt12=11;
            }
            else {
                alt12=13;}
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='#' && LA12_0<='&')||LA12_0=='*'||LA12_0==','||LA12_0=='.'||(LA12_0>=':' && LA12_0<=';')||(LA12_0>='=' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12=13;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | RULE_ML_COMMENT | RULE_INT | RULE_ID | RULE_LEXER_BODY | RULE_WS | RULE_STRING | RULE_SL_COMMENT | RULE_ANY_OTHER );", 12, 0, input);

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
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:30: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:46: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:55: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:63: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:79: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 11 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:87: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 12 :
                // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:1:99: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

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