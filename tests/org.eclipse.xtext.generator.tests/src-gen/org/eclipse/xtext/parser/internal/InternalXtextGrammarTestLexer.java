// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g 2008-06-06 17:58:57

package org.eclipse.xtext.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarTestLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=8;
    public static final int T14=14;
    public static final int T29=29;
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T22=22;
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
    public static final int RULE_WS=10;
    public static final int T26=26;
    public static final int T15=15;
    public static final int RULE_INT=7;
    public static final int EOF=-1;
    public static final int T32=32;
    public static final int T17=17;
    public static final int Tokens=36;
    public static final int T31=31;
    public static final int RULE_ANY_OTHER=11;
    public static final int T16=16;
    public static final int T27=27;
    public static final int RULE_SL_COMMENT=9;
    public static final int T30=30;
    public static final int T24=24;
    public static final int T19=19;
    public static final int RULE_LEXER_BODY=6;


      public Token nextToken() {
            while (true) {
                this.token = null;
                this.channel = Token.DEFAULT_CHANNEL;
                this.tokenStartCharIndex = input.index();
                this.tokenStartCharPositionInLine = input.getCharPositionInLine();
                this.tokenStartLine = input.getLine();
                this.text = null;
                if ( input.LA(1)==CharStream.EOF ) {
                    return Token.EOF_TOKEN;
                }
                try {
                    mTokens();
                    if ( this.token==null ) {
                        emit();
                    }
                    else if ( this.token==Token.SKIP_TOKEN ) {
                        continue;
                    }
                    return this.token;
                }
                catch (RecognitionException re) {
                    reportError(re);
                    if ( re instanceof NoViableAltException ) { recover(re); }
                                    // create token that holds mismatched char
                    Token t = new CommonToken(input, Token.INVALID_TOKEN_TYPE,
                                              Token.HIDDEN_CHANNEL,
                                              this.tokenStartCharIndex,
                                              getCharIndex()-1);
                    t.setLine(this.tokenStartLine);
                    t.setCharPositionInLine(this.tokenStartCharPositionInLine);
                    emit(t);
                    return this.token;
                }
            }
        }

    public InternalXtextGrammarTestLexer() {;} 
    public InternalXtextGrammarTestLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g"; }

    // $ANTLR start T12
    public void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:45:7: ( 'abstract language' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:45:7: 'abstract language'
            {
            match("abstract language"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:46:7: ( 'language' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:46:7: 'language'
            {
            match("language"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:47:7: ( '.' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:47:7: '.'
            {
            match('.'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:48:7: ( 'extends' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:48:7: 'extends'
            {
            match("extends"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:49:7: ( 'lexing' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:49:7: 'lexing'
            {
            match("lexing"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:50:7: ( ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:50:7: ':'
            {
            match(':'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:51:7: ( 'generate' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:51:7: 'generate'
            {
            match("generate"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:52:7: ( 'as' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:52:7: 'as'
            {
            match("as"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:53:7: ( 'import' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:53:7: 'import'
            {
            match("import"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:54:7: ( 'returns' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:54:7: 'returns'
            {
            match("returns"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:55:7: ( ';' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:55:7: ';'
            {
            match(';'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:56:7: ( '::' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:56:7: '::'
            {
            match("::"); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:57:7: ( '|' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:57:7: '|'
            {
            match('|'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:58:7: ( '?' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:58:7: '?'
            {
            match('?'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:59:7: ( '*' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:59:7: '*'
            {
            match('*'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:60:7: ( '+' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:60:7: '+'
            {
            match('+'); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:61:7: ( '+=' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:61:7: '+='
            {
            match("+="); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:62:7: ( '=' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:62:7: '='
            {
            match('='); 

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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:63:7: ( '?=' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:63:7: '?='
            {
            match("?="); 


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
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:64:7: ( '{' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:64:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:65:7: ( 'current' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:65:7: 'current'
            {
            match("current"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:66:7: ( '}' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:66:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:67:7: ( '(' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:67:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:68:7: ( ')' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:68:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start RULE_ID
    public void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:803:11: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:803:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:803:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:803:12: '^'
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

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:803:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
    public void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:805:12: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:805:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:805:12: ( '0' .. '9' )+
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
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:805:13: '0' .. '9'
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
    public void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:807:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
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
                    new NoViableAltException("807:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:807:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:807:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:807:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:807:65: ~ ( '\\\\' | '\"' )
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
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:807:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:807:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:807:93: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:807:137: ~ ( '\\\\' | '\\'' )
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
    public void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:809:19: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:809:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:809:24: ( options {greedy=false; } : . )*
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
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:809:52: .
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
    public void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:811:19: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:811:19: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:811:24: (~ ( '\\n' | '\\r' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:811:24: ~ ( '\\n' | '\\r' )
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

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:811:38: ( '\\r' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:811:38: '\\r'
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

    // $ANTLR start RULE_WS
    public void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:813:11: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:813:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:813:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
    public void mRULE_LEXER_BODY() throws RecognitionException {
        try {
            int _type = RULE_LEXER_BODY;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:815:19: ( '<#' ( '.' )* '#>' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:815:19: '<#' ( '.' )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:815:24: ( '.' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='.') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:815:24: '.'
            	    {
            	    match('.'); 

            	    }
            	    break;

            	default :
            	    break loop11;
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
    public void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:817:18: ( . )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:817:18: .
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
        // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:10: ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_LEXER_BODY | RULE_ANY_OTHER )
        int alt12=32;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='a') ) {
            switch ( input.LA(2) ) {
            case 'b':
                {
                int LA12_29 = input.LA(3);

                if ( (LA12_29=='s') ) {
                    int LA12_60 = input.LA(4);

                    if ( (LA12_60=='t') ) {
                        int LA12_69 = input.LA(5);

                        if ( (LA12_69=='r') ) {
                            int LA12_77 = input.LA(6);

                            if ( (LA12_77=='a') ) {
                                int LA12_85 = input.LA(7);

                                if ( (LA12_85=='c') ) {
                                    int LA12_93 = input.LA(8);

                                    if ( (LA12_93=='t') ) {
                                        int LA12_101 = input.LA(9);

                                        if ( (LA12_101==' ') ) {
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
            case 's':
                {
                int LA12_30 = input.LA(3);

                if ( ((LA12_30>='0' && LA12_30<='9')||(LA12_30>='A' && LA12_30<='Z')||LA12_30=='_'||(LA12_30>='a' && LA12_30<='z')) ) {
                    alt12=25;
                }
                else {
                    alt12=8;}
                }
                break;
            default:
                alt12=25;}

        }
        else if ( (LA12_0=='l') ) {
            switch ( input.LA(2) ) {
            case 'a':
                {
                int LA12_32 = input.LA(3);

                if ( (LA12_32=='n') ) {
                    int LA12_62 = input.LA(4);

                    if ( (LA12_62=='g') ) {
                        int LA12_70 = input.LA(5);

                        if ( (LA12_70=='u') ) {
                            int LA12_78 = input.LA(6);

                            if ( (LA12_78=='a') ) {
                                int LA12_86 = input.LA(7);

                                if ( (LA12_86=='g') ) {
                                    int LA12_94 = input.LA(8);

                                    if ( (LA12_94=='e') ) {
                                        int LA12_102 = input.LA(9);

                                        if ( ((LA12_102>='0' && LA12_102<='9')||(LA12_102>='A' && LA12_102<='Z')||LA12_102=='_'||(LA12_102>='a' && LA12_102<='z')) ) {
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
            case 'e':
                {
                int LA12_33 = input.LA(3);

                if ( (LA12_33=='x') ) {
                    int LA12_63 = input.LA(4);

                    if ( (LA12_63=='i') ) {
                        int LA12_71 = input.LA(5);

                        if ( (LA12_71=='n') ) {
                            int LA12_79 = input.LA(6);

                            if ( (LA12_79=='g') ) {
                                int LA12_87 = input.LA(7);

                                if ( ((LA12_87>='0' && LA12_87<='9')||(LA12_87>='A' && LA12_87<='Z')||LA12_87=='_'||(LA12_87>='a' && LA12_87<='z')) ) {
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
            default:
                alt12=25;}

        }
        else if ( (LA12_0=='.') ) {
            alt12=3;
        }
        else if ( (LA12_0=='e') ) {
            int LA12_4 = input.LA(2);

            if ( (LA12_4=='x') ) {
                int LA12_35 = input.LA(3);

                if ( (LA12_35=='t') ) {
                    int LA12_64 = input.LA(4);

                    if ( (LA12_64=='e') ) {
                        int LA12_72 = input.LA(5);

                        if ( (LA12_72=='n') ) {
                            int LA12_80 = input.LA(6);

                            if ( (LA12_80=='d') ) {
                                int LA12_88 = input.LA(7);

                                if ( (LA12_88=='s') ) {
                                    int LA12_96 = input.LA(8);

                                    if ( ((LA12_96>='0' && LA12_96<='9')||(LA12_96>='A' && LA12_96<='Z')||LA12_96=='_'||(LA12_96>='a' && LA12_96<='z')) ) {
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
                int LA12_38 = input.LA(3);

                if ( (LA12_38=='n') ) {
                    int LA12_65 = input.LA(4);

                    if ( (LA12_65=='e') ) {
                        int LA12_73 = input.LA(5);

                        if ( (LA12_73=='r') ) {
                            int LA12_81 = input.LA(6);

                            if ( (LA12_81=='a') ) {
                                int LA12_89 = input.LA(7);

                                if ( (LA12_89=='t') ) {
                                    int LA12_97 = input.LA(8);

                                    if ( (LA12_97=='e') ) {
                                        int LA12_104 = input.LA(9);

                                        if ( ((LA12_104>='0' && LA12_104<='9')||(LA12_104>='A' && LA12_104<='Z')||LA12_104=='_'||(LA12_104>='a' && LA12_104<='z')) ) {
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
                int LA12_39 = input.LA(3);

                if ( (LA12_39=='p') ) {
                    int LA12_66 = input.LA(4);

                    if ( (LA12_66=='o') ) {
                        int LA12_74 = input.LA(5);

                        if ( (LA12_74=='r') ) {
                            int LA12_82 = input.LA(6);

                            if ( (LA12_82=='t') ) {
                                int LA12_90 = input.LA(7);

                                if ( ((LA12_90>='0' && LA12_90<='9')||(LA12_90>='A' && LA12_90<='Z')||LA12_90=='_'||(LA12_90>='a' && LA12_90<='z')) ) {
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
                int LA12_40 = input.LA(3);

                if ( (LA12_40=='t') ) {
                    int LA12_67 = input.LA(4);

                    if ( (LA12_67=='u') ) {
                        int LA12_75 = input.LA(5);

                        if ( (LA12_75=='r') ) {
                            int LA12_83 = input.LA(6);

                            if ( (LA12_83=='n') ) {
                                int LA12_91 = input.LA(7);

                                if ( (LA12_91=='s') ) {
                                    int LA12_99 = input.LA(8);

                                    if ( ((LA12_99>='0' && LA12_99<='9')||(LA12_99>='A' && LA12_99<='Z')||LA12_99=='_'||(LA12_99>='a' && LA12_99<='z')) ) {
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
                int LA12_50 = input.LA(3);

                if ( (LA12_50=='r') ) {
                    int LA12_68 = input.LA(4);

                    if ( (LA12_68=='r') ) {
                        int LA12_76 = input.LA(5);

                        if ( (LA12_76=='e') ) {
                            int LA12_84 = input.LA(6);

                            if ( (LA12_84=='n') ) {
                                int LA12_92 = input.LA(7);

                                if ( (LA12_92=='t') ) {
                                    int LA12_100 = input.LA(8);

                                    if ( ((LA12_100>='0' && LA12_100<='9')||(LA12_100>='A' && LA12_100<='Z')||LA12_100=='_'||(LA12_100>='a' && LA12_100<='z')) ) {
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
                alt12=32;}
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
                alt12=32;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_24 = input.LA(2);

            if ( ((LA12_24>='\u0000' && LA12_24<='\uFFFE')) ) {
                alt12=27;
            }
            else {
                alt12=32;}
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=29;
                }
                break;
            case '*':
                {
                alt12=28;
                }
                break;
            default:
                alt12=32;}

        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=30;
        }
        else if ( (LA12_0=='<') ) {
            int LA12_27 = input.LA(2);

            if ( (LA12_27=='#') ) {
                alt12=31;
            }
            else {
                alt12=32;}
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>=',' && LA12_0<='-')||LA12_0=='>'||LA12_0=='@'||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12=32;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_LEXER_BODY | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:30: T17
                {
                mT17(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:34: T18
                {
                mT18(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:38: T19
                {
                mT19(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:42: T20
                {
                mT20(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:46: T21
                {
                mT21(); 

                }
                break;
            case 11 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:50: T22
                {
                mT22(); 

                }
                break;
            case 12 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:54: T23
                {
                mT23(); 

                }
                break;
            case 13 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:58: T24
                {
                mT24(); 

                }
                break;
            case 14 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:62: T25
                {
                mT25(); 

                }
                break;
            case 15 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:66: T26
                {
                mT26(); 

                }
                break;
            case 16 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:70: T27
                {
                mT27(); 

                }
                break;
            case 17 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:74: T28
                {
                mT28(); 

                }
                break;
            case 18 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:78: T29
                {
                mT29(); 

                }
                break;
            case 19 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:82: T30
                {
                mT30(); 

                }
                break;
            case 20 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:86: T31
                {
                mT31(); 

                }
                break;
            case 21 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:90: T32
                {
                mT32(); 

                }
                break;
            case 22 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:94: T33
                {
                mT33(); 

                }
                break;
            case 23 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:98: T34
                {
                mT34(); 

                }
                break;
            case 24 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:102: T35
                {
                mT35(); 

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
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:175: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 32 :
                // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1:191: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}