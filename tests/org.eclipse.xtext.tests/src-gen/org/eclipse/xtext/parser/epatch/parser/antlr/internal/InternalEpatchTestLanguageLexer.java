package org.eclipse.xtext.parser.epatch.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEpatchTestLanguageLexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=11;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int Tokens=41;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=9;
    public static final int T23=23;
    public static final int T40=40;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_FRAGMENT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_INT=7;
    public static final int T38=38;
    public static final int T37=37;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T39=39;
    public static final int T14=14;
    public static final int T34=34;
    public static final int RULE_WS=10;
    public static final int T15=15;
    public static final int T33=33;
    public static final int T16=16;
    public static final int T36=36;
    public static final int T17=17;
    public static final int T35=35;
    public static final int T18=18;
    public static final int T30=30;
    public static final int T19=19;
    public static final int T32=32;
    public static final int T31=31;
    public InternalEpatchTestLanguageLexer() {;} 
    public InternalEpatchTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:10:5: ( 'epatch' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:10:7: 'epatch'
            {
            match("epatch"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:11:5: ( '{' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:11:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:12:5: ( '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:12:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:13:5: ( 'import' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:13:7: 'import'
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
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:14:5: ( 'uri' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:14:7: 'uri'
            {
            match("uri"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:15:5: ( 'ns' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:15:7: 'ns'
            {
            match("ns"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:16:5: ( 'java' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:16:7: 'java'
            {
            match("java"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:17:5: ( '.' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:17:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:18:5: ( 'extension' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:18:7: 'extension'
            {
            match("extension"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:19:5: ( '::' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:19:7: '::'
            {
            match("::"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:20:5: ( 'resource' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:20:7: 'resource'
            {
            match("resource"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:21:5: ( 'left' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:21:7: 'left'
            {
            match("left"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:22:5: ( ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:22:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:23:5: ( 'right' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:23:7: 'right'
            {
            match("right"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:24:5: ( 'object' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:24:7: 'object'
            {
            match("object"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:25:5: ( '=' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:25:7: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:26:5: ( '|' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:26:7: '|'
            {
            match('|'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:27:5: ( '[' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:27:7: '['
            {
            match('['); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:28:5: ( ',' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:28:7: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:29:5: ( ']' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:29:7: ']'
            {
            match(']'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:30:5: ( ':' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:30:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:31:5: ( 'null' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:31:7: 'null'
            {
            match("null"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:32:5: ( 'new' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:32:7: 'new'
            {
            match("new"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:33:5: ( 'copy' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:33:7: 'copy'
            {
            match("copy"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:34:5: ( 'migrate' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:34:7: 'migrate'
            {
            match("migrate"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:35:5: ( 'as' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:35:7: 'as'
            {
            match("as"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:36:5: ( 'each' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:36:7: 'each'
            {
            match("each"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:37:5: ( '(' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:37:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:38:5: ( ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:38:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start RULE_FRAGMENT
    public final void mRULE_FRAGMENT() throws RecognitionException {
        try {
            int _type = RULE_FRAGMENT;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2747:15: ( '#' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '[' | ']' | '{' | '}' | '.' | '@' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2747:17: '#' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '[' | ']' | '{' | '}' | '.' | '@' )+
            {
            match('#'); 
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2747:21: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '[' | ']' | '{' | '}' | '.' | '@' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='.' && LA1_0<='9')||(LA1_0>='@' && LA1_0<='[')||LA1_0==']'||LA1_0=='_'||(LA1_0>='a' && LA1_0<='{')||LA1_0=='}') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='.' && input.LA(1)<='9')||(input.LA(1)>='@' && input.LA(1)<='[')||input.LA(1)==']'||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='{')||input.LA(1)=='}' ) {
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
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_FRAGMENT

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2749:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2749:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2749:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2749:11: '^'
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2749:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:
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
            	    break loop3;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2751:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2751:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2751:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2751:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("2753:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2753:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2755:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2755:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2755:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2755:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2757:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2757:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2757:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2757:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop9;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2757:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2757:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2757:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2757:41: '\\r'
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2759:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2759:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2759:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:
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
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2761:16: ( . )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2761:18: .
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
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | RULE_FRAGMENT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=37;
        int LA13_0 = input.LA(1);

        if ( (LA13_0=='e') ) {
            alt13 = mTokensHelper001();
        }
        else if ( (LA13_0=='{') ) {
            alt13 = mTokensHelper002();
        }
        else if ( (LA13_0=='}') ) {
            alt13 = mTokensHelper003();
        }
        else if ( (LA13_0=='i') ) {
            alt13 = mTokensHelper004();
        }
        else if ( (LA13_0=='u') ) {
            alt13 = mTokensHelper005();
        }
        else if ( (LA13_0=='n') ) {
            alt13 = mTokensHelper006();
        }
        else if ( (LA13_0=='j') ) {
            alt13 = mTokensHelper007();
        }
        else if ( (LA13_0=='.') ) {
            alt13 = mTokensHelper008();
        }
        else if ( (LA13_0==':') ) {
            alt13 = mTokensHelper009();
        }
        else if ( (LA13_0=='r') ) {
            alt13 = mTokensHelper010();
        }
        else if ( (LA13_0=='l') ) {
            alt13 = mTokensHelper011();
        }
        else if ( (LA13_0==';') ) {
            alt13 = mTokensHelper012();
        }
        else if ( (LA13_0=='o') ) {
            alt13 = mTokensHelper013();
        }
        else if ( (LA13_0=='=') ) {
            alt13 = mTokensHelper014();
        }
        else if ( (LA13_0=='|') ) {
            alt13 = mTokensHelper015();
        }
        else if ( (LA13_0=='[') ) {
            alt13 = mTokensHelper016();
        }
        else if ( (LA13_0==',') ) {
            alt13 = mTokensHelper017();
        }
        else if ( (LA13_0==']') ) {
            alt13 = mTokensHelper018();
        }
        else if ( (LA13_0=='c') ) {
            alt13 = mTokensHelper019();
        }
        else if ( (LA13_0=='m') ) {
            alt13 = mTokensHelper020();
        }
        else if ( (LA13_0=='a') ) {
            alt13 = mTokensHelper021();
        }
        else if ( (LA13_0=='(') ) {
            alt13 = mTokensHelper022();
        }
        else if ( (LA13_0==')') ) {
            alt13 = mTokensHelper023();
        }
        else if ( (LA13_0=='#') ) {
            alt13 = mTokensHelper024();
        }
        else if ( (LA13_0=='^') ) {
            alt13 = mTokensHelper025();
        }
        else if ( ((LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||LA13_0=='b'||LA13_0=='d'||(LA13_0>='f' && LA13_0<='h')||LA13_0=='k'||(LA13_0>='p' && LA13_0<='q')||(LA13_0>='s' && LA13_0<='t')||(LA13_0>='v' && LA13_0<='z')) ) {
            alt13 = mTokensHelper026();
        }
        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {
            alt13 = mTokensHelper027();
        }
        else if ( (LA13_0=='\"') ) {
            alt13 = mTokensHelper028();
        }
        else if ( (LA13_0=='\'') ) {
            alt13 = mTokensHelper029();
        }
        else if ( (LA13_0=='/') ) {
            alt13 = mTokensHelper030();
        }
        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
            alt13 = mTokensHelper031();
        }
        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||(LA13_0>='$' && LA13_0<='&')||(LA13_0>='*' && LA13_0<='+')||LA13_0=='-'||LA13_0=='<'||(LA13_0>='>' && LA13_0<='@')||LA13_0=='\\'||LA13_0=='`'||(LA13_0>='~' && LA13_0<='\uFFFE')) ) {
            alt13 = mTokensHelper032();
        }
        else {
            alt13 = mTokensHelper033();
        }
        switch (alt13) {
            case 1 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:30: T17
                {
                mT17(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:34: T18
                {
                mT18(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:38: T19
                {
                mT19(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:42: T20
                {
                mT20(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:46: T21
                {
                mT21(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:50: T22
                {
                mT22(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:54: T23
                {
                mT23(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:58: T24
                {
                mT24(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:62: T25
                {
                mT25(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:66: T26
                {
                mT26(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:70: T27
                {
                mT27(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:74: T28
                {
                mT28(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:78: T29
                {
                mT29(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:82: T30
                {
                mT30(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:86: T31
                {
                mT31(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:90: T32
                {
                mT32(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:94: T33
                {
                mT33(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:98: T34
                {
                mT34(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:102: T35
                {
                mT35(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:106: T36
                {
                mT36(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:110: T37
                {
                mT37(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:114: T38
                {
                mT38(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:118: T39
                {
                mT39(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:122: T40
                {
                mT40(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:126: RULE_FRAGMENT
                {
                mRULE_FRAGMENT(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:140: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:148: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:157: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:169: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:185: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:201: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1:209: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA13_33 = input.LA(3);

            if ( (LA13_33=='c') ) {
                int LA13_69 = input.LA(4);

                if ( (LA13_69=='h') ) {
                    int LA13_85 = input.LA(5);

                    if ( ((LA13_85>='0' && LA13_85<='9')||(LA13_85>='A' && LA13_85<='Z')||LA13_85=='_'||(LA13_85>='a' && LA13_85<='z')) ) {
                        return 31;
                    }
                    else {
                        return 27;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
            }
        case 'p':
            {
            int LA13_34 = input.LA(3);

            if ( (LA13_34=='a') ) {
                int LA13_70 = input.LA(4);

                if ( (LA13_70=='t') ) {
                    int LA13_86 = input.LA(5);

                    if ( (LA13_86=='c') ) {
                        int LA13_100 = input.LA(6);

                        if ( (LA13_100=='h') ) {
                            int LA13_111 = input.LA(7);

                            if ( ((LA13_111>='0' && LA13_111<='9')||(LA13_111>='A' && LA13_111<='Z')||LA13_111=='_'||(LA13_111>='a' && LA13_111<='z')) ) {
                                return 31;
                            }
                            else {
                                return 1;}
                        }
                        else {
                            return 31;}
                    }
                    else {
                        return 31;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
            }
        case 'x':
            {
            int LA13_35 = input.LA(3);

            if ( (LA13_35=='t') ) {
                int LA13_71 = input.LA(4);

                if ( (LA13_71=='e') ) {
                    int LA13_87 = input.LA(5);

                    if ( (LA13_87=='n') ) {
                        int LA13_101 = input.LA(6);

                        if ( (LA13_101=='s') ) {
                            int LA13_112 = input.LA(7);

                            if ( (LA13_112=='i') ) {
                                int LA13_119 = input.LA(8);

                                if ( (LA13_119=='o') ) {
                                    int LA13_124 = input.LA(9);

                                    if ( (LA13_124=='n') ) {
                                        int LA13_127 = input.LA(10);

                                        if ( ((LA13_127>='0' && LA13_127<='9')||(LA13_127>='A' && LA13_127<='Z')||LA13_127=='_'||(LA13_127>='a' && LA13_127<='z')) ) {
                                            return 31;
                                        }
                                        else {
                                            return 9;}
                                    }
                                    else {
                                        return 31;}
                                }
                                else {
                                    return 31;}
                            }
                            else {
                                return 31;}
                        }
                        else {
                            return 31;}
                    }
                    else {
                        return 31;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
            }
        default:
            return 31;}

    }

    private int mTokensHelper002() throws RecognitionException {
        return 2;
    }

    private int mTokensHelper003() throws RecognitionException {
        return 3;
    }

    private int mTokensHelper004() throws RecognitionException {
        int LA13_4 = input.LA(2);

        if ( (LA13_4=='m') ) {
            int LA13_39 = input.LA(3);

            if ( (LA13_39=='p') ) {
                int LA13_72 = input.LA(4);

                if ( (LA13_72=='o') ) {
                    int LA13_88 = input.LA(5);

                    if ( (LA13_88=='r') ) {
                        int LA13_102 = input.LA(6);

                        if ( (LA13_102=='t') ) {
                            int LA13_113 = input.LA(7);

                            if ( ((LA13_113>='0' && LA13_113<='9')||(LA13_113>='A' && LA13_113<='Z')||LA13_113=='_'||(LA13_113>='a' && LA13_113<='z')) ) {
                                return 31;
                            }
                            else {
                                return 4;}
                        }
                        else {
                            return 31;}
                    }
                    else {
                        return 31;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
        }
        else {
            return 31;}
    }

    private int mTokensHelper005() throws RecognitionException {
        int LA13_5 = input.LA(2);

        if ( (LA13_5=='r') ) {
            int LA13_40 = input.LA(3);

            if ( (LA13_40=='i') ) {
                int LA13_73 = input.LA(4);

                if ( ((LA13_73>='0' && LA13_73<='9')||(LA13_73>='A' && LA13_73<='Z')||LA13_73=='_'||(LA13_73>='a' && LA13_73<='z')) ) {
                    return 31;
                }
                else {
                    return 5;}
            }
            else {
                return 31;}
        }
        else {
            return 31;}
    }

    private int mTokensHelper006() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'u':
            {
            int LA13_41 = input.LA(3);

            if ( (LA13_41=='l') ) {
                int LA13_74 = input.LA(4);

                if ( (LA13_74=='l') ) {
                    int LA13_90 = input.LA(5);

                    if ( ((LA13_90>='0' && LA13_90<='9')||(LA13_90>='A' && LA13_90<='Z')||LA13_90=='_'||(LA13_90>='a' && LA13_90<='z')) ) {
                        return 31;
                    }
                    else {
                        return 22;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
            }
        case 'e':
            {
            int LA13_42 = input.LA(3);

            if ( (LA13_42=='w') ) {
                int LA13_75 = input.LA(4);

                if ( ((LA13_75>='0' && LA13_75<='9')||(LA13_75>='A' && LA13_75<='Z')||LA13_75=='_'||(LA13_75>='a' && LA13_75<='z')) ) {
                    return 31;
                }
                else {
                    return 23;}
            }
            else {
                return 31;}
            }
        case 's':
            {
            int LA13_43 = input.LA(3);

            if ( ((LA13_43>='0' && LA13_43<='9')||(LA13_43>='A' && LA13_43<='Z')||LA13_43=='_'||(LA13_43>='a' && LA13_43<='z')) ) {
                return 31;
            }
            else {
                return 6;}
            }
        default:
            return 31;}

    }

    private int mTokensHelper007() throws RecognitionException {
        int LA13_7 = input.LA(2);

        if ( (LA13_7=='a') ) {
            int LA13_44 = input.LA(3);

            if ( (LA13_44=='v') ) {
                int LA13_77 = input.LA(4);

                if ( (LA13_77=='a') ) {
                    int LA13_92 = input.LA(5);

                    if ( ((LA13_92>='0' && LA13_92<='9')||(LA13_92>='A' && LA13_92<='Z')||LA13_92=='_'||(LA13_92>='a' && LA13_92<='z')) ) {
                        return 31;
                    }
                    else {
                        return 7;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
        }
        else {
            return 31;}
    }

    private int mTokensHelper008() throws RecognitionException {
        return 8;
    }

    private int mTokensHelper009() throws RecognitionException {
        int LA13_9 = input.LA(2);

        if ( (LA13_9==':') ) {
            return 10;
        }
        else {
            return 21;}
    }

    private int mTokensHelper010() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'i':
            {
            int LA13_48 = input.LA(3);

            if ( (LA13_48=='g') ) {
                int LA13_78 = input.LA(4);

                if ( (LA13_78=='h') ) {
                    int LA13_93 = input.LA(5);

                    if ( (LA13_93=='t') ) {
                        int LA13_105 = input.LA(6);

                        if ( ((LA13_105>='0' && LA13_105<='9')||(LA13_105>='A' && LA13_105<='Z')||LA13_105=='_'||(LA13_105>='a' && LA13_105<='z')) ) {
                            return 31;
                        }
                        else {
                            return 14;}
                    }
                    else {
                        return 31;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
            }
        case 'e':
            {
            int LA13_49 = input.LA(3);

            if ( (LA13_49=='s') ) {
                int LA13_79 = input.LA(4);

                if ( (LA13_79=='o') ) {
                    int LA13_94 = input.LA(5);

                    if ( (LA13_94=='u') ) {
                        int LA13_106 = input.LA(6);

                        if ( (LA13_106=='r') ) {
                            int LA13_115 = input.LA(7);

                            if ( (LA13_115=='c') ) {
                                int LA13_121 = input.LA(8);

                                if ( (LA13_121=='e') ) {
                                    int LA13_125 = input.LA(9);

                                    if ( ((LA13_125>='0' && LA13_125<='9')||(LA13_125>='A' && LA13_125<='Z')||LA13_125=='_'||(LA13_125>='a' && LA13_125<='z')) ) {
                                        return 31;
                                    }
                                    else {
                                        return 11;}
                                }
                                else {
                                    return 31;}
                            }
                            else {
                                return 31;}
                        }
                        else {
                            return 31;}
                    }
                    else {
                        return 31;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
            }
        default:
            return 31;}

    }

    private int mTokensHelper011() throws RecognitionException {
        int LA13_11 = input.LA(2);

        if ( (LA13_11=='e') ) {
            int LA13_50 = input.LA(3);

            if ( (LA13_50=='f') ) {
                int LA13_80 = input.LA(4);

                if ( (LA13_80=='t') ) {
                    int LA13_95 = input.LA(5);

                    if ( ((LA13_95>='0' && LA13_95<='9')||(LA13_95>='A' && LA13_95<='Z')||LA13_95=='_'||(LA13_95>='a' && LA13_95<='z')) ) {
                        return 31;
                    }
                    else {
                        return 12;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
        }
        else {
            return 31;}
    }

    private int mTokensHelper012() throws RecognitionException {
        return 13;
    }

    private int mTokensHelper013() throws RecognitionException {
        int LA13_13 = input.LA(2);

        if ( (LA13_13=='b') ) {
            int LA13_52 = input.LA(3);

            if ( (LA13_52=='j') ) {
                int LA13_81 = input.LA(4);

                if ( (LA13_81=='e') ) {
                    int LA13_96 = input.LA(5);

                    if ( (LA13_96=='c') ) {
                        int LA13_108 = input.LA(6);

                        if ( (LA13_108=='t') ) {
                            int LA13_116 = input.LA(7);

                            if ( ((LA13_116>='0' && LA13_116<='9')||(LA13_116>='A' && LA13_116<='Z')||LA13_116=='_'||(LA13_116>='a' && LA13_116<='z')) ) {
                                return 31;
                            }
                            else {
                                return 15;}
                        }
                        else {
                            return 31;}
                    }
                    else {
                        return 31;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
        }
        else {
            return 31;}
    }

    private int mTokensHelper014() throws RecognitionException {
        return 16;
    }

    private int mTokensHelper015() throws RecognitionException {
        return 17;
    }

    private int mTokensHelper016() throws RecognitionException {
        return 18;
    }

    private int mTokensHelper017() throws RecognitionException {
        return 19;
    }

    private int mTokensHelper018() throws RecognitionException {
        return 20;
    }

    private int mTokensHelper019() throws RecognitionException {
        int LA13_19 = input.LA(2);

        if ( (LA13_19=='o') ) {
            int LA13_58 = input.LA(3);

            if ( (LA13_58=='p') ) {
                int LA13_82 = input.LA(4);

                if ( (LA13_82=='y') ) {
                    int LA13_97 = input.LA(5);

                    if ( ((LA13_97>='0' && LA13_97<='9')||(LA13_97>='A' && LA13_97<='Z')||LA13_97=='_'||(LA13_97>='a' && LA13_97<='z')) ) {
                        return 31;
                    }
                    else {
                        return 24;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
        }
        else {
            return 31;}
    }

    private int mTokensHelper020() throws RecognitionException {
        int LA13_20 = input.LA(2);

        if ( (LA13_20=='i') ) {
            int LA13_59 = input.LA(3);

            if ( (LA13_59=='g') ) {
                int LA13_83 = input.LA(4);

                if ( (LA13_83=='r') ) {
                    int LA13_98 = input.LA(5);

                    if ( (LA13_98=='a') ) {
                        int LA13_110 = input.LA(6);

                        if ( (LA13_110=='t') ) {
                            int LA13_117 = input.LA(7);

                            if ( (LA13_117=='e') ) {
                                int LA13_123 = input.LA(8);

                                if ( ((LA13_123>='0' && LA13_123<='9')||(LA13_123>='A' && LA13_123<='Z')||LA13_123=='_'||(LA13_123>='a' && LA13_123<='z')) ) {
                                    return 31;
                                }
                                else {
                                    return 25;}
                            }
                            else {
                                return 31;}
                        }
                        else {
                            return 31;}
                    }
                    else {
                        return 31;}
                }
                else {
                    return 31;}
            }
            else {
                return 31;}
        }
        else {
            return 31;}
    }

    private int mTokensHelper021() throws RecognitionException {
        int LA13_21 = input.LA(2);

        if ( (LA13_21=='s') ) {
            int LA13_60 = input.LA(3);

            if ( ((LA13_60>='0' && LA13_60<='9')||(LA13_60>='A' && LA13_60<='Z')||LA13_60=='_'||(LA13_60>='a' && LA13_60<='z')) ) {
                return 31;
            }
            else {
                return 26;}
        }
        else {
            return 31;}
    }

    private int mTokensHelper022() throws RecognitionException {
        return 28;
    }

    private int mTokensHelper023() throws RecognitionException {
        return 29;
    }

    private int mTokensHelper024() throws RecognitionException {
        int LA13_24 = input.LA(2);

        if ( ((LA13_24>='.' && LA13_24<='9')||(LA13_24>='@' && LA13_24<='[')||LA13_24==']'||LA13_24=='_'||(LA13_24>='a' && LA13_24<='{')||LA13_24=='}') ) {
            return 30;
        }
        else {
            return 37;}
    }

    private int mTokensHelper025() throws RecognitionException {
        int LA13_25 = input.LA(2);

        if ( ((LA13_25>='A' && LA13_25<='Z')||LA13_25=='_'||(LA13_25>='a' && LA13_25<='z')) ) {
            return 31;
        }
        else {
            return 37;}
    }

    private int mTokensHelper026() throws RecognitionException {
        return 31;
    }

    private int mTokensHelper027() throws RecognitionException {
        return 32;
    }

    private int mTokensHelper028() throws RecognitionException {
        int LA13_28 = input.LA(2);

        if ( ((LA13_28>='\u0000' && LA13_28<='\uFFFE')) ) {
            return 33;
        }
        else {
            return 37;}
    }

    private int mTokensHelper029() throws RecognitionException {
        int LA13_29 = input.LA(2);

        if ( ((LA13_29>='\u0000' && LA13_29<='\uFFFE')) ) {
            return 33;
        }
        else {
            return 37;}
    }

    private int mTokensHelper030() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '*':
            {
            return 34;
            }
        case '/':
            {
            return 35;
            }
        default:
            return 37;}

    }

    private int mTokensHelper031() throws RecognitionException {
        return 36;
    }

    private int mTokensHelper032() throws RecognitionException {
        return 37;
    }

    private int mTokensHelper033() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | RULE_FRAGMENT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 13, 0, input);

        throw nvae;
    }



 

}