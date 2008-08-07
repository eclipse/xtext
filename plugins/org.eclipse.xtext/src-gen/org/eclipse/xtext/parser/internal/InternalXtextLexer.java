// $ANTLR 3.0.1 ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g 2008-08-07 16:58:39

package org.eclipse.xtext.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=7;
    public static final int T14=14;
    public static final int T29=29;
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T11=11;
    public static final int T36=36;
    public static final int RULE_STRING=5;
    public static final int T12=12;
    public static final int T28=28;
    public static final int T23=23;
    public static final int T35=35;
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
    public static final int Tokens=37;
    public static final int T31=31;
    public static final int RULE_ANY_OTHER=10;
    public static final int T16=16;
    public static final int T27=27;
    public static final int RULE_SL_COMMENT=8;
    public static final int T30=30;
    public static final int T24=24;
    public static final int T19=19;
    public InternalXtextLexer() {;} 
    public InternalXtextLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:10:5: ( 'abstract language' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:10:7: 'abstract language'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:11:5: ( 'language' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:11:7: 'language'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:12:5: ( '.' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:12:7: '.'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:13:5: ( 'extends' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:13:7: 'extends'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:14:5: ( 'lexing' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:14:7: 'lexing'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:15:5: ( ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:15:7: ':'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:16:5: ( 'generate' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:16:7: 'generate'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:17:5: ( 'as' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:17:7: 'as'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:18:5: ( 'import' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:18:7: 'import'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:19:5: ( 'returns' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:19:7: 'returns'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:20:5: ( ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:20:7: ';'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:21:5: ( '::' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:21:7: '::'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:22:5: ( '|' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:22:7: '|'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:23:5: ( '?' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:23:7: '?'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:24:5: ( '*' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:24:7: '*'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:25:5: ( '+' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:25:7: '+'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:26:5: ( '+=' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:26:7: '+='
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:27:5: ( '=' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:27:7: '='
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:28:5: ( '?=' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:28:7: '?='
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:29:5: ( '{' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:29:7: '{'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:30:5: ( 'current' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:30:7: 'current'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:31:5: ( '}' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:31:7: '}'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:32:5: ( '[' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:32:7: '['
            {
            match('['); 

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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:33:5: ( ']' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:33:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:34:5: ( '(' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:34:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:35:5: ( ')' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:35:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1139:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1139:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1139:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1139:12: '^'
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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1139:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1141:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1141:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1141:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1141:13: '0' .. '9'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1143:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
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
                    new NoViableAltException("1143:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1143:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1143:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
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
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1143:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1143:65: ~ ( '\\\\' | '\"' )
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
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1143:101: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1143:106: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
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
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1143:108: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1143:152: ~ ( '\\\\' | '\\'' )
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1145:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1145:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1145:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1145:52: .
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1147:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1147:19: '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1147:24: (~ ( '\\n' | '\\r' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1147:24: ~ ( '\\n' | '\\r' )
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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1147:38: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1147:39: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1147:39: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1147:39: '\\r'
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1149:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1149:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1149:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1151:16: ( . )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1151:18: .
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
        // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=33;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='a') ) {
            switch ( input.LA(2) ) {
            case 'b':
                {
                int LA12_30 = input.LA(3);

                if ( (LA12_30=='s') ) {
                    int LA12_62 = input.LA(4);

                    if ( (LA12_62=='t') ) {
                        int LA12_71 = input.LA(5);

                        if ( (LA12_71=='r') ) {
                            int LA12_79 = input.LA(6);

                            if ( (LA12_79=='a') ) {
                                int LA12_87 = input.LA(7);

                                if ( (LA12_87=='c') ) {
                                    int LA12_95 = input.LA(8);

                                    if ( (LA12_95=='t') ) {
                                        int LA12_103 = input.LA(9);

                                        if ( (LA12_103==' ') ) {
                                            alt12=1;
                                        }
                                        else {
                                            alt12=27;}
                                    }
                                    else {
                                        alt12=27;}
                                }
                                else {
                                    alt12=27;}
                            }
                            else {
                                alt12=27;}
                        }
                        else {
                            alt12=27;}
                    }
                    else {
                        alt12=27;}
                }
                else {
                    alt12=27;}
                }
                break;
            case 's':
                {
                int LA12_31 = input.LA(3);

                if ( ((LA12_31>='0' && LA12_31<='9')||(LA12_31>='A' && LA12_31<='Z')||LA12_31=='_'||(LA12_31>='a' && LA12_31<='z')) ) {
                    alt12=27;
                }
                else {
                    alt12=8;}
                }
                break;
            default:
                alt12=27;}

        }
        else if ( (LA12_0=='l') ) {
            switch ( input.LA(2) ) {
            case 'a':
                {
                int LA12_33 = input.LA(3);

                if ( (LA12_33=='n') ) {
                    int LA12_64 = input.LA(4);

                    if ( (LA12_64=='g') ) {
                        int LA12_72 = input.LA(5);

                        if ( (LA12_72=='u') ) {
                            int LA12_80 = input.LA(6);

                            if ( (LA12_80=='a') ) {
                                int LA12_88 = input.LA(7);

                                if ( (LA12_88=='g') ) {
                                    int LA12_96 = input.LA(8);

                                    if ( (LA12_96=='e') ) {
                                        int LA12_104 = input.LA(9);

                                        if ( ((LA12_104>='0' && LA12_104<='9')||(LA12_104>='A' && LA12_104<='Z')||LA12_104=='_'||(LA12_104>='a' && LA12_104<='z')) ) {
                                            alt12=27;
                                        }
                                        else {
                                            alt12=2;}
                                    }
                                    else {
                                        alt12=27;}
                                }
                                else {
                                    alt12=27;}
                            }
                            else {
                                alt12=27;}
                        }
                        else {
                            alt12=27;}
                    }
                    else {
                        alt12=27;}
                }
                else {
                    alt12=27;}
                }
                break;
            case 'e':
                {
                int LA12_34 = input.LA(3);

                if ( (LA12_34=='x') ) {
                    int LA12_65 = input.LA(4);

                    if ( (LA12_65=='i') ) {
                        int LA12_73 = input.LA(5);

                        if ( (LA12_73=='n') ) {
                            int LA12_81 = input.LA(6);

                            if ( (LA12_81=='g') ) {
                                int LA12_89 = input.LA(7);

                                if ( ((LA12_89>='0' && LA12_89<='9')||(LA12_89>='A' && LA12_89<='Z')||LA12_89=='_'||(LA12_89>='a' && LA12_89<='z')) ) {
                                    alt12=27;
                                }
                                else {
                                    alt12=5;}
                            }
                            else {
                                alt12=27;}
                        }
                        else {
                            alt12=27;}
                    }
                    else {
                        alt12=27;}
                }
                else {
                    alt12=27;}
                }
                break;
            default:
                alt12=27;}

        }
        else if ( (LA12_0=='.') ) {
            alt12=3;
        }
        else if ( (LA12_0=='e') ) {
            int LA12_4 = input.LA(2);

            if ( (LA12_4=='x') ) {
                int LA12_36 = input.LA(3);

                if ( (LA12_36=='t') ) {
                    int LA12_66 = input.LA(4);

                    if ( (LA12_66=='e') ) {
                        int LA12_74 = input.LA(5);

                        if ( (LA12_74=='n') ) {
                            int LA12_82 = input.LA(6);

                            if ( (LA12_82=='d') ) {
                                int LA12_90 = input.LA(7);

                                if ( (LA12_90=='s') ) {
                                    int LA12_98 = input.LA(8);

                                    if ( ((LA12_98>='0' && LA12_98<='9')||(LA12_98>='A' && LA12_98<='Z')||LA12_98=='_'||(LA12_98>='a' && LA12_98<='z')) ) {
                                        alt12=27;
                                    }
                                    else {
                                        alt12=4;}
                                }
                                else {
                                    alt12=27;}
                            }
                            else {
                                alt12=27;}
                        }
                        else {
                            alt12=27;}
                    }
                    else {
                        alt12=27;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
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
                int LA12_39 = input.LA(3);

                if ( (LA12_39=='n') ) {
                    int LA12_67 = input.LA(4);

                    if ( (LA12_67=='e') ) {
                        int LA12_75 = input.LA(5);

                        if ( (LA12_75=='r') ) {
                            int LA12_83 = input.LA(6);

                            if ( (LA12_83=='a') ) {
                                int LA12_91 = input.LA(7);

                                if ( (LA12_91=='t') ) {
                                    int LA12_99 = input.LA(8);

                                    if ( (LA12_99=='e') ) {
                                        int LA12_106 = input.LA(9);

                                        if ( ((LA12_106>='0' && LA12_106<='9')||(LA12_106>='A' && LA12_106<='Z')||LA12_106=='_'||(LA12_106>='a' && LA12_106<='z')) ) {
                                            alt12=27;
                                        }
                                        else {
                                            alt12=7;}
                                    }
                                    else {
                                        alt12=27;}
                                }
                                else {
                                    alt12=27;}
                            }
                            else {
                                alt12=27;}
                        }
                        else {
                            alt12=27;}
                    }
                    else {
                        alt12=27;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
        }
        else if ( (LA12_0=='i') ) {
            int LA12_7 = input.LA(2);

            if ( (LA12_7=='m') ) {
                int LA12_40 = input.LA(3);

                if ( (LA12_40=='p') ) {
                    int LA12_68 = input.LA(4);

                    if ( (LA12_68=='o') ) {
                        int LA12_76 = input.LA(5);

                        if ( (LA12_76=='r') ) {
                            int LA12_84 = input.LA(6);

                            if ( (LA12_84=='t') ) {
                                int LA12_92 = input.LA(7);

                                if ( ((LA12_92>='0' && LA12_92<='9')||(LA12_92>='A' && LA12_92<='Z')||LA12_92=='_'||(LA12_92>='a' && LA12_92<='z')) ) {
                                    alt12=27;
                                }
                                else {
                                    alt12=9;}
                            }
                            else {
                                alt12=27;}
                        }
                        else {
                            alt12=27;}
                    }
                    else {
                        alt12=27;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
        }
        else if ( (LA12_0=='r') ) {
            int LA12_8 = input.LA(2);

            if ( (LA12_8=='e') ) {
                int LA12_41 = input.LA(3);

                if ( (LA12_41=='t') ) {
                    int LA12_69 = input.LA(4);

                    if ( (LA12_69=='u') ) {
                        int LA12_77 = input.LA(5);

                        if ( (LA12_77=='r') ) {
                            int LA12_85 = input.LA(6);

                            if ( (LA12_85=='n') ) {
                                int LA12_93 = input.LA(7);

                                if ( (LA12_93=='s') ) {
                                    int LA12_101 = input.LA(8);

                                    if ( ((LA12_101>='0' && LA12_101<='9')||(LA12_101>='A' && LA12_101<='Z')||LA12_101=='_'||(LA12_101>='a' && LA12_101<='z')) ) {
                                        alt12=27;
                                    }
                                    else {
                                        alt12=10;}
                                }
                                else {
                                    alt12=27;}
                            }
                            else {
                                alt12=27;}
                        }
                        else {
                            alt12=27;}
                    }
                    else {
                        alt12=27;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
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
                int LA12_51 = input.LA(3);

                if ( (LA12_51=='r') ) {
                    int LA12_70 = input.LA(4);

                    if ( (LA12_70=='r') ) {
                        int LA12_78 = input.LA(5);

                        if ( (LA12_78=='e') ) {
                            int LA12_86 = input.LA(6);

                            if ( (LA12_86=='n') ) {
                                int LA12_94 = input.LA(7);

                                if ( (LA12_94=='t') ) {
                                    int LA12_102 = input.LA(8);

                                    if ( ((LA12_102>='0' && LA12_102<='9')||(LA12_102>='A' && LA12_102<='Z')||LA12_102=='_'||(LA12_102>='a' && LA12_102<='z')) ) {
                                        alt12=27;
                                    }
                                    else {
                                        alt12=21;}
                                }
                                else {
                                    alt12=27;}
                            }
                            else {
                                alt12=27;}
                        }
                        else {
                            alt12=27;}
                    }
                    else {
                        alt12=27;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
        }
        else if ( (LA12_0=='}') ) {
            alt12=22;
        }
        else if ( (LA12_0=='[') ) {
            alt12=23;
        }
        else if ( (LA12_0==']') ) {
            alt12=24;
        }
        else if ( (LA12_0=='(') ) {
            alt12=25;
        }
        else if ( (LA12_0==')') ) {
            alt12=26;
        }
        else if ( (LA12_0=='^') ) {
            int LA12_22 = input.LA(2);

            if ( ((LA12_22>='A' && LA12_22<='Z')||LA12_22=='_'||(LA12_22>='a' && LA12_22<='z')) ) {
                alt12=27;
            }
            else {
                alt12=33;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||LA12_0=='d'||LA12_0=='f'||LA12_0=='h'||(LA12_0>='j' && LA12_0<='k')||(LA12_0>='m' && LA12_0<='q')||(LA12_0>='s' && LA12_0<='z')) ) {
            alt12=27;
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=28;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_25 = input.LA(2);

            if ( ((LA12_25>='\u0000' && LA12_25<='\uFFFE')) ) {
                alt12=29;
            }
            else {
                alt12=33;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_26 = input.LA(2);

            if ( ((LA12_26>='\u0000' && LA12_26<='\uFFFE')) ) {
                alt12=29;
            }
            else {
                alt12=33;}
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=31;
                }
                break;
            case '*':
                {
                alt12=30;
                }
                break;
            default:
                alt12=33;}

        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=32;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>=',' && LA12_0<='-')||LA12_0=='<'||LA12_0=='>'||LA12_0=='@'||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12=33;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

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
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:114: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:122: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:131: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:143: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:159: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:175: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:1:183: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}