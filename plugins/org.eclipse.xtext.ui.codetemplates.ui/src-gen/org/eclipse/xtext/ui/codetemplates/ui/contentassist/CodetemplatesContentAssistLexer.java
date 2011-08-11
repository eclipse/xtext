package org.eclipse.xtext.ui.codetemplates.ui.contentassist;

// Use our own Lexer superclass by means of import. 
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CodetemplatesContentAssistLexer extends Lexer {
    public static final int RULE_ID=18;
    public static final int RULE_ANY_OTHER=21;
    public static final int KEYWORD_1=11;
    public static final int KEYWORD_5=15;
    public static final int KEYWORD_4=14;
    public static final int KEYWORD_13=6;
    public static final int KEYWORD_3=13;
    public static final int KEYWORD_14=4;
    public static final int KEYWORD_2=12;
    public static final int KEYWORD_11=10;
    public static final int EOF=-1;
    public static final int KEYWORD_12=5;
    public static final int KEYWORD_10=9;
    public static final int RULE_STRING=19;
    public static final int KEYWORD_6=16;
    public static final int KEYWORD_7=17;
    public static final int KEYWORD_8=7;
    public static final int KEYWORD_9=8;
    public static final int RULE_WS=20;

      private boolean literal = false;
      private boolean templateVariable = false;


    // delegates
    // delegators

    public CodetemplatesContentAssistLexer() {;} 
    public CodetemplatesContentAssistLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CodetemplatesContentAssistLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g"; }

    // $ANTLR start "KEYWORD_14"
    public final void mKEYWORD_14() throws RecognitionException {
        try {
            int _type = KEYWORD_14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:20:12: ({...}? => 'templates' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:20:14: {...}? => 'templates'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "KEYWORD_14", "!literal || templateVariable");
            }
            match("templates"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_14"

    // $ANTLR start "KEYWORD_12"
    public final void mKEYWORD_12() throws RecognitionException {
        try {
            int _type = KEYWORD_12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:22:12: ( '\\\\<<' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:22:14: '\\\\<<'
            {
            match("\\<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_12"

    // $ANTLR start "KEYWORD_13"
    public final void mKEYWORD_13() throws RecognitionException {
        try {
            int _type = KEYWORD_13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:24:12: ({...}? => 'for' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:24:14: {...}? => 'for'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "KEYWORD_13", "!literal || templateVariable");
            }
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_13"

    // $ANTLR start "KEYWORD_8"
    public final void mKEYWORD_8() throws RecognitionException {
        try {
            int _type = KEYWORD_8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:26:11: ( '$$' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:26:13: '$$'
            {
            match("$$"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_8"

    // $ANTLR start "KEYWORD_9"
    public final void mKEYWORD_9() throws RecognitionException {
        try {
            int _type = KEYWORD_9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:28:11: ( '${' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:28:13: '${'
            {
            match("${"); 

            templateVariable = true;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_9"

    // $ANTLR start "KEYWORD_10"
    public final void mKEYWORD_10() throws RecognitionException {
        try {
            int _type = KEYWORD_10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:30:12: ( '<<' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:30:14: '<<'
            {
            match("<<"); 

             if (literal) literal = false; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_10"

    // $ANTLR start "KEYWORD_11"
    public final void mKEYWORD_11() throws RecognitionException {
        try {
            int _type = KEYWORD_11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:32:12: ({...}? => '>>' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:32:14: {...}? => '>>'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "KEYWORD_11", "!literal || templateVariable");
            }
            match(">>"); 

             if (!literal) literal = true; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_11"

    // $ANTLR start "KEYWORD_1"
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:34:11: ( '$' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:34:13: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_1"

    // $ANTLR start "KEYWORD_2"
    public final void mKEYWORD_2() throws RecognitionException {
        try {
            int _type = KEYWORD_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:36:11: ({...}? => '(' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:36:13: {...}? => '('
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "KEYWORD_2", "!literal || templateVariable");
            }
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_2"

    // $ANTLR start "KEYWORD_3"
    public final void mKEYWORD_3() throws RecognitionException {
        try {
            int _type = KEYWORD_3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:38:11: ({...}? => ')' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:38:13: {...}? => ')'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "KEYWORD_3", "!literal || templateVariable");
            }
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_3"

    // $ANTLR start "KEYWORD_4"
    public final void mKEYWORD_4() throws RecognitionException {
        try {
            int _type = KEYWORD_4;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:40:11: ({...}? => ',' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:40:13: {...}? => ','
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "KEYWORD_4", "!literal || templateVariable");
            }
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_4"

    // $ANTLR start "KEYWORD_5"
    public final void mKEYWORD_5() throws RecognitionException {
        try {
            int _type = KEYWORD_5;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:42:11: ({...}? => '.' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:42:13: {...}? => '.'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "KEYWORD_5", "!literal || templateVariable");
            }
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_5"

    // $ANTLR start "KEYWORD_6"
    public final void mKEYWORD_6() throws RecognitionException {
        try {
            int _type = KEYWORD_6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:44:11: ({...}? => ':' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:44:13: {...}? => ':'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "KEYWORD_6", "!literal || templateVariable");
            }
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_6"

    // $ANTLR start "KEYWORD_7"
    public final void mKEYWORD_7() throws RecognitionException {
        try {
            int _type = KEYWORD_7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:46:11: ({...}? => '}' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:46:13: {...}? => '}'
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "KEYWORD_7", "!literal || templateVariable");
            }
            match('}'); 
            templateVariable = false;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_7"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:50:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:50:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:50:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:50:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:50:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:52:13: ({...}? => ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:52:15: {...}? => ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            if ( !((!literal || templateVariable)) ) {
                throw new FailedPredicateException(input, "RULE_STRING", "!literal || templateVariable");
            }
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:52:48: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:52:50: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:52:55: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    alt3=1;
                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:52:56: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:52:97: ~ ( ( '\\\\' | '\\'' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('\''); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:54:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:54:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:54:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\t' && LA4_0<='\n')||LA4_0=='\r'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:56:16: ( . )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:56:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:8: ( KEYWORD_14 | KEYWORD_12 | KEYWORD_13 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | RULE_ID | RULE_STRING | RULE_WS | RULE_ANY_OTHER )
        int alt5=18;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:10: KEYWORD_14
                {
                mKEYWORD_14(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:21: KEYWORD_12
                {
                mKEYWORD_12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:32: KEYWORD_13
                {
                mKEYWORD_13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:43: KEYWORD_8
                {
                mKEYWORD_8(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:53: KEYWORD_9
                {
                mKEYWORD_9(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:63: KEYWORD_10
                {
                mKEYWORD_10(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:74: KEYWORD_11
                {
                mKEYWORD_11(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:85: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:95: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:105: KEYWORD_3
                {
                mKEYWORD_3(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:115: KEYWORD_4
                {
                mKEYWORD_4(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:125: KEYWORD_5
                {
                mKEYWORD_5(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:135: KEYWORD_6
                {
                mKEYWORD_6(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:145: KEYWORD_7
                {
                mKEYWORD_7(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:155: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:163: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:175: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.ui.codetemplates.ui/src/org/eclipse/xtext/ui/codetemplates/ui/contentassist/CodetemplatesContentAssistLexer.g:1:183: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\1\23\1\21\1\23\1\30\2\21\1\33\1\34\1\35\1\36\1\37\1\40"+
        "\1\21\1\uffff\1\21\2\uffff\1\23\2\uffff\1\23\15\uffff\1\23\1\54"+
        "\6\uffff\1\23\1\uffff\1\23\1\uffff\3\23\1\63\2\uffff";
    static final String DFA5_eofS =
        "\65\uffff";
    static final String DFA5_minS =
        "\1\0\1\145\1\74\1\157\1\44\1\74\1\76\6\0\1\101\1\uffff\1\0\2\uffff"+
        "\1\155\2\uffff\1\162\5\uffff\6\0\2\uffff\1\160\1\60\6\uffff\1\154"+
        "\1\0\1\141\1\uffff\1\164\1\145\1\163\1\60\1\0\1\uffff";
    static final String DFA5_maxS =
        "\1\uffff\1\145\1\74\1\157\1\173\1\74\1\76\6\0\1\172\1\uffff\1\uffff"+
        "\2\uffff\1\155\2\uffff\1\162\5\uffff\6\0\2\uffff\1\160\1\172\6\uffff"+
        "\1\154\1\0\1\141\1\uffff\1\164\1\145\1\163\1\172\1\0\1\uffff";
    static final String DFA5_acceptS =
        "\16\uffff\1\17\1\uffff\1\21\1\22\1\uffff\1\17\1\2\1\uffff\1\4\1"+
        "\5\1\10\1\6\1\7\6\uffff\1\20\1\21\2\uffff\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\3\uffff\1\3\5\uffff\1\1";
    static final String DFA5_specialS =
        "\1\7\5\uffff\1\0\10\uffff\1\1\13\uffff\1\10\1\3\1\4\1\5\1\6\1\2"+
        "\13\uffff\1\12\6\uffff\1\11\1\uffff}>";
    static final String[] DFA5_transitionS = {
            "\11\21\2\20\2\21\1\20\22\21\1\20\3\21\1\4\2\21\1\17\1\7\1\10"+
            "\2\21\1\11\1\21\1\12\13\21\1\13\1\21\1\5\1\21\1\6\2\21\32\16"+
            "\1\21\1\2\1\21\1\15\1\16\1\21\5\16\1\3\15\16\1\1\6\16\2\21\1"+
            "\14\uff82\21",
            "\1\22",
            "\1\24",
            "\1\25",
            "\1\26\126\uffff\1\27",
            "\1\31",
            "\1\32",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "\0\41",
            "",
            "",
            "\1\43",
            "",
            "",
            "\1\44",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\53",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55",
            "\1\uffff",
            "\1\57",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\uffff",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( KEYWORD_14 | KEYWORD_12 | KEYWORD_13 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | RULE_ID | RULE_STRING | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_6=='>') && ((!literal || templateVariable))) {s = 26;}

                        else s = 17;

                         
                        input.seek(index5_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_15 = input.LA(1);

                         
                        int index5_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA5_15>='\u0000' && LA5_15<='\uFFFF')) && ((!literal || templateVariable))) {s = 33;}

                        else s = 17;

                         
                        input.seek(index5_15);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_32 = input.LA(1);

                         
                        int index5_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 42;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_32);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_28 = input.LA(1);

                         
                        int index5_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 38;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_28);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_29 = input.LA(1);

                         
                        int index5_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 39;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_29);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_30 = input.LA(1);

                         
                        int index5_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 40;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_30);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA5_31 = input.LA(1);

                         
                        int index5_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 41;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_31);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA5_0 = input.LA(1);

                        s = -1;
                        if ( (LA5_0=='t') ) {s = 1;}

                        else if ( (LA5_0=='\\') ) {s = 2;}

                        else if ( (LA5_0=='f') ) {s = 3;}

                        else if ( (LA5_0=='$') ) {s = 4;}

                        else if ( (LA5_0=='<') ) {s = 5;}

                        else if ( (LA5_0=='>') ) {s = 6;}

                        else if ( (LA5_0=='(') ) {s = 7;}

                        else if ( (LA5_0==')') ) {s = 8;}

                        else if ( (LA5_0==',') ) {s = 9;}

                        else if ( (LA5_0=='.') ) {s = 10;}

                        else if ( (LA5_0==':') ) {s = 11;}

                        else if ( (LA5_0=='}') ) {s = 12;}

                        else if ( (LA5_0=='^') ) {s = 13;}

                        else if ( ((LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='e')||(LA5_0>='g' && LA5_0<='s')||(LA5_0>='u' && LA5_0<='z')) ) {s = 14;}

                        else if ( (LA5_0=='\'') ) {s = 15;}

                        else if ( ((LA5_0>='\t' && LA5_0<='\n')||LA5_0=='\r'||LA5_0==' ') ) {s = 16;}

                        else if ( ((LA5_0>='\u0000' && LA5_0<='\b')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\u001F')||(LA5_0>='!' && LA5_0<='#')||(LA5_0>='%' && LA5_0<='&')||(LA5_0>='*' && LA5_0<='+')||LA5_0=='-'||(LA5_0>='/' && LA5_0<='9')||LA5_0==';'||LA5_0=='='||(LA5_0>='?' && LA5_0<='@')||LA5_0=='['||LA5_0==']'||LA5_0=='`'||(LA5_0>='{' && LA5_0<='|')||(LA5_0>='~' && LA5_0<='\uFFFF')) ) {s = 17;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA5_27 = input.LA(1);

                         
                        int index5_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 37;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index5_27);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA5_51 = input.LA(1);

                         
                        int index5_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 52;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index5_51);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA5_44 = input.LA(1);

                         
                        int index5_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!literal || templateVariable)) ) {s = 46;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index5_44);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}