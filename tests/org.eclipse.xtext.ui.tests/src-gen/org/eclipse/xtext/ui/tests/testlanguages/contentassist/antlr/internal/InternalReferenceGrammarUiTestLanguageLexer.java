package org.eclipse.xtext.ui.tests.testlanguages.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalReferenceGrammarUiTestLanguageLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=7;
    public static final int T14=14;
    public static final int RULE_ID=5;
    public static final int T22=22;
    public static final int T11=11;
    public static final int RULE_STRING=4;
    public static final int T12=12;
    public static final int T23=23;
    public static final int T13=13;
    public static final int T20=20;
    public static final int T25=25;
    public static final int T18=18;
    public static final int RULE_WS=9;
    public static final int T15=15;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T17=17;
    public static final int Tokens=26;
    public static final int RULE_ANY_OTHER=10;
    public static final int T16=16;
    public static final int RULE_SL_COMMENT=8;
    public static final int T24=24;
    public static final int T19=19;
    public InternalReferenceGrammarUiTestLanguageLexer() {;} 
    public InternalReferenceGrammarUiTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:10:5: ( 'ROT' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:10:7: 'ROT'
            {
            match("ROT"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:11:5: ( 'BLAU' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:11:7: 'BLAU'
            {
            match("BLAU"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:12:5: ( 'GELB' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:12:7: 'GELB'
            {
            match("GELB"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:13:5: ( 'GR\\u00DCN' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:13:7: 'GR\\u00DCN'
            {
            match("GR\u00DCN"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:14:5: ( 'keyword' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:14:7: 'keyword'
            {
            match("keyword"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:15:5: ( 'spielplatz' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:15:7: 'spielplatz'
            {
            match("spielplatz"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:16:5: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:16:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:17:5: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:17:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:18:5: ( 'kind' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:18:7: 'kind'
            {
            match("kind"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:19:5: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:19:7: '('
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:20:5: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:20:7: ')'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:21:5: ( 'erwachsener' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:21:7: 'erwachsener'
            {
            match("erwachsener"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:22:5: ( 'spielzeug' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:22:7: 'spielzeug'
            {
            match("spielzeug"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:23:5: ( 'familie' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:23:7: 'familie'
            {
            match("familie"); 


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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:24:5: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:24:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1275:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1275:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1275:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1275:11: '^'
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1275:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1277:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1277:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1277:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1277:13: '0' .. '9'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("1279:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1279:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1281:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1281:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1281:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1281:52: .
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1283:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1283:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1283:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1283:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1283:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1283:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1283:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1283:41: '\\r'
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1285:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1285:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1285:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1287:16: ( . )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1287:18: .
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
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=22;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='R') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0=='B') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='G') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0=='k') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='s') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='{') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0=='}') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0=='(') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0==')') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='e') ) {
            alt12 = mTokensHelper010();
        }
        else if ( (LA12_0=='f') ) {
            alt12 = mTokensHelper011();
        }
        else if ( (LA12_0==',') ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0=='A'||(LA12_0>='C' && LA12_0<='F')||(LA12_0>='H' && LA12_0<='Q')||(LA12_0>='S' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='d')||(LA12_0>='g' && LA12_0<='j')||(LA12_0>='l' && LA12_0<='r')||(LA12_0>='t' && LA12_0<='z')) ) {
            alt12 = mTokensHelper014();
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12 = mTokensHelper015();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper016();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper017();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper018();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper019();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='*' && LA12_0<='+')||(LA12_0>='-' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper020();
        }
        else {
            alt12 = mTokensHelper021();
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:70: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:78: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:87: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:99: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:115: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:131: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1:139: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        int LA12_1 = input.LA(2);

        if ( (LA12_1=='O') ) {
            int LA12_21 = input.LA(3);

            if ( (LA12_21=='T') ) {
                int LA12_41 = input.LA(4);

                if ( ((LA12_41>='0' && LA12_41<='9')||(LA12_41>='A' && LA12_41<='Z')||LA12_41=='_'||(LA12_41>='a' && LA12_41<='z')) ) {
                    return 16;
                }
                else {
                    return 1;}
            }
            else {
                return 16;}
        }
        else {
            return 16;}
    }

    private int mTokensHelper002() throws RecognitionException {
        int LA12_2 = input.LA(2);

        if ( (LA12_2=='L') ) {
            int LA12_23 = input.LA(3);

            if ( (LA12_23=='A') ) {
                int LA12_42 = input.LA(4);

                if ( (LA12_42=='U') ) {
                    int LA12_51 = input.LA(5);

                    if ( ((LA12_51>='0' && LA12_51<='9')||(LA12_51>='A' && LA12_51<='Z')||LA12_51=='_'||(LA12_51>='a' && LA12_51<='z')) ) {
                        return 16;
                    }
                    else {
                        return 2;}
                }
                else {
                    return 16;}
            }
            else {
                return 16;}
        }
        else {
            return 16;}
    }

    private int mTokensHelper003() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'E':
            {
            int LA12_24 = input.LA(3);

            if ( (LA12_24=='L') ) {
                int LA12_43 = input.LA(4);

                if ( (LA12_43=='B') ) {
                    int LA12_52 = input.LA(5);

                    if ( ((LA12_52>='0' && LA12_52<='9')||(LA12_52>='A' && LA12_52<='Z')||LA12_52=='_'||(LA12_52>='a' && LA12_52<='z')) ) {
                        return 16;
                    }
                    else {
                        return 3;}
                }
                else {
                    return 16;}
            }
            else {
                return 16;}
            }
        case 'R':
            {
            int LA12_25 = input.LA(3);

            if ( (LA12_25=='\u00DC') ) {
                return 4;
            }
            else {
                return 16;}
            }
        default:
            return 16;}

    }

    private int mTokensHelper004() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'i':
            {
            int LA12_26 = input.LA(3);

            if ( (LA12_26=='n') ) {
                int LA12_45 = input.LA(4);

                if ( (LA12_45=='d') ) {
                    int LA12_53 = input.LA(5);

                    if ( ((LA12_53>='0' && LA12_53<='9')||(LA12_53>='A' && LA12_53<='Z')||LA12_53=='_'||(LA12_53>='a' && LA12_53<='z')) ) {
                        return 16;
                    }
                    else {
                        return 9;}
                }
                else {
                    return 16;}
            }
            else {
                return 16;}
            }
        case 'e':
            {
            int LA12_27 = input.LA(3);

            if ( (LA12_27=='y') ) {
                int LA12_46 = input.LA(4);

                if ( (LA12_46=='w') ) {
                    int LA12_54 = input.LA(5);

                    if ( (LA12_54=='o') ) {
                        int LA12_61 = input.LA(6);

                        if ( (LA12_61=='r') ) {
                            int LA12_65 = input.LA(7);

                            if ( (LA12_65=='d') ) {
                                int LA12_70 = input.LA(8);

                                if ( ((LA12_70>='0' && LA12_70<='9')||(LA12_70>='A' && LA12_70<='Z')||LA12_70=='_'||(LA12_70>='a' && LA12_70<='z')) ) {
                                    return 16;
                                }
                                else {
                                    return 5;}
                            }
                            else {
                                return 16;}
                        }
                        else {
                            return 16;}
                    }
                    else {
                        return 16;}
                }
                else {
                    return 16;}
            }
            else {
                return 16;}
            }
        default:
            return 16;}

    }

    private int mTokensHelper005() throws RecognitionException {
        int LA12_5 = input.LA(2);

        if ( (LA12_5=='p') ) {
            int LA12_28 = input.LA(3);

            if ( (LA12_28=='i') ) {
                int LA12_47 = input.LA(4);

                if ( (LA12_47=='e') ) {
                    int LA12_55 = input.LA(5);

                    if ( (LA12_55=='l') ) {
                        switch ( input.LA(6) ) {
                        case 'z':
                            {
                            int LA12_66 = input.LA(7);

                            if ( (LA12_66=='e') ) {
                                int LA12_71 = input.LA(8);

                                if ( (LA12_71=='u') ) {
                                    int LA12_76 = input.LA(9);

                                    if ( (LA12_76=='g') ) {
                                        int LA12_80 = input.LA(10);

                                        if ( ((LA12_80>='0' && LA12_80<='9')||(LA12_80>='A' && LA12_80<='Z')||LA12_80=='_'||(LA12_80>='a' && LA12_80<='z')) ) {
                                            return 16;
                                        }
                                        else {
                                            return 13;}
                                    }
                                    else {
                                        return 16;}
                                }
                                else {
                                    return 16;}
                            }
                            else {
                                return 16;}
                            }
                        case 'p':
                            {
                            int LA12_67 = input.LA(7);

                            if ( (LA12_67=='l') ) {
                                int LA12_72 = input.LA(8);

                                if ( (LA12_72=='a') ) {
                                    int LA12_77 = input.LA(9);

                                    if ( (LA12_77=='t') ) {
                                        int LA12_81 = input.LA(10);

                                        if ( (LA12_81=='z') ) {
                                            int LA12_84 = input.LA(11);

                                            if ( ((LA12_84>='0' && LA12_84<='9')||(LA12_84>='A' && LA12_84<='Z')||LA12_84=='_'||(LA12_84>='a' && LA12_84<='z')) ) {
                                                return 16;
                                            }
                                            else {
                                                return 6;}
                                        }
                                        else {
                                            return 16;}
                                    }
                                    else {
                                        return 16;}
                                }
                                else {
                                    return 16;}
                            }
                            else {
                                return 16;}
                            }
                        default:
                            return 16;}

                    }
                    else {
                        return 16;}
                }
                else {
                    return 16;}
            }
            else {
                return 16;}
        }
        else {
            return 16;}
    }

    private int mTokensHelper006() throws RecognitionException {
        return 7;
    }

    private int mTokensHelper007() throws RecognitionException {
        return 8;
    }

    private int mTokensHelper008() throws RecognitionException {
        return 10;
    }

    private int mTokensHelper009() throws RecognitionException {
        return 11;
    }

    private int mTokensHelper010() throws RecognitionException {
        int LA12_10 = input.LA(2);

        if ( (LA12_10=='r') ) {
            int LA12_33 = input.LA(3);

            if ( (LA12_33=='w') ) {
                int LA12_48 = input.LA(4);

                if ( (LA12_48=='a') ) {
                    int LA12_56 = input.LA(5);

                    if ( (LA12_56=='c') ) {
                        int LA12_63 = input.LA(6);

                        if ( (LA12_63=='h') ) {
                            int LA12_68 = input.LA(7);

                            if ( (LA12_68=='s') ) {
                                int LA12_73 = input.LA(8);

                                if ( (LA12_73=='e') ) {
                                    int LA12_78 = input.LA(9);

                                    if ( (LA12_78=='n') ) {
                                        int LA12_82 = input.LA(10);

                                        if ( (LA12_82=='e') ) {
                                            int LA12_85 = input.LA(11);

                                            if ( (LA12_85=='r') ) {
                                                int LA12_87 = input.LA(12);

                                                if ( ((LA12_87>='0' && LA12_87<='9')||(LA12_87>='A' && LA12_87<='Z')||LA12_87=='_'||(LA12_87>='a' && LA12_87<='z')) ) {
                                                    return 16;
                                                }
                                                else {
                                                    return 12;}
                                            }
                                            else {
                                                return 16;}
                                        }
                                        else {
                                            return 16;}
                                    }
                                    else {
                                        return 16;}
                                }
                                else {
                                    return 16;}
                            }
                            else {
                                return 16;}
                        }
                        else {
                            return 16;}
                    }
                    else {
                        return 16;}
                }
                else {
                    return 16;}
            }
            else {
                return 16;}
        }
        else {
            return 16;}
    }

    private int mTokensHelper011() throws RecognitionException {
        int LA12_11 = input.LA(2);

        if ( (LA12_11=='a') ) {
            int LA12_34 = input.LA(3);

            if ( (LA12_34=='m') ) {
                int LA12_49 = input.LA(4);

                if ( (LA12_49=='i') ) {
                    int LA12_57 = input.LA(5);

                    if ( (LA12_57=='l') ) {
                        int LA12_64 = input.LA(6);

                        if ( (LA12_64=='i') ) {
                            int LA12_69 = input.LA(7);

                            if ( (LA12_69=='e') ) {
                                int LA12_74 = input.LA(8);

                                if ( ((LA12_74>='0' && LA12_74<='9')||(LA12_74>='A' && LA12_74<='Z')||LA12_74=='_'||(LA12_74>='a' && LA12_74<='z')) ) {
                                    return 16;
                                }
                                else {
                                    return 14;}
                            }
                            else {
                                return 16;}
                        }
                        else {
                            return 16;}
                    }
                    else {
                        return 16;}
                }
                else {
                    return 16;}
            }
            else {
                return 16;}
        }
        else {
            return 16;}
    }

    private int mTokensHelper012() throws RecognitionException {
        return 15;
    }

    private int mTokensHelper013() throws RecognitionException {
        int LA12_13 = input.LA(2);

        if ( ((LA12_13>='A' && LA12_13<='Z')||LA12_13=='_'||(LA12_13>='a' && LA12_13<='z')) ) {
            return 16;
        }
        else {
            return 22;}
    }

    private int mTokensHelper014() throws RecognitionException {
        return 16;
    }

    private int mTokensHelper015() throws RecognitionException {
        return 17;
    }

    private int mTokensHelper016() throws RecognitionException {
        int LA12_16 = input.LA(2);

        if ( ((LA12_16>='\u0000' && LA12_16<='\uFFFE')) ) {
            return 18;
        }
        else {
            return 22;}
    }

    private int mTokensHelper017() throws RecognitionException {
        int LA12_17 = input.LA(2);

        if ( ((LA12_17>='\u0000' && LA12_17<='\uFFFE')) ) {
            return 18;
        }
        else {
            return 22;}
    }

    private int mTokensHelper018() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '*':
            {
            return 19;
            }
        case '/':
            {
            return 20;
            }
        default:
            return 22;}

    }

    private int mTokensHelper019() throws RecognitionException {
        return 21;
    }

    private int mTokensHelper020() throws RecognitionException {
        return 22;
    }

    private int mTokensHelper021() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}