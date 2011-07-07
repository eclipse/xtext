package org.eclipse.xtext.xtend2.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtend2Lexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_RICH_TEXT_END=9;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int RULE_IN_RICH_STRING=11;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_STRING=5;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int RULE_RICH_TEXT_START=7;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RULE_RICH_TEXT=6;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int RULE_INT=10;
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
    public static final int RULE_SL_COMMENT=13;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_RICH_TEXT_INBETWEEN=8;
    public static final int RULE_WS=14;

    // delegates
    // delegators

    public InternalXtend2Lexer() {;} 
    public InternalXtend2Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalXtend2Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11:7: ( '=' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:11:9: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:12:7: ( '+=' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:12:9: '+='
            {
            match("+="); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:13:7: ( '||' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:13:9: '||'
            {
            match("||"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:14:7: ( '&&' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:14:9: '&&'
            {
            match("&&"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:15:7: ( 'def' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:15:9: 'def'
            {
            match("def"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:16:7: ( 'create' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:16:9: 'create'
            {
            match("create"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:17:7: ( '==' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:17:9: '=='
            {
            match("=="); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:18:7: ( '!=' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:18:9: '!='
            {
            match("!="); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:19:7: ( '>=' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:19:9: '>='
            {
            match(">="); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20:7: ( '<=' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20:9: '<='
            {
            match("<="); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:21:7: ( '>' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:21:9: '>'
            {
            match('>'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:22:7: ( '<' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:22:9: '<'
            {
            match('<'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:23:7: ( '->' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:23:9: '->'
            {
            match("->"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:24:7: ( '..' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:24:9: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:25:7: ( '+' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:25:9: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:26:7: ( '-' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:26:9: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:27:7: ( '*' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:27:9: '*'
            {
            match('*'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:28:7: ( '**' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:28:9: '**'
            {
            match("**"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:29:7: ( '/' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:29:9: '/'
            {
            match('/'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:30:7: ( '%' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:30:9: '%'
            {
            match('%'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:31:7: ( '!' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:31:9: '!'
            {
            match('!'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:32:7: ( '.' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:32:9: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:33:7: ( 'val' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:33:9: 'val'
            {
            match("val"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:34:7: ( 'super' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:34:9: 'super'
            {
            match("super"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:35:7: ( 'false' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:35:9: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:36:7: ( 'package' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:36:9: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:37:7: ( 'import' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:37:9: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:38:7: ( 'class' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:38:9: 'class'
            {
            match("class"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:39:7: ( '{' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:39:9: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:40:7: ( '}' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:40:9: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:41:7: ( ',' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:41:9: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:42:7: ( 'extends' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:42:9: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:43:7: ( 'implements' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:43:9: 'implements'
            {
            match("implements"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:44:7: ( '(' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:44:9: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:45:7: ( ')' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:45:9: ')'
            {
            match(')'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:46:7: ( ':' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:46:9: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:47:7: ( 'FOR' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:47:9: 'FOR'
            {
            match("FOR"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:48:7: ( 'ENDFOR' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:48:9: 'ENDFOR'
            {
            match("ENDFOR"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:49:7: ( 'BEFORE' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:49:9: 'BEFORE'
            {
            match("BEFORE"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:50:7: ( 'SEPARATOR' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:50:9: 'SEPARATOR'
            {
            match("SEPARATOR"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:51:7: ( 'AFTER' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:51:9: 'AFTER'
            {
            match("AFTER"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:52:7: ( 'IF' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:52:9: 'IF'
            {
            match("IF"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:53:7: ( 'ENDIF' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:53:9: 'ENDIF'
            {
            match("ENDIF"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:54:7: ( 'ELSE' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:54:9: 'ELSE'
            {
            match("ELSE"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:55:7: ( 'ELSEIF' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:55:9: 'ELSEIF'
            {
            match("ELSEIF"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:56:7: ( '@' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:56:9: '@'
            {
            match('@'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:57:7: ( 'instanceof' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:57:9: 'instanceof'
            {
            match("instanceof"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:58:7: ( 'as' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:58:9: 'as'
            {
            match("as"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:59:7: ( '[' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:59:9: '['
            {
            match('['); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:60:7: ( '|' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:60:9: '|'
            {
            match('|'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:61:7: ( ']' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:61:9: ']'
            {
            match(']'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:62:7: ( 'if' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:62:9: 'if'
            {
            match("if"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:63:7: ( 'else' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:63:9: 'else'
            {
            match("else"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:64:7: ( 'switch' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:64:9: 'switch'
            {
            match("switch"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:65:7: ( 'default' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:65:9: 'default'
            {
            match("default"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:66:7: ( 'case' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:66:9: 'case'
            {
            match("case"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:67:7: ( 'for' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:67:9: 'for'
            {
            match("for"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:68:7: ( 'while' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:68:9: 'while'
            {
            match("while"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:69:7: ( 'do' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:69:9: 'do'
            {
            match("do"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:70:7: ( ';' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:70:9: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:71:7: ( '::' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:71:9: '::'
            {
            match("::"); 


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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:72:7: ( 'new' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:72:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:73:7: ( 'null' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:73:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:74:7: ( 'typeof' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:74:9: 'typeof'
            {
            match("typeof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:75:7: ( 'throw' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:75:9: 'throw'
            {
            match("throw"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:76:7: ( 'return' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:76:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:77:7: ( 'try' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:77:9: 'try'
            {
            match("try"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:78:7: ( 'finally' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:78:9: 'finally'
            {
            match("finally"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:79:7: ( 'catch' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:79:9: 'catch'
            {
            match("catch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:80:7: ( '=>' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:80:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:81:7: ( '?' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:81:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:82:7: ( '&' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:82:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:83:7: ( 'static' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:83:9: 'static'
            {
            match("static"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:84:7: ( 'extension' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:84:9: 'extension'
            {
            match("extension"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:85:7: ( 'override' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:85:9: 'override'
            {
            match("override"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:86:7: ( 'dispatch' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:86:9: 'dispatch'
            {
            match("dispatch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:87:7: ( '?.' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:87:9: '?.'
            {
            match("?."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:88:7: ( '*.' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:88:9: '*.'
            {
            match("*."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:89:7: ( 'var' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:89:9: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:90:7: ( 'true' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:90:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "RULE_RICH_TEXT"
    public final void mRULE_RICH_TEXT() throws RecognitionException {
        try {
            int _type = RULE_RICH_TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:16: ( '\\'\\'\\'' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:18: '\\'\\'\\'' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match("'''"); 

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:27: ( RULE_IN_RICH_STRING )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\'') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='\'') ) {
                        int LA1_4 = input.LA(3);

                        if ( ((LA1_4>='\u0000' && LA1_4<='&')||(LA1_4>='(' && LA1_4<='\u00AA')||(LA1_4>='\u00AC' && LA1_4<='\uFFFF')) ) {
                            alt1=1;
                        }


                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='&')||(LA1_1>='(' && LA1_1<='\u00AA')||(LA1_1>='\u00AC' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='&')||(LA1_0>='(' && LA1_0<='\u00AA')||(LA1_0>='\u00AC' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:27: RULE_IN_RICH_STRING
            	    {
            	    mRULE_IN_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:48: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\'') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='\'') ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3=='\'') ) {
                        alt4=1;
                    }
                    else {
                        alt4=2;}
                }
                else {
                    alt4=2;}
            }
            else {
                alt4=2;}
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:49: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:58: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:58: ( '\\'' ( '\\'' )? )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\'') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:59: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:64: ( '\\'' )?
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( (LA2_0=='\'') ) {
                                alt2=1;
                            }
                            switch (alt2) {
                                case 1 :
                                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20588:64: '\\''
                                    {
                                    match('\''); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    match(EOF); 

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
    // $ANTLR end "RULE_RICH_TEXT"

    // $ANTLR start "RULE_RICH_TEXT_START"
    public final void mRULE_RICH_TEXT_START() throws RecognitionException {
        try {
            int _type = RULE_RICH_TEXT_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20590:22: ( '\\'\\'\\'' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20590:24: '\\'\\'\\'' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB'
            {
            match("'''"); 

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20590:33: ( RULE_IN_RICH_STRING )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\'') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='\'') ) {
                        int LA5_4 = input.LA(3);

                        if ( ((LA5_4>='\u0000' && LA5_4<='&')||(LA5_4>='(' && LA5_4<='\u00AA')||(LA5_4>='\u00AC' && LA5_4<='\uFFFF')) ) {
                            alt5=1;
                        }


                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='&')||(LA5_1>='(' && LA5_1<='\u00AA')||(LA5_1>='\u00AC' && LA5_1<='\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='\u00AA')||(LA5_0>='\u00AC' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20590:33: RULE_IN_RICH_STRING
            	    {
            	    mRULE_IN_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20590:54: ( '\\'' ( '\\'' )? )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\'') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20590:55: '\\'' ( '\\'' )?
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20590:60: ( '\\'' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\'') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20590:60: '\\''
                            {
                            match('\''); 

                            }
                            break;

                    }


                    }
                    break;

            }

            match('\u00AB'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RICH_TEXT_START"

    // $ANTLR start "RULE_RICH_TEXT_END"
    public final void mRULE_RICH_TEXT_END() throws RecognitionException {
        try {
            int _type = RULE_RICH_TEXT_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:20: ( '\\u00BB' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:22: '\\u00BB' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match('\u00BB'); 
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:31: ( RULE_IN_RICH_STRING )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\'') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='\'') ) {
                        int LA8_4 = input.LA(3);

                        if ( ((LA8_4>='\u0000' && LA8_4<='&')||(LA8_4>='(' && LA8_4<='\u00AA')||(LA8_4>='\u00AC' && LA8_4<='\uFFFF')) ) {
                            alt8=1;
                        }


                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='&')||(LA8_1>='(' && LA8_1<='\u00AA')||(LA8_1>='\u00AC' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='\u00AA')||(LA8_0>='\u00AC' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:31: RULE_IN_RICH_STRING
            	    {
            	    mRULE_IN_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:52: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\'') ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1=='\'') ) {
                    int LA11_3 = input.LA(3);

                    if ( (LA11_3=='\'') ) {
                        alt11=1;
                    }
                    else {
                        alt11=2;}
                }
                else {
                    alt11=2;}
            }
            else {
                alt11=2;}
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:53: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:62: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:62: ( '\\'' ( '\\'' )? )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\'') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:63: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:68: ( '\\'' )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0=='\'') ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20592:68: '\\''
                                    {
                                    match('\''); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    match(EOF); 

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
    // $ANTLR end "RULE_RICH_TEXT_END"

    // $ANTLR start "RULE_RICH_TEXT_INBETWEEN"
    public final void mRULE_RICH_TEXT_INBETWEEN() throws RecognitionException {
        try {
            int _type = RULE_RICH_TEXT_INBETWEEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20594:26: ( '\\u00BB' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20594:28: '\\u00BB' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB'
            {
            match('\u00BB'); 
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20594:37: ( RULE_IN_RICH_STRING )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\'') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1=='\'') ) {
                        int LA12_4 = input.LA(3);

                        if ( ((LA12_4>='\u0000' && LA12_4<='&')||(LA12_4>='(' && LA12_4<='\u00AA')||(LA12_4>='\u00AC' && LA12_4<='\uFFFF')) ) {
                            alt12=1;
                        }


                    }
                    else if ( ((LA12_1>='\u0000' && LA12_1<='&')||(LA12_1>='(' && LA12_1<='\u00AA')||(LA12_1>='\u00AC' && LA12_1<='\uFFFF')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='\u00AA')||(LA12_0>='\u00AC' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20594:37: RULE_IN_RICH_STRING
            	    {
            	    mRULE_IN_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20594:58: ( '\\'' ( '\\'' )? )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\'') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20594:59: '\\'' ( '\\'' )?
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20594:64: ( '\\'' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\'') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20594:64: '\\''
                            {
                            match('\''); 

                            }
                            break;

                    }


                    }
                    break;

            }

            match('\u00AB'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RICH_TEXT_INBETWEEN"

    // $ANTLR start "RULE_IN_RICH_STRING"
    public final void mRULE_IN_RICH_STRING() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20596:30: ( ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) ) )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20596:32: ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) )
            {
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20596:32: ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\'') ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1=='\'') ) {
                    alt15=1;
                }
                else if ( ((LA15_1>='\u0000' && LA15_1<='&')||(LA15_1>='(' && LA15_1<='\u00AA')||(LA15_1>='\u00AC' && LA15_1<='\uFFFF')) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA15_0>='\u0000' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='\u00AA')||(LA15_0>='\u00AC' && LA15_0<='\uFFFF')) ) {
                alt15=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20596:33: '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) )
                    {
                    match("''"); 

                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\u00AA')||(input.LA(1)>='\u00AC' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20596:59: '\\'' ~ ( ( '\\u00AB' | '\\'' ) )
                    {
                    match('\''); 
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\u00AA')||(input.LA(1)>='\u00AC' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20596:83: ~ ( ( '\\u00AB' | '\\'' ) )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\u00AA')||(input.LA(1)>='\u00AC' && input.LA(1)<='\uFFFF') ) {
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

        }
        finally {
        }
    }
    // $ANTLR end "RULE_IN_RICH_STRING"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20598:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20598:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20598:11: ( '^' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='^') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20598:11: '^'
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

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20598:44: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='$'||(LA17_0>='0' && LA17_0<='9')||(LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:
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
            	    break loop17;
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20600:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20600:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20600:12: ( '0' .. '9' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20600:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\"') ) {
                alt21=1;
            }
            else if ( (LA21_0=='\'') ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop19:
                    do {
                        int alt19=3;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0=='\\') ) {
                            alt19=1;
                        }
                        else if ( ((LA19_0>='\u0000' && LA19_0<='!')||(LA19_0>='#' && LA19_0<='[')||(LA19_0>=']' && LA19_0<='\uFFFF')) ) {
                            alt19=2;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop19;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop20:
                    do {
                        int alt20=3;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='\\') ) {
                            alt20=1;
                        }
                        else if ( ((LA20_0>='\u0000' && LA20_0<='&')||(LA20_0>='(' && LA20_0<='[')||(LA20_0>=']' && LA20_0<='\uFFFF')) ) {
                            alt20=2;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20602:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop20;
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20604:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20604:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20604:24: ( options {greedy=false; } : . )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='*') ) {
                    int LA22_1 = input.LA(2);

                    if ( (LA22_1=='/') ) {
                        alt22=2;
                    }
                    else if ( ((LA22_1>='\u0000' && LA22_1<='.')||(LA22_1>='0' && LA22_1<='\uFFFF')) ) {
                        alt22=1;
                    }


                }
                else if ( ((LA22_0>='\u0000' && LA22_0<=')')||(LA22_0>='+' && LA22_0<='\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20604:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop22;
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20606:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20606:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20606:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='\u0000' && LA23_0<='\t')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='\uFFFF')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20606:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop23;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20606:40: ( ( '\\r' )? '\\n' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='\n'||LA25_0=='\r') ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20606:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20606:41: ( '\\r' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='\r') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20606:41: '\\r'
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20608:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20608:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20608:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>='\t' && LA26_0<='\n')||LA26_0=='\r'||LA26_0==' ') ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:
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
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
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
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20610:16: ( . )
            // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:20610:18: .
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
        // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | RULE_RICH_TEXT | RULE_RICH_TEXT_START | RULE_RICH_TEXT_END | RULE_RICH_TEXT_INBETWEEN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt27=91;
        alt27 = dfa27.predict(input);
        switch (alt27) {
            case 1 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:10: T__16
                {
                mT__16(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:16: T__17
                {
                mT__17(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:22: T__18
                {
                mT__18(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:28: T__19
                {
                mT__19(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:34: T__20
                {
                mT__20(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:40: T__21
                {
                mT__21(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:46: T__22
                {
                mT__22(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:52: T__23
                {
                mT__23(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:58: T__24
                {
                mT__24(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:64: T__25
                {
                mT__25(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:70: T__26
                {
                mT__26(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:76: T__27
                {
                mT__27(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:82: T__28
                {
                mT__28(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:88: T__29
                {
                mT__29(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:94: T__30
                {
                mT__30(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:100: T__31
                {
                mT__31(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:106: T__32
                {
                mT__32(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:112: T__33
                {
                mT__33(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:118: T__34
                {
                mT__34(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:124: T__35
                {
                mT__35(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:130: T__36
                {
                mT__36(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:136: T__37
                {
                mT__37(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:142: T__38
                {
                mT__38(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:148: T__39
                {
                mT__39(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:154: T__40
                {
                mT__40(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:160: T__41
                {
                mT__41(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:166: T__42
                {
                mT__42(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:172: T__43
                {
                mT__43(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:178: T__44
                {
                mT__44(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:184: T__45
                {
                mT__45(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:190: T__46
                {
                mT__46(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:196: T__47
                {
                mT__47(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:202: T__48
                {
                mT__48(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:208: T__49
                {
                mT__49(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:214: T__50
                {
                mT__50(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:220: T__51
                {
                mT__51(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:226: T__52
                {
                mT__52(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:232: T__53
                {
                mT__53(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:238: T__54
                {
                mT__54(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:244: T__55
                {
                mT__55(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:250: T__56
                {
                mT__56(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:256: T__57
                {
                mT__57(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:262: T__58
                {
                mT__58(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:268: T__59
                {
                mT__59(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:274: T__60
                {
                mT__60(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:280: T__61
                {
                mT__61(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:286: T__62
                {
                mT__62(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:292: T__63
                {
                mT__63(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:298: T__64
                {
                mT__64(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:304: T__65
                {
                mT__65(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:310: T__66
                {
                mT__66(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:316: T__67
                {
                mT__67(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:322: T__68
                {
                mT__68(); 

                }
                break;
            case 54 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:328: T__69
                {
                mT__69(); 

                }
                break;
            case 55 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:334: T__70
                {
                mT__70(); 

                }
                break;
            case 56 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:340: T__71
                {
                mT__71(); 

                }
                break;
            case 57 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:346: T__72
                {
                mT__72(); 

                }
                break;
            case 58 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:352: T__73
                {
                mT__73(); 

                }
                break;
            case 59 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:358: T__74
                {
                mT__74(); 

                }
                break;
            case 60 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:364: T__75
                {
                mT__75(); 

                }
                break;
            case 61 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:370: T__76
                {
                mT__76(); 

                }
                break;
            case 62 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:376: T__77
                {
                mT__77(); 

                }
                break;
            case 63 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:382: T__78
                {
                mT__78(); 

                }
                break;
            case 64 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:388: T__79
                {
                mT__79(); 

                }
                break;
            case 65 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:394: T__80
                {
                mT__80(); 

                }
                break;
            case 66 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:400: T__81
                {
                mT__81(); 

                }
                break;
            case 67 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:406: T__82
                {
                mT__82(); 

                }
                break;
            case 68 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:412: T__83
                {
                mT__83(); 

                }
                break;
            case 69 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:418: T__84
                {
                mT__84(); 

                }
                break;
            case 70 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:424: T__85
                {
                mT__85(); 

                }
                break;
            case 71 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:430: T__86
                {
                mT__86(); 

                }
                break;
            case 72 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:436: T__87
                {
                mT__87(); 

                }
                break;
            case 73 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:442: T__88
                {
                mT__88(); 

                }
                break;
            case 74 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:448: T__89
                {
                mT__89(); 

                }
                break;
            case 75 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:454: T__90
                {
                mT__90(); 

                }
                break;
            case 76 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:460: T__91
                {
                mT__91(); 

                }
                break;
            case 77 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:466: T__92
                {
                mT__92(); 

                }
                break;
            case 78 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:472: T__93
                {
                mT__93(); 

                }
                break;
            case 79 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:478: T__94
                {
                mT__94(); 

                }
                break;
            case 80 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:484: T__95
                {
                mT__95(); 

                }
                break;
            case 81 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:490: RULE_RICH_TEXT
                {
                mRULE_RICH_TEXT(); 

                }
                break;
            case 82 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:505: RULE_RICH_TEXT_START
                {
                mRULE_RICH_TEXT_START(); 

                }
                break;
            case 83 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:526: RULE_RICH_TEXT_END
                {
                mRULE_RICH_TEXT_END(); 

                }
                break;
            case 84 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:545: RULE_RICH_TEXT_INBETWEEN
                {
                mRULE_RICH_TEXT_INBETWEEN(); 

                }
                break;
            case 85 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:570: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 86 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:578: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 87 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:587: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 88 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:599: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 89 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:615: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 90 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:631: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 91 :
                // ../org.eclipse.xtext.xtend2.ui/src-gen/org/eclipse/xtext/xtend2/ui/contentassist/antlr/internal/InternalXtend2.g:1:639: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA27_eotS =
        "\1\uffff\1\66\1\70\1\72\1\74\2\100\1\105\1\107\1\111\1\113\1\115"+
        "\1\120\1\123\1\uffff\5\100\3\uffff\1\100\2\uffff\1\150\6\100\1\uffff"+
        "\1\100\2\uffff\1\100\1\uffff\3\100\1\175\1\100\1\63\1\u0083\1\63"+
        "\2\uffff\1\63\13\uffff\1\100\1\u0088\1\100\1\uffff\3\100\21\uffff"+
        "\12\100\1\u0099\3\uffff\2\100\4\uffff\6\100\1\u00a2\1\uffff\1\u00a3"+
        "\2\uffff\1\100\1\uffff\6\100\2\uffff\1\100\1\u0080\1\uffff\2\u0083"+
        "\4\uffff\1\u00b1\1\uffff\5\100\1\u00b7\1\u00b8\4\100\1\u00bd\4\100"+
        "\1\uffff\2\100\1\u00c5\5\100\2\uffff\1\100\1\u00cd\3\100\1\u00d1"+
        "\3\100\1\u00d7\2\u0083\1\100\1\uffff\3\100\1\u00de\1\100\2\uffff"+
        "\4\100\1\uffff\6\100\1\u00ea\1\uffff\2\100\1\u00ee\4\100\1\uffff"+
        "\1\u00f3\2\100\1\uffff\1\u00f6\2\100\2\u00d7\2\uffff\1\u0083\3\100"+
        "\1\u00fe\1\uffff\1\u00ff\1\u0100\2\100\1\u0103\6\100\1\uffff\1\100"+
        "\1\u010c\1\100\1\uffff\2\100\1\u0110\1\u0111\1\uffff\1\100\1\u0113"+
        "\1\uffff\2\100\2\u00d7\2\100\1\u0119\3\uffff\1\u011a\1\u011b\1\uffff"+
        "\2\100\1\u011e\4\100\1\u0123\1\uffff\1\u0124\1\u0125\1\100\2\uffff"+
        "\1\u0127\1\uffff\1\u0128\1\100\1\u00d7\1\u012a\1\100\3\uffff\1\u012c"+
        "\1\u012d\1\uffff\2\100\1\u0130\1\100\3\uffff\1\100\2\uffff\1\100"+
        "\1\uffff\1\u0134\2\uffff\2\100\1\uffff\2\100\1\u0139\1\uffff\2\100"+
        "\1\u013c\1\u013d\1\uffff\1\u013e\1\u013f\4\uffff";
    static final String DFA27_eofS =
        "\u0140\uffff";
    static final String DFA27_minS =
        "\1\0\2\75\1\174\1\46\1\145\1\141\3\75\1\76\1\56\2\52\1\uffff\1\141"+
        "\1\164\2\141\1\146\3\uffff\1\154\2\uffff\1\72\1\117\1\114\2\105"+
        "\2\106\1\uffff\1\163\2\uffff\1\150\1\uffff\1\145\1\150\1\145\1\56"+
        "\1\166\2\0\1\44\2\uffff\1\0\13\uffff\1\146\1\44\1\163\1\uffff\1"+
        "\145\1\141\1\163\21\uffff\1\154\1\160\1\151\1\141\1\154\1\162\1"+
        "\156\1\143\1\160\1\163\1\44\3\uffff\1\164\1\163\4\uffff\1\122\1"+
        "\104\1\123\1\106\1\120\1\124\1\44\1\uffff\1\44\2\uffff\1\151\1\uffff"+
        "\1\167\1\154\1\160\1\162\1\165\1\164\2\uffff\1\145\1\47\1\uffff"+
        "\2\0\4\uffff\1\44\1\uffff\1\160\1\141\1\163\1\145\1\143\2\44\1\145"+
        "\2\164\1\163\1\44\1\141\1\153\1\154\1\164\1\uffff\2\145\1\44\1\106"+
        "\1\105\1\117\1\101\1\105\2\uffff\1\154\1\44\1\154\1\145\1\157\1"+
        "\44\1\145\1\165\1\162\3\0\1\165\1\uffff\1\141\1\164\1\163\1\44\1"+
        "\150\2\uffff\1\162\1\143\1\151\1\145\1\uffff\1\154\1\141\1\162\1"+
        "\145\1\141\1\156\1\44\1\uffff\1\117\1\106\1\44\3\122\1\145\1\uffff"+
        "\1\44\1\157\1\167\1\uffff\1\44\2\162\2\0\2\uffff\1\0\1\154\1\164"+
        "\1\145\1\44\1\uffff\2\44\1\150\1\143\1\44\1\154\1\147\1\164\1\155"+
        "\1\156\1\144\1\uffff\1\122\1\44\1\106\1\uffff\1\105\1\101\2\44\1"+
        "\uffff\1\146\1\44\1\uffff\1\156\1\151\2\0\1\164\1\143\1\44\3\uffff"+
        "\2\44\1\uffff\1\171\1\145\1\44\1\145\1\143\1\163\1\151\1\44\1\uffff"+
        "\2\44\1\124\2\uffff\1\44\1\uffff\1\44\1\144\1\0\1\44\1\150\3\uffff"+
        "\2\44\1\uffff\1\156\1\145\1\44\1\157\3\uffff\1\117\2\uffff\1\145"+
        "\1\uffff\1\44\2\uffff\1\164\1\157\1\uffff\1\156\1\122\1\44\1\uffff"+
        "\1\163\1\146\2\44\1\uffff\2\44\4\uffff";
    static final String DFA27_maxS =
        "\1\uffff\1\76\1\75\1\174\1\46\1\157\1\162\3\75\1\76\2\56\1\57\1"+
        "\uffff\1\141\1\167\1\157\1\141\1\156\3\uffff\1\170\2\uffff\1\72"+
        "\1\117\1\116\2\105\2\106\1\uffff\1\163\2\uffff\1\150\1\uffff\1\165"+
        "\1\171\1\145\1\56\1\166\2\uffff\1\172\2\uffff\1\uffff\13\uffff\1"+
        "\146\1\172\1\163\1\uffff\1\145\1\141\1\164\21\uffff\1\162\1\160"+
        "\1\151\1\141\1\154\1\162\1\156\1\143\1\160\1\163\1\172\3\uffff\1"+
        "\164\1\163\4\uffff\1\122\1\104\1\123\1\106\1\120\1\124\1\172\1\uffff"+
        "\1\172\2\uffff\1\151\1\uffff\1\167\1\154\1\160\1\162\1\171\1\164"+
        "\2\uffff\1\145\1\47\1\uffff\2\uffff\4\uffff\1\172\1\uffff\1\160"+
        "\1\141\1\163\1\145\1\143\2\172\1\145\2\164\1\163\1\172\1\141\1\153"+
        "\1\157\1\164\1\uffff\2\145\1\172\1\111\1\105\1\117\1\101\1\105\2"+
        "\uffff\1\154\1\172\1\154\1\145\1\157\1\172\1\145\1\165\1\162\3\uffff"+
        "\1\165\1\uffff\1\141\1\164\1\163\1\172\1\150\2\uffff\1\162\1\143"+
        "\1\151\1\145\1\uffff\1\154\1\141\1\162\1\145\1\141\1\156\1\172\1"+
        "\uffff\1\117\1\106\1\172\3\122\1\145\1\uffff\1\172\1\157\1\167\1"+
        "\uffff\1\172\2\162\2\uffff\2\uffff\1\uffff\1\154\1\164\1\145\1\172"+
        "\1\uffff\2\172\1\150\1\143\1\172\1\154\1\147\1\164\1\155\1\156\1"+
        "\163\1\uffff\1\122\1\172\1\106\1\uffff\1\105\1\101\2\172\1\uffff"+
        "\1\146\1\172\1\uffff\1\156\1\151\2\uffff\1\164\1\143\1\172\3\uffff"+
        "\2\172\1\uffff\1\171\1\145\1\172\1\145\1\143\1\163\1\151\1\172\1"+
        "\uffff\2\172\1\124\2\uffff\1\172\1\uffff\1\172\1\144\1\uffff\1\172"+
        "\1\150\3\uffff\2\172\1\uffff\1\156\1\145\1\172\1\157\3\uffff\1\117"+
        "\2\uffff\1\145\1\uffff\1\172\2\uffff\1\164\1\157\1\uffff\1\156\1"+
        "\122\1\172\1\uffff\1\163\1\146\2\172\1\uffff\2\172\4\uffff";
    static final String DFA27_acceptS =
        "\16\uffff\1\24\5\uffff\1\35\1\36\1\37\1\uffff\1\42\1\43\7\uffff"+
        "\1\56\1\uffff\1\61\1\63\1\uffff\1\74\10\uffff\1\125\1\126\1\uffff"+
        "\1\132\1\133\1\7\1\106\1\1\1\2\1\17\1\3\1\62\1\4\1\110\3\uffff\1"+
        "\125\3\uffff\1\10\1\25\1\11\1\13\1\12\1\14\1\15\1\20\1\16\1\26\1"+
        "\22\1\116\1\21\1\130\1\131\1\23\1\24\13\uffff\1\35\1\36\1\37\2\uffff"+
        "\1\42\1\43\1\75\1\44\7\uffff\1\56\1\uffff\1\61\1\63\1\uffff\1\74"+
        "\6\uffff\1\115\1\107\2\uffff\1\127\2\uffff\1\123\1\124\1\126\1\132"+
        "\1\uffff\1\73\20\uffff\1\64\10\uffff\1\52\1\60\15\uffff\1\5\5\uffff"+
        "\1\27\1\117\4\uffff\1\71\7\uffff\1\45\7\uffff\1\76\3\uffff\1\103"+
        "\5\uffff\1\121\1\122\5\uffff\1\70\13\uffff\1\65\3\uffff\1\54\4\uffff"+
        "\1\77\2\uffff\1\120\7\uffff\1\34\1\105\1\30\2\uffff\1\31\10\uffff"+
        "\1\53\3\uffff\1\51\1\72\1\uffff\1\101\5\uffff\1\6\1\66\1\111\2\uffff"+
        "\1\33\4\uffff\1\46\1\55\1\47\1\uffff\1\100\1\102\1\uffff\1\67\1"+
        "\uffff\1\104\1\32\2\uffff\1\40\3\uffff\1\114\4\uffff\1\113\2\uffff"+
        "\1\112\1\50\1\41\1\57";
    static final String DFA27_specialS =
        "\1\10\53\uffff\1\12\1\14\3\uffff\1\13\117\uffff\1\6\1\2\52\uffff"+
        "\1\7\1\15\1\1\45\uffff\1\11\1\4\2\uffff\1\3\37\uffff\1\16\1\5\33"+
        "\uffff\1\0\51\uffff}>";
    static final String[] DFA27_transitionS = {
            "\11\63\2\62\2\63\1\62\22\63\1\62\1\7\1\61\1\63\1\57\1\16\1\4"+
            "\1\54\1\30\1\31\1\14\1\2\1\26\1\12\1\13\1\15\12\60\1\32\1\46"+
            "\1\11\1\1\1\10\1\52\1\41\1\37\1\35\2\57\1\34\1\33\2\57\1\40"+
            "\11\57\1\36\7\57\1\43\1\63\1\44\1\56\1\57\1\63\1\42\1\57\1\6"+
            "\1\5\1\27\1\21\2\57\1\23\4\57\1\47\1\53\1\22\1\57\1\51\1\20"+
            "\1\50\1\57\1\17\1\45\3\57\1\24\1\3\1\25\75\63\1\55\uff44\63",
            "\1\64\1\65",
            "\1\67",
            "\1\71",
            "\1\73",
            "\1\75\3\uffff\1\77\5\uffff\1\76",
            "\1\103\12\uffff\1\102\5\uffff\1\101",
            "\1\104",
            "\1\106",
            "\1\110",
            "\1\112",
            "\1\114",
            "\1\116\3\uffff\1\117",
            "\1\121\4\uffff\1\122",
            "",
            "\1\125",
            "\1\130\1\126\1\uffff\1\127",
            "\1\131\7\uffff\1\133\5\uffff\1\132",
            "\1\134",
            "\1\137\6\uffff\1\135\1\136",
            "",
            "",
            "",
            "\1\144\13\uffff\1\143",
            "",
            "",
            "\1\147",
            "\1\151",
            "\1\153\1\uffff\1\152",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "\1\161",
            "",
            "",
            "\1\164",
            "",
            "\1\166\17\uffff\1\167",
            "\1\171\11\uffff\1\172\6\uffff\1\170",
            "\1\173",
            "\1\174",
            "\1\176",
            "\47\u0080\1\177\uffd8\u0080",
            "\47\u0082\1\u0081\u0083\u0082\1\u0084\uff54\u0082",
            "\1\100\34\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "",
            "\0\u0080",
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
            "\1\u0087",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0089",
            "",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c\1\u008d",
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
            "\1\u008e\5\uffff\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "",
            "",
            "\1\u009a",
            "\1\u009b",
            "",
            "",
            "",
            "",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "",
            "\1\u00a4",
            "",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00aa\3\uffff\1\u00a9",
            "\1\u00ab",
            "",
            "",
            "\1\u00ac",
            "\1\u00ad",
            "",
            "\47\u00af\1\u00ae\u0083\u00af\1\u0084\uff54\u00af",
            "\47\u0082\1\u0081\u0083\u0082\1\u0084\uff54\u0082",
            "",
            "",
            "",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\1\u00b0\31\100",
            "",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c1\2\uffff\1\u00c0",
            "\1\u00c2",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00c6\2\uffff\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "",
            "",
            "\1\u00cc",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\47\u00d6\1\u00d5\u0083\u00d6\1\u00d8\uff54\u00d6",
            "\47\u00d9\1\uffff\u0083\u00d9\1\u0084\uff54\u00d9",
            "\47\u0082\1\u0081\u0083\u0082\1\u0084\uff54\u0082",
            "\1\u00da",
            "",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00df",
            "",
            "",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\u00eb",
            "\1\u00ec",
            "\1\100\13\uffff\12\100\7\uffff\10\100\1\u00ed\21\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00f4",
            "\1\u00f5",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00f7",
            "\1\u00f8",
            "\47\u00fa\1\u00f9\u0083\u00fa\1\u00d8\uff54\u00fa",
            "\47\u00d6\1\u00d5\u0083\u00d6\1\u00d8\uff54\u00d6",
            "",
            "",
            "\47\u0082\1\u0081\u0083\u0082\1\u0084\uff54\u0082",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0101",
            "\1\u0102",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109\16\uffff\1\u010a",
            "",
            "\1\u010b",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u010d",
            "",
            "\1\u010e",
            "\1\u010f",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\u0112",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\u0114",
            "\1\u0115",
            "\47\u0116\1\uffff\u0083\u0116\1\u00d8\uff54\u0116",
            "\47\u00d6\1\u00d5\u0083\u00d6\1\u00d8\uff54\u00d6",
            "\1\u0117",
            "\1\u0118",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\u011c",
            "\1\u011d",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0126",
            "",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0129",
            "\47\u00d6\1\u00d5\u0083\u00d6\1\u00d8\uff54\u00d6",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u012b",
            "",
            "",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\u012e",
            "\1\u012f",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0131",
            "",
            "",
            "",
            "\1\u0132",
            "",
            "",
            "\1\u0133",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "",
            "\1\u0135",
            "\1\u0136",
            "",
            "\1\u0137",
            "\1\u0138",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\u013a",
            "\1\u013b",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\13\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | RULE_RICH_TEXT | RULE_RICH_TEXT_START | RULE_RICH_TEXT_END | RULE_RICH_TEXT_INBETWEEN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_278 = input.LA(1);

                        s = -1;
                        if ( (LA27_278=='\'') ) {s = 213;}

                        else if ( (LA27_278=='\u00AB') ) {s = 216;}

                        else if ( ((LA27_278>='\u0000' && LA27_278<='&')||(LA27_278>='(' && LA27_278<='\u00AA')||(LA27_278>='\u00AC' && LA27_278<='\uFFFF')) ) {s = 214;}

                        else s = 215;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_175 = input.LA(1);

                        s = -1;
                        if ( (LA27_175=='\'') ) {s = 129;}

                        else if ( ((LA27_175>='\u0000' && LA27_175<='&')||(LA27_175>='(' && LA27_175<='\u00AA')||(LA27_175>='\u00AC' && LA27_175<='\uFFFF')) ) {s = 130;}

                        else if ( (LA27_175=='\u00AB') ) {s = 132;}

                        else s = 131;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_130 = input.LA(1);

                        s = -1;
                        if ( (LA27_130=='\'') ) {s = 129;}

                        else if ( ((LA27_130>='\u0000' && LA27_130<='&')||(LA27_130>='(' && LA27_130<='\u00AA')||(LA27_130>='\u00AC' && LA27_130<='\uFFFF')) ) {s = 130;}

                        else if ( (LA27_130=='\u00AB') ) {s = 132;}

                        else s = 131;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_217 = input.LA(1);

                        s = -1;
                        if ( (LA27_217=='\'') ) {s = 129;}

                        else if ( ((LA27_217>='\u0000' && LA27_217<='&')||(LA27_217>='(' && LA27_217<='\u00AA')||(LA27_217>='\u00AC' && LA27_217<='\uFFFF')) ) {s = 130;}

                        else if ( (LA27_217=='\u00AB') ) {s = 132;}

                        else s = 131;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA27_214 = input.LA(1);

                        s = -1;
                        if ( (LA27_214=='\'') ) {s = 213;}

                        else if ( ((LA27_214>='\u0000' && LA27_214<='&')||(LA27_214>='(' && LA27_214<='\u00AA')||(LA27_214>='\u00AC' && LA27_214<='\uFFFF')) ) {s = 214;}

                        else if ( (LA27_214=='\u00AB') ) {s = 216;}

                        else s = 215;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA27_250 = input.LA(1);

                        s = -1;
                        if ( (LA27_250=='\'') ) {s = 213;}

                        else if ( (LA27_250=='\u00AB') ) {s = 216;}

                        else if ( ((LA27_250>='\u0000' && LA27_250<='&')||(LA27_250>='(' && LA27_250<='\u00AA')||(LA27_250>='\u00AC' && LA27_250<='\uFFFF')) ) {s = 214;}

                        else s = 215;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA27_129 = input.LA(1);

                        s = -1;
                        if ( (LA27_129=='\'') ) {s = 174;}

                        else if ( ((LA27_129>='\u0000' && LA27_129<='&')||(LA27_129>='(' && LA27_129<='\u00AA')||(LA27_129>='\u00AC' && LA27_129<='\uFFFF')) ) {s = 175;}

                        else if ( (LA27_129=='\u00AB') ) {s = 132;}

                        else s = 131;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA27_173 = input.LA(1);

                        s = -1;
                        if ( (LA27_173=='\'') ) {s = 213;}

                        else if ( ((LA27_173>='\u0000' && LA27_173<='&')||(LA27_173>='(' && LA27_173<='\u00AA')||(LA27_173>='\u00AC' && LA27_173<='\uFFFF')) ) {s = 214;}

                        else if ( (LA27_173=='\u00AB') ) {s = 216;}

                        else s = 215;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA27_0 = input.LA(1);

                        s = -1;
                        if ( (LA27_0=='=') ) {s = 1;}

                        else if ( (LA27_0=='+') ) {s = 2;}

                        else if ( (LA27_0=='|') ) {s = 3;}

                        else if ( (LA27_0=='&') ) {s = 4;}

                        else if ( (LA27_0=='d') ) {s = 5;}

                        else if ( (LA27_0=='c') ) {s = 6;}

                        else if ( (LA27_0=='!') ) {s = 7;}

                        else if ( (LA27_0=='>') ) {s = 8;}

                        else if ( (LA27_0=='<') ) {s = 9;}

                        else if ( (LA27_0=='-') ) {s = 10;}

                        else if ( (LA27_0=='.') ) {s = 11;}

                        else if ( (LA27_0=='*') ) {s = 12;}

                        else if ( (LA27_0=='/') ) {s = 13;}

                        else if ( (LA27_0=='%') ) {s = 14;}

                        else if ( (LA27_0=='v') ) {s = 15;}

                        else if ( (LA27_0=='s') ) {s = 16;}

                        else if ( (LA27_0=='f') ) {s = 17;}

                        else if ( (LA27_0=='p') ) {s = 18;}

                        else if ( (LA27_0=='i') ) {s = 19;}

                        else if ( (LA27_0=='{') ) {s = 20;}

                        else if ( (LA27_0=='}') ) {s = 21;}

                        else if ( (LA27_0==',') ) {s = 22;}

                        else if ( (LA27_0=='e') ) {s = 23;}

                        else if ( (LA27_0=='(') ) {s = 24;}

                        else if ( (LA27_0==')') ) {s = 25;}

                        else if ( (LA27_0==':') ) {s = 26;}

                        else if ( (LA27_0=='F') ) {s = 27;}

                        else if ( (LA27_0=='E') ) {s = 28;}

                        else if ( (LA27_0=='B') ) {s = 29;}

                        else if ( (LA27_0=='S') ) {s = 30;}

                        else if ( (LA27_0=='A') ) {s = 31;}

                        else if ( (LA27_0=='I') ) {s = 32;}

                        else if ( (LA27_0=='@') ) {s = 33;}

                        else if ( (LA27_0=='a') ) {s = 34;}

                        else if ( (LA27_0=='[') ) {s = 35;}

                        else if ( (LA27_0==']') ) {s = 36;}

                        else if ( (LA27_0=='w') ) {s = 37;}

                        else if ( (LA27_0==';') ) {s = 38;}

                        else if ( (LA27_0=='n') ) {s = 39;}

                        else if ( (LA27_0=='t') ) {s = 40;}

                        else if ( (LA27_0=='r') ) {s = 41;}

                        else if ( (LA27_0=='?') ) {s = 42;}

                        else if ( (LA27_0=='o') ) {s = 43;}

                        else if ( (LA27_0=='\'') ) {s = 44;}

                        else if ( (LA27_0=='\u00BB') ) {s = 45;}

                        else if ( (LA27_0=='^') ) {s = 46;}

                        else if ( (LA27_0=='$'||(LA27_0>='C' && LA27_0<='D')||(LA27_0>='G' && LA27_0<='H')||(LA27_0>='J' && LA27_0<='R')||(LA27_0>='T' && LA27_0<='Z')||LA27_0=='_'||LA27_0=='b'||(LA27_0>='g' && LA27_0<='h')||(LA27_0>='j' && LA27_0<='m')||LA27_0=='q'||LA27_0=='u'||(LA27_0>='x' && LA27_0<='z')) ) {s = 47;}

                        else if ( ((LA27_0>='0' && LA27_0<='9')) ) {s = 48;}

                        else if ( (LA27_0=='\"') ) {s = 49;}

                        else if ( ((LA27_0>='\t' && LA27_0<='\n')||LA27_0=='\r'||LA27_0==' ') ) {s = 50;}

                        else if ( ((LA27_0>='\u0000' && LA27_0<='\b')||(LA27_0>='\u000B' && LA27_0<='\f')||(LA27_0>='\u000E' && LA27_0<='\u001F')||LA27_0=='#'||LA27_0=='\\'||LA27_0=='`'||(LA27_0>='~' && LA27_0<='\u00BA')||(LA27_0>='\u00BC' && LA27_0<='\uFFFF')) ) {s = 51;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA27_213 = input.LA(1);

                        s = -1;
                        if ( (LA27_213=='\'') ) {s = 249;}

                        else if ( ((LA27_213>='\u0000' && LA27_213<='&')||(LA27_213>='(' && LA27_213<='\u00AA')||(LA27_213>='\u00AC' && LA27_213<='\uFFFF')) ) {s = 250;}

                        else if ( (LA27_213=='\u00AB') ) {s = 216;}

                        else s = 215;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA27_44 = input.LA(1);

                        s = -1;
                        if ( (LA27_44=='\'') ) {s = 127;}

                        else if ( ((LA27_44>='\u0000' && LA27_44<='&')||(LA27_44>='(' && LA27_44<='\uFFFF')) ) {s = 128;}

                        else s = 51;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA27_49 = input.LA(1);

                        s = -1;
                        if ( ((LA27_49>='\u0000' && LA27_49<='\uFFFF')) ) {s = 128;}

                        else s = 51;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA27_45 = input.LA(1);

                        s = -1;
                        if ( (LA27_45=='\'') ) {s = 129;}

                        else if ( ((LA27_45>='\u0000' && LA27_45<='&')||(LA27_45>='(' && LA27_45<='\u00AA')||(LA27_45>='\u00AC' && LA27_45<='\uFFFF')) ) {s = 130;}

                        else if ( (LA27_45=='\u00AB') ) {s = 132;}

                        else s = 131;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA27_174 = input.LA(1);

                        s = -1;
                        if ( ((LA27_174>='\u0000' && LA27_174<='&')||(LA27_174>='(' && LA27_174<='\u00AA')||(LA27_174>='\u00AC' && LA27_174<='\uFFFF')) ) {s = 217;}

                        else if ( (LA27_174=='\u00AB') ) {s = 132;}

                        else s = 131;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA27_249 = input.LA(1);

                        s = -1;
                        if ( ((LA27_249>='\u0000' && LA27_249<='&')||(LA27_249>='(' && LA27_249<='\u00AA')||(LA27_249>='\u00AC' && LA27_249<='\uFFFF')) ) {s = 278;}

                        else if ( (LA27_249=='\u00AB') ) {s = 216;}

                        else s = 215;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}