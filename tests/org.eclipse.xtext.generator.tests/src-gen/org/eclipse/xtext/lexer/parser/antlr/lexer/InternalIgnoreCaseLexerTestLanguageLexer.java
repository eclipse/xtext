package org.eclipse.xtext.lexer.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalIgnoreCaseLexerTestLanguageLexer extends Lexer {
    public static final int RULE_WS=6;
    public static final int KEYWORD_1=5;
    public static final int EOF=-1;
    public static final int Tokens=8;
    public static final int KEYWORD_2=4;
    public static final int RULE_SL_COMMENT=7;
    public InternalIgnoreCaseLexerTestLanguageLexer() {;} 
    public InternalIgnoreCaseLexerTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g"; }

    // $ANTLR start KEYWORD_2
    public final void mKEYWORD_2() throws RecognitionException {
        try {
            int _type = KEYWORD_2;
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:19:11: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:19:13: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_2

    // $ANTLR start KEYWORD_1
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:21:11: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'O' | 'o' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:21:13: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'O' | 'o' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end KEYWORD_1

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:25:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:25:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:25:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:
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
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:27:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:27:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:27:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFE')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:27:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:27:40: ( ( '\\r' )? '\\n' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\n'||LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:27:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:27:41: ( '\\r' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:27:41: '\\r'
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

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:1:8: ( KEYWORD_2 | KEYWORD_1 | RULE_WS | RULE_SL_COMMENT )
        int alt5=4;
        switch ( input.LA(1) ) {
        case 'C':
        case 'c':
            {
            alt5=1;
            }
            break;
        case 'F':
        case 'f':
            {
            alt5=2;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt5=3;
            }
            break;
        case '/':
            {
            alt5=4;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( KEYWORD_2 | KEYWORD_1 | RULE_WS | RULE_SL_COMMENT );", 5, 0, input);

            throw nvae;
        }

        switch (alt5) {
            case 1 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:1:10: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:1:20: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:1:30: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalIgnoreCaseLexerTestLanguage.g:1:38: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


 

}