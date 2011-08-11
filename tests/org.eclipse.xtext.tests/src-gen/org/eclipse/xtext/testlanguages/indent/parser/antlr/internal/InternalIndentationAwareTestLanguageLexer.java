package org.eclipse.xtext.testlanguages.indent.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIndentationAwareTestLanguageLexer extends Lexer {
    public static final int RULE_END=6;
    public static final int RULE_OTHER=7;
    public static final int RULE_BEGIN=5;
    public static final int RULE_NL=4;
    public static final int EOF=-1;

    // delegates
    // delegators

    public InternalIndentationAwareTestLanguageLexer() {;} 
    public InternalIndentationAwareTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalIndentationAwareTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g"; }

    // $ANTLR start "RULE_NL"
    public final void mRULE_NL() throws RecognitionException {
        try {
            int _type = RULE_NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:224:9: ( ( '\\r' | '\\n' )+ ( '\\t' )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:224:11: ( '\\r' | '\\n' )+ ( '\\t' )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:224:11: ( '\\r' | '\\n' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\n'||LA1_0=='\r') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:224:24: ( '\\t' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\t') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:224:24: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NL"

    // $ANTLR start "RULE_BEGIN"
    public final void mRULE_BEGIN() throws RecognitionException {
        try {
            int _type = RULE_BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:226:12: ( '{' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:226:14: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BEGIN"

    // $ANTLR start "RULE_END"
    public final void mRULE_END() throws RecognitionException {
        try {
            int _type = RULE_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:228:10: ( '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:228:12: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_END"

    // $ANTLR start "RULE_OTHER"
    public final void mRULE_OTHER() throws RecognitionException {
        try {
            int _type = RULE_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:230:12: ( . )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:230:14: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:1:8: ( RULE_NL | RULE_BEGIN | RULE_END | RULE_OTHER )
        int alt3=4;
        int LA3_0 = input.LA(1);

        if ( (LA3_0=='\n'||LA3_0=='\r') ) {
            alt3 = mTokensHelper001();
        }
        else if ( (LA3_0=='{') ) {
            alt3 = mTokensHelper002();
        }
        else if ( (LA3_0=='}') ) {
            alt3 = mTokensHelper003();
        }
        else if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='z')||LA3_0=='|'||(LA3_0>='~' && LA3_0<='\uFFFF')) ) {
            alt3 = mTokensHelper004();
        }
        else {
            alt3 = mTokensHelper005();
        }
        switch (alt3) {
            case 1 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:1:10: RULE_NL
                {
                mRULE_NL(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:1:18: RULE_BEGIN
                {
                mRULE_BEGIN(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:1:29: RULE_END
                {
                mRULE_END(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/indent/parser/antlr/internal/InternalIndentationAwareTestLanguage.g:1:38: RULE_OTHER
                {
                mRULE_OTHER(); 

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
        return 3;
    }

    private int mTokensHelper004() throws RecognitionException {
        return 4;
    }

    private int mTokensHelper005() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("", 3, 0, input);

        throw nvae;
    }



 

}