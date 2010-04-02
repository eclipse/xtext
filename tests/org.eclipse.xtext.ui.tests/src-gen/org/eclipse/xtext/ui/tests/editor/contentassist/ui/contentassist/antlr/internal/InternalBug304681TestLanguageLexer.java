package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug304681TestLanguageLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=7;
    public static final int T14=14;
    public static final int T29=29;
    public static final int RULE_ID=4;
    public static final int T22=22;
    public static final int T11=11;
    public static final int RULE_STRING=5;
    public static final int T12=12;
    public static final int T28=28;
    public static final int T23=23;
    public static final int T13=13;
    public static final int T20=20;
    public static final int T25=25;
    public static final int T18=18;
    public static final int RULE_WS=9;
    public static final int T26=26;
    public static final int T15=15;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T17=17;
    public static final int Tokens=30;
    public static final int RULE_ANY_OTHER=10;
    public static final int T16=16;
    public static final int T27=27;
    public static final int RULE_SL_COMMENT=8;
    public static final int T24=24;
    public static final int T19=19;
    public InternalBug304681TestLanguageLexer() {;} 
    public InternalBug304681TestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:10:5: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:10:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:11:5: ( 'package' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:11:7: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:12:5: ( 'object' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:12:7: 'object'
            {
            match("object"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:13:5: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:13:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:14:5: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:14:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:15:5: ( 'extends' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:15:7: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:16:5: ( 'shortDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:16:7: 'shortDescription'
            {
            match("shortDescription"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:17:5: ( 'longDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:17:7: 'longDescription'
            {
            match("longDescription"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:18:5: ( 'serialUID' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:18:7: 'serialUID'
            {
            match("serialUID"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:19:5: ( 'before' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:19:7: 'before'
            {
            match("before"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:20:5: ( 'after' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:20:7: 'after'
            {
            match("after"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:21:5: ( 'optionalLoop' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:21:7: 'optionalLoop'
            {
            match("optionalLoop"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:22:5: ( 'mandatoryLoop' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:22:7: 'mandatoryLoop'
            {
            match("mandatoryLoop"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:23:5: ( 'Attribute' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:23:7: 'Attribute'
            {
            match("Attribute"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:24:5: ( 'Reference' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:24:7: 'Reference'
            {
            match("Reference"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:25:5: ( 'enabled' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:25:7: 'enabled'
            {
            match("enabled"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:26:5: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:26:7: 'abstract'
            {
            match("abstract"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:27:5: ( 'cloneable' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:27:7: 'cloneable'
            {
            match("cloneable"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:28:5: ( '*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:28:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2066:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2066:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2066:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2066:11: '^'
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2066:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2068:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2068:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2068:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2068:13: '0' .. '9'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("2070:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2070:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2072:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2072:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2072:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2072:52: .
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2074:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2074:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2074:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2074:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2074:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2074:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2074:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2074:41: '\\r'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2076:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2076:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2076:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2078:16: ( . )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2078:18: .
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
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=26;
        int LA12_0 = input.LA(1);

        if ( (LA12_0==';') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0=='p') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='o') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0=='{') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='}') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='e') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0=='s') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0=='l') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0=='b') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='a') ) {
            alt12 = mTokensHelper010();
        }
        else if ( (LA12_0=='m') ) {
            alt12 = mTokensHelper011();
        }
        else if ( (LA12_0=='A') ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0=='R') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0=='c') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='*') ) {
            alt12 = mTokensHelper015();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper016();
        }
        else if ( ((LA12_0>='B' && LA12_0<='Q')||(LA12_0>='S' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='d'||(LA12_0>='f' && LA12_0<='k')||LA12_0=='n'||(LA12_0>='q' && LA12_0<='r')||(LA12_0>='t' && LA12_0<='z')) ) {
            alt12 = mTokensHelper017();
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12 = mTokensHelper018();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper019();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper020();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper021();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper022();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='.')||LA12_0==':'||(LA12_0>='<' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper023();
        }
        else {
            alt12 = mTokensHelper024();
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:86: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:94: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:103: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:115: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:131: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:147: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1:155: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        return 1;
    }

    private int mTokensHelper002() throws RecognitionException {
        int LA12_2 = input.LA(2);

        if ( (LA12_2=='a') ) {
            int LA12_25 = input.LA(3);

            if ( (LA12_25=='c') ) {
                int LA12_49 = input.LA(4);

                if ( (LA12_49=='k') ) {
                    int LA12_64 = input.LA(5);

                    if ( (LA12_64=='a') ) {
                        int LA12_79 = input.LA(6);

                        if ( (LA12_79=='g') ) {
                            int LA12_94 = input.LA(7);

                            if ( (LA12_94=='e') ) {
                                int LA12_109 = input.LA(8);

                                if ( ((LA12_109>='0' && LA12_109<='9')||(LA12_109>='A' && LA12_109<='Z')||LA12_109=='_'||(LA12_109>='a' && LA12_109<='z')) ) {
                                    return 20;
                                }
                                else {
                                    return 2;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
        }
        else {
            return 20;}
    }

    private int mTokensHelper003() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'b':
            {
            int LA12_27 = input.LA(3);

            if ( (LA12_27=='j') ) {
                int LA12_50 = input.LA(4);

                if ( (LA12_50=='e') ) {
                    int LA12_65 = input.LA(5);

                    if ( (LA12_65=='c') ) {
                        int LA12_80 = input.LA(6);

                        if ( (LA12_80=='t') ) {
                            int LA12_95 = input.LA(7);

                            if ( ((LA12_95>='0' && LA12_95<='9')||(LA12_95>='A' && LA12_95<='Z')||LA12_95=='_'||(LA12_95>='a' && LA12_95<='z')) ) {
                                return 20;
                            }
                            else {
                                return 3;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
            }
        case 'p':
            {
            int LA12_28 = input.LA(3);

            if ( (LA12_28=='t') ) {
                int LA12_51 = input.LA(4);

                if ( (LA12_51=='i') ) {
                    int LA12_66 = input.LA(5);

                    if ( (LA12_66=='o') ) {
                        int LA12_81 = input.LA(6);

                        if ( (LA12_81=='n') ) {
                            int LA12_96 = input.LA(7);

                            if ( (LA12_96=='a') ) {
                                int LA12_111 = input.LA(8);

                                if ( (LA12_111=='l') ) {
                                    int LA12_124 = input.LA(9);

                                    if ( (LA12_124=='L') ) {
                                        int LA12_135 = input.LA(10);

                                        if ( (LA12_135=='o') ) {
                                            int LA12_144 = input.LA(11);

                                            if ( (LA12_144=='o') ) {
                                                int LA12_152 = input.LA(12);

                                                if ( (LA12_152=='p') ) {
                                                    int LA12_156 = input.LA(13);

                                                    if ( ((LA12_156>='0' && LA12_156<='9')||(LA12_156>='A' && LA12_156<='Z')||LA12_156=='_'||(LA12_156>='a' && LA12_156<='z')) ) {
                                                        return 20;
                                                    }
                                                    else {
                                                        return 12;}
                                                }
                                                else {
                                                    return 20;}
                                            }
                                            else {
                                                return 20;}
                                        }
                                        else {
                                            return 20;}
                                    }
                                    else {
                                        return 20;}
                                }
                                else {
                                    return 20;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
            }
        default:
            return 20;}

    }

    private int mTokensHelper004() throws RecognitionException {
        return 4;
    }

    private int mTokensHelper005() throws RecognitionException {
        return 5;
    }

    private int mTokensHelper006() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'n':
            {
            int LA12_31 = input.LA(3);

            if ( (LA12_31=='a') ) {
                int LA12_52 = input.LA(4);

                if ( (LA12_52=='b') ) {
                    int LA12_67 = input.LA(5);

                    if ( (LA12_67=='l') ) {
                        int LA12_82 = input.LA(6);

                        if ( (LA12_82=='e') ) {
                            int LA12_97 = input.LA(7);

                            if ( (LA12_97=='d') ) {
                                int LA12_112 = input.LA(8);

                                if ( ((LA12_112>='0' && LA12_112<='9')||(LA12_112>='A' && LA12_112<='Z')||LA12_112=='_'||(LA12_112>='a' && LA12_112<='z')) ) {
                                    return 20;
                                }
                                else {
                                    return 16;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
            }
        case 'x':
            {
            int LA12_32 = input.LA(3);

            if ( (LA12_32=='t') ) {
                int LA12_53 = input.LA(4);

                if ( (LA12_53=='e') ) {
                    int LA12_68 = input.LA(5);

                    if ( (LA12_68=='n') ) {
                        int LA12_83 = input.LA(6);

                        if ( (LA12_83=='d') ) {
                            int LA12_98 = input.LA(7);

                            if ( (LA12_98=='s') ) {
                                int LA12_113 = input.LA(8);

                                if ( ((LA12_113>='0' && LA12_113<='9')||(LA12_113>='A' && LA12_113<='Z')||LA12_113=='_'||(LA12_113>='a' && LA12_113<='z')) ) {
                                    return 20;
                                }
                                else {
                                    return 6;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
            }
        default:
            return 20;}

    }

    private int mTokensHelper007() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'h':
            {
            int LA12_33 = input.LA(3);

            if ( (LA12_33=='o') ) {
                int LA12_54 = input.LA(4);

                if ( (LA12_54=='r') ) {
                    int LA12_69 = input.LA(5);

                    if ( (LA12_69=='t') ) {
                        int LA12_84 = input.LA(6);

                        if ( (LA12_84=='D') ) {
                            int LA12_99 = input.LA(7);

                            if ( (LA12_99=='e') ) {
                                int LA12_114 = input.LA(8);

                                if ( (LA12_114=='s') ) {
                                    int LA12_127 = input.LA(9);

                                    if ( (LA12_127=='c') ) {
                                        int LA12_136 = input.LA(10);

                                        if ( (LA12_136=='r') ) {
                                            int LA12_145 = input.LA(11);

                                            if ( (LA12_145=='i') ) {
                                                int LA12_153 = input.LA(12);

                                                if ( (LA12_153=='p') ) {
                                                    int LA12_157 = input.LA(13);

                                                    if ( (LA12_157=='t') ) {
                                                        int LA12_161 = input.LA(14);

                                                        if ( (LA12_161=='i') ) {
                                                            int LA12_164 = input.LA(15);

                                                            if ( (LA12_164=='o') ) {
                                                                int LA12_167 = input.LA(16);

                                                                if ( (LA12_167=='n') ) {
                                                                    int LA12_169 = input.LA(17);

                                                                    if ( ((LA12_169>='0' && LA12_169<='9')||(LA12_169>='A' && LA12_169<='Z')||LA12_169=='_'||(LA12_169>='a' && LA12_169<='z')) ) {
                                                                        return 20;
                                                                    }
                                                                    else {
                                                                        return 7;}
                                                                }
                                                                else {
                                                                    return 20;}
                                                            }
                                                            else {
                                                                return 20;}
                                                        }
                                                        else {
                                                            return 20;}
                                                    }
                                                    else {
                                                        return 20;}
                                                }
                                                else {
                                                    return 20;}
                                            }
                                            else {
                                                return 20;}
                                        }
                                        else {
                                            return 20;}
                                    }
                                    else {
                                        return 20;}
                                }
                                else {
                                    return 20;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
            }
        case 'e':
            {
            int LA12_34 = input.LA(3);

            if ( (LA12_34=='r') ) {
                int LA12_55 = input.LA(4);

                if ( (LA12_55=='i') ) {
                    int LA12_70 = input.LA(5);

                    if ( (LA12_70=='a') ) {
                        int LA12_85 = input.LA(6);

                        if ( (LA12_85=='l') ) {
                            int LA12_100 = input.LA(7);

                            if ( (LA12_100=='U') ) {
                                int LA12_115 = input.LA(8);

                                if ( (LA12_115=='I') ) {
                                    int LA12_128 = input.LA(9);

                                    if ( (LA12_128=='D') ) {
                                        int LA12_137 = input.LA(10);

                                        if ( ((LA12_137>='0' && LA12_137<='9')||(LA12_137>='A' && LA12_137<='Z')||LA12_137=='_'||(LA12_137>='a' && LA12_137<='z')) ) {
                                            return 20;
                                        }
                                        else {
                                            return 9;}
                                    }
                                    else {
                                        return 20;}
                                }
                                else {
                                    return 20;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
            }
        default:
            return 20;}

    }

    private int mTokensHelper008() throws RecognitionException {
        int LA12_8 = input.LA(2);

        if ( (LA12_8=='o') ) {
            int LA12_35 = input.LA(3);

            if ( (LA12_35=='n') ) {
                int LA12_56 = input.LA(4);

                if ( (LA12_56=='g') ) {
                    int LA12_71 = input.LA(5);

                    if ( (LA12_71=='D') ) {
                        int LA12_86 = input.LA(6);

                        if ( (LA12_86=='e') ) {
                            int LA12_101 = input.LA(7);

                            if ( (LA12_101=='s') ) {
                                int LA12_116 = input.LA(8);

                                if ( (LA12_116=='c') ) {
                                    int LA12_129 = input.LA(9);

                                    if ( (LA12_129=='r') ) {
                                        int LA12_138 = input.LA(10);

                                        if ( (LA12_138=='i') ) {
                                            int LA12_147 = input.LA(11);

                                            if ( (LA12_147=='p') ) {
                                                int LA12_154 = input.LA(12);

                                                if ( (LA12_154=='t') ) {
                                                    int LA12_158 = input.LA(13);

                                                    if ( (LA12_158=='i') ) {
                                                        int LA12_162 = input.LA(14);

                                                        if ( (LA12_162=='o') ) {
                                                            int LA12_165 = input.LA(15);

                                                            if ( (LA12_165=='n') ) {
                                                                int LA12_168 = input.LA(16);

                                                                if ( ((LA12_168>='0' && LA12_168<='9')||(LA12_168>='A' && LA12_168<='Z')||LA12_168=='_'||(LA12_168>='a' && LA12_168<='z')) ) {
                                                                    return 20;
                                                                }
                                                                else {
                                                                    return 8;}
                                                            }
                                                            else {
                                                                return 20;}
                                                        }
                                                        else {
                                                            return 20;}
                                                    }
                                                    else {
                                                        return 20;}
                                                }
                                                else {
                                                    return 20;}
                                            }
                                            else {
                                                return 20;}
                                        }
                                        else {
                                            return 20;}
                                    }
                                    else {
                                        return 20;}
                                }
                                else {
                                    return 20;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
        }
        else {
            return 20;}
    }

    private int mTokensHelper009() throws RecognitionException {
        int LA12_9 = input.LA(2);

        if ( (LA12_9=='e') ) {
            int LA12_36 = input.LA(3);

            if ( (LA12_36=='f') ) {
                int LA12_57 = input.LA(4);

                if ( (LA12_57=='o') ) {
                    int LA12_72 = input.LA(5);

                    if ( (LA12_72=='r') ) {
                        int LA12_87 = input.LA(6);

                        if ( (LA12_87=='e') ) {
                            int LA12_102 = input.LA(7);

                            if ( ((LA12_102>='0' && LA12_102<='9')||(LA12_102>='A' && LA12_102<='Z')||LA12_102=='_'||(LA12_102>='a' && LA12_102<='z')) ) {
                                return 20;
                            }
                            else {
                                return 10;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
        }
        else {
            return 20;}
    }

    private int mTokensHelper010() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'b':
            {
            int LA12_37 = input.LA(3);

            if ( (LA12_37=='s') ) {
                int LA12_58 = input.LA(4);

                if ( (LA12_58=='t') ) {
                    int LA12_73 = input.LA(5);

                    if ( (LA12_73=='r') ) {
                        int LA12_88 = input.LA(6);

                        if ( (LA12_88=='a') ) {
                            int LA12_103 = input.LA(7);

                            if ( (LA12_103=='c') ) {
                                int LA12_118 = input.LA(8);

                                if ( (LA12_118=='t') ) {
                                    int LA12_130 = input.LA(9);

                                    if ( ((LA12_130>='0' && LA12_130<='9')||(LA12_130>='A' && LA12_130<='Z')||LA12_130=='_'||(LA12_130>='a' && LA12_130<='z')) ) {
                                        return 20;
                                    }
                                    else {
                                        return 17;}
                                }
                                else {
                                    return 20;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
            }
        case 'f':
            {
            int LA12_38 = input.LA(3);

            if ( (LA12_38=='t') ) {
                int LA12_59 = input.LA(4);

                if ( (LA12_59=='e') ) {
                    int LA12_74 = input.LA(5);

                    if ( (LA12_74=='r') ) {
                        int LA12_89 = input.LA(6);

                        if ( ((LA12_89>='0' && LA12_89<='9')||(LA12_89>='A' && LA12_89<='Z')||LA12_89=='_'||(LA12_89>='a' && LA12_89<='z')) ) {
                            return 20;
                        }
                        else {
                            return 11;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
            }
        default:
            return 20;}

    }

    private int mTokensHelper011() throws RecognitionException {
        int LA12_11 = input.LA(2);

        if ( (LA12_11=='a') ) {
            int LA12_39 = input.LA(3);

            if ( (LA12_39=='n') ) {
                int LA12_60 = input.LA(4);

                if ( (LA12_60=='d') ) {
                    int LA12_75 = input.LA(5);

                    if ( (LA12_75=='a') ) {
                        int LA12_90 = input.LA(6);

                        if ( (LA12_90=='t') ) {
                            int LA12_105 = input.LA(7);

                            if ( (LA12_105=='o') ) {
                                int LA12_119 = input.LA(8);

                                if ( (LA12_119=='r') ) {
                                    int LA12_131 = input.LA(9);

                                    if ( (LA12_131=='y') ) {
                                        int LA12_140 = input.LA(10);

                                        if ( (LA12_140=='L') ) {
                                            int LA12_148 = input.LA(11);

                                            if ( (LA12_148=='o') ) {
                                                int LA12_155 = input.LA(12);

                                                if ( (LA12_155=='o') ) {
                                                    int LA12_159 = input.LA(13);

                                                    if ( (LA12_159=='p') ) {
                                                        int LA12_163 = input.LA(14);

                                                        if ( ((LA12_163>='0' && LA12_163<='9')||(LA12_163>='A' && LA12_163<='Z')||LA12_163=='_'||(LA12_163>='a' && LA12_163<='z')) ) {
                                                            return 20;
                                                        }
                                                        else {
                                                            return 13;}
                                                    }
                                                    else {
                                                        return 20;}
                                                }
                                                else {
                                                    return 20;}
                                            }
                                            else {
                                                return 20;}
                                        }
                                        else {
                                            return 20;}
                                    }
                                    else {
                                        return 20;}
                                }
                                else {
                                    return 20;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
        }
        else {
            return 20;}
    }

    private int mTokensHelper012() throws RecognitionException {
        int LA12_12 = input.LA(2);

        if ( (LA12_12=='t') ) {
            int LA12_40 = input.LA(3);

            if ( (LA12_40=='t') ) {
                int LA12_61 = input.LA(4);

                if ( (LA12_61=='r') ) {
                    int LA12_76 = input.LA(5);

                    if ( (LA12_76=='i') ) {
                        int LA12_91 = input.LA(6);

                        if ( (LA12_91=='b') ) {
                            int LA12_106 = input.LA(7);

                            if ( (LA12_106=='u') ) {
                                int LA12_120 = input.LA(8);

                                if ( (LA12_120=='t') ) {
                                    int LA12_132 = input.LA(9);

                                    if ( (LA12_132=='e') ) {
                                        int LA12_141 = input.LA(10);

                                        if ( ((LA12_141>='0' && LA12_141<='9')||(LA12_141>='A' && LA12_141<='Z')||LA12_141=='_'||(LA12_141>='a' && LA12_141<='z')) ) {
                                            return 20;
                                        }
                                        else {
                                            return 14;}
                                    }
                                    else {
                                        return 20;}
                                }
                                else {
                                    return 20;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
        }
        else {
            return 20;}
    }

    private int mTokensHelper013() throws RecognitionException {
        int LA12_13 = input.LA(2);

        if ( (LA12_13=='e') ) {
            int LA12_41 = input.LA(3);

            if ( (LA12_41=='f') ) {
                int LA12_62 = input.LA(4);

                if ( (LA12_62=='e') ) {
                    int LA12_77 = input.LA(5);

                    if ( (LA12_77=='r') ) {
                        int LA12_92 = input.LA(6);

                        if ( (LA12_92=='e') ) {
                            int LA12_107 = input.LA(7);

                            if ( (LA12_107=='n') ) {
                                int LA12_121 = input.LA(8);

                                if ( (LA12_121=='c') ) {
                                    int LA12_133 = input.LA(9);

                                    if ( (LA12_133=='e') ) {
                                        int LA12_142 = input.LA(10);

                                        if ( ((LA12_142>='0' && LA12_142<='9')||(LA12_142>='A' && LA12_142<='Z')||LA12_142=='_'||(LA12_142>='a' && LA12_142<='z')) ) {
                                            return 20;
                                        }
                                        else {
                                            return 15;}
                                    }
                                    else {
                                        return 20;}
                                }
                                else {
                                    return 20;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
        }
        else {
            return 20;}
    }

    private int mTokensHelper014() throws RecognitionException {
        int LA12_14 = input.LA(2);

        if ( (LA12_14=='l') ) {
            int LA12_42 = input.LA(3);

            if ( (LA12_42=='o') ) {
                int LA12_63 = input.LA(4);

                if ( (LA12_63=='n') ) {
                    int LA12_78 = input.LA(5);

                    if ( (LA12_78=='e') ) {
                        int LA12_93 = input.LA(6);

                        if ( (LA12_93=='a') ) {
                            int LA12_108 = input.LA(7);

                            if ( (LA12_108=='b') ) {
                                int LA12_122 = input.LA(8);

                                if ( (LA12_122=='l') ) {
                                    int LA12_134 = input.LA(9);

                                    if ( (LA12_134=='e') ) {
                                        int LA12_143 = input.LA(10);

                                        if ( ((LA12_143>='0' && LA12_143<='9')||(LA12_143>='A' && LA12_143<='Z')||LA12_143=='_'||(LA12_143>='a' && LA12_143<='z')) ) {
                                            return 20;
                                        }
                                        else {
                                            return 18;}
                                    }
                                    else {
                                        return 20;}
                                }
                                else {
                                    return 20;}
                            }
                            else {
                                return 20;}
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 20;}
                }
                else {
                    return 20;}
            }
            else {
                return 20;}
        }
        else {
            return 20;}
    }

    private int mTokensHelper015() throws RecognitionException {
        return 19;
    }

    private int mTokensHelper016() throws RecognitionException {
        int LA12_16 = input.LA(2);

        if ( ((LA12_16>='A' && LA12_16<='Z')||LA12_16=='_'||(LA12_16>='a' && LA12_16<='z')) ) {
            return 20;
        }
        else {
            return 26;}
    }

    private int mTokensHelper017() throws RecognitionException {
        return 20;
    }

    private int mTokensHelper018() throws RecognitionException {
        return 21;
    }

    private int mTokensHelper019() throws RecognitionException {
        int LA12_19 = input.LA(2);

        if ( ((LA12_19>='\u0000' && LA12_19<='\uFFFE')) ) {
            return 22;
        }
        else {
            return 26;}
    }

    private int mTokensHelper020() throws RecognitionException {
        int LA12_20 = input.LA(2);

        if ( ((LA12_20>='\u0000' && LA12_20<='\uFFFE')) ) {
            return 22;
        }
        else {
            return 26;}
    }

    private int mTokensHelper021() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '*':
            {
            return 23;
            }
        case '/':
            {
            return 24;
            }
        default:
            return 26;}

    }

    private int mTokensHelper022() throws RecognitionException {
        return 25;
    }

    private int mTokensHelper023() throws RecognitionException {
        return 26;
    }

    private int mTokensHelper024() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}