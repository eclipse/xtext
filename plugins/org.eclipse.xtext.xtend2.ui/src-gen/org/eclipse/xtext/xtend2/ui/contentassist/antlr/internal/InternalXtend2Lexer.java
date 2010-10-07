package org.eclipse.xtext.xtend2.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtend2Lexer extends Lexer {
    public static final int T14=14;
    public static final int T29=29;
    public static final int T36=36;
    public static final int T58=58;
    public static final int RULE_STRING=6;
    public static final int T35=35;
    public static final int T61=61;
    public static final int T45=45;
    public static final int T20=20;
    public static final int T34=34;
    public static final int T64=64;
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
    public static final int T62=62;
    public static final int T44=44;
    public static final int T55=55;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T11=11;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T43=43;
    public static final int T12=12;
    public static final int T23=23;
    public static final int T28=28;
    public static final int T42=42;
    public static final int T40=40;
    public static final int T63=63;
    public static final int T57=57;
    public static final int T13=13;
    public static final int T65=65;
    public static final int T56=56;
    public static final int T59=59;
    public static final int RULE_WS=9;
    public static final int T48=48;
    public static final int T15=15;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int Tokens=66;
    public static final int T53=53;
    public static final int T60=60;
    public static final int RULE_ANY_OTHER=10;
    public static final int T31=31;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T30=30;
    public InternalXtend2Lexer() {;} 
    public InternalXtend2Lexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:10:5: ( '||' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:10:7: '||'
            {
            match("||"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11:5: ( '&&' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11:7: '&&'
            {
            match("&&"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:12:5: ( '=' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:12:7: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:13:5: ( '+=' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:13:7: '+='
            {
            match("+="); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:14:5: ( '==' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:14:7: '=='
            {
            match("=="); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:15:5: ( '!=' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:15:7: '!='
            {
            match("!="); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:16:5: ( '>=' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:16:7: '>='
            {
            match(">="); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:17:5: ( '<=' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:17:7: '<='
            {
            match("<="); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:18:5: ( '>' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:18:7: '>'
            {
            match('>'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:19:5: ( '<' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:19:7: '<'
            {
            match('<'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20:5: ( '->' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20:7: '->'
            {
            match("->"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:21:5: ( '..' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:21:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:22:5: ( '+' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:22:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:23:5: ( '-' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:23:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:24:5: ( '*' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:24:7: '*'
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:25:5: ( '**' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:25:7: '**'
            {
            match("**"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:26:5: ( '/' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:26:7: '/'
            {
            match('/'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:27:5: ( '%' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:27:7: '%'
            {
            match('%'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:28:5: ( '!' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:28:7: '!'
            {
            match('!'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:29:5: ( 'var' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:29:7: 'var'
            {
            match("var"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:30:5: ( 'val' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:30:7: 'val'
            {
            match("val"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:31:5: ( 'package' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:31:7: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:32:5: ( 'import' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:32:7: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:33:5: ( '.' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:33:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:34:5: ( 'class' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:34:7: 'class'
            {
            match("class"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:35:5: ( '{' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:35:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:36:5: ( '}' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:36:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:37:5: ( ',' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:37:7: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:38:5: ( 'extends' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:38:7: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:39:5: ( 'implements' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:39:7: 'implements'
            {
            match("implements"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:40:5: ( '(' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:40:7: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:41:5: ( ')' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:41:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:42:5: ( ':' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:42:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:43:5: ( ';' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:43:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:44:5: ( 'instanceof' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:44:7: 'instanceof'
            {
            match("instanceof"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:45:5: ( '|' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:45:7: '|'
            {
            match('|'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:46:5: ( 'if' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:46:7: 'if'
            {
            match("if"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:47:5: ( 'else' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:47:7: 'else'
            {
            match("else"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:48:5: ( 'switch' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:48:7: 'switch'
            {
            match("switch"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:49:5: ( 'default' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:49:7: 'default'
            {
            match("default"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:50:5: ( 'case' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:50:7: 'case'
            {
            match("case"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:51:5: ( 'while' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:51:7: 'while'
            {
            match("while"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:52:5: ( 'do' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:52:7: 'do'
            {
            match("do"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:53:5: ( 'new' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:53:7: 'new'
            {
            match("new"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:54:5: ( 'false' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:54:7: 'false'
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:55:5: ( 'null' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:55:7: 'null'
            {
            match("null"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:56:5: ( 'throw' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:56:7: 'throw'
            {
            match("throw"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:57:5: ( 'try' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:57:7: 'try'
            {
            match("try"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:58:5: ( 'finally' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:58:7: 'finally'
            {
            match("finally"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:59:5: ( 'catch' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:59:7: 'catch'
            {
            match("catch"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:60:5: ( '=>' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:60:7: '=>'
            {
            match("=>"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:61:5: ( '?' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:61:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:62:5: ( '&' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:62:7: '&'
            {
            match('&'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:63:5: ( 'super' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:63:7: 'super'
            {
            match("super"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:64:5: ( 'true' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:64:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T65

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11607:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11607:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11607:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11607:11: '^'
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

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11607:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11609:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11609:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11609:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11609:13: '0' .. '9'
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("11611:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11611:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11613:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11613:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11613:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11613:52: .
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11615:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11615:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11615:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11615:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11615:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11615:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11615:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11615:41: '\\r'
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11617:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11617:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11617:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11619:16: ( . )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11619:18: .
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
        // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=62;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='|') ) {
            int LA12_1 = input.LA(2);

            if ( (LA12_1=='|') ) {
                alt12=1;
            }
            else {
                alt12=36;}
        }
        else if ( (LA12_0=='&') ) {
            int LA12_2 = input.LA(2);

            if ( (LA12_2=='&') ) {
                alt12=2;
            }
            else {
                alt12=53;}
        }
        else if ( (LA12_0=='=') ) {
            switch ( input.LA(2) ) {
            case '>':
                {
                alt12=51;
                }
                break;
            case '=':
                {
                alt12=5;
                }
                break;
            default:
                alt12=3;}

        }
        else if ( (LA12_0=='+') ) {
            int LA12_4 = input.LA(2);

            if ( (LA12_4=='=') ) {
                alt12=4;
            }
            else {
                alt12=13;}
        }
        else if ( (LA12_0=='!') ) {
            int LA12_5 = input.LA(2);

            if ( (LA12_5=='=') ) {
                alt12=6;
            }
            else {
                alt12=19;}
        }
        else if ( (LA12_0=='>') ) {
            int LA12_6 = input.LA(2);

            if ( (LA12_6=='=') ) {
                alt12=7;
            }
            else {
                alt12=9;}
        }
        else if ( (LA12_0=='<') ) {
            int LA12_7 = input.LA(2);

            if ( (LA12_7=='=') ) {
                alt12=8;
            }
            else {
                alt12=10;}
        }
        else if ( (LA12_0=='-') ) {
            int LA12_8 = input.LA(2);

            if ( (LA12_8=='>') ) {
                alt12=11;
            }
            else {
                alt12=14;}
        }
        else if ( (LA12_0=='.') ) {
            int LA12_9 = input.LA(2);

            if ( (LA12_9=='.') ) {
                alt12=12;
            }
            else {
                alt12=24;}
        }
        else if ( (LA12_0=='*') ) {
            int LA12_10 = input.LA(2);

            if ( (LA12_10=='*') ) {
                alt12=16;
            }
            else {
                alt12=15;}
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=60;
                }
                break;
            case '*':
                {
                alt12=59;
                }
                break;
            default:
                alt12=17;}

        }
        else if ( (LA12_0=='%') ) {
            alt12=18;
        }
        else if ( (LA12_0=='v') ) {
            int LA12_13 = input.LA(2);

            if ( (LA12_13=='a') ) {
                switch ( input.LA(3) ) {
                case 'l':
                    {
                    int LA12_96 = input.LA(4);

                    if ( ((LA12_96>='0' && LA12_96<='9')||(LA12_96>='A' && LA12_96<='Z')||LA12_96=='_'||(LA12_96>='a' && LA12_96<='z')) ) {
                        alt12=56;
                    }
                    else {
                        alt12=21;}
                    }
                    break;
                case 'r':
                    {
                    int LA12_97 = input.LA(4);

                    if ( ((LA12_97>='0' && LA12_97<='9')||(LA12_97>='A' && LA12_97<='Z')||LA12_97=='_'||(LA12_97>='a' && LA12_97<='z')) ) {
                        alt12=56;
                    }
                    else {
                        alt12=20;}
                    }
                    break;
                default:
                    alt12=56;}

            }
            else {
                alt12=56;}
        }
        else if ( (LA12_0=='p') ) {
            int LA12_14 = input.LA(2);

            if ( (LA12_14=='a') ) {
                int LA12_66 = input.LA(3);

                if ( (LA12_66=='c') ) {
                    int LA12_98 = input.LA(4);

                    if ( (LA12_98=='k') ) {
                        int LA12_121 = input.LA(5);

                        if ( (LA12_121=='a') ) {
                            int LA12_141 = input.LA(6);

                            if ( (LA12_141=='g') ) {
                                int LA12_159 = input.LA(7);

                                if ( (LA12_159=='e') ) {
                                    int LA12_173 = input.LA(8);

                                    if ( ((LA12_173>='0' && LA12_173<='9')||(LA12_173>='A' && LA12_173<='Z')||LA12_173=='_'||(LA12_173>='a' && LA12_173<='z')) ) {
                                        alt12=56;
                                    }
                                    else {
                                        alt12=22;}
                                }
                                else {
                                    alt12=56;}
                            }
                            else {
                                alt12=56;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
            }
            else {
                alt12=56;}
        }
        else if ( (LA12_0=='i') ) {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA12_67 = input.LA(3);

                if ( (LA12_67=='s') ) {
                    int LA12_99 = input.LA(4);

                    if ( (LA12_99=='t') ) {
                        int LA12_122 = input.LA(5);

                        if ( (LA12_122=='a') ) {
                            int LA12_142 = input.LA(6);

                            if ( (LA12_142=='n') ) {
                                int LA12_160 = input.LA(7);

                                if ( (LA12_160=='c') ) {
                                    int LA12_174 = input.LA(8);

                                    if ( (LA12_174=='e') ) {
                                        int LA12_182 = input.LA(9);

                                        if ( (LA12_182=='o') ) {
                                            int LA12_187 = input.LA(10);

                                            if ( (LA12_187=='f') ) {
                                                int LA12_189 = input.LA(11);

                                                if ( ((LA12_189>='0' && LA12_189<='9')||(LA12_189>='A' && LA12_189<='Z')||LA12_189=='_'||(LA12_189>='a' && LA12_189<='z')) ) {
                                                    alt12=56;
                                                }
                                                else {
                                                    alt12=35;}
                                            }
                                            else {
                                                alt12=56;}
                                        }
                                        else {
                                            alt12=56;}
                                    }
                                    else {
                                        alt12=56;}
                                }
                                else {
                                    alt12=56;}
                            }
                            else {
                                alt12=56;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            case 'm':
                {
                int LA12_68 = input.LA(3);

                if ( (LA12_68=='p') ) {
                    switch ( input.LA(4) ) {
                    case 'o':
                        {
                        int LA12_123 = input.LA(5);

                        if ( (LA12_123=='r') ) {
                            int LA12_143 = input.LA(6);

                            if ( (LA12_143=='t') ) {
                                int LA12_161 = input.LA(7);

                                if ( ((LA12_161>='0' && LA12_161<='9')||(LA12_161>='A' && LA12_161<='Z')||LA12_161=='_'||(LA12_161>='a' && LA12_161<='z')) ) {
                                    alt12=56;
                                }
                                else {
                                    alt12=23;}
                            }
                            else {
                                alt12=56;}
                        }
                        else {
                            alt12=56;}
                        }
                        break;
                    case 'l':
                        {
                        int LA12_124 = input.LA(5);

                        if ( (LA12_124=='e') ) {
                            int LA12_144 = input.LA(6);

                            if ( (LA12_144=='m') ) {
                                int LA12_162 = input.LA(7);

                                if ( (LA12_162=='e') ) {
                                    int LA12_176 = input.LA(8);

                                    if ( (LA12_176=='n') ) {
                                        int LA12_183 = input.LA(9);

                                        if ( (LA12_183=='t') ) {
                                            int LA12_188 = input.LA(10);

                                            if ( (LA12_188=='s') ) {
                                                int LA12_190 = input.LA(11);

                                                if ( ((LA12_190>='0' && LA12_190<='9')||(LA12_190>='A' && LA12_190<='Z')||LA12_190=='_'||(LA12_190>='a' && LA12_190<='z')) ) {
                                                    alt12=56;
                                                }
                                                else {
                                                    alt12=30;}
                                            }
                                            else {
                                                alt12=56;}
                                        }
                                        else {
                                            alt12=56;}
                                    }
                                    else {
                                        alt12=56;}
                                }
                                else {
                                    alt12=56;}
                            }
                            else {
                                alt12=56;}
                        }
                        else {
                            alt12=56;}
                        }
                        break;
                    default:
                        alt12=56;}

                }
                else {
                    alt12=56;}
                }
                break;
            case 'f':
                {
                int LA12_69 = input.LA(3);

                if ( ((LA12_69>='0' && LA12_69<='9')||(LA12_69>='A' && LA12_69<='Z')||LA12_69=='_'||(LA12_69>='a' && LA12_69<='z')) ) {
                    alt12=56;
                }
                else {
                    alt12=37;}
                }
                break;
            default:
                alt12=56;}

        }
        else if ( (LA12_0=='c') ) {
            switch ( input.LA(2) ) {
            case 'l':
                {
                int LA12_70 = input.LA(3);

                if ( (LA12_70=='a') ) {
                    int LA12_102 = input.LA(4);

                    if ( (LA12_102=='s') ) {
                        int LA12_125 = input.LA(5);

                        if ( (LA12_125=='s') ) {
                            int LA12_145 = input.LA(6);

                            if ( ((LA12_145>='0' && LA12_145<='9')||(LA12_145>='A' && LA12_145<='Z')||LA12_145=='_'||(LA12_145>='a' && LA12_145<='z')) ) {
                                alt12=56;
                            }
                            else {
                                alt12=25;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            case 'a':
                {
                switch ( input.LA(3) ) {
                case 's':
                    {
                    int LA12_103 = input.LA(4);

                    if ( (LA12_103=='e') ) {
                        int LA12_126 = input.LA(5);

                        if ( ((LA12_126>='0' && LA12_126<='9')||(LA12_126>='A' && LA12_126<='Z')||LA12_126=='_'||(LA12_126>='a' && LA12_126<='z')) ) {
                            alt12=56;
                        }
                        else {
                            alt12=41;}
                    }
                    else {
                        alt12=56;}
                    }
                    break;
                case 't':
                    {
                    int LA12_104 = input.LA(4);

                    if ( (LA12_104=='c') ) {
                        int LA12_127 = input.LA(5);

                        if ( (LA12_127=='h') ) {
                            int LA12_147 = input.LA(6);

                            if ( ((LA12_147>='0' && LA12_147<='9')||(LA12_147>='A' && LA12_147<='Z')||LA12_147=='_'||(LA12_147>='a' && LA12_147<='z')) ) {
                                alt12=56;
                            }
                            else {
                                alt12=50;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                    }
                    break;
                default:
                    alt12=56;}

                }
                break;
            default:
                alt12=56;}

        }
        else if ( (LA12_0=='{') ) {
            alt12=26;
        }
        else if ( (LA12_0=='}') ) {
            alt12=27;
        }
        else if ( (LA12_0==',') ) {
            alt12=28;
        }
        else if ( (LA12_0=='e') ) {
            switch ( input.LA(2) ) {
            case 'l':
                {
                int LA12_75 = input.LA(3);

                if ( (LA12_75=='s') ) {
                    int LA12_105 = input.LA(4);

                    if ( (LA12_105=='e') ) {
                        int LA12_128 = input.LA(5);

                        if ( ((LA12_128>='0' && LA12_128<='9')||(LA12_128>='A' && LA12_128<='Z')||LA12_128=='_'||(LA12_128>='a' && LA12_128<='z')) ) {
                            alt12=56;
                        }
                        else {
                            alt12=38;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            case 'x':
                {
                int LA12_76 = input.LA(3);

                if ( (LA12_76=='t') ) {
                    int LA12_106 = input.LA(4);

                    if ( (LA12_106=='e') ) {
                        int LA12_129 = input.LA(5);

                        if ( (LA12_129=='n') ) {
                            int LA12_149 = input.LA(6);

                            if ( (LA12_149=='d') ) {
                                int LA12_165 = input.LA(7);

                                if ( (LA12_165=='s') ) {
                                    int LA12_177 = input.LA(8);

                                    if ( ((LA12_177>='0' && LA12_177<='9')||(LA12_177>='A' && LA12_177<='Z')||LA12_177=='_'||(LA12_177>='a' && LA12_177<='z')) ) {
                                        alt12=56;
                                    }
                                    else {
                                        alt12=29;}
                                }
                                else {
                                    alt12=56;}
                            }
                            else {
                                alt12=56;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            default:
                alt12=56;}

        }
        else if ( (LA12_0=='(') ) {
            alt12=31;
        }
        else if ( (LA12_0==')') ) {
            alt12=32;
        }
        else if ( (LA12_0==':') ) {
            alt12=33;
        }
        else if ( (LA12_0==';') ) {
            alt12=34;
        }
        else if ( (LA12_0=='s') ) {
            switch ( input.LA(2) ) {
            case 'u':
                {
                int LA12_81 = input.LA(3);

                if ( (LA12_81=='p') ) {
                    int LA12_107 = input.LA(4);

                    if ( (LA12_107=='e') ) {
                        int LA12_130 = input.LA(5);

                        if ( (LA12_130=='r') ) {
                            int LA12_150 = input.LA(6);

                            if ( ((LA12_150>='0' && LA12_150<='9')||(LA12_150>='A' && LA12_150<='Z')||LA12_150=='_'||(LA12_150>='a' && LA12_150<='z')) ) {
                                alt12=56;
                            }
                            else {
                                alt12=54;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            case 'w':
                {
                int LA12_82 = input.LA(3);

                if ( (LA12_82=='i') ) {
                    int LA12_108 = input.LA(4);

                    if ( (LA12_108=='t') ) {
                        int LA12_131 = input.LA(5);

                        if ( (LA12_131=='c') ) {
                            int LA12_151 = input.LA(6);

                            if ( (LA12_151=='h') ) {
                                int LA12_167 = input.LA(7);

                                if ( ((LA12_167>='0' && LA12_167<='9')||(LA12_167>='A' && LA12_167<='Z')||LA12_167=='_'||(LA12_167>='a' && LA12_167<='z')) ) {
                                    alt12=56;
                                }
                                else {
                                    alt12=39;}
                            }
                            else {
                                alt12=56;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            default:
                alt12=56;}

        }
        else if ( (LA12_0=='d') ) {
            switch ( input.LA(2) ) {
            case 'e':
                {
                int LA12_83 = input.LA(3);

                if ( (LA12_83=='f') ) {
                    int LA12_109 = input.LA(4);

                    if ( (LA12_109=='a') ) {
                        int LA12_132 = input.LA(5);

                        if ( (LA12_132=='u') ) {
                            int LA12_152 = input.LA(6);

                            if ( (LA12_152=='l') ) {
                                int LA12_168 = input.LA(7);

                                if ( (LA12_168=='t') ) {
                                    int LA12_179 = input.LA(8);

                                    if ( ((LA12_179>='0' && LA12_179<='9')||(LA12_179>='A' && LA12_179<='Z')||LA12_179=='_'||(LA12_179>='a' && LA12_179<='z')) ) {
                                        alt12=56;
                                    }
                                    else {
                                        alt12=40;}
                                }
                                else {
                                    alt12=56;}
                            }
                            else {
                                alt12=56;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            case 'o':
                {
                int LA12_84 = input.LA(3);

                if ( ((LA12_84>='0' && LA12_84<='9')||(LA12_84>='A' && LA12_84<='Z')||LA12_84=='_'||(LA12_84>='a' && LA12_84<='z')) ) {
                    alt12=56;
                }
                else {
                    alt12=43;}
                }
                break;
            default:
                alt12=56;}

        }
        else if ( (LA12_0=='w') ) {
            int LA12_27 = input.LA(2);

            if ( (LA12_27=='h') ) {
                int LA12_85 = input.LA(3);

                if ( (LA12_85=='i') ) {
                    int LA12_111 = input.LA(4);

                    if ( (LA12_111=='l') ) {
                        int LA12_133 = input.LA(5);

                        if ( (LA12_133=='e') ) {
                            int LA12_153 = input.LA(6);

                            if ( ((LA12_153>='0' && LA12_153<='9')||(LA12_153>='A' && LA12_153<='Z')||LA12_153=='_'||(LA12_153>='a' && LA12_153<='z')) ) {
                                alt12=56;
                            }
                            else {
                                alt12=42;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
            }
            else {
                alt12=56;}
        }
        else if ( (LA12_0=='n') ) {
            switch ( input.LA(2) ) {
            case 'e':
                {
                int LA12_86 = input.LA(3);

                if ( (LA12_86=='w') ) {
                    int LA12_112 = input.LA(4);

                    if ( ((LA12_112>='0' && LA12_112<='9')||(LA12_112>='A' && LA12_112<='Z')||LA12_112=='_'||(LA12_112>='a' && LA12_112<='z')) ) {
                        alt12=56;
                    }
                    else {
                        alt12=44;}
                }
                else {
                    alt12=56;}
                }
                break;
            case 'u':
                {
                int LA12_87 = input.LA(3);

                if ( (LA12_87=='l') ) {
                    int LA12_113 = input.LA(4);

                    if ( (LA12_113=='l') ) {
                        int LA12_135 = input.LA(5);

                        if ( ((LA12_135>='0' && LA12_135<='9')||(LA12_135>='A' && LA12_135<='Z')||LA12_135=='_'||(LA12_135>='a' && LA12_135<='z')) ) {
                            alt12=56;
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            default:
                alt12=56;}

        }
        else if ( (LA12_0=='f') ) {
            switch ( input.LA(2) ) {
            case 'i':
                {
                int LA12_88 = input.LA(3);

                if ( (LA12_88=='n') ) {
                    int LA12_114 = input.LA(4);

                    if ( (LA12_114=='a') ) {
                        int LA12_136 = input.LA(5);

                        if ( (LA12_136=='l') ) {
                            int LA12_155 = input.LA(6);

                            if ( (LA12_155=='l') ) {
                                int LA12_170 = input.LA(7);

                                if ( (LA12_170=='y') ) {
                                    int LA12_180 = input.LA(8);

                                    if ( ((LA12_180>='0' && LA12_180<='9')||(LA12_180>='A' && LA12_180<='Z')||LA12_180=='_'||(LA12_180>='a' && LA12_180<='z')) ) {
                                        alt12=56;
                                    }
                                    else {
                                        alt12=49;}
                                }
                                else {
                                    alt12=56;}
                            }
                            else {
                                alt12=56;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            case 'a':
                {
                int LA12_89 = input.LA(3);

                if ( (LA12_89=='l') ) {
                    int LA12_115 = input.LA(4);

                    if ( (LA12_115=='s') ) {
                        int LA12_137 = input.LA(5);

                        if ( (LA12_137=='e') ) {
                            int LA12_156 = input.LA(6);

                            if ( ((LA12_156>='0' && LA12_156<='9')||(LA12_156>='A' && LA12_156<='Z')||LA12_156=='_'||(LA12_156>='a' && LA12_156<='z')) ) {
                                alt12=56;
                            }
                            else {
                                alt12=45;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            default:
                alt12=56;}

        }
        else if ( (LA12_0=='t') ) {
            switch ( input.LA(2) ) {
            case 'r':
                {
                switch ( input.LA(3) ) {
                case 'y':
                    {
                    int LA12_116 = input.LA(4);

                    if ( ((LA12_116>='0' && LA12_116<='9')||(LA12_116>='A' && LA12_116<='Z')||LA12_116=='_'||(LA12_116>='a' && LA12_116<='z')) ) {
                        alt12=56;
                    }
                    else {
                        alt12=48;}
                    }
                    break;
                case 'u':
                    {
                    int LA12_117 = input.LA(4);

                    if ( (LA12_117=='e') ) {
                        int LA12_139 = input.LA(5);

                        if ( ((LA12_139>='0' && LA12_139<='9')||(LA12_139>='A' && LA12_139<='Z')||LA12_139=='_'||(LA12_139>='a' && LA12_139<='z')) ) {
                            alt12=56;
                        }
                        else {
                            alt12=55;}
                    }
                    else {
                        alt12=56;}
                    }
                    break;
                default:
                    alt12=56;}

                }
                break;
            case 'h':
                {
                int LA12_91 = input.LA(3);

                if ( (LA12_91=='r') ) {
                    int LA12_118 = input.LA(4);

                    if ( (LA12_118=='o') ) {
                        int LA12_140 = input.LA(5);

                        if ( (LA12_140=='w') ) {
                            int LA12_158 = input.LA(6);

                            if ( ((LA12_158>='0' && LA12_158<='9')||(LA12_158>='A' && LA12_158<='Z')||LA12_158=='_'||(LA12_158>='a' && LA12_158<='z')) ) {
                                alt12=56;
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=56;}
                    }
                    else {
                        alt12=56;}
                }
                else {
                    alt12=56;}
                }
                break;
            default:
                alt12=56;}

        }
        else if ( (LA12_0=='?') ) {
            alt12=52;
        }
        else if ( (LA12_0=='^') ) {
            int LA12_32 = input.LA(2);

            if ( ((LA12_32>='A' && LA12_32<='Z')||LA12_32=='_'||(LA12_32>='a' && LA12_32<='z')) ) {
                alt12=56;
            }
            else {
                alt12=62;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='b')||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='m')||LA12_0=='o'||(LA12_0>='q' && LA12_0<='r')||LA12_0=='u'||(LA12_0>='x' && LA12_0<='z')) ) {
            alt12=56;
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=57;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_35 = input.LA(2);

            if ( ((LA12_35>='\u0000' && LA12_35<='\uFFFE')) ) {
                alt12=58;
            }
            else {
                alt12=62;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_36 = input.LA(2);

            if ( ((LA12_36>='\u0000' && LA12_36<='\uFFFE')) ) {
                alt12=58;
            }
            else {
                alt12=62;}
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=61;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='#' && LA12_0<='$')||LA12_0=='@'||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12=62;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:122: T39
                {
                mT39(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:126: T40
                {
                mT40(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:130: T41
                {
                mT41(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:134: T42
                {
                mT42(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:138: T43
                {
                mT43(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:142: T44
                {
                mT44(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:146: T45
                {
                mT45(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:150: T46
                {
                mT46(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:154: T47
                {
                mT47(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:158: T48
                {
                mT48(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:162: T49
                {
                mT49(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:166: T50
                {
                mT50(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:170: T51
                {
                mT51(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:174: T52
                {
                mT52(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:178: T53
                {
                mT53(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:182: T54
                {
                mT54(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:186: T55
                {
                mT55(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:190: T56
                {
                mT56(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:194: T57
                {
                mT57(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:198: T58
                {
                mT58(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:202: T59
                {
                mT59(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:206: T60
                {
                mT60(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:210: T61
                {
                mT61(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:214: T62
                {
                mT62(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:218: T63
                {
                mT63(); 

                }
                break;
            case 54 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:222: T64
                {
                mT64(); 

                }
                break;
            case 55 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:226: T65
                {
                mT65(); 

                }
                break;
            case 56 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:230: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 57 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:238: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 58 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:247: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 59 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:259: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 60 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:275: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 61 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:291: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 62 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:299: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}