package org.eclipse.xtext.lexer.idea.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBacktrackingLexerTestLanguageLexer extends Lexer {
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int FRAGMENT_RULE_CHARY=18;
    public static final int FRAGMENT_RULE_CHARA=14;
    public static final int FRAGMENT_RULE_CHARX=16;
    public static final int RULE_CHARY=10;
    public static final int Abc=4;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=13;
    public static final int FRAGMENT_RULE_YC=17;
    public static final int FRAGMENT_RULE_CHARB=15;
    public static final int RULE_CHARX=8;
    public static final int FRAGMENT_RULE_SL_COMMENT=20;
    public static final int Efg=5;
    public static final int RULE_YC=9;
    public static final int FRAGMENT_RULE_WS=19;
    public static final int RULE_WS=12;
    public static final int RULE_CHARA=6;
    public static final int RULE_CHARB=7;
    public static final int RULE_CHARC=11;

    // delegates
    // delegators

    public PsiInternalBacktrackingLexerTestLanguageLexer() {;} 
    public PsiInternalBacktrackingLexerTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PsiInternalBacktrackingLexerTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "PsiInternalBacktrackingLexerTestLanguage.g"; }

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalBacktrackingLexerTestLanguage.g:11:7: ( 'Abc' )
            // PsiInternalBacktrackingLexerTestLanguage.g:11:9: 'Abc'
            {
            match("Abc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // PsiInternalBacktrackingLexerTestLanguage.g:12:7: ( 'Efg' )
            // PsiInternalBacktrackingLexerTestLanguage.g:12:9: 'Efg'
            {
            match("Efg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "RULE_CHARA"
    public final void mRULE_CHARA() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:302:21: ( FRAGMENT_RULE_CHARA )
            // PsiInternalBacktrackingLexerTestLanguage.g:302:23: FRAGMENT_RULE_CHARA
            {
            mFRAGMENT_RULE_CHARA(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARA"

    // $ANTLR start "FRAGMENT_RULE_CHARA"
    public final void mFRAGMENT_RULE_CHARA() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:303:30: ( 'A' )
            // PsiInternalBacktrackingLexerTestLanguage.g:303:32: 'A'
            {
            match('A'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHARA"

    // $ANTLR start "RULE_CHARB"
    public final void mRULE_CHARB() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:305:21: ( FRAGMENT_RULE_CHARB )
            // PsiInternalBacktrackingLexerTestLanguage.g:305:23: FRAGMENT_RULE_CHARB
            {
            mFRAGMENT_RULE_CHARB(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARB"

    // $ANTLR start "FRAGMENT_RULE_CHARB"
    public final void mFRAGMENT_RULE_CHARB() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:306:30: ( 'b' )
            // PsiInternalBacktrackingLexerTestLanguage.g:306:32: 'b'
            {
            match('b'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHARB"

    // $ANTLR start "RULE_CHARX"
    public final void mRULE_CHARX() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:308:21: ( FRAGMENT_RULE_CHARX )
            // PsiInternalBacktrackingLexerTestLanguage.g:308:23: FRAGMENT_RULE_CHARX
            {
            mFRAGMENT_RULE_CHARX(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARX"

    // $ANTLR start "FRAGMENT_RULE_CHARX"
    public final void mFRAGMENT_RULE_CHARX() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:309:30: ( 'X' )
            // PsiInternalBacktrackingLexerTestLanguage.g:309:32: 'X'
            {
            match('X'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHARX"

    // $ANTLR start "RULE_YC"
    public final void mRULE_YC() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:311:18: ( FRAGMENT_RULE_YC )
            // PsiInternalBacktrackingLexerTestLanguage.g:311:20: FRAGMENT_RULE_YC
            {
            mFRAGMENT_RULE_YC(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_YC"

    // $ANTLR start "FRAGMENT_RULE_YC"
    public final void mFRAGMENT_RULE_YC() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:312:27: ( RULE_CHARY RULE_CHARC )
            // PsiInternalBacktrackingLexerTestLanguage.g:312:29: RULE_CHARY RULE_CHARC
            {
            mRULE_CHARY(); 
            mRULE_CHARC(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "FRAGMENT_RULE_YC"

    // $ANTLR start "RULE_CHARY"
    public final void mRULE_CHARY() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:314:21: ( FRAGMENT_RULE_CHARY )
            // PsiInternalBacktrackingLexerTestLanguage.g:314:23: FRAGMENT_RULE_CHARY
            {
            mFRAGMENT_RULE_CHARY(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARY"

    // $ANTLR start "FRAGMENT_RULE_CHARY"
    public final void mFRAGMENT_RULE_CHARY() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:315:30: ( 'Y' )
            // PsiInternalBacktrackingLexerTestLanguage.g:315:32: 'Y'
            {
            match('Y'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHARY"

    // $ANTLR start "RULE_CHARC"
    public final void mRULE_CHARC() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:317:21: ( 'c' )
            // PsiInternalBacktrackingLexerTestLanguage.g:317:23: 'c'
            {
            match('c'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARC"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:319:18: ( FRAGMENT_RULE_WS )
            // PsiInternalBacktrackingLexerTestLanguage.g:319:20: FRAGMENT_RULE_WS
            {
            mFRAGMENT_RULE_WS(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "FRAGMENT_RULE_WS"
    public final void mFRAGMENT_RULE_WS() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:320:27: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // PsiInternalBacktrackingLexerTestLanguage.g:320:29: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:320:29: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // PsiInternalBacktrackingLexerTestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

        }
        finally {
        }
    }
    // $ANTLR end "FRAGMENT_RULE_WS"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:322:26: ( FRAGMENT_RULE_SL_COMMENT )
            // PsiInternalBacktrackingLexerTestLanguage.g:322:28: FRAGMENT_RULE_SL_COMMENT
            {
            mFRAGMENT_RULE_SL_COMMENT(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "FRAGMENT_RULE_SL_COMMENT"
    public final void mFRAGMENT_RULE_SL_COMMENT() throws RecognitionException {
        try {
            // PsiInternalBacktrackingLexerTestLanguage.g:323:35: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // PsiInternalBacktrackingLexerTestLanguage.g:323:37: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // PsiInternalBacktrackingLexerTestLanguage.g:323:42: (~ ( ( '\\n' | '\\r' ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalBacktrackingLexerTestLanguage.g:323:42: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // PsiInternalBacktrackingLexerTestLanguage.g:323:58: ( ( '\\r' )? '\\n' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\n'||LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalBacktrackingLexerTestLanguage.g:323:59: ( '\\r' )? '\\n'
                    {
                    // PsiInternalBacktrackingLexerTestLanguage.g:323:59: ( '\\r' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // PsiInternalBacktrackingLexerTestLanguage.g:323:59: '\\r'
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

        }
        finally {
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SL_COMMENT"

    public void mTokens() throws RecognitionException {
        // PsiInternalBacktrackingLexerTestLanguage.g:1:8: ( T__21 | T__22 )
        int alt5=2;
        int LA5_0 = input.LA(1);

        if ( (LA5_0=='A') ) {
            alt5 = mTokensHelper001();
        }
        else if ( (LA5_0=='E') ) {
            alt5 = mTokensHelper002();
        }
        else {
            alt5 = mTokensHelper003();
        }
        switch (alt5) {
            case 1 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:10: T__21
                {
                mT__21(); 

                }
                break;
            case 2 :
                // PsiInternalBacktrackingLexerTestLanguage.g:1:16: T__22
                {
                mT__22(); 

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
        NoViableAltException nvae =
            new NoViableAltException("", 5, 0, input);

        throw nvae;
    }



 

}