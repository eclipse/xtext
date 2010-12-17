package org.eclipse.xtext.xtend2.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtend2Lexer extends Lexer {
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int T__69=69;
    public static final int RULE_STRING=5;
    public static final int T__73=73;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__65=65;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__67=67;
    public static final int T__74=74;
    public static final int T__39=39;
    public static final int RULE_RICH_TEXT_START=7;
    public static final int RULE_RICH_TEXT=6;
    public static final int T__30=30;
    public static final int RULE_RICH_TEXT_INBETWEEN=8;
    public static final int T__46=46;
    public static final int T__52=52;
    public static final int T__68=68;
    public static final int T__17=17;
    public static final int T__62=62;
    public static final int RULE_INT=10;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int T__61=61;
    public static final int T__59=59;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_IN_DOUBLE_QUOTE_RICH_STRING=11;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__78=78;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__58=58;
    public static final int T__79=79;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__77=77;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int T__29=29;
    public static final int T__63=63;
    public static final int RULE_WS=14;
    public static final int T__43=43;
    public static final int T__75=75;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int RULE_RICH_TEXT_END=9;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int T__76=76;
    public static final int T__26=26;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__18=18;
    public static final int T__71=71;

    // delegates
    // delegators

    public InternalXtend2Lexer() {;} 
    public InternalXtend2Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalXtend2Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:11:7: ( 'package' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:11:9: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:12:7: ( 'import' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:12:9: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:13:7: ( '.' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:13:9: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:14:7: ( '*' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:14:9: '*'
            {
            match('*'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:15:7: ( '<' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:15:9: '<'
            {
            match('<'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:16:7: ( ',' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:16:9: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:17:7: ( '>' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:17:9: '>'
            {
            match('>'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:18:7: ( 'class' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:18:9: 'class'
            {
            match("class"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:19:7: ( 'extends' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:19:9: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:20:7: ( 'implements' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:20:9: 'implements'
            {
            match("implements"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:21:7: ( '{' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:21:9: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:22:7: ( '}' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:22:9: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:23:7: ( '(' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:23:9: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:24:7: ( ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:24:9: ')'
            {
            match(')'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:25:7: ( ';' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:25:9: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:26:7: ( 'FOR' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:26:9: 'FOR'
            {
            match("FOR"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:27:7: ( ':' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:27:9: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:28:7: ( 'ENDFOR' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:28:9: 'ENDFOR'
            {
            match("ENDFOR"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:29:7: ( 'IF' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:29:9: 'IF'
            {
            match("IF"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:30:7: ( 'ELSE' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:30:9: 'ELSE'
            {
            match("ELSE"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:31:7: ( 'ENDIF' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:31:9: 'ENDIF'
            {
            match("ENDIF"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:32:7: ( 'ELSEIF' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:32:9: 'ELSEIF'
            {
            match("ELSEIF"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:33:7: ( '=' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:33:9: '='
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:34:7: ( '+=' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:34:9: '+='
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:35:7: ( '||' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:35:9: '||'
            {
            match("||"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:36:7: ( '&&' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:36:9: '&&'
            {
            match("&&"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:37:7: ( '==' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:37:9: '=='
            {
            match("=="); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:38:7: ( '!=' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:38:9: '!='
            {
            match("!="); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:39:7: ( 'instanceof' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:39:9: 'instanceof'
            {
            match("instanceof"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:40:7: ( '>=' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:40:9: '>='
            {
            match(">="); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:41:7: ( '<=' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:41:9: '<='
            {
            match("<="); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:42:7: ( '->' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:42:9: '->'
            {
            match("->"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:43:7: ( '..' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:43:9: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:44:7: ( '+' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:44:9: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:45:7: ( '-' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:45:9: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:46:7: ( '**' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:46:9: '**'
            {
            match("**"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:47:7: ( '/' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:47:9: '/'
            {
            match('/'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:48:7: ( '%' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:48:9: '%'
            {
            match('%'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:49:7: ( '!' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:49:9: '!'
            {
            match('!'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:50:7: ( '?.' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:50:9: '?.'
            {
            match("?."); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:51:7: ( '*.' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:51:9: '*.'
            {
            match("*."); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:52:7: ( '|' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:52:9: '|'
            {
            match('|'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:53:7: ( 'if' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:53:9: 'if'
            {
            match("if"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:54:7: ( 'else' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:54:9: 'else'
            {
            match("else"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:55:7: ( 'switch' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:55:9: 'switch'
            {
            match("switch"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:56:7: ( 'default' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:56:9: 'default'
            {
            match("default"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:57:7: ( 'case' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:57:9: 'case'
            {
            match("case"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:58:7: ( 'for' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:58:9: 'for'
            {
            match("for"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:59:7: ( 'while' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:59:9: 'while'
            {
            match("while"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:60:7: ( 'do' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:60:9: 'do'
            {
            match("do"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:61:7: ( 'var' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:61:9: 'var'
            {
            match("var"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:62:7: ( 'val' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:62:9: 'val'
            {
            match("val"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:63:7: ( 'new' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:63:9: 'new'
            {
            match("new"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:64:7: ( 'false' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:64:9: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:65:7: ( 'true' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:65:9: 'true'
            {
            match("true"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:66:7: ( 'null' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:66:9: 'null'
            {
            match("null"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:67:7: ( 'throw' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:67:9: 'throw'
            {
            match("throw"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:68:7: ( 'try' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:68:9: 'try'
            {
            match("try"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:69:7: ( 'finally' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:69:9: 'finally'
            {
            match("finally"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:70:7: ( 'catch' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:70:9: 'catch'
            {
            match("catch"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:71:7: ( '=>' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:71:9: '=>'
            {
            match("=>"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:72:7: ( '?' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:72:9: '?'
            {
            match('?'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:73:7: ( '&' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:73:9: '&'
            {
            match('&'); 

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:74:7: ( 'super' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:74:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "RULE_RICH_TEXT"
    public final void mRULE_RICH_TEXT() throws RecognitionException {
        try {
            int _type = RULE_RICH_TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5522:16: ( '\\'\\'\\'' ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )* '\\'\\'\\'' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5522:18: '\\'\\'\\'' ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )* '\\'\\'\\''
            {
            match("'''"); 

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5522:27: ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\'') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='\'') ) {
                        int LA1_3 = input.LA(3);

                        if ( ((LA1_3>='\u0000' && LA1_3<='&')||(LA1_3>='(' && LA1_3<='\uFFFF')) ) {
                            alt1=1;
                        }


                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='&')||(LA1_1>='(' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='&')||(LA1_0>='(' && LA1_0<='\u00AA')||(LA1_0>='\u00AC' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5522:27: RULE_IN_DOUBLE_QUOTE_RICH_STRING
            	    {
            	    mRULE_IN_DOUBLE_QUOTE_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match("'''"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5524:22: ( '\\'\\'\\'' ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )* '\\u00AB' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5524:24: '\\'\\'\\'' ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )* '\\u00AB'
            {
            match("'''"); 

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5524:33: ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\u00AA')||(LA2_0>='\u00AC' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5524:33: RULE_IN_DOUBLE_QUOTE_RICH_STRING
            	    {
            	    mRULE_IN_DOUBLE_QUOTE_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5526:20: ( '\\u00BB' ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )* '\\'\\'\\'' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5526:22: '\\u00BB' ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )* '\\'\\'\\''
            {
            match('\u00BB'); 
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5526:31: ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\'') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='\'') ) {
                        int LA3_3 = input.LA(3);

                        if ( ((LA3_3>='\u0000' && LA3_3<='&')||(LA3_3>='(' && LA3_3<='\uFFFF')) ) {
                            alt3=1;
                        }


                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='&')||(LA3_1>='(' && LA3_1<='\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\u00AA')||(LA3_0>='\u00AC' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5526:31: RULE_IN_DOUBLE_QUOTE_RICH_STRING
            	    {
            	    mRULE_IN_DOUBLE_QUOTE_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("'''"); 


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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5528:26: ( '\\u00BB' ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )* '\\u00AB' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5528:28: '\\u00BB' ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )* '\\u00AB'
            {
            match('\u00BB'); 
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5528:37: ( RULE_IN_DOUBLE_QUOTE_RICH_STRING )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\u00AA')||(LA4_0>='\u00AC' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5528:37: RULE_IN_DOUBLE_QUOTE_RICH_STRING
            	    {
            	    mRULE_IN_DOUBLE_QUOTE_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\u00AB'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RICH_TEXT_INBETWEEN"

    // $ANTLR start "RULE_IN_DOUBLE_QUOTE_RICH_STRING"
    public final void mRULE_IN_DOUBLE_QUOTE_RICH_STRING() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5530:43: ( ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | ~ ( ( '\\u00AB' | '\\'' ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5530:45: ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | ~ ( ( '\\u00AB' | '\\'' ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5530:45: ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | ~ ( ( '\\u00AB' | '\\'' ) ) )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\'') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='\'') ) {
                    alt5=1;
                }
                else if ( ((LA5_1>='\u0000' && LA5_1<='&')||(LA5_1>='(' && LA5_1<='\uFFFF')) ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='\u00AA')||(LA5_0>='\u00AC' && LA5_0<='\uFFFF')) ) {
                alt5=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5530:46: '\\'\\'' ~ ( '\\'' )
                    {
                    match("''"); 

                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5530:61: '\\'' ~ ( '\\'' )
                    {
                    match('\''); 
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5530:74: ~ ( ( '\\u00AB' | '\\'' ) )
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
    // $ANTLR end "RULE_IN_DOUBLE_QUOTE_RICH_STRING"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5532:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5532:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5532:11: ( '^' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='^') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5532:11: '^'
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5532:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:
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
            	    break loop7;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5534:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5534:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5534:12: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5534:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\"') ) {
                alt11=1;
            }
            else if ( (LA11_0=='\'') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:62: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop9;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop10:
                    do {
                        int alt10=3;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='\\') ) {
                            alt10=1;
                        }
                        else if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFF')) ) {
                            alt10=2;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5536:129: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop10;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5538:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5538:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5538:24: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='*') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1=='/') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_1>='\u0000' && LA12_1<='.')||(LA12_1>='0' && LA12_1<='\uFFFF')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5538:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5540:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5540:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5540:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5540:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop13;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5540:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5540:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5540:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5540:41: '\\r'
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5542:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5542:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5542:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5544:16: ( . )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5544:18: .
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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | RULE_RICH_TEXT | RULE_RICH_TEXT_START | RULE_RICH_TEXT_END | RULE_RICH_TEXT_INBETWEEN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt17=75;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:10: T__16
                {
                mT__16(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:16: T__17
                {
                mT__17(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:22: T__18
                {
                mT__18(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:28: T__19
                {
                mT__19(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:34: T__20
                {
                mT__20(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:40: T__21
                {
                mT__21(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:46: T__22
                {
                mT__22(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:52: T__23
                {
                mT__23(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:58: T__24
                {
                mT__24(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:64: T__25
                {
                mT__25(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:70: T__26
                {
                mT__26(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:76: T__27
                {
                mT__27(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:82: T__28
                {
                mT__28(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:88: T__29
                {
                mT__29(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:94: T__30
                {
                mT__30(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:100: T__31
                {
                mT__31(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:106: T__32
                {
                mT__32(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:112: T__33
                {
                mT__33(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:118: T__34
                {
                mT__34(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:124: T__35
                {
                mT__35(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:130: T__36
                {
                mT__36(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:136: T__37
                {
                mT__37(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:142: T__38
                {
                mT__38(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:148: T__39
                {
                mT__39(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:154: T__40
                {
                mT__40(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:160: T__41
                {
                mT__41(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:166: T__42
                {
                mT__42(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:172: T__43
                {
                mT__43(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:178: T__44
                {
                mT__44(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:184: T__45
                {
                mT__45(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:190: T__46
                {
                mT__46(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:196: T__47
                {
                mT__47(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:202: T__48
                {
                mT__48(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:208: T__49
                {
                mT__49(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:214: T__50
                {
                mT__50(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:220: T__51
                {
                mT__51(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:226: T__52
                {
                mT__52(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:232: T__53
                {
                mT__53(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:238: T__54
                {
                mT__54(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:244: T__55
                {
                mT__55(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:250: T__56
                {
                mT__56(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:256: T__57
                {
                mT__57(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:262: T__58
                {
                mT__58(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:268: T__59
                {
                mT__59(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:274: T__60
                {
                mT__60(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:280: T__61
                {
                mT__61(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:286: T__62
                {
                mT__62(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:292: T__63
                {
                mT__63(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:298: T__64
                {
                mT__64(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:304: T__65
                {
                mT__65(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:310: T__66
                {
                mT__66(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:316: T__67
                {
                mT__67(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:322: T__68
                {
                mT__68(); 

                }
                break;
            case 54 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:328: T__69
                {
                mT__69(); 

                }
                break;
            case 55 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:334: T__70
                {
                mT__70(); 

                }
                break;
            case 56 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:340: T__71
                {
                mT__71(); 

                }
                break;
            case 57 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:346: T__72
                {
                mT__72(); 

                }
                break;
            case 58 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:352: T__73
                {
                mT__73(); 

                }
                break;
            case 59 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:358: T__74
                {
                mT__74(); 

                }
                break;
            case 60 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:364: T__75
                {
                mT__75(); 

                }
                break;
            case 61 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:370: T__76
                {
                mT__76(); 

                }
                break;
            case 62 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:376: T__77
                {
                mT__77(); 

                }
                break;
            case 63 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:382: T__78
                {
                mT__78(); 

                }
                break;
            case 64 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:388: T__79
                {
                mT__79(); 

                }
                break;
            case 65 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:394: RULE_RICH_TEXT
                {
                mRULE_RICH_TEXT(); 

                }
                break;
            case 66 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:409: RULE_RICH_TEXT_START
                {
                mRULE_RICH_TEXT_START(); 

                }
                break;
            case 67 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:430: RULE_RICH_TEXT_END
                {
                mRULE_RICH_TEXT_END(); 

                }
                break;
            case 68 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:449: RULE_RICH_TEXT_INBETWEEN
                {
                mRULE_RICH_TEXT_INBETWEEN(); 

                }
                break;
            case 69 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:474: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 70 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:482: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 71 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:491: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 72 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:503: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 73 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:519: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 74 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:535: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 75 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1:543: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\1\uffff\2\54\1\61\1\64\1\66\1\uffff\1\71\2\54\5\uffff\1\54\1\uffff"+
        "\2\54\1\112\1\114\1\116\1\120\1\122\1\124\1\127\1\uffff\1\132\7"+
        "\54\3\52\2\uffff\1\52\2\uffff\1\54\1\uffff\2\54\1\162\12\uffff\4"+
        "\54\5\uffff\1\54\1\uffff\2\54\1\173\23\uffff\3\54\1\177\11\54\1"+
        "\151\6\uffff\3\54\1\uffff\5\54\1\u0097\2\54\1\uffff\3\54\1\uffff"+
        "\1\u009e\3\54\1\u00a2\1\u00a3\1\u00a4\2\54\1\u00a7\1\54\3\uffff"+
        "\5\54\1\u00b3\2\54\1\u00b6\1\uffff\2\54\1\u00ba\3\54\1\uffff\3\54"+
        "\3\uffff\1\u00c1\1\u00c2\1\uffff\1\54\5\uffff\4\54\1\u00ca\1\uffff"+
        "\1\u00cb\1\54\1\uffff\1\54\1\u00ce\1\54\1\uffff\1\54\1\u00d1\1\54"+
        "\1\u00d3\1\54\1\u00d5\2\uffff\1\u00d6\2\uffff\1\54\1\u00da\2\54"+
        "\2\uffff\1\54\1\u00de\1\uffff\1\u00df\1\u00e0\1\uffff\1\54\1\uffff"+
        "\1\54\4\uffff\1\u00e3\1\uffff\2\54\1\u00e6\3\uffff\1\u00e7\1\u00e8"+
        "\1\uffff\2\54\3\uffff\2\54\1\u00ed\1\u00ee\2\uffff";
    static final String DFA17_eofS =
        "\u00ef\uffff";
    static final String DFA17_minS =
        "\1\0\1\141\1\146\1\56\1\52\1\75\1\uffff\1\75\1\141\1\154\5\uffff"+
        "\1\117\1\uffff\1\114\1\106\2\75\1\174\1\46\1\75\1\76\1\52\1\uffff"+
        "\1\56\1\165\1\145\1\141\1\150\1\141\1\145\1\150\2\0\1\101\2\uffff"+
        "\1\0\2\uffff\1\143\1\uffff\1\160\1\163\1\60\12\uffff\1\141\1\163"+
        "\1\164\1\163\5\uffff\1\122\1\uffff\1\104\1\123\1\60\23\uffff\1\151"+
        "\1\160\1\146\1\60\1\162\1\154\1\156\1\151\1\154\1\167\1\154\1\165"+
        "\1\162\1\47\1\uffff\2\0\3\uffff\1\153\1\154\1\164\1\uffff\1\163"+
        "\1\145\1\143\2\145\1\60\1\106\1\105\1\uffff\1\164\1\145\1\141\1"+
        "\uffff\1\60\1\163\1\141\1\154\3\60\1\154\1\145\1\60\1\157\3\0\1"+
        "\141\1\162\1\145\1\141\1\163\1\60\1\150\1\156\1\60\1\uffff\1\117"+
        "\1\106\1\60\1\143\1\162\1\165\1\uffff\1\145\1\154\1\145\3\uffff"+
        "\2\60\1\uffff\1\167\2\0\1\uffff\1\0\1\uffff\1\147\1\164\1\155\1"+
        "\156\1\60\1\uffff\1\60\1\144\1\uffff\1\122\1\60\1\106\1\uffff\1"+
        "\150\1\60\1\154\1\60\1\154\1\60\2\uffff\1\60\2\0\1\145\1\60\1\145"+
        "\1\143\2\uffff\1\163\1\60\1\uffff\2\60\1\uffff\1\164\1\uffff\1\171"+
        "\2\uffff\1\0\1\uffff\1\60\1\uffff\1\156\1\145\1\60\3\uffff\2\60"+
        "\1\uffff\1\164\1\157\3\uffff\1\163\1\146\2\60\2\uffff";
    static final String DFA17_maxS =
        "\1\uffff\1\141\1\156\2\56\1\75\1\uffff\1\75\1\154\1\170\5\uffff"+
        "\1\117\1\uffff\1\116\1\106\1\76\1\75\1\174\1\46\1\75\1\76\1\57\1"+
        "\uffff\1\56\1\167\2\157\1\150\1\141\1\165\1\162\2\uffff\1\172\2"+
        "\uffff\1\uffff\2\uffff\1\143\1\uffff\1\160\1\163\1\172\12\uffff"+
        "\1\141\2\164\1\163\5\uffff\1\122\1\uffff\1\104\1\123\1\172\23\uffff"+
        "\1\151\1\160\1\146\1\172\1\162\1\154\1\156\1\151\1\162\1\167\1\154"+
        "\1\171\1\162\1\47\1\uffff\2\uffff\3\uffff\1\153\1\157\1\164\1\uffff"+
        "\1\163\1\145\1\143\2\145\1\172\1\111\1\105\1\uffff\1\164\1\145\1"+
        "\141\1\uffff\1\172\1\163\1\141\1\154\3\172\1\154\1\145\1\172\1\157"+
        "\3\uffff\1\141\1\162\1\145\1\141\1\163\1\172\1\150\1\156\1\172\1"+
        "\uffff\1\117\1\106\1\172\1\143\1\162\1\165\1\uffff\1\145\1\154\1"+
        "\145\3\uffff\2\172\1\uffff\1\167\2\uffff\1\uffff\1\uffff\1\uffff"+
        "\1\147\1\164\1\155\1\156\1\172\1\uffff\1\172\1\144\1\uffff\1\122"+
        "\1\172\1\106\1\uffff\1\150\1\172\1\154\1\172\1\154\1\172\2\uffff"+
        "\1\172\2\uffff\1\145\1\172\1\145\1\143\2\uffff\1\163\1\172\1\uffff"+
        "\2\172\1\uffff\1\164\1\uffff\1\171\2\uffff\1\uffff\1\uffff\1\172"+
        "\1\uffff\1\156\1\145\1\172\3\uffff\2\172\1\uffff\1\164\1\157\3\uffff"+
        "\1\163\1\146\2\172\2\uffff";
    static final String DFA17_acceptS =
        "\6\uffff\1\6\3\uffff\1\13\1\14\1\15\1\16\1\17\1\uffff\1\21\11\uffff"+
        "\1\46\13\uffff\1\105\1\106\1\uffff\1\112\1\113\1\uffff\1\105\3\uffff"+
        "\1\41\1\3\1\44\1\51\1\4\1\37\1\5\1\6\1\36\1\7\4\uffff\1\13\1\14"+
        "\1\15\1\16\1\17\1\uffff\1\21\3\uffff\1\33\1\75\1\27\1\30\1\42\1"+
        "\31\1\52\1\32\1\77\1\34\1\47\1\40\1\43\1\110\1\111\1\45\1\46\1\50"+
        "\1\76\16\uffff\1\107\2\uffff\1\104\1\106\1\112\3\uffff\1\53\10\uffff"+
        "\1\23\3\uffff\1\62\27\uffff\1\20\6\uffff\1\60\3\uffff\1\63\1\64"+
        "\1\65\2\uffff\1\72\3\uffff\1\102\1\uffff\1\103\5\uffff\1\57\2\uffff"+
        "\1\54\3\uffff\1\24\6\uffff\1\70\1\67\7\uffff\1\10\1\74\2\uffff\1"+
        "\25\2\uffff\1\100\1\uffff\1\66\1\uffff\1\61\1\71\1\uffff\1\101\1"+
        "\uffff\1\2\3\uffff\1\22\1\26\1\55\2\uffff\1\1\2\uffff\1\11\1\56"+
        "\1\73\4\uffff\1\12\1\35";
    static final String DFA17_specialS =
        "\1\10\42\uffff\1\14\1\1\3\uffff\1\6\101\uffff\1\7\1\15\37\uffff"+
        "\1\2\1\16\1\13\33\uffff\1\0\1\4\1\uffff\1\11\27\uffff\1\5\1\3\21"+
        "\uffff\1\12\27\uffff}>";
    static final String[] DFA17_transitionS = {
            "\11\52\2\51\2\52\1\51\22\52\1\51\1\27\1\50\2\52\1\32\1\26\1"+
            "\43\1\14\1\15\1\4\1\24\1\6\1\30\1\3\1\31\12\47\1\20\1\16\1\5"+
            "\1\23\1\7\1\33\1\52\4\46\1\21\1\17\2\46\1\22\21\46\3\52\1\45"+
            "\1\46\1\52\2\46\1\10\1\35\1\11\1\36\2\46\1\2\4\46\1\41\1\46"+
            "\1\1\2\46\1\34\1\42\1\46\1\40\1\37\3\46\1\12\1\25\1\13\75\52"+
            "\1\44\uff44\52",
            "\1\53",
            "\1\57\6\uffff\1\55\1\56",
            "\1\60",
            "\1\62\3\uffff\1\63",
            "\1\65",
            "",
            "\1\70",
            "\1\73\12\uffff\1\72",
            "\1\75\13\uffff\1\74",
            "",
            "",
            "",
            "",
            "",
            "\1\103",
            "",
            "\1\106\1\uffff\1\105",
            "\1\107",
            "\1\110\1\111",
            "\1\113",
            "\1\115",
            "\1\117",
            "\1\121",
            "\1\123",
            "\1\125\4\uffff\1\126",
            "",
            "\1\131",
            "\1\134\1\uffff\1\133",
            "\1\135\11\uffff\1\136",
            "\1\140\7\uffff\1\141\5\uffff\1\137",
            "\1\142",
            "\1\143",
            "\1\144\17\uffff\1\145",
            "\1\147\11\uffff\1\146",
            "\47\151\1\150\uffd8\151",
            "\47\153\1\152\u0083\153\1\154\uff54\153",
            "\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\0\151",
            "",
            "",
            "\1\157",
            "",
            "\1\160",
            "\1\161",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
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
            "\1\163",
            "\1\164\1\165",
            "\1\166",
            "\1\167",
            "",
            "",
            "",
            "",
            "",
            "\1\170",
            "",
            "\1\171",
            "\1\172",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
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
            "\1\174",
            "\1\175",
            "\1\176",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0085\5\uffff\1\u0084",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088\3\uffff\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "",
            "\47\u008d\1\u008c\uffd8\u008d",
            "\47\153\1\152\u0083\153\1\154\uff54\153",
            "",
            "",
            "",
            "\1\u008e",
            "\1\u0090\2\uffff\1\u008f",
            "\1\u0091",
            "",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0098\2\uffff\1\u0099",
            "\1\u009a",
            "",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00a5",
            "\1\u00a6",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00a8",
            "\47\u00aa\1\u00a9\u0083\u00aa\1\u00ab\uff54\u00aa",
            "\47\u00ac\1\u00ad\uffd8\u00ac",
            "\47\153\1\152\u0083\153\1\154\uff54\153",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00b4",
            "\1\u00b5",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u00b7",
            "\1\u00b8",
            "\12\54\7\uffff\10\54\1\u00b9\21\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "",
            "",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u00c3",
            "\47\u00c5\1\u00c4\uffd8\u00c5",
            "\47\u00aa\1\u00a9\u0083\u00aa\1\u00ab\uff54\u00aa",
            "",
            "\47\153\1\152\u0083\153\1\154\uff54\153",
            "",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00cc",
            "",
            "\1\u00cd",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00cf",
            "",
            "\1\u00d0",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00d2",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00d4",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\47\u00d7\1\u00d8\uffd8\u00d7",
            "\47\u00aa\1\u00a9\u0083\u00aa\1\u00ab\uff54\u00aa",
            "\1\u00d9",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00db",
            "\1\u00dc",
            "",
            "",
            "\1\u00dd",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u00e1",
            "",
            "\1\u00e2",
            "",
            "",
            "\47\u00aa\1\u00a9\u0083\u00aa\1\u00ab\uff54\u00aa",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u00e4",
            "\1\u00e5",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u00e9",
            "\1\u00ea",
            "",
            "",
            "",
            "\1\u00eb",
            "\1\u00ec",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | RULE_RICH_TEXT | RULE_RICH_TEXT_START | RULE_RICH_TEXT_END | RULE_RICH_TEXT_INBETWEEN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_169 = input.LA(1);

                        s = -1;
                        if ( (LA17_169=='\'') ) {s = 196;}

                        else if ( ((LA17_169>='\u0000' && LA17_169<='&')||(LA17_169>='(' && LA17_169<='\uFFFF')) ) {s = 197;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_36 = input.LA(1);

                        s = -1;
                        if ( (LA17_36=='\'') ) {s = 106;}

                        else if ( ((LA17_36>='\u0000' && LA17_36<='&')||(LA17_36>='(' && LA17_36<='\u00AA')||(LA17_36>='\u00AC' && LA17_36<='\uFFFF')) ) {s = 107;}

                        else if ( (LA17_36=='\u00AB') ) {s = 108;}

                        else s = 42;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_139 = input.LA(1);

                        s = -1;
                        if ( (LA17_139=='\'') ) {s = 169;}

                        else if ( ((LA17_139>='\u0000' && LA17_139<='&')||(LA17_139>='(' && LA17_139<='\u00AA')||(LA17_139>='\u00AC' && LA17_139<='\uFFFF')) ) {s = 170;}

                        else if ( (LA17_139=='\u00AB') ) {s = 171;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_197 = input.LA(1);

                        s = -1;
                        if ( (LA17_197=='\u00AB') ) {s = 171;}

                        else if ( (LA17_197=='\'') ) {s = 169;}

                        else if ( ((LA17_197>='\u0000' && LA17_197<='&')||(LA17_197>='(' && LA17_197<='\u00AA')||(LA17_197>='\u00AC' && LA17_197<='\uFFFF')) ) {s = 170;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_170 = input.LA(1);

                        s = -1;
                        if ( (LA17_170=='\u00AB') ) {s = 171;}

                        else if ( (LA17_170=='\'') ) {s = 169;}

                        else if ( ((LA17_170>='\u0000' && LA17_170<='&')||(LA17_170>='(' && LA17_170<='\u00AA')||(LA17_170>='\u00AC' && LA17_170<='\uFFFF')) ) {s = 170;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_196 = input.LA(1);

                        s = -1;
                        if ( ((LA17_196>='\u0000' && LA17_196<='&')||(LA17_196>='(' && LA17_196<='\uFFFF')) ) {s = 215;}

                        else if ( (LA17_196=='\'') ) {s = 216;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_40 = input.LA(1);

                        s = -1;
                        if ( ((LA17_40>='\u0000' && LA17_40<='\uFFFF')) ) {s = 105;}

                        else s = 42;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_106 = input.LA(1);

                        s = -1;
                        if ( (LA17_106=='\'') ) {s = 140;}

                        else if ( ((LA17_106>='\u0000' && LA17_106<='&')||(LA17_106>='(' && LA17_106<='\uFFFF')) ) {s = 141;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_0 = input.LA(1);

                        s = -1;
                        if ( (LA17_0=='p') ) {s = 1;}

                        else if ( (LA17_0=='i') ) {s = 2;}

                        else if ( (LA17_0=='.') ) {s = 3;}

                        else if ( (LA17_0=='*') ) {s = 4;}

                        else if ( (LA17_0=='<') ) {s = 5;}

                        else if ( (LA17_0==',') ) {s = 6;}

                        else if ( (LA17_0=='>') ) {s = 7;}

                        else if ( (LA17_0=='c') ) {s = 8;}

                        else if ( (LA17_0=='e') ) {s = 9;}

                        else if ( (LA17_0=='{') ) {s = 10;}

                        else if ( (LA17_0=='}') ) {s = 11;}

                        else if ( (LA17_0=='(') ) {s = 12;}

                        else if ( (LA17_0==')') ) {s = 13;}

                        else if ( (LA17_0==';') ) {s = 14;}

                        else if ( (LA17_0=='F') ) {s = 15;}

                        else if ( (LA17_0==':') ) {s = 16;}

                        else if ( (LA17_0=='E') ) {s = 17;}

                        else if ( (LA17_0=='I') ) {s = 18;}

                        else if ( (LA17_0=='=') ) {s = 19;}

                        else if ( (LA17_0=='+') ) {s = 20;}

                        else if ( (LA17_0=='|') ) {s = 21;}

                        else if ( (LA17_0=='&') ) {s = 22;}

                        else if ( (LA17_0=='!') ) {s = 23;}

                        else if ( (LA17_0=='-') ) {s = 24;}

                        else if ( (LA17_0=='/') ) {s = 25;}

                        else if ( (LA17_0=='%') ) {s = 26;}

                        else if ( (LA17_0=='?') ) {s = 27;}

                        else if ( (LA17_0=='s') ) {s = 28;}

                        else if ( (LA17_0=='d') ) {s = 29;}

                        else if ( (LA17_0=='f') ) {s = 30;}

                        else if ( (LA17_0=='w') ) {s = 31;}

                        else if ( (LA17_0=='v') ) {s = 32;}

                        else if ( (LA17_0=='n') ) {s = 33;}

                        else if ( (LA17_0=='t') ) {s = 34;}

                        else if ( (LA17_0=='\'') ) {s = 35;}

                        else if ( (LA17_0=='\u00BB') ) {s = 36;}

                        else if ( (LA17_0=='^') ) {s = 37;}

                        else if ( ((LA17_0>='A' && LA17_0<='D')||(LA17_0>='G' && LA17_0<='H')||(LA17_0>='J' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='b')||(LA17_0>='g' && LA17_0<='h')||(LA17_0>='j' && LA17_0<='m')||LA17_0=='o'||(LA17_0>='q' && LA17_0<='r')||LA17_0=='u'||(LA17_0>='x' && LA17_0<='z')) ) {s = 38;}

                        else if ( ((LA17_0>='0' && LA17_0<='9')) ) {s = 39;}

                        else if ( (LA17_0=='\"') ) {s = 40;}

                        else if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {s = 41;}

                        else if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||(LA17_0>='#' && LA17_0<='$')||LA17_0=='@'||(LA17_0>='[' && LA17_0<=']')||LA17_0=='`'||(LA17_0>='~' && LA17_0<='\u00BA')||(LA17_0>='\u00BC' && LA17_0<='\uFFFF')) ) {s = 42;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_172 = input.LA(1);

                        s = -1;
                        if ( (LA17_172=='\'') ) {s = 106;}

                        else if ( ((LA17_172>='\u0000' && LA17_172<='&')||(LA17_172>='(' && LA17_172<='\u00AA')||(LA17_172>='\u00AC' && LA17_172<='\uFFFF')) ) {s = 107;}

                        else if ( (LA17_172=='\u00AB') ) {s = 108;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_215 = input.LA(1);

                        s = -1;
                        if ( (LA17_215=='\'') ) {s = 169;}

                        else if ( ((LA17_215>='\u0000' && LA17_215<='&')||(LA17_215>='(' && LA17_215<='\u00AA')||(LA17_215>='\u00AC' && LA17_215<='\uFFFF')) ) {s = 170;}

                        else if ( (LA17_215=='\u00AB') ) {s = 171;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_141 = input.LA(1);

                        s = -1;
                        if ( (LA17_141=='\u00AB') ) {s = 108;}

                        else if ( (LA17_141=='\'') ) {s = 106;}

                        else if ( ((LA17_141>='\u0000' && LA17_141<='&')||(LA17_141>='(' && LA17_141<='\u00AA')||(LA17_141>='\u00AC' && LA17_141<='\uFFFF')) ) {s = 107;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_35 = input.LA(1);

                        s = -1;
                        if ( (LA17_35=='\'') ) {s = 104;}

                        else if ( ((LA17_35>='\u0000' && LA17_35<='&')||(LA17_35>='(' && LA17_35<='\uFFFF')) ) {s = 105;}

                        else s = 42;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_107 = input.LA(1);

                        s = -1;
                        if ( (LA17_107=='\u00AB') ) {s = 108;}

                        else if ( (LA17_107=='\'') ) {s = 106;}

                        else if ( ((LA17_107>='\u0000' && LA17_107<='&')||(LA17_107>='(' && LA17_107<='\u00AA')||(LA17_107>='\u00AC' && LA17_107<='\uFFFF')) ) {s = 107;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_140 = input.LA(1);

                        s = -1;
                        if ( ((LA17_140>='\u0000' && LA17_140<='&')||(LA17_140>='(' && LA17_140<='\uFFFF')) ) {s = 172;}

                        else if ( (LA17_140=='\'') ) {s = 173;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}