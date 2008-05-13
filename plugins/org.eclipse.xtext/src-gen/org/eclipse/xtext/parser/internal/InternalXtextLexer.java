// $ANTLR 3.0 ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g 2008-05-13 15:03:13

package org.eclipse.xtext.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=8;
    public static final int T14=14;
    public static final int T29=29;
    public static final int RULE_ID=4;
    public static final int T22=22;
    public static final int T11=11;
    public static final int RULE_STRING=5;
    public static final int T12=12;
    public static final int T28=28;
    public static final int T23=23;
    public static final int T13=13;
    public static final int T20=20;
    public static final int T25=25;
    public static final int T18=18;
    public static final int RULE_WS=9;
    public static final int T26=26;
    public static final int T15=15;
    public static final int RULE_INT=7;
    public static final int EOF=-1;
    public static final int T17=17;
    public static final int Tokens=32;
    public static final int T31=31;
    public static final int T16=16;
    public static final int T27=27;
    public static final int RULE_SL_COMMENT=10;
    public static final int T30=30;
    public static final int T24=24;
    public static final int T19=19;
    public static final int RULE_LEXER_BODY=6;
    public InternalXtextLexer() {;} 
    public InternalXtextLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g"; }

    // $ANTLR start T11
    public void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:6:7: ( 'lexing' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:6:7: 'lexing'
            {
            match("lexing"); 


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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:7:7: ( ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:7:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:8:7: ( 'generate' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:8:7: 'generate'
            {
            match("generate"); 


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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:9:7: ( 'as' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:9:7: 'as'
            {
            match("as"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:10:7: ( 'import' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:10:7: 'import'
            {
            match("import"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:11:7: ( 'returns' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:11:7: 'returns'
            {
            match("returns"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:12:7: ( ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:12:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:13:7: ( '::' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:13:7: '::'
            {
            match("::"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:14:7: ( '|' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:14:7: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:15:7: ( '?' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:15:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:16:7: ( '*' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:16:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:17:7: ( '+' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:17:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:18:7: ( '+=' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:18:7: '+='
            {
            match("+="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:19:7: ( '=' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:19:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:20:7: ( '?=' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:20:7: '?='
            {
            match("?="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:21:7: ( '{' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:21:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:22:7: ( 'current' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:22:7: 'current'
            {
            match("current"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:23:7: ( '.' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:23:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:24:7: ( '}' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:24:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:25:7: ( '(' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:25:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:26:7: ( ')' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:26:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start RULE_STRING
    public void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:281:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
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
                    new NoViableAltException("281:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:281:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:281:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
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
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:281:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:281:65: ~ ( '\\\\' | '\"' )
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
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:282:2: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:282:7: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
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
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:282:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:282:53: ~ ( '\\\\' | '\\'' )
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

    // $ANTLR start RULE_ID
    public void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:284:11: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:284:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:284:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:284:12: '^'
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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:284:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:
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
            	    break loop5;
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:286:19: ( '<#' ( options {greedy=false; } : . )* '#>' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:286:19: '<#' ( options {greedy=false; } : . )* '#>'
            {
            match("<#"); 

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:286:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:286:52: .
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

    // $ANTLR start RULE_INT
    public void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:288:12: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:288:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:288:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:288:13: '0' .. '9'
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

    // $ANTLR start RULE_ML_COMMENT
    public void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:290:19: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:290:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:290:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:290:52: .
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

    // $ANTLR start RULE_WS
    public void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:292:11: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:292:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:292:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:
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
    public void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:294:19: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:294:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:294:24: (~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:294:24: ~ ( '\\n' | '\\r' )
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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:294:38: ( '\\r' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:294:38: '\\r'
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

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:10: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | RULE_STRING | RULE_ID | RULE_LEXER_BODY | RULE_INT | RULE_ML_COMMENT | RULE_WS | RULE_SL_COMMENT )
        int alt12=28;
        switch ( input.LA(1) ) {
        case 'l':
            {
            int LA12_1 = input.LA(2);

            if ( (LA12_1=='e') ) {
                int LA12_25 = input.LA(3);

                if ( (LA12_25=='x') ) {
                    int LA12_39 = input.LA(4);

                    if ( (LA12_39=='i') ) {
                        int LA12_45 = input.LA(5);

                        if ( (LA12_45=='n') ) {
                            int LA12_50 = input.LA(6);

                            if ( (LA12_50=='g') ) {
                                int LA12_55 = input.LA(7);

                                if ( ((LA12_55>='0' && LA12_55<='9')||(LA12_55>='A' && LA12_55<='Z')||LA12_55=='_'||(LA12_55>='a' && LA12_55<='z')) ) {
                                    alt12=23;
                                }
                                else {
                                    alt12=1;}
                            }
                            else {
                                alt12=23;}
                        }
                        else {
                            alt12=23;}
                    }
                    else {
                        alt12=23;}
                }
                else {
                    alt12=23;}
            }
            else {
                alt12=23;}
            }
            break;
        case ':':
            {
            int LA12_2 = input.LA(2);

            if ( (LA12_2==':') ) {
                alt12=8;
            }
            else {
                alt12=2;}
            }
            break;
        case 'g':
            {
            int LA12_3 = input.LA(2);

            if ( (LA12_3=='e') ) {
                int LA12_28 = input.LA(3);

                if ( (LA12_28=='n') ) {
                    int LA12_40 = input.LA(4);

                    if ( (LA12_40=='e') ) {
                        int LA12_46 = input.LA(5);

                        if ( (LA12_46=='r') ) {
                            int LA12_51 = input.LA(6);

                            if ( (LA12_51=='a') ) {
                                int LA12_56 = input.LA(7);

                                if ( (LA12_56=='t') ) {
                                    int LA12_61 = input.LA(8);

                                    if ( (LA12_61=='e') ) {
                                        int LA12_65 = input.LA(9);

                                        if ( ((LA12_65>='0' && LA12_65<='9')||(LA12_65>='A' && LA12_65<='Z')||LA12_65=='_'||(LA12_65>='a' && LA12_65<='z')) ) {
                                            alt12=23;
                                        }
                                        else {
                                            alt12=3;}
                                    }
                                    else {
                                        alt12=23;}
                                }
                                else {
                                    alt12=23;}
                            }
                            else {
                                alt12=23;}
                        }
                        else {
                            alt12=23;}
                    }
                    else {
                        alt12=23;}
                }
                else {
                    alt12=23;}
            }
            else {
                alt12=23;}
            }
            break;
        case 'a':
            {
            int LA12_4 = input.LA(2);

            if ( (LA12_4=='s') ) {
                int LA12_29 = input.LA(3);

                if ( ((LA12_29>='0' && LA12_29<='9')||(LA12_29>='A' && LA12_29<='Z')||LA12_29=='_'||(LA12_29>='a' && LA12_29<='z')) ) {
                    alt12=23;
                }
                else {
                    alt12=4;}
            }
            else {
                alt12=23;}
            }
            break;
        case 'i':
            {
            int LA12_5 = input.LA(2);

            if ( (LA12_5=='m') ) {
                int LA12_30 = input.LA(3);

                if ( (LA12_30=='p') ) {
                    int LA12_42 = input.LA(4);

                    if ( (LA12_42=='o') ) {
                        int LA12_47 = input.LA(5);

                        if ( (LA12_47=='r') ) {
                            int LA12_52 = input.LA(6);

                            if ( (LA12_52=='t') ) {
                                int LA12_57 = input.LA(7);

                                if ( ((LA12_57>='0' && LA12_57<='9')||(LA12_57>='A' && LA12_57<='Z')||LA12_57=='_'||(LA12_57>='a' && LA12_57<='z')) ) {
                                    alt12=23;
                                }
                                else {
                                    alt12=5;}
                            }
                            else {
                                alt12=23;}
                        }
                        else {
                            alt12=23;}
                    }
                    else {
                        alt12=23;}
                }
                else {
                    alt12=23;}
            }
            else {
                alt12=23;}
            }
            break;
        case 'r':
            {
            int LA12_6 = input.LA(2);

            if ( (LA12_6=='e') ) {
                int LA12_31 = input.LA(3);

                if ( (LA12_31=='t') ) {
                    int LA12_43 = input.LA(4);

                    if ( (LA12_43=='u') ) {
                        int LA12_48 = input.LA(5);

                        if ( (LA12_48=='r') ) {
                            int LA12_53 = input.LA(6);

                            if ( (LA12_53=='n') ) {
                                int LA12_58 = input.LA(7);

                                if ( (LA12_58=='s') ) {
                                    int LA12_63 = input.LA(8);

                                    if ( ((LA12_63>='0' && LA12_63<='9')||(LA12_63>='A' && LA12_63<='Z')||LA12_63=='_'||(LA12_63>='a' && LA12_63<='z')) ) {
                                        alt12=23;
                                    }
                                    else {
                                        alt12=6;}
                                }
                                else {
                                    alt12=23;}
                            }
                            else {
                                alt12=23;}
                        }
                        else {
                            alt12=23;}
                    }
                    else {
                        alt12=23;}
                }
                else {
                    alt12=23;}
            }
            else {
                alt12=23;}
            }
            break;
        case ';':
            {
            alt12=7;
            }
            break;
        case '|':
            {
            alt12=9;
            }
            break;
        case '?':
            {
            int LA12_9 = input.LA(2);

            if ( (LA12_9=='=') ) {
                alt12=15;
            }
            else {
                alt12=10;}
            }
            break;
        case '*':
            {
            alt12=11;
            }
            break;
        case '+':
            {
            int LA12_11 = input.LA(2);

            if ( (LA12_11=='=') ) {
                alt12=13;
            }
            else {
                alt12=12;}
            }
            break;
        case '=':
            {
            alt12=14;
            }
            break;
        case '{':
            {
            alt12=16;
            }
            break;
        case 'c':
            {
            int LA12_14 = input.LA(2);

            if ( (LA12_14=='u') ) {
                int LA12_36 = input.LA(3);

                if ( (LA12_36=='r') ) {
                    int LA12_44 = input.LA(4);

                    if ( (LA12_44=='r') ) {
                        int LA12_49 = input.LA(5);

                        if ( (LA12_49=='e') ) {
                            int LA12_54 = input.LA(6);

                            if ( (LA12_54=='n') ) {
                                int LA12_59 = input.LA(7);

                                if ( (LA12_59=='t') ) {
                                    int LA12_64 = input.LA(8);

                                    if ( ((LA12_64>='0' && LA12_64<='9')||(LA12_64>='A' && LA12_64<='Z')||LA12_64=='_'||(LA12_64>='a' && LA12_64<='z')) ) {
                                        alt12=23;
                                    }
                                    else {
                                        alt12=17;}
                                }
                                else {
                                    alt12=23;}
                            }
                            else {
                                alt12=23;}
                        }
                        else {
                            alt12=23;}
                    }
                    else {
                        alt12=23;}
                }
                else {
                    alt12=23;}
            }
            else {
                alt12=23;}
            }
            break;
        case '.':
            {
            alt12=18;
            }
            break;
        case '}':
            {
            alt12=19;
            }
            break;
        case '(':
            {
            alt12=20;
            }
            break;
        case ')':
            {
            alt12=21;
            }
            break;
        case '\"':
        case '\'':
            {
            alt12=22;
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
        case 'b':
        case 'd':
        case 'e':
        case 'f':
        case 'h':
        case 'j':
        case 'k':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt12=23;
            }
            break;
        case '<':
            {
            alt12=24;
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
            alt12=25;
            }
            break;
        case '/':
            {
            int LA12_23 = input.LA(2);

            if ( (LA12_23=='*') ) {
                alt12=26;
            }
            else if ( (LA12_23=='/') ) {
                alt12=28;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | RULE_STRING | RULE_ID | RULE_LEXER_BODY | RULE_INT | RULE_ML_COMMENT | RULE_WS | RULE_SL_COMMENT );", 12, 23, input);

                throw nvae;
            }
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt12=27;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | RULE_STRING | RULE_ID | RULE_LEXER_BODY | RULE_INT | RULE_ML_COMMENT | RULE_WS | RULE_SL_COMMENT );", 12, 0, input);

            throw nvae;
        }

        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:94: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:106: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:114: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:130: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:139: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:155: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:163: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


 

}