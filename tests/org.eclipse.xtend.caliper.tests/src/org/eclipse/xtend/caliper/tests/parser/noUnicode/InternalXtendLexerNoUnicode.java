package org.eclipse.xtend.caliper.tests.parser.noUnicode;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtendLexerNoUnicode extends Lexer {
    public static final int RULE_COMMENT_RICH_TEXT_INBETWEEN=9;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_ANY_OTHER=24;
    public static final int RULE_IDENTIFIER_PART_IMPL=19;
    public static final int RULE_COMMENT_RICH_TEXT_END=11;
    public static final int EOF=-1;
    public static final int RULE_IDENTIFIER_START=18;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int RULE_HEX=12;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int RULE_RICH_TEXT_END=10;
    public static final int RULE_DECIMAL=14;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_HEX_DIGIT=15;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int RULE_IN_RICH_STRING=17;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=21;
    public static final int RULE_STRING=5;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int RULE_RICH_TEXT_START=7;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int RULE_RICH_TEXT=6;
    public static final int T__63=63;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__121=121;
    public static final int T__120=120;
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
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__59=59;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int RULE_UNICODE_ESCAPE=16;
    public static final int RULE_INT=13;
    public static final int T__112=112;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_IDENTIFIER_PART=20;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=22;
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
    public static final int RULE_WS=23;

    // delegates
    // delegators

    public InternalXtendLexerNoUnicode() {;} 
    public InternalXtendLexerNoUnicode(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalXtendLexerNoUnicode(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g"; }

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:11:7: ( 'package' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:11:9: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:12:7: ( ';' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:12:9: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:13:7: ( 'class' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:13:9: 'class'
            {
            match("class"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:14:7: ( '<' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:14:9: '<'
            {
            match('<'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:15:7: ( ',' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:15:9: ','
            {
            match(','); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:16:7: ( '>' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:16:9: '>'
            {
            match('>'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:17:7: ( 'extends' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:17:9: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:18:7: ( 'implements' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:18:9: 'implements'
            {
            match("implements"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:19:7: ( '{' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:19:9: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:20:7: ( '}' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:20:9: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:21:7: ( 'interface' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:21:9: 'interface'
            {
            match("interface"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:22:7: ( 'enum' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:22:9: 'enum'
            {
            match("enum"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:23:7: ( 'annotation' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:23:9: 'annotation'
            {
            match("annotation"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:24:7: ( '=' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:24:9: '='
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:25:7: ( 'extension' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:25:9: 'extension'
            {
            match("extension"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:26:7: ( '(' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:26:9: '('
            {
            match('('); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:27:7: ( ')' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:27:9: ')'
            {
            match(')'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:28:7: ( 'throws' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:28:9: 'throws'
            {
            match("throws"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:29:7: ( 'new' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:29:9: 'new'
            {
            match("new"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:30:7: ( 'public' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:30:9: 'public'
            {
            match("public"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:31:7: ( 'private' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:31:9: 'private'
            {
            match("private"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:32:7: ( 'protected' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:32:9: 'protected'
            {
            match("protected"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:33:7: ( 'abstract' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:33:9: 'abstract'
            {
            match("abstract"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:34:7: ( 'static' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:34:9: 'static'
            {
            match("static"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:35:7: ( 'dispatch' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:35:9: 'dispatch'
            {
            match("dispatch"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:36:7: ( 'final' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:36:9: 'final'
            {
            match("final"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:37:7: ( 'val' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:37:9: 'val'
            {
            match("val"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:38:7: ( 'var' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:38:9: 'var'
            {
            match("var"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:39:7: ( 'def' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:39:9: 'def'
            {
            match("def"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:40:7: ( 'override' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:40:9: 'override'
            {
            match("override"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:41:7: ( 'create' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:41:9: 'create'
            {
            match("create"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:42:7: ( ':' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:42:9: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:43:7: ( 'import' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:43:9: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:44:7: ( '...' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:44:9: '...'
            {
            match("..."); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:45:7: ( 'FOR' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:45:9: 'FOR'
            {
            match("FOR"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:46:7: ( 'BEFORE' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:46:9: 'BEFORE'
            {
            match("BEFORE"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:47:7: ( 'SEPARATOR' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:47:9: 'SEPARATOR'
            {
            match("SEPARATOR"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:48:7: ( 'AFTER' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:48:9: 'AFTER'
            {
            match("AFTER"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:49:7: ( 'ENDFOR' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:49:9: 'ENDFOR'
            {
            match("ENDFOR"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:50:7: ( 'IF' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:50:9: 'IF'
            {
            match("IF"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:51:7: ( 'ELSE' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:51:9: 'ELSE'
            {
            match("ELSE"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:52:7: ( 'ENDIF' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:52:9: 'ENDIF'
            {
            match("ENDIF"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:53:7: ( 'ELSEIF' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:53:9: 'ELSEIF'
            {
            match("ELSEIF"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:54:7: ( '@' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:54:9: '@'
            {
            match('@'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:55:7: ( '#' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:55:9: '#'
            {
            match('#'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:56:7: ( '[' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:56:9: '['
            {
            match('['); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:57:7: ( ']' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:57:9: ']'
            {
            match(']'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:58:7: ( '+=' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:58:9: '+='
            {
            match("+="); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:59:7: ( '-=' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:59:9: '-='
            {
            match("-="); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:60:7: ( '||' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:60:9: '||'
            {
            match("||"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:61:7: ( '&&' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:61:9: '&&'
            {
            match("&&"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:62:7: ( '==' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:62:9: '=='
            {
            match("=="); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:63:7: ( '!=' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:63:9: '!='
            {
            match("!="); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:64:7: ( '===' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:64:9: '==='
            {
            match("==="); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:65:7: ( '!==' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:65:9: '!=='
            {
            match("!=="); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:66:7: ( 'instanceof' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:66:9: 'instanceof'
            {
            match("instanceof"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:67:7: ( '>=' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:67:9: '>='
            {
            match(">="); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:68:7: ( '<=' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:68:9: '<='
            {
            match("<="); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:69:7: ( '->' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:69:9: '->'
            {
            match("->"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:70:7: ( '..<' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:70:9: '..<'
            {
            match("..<"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:71:7: ( '..' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:71:9: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:72:7: ( '=>' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:72:9: '=>'
            {
            match("=>"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:73:7: ( '<>' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:73:9: '<>'
            {
            match("<>"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:74:7: ( '?:' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:74:9: '?:'
            {
            match("?:"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:75:7: ( '<=>' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:75:9: '<=>'
            {
            match("<=>"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:76:7: ( '+' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:76:9: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:77:7: ( '-' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:77:9: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:78:7: ( '*' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:78:9: '*'
            {
            match('*'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:79:7: ( '**' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:79:9: '**'
            {
            match("**"); 


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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:80:7: ( '/' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:80:9: '/'
            {
            match('/'); 

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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:81:7: ( '%' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:81:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:82:7: ( '!' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:82:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:83:7: ( 'as' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:83:9: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:84:7: ( '.' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:84:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:85:7: ( '::' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:85:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:86:8: ( '?.' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:86:10: '?.'
            {
            match("?."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:87:8: ( '|' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:87:10: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:88:8: ( 'if' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:88:10: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:89:8: ( 'else' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:89:10: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:90:8: ( 'switch' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:90:10: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:91:8: ( 'default' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:91:10: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:92:8: ( 'case' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:92:10: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:93:8: ( 'for' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:93:10: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:94:8: ( 'while' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:94:10: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:95:8: ( 'do' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:95:10: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:96:8: ( 'super' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:96:10: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:97:8: ( 'false' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:97:10: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:98:8: ( 'true' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:98:10: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:99:8: ( 'null' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:99:10: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:100:8: ( 'typeof' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:100:10: 'typeof'
            {
            match("typeof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:101:8: ( 'throw' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:101:10: 'throw'
            {
            match("throw"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:102:8: ( 'return' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:102:10: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:103:8: ( 'try' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:103:10: 'try'
            {
            match("try"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:104:8: ( 'finally' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:104:10: 'finally'
            {
            match("finally"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:105:8: ( 'catch' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:105:10: 'catch'
            {
            match("catch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:106:8: ( '?' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:106:10: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:107:8: ( '&' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:107:10: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "RULE_HEX_DIGIT"
    public final void mRULE_HEX_DIGIT() throws RecognitionException {
        try {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9873:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9873:27: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_DIGIT"

    // $ANTLR start "RULE_UNICODE_ESCAPE"
    public final void mRULE_UNICODE_ESCAPE() throws RecognitionException {
        try {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9875:30: ( '\\\\' 'u' ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT )? )? )? )? )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9875:32: '\\\\' 'u' ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT )? )? )? )?
            {
            match('\\'); 
            match('u'); 
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9875:41: ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT )? )? )? )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='F')||(LA4_0>='a' && LA4_0<='f')) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9875:42: RULE_HEX_DIGIT ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT )? )? )?
                    {
                    mRULE_HEX_DIGIT(); 
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9875:57: ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT )? )? )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='F')||(LA3_0>='a' && LA3_0<='f')) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9875:58: RULE_HEX_DIGIT ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT )? )?
                            {
                            mRULE_HEX_DIGIT(); 
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9875:73: ( RULE_HEX_DIGIT ( RULE_HEX_DIGIT )? )?
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')||(LA2_0>='a' && LA2_0<='f')) ) {
                                alt2=1;
                            }
                            switch (alt2) {
                                case 1 :
                                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9875:74: RULE_HEX_DIGIT ( RULE_HEX_DIGIT )?
                                    {
                                    mRULE_HEX_DIGIT(); 
                                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9875:89: ( RULE_HEX_DIGIT )?
                                    int alt1=2;
                                    int LA1_0 = input.LA(1);

                                    if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='F')||(LA1_0>='a' && LA1_0<='f')) ) {
                                        alt1=1;
                                    }
                                    switch (alt1) {
                                        case 1 :
                                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9875:89: RULE_HEX_DIGIT
                                            {
                                            mRULE_HEX_DIGIT(); 

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNICODE_ESCAPE"

    // $ANTLR start "RULE_RICH_TEXT"
    public final void mRULE_RICH_TEXT() throws RecognitionException {
        try {
            int _type = RULE_RICH_TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:16: ( '\\'\\'\\'' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:18: '\\'\\'\\'' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match("'''"); 

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:27: ( RULE_IN_RICH_STRING )*
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
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:27: RULE_IN_RICH_STRING
            	    {
            	    mRULE_IN_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:48: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\'') ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1=='\'') ) {
                    int LA8_3 = input.LA(3);

                    if ( (LA8_3=='\'') ) {
                        alt8=1;
                    }
                    else {
                        alt8=2;}
                }
                else {
                    alt8=2;}
            }
            else {
                alt8=2;}
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:49: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:58: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:58: ( '\\'' ( '\\'' )? )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='\'') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:59: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:64: ( '\\'' )?
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( (LA6_0=='\'') ) {
                                alt6=1;
                            }
                            switch (alt6) {
                                case 1 :
                                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9877:64: '\\''
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9879:22: ( '\\'\\'\\'' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9879:24: '\\'\\'\\'' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB'
            {
            match("'''"); 

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9879:33: ( RULE_IN_RICH_STRING )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\'') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='\'') ) {
                        int LA9_4 = input.LA(3);

                        if ( ((LA9_4>='\u0000' && LA9_4<='&')||(LA9_4>='(' && LA9_4<='\u00AA')||(LA9_4>='\u00AC' && LA9_4<='\uFFFF')) ) {
                            alt9=1;
                        }


                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='&')||(LA9_1>='(' && LA9_1<='\u00AA')||(LA9_1>='\u00AC' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='\u00AA')||(LA9_0>='\u00AC' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9879:33: RULE_IN_RICH_STRING
            	    {
            	    mRULE_IN_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9879:54: ( '\\'' ( '\\'' )? )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\'') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9879:55: '\\'' ( '\\'' )?
                    {
                    match('\''); 
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9879:60: ( '\\'' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\'') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9879:60: '\\''
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:20: ( '\\u00BB' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:22: '\\u00BB' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match('\u00BB'); 
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:31: ( RULE_IN_RICH_STRING )*
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
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:31: RULE_IN_RICH_STRING
            	    {
            	    mRULE_IN_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:52: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\'') ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1=='\'') ) {
                    int LA15_3 = input.LA(3);

                    if ( (LA15_3=='\'') ) {
                        alt15=1;
                    }
                    else {
                        alt15=2;}
                }
                else {
                    alt15=2;}
            }
            else {
                alt15=2;}
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:53: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:62: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:62: ( '\\'' ( '\\'' )? )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\'') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:63: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:68: ( '\\'' )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0=='\'') ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9881:68: '\\''
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9883:26: ( '\\u00BB' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9883:28: '\\u00BB' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB'
            {
            match('\u00BB'); 
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9883:37: ( RULE_IN_RICH_STRING )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='\'') ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1=='\'') ) {
                        int LA16_4 = input.LA(3);

                        if ( ((LA16_4>='\u0000' && LA16_4<='&')||(LA16_4>='(' && LA16_4<='\u00AA')||(LA16_4>='\u00AC' && LA16_4<='\uFFFF')) ) {
                            alt16=1;
                        }


                    }
                    else if ( ((LA16_1>='\u0000' && LA16_1<='&')||(LA16_1>='(' && LA16_1<='\u00AA')||(LA16_1>='\u00AC' && LA16_1<='\uFFFF')) ) {
                        alt16=1;
                    }


                }
                else if ( ((LA16_0>='\u0000' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='\u00AA')||(LA16_0>='\u00AC' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9883:37: RULE_IN_RICH_STRING
            	    {
            	    mRULE_IN_RICH_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9883:58: ( '\\'' ( '\\'' )? )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\'') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9883:59: '\\'' ( '\\'' )?
                    {
                    match('\''); 
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9883:64: ( '\\'' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='\'') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9883:64: '\\''
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

    // $ANTLR start "RULE_COMMENT_RICH_TEXT_INBETWEEN"
    public final void mRULE_COMMENT_RICH_TEXT_INBETWEEN() throws RecognitionException {
        try {
            int _type = RULE_COMMENT_RICH_TEXT_INBETWEEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:34: ( '\\u00AB\\u00AB' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB' )? )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:36: '\\u00AB\\u00AB' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB' )?
            {
            match("\u00AB\u00AB"); 

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:51: (~ ( ( '\\n' | '\\r' ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\u0000' && LA19_0<='\t')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:51: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop19;
                }
            } while (true);

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:67: ( ( '\\r' )? '\\n' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\n'||LA24_0=='\r') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:68: ( '\\r' )? '\\n' ( RULE_IN_RICH_STRING )* ( '\\'' ( '\\'' )? )? '\\u00AB'
                    {
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:68: ( '\\r' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='\r') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:68: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:79: ( RULE_IN_RICH_STRING )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0=='\'') ) {
                            int LA21_1 = input.LA(2);

                            if ( (LA21_1=='\'') ) {
                                int LA21_4 = input.LA(3);

                                if ( ((LA21_4>='\u0000' && LA21_4<='&')||(LA21_4>='(' && LA21_4<='\u00AA')||(LA21_4>='\u00AC' && LA21_4<='\uFFFF')) ) {
                                    alt21=1;
                                }


                            }
                            else if ( ((LA21_1>='\u0000' && LA21_1<='&')||(LA21_1>='(' && LA21_1<='\u00AA')||(LA21_1>='\u00AC' && LA21_1<='\uFFFF')) ) {
                                alt21=1;
                            }


                        }
                        else if ( ((LA21_0>='\u0000' && LA21_0<='&')||(LA21_0>='(' && LA21_0<='\u00AA')||(LA21_0>='\u00AC' && LA21_0<='\uFFFF')) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:79: RULE_IN_RICH_STRING
                    	    {
                    	    mRULE_IN_RICH_STRING(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:100: ( '\\'' ( '\\'' )? )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='\'') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:101: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:106: ( '\\'' )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0=='\'') ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9885:106: '\\''
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
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_COMMENT_RICH_TEXT_INBETWEEN"

    // $ANTLR start "RULE_COMMENT_RICH_TEXT_END"
    public final void mRULE_COMMENT_RICH_TEXT_END() throws RecognitionException {
        try {
            int _type = RULE_COMMENT_RICH_TEXT_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:28: ( '\\u00AB\\u00AB' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) | EOF ) )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:30: '\\u00AB\\u00AB' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) | EOF )
            {
            match("\u00AB\u00AB"); 

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:45: (~ ( ( '\\n' | '\\r' ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='\u0000' && LA25_0<='\t')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\uFFFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:45: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop25;
                }
            } while (true);

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:61: ( ( '\\r' )? '\\n' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) | EOF )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0=='\n'||LA31_0=='\r') ) {
                alt31=1;
            }
            else {
                alt31=2;}
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:62: ( '\\r' )? '\\n' ( RULE_IN_RICH_STRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
                    {
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:62: ( '\\r' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0=='\r') ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:62: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:73: ( RULE_IN_RICH_STRING )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0=='\'') ) {
                            int LA27_1 = input.LA(2);

                            if ( (LA27_1=='\'') ) {
                                int LA27_4 = input.LA(3);

                                if ( ((LA27_4>='\u0000' && LA27_4<='&')||(LA27_4>='(' && LA27_4<='\u00AA')||(LA27_4>='\u00AC' && LA27_4<='\uFFFF')) ) {
                                    alt27=1;
                                }


                            }
                            else if ( ((LA27_1>='\u0000' && LA27_1<='&')||(LA27_1>='(' && LA27_1<='\u00AA')||(LA27_1>='\u00AC' && LA27_1<='\uFFFF')) ) {
                                alt27=1;
                            }


                        }
                        else if ( ((LA27_0>='\u0000' && LA27_0<='&')||(LA27_0>='(' && LA27_0<='\u00AA')||(LA27_0>='\u00AC' && LA27_0<='\uFFFF')) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:73: RULE_IN_RICH_STRING
                    	    {
                    	    mRULE_IN_RICH_STRING(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:94: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0=='\'') ) {
                        int LA30_1 = input.LA(2);

                        if ( (LA30_1=='\'') ) {
                            int LA30_3 = input.LA(3);

                            if ( (LA30_3=='\'') ) {
                                alt30=1;
                            }
                            else {
                                alt30=2;}
                        }
                        else {
                            alt30=2;}
                    }
                    else {
                        alt30=2;}
                    switch (alt30) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:95: '\\'\\'\\''
                            {
                            match("'''"); 


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:104: ( '\\'' ( '\\'' )? )? EOF
                            {
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:104: ( '\\'' ( '\\'' )? )?
                            int alt29=2;
                            int LA29_0 = input.LA(1);

                            if ( (LA29_0=='\'') ) {
                                alt29=1;
                            }
                            switch (alt29) {
                                case 1 :
                                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:105: '\\'' ( '\\'' )?
                                    {
                                    match('\''); 
                                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:110: ( '\\'' )?
                                    int alt28=2;
                                    int LA28_0 = input.LA(1);

                                    if ( (LA28_0=='\'') ) {
                                        alt28=1;
                                    }
                                    switch (alt28) {
                                        case 1 :
                                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:110: '\\''
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
                    break;
                case 2 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9887:123: EOF
                    {
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
    // $ANTLR end "RULE_COMMENT_RICH_TEXT_END"

    // $ANTLR start "RULE_IN_RICH_STRING"
    public final void mRULE_IN_RICH_STRING() throws RecognitionException {
        try {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9889:30: ( ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) ) )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9889:32: ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) )
            {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9889:32: ( '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | '\\'' ~ ( ( '\\u00AB' | '\\'' ) ) | ~ ( ( '\\u00AB' | '\\'' ) ) )
            int alt32=3;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='\'') ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1=='\'') ) {
                    alt32=1;
                }
                else if ( ((LA32_1>='\u0000' && LA32_1<='&')||(LA32_1>='(' && LA32_1<='\u00AA')||(LA32_1>='\u00AC' && LA32_1<='\uFFFF')) ) {
                    alt32=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA32_0>='\u0000' && LA32_0<='&')||(LA32_0>='(' && LA32_0<='\u00AA')||(LA32_0>='\u00AC' && LA32_0<='\uFFFF')) ) {
                alt32=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9889:33: '\\'\\'' ~ ( ( '\\u00AB' | '\\'' ) )
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
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9889:59: '\\'' ~ ( ( '\\u00AB' | '\\'' ) )
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
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9889:83: ~ ( ( '\\u00AB' | '\\'' ) )
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

    // $ANTLR start "RULE_IDENTIFIER_START"
    public final void mRULE_IDENTIFIER_START() throws RecognitionException {
        try {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9891:32: ( ( '$' | 'A' .. 'Z' | '_' | 'a' .. 'z' | '\\u00A2' .. '\\u00A5' | '\\u00AA' | '\\u00B5' | '\\u00BA' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u0236' | '\\u0250' .. '\\u02C1' | '\\u02C6' .. '\\u02D1' | '\\u02E0' .. '\\u02E4' | '\\u02EE' | '\\u037A' | '\\u0386' | '\\u0388' .. '\\u038A' | '\\u038C' | '\\u038E' .. '\\u03A1' | '\\u03A3' .. '\\u03CE' | '\\u03D0' .. '\\u03F5' | '\\u03F7' .. '\\u03FB' | '\\u0400' .. '\\u0481' | '\\u048A' .. '\\u04CE' | '\\u04D0' .. '\\u04F5' | '\\u04F8' .. '\\u04F9' | '\\u0500' .. '\\u050F' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u05D0' .. '\\u05EA' | '\\u05F0' .. '\\u05F2' | '\\u0621' .. '\\u063A' | '\\u0640' .. '\\u064A' | '\\u066E' .. '\\u066F' | '\\u0671' .. '\\u06D3' | '\\u06D5' | '\\u06E5' .. '\\u06E6' | '\\u06EE' .. '\\u06EF' | '\\u06FA' .. '\\u06FC' | '\\u06FF' | '\\u0710' | '\\u0712' .. '\\u072F' | '\\u074D' .. '\\u074F' | '\\u0780' .. '\\u07A5' | '\\u07B1' | '\\u0904' .. '\\u0939' | '\\u093D' | '\\u0950' | '\\u0958' .. '\\u0961' | '\\u0985' .. '\\u098C' | '\\u098F' .. '\\u0990' | '\\u0993' .. '\\u09A8' | '\\u09AA' .. '\\u09B0' | '\\u09B2' | '\\u09B6' .. '\\u09B9' | '\\u09BD' | '\\u09DC' .. '\\u09DD' | '\\u09DF' .. '\\u09E1' | '\\u09F0' .. '\\u09F3' | '\\u0A05' .. '\\u0A0A' | '\\u0A0F' .. '\\u0A10' | '\\u0A13' .. '\\u0A28' | '\\u0A2A' .. '\\u0A30' | '\\u0A32' .. '\\u0A33' | '\\u0A35' .. '\\u0A36' | '\\u0A38' .. '\\u0A39' | '\\u0A59' .. '\\u0A5C' | '\\u0A5E' | '\\u0A72' .. '\\u0A74' | '\\u0A85' .. '\\u0A8D' | '\\u0A8F' .. '\\u0A91' | '\\u0A93' .. '\\u0AA8' | '\\u0AAA' .. '\\u0AB0' | '\\u0AB2' .. '\\u0AB3' | '\\u0AB5' .. '\\u0AB9' | '\\u0ABD' | '\\u0AD0' | '\\u0AE0' .. '\\u0AE1' | '\\u0AF1' | '\\u0B05' .. '\\u0B0C' | '\\u0B0F' .. '\\u0B10' | '\\u0B13' .. '\\u0B28' | '\\u0B2A' .. '\\u0B30' | '\\u0B32' .. '\\u0B33' | '\\u0B35' .. '\\u0B39' | '\\u0B3D' | '\\u0B5C' .. '\\u0B5D' | '\\u0B5F' .. '\\u0B61' | '\\u0B71' | '\\u0B83' | '\\u0B85' .. '\\u0B8A' | '\\u0B8E' .. '\\u0B90' | '\\u0B92' .. '\\u0B95' | '\\u0B99' .. '\\u0B9A' | '\\u0B9C' | '\\u0B9E' .. '\\u0B9F' | '\\u0BA3' .. '\\u0BA4' | '\\u0BA8' .. '\\u0BAA' | '\\u0BAE' .. '\\u0BB5' | '\\u0BB7' .. '\\u0BB9' | '\\u0BF9' | '\\u0C05' .. '\\u0C0C' | '\\u0C0E' .. '\\u0C10' | '\\u0C12' .. '\\u0C28' | '\\u0C2A' .. '\\u0C33' | '\\u0C35' .. '\\u0C39' | '\\u0C60' .. '\\u0C61' | '\\u0C85' .. '\\u0C8C' | '\\u0C8E' .. '\\u0C90' | '\\u0C92' .. '\\u0CA8' | '\\u0CAA' .. '\\u0CB3' | '\\u0CB5' .. '\\u0CB9' | '\\u0CBD' | '\\u0CDE' | '\\u0CE0' .. '\\u0CE1' | '\\u0D05' .. '\\u0D0C' | '\\u0D0E' .. '\\u0D10' | '\\u0D12' .. '\\u0D28' | '\\u0D2A' .. '\\u0D39' | '\\u0D60' .. '\\u0D61' | '\\u0D85' .. '\\u0D96' | '\\u0D9A' .. '\\u0DB1' | '\\u0DB3' .. '\\u0DBB' | '\\u0DBD' | '\\u0DC0' .. '\\u0DC6' | '\\u0E01' .. '\\u0E30' | '\\u0E32' .. '\\u0E33' | '\\u0E3F' .. '\\u0E46' | '\\u0E81' .. '\\u0E82' | '\\u0E84' | '\\u0E87' .. '\\u0E88' | '\\u0E8A' | '\\u0E8D' | '\\u0E94' .. '\\u0E97' | '\\u0E99' .. '\\u0E9F' | '\\u0EA1' .. '\\u0EA3' | '\\u0EA5' | '\\u0EA7' | '\\u0EAA' .. '\\u0EAB' | '\\u0EAD' .. '\\u0EB0' | '\\u0EB2' .. '\\u0EB3' | '\\u0EBD' | '\\u0EC0' .. '\\u0EC4' | '\\u0EC6' | '\\u0EDC' .. '\\u0EDD' | '\\u0F00' | '\\u0F40' .. '\\u0F47' | '\\u0F49' .. '\\u0F6A' | '\\u0F88' .. '\\u0F8B' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102A' | '\\u1050' .. '\\u1055' | '\\u10A0' .. '\\u10C5' | '\\u10D0' .. '\\u10F8' | '\\u1100' .. '\\u1159' | '\\u115F' .. '\\u11A2' | '\\u11A8' .. '\\u11F9' | '\\u1200' .. '\\u1206' | '\\u1208' .. '\\u1246' | '\\u1248' | '\\u124A' .. '\\u124D' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125A' .. '\\u125D' | '\\u1260' .. '\\u1286' | '\\u1288' | '\\u128A' .. '\\u128D' | '\\u1290' .. '\\u12AE' | '\\u12B0' | '\\u12B2' .. '\\u12B5' | '\\u12B8' .. '\\u12BE' | '\\u12C0' | '\\u12C2' .. '\\u12C5' | '\\u12C8' .. '\\u12CE' | '\\u12D0' .. '\\u12D6' | '\\u12D8' .. '\\u12EE' | '\\u12F0' .. '\\u130E' | '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u131E' | '\\u1320' .. '\\u1346' | '\\u1348' .. '\\u135A' | '\\u13A0' .. '\\u13F4' | '\\u1401' .. '\\u166C' | '\\u166F' .. '\\u1676' | '\\u1681' .. '\\u169A' | '\\u16A0' .. '\\u16EA' | '\\u16EE' .. '\\u16F0' | '\\u1700' .. '\\u170C' | '\\u170E' .. '\\u1711' | '\\u1720' .. '\\u1731' | '\\u1740' .. '\\u1751' | '\\u1760' .. '\\u176C' | '\\u176E' .. '\\u1770' | '\\u1780' .. '\\u17B3' | '\\u17D7' | '\\u17DB' .. '\\u17DC' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18A8' | '\\u1900' .. '\\u191C' | '\\u1950' .. '\\u196D' | '\\u1970' .. '\\u1974' | '\\u1D00' .. '\\u1D6B' | '\\u1E00' .. '\\u1E9B' | '\\u1EA0' .. '\\u1EF9' | '\\u1F00' .. '\\u1F15' | '\\u1F18' .. '\\u1F1D' | '\\u1F20' .. '\\u1F45' | '\\u1F48' .. '\\u1F4D' | '\\u1F50' .. '\\u1F57' | '\\u1F59' | '\\u1F5B' | '\\u1F5D' | '\\u1F5F' .. '\\u1F7D' | '\\u1F80' .. '\\u1FB4' | '\\u1FB6' .. '\\u1FBC' | '\\u1FBE' | '\\u1FC2' .. '\\u1FC4' | '\\u1FC6' .. '\\u1FCC' | '\\u1FD0' .. '\\u1FD3' | '\\u1FD6' .. '\\u1FDB' | '\\u1FE0' .. '\\u1FEC' | '\\u1FF2' .. '\\u1FF4' | '\\u1FF6' .. '\\u1FFC' | '\\u203F' .. '\\u2040' | '\\u2054' | '\\u2071' | '\\u207F' | '\\u20A0' .. '\\u20B1' | '\\u2102' | '\\u2107' | '\\u210A' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211D' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212A' .. '\\u212D' | '\\u212F' .. '\\u2131' | '\\u2133' .. '\\u2139' | '\\u213D' .. '\\u213F' | '\\u2145' .. '\\u2149' | '\\u2160' .. '\\u2183' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u3029' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303C' | '\\u3041' .. '\\u3096' | '\\u309D' .. '\\u309F' | '\\u30A1' .. '\\u30FF' | '\\u3105' .. '\\u312C' | '\\u3131' .. '\\u318E' | '\\u31A0' .. '\\u31B7' | '\\u31F0' .. '\\u31FF' | '\\u3400' .. '\\u4DB5' | '\\u4E00' .. '\\u9FA5' | '\\uA000' .. '\\uA48C' | '\\uAC00' .. '\\uD7A3' | '\\uF900' .. '\\uFA2D' | '\\uFA30' .. '\\uFA6A' | '\\uFB00' .. '\\uFB06' | '\\uFB13' .. '\\uFB17' | '\\uFB1D' | '\\uFB1F' .. '\\uFB28' | '\\uFB2A' .. '\\uFB36' | '\\uFB38' .. '\\uFB3C' | '\\uFB3E' | '\\uFB40' .. '\\uFB41' | '\\uFB43' .. '\\uFB44' | '\\uFB46' .. '\\uFBB1' | '\\uFBD3' .. '\\uFD3D' | '\\uFD50' .. '\\uFD8F' | '\\uFD92' .. '\\uFDC7' | '\\uFDF0' .. '\\uFDFC' | '\\uFE33' .. '\\uFE34' | '\\uFE4D' .. '\\uFE4F' | '\\uFE69' | '\\uFE70' .. '\\uFE74' | '\\uFE76' .. '\\uFEFC' | '\\uFF04' | '\\uFF21' .. '\\uFF3A' | '\\uFF3F' | '\\uFF41' .. '\\uFF5A' | '\\uFF65' .. '\\uFFBE' | '\\uFFC2' .. '\\uFFC7' | '\\uFFCA' .. '\\uFFCF' | '\\uFFD2' .. '\\uFFD7' | '\\uFFDA' .. '\\uFFDC' | '\\uFFE0' .. '\\uFFE1' | '\\uFFE5' .. '\\uFFE6' ) )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9891:34: ( '$' | 'A' .. 'Z' | '_' | 'a' .. 'z' | '\\u00A2' .. '\\u00A5' | '\\u00AA' | '\\u00B5' | '\\u00BA' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u0236' | '\\u0250' .. '\\u02C1' | '\\u02C6' .. '\\u02D1' | '\\u02E0' .. '\\u02E4' | '\\u02EE' | '\\u037A' | '\\u0386' | '\\u0388' .. '\\u038A' | '\\u038C' | '\\u038E' .. '\\u03A1' | '\\u03A3' .. '\\u03CE' | '\\u03D0' .. '\\u03F5' | '\\u03F7' .. '\\u03FB' | '\\u0400' .. '\\u0481' | '\\u048A' .. '\\u04CE' | '\\u04D0' .. '\\u04F5' | '\\u04F8' .. '\\u04F9' | '\\u0500' .. '\\u050F' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u05D0' .. '\\u05EA' | '\\u05F0' .. '\\u05F2' | '\\u0621' .. '\\u063A' | '\\u0640' .. '\\u064A' | '\\u066E' .. '\\u066F' | '\\u0671' .. '\\u06D3' | '\\u06D5' | '\\u06E5' .. '\\u06E6' | '\\u06EE' .. '\\u06EF' | '\\u06FA' .. '\\u06FC' | '\\u06FF' | '\\u0710' | '\\u0712' .. '\\u072F' | '\\u074D' .. '\\u074F' | '\\u0780' .. '\\u07A5' | '\\u07B1' | '\\u0904' .. '\\u0939' | '\\u093D' | '\\u0950' | '\\u0958' .. '\\u0961' | '\\u0985' .. '\\u098C' | '\\u098F' .. '\\u0990' | '\\u0993' .. '\\u09A8' | '\\u09AA' .. '\\u09B0' | '\\u09B2' | '\\u09B6' .. '\\u09B9' | '\\u09BD' | '\\u09DC' .. '\\u09DD' | '\\u09DF' .. '\\u09E1' | '\\u09F0' .. '\\u09F3' | '\\u0A05' .. '\\u0A0A' | '\\u0A0F' .. '\\u0A10' | '\\u0A13' .. '\\u0A28' | '\\u0A2A' .. '\\u0A30' | '\\u0A32' .. '\\u0A33' | '\\u0A35' .. '\\u0A36' | '\\u0A38' .. '\\u0A39' | '\\u0A59' .. '\\u0A5C' | '\\u0A5E' | '\\u0A72' .. '\\u0A74' | '\\u0A85' .. '\\u0A8D' | '\\u0A8F' .. '\\u0A91' | '\\u0A93' .. '\\u0AA8' | '\\u0AAA' .. '\\u0AB0' | '\\u0AB2' .. '\\u0AB3' | '\\u0AB5' .. '\\u0AB9' | '\\u0ABD' | '\\u0AD0' | '\\u0AE0' .. '\\u0AE1' | '\\u0AF1' | '\\u0B05' .. '\\u0B0C' | '\\u0B0F' .. '\\u0B10' | '\\u0B13' .. '\\u0B28' | '\\u0B2A' .. '\\u0B30' | '\\u0B32' .. '\\u0B33' | '\\u0B35' .. '\\u0B39' | '\\u0B3D' | '\\u0B5C' .. '\\u0B5D' | '\\u0B5F' .. '\\u0B61' | '\\u0B71' | '\\u0B83' | '\\u0B85' .. '\\u0B8A' | '\\u0B8E' .. '\\u0B90' | '\\u0B92' .. '\\u0B95' | '\\u0B99' .. '\\u0B9A' | '\\u0B9C' | '\\u0B9E' .. '\\u0B9F' | '\\u0BA3' .. '\\u0BA4' | '\\u0BA8' .. '\\u0BAA' | '\\u0BAE' .. '\\u0BB5' | '\\u0BB7' .. '\\u0BB9' | '\\u0BF9' | '\\u0C05' .. '\\u0C0C' | '\\u0C0E' .. '\\u0C10' | '\\u0C12' .. '\\u0C28' | '\\u0C2A' .. '\\u0C33' | '\\u0C35' .. '\\u0C39' | '\\u0C60' .. '\\u0C61' | '\\u0C85' .. '\\u0C8C' | '\\u0C8E' .. '\\u0C90' | '\\u0C92' .. '\\u0CA8' | '\\u0CAA' .. '\\u0CB3' | '\\u0CB5' .. '\\u0CB9' | '\\u0CBD' | '\\u0CDE' | '\\u0CE0' .. '\\u0CE1' | '\\u0D05' .. '\\u0D0C' | '\\u0D0E' .. '\\u0D10' | '\\u0D12' .. '\\u0D28' | '\\u0D2A' .. '\\u0D39' | '\\u0D60' .. '\\u0D61' | '\\u0D85' .. '\\u0D96' | '\\u0D9A' .. '\\u0DB1' | '\\u0DB3' .. '\\u0DBB' | '\\u0DBD' | '\\u0DC0' .. '\\u0DC6' | '\\u0E01' .. '\\u0E30' | '\\u0E32' .. '\\u0E33' | '\\u0E3F' .. '\\u0E46' | '\\u0E81' .. '\\u0E82' | '\\u0E84' | '\\u0E87' .. '\\u0E88' | '\\u0E8A' | '\\u0E8D' | '\\u0E94' .. '\\u0E97' | '\\u0E99' .. '\\u0E9F' | '\\u0EA1' .. '\\u0EA3' | '\\u0EA5' | '\\u0EA7' | '\\u0EAA' .. '\\u0EAB' | '\\u0EAD' .. '\\u0EB0' | '\\u0EB2' .. '\\u0EB3' | '\\u0EBD' | '\\u0EC0' .. '\\u0EC4' | '\\u0EC6' | '\\u0EDC' .. '\\u0EDD' | '\\u0F00' | '\\u0F40' .. '\\u0F47' | '\\u0F49' .. '\\u0F6A' | '\\u0F88' .. '\\u0F8B' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102A' | '\\u1050' .. '\\u1055' | '\\u10A0' .. '\\u10C5' | '\\u10D0' .. '\\u10F8' | '\\u1100' .. '\\u1159' | '\\u115F' .. '\\u11A2' | '\\u11A8' .. '\\u11F9' | '\\u1200' .. '\\u1206' | '\\u1208' .. '\\u1246' | '\\u1248' | '\\u124A' .. '\\u124D' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125A' .. '\\u125D' | '\\u1260' .. '\\u1286' | '\\u1288' | '\\u128A' .. '\\u128D' | '\\u1290' .. '\\u12AE' | '\\u12B0' | '\\u12B2' .. '\\u12B5' | '\\u12B8' .. '\\u12BE' | '\\u12C0' | '\\u12C2' .. '\\u12C5' | '\\u12C8' .. '\\u12CE' | '\\u12D0' .. '\\u12D6' | '\\u12D8' .. '\\u12EE' | '\\u12F0' .. '\\u130E' | '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u131E' | '\\u1320' .. '\\u1346' | '\\u1348' .. '\\u135A' | '\\u13A0' .. '\\u13F4' | '\\u1401' .. '\\u166C' | '\\u166F' .. '\\u1676' | '\\u1681' .. '\\u169A' | '\\u16A0' .. '\\u16EA' | '\\u16EE' .. '\\u16F0' | '\\u1700' .. '\\u170C' | '\\u170E' .. '\\u1711' | '\\u1720' .. '\\u1731' | '\\u1740' .. '\\u1751' | '\\u1760' .. '\\u176C' | '\\u176E' .. '\\u1770' | '\\u1780' .. '\\u17B3' | '\\u17D7' | '\\u17DB' .. '\\u17DC' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18A8' | '\\u1900' .. '\\u191C' | '\\u1950' .. '\\u196D' | '\\u1970' .. '\\u1974' | '\\u1D00' .. '\\u1D6B' | '\\u1E00' .. '\\u1E9B' | '\\u1EA0' .. '\\u1EF9' | '\\u1F00' .. '\\u1F15' | '\\u1F18' .. '\\u1F1D' | '\\u1F20' .. '\\u1F45' | '\\u1F48' .. '\\u1F4D' | '\\u1F50' .. '\\u1F57' | '\\u1F59' | '\\u1F5B' | '\\u1F5D' | '\\u1F5F' .. '\\u1F7D' | '\\u1F80' .. '\\u1FB4' | '\\u1FB6' .. '\\u1FBC' | '\\u1FBE' | '\\u1FC2' .. '\\u1FC4' | '\\u1FC6' .. '\\u1FCC' | '\\u1FD0' .. '\\u1FD3' | '\\u1FD6' .. '\\u1FDB' | '\\u1FE0' .. '\\u1FEC' | '\\u1FF2' .. '\\u1FF4' | '\\u1FF6' .. '\\u1FFC' | '\\u203F' .. '\\u2040' | '\\u2054' | '\\u2071' | '\\u207F' | '\\u20A0' .. '\\u20B1' | '\\u2102' | '\\u2107' | '\\u210A' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211D' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212A' .. '\\u212D' | '\\u212F' .. '\\u2131' | '\\u2133' .. '\\u2139' | '\\u213D' .. '\\u213F' | '\\u2145' .. '\\u2149' | '\\u2160' .. '\\u2183' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u3029' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303C' | '\\u3041' .. '\\u3096' | '\\u309D' .. '\\u309F' | '\\u30A1' .. '\\u30FF' | '\\u3105' .. '\\u312C' | '\\u3131' .. '\\u318E' | '\\u31A0' .. '\\u31B7' | '\\u31F0' .. '\\u31FF' | '\\u3400' .. '\\u4DB5' | '\\u4E00' .. '\\u9FA5' | '\\uA000' .. '\\uA48C' | '\\uAC00' .. '\\uD7A3' | '\\uF900' .. '\\uFA2D' | '\\uFA30' .. '\\uFA6A' | '\\uFB00' .. '\\uFB06' | '\\uFB13' .. '\\uFB17' | '\\uFB1D' | '\\uFB1F' .. '\\uFB28' | '\\uFB2A' .. '\\uFB36' | '\\uFB38' .. '\\uFB3C' | '\\uFB3E' | '\\uFB40' .. '\\uFB41' | '\\uFB43' .. '\\uFB44' | '\\uFB46' .. '\\uFBB1' | '\\uFBD3' .. '\\uFD3D' | '\\uFD50' .. '\\uFD8F' | '\\uFD92' .. '\\uFDC7' | '\\uFDF0' .. '\\uFDFC' | '\\uFE33' .. '\\uFE34' | '\\uFE4D' .. '\\uFE4F' | '\\uFE69' | '\\uFE70' .. '\\uFE74' | '\\uFE76' .. '\\uFEFC' | '\\uFF04' | '\\uFF21' .. '\\uFF3A' | '\\uFF3F' | '\\uFF41' .. '\\uFF5A' | '\\uFF65' .. '\\uFFBE' | '\\uFFC2' .. '\\uFFC7' | '\\uFFCA' .. '\\uFFCF' | '\\uFFD2' .. '\\uFFD7' | '\\uFFDA' .. '\\uFFDC' | '\\uFFE0' .. '\\uFFE1' | '\\uFFE5' .. '\\uFFE6' )
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00A2' && input.LA(1)<='\u00A5')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u0236')||(input.LA(1)>='\u0250' && input.LA(1)<='\u02C1')||(input.LA(1)>='\u02C6' && input.LA(1)<='\u02D1')||(input.LA(1)>='\u02E0' && input.LA(1)<='\u02E4')||input.LA(1)=='\u02EE'||input.LA(1)=='\u037A'||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE')||(input.LA(1)>='\u03D0' && input.LA(1)<='\u03F5')||(input.LA(1)>='\u03F7' && input.LA(1)<='\u03FB')||(input.LA(1)>='\u0400' && input.LA(1)<='\u0481')||(input.LA(1)>='\u048A' && input.LA(1)<='\u04CE')||(input.LA(1)>='\u04D0' && input.LA(1)<='\u04F5')||(input.LA(1)>='\u04F8' && input.LA(1)<='\u04F9')||(input.LA(1)>='\u0500' && input.LA(1)<='\u050F')||(input.LA(1)>='\u0531' && input.LA(1)<='\u0556')||input.LA(1)=='\u0559'||(input.LA(1)>='\u0561' && input.LA(1)<='\u0587')||(input.LA(1)>='\u05D0' && input.LA(1)<='\u05EA')||(input.LA(1)>='\u05F0' && input.LA(1)<='\u05F2')||(input.LA(1)>='\u0621' && input.LA(1)<='\u063A')||(input.LA(1)>='\u0640' && input.LA(1)<='\u064A')||(input.LA(1)>='\u066E' && input.LA(1)<='\u066F')||(input.LA(1)>='\u0671' && input.LA(1)<='\u06D3')||input.LA(1)=='\u06D5'||(input.LA(1)>='\u06E5' && input.LA(1)<='\u06E6')||(input.LA(1)>='\u06EE' && input.LA(1)<='\u06EF')||(input.LA(1)>='\u06FA' && input.LA(1)<='\u06FC')||input.LA(1)=='\u06FF'||input.LA(1)=='\u0710'||(input.LA(1)>='\u0712' && input.LA(1)<='\u072F')||(input.LA(1)>='\u074D' && input.LA(1)<='\u074F')||(input.LA(1)>='\u0780' && input.LA(1)<='\u07A5')||input.LA(1)=='\u07B1'||(input.LA(1)>='\u0904' && input.LA(1)<='\u0939')||input.LA(1)=='\u093D'||input.LA(1)=='\u0950'||(input.LA(1)>='\u0958' && input.LA(1)<='\u0961')||(input.LA(1)>='\u0985' && input.LA(1)<='\u098C')||(input.LA(1)>='\u098F' && input.LA(1)<='\u0990')||(input.LA(1)>='\u0993' && input.LA(1)<='\u09A8')||(input.LA(1)>='\u09AA' && input.LA(1)<='\u09B0')||input.LA(1)=='\u09B2'||(input.LA(1)>='\u09B6' && input.LA(1)<='\u09B9')||input.LA(1)=='\u09BD'||(input.LA(1)>='\u09DC' && input.LA(1)<='\u09DD')||(input.LA(1)>='\u09DF' && input.LA(1)<='\u09E1')||(input.LA(1)>='\u09F0' && input.LA(1)<='\u09F3')||(input.LA(1)>='\u0A05' && input.LA(1)<='\u0A0A')||(input.LA(1)>='\u0A0F' && input.LA(1)<='\u0A10')||(input.LA(1)>='\u0A13' && input.LA(1)<='\u0A28')||(input.LA(1)>='\u0A2A' && input.LA(1)<='\u0A30')||(input.LA(1)>='\u0A32' && input.LA(1)<='\u0A33')||(input.LA(1)>='\u0A35' && input.LA(1)<='\u0A36')||(input.LA(1)>='\u0A38' && input.LA(1)<='\u0A39')||(input.LA(1)>='\u0A59' && input.LA(1)<='\u0A5C')||input.LA(1)=='\u0A5E'||(input.LA(1)>='\u0A72' && input.LA(1)<='\u0A74')||(input.LA(1)>='\u0A85' && input.LA(1)<='\u0A8D')||(input.LA(1)>='\u0A8F' && input.LA(1)<='\u0A91')||(input.LA(1)>='\u0A93' && input.LA(1)<='\u0AA8')||(input.LA(1)>='\u0AAA' && input.LA(1)<='\u0AB0')||(input.LA(1)>='\u0AB2' && input.LA(1)<='\u0AB3')||(input.LA(1)>='\u0AB5' && input.LA(1)<='\u0AB9')||input.LA(1)=='\u0ABD'||input.LA(1)=='\u0AD0'||(input.LA(1)>='\u0AE0' && input.LA(1)<='\u0AE1')||input.LA(1)=='\u0AF1'||(input.LA(1)>='\u0B05' && input.LA(1)<='\u0B0C')||(input.LA(1)>='\u0B0F' && input.LA(1)<='\u0B10')||(input.LA(1)>='\u0B13' && input.LA(1)<='\u0B28')||(input.LA(1)>='\u0B2A' && input.LA(1)<='\u0B30')||(input.LA(1)>='\u0B32' && input.LA(1)<='\u0B33')||(input.LA(1)>='\u0B35' && input.LA(1)<='\u0B39')||input.LA(1)=='\u0B3D'||(input.LA(1)>='\u0B5C' && input.LA(1)<='\u0B5D')||(input.LA(1)>='\u0B5F' && input.LA(1)<='\u0B61')||input.LA(1)=='\u0B71'||input.LA(1)=='\u0B83'||(input.LA(1)>='\u0B85' && input.LA(1)<='\u0B8A')||(input.LA(1)>='\u0B8E' && input.LA(1)<='\u0B90')||(input.LA(1)>='\u0B92' && input.LA(1)<='\u0B95')||(input.LA(1)>='\u0B99' && input.LA(1)<='\u0B9A')||input.LA(1)=='\u0B9C'||(input.LA(1)>='\u0B9E' && input.LA(1)<='\u0B9F')||(input.LA(1)>='\u0BA3' && input.LA(1)<='\u0BA4')||(input.LA(1)>='\u0BA8' && input.LA(1)<='\u0BAA')||(input.LA(1)>='\u0BAE' && input.LA(1)<='\u0BB5')||(input.LA(1)>='\u0BB7' && input.LA(1)<='\u0BB9')||input.LA(1)=='\u0BF9'||(input.LA(1)>='\u0C05' && input.LA(1)<='\u0C0C')||(input.LA(1)>='\u0C0E' && input.LA(1)<='\u0C10')||(input.LA(1)>='\u0C12' && input.LA(1)<='\u0C28')||(input.LA(1)>='\u0C2A' && input.LA(1)<='\u0C33')||(input.LA(1)>='\u0C35' && input.LA(1)<='\u0C39')||(input.LA(1)>='\u0C60' && input.LA(1)<='\u0C61')||(input.LA(1)>='\u0C85' && input.LA(1)<='\u0C8C')||(input.LA(1)>='\u0C8E' && input.LA(1)<='\u0C90')||(input.LA(1)>='\u0C92' && input.LA(1)<='\u0CA8')||(input.LA(1)>='\u0CAA' && input.LA(1)<='\u0CB3')||(input.LA(1)>='\u0CB5' && input.LA(1)<='\u0CB9')||input.LA(1)=='\u0CBD'||input.LA(1)=='\u0CDE'||(input.LA(1)>='\u0CE0' && input.LA(1)<='\u0CE1')||(input.LA(1)>='\u0D05' && input.LA(1)<='\u0D0C')||(input.LA(1)>='\u0D0E' && input.LA(1)<='\u0D10')||(input.LA(1)>='\u0D12' && input.LA(1)<='\u0D28')||(input.LA(1)>='\u0D2A' && input.LA(1)<='\u0D39')||(input.LA(1)>='\u0D60' && input.LA(1)<='\u0D61')||(input.LA(1)>='\u0D85' && input.LA(1)<='\u0D96')||(input.LA(1)>='\u0D9A' && input.LA(1)<='\u0DB1')||(input.LA(1)>='\u0DB3' && input.LA(1)<='\u0DBB')||input.LA(1)=='\u0DBD'||(input.LA(1)>='\u0DC0' && input.LA(1)<='\u0DC6')||(input.LA(1)>='\u0E01' && input.LA(1)<='\u0E30')||(input.LA(1)>='\u0E32' && input.LA(1)<='\u0E33')||(input.LA(1)>='\u0E3F' && input.LA(1)<='\u0E46')||(input.LA(1)>='\u0E81' && input.LA(1)<='\u0E82')||input.LA(1)=='\u0E84'||(input.LA(1)>='\u0E87' && input.LA(1)<='\u0E88')||input.LA(1)=='\u0E8A'||input.LA(1)=='\u0E8D'||(input.LA(1)>='\u0E94' && input.LA(1)<='\u0E97')||(input.LA(1)>='\u0E99' && input.LA(1)<='\u0E9F')||(input.LA(1)>='\u0EA1' && input.LA(1)<='\u0EA3')||input.LA(1)=='\u0EA5'||input.LA(1)=='\u0EA7'||(input.LA(1)>='\u0EAA' && input.LA(1)<='\u0EAB')||(input.LA(1)>='\u0EAD' && input.LA(1)<='\u0EB0')||(input.LA(1)>='\u0EB2' && input.LA(1)<='\u0EB3')||input.LA(1)=='\u0EBD'||(input.LA(1)>='\u0EC0' && input.LA(1)<='\u0EC4')||input.LA(1)=='\u0EC6'||(input.LA(1)>='\u0EDC' && input.LA(1)<='\u0EDD')||input.LA(1)=='\u0F00'||(input.LA(1)>='\u0F40' && input.LA(1)<='\u0F47')||(input.LA(1)>='\u0F49' && input.LA(1)<='\u0F6A')||(input.LA(1)>='\u0F88' && input.LA(1)<='\u0F8B')||(input.LA(1)>='\u1000' && input.LA(1)<='\u1021')||(input.LA(1)>='\u1023' && input.LA(1)<='\u1027')||(input.LA(1)>='\u1029' && input.LA(1)<='\u102A')||(input.LA(1)>='\u1050' && input.LA(1)<='\u1055')||(input.LA(1)>='\u10A0' && input.LA(1)<='\u10C5')||(input.LA(1)>='\u10D0' && input.LA(1)<='\u10F8')||(input.LA(1)>='\u1100' && input.LA(1)<='\u1159')||(input.LA(1)>='\u115F' && input.LA(1)<='\u11A2')||(input.LA(1)>='\u11A8' && input.LA(1)<='\u11F9')||(input.LA(1)>='\u1200' && input.LA(1)<='\u1206')||(input.LA(1)>='\u1208' && input.LA(1)<='\u1246')||input.LA(1)=='\u1248'||(input.LA(1)>='\u124A' && input.LA(1)<='\u124D')||(input.LA(1)>='\u1250' && input.LA(1)<='\u1256')||input.LA(1)=='\u1258'||(input.LA(1)>='\u125A' && input.LA(1)<='\u125D')||(input.LA(1)>='\u1260' && input.LA(1)<='\u1286')||input.LA(1)=='\u1288'||(input.LA(1)>='\u128A' && input.LA(1)<='\u128D')||(input.LA(1)>='\u1290' && input.LA(1)<='\u12AE')||input.LA(1)=='\u12B0'||(input.LA(1)>='\u12B2' && input.LA(1)<='\u12B5')||(input.LA(1)>='\u12B8' && input.LA(1)<='\u12BE')||input.LA(1)=='\u12C0'||(input.LA(1)>='\u12C2' && input.LA(1)<='\u12C5')||(input.LA(1)>='\u12C8' && input.LA(1)<='\u12CE')||(input.LA(1)>='\u12D0' && input.LA(1)<='\u12D6')||(input.LA(1)>='\u12D8' && input.LA(1)<='\u12EE')||(input.LA(1)>='\u12F0' && input.LA(1)<='\u130E')||input.LA(1)=='\u1310'||(input.LA(1)>='\u1312' && input.LA(1)<='\u1315')||(input.LA(1)>='\u1318' && input.LA(1)<='\u131E')||(input.LA(1)>='\u1320' && input.LA(1)<='\u1346')||(input.LA(1)>='\u1348' && input.LA(1)<='\u135A')||(input.LA(1)>='\u13A0' && input.LA(1)<='\u13F4')||(input.LA(1)>='\u1401' && input.LA(1)<='\u166C')||(input.LA(1)>='\u166F' && input.LA(1)<='\u1676')||(input.LA(1)>='\u1681' && input.LA(1)<='\u169A')||(input.LA(1)>='\u16A0' && input.LA(1)<='\u16EA')||(input.LA(1)>='\u16EE' && input.LA(1)<='\u16F0')||(input.LA(1)>='\u1700' && input.LA(1)<='\u170C')||(input.LA(1)>='\u170E' && input.LA(1)<='\u1711')||(input.LA(1)>='\u1720' && input.LA(1)<='\u1731')||(input.LA(1)>='\u1740' && input.LA(1)<='\u1751')||(input.LA(1)>='\u1760' && input.LA(1)<='\u176C')||(input.LA(1)>='\u176E' && input.LA(1)<='\u1770')||(input.LA(1)>='\u1780' && input.LA(1)<='\u17B3')||input.LA(1)=='\u17D7'||(input.LA(1)>='\u17DB' && input.LA(1)<='\u17DC')||(input.LA(1)>='\u1820' && input.LA(1)<='\u1877')||(input.LA(1)>='\u1880' && input.LA(1)<='\u18A8')||(input.LA(1)>='\u1900' && input.LA(1)<='\u191C')||(input.LA(1)>='\u1950' && input.LA(1)<='\u196D')||(input.LA(1)>='\u1970' && input.LA(1)<='\u1974')||(input.LA(1)>='\u1D00' && input.LA(1)<='\u1D6B')||(input.LA(1)>='\u1E00' && input.LA(1)<='\u1E9B')||(input.LA(1)>='\u1EA0' && input.LA(1)<='\u1EF9')||(input.LA(1)>='\u1F00' && input.LA(1)<='\u1F15')||(input.LA(1)>='\u1F18' && input.LA(1)<='\u1F1D')||(input.LA(1)>='\u1F20' && input.LA(1)<='\u1F45')||(input.LA(1)>='\u1F48' && input.LA(1)<='\u1F4D')||(input.LA(1)>='\u1F50' && input.LA(1)<='\u1F57')||input.LA(1)=='\u1F59'||input.LA(1)=='\u1F5B'||input.LA(1)=='\u1F5D'||(input.LA(1)>='\u1F5F' && input.LA(1)<='\u1F7D')||(input.LA(1)>='\u1F80' && input.LA(1)<='\u1FB4')||(input.LA(1)>='\u1FB6' && input.LA(1)<='\u1FBC')||input.LA(1)=='\u1FBE'||(input.LA(1)>='\u1FC2' && input.LA(1)<='\u1FC4')||(input.LA(1)>='\u1FC6' && input.LA(1)<='\u1FCC')||(input.LA(1)>='\u1FD0' && input.LA(1)<='\u1FD3')||(input.LA(1)>='\u1FD6' && input.LA(1)<='\u1FDB')||(input.LA(1)>='\u1FE0' && input.LA(1)<='\u1FEC')||(input.LA(1)>='\u1FF2' && input.LA(1)<='\u1FF4')||(input.LA(1)>='\u1FF6' && input.LA(1)<='\u1FFC')||(input.LA(1)>='\u203F' && input.LA(1)<='\u2040')||input.LA(1)=='\u2054'||input.LA(1)=='\u2071'||input.LA(1)=='\u207F'||(input.LA(1)>='\u20A0' && input.LA(1)<='\u20B1')||input.LA(1)=='\u2102'||input.LA(1)=='\u2107'||(input.LA(1)>='\u210A' && input.LA(1)<='\u2113')||input.LA(1)=='\u2115'||(input.LA(1)>='\u2119' && input.LA(1)<='\u211D')||input.LA(1)=='\u2124'||input.LA(1)=='\u2126'||input.LA(1)=='\u2128'||(input.LA(1)>='\u212A' && input.LA(1)<='\u212D')||(input.LA(1)>='\u212F' && input.LA(1)<='\u2131')||(input.LA(1)>='\u2133' && input.LA(1)<='\u2139')||(input.LA(1)>='\u213D' && input.LA(1)<='\u213F')||(input.LA(1)>='\u2145' && input.LA(1)<='\u2149')||(input.LA(1)>='\u2160' && input.LA(1)<='\u2183')||(input.LA(1)>='\u3005' && input.LA(1)<='\u3007')||(input.LA(1)>='\u3021' && input.LA(1)<='\u3029')||(input.LA(1)>='\u3031' && input.LA(1)<='\u3035')||(input.LA(1)>='\u3038' && input.LA(1)<='\u303C')||(input.LA(1)>='\u3041' && input.LA(1)<='\u3096')||(input.LA(1)>='\u309D' && input.LA(1)<='\u309F')||(input.LA(1)>='\u30A1' && input.LA(1)<='\u30FF')||(input.LA(1)>='\u3105' && input.LA(1)<='\u312C')||(input.LA(1)>='\u3131' && input.LA(1)<='\u318E')||(input.LA(1)>='\u31A0' && input.LA(1)<='\u31B7')||(input.LA(1)>='\u31F0' && input.LA(1)<='\u31FF')||(input.LA(1)>='\u3400' && input.LA(1)<='\u4DB5')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FA5')||(input.LA(1)>='\uA000' && input.LA(1)<='\uA48C')||(input.LA(1)>='\uAC00' && input.LA(1)<='\uD7A3')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFA2D')||(input.LA(1)>='\uFA30' && input.LA(1)<='\uFA6A')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFB06')||(input.LA(1)>='\uFB13' && input.LA(1)<='\uFB17')||input.LA(1)=='\uFB1D'||(input.LA(1)>='\uFB1F' && input.LA(1)<='\uFB28')||(input.LA(1)>='\uFB2A' && input.LA(1)<='\uFB36')||(input.LA(1)>='\uFB38' && input.LA(1)<='\uFB3C')||input.LA(1)=='\uFB3E'||(input.LA(1)>='\uFB40' && input.LA(1)<='\uFB41')||(input.LA(1)>='\uFB43' && input.LA(1)<='\uFB44')||(input.LA(1)>='\uFB46' && input.LA(1)<='\uFBB1')||(input.LA(1)>='\uFBD3' && input.LA(1)<='\uFD3D')||(input.LA(1)>='\uFD50' && input.LA(1)<='\uFD8F')||(input.LA(1)>='\uFD92' && input.LA(1)<='\uFDC7')||(input.LA(1)>='\uFDF0' && input.LA(1)<='\uFDFC')||(input.LA(1)>='\uFE33' && input.LA(1)<='\uFE34')||(input.LA(1)>='\uFE4D' && input.LA(1)<='\uFE4F')||input.LA(1)=='\uFE69'||(input.LA(1)>='\uFE70' && input.LA(1)<='\uFE74')||(input.LA(1)>='\uFE76' && input.LA(1)<='\uFEFC')||input.LA(1)=='\uFF04'||(input.LA(1)>='\uFF21' && input.LA(1)<='\uFF3A')||input.LA(1)=='\uFF3F'||(input.LA(1)>='\uFF41' && input.LA(1)<='\uFF5A')||(input.LA(1)>='\uFF65' && input.LA(1)<='\uFFBE')||(input.LA(1)>='\uFFC2' && input.LA(1)<='\uFFC7')||(input.LA(1)>='\uFFCA' && input.LA(1)<='\uFFCF')||(input.LA(1)>='\uFFD2' && input.LA(1)<='\uFFD7')||(input.LA(1)>='\uFFDA' && input.LA(1)<='\uFFDC')||(input.LA(1)>='\uFFE0' && input.LA(1)<='\uFFE1')||(input.LA(1)>='\uFFE5' && input.LA(1)<='\uFFE6') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_IDENTIFIER_START"

    // $ANTLR start "RULE_IDENTIFIER_PART"
    public final void mRULE_IDENTIFIER_PART() throws RecognitionException {
        try {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9893:31: ( ( RULE_IDENTIFIER_START | RULE_IDENTIFIER_PART_IMPL ) )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9893:33: ( RULE_IDENTIFIER_START | RULE_IDENTIFIER_PART_IMPL )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001B')||input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u007F' && input.LA(1)<='\u009F')||(input.LA(1)>='\u00A2' && input.LA(1)<='\u00A5')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00AD'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u0236')||(input.LA(1)>='\u0250' && input.LA(1)<='\u02C1')||(input.LA(1)>='\u02C6' && input.LA(1)<='\u02D1')||(input.LA(1)>='\u02E0' && input.LA(1)<='\u02E4')||input.LA(1)=='\u02EE'||(input.LA(1)>='\u0300' && input.LA(1)<='\u0357')||(input.LA(1)>='\u035D' && input.LA(1)<='\u036F')||input.LA(1)=='\u037A'||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE')||(input.LA(1)>='\u03D0' && input.LA(1)<='\u03F5')||(input.LA(1)>='\u03F7' && input.LA(1)<='\u03FB')||(input.LA(1)>='\u0400' && input.LA(1)<='\u0481')||(input.LA(1)>='\u0483' && input.LA(1)<='\u0486')||(input.LA(1)>='\u048A' && input.LA(1)<='\u04CE')||(input.LA(1)>='\u04D0' && input.LA(1)<='\u04F5')||(input.LA(1)>='\u04F8' && input.LA(1)<='\u04F9')||(input.LA(1)>='\u0500' && input.LA(1)<='\u050F')||(input.LA(1)>='\u0531' && input.LA(1)<='\u0556')||input.LA(1)=='\u0559'||(input.LA(1)>='\u0561' && input.LA(1)<='\u0587')||(input.LA(1)>='\u0591' && input.LA(1)<='\u05A1')||(input.LA(1)>='\u05A3' && input.LA(1)<='\u05B9')||(input.LA(1)>='\u05BB' && input.LA(1)<='\u05BD')||input.LA(1)=='\u05BF'||(input.LA(1)>='\u05C1' && input.LA(1)<='\u05C2')||input.LA(1)=='\u05C4'||(input.LA(1)>='\u05D0' && input.LA(1)<='\u05EA')||(input.LA(1)>='\u05F0' && input.LA(1)<='\u05F2')||(input.LA(1)>='\u0600' && input.LA(1)<='\u0603')||(input.LA(1)>='\u0610' && input.LA(1)<='\u0615')||(input.LA(1)>='\u0621' && input.LA(1)<='\u063A')||(input.LA(1)>='\u0640' && input.LA(1)<='\u0658')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u066E' && input.LA(1)<='\u06D3')||(input.LA(1)>='\u06D5' && input.LA(1)<='\u06DD')||(input.LA(1)>='\u06DF' && input.LA(1)<='\u06E8')||(input.LA(1)>='\u06EA' && input.LA(1)<='\u06FC')||input.LA(1)=='\u06FF'||(input.LA(1)>='\u070F' && input.LA(1)<='\u074A')||(input.LA(1)>='\u074D' && input.LA(1)<='\u074F')||(input.LA(1)>='\u0780' && input.LA(1)<='\u07B1')||(input.LA(1)>='\u0901' && input.LA(1)<='\u0939')||(input.LA(1)>='\u093C' && input.LA(1)<='\u094D')||(input.LA(1)>='\u0950' && input.LA(1)<='\u0954')||(input.LA(1)>='\u0958' && input.LA(1)<='\u0963')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u0981' && input.LA(1)<='\u0983')||(input.LA(1)>='\u0985' && input.LA(1)<='\u098C')||(input.LA(1)>='\u098F' && input.LA(1)<='\u0990')||(input.LA(1)>='\u0993' && input.LA(1)<='\u09A8')||(input.LA(1)>='\u09AA' && input.LA(1)<='\u09B0')||input.LA(1)=='\u09B2'||(input.LA(1)>='\u09B6' && input.LA(1)<='\u09B9')||(input.LA(1)>='\u09BC' && input.LA(1)<='\u09C4')||(input.LA(1)>='\u09C7' && input.LA(1)<='\u09C8')||(input.LA(1)>='\u09CB' && input.LA(1)<='\u09CD')||input.LA(1)=='\u09D7'||(input.LA(1)>='\u09DC' && input.LA(1)<='\u09DD')||(input.LA(1)>='\u09DF' && input.LA(1)<='\u09E3')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09F3')||(input.LA(1)>='\u0A01' && input.LA(1)<='\u0A03')||(input.LA(1)>='\u0A05' && input.LA(1)<='\u0A0A')||(input.LA(1)>='\u0A0F' && input.LA(1)<='\u0A10')||(input.LA(1)>='\u0A13' && input.LA(1)<='\u0A28')||(input.LA(1)>='\u0A2A' && input.LA(1)<='\u0A30')||(input.LA(1)>='\u0A32' && input.LA(1)<='\u0A33')||(input.LA(1)>='\u0A35' && input.LA(1)<='\u0A36')||(input.LA(1)>='\u0A38' && input.LA(1)<='\u0A39')||input.LA(1)=='\u0A3C'||(input.LA(1)>='\u0A3E' && input.LA(1)<='\u0A42')||(input.LA(1)>='\u0A47' && input.LA(1)<='\u0A48')||(input.LA(1)>='\u0A4B' && input.LA(1)<='\u0A4D')||(input.LA(1)>='\u0A59' && input.LA(1)<='\u0A5C')||input.LA(1)=='\u0A5E'||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A74')||(input.LA(1)>='\u0A81' && input.LA(1)<='\u0A83')||(input.LA(1)>='\u0A85' && input.LA(1)<='\u0A8D')||(input.LA(1)>='\u0A8F' && input.LA(1)<='\u0A91')||(input.LA(1)>='\u0A93' && input.LA(1)<='\u0AA8')||(input.LA(1)>='\u0AAA' && input.LA(1)<='\u0AB0')||(input.LA(1)>='\u0AB2' && input.LA(1)<='\u0AB3')||(input.LA(1)>='\u0AB5' && input.LA(1)<='\u0AB9')||(input.LA(1)>='\u0ABC' && input.LA(1)<='\u0AC5')||(input.LA(1)>='\u0AC7' && input.LA(1)<='\u0AC9')||(input.LA(1)>='\u0ACB' && input.LA(1)<='\u0ACD')||input.LA(1)=='\u0AD0'||(input.LA(1)>='\u0AE0' && input.LA(1)<='\u0AE3')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||input.LA(1)=='\u0AF1'||(input.LA(1)>='\u0B01' && input.LA(1)<='\u0B03')||(input.LA(1)>='\u0B05' && input.LA(1)<='\u0B0C')||(input.LA(1)>='\u0B0F' && input.LA(1)<='\u0B10')||(input.LA(1)>='\u0B13' && input.LA(1)<='\u0B28')||(input.LA(1)>='\u0B2A' && input.LA(1)<='\u0B30')||(input.LA(1)>='\u0B32' && input.LA(1)<='\u0B33')||(input.LA(1)>='\u0B35' && input.LA(1)<='\u0B39')||(input.LA(1)>='\u0B3C' && input.LA(1)<='\u0B43')||(input.LA(1)>='\u0B47' && input.LA(1)<='\u0B48')||(input.LA(1)>='\u0B4B' && input.LA(1)<='\u0B4D')||(input.LA(1)>='\u0B56' && input.LA(1)<='\u0B57')||(input.LA(1)>='\u0B5C' && input.LA(1)<='\u0B5D')||(input.LA(1)>='\u0B5F' && input.LA(1)<='\u0B61')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||input.LA(1)=='\u0B71'||(input.LA(1)>='\u0B82' && input.LA(1)<='\u0B83')||(input.LA(1)>='\u0B85' && input.LA(1)<='\u0B8A')||(input.LA(1)>='\u0B8E' && input.LA(1)<='\u0B90')||(input.LA(1)>='\u0B92' && input.LA(1)<='\u0B95')||(input.LA(1)>='\u0B99' && input.LA(1)<='\u0B9A')||input.LA(1)=='\u0B9C'||(input.LA(1)>='\u0B9E' && input.LA(1)<='\u0B9F')||(input.LA(1)>='\u0BA3' && input.LA(1)<='\u0BA4')||(input.LA(1)>='\u0BA8' && input.LA(1)<='\u0BAA')||(input.LA(1)>='\u0BAE' && input.LA(1)<='\u0BB5')||(input.LA(1)>='\u0BB7' && input.LA(1)<='\u0BB9')||(input.LA(1)>='\u0BBE' && input.LA(1)<='\u0BC2')||(input.LA(1)>='\u0BC6' && input.LA(1)<='\u0BC8')||(input.LA(1)>='\u0BCA' && input.LA(1)<='\u0BCD')||input.LA(1)=='\u0BD7'||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||input.LA(1)=='\u0BF9'||(input.LA(1)>='\u0C01' && input.LA(1)<='\u0C03')||(input.LA(1)>='\u0C05' && input.LA(1)<='\u0C0C')||(input.LA(1)>='\u0C0E' && input.LA(1)<='\u0C10')||(input.LA(1)>='\u0C12' && input.LA(1)<='\u0C28')||(input.LA(1)>='\u0C2A' && input.LA(1)<='\u0C33')||(input.LA(1)>='\u0C35' && input.LA(1)<='\u0C39')||(input.LA(1)>='\u0C3E' && input.LA(1)<='\u0C44')||(input.LA(1)>='\u0C46' && input.LA(1)<='\u0C48')||(input.LA(1)>='\u0C4A' && input.LA(1)<='\u0C4D')||(input.LA(1)>='\u0C55' && input.LA(1)<='\u0C56')||(input.LA(1)>='\u0C60' && input.LA(1)<='\u0C61')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0C82' && input.LA(1)<='\u0C83')||(input.LA(1)>='\u0C85' && input.LA(1)<='\u0C8C')||(input.LA(1)>='\u0C8E' && input.LA(1)<='\u0C90')||(input.LA(1)>='\u0C92' && input.LA(1)<='\u0CA8')||(input.LA(1)>='\u0CAA' && input.LA(1)<='\u0CB3')||(input.LA(1)>='\u0CB5' && input.LA(1)<='\u0CB9')||(input.LA(1)>='\u0CBC' && input.LA(1)<='\u0CC4')||(input.LA(1)>='\u0CC6' && input.LA(1)<='\u0CC8')||(input.LA(1)>='\u0CCA' && input.LA(1)<='\u0CCD')||(input.LA(1)>='\u0CD5' && input.LA(1)<='\u0CD6')||input.LA(1)=='\u0CDE'||(input.LA(1)>='\u0CE0' && input.LA(1)<='\u0CE1')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D02' && input.LA(1)<='\u0D03')||(input.LA(1)>='\u0D05' && input.LA(1)<='\u0D0C')||(input.LA(1)>='\u0D0E' && input.LA(1)<='\u0D10')||(input.LA(1)>='\u0D12' && input.LA(1)<='\u0D28')||(input.LA(1)>='\u0D2A' && input.LA(1)<='\u0D39')||(input.LA(1)>='\u0D3E' && input.LA(1)<='\u0D43')||(input.LA(1)>='\u0D46' && input.LA(1)<='\u0D48')||(input.LA(1)>='\u0D4A' && input.LA(1)<='\u0D4D')||input.LA(1)=='\u0D57'||(input.LA(1)>='\u0D60' && input.LA(1)<='\u0D61')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0D82' && input.LA(1)<='\u0D83')||(input.LA(1)>='\u0D85' && input.LA(1)<='\u0D96')||(input.LA(1)>='\u0D9A' && input.LA(1)<='\u0DB1')||(input.LA(1)>='\u0DB3' && input.LA(1)<='\u0DBB')||input.LA(1)=='\u0DBD'||(input.LA(1)>='\u0DC0' && input.LA(1)<='\u0DC6')||input.LA(1)=='\u0DCA'||(input.LA(1)>='\u0DCF' && input.LA(1)<='\u0DD4')||input.LA(1)=='\u0DD6'||(input.LA(1)>='\u0DD8' && input.LA(1)<='\u0DDF')||(input.LA(1)>='\u0DF2' && input.LA(1)<='\u0DF3')||(input.LA(1)>='\u0E01' && input.LA(1)<='\u0E3A')||(input.LA(1)>='\u0E3F' && input.LA(1)<='\u0E4E')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0E81' && input.LA(1)<='\u0E82')||input.LA(1)=='\u0E84'||(input.LA(1)>='\u0E87' && input.LA(1)<='\u0E88')||input.LA(1)=='\u0E8A'||input.LA(1)=='\u0E8D'||(input.LA(1)>='\u0E94' && input.LA(1)<='\u0E97')||(input.LA(1)>='\u0E99' && input.LA(1)<='\u0E9F')||(input.LA(1)>='\u0EA1' && input.LA(1)<='\u0EA3')||input.LA(1)=='\u0EA5'||input.LA(1)=='\u0EA7'||(input.LA(1)>='\u0EAA' && input.LA(1)<='\u0EAB')||(input.LA(1)>='\u0EAD' && input.LA(1)<='\u0EB9')||(input.LA(1)>='\u0EBB' && input.LA(1)<='\u0EBD')||(input.LA(1)>='\u0EC0' && input.LA(1)<='\u0EC4')||input.LA(1)=='\u0EC6'||(input.LA(1)>='\u0EC8' && input.LA(1)<='\u0ECD')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u0EDC' && input.LA(1)<='\u0EDD')||input.LA(1)=='\u0F00'||(input.LA(1)>='\u0F18' && input.LA(1)<='\u0F19')||(input.LA(1)>='\u0F20' && input.LA(1)<='\u0F29')||input.LA(1)=='\u0F35'||input.LA(1)=='\u0F37'||input.LA(1)=='\u0F39'||(input.LA(1)>='\u0F3E' && input.LA(1)<='\u0F47')||(input.LA(1)>='\u0F49' && input.LA(1)<='\u0F6A')||(input.LA(1)>='\u0F71' && input.LA(1)<='\u0F84')||(input.LA(1)>='\u0F86' && input.LA(1)<='\u0F8B')||(input.LA(1)>='\u0F90' && input.LA(1)<='\u0F97')||(input.LA(1)>='\u0F99' && input.LA(1)<='\u0FBC')||input.LA(1)=='\u0FC6'||(input.LA(1)>='\u1000' && input.LA(1)<='\u1021')||(input.LA(1)>='\u1023' && input.LA(1)<='\u1027')||(input.LA(1)>='\u1029' && input.LA(1)<='\u102A')||(input.LA(1)>='\u102C' && input.LA(1)<='\u1032')||(input.LA(1)>='\u1036' && input.LA(1)<='\u1039')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049')||(input.LA(1)>='\u1050' && input.LA(1)<='\u1059')||(input.LA(1)>='\u10A0' && input.LA(1)<='\u10C5')||(input.LA(1)>='\u10D0' && input.LA(1)<='\u10F8')||(input.LA(1)>='\u1100' && input.LA(1)<='\u1159')||(input.LA(1)>='\u115F' && input.LA(1)<='\u11A2')||(input.LA(1)>='\u11A8' && input.LA(1)<='\u11F9')||(input.LA(1)>='\u1200' && input.LA(1)<='\u1206')||(input.LA(1)>='\u1208' && input.LA(1)<='\u1246')||input.LA(1)=='\u1248'||(input.LA(1)>='\u124A' && input.LA(1)<='\u124D')||(input.LA(1)>='\u1250' && input.LA(1)<='\u1256')||input.LA(1)=='\u1258'||(input.LA(1)>='\u125A' && input.LA(1)<='\u125D')||(input.LA(1)>='\u1260' && input.LA(1)<='\u1286')||input.LA(1)=='\u1288'||(input.LA(1)>='\u128A' && input.LA(1)<='\u128D')||(input.LA(1)>='\u1290' && input.LA(1)<='\u12AE')||input.LA(1)=='\u12B0'||(input.LA(1)>='\u12B2' && input.LA(1)<='\u12B5')||(input.LA(1)>='\u12B8' && input.LA(1)<='\u12BE')||input.LA(1)=='\u12C0'||(input.LA(1)>='\u12C2' && input.LA(1)<='\u12C5')||(input.LA(1)>='\u12C8' && input.LA(1)<='\u12CE')||(input.LA(1)>='\u12D0' && input.LA(1)<='\u12D6')||(input.LA(1)>='\u12D8' && input.LA(1)<='\u12EE')||(input.LA(1)>='\u12F0' && input.LA(1)<='\u130E')||input.LA(1)=='\u1310'||(input.LA(1)>='\u1312' && input.LA(1)<='\u1315')||(input.LA(1)>='\u1318' && input.LA(1)<='\u131E')||(input.LA(1)>='\u1320' && input.LA(1)<='\u1346')||(input.LA(1)>='\u1348' && input.LA(1)<='\u135A')||(input.LA(1)>='\u1369' && input.LA(1)<='\u1371')||(input.LA(1)>='\u13A0' && input.LA(1)<='\u13F4')||(input.LA(1)>='\u1401' && input.LA(1)<='\u166C')||(input.LA(1)>='\u166F' && input.LA(1)<='\u1676')||(input.LA(1)>='\u1681' && input.LA(1)<='\u169A')||(input.LA(1)>='\u16A0' && input.LA(1)<='\u16EA')||(input.LA(1)>='\u16EE' && input.LA(1)<='\u16F0')||(input.LA(1)>='\u1700' && input.LA(1)<='\u170C')||(input.LA(1)>='\u170E' && input.LA(1)<='\u1714')||(input.LA(1)>='\u1720' && input.LA(1)<='\u1734')||(input.LA(1)>='\u1740' && input.LA(1)<='\u1753')||(input.LA(1)>='\u1760' && input.LA(1)<='\u176C')||(input.LA(1)>='\u176E' && input.LA(1)<='\u1770')||(input.LA(1)>='\u1772' && input.LA(1)<='\u1773')||(input.LA(1)>='\u1780' && input.LA(1)<='\u17D3')||input.LA(1)=='\u17D7'||(input.LA(1)>='\u17DB' && input.LA(1)<='\u17DD')||(input.LA(1)>='\u17E0' && input.LA(1)<='\u17E9')||(input.LA(1)>='\u180B' && input.LA(1)<='\u180D')||(input.LA(1)>='\u1810' && input.LA(1)<='\u1819')||(input.LA(1)>='\u1820' && input.LA(1)<='\u1877')||(input.LA(1)>='\u1880' && input.LA(1)<='\u18A9')||(input.LA(1)>='\u1900' && input.LA(1)<='\u191C')||(input.LA(1)>='\u1920' && input.LA(1)<='\u192B')||(input.LA(1)>='\u1930' && input.LA(1)<='\u193B')||(input.LA(1)>='\u1946' && input.LA(1)<='\u196D')||(input.LA(1)>='\u1970' && input.LA(1)<='\u1974')||(input.LA(1)>='\u1D00' && input.LA(1)<='\u1D6B')||(input.LA(1)>='\u1E00' && input.LA(1)<='\u1E9B')||(input.LA(1)>='\u1EA0' && input.LA(1)<='\u1EF9')||(input.LA(1)>='\u1F00' && input.LA(1)<='\u1F15')||(input.LA(1)>='\u1F18' && input.LA(1)<='\u1F1D')||(input.LA(1)>='\u1F20' && input.LA(1)<='\u1F45')||(input.LA(1)>='\u1F48' && input.LA(1)<='\u1F4D')||(input.LA(1)>='\u1F50' && input.LA(1)<='\u1F57')||input.LA(1)=='\u1F59'||input.LA(1)=='\u1F5B'||input.LA(1)=='\u1F5D'||(input.LA(1)>='\u1F5F' && input.LA(1)<='\u1F7D')||(input.LA(1)>='\u1F80' && input.LA(1)<='\u1FB4')||(input.LA(1)>='\u1FB6' && input.LA(1)<='\u1FBC')||input.LA(1)=='\u1FBE'||(input.LA(1)>='\u1FC2' && input.LA(1)<='\u1FC4')||(input.LA(1)>='\u1FC6' && input.LA(1)<='\u1FCC')||(input.LA(1)>='\u1FD0' && input.LA(1)<='\u1FD3')||(input.LA(1)>='\u1FD6' && input.LA(1)<='\u1FDB')||(input.LA(1)>='\u1FE0' && input.LA(1)<='\u1FEC')||(input.LA(1)>='\u1FF2' && input.LA(1)<='\u1FF4')||(input.LA(1)>='\u1FF6' && input.LA(1)<='\u1FFC')||(input.LA(1)>='\u200C' && input.LA(1)<='\u200F')||(input.LA(1)>='\u202A' && input.LA(1)<='\u202E')||(input.LA(1)>='\u203F' && input.LA(1)<='\u2040')||input.LA(1)=='\u2054'||(input.LA(1)>='\u2060' && input.LA(1)<='\u2063')||(input.LA(1)>='\u206A' && input.LA(1)<='\u206F')||input.LA(1)=='\u2071'||input.LA(1)=='\u207F'||(input.LA(1)>='\u20A0' && input.LA(1)<='\u20B1')||(input.LA(1)>='\u20D0' && input.LA(1)<='\u20DC')||input.LA(1)=='\u20E1'||(input.LA(1)>='\u20E5' && input.LA(1)<='\u20EA')||input.LA(1)=='\u2102'||input.LA(1)=='\u2107'||(input.LA(1)>='\u210A' && input.LA(1)<='\u2113')||input.LA(1)=='\u2115'||(input.LA(1)>='\u2119' && input.LA(1)<='\u211D')||input.LA(1)=='\u2124'||input.LA(1)=='\u2126'||input.LA(1)=='\u2128'||(input.LA(1)>='\u212A' && input.LA(1)<='\u212D')||(input.LA(1)>='\u212F' && input.LA(1)<='\u2131')||(input.LA(1)>='\u2133' && input.LA(1)<='\u2139')||(input.LA(1)>='\u213D' && input.LA(1)<='\u213F')||(input.LA(1)>='\u2145' && input.LA(1)<='\u2149')||(input.LA(1)>='\u2160' && input.LA(1)<='\u2183')||(input.LA(1)>='\u3005' && input.LA(1)<='\u3007')||(input.LA(1)>='\u3021' && input.LA(1)<='\u302F')||(input.LA(1)>='\u3031' && input.LA(1)<='\u3035')||(input.LA(1)>='\u3038' && input.LA(1)<='\u303C')||(input.LA(1)>='\u3041' && input.LA(1)<='\u3096')||(input.LA(1)>='\u3099' && input.LA(1)<='\u309A')||(input.LA(1)>='\u309D' && input.LA(1)<='\u309F')||(input.LA(1)>='\u30A1' && input.LA(1)<='\u30FF')||(input.LA(1)>='\u3105' && input.LA(1)<='\u312C')||(input.LA(1)>='\u3131' && input.LA(1)<='\u318E')||(input.LA(1)>='\u31A0' && input.LA(1)<='\u31B7')||(input.LA(1)>='\u31F0' && input.LA(1)<='\u31FF')||(input.LA(1)>='\u3400' && input.LA(1)<='\u4DB5')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FA5')||(input.LA(1)>='\uA000' && input.LA(1)<='\uA48C')||(input.LA(1)>='\uAC00' && input.LA(1)<='\uD7A3')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFA2D')||(input.LA(1)>='\uFA30' && input.LA(1)<='\uFA6A')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFB06')||(input.LA(1)>='\uFB13' && input.LA(1)<='\uFB17')||(input.LA(1)>='\uFB1D' && input.LA(1)<='\uFB28')||(input.LA(1)>='\uFB2A' && input.LA(1)<='\uFB36')||(input.LA(1)>='\uFB38' && input.LA(1)<='\uFB3C')||input.LA(1)=='\uFB3E'||(input.LA(1)>='\uFB40' && input.LA(1)<='\uFB41')||(input.LA(1)>='\uFB43' && input.LA(1)<='\uFB44')||(input.LA(1)>='\uFB46' && input.LA(1)<='\uFBB1')||(input.LA(1)>='\uFBD3' && input.LA(1)<='\uFD3D')||(input.LA(1)>='\uFD50' && input.LA(1)<='\uFD8F')||(input.LA(1)>='\uFD92' && input.LA(1)<='\uFDC7')||(input.LA(1)>='\uFDF0' && input.LA(1)<='\uFDFC')||(input.LA(1)>='\uFE00' && input.LA(1)<='\uFE0F')||(input.LA(1)>='\uFE20' && input.LA(1)<='\uFE23')||(input.LA(1)>='\uFE33' && input.LA(1)<='\uFE34')||(input.LA(1)>='\uFE4D' && input.LA(1)<='\uFE4F')||input.LA(1)=='\uFE69'||(input.LA(1)>='\uFE70' && input.LA(1)<='\uFE74')||(input.LA(1)>='\uFE76' && input.LA(1)<='\uFEFC')||input.LA(1)=='\uFEFF'||input.LA(1)=='\uFF04'||(input.LA(1)>='\uFF10' && input.LA(1)<='\uFF19')||(input.LA(1)>='\uFF21' && input.LA(1)<='\uFF3A')||input.LA(1)=='\uFF3F'||(input.LA(1)>='\uFF41' && input.LA(1)<='\uFF5A')||(input.LA(1)>='\uFF65' && input.LA(1)<='\uFFBE')||(input.LA(1)>='\uFFC2' && input.LA(1)<='\uFFC7')||(input.LA(1)>='\uFFCA' && input.LA(1)<='\uFFCF')||(input.LA(1)>='\uFFD2' && input.LA(1)<='\uFFD7')||(input.LA(1)>='\uFFDA' && input.LA(1)<='\uFFDC')||(input.LA(1)>='\uFFE0' && input.LA(1)<='\uFFE1')||(input.LA(1)>='\uFFE5' && input.LA(1)<='\uFFE6')||(input.LA(1)>='\uFFF9' && input.LA(1)<='\uFFFB') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_IDENTIFIER_PART"

    // $ANTLR start "RULE_IDENTIFIER_PART_IMPL"
    public final void mRULE_IDENTIFIER_PART_IMPL() throws RecognitionException {
        try {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9895:36: ( ( '\\u0000' .. '\\b' | '\\u000E' .. '\\u001B' | '0' .. '9' | '\\u007F' .. '\\u009F' | '\\u00AD' | '\\u0300' .. '\\u0357' | '\\u035D' .. '\\u036F' | '\\u0483' .. '\\u0486' | '\\u0591' .. '\\u05A1' | '\\u05A3' .. '\\u05B9' | '\\u05BB' .. '\\u05BD' | '\\u05BF' | '\\u05C1' .. '\\u05C2' | '\\u05C4' | '\\u0600' .. '\\u0603' | '\\u0610' .. '\\u0615' | '\\u064B' .. '\\u0658' | '\\u0660' .. '\\u0669' | '\\u0670' | '\\u06D6' .. '\\u06DD' | '\\u06DF' .. '\\u06E4' | '\\u06E7' .. '\\u06E8' | '\\u06EA' .. '\\u06ED' | '\\u06F0' .. '\\u06F9' | '\\u070F' | '\\u0711' | '\\u0730' .. '\\u074A' | '\\u07A6' .. '\\u07B0' | '\\u0901' .. '\\u0903' | '\\u093C' | '\\u093E' .. '\\u094D' | '\\u0951' .. '\\u0954' | '\\u0962' .. '\\u0963' | '\\u0966' .. '\\u096F' | '\\u0981' .. '\\u0983' | '\\u09BC' | '\\u09BE' .. '\\u09C4' | '\\u09C7' .. '\\u09C8' | '\\u09CB' .. '\\u09CD' | '\\u09D7' | '\\u09E2' .. '\\u09E3' | '\\u09E6' .. '\\u09EF' | '\\u0A01' .. '\\u0A03' | '\\u0A3C' | '\\u0A3E' .. '\\u0A42' | '\\u0A47' .. '\\u0A48' | '\\u0A4B' .. '\\u0A4D' | '\\u0A66' .. '\\u0A71' | '\\u0A81' .. '\\u0A83' | '\\u0ABC' | '\\u0ABE' .. '\\u0AC5' | '\\u0AC7' .. '\\u0AC9' | '\\u0ACB' .. '\\u0ACD' | '\\u0AE2' .. '\\u0AE3' | '\\u0AE6' .. '\\u0AEF' | '\\u0B01' .. '\\u0B03' | '\\u0B3C' | '\\u0B3E' .. '\\u0B43' | '\\u0B47' .. '\\u0B48' | '\\u0B4B' .. '\\u0B4D' | '\\u0B56' .. '\\u0B57' | '\\u0B66' .. '\\u0B6F' | '\\u0B82' | '\\u0BBE' .. '\\u0BC2' | '\\u0BC6' .. '\\u0BC8' | '\\u0BCA' .. '\\u0BCD' | '\\u0BD7' | '\\u0BE7' .. '\\u0BEF' | '\\u0C01' .. '\\u0C03' | '\\u0C3E' .. '\\u0C44' | '\\u0C46' .. '\\u0C48' | '\\u0C4A' .. '\\u0C4D' | '\\u0C55' .. '\\u0C56' | '\\u0C66' .. '\\u0C6F' | '\\u0C82' .. '\\u0C83' | '\\u0CBC' | '\\u0CBE' .. '\\u0CC4' | '\\u0CC6' .. '\\u0CC8' | '\\u0CCA' .. '\\u0CCD' | '\\u0CD5' .. '\\u0CD6' | '\\u0CE6' .. '\\u0CEF' | '\\u0D02' .. '\\u0D03' | '\\u0D3E' .. '\\u0D43' | '\\u0D46' .. '\\u0D48' | '\\u0D4A' .. '\\u0D4D' | '\\u0D57' | '\\u0D66' .. '\\u0D6F' | '\\u0D82' .. '\\u0D83' | '\\u0DCA' | '\\u0DCF' .. '\\u0DD4' | '\\u0DD6' | '\\u0DD8' .. '\\u0DDF' | '\\u0DF2' .. '\\u0DF3' | '\\u0E31' | '\\u0E34' .. '\\u0E3A' | '\\u0E47' .. '\\u0E4E' | '\\u0E50' .. '\\u0E59' | '\\u0EB1' | '\\u0EB4' .. '\\u0EB9' | '\\u0EBB' .. '\\u0EBC' | '\\u0EC8' .. '\\u0ECD' | '\\u0ED0' .. '\\u0ED9' | '\\u0F18' .. '\\u0F19' | '\\u0F20' .. '\\u0F29' | '\\u0F35' | '\\u0F37' | '\\u0F39' | '\\u0F3E' .. '\\u0F3F' | '\\u0F71' .. '\\u0F84' | '\\u0F86' .. '\\u0F87' | '\\u0F90' .. '\\u0F97' | '\\u0F99' .. '\\u0FBC' | '\\u0FC6' | '\\u102C' .. '\\u1032' | '\\u1036' .. '\\u1039' | '\\u1040' .. '\\u1049' | '\\u1056' .. '\\u1059' | '\\u1369' .. '\\u1371' | '\\u1712' .. '\\u1714' | '\\u1732' .. '\\u1734' | '\\u1752' .. '\\u1753' | '\\u1772' .. '\\u1773' | '\\u17B4' .. '\\u17D3' | '\\u17DD' | '\\u17E0' .. '\\u17E9' | '\\u180B' .. '\\u180D' | '\\u1810' .. '\\u1819' | '\\u18A9' | '\\u1920' .. '\\u192B' | '\\u1930' .. '\\u193B' | '\\u1946' .. '\\u194F' | '\\u200C' .. '\\u200F' | '\\u202A' .. '\\u202E' | '\\u2060' .. '\\u2063' | '\\u206A' .. '\\u206F' | '\\u20D0' .. '\\u20DC' | '\\u20E1' | '\\u20E5' .. '\\u20EA' | '\\u302A' .. '\\u302F' | '\\u3099' .. '\\u309A' | '\\uFB1E' | '\\uFE00' .. '\\uFE0F' | '\\uFE20' .. '\\uFE23' | '\\uFEFF' | '\\uFF10' .. '\\uFF19' | '\\uFFF9' .. '\\uFFFB' ) )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9895:38: ( '\\u0000' .. '\\b' | '\\u000E' .. '\\u001B' | '0' .. '9' | '\\u007F' .. '\\u009F' | '\\u00AD' | '\\u0300' .. '\\u0357' | '\\u035D' .. '\\u036F' | '\\u0483' .. '\\u0486' | '\\u0591' .. '\\u05A1' | '\\u05A3' .. '\\u05B9' | '\\u05BB' .. '\\u05BD' | '\\u05BF' | '\\u05C1' .. '\\u05C2' | '\\u05C4' | '\\u0600' .. '\\u0603' | '\\u0610' .. '\\u0615' | '\\u064B' .. '\\u0658' | '\\u0660' .. '\\u0669' | '\\u0670' | '\\u06D6' .. '\\u06DD' | '\\u06DF' .. '\\u06E4' | '\\u06E7' .. '\\u06E8' | '\\u06EA' .. '\\u06ED' | '\\u06F0' .. '\\u06F9' | '\\u070F' | '\\u0711' | '\\u0730' .. '\\u074A' | '\\u07A6' .. '\\u07B0' | '\\u0901' .. '\\u0903' | '\\u093C' | '\\u093E' .. '\\u094D' | '\\u0951' .. '\\u0954' | '\\u0962' .. '\\u0963' | '\\u0966' .. '\\u096F' | '\\u0981' .. '\\u0983' | '\\u09BC' | '\\u09BE' .. '\\u09C4' | '\\u09C7' .. '\\u09C8' | '\\u09CB' .. '\\u09CD' | '\\u09D7' | '\\u09E2' .. '\\u09E3' | '\\u09E6' .. '\\u09EF' | '\\u0A01' .. '\\u0A03' | '\\u0A3C' | '\\u0A3E' .. '\\u0A42' | '\\u0A47' .. '\\u0A48' | '\\u0A4B' .. '\\u0A4D' | '\\u0A66' .. '\\u0A71' | '\\u0A81' .. '\\u0A83' | '\\u0ABC' | '\\u0ABE' .. '\\u0AC5' | '\\u0AC7' .. '\\u0AC9' | '\\u0ACB' .. '\\u0ACD' | '\\u0AE2' .. '\\u0AE3' | '\\u0AE6' .. '\\u0AEF' | '\\u0B01' .. '\\u0B03' | '\\u0B3C' | '\\u0B3E' .. '\\u0B43' | '\\u0B47' .. '\\u0B48' | '\\u0B4B' .. '\\u0B4D' | '\\u0B56' .. '\\u0B57' | '\\u0B66' .. '\\u0B6F' | '\\u0B82' | '\\u0BBE' .. '\\u0BC2' | '\\u0BC6' .. '\\u0BC8' | '\\u0BCA' .. '\\u0BCD' | '\\u0BD7' | '\\u0BE7' .. '\\u0BEF' | '\\u0C01' .. '\\u0C03' | '\\u0C3E' .. '\\u0C44' | '\\u0C46' .. '\\u0C48' | '\\u0C4A' .. '\\u0C4D' | '\\u0C55' .. '\\u0C56' | '\\u0C66' .. '\\u0C6F' | '\\u0C82' .. '\\u0C83' | '\\u0CBC' | '\\u0CBE' .. '\\u0CC4' | '\\u0CC6' .. '\\u0CC8' | '\\u0CCA' .. '\\u0CCD' | '\\u0CD5' .. '\\u0CD6' | '\\u0CE6' .. '\\u0CEF' | '\\u0D02' .. '\\u0D03' | '\\u0D3E' .. '\\u0D43' | '\\u0D46' .. '\\u0D48' | '\\u0D4A' .. '\\u0D4D' | '\\u0D57' | '\\u0D66' .. '\\u0D6F' | '\\u0D82' .. '\\u0D83' | '\\u0DCA' | '\\u0DCF' .. '\\u0DD4' | '\\u0DD6' | '\\u0DD8' .. '\\u0DDF' | '\\u0DF2' .. '\\u0DF3' | '\\u0E31' | '\\u0E34' .. '\\u0E3A' | '\\u0E47' .. '\\u0E4E' | '\\u0E50' .. '\\u0E59' | '\\u0EB1' | '\\u0EB4' .. '\\u0EB9' | '\\u0EBB' .. '\\u0EBC' | '\\u0EC8' .. '\\u0ECD' | '\\u0ED0' .. '\\u0ED9' | '\\u0F18' .. '\\u0F19' | '\\u0F20' .. '\\u0F29' | '\\u0F35' | '\\u0F37' | '\\u0F39' | '\\u0F3E' .. '\\u0F3F' | '\\u0F71' .. '\\u0F84' | '\\u0F86' .. '\\u0F87' | '\\u0F90' .. '\\u0F97' | '\\u0F99' .. '\\u0FBC' | '\\u0FC6' | '\\u102C' .. '\\u1032' | '\\u1036' .. '\\u1039' | '\\u1040' .. '\\u1049' | '\\u1056' .. '\\u1059' | '\\u1369' .. '\\u1371' | '\\u1712' .. '\\u1714' | '\\u1732' .. '\\u1734' | '\\u1752' .. '\\u1753' | '\\u1772' .. '\\u1773' | '\\u17B4' .. '\\u17D3' | '\\u17DD' | '\\u17E0' .. '\\u17E9' | '\\u180B' .. '\\u180D' | '\\u1810' .. '\\u1819' | '\\u18A9' | '\\u1920' .. '\\u192B' | '\\u1930' .. '\\u193B' | '\\u1946' .. '\\u194F' | '\\u200C' .. '\\u200F' | '\\u202A' .. '\\u202E' | '\\u2060' .. '\\u2063' | '\\u206A' .. '\\u206F' | '\\u20D0' .. '\\u20DC' | '\\u20E1' | '\\u20E5' .. '\\u20EA' | '\\u302A' .. '\\u302F' | '\\u3099' .. '\\u309A' | '\\uFB1E' | '\\uFE00' .. '\\uFE0F' | '\\uFE20' .. '\\uFE23' | '\\uFEFF' | '\\uFF10' .. '\\uFF19' | '\\uFFF9' .. '\\uFFFB' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001B')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='\u007F' && input.LA(1)<='\u009F')||input.LA(1)=='\u00AD'||(input.LA(1)>='\u0300' && input.LA(1)<='\u0357')||(input.LA(1)>='\u035D' && input.LA(1)<='\u036F')||(input.LA(1)>='\u0483' && input.LA(1)<='\u0486')||(input.LA(1)>='\u0591' && input.LA(1)<='\u05A1')||(input.LA(1)>='\u05A3' && input.LA(1)<='\u05B9')||(input.LA(1)>='\u05BB' && input.LA(1)<='\u05BD')||input.LA(1)=='\u05BF'||(input.LA(1)>='\u05C1' && input.LA(1)<='\u05C2')||input.LA(1)=='\u05C4'||(input.LA(1)>='\u0600' && input.LA(1)<='\u0603')||(input.LA(1)>='\u0610' && input.LA(1)<='\u0615')||(input.LA(1)>='\u064B' && input.LA(1)<='\u0658')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||input.LA(1)=='\u0670'||(input.LA(1)>='\u06D6' && input.LA(1)<='\u06DD')||(input.LA(1)>='\u06DF' && input.LA(1)<='\u06E4')||(input.LA(1)>='\u06E7' && input.LA(1)<='\u06E8')||(input.LA(1)>='\u06EA' && input.LA(1)<='\u06ED')||(input.LA(1)>='\u06F0' && input.LA(1)<='\u06F9')||input.LA(1)=='\u070F'||input.LA(1)=='\u0711'||(input.LA(1)>='\u0730' && input.LA(1)<='\u074A')||(input.LA(1)>='\u07A6' && input.LA(1)<='\u07B0')||(input.LA(1)>='\u0901' && input.LA(1)<='\u0903')||input.LA(1)=='\u093C'||(input.LA(1)>='\u093E' && input.LA(1)<='\u094D')||(input.LA(1)>='\u0951' && input.LA(1)<='\u0954')||(input.LA(1)>='\u0962' && input.LA(1)<='\u0963')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u0981' && input.LA(1)<='\u0983')||input.LA(1)=='\u09BC'||(input.LA(1)>='\u09BE' && input.LA(1)<='\u09C4')||(input.LA(1)>='\u09C7' && input.LA(1)<='\u09C8')||(input.LA(1)>='\u09CB' && input.LA(1)<='\u09CD')||input.LA(1)=='\u09D7'||(input.LA(1)>='\u09E2' && input.LA(1)<='\u09E3')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09EF')||(input.LA(1)>='\u0A01' && input.LA(1)<='\u0A03')||input.LA(1)=='\u0A3C'||(input.LA(1)>='\u0A3E' && input.LA(1)<='\u0A42')||(input.LA(1)>='\u0A47' && input.LA(1)<='\u0A48')||(input.LA(1)>='\u0A4B' && input.LA(1)<='\u0A4D')||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A71')||(input.LA(1)>='\u0A81' && input.LA(1)<='\u0A83')||input.LA(1)=='\u0ABC'||(input.LA(1)>='\u0ABE' && input.LA(1)<='\u0AC5')||(input.LA(1)>='\u0AC7' && input.LA(1)<='\u0AC9')||(input.LA(1)>='\u0ACB' && input.LA(1)<='\u0ACD')||(input.LA(1)>='\u0AE2' && input.LA(1)<='\u0AE3')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B01' && input.LA(1)<='\u0B03')||input.LA(1)=='\u0B3C'||(input.LA(1)>='\u0B3E' && input.LA(1)<='\u0B43')||(input.LA(1)>='\u0B47' && input.LA(1)<='\u0B48')||(input.LA(1)>='\u0B4B' && input.LA(1)<='\u0B4D')||(input.LA(1)>='\u0B56' && input.LA(1)<='\u0B57')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||input.LA(1)=='\u0B82'||(input.LA(1)>='\u0BBE' && input.LA(1)<='\u0BC2')||(input.LA(1)>='\u0BC6' && input.LA(1)<='\u0BC8')||(input.LA(1)>='\u0BCA' && input.LA(1)<='\u0BCD')||input.LA(1)=='\u0BD7'||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C01' && input.LA(1)<='\u0C03')||(input.LA(1)>='\u0C3E' && input.LA(1)<='\u0C44')||(input.LA(1)>='\u0C46' && input.LA(1)<='\u0C48')||(input.LA(1)>='\u0C4A' && input.LA(1)<='\u0C4D')||(input.LA(1)>='\u0C55' && input.LA(1)<='\u0C56')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0C82' && input.LA(1)<='\u0C83')||input.LA(1)=='\u0CBC'||(input.LA(1)>='\u0CBE' && input.LA(1)<='\u0CC4')||(input.LA(1)>='\u0CC6' && input.LA(1)<='\u0CC8')||(input.LA(1)>='\u0CCA' && input.LA(1)<='\u0CCD')||(input.LA(1)>='\u0CD5' && input.LA(1)<='\u0CD6')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D02' && input.LA(1)<='\u0D03')||(input.LA(1)>='\u0D3E' && input.LA(1)<='\u0D43')||(input.LA(1)>='\u0D46' && input.LA(1)<='\u0D48')||(input.LA(1)>='\u0D4A' && input.LA(1)<='\u0D4D')||input.LA(1)=='\u0D57'||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0D82' && input.LA(1)<='\u0D83')||input.LA(1)=='\u0DCA'||(input.LA(1)>='\u0DCF' && input.LA(1)<='\u0DD4')||input.LA(1)=='\u0DD6'||(input.LA(1)>='\u0DD8' && input.LA(1)<='\u0DDF')||(input.LA(1)>='\u0DF2' && input.LA(1)<='\u0DF3')||input.LA(1)=='\u0E31'||(input.LA(1)>='\u0E34' && input.LA(1)<='\u0E3A')||(input.LA(1)>='\u0E47' && input.LA(1)<='\u0E4E')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||input.LA(1)=='\u0EB1'||(input.LA(1)>='\u0EB4' && input.LA(1)<='\u0EB9')||(input.LA(1)>='\u0EBB' && input.LA(1)<='\u0EBC')||(input.LA(1)>='\u0EC8' && input.LA(1)<='\u0ECD')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u0F18' && input.LA(1)<='\u0F19')||(input.LA(1)>='\u0F20' && input.LA(1)<='\u0F29')||input.LA(1)=='\u0F35'||input.LA(1)=='\u0F37'||input.LA(1)=='\u0F39'||(input.LA(1)>='\u0F3E' && input.LA(1)<='\u0F3F')||(input.LA(1)>='\u0F71' && input.LA(1)<='\u0F84')||(input.LA(1)>='\u0F86' && input.LA(1)<='\u0F87')||(input.LA(1)>='\u0F90' && input.LA(1)<='\u0F97')||(input.LA(1)>='\u0F99' && input.LA(1)<='\u0FBC')||input.LA(1)=='\u0FC6'||(input.LA(1)>='\u102C' && input.LA(1)<='\u1032')||(input.LA(1)>='\u1036' && input.LA(1)<='\u1039')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049')||(input.LA(1)>='\u1056' && input.LA(1)<='\u1059')||(input.LA(1)>='\u1369' && input.LA(1)<='\u1371')||(input.LA(1)>='\u1712' && input.LA(1)<='\u1714')||(input.LA(1)>='\u1732' && input.LA(1)<='\u1734')||(input.LA(1)>='\u1752' && input.LA(1)<='\u1753')||(input.LA(1)>='\u1772' && input.LA(1)<='\u1773')||(input.LA(1)>='\u17B4' && input.LA(1)<='\u17D3')||input.LA(1)=='\u17DD'||(input.LA(1)>='\u17E0' && input.LA(1)<='\u17E9')||(input.LA(1)>='\u180B' && input.LA(1)<='\u180D')||(input.LA(1)>='\u1810' && input.LA(1)<='\u1819')||input.LA(1)=='\u18A9'||(input.LA(1)>='\u1920' && input.LA(1)<='\u192B')||(input.LA(1)>='\u1930' && input.LA(1)<='\u193B')||(input.LA(1)>='\u1946' && input.LA(1)<='\u194F')||(input.LA(1)>='\u200C' && input.LA(1)<='\u200F')||(input.LA(1)>='\u202A' && input.LA(1)<='\u202E')||(input.LA(1)>='\u2060' && input.LA(1)<='\u2063')||(input.LA(1)>='\u206A' && input.LA(1)<='\u206F')||(input.LA(1)>='\u20D0' && input.LA(1)<='\u20DC')||input.LA(1)=='\u20E1'||(input.LA(1)>='\u20E5' && input.LA(1)<='\u20EA')||(input.LA(1)>='\u302A' && input.LA(1)<='\u302F')||(input.LA(1)>='\u3099' && input.LA(1)<='\u309A')||input.LA(1)=='\uFB1E'||(input.LA(1)>='\uFE00' && input.LA(1)<='\uFE0F')||(input.LA(1)>='\uFE20' && input.LA(1)<='\uFE23')||input.LA(1)=='\uFEFF'||(input.LA(1)>='\uFF10' && input.LA(1)<='\uFF19')||(input.LA(1)>='\uFFF9' && input.LA(1)<='\uFFFB') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_IDENTIFIER_PART_IMPL"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )? )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:12: ( '0x' | '0X' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0=='0') ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1=='x') ) {
                    alt33=1;
                }
                else if ( (LA33_1=='X') ) {
                    alt33=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>='0' && LA34_0<='9')||(LA34_0>='A' && LA34_0<='F')||LA34_0=='_'||(LA34_0>='a' && LA34_0<='f')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:
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
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:58: ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0=='#') ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:59: '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    {
                    match('#'); 
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:63: ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0=='B'||LA35_0=='b') ) {
                        alt35=1;
                    }
                    else if ( (LA35_0=='L'||LA35_0=='l') ) {
                        alt35=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:64: ( 'b' | 'B' ) ( 'i' | 'I' )
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
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9897:84: ( 'l' | 'L' )
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9899:10: ( '0' .. '9' ( '0' .. '9' | '_' )* )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9899:12: '0' .. '9' ( '0' .. '9' | '_' )*
            {
            matchRange('0','9'); 
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9899:21: ( '0' .. '9' | '_' )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>='0' && LA37_0<='9')||LA37_0=='_') ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:
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
            	    break loop37;
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9901:14: ( RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )? )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9901:16: RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            {
            mRULE_INT(); 
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9901:25: ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0=='E'||LA39_0=='e') ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9901:26: ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9901:36: ( '+' | '-' )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0=='+'||LA38_0=='-') ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:
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

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9901:58: ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            int alt40=3;
            int LA40_0 = input.LA(1);

            if ( (LA40_0=='B'||LA40_0=='b') ) {
                alt40=1;
            }
            else if ( (LA40_0=='D'||LA40_0=='F'||LA40_0=='L'||LA40_0=='d'||LA40_0=='f'||LA40_0=='l') ) {
                alt40=2;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9901:59: ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' )
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
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9901:87: ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' )
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9903:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9903:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9903:11: ( '^' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0=='^') ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9903:11: '^'
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

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9903:44: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0=='$'||(LA42_0>='0' && LA42_0<='9')||(LA42_0>='A' && LA42_0<='Z')||LA42_0=='_'||(LA42_0>='a' && LA42_0<='z')) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:
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
            	    break loop42;
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0=='\"') ) {
                alt45=1;
            }
            else if ( (LA45_0=='\'') ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop43:
                    do {
                        int alt43=3;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0=='\\') ) {
                            alt43=1;
                        }
                        else if ( ((LA43_0>='\u0000' && LA43_0<='!')||(LA43_0>='#' && LA43_0<='[')||(LA43_0>=']' && LA43_0<='\uFFFF')) ) {
                            alt43=2;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop43;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop44:
                    do {
                        int alt44=3;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0=='\\') ) {
                            alt44=1;
                        }
                        else if ( ((LA44_0>='\u0000' && LA44_0<='&')||(LA44_0>='(' && LA44_0<='[')||(LA44_0>=']' && LA44_0<='\uFFFF')) ) {
                            alt44=2;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9905:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop44;
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9907:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9907:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9907:24: ( options {greedy=false; } : . )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0=='*') ) {
                    int LA46_1 = input.LA(2);

                    if ( (LA46_1=='/') ) {
                        alt46=2;
                    }
                    else if ( ((LA46_1>='\u0000' && LA46_1<='.')||(LA46_1>='0' && LA46_1<='\uFFFF')) ) {
                        alt46=1;
                    }


                }
                else if ( ((LA46_0>='\u0000' && LA46_0<=')')||(LA46_0>='+' && LA46_0<='\uFFFF')) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9907:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop46;
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9909:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9909:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9909:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>='\u0000' && LA47_0<='\t')||(LA47_0>='\u000B' && LA47_0<='\f')||(LA47_0>='\u000E' && LA47_0<='\uFFFF')) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9909:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop47;
                }
            } while (true);

            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9909:40: ( ( '\\r' )? '\\n' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0=='\n'||LA49_0=='\r') ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9909:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9909:41: ( '\\r' )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0=='\r') ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9909:41: '\\r'
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9911:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9911:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9911:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>='\t' && LA50_0<='\n')||LA50_0=='\r'||LA50_0==' ') ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:
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
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
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
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9913:16: ( . )
            // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:9913:18: .
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
        // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:8: ( T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | RULE_RICH_TEXT | RULE_RICH_TEXT_START | RULE_RICH_TEXT_END | RULE_RICH_TEXT_INBETWEEN | RULE_COMMENT_RICH_TEXT_INBETWEEN | RULE_COMMENT_RICH_TEXT_END | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt51=112;
        alt51 = dfa51.predict(input);
        switch (alt51) {
            case 1 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:10: T__25
                {
                mT__25(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:16: T__26
                {
                mT__26(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:22: T__27
                {
                mT__27(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:28: T__28
                {
                mT__28(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:34: T__29
                {
                mT__29(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:40: T__30
                {
                mT__30(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:46: T__31
                {
                mT__31(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:52: T__32
                {
                mT__32(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:58: T__33
                {
                mT__33(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:64: T__34
                {
                mT__34(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:70: T__35
                {
                mT__35(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:76: T__36
                {
                mT__36(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:82: T__37
                {
                mT__37(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:88: T__38
                {
                mT__38(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:94: T__39
                {
                mT__39(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:100: T__40
                {
                mT__40(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:106: T__41
                {
                mT__41(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:112: T__42
                {
                mT__42(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:118: T__43
                {
                mT__43(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:124: T__44
                {
                mT__44(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:130: T__45
                {
                mT__45(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:136: T__46
                {
                mT__46(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:142: T__47
                {
                mT__47(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:148: T__48
                {
                mT__48(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:154: T__49
                {
                mT__49(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:160: T__50
                {
                mT__50(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:166: T__51
                {
                mT__51(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:172: T__52
                {
                mT__52(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:178: T__53
                {
                mT__53(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:184: T__54
                {
                mT__54(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:190: T__55
                {
                mT__55(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:196: T__56
                {
                mT__56(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:202: T__57
                {
                mT__57(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:208: T__58
                {
                mT__58(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:214: T__59
                {
                mT__59(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:220: T__60
                {
                mT__60(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:226: T__61
                {
                mT__61(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:232: T__62
                {
                mT__62(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:238: T__63
                {
                mT__63(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:244: T__64
                {
                mT__64(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:250: T__65
                {
                mT__65(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:256: T__66
                {
                mT__66(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:262: T__67
                {
                mT__67(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:268: T__68
                {
                mT__68(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:274: T__69
                {
                mT__69(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:280: T__70
                {
                mT__70(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:286: T__71
                {
                mT__71(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:292: T__72
                {
                mT__72(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:298: T__73
                {
                mT__73(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:304: T__74
                {
                mT__74(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:310: T__75
                {
                mT__75(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:316: T__76
                {
                mT__76(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:322: T__77
                {
                mT__77(); 

                }
                break;
            case 54 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:328: T__78
                {
                mT__78(); 

                }
                break;
            case 55 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:334: T__79
                {
                mT__79(); 

                }
                break;
            case 56 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:340: T__80
                {
                mT__80(); 

                }
                break;
            case 57 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:346: T__81
                {
                mT__81(); 

                }
                break;
            case 58 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:352: T__82
                {
                mT__82(); 

                }
                break;
            case 59 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:358: T__83
                {
                mT__83(); 

                }
                break;
            case 60 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:364: T__84
                {
                mT__84(); 

                }
                break;
            case 61 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:370: T__85
                {
                mT__85(); 

                }
                break;
            case 62 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:376: T__86
                {
                mT__86(); 

                }
                break;
            case 63 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:382: T__87
                {
                mT__87(); 

                }
                break;
            case 64 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:388: T__88
                {
                mT__88(); 

                }
                break;
            case 65 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:394: T__89
                {
                mT__89(); 

                }
                break;
            case 66 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:400: T__90
                {
                mT__90(); 

                }
                break;
            case 67 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:406: T__91
                {
                mT__91(); 

                }
                break;
            case 68 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:412: T__92
                {
                mT__92(); 

                }
                break;
            case 69 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:418: T__93
                {
                mT__93(); 

                }
                break;
            case 70 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:424: T__94
                {
                mT__94(); 

                }
                break;
            case 71 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:430: T__95
                {
                mT__95(); 

                }
                break;
            case 72 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:436: T__96
                {
                mT__96(); 

                }
                break;
            case 73 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:442: T__97
                {
                mT__97(); 

                }
                break;
            case 74 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:448: T__98
                {
                mT__98(); 

                }
                break;
            case 75 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:454: T__99
                {
                mT__99(); 

                }
                break;
            case 76 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:460: T__100
                {
                mT__100(); 

                }
                break;
            case 77 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:467: T__101
                {
                mT__101(); 

                }
                break;
            case 78 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:474: T__102
                {
                mT__102(); 

                }
                break;
            case 79 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:481: T__103
                {
                mT__103(); 

                }
                break;
            case 80 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:488: T__104
                {
                mT__104(); 

                }
                break;
            case 81 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:495: T__105
                {
                mT__105(); 

                }
                break;
            case 82 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:502: T__106
                {
                mT__106(); 

                }
                break;
            case 83 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:509: T__107
                {
                mT__107(); 

                }
                break;
            case 84 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:516: T__108
                {
                mT__108(); 

                }
                break;
            case 85 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:523: T__109
                {
                mT__109(); 

                }
                break;
            case 86 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:530: T__110
                {
                mT__110(); 

                }
                break;
            case 87 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:537: T__111
                {
                mT__111(); 

                }
                break;
            case 88 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:544: T__112
                {
                mT__112(); 

                }
                break;
            case 89 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:551: T__113
                {
                mT__113(); 

                }
                break;
            case 90 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:558: T__114
                {
                mT__114(); 

                }
                break;
            case 91 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:565: T__115
                {
                mT__115(); 

                }
                break;
            case 92 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:572: T__116
                {
                mT__116(); 

                }
                break;
            case 93 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:579: T__117
                {
                mT__117(); 

                }
                break;
            case 94 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:586: T__118
                {
                mT__118(); 

                }
                break;
            case 95 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:593: T__119
                {
                mT__119(); 

                }
                break;
            case 96 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:600: T__120
                {
                mT__120(); 

                }
                break;
            case 97 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:607: T__121
                {
                mT__121(); 

                }
                break;
            case 98 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:614: RULE_RICH_TEXT
                {
                mRULE_RICH_TEXT(); 

                }
                break;
            case 99 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:629: RULE_RICH_TEXT_START
                {
                mRULE_RICH_TEXT_START(); 

                }
                break;
            case 100 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:650: RULE_RICH_TEXT_END
                {
                mRULE_RICH_TEXT_END(); 

                }
                break;
            case 101 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:669: RULE_RICH_TEXT_INBETWEEN
                {
                mRULE_RICH_TEXT_INBETWEEN(); 

                }
                break;
            case 102 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:694: RULE_COMMENT_RICH_TEXT_INBETWEEN
                {
                mRULE_COMMENT_RICH_TEXT_INBETWEEN(); 

                }
                break;
            case 103 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:727: RULE_COMMENT_RICH_TEXT_END
                {
                mRULE_COMMENT_RICH_TEXT_END(); 

                }
                break;
            case 104 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:754: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 105 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:763: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 106 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:772: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 107 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:785: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 108 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:793: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 109 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:805: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 110 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:821: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 111 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:837: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 112 :
                // ../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g:1:845: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA51 dfa51 = new DFA51(this);
    static final String DFA51_eotS =
        "\1\uffff\1\72\1\uffff\1\72\1\101\1\uffff\1\104\2\72\2\uffff\1\72"+
        "\1\122\2\uffff\7\72\1\146\1\150\6\72\4\uffff\1\165\1\170\1\172\1"+
        "\174\1\176\1\u0081\1\u0083\1\u0086\1\uffff\2\72\1\66\1\u008e\1\66"+
        "\2\u0093\1\66\1\uffff\1\66\2\uffff\3\72\2\uffff\3\72\1\u009f\5\uffff"+
        "\5\72\1\u00a6\2\uffff\2\72\1\u00a9\1\u00ab\4\uffff\12\72\1\u00b7"+
        "\5\72\2\uffff\1\u00c0\1\uffff\6\72\1\u00c7\15\uffff\1\u00c9\12\uffff"+
        "\2\72\1\u008b\1\uffff\2\u008e\2\uffff\1\u00d2\1\uffff\1\u0093\3"+
        "\uffff\10\72\2\uffff\6\72\1\uffff\2\72\3\uffff\2\72\1\u00e6\1\72"+
        "\1\u00e8\5\72\1\u00ef\1\uffff\1\72\1\u00f1\1\72\1\u00f3\1\u00f4"+
        "\1\72\3\uffff\1\u00f6\5\72\3\uffff\2\72\1\u0102\2\u008e\1\u00d2"+
        "\1\uffff\1\u0106\1\uffff\6\72\1\u010d\2\72\1\u0110\1\u0111\7\72"+
        "\1\u0119\1\uffff\1\72\1\uffff\1\u011b\5\72\1\uffff\1\72\1\uffff"+
        "\1\72\2\uffff\1\72\1\uffff\5\72\1\u012a\2\72\2\u0102\2\uffff\1\u008e"+
        "\2\u0106\1\uffff\4\72\1\u0135\1\72\1\uffff\1\u0137\1\72\2\uffff"+
        "\6\72\1\u0141\1\uffff\1\72\1\uffff\2\72\1\u0145\2\72\1\u0149\1\u014a"+
        "\3\72\1\u014e\1\72\1\u0150\1\72\1\uffff\1\u0152\1\72\2\u0102\2\u0106"+
        "\1\72\1\u0157\2\72\1\uffff\1\u015a\1\uffff\3\72\1\u015e\4\72\1\u0163"+
        "\1\uffff\1\u0164\1\u0165\1\u0166\1\uffff\3\72\2\uffff\1\72\1\u016b"+
        "\1\72\1\uffff\1\u016d\1\uffff\1\u016e\1\uffff\1\u016f\1\u0102\1"+
        "\u0106\1\u0170\1\uffff\1\u0171\1\72\1\uffff\1\u0173\2\72\1\uffff"+
        "\4\72\4\uffff\1\72\1\u017b\1\u017c\1\72\1\uffff\1\72\5\uffff\1\72"+
        "\1\uffff\5\72\1\u0185\1\u0186\2\uffff\1\u0187\1\72\1\u0189\1\u018a"+
        "\1\72\1\u018c\2\72\3\uffff\1\u018f\2\uffff\1\u0190\1\uffff\1\u0191"+
        "\1\u0192\4\uffff";
    static final String DFA51_eofS =
        "\u0193\uffff";
    static final String DFA51_minS =
        "\1\0\1\141\1\uffff\1\141\1\75\1\uffff\1\75\1\154\1\146\2\uffff\1"+
        "\142\1\75\2\uffff\1\150\1\145\1\164\1\145\2\141\1\166\1\72\1\56"+
        "\1\117\2\105\1\106\1\114\1\106\4\uffff\2\75\1\174\1\46\1\75\1\56"+
        "\2\52\1\uffff\1\150\1\145\2\0\1\u00ab\2\60\1\44\1\uffff\1\0\2\uffff"+
        "\1\143\1\142\1\151\2\uffff\1\141\1\145\1\163\1\76\5\uffff\1\164"+
        "\1\165\1\163\1\160\1\163\1\44\2\uffff\1\156\1\163\1\44\1\75\4\uffff"+
        "\1\162\1\165\1\160\1\167\1\154\1\141\1\151\1\160\1\163\1\146\1\44"+
        "\1\156\1\162\2\154\1\145\2\uffff\1\56\1\uffff\1\122\1\106\1\120"+
        "\1\124\1\104\1\123\1\44\15\uffff\1\75\12\uffff\1\151\1\164\1\47"+
        "\1\uffff\2\0\2\uffff\1\0\1\uffff\1\60\3\uffff\1\153\1\154\1\166"+
        "\1\164\1\163\1\141\1\145\1\143\2\uffff\1\145\1\155\1\145\1\154\1"+
        "\145\1\164\1\uffff\1\157\1\164\3\uffff\1\157\1\145\1\44\1\145\1"+
        "\44\1\154\2\164\1\145\1\160\1\44\1\uffff\1\141\1\44\1\163\2\44\1"+
        "\162\3\uffff\1\44\1\117\1\101\1\105\1\106\1\105\3\uffff\1\154\1"+
        "\165\4\0\1\12\1\0\1\uffff\1\141\1\151\1\141\1\145\1\163\1\164\1"+
        "\44\1\150\1\156\2\44\1\145\2\162\1\141\1\164\1\162\1\167\1\44\1"+
        "\uffff\1\157\1\uffff\1\44\1\151\1\143\1\162\1\141\1\165\1\uffff"+
        "\1\154\1\uffff\1\145\2\uffff\1\162\1\uffff\3\122\1\117\1\106\1\44"+
        "\1\145\1\162\2\0\2\uffff\3\0\1\uffff\1\147\1\143\1\164\1\143\1\44"+
        "\1\145\1\uffff\1\44\1\144\2\uffff\1\155\1\164\1\146\1\156\2\141"+
        "\1\44\1\uffff\1\146\1\uffff\1\143\1\150\1\44\1\164\1\154\2\44\1"+
        "\151\1\105\1\101\1\44\1\122\1\44\1\106\1\uffff\1\44\1\156\4\0\1"+
        "\145\1\44\1\145\1\164\1\uffff\1\44\1\uffff\1\163\1\151\1\145\1\44"+
        "\1\141\1\143\1\164\1\143\1\44\1\uffff\3\44\1\uffff\1\143\1\164\1"+
        "\171\2\uffff\1\144\1\44\1\124\1\uffff\1\44\1\uffff\1\44\1\uffff"+
        "\1\44\2\0\1\44\1\uffff\1\44\1\145\1\uffff\1\44\1\157\1\156\1\uffff"+
        "\1\143\1\145\1\151\1\164\4\uffff\1\150\2\44\1\145\1\uffff\1\117"+
        "\5\uffff\1\144\1\uffff\1\156\1\164\1\145\2\157\2\44\2\uffff\1\44"+
        "\1\122\2\44\1\163\1\44\1\146\1\156\3\uffff\1\44\2\uffff\1\44\1\uffff"+
        "\2\44\4\uffff";
    static final String DFA51_maxS =
        "\1\uffff\1\165\1\uffff\1\162\1\76\1\uffff\1\75\1\170\1\156\2\uffff"+
        "\1\163\1\76\2\uffff\1\171\1\165\1\167\2\157\1\141\1\166\1\72\1\56"+
        "\1\117\2\105\1\106\1\116\1\106\4\uffff\1\75\1\76\1\174\1\46\1\75"+
        "\1\72\1\52\1\57\1\uffff\1\150\1\145\2\uffff\1\u00ab\1\170\1\154"+
        "\1\172\1\uffff\1\uffff\2\uffff\1\143\1\142\1\157\2\uffff\1\141\1"+
        "\145\1\164\1\76\5\uffff\1\164\1\165\1\163\1\160\1\164\1\172\2\uffff"+
        "\1\156\1\163\1\172\1\75\4\uffff\1\162\1\171\1\160\1\167\1\154\1"+
        "\141\1\151\1\160\1\163\1\146\1\172\1\156\1\162\1\154\1\162\1\145"+
        "\2\uffff\1\74\1\uffff\1\122\1\106\1\120\1\124\1\104\1\123\1\172"+
        "\15\uffff\1\75\12\uffff\1\151\1\164\1\47\1\uffff\2\uffff\2\uffff"+
        "\1\uffff\1\uffff\1\154\3\uffff\1\153\1\154\1\166\1\164\1\163\1\141"+
        "\1\145\1\143\2\uffff\1\145\1\155\1\145\1\157\1\145\1\164\1\uffff"+
        "\1\157\1\164\3\uffff\1\157\1\145\1\172\1\145\1\172\1\154\2\164\1"+
        "\145\1\160\1\172\1\uffff\1\141\1\172\1\163\2\172\1\162\3\uffff\1"+
        "\172\1\117\1\101\1\105\1\111\1\105\3\uffff\1\154\1\165\4\uffff\1"+
        "\12\1\uffff\1\uffff\1\141\1\151\1\141\1\145\1\163\1\164\1\172\1"+
        "\150\1\156\2\172\1\145\2\162\1\141\1\164\1\162\1\167\1\172\1\uffff"+
        "\1\157\1\uffff\1\172\1\151\1\143\1\162\1\141\1\165\1\uffff\1\154"+
        "\1\uffff\1\145\2\uffff\1\162\1\uffff\3\122\1\117\1\106\1\172\1\145"+
        "\1\162\2\uffff\2\uffff\3\uffff\1\uffff\1\147\1\143\1\164\1\143\1"+
        "\172\1\145\1\uffff\1\172\1\163\2\uffff\1\155\1\164\1\146\1\156\2"+
        "\141\1\172\1\uffff\1\146\1\uffff\1\143\1\150\1\172\1\164\1\154\2"+
        "\172\1\151\1\105\1\101\1\172\1\122\1\172\1\106\1\uffff\1\172\1\156"+
        "\4\uffff\1\145\1\172\1\145\1\164\1\uffff\1\172\1\uffff\1\163\1\151"+
        "\1\145\1\172\1\141\1\143\1\164\1\143\1\172\1\uffff\3\172\1\uffff"+
        "\1\143\1\164\1\171\2\uffff\1\144\1\172\1\124\1\uffff\1\172\1\uffff"+
        "\1\172\1\uffff\1\172\2\uffff\1\172\1\uffff\1\172\1\145\1\uffff\1"+
        "\172\1\157\1\156\1\uffff\1\143\1\145\1\151\1\164\4\uffff\1\150\2"+
        "\172\1\145\1\uffff\1\117\5\uffff\1\144\1\uffff\1\156\1\164\1\145"+
        "\2\157\2\172\2\uffff\1\172\1\122\2\172\1\163\1\172\1\146\1\156\3"+
        "\uffff\1\172\2\uffff\1\172\1\uffff\2\172\4\uffff";
    static final String DFA51_acceptS =
        "\2\uffff\1\2\2\uffff\1\5\3\uffff\1\11\1\12\2\uffff\1\20\1\21\17"+
        "\uffff\1\54\1\55\1\56\1\57\10\uffff\1\107\10\uffff\1\153\1\uffff"+
        "\1\157\1\160\3\uffff\1\153\1\2\4\uffff\1\77\1\4\1\5\1\71\1\6\6\uffff"+
        "\1\11\1\12\4\uffff\1\76\1\16\1\20\1\21\20\uffff\1\113\1\40\1\uffff"+
        "\1\112\7\uffff\1\54\1\55\1\56\1\57\1\60\1\102\1\61\1\73\1\103\1"+
        "\62\1\115\1\63\1\141\1\uffff\1\110\1\100\1\114\1\140\1\105\1\104"+
        "\1\155\1\156\1\106\1\107\3\uffff\1\154\2\uffff\1\144\1\145\1\uffff"+
        "\1\150\1\uffff\1\151\1\152\1\157\10\uffff\1\101\1\72\6\uffff\1\116"+
        "\2\uffff\1\111\1\66\1\64\13\uffff\1\125\6\uffff\1\42\1\74\1\75\6"+
        "\uffff\1\50\1\67\1\65\10\uffff\1\146\23\uffff\1\135\1\uffff\1\23"+
        "\6\uffff\1\35\1\uffff\1\123\1\uffff\1\33\1\34\1\uffff\1\43\12\uffff"+
        "\1\143\1\142\3\uffff\1\147\6\uffff\1\122\2\uffff\1\14\1\117\7\uffff"+
        "\1\130\1\uffff\1\131\16\uffff\1\51\12\uffff\1\3\1\uffff\1\137\11"+
        "\uffff\1\133\3\uffff\1\126\3\uffff\1\32\1\127\3\uffff\1\46\1\uffff"+
        "\1\52\1\uffff\1\124\4\uffff\1\24\2\uffff\1\37\3\uffff\1\41\4\uffff"+
        "\1\22\1\132\1\30\1\120\4\uffff\1\44\1\uffff\1\47\1\53\1\134\1\1"+
        "\1\25\1\uffff\1\7\7\uffff\1\121\1\136\10\uffff\1\27\1\31\1\36\1"+
        "\uffff\1\26\1\17\1\uffff\1\13\2\uffff\1\45\1\10\1\70\1\15";
    static final String DFA51_specialS =
        "\1\0\54\uffff\1\16\1\2\5\uffff\1\1\127\uffff\1\25\1\15\2\uffff\1"+
        "\4\73\uffff\1\10\1\3\1\14\1\11\1\uffff\1\7\55\uffff\1\13\1\26\2"+
        "\uffff\1\17\1\20\1\6\47\uffff\1\22\1\23\1\21\1\5\43\uffff\1\24\1"+
        "\12\75\uffff}>";
    static final String[] DFA51_transitionS = {
            "\11\66\2\65\2\66\1\65\22\66\1\65\1\46\1\64\1\37\1\63\1\52\1"+
            "\45\1\55\1\15\1\16\1\50\1\42\1\5\1\43\1\27\1\51\1\60\11\61\1"+
            "\26\1\2\1\4\1\14\1\6\1\47\1\36\1\33\1\31\2\63\1\34\1\30\2\63"+
            "\1\35\11\63\1\32\7\63\1\40\1\66\1\41\1\62\1\63\1\66\1\13\1\63"+
            "\1\3\1\22\1\7\1\23\2\63\1\10\4\63\1\20\1\25\1\1\1\63\1\54\1"+
            "\21\1\17\1\63\1\24\1\53\3\63\1\11\1\44\1\12\55\66\1\57\17\66"+
            "\1\56\uff44\66",
            "\1\67\20\uffff\1\71\2\uffff\1\70",
            "",
            "\1\76\12\uffff\1\74\5\uffff\1\75",
            "\1\77\1\100",
            "",
            "\1\103",
            "\1\107\1\uffff\1\106\11\uffff\1\105",
            "\1\112\6\uffff\1\110\1\111",
            "",
            "",
            "\1\116\13\uffff\1\115\4\uffff\1\117",
            "\1\120\1\121",
            "",
            "",
            "\1\125\11\uffff\1\126\6\uffff\1\127",
            "\1\130\17\uffff\1\131",
            "\1\132\1\134\1\uffff\1\133",
            "\1\136\3\uffff\1\135\5\uffff\1\137",
            "\1\142\7\uffff\1\140\5\uffff\1\141",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\147",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\156\1\uffff\1\155",
            "\1\157",
            "",
            "",
            "",
            "",
            "\1\164",
            "\1\166\1\167",
            "\1\171",
            "\1\173",
            "\1\175",
            "\1\u0080\13\uffff\1\177",
            "\1\u0082",
            "\1\u0084\4\uffff\1\u0085",
            "",
            "\1\u0088",
            "\1\u0089",
            "\47\u008b\1\u008a\uffd8\u008b",
            "\47\u008d\1\u008c\u0083\u008d\1\u008f\uff54\u008d",
            "\1\u0090",
            "\12\u0092\10\uffff\1\u0094\1\uffff\3\u0094\5\uffff\1\u0094"+
            "\13\uffff\1\u0091\6\uffff\1\u0092\2\uffff\1\u0094\1\uffff\3"+
            "\u0094\5\uffff\1\u0094\13\uffff\1\u0091",
            "\12\u0092\10\uffff\1\u0094\1\uffff\3\u0094\5\uffff\1\u0094"+
            "\22\uffff\1\u0092\2\uffff\1\u0094\1\uffff\3\u0094\5\uffff\1"+
            "\u0094",
            "\1\72\34\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\0\u008b",
            "",
            "",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098\5\uffff\1\u0099",
            "",
            "",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c\1\u009d",
            "\1\u009e",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a5\1\u00a4",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "",
            "\1\u00a7",
            "\1\u00a8",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u00aa",
            "",
            "",
            "",
            "",
            "\1\u00ac",
            "\1\u00ad\3\uffff\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb\5\uffff\1\u00bc",
            "\1\u00bd",
            "",
            "",
            "\1\u00be\15\uffff\1\u00bf",
            "",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
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
            "\1\u00c8",
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
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "",
            "\47\u00ce\1\u00cd\u0083\u00ce\1\u008f\uff54\u00ce",
            "\47\u008d\1\u008c\u0083\u008d\1\u008f\uff54\u008d",
            "",
            "",
            "\12\u00cf\1\u00d1\2\u00cf\1\u00d0\ufff2\u00cf",
            "",
            "\12\u0092\10\uffff\1\u0094\1\uffff\3\u0094\5\uffff\1\u0094"+
            "\22\uffff\1\u0092\2\uffff\1\u0094\1\uffff\3\u0094\5\uffff\1"+
            "\u0094",
            "",
            "",
            "",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "",
            "",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de\2\uffff\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "",
            "\1\u00e2",
            "\1\u00e3",
            "",
            "",
            "",
            "\1\u00e4",
            "\1\u00e5",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u00e7",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u00ee"+
            "\31\72",
            "",
            "\1\u00f0",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u00f2",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u00f5",
            "",
            "",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa\2\uffff\1\u00fb",
            "\1\u00fc",
            "",
            "",
            "",
            "\1\u00fd",
            "\1\u00fe",
            "\47\u0100\1\u00ff\u0083\u0100\1\u0101\uff54\u0100",
            "\47\u0103\1\uffff\u0083\u0103\1\u008f\uff54\u0103",
            "\47\u008d\1\u008c\u0083\u008d\1\u008f\uff54\u008d",
            "\12\u00cf\1\u00d1\2\u00cf\1\u00d0\ufff2\u00cf",
            "\1\u00d1",
            "\47\u0105\1\u0104\u0083\u0105\1\u00d2\uff54\u0105",
            "",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u010e",
            "\1\u010f",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "\1\u011a",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "",
            "\1\u0121",
            "",
            "\1\u0122",
            "",
            "",
            "\1\u0123",
            "",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\72\13\uffff\12\72\7\uffff\10\72\1\u0129\21\72\4\uffff\1"+
            "\72\1\uffff\32\72",
            "\1\u012b",
            "\1\u012c",
            "\47\u012e\1\u012d\u0083\u012e\1\u0101\uff54\u012e",
            "\47\u0100\1\u00ff\u0083\u0100\1\u0101\uff54\u0100",
            "",
            "",
            "\47\u008d\1\u008c\u0083\u008d\1\u008f\uff54\u008d",
            "\47\u0130\1\u012f\u0083\u0130\1\u00d2\uff54\u0130",
            "\47\u0105\1\u0104\u0083\u0105\1\u00d2\uff54\u0105",
            "",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u0136",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u0138\16\uffff\1\u0139",
            "",
            "",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\22"+
            "\72\1\u0140\7\72",
            "",
            "\1\u0142",
            "",
            "\1\u0143",
            "\1\u0144",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u0146",
            "\1\u0147",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\13"+
            "\72\1\u0148\16\72",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u014f",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u0151",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u0153",
            "\47\u0154\1\uffff\u0083\u0154\1\u0101\uff54\u0154",
            "\47\u0100\1\u00ff\u0083\u0100\1\u0101\uff54\u0100",
            "\47\u0155\1\uffff\u0083\u0155\1\u00d2\uff54\u0155",
            "\47\u0105\1\u0104\u0083\u0105\1\u00d2\uff54\u0105",
            "\1\u0156",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u0158",
            "\1\u0159",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "",
            "",
            "\1\u016a",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u016c",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\47\u0100\1\u00ff\u0083\u0100\1\u0101\uff54\u0100",
            "\47\u0105\1\u0104\u0083\u0105\1\u00d2\uff54\u0105",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u0172",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u0174",
            "\1\u0175",
            "",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "",
            "",
            "",
            "",
            "\1\u017a",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u017d",
            "",
            "\1\u017e",
            "",
            "",
            "",
            "",
            "",
            "\1\u017f",
            "",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u0188",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u018b",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\u018d",
            "\1\u018e",
            "",
            "",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "\1\72\13\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32"+
            "\72",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | RULE_RICH_TEXT | RULE_RICH_TEXT_START | RULE_RICH_TEXT_END | RULE_RICH_TEXT_INBETWEEN | RULE_COMMENT_RICH_TEXT_INBETWEEN | RULE_COMMENT_RICH_TEXT_END | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_0 = input.LA(1);

                        s = -1;
                        if ( (LA51_0=='p') ) {s = 1;}

                        else if ( (LA51_0==';') ) {s = 2;}

                        else if ( (LA51_0=='c') ) {s = 3;}

                        else if ( (LA51_0=='<') ) {s = 4;}

                        else if ( (LA51_0==',') ) {s = 5;}

                        else if ( (LA51_0=='>') ) {s = 6;}

                        else if ( (LA51_0=='e') ) {s = 7;}

                        else if ( (LA51_0=='i') ) {s = 8;}

                        else if ( (LA51_0=='{') ) {s = 9;}

                        else if ( (LA51_0=='}') ) {s = 10;}

                        else if ( (LA51_0=='a') ) {s = 11;}

                        else if ( (LA51_0=='=') ) {s = 12;}

                        else if ( (LA51_0=='(') ) {s = 13;}

                        else if ( (LA51_0==')') ) {s = 14;}

                        else if ( (LA51_0=='t') ) {s = 15;}

                        else if ( (LA51_0=='n') ) {s = 16;}

                        else if ( (LA51_0=='s') ) {s = 17;}

                        else if ( (LA51_0=='d') ) {s = 18;}

                        else if ( (LA51_0=='f') ) {s = 19;}

                        else if ( (LA51_0=='v') ) {s = 20;}

                        else if ( (LA51_0=='o') ) {s = 21;}

                        else if ( (LA51_0==':') ) {s = 22;}

                        else if ( (LA51_0=='.') ) {s = 23;}

                        else if ( (LA51_0=='F') ) {s = 24;}

                        else if ( (LA51_0=='B') ) {s = 25;}

                        else if ( (LA51_0=='S') ) {s = 26;}

                        else if ( (LA51_0=='A') ) {s = 27;}

                        else if ( (LA51_0=='E') ) {s = 28;}

                        else if ( (LA51_0=='I') ) {s = 29;}

                        else if ( (LA51_0=='@') ) {s = 30;}

                        else if ( (LA51_0=='#') ) {s = 31;}

                        else if ( (LA51_0=='[') ) {s = 32;}

                        else if ( (LA51_0==']') ) {s = 33;}

                        else if ( (LA51_0=='+') ) {s = 34;}

                        else if ( (LA51_0=='-') ) {s = 35;}

                        else if ( (LA51_0=='|') ) {s = 36;}

                        else if ( (LA51_0=='&') ) {s = 37;}

                        else if ( (LA51_0=='!') ) {s = 38;}

                        else if ( (LA51_0=='?') ) {s = 39;}

                        else if ( (LA51_0=='*') ) {s = 40;}

                        else if ( (LA51_0=='/') ) {s = 41;}

                        else if ( (LA51_0=='%') ) {s = 42;}

                        else if ( (LA51_0=='w') ) {s = 43;}

                        else if ( (LA51_0=='r') ) {s = 44;}

                        else if ( (LA51_0=='\'') ) {s = 45;}

                        else if ( (LA51_0=='\u00BB') ) {s = 46;}

                        else if ( (LA51_0=='\u00AB') ) {s = 47;}

                        else if ( (LA51_0=='0') ) {s = 48;}

                        else if ( ((LA51_0>='1' && LA51_0<='9')) ) {s = 49;}

                        else if ( (LA51_0=='^') ) {s = 50;}

                        else if ( (LA51_0=='$'||(LA51_0>='C' && LA51_0<='D')||(LA51_0>='G' && LA51_0<='H')||(LA51_0>='J' && LA51_0<='R')||(LA51_0>='T' && LA51_0<='Z')||LA51_0=='_'||LA51_0=='b'||(LA51_0>='g' && LA51_0<='h')||(LA51_0>='j' && LA51_0<='m')||LA51_0=='q'||LA51_0=='u'||(LA51_0>='x' && LA51_0<='z')) ) {s = 51;}

                        else if ( (LA51_0=='\"') ) {s = 52;}

                        else if ( ((LA51_0>='\t' && LA51_0<='\n')||LA51_0=='\r'||LA51_0==' ') ) {s = 53;}

                        else if ( ((LA51_0>='\u0000' && LA51_0<='\b')||(LA51_0>='\u000B' && LA51_0<='\f')||(LA51_0>='\u000E' && LA51_0<='\u001F')||LA51_0=='\\'||LA51_0=='`'||(LA51_0>='~' && LA51_0<='\u00AA')||(LA51_0>='\u00AC' && LA51_0<='\u00BA')||(LA51_0>='\u00BC' && LA51_0<='\uFFFF')) ) {s = 54;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA51_52 = input.LA(1);

                        s = -1;
                        if ( ((LA51_52>='\u0000' && LA51_52<='\uFFFF')) ) {s = 139;}

                        else s = 54;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA51_46 = input.LA(1);

                        s = -1;
                        if ( (LA51_46=='\'') ) {s = 140;}

                        else if ( ((LA51_46>='\u0000' && LA51_46<='&')||(LA51_46>='(' && LA51_46<='\u00AA')||(LA51_46>='\u00AC' && LA51_46<='\uFFFF')) ) {s = 141;}

                        else if ( (LA51_46=='\u00AB') ) {s = 143;}

                        else s = 142;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA51_205 = input.LA(1);

                        s = -1;
                        if ( ((LA51_205>='\u0000' && LA51_205<='&')||(LA51_205>='(' && LA51_205<='\u00AA')||(LA51_205>='\u00AC' && LA51_205<='\uFFFF')) ) {s = 259;}

                        else if ( (LA51_205=='\u00AB') ) {s = 143;}

                        else s = 142;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA51_144 = input.LA(1);

                        s = -1;
                        if ( ((LA51_144>='\u0000' && LA51_144<='\t')||(LA51_144>='\u000B' && LA51_144<='\f')||(LA51_144>='\u000E' && LA51_144<='\uFFFF')) ) {s = 207;}

                        else if ( (LA51_144=='\r') ) {s = 208;}

                        else if ( (LA51_144=='\n') ) {s = 209;}

                        else s = 210;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA51_304 = input.LA(1);

                        s = -1;
                        if ( (LA51_304=='\'') ) {s = 260;}

                        else if ( ((LA51_304>='\u0000' && LA51_304<='&')||(LA51_304>='(' && LA51_304<='\u00AA')||(LA51_304>='\u00AC' && LA51_304<='\uFFFF')) ) {s = 261;}

                        else if ( (LA51_304=='\u00AB') ) {s = 210;}

                        else s = 262;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA51_261 = input.LA(1);

                        s = -1;
                        if ( (LA51_261=='\'') ) {s = 260;}

                        else if ( (LA51_261=='\u00AB') ) {s = 210;}

                        else if ( ((LA51_261>='\u0000' && LA51_261<='&')||(LA51_261>='(' && LA51_261<='\u00AA')||(LA51_261>='\u00AC' && LA51_261<='\uFFFF')) ) {s = 261;}

                        else s = 262;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA51_209 = input.LA(1);

                        s = -1;
                        if ( (LA51_209=='\'') ) {s = 260;}

                        else if ( ((LA51_209>='\u0000' && LA51_209<='&')||(LA51_209>='(' && LA51_209<='\u00AA')||(LA51_209>='\u00AC' && LA51_209<='\uFFFF')) ) {s = 261;}

                        else if ( (LA51_209=='\u00AB') ) {s = 210;}

                        else s = 262;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA51_204 = input.LA(1);

                        s = -1;
                        if ( (LA51_204=='\'') ) {s = 255;}

                        else if ( ((LA51_204>='\u0000' && LA51_204<='&')||(LA51_204>='(' && LA51_204<='\u00AA')||(LA51_204>='\u00AC' && LA51_204<='\uFFFF')) ) {s = 256;}

                        else if ( (LA51_204=='\u00AB') ) {s = 257;}

                        else s = 258;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA51_207 = input.LA(1);

                        s = -1;
                        if ( (LA51_207=='\r') ) {s = 208;}

                        else if ( (LA51_207=='\n') ) {s = 209;}

                        else if ( ((LA51_207>='\u0000' && LA51_207<='\t')||(LA51_207>='\u000B' && LA51_207<='\f')||(LA51_207>='\u000E' && LA51_207<='\uFFFF')) ) {s = 207;}

                        else s = 210;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA51_341 = input.LA(1);

                        s = -1;
                        if ( (LA51_341=='\'') ) {s = 260;}

                        else if ( ((LA51_341>='\u0000' && LA51_341<='&')||(LA51_341>='(' && LA51_341<='\u00AA')||(LA51_341>='\u00AC' && LA51_341<='\uFFFF')) ) {s = 261;}

                        else if ( (LA51_341=='\u00AB') ) {s = 210;}

                        else s = 262;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA51_255 = input.LA(1);

                        s = -1;
                        if ( (LA51_255=='\'') ) {s = 301;}

                        else if ( ((LA51_255>='\u0000' && LA51_255<='&')||(LA51_255>='(' && LA51_255<='\u00AA')||(LA51_255>='\u00AC' && LA51_255<='\uFFFF')) ) {s = 302;}

                        else if ( (LA51_255=='\u00AB') ) {s = 257;}

                        else s = 258;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA51_206 = input.LA(1);

                        s = -1;
                        if ( (LA51_206=='\'') ) {s = 140;}

                        else if ( ((LA51_206>='\u0000' && LA51_206<='&')||(LA51_206>='(' && LA51_206<='\u00AA')||(LA51_206>='\u00AC' && LA51_206<='\uFFFF')) ) {s = 141;}

                        else if ( (LA51_206=='\u00AB') ) {s = 143;}

                        else s = 142;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA51_141 = input.LA(1);

                        s = -1;
                        if ( (LA51_141=='\'') ) {s = 140;}

                        else if ( ((LA51_141>='\u0000' && LA51_141<='&')||(LA51_141>='(' && LA51_141<='\u00AA')||(LA51_141>='\u00AC' && LA51_141<='\uFFFF')) ) {s = 141;}

                        else if ( (LA51_141=='\u00AB') ) {s = 143;}

                        else s = 142;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA51_45 = input.LA(1);

                        s = -1;
                        if ( (LA51_45=='\'') ) {s = 138;}

                        else if ( ((LA51_45>='\u0000' && LA51_45<='&')||(LA51_45>='(' && LA51_45<='\uFFFF')) ) {s = 139;}

                        else s = 54;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA51_259 = input.LA(1);

                        s = -1;
                        if ( (LA51_259=='\'') ) {s = 140;}

                        else if ( ((LA51_259>='\u0000' && LA51_259<='&')||(LA51_259>='(' && LA51_259<='\u00AA')||(LA51_259>='\u00AC' && LA51_259<='\uFFFF')) ) {s = 141;}

                        else if ( (LA51_259=='\u00AB') ) {s = 143;}

                        else s = 142;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA51_260 = input.LA(1);

                        s = -1;
                        if ( (LA51_260=='\'') ) {s = 303;}

                        else if ( ((LA51_260>='\u0000' && LA51_260<='&')||(LA51_260>='(' && LA51_260<='\u00AA')||(LA51_260>='\u00AC' && LA51_260<='\uFFFF')) ) {s = 304;}

                        else if ( (LA51_260=='\u00AB') ) {s = 210;}

                        else s = 262;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA51_303 = input.LA(1);

                        s = -1;
                        if ( ((LA51_303>='\u0000' && LA51_303<='&')||(LA51_303>='(' && LA51_303<='\u00AA')||(LA51_303>='\u00AC' && LA51_303<='\uFFFF')) ) {s = 341;}

                        else if ( (LA51_303=='\u00AB') ) {s = 210;}

                        else s = 262;

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA51_301 = input.LA(1);

                        s = -1;
                        if ( ((LA51_301>='\u0000' && LA51_301<='&')||(LA51_301>='(' && LA51_301<='\u00AA')||(LA51_301>='\u00AC' && LA51_301<='\uFFFF')) ) {s = 340;}

                        else if ( (LA51_301=='\u00AB') ) {s = 257;}

                        else s = 258;

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA51_302 = input.LA(1);

                        s = -1;
                        if ( (LA51_302=='\'') ) {s = 255;}

                        else if ( (LA51_302=='\u00AB') ) {s = 257;}

                        else if ( ((LA51_302>='\u0000' && LA51_302<='&')||(LA51_302>='(' && LA51_302<='\u00AA')||(LA51_302>='\u00AC' && LA51_302<='\uFFFF')) ) {s = 256;}

                        else s = 258;

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA51_340 = input.LA(1);

                        s = -1;
                        if ( (LA51_340=='\'') ) {s = 255;}

                        else if ( (LA51_340=='\u00AB') ) {s = 257;}

                        else if ( ((LA51_340>='\u0000' && LA51_340<='&')||(LA51_340>='(' && LA51_340<='\u00AA')||(LA51_340>='\u00AC' && LA51_340<='\uFFFF')) ) {s = 256;}

                        else s = 258;

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA51_140 = input.LA(1);

                        s = -1;
                        if ( (LA51_140=='\'') ) {s = 205;}

                        else if ( ((LA51_140>='\u0000' && LA51_140<='&')||(LA51_140>='(' && LA51_140<='\u00AA')||(LA51_140>='\u00AC' && LA51_140<='\uFFFF')) ) {s = 206;}

                        else if ( (LA51_140=='\u00AB') ) {s = 143;}

                        else s = 142;

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA51_256 = input.LA(1);

                        s = -1;
                        if ( (LA51_256=='\'') ) {s = 255;}

                        else if ( ((LA51_256>='\u0000' && LA51_256<='&')||(LA51_256>='(' && LA51_256<='\u00AA')||(LA51_256>='\u00AC' && LA51_256<='\uFFFF')) ) {s = 256;}

                        else if ( (LA51_256=='\u00AB') ) {s = 257;}

                        else s = 258;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}