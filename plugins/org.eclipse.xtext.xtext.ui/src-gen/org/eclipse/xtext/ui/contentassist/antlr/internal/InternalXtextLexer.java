package org.eclipse.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextLexer extends Lexer {
    public static final int T14=14;
    public static final int T29=29;
    public static final int T36=36;
    public static final int RULE_STRING=5;
    public static final int T35=35;
    public static final int T20=20;
    public static final int T34=34;
    public static final int T25=25;
    public static final int T18=18;
    public static final int T37=37;
    public static final int T26=26;
    public static final int RULE_INT=6;
    public static final int T32=32;
    public static final int T17=17;
    public static final int T16=16;
    public static final int T38=38;
    public static final int T41=41;
    public static final int T24=24;
    public static final int T19=19;
    public static final int T39=39;
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T11=11;
    public static final int T22=22;
    public static final int T12=12;
    public static final int T23=23;
    public static final int T28=28;
    public static final int T42=42;
    public static final int T40=40;
    public static final int T13=13;
    public static final int RULE_WS=9;
    public static final int T15=15;
    public static final int EOF=-1;
    public static final int Tokens=43;
    public static final int RULE_ANY_OTHER=10;
    public static final int T31=31;
    public static final int RULE_SL_COMMENT=8;
    public static final int T27=27;
    public static final int T30=30;
    public InternalXtextLexer() {;} 
    public InternalXtextLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:10:5: ( '?' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:10:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:11:5: ( '*' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:11:7: '*'
            {
            match('*'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:12:5: ( '+' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:12:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:13:5: ( '=' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:13:7: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:14:5: ( '+=' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:14:7: '+='
            {
            match("+="); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:15:5: ( '?=' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:15:7: '?='
            {
            match("?="); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:16:5: ( 'grammar' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:16:7: 'grammar'
            {
            match("grammar"); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:17:5: ( 'with' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:17:7: 'with'
            {
            match("with"); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:18:5: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:18:7: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:19:5: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:19:7: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:20:5: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:20:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:21:5: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:21:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:22:5: ( 'generate' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:22:7: 'generate'
            {
            match("generate"); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:23:5: ( 'as' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:23:7: 'as'
            {
            match("as"); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:24:5: ( 'import' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:24:7: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:25:5: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:25:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:26:5: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:26:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:27:5: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:27:7: 'returns'
            {
            match("returns"); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:28:5: ( '::' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:28:7: '::'
            {
            match("::"); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:29:5: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:29:7: '|'
            {
            match('|'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:30:5: ( '&' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:30:7: '&'
            {
            match('&'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:31:5: ( '{' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:31:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:32:5: ( '}' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:32:7: '}'
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
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:33:5: ( 'current' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:33:7: 'current'
            {
            match("current"); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:34:5: ( '[' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:34:7: '['
            {
            match('['); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:35:5: ( ']' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:35:7: ']'
            {
            match(']'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:36:5: ( 'terminal' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:36:7: 'terminal'
            {
            match("terminal"); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:37:5: ( '!' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:37:7: '!'
            {
            match('!'); 

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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:38:5: ( '->' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:38:7: '->'
            {
            match("->"); 


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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:39:5: ( '..' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:39:7: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:40:5: ( 'enum' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:40:7: 'enum'
            {
            match("enum"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:41:5: ( 'hidden' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:41:7: 'hidden'
            {
            match("hidden"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7186:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7186:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7186:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7186:11: '^'
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

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7186:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:
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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7188:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7188:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7188:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7188:13: '0' .. '9'
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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("7190:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7190:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7192:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7192:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7192:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7192:52: .
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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7194:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7194:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7194:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7194:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7194:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7194:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7194:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7194:41: '\\r'
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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7196:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7196:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7196:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:
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
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7198:16: ( . )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7198:18: .
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
        // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=39;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='?') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0=='*') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='+') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0=='=') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='g') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='w') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0==',') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0=='(') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0==')') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='.') ) {
            alt12 = mTokensHelper010();
        }
        else if ( (LA12_0=='a') ) {
            alt12 = mTokensHelper011();
        }
        else if ( (LA12_0=='i') ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0==':') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0==';') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='r') ) {
            alt12 = mTokensHelper015();
        }
        else if ( (LA12_0=='|') ) {
            alt12 = mTokensHelper016();
        }
        else if ( (LA12_0=='&') ) {
            alt12 = mTokensHelper017();
        }
        else if ( (LA12_0=='{') ) {
            alt12 = mTokensHelper018();
        }
        else if ( (LA12_0=='}') ) {
            alt12 = mTokensHelper019();
        }
        else if ( (LA12_0=='c') ) {
            alt12 = mTokensHelper020();
        }
        else if ( (LA12_0=='[') ) {
            alt12 = mTokensHelper021();
        }
        else if ( (LA12_0==']') ) {
            alt12 = mTokensHelper022();
        }
        else if ( (LA12_0=='t') ) {
            alt12 = mTokensHelper023();
        }
        else if ( (LA12_0=='!') ) {
            alt12 = mTokensHelper024();
        }
        else if ( (LA12_0=='-') ) {
            alt12 = mTokensHelper025();
        }
        else if ( (LA12_0=='e') ) {
            alt12 = mTokensHelper026();
        }
        else if ( (LA12_0=='h') ) {
            alt12 = mTokensHelper027();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper028();
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||LA12_0=='d'||LA12_0=='f'||(LA12_0>='j' && LA12_0<='q')||LA12_0=='s'||(LA12_0>='u' && LA12_0<='v')||(LA12_0>='x' && LA12_0<='z')) ) {
            alt12 = mTokensHelper029();
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12 = mTokensHelper030();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper031();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper032();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper033();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper034();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='#' && LA12_0<='%')||LA12_0=='<'||LA12_0=='>'||LA12_0=='@'||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper035();
        }
        else {
            alt12 = mTokensHelper036();
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:122: T39
                {
                mT39(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:126: T40
                {
                mT40(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:130: T41
                {
                mT41(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:134: T42
                {
                mT42(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:138: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:146: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:155: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:167: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:183: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:199: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1:207: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        int LA12_1 = input.LA(2);

        if ( (LA12_1=='=') ) {
            return 6;
        }
        else {
            return 1;}
    }

    private int mTokensHelper002() throws RecognitionException {
        return 2;
    }

    private int mTokensHelper003() throws RecognitionException {
        int LA12_3 = input.LA(2);

        if ( (LA12_3=='=') ) {
            return 5;
        }
        else {
            return 3;}
    }

    private int mTokensHelper004() throws RecognitionException {
        return 4;
    }

    private int mTokensHelper005() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'r':
            {
            int LA12_42 = input.LA(3);

            if ( (LA12_42=='a') ) {
                int LA12_74 = input.LA(4);

                if ( (LA12_74=='m') ) {
                    int LA12_84 = input.LA(5);

                    if ( (LA12_84=='m') ) {
                        int LA12_93 = input.LA(6);

                        if ( (LA12_93=='a') ) {
                            int LA12_102 = input.LA(7);

                            if ( (LA12_102=='r') ) {
                                int LA12_109 = input.LA(8);

                                if ( ((LA12_109>='0' && LA12_109<='9')||(LA12_109>='A' && LA12_109<='Z')||LA12_109=='_'||(LA12_109>='a' && LA12_109<='z')) ) {
                                    return 33;
                                }
                                else {
                                    return 7;}
                            }
                            else {
                                return 33;}
                        }
                        else {
                            return 33;}
                    }
                    else {
                        return 33;}
                }
                else {
                    return 33;}
            }
            else {
                return 33;}
            }
        case 'e':
            {
            int LA12_43 = input.LA(3);

            if ( (LA12_43=='n') ) {
                int LA12_75 = input.LA(4);

                if ( (LA12_75=='e') ) {
                    int LA12_85 = input.LA(5);

                    if ( (LA12_85=='r') ) {
                        int LA12_94 = input.LA(6);

                        if ( (LA12_94=='a') ) {
                            int LA12_103 = input.LA(7);

                            if ( (LA12_103=='t') ) {
                                int LA12_110 = input.LA(8);

                                if ( (LA12_110=='e') ) {
                                    int LA12_117 = input.LA(9);

                                    if ( ((LA12_117>='0' && LA12_117<='9')||(LA12_117>='A' && LA12_117<='Z')||LA12_117=='_'||(LA12_117>='a' && LA12_117<='z')) ) {
                                        return 33;
                                    }
                                    else {
                                        return 13;}
                                }
                                else {
                                    return 33;}
                            }
                            else {
                                return 33;}
                        }
                        else {
                            return 33;}
                    }
                    else {
                        return 33;}
                }
                else {
                    return 33;}
            }
            else {
                return 33;}
            }
        default:
            return 33;}

    }

    private int mTokensHelper006() throws RecognitionException {
        int LA12_6 = input.LA(2);

        if ( (LA12_6=='i') ) {
            int LA12_45 = input.LA(3);

            if ( (LA12_45=='t') ) {
                int LA12_76 = input.LA(4);

                if ( (LA12_76=='h') ) {
                    int LA12_86 = input.LA(5);

                    if ( ((LA12_86>='0' && LA12_86<='9')||(LA12_86>='A' && LA12_86<='Z')||LA12_86=='_'||(LA12_86>='a' && LA12_86<='z')) ) {
                        return 33;
                    }
                    else {
                        return 8;}
                }
                else {
                    return 33;}
            }
            else {
                return 33;}
        }
        else {
            return 33;}
    }

    private int mTokensHelper007() throws RecognitionException {
        return 9;
    }

    private int mTokensHelper008() throws RecognitionException {
        return 10;
    }

    private int mTokensHelper009() throws RecognitionException {
        return 11;
    }

    private int mTokensHelper010() throws RecognitionException {
        int LA12_10 = input.LA(2);

        if ( (LA12_10=='.') ) {
            return 30;
        }
        else {
            return 12;}
    }

    private int mTokensHelper011() throws RecognitionException {
        int LA12_11 = input.LA(2);

        if ( (LA12_11=='s') ) {
            int LA12_51 = input.LA(3);

            if ( ((LA12_51>='0' && LA12_51<='9')||(LA12_51>='A' && LA12_51<='Z')||LA12_51=='_'||(LA12_51>='a' && LA12_51<='z')) ) {
                return 33;
            }
            else {
                return 14;}
        }
        else {
            return 33;}
    }

    private int mTokensHelper012() throws RecognitionException {
        int LA12_12 = input.LA(2);

        if ( (LA12_12=='m') ) {
            int LA12_52 = input.LA(3);

            if ( (LA12_52=='p') ) {
                int LA12_78 = input.LA(4);

                if ( (LA12_78=='o') ) {
                    int LA12_87 = input.LA(5);

                    if ( (LA12_87=='r') ) {
                        int LA12_96 = input.LA(6);

                        if ( (LA12_96=='t') ) {
                            int LA12_104 = input.LA(7);

                            if ( ((LA12_104>='0' && LA12_104<='9')||(LA12_104>='A' && LA12_104<='Z')||LA12_104=='_'||(LA12_104>='a' && LA12_104<='z')) ) {
                                return 33;
                            }
                            else {
                                return 15;}
                        }
                        else {
                            return 33;}
                    }
                    else {
                        return 33;}
                }
                else {
                    return 33;}
            }
            else {
                return 33;}
        }
        else {
            return 33;}
    }

    private int mTokensHelper013() throws RecognitionException {
        int LA12_13 = input.LA(2);

        if ( (LA12_13==':') ) {
            return 19;
        }
        else {
            return 16;}
    }

    private int mTokensHelper014() throws RecognitionException {
        return 17;
    }

    private int mTokensHelper015() throws RecognitionException {
        int LA12_15 = input.LA(2);

        if ( (LA12_15=='e') ) {
            int LA12_56 = input.LA(3);

            if ( (LA12_56=='t') ) {
                int LA12_79 = input.LA(4);

                if ( (LA12_79=='u') ) {
                    int LA12_88 = input.LA(5);

                    if ( (LA12_88=='r') ) {
                        int LA12_97 = input.LA(6);

                        if ( (LA12_97=='n') ) {
                            int LA12_105 = input.LA(7);

                            if ( (LA12_105=='s') ) {
                                int LA12_112 = input.LA(8);

                                if ( ((LA12_112>='0' && LA12_112<='9')||(LA12_112>='A' && LA12_112<='Z')||LA12_112=='_'||(LA12_112>='a' && LA12_112<='z')) ) {
                                    return 33;
                                }
                                else {
                                    return 18;}
                            }
                            else {
                                return 33;}
                        }
                        else {
                            return 33;}
                    }
                    else {
                        return 33;}
                }
                else {
                    return 33;}
            }
            else {
                return 33;}
        }
        else {
            return 33;}
    }

    private int mTokensHelper016() throws RecognitionException {
        return 20;
    }

    private int mTokensHelper017() throws RecognitionException {
        return 21;
    }

    private int mTokensHelper018() throws RecognitionException {
        return 22;
    }

    private int mTokensHelper019() throws RecognitionException {
        return 23;
    }

    private int mTokensHelper020() throws RecognitionException {
        int LA12_20 = input.LA(2);

        if ( (LA12_20=='u') ) {
            int LA12_61 = input.LA(3);

            if ( (LA12_61=='r') ) {
                int LA12_80 = input.LA(4);

                if ( (LA12_80=='r') ) {
                    int LA12_89 = input.LA(5);

                    if ( (LA12_89=='e') ) {
                        int LA12_98 = input.LA(6);

                        if ( (LA12_98=='n') ) {
                            int LA12_106 = input.LA(7);

                            if ( (LA12_106=='t') ) {
                                int LA12_113 = input.LA(8);

                                if ( ((LA12_113>='0' && LA12_113<='9')||(LA12_113>='A' && LA12_113<='Z')||LA12_113=='_'||(LA12_113>='a' && LA12_113<='z')) ) {
                                    return 33;
                                }
                                else {
                                    return 24;}
                            }
                            else {
                                return 33;}
                        }
                        else {
                            return 33;}
                    }
                    else {
                        return 33;}
                }
                else {
                    return 33;}
            }
            else {
                return 33;}
        }
        else {
            return 33;}
    }

    private int mTokensHelper021() throws RecognitionException {
        return 25;
    }

    private int mTokensHelper022() throws RecognitionException {
        return 26;
    }

    private int mTokensHelper023() throws RecognitionException {
        int LA12_23 = input.LA(2);

        if ( (LA12_23=='e') ) {
            int LA12_64 = input.LA(3);

            if ( (LA12_64=='r') ) {
                int LA12_81 = input.LA(4);

                if ( (LA12_81=='m') ) {
                    int LA12_90 = input.LA(5);

                    if ( (LA12_90=='i') ) {
                        int LA12_99 = input.LA(6);

                        if ( (LA12_99=='n') ) {
                            int LA12_107 = input.LA(7);

                            if ( (LA12_107=='a') ) {
                                int LA12_114 = input.LA(8);

                                if ( (LA12_114=='l') ) {
                                    int LA12_120 = input.LA(9);

                                    if ( ((LA12_120>='0' && LA12_120<='9')||(LA12_120>='A' && LA12_120<='Z')||LA12_120=='_'||(LA12_120>='a' && LA12_120<='z')) ) {
                                        return 33;
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 33;}
                            }
                            else {
                                return 33;}
                        }
                        else {
                            return 33;}
                    }
                    else {
                        return 33;}
                }
                else {
                    return 33;}
            }
            else {
                return 33;}
        }
        else {
            return 33;}
    }

    private int mTokensHelper024() throws RecognitionException {
        return 28;
    }

    private int mTokensHelper025() throws RecognitionException {
        int LA12_25 = input.LA(2);

        if ( (LA12_25=='>') ) {
            return 29;
        }
        else {
            return 39;}
    }

    private int mTokensHelper026() throws RecognitionException {
        int LA12_26 = input.LA(2);

        if ( (LA12_26=='n') ) {
            int LA12_67 = input.LA(3);

            if ( (LA12_67=='u') ) {
                int LA12_82 = input.LA(4);

                if ( (LA12_82=='m') ) {
                    int LA12_91 = input.LA(5);

                    if ( ((LA12_91>='0' && LA12_91<='9')||(LA12_91>='A' && LA12_91<='Z')||LA12_91=='_'||(LA12_91>='a' && LA12_91<='z')) ) {
                        return 33;
                    }
                    else {
                        return 31;}
                }
                else {
                    return 33;}
            }
            else {
                return 33;}
        }
        else {
            return 33;}
    }

    private int mTokensHelper027() throws RecognitionException {
        int LA12_27 = input.LA(2);

        if ( (LA12_27=='i') ) {
            int LA12_68 = input.LA(3);

            if ( (LA12_68=='d') ) {
                int LA12_83 = input.LA(4);

                if ( (LA12_83=='d') ) {
                    int LA12_92 = input.LA(5);

                    if ( (LA12_92=='e') ) {
                        int LA12_101 = input.LA(6);

                        if ( (LA12_101=='n') ) {
                            int LA12_108 = input.LA(7);

                            if ( ((LA12_108>='0' && LA12_108<='9')||(LA12_108>='A' && LA12_108<='Z')||LA12_108=='_'||(LA12_108>='a' && LA12_108<='z')) ) {
                                return 33;
                            }
                            else {
                                return 32;}
                        }
                        else {
                            return 33;}
                    }
                    else {
                        return 33;}
                }
                else {
                    return 33;}
            }
            else {
                return 33;}
        }
        else {
            return 33;}
    }

    private int mTokensHelper028() throws RecognitionException {
        int LA12_28 = input.LA(2);

        if ( ((LA12_28>='A' && LA12_28<='Z')||LA12_28=='_'||(LA12_28>='a' && LA12_28<='z')) ) {
            return 33;
        }
        else {
            return 39;}
    }

    private int mTokensHelper029() throws RecognitionException {
        return 33;
    }

    private int mTokensHelper030() throws RecognitionException {
        return 34;
    }

    private int mTokensHelper031() throws RecognitionException {
        int LA12_31 = input.LA(2);

        if ( ((LA12_31>='\u0000' && LA12_31<='\uFFFE')) ) {
            return 35;
        }
        else {
            return 39;}
    }

    private int mTokensHelper032() throws RecognitionException {
        int LA12_32 = input.LA(2);

        if ( ((LA12_32>='\u0000' && LA12_32<='\uFFFE')) ) {
            return 35;
        }
        else {
            return 39;}
    }

    private int mTokensHelper033() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '/':
            {
            return 37;
            }
        case '*':
            {
            return 36;
            }
        default:
            return 39;}

    }

    private int mTokensHelper034() throws RecognitionException {
        return 38;
    }

    private int mTokensHelper035() throws RecognitionException {
        return 39;
    }

    private int mTokensHelper036() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}