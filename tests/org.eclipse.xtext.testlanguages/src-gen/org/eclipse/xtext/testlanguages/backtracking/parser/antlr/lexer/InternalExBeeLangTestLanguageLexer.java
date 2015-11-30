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
    public static final int RULE_ID=71;
    public static final int VerticalLineVerticalLine=47;
    public static final int HyphenMinus=56;
    public static final int RightParenthesis=52;
    public static final int AmpersandAmpersand=34;
    public static final int Output=16;
    public static final int RULE_ANY_OTHER=77;
    public static final int ExclamationMark=49;
    public static final int LeftParenthesis=51;
    public static final int RightSquareBracket=65;
    public static final int Final=18;
    public static final int Context=12;
    public static final int Solidus=58;
    public static final int EOF=-1;
    public static final int GreaterThanSign=63;
    public static final int EqualsSignEqualsSign=43;
    public static final int FullStop=57;
    public static final int Version=13;
    public static final int PercentSign=50;
    public static final int RULE_HEX=70;
    public static final int FullStopFullStopFullStop=26;
    public static final int HyphenMinusHyphenMinus=38;
    public static final int EqualsSignGreaterThanSign=44;
    public static final int LessThanSign=61;
    public static final int When=23;
    public static final int Implements=6;
    public static final int Source=17;
    public static final int RULE_INT=72;
    public static final int EqualsSignEqualsSignEqualsSign=27;
    public static final int TildeEqualsSign=48;
    public static final int PlusSignPlusSign=36;
    public static final int LeftSquareBracket=64;
    public static final int FullStopFullStop=40;
    public static final int Provides=9;
    public static final int PercentSignEqualsSign=33;
    public static final int ExclamationMarkEqualsSign=32;
    public static final int Asterisk=53;
    public static final int Requires=10;
    public static final int RequiresMin=5;
    public static final int As=46;
    public static final int RequiresMax=4;
    public static final int Cached=14;
    public static final int Greedy=15;
    public static final int This=21;
    public static final int Unit=22;
    public static final int Properties=7;
    public static final int SolidusEqualsSign=41;
    public static final int LessThanSignEqualsSign=42;
    public static final int LeftCurlyBracket=66;
    public static final int Colon=59;
    public static final int Semicolon=60;
    public static final int Builder=11;
    public static final int RULE_SL_COMMENT=75;
    public static final int With=24;
    public static final int RULE_ML_COMMENT=74;
    public static final int Input=19;
    public static final int RULE_STRING=73;
    public static final int PlusSign=54;
    public static final int RULE_DOCUMENTATION=69;
    public static final int Function=8;
    public static final int VerticalLine=67;
    public static final int New=29;
    public static final int AsteriskEqualsSign=35;
    public static final int HyphenMinusEqualsSign=39;
    public static final int Name=20;
    public static final int Env=28;
    public static final int PlusSignEqualsSign=37;
    public static final int GreaterThanSignEqualsSign=45;
    public static final int ExclamationMarkEqualsSignEqualsSign=25;
    public static final int RULE_WS=76;
    public static final int EqualsSign=62;
    public static final int Comma=55;
    public static final int Val=30;
    public static final int Var=31;
    public static final int RightCurlyBracket=68;

    // delegates
    // delegators

    public InternalExBeeLangTestLanguageLexer() {;} 
    public InternalExBeeLangTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalExBeeLangTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalExBeeLangTestLanguageLexer.g"; }

    // $ANTLR start "RequiresMax"
    public final void mRequiresMax() throws RecognitionException {
        try {
            int _type = RequiresMax;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:14:13: ( 'requires-max' )
            // InternalExBeeLangTestLanguageLexer.g:14:15: 'requires-max'
            {
            match("requires-max"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RequiresMax"

    // $ANTLR start "RequiresMin"
    public final void mRequiresMin() throws RecognitionException {
        try {
            int _type = RequiresMin;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:16:13: ( 'requires-min' )
            // InternalExBeeLangTestLanguageLexer.g:16:15: 'requires-min'
            {
            match("requires-min"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RequiresMin"

    // $ANTLR start "Implements"
    public final void mImplements() throws RecognitionException {
        try {
            int _type = Implements;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:18:12: ( 'implements' )
            // InternalExBeeLangTestLanguageLexer.g:18:14: 'implements'
            {
            match("implements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Implements"

    // $ANTLR start "Properties"
    public final void mProperties() throws RecognitionException {
        try {
            int _type = Properties;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:20:12: ( 'properties' )
            // InternalExBeeLangTestLanguageLexer.g:20:14: 'properties'
            {
            match("properties"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Properties"

    // $ANTLR start "Function"
    public final void mFunction() throws RecognitionException {
        try {
            int _type = Function;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:22:10: ( 'function' )
            // InternalExBeeLangTestLanguageLexer.g:22:12: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Function"

    // $ANTLR start "Provides"
    public final void mProvides() throws RecognitionException {
        try {
            int _type = Provides;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:24:10: ( 'provides' )
            // InternalExBeeLangTestLanguageLexer.g:24:12: 'provides'
            {
            match("provides"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Provides"

    // $ANTLR start "Requires"
    public final void mRequires() throws RecognitionException {
        try {
            int _type = Requires;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:26:10: ( 'requires' )
            // InternalExBeeLangTestLanguageLexer.g:26:12: 'requires'
            {
            match("requires"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Requires"

    // $ANTLR start "Builder"
    public final void mBuilder() throws RecognitionException {
        try {
            int _type = Builder;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:28:9: ( 'builder' )
            // InternalExBeeLangTestLanguageLexer.g:28:11: 'builder'
            {
            match("builder"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Builder"

    // $ANTLR start "Context"
    public final void mContext() throws RecognitionException {
        try {
            int _type = Context;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:30:9: ( 'context' )
            // InternalExBeeLangTestLanguageLexer.g:30:11: 'context'
            {
            match("context"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Context"

    // $ANTLR start "Version"
    public final void mVersion() throws RecognitionException {
        try {
            int _type = Version;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:32:9: ( 'version' )
            // InternalExBeeLangTestLanguageLexer.g:32:11: 'version'
            {
            match("version"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Version"

    // $ANTLR start "Cached"
    public final void mCached() throws RecognitionException {
        try {
            int _type = Cached;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:34:8: ( 'cached' )
            // InternalExBeeLangTestLanguageLexer.g:34:10: 'cached'
            {
            match("cached"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Cached"

    // $ANTLR start "Greedy"
    public final void mGreedy() throws RecognitionException {
        try {
            int _type = Greedy;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:36:8: ( 'greedy' )
            // InternalExBeeLangTestLanguageLexer.g:36:10: 'greedy'
            {
            match("greedy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Greedy"

    // $ANTLR start "Output"
    public final void mOutput() throws RecognitionException {
        try {
            int _type = Output;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:38:8: ( 'output' )
            // InternalExBeeLangTestLanguageLexer.g:38:10: 'output'
            {
            match("output"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Output"

    // $ANTLR start "Source"
    public final void mSource() throws RecognitionException {
        try {
            int _type = Source;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:40:8: ( 'source' )
            // InternalExBeeLangTestLanguageLexer.g:40:10: 'source'
            {
            match("source"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Source"

    // $ANTLR start "Final"
    public final void mFinal() throws RecognitionException {
        try {
            int _type = Final;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:42:7: ( 'final' )
            // InternalExBeeLangTestLanguageLexer.g:42:9: 'final'
            {
            match("final"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Final"

    // $ANTLR start "Input"
    public final void mInput() throws RecognitionException {
        try {
            int _type = Input;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:44:7: ( 'input' )
            // InternalExBeeLangTestLanguageLexer.g:44:9: 'input'
            {
            match("input"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Input"

    // $ANTLR start "Name"
    public final void mName() throws RecognitionException {
        try {
            int _type = Name;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:46:6: ( 'name' )
            // InternalExBeeLangTestLanguageLexer.g:46:8: 'name'
            {
            match("name"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Name"

    // $ANTLR start "This"
    public final void mThis() throws RecognitionException {
        try {
            int _type = This;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:48:6: ( 'this' )
            // InternalExBeeLangTestLanguageLexer.g:48:8: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "This"

    // $ANTLR start "Unit"
    public final void mUnit() throws RecognitionException {
        try {
            int _type = Unit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:50:6: ( 'unit' )
            // InternalExBeeLangTestLanguageLexer.g:50:8: 'unit'
            {
            match("unit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Unit"

    // $ANTLR start "When"
    public final void mWhen() throws RecognitionException {
        try {
            int _type = When;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:52:6: ( 'when' )
            // InternalExBeeLangTestLanguageLexer.g:52:8: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "When"

    // $ANTLR start "With"
    public final void mWith() throws RecognitionException {
        try {
            int _type = With;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:54:6: ( 'with' )
            // InternalExBeeLangTestLanguageLexer.g:54:8: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "With"

    // $ANTLR start "ExclamationMarkEqualsSignEqualsSign"
    public final void mExclamationMarkEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:56:37: ( '!==' )
            // InternalExBeeLangTestLanguageLexer.g:56:39: '!=='
            {
            match("!=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMarkEqualsSignEqualsSign"

    // $ANTLR start "FullStopFullStopFullStop"
    public final void mFullStopFullStopFullStop() throws RecognitionException {
        try {
            int _type = FullStopFullStopFullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:58:26: ( '...' )
            // InternalExBeeLangTestLanguageLexer.g:58:28: '...'
            {
            match("..."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopFullStopFullStop"

    // $ANTLR start "EqualsSignEqualsSignEqualsSign"
    public final void mEqualsSignEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:60:32: ( '===' )
            // InternalExBeeLangTestLanguageLexer.g:60:34: '==='
            {
            match("==="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignEqualsSignEqualsSign"

    // $ANTLR start "Env"
    public final void mEnv() throws RecognitionException {
        try {
            int _type = Env;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:62:5: ( 'env' )
            // InternalExBeeLangTestLanguageLexer.g:62:7: 'env'
            {
            match("env"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Env"

    // $ANTLR start "New"
    public final void mNew() throws RecognitionException {
        try {
            int _type = New;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:64:5: ( 'new' )
            // InternalExBeeLangTestLanguageLexer.g:64:7: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "New"

    // $ANTLR start "Val"
    public final void mVal() throws RecognitionException {
        try {
            int _type = Val;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:66:5: ( 'val' )
            // InternalExBeeLangTestLanguageLexer.g:66:7: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Val"

    // $ANTLR start "Var"
    public final void mVar() throws RecognitionException {
        try {
            int _type = Var;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:68:5: ( 'var' )
            // InternalExBeeLangTestLanguageLexer.g:68:7: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Var"

    // $ANTLR start "ExclamationMarkEqualsSign"
    public final void mExclamationMarkEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:70:27: ( '!=' )
            // InternalExBeeLangTestLanguageLexer.g:70:29: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMarkEqualsSign"

    // $ANTLR start "PercentSignEqualsSign"
    public final void mPercentSignEqualsSign() throws RecognitionException {
        try {
            int _type = PercentSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:72:23: ( '%=' )
            // InternalExBeeLangTestLanguageLexer.g:72:25: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PercentSignEqualsSign"

    // $ANTLR start "AmpersandAmpersand"
    public final void mAmpersandAmpersand() throws RecognitionException {
        try {
            int _type = AmpersandAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:74:20: ( '&&' )
            // InternalExBeeLangTestLanguageLexer.g:74:22: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AmpersandAmpersand"

    // $ANTLR start "AsteriskEqualsSign"
    public final void mAsteriskEqualsSign() throws RecognitionException {
        try {
            int _type = AsteriskEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:76:20: ( '*=' )
            // InternalExBeeLangTestLanguageLexer.g:76:22: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AsteriskEqualsSign"

    // $ANTLR start "PlusSignPlusSign"
    public final void mPlusSignPlusSign() throws RecognitionException {
        try {
            int _type = PlusSignPlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:78:18: ( '++' )
            // InternalExBeeLangTestLanguageLexer.g:78:20: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSignPlusSign"

    // $ANTLR start "PlusSignEqualsSign"
    public final void mPlusSignEqualsSign() throws RecognitionException {
        try {
            int _type = PlusSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:80:20: ( '+=' )
            // InternalExBeeLangTestLanguageLexer.g:80:22: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSignEqualsSign"

    // $ANTLR start "HyphenMinusHyphenMinus"
    public final void mHyphenMinusHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinusHyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:82:24: ( '--' )
            // InternalExBeeLangTestLanguageLexer.g:82:26: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusHyphenMinus"

    // $ANTLR start "HyphenMinusEqualsSign"
    public final void mHyphenMinusEqualsSign() throws RecognitionException {
        try {
            int _type = HyphenMinusEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:84:23: ( '-=' )
            // InternalExBeeLangTestLanguageLexer.g:84:25: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusEqualsSign"

    // $ANTLR start "FullStopFullStop"
    public final void mFullStopFullStop() throws RecognitionException {
        try {
            int _type = FullStopFullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:86:18: ( '..' )
            // InternalExBeeLangTestLanguageLexer.g:86:20: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopFullStop"

    // $ANTLR start "SolidusEqualsSign"
    public final void mSolidusEqualsSign() throws RecognitionException {
        try {
            int _type = SolidusEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:88:19: ( '/=' )
            // InternalExBeeLangTestLanguageLexer.g:88:21: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SolidusEqualsSign"

    // $ANTLR start "LessThanSignEqualsSign"
    public final void mLessThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = LessThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:90:24: ( '<=' )
            // InternalExBeeLangTestLanguageLexer.g:90:26: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignEqualsSign"

    // $ANTLR start "EqualsSignEqualsSign"
    public final void mEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:92:22: ( '==' )
            // InternalExBeeLangTestLanguageLexer.g:92:24: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignEqualsSign"

    // $ANTLR start "EqualsSignGreaterThanSign"
    public final void mEqualsSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = EqualsSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:94:27: ( '=>' )
            // InternalExBeeLangTestLanguageLexer.g:94:29: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignGreaterThanSign"

    // $ANTLR start "GreaterThanSignEqualsSign"
    public final void mGreaterThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:96:27: ( '>=' )
            // InternalExBeeLangTestLanguageLexer.g:96:29: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignEqualsSign"

    // $ANTLR start "As"
    public final void mAs() throws RecognitionException {
        try {
            int _type = As;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:98:4: ( 'as' )
            // InternalExBeeLangTestLanguageLexer.g:98:6: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "As"

    // $ANTLR start "VerticalLineVerticalLine"
    public final void mVerticalLineVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLineVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:100:26: ( '||' )
            // InternalExBeeLangTestLanguageLexer.g:100:28: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLineVerticalLine"

    // $ANTLR start "TildeEqualsSign"
    public final void mTildeEqualsSign() throws RecognitionException {
        try {
            int _type = TildeEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:102:17: ( '~=' )
            // InternalExBeeLangTestLanguageLexer.g:102:19: '~='
            {
            match("~="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TildeEqualsSign"

    // $ANTLR start "ExclamationMark"
    public final void mExclamationMark() throws RecognitionException {
        try {
            int _type = ExclamationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:104:17: ( '!' )
            // InternalExBeeLangTestLanguageLexer.g:104:19: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMark"

    // $ANTLR start "PercentSign"
    public final void mPercentSign() throws RecognitionException {
        try {
            int _type = PercentSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:106:13: ( '%' )
            // InternalExBeeLangTestLanguageLexer.g:106:15: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PercentSign"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:108:17: ( '(' )
            // InternalExBeeLangTestLanguageLexer.g:108:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:110:18: ( ')' )
            // InternalExBeeLangTestLanguageLexer.g:110:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Asterisk"
    public final void mAsterisk() throws RecognitionException {
        try {
            int _type = Asterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:112:10: ( '*' )
            // InternalExBeeLangTestLanguageLexer.g:112:12: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Asterisk"

    // $ANTLR start "PlusSign"
    public final void mPlusSign() throws RecognitionException {
        try {
            int _type = PlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:114:10: ( '+' )
            // InternalExBeeLangTestLanguageLexer.g:114:12: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSign"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:116:7: ( ',' )
            // InternalExBeeLangTestLanguageLexer.g:116:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "HyphenMinus"
    public final void mHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:118:13: ( '-' )
            // InternalExBeeLangTestLanguageLexer.g:118:15: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinus"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:120:10: ( '.' )
            // InternalExBeeLangTestLanguageLexer.g:120:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStop"

    // $ANTLR start "Solidus"
    public final void mSolidus() throws RecognitionException {
        try {
            int _type = Solidus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:122:9: ( '/' )
            // InternalExBeeLangTestLanguageLexer.g:122:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Solidus"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:124:7: ( ':' )
            // InternalExBeeLangTestLanguageLexer.g:124:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:126:11: ( ';' )
            // InternalExBeeLangTestLanguageLexer.g:126:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Semicolon"

    // $ANTLR start "LessThanSign"
    public final void mLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:128:14: ( '<' )
            // InternalExBeeLangTestLanguageLexer.g:128:16: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSign"

    // $ANTLR start "EqualsSign"
    public final void mEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:130:12: ( '=' )
            // InternalExBeeLangTestLanguageLexer.g:130:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSign"

    // $ANTLR start "GreaterThanSign"
    public final void mGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:132:17: ( '>' )
            // InternalExBeeLangTestLanguageLexer.g:132:19: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSign"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:134:19: ( '[' )
            // InternalExBeeLangTestLanguageLexer.g:134:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:136:20: ( ']' )
            // InternalExBeeLangTestLanguageLexer.g:136:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:138:18: ( '{' )
            // InternalExBeeLangTestLanguageLexer.g:138:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "VerticalLine"
    public final void mVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:140:14: ( '|' )
            // InternalExBeeLangTestLanguageLexer.g:140:16: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLine"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:142:19: ( '}' )
            // InternalExBeeLangTestLanguageLexer.g:142:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_DOCUMENTATION"
    public final void mRULE_DOCUMENTATION() throws RecognitionException {
        try {
            int _type = RULE_DOCUMENTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExBeeLangTestLanguageLexer.g:146:20: ( '/**' ( options {greedy=false; } : . )* '*/' )
            // InternalExBeeLangTestLanguageLexer.g:146:22: '/**' ( options {greedy=false; } : . )* '*/'
            {
            match("/**"); 

            // InternalExBeeLangTestLanguageLexer.g:146:28: ( options {greedy=false; } : . )*
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
            	    // InternalExBeeLangTestLanguageLexer.g:146:56: .
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
            // InternalExBeeLangTestLanguageLexer.g:148:10: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalExBeeLangTestLanguageLexer.g:148:12: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalExBeeLangTestLanguageLexer.g:148:26: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
            	    // InternalExBeeLangTestLanguageLexer.g:
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
            // InternalExBeeLangTestLanguageLexer.g:150:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalExBeeLangTestLanguageLexer.g:150:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalExBeeLangTestLanguageLexer.g:150:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalExBeeLangTestLanguageLexer.g:150:11: '^'
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

            // InternalExBeeLangTestLanguageLexer.g:150:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageLexer.g:
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
            // InternalExBeeLangTestLanguageLexer.g:152:10: ( ( '0' .. '9' )+ )
            // InternalExBeeLangTestLanguageLexer.g:152:12: ( '0' .. '9' )+
            {
            // InternalExBeeLangTestLanguageLexer.g:152:12: ( '0' .. '9' )+
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
            	    // InternalExBeeLangTestLanguageLexer.g:152:13: '0' .. '9'
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
            // InternalExBeeLangTestLanguageLexer.g:154:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalExBeeLangTestLanguageLexer.g:154:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalExBeeLangTestLanguageLexer.g:154:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalExBeeLangTestLanguageLexer.g:154:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalExBeeLangTestLanguageLexer.g:154:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalExBeeLangTestLanguageLexer.g:154:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalExBeeLangTestLanguageLexer.g:154:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalExBeeLangTestLanguageLexer.g:154:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalExBeeLangTestLanguageLexer.g:154:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalExBeeLangTestLanguageLexer.g:154:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalExBeeLangTestLanguageLexer.g:154:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalExBeeLangTestLanguageLexer.g:156:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalExBeeLangTestLanguageLexer.g:156:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalExBeeLangTestLanguageLexer.g:156:24: ( options {greedy=false; } : . )*
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
            	    // InternalExBeeLangTestLanguageLexer.g:156:52: .
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
            // InternalExBeeLangTestLanguageLexer.g:158:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalExBeeLangTestLanguageLexer.g:158:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalExBeeLangTestLanguageLexer.g:158:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageLexer.g:158:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalExBeeLangTestLanguageLexer.g:158:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalExBeeLangTestLanguageLexer.g:158:41: ( '\\r' )? '\\n'
                    {
                    // InternalExBeeLangTestLanguageLexer.g:158:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalExBeeLangTestLanguageLexer.g:158:41: '\\r'
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
            // InternalExBeeLangTestLanguageLexer.g:160:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalExBeeLangTestLanguageLexer.g:160:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalExBeeLangTestLanguageLexer.g:160:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalExBeeLangTestLanguageLexer.g:
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
            // InternalExBeeLangTestLanguageLexer.g:162:16: ( . )
            // InternalExBeeLangTestLanguageLexer.g:162:18: .
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
        // InternalExBeeLangTestLanguageLexer.g:1:8: ( RequiresMax | RequiresMin | Implements | Properties | Function | Provides | Requires | Builder | Context | Version | Cached | Greedy | Output | Source | Final | Input | Name | This | Unit | When | With | ExclamationMarkEqualsSignEqualsSign | FullStopFullStopFullStop | EqualsSignEqualsSignEqualsSign | Env | New | Val | Var | ExclamationMarkEqualsSign | PercentSignEqualsSign | AmpersandAmpersand | AsteriskEqualsSign | PlusSignPlusSign | PlusSignEqualsSign | HyphenMinusHyphenMinus | HyphenMinusEqualsSign | FullStopFullStop | SolidusEqualsSign | LessThanSignEqualsSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | As | VerticalLineVerticalLine | TildeEqualsSign | ExclamationMark | PercentSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_DOCUMENTATION | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=74;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // InternalExBeeLangTestLanguageLexer.g:1:10: RequiresMax
                {
                mRequiresMax(); 

                }
                break;
            case 2 :
                // InternalExBeeLangTestLanguageLexer.g:1:22: RequiresMin
                {
                mRequiresMin(); 

                }
                break;
            case 3 :
                // InternalExBeeLangTestLanguageLexer.g:1:34: Implements
                {
                mImplements(); 

                }
                break;
            case 4 :
                // InternalExBeeLangTestLanguageLexer.g:1:45: Properties
                {
                mProperties(); 

                }
                break;
            case 5 :
                // InternalExBeeLangTestLanguageLexer.g:1:56: Function
                {
                mFunction(); 

                }
                break;
            case 6 :
                // InternalExBeeLangTestLanguageLexer.g:1:65: Provides
                {
                mProvides(); 

                }
                break;
            case 7 :
                // InternalExBeeLangTestLanguageLexer.g:1:74: Requires
                {
                mRequires(); 

                }
                break;
            case 8 :
                // InternalExBeeLangTestLanguageLexer.g:1:83: Builder
                {
                mBuilder(); 

                }
                break;
            case 9 :
                // InternalExBeeLangTestLanguageLexer.g:1:91: Context
                {
                mContext(); 

                }
                break;
            case 10 :
                // InternalExBeeLangTestLanguageLexer.g:1:99: Version
                {
                mVersion(); 

                }
                break;
            case 11 :
                // InternalExBeeLangTestLanguageLexer.g:1:107: Cached
                {
                mCached(); 

                }
                break;
            case 12 :
                // InternalExBeeLangTestLanguageLexer.g:1:114: Greedy
                {
                mGreedy(); 

                }
                break;
            case 13 :
                // InternalExBeeLangTestLanguageLexer.g:1:121: Output
                {
                mOutput(); 

                }
                break;
            case 14 :
                // InternalExBeeLangTestLanguageLexer.g:1:128: Source
                {
                mSource(); 

                }
                break;
            case 15 :
                // InternalExBeeLangTestLanguageLexer.g:1:135: Final
                {
                mFinal(); 

                }
                break;
            case 16 :
                // InternalExBeeLangTestLanguageLexer.g:1:141: Input
                {
                mInput(); 

                }
                break;
            case 17 :
                // InternalExBeeLangTestLanguageLexer.g:1:147: Name
                {
                mName(); 

                }
                break;
            case 18 :
                // InternalExBeeLangTestLanguageLexer.g:1:152: This
                {
                mThis(); 

                }
                break;
            case 19 :
                // InternalExBeeLangTestLanguageLexer.g:1:157: Unit
                {
                mUnit(); 

                }
                break;
            case 20 :
                // InternalExBeeLangTestLanguageLexer.g:1:162: When
                {
                mWhen(); 

                }
                break;
            case 21 :
                // InternalExBeeLangTestLanguageLexer.g:1:167: With
                {
                mWith(); 

                }
                break;
            case 22 :
                // InternalExBeeLangTestLanguageLexer.g:1:172: ExclamationMarkEqualsSignEqualsSign
                {
                mExclamationMarkEqualsSignEqualsSign(); 

                }
                break;
            case 23 :
                // InternalExBeeLangTestLanguageLexer.g:1:208: FullStopFullStopFullStop
                {
                mFullStopFullStopFullStop(); 

                }
                break;
            case 24 :
                // InternalExBeeLangTestLanguageLexer.g:1:233: EqualsSignEqualsSignEqualsSign
                {
                mEqualsSignEqualsSignEqualsSign(); 

                }
                break;
            case 25 :
                // InternalExBeeLangTestLanguageLexer.g:1:264: Env
                {
                mEnv(); 

                }
                break;
            case 26 :
                // InternalExBeeLangTestLanguageLexer.g:1:268: New
                {
                mNew(); 

                }
                break;
            case 27 :
                // InternalExBeeLangTestLanguageLexer.g:1:272: Val
                {
                mVal(); 

                }
                break;
            case 28 :
                // InternalExBeeLangTestLanguageLexer.g:1:276: Var
                {
                mVar(); 

                }
                break;
            case 29 :
                // InternalExBeeLangTestLanguageLexer.g:1:280: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 30 :
                // InternalExBeeLangTestLanguageLexer.g:1:306: PercentSignEqualsSign
                {
                mPercentSignEqualsSign(); 

                }
                break;
            case 31 :
                // InternalExBeeLangTestLanguageLexer.g:1:328: AmpersandAmpersand
                {
                mAmpersandAmpersand(); 

                }
                break;
            case 32 :
                // InternalExBeeLangTestLanguageLexer.g:1:347: AsteriskEqualsSign
                {
                mAsteriskEqualsSign(); 

                }
                break;
            case 33 :
                // InternalExBeeLangTestLanguageLexer.g:1:366: PlusSignPlusSign
                {
                mPlusSignPlusSign(); 

                }
                break;
            case 34 :
                // InternalExBeeLangTestLanguageLexer.g:1:383: PlusSignEqualsSign
                {
                mPlusSignEqualsSign(); 

                }
                break;
            case 35 :
                // InternalExBeeLangTestLanguageLexer.g:1:402: HyphenMinusHyphenMinus
                {
                mHyphenMinusHyphenMinus(); 

                }
                break;
            case 36 :
                // InternalExBeeLangTestLanguageLexer.g:1:425: HyphenMinusEqualsSign
                {
                mHyphenMinusEqualsSign(); 

                }
                break;
            case 37 :
                // InternalExBeeLangTestLanguageLexer.g:1:447: FullStopFullStop
                {
                mFullStopFullStop(); 

                }
                break;
            case 38 :
                // InternalExBeeLangTestLanguageLexer.g:1:464: SolidusEqualsSign
                {
                mSolidusEqualsSign(); 

                }
                break;
            case 39 :
                // InternalExBeeLangTestLanguageLexer.g:1:482: LessThanSignEqualsSign
                {
                mLessThanSignEqualsSign(); 

                }
                break;
            case 40 :
                // InternalExBeeLangTestLanguageLexer.g:1:505: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 41 :
                // InternalExBeeLangTestLanguageLexer.g:1:526: EqualsSignGreaterThanSign
                {
                mEqualsSignGreaterThanSign(); 

                }
                break;
            case 42 :
                // InternalExBeeLangTestLanguageLexer.g:1:552: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 43 :
                // InternalExBeeLangTestLanguageLexer.g:1:578: As
                {
                mAs(); 

                }
                break;
            case 44 :
                // InternalExBeeLangTestLanguageLexer.g:1:581: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 45 :
                // InternalExBeeLangTestLanguageLexer.g:1:606: TildeEqualsSign
                {
                mTildeEqualsSign(); 

                }
                break;
            case 46 :
                // InternalExBeeLangTestLanguageLexer.g:1:622: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 47 :
                // InternalExBeeLangTestLanguageLexer.g:1:638: PercentSign
                {
                mPercentSign(); 

                }
                break;
            case 48 :
                // InternalExBeeLangTestLanguageLexer.g:1:650: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 49 :
                // InternalExBeeLangTestLanguageLexer.g:1:666: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 50 :
                // InternalExBeeLangTestLanguageLexer.g:1:683: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 51 :
                // InternalExBeeLangTestLanguageLexer.g:1:692: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 52 :
                // InternalExBeeLangTestLanguageLexer.g:1:701: Comma
                {
                mComma(); 

                }
                break;
            case 53 :
                // InternalExBeeLangTestLanguageLexer.g:1:707: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 54 :
                // InternalExBeeLangTestLanguageLexer.g:1:719: FullStop
                {
                mFullStop(); 

                }
                break;
            case 55 :
                // InternalExBeeLangTestLanguageLexer.g:1:728: Solidus
                {
                mSolidus(); 

                }
                break;
            case 56 :
                // InternalExBeeLangTestLanguageLexer.g:1:736: Colon
                {
                mColon(); 

                }
                break;
            case 57 :
                // InternalExBeeLangTestLanguageLexer.g:1:742: Semicolon
                {
                mSemicolon(); 

                }
                break;
            case 58 :
                // InternalExBeeLangTestLanguageLexer.g:1:752: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 59 :
                // InternalExBeeLangTestLanguageLexer.g:1:765: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 60 :
                // InternalExBeeLangTestLanguageLexer.g:1:776: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 61 :
                // InternalExBeeLangTestLanguageLexer.g:1:792: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 62 :
                // InternalExBeeLangTestLanguageLexer.g:1:810: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 63 :
                // InternalExBeeLangTestLanguageLexer.g:1:829: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 64 :
                // InternalExBeeLangTestLanguageLexer.g:1:846: VerticalLine
                {
                mVerticalLine(); 

                }
                break;
            case 65 :
                // InternalExBeeLangTestLanguageLexer.g:1:859: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 66 :
                // InternalExBeeLangTestLanguageLexer.g:1:877: RULE_DOCUMENTATION
                {
                mRULE_DOCUMENTATION(); 

                }
                break;
            case 67 :
                // InternalExBeeLangTestLanguageLexer.g:1:896: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 68 :
                // InternalExBeeLangTestLanguageLexer.g:1:905: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 69 :
                // InternalExBeeLangTestLanguageLexer.g:1:913: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 70 :
                // InternalExBeeLangTestLanguageLexer.g:1:922: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 71 :
                // InternalExBeeLangTestLanguageLexer.g:1:934: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 72 :
                // InternalExBeeLangTestLanguageLexer.g:1:950: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 73 :
                // InternalExBeeLangTestLanguageLexer.g:1:966: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 74 :
                // InternalExBeeLangTestLanguageLexer.g:1:974: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\16\60\1\105\1\107\1\112\1\60\1\115\1\56\1\120\1\123\1\126\1\132\1\134\1\136\1\60\1\141\1\56\11\uffff\1\155\1\56\2\uffff\2\56\2\uffff\1\60\1\uffff\23\60\1\u0086\1\uffff\1\u0088\1\uffff\1\u008a\2\uffff\1\60\23\uffff\1\u008e\20\uffff\12\60\1\u009a\1\u009b\4\60\1\u00a0\4\60\6\uffff\1\u00a5\3\uffff\13\60\2\uffff\3\60\1\u00b7\1\uffff\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\uffff\1\u008d\2\uffff\2\60\1\u00bf\3\60\1\u00c3\7\60\5\uffff\1\u00cb\2\60\1\uffff\3\60\1\uffff\2\60\1\u00d3\1\60\1\u00d5\1\u00d6\1\u00d7\1\uffff\5\60\1\u00dd\1\u00de\1\uffff\1\u00df\3\uffff\1\u00e1\2\60\1\u00e4\1\u00e5\5\uffff\2\60\3\uffff\1\u00eb\1\u00ec\4\uffff";
    static final String DFA14_eofS =
        "\u00ed\uffff";
    static final String DFA14_minS =
        "\1\0\1\145\1\155\1\162\1\151\1\165\2\141\1\162\1\165\1\157\1\141\1\150\1\156\1\150\1\75\1\56\1\75\1\156\1\75\1\46\1\75\1\53\1\55\1\52\2\75\1\163\1\174\1\75\11\uffff\1\130\1\101\2\uffff\2\0\2\uffff\1\161\1\uffff\2\160\1\157\2\156\1\151\1\156\1\143\1\162\1\154\1\145\1\164\1\165\1\155\1\167\2\151\1\145\1\164\1\75\1\uffff\1\56\1\uffff\1\75\2\uffff\1\166\14\uffff\1\0\6\uffff\1\60\20\uffff\1\165\1\154\1\165\1\160\1\143\1\141\1\154\1\164\1\150\1\163\2\60\1\145\1\160\1\162\1\145\1\60\1\163\1\164\1\156\1\150\6\uffff\1\60\1\0\2\uffff\1\151\1\145\1\164\1\145\1\151\1\164\1\154\1\144\2\145\1\151\2\uffff\1\144\1\165\1\143\1\60\1\uffff\4\60\1\uffff\3\0\1\162\1\155\1\60\1\162\1\144\1\151\1\60\1\145\1\170\1\144\1\157\1\171\1\164\1\145\5\uffff\1\0\2\145\1\uffff\1\164\1\145\1\157\1\uffff\1\162\1\164\1\60\1\156\3\60\1\uffff\1\163\1\156\1\151\1\163\1\156\2\60\1\uffff\1\60\3\uffff\1\55\1\164\1\145\2\60\3\uffff\1\155\1\uffff\2\163\2\uffff\1\141\2\60\4\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\145\1\156\1\162\2\165\1\157\1\145\1\162\1\165\1\157\1\145\1\150\1\156\1\151\1\75\1\56\1\76\1\156\1\75\1\46\6\75\1\163\1\174\1\75\11\uffff\1\170\1\172\2\uffff\2\uffff\2\uffff\1\161\1\uffff\2\160\1\157\2\156\1\151\1\156\1\143\2\162\1\145\1\164\1\165\1\155\1\167\2\151\1\145\1\164\1\75\1\uffff\1\56\1\uffff\1\75\2\uffff\1\166\14\uffff\1\uffff\6\uffff\1\172\20\uffff\1\165\1\154\1\165\1\166\1\143\1\141\1\154\1\164\1\150\1\163\2\172\1\145\1\160\1\162\1\145\1\172\1\163\1\164\1\156\1\150\6\uffff\1\172\1\uffff\2\uffff\1\151\1\145\1\164\1\145\1\151\1\164\1\154\1\144\2\145\1\151\2\uffff\1\144\1\165\1\143\1\172\1\uffff\4\172\1\uffff\3\uffff\1\162\1\155\1\172\1\162\1\144\1\151\1\172\1\145\1\170\1\144\1\157\1\171\1\164\1\145\5\uffff\1\uffff\2\145\1\uffff\1\164\1\145\1\157\1\uffff\1\162\1\164\1\172\1\156\3\172\1\uffff\1\163\1\156\1\151\1\163\1\156\2\172\1\uffff\1\172\3\uffff\1\172\1\164\1\145\2\172\3\uffff\1\155\1\uffff\2\163\2\uffff\1\151\2\172\4\uffff";
    static final String DFA14_acceptS =
        "\36\uffff\1\60\1\61\1\64\1\70\1\71\1\75\1\76\1\77\1\101\2\uffff\1\104\1\105\2\uffff\1\111\1\112\1\uffff\1\104\24\uffff\1\56\1\uffff\1\66\1\uffff\1\51\1\73\1\uffff\1\36\1\57\1\37\1\40\1\62\1\41\1\42\1\63\1\43\1\44\1\65\1\46\1\uffff\1\110\1\67\1\47\1\72\1\52\1\74\1\uffff\1\54\1\100\1\55\1\60\1\61\1\64\1\70\1\71\1\75\1\76\1\77\1\101\1\103\1\105\1\106\1\111\25\uffff\1\26\1\35\1\27\1\45\1\30\1\50\2\uffff\1\107\1\53\13\uffff\1\33\1\34\4\uffff\1\32\4\uffff\1\31\21\uffff\1\21\1\22\1\23\1\24\1\25\3\uffff\1\20\3\uffff\1\17\7\uffff\1\102\7\uffff\1\13\1\uffff\1\14\1\15\1\16\5\uffff\1\10\1\11\1\12\1\uffff\1\7\2\uffff\1\6\1\5\3\uffff\1\1\1\2\1\3\1\4";
    static final String DFA14_specialS =
        "\1\2\52\uffff\1\5\1\4\53\uffff\1\3\63\uffff\1\7\31\uffff\1\10\1\6\1\1\23\uffff\1\0\60\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\56\2\55\2\56\1\55\22\56\1\55\1\17\1\53\2\56\1\23\1\24\1\54\1\36\1\37\1\25\1\26\1\40\1\27\1\20\1\30\1\47\11\52\1\41\1\42\1\31\1\21\1\32\2\56\32\51\1\43\1\56\1\44\1\50\1\51\1\56\1\33\1\5\1\6\1\51\1\22\1\4\1\10\1\51\1\2\4\51\1\13\1\11\1\3\1\51\1\1\1\12\1\14\1\15\1\7\1\16\3\51\1\45\1\34\1\46\1\35\uff81\56",
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
            "\1\u00e0\2\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
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

    static class DFA14 extends DFA {

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
            return "1:1: Tokens : ( RequiresMax | RequiresMin | Implements | Properties | Function | Provides | Requires | Builder | Context | Version | Cached | Greedy | Output | Source | Final | Input | Name | This | Unit | When | With | ExclamationMarkEqualsSignEqualsSign | FullStopFullStopFullStop | EqualsSignEqualsSignEqualsSign | Env | New | Val | Var | ExclamationMarkEqualsSign | PercentSignEqualsSign | AmpersandAmpersand | AsteriskEqualsSign | PlusSignPlusSign | PlusSignEqualsSign | HyphenMinusHyphenMinus | HyphenMinusEqualsSign | FullStopFullStop | SolidusEqualsSign | LessThanSignEqualsSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | As | VerticalLineVerticalLine | TildeEqualsSign | ExclamationMark | PercentSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_DOCUMENTATION | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
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
                        int LA14_168 = input.LA(1);

                        s = -1;
                        if ( (LA14_168=='*') ) {s = 167;}

                        else if ( ((LA14_168>='\u0000' && LA14_168<=')')||(LA14_168>='+' && LA14_168<='\uFFFF')) ) {s = 168;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
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
                    case 3 : 
                        int LA14_88 = input.LA(1);

                        s = -1;
                        if ( (LA14_88=='*') ) {s = 140;}

                        else if ( ((LA14_88>='\u0000' && LA14_88<=')')||(LA14_88>='+' && LA14_88<='\uFFFF')) ) {s = 141;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA14_44 = input.LA(1);

                        s = -1;
                        if ( ((LA14_44>='\u0000' && LA14_44<='\uFFFF')) ) {s = 110;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA14_43 = input.LA(1);

                        s = -1;
                        if ( ((LA14_43>='\u0000' && LA14_43<='\uFFFF')) ) {s = 110;}

                        else s = 46;

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
                        int LA14_140 = input.LA(1);

                        s = -1;
                        if ( (LA14_140=='/') ) {s = 166;}

                        else if ( (LA14_140=='*') ) {s = 167;}

                        else if ( ((LA14_140>='\u0000' && LA14_140<=')')||(LA14_140>='+' && LA14_140<='.')||(LA14_140>='0' && LA14_140<='\uFFFF')) ) {s = 168;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA14_166 = input.LA(1);

                        s = -1;
                        if ( (LA14_166=='*') ) {s = 167;}

                        else if ( ((LA14_166>='\u0000' && LA14_166<=')')||(LA14_166>='+' && LA14_166<='\uFFFF')) ) {s = 168;}

                        else s = 141;

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