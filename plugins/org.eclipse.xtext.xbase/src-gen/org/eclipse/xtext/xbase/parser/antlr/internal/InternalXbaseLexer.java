package org.eclipse.xtext.xbase.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXbaseLexer extends Lexer {
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=6;
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
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=4;
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
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=5;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__70=70;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators

    public InternalXbaseLexer() {;} 
    public InternalXbaseLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalXbaseLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:11:7: ( '=' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:11:9: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:12:7: ( '+=' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:12:9: '+='
            {
            match("+="); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:13:7: ( '||' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:13:9: '||'
            {
            match("||"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:14:7: ( '&&' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:14:9: '&&'
            {
            match("&&"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:15:7: ( '==' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:15:9: '=='
            {
            match("=="); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:16:7: ( '!=' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:16:9: '!='
            {
            match("!="); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:17:7: ( 'instanceof' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:17:9: 'instanceof'
            {
            match("instanceof"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:18:7: ( '>=' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:18:9: '>='
            {
            match(">="); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:19:7: ( '<=' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:19:9: '<='
            {
            match("<="); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:20:7: ( '>' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:20:9: '>'
            {
            match('>'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:21:7: ( '<' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:21:9: '<'
            {
            match('<'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:22:7: ( '->' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:22:9: '->'
            {
            match("->"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:23:7: ( '..' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:23:9: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:24:7: ( '+' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:24:9: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:25:7: ( '-' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:25:9: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:26:7: ( '*' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:26:9: '*'
            {
            match('*'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:27:7: ( '**' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:27:9: '**'
            {
            match("**"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:28:7: ( '/' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:28:9: '/'
            {
            match('/'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:29:7: ( '%' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:29:9: '%'
            {
            match('%'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:30:7: ( '!' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:30:9: '!'
            {
            match('!'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:31:7: ( 'as' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:31:9: 'as'
            {
            match("as"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:32:7: ( '.' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:32:9: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:33:7: ( '?.' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:33:9: '?.'
            {
            match("?."); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:34:7: ( '*.' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:34:9: '*.'
            {
            match("*."); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:35:7: ( ',' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:35:9: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:36:7: ( '(' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:36:9: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:37:7: ( ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:37:9: ')'
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:38:7: ( '[' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:38:9: '['
            {
            match('['); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:39:7: ( '|' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:39:9: '|'
            {
            match('|'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:40:7: ( ']' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:40:9: ']'
            {
            match(']'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:41:7: ( 'if' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:41:9: 'if'
            {
            match("if"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:42:7: ( 'else' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:42:9: 'else'
            {
            match("else"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:43:7: ( 'switch' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:43:9: 'switch'
            {
            match("switch"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:44:7: ( ':' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:44:9: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:45:7: ( '{' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:45:9: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:46:7: ( 'default' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:46:9: 'default'
            {
            match("default"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:47:7: ( '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:47:9: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:48:7: ( 'case' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:48:9: 'case'
            {
            match("case"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:49:7: ( 'for' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:49:9: 'for'
            {
            match("for"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:50:7: ( 'while' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:50:9: 'while'
            {
            match("while"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:51:7: ( 'do' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:51:9: 'do'
            {
            match("do"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:52:7: ( ';' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:52:9: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:53:7: ( 'var' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:53:9: 'var'
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:54:7: ( 'val' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:54:9: 'val'
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:55:7: ( 'super' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:55:9: 'super'
            {
            match("super"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:56:7: ( '::' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:56:9: '::'
            {
            match("::"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:57:7: ( 'new' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:57:9: 'new'
            {
            match("new"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:58:7: ( 'false' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:58:9: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:59:7: ( 'true' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:59:9: 'true'
            {
            match("true"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:60:7: ( 'null' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:60:9: 'null'
            {
            match("null"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:61:7: ( 'typeof' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:61:9: 'typeof'
            {
            match("typeof"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:62:7: ( 'throw' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:62:9: 'throw'
            {
            match("throw"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:63:7: ( 'return' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:63:9: 'return'
            {
            match("return"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:64:7: ( 'try' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:64:9: 'try'
            {
            match("try"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:65:7: ( 'finally' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:65:9: 'finally'
            {
            match("finally"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:66:7: ( 'catch' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:66:9: 'catch'
            {
            match("catch"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:67:7: ( '=>' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:67:9: '=>'
            {
            match("=>"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:68:7: ( '?' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:68:9: '?'
            {
            match('?'); 

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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:69:7: ( 'extends' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:69:9: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:70:7: ( '&' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:70:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4356:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4356:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4356:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4356:11: '^'
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4356:44: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='$'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4358:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4358:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4358:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4358:13: '0' .. '9'
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:66: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4360:137: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4362:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4362:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4362:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4362:52: .
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4364:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4364:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4364:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4364:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4364:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4364:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4364:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4364:41: '\\r'
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4366:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4366:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4366:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4368:16: ( . )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4368:18: .
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
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=67;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:16: T__12
                {
                mT__12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:22: T__13
                {
                mT__13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:28: T__14
                {
                mT__14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:34: T__15
                {
                mT__15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:40: T__16
                {
                mT__16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:46: T__17
                {
                mT__17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:52: T__18
                {
                mT__18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:58: T__19
                {
                mT__19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:64: T__20
                {
                mT__20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:70: T__21
                {
                mT__21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:76: T__22
                {
                mT__22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:82: T__23
                {
                mT__23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:88: T__24
                {
                mT__24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:94: T__25
                {
                mT__25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:100: T__26
                {
                mT__26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:106: T__27
                {
                mT__27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:112: T__28
                {
                mT__28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:118: T__29
                {
                mT__29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:124: T__30
                {
                mT__30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:130: T__31
                {
                mT__31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:136: T__32
                {
                mT__32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:142: T__33
                {
                mT__33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:148: T__34
                {
                mT__34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:154: T__35
                {
                mT__35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:160: T__36
                {
                mT__36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:166: T__37
                {
                mT__37(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:172: T__38
                {
                mT__38(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:178: T__39
                {
                mT__39(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:184: T__40
                {
                mT__40(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:190: T__41
                {
                mT__41(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:196: T__42
                {
                mT__42(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:202: T__43
                {
                mT__43(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:208: T__44
                {
                mT__44(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:214: T__45
                {
                mT__45(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:220: T__46
                {
                mT__46(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:226: T__47
                {
                mT__47(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:232: T__48
                {
                mT__48(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:238: T__49
                {
                mT__49(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:244: T__50
                {
                mT__50(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:250: T__51
                {
                mT__51(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:256: T__52
                {
                mT__52(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:262: T__53
                {
                mT__53(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:268: T__54
                {
                mT__54(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:274: T__55
                {
                mT__55(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:280: T__56
                {
                mT__56(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:286: T__57
                {
                mT__57(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:292: T__58
                {
                mT__58(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:298: T__59
                {
                mT__59(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:304: T__60
                {
                mT__60(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:310: T__61
                {
                mT__61(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:316: T__62
                {
                mT__62(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:322: T__63
                {
                mT__63(); 

                }
                break;
            case 54 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:328: T__64
                {
                mT__64(); 

                }
                break;
            case 55 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:334: T__65
                {
                mT__65(); 

                }
                break;
            case 56 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:340: T__66
                {
                mT__66(); 

                }
                break;
            case 57 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:346: T__67
                {
                mT__67(); 

                }
                break;
            case 58 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:352: T__68
                {
                mT__68(); 

                }
                break;
            case 59 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:358: T__69
                {
                mT__69(); 

                }
                break;
            case 60 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:364: T__70
                {
                mT__70(); 

                }
                break;
            case 61 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:370: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 62 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:378: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 63 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:387: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 64 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:399: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 65 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:415: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 66 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:431: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 67 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1:439: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\54\1\56\1\60\1\62\1\64\1\67\1\71\1\73\1\75\1\77\1\102"+
        "\1\105\1\uffff\1\67\1\111\5\uffff\2\67\1\124\1\uffff\1\67\1\uffff"+
        "\3\67\1\uffff\4\67\1\51\2\uffff\2\51\15\uffff\1\67\1\152\20\uffff"+
        "\1\153\7\uffff\4\67\3\uffff\1\67\1\161\1\uffff\5\67\1\uffff\7\67"+
        "\3\uffff\1\67\2\uffff\5\67\1\uffff\2\67\1\u0089\3\67\1\u008d\1\u008e"+
        "\1\u008f\2\67\1\u0092\4\67\1\u0097\4\67\1\u009c\1\67\1\uffff\3\67"+
        "\3\uffff\1\u00a1\1\u00a2\1\uffff\4\67\1\uffff\2\67\1\u00a9\1\67"+
        "\1\uffff\1\u00ab\1\u00ac\1\67\1\u00ae\2\uffff\1\67\1\u00b0\3\67"+
        "\1\u00b4\1\uffff\1\67\2\uffff\1\67\1\uffff\1\u00b7\1\uffff\1\u00b8"+
        "\1\67\1\u00ba\1\uffff\1\u00bb\1\u00bc\2\uffff\1\67\3\uffff\1\67"+
        "\1\u00bf\1\uffff";
    static final String DFA12_eofS =
        "\u00c0\uffff";
    static final String DFA12_minS =
        "\1\0\2\75\1\174\1\46\1\75\1\146\2\75\1\76\1\56\2\52\1\uffff\1\163"+
        "\1\56\5\uffff\1\154\1\165\1\72\1\uffff\1\145\1\uffff\2\141\1\150"+
        "\1\uffff\1\141\1\145\1\150\1\145\1\44\2\uffff\2\0\15\uffff\1\163"+
        "\1\44\20\uffff\1\44\7\uffff\1\163\1\164\1\151\1\160\3\uffff\1\146"+
        "\1\44\1\uffff\1\163\1\162\1\154\1\156\1\151\1\uffff\1\154\1\167"+
        "\1\154\1\165\1\160\1\162\1\164\3\uffff\1\164\2\uffff\2\145\1\164"+
        "\1\145\1\141\1\uffff\1\145\1\143\1\44\1\163\1\141\1\154\3\44\1\154"+
        "\1\145\1\44\1\145\1\157\1\165\1\141\1\44\1\156\1\143\1\162\1\165"+
        "\1\44\1\150\1\uffff\1\145\1\154\1\145\3\uffff\2\44\1\uffff\1\157"+
        "\1\167\1\162\1\156\1\uffff\1\144\1\150\1\44\1\154\1\uffff\2\44\1"+
        "\154\1\44\2\uffff\1\146\1\44\1\156\1\143\1\163\1\44\1\uffff\1\164"+
        "\2\uffff\1\171\1\uffff\1\44\1\uffff\1\44\1\145\1\44\1\uffff\2\44"+
        "\2\uffff\1\157\3\uffff\1\146\1\44\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\76\1\75\1\174\1\46\1\75\1\156\2\75\1\76\2\56\1\57\1\uffff"+
        "\1\163\1\56\5\uffff\1\170\1\167\1\72\1\uffff\1\157\1\uffff\1\141"+
        "\1\157\1\150\1\uffff\1\141\1\165\1\171\1\145\1\172\2\uffff\2\uffff"+
        "\15\uffff\1\163\1\172\20\uffff\1\172\7\uffff\1\163\1\164\1\151\1"+
        "\160\3\uffff\1\146\1\172\1\uffff\1\164\1\162\1\154\1\156\1\151\1"+
        "\uffff\1\162\1\167\1\154\1\171\1\160\1\162\1\164\3\uffff\1\164\2"+
        "\uffff\2\145\1\164\1\145\1\141\1\uffff\1\145\1\143\1\172\1\163\1"+
        "\141\1\154\3\172\1\154\1\145\1\172\1\145\1\157\1\165\1\141\1\172"+
        "\1\156\1\143\1\162\1\165\1\172\1\150\1\uffff\1\145\1\154\1\145\3"+
        "\uffff\2\172\1\uffff\1\157\1\167\1\162\1\156\1\uffff\1\144\1\150"+
        "\1\172\1\154\1\uffff\2\172\1\154\1\172\2\uffff\1\146\1\172\1\156"+
        "\1\143\1\163\1\172\1\uffff\1\164\2\uffff\1\171\1\uffff\1\172\1\uffff"+
        "\1\172\1\145\1\172\1\uffff\2\172\2\uffff\1\157\3\uffff\1\146\1\172"+
        "\1\uffff";
    static final String DFA12_acceptS =
        "\15\uffff\1\23\2\uffff\1\31\1\32\1\33\1\34\1\36\3\uffff\1\43\1\uffff"+
        "\1\45\3\uffff\1\52\5\uffff\1\75\1\76\2\uffff\1\102\1\103\1\5\1\71"+
        "\1\1\1\2\1\16\1\3\1\35\1\4\1\74\1\6\1\24\2\uffff\1\75\1\10\1\12"+
        "\1\11\1\13\1\14\1\17\1\15\1\26\1\21\1\30\1\20\1\100\1\101\1\22\1"+
        "\23\1\uffff\1\27\1\72\1\31\1\32\1\33\1\34\1\36\4\uffff\1\56\1\42"+
        "\1\43\2\uffff\1\45\5\uffff\1\52\7\uffff\1\76\1\77\1\102\1\uffff"+
        "\1\37\1\25\5\uffff\1\51\27\uffff\1\47\3\uffff\1\53\1\54\1\57\2\uffff"+
        "\1\66\4\uffff\1\40\4\uffff\1\46\4\uffff\1\62\1\61\6\uffff\1\55\1"+
        "\uffff\1\70\1\60\1\uffff\1\50\1\uffff\1\64\3\uffff\1\41\2\uffff"+
        "\1\63\1\65\1\uffff\1\73\1\44\1\67\2\uffff\1\7";
    static final String DFA12_specialS =
        "\1\1\45\uffff\1\0\1\2\u0098\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\51\2\50\2\51\1\50\22\51\1\50\1\5\1\46\1\51\1\44\1\15\1\4"+
            "\1\47\1\21\1\22\1\13\1\2\1\20\1\11\1\12\1\14\12\45\1\27\1\36"+
            "\1\10\1\1\1\7\1\17\1\51\32\44\1\23\1\51\1\24\1\43\1\44\1\51"+
            "\1\16\1\44\1\33\1\31\1\25\1\34\2\44\1\6\4\44\1\40\3\44\1\42"+
            "\1\26\1\41\1\44\1\37\1\35\3\44\1\30\1\3\1\32\uff82\51",
            "\1\52\1\53",
            "\1\55",
            "\1\57",
            "\1\61",
            "\1\63",
            "\1\66\7\uffff\1\65",
            "\1\70",
            "\1\72",
            "\1\74",
            "\1\76",
            "\1\100\3\uffff\1\101",
            "\1\103\4\uffff\1\104",
            "",
            "\1\107",
            "\1\110",
            "",
            "",
            "",
            "",
            "",
            "\1\117\13\uffff\1\120",
            "\1\122\1\uffff\1\121",
            "\1\123",
            "",
            "\1\126\11\uffff\1\127",
            "",
            "\1\131",
            "\1\133\7\uffff\1\134\5\uffff\1\132",
            "\1\135",
            "",
            "\1\137",
            "\1\140\17\uffff\1\141",
            "\1\144\11\uffff\1\142\6\uffff\1\143",
            "\1\145",
            "\1\67\34\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\0\147",
            "\0\147",
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
            "\1\151",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
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
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "",
            "",
            "\1\160",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "",
            "\1\162\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "\1\171\5\uffff\1\170",
            "\1\172",
            "\1\173",
            "\1\174\3\uffff\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "",
            "",
            "",
            "\1\u0081",
            "",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "",
            "\1\u0087",
            "\1\u0088",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\u0090",
            "\1\u0091",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\u009d",
            "",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "",
            "",
            "",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\1\u00a7",
            "\1\u00a8",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\u00aa",
            "",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\u00ad",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "",
            "",
            "\1\u00af",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "",
            "\1\u00b5",
            "",
            "",
            "\1\u00b6",
            "",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\u00b9",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "",
            "",
            "\1\u00bd",
            "",
            "",
            "",
            "\1\u00be",
            "\1\67\13\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32"+
            "\67",
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

    class DFA12 extends DFA {

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
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_38 = input.LA(1);

                        s = -1;
                        if ( ((LA12_38>='\u0000' && LA12_38<='\uFFFF')) ) {s = 103;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='=') ) {s = 1;}

                        else if ( (LA12_0=='+') ) {s = 2;}

                        else if ( (LA12_0=='|') ) {s = 3;}

                        else if ( (LA12_0=='&') ) {s = 4;}

                        else if ( (LA12_0=='!') ) {s = 5;}

                        else if ( (LA12_0=='i') ) {s = 6;}

                        else if ( (LA12_0=='>') ) {s = 7;}

                        else if ( (LA12_0=='<') ) {s = 8;}

                        else if ( (LA12_0=='-') ) {s = 9;}

                        else if ( (LA12_0=='.') ) {s = 10;}

                        else if ( (LA12_0=='*') ) {s = 11;}

                        else if ( (LA12_0=='/') ) {s = 12;}

                        else if ( (LA12_0=='%') ) {s = 13;}

                        else if ( (LA12_0=='a') ) {s = 14;}

                        else if ( (LA12_0=='?') ) {s = 15;}

                        else if ( (LA12_0==',') ) {s = 16;}

                        else if ( (LA12_0=='(') ) {s = 17;}

                        else if ( (LA12_0==')') ) {s = 18;}

                        else if ( (LA12_0=='[') ) {s = 19;}

                        else if ( (LA12_0==']') ) {s = 20;}

                        else if ( (LA12_0=='e') ) {s = 21;}

                        else if ( (LA12_0=='s') ) {s = 22;}

                        else if ( (LA12_0==':') ) {s = 23;}

                        else if ( (LA12_0=='{') ) {s = 24;}

                        else if ( (LA12_0=='d') ) {s = 25;}

                        else if ( (LA12_0=='}') ) {s = 26;}

                        else if ( (LA12_0=='c') ) {s = 27;}

                        else if ( (LA12_0=='f') ) {s = 28;}

                        else if ( (LA12_0=='w') ) {s = 29;}

                        else if ( (LA12_0==';') ) {s = 30;}

                        else if ( (LA12_0=='v') ) {s = 31;}

                        else if ( (LA12_0=='n') ) {s = 32;}

                        else if ( (LA12_0=='t') ) {s = 33;}

                        else if ( (LA12_0=='r') ) {s = 34;}

                        else if ( (LA12_0=='^') ) {s = 35;}

                        else if ( (LA12_0=='$'||(LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='m')||(LA12_0>='o' && LA12_0<='q')||LA12_0=='u'||(LA12_0>='x' && LA12_0<='z')) ) {s = 36;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 37;}

                        else if ( (LA12_0=='\"') ) {s = 38;}

                        else if ( (LA12_0=='\'') ) {s = 39;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 40;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='#'||LA12_0=='@'||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_39 = input.LA(1);

                        s = -1;
                        if ( ((LA12_39>='\u0000' && LA12_39<='\uFFFF')) ) {s = 103;}

                        else s = 41;

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