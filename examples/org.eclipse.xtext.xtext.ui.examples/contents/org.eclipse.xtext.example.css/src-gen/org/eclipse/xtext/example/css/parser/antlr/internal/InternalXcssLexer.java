package org.eclipse.xtext.example.css.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXcssLexer extends Lexer {
    public static final int T14=14;
    public static final int T29=29;
    public static final int T36=36;
    public static final int T58=58;
    public static final int T70=70;
    public static final int RULE_STRING=5;
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
    public static final int RULE_INT=6;
    public static final int T32=32;
    public static final int T17=17;
    public static final int T51=51;
    public static final int T46=46;
    public static final int T16=16;
    public static final int T38=38;
    public static final int T41=41;
    public static final int T24=24;
    public static final int T19=19;
    public static final int T69=69;
    public static final int T39=39;
    public static final int T21=21;
    public static final int T62=62;
    public static final int T44=44;
    public static final int T55=55;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T68=68;
    public static final int T33=33;
    public static final int T11=11;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T43=43;
    public static final int T12=12;
    public static final int T23=23;
    public static final int T28=28;
    public static final int T42=42;
    public static final int T66=66;
    public static final int T40=40;
    public static final int T71=71;
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
    public static final int T67=67;
    public static final int T47=47;
    public static final int Tokens=72;
    public static final int T53=53;
    public static final int T60=60;
    public static final int RULE_ANY_OTHER=10;
    public static final int T31=31;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T30=30;
    public InternalXcssLexer() {;} 
    public InternalXcssLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:10:5: ( '{' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:10:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:11:5: ( '}' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:11:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:12:5: ( '*' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:12:7: '*'
            {
            match('*'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:13:5: ( '[' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:13:7: '['
            {
            match('['); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:14:5: ( ']' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:14:7: ']'
            {
            match(']'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:15:5: ( ';' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:15:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:16:5: ( ':' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:16:7: ':'
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
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:17:5: ( 'font' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:17:7: 'font'
            {
            match("font"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:18:5: ( 'I' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:18:7: 'I'
            {
            match('I'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:19:5: ( 'B' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:19:7: 'B'
            {
            match('B'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:20:5: ( '#' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:20:7: '#'
            {
            match('#'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:21:5: ( '||' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:21:7: '||'
            {
            match("||"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:22:5: ( '&&' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:22:7: '&&'
            {
            match("&&"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:23:5: ( '==' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:23:7: '=='
            {
            match("=="); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:24:5: ( '!=' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:24:7: '!='
            {
            match("!="); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:25:5: ( 'instanceof' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:25:7: 'instanceof'
            {
            match("instanceof"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:26:5: ( '>=' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:26:7: '>='
            {
            match(">="); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:27:5: ( '<=' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:27:7: '<='
            {
            match("<="); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:28:5: ( '>' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:28:7: '>'
            {
            match('>'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:29:5: ( '<' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:29:7: '<'
            {
            match('<'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:30:5: ( '->' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:30:7: '->'
            {
            match("->"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:31:5: ( '..' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:31:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:32:5: ( '+' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:32:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:33:5: ( '-' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:33:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:34:5: ( '**' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:34:7: '**'
            {
            match("**"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:35:5: ( '/' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:35:7: '/'
            {
            match('/'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:36:5: ( '%' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:36:7: '%'
            {
            match('%'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:37:5: ( '!' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:37:7: '!'
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:38:5: ( '.' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:38:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:39:5: ( '(' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:39:7: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:40:5: ( ',' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:40:7: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:41:5: ( ')' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:41:7: ')'
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:42:5: ( '|' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:42:7: '|'
            {
            match('|'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:43:5: ( 'if' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:43:7: 'if'
            {
            match("if"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:44:5: ( 'else' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:44:7: 'else'
            {
            match("else"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:45:5: ( 'switch' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:45:7: 'switch'
            {
            match("switch"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:46:5: ( 'default' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:46:7: 'default'
            {
            match("default"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:47:5: ( 'case' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:47:7: 'case'
            {
            match("case"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:48:5: ( 'for' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:48:7: 'for'
            {
            match("for"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:49:5: ( 'while' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:49:7: 'while'
            {
            match("while"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:50:5: ( 'do' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:50:7: 'do'
            {
            match("do"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:51:5: ( 'var' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:51:7: 'var'
            {
            match("var"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:52:5: ( 'val' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:52:7: 'val'
            {
            match("val"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:53:5: ( '=' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:53:7: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:54:5: ( 'new' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:54:7: 'new'
            {
            match("new"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:55:5: ( 'false' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:55:7: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:56:5: ( 'true' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:56:7: 'true'
            {
            match("true"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:57:5: ( 'null' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:57:7: 'null'
            {
            match("null"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:58:5: ( 'class' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:58:7: 'class'
            {
            match("class"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:59:5: ( 'throw' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:59:7: 'throw'
            {
            match("throw"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:60:5: ( 'try' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:60:7: 'try'
            {
            match("try"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:61:5: ( 'finally' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:61:7: 'finally'
            {
            match("finally"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:62:5: ( 'catch' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:62:7: 'catch'
            {
            match("catch"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:63:5: ( '=>' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:63:7: '=>'
            {
            match("=>"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:64:5: ( '?' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:64:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:65:5: ( 'extends' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:65:7: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:66:5: ( '&' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:66:7: '&'
            {
            match('&'); 

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:67:5: ( 'super' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:67:7: 'super'
            {
            match("super"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:68:5: ( 'em' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:68:7: 'em'
            {
            match("em"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:69:5: ( 'pt' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:69:7: 'pt'
            {
            match("pt"); 


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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:70:5: ( 'px' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:70:7: 'px'
            {
            match("px"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T71

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5386:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5386:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5386:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5386:11: '^'
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5386:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5388:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5388:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5388:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5388:13: '0' .. '9'
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("5390:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5390:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5392:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5392:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5392:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5392:52: .
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5394:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5394:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5394:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5394:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5394:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5394:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5394:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5394:41: '\\r'
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5396:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5396:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5396:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5398:16: ( . )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5398:18: .
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
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=68;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='{') ) {
            alt12=1;
        }
        else if ( (LA12_0=='}') ) {
            alt12=2;
        }
        else if ( (LA12_0=='*') ) {
            int LA12_3 = input.LA(2);

            if ( (LA12_3=='*') ) {
                alt12=25;
            }
            else {
                alt12=3;}
        }
        else if ( (LA12_0=='[') ) {
            alt12=4;
        }
        else if ( (LA12_0==']') ) {
            alt12=5;
        }
        else if ( (LA12_0==';') ) {
            alt12=6;
        }
        else if ( (LA12_0==':') ) {
            alt12=7;
        }
        else if ( (LA12_0=='f') ) {
            switch ( input.LA(2) ) {
            case 'o':
                {
                switch ( input.LA(3) ) {
                case 'r':
                    {
                    int LA12_107 = input.LA(4);

                    if ( ((LA12_107>='0' && LA12_107<='9')||(LA12_107>='A' && LA12_107<='Z')||LA12_107=='_'||(LA12_107>='a' && LA12_107<='z')) ) {
                        alt12=62;
                    }
                    else {
                        alt12=39;}
                    }
                    break;
                case 'n':
                    {
                    int LA12_108 = input.LA(4);

                    if ( (LA12_108=='t') ) {
                        int LA12_134 = input.LA(5);

                        if ( ((LA12_134>='0' && LA12_134<='9')||(LA12_134>='A' && LA12_134<='Z')||LA12_134=='_'||(LA12_134>='a' && LA12_134<='z')) ) {
                            alt12=62;
                        }
                        else {
                            alt12=8;}
                    }
                    else {
                        alt12=62;}
                    }
                    break;
                default:
                    alt12=62;}

                }
                break;
            case 'i':
                {
                int LA12_53 = input.LA(3);

                if ( (LA12_53=='n') ) {
                    int LA12_109 = input.LA(4);

                    if ( (LA12_109=='a') ) {
                        int LA12_135 = input.LA(5);

                        if ( (LA12_135=='l') ) {
                            int LA12_155 = input.LA(6);

                            if ( (LA12_155=='l') ) {
                                int LA12_170 = input.LA(7);

                                if ( (LA12_170=='y') ) {
                                    int LA12_181 = input.LA(8);

                                    if ( ((LA12_181>='0' && LA12_181<='9')||(LA12_181>='A' && LA12_181<='Z')||LA12_181=='_'||(LA12_181>='a' && LA12_181<='z')) ) {
                                        alt12=62;
                                    }
                                    else {
                                        alt12=52;}
                                }
                                else {
                                    alt12=62;}
                            }
                            else {
                                alt12=62;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            case 'a':
                {
                int LA12_54 = input.LA(3);

                if ( (LA12_54=='l') ) {
                    int LA12_110 = input.LA(4);

                    if ( (LA12_110=='s') ) {
                        int LA12_136 = input.LA(5);

                        if ( (LA12_136=='e') ) {
                            int LA12_156 = input.LA(6);

                            if ( ((LA12_156>='0' && LA12_156<='9')||(LA12_156>='A' && LA12_156<='Z')||LA12_156=='_'||(LA12_156>='a' && LA12_156<='z')) ) {
                                alt12=62;
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            default:
                alt12=62;}

        }
        else if ( (LA12_0=='I') ) {
            int LA12_9 = input.LA(2);

            if ( ((LA12_9>='0' && LA12_9<='9')||(LA12_9>='A' && LA12_9<='Z')||LA12_9=='_'||(LA12_9>='a' && LA12_9<='z')) ) {
                alt12=62;
            }
            else {
                alt12=9;}
        }
        else if ( (LA12_0=='B') ) {
            int LA12_10 = input.LA(2);

            if ( ((LA12_10>='0' && LA12_10<='9')||(LA12_10>='A' && LA12_10<='Z')||LA12_10=='_'||(LA12_10>='a' && LA12_10<='z')) ) {
                alt12=62;
            }
            else {
                alt12=10;}
        }
        else if ( (LA12_0=='#') ) {
            alt12=11;
        }
        else if ( (LA12_0=='|') ) {
            int LA12_12 = input.LA(2);

            if ( (LA12_12=='|') ) {
                alt12=12;
            }
            else {
                alt12=33;}
        }
        else if ( (LA12_0=='&') ) {
            int LA12_13 = input.LA(2);

            if ( (LA12_13=='&') ) {
                alt12=13;
            }
            else {
                alt12=57;}
        }
        else if ( (LA12_0=='=') ) {
            switch ( input.LA(2) ) {
            case '>':
                {
                alt12=54;
                }
                break;
            case '=':
                {
                alt12=14;
                }
                break;
            default:
                alt12=44;}

        }
        else if ( (LA12_0=='!') ) {
            int LA12_15 = input.LA(2);

            if ( (LA12_15=='=') ) {
                alt12=15;
            }
            else {
                alt12=28;}
        }
        else if ( (LA12_0=='i') ) {
            switch ( input.LA(2) ) {
            case 'f':
                {
                int LA12_68 = input.LA(3);

                if ( ((LA12_68>='0' && LA12_68<='9')||(LA12_68>='A' && LA12_68<='Z')||LA12_68=='_'||(LA12_68>='a' && LA12_68<='z')) ) {
                    alt12=62;
                }
                else {
                    alt12=34;}
                }
                break;
            case 'n':
                {
                int LA12_69 = input.LA(3);

                if ( (LA12_69=='s') ) {
                    int LA12_112 = input.LA(4);

                    if ( (LA12_112=='t') ) {
                        int LA12_137 = input.LA(5);

                        if ( (LA12_137=='a') ) {
                            int LA12_157 = input.LA(6);

                            if ( (LA12_157=='n') ) {
                                int LA12_172 = input.LA(7);

                                if ( (LA12_172=='c') ) {
                                    int LA12_182 = input.LA(8);

                                    if ( (LA12_182=='e') ) {
                                        int LA12_187 = input.LA(9);

                                        if ( (LA12_187=='o') ) {
                                            int LA12_190 = input.LA(10);

                                            if ( (LA12_190=='f') ) {
                                                int LA12_191 = input.LA(11);

                                                if ( ((LA12_191>='0' && LA12_191<='9')||(LA12_191>='A' && LA12_191<='Z')||LA12_191=='_'||(LA12_191>='a' && LA12_191<='z')) ) {
                                                    alt12=62;
                                                }
                                                else {
                                                    alt12=16;}
                                            }
                                            else {
                                                alt12=62;}
                                        }
                                        else {
                                            alt12=62;}
                                    }
                                    else {
                                        alt12=62;}
                                }
                                else {
                                    alt12=62;}
                            }
                            else {
                                alt12=62;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            default:
                alt12=62;}

        }
        else if ( (LA12_0=='>') ) {
            int LA12_17 = input.LA(2);

            if ( (LA12_17=='=') ) {
                alt12=17;
            }
            else {
                alt12=19;}
        }
        else if ( (LA12_0=='<') ) {
            int LA12_18 = input.LA(2);

            if ( (LA12_18=='=') ) {
                alt12=18;
            }
            else {
                alt12=20;}
        }
        else if ( (LA12_0=='-') ) {
            int LA12_19 = input.LA(2);

            if ( (LA12_19=='>') ) {
                alt12=21;
            }
            else {
                alt12=24;}
        }
        else if ( (LA12_0=='.') ) {
            int LA12_20 = input.LA(2);

            if ( (LA12_20=='.') ) {
                alt12=22;
            }
            else {
                alt12=29;}
        }
        else if ( (LA12_0=='+') ) {
            alt12=23;
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=66;
                }
                break;
            case '*':
                {
                alt12=65;
                }
                break;
            default:
                alt12=26;}

        }
        else if ( (LA12_0=='%') ) {
            alt12=27;
        }
        else if ( (LA12_0=='(') ) {
            alt12=30;
        }
        else if ( (LA12_0==',') ) {
            alt12=31;
        }
        else if ( (LA12_0==')') ) {
            alt12=32;
        }
        else if ( (LA12_0=='e') ) {
            switch ( input.LA(2) ) {
            case 'm':
                {
                int LA12_86 = input.LA(3);

                if ( ((LA12_86>='0' && LA12_86<='9')||(LA12_86>='A' && LA12_86<='Z')||LA12_86=='_'||(LA12_86>='a' && LA12_86<='z')) ) {
                    alt12=62;
                }
                else {
                    alt12=59;}
                }
                break;
            case 'x':
                {
                int LA12_87 = input.LA(3);

                if ( (LA12_87=='t') ) {
                    int LA12_114 = input.LA(4);

                    if ( (LA12_114=='e') ) {
                        int LA12_138 = input.LA(5);

                        if ( (LA12_138=='n') ) {
                            int LA12_158 = input.LA(6);

                            if ( (LA12_158=='d') ) {
                                int LA12_173 = input.LA(7);

                                if ( (LA12_173=='s') ) {
                                    int LA12_183 = input.LA(8);

                                    if ( ((LA12_183>='0' && LA12_183<='9')||(LA12_183>='A' && LA12_183<='Z')||LA12_183=='_'||(LA12_183>='a' && LA12_183<='z')) ) {
                                        alt12=62;
                                    }
                                    else {
                                        alt12=56;}
                                }
                                else {
                                    alt12=62;}
                            }
                            else {
                                alt12=62;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            case 'l':
                {
                int LA12_88 = input.LA(3);

                if ( (LA12_88=='s') ) {
                    int LA12_115 = input.LA(4);

                    if ( (LA12_115=='e') ) {
                        int LA12_139 = input.LA(5);

                        if ( ((LA12_139>='0' && LA12_139<='9')||(LA12_139>='A' && LA12_139<='Z')||LA12_139=='_'||(LA12_139>='a' && LA12_139<='z')) ) {
                            alt12=62;
                        }
                        else {
                            alt12=35;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            default:
                alt12=62;}

        }
        else if ( (LA12_0=='s') ) {
            switch ( input.LA(2) ) {
            case 'u':
                {
                int LA12_89 = input.LA(3);

                if ( (LA12_89=='p') ) {
                    int LA12_116 = input.LA(4);

                    if ( (LA12_116=='e') ) {
                        int LA12_140 = input.LA(5);

                        if ( (LA12_140=='r') ) {
                            int LA12_160 = input.LA(6);

                            if ( ((LA12_160>='0' && LA12_160<='9')||(LA12_160>='A' && LA12_160<='Z')||LA12_160=='_'||(LA12_160>='a' && LA12_160<='z')) ) {
                                alt12=62;
                            }
                            else {
                                alt12=58;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            case 'w':
                {
                int LA12_90 = input.LA(3);

                if ( (LA12_90=='i') ) {
                    int LA12_117 = input.LA(4);

                    if ( (LA12_117=='t') ) {
                        int LA12_141 = input.LA(5);

                        if ( (LA12_141=='c') ) {
                            int LA12_161 = input.LA(6);

                            if ( (LA12_161=='h') ) {
                                int LA12_175 = input.LA(7);

                                if ( ((LA12_175>='0' && LA12_175<='9')||(LA12_175>='A' && LA12_175<='Z')||LA12_175=='_'||(LA12_175>='a' && LA12_175<='z')) ) {
                                    alt12=62;
                                }
                                else {
                                    alt12=36;}
                            }
                            else {
                                alt12=62;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            default:
                alt12=62;}

        }
        else if ( (LA12_0=='d') ) {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA12_91 = input.LA(3);

                if ( ((LA12_91>='0' && LA12_91<='9')||(LA12_91>='A' && LA12_91<='Z')||LA12_91=='_'||(LA12_91>='a' && LA12_91<='z')) ) {
                    alt12=62;
                }
                else {
                    alt12=41;}
                }
                break;
            case 'e':
                {
                int LA12_92 = input.LA(3);

                if ( (LA12_92=='f') ) {
                    int LA12_119 = input.LA(4);

                    if ( (LA12_119=='a') ) {
                        int LA12_142 = input.LA(5);

                        if ( (LA12_142=='u') ) {
                            int LA12_162 = input.LA(6);

                            if ( (LA12_162=='l') ) {
                                int LA12_176 = input.LA(7);

                                if ( (LA12_176=='t') ) {
                                    int LA12_185 = input.LA(8);

                                    if ( ((LA12_185>='0' && LA12_185<='9')||(LA12_185>='A' && LA12_185<='Z')||LA12_185=='_'||(LA12_185>='a' && LA12_185<='z')) ) {
                                        alt12=62;
                                    }
                                    else {
                                        alt12=37;}
                                }
                                else {
                                    alt12=62;}
                            }
                            else {
                                alt12=62;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            default:
                alt12=62;}

        }
        else if ( (LA12_0=='c') ) {
            switch ( input.LA(2) ) {
            case 'l':
                {
                int LA12_93 = input.LA(3);

                if ( (LA12_93=='a') ) {
                    int LA12_120 = input.LA(4);

                    if ( (LA12_120=='s') ) {
                        int LA12_143 = input.LA(5);

                        if ( (LA12_143=='s') ) {
                            int LA12_163 = input.LA(6);

                            if ( ((LA12_163>='0' && LA12_163<='9')||(LA12_163>='A' && LA12_163<='Z')||LA12_163=='_'||(LA12_163>='a' && LA12_163<='z')) ) {
                                alt12=62;
                            }
                            else {
                                alt12=49;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            case 'a':
                {
                switch ( input.LA(3) ) {
                case 's':
                    {
                    int LA12_121 = input.LA(4);

                    if ( (LA12_121=='e') ) {
                        int LA12_144 = input.LA(5);

                        if ( ((LA12_144>='0' && LA12_144<='9')||(LA12_144>='A' && LA12_144<='Z')||LA12_144=='_'||(LA12_144>='a' && LA12_144<='z')) ) {
                            alt12=62;
                        }
                        else {
                            alt12=38;}
                    }
                    else {
                        alt12=62;}
                    }
                    break;
                case 't':
                    {
                    int LA12_122 = input.LA(4);

                    if ( (LA12_122=='c') ) {
                        int LA12_145 = input.LA(5);

                        if ( (LA12_145=='h') ) {
                            int LA12_165 = input.LA(6);

                            if ( ((LA12_165>='0' && LA12_165<='9')||(LA12_165>='A' && LA12_165<='Z')||LA12_165=='_'||(LA12_165>='a' && LA12_165<='z')) ) {
                                alt12=62;
                            }
                            else {
                                alt12=53;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                    }
                    break;
                default:
                    alt12=62;}

                }
                break;
            default:
                alt12=62;}

        }
        else if ( (LA12_0=='w') ) {
            int LA12_31 = input.LA(2);

            if ( (LA12_31=='h') ) {
                int LA12_95 = input.LA(3);

                if ( (LA12_95=='i') ) {
                    int LA12_123 = input.LA(4);

                    if ( (LA12_123=='l') ) {
                        int LA12_146 = input.LA(5);

                        if ( (LA12_146=='e') ) {
                            int LA12_166 = input.LA(6);

                            if ( ((LA12_166>='0' && LA12_166<='9')||(LA12_166>='A' && LA12_166<='Z')||LA12_166=='_'||(LA12_166>='a' && LA12_166<='z')) ) {
                                alt12=62;
                            }
                            else {
                                alt12=40;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
            }
            else {
                alt12=62;}
        }
        else if ( (LA12_0=='v') ) {
            int LA12_32 = input.LA(2);

            if ( (LA12_32=='a') ) {
                switch ( input.LA(3) ) {
                case 'l':
                    {
                    int LA12_124 = input.LA(4);

                    if ( ((LA12_124>='0' && LA12_124<='9')||(LA12_124>='A' && LA12_124<='Z')||LA12_124=='_'||(LA12_124>='a' && LA12_124<='z')) ) {
                        alt12=62;
                    }
                    else {
                        alt12=43;}
                    }
                    break;
                case 'r':
                    {
                    int LA12_125 = input.LA(4);

                    if ( ((LA12_125>='0' && LA12_125<='9')||(LA12_125>='A' && LA12_125<='Z')||LA12_125=='_'||(LA12_125>='a' && LA12_125<='z')) ) {
                        alt12=62;
                    }
                    else {
                        alt12=42;}
                    }
                    break;
                default:
                    alt12=62;}

            }
            else {
                alt12=62;}
        }
        else if ( (LA12_0=='n') ) {
            switch ( input.LA(2) ) {
            case 'u':
                {
                int LA12_97 = input.LA(3);

                if ( (LA12_97=='l') ) {
                    int LA12_126 = input.LA(4);

                    if ( (LA12_126=='l') ) {
                        int LA12_149 = input.LA(5);

                        if ( ((LA12_149>='0' && LA12_149<='9')||(LA12_149>='A' && LA12_149<='Z')||LA12_149=='_'||(LA12_149>='a' && LA12_149<='z')) ) {
                            alt12=62;
                        }
                        else {
                            alt12=48;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            case 'e':
                {
                int LA12_98 = input.LA(3);

                if ( (LA12_98=='w') ) {
                    int LA12_127 = input.LA(4);

                    if ( ((LA12_127>='0' && LA12_127<='9')||(LA12_127>='A' && LA12_127<='Z')||LA12_127=='_'||(LA12_127>='a' && LA12_127<='z')) ) {
                        alt12=62;
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=62;}
                }
                break;
            default:
                alt12=62;}

        }
        else if ( (LA12_0=='t') ) {
            switch ( input.LA(2) ) {
            case 'h':
                {
                int LA12_99 = input.LA(3);

                if ( (LA12_99=='r') ) {
                    int LA12_128 = input.LA(4);

                    if ( (LA12_128=='o') ) {
                        int LA12_151 = input.LA(5);

                        if ( (LA12_151=='w') ) {
                            int LA12_168 = input.LA(6);

                            if ( ((LA12_168>='0' && LA12_168<='9')||(LA12_168>='A' && LA12_168<='Z')||LA12_168=='_'||(LA12_168>='a' && LA12_168<='z')) ) {
                                alt12=62;
                            }
                            else {
                                alt12=50;}
                        }
                        else {
                            alt12=62;}
                    }
                    else {
                        alt12=62;}
                }
                else {
                    alt12=62;}
                }
                break;
            case 'r':
                {
                switch ( input.LA(3) ) {
                case 'y':
                    {
                    int LA12_129 = input.LA(4);

                    if ( ((LA12_129>='0' && LA12_129<='9')||(LA12_129>='A' && LA12_129<='Z')||LA12_129=='_'||(LA12_129>='a' && LA12_129<='z')) ) {
                        alt12=62;
                    }
                    else {
                        alt12=51;}
                    }
                    break;
                case 'u':
                    {
                    int LA12_130 = input.LA(4);

                    if ( (LA12_130=='e') ) {
                        int LA12_153 = input.LA(5);

                        if ( ((LA12_153>='0' && LA12_153<='9')||(LA12_153>='A' && LA12_153<='Z')||LA12_153=='_'||(LA12_153>='a' && LA12_153<='z')) ) {
                            alt12=62;
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=62;}
                    }
                    break;
                default:
                    alt12=62;}

                }
                break;
            default:
                alt12=62;}

        }
        else if ( (LA12_0=='?') ) {
            alt12=55;
        }
        else if ( (LA12_0=='p') ) {
            switch ( input.LA(2) ) {
            case 'x':
                {
                int LA12_102 = input.LA(3);

                if ( ((LA12_102>='0' && LA12_102<='9')||(LA12_102>='A' && LA12_102<='Z')||LA12_102=='_'||(LA12_102>='a' && LA12_102<='z')) ) {
                    alt12=62;
                }
                else {
                    alt12=61;}
                }
                break;
            case 't':
                {
                int LA12_103 = input.LA(3);

                if ( ((LA12_103>='0' && LA12_103<='9')||(LA12_103>='A' && LA12_103<='Z')||LA12_103=='_'||(LA12_103>='a' && LA12_103<='z')) ) {
                    alt12=62;
                }
                else {
                    alt12=60;}
                }
                break;
            default:
                alt12=62;}

        }
        else if ( (LA12_0=='^') ) {
            int LA12_37 = input.LA(2);

            if ( ((LA12_37>='A' && LA12_37<='Z')||LA12_37=='_'||(LA12_37>='a' && LA12_37<='z')) ) {
                alt12=62;
            }
            else {
                alt12=68;}
        }
        else if ( (LA12_0=='A'||(LA12_0>='C' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='b')||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='m')||LA12_0=='o'||(LA12_0>='q' && LA12_0<='r')||LA12_0=='u'||(LA12_0>='x' && LA12_0<='z')) ) {
            alt12=62;
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=63;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_40 = input.LA(2);

            if ( ((LA12_40>='\u0000' && LA12_40<='\uFFFE')) ) {
                alt12=64;
            }
            else {
                alt12=68;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_41 = input.LA(2);

            if ( ((LA12_41>='\u0000' && LA12_41<='\uFFFE')) ) {
                alt12=64;
            }
            else {
                alt12=68;}
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=67;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='$'||LA12_0=='@'||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12=68;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:122: T39
                {
                mT39(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:126: T40
                {
                mT40(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:130: T41
                {
                mT41(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:134: T42
                {
                mT42(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:138: T43
                {
                mT43(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:142: T44
                {
                mT44(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:146: T45
                {
                mT45(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:150: T46
                {
                mT46(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:154: T47
                {
                mT47(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:158: T48
                {
                mT48(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:162: T49
                {
                mT49(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:166: T50
                {
                mT50(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:170: T51
                {
                mT51(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:174: T52
                {
                mT52(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:178: T53
                {
                mT53(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:182: T54
                {
                mT54(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:186: T55
                {
                mT55(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:190: T56
                {
                mT56(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:194: T57
                {
                mT57(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:198: T58
                {
                mT58(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:202: T59
                {
                mT59(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:206: T60
                {
                mT60(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:210: T61
                {
                mT61(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:214: T62
                {
                mT62(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:218: T63
                {
                mT63(); 

                }
                break;
            case 54 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:222: T64
                {
                mT64(); 

                }
                break;
            case 55 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:226: T65
                {
                mT65(); 

                }
                break;
            case 56 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:230: T66
                {
                mT66(); 

                }
                break;
            case 57 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:234: T67
                {
                mT67(); 

                }
                break;
            case 58 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:238: T68
                {
                mT68(); 

                }
                break;
            case 59 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:242: T69
                {
                mT69(); 

                }
                break;
            case 60 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:246: T70
                {
                mT70(); 

                }
                break;
            case 61 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:250: T71
                {
                mT71(); 

                }
                break;
            case 62 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:254: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 63 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:262: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 64 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:271: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 65 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:283: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 66 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:299: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 67 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:315: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 68 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1:323: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}