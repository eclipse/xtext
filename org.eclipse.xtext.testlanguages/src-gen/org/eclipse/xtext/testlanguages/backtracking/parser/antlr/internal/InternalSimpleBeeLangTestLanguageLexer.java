package org.eclipse.xtext.testlanguages.backtracking.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSimpleBeeLangTestLanguageLexer extends Lexer {
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=5;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__29=29;
    public static final int T__64=64;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__26=26;
    public static final int T__63=63;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=8;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=7;
    public static final int T__33=33;
    public static final int T__71=71;
    public static final int T__34=34;
    public static final int T__72=72;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__70=70;
    public static final int RULE_DOCUMENTATION=4;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__76=76;
    public static final int RULE_WS=11;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__77=77;

    // delegates
    // delegators

    public InternalSimpleBeeLangTestLanguageLexer() {;} 
    public InternalSimpleBeeLangTestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalSimpleBeeLangTestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalSimpleBeeLangTestLanguage.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:11:7: ( 'unit' )
            // InternalSimpleBeeLangTestLanguage.g:11:9: 'unit'
            {
            match("unit"); 


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
            // InternalSimpleBeeLangTestLanguage.g:12:7: ( 'version' )
            // InternalSimpleBeeLangTestLanguage.g:12:9: 'version'
            {
            match("version"); 


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
            // InternalSimpleBeeLangTestLanguage.g:13:7: ( 'implements' )
            // InternalSimpleBeeLangTestLanguage.g:13:9: 'implements'
            {
            match("implements"); 


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
            // InternalSimpleBeeLangTestLanguage.g:14:7: ( ',' )
            // InternalSimpleBeeLangTestLanguage.g:14:9: ','
            {
            match(','); 

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
            // InternalSimpleBeeLangTestLanguage.g:15:7: ( '{' )
            // InternalSimpleBeeLangTestLanguage.g:15:9: '{'
            {
            match('{'); 

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
            // InternalSimpleBeeLangTestLanguage.g:16:7: ( 'source' )
            // InternalSimpleBeeLangTestLanguage.g:16:9: 'source'
            {
            match("source"); 


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
            // InternalSimpleBeeLangTestLanguage.g:17:7: ( ':' )
            // InternalSimpleBeeLangTestLanguage.g:17:9: ':'
            {
            match(':'); 

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
            // InternalSimpleBeeLangTestLanguage.g:18:7: ( ';' )
            // InternalSimpleBeeLangTestLanguage.g:18:9: ';'
            {
            match(';'); 

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
            // InternalSimpleBeeLangTestLanguage.g:19:7: ( 'output' )
            // InternalSimpleBeeLangTestLanguage.g:19:9: 'output'
            {
            match("output"); 


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
            // InternalSimpleBeeLangTestLanguage.g:20:7: ( 'provides' )
            // InternalSimpleBeeLangTestLanguage.g:20:9: 'provides'
            {
            match("provides"); 


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
            // InternalSimpleBeeLangTestLanguage.g:21:7: ( 'requires' )
            // InternalSimpleBeeLangTestLanguage.g:21:9: 'requires'
            {
            match("requires"); 


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
            // InternalSimpleBeeLangTestLanguage.g:22:7: ( 'env' )
            // InternalSimpleBeeLangTestLanguage.g:22:9: 'env'
            {
            match("env"); 


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
            // InternalSimpleBeeLangTestLanguage.g:23:7: ( '}' )
            // InternalSimpleBeeLangTestLanguage.g:23:9: '}'
            {
            match('}'); 

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
            // InternalSimpleBeeLangTestLanguage.g:24:7: ( 'when' )
            // InternalSimpleBeeLangTestLanguage.g:24:9: 'when'
            {
            match("when"); 


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
            // InternalSimpleBeeLangTestLanguage.g:25:7: ( 'name' )
            // InternalSimpleBeeLangTestLanguage.g:25:9: 'name'
            {
            match("name"); 


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
            // InternalSimpleBeeLangTestLanguage.g:26:7: ( 'as' )
            // InternalSimpleBeeLangTestLanguage.g:26:9: 'as'
            {
            match("as"); 


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
            // InternalSimpleBeeLangTestLanguage.g:27:7: ( 'greedy' )
            // InternalSimpleBeeLangTestLanguage.g:27:9: 'greedy'
            {
            match("greedy"); 


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
            // InternalSimpleBeeLangTestLanguage.g:28:7: ( 'requires-min' )
            // InternalSimpleBeeLangTestLanguage.g:28:9: 'requires-min'
            {
            match("requires-min"); 


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
            // InternalSimpleBeeLangTestLanguage.g:29:7: ( 'requires-max' )
            // InternalSimpleBeeLangTestLanguage.g:29:9: 'requires-max'
            {
            match("requires-max"); 


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
            // InternalSimpleBeeLangTestLanguage.g:30:7: ( '/' )
            // InternalSimpleBeeLangTestLanguage.g:30:9: '/'
            {
            match('/'); 

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
            // InternalSimpleBeeLangTestLanguage.g:31:7: ( 'final' )
            // InternalSimpleBeeLangTestLanguage.g:31:9: 'final'
            {
            match("final"); 


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
            // InternalSimpleBeeLangTestLanguage.g:32:7: ( 'function' )
            // InternalSimpleBeeLangTestLanguage.g:32:9: 'function'
            {
            match("function"); 


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
            // InternalSimpleBeeLangTestLanguage.g:33:7: ( '(' )
            // InternalSimpleBeeLangTestLanguage.g:33:9: '('
            {
            match('('); 

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
            // InternalSimpleBeeLangTestLanguage.g:34:7: ( '...' )
            // InternalSimpleBeeLangTestLanguage.g:34:9: '...'
            {
            match("..."); 


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
            // InternalSimpleBeeLangTestLanguage.g:35:7: ( ')' )
            // InternalSimpleBeeLangTestLanguage.g:35:9: ')'
            {
            match(')'); 

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
            // InternalSimpleBeeLangTestLanguage.g:36:7: ( '=' )
            // InternalSimpleBeeLangTestLanguage.g:36:9: '='
            {
            match('='); 

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
            // InternalSimpleBeeLangTestLanguage.g:37:7: ( '+=' )
            // InternalSimpleBeeLangTestLanguage.g:37:9: '+='
            {
            match("+="); 


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
            // InternalSimpleBeeLangTestLanguage.g:38:7: ( '-=' )
            // InternalSimpleBeeLangTestLanguage.g:38:9: '-='
            {
            match("-="); 


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
            // InternalSimpleBeeLangTestLanguage.g:39:7: ( '*=' )
            // InternalSimpleBeeLangTestLanguage.g:39:9: '*='
            {
            match("*="); 


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
            // InternalSimpleBeeLangTestLanguage.g:40:7: ( '/=' )
            // InternalSimpleBeeLangTestLanguage.g:40:9: '/='
            {
            match("/="); 


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
            // InternalSimpleBeeLangTestLanguage.g:41:7: ( '%=' )
            // InternalSimpleBeeLangTestLanguage.g:41:9: '%='
            {
            match("%="); 


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
            // InternalSimpleBeeLangTestLanguage.g:42:7: ( '~=' )
            // InternalSimpleBeeLangTestLanguage.g:42:9: '~='
            {
            match("~="); 


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
            // InternalSimpleBeeLangTestLanguage.g:43:7: ( '==' )
            // InternalSimpleBeeLangTestLanguage.g:43:9: '=='
            {
            match("=="); 


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
            // InternalSimpleBeeLangTestLanguage.g:44:7: ( '===' )
            // InternalSimpleBeeLangTestLanguage.g:44:9: '==='
            {
            match("==="); 


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
            // InternalSimpleBeeLangTestLanguage.g:45:7: ( '!=' )
            // InternalSimpleBeeLangTestLanguage.g:45:9: '!='
            {
            match("!="); 


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
            // InternalSimpleBeeLangTestLanguage.g:46:7: ( '!==' )
            // InternalSimpleBeeLangTestLanguage.g:46:9: '!=='
            {
            match("!=="); 


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
            // InternalSimpleBeeLangTestLanguage.g:47:7: ( '>=' )
            // InternalSimpleBeeLangTestLanguage.g:47:9: '>='
            {
            match(">="); 


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
            // InternalSimpleBeeLangTestLanguage.g:48:7: ( '<=' )
            // InternalSimpleBeeLangTestLanguage.g:48:9: '<='
            {
            match("<="); 


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
            // InternalSimpleBeeLangTestLanguage.g:49:7: ( '>' )
            // InternalSimpleBeeLangTestLanguage.g:49:9: '>'
            {
            match('>'); 

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
            // InternalSimpleBeeLangTestLanguage.g:50:7: ( '<' )
            // InternalSimpleBeeLangTestLanguage.g:50:9: '<'
            {
            match('<'); 

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
            // InternalSimpleBeeLangTestLanguage.g:51:7: ( 'var' )
            // InternalSimpleBeeLangTestLanguage.g:51:9: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:52:7: ( 'val' )
            // InternalSimpleBeeLangTestLanguage.g:52:9: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:53:7: ( '=>' )
            // InternalSimpleBeeLangTestLanguage.g:53:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:54:7: ( 'cached' )
            // InternalSimpleBeeLangTestLanguage.g:54:9: 'cached'
            {
            match("cached"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:55:7: ( '||' )
            // InternalSimpleBeeLangTestLanguage.g:55:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:56:7: ( '&&' )
            // InternalSimpleBeeLangTestLanguage.g:56:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:57:7: ( '+' )
            // InternalSimpleBeeLangTestLanguage.g:57:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:58:7: ( '-' )
            // InternalSimpleBeeLangTestLanguage.g:58:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:59:7: ( '*' )
            // InternalSimpleBeeLangTestLanguage.g:59:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:60:7: ( '%' )
            // InternalSimpleBeeLangTestLanguage.g:60:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:61:7: ( '..' )
            // InternalSimpleBeeLangTestLanguage.g:61:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:62:7: ( '!' )
            // InternalSimpleBeeLangTestLanguage.g:62:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:63:7: ( '++' )
            // InternalSimpleBeeLangTestLanguage.g:63:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:64:7: ( '--' )
            // InternalSimpleBeeLangTestLanguage.g:64:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:65:7: ( '.' )
            // InternalSimpleBeeLangTestLanguage.g:65:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:66:7: ( '[' )
            // InternalSimpleBeeLangTestLanguage.g:66:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:67:7: ( ']' )
            // InternalSimpleBeeLangTestLanguage.g:67:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:68:7: ( 'with' )
            // InternalSimpleBeeLangTestLanguage.g:68:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:69:7: ( 'context' )
            // InternalSimpleBeeLangTestLanguage.g:69:9: 'context'
            {
            match("context"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:70:7: ( 'input' )
            // InternalSimpleBeeLangTestLanguage.g:70:9: 'input'
            {
            match("input"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:71:7: ( 'properties' )
            // InternalSimpleBeeLangTestLanguage.g:71:9: 'properties'
            {
            match("properties"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:72:7: ( 'builder' )
            // InternalSimpleBeeLangTestLanguage.g:72:9: 'builder'
            {
            match("builder"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:73:7: ( 'this' )
            // InternalSimpleBeeLangTestLanguage.g:73:9: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:74:7: ( 'new' )
            // InternalSimpleBeeLangTestLanguage.g:74:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:75:7: ( '|' )
            // InternalSimpleBeeLangTestLanguage.g:75:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "RULE_DOCUMENTATION"
    public final void mRULE_DOCUMENTATION() throws RecognitionException {
        try {
            int _type = RULE_DOCUMENTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSimpleBeeLangTestLanguage.g:5510:20: ( '/**' ( options {greedy=false; } : . )* '*/' )
            // InternalSimpleBeeLangTestLanguage.g:5510:22: '/**' ( options {greedy=false; } : . )* '*/'
            {
            match("/**"); 

            // InternalSimpleBeeLangTestLanguage.g:5510:28: ( options {greedy=false; } : . )*
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
            	    // InternalSimpleBeeLangTestLanguage.g:5510:56: .
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
            // InternalSimpleBeeLangTestLanguage.g:5512:10: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalSimpleBeeLangTestLanguage.g:5512:12: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalSimpleBeeLangTestLanguage.g:5512:26: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
            	    // InternalSimpleBeeLangTestLanguage.g:
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
            // InternalSimpleBeeLangTestLanguage.g:5514:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalSimpleBeeLangTestLanguage.g:5514:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalSimpleBeeLangTestLanguage.g:5514:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:5514:11: '^'
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

            // InternalSimpleBeeLangTestLanguage.g:5514:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:
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
            // InternalSimpleBeeLangTestLanguage.g:5516:10: ( ( '0' .. '9' )+ )
            // InternalSimpleBeeLangTestLanguage.g:5516:12: ( '0' .. '9' )+
            {
            // InternalSimpleBeeLangTestLanguage.g:5516:12: ( '0' .. '9' )+
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
            	    // InternalSimpleBeeLangTestLanguage.g:5516:13: '0' .. '9'
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
            // InternalSimpleBeeLangTestLanguage.g:5518:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalSimpleBeeLangTestLanguage.g:5518:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalSimpleBeeLangTestLanguage.g:5518:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalSimpleBeeLangTestLanguage.g:5518:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalSimpleBeeLangTestLanguage.g:5518:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalSimpleBeeLangTestLanguage.g:5518:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalSimpleBeeLangTestLanguage.g:5518:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalSimpleBeeLangTestLanguage.g:5518:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalSimpleBeeLangTestLanguage.g:5518:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalSimpleBeeLangTestLanguage.g:5518:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalSimpleBeeLangTestLanguage.g:5518:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalSimpleBeeLangTestLanguage.g:5520:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalSimpleBeeLangTestLanguage.g:5520:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalSimpleBeeLangTestLanguage.g:5520:24: ( options {greedy=false; } : . )*
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
            	    // InternalSimpleBeeLangTestLanguage.g:5520:52: .
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
            // InternalSimpleBeeLangTestLanguage.g:5522:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalSimpleBeeLangTestLanguage.g:5522:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalSimpleBeeLangTestLanguage.g:5522:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:5522:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalSimpleBeeLangTestLanguage.g:5522:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:5522:41: ( '\\r' )? '\\n'
                    {
                    // InternalSimpleBeeLangTestLanguage.g:5522:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalSimpleBeeLangTestLanguage.g:5522:41: '\\r'
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
            // InternalSimpleBeeLangTestLanguage.g:5524:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalSimpleBeeLangTestLanguage.g:5524:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalSimpleBeeLangTestLanguage.g:5524:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalSimpleBeeLangTestLanguage.g:
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
            // InternalSimpleBeeLangTestLanguage.g:5526:16: ( . )
            // InternalSimpleBeeLangTestLanguage.g:5526:18: .
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
        // InternalSimpleBeeLangTestLanguage.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | RULE_DOCUMENTATION | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=74;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // InternalSimpleBeeLangTestLanguage.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalSimpleBeeLangTestLanguage.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalSimpleBeeLangTestLanguage.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalSimpleBeeLangTestLanguage.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalSimpleBeeLangTestLanguage.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalSimpleBeeLangTestLanguage.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalSimpleBeeLangTestLanguage.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalSimpleBeeLangTestLanguage.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalSimpleBeeLangTestLanguage.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalSimpleBeeLangTestLanguage.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalSimpleBeeLangTestLanguage.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalSimpleBeeLangTestLanguage.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalSimpleBeeLangTestLanguage.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalSimpleBeeLangTestLanguage.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalSimpleBeeLangTestLanguage.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalSimpleBeeLangTestLanguage.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalSimpleBeeLangTestLanguage.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalSimpleBeeLangTestLanguage.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalSimpleBeeLangTestLanguage.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalSimpleBeeLangTestLanguage.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalSimpleBeeLangTestLanguage.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalSimpleBeeLangTestLanguage.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalSimpleBeeLangTestLanguage.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalSimpleBeeLangTestLanguage.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalSimpleBeeLangTestLanguage.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalSimpleBeeLangTestLanguage.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalSimpleBeeLangTestLanguage.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalSimpleBeeLangTestLanguage.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalSimpleBeeLangTestLanguage.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalSimpleBeeLangTestLanguage.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalSimpleBeeLangTestLanguage.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalSimpleBeeLangTestLanguage.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalSimpleBeeLangTestLanguage.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalSimpleBeeLangTestLanguage.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalSimpleBeeLangTestLanguage.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalSimpleBeeLangTestLanguage.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalSimpleBeeLangTestLanguage.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalSimpleBeeLangTestLanguage.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalSimpleBeeLangTestLanguage.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // InternalSimpleBeeLangTestLanguage.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // InternalSimpleBeeLangTestLanguage.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // InternalSimpleBeeLangTestLanguage.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // InternalSimpleBeeLangTestLanguage.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // InternalSimpleBeeLangTestLanguage.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // InternalSimpleBeeLangTestLanguage.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // InternalSimpleBeeLangTestLanguage.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // InternalSimpleBeeLangTestLanguage.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // InternalSimpleBeeLangTestLanguage.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // InternalSimpleBeeLangTestLanguage.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // InternalSimpleBeeLangTestLanguage.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // InternalSimpleBeeLangTestLanguage.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // InternalSimpleBeeLangTestLanguage.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // InternalSimpleBeeLangTestLanguage.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // InternalSimpleBeeLangTestLanguage.g:1:328: T__66
                {
                mT__66(); 

                }
                break;
            case 55 :
                // InternalSimpleBeeLangTestLanguage.g:1:334: T__67
                {
                mT__67(); 

                }
                break;
            case 56 :
                // InternalSimpleBeeLangTestLanguage.g:1:340: T__68
                {
                mT__68(); 

                }
                break;
            case 57 :
                // InternalSimpleBeeLangTestLanguage.g:1:346: T__69
                {
                mT__69(); 

                }
                break;
            case 58 :
                // InternalSimpleBeeLangTestLanguage.g:1:352: T__70
                {
                mT__70(); 

                }
                break;
            case 59 :
                // InternalSimpleBeeLangTestLanguage.g:1:358: T__71
                {
                mT__71(); 

                }
                break;
            case 60 :
                // InternalSimpleBeeLangTestLanguage.g:1:364: T__72
                {
                mT__72(); 

                }
                break;
            case 61 :
                // InternalSimpleBeeLangTestLanguage.g:1:370: T__73
                {
                mT__73(); 

                }
                break;
            case 62 :
                // InternalSimpleBeeLangTestLanguage.g:1:376: T__74
                {
                mT__74(); 

                }
                break;
            case 63 :
                // InternalSimpleBeeLangTestLanguage.g:1:382: T__75
                {
                mT__75(); 

                }
                break;
            case 64 :
                // InternalSimpleBeeLangTestLanguage.g:1:388: T__76
                {
                mT__76(); 

                }
                break;
            case 65 :
                // InternalSimpleBeeLangTestLanguage.g:1:394: T__77
                {
                mT__77(); 

                }
                break;
            case 66 :
                // InternalSimpleBeeLangTestLanguage.g:1:400: RULE_DOCUMENTATION
                {
                mRULE_DOCUMENTATION(); 

                }
                break;
            case 67 :
                // InternalSimpleBeeLangTestLanguage.g:1:419: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 68 :
                // InternalSimpleBeeLangTestLanguage.g:1:428: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 69 :
                // InternalSimpleBeeLangTestLanguage.g:1:436: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 70 :
                // InternalSimpleBeeLangTestLanguage.g:1:445: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 71 :
                // InternalSimpleBeeLangTestLanguage.g:1:457: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 72 :
                // InternalSimpleBeeLangTestLanguage.g:1:473: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 73 :
                // InternalSimpleBeeLangTestLanguage.g:1:489: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 74 :
                // InternalSimpleBeeLangTestLanguage.g:1:497: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\3\60\2\uffff\1\60\2\uffff\4\60\1\uffff\4\60\1\110\1\60\1\uffff\1\115\1\uffff\1\121\1\124\1\127\1\131\1\133\1\56\1\136\1\140\1\142\1\60\1\146\1\56\2\uffff\2\60\1\155\1\56\2\uffff\2\56\2\uffff\1\60\1\uffff\4\60\2\uffff\1\60\2\uffff\4\60\1\uffff\4\60\1\177\1\60\4\uffff\2\60\1\uffff\1\u0086\2\uffff\1\u0088\15\uffff\1\u008a\5\uffff\2\60\5\uffff\2\60\4\uffff\2\60\1\u0091\1\u0092\6\60\1\u009a\3\60\1\u009e\1\uffff\1\60\2\uffff\2\60\6\uffff\4\60\1\u00a9\1\60\2\uffff\7\60\1\uffff\1\u00b2\1\u00b3\1\u00b4\1\uffff\1\60\1\u0082\2\uffff\5\60\1\u00bc\1\uffff\2\60\1\u00bf\5\60\3\uffff\1\60\1\u00c6\1\u00c7\4\60\1\uffff\2\60\1\uffff\1\u00ce\1\u00cf\3\60\1\u00d3\2\uffff\1\60\1\u00d5\2\60\1\u00d8\1\60\2\uffff\3\60\1\uffff\1\60\1\uffff\1\u00de\1\u00df\1\uffff\1\60\1\u00e1\1\60\1\u00e4\1\u00e5\2\uffff\1\60\1\uffff\1\60\3\uffff\1\u00e9\1\u00ea\5\uffff";
    static final String DFA14_eofS =
        "\u00ed\uffff";
    static final String DFA14_minS =
        "\1\0\1\156\1\141\1\155\2\uffff\1\157\2\uffff\1\165\1\162\1\145\1\156\1\uffff\1\150\1\141\1\163\1\162\1\52\1\151\1\uffff\1\56\1\uffff\1\75\1\53\1\55\6\75\1\141\1\174\1\46\2\uffff\1\165\1\150\1\130\1\101\2\uffff\2\0\2\uffff\1\151\1\uffff\1\162\1\154\2\160\2\uffff\1\165\2\uffff\1\164\1\157\1\161\1\166\1\uffff\1\145\1\164\1\155\1\167\1\60\1\145\1\uffff\1\0\2\uffff\2\156\1\uffff\1\56\2\uffff\1\75\15\uffff\1\75\5\uffff\1\143\1\156\5\uffff\2\151\4\uffff\1\164\1\163\2\60\1\154\1\165\1\162\2\160\1\165\1\60\1\156\1\150\1\145\1\60\1\uffff\1\145\1\0\1\uffff\1\141\1\143\6\uffff\1\150\1\164\1\154\1\163\1\60\1\151\2\uffff\1\145\1\164\1\143\1\165\1\151\1\145\1\151\1\uffff\3\60\1\uffff\1\144\3\0\1\154\1\164\2\145\1\144\1\60\1\uffff\1\157\1\155\1\60\1\145\1\164\1\144\2\162\3\uffff\1\171\1\0\1\60\1\151\1\144\1\170\1\145\1\uffff\1\156\1\145\1\uffff\2\60\1\145\1\164\1\145\1\60\2\uffff\1\157\1\60\1\164\1\162\1\60\1\156\2\uffff\1\163\1\151\1\163\1\uffff\1\156\1\uffff\2\60\1\uffff\1\164\1\60\1\145\1\55\1\60\2\uffff\1\163\1\uffff\1\163\1\155\2\uffff\2\60\1\141\4\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\156\1\145\1\156\2\uffff\1\157\2\uffff\1\165\1\162\1\145\1\156\1\uffff\1\151\1\145\1\163\1\162\1\75\1\165\1\uffff\1\56\1\uffff\1\76\10\75\1\157\1\174\1\46\2\uffff\1\165\1\150\1\170\1\172\2\uffff\2\uffff\2\uffff\1\151\1\uffff\2\162\2\160\2\uffff\1\165\2\uffff\1\164\1\157\1\161\1\166\1\uffff\1\145\1\164\1\155\1\167\1\172\1\145\1\uffff\1\uffff\2\uffff\2\156\1\uffff\1\56\2\uffff\1\75\15\uffff\1\75\5\uffff\1\143\1\156\5\uffff\2\151\4\uffff\1\164\1\163\2\172\1\154\1\165\1\162\1\160\1\166\1\165\1\172\1\156\1\150\1\145\1\172\1\uffff\1\145\1\uffff\1\uffff\1\141\1\143\6\uffff\1\150\1\164\1\154\1\163\1\172\1\151\2\uffff\1\145\1\164\1\143\1\165\1\151\1\145\1\151\1\uffff\3\172\1\uffff\1\144\3\uffff\1\154\1\164\2\145\1\144\1\172\1\uffff\1\157\1\155\1\172\1\145\1\164\1\144\2\162\3\uffff\1\171\1\uffff\1\172\1\151\1\144\1\170\1\145\1\uffff\1\156\1\145\1\uffff\2\172\1\145\1\164\1\145\1\172\2\uffff\1\157\1\172\1\164\1\162\1\172\1\156\2\uffff\1\163\1\151\1\163\1\uffff\1\156\1\uffff\2\172\1\uffff\1\164\1\172\1\145\2\172\2\uffff\1\163\1\uffff\1\163\1\155\2\uffff\2\172\1\151\4\uffff";
    static final String DFA14_acceptS =
        "\4\uffff\1\4\1\5\1\uffff\1\7\1\10\4\uffff\1\15\6\uffff\1\27\1\uffff\1\31\14\uffff\1\70\1\71\4\uffff\1\104\1\105\2\uffff\1\111\1\112\1\uffff\1\104\4\uffff\1\4\1\5\1\uffff\1\7\1\10\4\uffff\1\15\6\uffff\1\36\1\uffff\1\110\1\24\2\uffff\1\27\1\uffff\1\67\1\31\1\uffff\1\53\1\32\1\33\1\65\1\57\1\34\1\66\1\60\1\35\1\61\1\37\1\62\1\40\1\uffff\1\64\1\45\1\47\1\46\1\50\2\uffff\1\55\1\101\1\56\1\70\1\71\2\uffff\1\103\1\105\1\106\1\111\17\uffff\1\20\2\uffff\1\107\2\uffff\1\30\1\63\1\42\1\41\1\44\1\43\6\uffff\1\51\1\52\7\uffff\1\14\3\uffff\1\100\12\uffff\1\1\10\uffff\1\16\1\72\1\17\7\uffff\1\77\2\uffff\1\74\6\uffff\1\102\1\25\6\uffff\1\6\1\11\3\uffff\1\21\1\uffff\1\54\2\uffff\1\2\5\uffff\1\73\1\76\1\uffff\1\12\2\uffff\1\13\1\26\3\uffff\1\3\1\75\1\22\1\23";
    static final String DFA14_specialS =
        "\1\2\52\uffff\1\5\1\4\31\uffff\1\3\72\uffff\1\7\36\uffff\1\10\1\6\1\1\23\uffff\1\0\66\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\56\2\55\2\56\1\55\22\56\1\55\1\35\1\53\2\56\1\33\1\42\1\54\1\24\1\26\1\32\1\30\1\4\1\31\1\25\1\22\1\47\11\52\1\7\1\10\1\37\1\27\1\36\2\56\32\51\1\43\1\56\1\44\1\50\1\51\1\56\1\20\1\45\1\40\1\51\1\14\1\23\1\21\1\51\1\3\4\51\1\17\1\11\1\12\1\51\1\13\1\6\1\46\1\1\1\2\1\16\3\51\1\5\1\41\1\15\1\34\uff81\56",
            "\1\57",
            "\1\62\3\uffff\1\61",
            "\1\63\1\64",
            "",
            "",
            "\1\67",
            "",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "",
            "\1\77\1\100",
            "\1\101\3\uffff\1\102",
            "\1\103",
            "\1\104",
            "\1\106\4\uffff\1\107\15\uffff\1\105",
            "\1\111\13\uffff\1\112",
            "",
            "\1\114",
            "",
            "\1\117\1\120",
            "\1\123\21\uffff\1\122",
            "\1\126\17\uffff\1\125",
            "\1\130",
            "\1\132",
            "\1\134",
            "\1\135",
            "\1\137",
            "\1\141",
            "\1\143\15\uffff\1\144",
            "\1\145",
            "\1\147",
            "",
            "",
            "\1\152",
            "\1\153",
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
            "\1\163\5\uffff\1\162",
            "\1\164",
            "\1\165",
            "",
            "",
            "\1\166",
            "",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0080",
            "",
            "\52\u0082\1\u0081\uffd5\u0082",
            "",
            "",
            "\1\u0083",
            "\1\u0084",
            "",
            "\1\u0085",
            "",
            "",
            "\1\u0087",
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
            "\1\u0089",
            "",
            "",
            "",
            "",
            "",
            "\1\u008b",
            "\1\u008c",
            "",
            "",
            "",
            "",
            "",
            "\1\u008d",
            "\1\u008e",
            "",
            "",
            "",
            "",
            "\1\u008f",
            "\1\u0090",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0098\5\uffff\1\u0097",
            "\1\u0099",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u009f",
            "\52\u00a2\1\u00a1\4\u00a2\1\u00a0\uffd0\u00a2",
            "",
            "\1\u00a3",
            "\1\u00a4",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00aa",
            "",
            "",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00b5",
            "\52\u00a2\1\u00a1\uffd5\u00a2",
            "\52\u00a2\1\u00a1\4\u00a2\1\u00b6\uffd0\u00a2",
            "\52\u00a2\1\u00a1\uffd5\u00a2",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00bd",
            "\1\u00be",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "",
            "",
            "",
            "\1\u00c5",
            "\52\u00a2\1\u00a1\uffd5\u00a2",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "",
            "\1\u00cc",
            "\1\u00cd",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "\1\u00d4",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00d6",
            "\1\u00d7",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00d9",
            "",
            "",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "",
            "\1\u00dd",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00e0",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00e2",
            "\1\u00e3\2\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "\1\u00e6",
            "",
            "\1\u00e7",
            "\1\u00e8",
            "",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00ec\7\uffff\1\u00eb",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | RULE_DOCUMENTATION | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_182 = input.LA(1);

                        s = -1;
                        if ( (LA14_182=='*') ) {s = 161;}

                        else if ( ((LA14_182>='\u0000' && LA14_182<=')')||(LA14_182>='+' && LA14_182<='\uFFFF')) ) {s = 162;}

                        else s = 198;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_162 = input.LA(1);

                        s = -1;
                        if ( (LA14_162=='*') ) {s = 161;}

                        else if ( ((LA14_162>='\u0000' && LA14_162<=')')||(LA14_162>='+' && LA14_162<='\uFFFF')) ) {s = 162;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='u') ) {s = 1;}

                        else if ( (LA14_0=='v') ) {s = 2;}

                        else if ( (LA14_0=='i') ) {s = 3;}

                        else if ( (LA14_0==',') ) {s = 4;}

                        else if ( (LA14_0=='{') ) {s = 5;}

                        else if ( (LA14_0=='s') ) {s = 6;}

                        else if ( (LA14_0==':') ) {s = 7;}

                        else if ( (LA14_0==';') ) {s = 8;}

                        else if ( (LA14_0=='o') ) {s = 9;}

                        else if ( (LA14_0=='p') ) {s = 10;}

                        else if ( (LA14_0=='r') ) {s = 11;}

                        else if ( (LA14_0=='e') ) {s = 12;}

                        else if ( (LA14_0=='}') ) {s = 13;}

                        else if ( (LA14_0=='w') ) {s = 14;}

                        else if ( (LA14_0=='n') ) {s = 15;}

                        else if ( (LA14_0=='a') ) {s = 16;}

                        else if ( (LA14_0=='g') ) {s = 17;}

                        else if ( (LA14_0=='/') ) {s = 18;}

                        else if ( (LA14_0=='f') ) {s = 19;}

                        else if ( (LA14_0=='(') ) {s = 20;}

                        else if ( (LA14_0=='.') ) {s = 21;}

                        else if ( (LA14_0==')') ) {s = 22;}

                        else if ( (LA14_0=='=') ) {s = 23;}

                        else if ( (LA14_0=='+') ) {s = 24;}

                        else if ( (LA14_0=='-') ) {s = 25;}

                        else if ( (LA14_0=='*') ) {s = 26;}

                        else if ( (LA14_0=='%') ) {s = 27;}

                        else if ( (LA14_0=='~') ) {s = 28;}

                        else if ( (LA14_0=='!') ) {s = 29;}

                        else if ( (LA14_0=='>') ) {s = 30;}

                        else if ( (LA14_0=='<') ) {s = 31;}

                        else if ( (LA14_0=='c') ) {s = 32;}

                        else if ( (LA14_0=='|') ) {s = 33;}

                        else if ( (LA14_0=='&') ) {s = 34;}

                        else if ( (LA14_0=='[') ) {s = 35;}

                        else if ( (LA14_0==']') ) {s = 36;}

                        else if ( (LA14_0=='b') ) {s = 37;}

                        else if ( (LA14_0=='t') ) {s = 38;}

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
                        int LA14_70 = input.LA(1);

                        s = -1;
                        if ( (LA14_70=='*') ) {s = 129;}

                        else if ( ((LA14_70>='\u0000' && LA14_70<=')')||(LA14_70>='+' && LA14_70<='\uFFFF')) ) {s = 130;}

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
                        int LA14_161 = input.LA(1);

                        s = -1;
                        if ( (LA14_161=='/') ) {s = 182;}

                        else if ( (LA14_161=='*') ) {s = 161;}

                        else if ( ((LA14_161>='\u0000' && LA14_161<=')')||(LA14_161>='+' && LA14_161<='.')||(LA14_161>='0' && LA14_161<='\uFFFF')) ) {s = 162;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA14_129 = input.LA(1);

                        s = -1;
                        if ( (LA14_129=='/') ) {s = 160;}

                        else if ( (LA14_129=='*') ) {s = 161;}

                        else if ( ((LA14_129>='\u0000' && LA14_129<=')')||(LA14_129>='+' && LA14_129<='.')||(LA14_129>='0' && LA14_129<='\uFFFF')) ) {s = 162;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA14_160 = input.LA(1);

                        s = -1;
                        if ( (LA14_160=='*') ) {s = 161;}

                        else if ( ((LA14_160>='\u0000' && LA14_160<=')')||(LA14_160>='+' && LA14_160<='\uFFFF')) ) {s = 162;}

                        else s = 130;

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