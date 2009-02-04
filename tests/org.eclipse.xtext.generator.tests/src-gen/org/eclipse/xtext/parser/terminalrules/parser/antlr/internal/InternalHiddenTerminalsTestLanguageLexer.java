package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalHiddenTerminalsTestLanguageLexer extends Lexer {
    public static final int T10=10;
    public static final int RULE_ML_COMMENT=5;
    public static final int T14=14;
    public static final int RULE_WS=4;
    public static final int T11=11;
    public static final int T9=9;
    public static final int T15=15;
    public static final int EOF=-1;
    public static final int T17=17;
    public static final int T12=12;
    public static final int Tokens=18;
    public static final int RULE_ANY_OTHER=7;
    public static final int T16=16;
    public static final int T8=8;
    public static final int RULE_SL_COMMENT=6;
    public static final int T13=13;
    public InternalHiddenTerminalsTestLanguageLexer() {;} 
    public InternalHiddenTerminalsTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g"; }

    // $ANTLR start T8
    public final void mT8() throws RecognitionException {
        try {
            int _type = T8;
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:10:4: ( 'without' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:10:6: 'without'
            {
            match("without"); 


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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:11:4: ( 'hiddens' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:11:6: 'hiddens'
            {
            match("hiddens"); 


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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:12:5: ( ';' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:12:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:13:5: ( 'with' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:13:7: 'with'
            {
            match("with"); 


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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:14:5: ( 'overriding' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:14:7: 'overriding'
            {
            match("overriding"); 


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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:15:5: ( '(' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:15:7: '('
            {
            match('('); 

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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:16:5: ( ')' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:16:7: ')'
            {
            match(')'); 

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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:17:5: ( 'call' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:17:7: 'call'
            {
            match("call"); 


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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:18:5: ( 'inheriting' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:18:7: 'inheriting'
            {
            match("inheriting"); 


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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:19:5: ( 'hiding' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:19:7: 'hiding'
            {
            match("hiding"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:663:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:663:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:663:24: ( options {greedy=false; } : . )*
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
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:663:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:667:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:667:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:667:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFE')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:667:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop2;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:667:40: ( ( '\\r' )? '\\n' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\n'||LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:667:41: ( '\\r' )? '\\n'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:667:41: ( '\\r' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:667:41: '\\r'
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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:671:9: ( ( ( ( ' ' | '\\t' ) | '\\r' ) | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:671:11: ( ( ( ' ' | '\\t' ) | '\\r' ) | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:671:11: ( ( ( ' ' | '\\t' ) | '\\r' ) | '\\n' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\t' && LA5_0<='\n')||LA5_0=='\r'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:675:16: ( . )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:675:18: .
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
        // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:8: ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt6=14;
        int LA6_0 = input.LA(1);

        if ( (LA6_0=='w') ) {
            int LA6_1 = input.LA(2);

            if ( (LA6_1=='i') ) {
                int LA6_12 = input.LA(3);

                if ( (LA6_12=='t') ) {
                    int LA6_23 = input.LA(4);

                    if ( (LA6_23=='h') ) {
                        int LA6_25 = input.LA(5);

                        if ( (LA6_25=='o') ) {
                            alt6=1;
                        }
                        else {
                            alt6=4;}
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 6, 23, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 6, 12, input);

                    throw nvae;
                }
            }
            else {
                alt6=14;}
        }
        else if ( (LA6_0=='h') ) {
            int LA6_2 = input.LA(2);

            if ( (LA6_2=='i') ) {
                int LA6_13 = input.LA(3);

                if ( (LA6_13=='d') ) {
                    int LA6_24 = input.LA(4);

                    if ( (LA6_24=='d') ) {
                        alt6=2;
                    }
                    else if ( (LA6_24=='i') ) {
                        alt6=10;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 6, 24, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 6, 13, input);

                    throw nvae;
                }
            }
            else {
                alt6=14;}
        }
        else if ( (LA6_0==';') ) {
            alt6=3;
        }
        else if ( (LA6_0=='o') ) {
            int LA6_4 = input.LA(2);

            if ( (LA6_4=='v') ) {
                alt6=5;
            }
            else {
                alt6=14;}
        }
        else if ( (LA6_0=='(') ) {
            alt6=6;
        }
        else if ( (LA6_0==')') ) {
            alt6=7;
        }
        else if ( (LA6_0=='c') ) {
            int LA6_7 = input.LA(2);

            if ( (LA6_7=='a') ) {
                alt6=8;
            }
            else {
                alt6=14;}
        }
        else if ( (LA6_0=='i') ) {
            int LA6_8 = input.LA(2);

            if ( (LA6_8=='n') ) {
                alt6=9;
            }
            else {
                alt6=14;}
        }
        else if ( (LA6_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt6=12;
                }
                break;
            case '*':
                {
                alt6=11;
                }
                break;
            default:
                alt6=14;}

        }
        else if ( ((LA6_0>='\t' && LA6_0<='\n')||LA6_0=='\r'||LA6_0==' ') ) {
            alt6=13;
        }
        else if ( ((LA6_0>='\u0000' && LA6_0<='\b')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\u001F')||(LA6_0>='!' && LA6_0<='\'')||(LA6_0>='*' && LA6_0<='.')||(LA6_0>='0' && LA6_0<=':')||(LA6_0>='<' && LA6_0<='b')||(LA6_0>='d' && LA6_0<='g')||(LA6_0>='j' && LA6_0<='n')||(LA6_0>='p' && LA6_0<='v')||(LA6_0>='x' && LA6_0<='\uFFFE')) ) {
            alt6=14;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 6, 0, input);

            throw nvae;
        }
        switch (alt6) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:10: T8
                {
                mT8(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:13: T9
                {
                mT9(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:16: T10
                {
                mT10(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:20: T11
                {
                mT11(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:24: T12
                {
                mT12(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:28: T13
                {
                mT13(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:32: T14
                {
                mT14(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:36: T15
                {
                mT15(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:40: T16
                {
                mT16(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:44: T17
                {
                mT17(); 

                }
                break;
            case 11 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:48: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 12 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:64: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 13 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:80: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 14 :
                // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:1:88: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}