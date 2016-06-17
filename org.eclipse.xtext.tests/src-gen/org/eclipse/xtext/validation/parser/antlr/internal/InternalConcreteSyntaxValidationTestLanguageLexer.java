package org.eclipse.xtext.validation.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConcreteSyntaxValidationTestLanguageLexer extends Lexer {
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators

    public InternalConcreteSyntaxValidationTestLanguageLexer() {;} 
    public InternalConcreteSyntaxValidationTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalConcreteSyntaxValidationTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalConcreteSyntaxValidationTestLanguage.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:11:7: ( '#1' )
            // InternalConcreteSyntaxValidationTestLanguage.g:11:9: '#1'
            {
            match("#1"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:12:7: ( '#2' )
            // InternalConcreteSyntaxValidationTestLanguage.g:12:9: '#2'
            {
            match("#2"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:13:7: ( 'kw1' )
            // InternalConcreteSyntaxValidationTestLanguage.g:13:9: 'kw1'
            {
            match("kw1"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:14:7: ( 'kw2' )
            // InternalConcreteSyntaxValidationTestLanguage.g:14:9: 'kw2'
            {
            match("kw2"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:15:7: ( '#3' )
            // InternalConcreteSyntaxValidationTestLanguage.g:15:9: '#3'
            {
            match("#3"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:16:7: ( 'kw3' )
            // InternalConcreteSyntaxValidationTestLanguage.g:16:9: 'kw3'
            {
            match("kw3"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:17:7: ( '#4' )
            // InternalConcreteSyntaxValidationTestLanguage.g:17:9: '#4'
            {
            match("#4"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:18:7: ( '#5' )
            // InternalConcreteSyntaxValidationTestLanguage.g:18:9: '#5'
            {
            match("#5"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:19:7: ( 'kw4' )
            // InternalConcreteSyntaxValidationTestLanguage.g:19:9: 'kw4'
            {
            match("kw4"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:20:7: ( 'kw5' )
            // InternalConcreteSyntaxValidationTestLanguage.g:20:9: 'kw5'
            {
            match("kw5"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:21:7: ( '#6' )
            // InternalConcreteSyntaxValidationTestLanguage.g:21:9: '#6'
            {
            match("#6"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:22:7: ( '#7' )
            // InternalConcreteSyntaxValidationTestLanguage.g:22:9: '#7'
            {
            match("#7"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:23:7: ( '#8' )
            // InternalConcreteSyntaxValidationTestLanguage.g:23:9: '#8'
            {
            match("#8"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:24:7: ( '#9' )
            // InternalConcreteSyntaxValidationTestLanguage.g:24:9: '#9'
            {
            match("#9"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:25:7: ( '#10' )
            // InternalConcreteSyntaxValidationTestLanguage.g:25:9: '#10'
            {
            match("#10"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:26:7: ( '#11' )
            // InternalConcreteSyntaxValidationTestLanguage.g:26:9: '#11'
            {
            match("#11"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:27:7: ( '#12' )
            // InternalConcreteSyntaxValidationTestLanguage.g:27:9: '#12'
            {
            match("#12"); 


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
            // InternalConcreteSyntaxValidationTestLanguage.g:28:7: ( '#13' )
            // InternalConcreteSyntaxValidationTestLanguage.g:28:9: '#13'
            {
            match("#13"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:29:7: ( '#14' )
            // InternalConcreteSyntaxValidationTestLanguage.g:29:9: '#14'
            {
            match("#14"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:30:7: ( '#15' )
            // InternalConcreteSyntaxValidationTestLanguage.g:30:9: '#15'
            {
            match("#15"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:31:7: ( '#16' )
            // InternalConcreteSyntaxValidationTestLanguage.g:31:9: '#16'
            {
            match("#16"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:32:7: ( 'group' )
            // InternalConcreteSyntaxValidationTestLanguage.g:32:9: 'group'
            {
            match("group"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:33:7: ( '#17' )
            // InternalConcreteSyntaxValidationTestLanguage.g:33:9: '#17'
            {
            match("#17"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:34:7: ( ',' )
            // InternalConcreteSyntaxValidationTestLanguage.g:34:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:35:7: ( '#18' )
            // InternalConcreteSyntaxValidationTestLanguage.g:35:9: '#18'
            {
            match("#18"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:36:7: ( '#19' )
            // InternalConcreteSyntaxValidationTestLanguage.g:36:9: '#19'
            {
            match("#19"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:37:7: ( '#20' )
            // InternalConcreteSyntaxValidationTestLanguage.g:37:9: '#20'
            {
            match("#20"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:38:7: ( '#21' )
            // InternalConcreteSyntaxValidationTestLanguage.g:38:9: '#21'
            {
            match("#21"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:39:7: ( '#22' )
            // InternalConcreteSyntaxValidationTestLanguage.g:39:9: '#22'
            {
            match("#22"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:40:7: ( '#23' )
            // InternalConcreteSyntaxValidationTestLanguage.g:40:9: '#23'
            {
            match("#23"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:41:7: ( 'kw' )
            // InternalConcreteSyntaxValidationTestLanguage.g:41:9: 'kw'
            {
            match("kw"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:42:7: ( '#24' )
            // InternalConcreteSyntaxValidationTestLanguage.g:42:9: '#24'
            {
            match("#24"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:43:7: ( '#25' )
            // InternalConcreteSyntaxValidationTestLanguage.g:43:9: '#25'
            {
            match("#25"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:44:7: ( '#26' )
            // InternalConcreteSyntaxValidationTestLanguage.g:44:9: '#26'
            {
            match("#26"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:45:7: ( '#27' )
            // InternalConcreteSyntaxValidationTestLanguage.g:45:9: '#27'
            {
            match("#27"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:46:7: ( 'short' )
            // InternalConcreteSyntaxValidationTestLanguage.g:46:9: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:47:7: ( 'one' )
            // InternalConcreteSyntaxValidationTestLanguage.g:47:9: 'one'
            {
            match("one"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:48:7: ( 'long' )
            // InternalConcreteSyntaxValidationTestLanguage.g:48:9: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:49:7: ( 'extra' )
            // InternalConcreteSyntaxValidationTestLanguage.g:49:9: 'extra'
            {
            match("extra"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:50:7: ( 'two' )
            // InternalConcreteSyntaxValidationTestLanguage.g:50:9: 'two'
            {
            match("two"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:51:7: ( '#28' )
            // InternalConcreteSyntaxValidationTestLanguage.g:51:9: '#28'
            {
            match("#28"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:52:7: ( 'lit1' )
            // InternalConcreteSyntaxValidationTestLanguage.g:52:9: 'lit1'
            {
            match("lit1"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:53:7: ( 'lit2' )
            // InternalConcreteSyntaxValidationTestLanguage.g:53:9: 'lit2'
            {
            match("lit2"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConcreteSyntaxValidationTestLanguage.g:3570:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalConcreteSyntaxValidationTestLanguage.g:3570:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3570:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3570:11: '^'
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

            // InternalConcreteSyntaxValidationTestLanguage.g:3570:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:
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
            // InternalConcreteSyntaxValidationTestLanguage.g:3572:10: ( ( '0' .. '9' )+ )
            // InternalConcreteSyntaxValidationTestLanguage.g:3572:12: ( '0' .. '9' )+
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3572:12: ( '0' .. '9' )+
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3572:13: '0' .. '9'
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
            // InternalConcreteSyntaxValidationTestLanguage.g:3574:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3574:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3574:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:3574:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalConcreteSyntaxValidationTestLanguage.g:3574:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3574:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3574:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:3574:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalConcreteSyntaxValidationTestLanguage.g:3574:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3574:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3574:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalConcreteSyntaxValidationTestLanguage.g:3576:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalConcreteSyntaxValidationTestLanguage.g:3576:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalConcreteSyntaxValidationTestLanguage.g:3576:24: ( options {greedy=false; } : . )*
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3576:52: .
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
            // InternalConcreteSyntaxValidationTestLanguage.g:3578:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:3578:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalConcreteSyntaxValidationTestLanguage.g:3578:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3578:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalConcreteSyntaxValidationTestLanguage.g:3578:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3578:41: ( '\\r' )? '\\n'
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3578:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalConcreteSyntaxValidationTestLanguage.g:3578:41: '\\r'
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
            // InternalConcreteSyntaxValidationTestLanguage.g:3580:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalConcreteSyntaxValidationTestLanguage.g:3580:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3580:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            // InternalConcreteSyntaxValidationTestLanguage.g:3582:16: ( . )
            // InternalConcreteSyntaxValidationTestLanguage.g:3582:18: .
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
        // InternalConcreteSyntaxValidationTestLanguage.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=50;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:16: T__12
                {
                mT__12(); 

                }
                break;
            case 3 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:22: T__13
                {
                mT__13(); 

                }
                break;
            case 4 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:28: T__14
                {
                mT__14(); 

                }
                break;
            case 5 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:34: T__15
                {
                mT__15(); 

                }
                break;
            case 6 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:40: T__16
                {
                mT__16(); 

                }
                break;
            case 7 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:46: T__17
                {
                mT__17(); 

                }
                break;
            case 8 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:52: T__18
                {
                mT__18(); 

                }
                break;
            case 9 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:58: T__19
                {
                mT__19(); 

                }
                break;
            case 10 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:64: T__20
                {
                mT__20(); 

                }
                break;
            case 11 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:70: T__21
                {
                mT__21(); 

                }
                break;
            case 12 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:76: T__22
                {
                mT__22(); 

                }
                break;
            case 13 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:82: T__23
                {
                mT__23(); 

                }
                break;
            case 14 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:88: T__24
                {
                mT__24(); 

                }
                break;
            case 15 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:94: T__25
                {
                mT__25(); 

                }
                break;
            case 16 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:100: T__26
                {
                mT__26(); 

                }
                break;
            case 17 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:106: T__27
                {
                mT__27(); 

                }
                break;
            case 18 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:112: T__28
                {
                mT__28(); 

                }
                break;
            case 19 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:118: T__29
                {
                mT__29(); 

                }
                break;
            case 20 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:124: T__30
                {
                mT__30(); 

                }
                break;
            case 21 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:130: T__31
                {
                mT__31(); 

                }
                break;
            case 22 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:136: T__32
                {
                mT__32(); 

                }
                break;
            case 23 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:142: T__33
                {
                mT__33(); 

                }
                break;
            case 24 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:148: T__34
                {
                mT__34(); 

                }
                break;
            case 25 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:154: T__35
                {
                mT__35(); 

                }
                break;
            case 26 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:160: T__36
                {
                mT__36(); 

                }
                break;
            case 27 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:166: T__37
                {
                mT__37(); 

                }
                break;
            case 28 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:172: T__38
                {
                mT__38(); 

                }
                break;
            case 29 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:178: T__39
                {
                mT__39(); 

                }
                break;
            case 30 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:184: T__40
                {
                mT__40(); 

                }
                break;
            case 31 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:190: T__41
                {
                mT__41(); 

                }
                break;
            case 32 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:196: T__42
                {
                mT__42(); 

                }
                break;
            case 33 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:202: T__43
                {
                mT__43(); 

                }
                break;
            case 34 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:208: T__44
                {
                mT__44(); 

                }
                break;
            case 35 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:214: T__45
                {
                mT__45(); 

                }
                break;
            case 36 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:220: T__46
                {
                mT__46(); 

                }
                break;
            case 37 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:226: T__47
                {
                mT__47(); 

                }
                break;
            case 38 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:232: T__48
                {
                mT__48(); 

                }
                break;
            case 39 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:238: T__49
                {
                mT__49(); 

                }
                break;
            case 40 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:244: T__50
                {
                mT__50(); 

                }
                break;
            case 41 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:250: T__51
                {
                mT__51(); 

                }
                break;
            case 42 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:256: T__52
                {
                mT__52(); 

                }
                break;
            case 43 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:262: T__53
                {
                mT__53(); 

                }
                break;
            case 44 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:268: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 45 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:276: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 46 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:285: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 47 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:297: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 48 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:313: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 49 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:329: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 50 :
                // InternalConcreteSyntaxValidationTestLanguage.g:1:337: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\21\2\34\1\uffff\5\34\1\21\2\uffff\3\21\2\uffff\1\64\1\76\7\uffff\1\104\1\uffff\1\34\1\uffff\6\34\32\uffff\1\114\1\115\1\116\1\117\1\120\1\uffff\2\34\1\123\3\34\1\130\5\uffff\2\34\1\uffff\1\133\1\134\1\135\1\34\1\uffff\1\137\1\140\3\uffff\1\141\3\uffff";
    static final String DFA12_eofS =
        "\142\uffff";
    static final String DFA12_minS =
        "\1\0\1\61\1\167\1\162\1\uffff\1\150\1\156\1\151\1\170\1\167\1\101\2\uffff\2\0\1\52\2\uffff\2\60\7\uffff\1\60\1\uffff\1\157\1\uffff\1\157\1\145\1\156\2\164\1\157\32\uffff\5\60\1\uffff\1\165\1\162\1\60\1\147\1\61\1\162\1\60\5\uffff\1\160\1\164\1\uffff\3\60\1\141\1\uffff\2\60\3\uffff\1\60\3\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\71\1\167\1\162\1\uffff\1\150\1\156\1\157\1\170\1\167\1\172\2\uffff\2\uffff\1\57\2\uffff\1\71\1\70\7\uffff\1\172\1\uffff\1\157\1\uffff\1\157\1\145\1\156\2\164\1\157\32\uffff\5\172\1\uffff\1\165\1\162\1\172\1\147\1\62\1\162\1\172\5\uffff\1\160\1\164\1\uffff\3\172\1\141\1\uffff\2\172\3\uffff\1\172\3\uffff";
    static final String DFA12_acceptS =
        "\4\uffff\1\30\6\uffff\1\54\1\55\3\uffff\1\61\1\62\2\uffff\1\5\1\7\1\10\1\13\1\14\1\15\1\16\1\uffff\1\54\1\uffff\1\30\6\uffff\1\55\1\56\1\57\1\60\1\61\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\27\1\31\1\32\1\1\1\33\1\34\1\35\1\36\1\40\1\41\1\42\1\43\1\51\1\2\5\uffff\1\37\7\uffff\1\3\1\4\1\6\1\11\1\12\2\uffff\1\45\4\uffff\1\50\2\uffff\1\46\1\52\1\53\1\uffff\1\26\1\44\1\47";
    static final String DFA12_specialS =
        "\1\0\14\uffff\1\2\1\1\123\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\21\2\20\2\21\1\20\22\21\1\20\1\21\1\15\1\1\3\21\1\16\4\21\1\4\2\21\1\17\12\14\7\21\32\13\3\21\1\12\1\13\1\21\4\13\1\10\1\13\1\3\3\13\1\2\1\7\2\13\1\6\3\13\1\5\1\11\6\13\uff85\21",
            "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32",
            "\1\33",
            "\1\35",
            "",
            "\1\37",
            "\1\40",
            "\1\42\5\uffff\1\41",
            "\1\43",
            "\1\44",
            "\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\0\46",
            "\0\46",
            "\1\47\4\uffff\1\50",
            "",
            "",
            "\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63",
            "\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\34\1\77\1\100\1\101\1\102\1\103\4\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\105",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
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
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\121",
            "\1\122",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\124",
            "\1\125\1\126",
            "\1\127",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "",
            "",
            "\1\131",
            "\1\132",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\136",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    static class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='#') ) {s = 1;}

                        else if ( (LA12_0=='k') ) {s = 2;}

                        else if ( (LA12_0=='g') ) {s = 3;}

                        else if ( (LA12_0==',') ) {s = 4;}

                        else if ( (LA12_0=='s') ) {s = 5;}

                        else if ( (LA12_0=='o') ) {s = 6;}

                        else if ( (LA12_0=='l') ) {s = 7;}

                        else if ( (LA12_0=='e') ) {s = 8;}

                        else if ( (LA12_0=='t') ) {s = 9;}

                        else if ( (LA12_0=='^') ) {s = 10;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='d')||LA12_0=='f'||(LA12_0>='h' && LA12_0<='j')||(LA12_0>='m' && LA12_0<='n')||(LA12_0>='p' && LA12_0<='r')||(LA12_0>='u' && LA12_0<='z')) ) {s = 11;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 12;}

                        else if ( (LA12_0=='\"') ) {s = 13;}

                        else if ( (LA12_0=='\'') ) {s = 14;}

                        else if ( (LA12_0=='/') ) {s = 15;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 16;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='$' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='+')||(LA12_0>='-' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 17;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_14 = input.LA(1);

                        s = -1;
                        if ( ((LA12_14>='\u0000' && LA12_14<='\uFFFF')) ) {s = 38;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_13 = input.LA(1);

                        s = -1;
                        if ( ((LA12_13>='\u0000' && LA12_13<='\uFFFF')) ) {s = 38;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}