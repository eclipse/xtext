package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug304681TestLanguageLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=7;
    public static final int T14=14;
    public static final int T29=29;
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T11=11;
    public static final int T36=36;
    public static final int RULE_STRING=5;
    public static final int T12=12;
    public static final int T28=28;
    public static final int T23=23;
    public static final int T35=35;
    public static final int T13=13;
    public static final int T34=34;
    public static final int T20=20;
    public static final int T25=25;
    public static final int T18=18;
    public static final int RULE_WS=9;
    public static final int T26=26;
    public static final int T15=15;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T32=32;
    public static final int T17=17;
    public static final int Tokens=37;
    public static final int T31=31;
    public static final int RULE_ANY_OTHER=10;
    public static final int T16=16;
    public static final int T27=27;
    public static final int RULE_SL_COMMENT=8;
    public static final int T30=30;
    public static final int T24=24;
    public static final int T19=19;
    public InternalBug304681TestLanguageLexer() {;} 
    public InternalBug304681TestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:10:5: ( '1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:10:7: '1'
            {
            match('1'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:11:5: ( '2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:11:7: '2'
            {
            match('2'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:12:5: ( 'package' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:12:7: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:13:5: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:13:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:14:5: ( 'enabled' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:14:7: 'enabled'
            {
            match("enabled"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:15:5: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:15:7: 'abstract'
            {
            match("abstract"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:16:5: ( 'object' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:16:7: 'object'
            {
            match("object"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:17:5: ( 'extends' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:17:7: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:18:5: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:18:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:19:5: ( 'shortDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:19:7: 'shortDescription'
            {
            match("shortDescription"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:20:5: ( 'longDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:20:7: 'longDescription'
            {
            match("longDescription"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:21:5: ( 'serialUID' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:21:7: 'serialUID'
            {
            match("serialUID"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:22:5: ( 'cloneable' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:22:7: 'cloneable'
            {
            match("cloneable"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:23:5: ( 'before' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:23:7: 'before'
            {
            match("before"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:24:5: ( 'after' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:24:7: 'after'
            {
            match("after"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:25:5: ( 'optionalLoop' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:25:7: 'optionalLoop'
            {
            match("optionalLoop"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:26:5: ( 'mandatoryLoop' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:26:7: 'mandatoryLoop'
            {
            match("mandatoryLoop"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:27:5: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:27:7: '}'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:28:5: ( 'Attribute' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:28:7: 'Attribute'
            {
            match("Attribute"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:29:5: ( 'Reference' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:29:7: 'Reference'
            {
            match("Reference"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:30:5: ( '*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:30:7: '*'
            {
            match('*'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:31:5: ( 'required' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:31:7: 'required'
            {
            match("required"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:32:5: ( 'technical' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:32:7: 'technical'
            {
            match("technical"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:33:5: ( 'constraint' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:33:7: 'constraint'
            {
            match("constraint"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:34:5: ( 'parameters' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:34:7: 'parameters'
            {
            match("parameters"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:35:5: ( 'message' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:35:7: 'message'
            {
            match("message"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2177:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2177:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2177:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2177:11: '^'
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2177:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2179:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2179:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2179:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2179:13: '0' .. '9'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("2181:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2181:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2183:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2183:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2183:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2183:52: .
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2185:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2185:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2185:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2185:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2185:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2185:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2185:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2185:41: '\\r'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2187:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2187:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2187:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2189:16: ( . )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2189:18: .
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
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=33;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='1') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0=='2') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='p') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0==';') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='e') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='a') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0=='o') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0=='{') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0=='s') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='l') ) {
            alt12 = mTokensHelper010();
        }
        else if ( (LA12_0=='c') ) {
            alt12 = mTokensHelper011();
        }
        else if ( (LA12_0=='b') ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0=='m') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0=='}') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='A') ) {
            alt12 = mTokensHelper015();
        }
        else if ( (LA12_0=='R') ) {
            alt12 = mTokensHelper016();
        }
        else if ( (LA12_0=='*') ) {
            alt12 = mTokensHelper017();
        }
        else if ( (LA12_0=='r') ) {
            alt12 = mTokensHelper018();
        }
        else if ( (LA12_0=='t') ) {
            alt12 = mTokensHelper019();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper020();
        }
        else if ( ((LA12_0>='B' && LA12_0<='Q')||(LA12_0>='S' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='d'||(LA12_0>='f' && LA12_0<='k')||LA12_0=='n'||LA12_0=='q'||(LA12_0>='u' && LA12_0<='z')) ) {
            alt12 = mTokensHelper021();
        }
        else if ( (LA12_0=='0'||(LA12_0>='3' && LA12_0<='9')) ) {
            alt12 = mTokensHelper022();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper023();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper024();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper025();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper026();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='.')||LA12_0==':'||(LA12_0>='<' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper027();
        }
        else {
            alt12 = mTokensHelper028();
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:114: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:122: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:131: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:143: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:159: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:175: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1:183: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        int LA12_1 = input.LA(2);

        if ( ((LA12_1>='0' && LA12_1<='9')) ) {
            return 28;
        }
        else {
            return 1;}
    }

    private int mTokensHelper002() throws RecognitionException {
        int LA12_2 = input.LA(2);

        if ( ((LA12_2>='0' && LA12_2<='9')) ) {
            return 28;
        }
        else {
            return 2;}
    }

    private int mTokensHelper003() throws RecognitionException {
        int LA12_3 = input.LA(2);

        if ( (LA12_3=='a') ) {
            switch ( input.LA(3) ) {
            case 'r':
                {
                int LA12_59 = input.LA(4);

                if ( (LA12_59=='a') ) {
                    int LA12_79 = input.LA(5);

                    if ( (LA12_79=='m') ) {
                        int LA12_99 = input.LA(6);

                        if ( (LA12_99=='e') ) {
                            int LA12_119 = input.LA(7);

                            if ( (LA12_119=='t') ) {
                                int LA12_139 = input.LA(8);

                                if ( (LA12_139=='e') ) {
                                    int LA12_158 = input.LA(9);

                                    if ( (LA12_158=='r') ) {
                                        int LA12_175 = input.LA(10);

                                        if ( (LA12_175=='s') ) {
                                            int LA12_188 = input.LA(11);

                                            if ( ((LA12_188>='0' && LA12_188<='9')||(LA12_188>='A' && LA12_188<='Z')||LA12_188=='_'||(LA12_188>='a' && LA12_188<='z')) ) {
                                                return 27;
                                            }
                                            else {
                                                return 25;}
                                        }
                                        else {
                                            return 27;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
                }
            case 'c':
                {
                int LA12_60 = input.LA(4);

                if ( (LA12_60=='k') ) {
                    int LA12_80 = input.LA(5);

                    if ( (LA12_80=='a') ) {
                        int LA12_100 = input.LA(6);

                        if ( (LA12_100=='g') ) {
                            int LA12_120 = input.LA(7);

                            if ( (LA12_120=='e') ) {
                                int LA12_140 = input.LA(8);

                                if ( ((LA12_140>='0' && LA12_140<='9')||(LA12_140>='A' && LA12_140<='Z')||LA12_140=='_'||(LA12_140>='a' && LA12_140<='z')) ) {
                                    return 27;
                                }
                                else {
                                    return 3;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
                }
            default:
                return 27;}

        }
        else {
            return 27;}
    }

    private int mTokensHelper004() throws RecognitionException {
        return 4;
    }

    private int mTokensHelper005() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'n':
            {
            int LA12_34 = input.LA(3);

            if ( (LA12_34=='a') ) {
                int LA12_61 = input.LA(4);

                if ( (LA12_61=='b') ) {
                    int LA12_81 = input.LA(5);

                    if ( (LA12_81=='l') ) {
                        int LA12_101 = input.LA(6);

                        if ( (LA12_101=='e') ) {
                            int LA12_121 = input.LA(7);

                            if ( (LA12_121=='d') ) {
                                int LA12_141 = input.LA(8);

                                if ( ((LA12_141>='0' && LA12_141<='9')||(LA12_141>='A' && LA12_141<='Z')||LA12_141=='_'||(LA12_141>='a' && LA12_141<='z')) ) {
                                    return 27;
                                }
                                else {
                                    return 5;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        case 'x':
            {
            int LA12_35 = input.LA(3);

            if ( (LA12_35=='t') ) {
                int LA12_62 = input.LA(4);

                if ( (LA12_62=='e') ) {
                    int LA12_82 = input.LA(5);

                    if ( (LA12_82=='n') ) {
                        int LA12_102 = input.LA(6);

                        if ( (LA12_102=='d') ) {
                            int LA12_122 = input.LA(7);

                            if ( (LA12_122=='s') ) {
                                int LA12_142 = input.LA(8);

                                if ( ((LA12_142>='0' && LA12_142<='9')||(LA12_142>='A' && LA12_142<='Z')||LA12_142=='_'||(LA12_142>='a' && LA12_142<='z')) ) {
                                    return 27;
                                }
                                else {
                                    return 8;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        default:
            return 27;}

    }

    private int mTokensHelper006() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'f':
            {
            int LA12_36 = input.LA(3);

            if ( (LA12_36=='t') ) {
                int LA12_63 = input.LA(4);

                if ( (LA12_63=='e') ) {
                    int LA12_83 = input.LA(5);

                    if ( (LA12_83=='r') ) {
                        int LA12_103 = input.LA(6);

                        if ( ((LA12_103>='0' && LA12_103<='9')||(LA12_103>='A' && LA12_103<='Z')||LA12_103=='_'||(LA12_103>='a' && LA12_103<='z')) ) {
                            return 27;
                        }
                        else {
                            return 15;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        case 'b':
            {
            int LA12_37 = input.LA(3);

            if ( (LA12_37=='s') ) {
                int LA12_64 = input.LA(4);

                if ( (LA12_64=='t') ) {
                    int LA12_84 = input.LA(5);

                    if ( (LA12_84=='r') ) {
                        int LA12_104 = input.LA(6);

                        if ( (LA12_104=='a') ) {
                            int LA12_124 = input.LA(7);

                            if ( (LA12_124=='c') ) {
                                int LA12_143 = input.LA(8);

                                if ( (LA12_143=='t') ) {
                                    int LA12_162 = input.LA(9);

                                    if ( ((LA12_162>='0' && LA12_162<='9')||(LA12_162>='A' && LA12_162<='Z')||LA12_162=='_'||(LA12_162>='a' && LA12_162<='z')) ) {
                                        return 27;
                                    }
                                    else {
                                        return 6;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        default:
            return 27;}

    }

    private int mTokensHelper007() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'b':
            {
            int LA12_38 = input.LA(3);

            if ( (LA12_38=='j') ) {
                int LA12_65 = input.LA(4);

                if ( (LA12_65=='e') ) {
                    int LA12_85 = input.LA(5);

                    if ( (LA12_85=='c') ) {
                        int LA12_105 = input.LA(6);

                        if ( (LA12_105=='t') ) {
                            int LA12_125 = input.LA(7);

                            if ( ((LA12_125>='0' && LA12_125<='9')||(LA12_125>='A' && LA12_125<='Z')||LA12_125=='_'||(LA12_125>='a' && LA12_125<='z')) ) {
                                return 27;
                            }
                            else {
                                return 7;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        case 'p':
            {
            int LA12_39 = input.LA(3);

            if ( (LA12_39=='t') ) {
                int LA12_66 = input.LA(4);

                if ( (LA12_66=='i') ) {
                    int LA12_86 = input.LA(5);

                    if ( (LA12_86=='o') ) {
                        int LA12_106 = input.LA(6);

                        if ( (LA12_106=='n') ) {
                            int LA12_126 = input.LA(7);

                            if ( (LA12_126=='a') ) {
                                int LA12_145 = input.LA(8);

                                if ( (LA12_145=='l') ) {
                                    int LA12_163 = input.LA(9);

                                    if ( (LA12_163=='L') ) {
                                        int LA12_177 = input.LA(10);

                                        if ( (LA12_177=='o') ) {
                                            int LA12_189 = input.LA(11);

                                            if ( (LA12_189=='o') ) {
                                                int LA12_200 = input.LA(12);

                                                if ( (LA12_200=='p') ) {
                                                    int LA12_205 = input.LA(13);

                                                    if ( ((LA12_205>='0' && LA12_205<='9')||(LA12_205>='A' && LA12_205<='Z')||LA12_205=='_'||(LA12_205>='a' && LA12_205<='z')) ) {
                                                        return 27;
                                                    }
                                                    else {
                                                        return 16;}
                                                }
                                                else {
                                                    return 27;}
                                            }
                                            else {
                                                return 27;}
                                        }
                                        else {
                                            return 27;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        default:
            return 27;}

    }

    private int mTokensHelper008() throws RecognitionException {
        return 9;
    }

    private int mTokensHelper009() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'h':
            {
            int LA12_41 = input.LA(3);

            if ( (LA12_41=='o') ) {
                int LA12_67 = input.LA(4);

                if ( (LA12_67=='r') ) {
                    int LA12_87 = input.LA(5);

                    if ( (LA12_87=='t') ) {
                        int LA12_107 = input.LA(6);

                        if ( (LA12_107=='D') ) {
                            int LA12_127 = input.LA(7);

                            if ( (LA12_127=='e') ) {
                                int LA12_146 = input.LA(8);

                                if ( (LA12_146=='s') ) {
                                    int LA12_164 = input.LA(9);

                                    if ( (LA12_164=='c') ) {
                                        int LA12_178 = input.LA(10);

                                        if ( (LA12_178=='r') ) {
                                            int LA12_190 = input.LA(11);

                                            if ( (LA12_190=='i') ) {
                                                int LA12_201 = input.LA(12);

                                                if ( (LA12_201=='p') ) {
                                                    int LA12_206 = input.LA(13);

                                                    if ( (LA12_206=='t') ) {
                                                        int LA12_210 = input.LA(14);

                                                        if ( (LA12_210=='i') ) {
                                                            int LA12_213 = input.LA(15);

                                                            if ( (LA12_213=='o') ) {
                                                                int LA12_216 = input.LA(16);

                                                                if ( (LA12_216=='n') ) {
                                                                    int LA12_218 = input.LA(17);

                                                                    if ( ((LA12_218>='0' && LA12_218<='9')||(LA12_218>='A' && LA12_218<='Z')||LA12_218=='_'||(LA12_218>='a' && LA12_218<='z')) ) {
                                                                        return 27;
                                                                    }
                                                                    else {
                                                                        return 10;}
                                                                }
                                                                else {
                                                                    return 27;}
                                                            }
                                                            else {
                                                                return 27;}
                                                        }
                                                        else {
                                                            return 27;}
                                                    }
                                                    else {
                                                        return 27;}
                                                }
                                                else {
                                                    return 27;}
                                            }
                                            else {
                                                return 27;}
                                        }
                                        else {
                                            return 27;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        case 'e':
            {
            int LA12_42 = input.LA(3);

            if ( (LA12_42=='r') ) {
                int LA12_68 = input.LA(4);

                if ( (LA12_68=='i') ) {
                    int LA12_88 = input.LA(5);

                    if ( (LA12_88=='a') ) {
                        int LA12_108 = input.LA(6);

                        if ( (LA12_108=='l') ) {
                            int LA12_128 = input.LA(7);

                            if ( (LA12_128=='U') ) {
                                int LA12_147 = input.LA(8);

                                if ( (LA12_147=='I') ) {
                                    int LA12_165 = input.LA(9);

                                    if ( (LA12_165=='D') ) {
                                        int LA12_179 = input.LA(10);

                                        if ( ((LA12_179>='0' && LA12_179<='9')||(LA12_179>='A' && LA12_179<='Z')||LA12_179=='_'||(LA12_179>='a' && LA12_179<='z')) ) {
                                            return 27;
                                        }
                                        else {
                                            return 12;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        default:
            return 27;}

    }

    private int mTokensHelper010() throws RecognitionException {
        int LA12_10 = input.LA(2);

        if ( (LA12_10=='o') ) {
            int LA12_43 = input.LA(3);

            if ( (LA12_43=='n') ) {
                int LA12_69 = input.LA(4);

                if ( (LA12_69=='g') ) {
                    int LA12_89 = input.LA(5);

                    if ( (LA12_89=='D') ) {
                        int LA12_109 = input.LA(6);

                        if ( (LA12_109=='e') ) {
                            int LA12_129 = input.LA(7);

                            if ( (LA12_129=='s') ) {
                                int LA12_148 = input.LA(8);

                                if ( (LA12_148=='c') ) {
                                    int LA12_166 = input.LA(9);

                                    if ( (LA12_166=='r') ) {
                                        int LA12_180 = input.LA(10);

                                        if ( (LA12_180=='i') ) {
                                            int LA12_192 = input.LA(11);

                                            if ( (LA12_192=='p') ) {
                                                int LA12_202 = input.LA(12);

                                                if ( (LA12_202=='t') ) {
                                                    int LA12_207 = input.LA(13);

                                                    if ( (LA12_207=='i') ) {
                                                        int LA12_211 = input.LA(14);

                                                        if ( (LA12_211=='o') ) {
                                                            int LA12_214 = input.LA(15);

                                                            if ( (LA12_214=='n') ) {
                                                                int LA12_217 = input.LA(16);

                                                                if ( ((LA12_217>='0' && LA12_217<='9')||(LA12_217>='A' && LA12_217<='Z')||LA12_217=='_'||(LA12_217>='a' && LA12_217<='z')) ) {
                                                                    return 27;
                                                                }
                                                                else {
                                                                    return 11;}
                                                            }
                                                            else {
                                                                return 27;}
                                                        }
                                                        else {
                                                            return 27;}
                                                    }
                                                    else {
                                                        return 27;}
                                                }
                                                else {
                                                    return 27;}
                                            }
                                            else {
                                                return 27;}
                                        }
                                        else {
                                            return 27;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
        }
        else {
            return 27;}
    }

    private int mTokensHelper011() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'l':
            {
            int LA12_44 = input.LA(3);

            if ( (LA12_44=='o') ) {
                int LA12_70 = input.LA(4);

                if ( (LA12_70=='n') ) {
                    int LA12_90 = input.LA(5);

                    if ( (LA12_90=='e') ) {
                        int LA12_110 = input.LA(6);

                        if ( (LA12_110=='a') ) {
                            int LA12_130 = input.LA(7);

                            if ( (LA12_130=='b') ) {
                                int LA12_149 = input.LA(8);

                                if ( (LA12_149=='l') ) {
                                    int LA12_167 = input.LA(9);

                                    if ( (LA12_167=='e') ) {
                                        int LA12_181 = input.LA(10);

                                        if ( ((LA12_181>='0' && LA12_181<='9')||(LA12_181>='A' && LA12_181<='Z')||LA12_181=='_'||(LA12_181>='a' && LA12_181<='z')) ) {
                                            return 27;
                                        }
                                        else {
                                            return 13;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        case 'o':
            {
            int LA12_45 = input.LA(3);

            if ( (LA12_45=='n') ) {
                int LA12_71 = input.LA(4);

                if ( (LA12_71=='s') ) {
                    int LA12_91 = input.LA(5);

                    if ( (LA12_91=='t') ) {
                        int LA12_111 = input.LA(6);

                        if ( (LA12_111=='r') ) {
                            int LA12_131 = input.LA(7);

                            if ( (LA12_131=='a') ) {
                                int LA12_150 = input.LA(8);

                                if ( (LA12_150=='i') ) {
                                    int LA12_168 = input.LA(9);

                                    if ( (LA12_168=='n') ) {
                                        int LA12_182 = input.LA(10);

                                        if ( (LA12_182=='t') ) {
                                            int LA12_194 = input.LA(11);

                                            if ( ((LA12_194>='0' && LA12_194<='9')||(LA12_194>='A' && LA12_194<='Z')||LA12_194=='_'||(LA12_194>='a' && LA12_194<='z')) ) {
                                                return 27;
                                            }
                                            else {
                                                return 24;}
                                        }
                                        else {
                                            return 27;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        default:
            return 27;}

    }

    private int mTokensHelper012() throws RecognitionException {
        int LA12_12 = input.LA(2);

        if ( (LA12_12=='e') ) {
            int LA12_46 = input.LA(3);

            if ( (LA12_46=='f') ) {
                int LA12_72 = input.LA(4);

                if ( (LA12_72=='o') ) {
                    int LA12_92 = input.LA(5);

                    if ( (LA12_92=='r') ) {
                        int LA12_112 = input.LA(6);

                        if ( (LA12_112=='e') ) {
                            int LA12_132 = input.LA(7);

                            if ( ((LA12_132>='0' && LA12_132<='9')||(LA12_132>='A' && LA12_132<='Z')||LA12_132=='_'||(LA12_132>='a' && LA12_132<='z')) ) {
                                return 27;
                            }
                            else {
                                return 14;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
        }
        else {
            return 27;}
    }

    private int mTokensHelper013() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'e':
            {
            int LA12_47 = input.LA(3);

            if ( (LA12_47=='s') ) {
                int LA12_73 = input.LA(4);

                if ( (LA12_73=='s') ) {
                    int LA12_93 = input.LA(5);

                    if ( (LA12_93=='a') ) {
                        int LA12_113 = input.LA(6);

                        if ( (LA12_113=='g') ) {
                            int LA12_133 = input.LA(7);

                            if ( (LA12_133=='e') ) {
                                int LA12_152 = input.LA(8);

                                if ( ((LA12_152>='0' && LA12_152<='9')||(LA12_152>='A' && LA12_152<='Z')||LA12_152=='_'||(LA12_152>='a' && LA12_152<='z')) ) {
                                    return 27;
                                }
                                else {
                                    return 26;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        case 'a':
            {
            int LA12_48 = input.LA(3);

            if ( (LA12_48=='n') ) {
                int LA12_74 = input.LA(4);

                if ( (LA12_74=='d') ) {
                    int LA12_94 = input.LA(5);

                    if ( (LA12_94=='a') ) {
                        int LA12_114 = input.LA(6);

                        if ( (LA12_114=='t') ) {
                            int LA12_134 = input.LA(7);

                            if ( (LA12_134=='o') ) {
                                int LA12_153 = input.LA(8);

                                if ( (LA12_153=='r') ) {
                                    int LA12_170 = input.LA(9);

                                    if ( (LA12_170=='y') ) {
                                        int LA12_183 = input.LA(10);

                                        if ( (LA12_183=='L') ) {
                                            int LA12_195 = input.LA(11);

                                            if ( (LA12_195=='o') ) {
                                                int LA12_204 = input.LA(12);

                                                if ( (LA12_204=='o') ) {
                                                    int LA12_208 = input.LA(13);

                                                    if ( (LA12_208=='p') ) {
                                                        int LA12_212 = input.LA(14);

                                                        if ( ((LA12_212>='0' && LA12_212<='9')||(LA12_212>='A' && LA12_212<='Z')||LA12_212=='_'||(LA12_212>='a' && LA12_212<='z')) ) {
                                                            return 27;
                                                        }
                                                        else {
                                                            return 17;}
                                                    }
                                                    else {
                                                        return 27;}
                                                }
                                                else {
                                                    return 27;}
                                            }
                                            else {
                                                return 27;}
                                        }
                                        else {
                                            return 27;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
            }
        default:
            return 27;}

    }

    private int mTokensHelper014() throws RecognitionException {
        return 18;
    }

    private int mTokensHelper015() throws RecognitionException {
        int LA12_15 = input.LA(2);

        if ( (LA12_15=='t') ) {
            int LA12_50 = input.LA(3);

            if ( (LA12_50=='t') ) {
                int LA12_75 = input.LA(4);

                if ( (LA12_75=='r') ) {
                    int LA12_95 = input.LA(5);

                    if ( (LA12_95=='i') ) {
                        int LA12_115 = input.LA(6);

                        if ( (LA12_115=='b') ) {
                            int LA12_135 = input.LA(7);

                            if ( (LA12_135=='u') ) {
                                int LA12_154 = input.LA(8);

                                if ( (LA12_154=='t') ) {
                                    int LA12_171 = input.LA(9);

                                    if ( (LA12_171=='e') ) {
                                        int LA12_184 = input.LA(10);

                                        if ( ((LA12_184>='0' && LA12_184<='9')||(LA12_184>='A' && LA12_184<='Z')||LA12_184=='_'||(LA12_184>='a' && LA12_184<='z')) ) {
                                            return 27;
                                        }
                                        else {
                                            return 19;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
        }
        else {
            return 27;}
    }

    private int mTokensHelper016() throws RecognitionException {
        int LA12_16 = input.LA(2);

        if ( (LA12_16=='e') ) {
            int LA12_51 = input.LA(3);

            if ( (LA12_51=='f') ) {
                int LA12_76 = input.LA(4);

                if ( (LA12_76=='e') ) {
                    int LA12_96 = input.LA(5);

                    if ( (LA12_96=='r') ) {
                        int LA12_116 = input.LA(6);

                        if ( (LA12_116=='e') ) {
                            int LA12_136 = input.LA(7);

                            if ( (LA12_136=='n') ) {
                                int LA12_155 = input.LA(8);

                                if ( (LA12_155=='c') ) {
                                    int LA12_172 = input.LA(9);

                                    if ( (LA12_172=='e') ) {
                                        int LA12_185 = input.LA(10);

                                        if ( ((LA12_185>='0' && LA12_185<='9')||(LA12_185>='A' && LA12_185<='Z')||LA12_185=='_'||(LA12_185>='a' && LA12_185<='z')) ) {
                                            return 27;
                                        }
                                        else {
                                            return 20;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
        }
        else {
            return 27;}
    }

    private int mTokensHelper017() throws RecognitionException {
        return 21;
    }

    private int mTokensHelper018() throws RecognitionException {
        int LA12_18 = input.LA(2);

        if ( (LA12_18=='e') ) {
            int LA12_53 = input.LA(3);

            if ( (LA12_53=='q') ) {
                int LA12_77 = input.LA(4);

                if ( (LA12_77=='u') ) {
                    int LA12_97 = input.LA(5);

                    if ( (LA12_97=='i') ) {
                        int LA12_117 = input.LA(6);

                        if ( (LA12_117=='r') ) {
                            int LA12_137 = input.LA(7);

                            if ( (LA12_137=='e') ) {
                                int LA12_156 = input.LA(8);

                                if ( (LA12_156=='d') ) {
                                    int LA12_173 = input.LA(9);

                                    if ( ((LA12_173>='0' && LA12_173<='9')||(LA12_173>='A' && LA12_173<='Z')||LA12_173=='_'||(LA12_173>='a' && LA12_173<='z')) ) {
                                        return 27;
                                    }
                                    else {
                                        return 22;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
        }
        else {
            return 27;}
    }

    private int mTokensHelper019() throws RecognitionException {
        int LA12_19 = input.LA(2);

        if ( (LA12_19=='e') ) {
            int LA12_54 = input.LA(3);

            if ( (LA12_54=='c') ) {
                int LA12_78 = input.LA(4);

                if ( (LA12_78=='h') ) {
                    int LA12_98 = input.LA(5);

                    if ( (LA12_98=='n') ) {
                        int LA12_118 = input.LA(6);

                        if ( (LA12_118=='i') ) {
                            int LA12_138 = input.LA(7);

                            if ( (LA12_138=='c') ) {
                                int LA12_157 = input.LA(8);

                                if ( (LA12_157=='a') ) {
                                    int LA12_174 = input.LA(9);

                                    if ( (LA12_174=='l') ) {
                                        int LA12_187 = input.LA(10);

                                        if ( ((LA12_187>='0' && LA12_187<='9')||(LA12_187>='A' && LA12_187<='Z')||LA12_187=='_'||(LA12_187>='a' && LA12_187<='z')) ) {
                                            return 27;
                                        }
                                        else {
                                            return 23;}
                                    }
                                    else {
                                        return 27;}
                                }
                                else {
                                    return 27;}
                            }
                            else {
                                return 27;}
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 27;}
                }
                else {
                    return 27;}
            }
            else {
                return 27;}
        }
        else {
            return 27;}
    }

    private int mTokensHelper020() throws RecognitionException {
        int LA12_20 = input.LA(2);

        if ( ((LA12_20>='A' && LA12_20<='Z')||LA12_20=='_'||(LA12_20>='a' && LA12_20<='z')) ) {
            return 27;
        }
        else {
            return 33;}
    }

    private int mTokensHelper021() throws RecognitionException {
        return 27;
    }

    private int mTokensHelper022() throws RecognitionException {
        return 28;
    }

    private int mTokensHelper023() throws RecognitionException {
        int LA12_23 = input.LA(2);

        if ( ((LA12_23>='\u0000' && LA12_23<='\uFFFE')) ) {
            return 29;
        }
        else {
            return 33;}
    }

    private int mTokensHelper024() throws RecognitionException {
        int LA12_24 = input.LA(2);

        if ( ((LA12_24>='\u0000' && LA12_24<='\uFFFE')) ) {
            return 29;
        }
        else {
            return 33;}
    }

    private int mTokensHelper025() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '/':
            {
            return 31;
            }
        case '*':
            {
            return 30;
            }
        default:
            return 33;}

    }

    private int mTokensHelper026() throws RecognitionException {
        return 32;
    }

    private int mTokensHelper027() throws RecognitionException {
        return 33;
    }

    private int mTokensHelper028() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}