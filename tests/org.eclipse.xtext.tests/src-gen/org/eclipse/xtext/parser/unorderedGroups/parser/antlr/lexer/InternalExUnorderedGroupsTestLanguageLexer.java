package org.eclipse.xtext.parser.unorderedGroups.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalExUnorderedGroupsTestLanguageLexer extends Lexer {
    public static final int KEYWORD_7=19;
    public static final int RULE_ML_COMMENT=29;
    public static final int RULE_ID=26;
    public static final int KEYWORD_21=6;
    public static final int KEYWORD_10=22;
    public static final int KEYWORD_17=11;
    public static final int KEYWORD_1=13;
    public static final int KEYWORD_18=12;
    public static final int RULE_STRING=28;
    public static final int KEYWORD_9=21;
    public static final int KEYWORD_19=7;
    public static final int KEYWORD_2=14;
    public static final int KEYWORD_22=4;
    public static final int KEYWORD_16=10;
    public static final int KEYWORD_11=23;
    public static final int KEYWORD_4=16;
    public static final int RULE_WS=31;
    public static final int KEYWORD_20=5;
    public static final int RULE_INT=27;
    public static final int KEYWORD_13=25;
    public static final int EOF=-1;
    public static final int KEYWORD_14=8;
    public static final int KEYWORD_5=17;
    public static final int Tokens=33;
    public static final int KEYWORD_6=18;
    public static final int RULE_ANY_OTHER=32;
    public static final int KEYWORD_12=24;
    public static final int KEYWORD_15=9;
    public static final int RULE_SL_COMMENT=30;
    public static final int KEYWORD_8=20;
    public static final int KEYWORD_3=15;
    public InternalExUnorderedGroupsTestLanguageLexer() {;} 
    public InternalExUnorderedGroupsTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g"; }

    // $ANTLR start KEYWORD_22
    public final void mKEYWORD_22() throws RecognitionException {
        try {
            int _type = KEYWORD_22;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:19:12: ( 'serialization' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:19:14: 'serialization'
            {
            match("serialization"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_22

    // $ANTLR start KEYWORD_20
    public final void mKEYWORD_20() throws RecognitionException {
        try {
            int _type = KEYWORD_20;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:21:12: ( 'bug302585' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:21:14: 'bug302585'
            {
            match("bug302585"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_20

    // $ANTLR start KEYWORD_21
    public final void mKEYWORD_21() throws RecognitionException {
        try {
            int _type = KEYWORD_21;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:23:12: ( 'datatypes' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:23:14: 'datatypes'
            {
            match("datatypes"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_21

    // $ANTLR start KEYWORD_19
    public final void mKEYWORD_19() throws RecognitionException {
        try {
            int _type = KEYWORD_19;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:25:12: ( 'nested' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:25:14: 'nested'
            {
            match("nested"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_19

    // $ANTLR start KEYWORD_14
    public final void mKEYWORD_14() throws RecognitionException {
        try {
            int _type = KEYWORD_14;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:27:12: ( '10' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:27:14: '10'
            {
            match("10"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_14

    // $ANTLR start KEYWORD_15
    public final void mKEYWORD_15() throws RecognitionException {
        try {
            int _type = KEYWORD_15;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:29:12: ( '11' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:29:14: '11'
            {
            match("11"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_15

    // $ANTLR start KEYWORD_16
    public final void mKEYWORD_16() throws RecognitionException {
        try {
            int _type = KEYWORD_16;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:31:12: ( '12' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:31:14: '12'
            {
            match("12"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_16

    // $ANTLR start KEYWORD_17
    public final void mKEYWORD_17() throws RecognitionException {
        try {
            int _type = KEYWORD_17;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:33:12: ( '13' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:33:14: '13'
            {
            match("13"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_17

    // $ANTLR start KEYWORD_18
    public final void mKEYWORD_18() throws RecognitionException {
        try {
            int _type = KEYWORD_18;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:35:12: ( '14' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:35:14: '14'
            {
            match("14"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_18

    // $ANTLR start KEYWORD_1
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:37:11: ( '1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:37:13: '1'
            {
            match('1'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_1

    // $ANTLR start KEYWORD_2
    public final void mKEYWORD_2() throws RecognitionException {
        try {
            int _type = KEYWORD_2;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:39:11: ( '2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:39:13: '2'
            {
            match('2'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_2

    // $ANTLR start KEYWORD_3
    public final void mKEYWORD_3() throws RecognitionException {
        try {
            int _type = KEYWORD_3;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:41:11: ( '3' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:41:13: '3'
            {
            match('3'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_3

    // $ANTLR start KEYWORD_4
    public final void mKEYWORD_4() throws RecognitionException {
        try {
            int _type = KEYWORD_4;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:43:11: ( '4' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:43:13: '4'
            {
            match('4'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_4

    // $ANTLR start KEYWORD_5
    public final void mKEYWORD_5() throws RecognitionException {
        try {
            int _type = KEYWORD_5;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:45:11: ( '5' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:45:13: '5'
            {
            match('5'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_5

    // $ANTLR start KEYWORD_6
    public final void mKEYWORD_6() throws RecognitionException {
        try {
            int _type = KEYWORD_6;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:47:11: ( '6' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:47:13: '6'
            {
            match('6'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_6

    // $ANTLR start KEYWORD_7
    public final void mKEYWORD_7() throws RecognitionException {
        try {
            int _type = KEYWORD_7;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:49:11: ( '7' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:49:13: '7'
            {
            match('7'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_7

    // $ANTLR start KEYWORD_8
    public final void mKEYWORD_8() throws RecognitionException {
        try {
            int _type = KEYWORD_8;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:51:11: ( '8' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:51:13: '8'
            {
            match('8'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_8

    // $ANTLR start KEYWORD_9
    public final void mKEYWORD_9() throws RecognitionException {
        try {
            int _type = KEYWORD_9;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:53:11: ( '9' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:53:13: '9'
            {
            match('9'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_9

    // $ANTLR start KEYWORD_10
    public final void mKEYWORD_10() throws RecognitionException {
        try {
            int _type = KEYWORD_10;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:55:12: ( 'a' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:55:14: 'a'
            {
            match('a'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_10

    // $ANTLR start KEYWORD_11
    public final void mKEYWORD_11() throws RecognitionException {
        try {
            int _type = KEYWORD_11;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:57:12: ( 'b' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:57:14: 'b'
            {
            match('b'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_11

    // $ANTLR start KEYWORD_12
    public final void mKEYWORD_12() throws RecognitionException {
        try {
            int _type = KEYWORD_12;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:59:12: ( 'c' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:59:14: 'c'
            {
            match('c'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_12

    // $ANTLR start KEYWORD_13
    public final void mKEYWORD_13() throws RecognitionException {
        try {
            int _type = KEYWORD_13;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:61:12: ( 'd' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:61:14: 'd'
            {
            match('d'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_13

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:65:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:65:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:65:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:65:11: '^'
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:65:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:67:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:67:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:67:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:67:13: '0' .. '9'
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("69:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:69:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:71:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:71:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:71:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:71:52: .
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:73:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:73:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:73:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:73:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:73:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:73:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:73:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:73:41: '\\r'
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:75:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:75:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:75:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:77:16: ( . )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:77:18: .
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
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:8: ( KEYWORD_22 | KEYWORD_20 | KEYWORD_21 | KEYWORD_19 | KEYWORD_14 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_18 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=29;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='s') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0=='b') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='d') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0=='n') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='1') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='2') ) {
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
        else if ( (LA12_0=='a') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='c') ) {
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
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:10: KEYWORD_22
                {
                mKEYWORD_22(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:21: KEYWORD_20
                {
                mKEYWORD_20(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:32: KEYWORD_21
                {
                mKEYWORD_21(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:43: KEYWORD_19
                {
                mKEYWORD_19(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:54: KEYWORD_14
                {
                mKEYWORD_14(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:65: KEYWORD_15
                {
                mKEYWORD_15(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:76: KEYWORD_16
                {
                mKEYWORD_16(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:87: KEYWORD_17
                {
                mKEYWORD_17(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:98: KEYWORD_18
                {
                mKEYWORD_18(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:109: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:119: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:129: KEYWORD_3
                {
                mKEYWORD_3(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:139: KEYWORD_4
                {
                mKEYWORD_4(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:149: KEYWORD_5
                {
                mKEYWORD_5(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:159: KEYWORD_6
                {
                mKEYWORD_6(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:169: KEYWORD_7
                {
                mKEYWORD_7(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:179: KEYWORD_8
                {
                mKEYWORD_8(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:189: KEYWORD_9
                {
                mKEYWORD_9(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:199: KEYWORD_10
                {
                mKEYWORD_10(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:210: KEYWORD_11
                {
                mKEYWORD_11(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:221: KEYWORD_12
                {
                mKEYWORD_12(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:232: KEYWORD_13
                {
                mKEYWORD_13(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:243: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:251: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:260: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:272: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:288: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:304: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/unorderedGroups/parser/antlr/lexer/InternalExUnorderedGroupsTestLanguage.g:1:312: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        int LA12_1 = input.LA(2);

        if ( (LA12_1=='e') ) {
            int LA12_24 = input.LA(3);

            if ( (LA12_24=='r') ) {
                int LA12_52 = input.LA(4);

                if ( (LA12_52=='i') ) {
                    int LA12_61 = input.LA(5);

                    if ( (LA12_61=='a') ) {
                        int LA12_65 = input.LA(6);

                        if ( (LA12_65=='l') ) {
                            int LA12_69 = input.LA(7);

                            if ( (LA12_69=='i') ) {
                                int LA12_73 = input.LA(8);

                                if ( (LA12_73=='z') ) {
                                    int LA12_77 = input.LA(9);

                                    if ( (LA12_77=='a') ) {
                                        int LA12_80 = input.LA(10);

                                        if ( (LA12_80=='t') ) {
                                            int LA12_83 = input.LA(11);

                                            if ( (LA12_83=='i') ) {
                                                int LA12_86 = input.LA(12);

                                                if ( (LA12_86=='o') ) {
                                                    int LA12_87 = input.LA(13);

                                                    if ( (LA12_87=='n') ) {
                                                        int LA12_88 = input.LA(14);

                                                        if ( ((LA12_88>='0' && LA12_88<='9')||(LA12_88>='A' && LA12_88<='Z')||LA12_88=='_'||(LA12_88>='a' && LA12_88<='z')) ) {
                                                            return 23;
                                                        }
                                                        else {
                                                            return 1;}
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

    private int mTokensHelper002() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'u':
            {
            int LA12_26 = input.LA(3);

            if ( (LA12_26=='g') ) {
                int LA12_53 = input.LA(4);

                if ( (LA12_53=='3') ) {
                    int LA12_62 = input.LA(5);

                    if ( (LA12_62=='0') ) {
                        int LA12_66 = input.LA(6);

                        if ( (LA12_66=='2') ) {
                            int LA12_70 = input.LA(7);

                            if ( (LA12_70=='5') ) {
                                int LA12_74 = input.LA(8);

                                if ( (LA12_74=='8') ) {
                                    int LA12_78 = input.LA(9);

                                    if ( (LA12_78=='5') ) {
                                        int LA12_81 = input.LA(10);

                                        if ( ((LA12_81>='0' && LA12_81<='9')||(LA12_81>='A' && LA12_81<='Z')||LA12_81=='_'||(LA12_81>='a' && LA12_81<='z')) ) {
                                            return 23;
                                        }
                                        else {
                                            return 2;}
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
            return 20;}

    }

    private int mTokensHelper003() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA12_28 = input.LA(3);

            if ( (LA12_28=='t') ) {
                int LA12_54 = input.LA(4);

                if ( (LA12_54=='a') ) {
                    int LA12_63 = input.LA(5);

                    if ( (LA12_63=='t') ) {
                        int LA12_67 = input.LA(6);

                        if ( (LA12_67=='y') ) {
                            int LA12_71 = input.LA(7);

                            if ( (LA12_71=='p') ) {
                                int LA12_75 = input.LA(8);

                                if ( (LA12_75=='e') ) {
                                    int LA12_79 = input.LA(9);

                                    if ( (LA12_79=='s') ) {
                                        int LA12_82 = input.LA(10);

                                        if ( ((LA12_82>='0' && LA12_82<='9')||(LA12_82>='A' && LA12_82<='Z')||LA12_82=='_'||(LA12_82>='a' && LA12_82<='z')) ) {
                                            return 23;
                                        }
                                        else {
                                            return 3;}
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
            return 22;}

    }

    private int mTokensHelper004() throws RecognitionException {
        int LA12_4 = input.LA(2);

        if ( (LA12_4=='e') ) {
            int LA12_30 = input.LA(3);

            if ( (LA12_30=='s') ) {
                int LA12_55 = input.LA(4);

                if ( (LA12_55=='t') ) {
                    int LA12_64 = input.LA(5);

                    if ( (LA12_64=='e') ) {
                        int LA12_68 = input.LA(6);

                        if ( (LA12_68=='d') ) {
                            int LA12_72 = input.LA(7);

                            if ( ((LA12_72>='0' && LA12_72<='9')||(LA12_72>='A' && LA12_72<='Z')||LA12_72=='_'||(LA12_72>='a' && LA12_72<='z')) ) {
                                return 23;
                            }
                            else {
                                return 4;}
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

    private int mTokensHelper005() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '3':
            {
            int LA12_31 = input.LA(3);

            if ( ((LA12_31>='0' && LA12_31<='9')) ) {
                return 24;
            }
            else {
                return 8;}
            }
        case '2':
            {
            int LA12_32 = input.LA(3);

            if ( ((LA12_32>='0' && LA12_32<='9')) ) {
                return 24;
            }
            else {
                return 7;}
            }
        case '4':
            {
            int LA12_33 = input.LA(3);

            if ( ((LA12_33>='0' && LA12_33<='9')) ) {
                return 24;
            }
            else {
                return 9;}
            }
        case '1':
            {
            int LA12_34 = input.LA(3);

            if ( ((LA12_34>='0' && LA12_34<='9')) ) {
                return 24;
            }
            else {
                return 6;}
            }
        case '0':
            {
            int LA12_35 = input.LA(3);

            if ( ((LA12_35>='0' && LA12_35<='9')) ) {
                return 24;
            }
            else {
                return 5;}
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
            return 10;}

    }

    private int mTokensHelper006() throws RecognitionException {
        int LA12_6 = input.LA(2);

        if ( ((LA12_6>='0' && LA12_6<='9')) ) {
            return 24;
        }
        else {
            return 11;}
    }

    private int mTokensHelper007() throws RecognitionException {
        int LA12_7 = input.LA(2);

        if ( ((LA12_7>='0' && LA12_7<='9')) ) {
            return 24;
        }
        else {
            return 12;}
    }

    private int mTokensHelper008() throws RecognitionException {
        int LA12_8 = input.LA(2);

        if ( ((LA12_8>='0' && LA12_8<='9')) ) {
            return 24;
        }
        else {
            return 13;}
    }

    private int mTokensHelper009() throws RecognitionException {
        int LA12_9 = input.LA(2);

        if ( ((LA12_9>='0' && LA12_9<='9')) ) {
            return 24;
        }
        else {
            return 14;}
    }

    private int mTokensHelper010() throws RecognitionException {
        int LA12_10 = input.LA(2);

        if ( ((LA12_10>='0' && LA12_10<='9')) ) {
            return 24;
        }
        else {
            return 15;}
    }

    private int mTokensHelper011() throws RecognitionException {
        int LA12_11 = input.LA(2);

        if ( ((LA12_11>='0' && LA12_11<='9')) ) {
            return 24;
        }
        else {
            return 16;}
    }

    private int mTokensHelper012() throws RecognitionException {
        int LA12_12 = input.LA(2);

        if ( ((LA12_12>='0' && LA12_12<='9')) ) {
            return 24;
        }
        else {
            return 17;}
    }

    private int mTokensHelper013() throws RecognitionException {
        int LA12_13 = input.LA(2);

        if ( ((LA12_13>='0' && LA12_13<='9')) ) {
            return 24;
        }
        else {
            return 18;}
    }

    private int mTokensHelper014() throws RecognitionException {
        int LA12_14 = input.LA(2);

        if ( ((LA12_14>='0' && LA12_14<='9')||(LA12_14>='A' && LA12_14<='Z')||LA12_14=='_'||(LA12_14>='a' && LA12_14<='z')) ) {
            return 23;
        }
        else {
            return 19;}
    }

    private int mTokensHelper015() throws RecognitionException {
        int LA12_15 = input.LA(2);

        if ( ((LA12_15>='0' && LA12_15<='9')||(LA12_15>='A' && LA12_15<='Z')||LA12_15=='_'||(LA12_15>='a' && LA12_15<='z')) ) {
            return 23;
        }
        else {
            return 21;}
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
            new NoViableAltException("1:1: Tokens : ( KEYWORD_22 | KEYWORD_20 | KEYWORD_21 | KEYWORD_19 | KEYWORD_14 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_18 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}