package org.eclipse.xtext.lexer.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalBacktrackingLexerTestLanguageLexer extends Lexer {
    public static final int FRAGMENT_RULE_CHARA=6;
    public static final int FRAGMENT_RULE_CHARX=8;
    public static final int FRAGMENT_RULE_SL_COMMENT=10;
    public static final int KEYWORD_1=12;
    public static final int KEYWORD_2=13;
    public static final int RULE_CHARA=14;
    public static final int RULE_CHARX=16;
    public static final int FRAGMENT_KEYWORD_2=5;
    public static final int RULE_WS=17;
    public static final int EOF=-1;
    public static final int Tokens=19;
    public static final int SYNTHETIC_ALL_KEYWORDS=11;
    public static final int RULE_SL_COMMENT=18;
    public static final int FRAGMENT_KEYWORD_1=4;
    public static final int FRAGMENT_RULE_CHARB=7;
    public static final int RULE_CHARB=15;
    public static final int FRAGMENT_RULE_WS=9;
    public InternalBacktrackingLexerTestLanguageLexer() {;} 
    public InternalBacktrackingLexerTestLanguageLexer(CharStream input) {
        super(input);
        ruleMemo = new HashMap[32+1];
     }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g"; }

    // $ANTLR start SYNTHETIC_ALL_KEYWORDS
    public final void mSYNTHETIC_ALL_KEYWORDS() throws RecognitionException {
        int SYNTHETIC_ALL_KEYWORDS_StartIndex = input.index();
        try {
            int _type = SYNTHETIC_ALL_KEYWORDS;
            if ( backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:22:24: ( ( FRAGMENT_KEYWORD_1 )=> FRAGMENT_KEYWORD_1 | ( FRAGMENT_KEYWORD_2 )=> FRAGMENT_KEYWORD_2 | ( FRAGMENT_RULE_CHARA )=> FRAGMENT_RULE_CHARA | ( FRAGMENT_RULE_CHARB )=> FRAGMENT_RULE_CHARB | ( FRAGMENT_RULE_CHARX )=> FRAGMENT_RULE_CHARX | ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS | ( FRAGMENT_RULE_SL_COMMENT )=> FRAGMENT_RULE_SL_COMMENT )
            int alt1=7;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='A') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='b') && (synpred1())) {
                    alt1=1;
                }
                else {
                    alt1=3;}
            }
            else if ( (LA1_0=='E') && (synpred2())) {
                alt1=2;
            }
            else if ( (LA1_0=='b') && (synpred4())) {
                alt1=4;
            }
            else if ( (LA1_0=='X') && (synpred5())) {
                alt1=5;
            }
            else if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') && (synpred6())) {
                alt1=6;
            }
            else if ( (LA1_0=='/') && (synpred7())) {
                alt1=7;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("22:1: SYNTHETIC_ALL_KEYWORDS : ( ( FRAGMENT_KEYWORD_1 )=> FRAGMENT_KEYWORD_1 | ( FRAGMENT_KEYWORD_2 )=> FRAGMENT_KEYWORD_2 | ( FRAGMENT_RULE_CHARA )=> FRAGMENT_RULE_CHARA | ( FRAGMENT_RULE_CHARB )=> FRAGMENT_RULE_CHARB | ( FRAGMENT_RULE_CHARX )=> FRAGMENT_RULE_CHARX | ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS | ( FRAGMENT_RULE_SL_COMMENT )=> FRAGMENT_RULE_SL_COMMENT );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:24:2: ( FRAGMENT_KEYWORD_1 )=> FRAGMENT_KEYWORD_1
                    {
                    mFRAGMENT_KEYWORD_1(); if (failed) return ;
                    if ( backtracking==0 ) {
                      _type = KEYWORD_1; 
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:26:2: ( FRAGMENT_KEYWORD_2 )=> FRAGMENT_KEYWORD_2
                    {
                    mFRAGMENT_KEYWORD_2(); if (failed) return ;
                    if ( backtracking==0 ) {
                      _type = KEYWORD_2; 
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:27:2: ( FRAGMENT_RULE_CHARA )=> FRAGMENT_RULE_CHARA
                    {
                    mFRAGMENT_RULE_CHARA(); if (failed) return ;
                    if ( backtracking==0 ) {
                      _type = RULE_CHARA; 
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:28:2: ( FRAGMENT_RULE_CHARB )=> FRAGMENT_RULE_CHARB
                    {
                    mFRAGMENT_RULE_CHARB(); if (failed) return ;
                    if ( backtracking==0 ) {
                      _type = RULE_CHARB; 
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:29:2: ( FRAGMENT_RULE_CHARX )=> FRAGMENT_RULE_CHARX
                    {
                    mFRAGMENT_RULE_CHARX(); if (failed) return ;
                    if ( backtracking==0 ) {
                      _type = RULE_CHARX; 
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:30:2: ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS
                    {
                    mFRAGMENT_RULE_WS(); if (failed) return ;
                    if ( backtracking==0 ) {
                      _type = RULE_WS; 
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:31:2: ( FRAGMENT_RULE_SL_COMMENT )=> FRAGMENT_RULE_SL_COMMENT
                    {
                    mFRAGMENT_RULE_SL_COMMENT(); if (failed) return ;
                    if ( backtracking==0 ) {
                      _type = RULE_SL_COMMENT; 
                    }

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 1, SYNTHETIC_ALL_KEYWORDS_StartIndex); }
        }
    }
    // $ANTLR end SYNTHETIC_ALL_KEYWORDS

    // $ANTLR start KEYWORD_1
    public final void mKEYWORD_1() throws RecognitionException {
        int KEYWORD_1_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:33:20: ( 'Abc' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:33:22: 'Abc'
            {
            match("Abc"); if (failed) return ;


            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 2, KEYWORD_1_StartIndex); }
        }
    }
    // $ANTLR end KEYWORD_1

    // $ANTLR start FRAGMENT_KEYWORD_1
    public final void mFRAGMENT_KEYWORD_1() throws RecognitionException {
        int FRAGMENT_KEYWORD_1_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:34:29: ( 'Abc' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:34:31: 'Abc'
            {
            match("Abc"); if (failed) return ;


            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 3, FRAGMENT_KEYWORD_1_StartIndex); }
        }
    }
    // $ANTLR end FRAGMENT_KEYWORD_1

    // $ANTLR start KEYWORD_2
    public final void mKEYWORD_2() throws RecognitionException {
        int KEYWORD_2_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:36:20: ( 'Efg' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:36:22: 'Efg'
            {
            match("Efg"); if (failed) return ;


            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 4, KEYWORD_2_StartIndex); }
        }
    }
    // $ANTLR end KEYWORD_2

    // $ANTLR start FRAGMENT_KEYWORD_2
    public final void mFRAGMENT_KEYWORD_2() throws RecognitionException {
        int FRAGMENT_KEYWORD_2_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:37:29: ( 'Efg' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:37:31: 'Efg'
            {
            match("Efg"); if (failed) return ;


            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 5, FRAGMENT_KEYWORD_2_StartIndex); }
        }
    }
    // $ANTLR end FRAGMENT_KEYWORD_2

    // $ANTLR start RULE_CHARA
    public final void mRULE_CHARA() throws RecognitionException {
        int RULE_CHARA_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:41:21: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:41:23: 
            {
            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 6, RULE_CHARA_StartIndex); }
        }
    }
    // $ANTLR end RULE_CHARA

    // $ANTLR start FRAGMENT_RULE_CHARA
    public final void mFRAGMENT_RULE_CHARA() throws RecognitionException {
        int FRAGMENT_RULE_CHARA_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:42:30: ( 'A' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:42:32: 'A'
            {
            match('A'); if (failed) return ;

            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 7, FRAGMENT_RULE_CHARA_StartIndex); }
        }
    }
    // $ANTLR end FRAGMENT_RULE_CHARA

    // $ANTLR start RULE_CHARB
    public final void mRULE_CHARB() throws RecognitionException {
        int RULE_CHARB_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:44:21: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:44:23: 
            {
            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 8, RULE_CHARB_StartIndex); }
        }
    }
    // $ANTLR end RULE_CHARB

    // $ANTLR start FRAGMENT_RULE_CHARB
    public final void mFRAGMENT_RULE_CHARB() throws RecognitionException {
        int FRAGMENT_RULE_CHARB_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:45:30: ( 'b' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:45:32: 'b'
            {
            match('b'); if (failed) return ;

            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 9, FRAGMENT_RULE_CHARB_StartIndex); }
        }
    }
    // $ANTLR end FRAGMENT_RULE_CHARB

    // $ANTLR start RULE_CHARX
    public final void mRULE_CHARX() throws RecognitionException {
        int RULE_CHARX_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:47:21: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:47:23: 
            {
            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 10, RULE_CHARX_StartIndex); }
        }
    }
    // $ANTLR end RULE_CHARX

    // $ANTLR start FRAGMENT_RULE_CHARX
    public final void mFRAGMENT_RULE_CHARX() throws RecognitionException {
        int FRAGMENT_RULE_CHARX_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:48:30: ( 'X' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:48:32: 'X'
            {
            match('X'); if (failed) return ;

            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 11, FRAGMENT_RULE_CHARX_StartIndex); }
        }
    }
    // $ANTLR end FRAGMENT_RULE_CHARX

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        int RULE_WS_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:50:18: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:50:20: 
            {
            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 12, RULE_WS_StartIndex); }
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start FRAGMENT_RULE_WS
    public final void mFRAGMENT_RULE_WS() throws RecognitionException {
        int FRAGMENT_RULE_WS_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:51:27: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:51:29: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:51:29: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\t' && LA2_0<='\n')||LA2_0=='\r'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 13, FRAGMENT_RULE_WS_StartIndex); }
        }
    }
    // $ANTLR end FRAGMENT_RULE_WS

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        int RULE_SL_COMMENT_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:53:26: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:53:28: 
            {
            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 14, RULE_SL_COMMENT_StartIndex); }
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start FRAGMENT_RULE_SL_COMMENT
    public final void mFRAGMENT_RULE_SL_COMMENT() throws RecognitionException {
        int FRAGMENT_RULE_SL_COMMENT_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:54:35: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:54:37: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); if (failed) return ;

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:54:42: (~ ( ( '\\n' | '\\r' ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFE')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:0:0: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:54:58: ( ( '\\r' )? '\\n' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\n'||LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:54:59: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:54:59: ( '\\r' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\r') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:0:0: '\\r'
                            {
                            match('\r'); if (failed) return ;

                            }
                            break;

                    }

                    match('\n'); if (failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( backtracking>0 ) { memoize(input, 15, FRAGMENT_RULE_SL_COMMENT_StartIndex); }
        }
    }
    // $ANTLR end FRAGMENT_RULE_SL_COMMENT

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:1:8: ( SYNTHETIC_ALL_KEYWORDS )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:1:10: SYNTHETIC_ALL_KEYWORDS
        {
        mSYNTHETIC_ALL_KEYWORDS(); if (failed) return ;

        }


    }

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:24:2: ( FRAGMENT_KEYWORD_1 )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:24:3: FRAGMENT_KEYWORD_1
        {
        mFRAGMENT_KEYWORD_1(); if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:26:2: ( FRAGMENT_KEYWORD_2 )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:26:3: FRAGMENT_KEYWORD_2
        {
        mFRAGMENT_KEYWORD_2(); if (failed) return ;

        }
    }
    // $ANTLR end synpred2

    // $ANTLR start synpred3
    public final void synpred3_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:27:2: ( FRAGMENT_RULE_CHARA )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:27:3: FRAGMENT_RULE_CHARA
        {
        mFRAGMENT_RULE_CHARA(); if (failed) return ;

        }
    }
    // $ANTLR end synpred3

    // $ANTLR start synpred4
    public final void synpred4_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:28:2: ( FRAGMENT_RULE_CHARB )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:28:3: FRAGMENT_RULE_CHARB
        {
        mFRAGMENT_RULE_CHARB(); if (failed) return ;

        }
    }
    // $ANTLR end synpred4

    // $ANTLR start synpred5
    public final void synpred5_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:29:2: ( FRAGMENT_RULE_CHARX )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:29:3: FRAGMENT_RULE_CHARX
        {
        mFRAGMENT_RULE_CHARX(); if (failed) return ;

        }
    }
    // $ANTLR end synpred5

    // $ANTLR start synpred6
    public final void synpred6_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:30:2: ( FRAGMENT_RULE_WS )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:30:3: FRAGMENT_RULE_WS
        {
        mFRAGMENT_RULE_WS(); if (failed) return ;

        }
    }
    // $ANTLR end synpred6

    // $ANTLR start synpred7
    public final void synpred7_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:31:2: ( FRAGMENT_RULE_SL_COMMENT )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/lexer/InternalBacktrackingLexerTestLanguage.g:31:3: FRAGMENT_RULE_SL_COMMENT
        {
        mFRAGMENT_RULE_SL_COMMENT(); if (failed) return ;

        }
    }
    // $ANTLR end synpred7

    public final boolean synpred4() {
        backtracking++;
        int start = input.mark();
        try {
            synpred4_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred7() {
        backtracking++;
        int start = input.mark();
        try {
            synpred7_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred3() {
        backtracking++;
        int start = input.mark();
        try {
            synpred3_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred5() {
        backtracking++;
        int start = input.mark();
        try {
            synpred5_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred6() {
        backtracking++;
        int start = input.mark();
        try {
            synpred6_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

}