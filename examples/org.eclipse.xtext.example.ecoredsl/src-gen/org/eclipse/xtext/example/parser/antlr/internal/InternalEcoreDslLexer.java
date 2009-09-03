package org.eclipse.xtext.example.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEcoreDslLexer extends Lexer {
    public static final int T29=29;
    public static final int T36=36;
    public static final int RULE_STRING=5;
    public static final int T35=35;
    public static final int RULE_READONLY=9;
    public static final int T45=45;
    public static final int T20=20;
    public static final int T34=34;
    public static final int T25=25;
    public static final int T18=18;
    public static final int T37=37;
    public static final int T26=26;
    public static final int RULE_INT=10;
    public static final int T32=32;
    public static final int T17=17;
    public static final int T51=51;
    public static final int RULE_SERIALIZABLE=6;
    public static final int RULE_RANDOM=8;
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
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T43=43;
    public static final int T23=23;
    public static final int T28=28;
    public static final int RULE_BAG=7;
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g"; }

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:10:5: ( 'import' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:10:7: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:11:5: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:11:7: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:12:5: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:12:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:13:5: ( 'package' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:13:7: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:14:5: ( 'nsURI' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:14:7: 'nsURI'
            {
            match("nsURI"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:15:5: ( 'nsPrefix' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:15:7: 'nsPrefix'
            {
            match("nsPrefix"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:16:5: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:16:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:17:5: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:17:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:18:5: ( 'datatype' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:18:7: 'datatype'
            {
            match("datatype"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:19:5: ( ':' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:19:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:20:5: ( '@' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:20:7: '@'
            {
            match('@'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:21:5: ( '(' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:21:7: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:22:5: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:22:7: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:23:5: ( ')' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:23:7: ')'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:24:5: ( 'abstract' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:24:7: 'abstract'
            {
            match("abstract"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:25:5: ( 'interface' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:25:7: 'interface'
            {
            match("interface"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:26:5: ( 'class' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:26:7: 'class'
            {
            match("class"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:27:5: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:27:7: '<'
            {
            match('<'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:28:5: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:28:7: '>'
            {
            match('>'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:29:5: ( 'extends' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:29:7: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:30:5: ( 'ID' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:30:7: 'ID'
            {
            match("ID"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:31:5: ( 'volatile' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:31:7: 'volatile'
            {
            match("volatile"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:32:5: ( 'transient' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:32:7: 'transient'
            {
            match("transient"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:33:5: ( 'unsettable' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:33:7: 'unsettable'
            {
            match("unsettable"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:34:5: ( 'derived' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:34:7: 'derived'
            {
            match("derived"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:35:5: ( 'attr' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:35:7: 'attr'
            {
            match("attr"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:36:5: ( '[' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:36:7: '['
            {
            match('['); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:37:5: ( '..' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:37:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:38:5: ( ']' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:38:7: ']'
            {
            match(']'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:39:5: ( 'val' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:39:7: 'val'
            {
            match("val"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:40:5: ( 'ref' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:40:7: 'ref'
            {
            match("ref"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:41:5: ( '#' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:41:7: '#'
            {
            match('#'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:42:5: ( 'enum' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:42:7: 'enum'
            {
            match("enum"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:43:5: ( '?' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:43:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:44:5: ( 'super' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:44:7: 'super'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:45:5: ( 'op' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:45:7: 'op'
            {
            match("op"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:46:5: ( 'void' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:46:7: 'void'
            {
            match("void"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:47:5: ( 'throws' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:47:7: 'throws'
            {
            match("throws"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:48:5: ( '.' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:48:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:49:5: ( '$' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:49:7: '$'
            {
            match('$'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:50:5: ( '-' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:50:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3156:10: ( 'bag' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3156:12: 'bag'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3158:13: ( 'random' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3158:15: 'random'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3160:15: ( 'readonly' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3160:17: 'readonly'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3162:12: ( 'local' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3162:14: 'local'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3164:19: ( '!serializable' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3164:21: '!serializable'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3166:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3166:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3166:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3166:11: '^'
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3166:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3168:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3168:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3168:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3168:13: '0' .. '9'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("3170:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3170:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3172:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3172:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3172:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3172:52: .
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3174:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3174:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3174:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3174:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3174:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3174:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3174:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3174:41: '\\r'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3176:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3176:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3176:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3178:16: ( . )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:3178:18: .
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
        // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:8: ( T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | RULE_BAG | RULE_RANDOM | RULE_READONLY | RULE_LOCAL | RULE_SERIALIZABLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=53;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='i') ) {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA12_44 = input.LA(3);

                if ( (LA12_44=='t') ) {
                    int LA12_93 = input.LA(4);

                    if ( (LA12_93=='e') ) {
                        int LA12_119 = input.LA(5);

                        if ( (LA12_119=='r') ) {
                            int LA12_143 = input.LA(6);

                            if ( (LA12_143=='f') ) {
                                int LA12_164 = input.LA(7);

                                if ( (LA12_164=='a') ) {
                                    int LA12_182 = input.LA(8);

                                    if ( (LA12_182=='c') ) {
                                        int LA12_196 = input.LA(9);

                                        if ( (LA12_196=='e') ) {
                                            int LA12_207 = input.LA(10);

                                            if ( ((LA12_207>='0' && LA12_207<='9')||(LA12_207>='A' && LA12_207<='Z')||LA12_207=='_'||(LA12_207>='a' && LA12_207<='z')) ) {
                                                alt12=47;
                                            }
                                            else {
                                                alt12=16;}
                                        }
                                        else {
                                            alt12=47;}
                                    }
                                    else {
                                        alt12=47;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            case 'm':
                {
                int LA12_45 = input.LA(3);

                if ( (LA12_45=='p') ) {
                    int LA12_94 = input.LA(4);

                    if ( (LA12_94=='o') ) {
                        int LA12_120 = input.LA(5);

                        if ( (LA12_120=='r') ) {
                            int LA12_144 = input.LA(6);

                            if ( (LA12_144=='t') ) {
                                int LA12_165 = input.LA(7);

                                if ( ((LA12_165>='0' && LA12_165<='9')||(LA12_165>='A' && LA12_165<='Z')||LA12_165=='_'||(LA12_165>='a' && LA12_165<='z')) ) {
                                    alt12=47;
                                }
                                else {
                                    alt12=1;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            default:
                alt12=47;}

        }
        else if ( (LA12_0=='=') ) {
            alt12=2;
        }
        else if ( (LA12_0==';') ) {
            alt12=3;
        }
        else if ( (LA12_0=='p') ) {
            int LA12_4 = input.LA(2);

            if ( (LA12_4=='a') ) {
                int LA12_49 = input.LA(3);

                if ( (LA12_49=='c') ) {
                    int LA12_95 = input.LA(4);

                    if ( (LA12_95=='k') ) {
                        int LA12_121 = input.LA(5);

                        if ( (LA12_121=='a') ) {
                            int LA12_145 = input.LA(6);

                            if ( (LA12_145=='g') ) {
                                int LA12_166 = input.LA(7);

                                if ( (LA12_166=='e') ) {
                                    int LA12_184 = input.LA(8);

                                    if ( ((LA12_184>='0' && LA12_184<='9')||(LA12_184>='A' && LA12_184<='Z')||LA12_184=='_'||(LA12_184>='a' && LA12_184<='z')) ) {
                                        alt12=47;
                                    }
                                    else {
                                        alt12=4;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
            }
            else {
                alt12=47;}
        }
        else if ( (LA12_0=='n') ) {
            int LA12_5 = input.LA(2);

            if ( (LA12_5=='s') ) {
                switch ( input.LA(3) ) {
                case 'U':
                    {
                    int LA12_96 = input.LA(4);

                    if ( (LA12_96=='R') ) {
                        int LA12_122 = input.LA(5);

                        if ( (LA12_122=='I') ) {
                            int LA12_146 = input.LA(6);

                            if ( ((LA12_146>='0' && LA12_146<='9')||(LA12_146>='A' && LA12_146<='Z')||LA12_146=='_'||(LA12_146>='a' && LA12_146<='z')) ) {
                                alt12=47;
                            }
                            else {
                                alt12=5;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                    }
                    break;
                case 'P':
                    {
                    int LA12_97 = input.LA(4);

                    if ( (LA12_97=='r') ) {
                        int LA12_123 = input.LA(5);

                        if ( (LA12_123=='e') ) {
                            int LA12_147 = input.LA(6);

                            if ( (LA12_147=='f') ) {
                                int LA12_168 = input.LA(7);

                                if ( (LA12_168=='i') ) {
                                    int LA12_185 = input.LA(8);

                                    if ( (LA12_185=='x') ) {
                                        int LA12_198 = input.LA(9);

                                        if ( ((LA12_198>='0' && LA12_198<='9')||(LA12_198>='A' && LA12_198<='Z')||LA12_198=='_'||(LA12_198>='a' && LA12_198<='z')) ) {
                                            alt12=47;
                                        }
                                        else {
                                            alt12=6;}
                                    }
                                    else {
                                        alt12=47;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                    }
                    break;
                default:
                    alt12=47;}

            }
            else {
                alt12=47;}
        }
        else if ( (LA12_0=='{') ) {
            alt12=7;
        }
        else if ( (LA12_0=='}') ) {
            alt12=8;
        }
        else if ( (LA12_0=='d') ) {
            switch ( input.LA(2) ) {
            case 'e':
                {
                int LA12_53 = input.LA(3);

                if ( (LA12_53=='r') ) {
                    int LA12_98 = input.LA(4);

                    if ( (LA12_98=='i') ) {
                        int LA12_124 = input.LA(5);

                        if ( (LA12_124=='v') ) {
                            int LA12_148 = input.LA(6);

                            if ( (LA12_148=='e') ) {
                                int LA12_169 = input.LA(7);

                                if ( (LA12_169=='d') ) {
                                    int LA12_186 = input.LA(8);

                                    if ( ((LA12_186>='0' && LA12_186<='9')||(LA12_186>='A' && LA12_186<='Z')||LA12_186=='_'||(LA12_186>='a' && LA12_186<='z')) ) {
                                        alt12=47;
                                    }
                                    else {
                                        alt12=25;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            case 'a':
                {
                int LA12_54 = input.LA(3);

                if ( (LA12_54=='t') ) {
                    int LA12_99 = input.LA(4);

                    if ( (LA12_99=='a') ) {
                        int LA12_125 = input.LA(5);

                        if ( (LA12_125=='t') ) {
                            int LA12_149 = input.LA(6);

                            if ( (LA12_149=='y') ) {
                                int LA12_170 = input.LA(7);

                                if ( (LA12_170=='p') ) {
                                    int LA12_187 = input.LA(8);

                                    if ( (LA12_187=='e') ) {
                                        int LA12_200 = input.LA(9);

                                        if ( ((LA12_200>='0' && LA12_200<='9')||(LA12_200>='A' && LA12_200<='Z')||LA12_200=='_'||(LA12_200>='a' && LA12_200<='z')) ) {
                                            alt12=47;
                                        }
                                        else {
                                            alt12=9;}
                                    }
                                    else {
                                        alt12=47;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            default:
                alt12=47;}

        }
        else if ( (LA12_0==':') ) {
            alt12=10;
        }
        else if ( (LA12_0=='@') ) {
            alt12=11;
        }
        else if ( (LA12_0=='(') ) {
            alt12=12;
        }
        else if ( (LA12_0==',') ) {
            alt12=13;
        }
        else if ( (LA12_0==')') ) {
            alt12=14;
        }
        else if ( (LA12_0=='a') ) {
            switch ( input.LA(2) ) {
            case 'b':
                {
                int LA12_60 = input.LA(3);

                if ( (LA12_60=='s') ) {
                    int LA12_100 = input.LA(4);

                    if ( (LA12_100=='t') ) {
                        int LA12_126 = input.LA(5);

                        if ( (LA12_126=='r') ) {
                            int LA12_150 = input.LA(6);

                            if ( (LA12_150=='a') ) {
                                int LA12_171 = input.LA(7);

                                if ( (LA12_171=='c') ) {
                                    int LA12_188 = input.LA(8);

                                    if ( (LA12_188=='t') ) {
                                        int LA12_201 = input.LA(9);

                                        if ( ((LA12_201>='0' && LA12_201<='9')||(LA12_201>='A' && LA12_201<='Z')||LA12_201=='_'||(LA12_201>='a' && LA12_201<='z')) ) {
                                            alt12=47;
                                        }
                                        else {
                                            alt12=15;}
                                    }
                                    else {
                                        alt12=47;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            case 't':
                {
                int LA12_61 = input.LA(3);

                if ( (LA12_61=='t') ) {
                    int LA12_101 = input.LA(4);

                    if ( (LA12_101=='r') ) {
                        int LA12_127 = input.LA(5);

                        if ( ((LA12_127>='0' && LA12_127<='9')||(LA12_127>='A' && LA12_127<='Z')||LA12_127=='_'||(LA12_127>='a' && LA12_127<='z')) ) {
                            alt12=47;
                        }
                        else {
                            alt12=26;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            default:
                alt12=47;}

        }
        else if ( (LA12_0=='c') ) {
            int LA12_15 = input.LA(2);

            if ( (LA12_15=='l') ) {
                int LA12_62 = input.LA(3);

                if ( (LA12_62=='a') ) {
                    int LA12_102 = input.LA(4);

                    if ( (LA12_102=='s') ) {
                        int LA12_128 = input.LA(5);

                        if ( (LA12_128=='s') ) {
                            int LA12_152 = input.LA(6);

                            if ( ((LA12_152>='0' && LA12_152<='9')||(LA12_152>='A' && LA12_152<='Z')||LA12_152=='_'||(LA12_152>='a' && LA12_152<='z')) ) {
                                alt12=47;
                            }
                            else {
                                alt12=17;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
            }
            else {
                alt12=47;}
        }
        else if ( (LA12_0=='<') ) {
            alt12=18;
        }
        else if ( (LA12_0=='>') ) {
            alt12=19;
        }
        else if ( (LA12_0=='e') ) {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA12_65 = input.LA(3);

                if ( (LA12_65=='u') ) {
                    int LA12_103 = input.LA(4);

                    if ( (LA12_103=='m') ) {
                        int LA12_129 = input.LA(5);

                        if ( ((LA12_129>='0' && LA12_129<='9')||(LA12_129>='A' && LA12_129<='Z')||LA12_129=='_'||(LA12_129>='a' && LA12_129<='z')) ) {
                            alt12=47;
                        }
                        else {
                            alt12=33;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            case 'x':
                {
                int LA12_66 = input.LA(3);

                if ( (LA12_66=='t') ) {
                    int LA12_104 = input.LA(4);

                    if ( (LA12_104=='e') ) {
                        int LA12_130 = input.LA(5);

                        if ( (LA12_130=='n') ) {
                            int LA12_154 = input.LA(6);

                            if ( (LA12_154=='d') ) {
                                int LA12_173 = input.LA(7);

                                if ( (LA12_173=='s') ) {
                                    int LA12_189 = input.LA(8);

                                    if ( ((LA12_189>='0' && LA12_189<='9')||(LA12_189>='A' && LA12_189<='Z')||LA12_189=='_'||(LA12_189>='a' && LA12_189<='z')) ) {
                                        alt12=47;
                                    }
                                    else {
                                        alt12=20;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            default:
                alt12=47;}

        }
        else if ( (LA12_0=='I') ) {
            int LA12_19 = input.LA(2);

            if ( (LA12_19=='D') ) {
                int LA12_67 = input.LA(3);

                if ( ((LA12_67>='0' && LA12_67<='9')||(LA12_67>='A' && LA12_67<='Z')||LA12_67=='_'||(LA12_67>='a' && LA12_67<='z')) ) {
                    alt12=47;
                }
                else {
                    alt12=21;}
            }
            else {
                alt12=47;}
        }
        else if ( (LA12_0=='v') ) {
            switch ( input.LA(2) ) {
            case 'o':
                {
                switch ( input.LA(3) ) {
                case 'l':
                    {
                    int LA12_106 = input.LA(4);

                    if ( (LA12_106=='a') ) {
                        int LA12_131 = input.LA(5);

                        if ( (LA12_131=='t') ) {
                            int LA12_155 = input.LA(6);

                            if ( (LA12_155=='i') ) {
                                int LA12_174 = input.LA(7);

                                if ( (LA12_174=='l') ) {
                                    int LA12_190 = input.LA(8);

                                    if ( (LA12_190=='e') ) {
                                        int LA12_203 = input.LA(9);

                                        if ( ((LA12_203>='0' && LA12_203<='9')||(LA12_203>='A' && LA12_203<='Z')||LA12_203=='_'||(LA12_203>='a' && LA12_203<='z')) ) {
                                            alt12=47;
                                        }
                                        else {
                                            alt12=22;}
                                    }
                                    else {
                                        alt12=47;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                    }
                    break;
                case 'i':
                    {
                    int LA12_107 = input.LA(4);

                    if ( (LA12_107=='d') ) {
                        int LA12_132 = input.LA(5);

                        if ( ((LA12_132>='0' && LA12_132<='9')||(LA12_132>='A' && LA12_132<='Z')||LA12_132=='_'||(LA12_132>='a' && LA12_132<='z')) ) {
                            alt12=47;
                        }
                        else {
                            alt12=37;}
                    }
                    else {
                        alt12=47;}
                    }
                    break;
                default:
                    alt12=47;}

                }
                break;
            case 'a':
                {
                int LA12_69 = input.LA(3);

                if ( (LA12_69=='l') ) {
                    int LA12_108 = input.LA(4);

                    if ( ((LA12_108>='0' && LA12_108<='9')||(LA12_108>='A' && LA12_108<='Z')||LA12_108=='_'||(LA12_108>='a' && LA12_108<='z')) ) {
                        alt12=47;
                    }
                    else {
                        alt12=30;}
                }
                else {
                    alt12=47;}
                }
                break;
            default:
                alt12=47;}

        }
        else if ( (LA12_0=='t') ) {
            switch ( input.LA(2) ) {
            case 'r':
                {
                int LA12_70 = input.LA(3);

                if ( (LA12_70=='a') ) {
                    int LA12_109 = input.LA(4);

                    if ( (LA12_109=='n') ) {
                        int LA12_134 = input.LA(5);

                        if ( (LA12_134=='s') ) {
                            int LA12_157 = input.LA(6);

                            if ( (LA12_157=='i') ) {
                                int LA12_175 = input.LA(7);

                                if ( (LA12_175=='e') ) {
                                    int LA12_191 = input.LA(8);

                                    if ( (LA12_191=='n') ) {
                                        int LA12_204 = input.LA(9);

                                        if ( (LA12_204=='t') ) {
                                            int LA12_212 = input.LA(10);

                                            if ( ((LA12_212>='0' && LA12_212<='9')||(LA12_212>='A' && LA12_212<='Z')||LA12_212=='_'||(LA12_212>='a' && LA12_212<='z')) ) {
                                                alt12=47;
                                            }
                                            else {
                                                alt12=23;}
                                        }
                                        else {
                                            alt12=47;}
                                    }
                                    else {
                                        alt12=47;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            case 'h':
                {
                int LA12_71 = input.LA(3);

                if ( (LA12_71=='r') ) {
                    int LA12_110 = input.LA(4);

                    if ( (LA12_110=='o') ) {
                        int LA12_135 = input.LA(5);

                        if ( (LA12_135=='w') ) {
                            int LA12_158 = input.LA(6);

                            if ( (LA12_158=='s') ) {
                                int LA12_176 = input.LA(7);

                                if ( ((LA12_176>='0' && LA12_176<='9')||(LA12_176>='A' && LA12_176<='Z')||LA12_176=='_'||(LA12_176>='a' && LA12_176<='z')) ) {
                                    alt12=47;
                                }
                                else {
                                    alt12=38;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            default:
                alt12=47;}

        }
        else if ( (LA12_0=='u') ) {
            int LA12_22 = input.LA(2);

            if ( (LA12_22=='n') ) {
                int LA12_72 = input.LA(3);

                if ( (LA12_72=='s') ) {
                    int LA12_111 = input.LA(4);

                    if ( (LA12_111=='e') ) {
                        int LA12_136 = input.LA(5);

                        if ( (LA12_136=='t') ) {
                            int LA12_159 = input.LA(6);

                            if ( (LA12_159=='t') ) {
                                int LA12_177 = input.LA(7);

                                if ( (LA12_177=='a') ) {
                                    int LA12_193 = input.LA(8);

                                    if ( (LA12_193=='b') ) {
                                        int LA12_205 = input.LA(9);

                                        if ( (LA12_205=='l') ) {
                                            int LA12_213 = input.LA(10);

                                            if ( (LA12_213=='e') ) {
                                                int LA12_217 = input.LA(11);

                                                if ( ((LA12_217>='0' && LA12_217<='9')||(LA12_217>='A' && LA12_217<='Z')||LA12_217=='_'||(LA12_217>='a' && LA12_217<='z')) ) {
                                                    alt12=47;
                                                }
                                                else {
                                                    alt12=24;}
                                            }
                                            else {
                                                alt12=47;}
                                        }
                                        else {
                                            alt12=47;}
                                    }
                                    else {
                                        alt12=47;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
            }
            else {
                alt12=47;}
        }
        else if ( (LA12_0=='[') ) {
            alt12=27;
        }
        else if ( (LA12_0=='.') ) {
            int LA12_24 = input.LA(2);

            if ( (LA12_24=='.') ) {
                alt12=28;
            }
            else {
                alt12=39;}
        }
        else if ( (LA12_0==']') ) {
            alt12=29;
        }
        else if ( (LA12_0=='r') ) {
            switch ( input.LA(2) ) {
            case 'a':
                {
                int LA12_77 = input.LA(3);

                if ( (LA12_77=='n') ) {
                    int LA12_112 = input.LA(4);

                    if ( (LA12_112=='d') ) {
                        int LA12_137 = input.LA(5);

                        if ( (LA12_137=='o') ) {
                            int LA12_160 = input.LA(6);

                            if ( (LA12_160=='m') ) {
                                int LA12_178 = input.LA(7);

                                if ( ((LA12_178>='0' && LA12_178<='9')||(LA12_178>='A' && LA12_178<='Z')||LA12_178=='_'||(LA12_178>='a' && LA12_178<='z')) ) {
                                    alt12=47;
                                }
                                else {
                                    alt12=43;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
                }
                break;
            case 'e':
                {
                switch ( input.LA(3) ) {
                case 'f':
                    {
                    int LA12_113 = input.LA(4);

                    if ( ((LA12_113>='0' && LA12_113<='9')||(LA12_113>='A' && LA12_113<='Z')||LA12_113=='_'||(LA12_113>='a' && LA12_113<='z')) ) {
                        alt12=47;
                    }
                    else {
                        alt12=31;}
                    }
                    break;
                case 'a':
                    {
                    int LA12_114 = input.LA(4);

                    if ( (LA12_114=='d') ) {
                        int LA12_139 = input.LA(5);

                        if ( (LA12_139=='o') ) {
                            int LA12_161 = input.LA(6);

                            if ( (LA12_161=='n') ) {
                                int LA12_179 = input.LA(7);

                                if ( (LA12_179=='l') ) {
                                    int LA12_195 = input.LA(8);

                                    if ( (LA12_195=='y') ) {
                                        int LA12_206 = input.LA(9);

                                        if ( ((LA12_206>='0' && LA12_206<='9')||(LA12_206>='A' && LA12_206<='Z')||LA12_206=='_'||(LA12_206>='a' && LA12_206<='z')) ) {
                                            alt12=47;
                                        }
                                        else {
                                            alt12=44;}
                                    }
                                    else {
                                        alt12=47;}
                                }
                                else {
                                    alt12=47;}
                            }
                            else {
                                alt12=47;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                    }
                    break;
                default:
                    alt12=47;}

                }
                break;
            default:
                alt12=47;}

        }
        else if ( (LA12_0=='#') ) {
            alt12=32;
        }
        else if ( (LA12_0=='?') ) {
            alt12=34;
        }
        else if ( (LA12_0=='s') ) {
            int LA12_29 = input.LA(2);

            if ( (LA12_29=='u') ) {
                int LA12_81 = input.LA(3);

                if ( (LA12_81=='p') ) {
                    int LA12_115 = input.LA(4);

                    if ( (LA12_115=='e') ) {
                        int LA12_140 = input.LA(5);

                        if ( (LA12_140=='r') ) {
                            int LA12_162 = input.LA(6);

                            if ( ((LA12_162>='0' && LA12_162<='9')||(LA12_162>='A' && LA12_162<='Z')||LA12_162=='_'||(LA12_162>='a' && LA12_162<='z')) ) {
                                alt12=47;
                            }
                            else {
                                alt12=35;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
            }
            else {
                alt12=47;}
        }
        else if ( (LA12_0=='o') ) {
            int LA12_30 = input.LA(2);

            if ( (LA12_30=='p') ) {
                int LA12_82 = input.LA(3);

                if ( ((LA12_82>='0' && LA12_82<='9')||(LA12_82>='A' && LA12_82<='Z')||LA12_82=='_'||(LA12_82>='a' && LA12_82<='z')) ) {
                    alt12=47;
                }
                else {
                    alt12=36;}
            }
            else {
                alt12=47;}
        }
        else if ( (LA12_0=='$') ) {
            alt12=40;
        }
        else if ( (LA12_0=='-') ) {
            alt12=41;
        }
        else if ( (LA12_0=='b') ) {
            int LA12_33 = input.LA(2);

            if ( (LA12_33=='a') ) {
                int LA12_85 = input.LA(3);

                if ( (LA12_85=='g') ) {
                    int LA12_117 = input.LA(4);

                    if ( ((LA12_117>='0' && LA12_117<='9')||(LA12_117>='A' && LA12_117<='Z')||LA12_117=='_'||(LA12_117>='a' && LA12_117<='z')) ) {
                        alt12=47;
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=47;}
            }
            else {
                alt12=47;}
        }
        else if ( (LA12_0=='l') ) {
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
                                alt12=47;
                            }
                            else {
                                alt12=45;}
                        }
                        else {
                            alt12=47;}
                    }
                    else {
                        alt12=47;}
                }
                else {
                    alt12=47;}
            }
            else {
                alt12=47;}
        }
        else if ( (LA12_0=='!') ) {
            int LA12_35 = input.LA(2);

            if ( (LA12_35=='s') ) {
                alt12=46;
            }
            else {
                alt12=53;}
        }
        else if ( (LA12_0=='^') ) {
            int LA12_36 = input.LA(2);

            if ( ((LA12_36>='A' && LA12_36<='Z')||LA12_36=='_'||(LA12_36>='a' && LA12_36<='z')) ) {
                alt12=47;
            }
            else {
                alt12=53;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='f' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||LA12_0=='m'||LA12_0=='q'||(LA12_0>='w' && LA12_0<='z')) ) {
            alt12=47;
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=48;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_39 = input.LA(2);

            if ( ((LA12_39>='\u0000' && LA12_39<='\uFFFE')) ) {
                alt12=49;
            }
            else {
                alt12=53;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_40 = input.LA(2);

            if ( ((LA12_40>='\u0000' && LA12_40<='\uFFFE')) ) {
                alt12=49;
            }
            else {
                alt12=53;}
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=51;
                }
                break;
            case '*':
                {
                alt12=50;
                }
                break;
            default:
                alt12=53;}

        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=52;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='%' && LA12_0<='&')||(LA12_0>='*' && LA12_0<='+')||LA12_0=='\\'||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12=53;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | RULE_BAG | RULE_RANDOM | RULE_READONLY | RULE_LOCAL | RULE_SERIALIZABLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:10: T16
                {
                mT16(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:14: T17
                {
                mT17(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:18: T18
                {
                mT18(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:22: T19
                {
                mT19(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:26: T20
                {
                mT20(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:30: T21
                {
                mT21(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:34: T22
                {
                mT22(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:38: T23
                {
                mT23(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:42: T24
                {
                mT24(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:46: T25
                {
                mT25(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:50: T26
                {
                mT26(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:54: T27
                {
                mT27(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:58: T28
                {
                mT28(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:62: T29
                {
                mT29(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:66: T30
                {
                mT30(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:70: T31
                {
                mT31(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:74: T32
                {
                mT32(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:78: T33
                {
                mT33(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:82: T34
                {
                mT34(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:86: T35
                {
                mT35(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:90: T36
                {
                mT36(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:94: T37
                {
                mT37(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:98: T38
                {
                mT38(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:102: T39
                {
                mT39(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:106: T40
                {
                mT40(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:110: T41
                {
                mT41(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:114: T42
                {
                mT42(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:118: T43
                {
                mT43(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:122: T44
                {
                mT44(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:126: T45
                {
                mT45(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:130: T46
                {
                mT46(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:134: T47
                {
                mT47(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:138: T48
                {
                mT48(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:142: T49
                {
                mT49(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:146: T50
                {
                mT50(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:150: T51
                {
                mT51(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:154: T52
                {
                mT52(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:158: T53
                {
                mT53(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:162: T54
                {
                mT54(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:166: T55
                {
                mT55(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:170: T56
                {
                mT56(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:174: RULE_BAG
                {
                mRULE_BAG(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:183: RULE_RANDOM
                {
                mRULE_RANDOM(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:195: RULE_READONLY
                {
                mRULE_READONLY(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:209: RULE_LOCAL
                {
                mRULE_LOCAL(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:220: RULE_SERIALIZABLE
                {
                mRULE_SERIALIZABLE(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:238: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:246: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:255: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:267: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:283: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:299: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:307: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}