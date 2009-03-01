package org.eclipse.xtext.testlanguages.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLexerTestLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int Tokens=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public InternalLexerTestLanguageLexer() {;} 
    public InternalLexerTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g"; }

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:193:9: ( ( '^' )? ( ( 'a' .. 'z' | 'A' .. 'Z' ) | '_' ) ( ( ( 'a' .. 'z' | 'A' .. 'Z' ) | '_' ) | '0' .. '9' )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:193:11: ( '^' )? ( ( 'a' .. 'z' | 'A' .. 'Z' ) | '_' ) ( ( ( 'a' .. 'z' | 'A' .. 'Z' ) | '_' ) | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:193:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:193:11: '^'
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:193:42: ( ( ( 'a' .. 'z' | 'A' .. 'Z' ) | '_' ) | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:197:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:197:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:197:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:197:13: '0' .. '9'
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

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:201:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:201:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:201:24: ( options {greedy=false; } : . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='*') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='/') ) {
                        alt4=2;
                    }
                    else if ( ((LA4_1>='\u0000' && LA4_1<='.')||(LA4_1>='0' && LA4_1<='\uFFFE')) ) {
                        alt4=1;
                    }


                }
                else if ( ((LA4_0>='\u0000' && LA4_0<=')')||(LA4_0>='+' && LA4_0<='\uFFFE')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:201:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:205:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:205:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:205:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\uFFFE')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:205:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop5;
                }
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:205:40: ( ( '\\r' )? '\\n' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\n'||LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:205:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:205:41: ( '\\r' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\r') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:205:41: '\\r'
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:209:9: ( ( ( ( ' ' | '\\t' ) | '\\r' ) | '\\n' )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:209:11: ( ( ( ' ' | '\\t' ) | '\\r' ) | '\\n' )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:209:11: ( ( ( ' ' | '\\t' ) | '\\r' ) | '\\n' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0=='\r'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:213:16: ( . )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:213:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:217:13: ( '#' ( 'B' )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:217:16: '#' ( 'B' )+
            {
            match('#'); 
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:217:20: ( 'B' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='B') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:217:21: 'B'
            	    {
            	    match('B'); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:1:8: ( RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER | RULE_STRING )
        int alt10=7;
        int LA10_0 = input.LA(1);

        if ( (LA10_0=='^') ) {
            int LA10_1 = input.LA(2);

            if ( ((LA10_1>='A' && LA10_1<='Z')||LA10_1=='_'||(LA10_1>='a' && LA10_1<='z')) ) {
                alt10=1;
            }
            else {
                alt10=6;}
        }
        else if ( ((LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
            alt10=1;
        }
        else if ( ((LA10_0>='0' && LA10_0<='9')) ) {
            alt10=2;
        }
        else if ( (LA10_0=='/') ) {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt10=3;
                }
                break;
            case '/':
                {
                alt10=4;
                }
                break;
            default:
                alt10=6;}

        }
        else if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
            alt10=5;
        }
        else if ( (LA10_0=='#') ) {
            int LA10_6 = input.LA(2);

            if ( (LA10_6=='B') ) {
                alt10=7;
            }
            else {
                alt10=6;}
        }
        else if ( ((LA10_0>='\u0000' && LA10_0<='\b')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\u001F')||(LA10_0>='!' && LA10_0<='\"')||(LA10_0>='$' && LA10_0<='.')||(LA10_0>=':' && LA10_0<='@')||(LA10_0>='[' && LA10_0<=']')||LA10_0=='`'||(LA10_0>='{' && LA10_0<='\uFFFE')) ) {
            alt10=6;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER | RULE_STRING );", 10, 0, input);

            throw nvae;
        }
        switch (alt10) {
            case 1 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:1:10: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:1:18: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:1:27: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:1:43: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:1:59: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:1:67: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:1:82: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;

        }

    }


 

}