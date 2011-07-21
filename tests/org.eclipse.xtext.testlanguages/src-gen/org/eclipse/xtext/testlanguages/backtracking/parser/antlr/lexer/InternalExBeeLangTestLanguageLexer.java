package org.eclipse.xtext.testlanguages.backtracking.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExBeeLangTestLanguageLexer extends Lexer {
    public static final int KEYWORD_7=55;
    public static final int KEYWORD_49=24;
    public static final int KEYWORD_43=30;
    public static final int KEYWORD_21=32;
    public static final int KEYWORD_17=65;
    public static final int KEYWORD_18=66;
    public static final int KEYWORD_24=35;
    public static final int RULE_STRING=73;
    public static final int KEYWORD_65=5;
    public static final int KEYWORD_31=42;
    public static final int KEYWORD_36=47;
    public static final int KEYWORD_19=67;
    public static final int KEYWORD_9=57;
    public static final int KEYWORD_2=50;
    public static final int RULE_HEX=70;
    public static final int KEYWORD_23=34;
    public static final int KEYWORD_30=41;
    public static final int KEYWORD_44=31;
    public static final int KEYWORD_16=64;
    public static final int KEYWORD_58=13;
    public static final int KEYWORD_22=33;
    public static final int KEYWORD_57=12;
    public static final int KEYWORD_28=39;
    public static final int KEYWORD_61=10;
    public static final int KEYWORD_50=18;
    public static final int RULE_INT=72;
    public static final int KEYWORD_13=61;
    public static final int KEYWORD_35=46;
    public static final int KEYWORD_5=53;
    public static final int KEYWORD_62=6;
    public static final int KEYWORD_51=19;
    public static final int KEYWORD_47=22;
    public static final int KEYWORD_34=45;
    public static final int KEYWORD_12=60;
    public static final int KEYWORD_8=56;
    public static final int KEYWORD_37=48;
    public static final int KEYWORD_56=11;
    public static final int KEYWORD_48=23;
    public static final int KEYWORD_27=38;
    public static final int KEYWORD_53=15;
    public static final int KEYWORD_32=43;
    public static final int KEYWORD_38=25;
    public static final int RULE_ML_COMMENT=74;
    public static final int RULE_ID=71;
    public static final int KEYWORD_10=58;
    public static final int KEYWORD_29=40;
    public static final int KEYWORD_1=49;
    public static final int KEYWORD_46=21;
    public static final int KEYWORD_39=26;
    public static final int KEYWORD_54=16;
    public static final int KEYWORD_55=17;
    public static final int KEYWORD_45=20;
    public static final int KEYWORD_33=44;
    public static final int KEYWORD_52=14;
    public static final int KEYWORD_11=59;
    public static final int KEYWORD_64=4;
    public static final int KEYWORD_4=52;
    public static final int RULE_WS=76;
    public static final int KEYWORD_20=68;
    public static final int KEYWORD_14=62;
    public static final int EOF=-1;
    public static final int KEYWORD_42=29;
    public static final int RULE_DOCUMENTATION=69;
    public static final int KEYWORD_6=54;
    public static final int RULE_ANY_OTHER=77;
    public static final int KEYWORD_25=36;
    public static final int KEYWORD_41=28;
    public static final int KEYWORD_15=63;
    public static final int RULE_SL_COMMENT=75;
    public static final int KEYWORD_60=9;
    public static final int KEYWORD_59=8;
    public static final int KEYWORD_63=7;
    public static final int KEYWORD_26=37;
    public static final int KEYWORD_3=51;
    public static final int KEYWORD_40=27;

    // delegates
    // delegators

    public InternalExBeeLangTestLanguageLexer() {;} 
    public InternalExBeeLangTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalExBeeLangTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g"; }

    // $ANTLR start "KEYWORD_64"
    public final void mKEYWORD_64() throws RecognitionException {
        try {
            int _type = KEYWORD_64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:19:12: ( 'requires-max' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:19:14: 'requires-max'
            {
            match("requires-max"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_64"

    // $ANTLR start "KEYWORD_65"
    public final void mKEYWORD_65() throws RecognitionException {
        try {
            int _type = KEYWORD_65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:21:12: ( 'requires-min' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:21:14: 'requires-min'
            {
            match("requires-min"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_65"

    // $ANTLR start "KEYWORD_62"
    public final void mKEYWORD_62() throws RecognitionException {
        try {
            int _type = KEYWORD_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:23:12: ( 'implements' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:23:14: 'implements'
            {
            match("implements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_62"

    // $ANTLR start "KEYWORD_63"
    public final void mKEYWORD_63() throws RecognitionException {
        try {
            int _type = KEYWORD_63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:25:12: ( 'properties' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:25:14: 'properties'
            {
            match("properties"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_63"

    // $ANTLR start "KEYWORD_59"
    public final void mKEYWORD_59() throws RecognitionException {
        try {
            int _type = KEYWORD_59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:27:12: ( 'function' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:27:14: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_59"

    // $ANTLR start "KEYWORD_60"
    public final void mKEYWORD_60() throws RecognitionException {
        try {
            int _type = KEYWORD_60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:29:12: ( 'provides' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:29:14: 'provides'
            {
            match("provides"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_60"

    // $ANTLR start "KEYWORD_61"
    public final void mKEYWORD_61() throws RecognitionException {
        try {
            int _type = KEYWORD_61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:31:12: ( 'requires' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:31:14: 'requires'
            {
            match("requires"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_61"

    // $ANTLR start "KEYWORD_56"
    public final void mKEYWORD_56() throws RecognitionException {
        try {
            int _type = KEYWORD_56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:33:12: ( 'builder' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:33:14: 'builder'
            {
            match("builder"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_56"

    // $ANTLR start "KEYWORD_57"
    public final void mKEYWORD_57() throws RecognitionException {
        try {
            int _type = KEYWORD_57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:35:12: ( 'context' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:35:14: 'context'
            {
            match("context"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_57"

    // $ANTLR start "KEYWORD_58"
    public final void mKEYWORD_58() throws RecognitionException {
        try {
            int _type = KEYWORD_58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:37:12: ( 'version' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:37:14: 'version'
            {
            match("version"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_58"

    // $ANTLR start "KEYWORD_52"
    public final void mKEYWORD_52() throws RecognitionException {
        try {
            int _type = KEYWORD_52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:39:12: ( 'cached' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:39:14: 'cached'
            {
            match("cached"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_52"

    // $ANTLR start "KEYWORD_53"
    public final void mKEYWORD_53() throws RecognitionException {
        try {
            int _type = KEYWORD_53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:41:12: ( 'greedy' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:41:14: 'greedy'
            {
            match("greedy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_53"

    // $ANTLR start "KEYWORD_54"
    public final void mKEYWORD_54() throws RecognitionException {
        try {
            int _type = KEYWORD_54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:43:12: ( 'output' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:43:14: 'output'
            {
            match("output"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_54"

    // $ANTLR start "KEYWORD_55"
    public final void mKEYWORD_55() throws RecognitionException {
        try {
            int _type = KEYWORD_55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:45:12: ( 'source' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:45:14: 'source'
            {
            match("source"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_55"

    // $ANTLR start "KEYWORD_50"
    public final void mKEYWORD_50() throws RecognitionException {
        try {
            int _type = KEYWORD_50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:47:12: ( 'final' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:47:14: 'final'
            {
            match("final"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_50"

    // $ANTLR start "KEYWORD_51"
    public final void mKEYWORD_51() throws RecognitionException {
        try {
            int _type = KEYWORD_51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:49:12: ( 'input' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:49:14: 'input'
            {
            match("input"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_51"

    // $ANTLR start "KEYWORD_45"
    public final void mKEYWORD_45() throws RecognitionException {
        try {
            int _type = KEYWORD_45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:51:12: ( 'name' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:51:14: 'name'
            {
            match("name"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_45"

    // $ANTLR start "KEYWORD_46"
    public final void mKEYWORD_46() throws RecognitionException {
        try {
            int _type = KEYWORD_46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:53:12: ( 'this' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:53:14: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_46"

    // $ANTLR start "KEYWORD_47"
    public final void mKEYWORD_47() throws RecognitionException {
        try {
            int _type = KEYWORD_47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:55:12: ( 'unit' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:55:14: 'unit'
            {
            match("unit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_47"

    // $ANTLR start "KEYWORD_48"
    public final void mKEYWORD_48() throws RecognitionException {
        try {
            int _type = KEYWORD_48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:57:12: ( 'when' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:57:14: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_48"

    // $ANTLR start "KEYWORD_49"
    public final void mKEYWORD_49() throws RecognitionException {
        try {
            int _type = KEYWORD_49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:59:12: ( 'with' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:59:14: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_49"

    // $ANTLR start "KEYWORD_38"
    public final void mKEYWORD_38() throws RecognitionException {
        try {
            int _type = KEYWORD_38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:61:12: ( '!==' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:61:14: '!=='
            {
            match("!=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_38"

    // $ANTLR start "KEYWORD_39"
    public final void mKEYWORD_39() throws RecognitionException {
        try {
            int _type = KEYWORD_39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:63:12: ( '...' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:63:14: '...'
            {
            match("..."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_39"

    // $ANTLR start "KEYWORD_40"
    public final void mKEYWORD_40() throws RecognitionException {
        try {
            int _type = KEYWORD_40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:65:12: ( '===' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:65:14: '==='
            {
            match("==="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_40"

    // $ANTLR start "KEYWORD_41"
    public final void mKEYWORD_41() throws RecognitionException {
        try {
            int _type = KEYWORD_41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:67:12: ( 'env' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:67:14: 'env'
            {
            match("env"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_41"

    // $ANTLR start "KEYWORD_42"
    public final void mKEYWORD_42() throws RecognitionException {
        try {
            int _type = KEYWORD_42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:69:12: ( 'new' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:69:14: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_42"

    // $ANTLR start "KEYWORD_43"
    public final void mKEYWORD_43() throws RecognitionException {
        try {
            int _type = KEYWORD_43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:71:12: ( 'val' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:71:14: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_43"

    // $ANTLR start "KEYWORD_44"
    public final void mKEYWORD_44() throws RecognitionException {
        try {
            int _type = KEYWORD_44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:73:12: ( 'var' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:73:14: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_44"

    // $ANTLR start "KEYWORD_21"
    public final void mKEYWORD_21() throws RecognitionException {
        try {
            int _type = KEYWORD_21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:75:12: ( '!=' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:75:14: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_21"

    // $ANTLR start "KEYWORD_22"
    public final void mKEYWORD_22() throws RecognitionException {
        try {
            int _type = KEYWORD_22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:77:12: ( '%=' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:77:14: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_22"

    // $ANTLR start "KEYWORD_23"
    public final void mKEYWORD_23() throws RecognitionException {
        try {
            int _type = KEYWORD_23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:79:12: ( '&&' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:79:14: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_23"

    // $ANTLR start "KEYWORD_24"
    public final void mKEYWORD_24() throws RecognitionException {
        try {
            int _type = KEYWORD_24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:81:12: ( '*=' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:81:14: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_24"

    // $ANTLR start "KEYWORD_25"
    public final void mKEYWORD_25() throws RecognitionException {
        try {
            int _type = KEYWORD_25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:83:12: ( '++' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:83:14: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_25"

    // $ANTLR start "KEYWORD_26"
    public final void mKEYWORD_26() throws RecognitionException {
        try {
            int _type = KEYWORD_26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:85:12: ( '+=' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:85:14: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_26"

    // $ANTLR start "KEYWORD_27"
    public final void mKEYWORD_27() throws RecognitionException {
        try {
            int _type = KEYWORD_27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:87:12: ( '--' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:87:14: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_27"

    // $ANTLR start "KEYWORD_28"
    public final void mKEYWORD_28() throws RecognitionException {
        try {
            int _type = KEYWORD_28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:89:12: ( '-=' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:89:14: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_28"

    // $ANTLR start "KEYWORD_29"
    public final void mKEYWORD_29() throws RecognitionException {
        try {
            int _type = KEYWORD_29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:91:12: ( '..' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:91:14: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_29"

    // $ANTLR start "KEYWORD_30"
    public final void mKEYWORD_30() throws RecognitionException {
        try {
            int _type = KEYWORD_30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:93:12: ( '/=' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:93:14: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_30"

    // $ANTLR start "KEYWORD_31"
    public final void mKEYWORD_31() throws RecognitionException {
        try {
            int _type = KEYWORD_31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:95:12: ( '<=' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:95:14: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_31"

    // $ANTLR start "KEYWORD_32"
    public final void mKEYWORD_32() throws RecognitionException {
        try {
            int _type = KEYWORD_32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:97:12: ( '==' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:97:14: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_32"

    // $ANTLR start "KEYWORD_33"
    public final void mKEYWORD_33() throws RecognitionException {
        try {
            int _type = KEYWORD_33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:99:12: ( '=>' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:99:14: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_33"

    // $ANTLR start "KEYWORD_34"
    public final void mKEYWORD_34() throws RecognitionException {
        try {
            int _type = KEYWORD_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:101:12: ( '>=' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:101:14: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_34"

    // $ANTLR start "KEYWORD_35"
    public final void mKEYWORD_35() throws RecognitionException {
        try {
            int _type = KEYWORD_35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:103:12: ( 'as' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:103:14: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_35"

    // $ANTLR start "KEYWORD_36"
    public final void mKEYWORD_36() throws RecognitionException {
        try {
            int _type = KEYWORD_36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:105:12: ( '||' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:105:14: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_36"

    // $ANTLR start "KEYWORD_37"
    public final void mKEYWORD_37() throws RecognitionException {
        try {
            int _type = KEYWORD_37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:107:12: ( '~=' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:107:14: '~='
            {
            match("~="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_37"

    // $ANTLR start "KEYWORD_1"
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:109:11: ( '!' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:109:13: '!'
            {
            match('!'); 

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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:111:11: ( '%' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:111:13: '%'
            {
            match('%'); 

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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:113:11: ( '(' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:113:13: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:115:11: ( ')' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:115:13: ')'
            {
            match(')'); 

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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:117:11: ( '*' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:117:13: '*'
            {
            match('*'); 

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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:119:11: ( '+' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:119:13: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:121:11: ( ',' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:121:13: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_7"

    // $ANTLR start "KEYWORD_8"
    public final void mKEYWORD_8() throws RecognitionException {
        try {
            int _type = KEYWORD_8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:123:11: ( '-' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:123:13: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:125:11: ( '.' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:125:13: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:127:12: ( '/' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:127:14: '/'
            {
            match('/'); 

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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:129:12: ( ':' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:129:14: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_11"

    // $ANTLR start "KEYWORD_12"
    public final void mKEYWORD_12() throws RecognitionException {
        try {
            int _type = KEYWORD_12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:131:12: ( ';' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:131:14: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:133:12: ( '<' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:133:14: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_13"

    // $ANTLR start "KEYWORD_14"
    public final void mKEYWORD_14() throws RecognitionException {
        try {
            int _type = KEYWORD_14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:135:12: ( '=' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:135:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_14"

    // $ANTLR start "KEYWORD_15"
    public final void mKEYWORD_15() throws RecognitionException {
        try {
            int _type = KEYWORD_15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:137:12: ( '>' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:137:14: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_15"

    // $ANTLR start "KEYWORD_16"
    public final void mKEYWORD_16() throws RecognitionException {
        try {
            int _type = KEYWORD_16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:139:12: ( '[' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:139:14: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_16"

    // $ANTLR start "KEYWORD_17"
    public final void mKEYWORD_17() throws RecognitionException {
        try {
            int _type = KEYWORD_17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:141:12: ( ']' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:141:14: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_17"

    // $ANTLR start "KEYWORD_18"
    public final void mKEYWORD_18() throws RecognitionException {
        try {
            int _type = KEYWORD_18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:143:12: ( '{' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:143:14: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_18"

    // $ANTLR start "KEYWORD_19"
    public final void mKEYWORD_19() throws RecognitionException {
        try {
            int _type = KEYWORD_19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:145:12: ( '|' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:145:14: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_19"

    // $ANTLR start "KEYWORD_20"
    public final void mKEYWORD_20() throws RecognitionException {
        try {
            int _type = KEYWORD_20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:147:12: ( '}' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:147:14: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_20"

    // $ANTLR start "RULE_DOCUMENTATION"
    public final void mRULE_DOCUMENTATION() throws RecognitionException {
        try {
            int _type = RULE_DOCUMENTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:151:20: ( '/**' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:151:22: '/**' ( options {greedy=false; } : . )* '*/'
            {
            match("/**"); 

            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:151:28: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='.')||(LA1_1>='0' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=')')||(LA1_0>='+' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:151:56: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "RULE_DOCUMENTATION"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:153:10: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:153:12: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:153:26: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')||(LA2_0>='a' && LA2_0<='f')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:155:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:155:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:155:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:155:11: '^'
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

            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:155:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:
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
            	    break loop4;
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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:157:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:157:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:157:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:157:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:159:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop7;
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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:161:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:161:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:161:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:161:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:163:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:163:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:163:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:163:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop10;
                }
            } while (true);

            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:163:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:163:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:163:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:163:41: '\\r'
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:165:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:165:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:165:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:167:16: ( . )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:167:18: .
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
        // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:8: ( KEYWORD_64 | KEYWORD_65 | KEYWORD_62 | KEYWORD_63 | KEYWORD_59 | KEYWORD_60 | KEYWORD_61 | KEYWORD_56 | KEYWORD_57 | KEYWORD_58 | KEYWORD_52 | KEYWORD_53 | KEYWORD_54 | KEYWORD_55 | KEYWORD_50 | KEYWORD_51 | KEYWORD_45 | KEYWORD_46 | KEYWORD_47 | KEYWORD_48 | KEYWORD_49 | KEYWORD_38 | KEYWORD_39 | KEYWORD_40 | KEYWORD_41 | KEYWORD_42 | KEYWORD_43 | KEYWORD_44 | KEYWORD_21 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_25 | KEYWORD_26 | KEYWORD_27 | KEYWORD_28 | KEYWORD_29 | KEYWORD_30 | KEYWORD_31 | KEYWORD_32 | KEYWORD_33 | KEYWORD_34 | KEYWORD_35 | KEYWORD_36 | KEYWORD_37 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | KEYWORD_14 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_18 | KEYWORD_19 | KEYWORD_20 | RULE_DOCUMENTATION | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=74;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:10: KEYWORD_64
                {
                mKEYWORD_64(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:21: KEYWORD_65
                {
                mKEYWORD_65(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:32: KEYWORD_62
                {
                mKEYWORD_62(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:43: KEYWORD_63
                {
                mKEYWORD_63(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:54: KEYWORD_59
                {
                mKEYWORD_59(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:65: KEYWORD_60
                {
                mKEYWORD_60(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:76: KEYWORD_61
                {
                mKEYWORD_61(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:87: KEYWORD_56
                {
                mKEYWORD_56(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:98: KEYWORD_57
                {
                mKEYWORD_57(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:109: KEYWORD_58
                {
                mKEYWORD_58(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:120: KEYWORD_52
                {
                mKEYWORD_52(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:131: KEYWORD_53
                {
                mKEYWORD_53(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:142: KEYWORD_54
                {
                mKEYWORD_54(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:153: KEYWORD_55
                {
                mKEYWORD_55(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:164: KEYWORD_50
                {
                mKEYWORD_50(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:175: KEYWORD_51
                {
                mKEYWORD_51(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:186: KEYWORD_45
                {
                mKEYWORD_45(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:197: KEYWORD_46
                {
                mKEYWORD_46(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:208: KEYWORD_47
                {
                mKEYWORD_47(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:219: KEYWORD_48
                {
                mKEYWORD_48(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:230: KEYWORD_49
                {
                mKEYWORD_49(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:241: KEYWORD_38
                {
                mKEYWORD_38(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:252: KEYWORD_39
                {
                mKEYWORD_39(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:263: KEYWORD_40
                {
                mKEYWORD_40(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:274: KEYWORD_41
                {
                mKEYWORD_41(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:285: KEYWORD_42
                {
                mKEYWORD_42(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:296: KEYWORD_43
                {
                mKEYWORD_43(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:307: KEYWORD_44
                {
                mKEYWORD_44(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:318: KEYWORD_21
                {
                mKEYWORD_21(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:329: KEYWORD_22
                {
                mKEYWORD_22(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:340: KEYWORD_23
                {
                mKEYWORD_23(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:351: KEYWORD_24
                {
                mKEYWORD_24(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:362: KEYWORD_25
                {
                mKEYWORD_25(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:373: KEYWORD_26
                {
                mKEYWORD_26(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:384: KEYWORD_27
                {
                mKEYWORD_27(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:395: KEYWORD_28
                {
                mKEYWORD_28(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:406: KEYWORD_29
                {
                mKEYWORD_29(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:417: KEYWORD_30
                {
                mKEYWORD_30(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:428: KEYWORD_31
                {
                mKEYWORD_31(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:439: KEYWORD_32
                {
                mKEYWORD_32(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:450: KEYWORD_33
                {
                mKEYWORD_33(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:461: KEYWORD_34
                {
                mKEYWORD_34(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:472: KEYWORD_35
                {
                mKEYWORD_35(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:483: KEYWORD_36
                {
                mKEYWORD_36(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:494: KEYWORD_37
                {
                mKEYWORD_37(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:505: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:515: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:525: KEYWORD_3
                {
                mKEYWORD_3(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:535: KEYWORD_4
                {
                mKEYWORD_4(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:545: KEYWORD_5
                {
                mKEYWORD_5(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:555: KEYWORD_6
                {
                mKEYWORD_6(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:565: KEYWORD_7
                {
                mKEYWORD_7(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:575: KEYWORD_8
                {
                mKEYWORD_8(); 

                }
                break;
            case 54 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:585: KEYWORD_9
                {
                mKEYWORD_9(); 

                }
                break;
            case 55 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:595: KEYWORD_10
                {
                mKEYWORD_10(); 

                }
                break;
            case 56 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:606: KEYWORD_11
                {
                mKEYWORD_11(); 

                }
                break;
            case 57 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:617: KEYWORD_12
                {
                mKEYWORD_12(); 

                }
                break;
            case 58 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:628: KEYWORD_13
                {
                mKEYWORD_13(); 

                }
                break;
            case 59 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:639: KEYWORD_14
                {
                mKEYWORD_14(); 

                }
                break;
            case 60 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:650: KEYWORD_15
                {
                mKEYWORD_15(); 

                }
                break;
            case 61 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:661: KEYWORD_16
                {
                mKEYWORD_16(); 

                }
                break;
            case 62 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:672: KEYWORD_17
                {
                mKEYWORD_17(); 

                }
                break;
            case 63 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:683: KEYWORD_18
                {
                mKEYWORD_18(); 

                }
                break;
            case 64 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:694: KEYWORD_19
                {
                mKEYWORD_19(); 

                }
                break;
            case 65 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:705: KEYWORD_20
                {
                mKEYWORD_20(); 

                }
                break;
            case 66 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:716: RULE_DOCUMENTATION
                {
                mRULE_DOCUMENTATION(); 

                }
                break;
            case 67 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:735: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 68 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:744: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 69 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:752: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 70 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:761: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 71 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:773: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 72 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:789: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 73 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:805: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 74 :
                // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/backtracking/parser/antlr/lexer/InternalExBeeLangTestLanguageLexer.g:1:813: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\16\60\1\105\1\107\1\112\1\60\1\115\1\56\1\120\1\123\1\126"+
        "\1\132\1\134\1\136\1\60\1\141\1\56\11\uffff\1\155\1\56\2\uffff\2"+
        "\56\2\uffff\1\60\1\uffff\23\60\1\u0086\1\uffff\1\u0088\1\uffff\1"+
        "\u008a\2\uffff\1\60\23\uffff\1\u008e\20\uffff\12\60\1\u009a\1\u009b"+
        "\4\60\1\u00a0\4\60\6\uffff\1\u00a5\3\uffff\13\60\2\uffff\3\60\1"+
        "\u00b7\1\uffff\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\uffff\1\u008d\2"+
        "\uffff\2\60\1\u00bf\3\60\1\u00c3\7\60\5\uffff\1\u00cb\2\60\1\uffff"+
        "\3\60\1\uffff\2\60\1\u00d3\1\60\1\u00d5\1\u00d6\1\u00d7\1\uffff"+
        "\5\60\1\u00dd\1\u00de\1\uffff\1\u00df\3\uffff\1\u00e1\2\60\1\u00e4"+
        "\1\u00e5\5\uffff\2\60\3\uffff\1\u00eb\1\u00ec\4\uffff";
    static final String DFA14_eofS =
        "\u00ed\uffff";
    static final String DFA14_minS =
        "\1\0\1\145\1\155\1\162\1\151\1\165\2\141\1\162\1\165\1\157\1\141"+
        "\1\150\1\156\1\150\1\75\1\56\1\75\1\156\1\75\1\46\1\75\1\53\1\55"+
        "\1\52\2\75\1\163\1\174\1\75\11\uffff\1\130\1\101\2\uffff\2\0\2\uffff"+
        "\1\161\1\uffff\2\160\1\157\2\156\1\151\1\156\1\143\1\162\1\154\1"+
        "\145\1\164\1\165\1\155\1\167\2\151\1\145\1\164\1\75\1\uffff\1\56"+
        "\1\uffff\1\75\2\uffff\1\166\14\uffff\1\0\6\uffff\1\60\20\uffff\1"+
        "\165\1\154\1\165\1\160\1\143\1\141\1\154\1\164\1\150\1\163\2\60"+
        "\1\145\1\160\1\162\1\145\1\60\1\163\1\164\1\156\1\150\6\uffff\1"+
        "\60\1\0\2\uffff\1\151\1\145\1\164\1\145\1\151\1\164\1\154\1\144"+
        "\2\145\1\151\2\uffff\1\144\1\165\1\143\1\60\1\uffff\4\60\1\uffff"+
        "\3\0\1\162\1\155\1\60\1\162\1\144\1\151\1\60\1\145\1\170\1\144\1"+
        "\157\1\171\1\164\1\145\5\uffff\1\0\2\145\1\uffff\1\164\1\145\1\157"+
        "\1\uffff\1\162\1\164\1\60\1\156\3\60\1\uffff\1\163\1\156\1\151\1"+
        "\163\1\156\2\60\1\uffff\1\60\3\uffff\1\55\1\164\1\145\2\60\3\uffff"+
        "\1\155\1\uffff\2\163\2\uffff\1\141\2\60\4\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\145\1\156\1\162\2\165\1\157\1\145\1\162\1\165\1\157\1"+
        "\145\1\150\1\156\1\151\1\75\1\56\1\76\1\156\1\75\1\46\6\75\1\163"+
        "\1\174\1\75\11\uffff\1\170\1\172\2\uffff\2\uffff\2\uffff\1\161\1"+
        "\uffff\2\160\1\157\2\156\1\151\1\156\1\143\2\162\1\145\1\164\1\165"+
        "\1\155\1\167\2\151\1\145\1\164\1\75\1\uffff\1\56\1\uffff\1\75\2"+
        "\uffff\1\166\14\uffff\1\uffff\6\uffff\1\172\20\uffff\1\165\1\154"+
        "\1\165\1\166\1\143\1\141\1\154\1\164\1\150\1\163\2\172\1\145\1\160"+
        "\1\162\1\145\1\172\1\163\1\164\1\156\1\150\6\uffff\1\172\1\uffff"+
        "\2\uffff\1\151\1\145\1\164\1\145\1\151\1\164\1\154\1\144\2\145\1"+
        "\151\2\uffff\1\144\1\165\1\143\1\172\1\uffff\4\172\1\uffff\3\uffff"+
        "\1\162\1\155\1\172\1\162\1\144\1\151\1\172\1\145\1\170\1\144\1\157"+
        "\1\171\1\164\1\145\5\uffff\1\uffff\2\145\1\uffff\1\164\1\145\1\157"+
        "\1\uffff\1\162\1\164\1\172\1\156\3\172\1\uffff\1\163\1\156\1\151"+
        "\1\163\1\156\2\172\1\uffff\1\172\3\uffff\1\172\1\164\1\145\2\172"+
        "\3\uffff\1\155\1\uffff\2\163\2\uffff\1\151\2\172\4\uffff";
    static final String DFA14_acceptS =
        "\36\uffff\1\60\1\61\1\64\1\70\1\71\1\75\1\76\1\77\1\101\2\uffff"+
        "\1\104\1\105\2\uffff\1\111\1\112\1\uffff\1\104\24\uffff\1\56\1\uffff"+
        "\1\66\1\uffff\1\51\1\73\1\uffff\1\36\1\57\1\37\1\40\1\62\1\41\1"+
        "\42\1\63\1\43\1\44\1\65\1\46\1\uffff\1\110\1\67\1\47\1\72\1\52\1"+
        "\74\1\uffff\1\54\1\100\1\55\1\60\1\61\1\64\1\70\1\71\1\75\1\76\1"+
        "\77\1\101\1\103\1\105\1\106\1\111\25\uffff\1\26\1\35\1\27\1\45\1"+
        "\30\1\50\2\uffff\1\107\1\53\13\uffff\1\33\1\34\4\uffff\1\32\4\uffff"+
        "\1\31\21\uffff\1\21\1\22\1\23\1\24\1\25\3\uffff\1\20\3\uffff\1\17"+
        "\7\uffff\1\102\7\uffff\1\13\1\uffff\1\14\1\15\1\16\5\uffff\1\10"+
        "\1\11\1\12\1\uffff\1\7\2\uffff\1\6\1\5\3\uffff\1\1\1\2\1\3\1\4";
    static final String DFA14_specialS =
        "\1\5\52\uffff\1\10\1\2\53\uffff\1\7\63\uffff\1\1\31\uffff\1\4\1"+
        "\6\1\3\23\uffff\1\0\60\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\56\2\55\2\56\1\55\22\56\1\55\1\17\1\53\2\56\1\23\1\24\1"+
            "\54\1\36\1\37\1\25\1\26\1\40\1\27\1\20\1\30\1\47\11\52\1\41"+
            "\1\42\1\31\1\21\1\32\2\56\32\51\1\43\1\56\1\44\1\50\1\51\1\56"+
            "\1\33\1\5\1\6\1\51\1\22\1\4\1\10\1\51\1\2\4\51\1\13\1\11\1\3"+
            "\1\51\1\1\1\12\1\14\1\15\1\7\1\16\3\51\1\45\1\34\1\46\1\35\uff81"+
            "\56",
            "\1\57",
            "\1\61\1\62",
            "\1\63",
            "\1\65\13\uffff\1\64",
            "\1\66",
            "\1\70\15\uffff\1\67",
            "\1\72\3\uffff\1\71",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76\3\uffff\1\77",
            "\1\100",
            "\1\101",
            "\1\102\1\103",
            "\1\104",
            "\1\106",
            "\1\110\1\111",
            "\1\113",
            "\1\114",
            "\1\116",
            "\1\117",
            "\1\121\21\uffff\1\122",
            "\1\124\17\uffff\1\125",
            "\1\130\4\uffff\1\131\15\uffff\1\127",
            "\1\133",
            "\1\135",
            "\1\137",
            "\1\140",
            "\1\142",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\154\37\uffff\1\154",
            "\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "\0\156",
            "\0\156",
            "",
            "",
            "\1\160",
            "",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172\5\uffff\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\u0087",
            "",
            "\1\u0089",
            "",
            "",
            "\1\u008b",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\52\u008d\1\u008c\uffd5\u008d",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092\5\uffff\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\52\u00a8\1\u00a7\4\u00a8\1\u00a6\uffd0\u00a8",
            "",
            "",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "",
            "",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\52\u00a8\1\u00a7\uffd5\u00a8",
            "\52\u00a8\1\u00a7\4\u00a8\1\u00bc\uffd0\u00a8",
            "\52\u00a8\1\u00a7\uffd5\u00a8",
            "\1\u00bd",
            "\1\u00be",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "",
            "",
            "",
            "",
            "",
            "\52\u00a8\1\u00a7\uffd5\u00a8",
            "\1\u00cc",
            "\1\u00cd",
            "",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "",
            "\1\u00d1",
            "\1\u00d2",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00d4",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "\1\u00e0\2\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32"+
            "\60",
            "\1\u00e2",
            "\1\u00e3",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "\1\u00e6",
            "",
            "\1\u00e7",
            "\1\u00e8",
            "",
            "",
            "\1\u00e9\7\uffff\1\u00ea",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( KEYWORD_64 | KEYWORD_65 | KEYWORD_62 | KEYWORD_63 | KEYWORD_59 | KEYWORD_60 | KEYWORD_61 | KEYWORD_56 | KEYWORD_57 | KEYWORD_58 | KEYWORD_52 | KEYWORD_53 | KEYWORD_54 | KEYWORD_55 | KEYWORD_50 | KEYWORD_51 | KEYWORD_45 | KEYWORD_46 | KEYWORD_47 | KEYWORD_48 | KEYWORD_49 | KEYWORD_38 | KEYWORD_39 | KEYWORD_40 | KEYWORD_41 | KEYWORD_42 | KEYWORD_43 | KEYWORD_44 | KEYWORD_21 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_25 | KEYWORD_26 | KEYWORD_27 | KEYWORD_28 | KEYWORD_29 | KEYWORD_30 | KEYWORD_31 | KEYWORD_32 | KEYWORD_33 | KEYWORD_34 | KEYWORD_35 | KEYWORD_36 | KEYWORD_37 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | KEYWORD_14 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_18 | KEYWORD_19 | KEYWORD_20 | RULE_DOCUMENTATION | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_188 = input.LA(1);

                        s = -1;
                        if ( (LA14_188=='*') ) {s = 167;}

                        else if ( ((LA14_188>='\u0000' && LA14_188<=')')||(LA14_188>='+' && LA14_188<='\uFFFF')) ) {s = 168;}

                        else s = 203;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_140 = input.LA(1);

                        s = -1;
                        if ( (LA14_140=='/') ) {s = 166;}

                        else if ( (LA14_140=='*') ) {s = 167;}

                        else if ( ((LA14_140>='\u0000' && LA14_140<=')')||(LA14_140>='+' && LA14_140<='.')||(LA14_140>='0' && LA14_140<='\uFFFF')) ) {s = 168;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_44 = input.LA(1);

                        s = -1;
                        if ( ((LA14_44>='\u0000' && LA14_44<='\uFFFF')) ) {s = 110;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_168 = input.LA(1);

                        s = -1;
                        if ( (LA14_168=='*') ) {s = 167;}

                        else if ( ((LA14_168>='\u0000' && LA14_168<=')')||(LA14_168>='+' && LA14_168<='\uFFFF')) ) {s = 168;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA14_166 = input.LA(1);

                        s = -1;
                        if ( (LA14_166=='*') ) {s = 167;}

                        else if ( ((LA14_166>='\u0000' && LA14_166<=')')||(LA14_166>='+' && LA14_166<='\uFFFF')) ) {s = 168;}

                        else s = 141;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='r') ) {s = 1;}

                        else if ( (LA14_0=='i') ) {s = 2;}

                        else if ( (LA14_0=='p') ) {s = 3;}

                        else if ( (LA14_0=='f') ) {s = 4;}

                        else if ( (LA14_0=='b') ) {s = 5;}

                        else if ( (LA14_0=='c') ) {s = 6;}

                        else if ( (LA14_0=='v') ) {s = 7;}

                        else if ( (LA14_0=='g') ) {s = 8;}

                        else if ( (LA14_0=='o') ) {s = 9;}

                        else if ( (LA14_0=='s') ) {s = 10;}

                        else if ( (LA14_0=='n') ) {s = 11;}

                        else if ( (LA14_0=='t') ) {s = 12;}

                        else if ( (LA14_0=='u') ) {s = 13;}

                        else if ( (LA14_0=='w') ) {s = 14;}

                        else if ( (LA14_0=='!') ) {s = 15;}

                        else if ( (LA14_0=='.') ) {s = 16;}

                        else if ( (LA14_0=='=') ) {s = 17;}

                        else if ( (LA14_0=='e') ) {s = 18;}

                        else if ( (LA14_0=='%') ) {s = 19;}

                        else if ( (LA14_0=='&') ) {s = 20;}

                        else if ( (LA14_0=='*') ) {s = 21;}

                        else if ( (LA14_0=='+') ) {s = 22;}

                        else if ( (LA14_0=='-') ) {s = 23;}

                        else if ( (LA14_0=='/') ) {s = 24;}

                        else if ( (LA14_0=='<') ) {s = 25;}

                        else if ( (LA14_0=='>') ) {s = 26;}

                        else if ( (LA14_0=='a') ) {s = 27;}

                        else if ( (LA14_0=='|') ) {s = 28;}

                        else if ( (LA14_0=='~') ) {s = 29;}

                        else if ( (LA14_0=='(') ) {s = 30;}

                        else if ( (LA14_0==')') ) {s = 31;}

                        else if ( (LA14_0==',') ) {s = 32;}

                        else if ( (LA14_0==':') ) {s = 33;}

                        else if ( (LA14_0==';') ) {s = 34;}

                        else if ( (LA14_0=='[') ) {s = 35;}

                        else if ( (LA14_0==']') ) {s = 36;}

                        else if ( (LA14_0=='{') ) {s = 37;}

                        else if ( (LA14_0=='}') ) {s = 38;}

                        else if ( (LA14_0=='0') ) {s = 39;}

                        else if ( (LA14_0=='^') ) {s = 40;}

                        else if ( ((LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||LA14_0=='d'||LA14_0=='h'||(LA14_0>='j' && LA14_0<='m')||LA14_0=='q'||(LA14_0>='x' && LA14_0<='z')) ) {s = 41;}

                        else if ( ((LA14_0>='1' && LA14_0<='9')) ) {s = 42;}

                        else if ( (LA14_0=='\"') ) {s = 43;}

                        else if ( (LA14_0=='\'') ) {s = 44;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 45;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||(LA14_0>='#' && LA14_0<='$')||(LA14_0>='?' && LA14_0<='@')||LA14_0=='\\'||LA14_0=='`'||(LA14_0>='\u007F' && LA14_0<='\uFFFF')) ) {s = 46;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA14_167 = input.LA(1);

                        s = -1;
                        if ( (LA14_167=='/') ) {s = 188;}

                        else if ( (LA14_167=='*') ) {s = 167;}

                        else if ( ((LA14_167>='\u0000' && LA14_167<=')')||(LA14_167>='+' && LA14_167<='.')||(LA14_167>='0' && LA14_167<='\uFFFF')) ) {s = 168;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA14_88 = input.LA(1);

                        s = -1;
                        if ( (LA14_88=='*') ) {s = 140;}

                        else if ( ((LA14_88>='\u0000' && LA14_88<=')')||(LA14_88>='+' && LA14_88<='\uFFFF')) ) {s = 141;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA14_43 = input.LA(1);

                        s = -1;
                        if ( ((LA14_43>='\u0000' && LA14_43<='\uFFFF')) ) {s = 110;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}