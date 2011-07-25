package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug348199TestLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=9;
    public static final int T__12=12;
    public static final int RULE_ID=5;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=8;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__22=22;
    public static final int RULE_WS=7;
    public static final int T__17=17;
    public static final int RULE_NL=4;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int T__27=27;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int T__26=26;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators

    public InternalBug348199TestLanguageLexer() {;} 
    public InternalBug348199TestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBug348199TestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:11:7: ( 'define' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:11:9: 'define'
            {
            match("define"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:12:7: ( 'timeperiod' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:12:9: 'timeperiod'
            {
            match("timeperiod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:13:7: ( '1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:13:9: '1'
            {
            match('1'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:14:7: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:14:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:15:7: ( 'timeperiod_name' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:15:9: 'timeperiod_name'
            {
            match("timeperiod_name"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:16:7: ( 'otherelement' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:16:9: 'otherelement'
            {
            match("otherelement"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:17:7: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:17:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:18:7: ( '2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:18:9: '2'
            {
            match('2'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:19:7: ( '3' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:19:9: '3'
            {
            match('3'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:20:7: ( '4' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:20:9: '4'
            {
            match('4'); 

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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:21:7: ( '5' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:21:9: '5'
            {
            match('5'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:22:7: ( '6' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:22:9: '6'
            {
            match('6'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:23:7: ( '7' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:23:9: '7'
            {
            match('7'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:24:7: ( '8' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:24:9: '8'
            {
            match('8'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:25:7: ( 'july' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:25:9: 'july'
            {
            match("july"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:26:7: ( 'august' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:26:9: 'august'
            {
            match("august"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:27:7: ( 'september' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:27:9: 'september'
            {
            match("september"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "RULE_NL"
    public final void mRULE_NL() throws RecognitionException {
        try {
            int _type = RULE_NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1397:9: ( '\\n' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1397:11: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NL"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1399:9: ( ( ' ' | '\\t' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1399:11: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1401:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1401:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1401:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1401:11: '^'
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1401:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1403:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1403:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1403:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1403:13: '0' .. '9'
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1405:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1407:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1407:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1407:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1407:52: .
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1409:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1409:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1409:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1409:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop8;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1409:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1409:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1409:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1409:41: '\\r'
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1411:16: ( . )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1411:18: .
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
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | RULE_NL | RULE_WS | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_ANY_OTHER )
        int alt11=25;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:112: RULE_NL
                {
                mRULE_NL(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:120: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:128: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:136: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:145: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:157: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:173: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348199TestLanguage.g:1:189: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\2\33\1\35\1\uffff\1\33\1\uffff\1\42\1\43\1\44\1\45\1\46"+
        "\1\47\1\50\3\33\2\uffff\1\31\2\uffff\3\31\1\uffff\1\33\1\uffff\1"+
        "\33\3\uffff\1\33\10\uffff\3\33\5\uffff\11\33\1\100\5\33\1\uffff"+
        "\2\33\1\110\2\33\1\113\1\33\1\uffff\2\33\1\uffff\6\33\1\125\1\127"+
        "\1\33\1\uffff\1\33\1\uffff\2\33\1\134\1\33\1\uffff\1\33\1\137\1"+
        "\uffff";
    static final String DFA11_eofS =
        "\140\uffff";
    static final String DFA11_minS =
        "\1\0\1\145\1\151\1\60\1\uffff\1\164\1\uffff\7\60\2\165\1\145\2\uffff"+
        "\1\101\2\uffff\2\0\1\52\1\uffff\1\146\1\uffff\1\155\3\uffff\1\150"+
        "\10\uffff\1\154\1\147\1\160\5\uffff\1\151\2\145\1\171\1\165\1\164"+
        "\1\156\1\160\1\162\1\60\1\163\4\145\1\uffff\1\164\1\155\1\60\1\162"+
        "\1\154\1\60\1\142\1\uffff\1\151\1\145\1\uffff\1\145\1\157\1\155"+
        "\1\162\1\144\1\145\2\60\1\156\1\uffff\1\156\1\uffff\1\164\1\141"+
        "\1\60\1\155\1\uffff\1\145\1\60\1\uffff";
    static final String DFA11_maxS =
        "\1\uffff\1\145\1\151\1\71\1\uffff\1\164\1\uffff\7\71\2\165\1\145"+
        "\2\uffff\1\172\2\uffff\2\uffff\1\57\1\uffff\1\146\1\uffff\1\155"+
        "\3\uffff\1\150\10\uffff\1\154\1\147\1\160\5\uffff\1\151\2\145\1"+
        "\171\1\165\1\164\1\156\1\160\1\162\1\172\1\163\4\145\1\uffff\1\164"+
        "\1\155\1\172\1\162\1\154\1\172\1\142\1\uffff\1\151\1\145\1\uffff"+
        "\1\145\1\157\1\155\1\162\1\144\1\145\2\172\1\156\1\uffff\1\156\1"+
        "\uffff\1\164\1\141\1\172\1\155\1\uffff\1\145\1\172\1\uffff";
    static final String DFA11_acceptS =
        "\4\uffff\1\4\1\uffff\1\7\12\uffff\1\22\1\23\1\uffff\1\24\1\25\3"+
        "\uffff\1\31\1\uffff\1\24\1\uffff\1\3\1\25\1\4\1\uffff\1\7\1\10\1"+
        "\11\1\12\1\13\1\14\1\15\1\16\3\uffff\1\22\1\23\1\26\1\27\1\30\17"+
        "\uffff\1\17\7\uffff\1\1\2\uffff\1\20\11\uffff\1\21\1\uffff\1\2\4"+
        "\uffff\1\6\2\uffff\1\5";
    static final String DFA11_specialS =
        "\1\1\25\uffff\1\0\1\2\110\uffff}>";
    static final String[] DFA11_transitionS = {
            "\11\31\1\22\1\21\25\31\1\22\1\31\1\26\4\31\1\27\7\31\1\30\1"+
            "\25\1\3\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\25\7\31\32\24\3"+
            "\31\1\23\1\24\1\31\1\17\2\24\1\1\5\24\1\16\4\24\1\5\3\24\1\20"+
            "\1\2\6\24\1\4\1\31\1\6\uff82\31",
            "\1\32",
            "\1\34",
            "\12\36",
            "",
            "\1\40",
            "",
            "\12\36",
            "\12\36",
            "\12\36",
            "\12\36",
            "\12\36",
            "\12\36",
            "\12\36",
            "\1\51",
            "\1\52",
            "\1\53",
            "",
            "",
            "\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "\0\56",
            "\0\56",
            "\1\57\4\uffff\1\60",
            "",
            "\1\61",
            "",
            "\1\62",
            "",
            "",
            "",
            "\1\63",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\64",
            "\1\65",
            "\1\66",
            "",
            "",
            "",
            "",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "",
            "\1\106",
            "\1\107",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\111",
            "\1\112",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\114",
            "",
            "\1\115",
            "\1\116",
            "",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\126\1\uffff\32\33",
            "\1\130",
            "",
            "\1\131",
            "",
            "\1\132",
            "\1\133",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\135",
            "",
            "\1\136",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    static class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | RULE_NL | RULE_WS | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_22 = input.LA(1);

                        s = -1;
                        if ( ((LA11_22>='\u0000' && LA11_22<='\uFFFF')) ) {s = 46;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_0 = input.LA(1);

                        s = -1;
                        if ( (LA11_0=='d') ) {s = 1;}

                        else if ( (LA11_0=='t') ) {s = 2;}

                        else if ( (LA11_0=='1') ) {s = 3;}

                        else if ( (LA11_0=='{') ) {s = 4;}

                        else if ( (LA11_0=='o') ) {s = 5;}

                        else if ( (LA11_0=='}') ) {s = 6;}

                        else if ( (LA11_0=='2') ) {s = 7;}

                        else if ( (LA11_0=='3') ) {s = 8;}

                        else if ( (LA11_0=='4') ) {s = 9;}

                        else if ( (LA11_0=='5') ) {s = 10;}

                        else if ( (LA11_0=='6') ) {s = 11;}

                        else if ( (LA11_0=='7') ) {s = 12;}

                        else if ( (LA11_0=='8') ) {s = 13;}

                        else if ( (LA11_0=='j') ) {s = 14;}

                        else if ( (LA11_0=='a') ) {s = 15;}

                        else if ( (LA11_0=='s') ) {s = 16;}

                        else if ( (LA11_0=='\n') ) {s = 17;}

                        else if ( (LA11_0=='\t'||LA11_0==' ') ) {s = 18;}

                        else if ( (LA11_0=='^') ) {s = 19;}

                        else if ( ((LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='b' && LA11_0<='c')||(LA11_0>='e' && LA11_0<='i')||(LA11_0>='k' && LA11_0<='n')||(LA11_0>='p' && LA11_0<='r')||(LA11_0>='u' && LA11_0<='z')) ) {s = 20;}

                        else if ( (LA11_0=='0'||LA11_0=='9') ) {s = 21;}

                        else if ( (LA11_0=='\"') ) {s = 22;}

                        else if ( (LA11_0=='\'') ) {s = 23;}

                        else if ( (LA11_0=='/') ) {s = 24;}

                        else if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\u000B' && LA11_0<='\u001F')||LA11_0=='!'||(LA11_0>='#' && LA11_0<='&')||(LA11_0>='(' && LA11_0<='.')||(LA11_0>=':' && LA11_0<='@')||(LA11_0>='[' && LA11_0<=']')||LA11_0=='`'||LA11_0=='|'||(LA11_0>='~' && LA11_0<='\uFFFF')) ) {s = 25;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_23 = input.LA(1);

                        s = -1;
                        if ( ((LA11_23>='\u0000' && LA11_23<='\uFFFF')) ) {s = 46;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}