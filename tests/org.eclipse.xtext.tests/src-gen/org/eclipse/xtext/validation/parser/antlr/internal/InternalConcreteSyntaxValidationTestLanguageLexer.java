package org.eclipse.xtext.validation.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalConcreteSyntaxValidationTestLanguageLexer extends Lexer {
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
    public static final int T13=13;
    public static final int RULE_WS=9;
    public static final int T48=48;
    public static final int T15=15;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int Tokens=54;
    public static final int T53=53;
    public static final int RULE_ANY_OTHER=10;
    public static final int T31=31;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T30=30;
    public InternalConcreteSyntaxValidationTestLanguageLexer() {;} 
    public InternalConcreteSyntaxValidationTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:10:5: ( '#1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:10:7: '#1'
            {
            match("#1"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:11:5: ( '#2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:11:7: '#2'
            {
            match("#2"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:12:5: ( 'kw1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:12:7: 'kw1'
            {
            match("kw1"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:13:5: ( 'kw2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:13:7: 'kw2'
            {
            match("kw2"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:14:5: ( '#3' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:14:7: '#3'
            {
            match("#3"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:15:5: ( 'kw3' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:15:7: 'kw3'
            {
            match("kw3"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:16:5: ( '#4' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:16:7: '#4'
            {
            match("#4"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:17:5: ( '#5' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:17:7: '#5'
            {
            match("#5"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:18:5: ( 'kw4' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:18:7: 'kw4'
            {
            match("kw4"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:19:5: ( 'kw5' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:19:7: 'kw5'
            {
            match("kw5"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:20:5: ( '#6' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:20:7: '#6'
            {
            match("#6"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:21:5: ( '#7' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:21:7: '#7'
            {
            match("#7"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:22:5: ( '#8' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:22:7: '#8'
            {
            match("#8"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:23:5: ( '#9' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:23:7: '#9'
            {
            match("#9"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:24:5: ( '#10' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:24:7: '#10'
            {
            match("#10"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:25:5: ( '#11' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:25:7: '#11'
            {
            match("#11"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:26:5: ( '#12' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:26:7: '#12'
            {
            match("#12"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:27:5: ( '#13' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:27:7: '#13'
            {
            match("#13"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:28:5: ( '#14' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:28:7: '#14'
            {
            match("#14"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:29:5: ( '#15' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:29:7: '#15'
            {
            match("#15"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:30:5: ( '#16' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:30:7: '#16'
            {
            match("#16"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:31:5: ( 'group' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:31:7: 'group'
            {
            match("group"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:32:5: ( '#17' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:32:7: '#17'
            {
            match("#17"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:33:5: ( ',' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:33:7: ','
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:34:5: ( '#18' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:34:7: '#18'
            {
            match("#18"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:35:5: ( '#19' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:35:7: '#19'
            {
            match("#19"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:36:5: ( '#20' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:36:7: '#20'
            {
            match("#20"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:37:5: ( '#21' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:37:7: '#21'
            {
            match("#21"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:38:5: ( '#22' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:38:7: '#22'
            {
            match("#22"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:39:5: ( '#23' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:39:7: '#23'
            {
            match("#23"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:40:5: ( 'kw' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:40:7: 'kw'
            {
            match("kw"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:41:5: ( '#24' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:41:7: '#24'
            {
            match("#24"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:42:5: ( '#25' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:42:7: '#25'
            {
            match("#25"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:43:5: ( '#26' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:43:7: '#26'
            {
            match("#26"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:44:5: ( '#27' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:44:7: '#27'
            {
            match("#27"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:45:5: ( 'short' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:45:7: 'short'
            {
            match("short"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:46:5: ( 'one' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:46:7: 'one'
            {
            match("one"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:47:5: ( 'long' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:47:7: 'long'
            {
            match("long"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:48:5: ( 'extra' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:48:7: 'extra'
            {
            match("extra"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:49:5: ( 'two' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:49:7: 'two'
            {
            match("two"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:50:5: ( '#28' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:50:7: '#28'
            {
            match("#28"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:51:5: ( 'lit1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:51:7: 'lit1'
            {
            match("lit1"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:52:5: ( 'lit2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:52:7: 'lit2'
            {
            match("lit2"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4476:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4476:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4476:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4476:11: '^'
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4476:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4478:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4478:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4478:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4478:13: '0' .. '9'
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("4480:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4480:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4482:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4482:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4482:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4482:52: .
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4484:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4484:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4484:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4484:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4484:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4484:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4484:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4484:41: '\\r'
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4486:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4486:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4486:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4488:16: ( . )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4488:18: .
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
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=50;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='#') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0=='k') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='g') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0==',') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='s') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='o') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0=='l') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0=='e') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0=='t') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper010();
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='d')||LA12_0=='f'||(LA12_0>='h' && LA12_0<='j')||(LA12_0>='m' && LA12_0<='n')||(LA12_0>='p' && LA12_0<='r')||(LA12_0>='u' && LA12_0<='z')) ) {
            alt12 = mTokensHelper011();
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper015();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper016();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='$' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='+')||(LA12_0>='-' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper017();
        }
        else {
            alt12 = mTokensHelper018();
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:122: T39
                {
                mT39(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:126: T40
                {
                mT40(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:130: T41
                {
                mT41(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:134: T42
                {
                mT42(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:138: T43
                {
                mT43(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:142: T44
                {
                mT44(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:146: T45
                {
                mT45(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:150: T46
                {
                mT46(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:154: T47
                {
                mT47(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:158: T48
                {
                mT48(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:162: T49
                {
                mT49(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:166: T50
                {
                mT50(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:170: T51
                {
                mT51(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:174: T52
                {
                mT52(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:178: T53
                {
                mT53(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:182: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:190: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:199: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:211: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:227: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:243: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1:251: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '2':
            {
            switch ( input.LA(3) ) {
            case '1':
                {
                return 28;
                }
            case '7':
                {
                return 35;
                }
            case '0':
                {
                return 27;
                }
            case '8':
                {
                return 41;
                }
            case '2':
                {
                return 29;
                }
            case '5':
                {
                return 33;
                }
            case '6':
                {
                return 34;
                }
            case '4':
                {
                return 32;
                }
            case '3':
                {
                return 30;
                }
            default:
                return 2;}

            }
        case '1':
            {
            switch ( input.LA(3) ) {
            case '5':
                {
                return 20;
                }
            case '4':
                {
                return 19;
                }
            case '7':
                {
                return 23;
                }
            case '1':
                {
                return 16;
                }
            case '0':
                {
                return 15;
                }
            case '8':
                {
                return 25;
                }
            case '2':
                {
                return 17;
                }
            case '6':
                {
                return 21;
                }
            case '9':
                {
                return 26;
                }
            case '3':
                {
                return 18;
                }
            default:
                return 1;}

            }
        case '7':
            {
            return 12;
            }
        case '8':
            {
            return 13;
            }
        case '4':
            {
            return 7;
            }
        case '5':
            {
            return 8;
            }
        case '3':
            {
            return 5;
            }
        case '6':
            {
            return 11;
            }
        case '9':
            {
            return 14;
            }
        default:
            return 50;}

    }

    private int mTokensHelper002() throws RecognitionException {
        int LA12_2 = input.LA(2);

        if ( (LA12_2=='w') ) {
            switch ( input.LA(3) ) {
            case '5':
                {
                int LA12_63 = input.LA(4);

                if ( ((LA12_63>='0' && LA12_63<='9')||(LA12_63>='A' && LA12_63<='Z')||LA12_63=='_'||(LA12_63>='a' && LA12_63<='z')) ) {
                    return 44;
                }
                else {
                    return 10;}
                }
            case '1':
                {
                int LA12_64 = input.LA(4);

                if ( ((LA12_64>='0' && LA12_64<='9')||(LA12_64>='A' && LA12_64<='Z')||LA12_64=='_'||(LA12_64>='a' && LA12_64<='z')) ) {
                    return 44;
                }
                else {
                    return 3;}
                }
            case '4':
                {
                int LA12_65 = input.LA(4);

                if ( ((LA12_65>='0' && LA12_65<='9')||(LA12_65>='A' && LA12_65<='Z')||LA12_65=='_'||(LA12_65>='a' && LA12_65<='z')) ) {
                    return 44;
                }
                else {
                    return 9;}
                }
            case '3':
                {
                int LA12_66 = input.LA(4);

                if ( ((LA12_66>='0' && LA12_66<='9')||(LA12_66>='A' && LA12_66<='Z')||LA12_66=='_'||(LA12_66>='a' && LA12_66<='z')) ) {
                    return 44;
                }
                else {
                    return 6;}
                }
            case '2':
                {
                int LA12_67 = input.LA(4);

                if ( ((LA12_67>='0' && LA12_67<='9')||(LA12_67>='A' && LA12_67<='Z')||LA12_67=='_'||(LA12_67>='a' && LA12_67<='z')) ) {
                    return 44;
                }
                else {
                    return 4;}
                }
            case '0':
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
                return 44;
                }
            default:
                return 31;}

        }
        else {
            return 44;}
    }

    private int mTokensHelper003() throws RecognitionException {
        int LA12_3 = input.LA(2);

        if ( (LA12_3=='r') ) {
            int LA12_29 = input.LA(3);

            if ( (LA12_29=='o') ) {
                int LA12_69 = input.LA(4);

                if ( (LA12_69=='u') ) {
                    int LA12_81 = input.LA(5);

                    if ( (LA12_81=='p') ) {
                        int LA12_89 = input.LA(6);

                        if ( ((LA12_89>='0' && LA12_89<='9')||(LA12_89>='A' && LA12_89<='Z')||LA12_89=='_'||(LA12_89>='a' && LA12_89<='z')) ) {
                            return 44;
                        }
                        else {
                            return 22;}
                    }
                    else {
                        return 44;}
                }
                else {
                    return 44;}
            }
            else {
                return 44;}
        }
        else {
            return 44;}
    }

    private int mTokensHelper004() throws RecognitionException {
        return 24;
    }

    private int mTokensHelper005() throws RecognitionException {
        int LA12_5 = input.LA(2);

        if ( (LA12_5=='h') ) {
            int LA12_31 = input.LA(3);

            if ( (LA12_31=='o') ) {
                int LA12_70 = input.LA(4);

                if ( (LA12_70=='r') ) {
                    int LA12_82 = input.LA(5);

                    if ( (LA12_82=='t') ) {
                        int LA12_90 = input.LA(6);

                        if ( ((LA12_90>='0' && LA12_90<='9')||(LA12_90>='A' && LA12_90<='Z')||LA12_90=='_'||(LA12_90>='a' && LA12_90<='z')) ) {
                            return 44;
                        }
                        else {
                            return 36;}
                    }
                    else {
                        return 44;}
                }
                else {
                    return 44;}
            }
            else {
                return 44;}
        }
        else {
            return 44;}
    }

    private int mTokensHelper006() throws RecognitionException {
        int LA12_6 = input.LA(2);

        if ( (LA12_6=='n') ) {
            int LA12_32 = input.LA(3);

            if ( (LA12_32=='e') ) {
                int LA12_71 = input.LA(4);

                if ( ((LA12_71>='0' && LA12_71<='9')||(LA12_71>='A' && LA12_71<='Z')||LA12_71=='_'||(LA12_71>='a' && LA12_71<='z')) ) {
                    return 44;
                }
                else {
                    return 37;}
            }
            else {
                return 44;}
        }
        else {
            return 44;}
    }

    private int mTokensHelper007() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'i':
            {
            int LA12_33 = input.LA(3);

            if ( (LA12_33=='t') ) {
                switch ( input.LA(4) ) {
                case '1':
                    {
                    int LA12_84 = input.LA(5);

                    if ( ((LA12_84>='0' && LA12_84<='9')||(LA12_84>='A' && LA12_84<='Z')||LA12_84=='_'||(LA12_84>='a' && LA12_84<='z')) ) {
                        return 44;
                    }
                    else {
                        return 42;}
                    }
                case '2':
                    {
                    int LA12_85 = input.LA(5);

                    if ( ((LA12_85>='0' && LA12_85<='9')||(LA12_85>='A' && LA12_85<='Z')||LA12_85=='_'||(LA12_85>='a' && LA12_85<='z')) ) {
                        return 44;
                    }
                    else {
                        return 43;}
                    }
                default:
                    return 44;}

            }
            else {
                return 44;}
            }
        case 'o':
            {
            int LA12_34 = input.LA(3);

            if ( (LA12_34=='n') ) {
                int LA12_73 = input.LA(4);

                if ( (LA12_73=='g') ) {
                    int LA12_86 = input.LA(5);

                    if ( ((LA12_86>='0' && LA12_86<='9')||(LA12_86>='A' && LA12_86<='Z')||LA12_86=='_'||(LA12_86>='a' && LA12_86<='z')) ) {
                        return 44;
                    }
                    else {
                        return 38;}
                }
                else {
                    return 44;}
            }
            else {
                return 44;}
            }
        default:
            return 44;}

    }

    private int mTokensHelper008() throws RecognitionException {
        int LA12_8 = input.LA(2);

        if ( (LA12_8=='x') ) {
            int LA12_35 = input.LA(3);

            if ( (LA12_35=='t') ) {
                int LA12_74 = input.LA(4);

                if ( (LA12_74=='r') ) {
                    int LA12_87 = input.LA(5);

                    if ( (LA12_87=='a') ) {
                        int LA12_94 = input.LA(6);

                        if ( ((LA12_94>='0' && LA12_94<='9')||(LA12_94>='A' && LA12_94<='Z')||LA12_94=='_'||(LA12_94>='a' && LA12_94<='z')) ) {
                            return 44;
                        }
                        else {
                            return 39;}
                    }
                    else {
                        return 44;}
                }
                else {
                    return 44;}
            }
            else {
                return 44;}
        }
        else {
            return 44;}
    }

    private int mTokensHelper009() throws RecognitionException {
        int LA12_9 = input.LA(2);

        if ( (LA12_9=='w') ) {
            int LA12_36 = input.LA(3);

            if ( (LA12_36=='o') ) {
                int LA12_75 = input.LA(4);

                if ( ((LA12_75>='0' && LA12_75<='9')||(LA12_75>='A' && LA12_75<='Z')||LA12_75=='_'||(LA12_75>='a' && LA12_75<='z')) ) {
                    return 44;
                }
                else {
                    return 40;}
            }
            else {
                return 44;}
        }
        else {
            return 44;}
    }

    private int mTokensHelper010() throws RecognitionException {
        int LA12_10 = input.LA(2);

        if ( ((LA12_10>='A' && LA12_10<='Z')||LA12_10=='_'||(LA12_10>='a' && LA12_10<='z')) ) {
            return 44;
        }
        else {
            return 50;}
    }

    private int mTokensHelper011() throws RecognitionException {
        return 44;
    }

    private int mTokensHelper012() throws RecognitionException {
        return 45;
    }

    private int mTokensHelper013() throws RecognitionException {
        int LA12_13 = input.LA(2);

        if ( ((LA12_13>='\u0000' && LA12_13<='\uFFFE')) ) {
            return 46;
        }
        else {
            return 50;}
    }

    private int mTokensHelper014() throws RecognitionException {
        int LA12_14 = input.LA(2);

        if ( ((LA12_14>='\u0000' && LA12_14<='\uFFFE')) ) {
            return 46;
        }
        else {
            return 50;}
    }

    private int mTokensHelper015() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '*':
            {
            return 47;
            }
        case '/':
            {
            return 48;
            }
        default:
            return 50;}

    }

    private int mTokensHelper016() throws RecognitionException {
        return 49;
    }

    private int mTokensHelper017() throws RecognitionException {
        return 50;
    }

    private int mTokensHelper018() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}