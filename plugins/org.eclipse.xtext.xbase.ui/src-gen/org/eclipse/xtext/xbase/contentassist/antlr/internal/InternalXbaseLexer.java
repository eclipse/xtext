package org.eclipse.xtext.xbase.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXbaseLexer extends Lexer {
    public static final int T14=14;
    public static final int T29=29;
    public static final int T36=36;
    public static final int RULE_STRING=6;
    public static final int T35=35;
    public static final int T45=45;
    public static final int T20=20;
    public static final int T34=34;
    public static final int T25=25;
    public static final int T18=18;
    public static final int T37=37;
    public static final int T26=26;
    public static final int RULE_INT=5;
    public static final int T32=32;
    public static final int T17=17;
    public static final int T51=51;
    public static final int T46=46;
    public static final int T16=16;
    public static final int T38=38;
    public static final int T41=41;
    public static final int T24=24;
    public static final int T19=19;
    public static final int T39=39;
    public static final int T21=21;
    public static final int T44=44;
    public static final int T55=55;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T43=43;
    public static final int T12=12;
    public static final int T23=23;
    public static final int T28=28;
    public static final int T42=42;
    public static final int T40=40;
    public static final int T13=13;
    public static final int T56=56;
    public static final int RULE_WS=10;
    public static final int T48=48;
    public static final int T15=15;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int RULE_RICH_STRING=7;
    public static final int Tokens=57;
    public static final int T53=53;
    public static final int RULE_ANY_OTHER=11;
    public static final int T31=31;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=9;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T30=30;
    public InternalXbaseLexer() {;} 
    public InternalXbaseLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:10:5: ( '==' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:10:7: '=='
            {
            match("=="); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:11:5: ( '!=' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:11:7: '!='
            {
            match("!="); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:12:5: ( '>=' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:12:7: '>='
            {
            match(">="); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:13:5: ( '<=' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:13:7: '<='
            {
            match("<="); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:14:5: ( '>' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:14:7: '>'
            {
            match('>'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:15:5: ( '<' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:15:7: '<'
            {
            match('<'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:16:5: ( '+' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:16:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:17:5: ( '-' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:17:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:18:5: ( '*' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:18:7: '*'
            {
            match('*'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:19:5: ( '/' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:19:7: '/'
            {
            match('/'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:20:5: ( '+=' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:20:7: '+='
            {
            match("+="); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:21:5: ( '..' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:21:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:22:5: ( '!' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:22:7: '!'
            {
            match('!'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:23:5: ( 'def' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:23:7: 'def'
            {
            match("def"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:24:5: ( 'import' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:24:7: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:25:5: ( '.' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:25:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:26:5: ( '(' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:26:7: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:27:5: ( ')' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:27:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:28:5: ( ',' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:28:7: ','
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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:29:5: ( 'if' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:29:7: 'if'
            {
            match("if"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:30:5: ( ':' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:30:7: ':'
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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:31:5: ( ';' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:31:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:32:5: ( '|' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:32:7: '|'
            {
            match('|'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:33:5: ( '=' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:33:7: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:34:5: ( 'else' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:34:7: 'else'
            {
            match("else"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:35:5: ( 'switch' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:35:7: 'switch'
            {
            match("switch"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:36:5: ( '{' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:36:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:37:5: ( '}' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:37:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:38:5: ( 'default' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:38:7: 'default'
            {
            match("default"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:39:5: ( 'while' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:39:7: 'while'
            {
            match("while"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:40:5: ( 'case' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:40:7: 'case'
            {
            match("case"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:41:5: ( ':=' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:41:7: ':='
            {
            match(":="); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:42:5: ( 'new' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:42:7: 'new'
            {
            match("new"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:43:5: ( 'false' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:43:7: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:44:5: ( 'null' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:44:7: 'null'
            {
            match("null"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:45:5: ( '=>' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:45:7: '=>'
            {
            match("=>"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:46:5: ( '?' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:46:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:47:5: ( 'extends' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:47:7: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:48:5: ( 'super' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:48:7: 'super'
            {
            match("super"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:49:5: ( '&' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:49:7: '&'
            {
            match('&'); 

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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:50:5: ( 'private' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:50:7: 'private'
            {
            match("private"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:51:5: ( 'final' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:51:7: 'final'
            {
            match("final"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:52:5: ( '||' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:52:7: '||'
            {
            match("||"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:53:5: ( '&&' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:53:7: '&&'
            {
            match("&&"); 


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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:54:5: ( 'true' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:54:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T56

    // $ANTLR start RULE_RICH_STRING
    public final void mRULE_RICH_STRING() throws RecognitionException {
        try {
            int _type = RULE_RICH_STRING;
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7029:18: ( '\\u00BB' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\u00AB' ) ) )* '\\u00AB' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7029:20: '\\u00BB' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\u00AB' ) ) )* '\\u00AB'
            {
            match('\u00BB'); 
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7029:29: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\u00AB' ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    alt1=1;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\u00AA')||(LA1_0>='\u00AC' && LA1_0<='\uFFFE')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7029:30: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7029:71: ~ ( ( '\\\\' | '\\u00AB' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\u00AA')||(input.LA(1)>='\u00AC' && input.LA(1)<='\uFFFE') ) {
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

            match('\u00AB'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_RICH_STRING

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7031:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7031:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7031:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7031:11: '^'
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

            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7031:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:
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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7033:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7033:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7033:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7033:13: '0' .. '9'
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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("7035:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7035:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7037:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7037:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7037:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7037:52: .
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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7039:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7039:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7039:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7039:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7039:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7039:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7039:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7039:41: '\\r'
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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7041:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7041:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7041:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:
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
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7043:16: ( . )
            // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:7043:18: .
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
        // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | RULE_RICH_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=53;
        int LA13_0 = input.LA(1);

        if ( (LA13_0=='=') ) {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt13=1;
                }
                break;
            case '>':
                {
                alt13=36;
                }
                break;
            default:
                alt13=24;}

        }
        else if ( (LA13_0=='!') ) {
            int LA13_2 = input.LA(2);

            if ( (LA13_2=='=') ) {
                alt13=2;
            }
            else {
                alt13=13;}
        }
        else if ( (LA13_0=='>') ) {
            int LA13_3 = input.LA(2);

            if ( (LA13_3=='=') ) {
                alt13=3;
            }
            else {
                alt13=5;}
        }
        else if ( (LA13_0=='<') ) {
            int LA13_4 = input.LA(2);

            if ( (LA13_4=='=') ) {
                alt13=4;
            }
            else {
                alt13=6;}
        }
        else if ( (LA13_0=='+') ) {
            int LA13_5 = input.LA(2);

            if ( (LA13_5=='=') ) {
                alt13=11;
            }
            else {
                alt13=7;}
        }
        else if ( (LA13_0=='-') ) {
            alt13=8;
        }
        else if ( (LA13_0=='*') ) {
            alt13=9;
        }
        else if ( (LA13_0=='/') ) {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt13=50;
                }
                break;
            case '/':
                {
                alt13=51;
                }
                break;
            default:
                alt13=10;}

        }
        else if ( (LA13_0=='.') ) {
            int LA13_9 = input.LA(2);

            if ( (LA13_9=='.') ) {
                alt13=12;
            }
            else {
                alt13=16;}
        }
        else if ( (LA13_0=='d') ) {
            int LA13_10 = input.LA(2);

            if ( (LA13_10=='e') ) {
                int LA13_56 = input.LA(3);

                if ( (LA13_56=='f') ) {
                    switch ( input.LA(4) ) {
                    case 'a':
                        {
                        int LA13_104 = input.LA(5);

                        if ( (LA13_104=='u') ) {
                            int LA13_119 = input.LA(6);

                            if ( (LA13_119=='l') ) {
                                int LA13_132 = input.LA(7);

                                if ( (LA13_132=='t') ) {
                                    int LA13_141 = input.LA(8);

                                    if ( ((LA13_141>='0' && LA13_141<='9')||(LA13_141>='A' && LA13_141<='Z')||LA13_141=='_'||(LA13_141>='a' && LA13_141<='z')) ) {
                                        alt13=47;
                                    }
                                    else {
                                        alt13=29;}
                                }
                                else {
                                    alt13=47;}
                            }
                            else {
                                alt13=47;}
                        }
                        else {
                            alt13=47;}
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
                        alt13=47;
                        }
                        break;
                    default:
                        alt13=14;}

                }
                else {
                    alt13=47;}
            }
            else {
                alt13=47;}
        }
        else if ( (LA13_0=='i') ) {
            switch ( input.LA(2) ) {
            case 'f':
                {
                int LA13_58 = input.LA(3);

                if ( ((LA13_58>='0' && LA13_58<='9')||(LA13_58>='A' && LA13_58<='Z')||LA13_58=='_'||(LA13_58>='a' && LA13_58<='z')) ) {
                    alt13=47;
                }
                else {
                    alt13=20;}
                }
                break;
            case 'm':
                {
                int LA13_59 = input.LA(3);

                if ( (LA13_59=='p') ) {
                    int LA13_91 = input.LA(4);

                    if ( (LA13_91=='o') ) {
                        int LA13_106 = input.LA(5);

                        if ( (LA13_106=='r') ) {
                            int LA13_120 = input.LA(6);

                            if ( (LA13_120=='t') ) {
                                int LA13_133 = input.LA(7);

                                if ( ((LA13_133>='0' && LA13_133<='9')||(LA13_133>='A' && LA13_133<='Z')||LA13_133=='_'||(LA13_133>='a' && LA13_133<='z')) ) {
                                    alt13=47;
                                }
                                else {
                                    alt13=15;}
                            }
                            else {
                                alt13=47;}
                        }
                        else {
                            alt13=47;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
                }
                break;
            default:
                alt13=47;}

        }
        else if ( (LA13_0=='(') ) {
            alt13=17;
        }
        else if ( (LA13_0==')') ) {
            alt13=18;
        }
        else if ( (LA13_0==',') ) {
            alt13=19;
        }
        else if ( (LA13_0==':') ) {
            int LA13_15 = input.LA(2);

            if ( (LA13_15=='=') ) {
                alt13=32;
            }
            else {
                alt13=21;}
        }
        else if ( (LA13_0==';') ) {
            alt13=22;
        }
        else if ( (LA13_0=='|') ) {
            int LA13_17 = input.LA(2);

            if ( (LA13_17=='|') ) {
                alt13=43;
            }
            else {
                alt13=23;}
        }
        else if ( (LA13_0=='e') ) {
            switch ( input.LA(2) ) {
            case 'l':
                {
                int LA13_68 = input.LA(3);

                if ( (LA13_68=='s') ) {
                    int LA13_92 = input.LA(4);

                    if ( (LA13_92=='e') ) {
                        int LA13_107 = input.LA(5);

                        if ( ((LA13_107>='0' && LA13_107<='9')||(LA13_107>='A' && LA13_107<='Z')||LA13_107=='_'||(LA13_107>='a' && LA13_107<='z')) ) {
                            alt13=47;
                        }
                        else {
                            alt13=25;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
                }
                break;
            case 'x':
                {
                int LA13_69 = input.LA(3);

                if ( (LA13_69=='t') ) {
                    int LA13_93 = input.LA(4);

                    if ( (LA13_93=='e') ) {
                        int LA13_108 = input.LA(5);

                        if ( (LA13_108=='n') ) {
                            int LA13_122 = input.LA(6);

                            if ( (LA13_122=='d') ) {
                                int LA13_134 = input.LA(7);

                                if ( (LA13_134=='s') ) {
                                    int LA13_143 = input.LA(8);

                                    if ( ((LA13_143>='0' && LA13_143<='9')||(LA13_143>='A' && LA13_143<='Z')||LA13_143=='_'||(LA13_143>='a' && LA13_143<='z')) ) {
                                        alt13=47;
                                    }
                                    else {
                                        alt13=38;}
                                }
                                else {
                                    alt13=47;}
                            }
                            else {
                                alt13=47;}
                        }
                        else {
                            alt13=47;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
                }
                break;
            default:
                alt13=47;}

        }
        else if ( (LA13_0=='s') ) {
            switch ( input.LA(2) ) {
            case 'u':
                {
                int LA13_70 = input.LA(3);

                if ( (LA13_70=='p') ) {
                    int LA13_94 = input.LA(4);

                    if ( (LA13_94=='e') ) {
                        int LA13_109 = input.LA(5);

                        if ( (LA13_109=='r') ) {
                            int LA13_123 = input.LA(6);

                            if ( ((LA13_123>='0' && LA13_123<='9')||(LA13_123>='A' && LA13_123<='Z')||LA13_123=='_'||(LA13_123>='a' && LA13_123<='z')) ) {
                                alt13=47;
                            }
                            else {
                                alt13=39;}
                        }
                        else {
                            alt13=47;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
                }
                break;
            case 'w':
                {
                int LA13_71 = input.LA(3);

                if ( (LA13_71=='i') ) {
                    int LA13_95 = input.LA(4);

                    if ( (LA13_95=='t') ) {
                        int LA13_110 = input.LA(5);

                        if ( (LA13_110=='c') ) {
                            int LA13_124 = input.LA(6);

                            if ( (LA13_124=='h') ) {
                                int LA13_136 = input.LA(7);

                                if ( ((LA13_136>='0' && LA13_136<='9')||(LA13_136>='A' && LA13_136<='Z')||LA13_136=='_'||(LA13_136>='a' && LA13_136<='z')) ) {
                                    alt13=47;
                                }
                                else {
                                    alt13=26;}
                            }
                            else {
                                alt13=47;}
                        }
                        else {
                            alt13=47;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
                }
                break;
            default:
                alt13=47;}

        }
        else if ( (LA13_0=='{') ) {
            alt13=27;
        }
        else if ( (LA13_0=='}') ) {
            alt13=28;
        }
        else if ( (LA13_0=='w') ) {
            int LA13_22 = input.LA(2);

            if ( (LA13_22=='h') ) {
                int LA13_74 = input.LA(3);

                if ( (LA13_74=='i') ) {
                    int LA13_96 = input.LA(4);

                    if ( (LA13_96=='l') ) {
                        int LA13_111 = input.LA(5);

                        if ( (LA13_111=='e') ) {
                            int LA13_125 = input.LA(6);

                            if ( ((LA13_125>='0' && LA13_125<='9')||(LA13_125>='A' && LA13_125<='Z')||LA13_125=='_'||(LA13_125>='a' && LA13_125<='z')) ) {
                                alt13=47;
                            }
                            else {
                                alt13=30;}
                        }
                        else {
                            alt13=47;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
            }
            else {
                alt13=47;}
        }
        else if ( (LA13_0=='c') ) {
            int LA13_23 = input.LA(2);

            if ( (LA13_23=='a') ) {
                int LA13_75 = input.LA(3);

                if ( (LA13_75=='s') ) {
                    int LA13_97 = input.LA(4);

                    if ( (LA13_97=='e') ) {
                        int LA13_112 = input.LA(5);

                        if ( ((LA13_112>='0' && LA13_112<='9')||(LA13_112>='A' && LA13_112<='Z')||LA13_112=='_'||(LA13_112>='a' && LA13_112<='z')) ) {
                            alt13=47;
                        }
                        else {
                            alt13=31;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
            }
            else {
                alt13=47;}
        }
        else if ( (LA13_0=='n') ) {
            switch ( input.LA(2) ) {
            case 'u':
                {
                int LA13_76 = input.LA(3);

                if ( (LA13_76=='l') ) {
                    int LA13_98 = input.LA(4);

                    if ( (LA13_98=='l') ) {
                        int LA13_113 = input.LA(5);

                        if ( ((LA13_113>='0' && LA13_113<='9')||(LA13_113>='A' && LA13_113<='Z')||LA13_113=='_'||(LA13_113>='a' && LA13_113<='z')) ) {
                            alt13=47;
                        }
                        else {
                            alt13=35;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
                }
                break;
            case 'e':
                {
                int LA13_77 = input.LA(3);

                if ( (LA13_77=='w') ) {
                    int LA13_99 = input.LA(4);

                    if ( ((LA13_99>='0' && LA13_99<='9')||(LA13_99>='A' && LA13_99<='Z')||LA13_99=='_'||(LA13_99>='a' && LA13_99<='z')) ) {
                        alt13=47;
                    }
                    else {
                        alt13=33;}
                }
                else {
                    alt13=47;}
                }
                break;
            default:
                alt13=47;}

        }
        else if ( (LA13_0=='f') ) {
            switch ( input.LA(2) ) {
            case 'i':
                {
                int LA13_78 = input.LA(3);

                if ( (LA13_78=='n') ) {
                    int LA13_100 = input.LA(4);

                    if ( (LA13_100=='a') ) {
                        int LA13_115 = input.LA(5);

                        if ( (LA13_115=='l') ) {
                            int LA13_128 = input.LA(6);

                            if ( ((LA13_128>='0' && LA13_128<='9')||(LA13_128>='A' && LA13_128<='Z')||LA13_128=='_'||(LA13_128>='a' && LA13_128<='z')) ) {
                                alt13=47;
                            }
                            else {
                                alt13=42;}
                        }
                        else {
                            alt13=47;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
                }
                break;
            case 'a':
                {
                int LA13_79 = input.LA(3);

                if ( (LA13_79=='l') ) {
                    int LA13_101 = input.LA(4);

                    if ( (LA13_101=='s') ) {
                        int LA13_116 = input.LA(5);

                        if ( (LA13_116=='e') ) {
                            int LA13_129 = input.LA(6);

                            if ( ((LA13_129>='0' && LA13_129<='9')||(LA13_129>='A' && LA13_129<='Z')||LA13_129=='_'||(LA13_129>='a' && LA13_129<='z')) ) {
                                alt13=47;
                            }
                            else {
                                alt13=34;}
                        }
                        else {
                            alt13=47;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
                }
                break;
            default:
                alt13=47;}

        }
        else if ( (LA13_0=='?') ) {
            alt13=37;
        }
        else if ( (LA13_0=='&') ) {
            int LA13_27 = input.LA(2);

            if ( (LA13_27=='&') ) {
                alt13=44;
            }
            else {
                alt13=40;}
        }
        else if ( (LA13_0=='p') ) {
            int LA13_28 = input.LA(2);

            if ( (LA13_28=='r') ) {
                int LA13_83 = input.LA(3);

                if ( (LA13_83=='i') ) {
                    int LA13_102 = input.LA(4);

                    if ( (LA13_102=='v') ) {
                        int LA13_117 = input.LA(5);

                        if ( (LA13_117=='a') ) {
                            int LA13_130 = input.LA(6);

                            if ( (LA13_130=='t') ) {
                                int LA13_140 = input.LA(7);

                                if ( (LA13_140=='e') ) {
                                    int LA13_145 = input.LA(8);

                                    if ( ((LA13_145>='0' && LA13_145<='9')||(LA13_145>='A' && LA13_145<='Z')||LA13_145=='_'||(LA13_145>='a' && LA13_145<='z')) ) {
                                        alt13=47;
                                    }
                                    else {
                                        alt13=41;}
                                }
                                else {
                                    alt13=47;}
                            }
                            else {
                                alt13=47;}
                        }
                        else {
                            alt13=47;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
            }
            else {
                alt13=47;}
        }
        else if ( (LA13_0=='t') ) {
            int LA13_29 = input.LA(2);

            if ( (LA13_29=='r') ) {
                int LA13_84 = input.LA(3);

                if ( (LA13_84=='u') ) {
                    int LA13_103 = input.LA(4);

                    if ( (LA13_103=='e') ) {
                        int LA13_118 = input.LA(5);

                        if ( ((LA13_118>='0' && LA13_118<='9')||(LA13_118>='A' && LA13_118<='Z')||LA13_118=='_'||(LA13_118>='a' && LA13_118<='z')) ) {
                            alt13=47;
                        }
                        else {
                            alt13=45;}
                    }
                    else {
                        alt13=47;}
                }
                else {
                    alt13=47;}
            }
            else {
                alt13=47;}
        }
        else if ( (LA13_0=='\u00BB') ) {
            int LA13_30 = input.LA(2);

            if ( ((LA13_30>='\u0000' && LA13_30<='\uFFFE')) ) {
                alt13=46;
            }
            else {
                alt13=53;}
        }
        else if ( (LA13_0=='^') ) {
            int LA13_31 = input.LA(2);

            if ( ((LA13_31>='A' && LA13_31<='Z')||LA13_31=='_'||(LA13_31>='a' && LA13_31<='z')) ) {
                alt13=47;
            }
            else {
                alt13=53;}
        }
        else if ( ((LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='b')||(LA13_0>='g' && LA13_0<='h')||(LA13_0>='j' && LA13_0<='m')||LA13_0=='o'||(LA13_0>='q' && LA13_0<='r')||(LA13_0>='u' && LA13_0<='v')||(LA13_0>='x' && LA13_0<='z')) ) {
            alt13=47;
        }
        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {
            alt13=48;
        }
        else if ( (LA13_0=='\"') ) {
            int LA13_34 = input.LA(2);

            if ( ((LA13_34>='\u0000' && LA13_34<='\uFFFE')) ) {
                alt13=49;
            }
            else {
                alt13=53;}
        }
        else if ( (LA13_0=='\'') ) {
            int LA13_35 = input.LA(2);

            if ( ((LA13_35>='\u0000' && LA13_35<='\uFFFE')) ) {
                alt13=49;
            }
            else {
                alt13=53;}
        }
        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
            alt13=52;
        }
        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||(LA13_0>='#' && LA13_0<='%')||LA13_0=='@'||(LA13_0>='[' && LA13_0<=']')||LA13_0=='`'||(LA13_0>='~' && LA13_0<='\u00BA')||(LA13_0>='\u00BC' && LA13_0<='\uFFFE')) ) {
            alt13=53;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | RULE_RICH_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 13, 0, input);

            throw nvae;
        }
        switch (alt13) {
            case 1 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:30: T17
                {
                mT17(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:34: T18
                {
                mT18(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:38: T19
                {
                mT19(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:42: T20
                {
                mT20(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:46: T21
                {
                mT21(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:50: T22
                {
                mT22(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:54: T23
                {
                mT23(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:58: T24
                {
                mT24(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:62: T25
                {
                mT25(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:66: T26
                {
                mT26(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:70: T27
                {
                mT27(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:74: T28
                {
                mT28(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:78: T29
                {
                mT29(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:82: T30
                {
                mT30(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:86: T31
                {
                mT31(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:90: T32
                {
                mT32(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:94: T33
                {
                mT33(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:98: T34
                {
                mT34(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:102: T35
                {
                mT35(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:106: T36
                {
                mT36(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:110: T37
                {
                mT37(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:114: T38
                {
                mT38(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:118: T39
                {
                mT39(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:122: T40
                {
                mT40(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:126: T41
                {
                mT41(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:130: T42
                {
                mT42(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:134: T43
                {
                mT43(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:138: T44
                {
                mT44(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:142: T45
                {
                mT45(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:146: T46
                {
                mT46(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:150: T47
                {
                mT47(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:154: T48
                {
                mT48(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:158: T49
                {
                mT49(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:162: T50
                {
                mT50(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:166: T51
                {
                mT51(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:170: T52
                {
                mT52(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:174: T53
                {
                mT53(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:178: T54
                {
                mT54(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:182: T55
                {
                mT55(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:186: T56
                {
                mT56(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:190: RULE_RICH_STRING
                {
                mRULE_RICH_STRING(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:207: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:215: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:224: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:236: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:252: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:268: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.xbase.ui/src-gen/org/eclipse/xtext/xbase/contentassist/antlr/internal/InternalXbase.g:1:276: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}