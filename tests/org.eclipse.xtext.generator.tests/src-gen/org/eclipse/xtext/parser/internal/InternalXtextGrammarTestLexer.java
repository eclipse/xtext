// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g 2008-07-18 09:17:18

package org.eclipse.xtext.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarTestLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=7;
    public static final int T14=14;
    public static final int T29=29;
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T11=11;
    public static final int RULE_STRING=5;
    public static final int T12=12;
    public static final int T28=28;
    public static final int T23=23;
    public static final int T13=13;
    public static final int T34=34;
    public static final int T20=20;
    public static final int T25=25;
    public static final int T18=18;
    public static final int RULE_WS=9;
    public static final int T26=26;
    public static final int T15=15;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T32=32;
    public static final int T17=17;
    public static final int Tokens=35;
    public static final int T31=31;
    public static final int RULE_ANY_OTHER=10;
    public static final int T16=16;
    public static final int T27=27;
    public static final int RULE_SL_COMMENT=8;
    public static final int T30=30;
    public static final int T24=24;
    public static final int T19=19;
    public InternalXtextGrammarTestLexer() {;} 
    public InternalXtextGrammarTestLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:10:5: ( 'abstract language' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:10:7: 'abstract language'
            {
            match("abstract language"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:11:5: ( 'language' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:11:7: 'language'
            {
            match("language"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:12:5: ( '.' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:12:7: '.'
            {
            match('.'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:13:5: ( 'extends' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:13:7: 'extends'
            {
            match("extends"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:14:5: ( 'lexing' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:14:7: 'lexing'
            {
            match("lexing"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:15:5: ( ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:15:7: ':'
            {
            match(':'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:16:5: ( 'generate' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:16:7: 'generate'
            {
            match("generate"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:17:5: ( 'as' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:17:7: 'as'
            {
            match("as"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:18:5: ( 'import' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:18:7: 'import'
            {
            match("import"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:19:5: ( 'returns' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:19:7: 'returns'
            {
            match("returns"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:20:5: ( ';' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:20:7: ';'
            {
            match(';'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:21:5: ( '::' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:21:7: '::'
            {
            match("::"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:22:5: ( '|' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:22:7: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:23:5: ( '?' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:23:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:24:5: ( '*' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:24:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:25:5: ( '+' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:25:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:26:5: ( '+=' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:26:7: '+='
            {
            match("+="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:27:5: ( '=' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:27:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:28:5: ( '?=' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:28:7: '?='
            {
            match("?="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:29:5: ( '{' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:29:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:30:5: ( 'current' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:30:7: 'current'
            {
            match("current"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:31:5: ( '}' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:31:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:32:5: ( '(' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:32:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:33:5: ( ')' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:33:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1065:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1065:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1065:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1065:12: '^'
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

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1065:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:
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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1067:10: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1067:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1067:12: ( '0' .. '9' )+
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
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1067:13: '0' .. '9'
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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1069:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
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
                    new NoViableAltException("1069:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1069:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1069:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1069:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1069:65: ~ ( '\\\\' | '\"' )
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
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1069:101: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1069:106: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1069:108: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1069:152: ~ ( '\\\\' | '\\'' )
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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1071:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1071:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1071:24: ( options {greedy=false; } : . )*
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
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1071:52: .
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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1073:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\r' )? '\\n' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1073:19: '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1073:24: (~ ( '\\n' | '\\r' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1073:24: ~ ( '\\n' | '\\r' )
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

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1073:38: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1073:39: ( '\\r' )? '\\n'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1073:39: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1073:39: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1075:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1075:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1075:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:
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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1077:16: ( . )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1077:18: .
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
        // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=31;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='a') ) {
            switch ( input.LA(2) ) {
            case 's':
                {
                int LA12_28 = input.LA(3);

                if ( ((LA12_28>='0' && LA12_28<='9')||(LA12_28>='A' && LA12_28<='Z')||LA12_28=='_'||(LA12_28>='a' && LA12_28<='z')) ) {
                    alt12=25;
                }
                else {
                    alt12=8;}
                }
                break;
            case 'b':
                {
                int LA12_29 = input.LA(3);

                if ( (LA12_29=='s') ) {
                    int LA12_59 = input.LA(4);

                    if ( (LA12_59=='t') ) {
                        int LA12_67 = input.LA(5);

                        if ( (LA12_67=='r') ) {
                            int LA12_75 = input.LA(6);

                            if ( (LA12_75=='a') ) {
                                int LA12_83 = input.LA(7);

                                if ( (LA12_83=='c') ) {
                                    int LA12_91 = input.LA(8);

                                    if ( (LA12_91=='t') ) {
                                        int LA12_99 = input.LA(9);

                                        if ( (LA12_99==' ') ) {
                                            alt12=1;
                                        }
                                        else {
                                            alt12=25;}
                                    }
                                    else {
                                        alt12=25;}
                                }
                                else {
                                    alt12=25;}
                            }
                            else {
                                alt12=25;}
                        }
                        else {
                            alt12=25;}
                    }
                    else {
                        alt12=25;}
                }
                else {
                    alt12=25;}
                }
                break;
            default:
                alt12=25;}

        }
        else if ( (LA12_0=='l') ) {
            switch ( input.LA(2) ) {
            case 'e':
                {
                int LA12_31 = input.LA(3);

                if ( (LA12_31=='x') ) {
                    int LA12_60 = input.LA(4);

                    if ( (LA12_60=='i') ) {
                        int LA12_68 = input.LA(5);

                        if ( (LA12_68=='n') ) {
                            int LA12_76 = input.LA(6);

                            if ( (LA12_76=='g') ) {
                                int LA12_84 = input.LA(7);

                                if ( ((LA12_84>='0' && LA12_84<='9')||(LA12_84>='A' && LA12_84<='Z')||LA12_84=='_'||(LA12_84>='a' && LA12_84<='z')) ) {
                                    alt12=25;
                                }
                                else {
                                    alt12=5;}
                            }
                            else {
                                alt12=25;}
                        }
                        else {
                            alt12=25;}
                    }
                    else {
                        alt12=25;}
                }
                else {
                    alt12=25;}
                }
                break;
            case 'a':
                {
                int LA12_32 = input.LA(3);

                if ( (LA12_32=='n') ) {
                    int LA12_61 = input.LA(4);

                    if ( (LA12_61=='g') ) {
                        int LA12_69 = input.LA(5);

                        if ( (LA12_69=='u') ) {
                            int LA12_77 = input.LA(6);

                            if ( (LA12_77=='a') ) {
                                int LA12_85 = input.LA(7);

                                if ( (LA12_85=='g') ) {
                                    int LA12_93 = input.LA(8);

                                    if ( (LA12_93=='e') ) {
                                        int LA12_100 = input.LA(9);

                                        if ( ((LA12_100>='0' && LA12_100<='9')||(LA12_100>='A' && LA12_100<='Z')||LA12_100=='_'||(LA12_100>='a' && LA12_100<='z')) ) {
                                            alt12=25;
                                        }
                                        else {
                                            alt12=2;}
                                    }
                                    else {
                                        alt12=25;}
                                }
                                else {
                                    alt12=25;}
                            }
                            else {
                                alt12=25;}
                        }
                        else {
                            alt12=25;}
                    }
                    else {
                        alt12=25;}
                }
                else {
                    alt12=25;}
                }
                break;
            default:
                alt12=25;}

        }
        else if ( (LA12_0=='.') ) {
            alt12=3;
        }
        else if ( (LA12_0=='e') ) {
            int LA12_4 = input.LA(2);

            if ( (LA12_4=='x') ) {
                int LA12_34 = input.LA(3);

                if ( (LA12_34=='t') ) {
                    int LA12_62 = input.LA(4);

                    if ( (LA12_62=='e') ) {
                        int LA12_70 = input.LA(5);

                        if ( (LA12_70=='n') ) {
                            int LA12_78 = input.LA(6);

                            if ( (LA12_78=='d') ) {
                                int LA12_86 = input.LA(7);

                                if ( (LA12_86=='s') ) {
                                    int LA12_94 = input.LA(8);

                                    if ( ((LA12_94>='0' && LA12_94<='9')||(LA12_94>='A' && LA12_94<='Z')||LA12_94=='_'||(LA12_94>='a' && LA12_94<='z')) ) {
                                        alt12=25;
                                    }
                                    else {
                                        alt12=4;}
                                }
                                else {
                                    alt12=25;}
                            }
                            else {
                                alt12=25;}
                        }
                        else {
                            alt12=25;}
                    }
                    else {
                        alt12=25;}
                }
                else {
                    alt12=25;}
            }
            else {
                alt12=25;}
        }
        else if ( (LA12_0==':') ) {
            int LA12_5 = input.LA(2);

            if ( (LA12_5==':') ) {
                alt12=12;
            }
            else {
                alt12=6;}
        }
        else if ( (LA12_0=='g') ) {
            int LA12_6 = input.LA(2);

            if ( (LA12_6=='e') ) {
                int LA12_37 = input.LA(3);

                if ( (LA12_37=='n') ) {
                    int LA12_63 = input.LA(4);

                    if ( (LA12_63=='e') ) {
                        int LA12_71 = input.LA(5);

                        if ( (LA12_71=='r') ) {
                            int LA12_79 = input.LA(6);

                            if ( (LA12_79=='a') ) {
                                int LA12_87 = input.LA(7);

                                if ( (LA12_87=='t') ) {
                                    int LA12_95 = input.LA(8);

                                    if ( (LA12_95=='e') ) {
                                        int LA12_102 = input.LA(9);

                                        if ( ((LA12_102>='0' && LA12_102<='9')||(LA12_102>='A' && LA12_102<='Z')||LA12_102=='_'||(LA12_102>='a' && LA12_102<='z')) ) {
                                            alt12=25;
                                        }
                                        else {
                                            alt12=7;}
                                    }
                                    else {
                                        alt12=25;}
                                }
                                else {
                                    alt12=25;}
                            }
                            else {
                                alt12=25;}
                        }
                        else {
                            alt12=25;}
                    }
                    else {
                        alt12=25;}
                }
                else {
                    alt12=25;}
            }
            else {
                alt12=25;}
        }
        else if ( (LA12_0=='i') ) {
            int LA12_7 = input.LA(2);

            if ( (LA12_7=='m') ) {
                int LA12_38 = input.LA(3);

                if ( (LA12_38=='p') ) {
                    int LA12_64 = input.LA(4);

                    if ( (LA12_64=='o') ) {
                        int LA12_72 = input.LA(5);

                        if ( (LA12_72=='r') ) {
                            int LA12_80 = input.LA(6);

                            if ( (LA12_80=='t') ) {
                                int LA12_88 = input.LA(7);

                                if ( ((LA12_88>='0' && LA12_88<='9')||(LA12_88>='A' && LA12_88<='Z')||LA12_88=='_'||(LA12_88>='a' && LA12_88<='z')) ) {
                                    alt12=25;
                                }
                                else {
                                    alt12=9;}
                            }
                            else {
                                alt12=25;}
                        }
                        else {
                            alt12=25;}
                    }
                    else {
                        alt12=25;}
                }
                else {
                    alt12=25;}
            }
            else {
                alt12=25;}
        }
        else if ( (LA12_0=='r') ) {
            int LA12_8 = input.LA(2);

            if ( (LA12_8=='e') ) {
                int LA12_39 = input.LA(3);

                if ( (LA12_39=='t') ) {
                    int LA12_65 = input.LA(4);

                    if ( (LA12_65=='u') ) {
                        int LA12_73 = input.LA(5);

                        if ( (LA12_73=='r') ) {
                            int LA12_81 = input.LA(6);

                            if ( (LA12_81=='n') ) {
                                int LA12_89 = input.LA(7);

                                if ( (LA12_89=='s') ) {
                                    int LA12_97 = input.LA(8);

                                    if ( ((LA12_97>='0' && LA12_97<='9')||(LA12_97>='A' && LA12_97<='Z')||LA12_97=='_'||(LA12_97>='a' && LA12_97<='z')) ) {
                                        alt12=25;
                                    }
                                    else {
                                        alt12=10;}
                                }
                                else {
                                    alt12=25;}
                            }
                            else {
                                alt12=25;}
                        }
                        else {
                            alt12=25;}
                    }
                    else {
                        alt12=25;}
                }
                else {
                    alt12=25;}
            }
            else {
                alt12=25;}
        }
        else if ( (LA12_0==';') ) {
            alt12=11;
        }
        else if ( (LA12_0=='|') ) {
            alt12=13;
        }
        else if ( (LA12_0=='?') ) {
            int LA12_11 = input.LA(2);

            if ( (LA12_11=='=') ) {
                alt12=19;
            }
            else {
                alt12=14;}
        }
        else if ( (LA12_0=='*') ) {
            alt12=15;
        }
        else if ( (LA12_0=='+') ) {
            int LA12_13 = input.LA(2);

            if ( (LA12_13=='=') ) {
                alt12=17;
            }
            else {
                alt12=16;}
        }
        else if ( (LA12_0=='=') ) {
            alt12=18;
        }
        else if ( (LA12_0=='{') ) {
            alt12=20;
        }
        else if ( (LA12_0=='c') ) {
            int LA12_16 = input.LA(2);

            if ( (LA12_16=='u') ) {
                int LA12_49 = input.LA(3);

                if ( (LA12_49=='r') ) {
                    int LA12_66 = input.LA(4);

                    if ( (LA12_66=='r') ) {
                        int LA12_74 = input.LA(5);

                        if ( (LA12_74=='e') ) {
                            int LA12_82 = input.LA(6);

                            if ( (LA12_82=='n') ) {
                                int LA12_90 = input.LA(7);

                                if ( (LA12_90=='t') ) {
                                    int LA12_98 = input.LA(8);

                                    if ( ((LA12_98>='0' && LA12_98<='9')||(LA12_98>='A' && LA12_98<='Z')||LA12_98=='_'||(LA12_98>='a' && LA12_98<='z')) ) {
                                        alt12=25;
                                    }
                                    else {
                                        alt12=21;}
                                }
                                else {
                                    alt12=25;}
                            }
                            else {
                                alt12=25;}
                        }
                        else {
                            alt12=25;}
                    }
                    else {
                        alt12=25;}
                }
                else {
                    alt12=25;}
            }
            else {
                alt12=25;}
        }
        else if ( (LA12_0=='}') ) {
            alt12=22;
        }
        else if ( (LA12_0=='(') ) {
            alt12=23;
        }
        else if ( (LA12_0==')') ) {
            alt12=24;
        }
        else if ( (LA12_0=='^') ) {
            int LA12_20 = input.LA(2);

            if ( ((LA12_20>='A' && LA12_20<='Z')||LA12_20=='_'||(LA12_20>='a' && LA12_20<='z')) ) {
                alt12=25;
            }
            else {
                alt12=31;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||LA12_0=='d'||LA12_0=='f'||LA12_0=='h'||(LA12_0>='j' && LA12_0<='k')||(LA12_0>='m' && LA12_0<='q')||(LA12_0>='s' && LA12_0<='z')) ) {
            alt12=25;
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=26;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_23 = input.LA(2);

            if ( ((LA12_23>='\u0000' && LA12_23<='\uFFFE')) ) {
                alt12=27;
            }
            else {
                alt12=31;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_24 = input.LA(2);

            if ( ((LA12_24>='\u0000' && LA12_24<='\uFFFE')) ) {
                alt12=27;
            }
            else {
                alt12=31;}
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt12=28;
                }
                break;
            case '/':
                {
                alt12=29;
                }
                break;
            default:
                alt12=31;}

        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=30;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>=',' && LA12_0<='-')||LA12_0=='<'||LA12_0=='>'||LA12_0=='@'||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12=31;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:106: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 26 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:114: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 27 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:123: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 28 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:135: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 29 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:151: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 30 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:167: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 31 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:175: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}