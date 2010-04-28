package org.eclipse.xtext.parser.antlr.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug301935ExTestLanguageLexer extends Lexer {
    public static final int RULE_ID=6;
    public static final int RULE_ANY_OTHER=8;
    public static final int KEYWORD_1=4;
    public static final int KEYWORD_2=5;
    public static final int RULE_WS=7;
    public static final int Tokens=9;
    public static final int EOF=-1;
    public InternalBug301935ExTestLanguageLexer() {;} 
    public InternalBug301935ExTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g"; }

    // $ANTLR start KEYWORD_1
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:19:11: ( '\\n' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:19:13: '\\n'
            {
            match('\n'); 

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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:21:11: ( '\\r' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:21:13: '\\r'
            {
            match('\r'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_2

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:25:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:25:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:25:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:25:11: '^'
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:25:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:
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

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:27:9: ( ( ' ' | '\\t' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:27:11: ( ' ' | '\\t' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:27:11: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
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
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:29:16: ( . )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:29:18: .
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
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:1:8: ( KEYWORD_1 | KEYWORD_2 | RULE_ID | RULE_WS | RULE_ANY_OTHER )
        int alt4=5;
        int LA4_0 = input.LA(1);

        if ( (LA4_0=='\n') ) {
            alt4 = mTokensHelper001();
        }
        else if ( (LA4_0=='\r') ) {
            alt4 = mTokensHelper002();
        }
        else if ( (LA4_0=='^') ) {
            alt4 = mTokensHelper003();
        }
        else if ( ((LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
            alt4 = mTokensHelper004();
        }
        else if ( (LA4_0=='\t'||LA4_0==' ') ) {
            alt4 = mTokensHelper005();
        }
        else if ( ((LA4_0>='\u0000' && LA4_0<='\b')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\u001F')||(LA4_0>='!' && LA4_0<='@')||(LA4_0>='[' && LA4_0<=']')||LA4_0=='`'||(LA4_0>='{' && LA4_0<='\uFFFE')) ) {
            alt4 = mTokensHelper006();
        }
        else {
            alt4 = mTokensHelper007();
        }
        switch (alt4) {
            case 1 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:1:10: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:1:20: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:1:30: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:1:38: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/lexer/InternalBug301935ExTestLanguage.g:1:46: RULE_ANY_OTHER
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
        return 2;
    }

    private int mTokensHelper003() throws RecognitionException {
        int LA4_3 = input.LA(2);

        if ( ((LA4_3>='A' && LA4_3<='Z')||LA4_3=='_'||(LA4_3>='a' && LA4_3<='z')) ) {
            return 3;
        }
        else {
            return 5;}
    }

    private int mTokensHelper004() throws RecognitionException {
        return 3;
    }

    private int mTokensHelper005() throws RecognitionException {
        return 4;
    }

    private int mTokensHelper006() throws RecognitionException {
        return 5;
    }

    private int mTokensHelper007() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( KEYWORD_1 | KEYWORD_2 | RULE_ID | RULE_WS | RULE_ANY_OTHER );", 4, 0, input);

        throw nvae;
    }



 

}