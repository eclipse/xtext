package org.eclipse.xtext.example.homeautomation.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRuleEngineLexer extends Lexer {
    public static final int Typeof=15;
    public static final int QuestionMarkFullStop=54;
    public static final int Switch=14;
    public static final int RULE_ID=89;
    public static final int Try=34;
    public static final int VerticalLineVerticalLine=60;
    public static final int HyphenMinus=70;
    public static final int RightParenthesis=66;
    public static final int Static=13;
    public static final int AmpersandAmpersand=39;
    public static final int RULE_BEGIN=84;
    public static final int RULE_ANY_OTHER=94;
    public static final int ExclamationMark=61;
    public static final int QuestionMarkColon=55;
    public static final int False=17;
    public static final int LeftParenthesis=65;
    public static final int Extension=6;
    public static final int RightSquareBracket=80;
    public static final int Extends=8;
    public static final int While=20;
    public static final int Solidus=72;
    public static final int LessThanSignGreaterThanSign=50;
    public static final int Case=22;
    public static final int EOF=-1;
    public static final int GreaterThanSign=77;
    public static final int EqualsSignEqualsSign=51;
    public static final int FullStop=71;
    public static final int PercentSign=63;
    public static final int Finally=9;
    public static final int Default=7;
    public static final int RULE_HEX=86;
    public static final int HyphenMinusHyphenMinus=44;
    public static final int EqualsSignGreaterThanSign=52;
    public static final int LessThanSign=75;
    public static final int When=27;
    public static final int Do=58;
    public static final int RULE_INT=87;
    public static final int EqualsSignEqualsSignEqualsSign=30;
    public static final int AsteriskAsterisk=40;
    public static final int Synchronized=4;
    public static final int PlusSignPlusSign=42;
    public static final int LeftSquareBracket=79;
    public static final int RULE_DECIMAL=88;
    public static final int FullStopFullStop=47;
    public static final int Return=12;
    public static final int True=26;
    public static final int If=59;
    public static final int Null=24;
    public static final int PercentSignEqualsSign=38;
    public static final int ExclamationMarkEqualsSign=37;
    public static final int Asterisk=67;
    public static final int Import=11;
    public static final int Device=10;
    public static final int As=56;
    public static final int Then=25;
    public static final int Catch=16;
    public static final int Super=18;
    public static final int Throw=19;
    public static final int SolidusEqualsSign=48;
    public static final int LeftCurlyBracket=81;
    public static final int Colon=73;
    public static final int Can=31;
    public static final int Semicolon=74;
    public static final int RULE_SL_COMMENT=92;
    public static final int For=32;
    public static final int NumberSign=62;
    public static final int RULE_ML_COMMENT=91;
    public static final int Ampersand=64;
    public static final int ColonColon=49;
    public static final int RULE_STRING=90;
    public static final int PlusSign=68;
    public static final int VerticalLine=82;
    public static final int RULE_END=85;
    public static final int New=33;
    public static final int AsteriskEqualsSign=41;
    public static final int Rule=21;
    public static final int HyphenMinusEqualsSign=45;
    public static final int Instanceof=5;
    public static final int PlusSignEqualsSign=43;
    public static final int FullStopFullStopLessThanSign=29;
    public static final int GreaterThanSignEqualsSign=53;
    public static final int QuestionMark=78;
    public static final int Be=57;
    public static final int ExclamationMarkEqualsSignEqualsSign=28;
    public static final int RULE_WS=93;
    public static final int Else=23;
    public static final int EqualsSign=76;
    public static final int Comma=69;
    public static final int Val=35;
    public static final int Var=36;
    public static final int HyphenMinusGreaterThanSign=46;
    public static final int RightCurlyBracket=83;

    // delegates
    // delegators

    public InternalRuleEngineLexer() {;} 
    public InternalRuleEngineLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalRuleEngineLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalRuleEngineLexer.g"; }

    // $ANTLR start "Synchronized"
    public final void mSynchronized() throws RecognitionException {
        try {
            int _type = Synchronized;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:14:14: ( 'synchronized' )
            // InternalRuleEngineLexer.g:14:16: 'synchronized'
            {
            match("synchronized"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Synchronized"

    // $ANTLR start "Instanceof"
    public final void mInstanceof() throws RecognitionException {
        try {
            int _type = Instanceof;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:16:12: ( 'instanceof' )
            // InternalRuleEngineLexer.g:16:14: 'instanceof'
            {
            match("instanceof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Instanceof"

    // $ANTLR start "Extension"
    public final void mExtension() throws RecognitionException {
        try {
            int _type = Extension;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:18:11: ( 'extension' )
            // InternalRuleEngineLexer.g:18:13: 'extension'
            {
            match("extension"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Extension"

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:20:9: ( 'default' )
            // InternalRuleEngineLexer.g:20:11: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Default"

    // $ANTLR start "Extends"
    public final void mExtends() throws RecognitionException {
        try {
            int _type = Extends;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:22:9: ( 'extends' )
            // InternalRuleEngineLexer.g:22:11: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Extends"

    // $ANTLR start "Finally"
    public final void mFinally() throws RecognitionException {
        try {
            int _type = Finally;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:24:9: ( 'finally' )
            // InternalRuleEngineLexer.g:24:11: 'finally'
            {
            match("finally"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Finally"

    // $ANTLR start "Device"
    public final void mDevice() throws RecognitionException {
        try {
            int _type = Device;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:26:8: ( 'Device' )
            // InternalRuleEngineLexer.g:26:10: 'Device'
            {
            match("Device"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Device"

    // $ANTLR start "Import"
    public final void mImport() throws RecognitionException {
        try {
            int _type = Import;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:28:8: ( 'import' )
            // InternalRuleEngineLexer.g:28:10: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Import"

    // $ANTLR start "Return"
    public final void mReturn() throws RecognitionException {
        try {
            int _type = Return;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:30:8: ( 'return' )
            // InternalRuleEngineLexer.g:30:10: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Return"

    // $ANTLR start "Static"
    public final void mStatic() throws RecognitionException {
        try {
            int _type = Static;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:32:8: ( 'static' )
            // InternalRuleEngineLexer.g:32:10: 'static'
            {
            match("static"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Static"

    // $ANTLR start "Switch"
    public final void mSwitch() throws RecognitionException {
        try {
            int _type = Switch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:34:8: ( 'switch' )
            // InternalRuleEngineLexer.g:34:10: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Switch"

    // $ANTLR start "Typeof"
    public final void mTypeof() throws RecognitionException {
        try {
            int _type = Typeof;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:36:8: ( 'typeof' )
            // InternalRuleEngineLexer.g:36:10: 'typeof'
            {
            match("typeof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Typeof"

    // $ANTLR start "Catch"
    public final void mCatch() throws RecognitionException {
        try {
            int _type = Catch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:38:7: ( 'catch' )
            // InternalRuleEngineLexer.g:38:9: 'catch'
            {
            match("catch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Catch"

    // $ANTLR start "False"
    public final void mFalse() throws RecognitionException {
        try {
            int _type = False;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:40:7: ( 'false' )
            // InternalRuleEngineLexer.g:40:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "False"

    // $ANTLR start "Super"
    public final void mSuper() throws RecognitionException {
        try {
            int _type = Super;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:42:7: ( 'super' )
            // InternalRuleEngineLexer.g:42:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Super"

    // $ANTLR start "Throw"
    public final void mThrow() throws RecognitionException {
        try {
            int _type = Throw;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:44:7: ( 'throw' )
            // InternalRuleEngineLexer.g:44:9: 'throw'
            {
            match("throw"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Throw"

    // $ANTLR start "While"
    public final void mWhile() throws RecognitionException {
        try {
            int _type = While;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:46:7: ( 'while' )
            // InternalRuleEngineLexer.g:46:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "While"

    // $ANTLR start "Rule"
    public final void mRule() throws RecognitionException {
        try {
            int _type = Rule;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:48:6: ( 'Rule' )
            // InternalRuleEngineLexer.g:48:8: 'Rule'
            {
            match("Rule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Rule"

    // $ANTLR start "Case"
    public final void mCase() throws RecognitionException {
        try {
            int _type = Case;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:50:6: ( 'case' )
            // InternalRuleEngineLexer.g:50:8: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Case"

    // $ANTLR start "Else"
    public final void mElse() throws RecognitionException {
        try {
            int _type = Else;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:52:6: ( 'else' )
            // InternalRuleEngineLexer.g:52:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Else"

    // $ANTLR start "Null"
    public final void mNull() throws RecognitionException {
        try {
            int _type = Null;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:54:6: ( 'null' )
            // InternalRuleEngineLexer.g:54:8: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Null"

    // $ANTLR start "Then"
    public final void mThen() throws RecognitionException {
        try {
            int _type = Then;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:56:6: ( 'then' )
            // InternalRuleEngineLexer.g:56:8: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Then"

    // $ANTLR start "True"
    public final void mTrue() throws RecognitionException {
        try {
            int _type = True;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:58:6: ( 'true' )
            // InternalRuleEngineLexer.g:58:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "True"

    // $ANTLR start "When"
    public final void mWhen() throws RecognitionException {
        try {
            int _type = When;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:60:6: ( 'when' )
            // InternalRuleEngineLexer.g:60:8: 'when'
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

    // $ANTLR start "ExclamationMarkEqualsSignEqualsSign"
    public final void mExclamationMarkEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:62:37: ( '!==' )
            // InternalRuleEngineLexer.g:62:39: '!=='
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

    // $ANTLR start "FullStopFullStopLessThanSign"
    public final void mFullStopFullStopLessThanSign() throws RecognitionException {
        try {
            int _type = FullStopFullStopLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:64:30: ( '..<' )
            // InternalRuleEngineLexer.g:64:32: '..<'
            {
            match("..<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopFullStopLessThanSign"

    // $ANTLR start "EqualsSignEqualsSignEqualsSign"
    public final void mEqualsSignEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:66:32: ( '===' )
            // InternalRuleEngineLexer.g:66:34: '==='
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

    // $ANTLR start "Can"
    public final void mCan() throws RecognitionException {
        try {
            int _type = Can;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:68:5: ( 'can' )
            // InternalRuleEngineLexer.g:68:7: 'can'
            {
            match("can"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Can"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:70:5: ( 'for' )
            // InternalRuleEngineLexer.g:70:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "For"

    // $ANTLR start "New"
    public final void mNew() throws RecognitionException {
        try {
            int _type = New;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:72:5: ( 'new' )
            // InternalRuleEngineLexer.g:72:7: 'new'
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

    // $ANTLR start "Try"
    public final void mTry() throws RecognitionException {
        try {
            int _type = Try;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:74:5: ( 'try' )
            // InternalRuleEngineLexer.g:74:7: 'try'
            {
            match("try"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Try"

    // $ANTLR start "Val"
    public final void mVal() throws RecognitionException {
        try {
            int _type = Val;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:76:5: ( 'val' )
            // InternalRuleEngineLexer.g:76:7: 'val'
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
            // InternalRuleEngineLexer.g:78:5: ( 'var' )
            // InternalRuleEngineLexer.g:78:7: 'var'
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
            // InternalRuleEngineLexer.g:80:27: ( '!=' )
            // InternalRuleEngineLexer.g:80:29: '!='
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
            // InternalRuleEngineLexer.g:82:23: ( '%=' )
            // InternalRuleEngineLexer.g:82:25: '%='
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
            // InternalRuleEngineLexer.g:84:20: ( '&&' )
            // InternalRuleEngineLexer.g:84:22: '&&'
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

    // $ANTLR start "AsteriskAsterisk"
    public final void mAsteriskAsterisk() throws RecognitionException {
        try {
            int _type = AsteriskAsterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:86:18: ( '**' )
            // InternalRuleEngineLexer.g:86:20: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AsteriskAsterisk"

    // $ANTLR start "AsteriskEqualsSign"
    public final void mAsteriskEqualsSign() throws RecognitionException {
        try {
            int _type = AsteriskEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:88:20: ( '*=' )
            // InternalRuleEngineLexer.g:88:22: '*='
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
            // InternalRuleEngineLexer.g:90:18: ( '++' )
            // InternalRuleEngineLexer.g:90:20: '++'
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
            // InternalRuleEngineLexer.g:92:20: ( '+=' )
            // InternalRuleEngineLexer.g:92:22: '+='
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
            // InternalRuleEngineLexer.g:94:24: ( '--' )
            // InternalRuleEngineLexer.g:94:26: '--'
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
            // InternalRuleEngineLexer.g:96:23: ( '-=' )
            // InternalRuleEngineLexer.g:96:25: '-='
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

    // $ANTLR start "HyphenMinusGreaterThanSign"
    public final void mHyphenMinusGreaterThanSign() throws RecognitionException {
        try {
            int _type = HyphenMinusGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:98:28: ( '->' )
            // InternalRuleEngineLexer.g:98:30: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusGreaterThanSign"

    // $ANTLR start "FullStopFullStop"
    public final void mFullStopFullStop() throws RecognitionException {
        try {
            int _type = FullStopFullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:100:18: ( '..' )
            // InternalRuleEngineLexer.g:100:20: '..'
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
            // InternalRuleEngineLexer.g:102:19: ( '/=' )
            // InternalRuleEngineLexer.g:102:21: '/='
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

    // $ANTLR start "ColonColon"
    public final void mColonColon() throws RecognitionException {
        try {
            int _type = ColonColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:104:12: ( '::' )
            // InternalRuleEngineLexer.g:104:14: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ColonColon"

    // $ANTLR start "LessThanSignGreaterThanSign"
    public final void mLessThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:106:29: ( '<>' )
            // InternalRuleEngineLexer.g:106:31: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignGreaterThanSign"

    // $ANTLR start "EqualsSignEqualsSign"
    public final void mEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:108:22: ( '==' )
            // InternalRuleEngineLexer.g:108:24: '=='
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
            // InternalRuleEngineLexer.g:110:27: ( '=>' )
            // InternalRuleEngineLexer.g:110:29: '=>'
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
            // InternalRuleEngineLexer.g:112:27: ( '>=' )
            // InternalRuleEngineLexer.g:112:29: '>='
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

    // $ANTLR start "QuestionMarkFullStop"
    public final void mQuestionMarkFullStop() throws RecognitionException {
        try {
            int _type = QuestionMarkFullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:114:22: ( '?.' )
            // InternalRuleEngineLexer.g:114:24: '?.'
            {
            match("?."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuestionMarkFullStop"

    // $ANTLR start "QuestionMarkColon"
    public final void mQuestionMarkColon() throws RecognitionException {
        try {
            int _type = QuestionMarkColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:116:19: ( '?:' )
            // InternalRuleEngineLexer.g:116:21: '?:'
            {
            match("?:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuestionMarkColon"

    // $ANTLR start "As"
    public final void mAs() throws RecognitionException {
        try {
            int _type = As;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:118:4: ( 'as' )
            // InternalRuleEngineLexer.g:118:6: 'as'
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

    // $ANTLR start "Be"
    public final void mBe() throws RecognitionException {
        try {
            int _type = Be;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:120:4: ( 'be' )
            // InternalRuleEngineLexer.g:120:6: 'be'
            {
            match("be"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Be"

    // $ANTLR start "Do"
    public final void mDo() throws RecognitionException {
        try {
            int _type = Do;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:122:4: ( 'do' )
            // InternalRuleEngineLexer.g:122:6: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Do"

    // $ANTLR start "If"
    public final void mIf() throws RecognitionException {
        try {
            int _type = If;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:124:4: ( 'if' )
            // InternalRuleEngineLexer.g:124:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "If"

    // $ANTLR start "VerticalLineVerticalLine"
    public final void mVerticalLineVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLineVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:126:26: ( '||' )
            // InternalRuleEngineLexer.g:126:28: '||'
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

    // $ANTLR start "ExclamationMark"
    public final void mExclamationMark() throws RecognitionException {
        try {
            int _type = ExclamationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:128:17: ( '!' )
            // InternalRuleEngineLexer.g:128:19: '!'
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

    // $ANTLR start "NumberSign"
    public final void mNumberSign() throws RecognitionException {
        try {
            int _type = NumberSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:130:12: ( '#' )
            // InternalRuleEngineLexer.g:130:14: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSign"

    // $ANTLR start "PercentSign"
    public final void mPercentSign() throws RecognitionException {
        try {
            int _type = PercentSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:132:13: ( '%' )
            // InternalRuleEngineLexer.g:132:15: '%'
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

    // $ANTLR start "Ampersand"
    public final void mAmpersand() throws RecognitionException {
        try {
            int _type = Ampersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:134:11: ( '&' )
            // InternalRuleEngineLexer.g:134:13: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ampersand"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:136:17: ( '(' )
            // InternalRuleEngineLexer.g:136:19: '('
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
            // InternalRuleEngineLexer.g:138:18: ( ')' )
            // InternalRuleEngineLexer.g:138:20: ')'
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
            // InternalRuleEngineLexer.g:140:10: ( '*' )
            // InternalRuleEngineLexer.g:140:12: '*'
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
            // InternalRuleEngineLexer.g:142:10: ( '+' )
            // InternalRuleEngineLexer.g:142:12: '+'
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
            // InternalRuleEngineLexer.g:144:7: ( ',' )
            // InternalRuleEngineLexer.g:144:9: ','
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
            // InternalRuleEngineLexer.g:146:13: ( '-' )
            // InternalRuleEngineLexer.g:146:15: '-'
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
            // InternalRuleEngineLexer.g:148:10: ( '.' )
            // InternalRuleEngineLexer.g:148:12: '.'
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
            // InternalRuleEngineLexer.g:150:9: ( '/' )
            // InternalRuleEngineLexer.g:150:11: '/'
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
            // InternalRuleEngineLexer.g:152:7: ( ':' )
            // InternalRuleEngineLexer.g:152:9: ':'
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
            // InternalRuleEngineLexer.g:154:11: ( ';' )
            // InternalRuleEngineLexer.g:154:13: ';'
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
            // InternalRuleEngineLexer.g:156:14: ( '<' )
            // InternalRuleEngineLexer.g:156:16: '<'
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
            // InternalRuleEngineLexer.g:158:12: ( '=' )
            // InternalRuleEngineLexer.g:158:14: '='
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
            // InternalRuleEngineLexer.g:160:17: ( '>' )
            // InternalRuleEngineLexer.g:160:19: '>'
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

    // $ANTLR start "QuestionMark"
    public final void mQuestionMark() throws RecognitionException {
        try {
            int _type = QuestionMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:162:14: ( '?' )
            // InternalRuleEngineLexer.g:162:16: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuestionMark"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:164:19: ( '[' )
            // InternalRuleEngineLexer.g:164:21: '['
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
            // InternalRuleEngineLexer.g:166:20: ( ']' )
            // InternalRuleEngineLexer.g:166:22: ']'
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
            // InternalRuleEngineLexer.g:168:18: ( '{' )
            // InternalRuleEngineLexer.g:168:20: '{'
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
            // InternalRuleEngineLexer.g:170:14: ( '|' )
            // InternalRuleEngineLexer.g:170:16: '|'
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
            // InternalRuleEngineLexer.g:172:19: ( '}' )
            // InternalRuleEngineLexer.g:172:21: '}'
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

    // $ANTLR start "RULE_BEGIN"
    public final void mRULE_BEGIN() throws RecognitionException {
        try {
            // InternalRuleEngineLexer.g:176:21: ()
            // InternalRuleEngineLexer.g:176:23: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BEGIN"

    // $ANTLR start "RULE_END"
    public final void mRULE_END() throws RecognitionException {
        try {
            // InternalRuleEngineLexer.g:178:19: ()
            // InternalRuleEngineLexer.g:178:21: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_END"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:180:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )? )
            // InternalRuleEngineLexer.g:180:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            {
            // InternalRuleEngineLexer.g:180:12: ( '0x' | '0X' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='0') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='x') ) {
                    alt1=1;
                }
                else if ( (LA1_1=='X') ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalRuleEngineLexer.g:180:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // InternalRuleEngineLexer.g:180:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // InternalRuleEngineLexer.g:180:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='f')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRuleEngineLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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

            // InternalRuleEngineLexer.g:180:58: ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='#') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRuleEngineLexer.g:180:59: '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    {
                    match('#'); 
                    // InternalRuleEngineLexer.g:180:63: ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='B'||LA3_0=='b') ) {
                        alt3=1;
                    }
                    else if ( (LA3_0=='L'||LA3_0=='l') ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalRuleEngineLexer.g:180:64: ( 'b' | 'B' ) ( 'i' | 'I' )
                            {
                            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;
                        case 2 :
                            // InternalRuleEngineLexer.g:180:84: ( 'l' | 'L' )
                            {
                            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


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
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:182:10: ( '0' .. '9' ( '0' .. '9' | '_' )* )
            // InternalRuleEngineLexer.g:182:12: '0' .. '9' ( '0' .. '9' | '_' )*
            {
            matchRange('0','9'); 
            // InternalRuleEngineLexer.g:182:21: ( '0' .. '9' | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||LA5_0=='_') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalRuleEngineLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='_' ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_DECIMAL"
    public final void mRULE_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:184:14: ( RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )? )
            // InternalRuleEngineLexer.g:184:16: RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            {
            mRULE_INT(); 
            // InternalRuleEngineLexer.g:184:25: ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='E'||LA7_0=='e') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalRuleEngineLexer.g:184:26: ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalRuleEngineLexer.g:184:36: ( '+' | '-' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='+'||LA6_0=='-') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalRuleEngineLexer.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    mRULE_INT(); 

                    }
                    break;

            }

            // InternalRuleEngineLexer.g:184:58: ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='B'||LA8_0=='b') ) {
                alt8=1;
            }
            else if ( (LA8_0=='D'||LA8_0=='F'||LA8_0=='L'||LA8_0=='d'||LA8_0=='f'||LA8_0=='l') ) {
                alt8=2;
            }
            switch (alt8) {
                case 1 :
                    // InternalRuleEngineLexer.g:184:59: ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' )
                    {
                    if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    if ( input.LA(1)=='D'||input.LA(1)=='I'||input.LA(1)=='d'||input.LA(1)=='i' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // InternalRuleEngineLexer.g:184:87: ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' )
                    {
                    if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='L'||input.LA(1)=='d'||input.LA(1)=='f'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


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
    // $ANTLR end "RULE_DECIMAL"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRuleEngineLexer.g:186:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )* )
            // InternalRuleEngineLexer.g:186:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            {
            // InternalRuleEngineLexer.g:186:11: ( '^' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='^') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalRuleEngineLexer.g:186:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalRuleEngineLexer.g:186:44: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='$'||(LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalRuleEngineLexer.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
            // InternalRuleEngineLexer.g:188:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? ) )
            // InternalRuleEngineLexer.g:188:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? )
            {
            // InternalRuleEngineLexer.g:188:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\"') ) {
                alt15=1;
            }
            else if ( (LA15_0=='\'') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalRuleEngineLexer.g:188:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )?
                    {
                    match('\"'); 
                    // InternalRuleEngineLexer.g:188:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop11:
                    do {
                        int alt11=3;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='\\') ) {
                            alt11=1;
                        }
                        else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                            alt11=2;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalRuleEngineLexer.g:188:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRuleEngineLexer.g:188:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop11;
                        }
                    } while (true);

                    // InternalRuleEngineLexer.g:188:44: ( '\"' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\"') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalRuleEngineLexer.g:188:44: '\"'
                            {
                            match('\"'); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineLexer.g:188:49: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )?
                    {
                    match('\''); 
                    // InternalRuleEngineLexer.g:188:54: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\\') ) {
                            alt13=1;
                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalRuleEngineLexer.g:188:55: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRuleEngineLexer.g:188:62: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop13;
                        }
                    } while (true);

                    // InternalRuleEngineLexer.g:188:79: ( '\\'' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\'') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalRuleEngineLexer.g:188:79: '\\''
                            {
                            match('\''); 

                            }
                            break;

                    }


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
            // InternalRuleEngineLexer.g:190:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalRuleEngineLexer.g:190:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalRuleEngineLexer.g:190:24: ( options {greedy=false; } : . )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='*') ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1=='/') ) {
                        alt16=2;
                    }
                    else if ( ((LA16_1>='\u0000' && LA16_1<='.')||(LA16_1>='0' && LA16_1<='\uFFFF')) ) {
                        alt16=1;
                    }


                }
                else if ( ((LA16_0>='\u0000' && LA16_0<=')')||(LA16_0>='+' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalRuleEngineLexer.g:190:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop16;
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
            // InternalRuleEngineLexer.g:192:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalRuleEngineLexer.g:192:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalRuleEngineLexer.g:192:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalRuleEngineLexer.g:192:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop17;
                }
            } while (true);

            // InternalRuleEngineLexer.g:192:40: ( ( '\\r' )? '\\n' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\n'||LA19_0=='\r') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRuleEngineLexer.g:192:41: ( '\\r' )? '\\n'
                    {
                    // InternalRuleEngineLexer.g:192:41: ( '\\r' )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='\r') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalRuleEngineLexer.g:192:41: '\\r'
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
            // InternalRuleEngineLexer.g:194:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalRuleEngineLexer.g:194:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalRuleEngineLexer.g:194:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\t' && LA20_0<='\n')||LA20_0=='\r'||LA20_0==' ') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalRuleEngineLexer.g:
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
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
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
            // InternalRuleEngineLexer.g:196:16: ( . )
            // InternalRuleEngineLexer.g:196:18: .
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
        // InternalRuleEngineLexer.g:1:8: ( Synchronized | Instanceof | Extension | Default | Extends | Finally | Device | Import | Return | Static | Switch | Typeof | Catch | False | Super | Throw | While | Rule | Case | Else | Null | Then | True | When | ExclamationMarkEqualsSignEqualsSign | FullStopFullStopLessThanSign | EqualsSignEqualsSignEqualsSign | Can | For | New | Try | Val | Var | ExclamationMarkEqualsSign | PercentSignEqualsSign | AmpersandAmpersand | AsteriskAsterisk | AsteriskEqualsSign | PlusSignPlusSign | PlusSignEqualsSign | HyphenMinusHyphenMinus | HyphenMinusEqualsSign | HyphenMinusGreaterThanSign | FullStopFullStop | SolidusEqualsSign | ColonColon | LessThanSignGreaterThanSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | QuestionMarkFullStop | QuestionMarkColon | As | Be | Do | If | VerticalLineVerticalLine | ExclamationMark | NumberSign | PercentSign | Ampersand | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | QuestionMark | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt21=89;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // InternalRuleEngineLexer.g:1:10: Synchronized
                {
                mSynchronized(); 

                }
                break;
            case 2 :
                // InternalRuleEngineLexer.g:1:23: Instanceof
                {
                mInstanceof(); 

                }
                break;
            case 3 :
                // InternalRuleEngineLexer.g:1:34: Extension
                {
                mExtension(); 

                }
                break;
            case 4 :
                // InternalRuleEngineLexer.g:1:44: Default
                {
                mDefault(); 

                }
                break;
            case 5 :
                // InternalRuleEngineLexer.g:1:52: Extends
                {
                mExtends(); 

                }
                break;
            case 6 :
                // InternalRuleEngineLexer.g:1:60: Finally
                {
                mFinally(); 

                }
                break;
            case 7 :
                // InternalRuleEngineLexer.g:1:68: Device
                {
                mDevice(); 

                }
                break;
            case 8 :
                // InternalRuleEngineLexer.g:1:75: Import
                {
                mImport(); 

                }
                break;
            case 9 :
                // InternalRuleEngineLexer.g:1:82: Return
                {
                mReturn(); 

                }
                break;
            case 10 :
                // InternalRuleEngineLexer.g:1:89: Static
                {
                mStatic(); 

                }
                break;
            case 11 :
                // InternalRuleEngineLexer.g:1:96: Switch
                {
                mSwitch(); 

                }
                break;
            case 12 :
                // InternalRuleEngineLexer.g:1:103: Typeof
                {
                mTypeof(); 

                }
                break;
            case 13 :
                // InternalRuleEngineLexer.g:1:110: Catch
                {
                mCatch(); 

                }
                break;
            case 14 :
                // InternalRuleEngineLexer.g:1:116: False
                {
                mFalse(); 

                }
                break;
            case 15 :
                // InternalRuleEngineLexer.g:1:122: Super
                {
                mSuper(); 

                }
                break;
            case 16 :
                // InternalRuleEngineLexer.g:1:128: Throw
                {
                mThrow(); 

                }
                break;
            case 17 :
                // InternalRuleEngineLexer.g:1:134: While
                {
                mWhile(); 

                }
                break;
            case 18 :
                // InternalRuleEngineLexer.g:1:140: Rule
                {
                mRule(); 

                }
                break;
            case 19 :
                // InternalRuleEngineLexer.g:1:145: Case
                {
                mCase(); 

                }
                break;
            case 20 :
                // InternalRuleEngineLexer.g:1:150: Else
                {
                mElse(); 

                }
                break;
            case 21 :
                // InternalRuleEngineLexer.g:1:155: Null
                {
                mNull(); 

                }
                break;
            case 22 :
                // InternalRuleEngineLexer.g:1:160: Then
                {
                mThen(); 

                }
                break;
            case 23 :
                // InternalRuleEngineLexer.g:1:165: True
                {
                mTrue(); 

                }
                break;
            case 24 :
                // InternalRuleEngineLexer.g:1:170: When
                {
                mWhen(); 

                }
                break;
            case 25 :
                // InternalRuleEngineLexer.g:1:175: ExclamationMarkEqualsSignEqualsSign
                {
                mExclamationMarkEqualsSignEqualsSign(); 

                }
                break;
            case 26 :
                // InternalRuleEngineLexer.g:1:211: FullStopFullStopLessThanSign
                {
                mFullStopFullStopLessThanSign(); 

                }
                break;
            case 27 :
                // InternalRuleEngineLexer.g:1:240: EqualsSignEqualsSignEqualsSign
                {
                mEqualsSignEqualsSignEqualsSign(); 

                }
                break;
            case 28 :
                // InternalRuleEngineLexer.g:1:271: Can
                {
                mCan(); 

                }
                break;
            case 29 :
                // InternalRuleEngineLexer.g:1:275: For
                {
                mFor(); 

                }
                break;
            case 30 :
                // InternalRuleEngineLexer.g:1:279: New
                {
                mNew(); 

                }
                break;
            case 31 :
                // InternalRuleEngineLexer.g:1:283: Try
                {
                mTry(); 

                }
                break;
            case 32 :
                // InternalRuleEngineLexer.g:1:287: Val
                {
                mVal(); 

                }
                break;
            case 33 :
                // InternalRuleEngineLexer.g:1:291: Var
                {
                mVar(); 

                }
                break;
            case 34 :
                // InternalRuleEngineLexer.g:1:295: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 35 :
                // InternalRuleEngineLexer.g:1:321: PercentSignEqualsSign
                {
                mPercentSignEqualsSign(); 

                }
                break;
            case 36 :
                // InternalRuleEngineLexer.g:1:343: AmpersandAmpersand
                {
                mAmpersandAmpersand(); 

                }
                break;
            case 37 :
                // InternalRuleEngineLexer.g:1:362: AsteriskAsterisk
                {
                mAsteriskAsterisk(); 

                }
                break;
            case 38 :
                // InternalRuleEngineLexer.g:1:379: AsteriskEqualsSign
                {
                mAsteriskEqualsSign(); 

                }
                break;
            case 39 :
                // InternalRuleEngineLexer.g:1:398: PlusSignPlusSign
                {
                mPlusSignPlusSign(); 

                }
                break;
            case 40 :
                // InternalRuleEngineLexer.g:1:415: PlusSignEqualsSign
                {
                mPlusSignEqualsSign(); 

                }
                break;
            case 41 :
                // InternalRuleEngineLexer.g:1:434: HyphenMinusHyphenMinus
                {
                mHyphenMinusHyphenMinus(); 

                }
                break;
            case 42 :
                // InternalRuleEngineLexer.g:1:457: HyphenMinusEqualsSign
                {
                mHyphenMinusEqualsSign(); 

                }
                break;
            case 43 :
                // InternalRuleEngineLexer.g:1:479: HyphenMinusGreaterThanSign
                {
                mHyphenMinusGreaterThanSign(); 

                }
                break;
            case 44 :
                // InternalRuleEngineLexer.g:1:506: FullStopFullStop
                {
                mFullStopFullStop(); 

                }
                break;
            case 45 :
                // InternalRuleEngineLexer.g:1:523: SolidusEqualsSign
                {
                mSolidusEqualsSign(); 

                }
                break;
            case 46 :
                // InternalRuleEngineLexer.g:1:541: ColonColon
                {
                mColonColon(); 

                }
                break;
            case 47 :
                // InternalRuleEngineLexer.g:1:552: LessThanSignGreaterThanSign
                {
                mLessThanSignGreaterThanSign(); 

                }
                break;
            case 48 :
                // InternalRuleEngineLexer.g:1:580: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 49 :
                // InternalRuleEngineLexer.g:1:601: EqualsSignGreaterThanSign
                {
                mEqualsSignGreaterThanSign(); 

                }
                break;
            case 50 :
                // InternalRuleEngineLexer.g:1:627: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 51 :
                // InternalRuleEngineLexer.g:1:653: QuestionMarkFullStop
                {
                mQuestionMarkFullStop(); 

                }
                break;
            case 52 :
                // InternalRuleEngineLexer.g:1:674: QuestionMarkColon
                {
                mQuestionMarkColon(); 

                }
                break;
            case 53 :
                // InternalRuleEngineLexer.g:1:692: As
                {
                mAs(); 

                }
                break;
            case 54 :
                // InternalRuleEngineLexer.g:1:695: Be
                {
                mBe(); 

                }
                break;
            case 55 :
                // InternalRuleEngineLexer.g:1:698: Do
                {
                mDo(); 

                }
                break;
            case 56 :
                // InternalRuleEngineLexer.g:1:701: If
                {
                mIf(); 

                }
                break;
            case 57 :
                // InternalRuleEngineLexer.g:1:704: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 58 :
                // InternalRuleEngineLexer.g:1:729: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 59 :
                // InternalRuleEngineLexer.g:1:745: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 60 :
                // InternalRuleEngineLexer.g:1:756: PercentSign
                {
                mPercentSign(); 

                }
                break;
            case 61 :
                // InternalRuleEngineLexer.g:1:768: Ampersand
                {
                mAmpersand(); 

                }
                break;
            case 62 :
                // InternalRuleEngineLexer.g:1:778: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 63 :
                // InternalRuleEngineLexer.g:1:794: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 64 :
                // InternalRuleEngineLexer.g:1:811: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 65 :
                // InternalRuleEngineLexer.g:1:820: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 66 :
                // InternalRuleEngineLexer.g:1:829: Comma
                {
                mComma(); 

                }
                break;
            case 67 :
                // InternalRuleEngineLexer.g:1:835: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 68 :
                // InternalRuleEngineLexer.g:1:847: FullStop
                {
                mFullStop(); 

                }
                break;
            case 69 :
                // InternalRuleEngineLexer.g:1:856: Solidus
                {
                mSolidus(); 

                }
                break;
            case 70 :
                // InternalRuleEngineLexer.g:1:864: Colon
                {
                mColon(); 

                }
                break;
            case 71 :
                // InternalRuleEngineLexer.g:1:870: Semicolon
                {
                mSemicolon(); 

                }
                break;
            case 72 :
                // InternalRuleEngineLexer.g:1:880: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 73 :
                // InternalRuleEngineLexer.g:1:893: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 74 :
                // InternalRuleEngineLexer.g:1:904: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 75 :
                // InternalRuleEngineLexer.g:1:920: QuestionMark
                {
                mQuestionMark(); 

                }
                break;
            case 76 :
                // InternalRuleEngineLexer.g:1:933: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 77 :
                // InternalRuleEngineLexer.g:1:951: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 78 :
                // InternalRuleEngineLexer.g:1:970: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 79 :
                // InternalRuleEngineLexer.g:1:987: VerticalLine
                {
                mVerticalLine(); 

                }
                break;
            case 80 :
                // InternalRuleEngineLexer.g:1:1000: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 81 :
                // InternalRuleEngineLexer.g:1:1018: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 82 :
                // InternalRuleEngineLexer.g:1:1027: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 83 :
                // InternalRuleEngineLexer.g:1:1036: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 84 :
                // InternalRuleEngineLexer.g:1:1049: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 85 :
                // InternalRuleEngineLexer.g:1:1057: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 86 :
                // InternalRuleEngineLexer.g:1:1069: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 87 :
                // InternalRuleEngineLexer.g:1:1085: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 88 :
                // InternalRuleEngineLexer.g:1:1101: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 89 :
                // InternalRuleEngineLexer.g:1:1109: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\1\uffff\14\63\1\111\1\113\1\116\1\63\1\121\1\123\1\126\1\131\1\135\1\141\1\143\1\145\1\147\1\152\2\63\1\156\11\uffff\2\172\1\56\5\uffff\4\63\1\uffff\2\63\1\u0084\3\63\1\u0088\15\63\1\u009c\1\uffff\1\u009e\1\uffff\1\u00a0\2\uffff\1\63\33\uffff\1\u00a3\1\u00a4\14\uffff\1\172\4\uffff\6\63\1\uffff\3\63\1\uffff\2\63\1\u00b0\6\63\1\u00b7\2\63\1\u00ba\4\63\1\u00bf\6\uffff\1\u00c0\1\u00c1\2\uffff\7\63\1\u00c9\3\63\1\uffff\4\63\1\u00d1\1\u00d2\1\uffff\1\63\1\u00d4\1\uffff\1\63\1\u00d6\1\u00d7\1\u00d8\3\uffff\3\63\1\u00dc\3\63\1\uffff\2\63\1\u00e3\3\63\1\u00e7\2\uffff\1\u00e8\1\uffff\1\u00e9\3\uffff\1\63\1\u00eb\1\u00ec\1\uffff\1\63\1\u00ee\4\63\1\uffff\1\u00f3\1\u00f4\1\u00f5\3\uffff\1\63\2\uffff\1\63\1\uffff\1\63\1\u00f9\1\u00fa\1\u00fb\3\uffff\3\63\3\uffff\2\63\1\u0101\1\63\1\u0103\1\uffff\1\63\1\uffff\1\u0105\1\uffff";
    static final String DFA21_eofS =
        "\u0106\uffff";
    static final String DFA21_minS =
        "\1\0\1\164\1\146\1\154\1\145\1\141\2\145\1\150\1\141\1\150\1\165\1\145\1\75\1\56\1\75\1\141\1\75\1\46\1\52\1\53\1\55\1\52\1\72\1\76\1\75\1\56\1\163\1\145\1\174\11\uffff\2\60\1\44\5\uffff\1\156\1\141\1\151\1\160\1\uffff\1\163\1\160\1\44\1\164\1\163\1\146\1\44\1\156\1\154\1\162\1\166\1\164\1\160\1\145\1\165\1\156\1\145\2\154\1\167\1\75\1\uffff\1\74\1\uffff\1\75\2\uffff\1\154\33\uffff\2\44\14\uffff\1\60\4\uffff\1\143\2\164\1\145\1\164\1\157\1\uffff\2\145\1\141\1\uffff\1\141\1\163\1\44\1\151\1\165\1\145\1\157\1\156\1\145\1\44\1\143\1\145\1\44\1\154\1\156\1\145\1\154\1\44\6\uffff\2\44\2\uffff\1\150\1\151\1\143\1\162\1\141\1\162\1\156\1\44\1\165\1\154\1\145\1\uffff\1\143\1\162\1\157\1\167\2\44\1\uffff\1\150\1\44\1\uffff\1\145\3\44\3\uffff\1\162\1\143\1\150\1\44\1\156\1\164\1\144\1\uffff\2\154\1\44\1\145\1\156\1\146\1\44\2\uffff\1\44\1\uffff\1\44\3\uffff\1\157\2\44\1\uffff\1\143\1\44\1\151\1\163\1\164\1\171\1\uffff\3\44\3\uffff\1\156\2\uffff\1\145\1\uffff\1\157\3\44\3\uffff\1\151\1\157\1\156\3\uffff\1\172\1\146\1\44\1\145\1\44\1\uffff\1\144\1\uffff\1\44\1\uffff";
    static final String DFA21_maxS =
        "\1\uffff\1\171\1\156\1\170\2\157\2\145\1\171\1\141\1\150\2\165\1\75\1\56\1\76\1\141\1\75\1\46\2\75\1\76\1\75\1\72\1\76\1\75\1\72\1\163\1\145\1\174\11\uffff\1\170\1\154\1\172\5\uffff\1\156\1\141\1\151\1\160\1\uffff\1\163\1\160\1\172\1\164\1\163\1\146\1\172\1\156\1\154\1\162\1\166\1\164\1\160\1\162\1\171\1\164\1\151\2\154\1\167\1\75\1\uffff\1\74\1\uffff\1\75\2\uffff\1\162\33\uffff\2\172\14\uffff\1\154\4\uffff\1\143\2\164\1\145\1\164\1\157\1\uffff\2\145\1\141\1\uffff\1\141\1\163\1\172\1\151\1\165\1\145\1\157\1\156\1\145\1\172\1\143\1\145\1\172\1\154\1\156\1\145\1\154\1\172\6\uffff\2\172\2\uffff\1\150\1\151\1\143\1\162\1\141\1\162\1\156\1\172\1\165\1\154\1\145\1\uffff\1\143\1\162\1\157\1\167\2\172\1\uffff\1\150\1\172\1\uffff\1\145\3\172\3\uffff\1\162\1\143\1\150\1\172\1\156\1\164\1\163\1\uffff\2\154\1\172\1\145\1\156\1\146\1\172\2\uffff\1\172\1\uffff\1\172\3\uffff\1\157\2\172\1\uffff\1\143\1\172\1\151\1\163\1\164\1\171\1\uffff\3\172\3\uffff\1\156\2\uffff\1\145\1\uffff\1\157\3\172\3\uffff\1\151\1\157\1\156\3\uffff\1\172\1\146\1\172\1\145\1\172\1\uffff\1\144\1\uffff\1\172\1\uffff";
    static final String DFA21_acceptS =
        "\36\uffff\1\73\1\76\1\77\1\102\1\107\1\114\1\115\1\116\1\120\3\uffff\1\124\2\125\1\130\1\131\4\uffff\1\124\25\uffff\1\72\1\uffff\1\104\1\uffff\1\61\1\111\1\uffff\1\43\1\74\1\44\1\75\1\45\1\46\1\100\1\47\1\50\1\101\1\51\1\52\1\53\1\103\1\55\1\126\1\127\1\105\1\56\1\106\1\57\1\110\1\62\1\112\1\63\1\64\1\113\2\uffff\1\71\1\117\1\73\1\76\1\77\1\102\1\107\1\114\1\115\1\116\1\120\1\121\1\uffff\1\122\1\123\1\125\1\130\6\uffff\1\70\3\uffff\1\67\22\uffff\1\31\1\42\1\32\1\54\1\33\1\60\2\uffff\1\65\1\66\13\uffff\1\35\6\uffff\1\37\2\uffff\1\34\4\uffff\1\36\1\40\1\41\7\uffff\1\24\7\uffff\1\26\1\27\1\uffff\1\23\1\uffff\1\30\1\22\1\25\3\uffff\1\17\6\uffff\1\16\3\uffff\1\20\1\15\1\21\1\uffff\1\12\1\13\1\uffff\1\10\4\uffff\1\7\1\11\1\14\3\uffff\1\5\1\4\1\6\5\uffff\1\3\1\uffff\1\2\1\uffff\1\1";
    static final String DFA21_specialS =
        "\1\0\u0105\uffff}>";
    static final String[] DFA21_transitionS = {
            "\11\56\2\55\2\56\1\55\22\56\1\55\1\15\1\53\1\36\1\52\1\21\1\22\1\54\1\37\1\40\1\23\1\24\1\41\1\25\1\16\1\26\1\47\11\50\1\27\1\42\1\30\1\17\1\31\1\32\1\56\3\52\1\6\15\52\1\13\10\52\1\43\1\56\1\44\1\51\1\52\1\56\1\33\1\34\1\11\1\4\1\3\1\5\2\52\1\2\4\52\1\14\3\52\1\7\1\1\1\10\1\52\1\20\1\12\3\52\1\45\1\35\1\46\uff82\56",
            "\1\60\1\62\1\uffff\1\61\1\uffff\1\57",
            "\1\66\6\uffff\1\65\1\64",
            "\1\70\13\uffff\1\67",
            "\1\71\11\uffff\1\72",
            "\1\74\7\uffff\1\73\5\uffff\1\75",
            "\1\76",
            "\1\77",
            "\1\101\11\uffff\1\102\6\uffff\1\100",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\107\17\uffff\1\106",
            "\1\110",
            "\1\112",
            "\1\114\1\115",
            "\1\117",
            "\1\120",
            "\1\122",
            "\1\124\22\uffff\1\125",
            "\1\127\21\uffff\1\130",
            "\1\132\17\uffff\1\133\1\134",
            "\1\137\4\uffff\1\140\15\uffff\1\136",
            "\1\142",
            "\1\144",
            "\1\146",
            "\1\150\13\uffff\1\151",
            "\1\153",
            "\1\154",
            "\1\155",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\171\10\uffff\1\173\1\uffff\3\173\5\uffff\1\173\13\uffff\1\170\6\uffff\1\171\2\uffff\1\173\1\uffff\3\173\5\uffff\1\173\13\uffff\1\170",
            "\12\171\10\uffff\1\173\1\uffff\3\173\5\uffff\1\173\22\uffff\1\171\2\uffff\1\173\1\uffff\3\173\5\uffff\1\173",
            "\1\63\34\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "",
            "",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u0090\14\uffff\1\u008f",
            "\1\u0091\3\uffff\1\u0092",
            "\1\u0095\4\uffff\1\u0094\1\u0093",
            "\1\u0097\3\uffff\1\u0096",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "",
            "\1\u009d",
            "",
            "\1\u009f",
            "",
            "",
            "\1\u00a1\5\uffff\1\u00a2",
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
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
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
            "\12\171\10\uffff\1\173\1\uffff\3\173\5\uffff\1\173\22\uffff\1\171\2\uffff\1\173\1\uffff\3\173\5\uffff\1\173",
            "",
            "",
            "",
            "",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "",
            "\1\u00ae",
            "\1\u00af",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00b8",
            "\1\u00b9",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u00d3",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u00d5",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00e0\16\uffff\1\u00df",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "\1\u00ea",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u00ed",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "\1\u00f6",
            "",
            "",
            "\1\u00f7",
            "",
            "\1\u00f8",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "",
            "",
            "",
            "\1\u00ff",
            "\1\u0100",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0102",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u0104",
            "",
            "\1\63\13\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Synchronized | Instanceof | Extension | Default | Extends | Finally | Device | Import | Return | Static | Switch | Typeof | Catch | False | Super | Throw | While | Rule | Case | Else | Null | Then | True | When | ExclamationMarkEqualsSignEqualsSign | FullStopFullStopLessThanSign | EqualsSignEqualsSignEqualsSign | Can | For | New | Try | Val | Var | ExclamationMarkEqualsSign | PercentSignEqualsSign | AmpersandAmpersand | AsteriskAsterisk | AsteriskEqualsSign | PlusSignPlusSign | PlusSignEqualsSign | HyphenMinusHyphenMinus | HyphenMinusEqualsSign | HyphenMinusGreaterThanSign | FullStopFullStop | SolidusEqualsSign | ColonColon | LessThanSignGreaterThanSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | QuestionMarkFullStop | QuestionMarkColon | As | Be | Do | If | VerticalLineVerticalLine | ExclamationMark | NumberSign | PercentSign | Ampersand | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | QuestionMark | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_0 = input.LA(1);

                        s = -1;
                        if ( (LA21_0=='s') ) {s = 1;}

                        else if ( (LA21_0=='i') ) {s = 2;}

                        else if ( (LA21_0=='e') ) {s = 3;}

                        else if ( (LA21_0=='d') ) {s = 4;}

                        else if ( (LA21_0=='f') ) {s = 5;}

                        else if ( (LA21_0=='D') ) {s = 6;}

                        else if ( (LA21_0=='r') ) {s = 7;}

                        else if ( (LA21_0=='t') ) {s = 8;}

                        else if ( (LA21_0=='c') ) {s = 9;}

                        else if ( (LA21_0=='w') ) {s = 10;}

                        else if ( (LA21_0=='R') ) {s = 11;}

                        else if ( (LA21_0=='n') ) {s = 12;}

                        else if ( (LA21_0=='!') ) {s = 13;}

                        else if ( (LA21_0=='.') ) {s = 14;}

                        else if ( (LA21_0=='=') ) {s = 15;}

                        else if ( (LA21_0=='v') ) {s = 16;}

                        else if ( (LA21_0=='%') ) {s = 17;}

                        else if ( (LA21_0=='&') ) {s = 18;}

                        else if ( (LA21_0=='*') ) {s = 19;}

                        else if ( (LA21_0=='+') ) {s = 20;}

                        else if ( (LA21_0=='-') ) {s = 21;}

                        else if ( (LA21_0=='/') ) {s = 22;}

                        else if ( (LA21_0==':') ) {s = 23;}

                        else if ( (LA21_0=='<') ) {s = 24;}

                        else if ( (LA21_0=='>') ) {s = 25;}

                        else if ( (LA21_0=='?') ) {s = 26;}

                        else if ( (LA21_0=='a') ) {s = 27;}

                        else if ( (LA21_0=='b') ) {s = 28;}

                        else if ( (LA21_0=='|') ) {s = 29;}

                        else if ( (LA21_0=='#') ) {s = 30;}

                        else if ( (LA21_0=='(') ) {s = 31;}

                        else if ( (LA21_0==')') ) {s = 32;}

                        else if ( (LA21_0==',') ) {s = 33;}

                        else if ( (LA21_0==';') ) {s = 34;}

                        else if ( (LA21_0=='[') ) {s = 35;}

                        else if ( (LA21_0==']') ) {s = 36;}

                        else if ( (LA21_0=='{') ) {s = 37;}

                        else if ( (LA21_0=='}') ) {s = 38;}

                        else if ( (LA21_0=='0') ) {s = 39;}

                        else if ( ((LA21_0>='1' && LA21_0<='9')) ) {s = 40;}

                        else if ( (LA21_0=='^') ) {s = 41;}

                        else if ( (LA21_0=='$'||(LA21_0>='A' && LA21_0<='C')||(LA21_0>='E' && LA21_0<='Q')||(LA21_0>='S' && LA21_0<='Z')||LA21_0=='_'||(LA21_0>='g' && LA21_0<='h')||(LA21_0>='j' && LA21_0<='m')||(LA21_0>='o' && LA21_0<='q')||LA21_0=='u'||(LA21_0>='x' && LA21_0<='z')) ) {s = 42;}

                        else if ( (LA21_0=='\"') ) {s = 43;}

                        else if ( (LA21_0=='\'') ) {s = 44;}

                        else if ( ((LA21_0>='\t' && LA21_0<='\n')||LA21_0=='\r'||LA21_0==' ') ) {s = 45;}

                        else if ( ((LA21_0>='\u0000' && LA21_0<='\b')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\u001F')||LA21_0=='@'||LA21_0=='\\'||LA21_0=='`'||(LA21_0>='~' && LA21_0<='\uFFFF')) ) {s = 46;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}