package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBacktrackingContentAssistTestLanguageLexer extends Lexer {
    public static final int T75=75;
    public static final int T76=76;
    public static final int T73=73;
    public static final int RULE_ID=5;
    public static final int T74=74;
    public static final int T79=79;
    public static final int T77=77;
    public static final int T78=78;
    public static final int RULE_ANY_OTHER=10;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int EOF=-1;
    public static final int T24=24;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T72=72;
    public static final int T21=21;
    public static final int T71=71;
    public static final int T20=20;
    public static final int T70=70;
    public static final int T62=62;
    public static final int T63=63;
    public static final int T64=64;
    public static final int T65=65;
    public static final int T66=66;
    public static final int T67=67;
    public static final int T68=68;
    public static final int T69=69;
    public static final int RULE_INT=4;
    public static final int T38=38;
    public static final int T37=37;
    public static final int T39=39;
    public static final int T34=34;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int T30=30;
    public static final int T61=61;
    public static final int T32=32;
    public static final int T60=60;
    public static final int T31=31;
    public static final int T49=49;
    public static final int T48=48;
    public static final int T43=43;
    public static final int Tokens=82;
    public static final int RULE_SL_COMMENT=8;
    public static final int T42=42;
    public static final int T41=41;
    public static final int T40=40;
    public static final int T47=47;
    public static final int T46=46;
    public static final int T45=45;
    public static final int RULE_ML_COMMENT=7;
    public static final int T44=44;
    public static final int RULE_STRING=6;
    public static final int T50=50;
    public static final int T59=59;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T81=81;
    public static final int T52=52;
    public static final int T15=15;
    public static final int RULE_WS=9;
    public static final int T80=80;
    public static final int T51=51;
    public static final int T16=16;
    public static final int T54=54;
    public static final int T17=17;
    public static final int T53=53;
    public static final int T18=18;
    public static final int T56=56;
    public static final int T19=19;
    public static final int T55=55;
    public static final int T58=58;
    public static final int T57=57;
    public InternalBacktrackingContentAssistTestLanguageLexer() {;} 
    public InternalBacktrackingContentAssistTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:10:5: ( 'body' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:10:7: 'body'
            {
            match("body"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:11:5: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:11:7: ':'
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
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:12:5: ( 'context' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:12:7: 'context'
            {
            match("context"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:13:5: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:13:7: 'static'
            {
            match("static"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:14:5: ( 'def' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:14:7: 'def'
            {
            match("def"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:15:5: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:15:7: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:16:5: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:16:7: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:17:5: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:17:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:18:5: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:18:7: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:19:5: ( 'derive' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:19:7: 'derive'
            {
            match("derive"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:20:5: ( 'init' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:20:7: 'init'
            {
            match("init"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:21:5: ( 'inv' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:21:7: 'inv'
            {
            match("inv"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:22:5: ( 'package' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:22:7: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:23:5: ( 'endpackage' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:23:7: 'endpackage'
            {
            match("endpackage"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:24:5: ( 'post' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:24:7: 'post'
            {
            match("post"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:25:5: ( 'pre' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:25:7: 'pre'
            {
            match("pre"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:26:5: ( '::' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:26:7: '::'
            {
            match("::"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:27:5: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:27:7: '.'
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
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:28:5: ( '->' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:28:7: '->'
            {
            match("->"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:29:5: ( '^^' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:29:7: '^^'
            {
            match("^^"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:30:5: ( '^' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:30:7: '^'
            {
            match('^'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:31:5: ( '?' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:31:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:32:5: ( 'e' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:32:7: 'e'
            {
            match('e'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:33:5: ( 'E' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:33:7: 'E'
            {
            match('E'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:34:5: ( '+' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:34:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:35:5: ( '-' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:35:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:36:5: ( 'Boolean' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:36:7: 'Boolean'
            {
            match("Boolean"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:37:5: ( 'Integer' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:37:7: 'Integer'
            {
            match("Integer"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:38:5: ( 'Real' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:38:7: 'Real'
            {
            match("Real"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:39:5: ( 'String' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:39:7: 'String'
            {
            match("String"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:40:5: ( 'UnlimitedNatural' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:40:7: 'UnlimitedNatural'
            {
            match("UnlimitedNatural"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:41:5: ( 'OclAny' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:41:7: 'OclAny'
            {
            match("OclAny"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:42:5: ( 'OclInvalid' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:42:7: 'OclInvalid'
            {
            match("OclInvalid"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:43:5: ( 'OclVoid' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:43:7: 'OclVoid'
            {
            match("OclVoid"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:44:5: ( 'Set' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:44:7: 'Set'
            {
            match("Set"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:45:5: ( 'Bag' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:45:7: 'Bag'
            {
            match("Bag"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:46:5: ( 'Sequence' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:46:7: 'Sequence'
            {
            match("Sequence"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:47:5: ( 'Collection' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:47:7: 'Collection'
            {
            match("Collection"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:48:5: ( 'OrderedSet' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:48:7: 'OrderedSet'
            {
            match("OrderedSet"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:49:5: ( 'Tuple' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:49:7: 'Tuple'
            {
            match("Tuple"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public final void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:50:5: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:50:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start T52
    public final void mT52() throws RecognitionException {
        try {
            int _type = T52;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:51:5: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:51:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T52

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:52:5: ( '..' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:52:7: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:53:5: ( 'true' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:53:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start T55
    public final void mT55() throws RecognitionException {
        try {
            int _type = T55;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:54:5: ( 'false' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:54:7: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T55

    // $ANTLR start T56
    public final void mT56() throws RecognitionException {
        try {
            int _type = T56;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:55:5: ( 'invalid' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:55:7: 'invalid'
            {
            match("invalid"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T56

    // $ANTLR start T57
    public final void mT57() throws RecognitionException {
        try {
            int _type = T57;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:56:5: ( 'null' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:56:7: 'null'
            {
            match("null"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T57

    // $ANTLR start T58
    public final void mT58() throws RecognitionException {
        try {
            int _type = T58;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:57:5: ( 'implies' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:57:7: 'implies'
            {
            match("implies"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T58

    // $ANTLR start T59
    public final void mT59() throws RecognitionException {
        try {
            int _type = T59;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:58:5: ( 'xor' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:58:7: 'xor'
            {
            match("xor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T59

    // $ANTLR start T60
    public final void mT60() throws RecognitionException {
        try {
            int _type = T60;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:59:5: ( 'or' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:59:7: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T60

    // $ANTLR start T61
    public final void mT61() throws RecognitionException {
        try {
            int _type = T61;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:60:5: ( 'and' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:60:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T61

    // $ANTLR start T62
    public final void mT62() throws RecognitionException {
        try {
            int _type = T62;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:61:5: ( '<>' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:61:7: '<>'
            {
            match("<>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T62

    // $ANTLR start T63
    public final void mT63() throws RecognitionException {
        try {
            int _type = T63;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:62:5: ( '>' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:62:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T63

    // $ANTLR start T64
    public final void mT64() throws RecognitionException {
        try {
            int _type = T64;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:63:5: ( '<' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:63:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T64

    // $ANTLR start T65
    public final void mT65() throws RecognitionException {
        try {
            int _type = T65;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:64:5: ( '>=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:64:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T65

    // $ANTLR start T66
    public final void mT66() throws RecognitionException {
        try {
            int _type = T66;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:65:5: ( '<=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:65:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T66

    // $ANTLR start T67
    public final void mT67() throws RecognitionException {
        try {
            int _type = T67;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:66:5: ( '*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:66:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T67

    // $ANTLR start T68
    public final void mT68() throws RecognitionException {
        try {
            int _type = T68;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:67:5: ( '/' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:67:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T68

    // $ANTLR start T69
    public final void mT69() throws RecognitionException {
        try {
            int _type = T69;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:68:5: ( 'not' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:68:7: 'not'
            {
            match("not"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T69

    // $ANTLR start T70
    public final void mT70() throws RecognitionException {
        try {
            int _type = T70;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:69:5: ( '@' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:69:7: '@'
            {
            match('@'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T70

    // $ANTLR start T71
    public final void mT71() throws RecognitionException {
        try {
            int _type = T71;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:70:5: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:70:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T71

    // $ANTLR start T72
    public final void mT72() throws RecognitionException {
        try {
            int _type = T72;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:71:5: ( '|' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:71:7: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T72

    // $ANTLR start T73
    public final void mT73() throws RecognitionException {
        try {
            int _type = T73;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:72:5: ( '[' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:72:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T73

    // $ANTLR start T74
    public final void mT74() throws RecognitionException {
        try {
            int _type = T74;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:73:5: ( ']' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:73:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T74

    // $ANTLR start T75
    public final void mT75() throws RecognitionException {
        try {
            int _type = T75;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:74:5: ( 'self' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:74:7: 'self'
            {
            match("self"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T75

    // $ANTLR start T76
    public final void mT76() throws RecognitionException {
        try {
            int _type = T76;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:75:5: ( 'if' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:75:7: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T76

    // $ANTLR start T77
    public final void mT77() throws RecognitionException {
        try {
            int _type = T77;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:76:5: ( 'then' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:76:7: 'then'
            {
            match("then"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T77

    // $ANTLR start T78
    public final void mT78() throws RecognitionException {
        try {
            int _type = T78;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:77:5: ( 'else' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:77:7: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T78

    // $ANTLR start T79
    public final void mT79() throws RecognitionException {
        try {
            int _type = T79;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:78:5: ( 'endif' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:78:7: 'endif'
            {
            match("endif"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T79

    // $ANTLR start T80
    public final void mT80() throws RecognitionException {
        try {
            int _type = T80;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:79:5: ( 'let' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:79:7: 'let'
            {
            match("let"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T80

    // $ANTLR start T81
    public final void mT81() throws RecognitionException {
        try {
            int _type = T81;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:80:5: ( 'in' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:80:7: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T81

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6917:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6917:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6917:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6917:11: '^'
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6917:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6919:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6919:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6919:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6919:13: '0' .. '9'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("6921:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6921:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6923:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6923:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6923:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6923:52: .
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6925:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6925:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6925:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6925:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6925:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6925:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6925:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6925:41: '\\r'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6927:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6927:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6927:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6929:16: ( . )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:6929:18: .
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
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=78;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='b') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0==':') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='c') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0=='s') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='d') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='(') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0==',') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0==')') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0=='=') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='i') ) {
            alt12 = mTokensHelper010();
        }
        else if ( (LA12_0=='p') ) {
            alt12 = mTokensHelper011();
        }
        else if ( (LA12_0=='e') ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0=='.') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0=='-') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper015();
        }
        else if ( (LA12_0=='?') ) {
            alt12 = mTokensHelper016();
        }
        else if ( (LA12_0=='E') ) {
            alt12 = mTokensHelper017();
        }
        else if ( (LA12_0=='+') ) {
            alt12 = mTokensHelper018();
        }
        else if ( (LA12_0=='B') ) {
            alt12 = mTokensHelper019();
        }
        else if ( (LA12_0=='I') ) {
            alt12 = mTokensHelper020();
        }
        else if ( (LA12_0=='R') ) {
            alt12 = mTokensHelper021();
        }
        else if ( (LA12_0=='S') ) {
            alt12 = mTokensHelper022();
        }
        else if ( (LA12_0=='U') ) {
            alt12 = mTokensHelper023();
        }
        else if ( (LA12_0=='O') ) {
            alt12 = mTokensHelper024();
        }
        else if ( (LA12_0=='C') ) {
            alt12 = mTokensHelper025();
        }
        else if ( (LA12_0=='T') ) {
            alt12 = mTokensHelper026();
        }
        else if ( (LA12_0=='{') ) {
            alt12 = mTokensHelper027();
        }
        else if ( (LA12_0=='}') ) {
            alt12 = mTokensHelper028();
        }
        else if ( (LA12_0=='t') ) {
            alt12 = mTokensHelper029();
        }
        else if ( (LA12_0=='f') ) {
            alt12 = mTokensHelper030();
        }
        else if ( (LA12_0=='n') ) {
            alt12 = mTokensHelper031();
        }
        else if ( (LA12_0=='x') ) {
            alt12 = mTokensHelper032();
        }
        else if ( (LA12_0=='o') ) {
            alt12 = mTokensHelper033();
        }
        else if ( (LA12_0=='a') ) {
            alt12 = mTokensHelper034();
        }
        else if ( (LA12_0=='<') ) {
            alt12 = mTokensHelper035();
        }
        else if ( (LA12_0=='>') ) {
            alt12 = mTokensHelper036();
        }
        else if ( (LA12_0=='*') ) {
            alt12 = mTokensHelper037();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper038();
        }
        else if ( (LA12_0=='@') ) {
            alt12 = mTokensHelper039();
        }
        else if ( (LA12_0==';') ) {
            alt12 = mTokensHelper040();
        }
        else if ( (LA12_0=='|') ) {
            alt12 = mTokensHelper041();
        }
        else if ( (LA12_0=='[') ) {
            alt12 = mTokensHelper042();
        }
        else if ( (LA12_0==']') ) {
            alt12 = mTokensHelper043();
        }
        else if ( (LA12_0=='l') ) {
            alt12 = mTokensHelper044();
        }
        else if ( (LA12_0=='A'||LA12_0=='D'||(LA12_0>='F' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='N')||(LA12_0>='P' && LA12_0<='Q')||(LA12_0>='V' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||LA12_0=='m'||(LA12_0>='q' && LA12_0<='r')||(LA12_0>='u' && LA12_0<='w')||(LA12_0>='y' && LA12_0<='z')) ) {
            alt12 = mTokensHelper045();
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12 = mTokensHelper046();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper047();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper048();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper049();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper050();
        }
        else {
            alt12 = mTokensHelper051();
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:122: T39
                {
                mT39(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:126: T40
                {
                mT40(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:130: T41
                {
                mT41(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:134: T42
                {
                mT42(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:138: T43
                {
                mT43(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:142: T44
                {
                mT44(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:146: T45
                {
                mT45(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:150: T46
                {
                mT46(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:154: T47
                {
                mT47(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:158: T48
                {
                mT48(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:162: T49
                {
                mT49(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:166: T50
                {
                mT50(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:170: T51
                {
                mT51(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:174: T52
                {
                mT52(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:178: T53
                {
                mT53(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:182: T54
                {
                mT54(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:186: T55
                {
                mT55(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:190: T56
                {
                mT56(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:194: T57
                {
                mT57(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:198: T58
                {
                mT58(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:202: T59
                {
                mT59(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:206: T60
                {
                mT60(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:210: T61
                {
                mT61(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:214: T62
                {
                mT62(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:218: T63
                {
                mT63(); 

                }
                break;
            case 54 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:222: T64
                {
                mT64(); 

                }
                break;
            case 55 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:226: T65
                {
                mT65(); 

                }
                break;
            case 56 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:230: T66
                {
                mT66(); 

                }
                break;
            case 57 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:234: T67
                {
                mT67(); 

                }
                break;
            case 58 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:238: T68
                {
                mT68(); 

                }
                break;
            case 59 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:242: T69
                {
                mT69(); 

                }
                break;
            case 60 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:246: T70
                {
                mT70(); 

                }
                break;
            case 61 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:250: T71
                {
                mT71(); 

                }
                break;
            case 62 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:254: T72
                {
                mT72(); 

                }
                break;
            case 63 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:258: T73
                {
                mT73(); 

                }
                break;
            case 64 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:262: T74
                {
                mT74(); 

                }
                break;
            case 65 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:266: T75
                {
                mT75(); 

                }
                break;
            case 66 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:270: T76
                {
                mT76(); 

                }
                break;
            case 67 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:274: T77
                {
                mT77(); 

                }
                break;
            case 68 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:278: T78
                {
                mT78(); 

                }
                break;
            case 69 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:282: T79
                {
                mT79(); 

                }
                break;
            case 70 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:286: T80
                {
                mT80(); 

                }
                break;
            case 71 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:290: T81
                {
                mT81(); 

                }
                break;
            case 72 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:294: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 73 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:302: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 74 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:311: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 75 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:323: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 76 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:339: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 77 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:355: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 78 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBacktrackingContentAssistTestLanguage.g:1:363: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        int LA12_1 = input.LA(2);

        if ( (LA12_1=='o') ) {
            int LA12_51 = input.LA(3);

            if ( (LA12_51=='d') ) {
                int LA12_120 = input.LA(4);

                if ( (LA12_120=='y') ) {
                    int LA12_157 = input.LA(5);

                    if ( ((LA12_157>='0' && LA12_157<='9')||(LA12_157>='A' && LA12_157<='Z')||LA12_157=='_'||(LA12_157>='a' && LA12_157<='z')) ) {
                        return 72;
                    }
                    else {
                        return 1;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper002() throws RecognitionException {
        int LA12_2 = input.LA(2);

        if ( (LA12_2==':') ) {
            return 17;
        }
        else {
            return 2;}
    }

    private int mTokensHelper003() throws RecognitionException {
        int LA12_3 = input.LA(2);

        if ( (LA12_3=='o') ) {
            int LA12_55 = input.LA(3);

            if ( (LA12_55=='n') ) {
                int LA12_121 = input.LA(4);

                if ( (LA12_121=='t') ) {
                    int LA12_158 = input.LA(5);

                    if ( (LA12_158=='e') ) {
                        int LA12_196 = input.LA(6);

                        if ( (LA12_196=='x') ) {
                            int LA12_224 = input.LA(7);

                            if ( (LA12_224=='t') ) {
                                int LA12_244 = input.LA(8);

                                if ( ((LA12_244>='0' && LA12_244<='9')||(LA12_244>='A' && LA12_244<='Z')||LA12_244=='_'||(LA12_244>='a' && LA12_244<='z')) ) {
                                    return 72;
                                }
                                else {
                                    return 3;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper004() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'e':
            {
            int LA12_56 = input.LA(3);

            if ( (LA12_56=='l') ) {
                int LA12_122 = input.LA(4);

                if ( (LA12_122=='f') ) {
                    int LA12_159 = input.LA(5);

                    if ( ((LA12_159>='0' && LA12_159<='9')||(LA12_159>='A' && LA12_159<='Z')||LA12_159=='_'||(LA12_159>='a' && LA12_159<='z')) ) {
                        return 72;
                    }
                    else {
                        return 65;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        case 't':
            {
            int LA12_57 = input.LA(3);

            if ( (LA12_57=='a') ) {
                int LA12_123 = input.LA(4);

                if ( (LA12_123=='t') ) {
                    int LA12_160 = input.LA(5);

                    if ( (LA12_160=='i') ) {
                        int LA12_198 = input.LA(6);

                        if ( (LA12_198=='c') ) {
                            int LA12_225 = input.LA(7);

                            if ( ((LA12_225>='0' && LA12_225<='9')||(LA12_225>='A' && LA12_225<='Z')||LA12_225=='_'||(LA12_225>='a' && LA12_225<='z')) ) {
                                return 72;
                            }
                            else {
                                return 4;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        default:
            return 72;}

    }

    private int mTokensHelper005() throws RecognitionException {
        int LA12_5 = input.LA(2);

        if ( (LA12_5=='e') ) {
            switch ( input.LA(3) ) {
            case 'f':
                {
                int LA12_124 = input.LA(4);

                if ( ((LA12_124>='0' && LA12_124<='9')||(LA12_124>='A' && LA12_124<='Z')||LA12_124=='_'||(LA12_124>='a' && LA12_124<='z')) ) {
                    return 72;
                }
                else {
                    return 5;}
                }
            case 'r':
                {
                int LA12_125 = input.LA(4);

                if ( (LA12_125=='i') ) {
                    int LA12_162 = input.LA(5);

                    if ( (LA12_162=='v') ) {
                        int LA12_199 = input.LA(6);

                        if ( (LA12_199=='e') ) {
                            int LA12_226 = input.LA(7);

                            if ( ((LA12_226>='0' && LA12_226<='9')||(LA12_226>='A' && LA12_226<='Z')||LA12_226=='_'||(LA12_226>='a' && LA12_226<='z')) ) {
                                return 72;
                            }
                            else {
                                return 10;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
                }
            default:
                return 72;}

        }
        else {
            return 72;}
    }

    private int mTokensHelper006() throws RecognitionException {
        return 6;
    }

    private int mTokensHelper007() throws RecognitionException {
        return 7;
    }

    private int mTokensHelper008() throws RecognitionException {
        return 8;
    }

    private int mTokensHelper009() throws RecognitionException {
        return 9;
    }

    private int mTokensHelper010() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'n':
            {
            switch ( input.LA(3) ) {
            case 'v':
                {
                switch ( input.LA(4) ) {
                case 'a':
                    {
                    int LA12_163 = input.LA(5);

                    if ( (LA12_163=='l') ) {
                        int LA12_200 = input.LA(6);

                        if ( (LA12_200=='i') ) {
                            int LA12_227 = input.LA(7);

                            if ( (LA12_227=='d') ) {
                                int LA12_247 = input.LA(8);

                                if ( ((LA12_247>='0' && LA12_247<='9')||(LA12_247>='A' && LA12_247<='Z')||LA12_247=='_'||(LA12_247>='a' && LA12_247<='z')) ) {
                                    return 72;
                                }
                                else {
                                    return 46;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
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
                case '_':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    return 72;
                    }
                default:
                    return 12;}

                }
            case 'i':
                {
                int LA12_127 = input.LA(4);

                if ( (LA12_127=='t') ) {
                    int LA12_165 = input.LA(5);

                    if ( ((LA12_165>='0' && LA12_165<='9')||(LA12_165>='A' && LA12_165<='Z')||LA12_165=='_'||(LA12_165>='a' && LA12_165<='z')) ) {
                        return 72;
                    }
                    else {
                        return 11;}
                }
                else {
                    return 72;}
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
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                return 72;
                }
            default:
                return 71;}

            }
        case 'm':
            {
            int LA12_64 = input.LA(3);

            if ( (LA12_64=='p') ) {
                int LA12_129 = input.LA(4);

                if ( (LA12_129=='l') ) {
                    int LA12_166 = input.LA(5);

                    if ( (LA12_166=='i') ) {
                        int LA12_202 = input.LA(6);

                        if ( (LA12_202=='e') ) {
                            int LA12_228 = input.LA(7);

                            if ( (LA12_228=='s') ) {
                                int LA12_248 = input.LA(8);

                                if ( ((LA12_248>='0' && LA12_248<='9')||(LA12_248>='A' && LA12_248<='Z')||LA12_248=='_'||(LA12_248>='a' && LA12_248<='z')) ) {
                                    return 72;
                                }
                                else {
                                    return 48;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        case 'f':
            {
            int LA12_65 = input.LA(3);

            if ( ((LA12_65>='0' && LA12_65<='9')||(LA12_65>='A' && LA12_65<='Z')||LA12_65=='_'||(LA12_65>='a' && LA12_65<='z')) ) {
                return 72;
            }
            else {
                return 66;}
            }
        default:
            return 72;}

    }

    private int mTokensHelper011() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'o':
            {
            int LA12_66 = input.LA(3);

            if ( (LA12_66=='s') ) {
                int LA12_131 = input.LA(4);

                if ( (LA12_131=='t') ) {
                    int LA12_167 = input.LA(5);

                    if ( ((LA12_167>='0' && LA12_167<='9')||(LA12_167>='A' && LA12_167<='Z')||LA12_167=='_'||(LA12_167>='a' && LA12_167<='z')) ) {
                        return 72;
                    }
                    else {
                        return 15;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        case 'a':
            {
            int LA12_67 = input.LA(3);

            if ( (LA12_67=='c') ) {
                int LA12_132 = input.LA(4);

                if ( (LA12_132=='k') ) {
                    int LA12_168 = input.LA(5);

                    if ( (LA12_168=='a') ) {
                        int LA12_204 = input.LA(6);

                        if ( (LA12_204=='g') ) {
                            int LA12_229 = input.LA(7);

                            if ( (LA12_229=='e') ) {
                                int LA12_249 = input.LA(8);

                                if ( ((LA12_249>='0' && LA12_249<='9')||(LA12_249>='A' && LA12_249<='Z')||LA12_249=='_'||(LA12_249>='a' && LA12_249<='z')) ) {
                                    return 72;
                                }
                                else {
                                    return 13;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        case 'r':
            {
            int LA12_68 = input.LA(3);

            if ( (LA12_68=='e') ) {
                int LA12_133 = input.LA(4);

                if ( ((LA12_133>='0' && LA12_133<='9')||(LA12_133>='A' && LA12_133<='Z')||LA12_133=='_'||(LA12_133>='a' && LA12_133<='z')) ) {
                    return 72;
                }
                else {
                    return 16;}
            }
            else {
                return 72;}
            }
        default:
            return 72;}

    }

    private int mTokensHelper012() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'l':
            {
            int LA12_69 = input.LA(3);

            if ( (LA12_69=='s') ) {
                int LA12_134 = input.LA(4);

                if ( (LA12_134=='e') ) {
                    int LA12_170 = input.LA(5);

                    if ( ((LA12_170>='0' && LA12_170<='9')||(LA12_170>='A' && LA12_170<='Z')||LA12_170=='_'||(LA12_170>='a' && LA12_170<='z')) ) {
                        return 72;
                    }
                    else {
                        return 68;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        case 'n':
            {
            int LA12_70 = input.LA(3);

            if ( (LA12_70=='d') ) {
                switch ( input.LA(4) ) {
                case 'p':
                    {
                    int LA12_171 = input.LA(5);

                    if ( (LA12_171=='a') ) {
                        int LA12_206 = input.LA(6);

                        if ( (LA12_206=='c') ) {
                            int LA12_230 = input.LA(7);

                            if ( (LA12_230=='k') ) {
                                int LA12_250 = input.LA(8);

                                if ( (LA12_250=='a') ) {
                                    int LA12_265 = input.LA(9);

                                    if ( (LA12_265=='g') ) {
                                        int LA12_274 = input.LA(10);

                                        if ( (LA12_274=='e') ) {
                                            int LA12_280 = input.LA(11);

                                            if ( ((LA12_280>='0' && LA12_280<='9')||(LA12_280>='A' && LA12_280<='Z')||LA12_280=='_'||(LA12_280>='a' && LA12_280<='z')) ) {
                                                return 72;
                                            }
                                            else {
                                                return 14;}
                                        }
                                        else {
                                            return 72;}
                                    }
                                    else {
                                        return 72;}
                                }
                                else {
                                    return 72;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                    }
                case 'i':
                    {
                    int LA12_172 = input.LA(5);

                    if ( (LA12_172=='f') ) {
                        int LA12_207 = input.LA(6);

                        if ( ((LA12_207>='0' && LA12_207<='9')||(LA12_207>='A' && LA12_207<='Z')||LA12_207=='_'||(LA12_207>='a' && LA12_207<='z')) ) {
                            return 72;
                        }
                        else {
                            return 69;}
                    }
                    else {
                        return 72;}
                    }
                default:
                    return 72;}

            }
            else {
                return 72;}
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
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'm':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            return 72;
            }
        default:
            return 23;}

    }

    private int mTokensHelper013() throws RecognitionException {
        int LA12_13 = input.LA(2);

        if ( (LA12_13=='.') ) {
            return 43;
        }
        else {
            return 18;}
    }

    private int mTokensHelper014() throws RecognitionException {
        int LA12_14 = input.LA(2);

        if ( (LA12_14=='>') ) {
            return 19;
        }
        else {
            return 26;}
    }

    private int mTokensHelper015() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '^':
            {
            return 20;
            }
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
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            return 72;
            }
        default:
            return 21;}

    }

    private int mTokensHelper016() throws RecognitionException {
        return 22;
    }

    private int mTokensHelper017() throws RecognitionException {
        int LA12_17 = input.LA(2);

        if ( ((LA12_17>='0' && LA12_17<='9')||(LA12_17>='A' && LA12_17<='Z')||LA12_17=='_'||(LA12_17>='a' && LA12_17<='z')) ) {
            return 72;
        }
        else {
            return 24;}
    }

    private int mTokensHelper018() throws RecognitionException {
        return 25;
    }

    private int mTokensHelper019() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA12_81 = input.LA(3);

            if ( (LA12_81=='g') ) {
                int LA12_136 = input.LA(4);

                if ( ((LA12_136>='0' && LA12_136<='9')||(LA12_136>='A' && LA12_136<='Z')||LA12_136=='_'||(LA12_136>='a' && LA12_136<='z')) ) {
                    return 72;
                }
                else {
                    return 36;}
            }
            else {
                return 72;}
            }
        case 'o':
            {
            int LA12_82 = input.LA(3);

            if ( (LA12_82=='o') ) {
                int LA12_137 = input.LA(4);

                if ( (LA12_137=='l') ) {
                    int LA12_174 = input.LA(5);

                    if ( (LA12_174=='e') ) {
                        int LA12_208 = input.LA(6);

                        if ( (LA12_208=='a') ) {
                            int LA12_232 = input.LA(7);

                            if ( (LA12_232=='n') ) {
                                int LA12_251 = input.LA(8);

                                if ( ((LA12_251>='0' && LA12_251<='9')||(LA12_251>='A' && LA12_251<='Z')||LA12_251=='_'||(LA12_251>='a' && LA12_251<='z')) ) {
                                    return 72;
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        default:
            return 72;}

    }

    private int mTokensHelper020() throws RecognitionException {
        int LA12_20 = input.LA(2);

        if ( (LA12_20=='n') ) {
            int LA12_83 = input.LA(3);

            if ( (LA12_83=='t') ) {
                int LA12_138 = input.LA(4);

                if ( (LA12_138=='e') ) {
                    int LA12_175 = input.LA(5);

                    if ( (LA12_175=='g') ) {
                        int LA12_209 = input.LA(6);

                        if ( (LA12_209=='e') ) {
                            int LA12_233 = input.LA(7);

                            if ( (LA12_233=='r') ) {
                                int LA12_252 = input.LA(8);

                                if ( ((LA12_252>='0' && LA12_252<='9')||(LA12_252>='A' && LA12_252<='Z')||LA12_252=='_'||(LA12_252>='a' && LA12_252<='z')) ) {
                                    return 72;
                                }
                                else {
                                    return 28;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper021() throws RecognitionException {
        int LA12_21 = input.LA(2);

        if ( (LA12_21=='e') ) {
            int LA12_84 = input.LA(3);

            if ( (LA12_84=='a') ) {
                int LA12_139 = input.LA(4);

                if ( (LA12_139=='l') ) {
                    int LA12_176 = input.LA(5);

                    if ( ((LA12_176>='0' && LA12_176<='9')||(LA12_176>='A' && LA12_176<='Z')||LA12_176=='_'||(LA12_176>='a' && LA12_176<='z')) ) {
                        return 72;
                    }
                    else {
                        return 29;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper022() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'e':
            {
            switch ( input.LA(3) ) {
            case 'q':
                {
                int LA12_140 = input.LA(4);

                if ( (LA12_140=='u') ) {
                    int LA12_177 = input.LA(5);

                    if ( (LA12_177=='e') ) {
                        int LA12_211 = input.LA(6);

                        if ( (LA12_211=='n') ) {
                            int LA12_234 = input.LA(7);

                            if ( (LA12_234=='c') ) {
                                int LA12_253 = input.LA(8);

                                if ( (LA12_253=='e') ) {
                                    int LA12_268 = input.LA(9);

                                    if ( ((LA12_268>='0' && LA12_268<='9')||(LA12_268>='A' && LA12_268<='Z')||LA12_268=='_'||(LA12_268>='a' && LA12_268<='z')) ) {
                                        return 72;
                                    }
                                    else {
                                        return 37;}
                                }
                                else {
                                    return 72;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
                }
            case 't':
                {
                int LA12_141 = input.LA(4);

                if ( ((LA12_141>='0' && LA12_141<='9')||(LA12_141>='A' && LA12_141<='Z')||LA12_141=='_'||(LA12_141>='a' && LA12_141<='z')) ) {
                    return 72;
                }
                else {
                    return 35;}
                }
            default:
                return 72;}

            }
        case 't':
            {
            int LA12_86 = input.LA(3);

            if ( (LA12_86=='r') ) {
                int LA12_142 = input.LA(4);

                if ( (LA12_142=='i') ) {
                    int LA12_179 = input.LA(5);

                    if ( (LA12_179=='n') ) {
                        int LA12_212 = input.LA(6);

                        if ( (LA12_212=='g') ) {
                            int LA12_235 = input.LA(7);

                            if ( ((LA12_235>='0' && LA12_235<='9')||(LA12_235>='A' && LA12_235<='Z')||LA12_235=='_'||(LA12_235>='a' && LA12_235<='z')) ) {
                                return 72;
                            }
                            else {
                                return 30;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        default:
            return 72;}

    }

    private int mTokensHelper023() throws RecognitionException {
        int LA12_23 = input.LA(2);

        if ( (LA12_23=='n') ) {
            int LA12_87 = input.LA(3);

            if ( (LA12_87=='l') ) {
                int LA12_143 = input.LA(4);

                if ( (LA12_143=='i') ) {
                    int LA12_180 = input.LA(5);

                    if ( (LA12_180=='m') ) {
                        int LA12_213 = input.LA(6);

                        if ( (LA12_213=='i') ) {
                            int LA12_236 = input.LA(7);

                            if ( (LA12_236=='t') ) {
                                int LA12_255 = input.LA(8);

                                if ( (LA12_255=='e') ) {
                                    int LA12_269 = input.LA(9);

                                    if ( (LA12_269=='d') ) {
                                        int LA12_276 = input.LA(10);

                                        if ( (LA12_276=='N') ) {
                                            int LA12_281 = input.LA(11);

                                            if ( (LA12_281=='a') ) {
                                                int LA12_286 = input.LA(12);

                                                if ( (LA12_286=='t') ) {
                                                    int LA12_290 = input.LA(13);

                                                    if ( (LA12_290=='u') ) {
                                                        int LA12_291 = input.LA(14);

                                                        if ( (LA12_291=='r') ) {
                                                            int LA12_292 = input.LA(15);

                                                            if ( (LA12_292=='a') ) {
                                                                int LA12_293 = input.LA(16);

                                                                if ( (LA12_293=='l') ) {
                                                                    int LA12_294 = input.LA(17);

                                                                    if ( ((LA12_294>='0' && LA12_294<='9')||(LA12_294>='A' && LA12_294<='Z')||LA12_294=='_'||(LA12_294>='a' && LA12_294<='z')) ) {
                                                                        return 72;
                                                                    }
                                                                    else {
                                                                        return 31;}
                                                                }
                                                                else {
                                                                    return 72;}
                                                            }
                                                            else {
                                                                return 72;}
                                                        }
                                                        else {
                                                            return 72;}
                                                    }
                                                    else {
                                                        return 72;}
                                                }
                                                else {
                                                    return 72;}
                                            }
                                            else {
                                                return 72;}
                                        }
                                        else {
                                            return 72;}
                                    }
                                    else {
                                        return 72;}
                                }
                                else {
                                    return 72;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper024() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'c':
            {
            int LA12_88 = input.LA(3);

            if ( (LA12_88=='l') ) {
                switch ( input.LA(4) ) {
                case 'A':
                    {
                    int LA12_181 = input.LA(5);

                    if ( (LA12_181=='n') ) {
                        int LA12_214 = input.LA(6);

                        if ( (LA12_214=='y') ) {
                            int LA12_237 = input.LA(7);

                            if ( ((LA12_237>='0' && LA12_237<='9')||(LA12_237>='A' && LA12_237<='Z')||LA12_237=='_'||(LA12_237>='a' && LA12_237<='z')) ) {
                                return 72;
                            }
                            else {
                                return 32;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                    }
                case 'I':
                    {
                    int LA12_182 = input.LA(5);

                    if ( (LA12_182=='n') ) {
                        int LA12_215 = input.LA(6);

                        if ( (LA12_215=='v') ) {
                            int LA12_238 = input.LA(7);

                            if ( (LA12_238=='a') ) {
                                int LA12_257 = input.LA(8);

                                if ( (LA12_257=='l') ) {
                                    int LA12_270 = input.LA(9);

                                    if ( (LA12_270=='i') ) {
                                        int LA12_277 = input.LA(10);

                                        if ( (LA12_277=='d') ) {
                                            int LA12_282 = input.LA(11);

                                            if ( ((LA12_282>='0' && LA12_282<='9')||(LA12_282>='A' && LA12_282<='Z')||LA12_282=='_'||(LA12_282>='a' && LA12_282<='z')) ) {
                                                return 72;
                                            }
                                            else {
                                                return 33;}
                                        }
                                        else {
                                            return 72;}
                                    }
                                    else {
                                        return 72;}
                                }
                                else {
                                    return 72;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                    }
                case 'V':
                    {
                    int LA12_183 = input.LA(5);

                    if ( (LA12_183=='o') ) {
                        int LA12_216 = input.LA(6);

                        if ( (LA12_216=='i') ) {
                            int LA12_239 = input.LA(7);

                            if ( (LA12_239=='d') ) {
                                int LA12_258 = input.LA(8);

                                if ( ((LA12_258>='0' && LA12_258<='9')||(LA12_258>='A' && LA12_258<='Z')||LA12_258=='_'||(LA12_258>='a' && LA12_258<='z')) ) {
                                    return 72;
                                }
                                else {
                                    return 34;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                    }
                default:
                    return 72;}

            }
            else {
                return 72;}
            }
        case 'r':
            {
            int LA12_89 = input.LA(3);

            if ( (LA12_89=='d') ) {
                int LA12_145 = input.LA(4);

                if ( (LA12_145=='e') ) {
                    int LA12_184 = input.LA(5);

                    if ( (LA12_184=='r') ) {
                        int LA12_217 = input.LA(6);

                        if ( (LA12_217=='e') ) {
                            int LA12_240 = input.LA(7);

                            if ( (LA12_240=='d') ) {
                                int LA12_259 = input.LA(8);

                                if ( (LA12_259=='S') ) {
                                    int LA12_272 = input.LA(9);

                                    if ( (LA12_272=='e') ) {
                                        int LA12_278 = input.LA(10);

                                        if ( (LA12_278=='t') ) {
                                            int LA12_283 = input.LA(11);

                                            if ( ((LA12_283>='0' && LA12_283<='9')||(LA12_283>='A' && LA12_283<='Z')||LA12_283=='_'||(LA12_283>='a' && LA12_283<='z')) ) {
                                                return 72;
                                            }
                                            else {
                                                return 39;}
                                        }
                                        else {
                                            return 72;}
                                    }
                                    else {
                                        return 72;}
                                }
                                else {
                                    return 72;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        default:
            return 72;}

    }

    private int mTokensHelper025() throws RecognitionException {
        int LA12_25 = input.LA(2);

        if ( (LA12_25=='o') ) {
            int LA12_90 = input.LA(3);

            if ( (LA12_90=='l') ) {
                int LA12_146 = input.LA(4);

                if ( (LA12_146=='l') ) {
                    int LA12_185 = input.LA(5);

                    if ( (LA12_185=='e') ) {
                        int LA12_218 = input.LA(6);

                        if ( (LA12_218=='c') ) {
                            int LA12_241 = input.LA(7);

                            if ( (LA12_241=='t') ) {
                                int LA12_260 = input.LA(8);

                                if ( (LA12_260=='i') ) {
                                    int LA12_273 = input.LA(9);

                                    if ( (LA12_273=='o') ) {
                                        int LA12_279 = input.LA(10);

                                        if ( (LA12_279=='n') ) {
                                            int LA12_284 = input.LA(11);

                                            if ( ((LA12_284>='0' && LA12_284<='9')||(LA12_284>='A' && LA12_284<='Z')||LA12_284=='_'||(LA12_284>='a' && LA12_284<='z')) ) {
                                                return 72;
                                            }
                                            else {
                                                return 38;}
                                        }
                                        else {
                                            return 72;}
                                    }
                                    else {
                                        return 72;}
                                }
                                else {
                                    return 72;}
                            }
                            else {
                                return 72;}
                        }
                        else {
                            return 72;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper026() throws RecognitionException {
        int LA12_26 = input.LA(2);

        if ( (LA12_26=='u') ) {
            int LA12_91 = input.LA(3);

            if ( (LA12_91=='p') ) {
                int LA12_147 = input.LA(4);

                if ( (LA12_147=='l') ) {
                    int LA12_186 = input.LA(5);

                    if ( (LA12_186=='e') ) {
                        int LA12_219 = input.LA(6);

                        if ( ((LA12_219>='0' && LA12_219<='9')||(LA12_219>='A' && LA12_219<='Z')||LA12_219=='_'||(LA12_219>='a' && LA12_219<='z')) ) {
                            return 72;
                        }
                        else {
                            return 40;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper027() throws RecognitionException {
        return 41;
    }

    private int mTokensHelper028() throws RecognitionException {
        return 42;
    }

    private int mTokensHelper029() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'r':
            {
            int LA12_94 = input.LA(3);

            if ( (LA12_94=='u') ) {
                int LA12_148 = input.LA(4);

                if ( (LA12_148=='e') ) {
                    int LA12_187 = input.LA(5);

                    if ( ((LA12_187>='0' && LA12_187<='9')||(LA12_187>='A' && LA12_187<='Z')||LA12_187=='_'||(LA12_187>='a' && LA12_187<='z')) ) {
                        return 72;
                    }
                    else {
                        return 44;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        case 'h':
            {
            int LA12_95 = input.LA(3);

            if ( (LA12_95=='e') ) {
                int LA12_149 = input.LA(4);

                if ( (LA12_149=='n') ) {
                    int LA12_188 = input.LA(5);

                    if ( ((LA12_188>='0' && LA12_188<='9')||(LA12_188>='A' && LA12_188<='Z')||LA12_188=='_'||(LA12_188>='a' && LA12_188<='z')) ) {
                        return 72;
                    }
                    else {
                        return 67;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        default:
            return 72;}

    }

    private int mTokensHelper030() throws RecognitionException {
        int LA12_30 = input.LA(2);

        if ( (LA12_30=='a') ) {
            int LA12_96 = input.LA(3);

            if ( (LA12_96=='l') ) {
                int LA12_150 = input.LA(4);

                if ( (LA12_150=='s') ) {
                    int LA12_189 = input.LA(5);

                    if ( (LA12_189=='e') ) {
                        int LA12_222 = input.LA(6);

                        if ( ((LA12_222>='0' && LA12_222<='9')||(LA12_222>='A' && LA12_222<='Z')||LA12_222=='_'||(LA12_222>='a' && LA12_222<='z')) ) {
                            return 72;
                        }
                        else {
                            return 45;}
                    }
                    else {
                        return 72;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper031() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'u':
            {
            int LA12_97 = input.LA(3);

            if ( (LA12_97=='l') ) {
                int LA12_151 = input.LA(4);

                if ( (LA12_151=='l') ) {
                    int LA12_190 = input.LA(5);

                    if ( ((LA12_190>='0' && LA12_190<='9')||(LA12_190>='A' && LA12_190<='Z')||LA12_190=='_'||(LA12_190>='a' && LA12_190<='z')) ) {
                        return 72;
                    }
                    else {
                        return 47;}
                }
                else {
                    return 72;}
            }
            else {
                return 72;}
            }
        case 'o':
            {
            int LA12_98 = input.LA(3);

            if ( (LA12_98=='t') ) {
                int LA12_152 = input.LA(4);

                if ( ((LA12_152>='0' && LA12_152<='9')||(LA12_152>='A' && LA12_152<='Z')||LA12_152=='_'||(LA12_152>='a' && LA12_152<='z')) ) {
                    return 72;
                }
                else {
                    return 59;}
            }
            else {
                return 72;}
            }
        default:
            return 72;}

    }

    private int mTokensHelper032() throws RecognitionException {
        int LA12_32 = input.LA(2);

        if ( (LA12_32=='o') ) {
            int LA12_99 = input.LA(3);

            if ( (LA12_99=='r') ) {
                int LA12_153 = input.LA(4);

                if ( ((LA12_153>='0' && LA12_153<='9')||(LA12_153>='A' && LA12_153<='Z')||LA12_153=='_'||(LA12_153>='a' && LA12_153<='z')) ) {
                    return 72;
                }
                else {
                    return 49;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper033() throws RecognitionException {
        int LA12_33 = input.LA(2);

        if ( (LA12_33=='r') ) {
            int LA12_100 = input.LA(3);

            if ( ((LA12_100>='0' && LA12_100<='9')||(LA12_100>='A' && LA12_100<='Z')||LA12_100=='_'||(LA12_100>='a' && LA12_100<='z')) ) {
                return 72;
            }
            else {
                return 50;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper034() throws RecognitionException {
        int LA12_34 = input.LA(2);

        if ( (LA12_34=='n') ) {
            int LA12_101 = input.LA(3);

            if ( (LA12_101=='d') ) {
                int LA12_155 = input.LA(4);

                if ( ((LA12_155>='0' && LA12_155<='9')||(LA12_155>='A' && LA12_155<='Z')||LA12_155=='_'||(LA12_155>='a' && LA12_155<='z')) ) {
                    return 72;
                }
                else {
                    return 51;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper035() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '>':
            {
            return 52;
            }
        case '=':
            {
            return 56;
            }
        default:
            return 54;}

    }

    private int mTokensHelper036() throws RecognitionException {
        int LA12_36 = input.LA(2);

        if ( (LA12_36=='=') ) {
            return 55;
        }
        else {
            return 53;}
    }

    private int mTokensHelper037() throws RecognitionException {
        return 57;
    }

    private int mTokensHelper038() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '/':
            {
            return 76;
            }
        case '*':
            {
            return 75;
            }
        default:
            return 58;}

    }

    private int mTokensHelper039() throws RecognitionException {
        return 60;
    }

    private int mTokensHelper040() throws RecognitionException {
        return 61;
    }

    private int mTokensHelper041() throws RecognitionException {
        return 62;
    }

    private int mTokensHelper042() throws RecognitionException {
        return 63;
    }

    private int mTokensHelper043() throws RecognitionException {
        return 64;
    }

    private int mTokensHelper044() throws RecognitionException {
        int LA12_44 = input.LA(2);

        if ( (LA12_44=='e') ) {
            int LA12_116 = input.LA(3);

            if ( (LA12_116=='t') ) {
                int LA12_156 = input.LA(4);

                if ( ((LA12_156>='0' && LA12_156<='9')||(LA12_156>='A' && LA12_156<='Z')||LA12_156=='_'||(LA12_156>='a' && LA12_156<='z')) ) {
                    return 72;
                }
                else {
                    return 70;}
            }
            else {
                return 72;}
        }
        else {
            return 72;}
    }

    private int mTokensHelper045() throws RecognitionException {
        return 72;
    }

    private int mTokensHelper046() throws RecognitionException {
        return 73;
    }

    private int mTokensHelper047() throws RecognitionException {
        int LA12_47 = input.LA(2);

        if ( ((LA12_47>='\u0000' && LA12_47<='\uFFFE')) ) {
            return 74;
        }
        else {
            return 78;}
    }

    private int mTokensHelper048() throws RecognitionException {
        int LA12_48 = input.LA(2);

        if ( ((LA12_48>='\u0000' && LA12_48<='\uFFFE')) ) {
            return 74;
        }
        else {
            return 78;}
    }

    private int mTokensHelper049() throws RecognitionException {
        return 77;
    }

    private int mTokensHelper050() throws RecognitionException {
        return 78;
    }

    private int mTokensHelper051() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}