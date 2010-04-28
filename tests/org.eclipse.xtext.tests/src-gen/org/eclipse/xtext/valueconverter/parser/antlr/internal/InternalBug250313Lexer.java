package org.eclipse.xtext.valueconverter.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug250313Lexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int Tokens=24;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_STRING=4;
    public static final int RULE_INT=6;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int RULE_WS=9;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T19=19;
    public InternalBug250313Lexer() {;} 
    public InternalBug250313Lexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:10:5: ( '1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:10:7: '1'
            {
            match('1'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:11:5: ( 'mykeyword1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:11:7: 'mykeyword1'
            {
            match("mykeyword1"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:12:5: ( '1+' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:12:7: '1+'
            {
            match("1+"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:13:5: ( '2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:13:7: '2'
            {
            match('2'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:14:5: ( '2+' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:14:7: '2+'
            {
            match("2+"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:15:5: ( '3' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:15:7: '3'
            {
            match('3'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:16:5: ( '3+' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:16:7: '3+'
            {
            match("3+"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:17:5: ( '4' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:17:7: '4'
            {
            match('4'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:18:5: ( '4+' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:18:7: '4+'
            {
            match("4+"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:19:5: ( 'content' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:19:7: 'content'
            {
            match("content"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:20:5: ( 'ref' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:20:7: 'ref'
            {
            match("ref"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:21:5: ( '-' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:21:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:22:5: ( '+' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:22:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:785:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:785:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:785:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:785:11: '^'
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:785:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:787:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:787:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:787:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:787:13: '0' .. '9'
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("789:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:789:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:791:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:791:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:791:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:791:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:793:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:793:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:793:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:793:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:793:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:793:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:793:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:793:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:795:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:795:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:795:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:797:16: ( . )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:797:18: .
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
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=20;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='1') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0=='m') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='2') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0=='3') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='4') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='c') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0=='r') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0=='-') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0=='+') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper010();
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='b')||(LA12_0>='d' && LA12_0<='l')||(LA12_0>='n' && LA12_0<='q')||(LA12_0>='s' && LA12_0<='z')) ) {
            alt12 = mTokensHelper011();
        }
        else if ( (LA12_0=='0'||(LA12_0>='5' && LA12_0<='9')) ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper015();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper016();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='*')||LA12_0==','||LA12_0=='.'||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper017();
        }
        else {
            alt12 = mTokensHelper018();
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:62: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:70: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:79: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:91: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:107: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:123: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:1:131: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '+':
            {
            return 3;
            }
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
            return 15;
            }
        default:
            return 1;}

    }

    private int mTokensHelper002() throws RecognitionException {
        int LA12_2 = input.LA(2);

        if ( (LA12_2=='y') ) {
            int LA12_21 = input.LA(3);

            if ( (LA12_21=='k') ) {
                int LA12_37 = input.LA(4);

                if ( (LA12_37=='e') ) {
                    int LA12_40 = input.LA(5);

                    if ( (LA12_40=='y') ) {
                        int LA12_43 = input.LA(6);

                        if ( (LA12_43=='w') ) {
                            int LA12_45 = input.LA(7);

                            if ( (LA12_45=='o') ) {
                                int LA12_47 = input.LA(8);

                                if ( (LA12_47=='r') ) {
                                    int LA12_49 = input.LA(9);

                                    if ( (LA12_49=='d') ) {
                                        int LA12_51 = input.LA(10);

                                        if ( (LA12_51=='1') ) {
                                            int LA12_52 = input.LA(11);

                                            if ( ((LA12_52>='0' && LA12_52<='9')||(LA12_52>='A' && LA12_52<='Z')||LA12_52=='_'||(LA12_52>='a' && LA12_52<='z')) ) {
                                                return 14;
                                            }
                                            else {
                                                return 2;}
                                        }
                                        else {
                                            return 14;}
                                    }
                                    else {
                                        return 14;}
                                }
                                else {
                                    return 14;}
                            }
                            else {
                                return 14;}
                        }
                        else {
                            return 14;}
                    }
                    else {
                        return 14;}
                }
                else {
                    return 14;}
            }
            else {
                return 14;}
        }
        else {
            return 14;}
    }

    private int mTokensHelper003() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '+':
            {
            return 5;
            }
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
            return 15;
            }
        default:
            return 4;}

    }

    private int mTokensHelper004() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '+':
            {
            return 7;
            }
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
            return 15;
            }
        default:
            return 6;}

    }

    private int mTokensHelper005() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '+':
            {
            return 9;
            }
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
            return 15;
            }
        default:
            return 8;}

    }

    private int mTokensHelper006() throws RecognitionException {
        int LA12_6 = input.LA(2);

        if ( (LA12_6=='o') ) {
            int LA12_29 = input.LA(3);

            if ( (LA12_29=='n') ) {
                int LA12_38 = input.LA(4);

                if ( (LA12_38=='t') ) {
                    int LA12_41 = input.LA(5);

                    if ( (LA12_41=='e') ) {
                        int LA12_44 = input.LA(6);

                        if ( (LA12_44=='n') ) {
                            int LA12_46 = input.LA(7);

                            if ( (LA12_46=='t') ) {
                                int LA12_48 = input.LA(8);

                                if ( ((LA12_48>='0' && LA12_48<='9')||(LA12_48>='A' && LA12_48<='Z')||LA12_48=='_'||(LA12_48>='a' && LA12_48<='z')) ) {
                                    return 14;
                                }
                                else {
                                    return 10;}
                            }
                            else {
                                return 14;}
                        }
                        else {
                            return 14;}
                    }
                    else {
                        return 14;}
                }
                else {
                    return 14;}
            }
            else {
                return 14;}
        }
        else {
            return 14;}
    }

    private int mTokensHelper007() throws RecognitionException {
        int LA12_7 = input.LA(2);

        if ( (LA12_7=='e') ) {
            int LA12_30 = input.LA(3);

            if ( (LA12_30=='f') ) {
                int LA12_39 = input.LA(4);

                if ( ((LA12_39>='0' && LA12_39<='9')||(LA12_39>='A' && LA12_39<='Z')||LA12_39=='_'||(LA12_39>='a' && LA12_39<='z')) ) {
                    return 14;
                }
                else {
                    return 11;}
            }
            else {
                return 14;}
        }
        else {
            return 14;}
    }

    private int mTokensHelper008() throws RecognitionException {
        return 12;
    }

    private int mTokensHelper009() throws RecognitionException {
        return 13;
    }

    private int mTokensHelper010() throws RecognitionException {
        int LA12_10 = input.LA(2);

        if ( ((LA12_10>='A' && LA12_10<='Z')||LA12_10=='_'||(LA12_10>='a' && LA12_10<='z')) ) {
            return 14;
        }
        else {
            return 20;}
    }

    private int mTokensHelper011() throws RecognitionException {
        return 14;
    }

    private int mTokensHelper012() throws RecognitionException {
        return 15;
    }

    private int mTokensHelper013() throws RecognitionException {
        int LA12_13 = input.LA(2);

        if ( ((LA12_13>='\u0000' && LA12_13<='\uFFFE')) ) {
            return 16;
        }
        else {
            return 20;}
    }

    private int mTokensHelper014() throws RecognitionException {
        int LA12_14 = input.LA(2);

        if ( ((LA12_14>='\u0000' && LA12_14<='\uFFFE')) ) {
            return 16;
        }
        else {
            return 20;}
    }

    private int mTokensHelper015() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '/':
            {
            return 18;
            }
        case '*':
            {
            return 17;
            }
        default:
            return 20;}

    }

    private int mTokensHelper016() throws RecognitionException {
        return 19;
    }

    private int mTokensHelper017() throws RecognitionException {
        return 20;
    }

    private int mTokensHelper018() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}