package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEcoreTerminalsTestLanguageLexer extends Lexer {
    public static final int RULE_EDATE=6;
    public static final int RULE_EDOUBLE=5;
    public static final int RULE_EINT=4;
    public static final int T10=10;
    public static final int T8=8;
    public static final int T9=9;
    public static final int RULE_WS=7;
    public static final int Tokens=11;
    public static final int EOF=-1;
    public InternalEcoreTerminalsTestLanguageLexer() {;} 
    public InternalEcoreTerminalsTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g"; }

    // $ANTLR start T8
    public final void mT8() throws RecognitionException {
        try {
            int _type = T8;
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:10:4: ( 'int' )
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:10:6: 'int'
            {
            match("int"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T8

    // $ANTLR start T9
    public final void mT9() throws RecognitionException {
        try {
            int _type = T9;
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:11:4: ( 'double' )
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:11:6: 'double'
            {
            match("double"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T9

    // $ANTLR start T10
    public final void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:12:5: ( 'date' )
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:12:7: 'date'
            {
            match("date"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start RULE_EDOUBLE
    public final void mRULE_EDOUBLE() throws RecognitionException {
        try {
            int _type = RULE_EDOUBLE;
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:14: ( ( '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )* ) ( ( 'E' | 'e' ) ( '-' | ( '+' )? ) ( '0' .. '9' )+ )? )
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:16: ( '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )* ) ( ( 'E' | 'e' ) ( '-' | ( '+' )? ) ( '0' .. '9' )+ )?
            {
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:16: ( '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )* )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.') ) {
                alt4=1;
            }
            else if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("185:16: ( '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )* )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:17: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:21: ( '0' .. '9' )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:22: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:33: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
                    {
                    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:33: ( '0' .. '9' )+
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
                    	    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:34: '0' .. '9'
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

                    match('.'); 
                    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:49: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:50: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:62: ( ( 'E' | 'e' ) ( '-' | ( '+' )? ) ( '0' .. '9' )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='E'||LA8_0=='e') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:63: ( 'E' | 'e' ) ( '-' | ( '+' )? ) ( '0' .. '9' )+
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:73: ( '-' | ( '+' )? )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='-') ) {
                        alt6=1;
                    }
                    else if ( (LA6_0=='+'||(LA6_0>='0' && LA6_0<='9')) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("185:73: ( '-' | ( '+' )? )", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:74: '-'
                            {
                            match('-'); 

                            }
                            break;
                        case 2 :
                            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:78: ( '+' )?
                            {
                            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:78: ( '+' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0=='+') ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:78: '+'
                                    {
                                    match('+'); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:84: ( '0' .. '9' )+
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
                    	    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:185:85: '0' .. '9'
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
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_EDOUBLE

    // $ANTLR start RULE_EDATE
    public final void mRULE_EDATE() throws RecognitionException {
        try {
            int _type = RULE_EDATE;
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:187:12: ( '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' 'T' '0' .. '9' '0' .. '9' ':' '0' .. '9' '0' .. '9' ':' '0' .. '9' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' ( '+' | '-' ) '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' )
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:187:14: '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' '-' '0' .. '9' '0' .. '9' 'T' '0' .. '9' '0' .. '9' ':' '0' .. '9' '0' .. '9' ':' '0' .. '9' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' ( '+' | '-' ) '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9'
            {
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('-'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('-'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('T'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match(':'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match(':'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('.'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_EDATE

    // $ANTLR start RULE_EINT
    public final void mRULE_EINT() throws RecognitionException {
        try {
            int _type = RULE_EINT;
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:189:11: ( ( '-' )? ( '0' .. '9' )+ )
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:189:13: ( '-' )? ( '0' .. '9' )+
            {
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:189:13: ( '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='-') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:189:13: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:189:18: ( '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:189:19: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_EINT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:191:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:191:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:191:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:
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

    public void mTokens() throws RecognitionException {
        // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:8: ( T8 | T9 | T10 | RULE_EDOUBLE | RULE_EDATE | RULE_EINT | RULE_WS )
        int alt12=7;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:10: T8
                {
                mT8(); 

                }
                break;
            case 2 :
                // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:13: T9
                {
                mT9(); 

                }
                break;
            case 3 :
                // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:16: T10
                {
                mT10(); 

                }
                break;
            case 4 :
                // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:20: RULE_EDOUBLE
                {
                mRULE_EDOUBLE(); 

                }
                break;
            case 5 :
                // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:33: RULE_EDATE
                {
                mRULE_EDATE(); 

                }
                break;
            case 6 :
                // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:44: RULE_EINT
                {
                mRULE_EINT(); 

                }
                break;
            case 7 :
                // /Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:1:54: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\4\uffff\1\5\4\uffff\3\5\1\uffff\1\5";
    static final String DFA12_eofS =
        "\16\uffff";
    static final String DFA12_minS =
        "\1\11\1\uffff\1\141\1\uffff\1\56\4\uffff\2\56\1\55\1\uffff\1\56";
    static final String DFA12_maxS =
        "\1\151\1\uffff\1\157\1\uffff\1\71\4\uffff\3\71\1\uffff\1\71";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\uffff\1\6\1\7\1\3\1\2\3\uffff\1\5\1\uffff";
    static final String DFA12_specialS =
        "\16\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\6\2\uffff\1\6\22\uffff\1\6\14\uffff\1\5\1\3\1\uffff\12\4"+
            "\52\uffff\1\2\4\uffff\1\1",
            "",
            "\1\7\15\uffff\1\10",
            "",
            "\1\3\1\uffff\12\11",
            "",
            "",
            "",
            "",
            "\1\3\1\uffff\12\12",
            "\1\3\1\uffff\12\13",
            "\1\14\1\3\1\uffff\12\15",
            "",
            "\1\3\1\uffff\12\15"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T8 | T9 | T10 | RULE_EDOUBLE | RULE_EDATE | RULE_EINT | RULE_WS );";
        }
    }
 

}