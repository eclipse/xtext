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
@SuppressWarnings("all")
public class InternalBacktrackingLexerTestLanguageLexer extends Lexer {
    public static final int FRAGMENT_Abc=14;
    public static final int FRAGMENT_RULE_CHARY=20;
    public static final int FRAGMENT_RULE_CHARA=16;
    public static final int FRAGMENT_RULE_CHARX=18;
    public static final int RULE_CHARY=10;
    public static final int Abc=4;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=13;
    public static final int FRAGMENT_RULE_YC=19;
    public static final int FRAGMENT_RULE_CHARC=21;
    public static final int FRAGMENT_RULE_CHARB=17;
    public static final int FRAGMENT_Efg=15;
    public static final int SYNTHETIC_ALL_KEYWORDS=24;
    public static final int RULE_CHARX=8;
    public static final int FRAGMENT_RULE_SL_COMMENT=23;
    public static final int Efg=5;
    public static final int RULE_YC=9;
    public static final int FRAGMENT_RULE_WS=22;
    public static final int RULE_CHARA=6;
    public static final int RULE_WS=12;
    public static final int RULE_CHARB=7;
    public static final int RULE_CHARC=11;

    // delegates
    // delegators

    public InternalBacktrackingLexerTestLanguageLexer() {;} 
    public InternalBacktrackingLexerTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBacktrackingLexerTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        state.ruleMemo = new HashMap[39+1];
 
    }
    public String getGrammarFileName() { return "InternalBacktrackingLexerTestLanguageLexer.g"; }

    // $ANTLR start "SYNTHETIC_ALL_KEYWORDS"
    public final void mSYNTHETIC_ALL_KEYWORDS() throws RecognitionException {
        int SYNTHETIC_ALL_KEYWORDS_StartIndex = input.index();
        try {
            int _type = SYNTHETIC_ALL_KEYWORDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:35:24: ( ( FRAGMENT_Abc )=> FRAGMENT_Abc | ( FRAGMENT_Efg )=> FRAGMENT_Efg | ( FRAGMENT_RULE_CHARA )=> FRAGMENT_RULE_CHARA | ( FRAGMENT_RULE_CHARB )=> FRAGMENT_RULE_CHARB | ( FRAGMENT_RULE_CHARX )=> FRAGMENT_RULE_CHARX | ( FRAGMENT_RULE_YC )=> FRAGMENT_RULE_YC | ( FRAGMENT_RULE_CHARY )=> FRAGMENT_RULE_CHARY | ( FRAGMENT_RULE_CHARC )=> FRAGMENT_RULE_CHARC | ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS | ( FRAGMENT_RULE_SL_COMMENT )=> FRAGMENT_RULE_SL_COMMENT )
            int alt1=10;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:36:2: ( FRAGMENT_Abc )=> FRAGMENT_Abc
                    {
                    mFRAGMENT_Abc(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = Abc; 
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:37:2: ( FRAGMENT_Efg )=> FRAGMENT_Efg
                    {
                    mFRAGMENT_Efg(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = Efg; 
                    }

                    }
                    break;
                case 3 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:38:2: ( FRAGMENT_RULE_CHARA )=> FRAGMENT_RULE_CHARA
                    {
                    mFRAGMENT_RULE_CHARA(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_CHARA; 
                    }

                    }
                    break;
                case 4 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:39:2: ( FRAGMENT_RULE_CHARB )=> FRAGMENT_RULE_CHARB
                    {
                    mFRAGMENT_RULE_CHARB(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_CHARB; 
                    }

                    }
                    break;
                case 5 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:40:2: ( FRAGMENT_RULE_CHARX )=> FRAGMENT_RULE_CHARX
                    {
                    mFRAGMENT_RULE_CHARX(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_CHARX; 
                    }

                    }
                    break;
                case 6 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:41:2: ( FRAGMENT_RULE_YC )=> FRAGMENT_RULE_YC
                    {
                    mFRAGMENT_RULE_YC(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_YC; 
                    }

                    }
                    break;
                case 7 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:42:2: ( FRAGMENT_RULE_CHARY )=> FRAGMENT_RULE_CHARY
                    {
                    mFRAGMENT_RULE_CHARY(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_CHARY; 
                    }

                    }
                    break;
                case 8 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:43:2: ( FRAGMENT_RULE_CHARC )=> FRAGMENT_RULE_CHARC
                    {
                    mFRAGMENT_RULE_CHARC(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_CHARC; 
                    }

                    }
                    break;
                case 9 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:44:2: ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS
                    {
                    mFRAGMENT_RULE_WS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_WS; 
                    }

                    }
                    break;
                case 10 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:45:2: ( FRAGMENT_RULE_SL_COMMENT )=> FRAGMENT_RULE_SL_COMMENT
                    {
                    mFRAGMENT_RULE_SL_COMMENT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SL_COMMENT; 
                    }

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, SYNTHETIC_ALL_KEYWORDS_StartIndex); }
        }
    }
    // $ANTLR end "SYNTHETIC_ALL_KEYWORDS"

    // $ANTLR start "FRAGMENT_Abc"
    public final void mFRAGMENT_Abc() throws RecognitionException {
        int FRAGMENT_Abc_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:47:23: ( 'Abc' )
            // InternalBacktrackingLexerTestLanguageLexer.g:47:25: 'Abc'
            {
            match("Abc"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, FRAGMENT_Abc_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_Abc"

    // $ANTLR start "FRAGMENT_Efg"
    public final void mFRAGMENT_Efg() throws RecognitionException {
        int FRAGMENT_Efg_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:49:23: ( 'Efg' )
            // InternalBacktrackingLexerTestLanguageLexer.g:49:25: 'Efg'
            {
            match("Efg"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, FRAGMENT_Efg_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_Efg"

    // $ANTLR start "RULE_CHARA"
    public final void mRULE_CHARA() throws RecognitionException {
        int RULE_CHARA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:54:21: ( FRAGMENT_RULE_CHARA )
            // InternalBacktrackingLexerTestLanguageLexer.g:54:23: FRAGMENT_RULE_CHARA
            {
            mFRAGMENT_RULE_CHARA(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, RULE_CHARA_StartIndex); }
        }
    }
    // $ANTLR end "RULE_CHARA"

    // $ANTLR start "FRAGMENT_RULE_CHARA"
    public final void mFRAGMENT_RULE_CHARA() throws RecognitionException {
        int FRAGMENT_RULE_CHARA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:55:30: ( 'A' )
            // InternalBacktrackingLexerTestLanguageLexer.g:55:32: 'A'
            {
            match('A'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, FRAGMENT_RULE_CHARA_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHARA"

    // $ANTLR start "RULE_CHARB"
    public final void mRULE_CHARB() throws RecognitionException {
        int RULE_CHARB_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:57:21: ( FRAGMENT_RULE_CHARB )
            // InternalBacktrackingLexerTestLanguageLexer.g:57:23: FRAGMENT_RULE_CHARB
            {
            mFRAGMENT_RULE_CHARB(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, RULE_CHARB_StartIndex); }
        }
    }
    // $ANTLR end "RULE_CHARB"

    // $ANTLR start "FRAGMENT_RULE_CHARB"
    public final void mFRAGMENT_RULE_CHARB() throws RecognitionException {
        int FRAGMENT_RULE_CHARB_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:58:30: ( 'b' )
            // InternalBacktrackingLexerTestLanguageLexer.g:58:32: 'b'
            {
            match('b'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, FRAGMENT_RULE_CHARB_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHARB"

    // $ANTLR start "RULE_CHARX"
    public final void mRULE_CHARX() throws RecognitionException {
        int RULE_CHARX_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:60:21: ( FRAGMENT_RULE_CHARX )
            // InternalBacktrackingLexerTestLanguageLexer.g:60:23: FRAGMENT_RULE_CHARX
            {
            mFRAGMENT_RULE_CHARX(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, RULE_CHARX_StartIndex); }
        }
    }
    // $ANTLR end "RULE_CHARX"

    // $ANTLR start "FRAGMENT_RULE_CHARX"
    public final void mFRAGMENT_RULE_CHARX() throws RecognitionException {
        int FRAGMENT_RULE_CHARX_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:61:30: ( 'X' )
            // InternalBacktrackingLexerTestLanguageLexer.g:61:32: 'X'
            {
            match('X'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, FRAGMENT_RULE_CHARX_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHARX"

    // $ANTLR start "RULE_YC"
    public final void mRULE_YC() throws RecognitionException {
        int RULE_YC_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:63:18: ( FRAGMENT_RULE_YC )
            // InternalBacktrackingLexerTestLanguageLexer.g:63:20: FRAGMENT_RULE_YC
            {
            mFRAGMENT_RULE_YC(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, RULE_YC_StartIndex); }
        }
    }
    // $ANTLR end "RULE_YC"

    // $ANTLR start "FRAGMENT_RULE_YC"
    public final void mFRAGMENT_RULE_YC() throws RecognitionException {
        int FRAGMENT_RULE_YC_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:64:27: ( RULE_CHARY RULE_CHARC )
            // InternalBacktrackingLexerTestLanguageLexer.g:64:29: RULE_CHARY RULE_CHARC
            {
            mRULE_CHARY(); if (state.failed) return ;
            mRULE_CHARC(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, FRAGMENT_RULE_YC_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_YC"

    // $ANTLR start "RULE_CHARY"
    public final void mRULE_CHARY() throws RecognitionException {
        int RULE_CHARY_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:66:21: ( FRAGMENT_RULE_CHARY )
            // InternalBacktrackingLexerTestLanguageLexer.g:66:23: FRAGMENT_RULE_CHARY
            {
            mFRAGMENT_RULE_CHARY(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, RULE_CHARY_StartIndex); }
        }
    }
    // $ANTLR end "RULE_CHARY"

    // $ANTLR start "FRAGMENT_RULE_CHARY"
    public final void mFRAGMENT_RULE_CHARY() throws RecognitionException {
        int FRAGMENT_RULE_CHARY_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:67:30: ( 'Y' )
            // InternalBacktrackingLexerTestLanguageLexer.g:67:32: 'Y'
            {
            match('Y'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, FRAGMENT_RULE_CHARY_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHARY"

    // $ANTLR start "RULE_CHARC"
    public final void mRULE_CHARC() throws RecognitionException {
        int RULE_CHARC_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:69:21: ( FRAGMENT_RULE_CHARC )
            // InternalBacktrackingLexerTestLanguageLexer.g:69:23: FRAGMENT_RULE_CHARC
            {
            mFRAGMENT_RULE_CHARC(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, RULE_CHARC_StartIndex); }
        }
    }
    // $ANTLR end "RULE_CHARC"

    // $ANTLR start "FRAGMENT_RULE_CHARC"
    public final void mFRAGMENT_RULE_CHARC() throws RecognitionException {
        int FRAGMENT_RULE_CHARC_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:70:30: ( 'c' )
            // InternalBacktrackingLexerTestLanguageLexer.g:70:32: 'c'
            {
            match('c'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, FRAGMENT_RULE_CHARC_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHARC"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        int RULE_WS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:72:18: ( FRAGMENT_RULE_WS )
            // InternalBacktrackingLexerTestLanguageLexer.g:72:20: FRAGMENT_RULE_WS
            {
            mFRAGMENT_RULE_WS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, RULE_WS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "FRAGMENT_RULE_WS"
    public final void mFRAGMENT_RULE_WS() throws RecognitionException {
        int FRAGMENT_RULE_WS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:73:27: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalBacktrackingLexerTestLanguageLexer.g:73:29: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalBacktrackingLexerTestLanguageLexer.g:73:29: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalBacktrackingLexerTestLanguageLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, FRAGMENT_RULE_WS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_WS"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        int RULE_SL_COMMENT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:75:26: ( FRAGMENT_RULE_SL_COMMENT )
            // InternalBacktrackingLexerTestLanguageLexer.g:75:28: FRAGMENT_RULE_SL_COMMENT
            {
            mFRAGMENT_RULE_SL_COMMENT(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, RULE_SL_COMMENT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "FRAGMENT_RULE_SL_COMMENT"
    public final void mFRAGMENT_RULE_SL_COMMENT() throws RecognitionException {
        int FRAGMENT_RULE_SL_COMMENT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }
            // InternalBacktrackingLexerTestLanguageLexer.g:76:35: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalBacktrackingLexerTestLanguageLexer.g:76:37: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); if (state.failed) return ;

            // InternalBacktrackingLexerTestLanguageLexer.g:76:42: (~ ( ( '\\n' | '\\r' ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBacktrackingLexerTestLanguageLexer.g:0:0: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalBacktrackingLexerTestLanguageLexer.g:76:58: ( ( '\\r' )? '\\n' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\n'||LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBacktrackingLexerTestLanguageLexer.g:76:59: ( '\\r' )? '\\n'
                    {
                    // InternalBacktrackingLexerTestLanguageLexer.g:76:59: ( '\\r' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\r') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalBacktrackingLexerTestLanguageLexer.g:0:0: '\\r'
                            {
                            match('\r'); if (state.failed) return ;

                            }
                            break;

                    }

                    match('\n'); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, FRAGMENT_RULE_SL_COMMENT_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SL_COMMENT"

    public void mTokens() throws RecognitionException {
        // InternalBacktrackingLexerTestLanguageLexer.g:1:8: ( SYNTHETIC_ALL_KEYWORDS )
        // InternalBacktrackingLexerTestLanguageLexer.g:1:10: SYNTHETIC_ALL_KEYWORDS
        {
        mSYNTHETIC_ALL_KEYWORDS(); if (state.failed) return ;

        }


    }

    // $ANTLR start synpred1_InternalBacktrackingLexerTestLanguageLexer
    public final void synpred1_InternalBacktrackingLexerTestLanguageLexer_fragment() throws RecognitionException {   
        // InternalBacktrackingLexerTestLanguageLexer.g:36:2: ( FRAGMENT_Abc )
        // InternalBacktrackingLexerTestLanguageLexer.g:36:3: FRAGMENT_Abc
        {
        mFRAGMENT_Abc(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalBacktrackingLexerTestLanguageLexer

    // $ANTLR start synpred2_InternalBacktrackingLexerTestLanguageLexer
    public final void synpred2_InternalBacktrackingLexerTestLanguageLexer_fragment() throws RecognitionException {   
        // InternalBacktrackingLexerTestLanguageLexer.g:37:2: ( FRAGMENT_Efg )
        // InternalBacktrackingLexerTestLanguageLexer.g:37:3: FRAGMENT_Efg
        {
        mFRAGMENT_Efg(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalBacktrackingLexerTestLanguageLexer

    // $ANTLR start synpred3_InternalBacktrackingLexerTestLanguageLexer
    public final void synpred3_InternalBacktrackingLexerTestLanguageLexer_fragment() throws RecognitionException {   
        // InternalBacktrackingLexerTestLanguageLexer.g:38:2: ( FRAGMENT_RULE_CHARA )
        // InternalBacktrackingLexerTestLanguageLexer.g:38:3: FRAGMENT_RULE_CHARA
        {
        mFRAGMENT_RULE_CHARA(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalBacktrackingLexerTestLanguageLexer

    // $ANTLR start synpred4_InternalBacktrackingLexerTestLanguageLexer
    public final void synpred4_InternalBacktrackingLexerTestLanguageLexer_fragment() throws RecognitionException {   
        // InternalBacktrackingLexerTestLanguageLexer.g:39:2: ( FRAGMENT_RULE_CHARB )
        // InternalBacktrackingLexerTestLanguageLexer.g:39:3: FRAGMENT_RULE_CHARB
        {
        mFRAGMENT_RULE_CHARB(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalBacktrackingLexerTestLanguageLexer

    // $ANTLR start synpred5_InternalBacktrackingLexerTestLanguageLexer
    public final void synpred5_InternalBacktrackingLexerTestLanguageLexer_fragment() throws RecognitionException {   
        // InternalBacktrackingLexerTestLanguageLexer.g:40:2: ( FRAGMENT_RULE_CHARX )
        // InternalBacktrackingLexerTestLanguageLexer.g:40:3: FRAGMENT_RULE_CHARX
        {
        mFRAGMENT_RULE_CHARX(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalBacktrackingLexerTestLanguageLexer

    // $ANTLR start synpred6_InternalBacktrackingLexerTestLanguageLexer
    public final void synpred6_InternalBacktrackingLexerTestLanguageLexer_fragment() throws RecognitionException {   
        // InternalBacktrackingLexerTestLanguageLexer.g:41:2: ( FRAGMENT_RULE_YC )
        // InternalBacktrackingLexerTestLanguageLexer.g:41:3: FRAGMENT_RULE_YC
        {
        mFRAGMENT_RULE_YC(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalBacktrackingLexerTestLanguageLexer

    // $ANTLR start synpred7_InternalBacktrackingLexerTestLanguageLexer
    public final void synpred7_InternalBacktrackingLexerTestLanguageLexer_fragment() throws RecognitionException {   
        // InternalBacktrackingLexerTestLanguageLexer.g:42:2: ( FRAGMENT_RULE_CHARY )
        // InternalBacktrackingLexerTestLanguageLexer.g:42:3: FRAGMENT_RULE_CHARY
        {
        mFRAGMENT_RULE_CHARY(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalBacktrackingLexerTestLanguageLexer

    // $ANTLR start synpred8_InternalBacktrackingLexerTestLanguageLexer
    public final void synpred8_InternalBacktrackingLexerTestLanguageLexer_fragment() throws RecognitionException {   
        // InternalBacktrackingLexerTestLanguageLexer.g:43:2: ( FRAGMENT_RULE_CHARC )
        // InternalBacktrackingLexerTestLanguageLexer.g:43:3: FRAGMENT_RULE_CHARC
        {
        mFRAGMENT_RULE_CHARC(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalBacktrackingLexerTestLanguageLexer

    // $ANTLR start synpred9_InternalBacktrackingLexerTestLanguageLexer
    public final void synpred9_InternalBacktrackingLexerTestLanguageLexer_fragment() throws RecognitionException {   
        // InternalBacktrackingLexerTestLanguageLexer.g:44:2: ( FRAGMENT_RULE_WS )
        // InternalBacktrackingLexerTestLanguageLexer.g:44:3: FRAGMENT_RULE_WS
        {
        mFRAGMENT_RULE_WS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalBacktrackingLexerTestLanguageLexer

    // $ANTLR start synpred10_InternalBacktrackingLexerTestLanguageLexer
    public final void synpred10_InternalBacktrackingLexerTestLanguageLexer_fragment() throws RecognitionException {   
        // InternalBacktrackingLexerTestLanguageLexer.g:45:2: ( FRAGMENT_RULE_SL_COMMENT )
        // InternalBacktrackingLexerTestLanguageLexer.g:45:3: FRAGMENT_RULE_SL_COMMENT
        {
        mFRAGMENT_RULE_SL_COMMENT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalBacktrackingLexerTestLanguageLexer

    public final boolean synpred10_InternalBacktrackingLexerTestLanguageLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalBacktrackingLexerTestLanguageLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalBacktrackingLexerTestLanguageLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalBacktrackingLexerTestLanguageLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalBacktrackingLexerTestLanguageLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalBacktrackingLexerTestLanguageLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalBacktrackingLexerTestLanguageLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalBacktrackingLexerTestLanguageLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalBacktrackingLexerTestLanguageLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalBacktrackingLexerTestLanguageLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalBacktrackingLexerTestLanguageLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalBacktrackingLexerTestLanguageLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalBacktrackingLexerTestLanguageLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalBacktrackingLexerTestLanguageLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalBacktrackingLexerTestLanguageLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalBacktrackingLexerTestLanguageLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalBacktrackingLexerTestLanguageLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalBacktrackingLexerTestLanguageLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalBacktrackingLexerTestLanguageLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalBacktrackingLexerTestLanguageLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\1\uffff\1\12\3\uffff\1\13\7\uffff";
    static final String DFA1_eofS =
        "\15\uffff";
    static final String DFA1_minS =
        "\1\11\1\142\3\uffff\1\143\7\uffff";
    static final String DFA1_maxS =
        "\1\143\1\142\3\uffff\1\143\7\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\1\4\1\5\1\uffff\1\10\1\11\1\12\1\1\1\3\1\7\1\6";
    static final String DFA1_specialS =
        "\1\0\1\2\3\uffff\1\1\7\uffff}>";
    static final String[] DFA1_transitionS = {
            "\2\7\2\uffff\1\7\22\uffff\1\7\16\uffff\1\10\21\uffff\1\1\3\uffff\1\2\22\uffff\1\4\1\5\10\uffff\1\3\1\6",
            "\1\11",
            "",
            "",
            "",
            "\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "35:1: SYNTHETIC_ALL_KEYWORDS : ( ( FRAGMENT_Abc )=> FRAGMENT_Abc | ( FRAGMENT_Efg )=> FRAGMENT_Efg | ( FRAGMENT_RULE_CHARA )=> FRAGMENT_RULE_CHARA | ( FRAGMENT_RULE_CHARB )=> FRAGMENT_RULE_CHARB | ( FRAGMENT_RULE_CHARX )=> FRAGMENT_RULE_CHARX | ( FRAGMENT_RULE_YC )=> FRAGMENT_RULE_YC | ( FRAGMENT_RULE_CHARY )=> FRAGMENT_RULE_CHARY | ( FRAGMENT_RULE_CHARC )=> FRAGMENT_RULE_CHARC | ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS | ( FRAGMENT_RULE_SL_COMMENT )=> FRAGMENT_RULE_SL_COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_0 = input.LA(1);

                         
                        int index1_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_0=='A') ) {s = 1;}

                        else if ( (LA1_0=='E') && (synpred2_InternalBacktrackingLexerTestLanguageLexer())) {s = 2;}

                        else if ( (LA1_0=='b') && (synpred4_InternalBacktrackingLexerTestLanguageLexer())) {s = 3;}

                        else if ( (LA1_0=='X') && (synpred5_InternalBacktrackingLexerTestLanguageLexer())) {s = 4;}

                        else if ( (LA1_0=='Y') ) {s = 5;}

                        else if ( (LA1_0=='c') && (synpred8_InternalBacktrackingLexerTestLanguageLexer())) {s = 6;}

                        else if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') && (synpred9_InternalBacktrackingLexerTestLanguageLexer())) {s = 7;}

                        else if ( (LA1_0=='/') && (synpred10_InternalBacktrackingLexerTestLanguageLexer())) {s = 8;}

                         
                        input.seek(index1_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_5=='c') && (synpred6_InternalBacktrackingLexerTestLanguageLexer())) {s = 12;}

                        else s = 11;

                         
                        input.seek(index1_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_1 = input.LA(1);

                         
                        int index1_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_1=='b') && (synpred1_InternalBacktrackingLexerTestLanguageLexer())) {s = 9;}

                        else s = 10;

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}