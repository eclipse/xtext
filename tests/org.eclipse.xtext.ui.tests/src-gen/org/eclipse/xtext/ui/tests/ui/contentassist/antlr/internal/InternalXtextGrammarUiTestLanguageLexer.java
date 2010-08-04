package org.eclipse.xtext.ui.tests.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtextGrammarUiTestLanguageLexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int Tokens=42;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int T41=41;
    public static final int T23=23;
    public static final int T40=40;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_STRING=5;
    public static final int RULE_INT=6;
    public static final int T38=38;
    public static final int T11=11;
    public static final int T37=37;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T39=39;
    public static final int T14=14;
    public static final int T34=34;
    public static final int RULE_WS=9;
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
    public InternalXtextGrammarUiTestLanguageLexer() {;} 
    public InternalXtextGrammarUiTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:10:5: ( '?' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:10:7: '?'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:11:5: ( '*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:11:7: '*'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:12:5: ( '+' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:12:7: '+'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:13:5: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:13:7: '='
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:14:5: ( '+=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:14:7: '+='
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:15:5: ( '?=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:15:7: '?='
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:16:5: ( 'grammar' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:16:7: 'grammar'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:17:5: ( 'with' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:17:7: 'with'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:18:5: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:18:7: ','
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:19:5: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:19:7: '('
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:20:5: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:20:7: ')'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:21:5: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:21:7: '.'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:22:5: ( 'generate' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:22:7: 'generate'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:23:5: ( 'as' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:23:7: 'as'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:24:5: ( 'import' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:24:7: 'import'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:25:5: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:25:7: ':'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:26:5: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:26:7: ';'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:27:5: ( 'returns' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:27:7: 'returns'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:28:5: ( '::' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:28:7: '::'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:29:5: ( '|' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:29:7: '|'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:30:5: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:30:7: '{'
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
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:31:5: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:31:7: '}'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:32:5: ( 'current' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:32:7: 'current'
            {
            match("current"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:33:5: ( '[' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:33:7: '['
            {
            match('['); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:34:5: ( ']' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:34:7: ']'
            {
            match(']'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:35:5: ( 'terminal' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:35:7: 'terminal'
            {
            match("terminal"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:36:5: ( '!' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:36:7: '!'
            {
            match('!'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:37:5: ( '->' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:37:7: '->'
            {
            match("->"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:38:5: ( '..' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:38:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:39:5: ( 'enum' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:39:7: 'enum'
            {
            match("enum"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:40:5: ( 'hidden' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:40:7: 'hidden'
            {
            match("hidden"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7316:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7316:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7316:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7316:11: '^'
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7316:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7318:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7318:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7318:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7318:13: '0' .. '9'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("7320:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7320:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7322:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7322:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7322:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7322:52: .
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7324:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7324:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7324:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7324:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7324:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7324:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7324:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7324:41: '\\r'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7326:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7326:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7326:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7328:16: ( . )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7328:18: .
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
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=38;
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
        else if ( (LA12_0=='{') ) {
            alt12 = mTokensHelper017();
        }
        else if ( (LA12_0=='}') ) {
            alt12 = mTokensHelper018();
        }
        else if ( (LA12_0=='c') ) {
            alt12 = mTokensHelper019();
        }
        else if ( (LA12_0=='[') ) {
            alt12 = mTokensHelper020();
        }
        else if ( (LA12_0==']') ) {
            alt12 = mTokensHelper021();
        }
        else if ( (LA12_0=='t') ) {
            alt12 = mTokensHelper022();
        }
        else if ( (LA12_0=='!') ) {
            alt12 = mTokensHelper023();
        }
        else if ( (LA12_0=='-') ) {
            alt12 = mTokensHelper024();
        }
        else if ( (LA12_0=='e') ) {
            alt12 = mTokensHelper025();
        }
        else if ( (LA12_0=='h') ) {
            alt12 = mTokensHelper026();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper027();
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||LA12_0=='d'||LA12_0=='f'||(LA12_0>='j' && LA12_0<='q')||LA12_0=='s'||(LA12_0>='u' && LA12_0<='v')||(LA12_0>='x' && LA12_0<='z')) ) {
            alt12 = mTokensHelper028();
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12 = mTokensHelper029();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper030();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper031();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper032();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper033();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='#' && LA12_0<='&')||LA12_0=='<'||LA12_0=='>'||LA12_0=='@'||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper034();
        }
        else {
            alt12 = mTokensHelper035();
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:122: T39
                {
                mT39(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:126: T40
                {
                mT40(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:130: T41
                {
                mT41(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:134: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:142: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:151: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:163: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:179: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:195: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1:203: RULE_ANY_OTHER
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
            int LA12_41 = input.LA(3);

            if ( (LA12_41=='a') ) {
                int LA12_72 = input.LA(4);

                if ( (LA12_72=='m') ) {
                    int LA12_82 = input.LA(5);

                    if ( (LA12_82=='m') ) {
                        int LA12_91 = input.LA(6);

                        if ( (LA12_91=='a') ) {
                            int LA12_100 = input.LA(7);

                            if ( (LA12_100=='r') ) {
                                int LA12_107 = input.LA(8);

                                if ( ((LA12_107>='0' && LA12_107<='9')||(LA12_107>='A' && LA12_107<='Z')||LA12_107=='_'||(LA12_107>='a' && LA12_107<='z')) ) {
                                    return 32;
                                }
                                else {
                                    return 7;}
                            }
                            else {
                                return 32;}
                        }
                        else {
                            return 32;}
                    }
                    else {
                        return 32;}
                }
                else {
                    return 32;}
            }
            else {
                return 32;}
            }
        case 'e':
            {
            int LA12_42 = input.LA(3);

            if ( (LA12_42=='n') ) {
                int LA12_73 = input.LA(4);

                if ( (LA12_73=='e') ) {
                    int LA12_83 = input.LA(5);

                    if ( (LA12_83=='r') ) {
                        int LA12_92 = input.LA(6);

                        if ( (LA12_92=='a') ) {
                            int LA12_101 = input.LA(7);

                            if ( (LA12_101=='t') ) {
                                int LA12_108 = input.LA(8);

                                if ( (LA12_108=='e') ) {
                                    int LA12_115 = input.LA(9);

                                    if ( ((LA12_115>='0' && LA12_115<='9')||(LA12_115>='A' && LA12_115<='Z')||LA12_115=='_'||(LA12_115>='a' && LA12_115<='z')) ) {
                                        return 32;
                                    }
                                    else {
                                        return 13;}
                                }
                                else {
                                    return 32;}
                            }
                            else {
                                return 32;}
                        }
                        else {
                            return 32;}
                    }
                    else {
                        return 32;}
                }
                else {
                    return 32;}
            }
            else {
                return 32;}
            }
        default:
            return 32;}

    }

    private int mTokensHelper006() throws RecognitionException {
        int LA12_6 = input.LA(2);

        if ( (LA12_6=='i') ) {
            int LA12_44 = input.LA(3);

            if ( (LA12_44=='t') ) {
                int LA12_74 = input.LA(4);

                if ( (LA12_74=='h') ) {
                    int LA12_84 = input.LA(5);

                    if ( ((LA12_84>='0' && LA12_84<='9')||(LA12_84>='A' && LA12_84<='Z')||LA12_84=='_'||(LA12_84>='a' && LA12_84<='z')) ) {
                        return 32;
                    }
                    else {
                        return 8;}
                }
                else {
                    return 32;}
            }
            else {
                return 32;}
        }
        else {
            return 32;}
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
            return 29;
        }
        else {
            return 12;}
    }

    private int mTokensHelper011() throws RecognitionException {
        int LA12_11 = input.LA(2);

        if ( (LA12_11=='s') ) {
            int LA12_50 = input.LA(3);

            if ( ((LA12_50>='0' && LA12_50<='9')||(LA12_50>='A' && LA12_50<='Z')||LA12_50=='_'||(LA12_50>='a' && LA12_50<='z')) ) {
                return 32;
            }
            else {
                return 14;}
        }
        else {
            return 32;}
    }

    private int mTokensHelper012() throws RecognitionException {
        int LA12_12 = input.LA(2);

        if ( (LA12_12=='m') ) {
            int LA12_51 = input.LA(3);

            if ( (LA12_51=='p') ) {
                int LA12_76 = input.LA(4);

                if ( (LA12_76=='o') ) {
                    int LA12_85 = input.LA(5);

                    if ( (LA12_85=='r') ) {
                        int LA12_94 = input.LA(6);

                        if ( (LA12_94=='t') ) {
                            int LA12_102 = input.LA(7);

                            if ( ((LA12_102>='0' && LA12_102<='9')||(LA12_102>='A' && LA12_102<='Z')||LA12_102=='_'||(LA12_102>='a' && LA12_102<='z')) ) {
                                return 32;
                            }
                            else {
                                return 15;}
                        }
                        else {
                            return 32;}
                    }
                    else {
                        return 32;}
                }
                else {
                    return 32;}
            }
            else {
                return 32;}
        }
        else {
            return 32;}
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
            int LA12_55 = input.LA(3);

            if ( (LA12_55=='t') ) {
                int LA12_77 = input.LA(4);

                if ( (LA12_77=='u') ) {
                    int LA12_86 = input.LA(5);

                    if ( (LA12_86=='r') ) {
                        int LA12_95 = input.LA(6);

                        if ( (LA12_95=='n') ) {
                            int LA12_103 = input.LA(7);

                            if ( (LA12_103=='s') ) {
                                int LA12_110 = input.LA(8);

                                if ( ((LA12_110>='0' && LA12_110<='9')||(LA12_110>='A' && LA12_110<='Z')||LA12_110=='_'||(LA12_110>='a' && LA12_110<='z')) ) {
                                    return 32;
                                }
                                else {
                                    return 18;}
                            }
                            else {
                                return 32;}
                        }
                        else {
                            return 32;}
                    }
                    else {
                        return 32;}
                }
                else {
                    return 32;}
            }
            else {
                return 32;}
        }
        else {
            return 32;}
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
        int LA12_19 = input.LA(2);

        if ( (LA12_19=='u') ) {
            int LA12_59 = input.LA(3);

            if ( (LA12_59=='r') ) {
                int LA12_78 = input.LA(4);

                if ( (LA12_78=='r') ) {
                    int LA12_87 = input.LA(5);

                    if ( (LA12_87=='e') ) {
                        int LA12_96 = input.LA(6);

                        if ( (LA12_96=='n') ) {
                            int LA12_104 = input.LA(7);

                            if ( (LA12_104=='t') ) {
                                int LA12_111 = input.LA(8);

                                if ( ((LA12_111>='0' && LA12_111<='9')||(LA12_111>='A' && LA12_111<='Z')||LA12_111=='_'||(LA12_111>='a' && LA12_111<='z')) ) {
                                    return 32;
                                }
                                else {
                                    return 23;}
                            }
                            else {
                                return 32;}
                        }
                        else {
                            return 32;}
                    }
                    else {
                        return 32;}
                }
                else {
                    return 32;}
            }
            else {
                return 32;}
        }
        else {
            return 32;}
    }

    private int mTokensHelper020() throws RecognitionException {
        return 24;
    }

    private int mTokensHelper021() throws RecognitionException {
        return 25;
    }

    private int mTokensHelper022() throws RecognitionException {
        int LA12_22 = input.LA(2);

        if ( (LA12_22=='e') ) {
            int LA12_62 = input.LA(3);

            if ( (LA12_62=='r') ) {
                int LA12_79 = input.LA(4);

                if ( (LA12_79=='m') ) {
                    int LA12_88 = input.LA(5);

                    if ( (LA12_88=='i') ) {
                        int LA12_97 = input.LA(6);

                        if ( (LA12_97=='n') ) {
                            int LA12_105 = input.LA(7);

                            if ( (LA12_105=='a') ) {
                                int LA12_112 = input.LA(8);

                                if ( (LA12_112=='l') ) {
                                    int LA12_118 = input.LA(9);

                                    if ( ((LA12_118>='0' && LA12_118<='9')||(LA12_118>='A' && LA12_118<='Z')||LA12_118=='_'||(LA12_118>='a' && LA12_118<='z')) ) {
                                        return 32;
                                    }
                                    else {
                                        return 26;}
                                }
                                else {
                                    return 32;}
                            }
                            else {
                                return 32;}
                        }
                        else {
                            return 32;}
                    }
                    else {
                        return 32;}
                }
                else {
                    return 32;}
            }
            else {
                return 32;}
        }
        else {
            return 32;}
    }

    private int mTokensHelper023() throws RecognitionException {
        return 27;
    }

    private int mTokensHelper024() throws RecognitionException {
        int LA12_24 = input.LA(2);

        if ( (LA12_24=='>') ) {
            return 28;
        }
        else {
            return 38;}
    }

    private int mTokensHelper025() throws RecognitionException {
        int LA12_25 = input.LA(2);

        if ( (LA12_25=='n') ) {
            int LA12_65 = input.LA(3);

            if ( (LA12_65=='u') ) {
                int LA12_80 = input.LA(4);

                if ( (LA12_80=='m') ) {
                    int LA12_89 = input.LA(5);

                    if ( ((LA12_89>='0' && LA12_89<='9')||(LA12_89>='A' && LA12_89<='Z')||LA12_89=='_'||(LA12_89>='a' && LA12_89<='z')) ) {
                        return 32;
                    }
                    else {
                        return 30;}
                }
                else {
                    return 32;}
            }
            else {
                return 32;}
        }
        else {
            return 32;}
    }

    private int mTokensHelper026() throws RecognitionException {
        int LA12_26 = input.LA(2);

        if ( (LA12_26=='i') ) {
            int LA12_66 = input.LA(3);

            if ( (LA12_66=='d') ) {
                int LA12_81 = input.LA(4);

                if ( (LA12_81=='d') ) {
                    int LA12_90 = input.LA(5);

                    if ( (LA12_90=='e') ) {
                        int LA12_99 = input.LA(6);

                        if ( (LA12_99=='n') ) {
                            int LA12_106 = input.LA(7);

                            if ( ((LA12_106>='0' && LA12_106<='9')||(LA12_106>='A' && LA12_106<='Z')||LA12_106=='_'||(LA12_106>='a' && LA12_106<='z')) ) {
                                return 32;
                            }
                            else {
                                return 31;}
                        }
                        else {
                            return 32;}
                    }
                    else {
                        return 32;}
                }
                else {
                    return 32;}
            }
            else {
                return 32;}
        }
        else {
            return 32;}
    }

    private int mTokensHelper027() throws RecognitionException {
        int LA12_27 = input.LA(2);

        if ( ((LA12_27>='A' && LA12_27<='Z')||LA12_27=='_'||(LA12_27>='a' && LA12_27<='z')) ) {
            return 32;
        }
        else {
            return 38;}
    }

    private int mTokensHelper028() throws RecognitionException {
        return 32;
    }

    private int mTokensHelper029() throws RecognitionException {
        return 33;
    }

    private int mTokensHelper030() throws RecognitionException {
        int LA12_30 = input.LA(2);

        if ( ((LA12_30>='\u0000' && LA12_30<='\uFFFE')) ) {
            return 34;
        }
        else {
            return 38;}
    }

    private int mTokensHelper031() throws RecognitionException {
        int LA12_31 = input.LA(2);

        if ( ((LA12_31>='\u0000' && LA12_31<='\uFFFE')) ) {
            return 34;
        }
        else {
            return 38;}
    }

    private int mTokensHelper032() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '/':
            {
            return 36;
            }
        case '*':
            {
            return 35;
            }
        default:
            return 38;}

    }

    private int mTokensHelper033() throws RecognitionException {
        return 37;
    }

    private int mTokensHelper034() throws RecognitionException {
        return 38;
    }

    private int mTokensHelper035() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}