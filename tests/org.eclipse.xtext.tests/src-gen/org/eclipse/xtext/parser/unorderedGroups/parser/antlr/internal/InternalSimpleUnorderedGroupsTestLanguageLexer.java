package org.eclipse.xtext.parser.unorderedGroups.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleUnorderedGroupsTestLanguageLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=7;
    public static final int T14=14;
    public static final int T29=29;
    public static final int RULE_ID=4;
    public static final int T22=22;
    public static final int T11=11;
    public static final int RULE_STRING=6;
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
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T32=32;
    public static final int T17=17;
    public static final int Tokens=33;
    public static final int T31=31;
    public static final int RULE_ANY_OTHER=10;
    public static final int T16=16;
    public static final int T27=27;
    public static final int RULE_SL_COMMENT=8;
    public static final int T30=30;
    public static final int T24=24;
    public static final int T19=19;
    public InternalSimpleUnorderedGroupsTestLanguageLexer() {;} 
    public InternalSimpleUnorderedGroupsTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:10:5: ( '1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:10:7: '1'
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:11:5: ( 'a' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:11:7: 'a'
            {
            match('a'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:12:5: ( 'b' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:12:7: 'b'
            {
            match('b'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:13:5: ( '2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:13:7: '2'
            {
            match('2'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:14:5: ( 'c' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:14:7: 'c'
            {
            match('c'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:15:5: ( 'd' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:15:7: 'd'
            {
            match('d'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:16:5: ( '3' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:16:7: '3'
            {
            match('3'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:17:5: ( '4' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:17:7: '4'
            {
            match('4'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:18:5: ( '5' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:18:7: '5'
            {
            match('5'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:19:5: ( '6' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:19:7: '6'
            {
            match('6'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:20:5: ( '7' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:20:7: '7'
            {
            match('7'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:21:5: ( '8' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:21:7: '8'
            {
            match('8'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:22:5: ( '9' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:22:7: '9'
            {
            match('9'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:23:5: ( '10' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:23:7: '10'
            {
            match("10"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:24:5: ( '11' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:24:7: '11'
            {
            match("11"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:25:5: ( '12' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:25:7: '12'
            {
            match("12"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:26:5: ( '13' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:26:7: '13'
            {
            match("13"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:27:5: ( '14' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:27:7: '14'
            {
            match("14"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:28:5: ( 'datatypes' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:28:7: 'datatypes'
            {
            match("datatypes"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:29:5: ( 'serialization' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:29:7: 'serialization'
            {
            match("serialization"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:30:5: ( 'bug302585' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:30:7: 'bug302585'
            {
            match("bug302585"); 


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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:31:5: ( 'nested' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:31:7: 'nested'
            {
            match("nested"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3354:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3354:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3354:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3354:11: '^'
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3354:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3356:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3356:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3356:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3356:13: '0' .. '9'
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("3358:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3358:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3360:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3360:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3360:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3360:52: .
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3362:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3362:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3362:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3362:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3362:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3362:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3362:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3362:41: '\\r'
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3364:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3364:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3364:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3366:16: ( . )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:3366:18: .
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
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=29;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='1') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0=='a') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='b') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0=='2') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='c') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='d') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0=='3') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0=='4') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0=='5') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='6') ) {
            alt12 = mTokensHelper010();
        }
        else if ( (LA12_0=='7') ) {
            alt12 = mTokensHelper011();
        }
        else if ( (LA12_0=='8') ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0=='9') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0=='s') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='n') ) {
            alt12 = mTokensHelper015();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper016();
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='e' && LA12_0<='m')||(LA12_0>='o' && LA12_0<='r')||(LA12_0>='t' && LA12_0<='z')) ) {
            alt12 = mTokensHelper017();
        }
        else if ( (LA12_0=='0') ) {
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
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper023();
        }
        else {
            alt12 = mTokensHelper024();
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:98: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:106: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:115: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:127: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:143: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:159: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/internal/InternalSimpleUnorderedGroupsTestLanguage.g:1:167: RULE_ANY_OTHER
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
            int LA12_24 = input.LA(3);

            if ( ((LA12_24>='0' && LA12_24<='9')) ) {
                return 24;
            }
            else {
                return 16;}
            }
        case '0':
            {
            int LA12_25 = input.LA(3);

            if ( ((LA12_25>='0' && LA12_25<='9')) ) {
                return 24;
            }
            else {
                return 14;}
            }
        case '1':
            {
            int LA12_26 = input.LA(3);

            if ( ((LA12_26>='0' && LA12_26<='9')) ) {
                return 24;
            }
            else {
                return 15;}
            }
        case '4':
            {
            int LA12_27 = input.LA(3);

            if ( ((LA12_27>='0' && LA12_27<='9')) ) {
                return 24;
            }
            else {
                return 18;}
            }
        case '3':
            {
            int LA12_28 = input.LA(3);

            if ( ((LA12_28>='0' && LA12_28<='9')) ) {
                return 24;
            }
            else {
                return 17;}
            }
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            return 24;
            }
        default:
            return 1;}

    }

    private int mTokensHelper002() throws RecognitionException {
        int LA12_2 = input.LA(2);

        if ( ((LA12_2>='0' && LA12_2<='9')||(LA12_2>='A' && LA12_2<='Z')||LA12_2=='_'||(LA12_2>='a' && LA12_2<='z')) ) {
            return 23;
        }
        else {
            return 2;}
    }

    private int mTokensHelper003() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'u':
            {
            int LA12_33 = input.LA(3);

            if ( (LA12_33=='g') ) {
                int LA12_57 = input.LA(4);

                if ( (LA12_57=='3') ) {
                    int LA12_61 = input.LA(5);

                    if ( (LA12_61=='0') ) {
                        int LA12_65 = input.LA(6);

                        if ( (LA12_65=='2') ) {
                            int LA12_69 = input.LA(7);

                            if ( (LA12_69=='5') ) {
                                int LA12_73 = input.LA(8);

                                if ( (LA12_73=='8') ) {
                                    int LA12_77 = input.LA(9);

                                    if ( (LA12_77=='5') ) {
                                        int LA12_80 = input.LA(10);

                                        if ( ((LA12_80>='0' && LA12_80<='9')||(LA12_80>='A' && LA12_80<='Z')||LA12_80=='_'||(LA12_80>='a' && LA12_80<='z')) ) {
                                            return 23;
                                        }
                                        else {
                                            return 21;}
                                    }
                                    else {
                                        return 23;}
                                }
                                else {
                                    return 23;}
                            }
                            else {
                                return 23;}
                        }
                        else {
                            return 23;}
                    }
                    else {
                        return 23;}
                }
                else {
                    return 23;}
            }
            else {
                return 23;}
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
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            return 23;
            }
        default:
            return 3;}

    }

    private int mTokensHelper004() throws RecognitionException {
        int LA12_4 = input.LA(2);

        if ( ((LA12_4>='0' && LA12_4<='9')) ) {
            return 24;
        }
        else {
            return 4;}
    }

    private int mTokensHelper005() throws RecognitionException {
        int LA12_5 = input.LA(2);

        if ( ((LA12_5>='0' && LA12_5<='9')||(LA12_5>='A' && LA12_5<='Z')||LA12_5=='_'||(LA12_5>='a' && LA12_5<='z')) ) {
            return 23;
        }
        else {
            return 5;}
    }

    private int mTokensHelper006() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA12_37 = input.LA(3);

            if ( (LA12_37=='t') ) {
                int LA12_58 = input.LA(4);

                if ( (LA12_58=='a') ) {
                    int LA12_62 = input.LA(5);

                    if ( (LA12_62=='t') ) {
                        int LA12_66 = input.LA(6);

                        if ( (LA12_66=='y') ) {
                            int LA12_70 = input.LA(7);

                            if ( (LA12_70=='p') ) {
                                int LA12_74 = input.LA(8);

                                if ( (LA12_74=='e') ) {
                                    int LA12_78 = input.LA(9);

                                    if ( (LA12_78=='s') ) {
                                        int LA12_81 = input.LA(10);

                                        if ( ((LA12_81>='0' && LA12_81<='9')||(LA12_81>='A' && LA12_81<='Z')||LA12_81=='_'||(LA12_81>='a' && LA12_81<='z')) ) {
                                            return 23;
                                        }
                                        else {
                                            return 19;}
                                    }
                                    else {
                                        return 23;}
                                }
                                else {
                                    return 23;}
                            }
                            else {
                                return 23;}
                        }
                        else {
                            return 23;}
                    }
                    else {
                        return 23;}
                }
                else {
                    return 23;}
            }
            else {
                return 23;}
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
            return 23;
            }
        default:
            return 6;}

    }

    private int mTokensHelper007() throws RecognitionException {
        int LA12_7 = input.LA(2);

        if ( ((LA12_7>='0' && LA12_7<='9')) ) {
            return 24;
        }
        else {
            return 7;}
    }

    private int mTokensHelper008() throws RecognitionException {
        int LA12_8 = input.LA(2);

        if ( ((LA12_8>='0' && LA12_8<='9')) ) {
            return 24;
        }
        else {
            return 8;}
    }

    private int mTokensHelper009() throws RecognitionException {
        int LA12_9 = input.LA(2);

        if ( ((LA12_9>='0' && LA12_9<='9')) ) {
            return 24;
        }
        else {
            return 9;}
    }

    private int mTokensHelper010() throws RecognitionException {
        int LA12_10 = input.LA(2);

        if ( ((LA12_10>='0' && LA12_10<='9')) ) {
            return 24;
        }
        else {
            return 10;}
    }

    private int mTokensHelper011() throws RecognitionException {
        int LA12_11 = input.LA(2);

        if ( ((LA12_11>='0' && LA12_11<='9')) ) {
            return 24;
        }
        else {
            return 11;}
    }

    private int mTokensHelper012() throws RecognitionException {
        int LA12_12 = input.LA(2);

        if ( ((LA12_12>='0' && LA12_12<='9')) ) {
            return 24;
        }
        else {
            return 12;}
    }

    private int mTokensHelper013() throws RecognitionException {
        int LA12_13 = input.LA(2);

        if ( ((LA12_13>='0' && LA12_13<='9')) ) {
            return 24;
        }
        else {
            return 13;}
    }

    private int mTokensHelper014() throws RecognitionException {
        int LA12_14 = input.LA(2);

        if ( (LA12_14=='e') ) {
            int LA12_46 = input.LA(3);

            if ( (LA12_46=='r') ) {
                int LA12_59 = input.LA(4);

                if ( (LA12_59=='i') ) {
                    int LA12_63 = input.LA(5);

                    if ( (LA12_63=='a') ) {
                        int LA12_67 = input.LA(6);

                        if ( (LA12_67=='l') ) {
                            int LA12_71 = input.LA(7);

                            if ( (LA12_71=='i') ) {
                                int LA12_75 = input.LA(8);

                                if ( (LA12_75=='z') ) {
                                    int LA12_79 = input.LA(9);

                                    if ( (LA12_79=='a') ) {
                                        int LA12_82 = input.LA(10);

                                        if ( (LA12_82=='t') ) {
                                            int LA12_85 = input.LA(11);

                                            if ( (LA12_85=='i') ) {
                                                int LA12_86 = input.LA(12);

                                                if ( (LA12_86=='o') ) {
                                                    int LA12_87 = input.LA(13);

                                                    if ( (LA12_87=='n') ) {
                                                        int LA12_88 = input.LA(14);

                                                        if ( ((LA12_88>='0' && LA12_88<='9')||(LA12_88>='A' && LA12_88<='Z')||LA12_88=='_'||(LA12_88>='a' && LA12_88<='z')) ) {
                                                            return 23;
                                                        }
                                                        else {
                                                            return 20;}
                                                    }
                                                    else {
                                                        return 23;}
                                                }
                                                else {
                                                    return 23;}
                                            }
                                            else {
                                                return 23;}
                                        }
                                        else {
                                            return 23;}
                                    }
                                    else {
                                        return 23;}
                                }
                                else {
                                    return 23;}
                            }
                            else {
                                return 23;}
                        }
                        else {
                            return 23;}
                    }
                    else {
                        return 23;}
                }
                else {
                    return 23;}
            }
            else {
                return 23;}
        }
        else {
            return 23;}
    }

    private int mTokensHelper015() throws RecognitionException {
        int LA12_15 = input.LA(2);

        if ( (LA12_15=='e') ) {
            int LA12_47 = input.LA(3);

            if ( (LA12_47=='s') ) {
                int LA12_60 = input.LA(4);

                if ( (LA12_60=='t') ) {
                    int LA12_64 = input.LA(5);

                    if ( (LA12_64=='e') ) {
                        int LA12_68 = input.LA(6);

                        if ( (LA12_68=='d') ) {
                            int LA12_72 = input.LA(7);

                            if ( ((LA12_72>='0' && LA12_72<='9')||(LA12_72>='A' && LA12_72<='Z')||LA12_72=='_'||(LA12_72>='a' && LA12_72<='z')) ) {
                                return 23;
                            }
                            else {
                                return 22;}
                        }
                        else {
                            return 23;}
                    }
                    else {
                        return 23;}
                }
                else {
                    return 23;}
            }
            else {
                return 23;}
        }
        else {
            return 23;}
    }

    private int mTokensHelper016() throws RecognitionException {
        int LA12_16 = input.LA(2);

        if ( ((LA12_16>='A' && LA12_16<='Z')||LA12_16=='_'||(LA12_16>='a' && LA12_16<='z')) ) {
            return 23;
        }
        else {
            return 29;}
    }

    private int mTokensHelper017() throws RecognitionException {
        return 23;
    }

    private int mTokensHelper018() throws RecognitionException {
        return 24;
    }

    private int mTokensHelper019() throws RecognitionException {
        int LA12_19 = input.LA(2);

        if ( ((LA12_19>='\u0000' && LA12_19<='\uFFFE')) ) {
            return 25;
        }
        else {
            return 29;}
    }

    private int mTokensHelper020() throws RecognitionException {
        int LA12_20 = input.LA(2);

        if ( ((LA12_20>='\u0000' && LA12_20<='\uFFFE')) ) {
            return 25;
        }
        else {
            return 29;}
    }

    private int mTokensHelper021() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '/':
            {
            return 27;
            }
        case '*':
            {
            return 26;
            }
        default:
            return 29;}

    }

    private int mTokensHelper022() throws RecognitionException {
        return 28;
    }

    private int mTokensHelper023() throws RecognitionException {
        return 29;
    }

    private int mTokensHelper024() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}