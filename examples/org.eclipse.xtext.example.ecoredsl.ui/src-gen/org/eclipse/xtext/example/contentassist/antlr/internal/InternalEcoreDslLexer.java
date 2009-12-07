package org.eclipse.xtext.example.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEcoreDslLexer extends Lexer {
    public static final int T29=29;
    public static final int T36=36;
    public static final int RULE_STRING=4;
    public static final int T35=35;
    public static final int RULE_READONLY=10;
    public static final int T45=45;
    public static final int T20=20;
    public static final int T34=34;
    public static final int T25=25;
    public static final int T18=18;
    public static final int T37=37;
    public static final int T26=26;
    public static final int RULE_INT=6;
    public static final int T32=32;
    public static final int T17=17;
    public static final int T51=51;
    public static final int RULE_SERIALIZABLE=7;
    public static final int RULE_RANDOM=9;
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
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_ID=5;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T43=43;
    public static final int T23=23;
    public static final int T28=28;
    public static final int RULE_BAG=8;
    public static final int T42=42;
    public static final int T40=40;
    public static final int T56=56;
    public static final int RULE_WS=14;
    public static final int T48=48;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int RULE_LOCAL=11;
    public static final int Tokens=57;
    public static final int T53=53;
    public static final int RULE_ANY_OTHER=15;
    public static final int T31=31;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=13;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T30=30;
    public InternalEcoreDslLexer() {;} 
    public InternalEcoreDslLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g"; }

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:10:5: ( 'class' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:10:7: 'class'
            {
            match("class"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:11:5: ( 'ref' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:11:7: 'ref'
            {
            match("ref"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:12:5: ( 'void' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:12:7: 'void'
            {
            match("void"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:13:5: ( '.' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:13:7: '.'
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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:14:5: ( '$' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:14:7: '$'
            {
            match('$'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:15:5: ( 'import' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:15:7: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:16:5: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:16:7: ';'
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
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:17:5: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:17:7: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:18:5: ( 'package' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:18:7: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:19:5: ( 'nsURI' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:19:7: 'nsURI'
            {
            match("nsURI"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:20:5: ( 'nsPrefix' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:20:7: 'nsPrefix'
            {
            match("nsPrefix"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:21:5: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:21:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:22:5: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:22:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:23:5: ( 'datatype' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:23:7: 'datatype'
            {
            match("datatype"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:24:5: ( ':' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:24:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:25:5: ( '@' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:25:7: '@'
            {
            match('@'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:26:5: ( '(' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:26:7: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:27:5: ( ')' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:27:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:28:5: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:28:7: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:29:5: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:29:7: '<'
            {
            match('<'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:30:5: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:30:7: '>'
            {
            match('>'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:31:5: ( 'extends' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:31:7: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:32:5: ( 'attr' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:32:7: 'attr'
            {
            match("attr"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:33:5: ( '[' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:33:7: '['
            {
            match('['); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:34:5: ( ']' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:34:7: ']'
            {
            match(']'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:35:5: ( '..' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:35:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:36:5: ( '#' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:36:7: '#'
            {
            match('#'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:37:5: ( 'enum' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:37:7: 'enum'
            {
            match("enum"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:38:5: ( '?' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:38:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:39:5: ( 'super' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:39:7: 'super'
            {
            match("super"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:40:5: ( 'op' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:40:7: 'op'
            {
            match("op"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:41:5: ( 'throws' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:41:7: 'throws'
            {
            match("throws"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:42:5: ( '-' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:42:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:43:5: ( 'abstract' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:43:7: 'abstract'
            {
            match("abstract"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:44:5: ( 'interface' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:44:7: 'interface'
            {
            match("interface"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:45:5: ( 'ID' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:45:7: 'ID'
            {
            match("ID"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:46:5: ( 'volatile' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:46:7: 'volatile'
            {
            match("volatile"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:47:5: ( 'transient' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:47:7: 'transient'
            {
            match("transient"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:48:5: ( 'unsettable' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:48:7: 'unsettable'
            {
            match("unsettable"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:49:5: ( 'derived' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:49:7: 'derived'
            {
            match("derived"); 


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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:50:5: ( 'val' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:50:7: 'val'
            {
            match("val"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T56

    // $ANTLR start RULE_BAG
    public final void mRULE_BAG() throws RecognitionException {
        try {
            int _type = RULE_BAG;
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6350:10: ( 'bag' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6350:12: 'bag'
            {
            match("bag"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_BAG

    // $ANTLR start RULE_RANDOM
    public final void mRULE_RANDOM() throws RecognitionException {
        try {
            int _type = RULE_RANDOM;
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6352:13: ( 'random' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6352:15: 'random'
            {
            match("random"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_RANDOM

    // $ANTLR start RULE_READONLY
    public final void mRULE_READONLY() throws RecognitionException {
        try {
            int _type = RULE_READONLY;
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6354:15: ( 'readonly' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6354:17: 'readonly'
            {
            match("readonly"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_READONLY

    // $ANTLR start RULE_LOCAL
    public final void mRULE_LOCAL() throws RecognitionException {
        try {
            int _type = RULE_LOCAL;
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6356:12: ( 'local' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6356:14: 'local'
            {
            match("local"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_LOCAL

    // $ANTLR start RULE_SERIALIZABLE
    public final void mRULE_SERIALIZABLE() throws RecognitionException {
        try {
            int _type = RULE_SERIALIZABLE;
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6358:19: ( '!serializable' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6358:21: '!serializable'
            {
            match("!serializable"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SERIALIZABLE

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6360:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6360:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6360:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6360:11: '^'
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

            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6360:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:
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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6362:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6362:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6362:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6362:13: '0' .. '9'
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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("6364:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6364:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6366:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6366:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6366:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6366:52: .
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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6368:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6368:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6368:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6368:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6368:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6368:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6368:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6368:41: '\\r'
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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6370:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6370:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6370:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:
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
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6372:16: ( . )
            // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:6372:18: .
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
        // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:8: ( T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | RULE_BAG | RULE_RANDOM | RULE_READONLY | RULE_LOCAL | RULE_SERIALIZABLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=53;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='c') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0=='r') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='v') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0=='.') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='$') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='i') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0==';') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0=='=') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0=='p') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='n') ) {
            alt12 = mTokensHelper010();
        }
        else if ( (LA12_0=='{') ) {
            alt12 = mTokensHelper011();
        }
        else if ( (LA12_0=='}') ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0=='d') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0==':') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='@') ) {
            alt12 = mTokensHelper015();
        }
        else if ( (LA12_0=='(') ) {
            alt12 = mTokensHelper016();
        }
        else if ( (LA12_0==')') ) {
            alt12 = mTokensHelper017();
        }
        else if ( (LA12_0==',') ) {
            alt12 = mTokensHelper018();
        }
        else if ( (LA12_0=='<') ) {
            alt12 = mTokensHelper019();
        }
        else if ( (LA12_0=='>') ) {
            alt12 = mTokensHelper020();
        }
        else if ( (LA12_0=='e') ) {
            alt12 = mTokensHelper021();
        }
        else if ( (LA12_0=='a') ) {
            alt12 = mTokensHelper022();
        }
        else if ( (LA12_0=='[') ) {
            alt12 = mTokensHelper023();
        }
        else if ( (LA12_0==']') ) {
            alt12 = mTokensHelper024();
        }
        else if ( (LA12_0=='#') ) {
            alt12 = mTokensHelper025();
        }
        else if ( (LA12_0=='?') ) {
            alt12 = mTokensHelper026();
        }
        else if ( (LA12_0=='s') ) {
            alt12 = mTokensHelper027();
        }
        else if ( (LA12_0=='o') ) {
            alt12 = mTokensHelper028();
        }
        else if ( (LA12_0=='t') ) {
            alt12 = mTokensHelper029();
        }
        else if ( (LA12_0=='-') ) {
            alt12 = mTokensHelper030();
        }
        else if ( (LA12_0=='I') ) {
            alt12 = mTokensHelper031();
        }
        else if ( (LA12_0=='u') ) {
            alt12 = mTokensHelper032();
        }
        else if ( (LA12_0=='b') ) {
            alt12 = mTokensHelper033();
        }
        else if ( (LA12_0=='l') ) {
            alt12 = mTokensHelper034();
        }
        else if ( (LA12_0=='!') ) {
            alt12 = mTokensHelper035();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper036();
        }
        else if ( ((LA12_0>='A' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='f' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||LA12_0=='m'||LA12_0=='q'||(LA12_0>='w' && LA12_0<='z')) ) {
            alt12 = mTokensHelper037();
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12 = mTokensHelper038();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper039();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper040();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper041();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper042();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='%' && LA12_0<='&')||(LA12_0>='*' && LA12_0<='+')||LA12_0=='\\'||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper043();
        }
        else {
            alt12 = mTokensHelper044();
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:10: T16
                {
                mT16(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:14: T17
                {
                mT17(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:18: T18
                {
                mT18(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:22: T19
                {
                mT19(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:26: T20
                {
                mT20(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:30: T21
                {
                mT21(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:34: T22
                {
                mT22(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:38: T23
                {
                mT23(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:42: T24
                {
                mT24(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:46: T25
                {
                mT25(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:50: T26
                {
                mT26(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:54: T27
                {
                mT27(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:58: T28
                {
                mT28(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:62: T29
                {
                mT29(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:66: T30
                {
                mT30(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:70: T31
                {
                mT31(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:74: T32
                {
                mT32(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:78: T33
                {
                mT33(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:82: T34
                {
                mT34(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:86: T35
                {
                mT35(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:90: T36
                {
                mT36(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:94: T37
                {
                mT37(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:98: T38
                {
                mT38(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:102: T39
                {
                mT39(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:106: T40
                {
                mT40(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:110: T41
                {
                mT41(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:114: T42
                {
                mT42(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:118: T43
                {
                mT43(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:122: T44
                {
                mT44(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:126: T45
                {
                mT45(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:130: T46
                {
                mT46(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:134: T47
                {
                mT47(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:138: T48
                {
                mT48(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:142: T49
                {
                mT49(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:146: T50
                {
                mT50(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:150: T51
                {
                mT51(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:154: T52
                {
                mT52(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:158: T53
                {
                mT53(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:162: T54
                {
                mT54(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:166: T55
                {
                mT55(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:170: T56
                {
                mT56(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:174: RULE_BAG
                {
                mRULE_BAG(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:183: RULE_RANDOM
                {
                mRULE_RANDOM(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:195: RULE_READONLY
                {
                mRULE_READONLY(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:209: RULE_LOCAL
                {
                mRULE_LOCAL(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:220: RULE_SERIALIZABLE
                {
                mRULE_SERIALIZABLE(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:238: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:246: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:255: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:267: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:283: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:299: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g:1:307: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        int LA12_1 = input.LA(2);

        if ( (LA12_1=='l') ) {
            int LA12_44 = input.LA(3);

            if ( (LA12_44=='a') ) {
                int LA12_93 = input.LA(4);

                if ( (LA12_93=='s') ) {
                    int LA12_119 = input.LA(5);

                    if ( (LA12_119=='s') ) {
                        int LA12_143 = input.LA(6);

                        if ( ((LA12_143>='0' && LA12_143<='9')||(LA12_143>='A' && LA12_143<='Z')||LA12_143=='_'||(LA12_143>='a' && LA12_143<='z')) ) {
                            return 47;
                        }
                        else {
                            return 1;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
        }
        else {
            return 47;}
    }

    private int mTokensHelper002() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA12_46 = input.LA(3);

            if ( (LA12_46=='n') ) {
                int LA12_94 = input.LA(4);

                if ( (LA12_94=='d') ) {
                    int LA12_120 = input.LA(5);

                    if ( (LA12_120=='o') ) {
                        int LA12_144 = input.LA(6);

                        if ( (LA12_144=='m') ) {
                            int LA12_165 = input.LA(7);

                            if ( ((LA12_165>='0' && LA12_165<='9')||(LA12_165>='A' && LA12_165<='Z')||LA12_165=='_'||(LA12_165>='a' && LA12_165<='z')) ) {
                                return 47;
                            }
                            else {
                                return 43;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        case 'e':
            {
            switch ( input.LA(3) ) {
            case 'a':
                {
                int LA12_95 = input.LA(4);

                if ( (LA12_95=='d') ) {
                    int LA12_121 = input.LA(5);

                    if ( (LA12_121=='o') ) {
                        int LA12_145 = input.LA(6);

                        if ( (LA12_145=='n') ) {
                            int LA12_166 = input.LA(7);

                            if ( (LA12_166=='l') ) {
                                int LA12_183 = input.LA(8);

                                if ( (LA12_183=='y') ) {
                                    int LA12_196 = input.LA(9);

                                    if ( ((LA12_196>='0' && LA12_196<='9')||(LA12_196>='A' && LA12_196<='Z')||LA12_196=='_'||(LA12_196>='a' && LA12_196<='z')) ) {
                                        return 47;
                                    }
                                    else {
                                        return 44;}
                                }
                                else {
                                    return 47;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
                }
            case 'f':
                {
                int LA12_96 = input.LA(4);

                if ( ((LA12_96>='0' && LA12_96<='9')||(LA12_96>='A' && LA12_96<='Z')||LA12_96=='_'||(LA12_96>='a' && LA12_96<='z')) ) {
                    return 47;
                }
                else {
                    return 2;}
                }
            default:
                return 47;}

            }
        default:
            return 47;}

    }

    private int mTokensHelper003() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA12_48 = input.LA(3);

            if ( (LA12_48=='l') ) {
                int LA12_97 = input.LA(4);

                if ( ((LA12_97>='0' && LA12_97<='9')||(LA12_97>='A' && LA12_97<='Z')||LA12_97=='_'||(LA12_97>='a' && LA12_97<='z')) ) {
                    return 47;
                }
                else {
                    return 41;}
            }
            else {
                return 47;}
            }
        case 'o':
            {
            switch ( input.LA(3) ) {
            case 'i':
                {
                int LA12_98 = input.LA(4);

                if ( (LA12_98=='d') ) {
                    int LA12_124 = input.LA(5);

                    if ( ((LA12_124>='0' && LA12_124<='9')||(LA12_124>='A' && LA12_124<='Z')||LA12_124=='_'||(LA12_124>='a' && LA12_124<='z')) ) {
                        return 47;
                    }
                    else {
                        return 3;}
                }
                else {
                    return 47;}
                }
            case 'l':
                {
                int LA12_99 = input.LA(4);

                if ( (LA12_99=='a') ) {
                    int LA12_125 = input.LA(5);

                    if ( (LA12_125=='t') ) {
                        int LA12_147 = input.LA(6);

                        if ( (LA12_147=='i') ) {
                            int LA12_167 = input.LA(7);

                            if ( (LA12_167=='l') ) {
                                int LA12_184 = input.LA(8);

                                if ( (LA12_184=='e') ) {
                                    int LA12_197 = input.LA(9);

                                    if ( ((LA12_197>='0' && LA12_197<='9')||(LA12_197>='A' && LA12_197<='Z')||LA12_197=='_'||(LA12_197>='a' && LA12_197<='z')) ) {
                                        return 47;
                                    }
                                    else {
                                        return 37;}
                                }
                                else {
                                    return 47;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
                }
            default:
                return 47;}

            }
        default:
            return 47;}

    }

    private int mTokensHelper004() throws RecognitionException {
        int LA12_4 = input.LA(2);

        if ( (LA12_4=='.') ) {
            return 26;
        }
        else {
            return 4;}
    }

    private int mTokensHelper005() throws RecognitionException {
        return 5;
    }

    private int mTokensHelper006() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'm':
            {
            int LA12_53 = input.LA(3);

            if ( (LA12_53=='p') ) {
                int LA12_100 = input.LA(4);

                if ( (LA12_100=='o') ) {
                    int LA12_126 = input.LA(5);

                    if ( (LA12_126=='r') ) {
                        int LA12_148 = input.LA(6);

                        if ( (LA12_148=='t') ) {
                            int LA12_168 = input.LA(7);

                            if ( ((LA12_168>='0' && LA12_168<='9')||(LA12_168>='A' && LA12_168<='Z')||LA12_168=='_'||(LA12_168>='a' && LA12_168<='z')) ) {
                                return 47;
                            }
                            else {
                                return 6;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        case 'n':
            {
            int LA12_54 = input.LA(3);

            if ( (LA12_54=='t') ) {
                int LA12_101 = input.LA(4);

                if ( (LA12_101=='e') ) {
                    int LA12_127 = input.LA(5);

                    if ( (LA12_127=='r') ) {
                        int LA12_149 = input.LA(6);

                        if ( (LA12_149=='f') ) {
                            int LA12_169 = input.LA(7);

                            if ( (LA12_169=='a') ) {
                                int LA12_186 = input.LA(8);

                                if ( (LA12_186=='c') ) {
                                    int LA12_198 = input.LA(9);

                                    if ( (LA12_198=='e') ) {
                                        int LA12_209 = input.LA(10);

                                        if ( ((LA12_209>='0' && LA12_209<='9')||(LA12_209>='A' && LA12_209<='Z')||LA12_209=='_'||(LA12_209>='a' && LA12_209<='z')) ) {
                                            return 47;
                                        }
                                        else {
                                            return 35;}
                                    }
                                    else {
                                        return 47;}
                                }
                                else {
                                    return 47;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        default:
            return 47;}

    }

    private int mTokensHelper007() throws RecognitionException {
        return 7;
    }

    private int mTokensHelper008() throws RecognitionException {
        return 8;
    }

    private int mTokensHelper009() throws RecognitionException {
        int LA12_9 = input.LA(2);

        if ( (LA12_9=='a') ) {
            int LA12_57 = input.LA(3);

            if ( (LA12_57=='c') ) {
                int LA12_102 = input.LA(4);

                if ( (LA12_102=='k') ) {
                    int LA12_128 = input.LA(5);

                    if ( (LA12_128=='a') ) {
                        int LA12_150 = input.LA(6);

                        if ( (LA12_150=='g') ) {
                            int LA12_170 = input.LA(7);

                            if ( (LA12_170=='e') ) {
                                int LA12_187 = input.LA(8);

                                if ( ((LA12_187>='0' && LA12_187<='9')||(LA12_187>='A' && LA12_187<='Z')||LA12_187=='_'||(LA12_187>='a' && LA12_187<='z')) ) {
                                    return 47;
                                }
                                else {
                                    return 9;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
        }
        else {
            return 47;}
    }

    private int mTokensHelper010() throws RecognitionException {
        int LA12_10 = input.LA(2);

        if ( (LA12_10=='s') ) {
            switch ( input.LA(3) ) {
            case 'P':
                {
                int LA12_103 = input.LA(4);

                if ( (LA12_103=='r') ) {
                    int LA12_129 = input.LA(5);

                    if ( (LA12_129=='e') ) {
                        int LA12_151 = input.LA(6);

                        if ( (LA12_151=='f') ) {
                            int LA12_171 = input.LA(7);

                            if ( (LA12_171=='i') ) {
                                int LA12_188 = input.LA(8);

                                if ( (LA12_188=='x') ) {
                                    int LA12_200 = input.LA(9);

                                    if ( ((LA12_200>='0' && LA12_200<='9')||(LA12_200>='A' && LA12_200<='Z')||LA12_200=='_'||(LA12_200>='a' && LA12_200<='z')) ) {
                                        return 47;
                                    }
                                    else {
                                        return 11;}
                                }
                                else {
                                    return 47;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
                }
            case 'U':
                {
                int LA12_104 = input.LA(4);

                if ( (LA12_104=='R') ) {
                    int LA12_130 = input.LA(5);

                    if ( (LA12_130=='I') ) {
                        int LA12_152 = input.LA(6);

                        if ( ((LA12_152>='0' && LA12_152<='9')||(LA12_152>='A' && LA12_152<='Z')||LA12_152=='_'||(LA12_152>='a' && LA12_152<='z')) ) {
                            return 47;
                        }
                        else {
                            return 10;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
                }
            default:
                return 47;}

        }
        else {
            return 47;}
    }

    private int mTokensHelper011() throws RecognitionException {
        return 12;
    }

    private int mTokensHelper012() throws RecognitionException {
        return 13;
    }

    private int mTokensHelper013() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA12_61 = input.LA(3);

            if ( (LA12_61=='t') ) {
                int LA12_105 = input.LA(4);

                if ( (LA12_105=='a') ) {
                    int LA12_131 = input.LA(5);

                    if ( (LA12_131=='t') ) {
                        int LA12_153 = input.LA(6);

                        if ( (LA12_153=='y') ) {
                            int LA12_173 = input.LA(7);

                            if ( (LA12_173=='p') ) {
                                int LA12_189 = input.LA(8);

                                if ( (LA12_189=='e') ) {
                                    int LA12_201 = input.LA(9);

                                    if ( ((LA12_201>='0' && LA12_201<='9')||(LA12_201>='A' && LA12_201<='Z')||LA12_201=='_'||(LA12_201>='a' && LA12_201<='z')) ) {
                                        return 47;
                                    }
                                    else {
                                        return 14;}
                                }
                                else {
                                    return 47;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        case 'e':
            {
            int LA12_62 = input.LA(3);

            if ( (LA12_62=='r') ) {
                int LA12_106 = input.LA(4);

                if ( (LA12_106=='i') ) {
                    int LA12_132 = input.LA(5);

                    if ( (LA12_132=='v') ) {
                        int LA12_154 = input.LA(6);

                        if ( (LA12_154=='e') ) {
                            int LA12_174 = input.LA(7);

                            if ( (LA12_174=='d') ) {
                                int LA12_190 = input.LA(8);

                                if ( ((LA12_190>='0' && LA12_190<='9')||(LA12_190>='A' && LA12_190<='Z')||LA12_190=='_'||(LA12_190>='a' && LA12_190<='z')) ) {
                                    return 47;
                                }
                                else {
                                    return 40;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        default:
            return 47;}

    }

    private int mTokensHelper014() throws RecognitionException {
        return 15;
    }

    private int mTokensHelper015() throws RecognitionException {
        return 16;
    }

    private int mTokensHelper016() throws RecognitionException {
        return 17;
    }

    private int mTokensHelper017() throws RecognitionException {
        return 18;
    }

    private int mTokensHelper018() throws RecognitionException {
        return 19;
    }

    private int mTokensHelper019() throws RecognitionException {
        return 20;
    }

    private int mTokensHelper020() throws RecognitionException {
        return 21;
    }

    private int mTokensHelper021() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'x':
            {
            int LA12_70 = input.LA(3);

            if ( (LA12_70=='t') ) {
                int LA12_107 = input.LA(4);

                if ( (LA12_107=='e') ) {
                    int LA12_133 = input.LA(5);

                    if ( (LA12_133=='n') ) {
                        int LA12_155 = input.LA(6);

                        if ( (LA12_155=='d') ) {
                            int LA12_175 = input.LA(7);

                            if ( (LA12_175=='s') ) {
                                int LA12_191 = input.LA(8);

                                if ( ((LA12_191>='0' && LA12_191<='9')||(LA12_191>='A' && LA12_191<='Z')||LA12_191=='_'||(LA12_191>='a' && LA12_191<='z')) ) {
                                    return 47;
                                }
                                else {
                                    return 22;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        case 'n':
            {
            int LA12_71 = input.LA(3);

            if ( (LA12_71=='u') ) {
                int LA12_108 = input.LA(4);

                if ( (LA12_108=='m') ) {
                    int LA12_134 = input.LA(5);

                    if ( ((LA12_134>='0' && LA12_134<='9')||(LA12_134>='A' && LA12_134<='Z')||LA12_134=='_'||(LA12_134>='a' && LA12_134<='z')) ) {
                        return 47;
                    }
                    else {
                        return 28;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        default:
            return 47;}

    }

    private int mTokensHelper022() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'b':
            {
            int LA12_72 = input.LA(3);

            if ( (LA12_72=='s') ) {
                int LA12_109 = input.LA(4);

                if ( (LA12_109=='t') ) {
                    int LA12_135 = input.LA(5);

                    if ( (LA12_135=='r') ) {
                        int LA12_157 = input.LA(6);

                        if ( (LA12_157=='a') ) {
                            int LA12_176 = input.LA(7);

                            if ( (LA12_176=='c') ) {
                                int LA12_192 = input.LA(8);

                                if ( (LA12_192=='t') ) {
                                    int LA12_204 = input.LA(9);

                                    if ( ((LA12_204>='0' && LA12_204<='9')||(LA12_204>='A' && LA12_204<='Z')||LA12_204=='_'||(LA12_204>='a' && LA12_204<='z')) ) {
                                        return 47;
                                    }
                                    else {
                                        return 34;}
                                }
                                else {
                                    return 47;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        case 't':
            {
            int LA12_73 = input.LA(3);

            if ( (LA12_73=='t') ) {
                int LA12_110 = input.LA(4);

                if ( (LA12_110=='r') ) {
                    int LA12_136 = input.LA(5);

                    if ( ((LA12_136>='0' && LA12_136<='9')||(LA12_136>='A' && LA12_136<='Z')||LA12_136=='_'||(LA12_136>='a' && LA12_136<='z')) ) {
                        return 47;
                    }
                    else {
                        return 23;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        default:
            return 47;}

    }

    private int mTokensHelper023() throws RecognitionException {
        return 24;
    }

    private int mTokensHelper024() throws RecognitionException {
        return 25;
    }

    private int mTokensHelper025() throws RecognitionException {
        return 27;
    }

    private int mTokensHelper026() throws RecognitionException {
        return 29;
    }

    private int mTokensHelper027() throws RecognitionException {
        int LA12_27 = input.LA(2);

        if ( (LA12_27=='u') ) {
            int LA12_78 = input.LA(3);

            if ( (LA12_78=='p') ) {
                int LA12_111 = input.LA(4);

                if ( (LA12_111=='e') ) {
                    int LA12_137 = input.LA(5);

                    if ( (LA12_137=='r') ) {
                        int LA12_159 = input.LA(6);

                        if ( ((LA12_159>='0' && LA12_159<='9')||(LA12_159>='A' && LA12_159<='Z')||LA12_159=='_'||(LA12_159>='a' && LA12_159<='z')) ) {
                            return 47;
                        }
                        else {
                            return 30;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
        }
        else {
            return 47;}
    }

    private int mTokensHelper028() throws RecognitionException {
        int LA12_28 = input.LA(2);

        if ( (LA12_28=='p') ) {
            int LA12_79 = input.LA(3);

            if ( ((LA12_79>='0' && LA12_79<='9')||(LA12_79>='A' && LA12_79<='Z')||LA12_79=='_'||(LA12_79>='a' && LA12_79<='z')) ) {
                return 47;
            }
            else {
                return 31;}
        }
        else {
            return 47;}
    }

    private int mTokensHelper029() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'r':
            {
            int LA12_80 = input.LA(3);

            if ( (LA12_80=='a') ) {
                int LA12_113 = input.LA(4);

                if ( (LA12_113=='n') ) {
                    int LA12_138 = input.LA(5);

                    if ( (LA12_138=='s') ) {
                        int LA12_160 = input.LA(6);

                        if ( (LA12_160=='i') ) {
                            int LA12_178 = input.LA(7);

                            if ( (LA12_178=='e') ) {
                                int LA12_193 = input.LA(8);

                                if ( (LA12_193=='n') ) {
                                    int LA12_205 = input.LA(9);

                                    if ( (LA12_205=='t') ) {
                                        int LA12_213 = input.LA(10);

                                        if ( ((LA12_213>='0' && LA12_213<='9')||(LA12_213>='A' && LA12_213<='Z')||LA12_213=='_'||(LA12_213>='a' && LA12_213<='z')) ) {
                                            return 47;
                                        }
                                        else {
                                            return 38;}
                                    }
                                    else {
                                        return 47;}
                                }
                                else {
                                    return 47;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        case 'h':
            {
            int LA12_81 = input.LA(3);

            if ( (LA12_81=='r') ) {
                int LA12_114 = input.LA(4);

                if ( (LA12_114=='o') ) {
                    int LA12_139 = input.LA(5);

                    if ( (LA12_139=='w') ) {
                        int LA12_161 = input.LA(6);

                        if ( (LA12_161=='s') ) {
                            int LA12_179 = input.LA(7);

                            if ( ((LA12_179>='0' && LA12_179<='9')||(LA12_179>='A' && LA12_179<='Z')||LA12_179=='_'||(LA12_179>='a' && LA12_179<='z')) ) {
                                return 47;
                            }
                            else {
                                return 32;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
            }
        default:
            return 47;}

    }

    private int mTokensHelper030() throws RecognitionException {
        return 33;
    }

    private int mTokensHelper031() throws RecognitionException {
        int LA12_31 = input.LA(2);

        if ( (LA12_31=='D') ) {
            int LA12_83 = input.LA(3);

            if ( ((LA12_83>='0' && LA12_83<='9')||(LA12_83>='A' && LA12_83<='Z')||LA12_83=='_'||(LA12_83>='a' && LA12_83<='z')) ) {
                return 47;
            }
            else {
                return 36;}
        }
        else {
            return 47;}
    }

    private int mTokensHelper032() throws RecognitionException {
        int LA12_32 = input.LA(2);

        if ( (LA12_32=='n') ) {
            int LA12_84 = input.LA(3);

            if ( (LA12_84=='s') ) {
                int LA12_116 = input.LA(4);

                if ( (LA12_116=='e') ) {
                    int LA12_140 = input.LA(5);

                    if ( (LA12_140=='t') ) {
                        int LA12_162 = input.LA(6);

                        if ( (LA12_162=='t') ) {
                            int LA12_180 = input.LA(7);

                            if ( (LA12_180=='a') ) {
                                int LA12_195 = input.LA(8);

                                if ( (LA12_195=='b') ) {
                                    int LA12_206 = input.LA(9);

                                    if ( (LA12_206=='l') ) {
                                        int LA12_214 = input.LA(10);

                                        if ( (LA12_214=='e') ) {
                                            int LA12_217 = input.LA(11);

                                            if ( ((LA12_217>='0' && LA12_217<='9')||(LA12_217>='A' && LA12_217<='Z')||LA12_217=='_'||(LA12_217>='a' && LA12_217<='z')) ) {
                                                return 47;
                                            }
                                            else {
                                                return 39;}
                                        }
                                        else {
                                            return 47;}
                                    }
                                    else {
                                        return 47;}
                                }
                                else {
                                    return 47;}
                            }
                            else {
                                return 47;}
                        }
                        else {
                            return 47;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
        }
        else {
            return 47;}
    }

    private int mTokensHelper033() throws RecognitionException {
        int LA12_33 = input.LA(2);

        if ( (LA12_33=='a') ) {
            int LA12_85 = input.LA(3);

            if ( (LA12_85=='g') ) {
                int LA12_117 = input.LA(4);

                if ( ((LA12_117>='0' && LA12_117<='9')||(LA12_117>='A' && LA12_117<='Z')||LA12_117=='_'||(LA12_117>='a' && LA12_117<='z')) ) {
                    return 47;
                }
                else {
                    return 42;}
            }
            else {
                return 47;}
        }
        else {
            return 47;}
    }

    private int mTokensHelper034() throws RecognitionException {
        int LA12_34 = input.LA(2);

        if ( (LA12_34=='o') ) {
            int LA12_86 = input.LA(3);

            if ( (LA12_86=='c') ) {
                int LA12_118 = input.LA(4);

                if ( (LA12_118=='a') ) {
                    int LA12_142 = input.LA(5);

                    if ( (LA12_142=='l') ) {
                        int LA12_163 = input.LA(6);

                        if ( ((LA12_163>='0' && LA12_163<='9')||(LA12_163>='A' && LA12_163<='Z')||LA12_163=='_'||(LA12_163>='a' && LA12_163<='z')) ) {
                            return 47;
                        }
                        else {
                            return 45;}
                    }
                    else {
                        return 47;}
                }
                else {
                    return 47;}
            }
            else {
                return 47;}
        }
        else {
            return 47;}
    }

    private int mTokensHelper035() throws RecognitionException {
        int LA12_35 = input.LA(2);

        if ( (LA12_35=='s') ) {
            return 46;
        }
        else {
            return 53;}
    }

    private int mTokensHelper036() throws RecognitionException {
        int LA12_36 = input.LA(2);

        if ( ((LA12_36>='A' && LA12_36<='Z')||LA12_36=='_'||(LA12_36>='a' && LA12_36<='z')) ) {
            return 47;
        }
        else {
            return 53;}
    }

    private int mTokensHelper037() throws RecognitionException {
        return 47;
    }

    private int mTokensHelper038() throws RecognitionException {
        return 48;
    }

    private int mTokensHelper039() throws RecognitionException {
        int LA12_39 = input.LA(2);

        if ( ((LA12_39>='\u0000' && LA12_39<='\uFFFE')) ) {
            return 49;
        }
        else {
            return 53;}
    }

    private int mTokensHelper040() throws RecognitionException {
        int LA12_40 = input.LA(2);

        if ( ((LA12_40>='\u0000' && LA12_40<='\uFFFE')) ) {
            return 49;
        }
        else {
            return 53;}
    }

    private int mTokensHelper041() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '/':
            {
            return 51;
            }
        case '*':
            {
            return 50;
            }
        default:
            return 53;}

    }

    private int mTokensHelper042() throws RecognitionException {
        return 52;
    }

    private int mTokensHelper043() throws RecognitionException {
        return 53;
    }

    private int mTokensHelper044() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | RULE_BAG | RULE_RANDOM | RULE_READONLY | RULE_LOCAL | RULE_SERIALIZABLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}