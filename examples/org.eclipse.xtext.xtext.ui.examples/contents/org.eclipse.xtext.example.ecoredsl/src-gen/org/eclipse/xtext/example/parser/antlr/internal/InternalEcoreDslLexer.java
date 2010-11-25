package org.eclipse.xtext.example.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEcoreDslLexer extends Lexer {
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int RULE_STRING=5;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int RULE_READONLY=9;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__17=17;
    public static final int RULE_INT=10;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int RULE_RANDOM=8;
    public static final int RULE_SERIALIZABLE=6;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__44=44;
    public static final int RULE_BAG=7;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int RULE_WS=14;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int RULE_LOCAL=11;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators

    public InternalEcoreDslLexer() {;} 
    public InternalEcoreDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalEcoreDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:11:7: ( 'import' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:11:9: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:12:7: ( '=' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:12:9: '='
            {
            match('='); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:13:7: ( ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:13:9: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:14:7: ( 'package' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:14:9: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:15:7: ( 'nsURI' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:15:9: 'nsURI'
            {
            match("nsURI"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:16:7: ( 'nsPrefix' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:16:9: 'nsPrefix'
            {
            match("nsPrefix"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:17:7: ( '{' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:17:9: '{'
            {
            match('{'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:18:7: ( '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:18:9: '}'
            {
            match('}'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:19:7: ( 'datatype' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:19:9: 'datatype'
            {
            match("datatype"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:20:7: ( ':' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:20:9: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:21:7: ( '@' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:21:9: '@'
            {
            match('@'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:22:7: ( '(' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:22:9: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:23:7: ( ',' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:23:9: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:24:7: ( ')' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:24:9: ')'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:25:7: ( 'abstract' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:25:9: 'abstract'
            {
            match("abstract"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:26:7: ( 'interface' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:26:9: 'interface'
            {
            match("interface"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:27:7: ( 'class' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:27:9: 'class'
            {
            match("class"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:28:7: ( '<' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:28:9: '<'
            {
            match('<'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:29:7: ( '>' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:29:9: '>'
            {
            match('>'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:30:7: ( 'extends' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:30:9: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:31:7: ( 'ID' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:31:9: 'ID'
            {
            match("ID"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:32:7: ( 'volatile' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:32:9: 'volatile'
            {
            match("volatile"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:33:7: ( 'transient' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:33:9: 'transient'
            {
            match("transient"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:34:7: ( 'unsettable' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:34:9: 'unsettable'
            {
            match("unsettable"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:35:7: ( 'derived' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:35:9: 'derived'
            {
            match("derived"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:36:7: ( 'attr' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:36:9: 'attr'
            {
            match("attr"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:37:7: ( '[' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:37:9: '['
            {
            match('['); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:38:7: ( '..' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:38:9: '..'
            {
            match(".."); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:39:7: ( ']' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:39:9: ']'
            {
            match(']'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:40:7: ( 'val' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:40:9: 'val'
            {
            match("val"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:41:7: ( 'ref' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:41:9: 'ref'
            {
            match("ref"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:42:7: ( '#' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:42:9: '#'
            {
            match('#'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:43:7: ( 'enum' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:43:9: 'enum'
            {
            match("enum"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:44:7: ( '?' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:44:9: '?'
            {
            match('?'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:45:7: ( 'super' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:45:9: 'super'
            {
            match("super"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:46:7: ( 'op' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:46:9: 'op'
            {
            match("op"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:47:7: ( 'void' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:47:9: 'void'
            {
            match("void"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:48:7: ( 'throws' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:48:9: 'throws'
            {
            match("throws"); 


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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:49:7: ( '.' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:49:9: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:50:7: ( '$' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:50:9: '$'
            {
            match('$'); 

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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:51:7: ( '-' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:51:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "RULE_BAG"
    public final void mRULE_BAG() throws RecognitionException {
        try {
            int _type = RULE_BAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2602:10: ( 'bag' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2602:12: 'bag'
            {
            match("bag"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BAG"

    // $ANTLR start "RULE_RANDOM"
    public final void mRULE_RANDOM() throws RecognitionException {
        try {
            int _type = RULE_RANDOM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2604:13: ( 'random' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2604:15: 'random'
            {
            match("random"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RANDOM"

    // $ANTLR start "RULE_READONLY"
    public final void mRULE_READONLY() throws RecognitionException {
        try {
            int _type = RULE_READONLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2606:15: ( 'readonly' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2606:17: 'readonly'
            {
            match("readonly"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_READONLY"

    // $ANTLR start "RULE_LOCAL"
    public final void mRULE_LOCAL() throws RecognitionException {
        try {
            int _type = RULE_LOCAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2608:12: ( 'local' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2608:14: 'local'
            {
            match("local"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LOCAL"

    // $ANTLR start "RULE_SERIALIZABLE"
    public final void mRULE_SERIALIZABLE() throws RecognitionException {
        try {
            int _type = RULE_SERIALIZABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2610:19: ( '!serializable' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2610:21: '!serializable'
            {
            match("!serializable"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SERIALIZABLE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2612:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2612:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2612:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2612:11: '^'
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2612:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2614:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2614:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2614:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2614:13: '0' .. '9'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2616:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2618:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2618:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2618:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2618:52: .
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2620:41: '\\r'
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2622:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2622:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2622:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:
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
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2624:16: ( . )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2624:18: .
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
        // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | RULE_BAG | RULE_RANDOM | RULE_READONLY | RULE_LOCAL | RULE_SERIALIZABLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=53;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:10: T__16
                {
                mT__16(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:16: T__17
                {
                mT__17(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:22: T__18
                {
                mT__18(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:28: T__19
                {
                mT__19(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:34: T__20
                {
                mT__20(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:40: T__21
                {
                mT__21(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:46: T__22
                {
                mT__22(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:52: T__23
                {
                mT__23(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:58: T__24
                {
                mT__24(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:64: T__25
                {
                mT__25(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:70: T__26
                {
                mT__26(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:76: T__27
                {
                mT__27(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:82: T__28
                {
                mT__28(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:88: T__29
                {
                mT__29(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:94: T__30
                {
                mT__30(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:100: T__31
                {
                mT__31(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:106: T__32
                {
                mT__32(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:112: T__33
                {
                mT__33(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:118: T__34
                {
                mT__34(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:124: T__35
                {
                mT__35(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:130: T__36
                {
                mT__36(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:136: T__37
                {
                mT__37(); 

                }
                break;
            case 23 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:142: T__38
                {
                mT__38(); 

                }
                break;
            case 24 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:148: T__39
                {
                mT__39(); 

                }
                break;
            case 25 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:154: T__40
                {
                mT__40(); 

                }
                break;
            case 26 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:160: T__41
                {
                mT__41(); 

                }
                break;
            case 27 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:166: T__42
                {
                mT__42(); 

                }
                break;
            case 28 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:172: T__43
                {
                mT__43(); 

                }
                break;
            case 29 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:178: T__44
                {
                mT__44(); 

                }
                break;
            case 30 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:184: T__45
                {
                mT__45(); 

                }
                break;
            case 31 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:190: T__46
                {
                mT__46(); 

                }
                break;
            case 32 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:196: T__47
                {
                mT__47(); 

                }
                break;
            case 33 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:202: T__48
                {
                mT__48(); 

                }
                break;
            case 34 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:208: T__49
                {
                mT__49(); 

                }
                break;
            case 35 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:214: T__50
                {
                mT__50(); 

                }
                break;
            case 36 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:220: T__51
                {
                mT__51(); 

                }
                break;
            case 37 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:226: T__52
                {
                mT__52(); 

                }
                break;
            case 38 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:232: T__53
                {
                mT__53(); 

                }
                break;
            case 39 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:238: T__54
                {
                mT__54(); 

                }
                break;
            case 40 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:244: T__55
                {
                mT__55(); 

                }
                break;
            case 41 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:250: T__56
                {
                mT__56(); 

                }
                break;
            case 42 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:256: RULE_BAG
                {
                mRULE_BAG(); 

                }
                break;
            case 43 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:265: RULE_RANDOM
                {
                mRULE_RANDOM(); 

                }
                break;
            case 44 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:277: RULE_READONLY
                {
                mRULE_READONLY(); 

                }
                break;
            case 45 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:291: RULE_LOCAL
                {
                mRULE_LOCAL(); 

                }
                break;
            case 46 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:302: RULE_SERIALIZABLE
                {
                mRULE_SERIALIZABLE(); 

                }
                break;
            case 47 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:320: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 48 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:328: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 49 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:337: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 50 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:349: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 51 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:365: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 52 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:381: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 53 :
                // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1:389: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\56\2\uffff\2\56\2\uffff\1\56\5\uffff\2\56\2\uffff\5\56"+
        "\1\uffff\1\113\1\uffff\1\56\2\uffff\2\56\2\uffff\2\56\2\53\2\uffff"+
        "\3\53\2\uffff\2\56\3\uffff\2\56\2\uffff\2\56\5\uffff\3\56\2\uffff"+
        "\2\56\1\151\5\56\4\uffff\2\56\2\uffff\1\56\1\164\2\uffff\2\56\6"+
        "\uffff\14\56\1\uffff\2\56\1\u0085\3\56\1\u0089\3\56\1\uffff\1\u008d"+
        "\11\56\1\u0097\2\56\1\u009a\1\56\1\u009c\1\uffff\3\56\1\uffff\3"+
        "\56\1\uffff\4\56\1\u00a7\4\56\1\uffff\1\u00ac\1\56\1\uffff\1\56"+
        "\1\uffff\5\56\1\u00b4\1\u00b5\1\u00b6\2\56\1\uffff\4\56\1\uffff"+
        "\3\56\1\u00c0\2\56\1\u00c3\3\uffff\1\56\1\u00c5\2\56\1\u00c8\1\56"+
        "\1\u00ca\2\56\1\uffff\2\56\1\uffff\1\56\1\uffff\1\u00d0\1\u00d1"+
        "\1\uffff\1\u00d2\1\uffff\1\u00d3\2\56\1\u00d6\1\u00d7\4\uffff\1"+
        "\u00d8\1\56\3\uffff\1\u00da\1\uffff";
    static final String DFA12_eofS =
        "\u00db\uffff";
    static final String DFA12_minS =
        "\1\0\1\155\2\uffff\1\141\1\163\2\uffff\1\141\5\uffff\1\142\1\154"+
        "\2\uffff\1\156\1\104\1\141\1\150\1\156\1\uffff\1\56\1\uffff\1\141"+
        "\2\uffff\1\165\1\160\2\uffff\1\141\1\157\1\163\1\101\2\uffff\2\0"+
        "\1\52\2\uffff\1\160\1\164\3\uffff\1\143\1\120\2\uffff\1\164\1\162"+
        "\5\uffff\1\163\1\164\1\141\2\uffff\1\164\1\165\1\60\1\151\1\154"+
        "\1\141\1\162\1\163\4\uffff\1\141\1\156\2\uffff\1\160\1\60\2\uffff"+
        "\1\147\1\143\6\uffff\1\157\1\145\1\153\1\122\1\162\1\141\1\151\1"+
        "\164\1\162\1\163\1\145\1\155\1\uffff\1\141\1\144\1\60\1\156\1\157"+
        "\1\145\1\60\2\144\1\145\1\uffff\1\60\1\141\2\162\1\141\1\111\1\145"+
        "\1\164\1\166\1\162\1\60\1\163\1\156\1\60\1\164\1\60\1\uffff\1\163"+
        "\1\167\1\164\1\uffff\2\157\1\162\1\uffff\1\154\1\164\1\146\1\147"+
        "\1\60\1\146\1\171\1\145\1\141\1\uffff\1\60\1\144\1\uffff\1\151\1"+
        "\uffff\1\151\1\163\1\164\1\156\1\155\3\60\1\141\1\145\1\uffff\1"+
        "\151\1\160\1\144\1\143\1\uffff\1\163\1\154\1\145\1\60\1\141\1\154"+
        "\1\60\3\uffff\1\143\1\60\1\170\1\145\1\60\1\164\1\60\1\145\1\156"+
        "\1\uffff\1\142\1\171\1\uffff\1\145\1\uffff\2\60\1\uffff\1\60\1\uffff"+
        "\1\60\1\164\1\154\2\60\4\uffff\1\60\1\145\3\uffff\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\156\2\uffff\1\141\1\163\2\uffff\1\145\5\uffff\1\164\1"+
        "\154\2\uffff\1\170\1\104\1\157\1\162\1\156\1\uffff\1\56\1\uffff"+
        "\1\145\2\uffff\1\165\1\160\2\uffff\1\141\1\157\1\163\1\172\2\uffff"+
        "\2\uffff\1\57\2\uffff\1\160\1\164\3\uffff\1\143\1\125\2\uffff\1"+
        "\164\1\162\5\uffff\1\163\1\164\1\141\2\uffff\1\164\1\165\1\172\2"+
        "\154\1\141\1\162\1\163\4\uffff\1\146\1\156\2\uffff\1\160\1\172\2"+
        "\uffff\1\147\1\143\6\uffff\1\157\1\145\1\153\1\122\1\162\1\141\1"+
        "\151\1\164\1\162\1\163\1\145\1\155\1\uffff\1\141\1\144\1\172\1\156"+
        "\1\157\1\145\1\172\2\144\1\145\1\uffff\1\172\1\141\2\162\1\141\1"+
        "\111\1\145\1\164\1\166\1\162\1\172\1\163\1\156\1\172\1\164\1\172"+
        "\1\uffff\1\163\1\167\1\164\1\uffff\2\157\1\162\1\uffff\1\154\1\164"+
        "\1\146\1\147\1\172\1\146\1\171\1\145\1\141\1\uffff\1\172\1\144\1"+
        "\uffff\1\151\1\uffff\1\151\1\163\1\164\1\156\1\155\3\172\1\141\1"+
        "\145\1\uffff\1\151\1\160\1\144\1\143\1\uffff\1\163\1\154\1\145\1"+
        "\172\1\141\1\154\1\172\3\uffff\1\143\1\172\1\170\1\145\1\172\1\164"+
        "\1\172\1\145\1\156\1\uffff\1\142\1\171\1\uffff\1\145\1\uffff\2\172"+
        "\1\uffff\1\172\1\uffff\1\172\1\164\1\154\2\172\4\uffff\1\172\1\145"+
        "\3\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\3\2\uffff\1\7\1\10\1\uffff\1\12\1\13\1\14\1\15\1"+
        "\16\2\uffff\1\22\1\23\5\uffff\1\33\1\uffff\1\35\1\uffff\1\40\1\42"+
        "\2\uffff\1\50\1\51\4\uffff\1\57\1\60\3\uffff\1\64\1\65\2\uffff\1"+
        "\57\1\2\1\3\2\uffff\1\7\1\10\2\uffff\1\12\1\13\1\14\1\15\1\16\3"+
        "\uffff\1\22\1\23\10\uffff\1\33\1\34\1\47\1\35\2\uffff\1\40\1\42"+
        "\2\uffff\1\50\1\51\2\uffff\1\56\1\60\1\61\1\62\1\63\1\64\14\uffff"+
        "\1\25\12\uffff\1\44\20\uffff\1\36\3\uffff\1\37\3\uffff\1\52\11\uffff"+
        "\1\32\2\uffff\1\41\1\uffff\1\45\12\uffff\1\5\4\uffff\1\21\7\uffff"+
        "\1\43\1\55\1\1\11\uffff\1\46\2\uffff\1\53\1\uffff\1\4\2\uffff\1"+
        "\31\1\uffff\1\24\5\uffff\1\6\1\11\1\17\1\26\2\uffff\1\54\1\20\1"+
        "\27\1\uffff\1\30";
    static final String DFA12_specialS =
        "\1\2\46\uffff\1\1\1\0\u00b2\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\53\2\52\2\53\1\52\22\53\1\52\1\43\1\47\1\33\1\37\2\53\1"+
            "\50\1\13\1\15\2\53\1\14\1\40\1\30\1\51\12\46\1\11\1\3\1\20\1"+
            "\2\1\21\1\34\1\12\10\45\1\23\21\45\1\27\1\53\1\31\1\44\1\45"+
            "\1\53\1\16\1\41\1\17\1\10\1\22\3\45\1\1\2\45\1\42\1\45\1\5\1"+
            "\36\1\4\1\45\1\32\1\35\1\25\1\26\1\24\4\45\1\6\1\53\1\7\uff82"+
            "\53",
            "\1\54\1\55",
            "",
            "",
            "\1\61",
            "\1\62",
            "",
            "",
            "\1\65\3\uffff\1\66",
            "",
            "",
            "",
            "",
            "",
            "\1\74\21\uffff\1\75",
            "\1\76",
            "",
            "",
            "\1\102\11\uffff\1\101",
            "\1\103",
            "\1\105\15\uffff\1\104",
            "\1\107\11\uffff\1\106",
            "\1\110",
            "",
            "\1\112",
            "",
            "\1\116\3\uffff\1\115",
            "",
            "",
            "\1\121",
            "\1\122",
            "",
            "",
            "\1\125",
            "\1\126",
            "\1\127",
            "\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "\0\131",
            "\0\131",
            "\1\132\4\uffff\1\133",
            "",
            "",
            "\1\135",
            "\1\136",
            "",
            "",
            "",
            "\1\137",
            "\1\141\4\uffff\1\140",
            "",
            "",
            "\1\142",
            "\1\143",
            "",
            "",
            "",
            "",
            "",
            "\1\144",
            "\1\145",
            "\1\146",
            "",
            "",
            "\1\147",
            "\1\150",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\153\2\uffff\1\152",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "",
            "",
            "",
            "\1\161\4\uffff\1\160",
            "\1\162",
            "",
            "",
            "\1\163",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "\1\165",
            "\1\166",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "\1\u0083",
            "\1\u0084",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0098",
            "\1\u0099",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u009b",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00ad",
            "",
            "\1\u00ae",
            "",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00b7",
            "\1\u00b8",
            "",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00c1",
            "\1\u00c2",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "",
            "\1\u00c4",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00c6",
            "\1\u00c7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00c9",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00cb",
            "\1\u00cc",
            "",
            "\1\u00cd",
            "\1\u00ce",
            "",
            "\1\u00cf",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00d4",
            "\1\u00d5",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00d9",
            "",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
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
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | RULE_BAG | RULE_RANDOM | RULE_READONLY | RULE_LOCAL | RULE_SERIALIZABLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_40 = input.LA(1);

                        s = -1;
                        if ( ((LA12_40>='\u0000' && LA12_40<='\uFFFF')) ) {s = 89;}

                        else s = 43;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_39 = input.LA(1);

                        s = -1;
                        if ( ((LA12_39>='\u0000' && LA12_39<='\uFFFF')) ) {s = 89;}

                        else s = 43;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='i') ) {s = 1;}

                        else if ( (LA12_0=='=') ) {s = 2;}

                        else if ( (LA12_0==';') ) {s = 3;}

                        else if ( (LA12_0=='p') ) {s = 4;}

                        else if ( (LA12_0=='n') ) {s = 5;}

                        else if ( (LA12_0=='{') ) {s = 6;}

                        else if ( (LA12_0=='}') ) {s = 7;}

                        else if ( (LA12_0=='d') ) {s = 8;}

                        else if ( (LA12_0==':') ) {s = 9;}

                        else if ( (LA12_0=='@') ) {s = 10;}

                        else if ( (LA12_0=='(') ) {s = 11;}

                        else if ( (LA12_0==',') ) {s = 12;}

                        else if ( (LA12_0==')') ) {s = 13;}

                        else if ( (LA12_0=='a') ) {s = 14;}

                        else if ( (LA12_0=='c') ) {s = 15;}

                        else if ( (LA12_0=='<') ) {s = 16;}

                        else if ( (LA12_0=='>') ) {s = 17;}

                        else if ( (LA12_0=='e') ) {s = 18;}

                        else if ( (LA12_0=='I') ) {s = 19;}

                        else if ( (LA12_0=='v') ) {s = 20;}

                        else if ( (LA12_0=='t') ) {s = 21;}

                        else if ( (LA12_0=='u') ) {s = 22;}

                        else if ( (LA12_0=='[') ) {s = 23;}

                        else if ( (LA12_0=='.') ) {s = 24;}

                        else if ( (LA12_0==']') ) {s = 25;}

                        else if ( (LA12_0=='r') ) {s = 26;}

                        else if ( (LA12_0=='#') ) {s = 27;}

                        else if ( (LA12_0=='?') ) {s = 28;}

                        else if ( (LA12_0=='s') ) {s = 29;}

                        else if ( (LA12_0=='o') ) {s = 30;}

                        else if ( (LA12_0=='$') ) {s = 31;}

                        else if ( (LA12_0=='-') ) {s = 32;}

                        else if ( (LA12_0=='b') ) {s = 33;}

                        else if ( (LA12_0=='l') ) {s = 34;}

                        else if ( (LA12_0=='!') ) {s = 35;}

                        else if ( (LA12_0=='^') ) {s = 36;}

                        else if ( ((LA12_0>='A' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='f' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||LA12_0=='m'||LA12_0=='q'||(LA12_0>='w' && LA12_0<='z')) ) {s = 37;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 38;}

                        else if ( (LA12_0=='\"') ) {s = 39;}

                        else if ( (LA12_0=='\'') ) {s = 40;}

                        else if ( (LA12_0=='/') ) {s = 41;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 42;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='%' && LA12_0<='&')||(LA12_0>='*' && LA12_0<='+')||LA12_0=='\\'||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 43;}

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