// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g 2008-05-14 13:50:30

package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_LEXER_BODY", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_INT", "'lexing'", "':'", "'generate'", "'as'", "'import'", "'returns'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'.'", "'}'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_INT=10;
    public static final int EOF=-1;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=6;

        public InternalXtextGrammarTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g"; }


    private IElementFactory factory;
    public InternalXtextGrammarTestParser(TokenStream input, IElementFactory factory) {
    	this(input);
    	this.factory = factory;
    }




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:23:1: parse returns [Object current] : ruleGrammar EOF ;
    public final Object parse() throws RecognitionException {
        Object current = null;

        Object ruleGrammar1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:23:32: ( ruleGrammar EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:24:2: ruleGrammar EOF
            {
            pushFollow(FOLLOW_ruleGrammar_in_parse43);
            ruleGrammar1=ruleGrammar();
            _fsp--;

            current =ruleGrammar1;
            match(input,EOF,FOLLOW_EOF_in_parse47); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end parse


    // $ANTLR start ruleGrammar
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:27:1: ruleGrammar returns [Object current=null] : ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) ;
    public final Object ruleGrammar() throws RecognitionException {
        Object current = null;

        Object lv_metamodelDeclarations = null;

        Object lv_parserRules = null;

        Object lv_lexerRules = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:27:43: ( ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:27:45: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:29:1: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:30:1: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:30:1: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:31:1: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )*
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:31:1: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:32:2: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar74);
            	    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration();
            	    _fsp--;

            	    if (current==null) {current = factory.create("Grammar");}factory.add(current, "metamodelDeclarations",lv_metamodelDeclarations);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:35:1: (lv_parserRules= ruleParserRule )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:36:2: lv_parserRules= ruleParserRule
            	    {
            	    pushFollow(FOLLOW_ruleParserRule_in_ruleGrammar87);
            	    lv_parserRules=ruleParserRule();
            	    _fsp--;

            	    if (current==null) {current = factory.create("Grammar");}factory.add(current, "parserRules",lv_parserRules);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:39:1: ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:40:1: ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:40:1: ( 'lexing' ':' )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:41:1: 'lexing' ':'
                    {
                    match(input,11,FOLLOW_11_in_ruleGrammar99); 
                    match(input,12,FOLLOW_12_in_ruleGrammar101); 

                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:43:1: (lv_lexerRules= ruleLexerRule )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:44:2: lv_lexerRules= ruleLexerRule
                    	    {
                    	    pushFollow(FOLLOW_ruleLexerRule_in_ruleGrammar110);
                    	    lv_lexerRules=ruleLexerRule();
                    	    _fsp--;

                    	    if (current==null) {current = factory.create("Grammar");}factory.add(current, "lexerRules",lv_lexerRules);

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
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGrammar


    // $ANTLR start ruleAbstractRule
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:48:1: ruleAbstractRule returns [Object current=null] : (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) ;
    public final Object ruleAbstractRule() throws RecognitionException {
        Object current = null;

        Object this_LexerRule = null;

        Object this_ParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:48:48: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:48:50: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:50:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==12) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==RULE_LEXER_BODY) ) {
                        alt5=1;
                    }
                    else if ( ((LA5_2>=RULE_ID && LA5_2<=RULE_STRING)||LA5_2==26||LA5_2==30) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("50:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA5_1==16) ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("50:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("50:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:51:1: this_LexerRule= ruleLexerRule
                    {
                    pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule138);
                    this_LexerRule=ruleLexerRule();
                    _fsp--;

                    current = this_LexerRule;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:52:1: this_ParserRule= ruleParserRule
                    {
                    pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule144);
                    this_ParserRule=ruleParserRule();
                    _fsp--;

                    current = this_ParserRule;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAbstractRule


    // $ANTLR start ruleAbstractMetamodelDeclaration
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:54:1: ruleAbstractMetamodelDeclaration returns [Object current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public final Object ruleAbstractMetamodelDeclaration() throws RecognitionException {
        Object current = null;

        Object this_GeneratedMetamodel = null;

        Object this_ReferencedMetamodel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:54:64: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:54:66: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:56:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                alt6=1;
            }
            else if ( (LA6_0==15) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("56:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:57:1: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration166);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                    current = this_GeneratedMetamodel;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:58:1: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration172);
                    this_ReferencedMetamodel=ruleReferencedMetamodel();
                    _fsp--;

                    current = this_ReferencedMetamodel;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAbstractMetamodelDeclaration


    // $ANTLR start ruleGeneratedMetamodel
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:60:1: ruleGeneratedMetamodel returns [Object current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final Object ruleGeneratedMetamodel() throws RecognitionException {
        Object current = null;

        Token lv_name=null;
        Token lv_nsURI=null;
        Token lv_alias=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:60:54: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:60:56: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:62:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:63:1: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:63:1: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:64:1: ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:64:1: ( 'generate' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:65:1: 'generate' (lv_name= RULE_ID )
            {
            match(input,13,FOLLOW_13_in_ruleGeneratedMetamodel196); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:66:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:67:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel204); 
            if (current==null) {current = factory.create("GeneratedMetamodel");}factory.set(current, "name",lv_name);

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:70:1: (lv_nsURI= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:71:2: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel217); 
            if (current==null) {current = factory.create("GeneratedMetamodel");}factory.set(current, "nsURI",lv_nsURI);

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:1: ( 'as' (lv_alias= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:75:1: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,14,FOLLOW_14_in_ruleGeneratedMetamodel226); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:76:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:77:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel234); 
                    if (current==null) {current = factory.create("GeneratedMetamodel");}factory.set(current, "alias",lv_alias);

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGeneratedMetamodel


    // $ANTLR start ruleReferencedMetamodel
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:81:1: ruleReferencedMetamodel returns [Object current=null] : ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final Object ruleReferencedMetamodel() throws RecognitionException {
        Object current = null;

        Token lv_uri=null;
        Token lv_alias=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:81:55: ( ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:81:57: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:83:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:84:1: ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:84:1: ( 'import' (lv_uri= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:85:1: 'import' (lv_uri= RULE_STRING )
            {
            match(input,15,FOLLOW_15_in_ruleReferencedMetamodel261); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:86:1: (lv_uri= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:87:2: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel269); 
            if (current==null) {current = factory.create("ReferencedMetamodel");}factory.set(current, "uri",lv_uri);

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:90:1: ( 'as' (lv_alias= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==14) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:91:1: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,14,FOLLOW_14_in_ruleReferencedMetamodel278); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:92:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:93:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel286); 
                    if (current==null) {current = factory.create("ReferencedMetamodel");}factory.set(current, "alias",lv_alias);

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleReferencedMetamodel


    // $ANTLR start ruleLexerRule
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:97:1: ruleLexerRule returns [Object current=null] : ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) ) ;
    public final Object ruleLexerRule() throws RecognitionException {
        Object current = null;

        Token lv_name=null;
        Token lv_body=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:97:45: ( ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:97:47: ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:99:1: ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:100:1: ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:100:1: ( (lv_name= RULE_ID ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:101:1: (lv_name= RULE_ID ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:101:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:102:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule319); 
            if (current==null) {current = factory.create("LexerRule");}factory.set(current, "name",lv_name);

            }

            match(input,12,FOLLOW_12_in_ruleLexerRule325); 

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:106:1: (lv_body= RULE_LEXER_BODY )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:107:2: lv_body= RULE_LEXER_BODY
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_LEXER_BODY,FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule334); 
            if (current==null) {current = factory.create("LexerRule");}factory.set(current, "body",lv_body);

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLexerRule


    // $ANTLR start ruleParserRule
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:111:1: ruleParserRule returns [Object current=null] : ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public final Object ruleParserRule() throws RecognitionException {
        Object current = null;

        Token lv_name=null;
        Object lv_type = null;

        Object lv_alternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:111:46: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:111:48: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:113:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:114:1: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:114:1: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:115:1: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:115:1: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:116:1: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:116:1: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:117:1: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:117:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:118:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule369); 
            if (current==null) {current = factory.create("ParserRule");}factory.set(current, "name",lv_name);

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:121:1: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:122:1: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,16,FOLLOW_16_in_ruleParserRule377); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:123:1: (lv_type= ruleTypeRef )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:124:2: lv_type= ruleTypeRef
                    {
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule385);
                    lv_type=ruleTypeRef();
                    _fsp--;

                    if (current==null) {current = factory.create("ParserRule");}factory.set(current, "type",lv_type);

                    }


                    }
                    break;

            }


            }

            match(input,12,FOLLOW_12_in_ruleParserRule394); 

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:128:1: (lv_alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:129:2: lv_alternatives= ruleAlternatives
            {
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule403);
            lv_alternatives=ruleAlternatives();
            _fsp--;

            if (current==null) {current = factory.create("ParserRule");}factory.set(current, "alternatives",lv_alternatives);

            }


            }

            match(input,17,FOLLOW_17_in_ruleParserRule410); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParserRule


    // $ANTLR start ruleTypeRef
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:134:1: ruleTypeRef returns [Object current=null] : ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) ;
    public final Object ruleTypeRef() throws RecognitionException {
        Object current = null;

        Token lv_alias=null;
        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:134:43: ( ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:134:45: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:136:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:1: ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:1: ( (lv_alias= RULE_ID ) '::' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==18) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:138:1: (lv_alias= RULE_ID ) '::'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:138:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:139:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef437); 
                    if (current==null) {current = factory.create("TypeRef");}factory.set(current, "alias",lv_alias);

                    }

                    match(input,18,FOLLOW_18_in_ruleTypeRef443); 

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:143:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:144:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef453); 
            if (current==null) {current = factory.create("TypeRef");}factory.set(current, "name",lv_name);

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTypeRef


    // $ANTLR start ruleAlternatives
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:148:1: ruleAlternatives returns [Object current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public final Object ruleAlternatives() throws RecognitionException {
        Object current = null;

        Object this_Group = null;

        Object lv_groups = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:148:48: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:148:50: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:150:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:151:1: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives478);
            this_Group=ruleGroup();
            _fsp--;

            current = this_Group;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:152:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==19) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:153:1: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:153:1: ( () '|' )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:154:1: () '|'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:154:1: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:2: 
            	    {
            	    temp=factory.create("Alternatives");
            	    	 factory.add(temp, "groups",current);
            	    	 current = temp; temp = null;

            	    }

            	    match(input,19,FOLLOW_19_in_ruleAlternatives492); 

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:160:1: (lv_groups= ruleGroup )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:161:2: lv_groups= ruleGroup
            	    {
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives501);
            	    lv_groups=ruleGroup();
            	    _fsp--;

            	    if (current==null) {current = factory.create("AbstractElement");}factory.add(current, "groups",lv_groups);

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAlternatives


    // $ANTLR start ruleGroup
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:165:1: ruleGroup returns [Object current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public final Object ruleGroup() throws RecognitionException {
        Object current = null;

        Object this_AbstractToken = null;

        Object lv_abstractTokens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:165:41: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:165:43: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:167:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:168:1: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup528);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

            current = this_AbstractToken;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:169:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_STRING)||LA12_0==26||LA12_0==30) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:170:1: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:170:1: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:171:2: 
            	    {
            	    temp=factory.create("Group");
            	    	 factory.add(temp, "abstractTokens",current);
            	    	 current = temp; temp = null;

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:175:1: (lv_abstractTokens= ruleAbstractToken )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:176:2: lv_abstractTokens= ruleAbstractToken
            	    {
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup546);
            	    lv_abstractTokens=ruleAbstractToken();
            	    _fsp--;

            	    if (current==null) {current = factory.create("AbstractElement");}factory.add(current, "abstractTokens",lv_abstractTokens);

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGroup


    // $ANTLR start ruleAbstractToken
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:180:1: ruleAbstractToken returns [Object current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final Object ruleAbstractToken() throws RecognitionException {
        Object current = null;

        Token lv_cardinality=null;
        Object this_Assignment = null;

        Object this_Action = null;

        Object this_AbstractTerminal = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:180:49: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:180:51: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:182:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:183:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:183:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
            int alt14=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA14_1 = input.LA(2);

                if ( ((LA14_1>=23 && LA14_1<=25)) ) {
                    alt14=1;
                }
                else if ( ((LA14_1>=RULE_ID && LA14_1<=RULE_STRING)||LA14_1==17||(LA14_1>=19 && LA14_1<=22)||LA14_1==26||(LA14_1>=30 && LA14_1<=31)) ) {
                    alt14=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("183:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 14, 1, input);

                    throw nvae;
                }
                }
                break;
            case 26:
                {
                alt14=1;
                }
                break;
            case RULE_STRING:
            case 30:
                {
                alt14=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("183:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:184:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:184:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_ID) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==26) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("184:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:185:1: this_Assignment= ruleAssignment
                            {
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken577);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                            current = this_Assignment;

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:186:1: this_Action= ruleAction
                            {
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken583);
                            this_Action=ruleAction();
                            _fsp--;

                            current = this_Action;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:187:1: this_AbstractTerminal= ruleAbstractTerminal
                    {
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken590);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                    current = this_AbstractTerminal;

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:188:1: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=20 && LA15_0<=22)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:189:2: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    lv_cardinality=(Token)input.LT(1);
                    if ( (input.LA(1)>=20 && input.LA(1)<=22) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAbstractToken600);    throw mse;
                    }

                    if (current==null) {current = factory.create("AbstractElement");}factory.set(current, "cardinality",lv_cardinality);

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAbstractToken


    // $ANTLR start ruleAssignment
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:1: ruleAssignment returns [Object current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public final Object ruleAssignment() throws RecognitionException {
        Object current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        Object lv_terminal = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:46: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:48: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:199:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:200:1: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:200:1: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:201:1: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:201:1: (lv_feature= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:202:2: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment644); 
            if (current==null) {current = factory.create("Assignment");}factory.set(current, "feature",lv_feature);

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:205:1: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:206:2: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            lv_operator=(Token)input.LT(1);
            if ( (input.LA(1)>=23 && input.LA(1)<=25) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAssignment656);    throw mse;
            }

            if (current==null) {current = factory.create("Assignment");}factory.set(current, "operator",lv_operator);

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:213:1: (lv_terminal= ruleAbstractTerminal )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:214:2: lv_terminal= ruleAbstractTerminal
            {
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment681);
            lv_terminal=ruleAbstractTerminal();
            _fsp--;

            if (current==null) {current = factory.create("Assignment");}factory.set(current, "terminal",lv_terminal);

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAssignment


    // $ANTLR start ruleAction
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:218:1: ruleAction returns [Object current=null] : ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) ;
    public final Object ruleAction() throws RecognitionException {
        Object current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        Object lv_typeName = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:218:42: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:218:44: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:220:1: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:221:1: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:221:1: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:222:1: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:222:1: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:223:1: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:223:1: ( '{' ( 'current' '=' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:224:1: '{' ( 'current' '=' )?
            {
            match(input,26,FOLLOW_26_in_ruleAction710); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:225:1: ( 'current' '=' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:226:1: 'current' '='
                    {
                    match(input,27,FOLLOW_27_in_ruleAction714); 
                    match(input,24,FOLLOW_24_in_ruleAction716); 

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:1: (lv_typeName= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:229:2: lv_typeName= ruleTypeRef
            {
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction727);
            lv_typeName=ruleTypeRef();
            _fsp--;

            if (current==null) {current = factory.create("Action");}factory.set(current, "typeName",lv_typeName);

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:232:1: ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:233:1: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:233:1: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:234:1: ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:234:1: ( '.' (lv_feature= RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:235:1: '.' (lv_feature= RULE_ID )
                    {
                    match(input,28,FOLLOW_28_in_ruleAction740); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:236:1: (lv_feature= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:237:2: lv_feature= RULE_ID
                    {
                    lv_feature=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction748); 
                    if (current==null) {current = factory.create("Action");}factory.set(current, "feature",lv_feature);

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:240:1: (lv_operator= ( '=' | '+=' ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:241:2: lv_operator= ( '=' | '+=' )
                    {
                    lv_operator=(Token)input.LT(1);
                    if ( (input.LA(1)>=23 && input.LA(1)<=24) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAction761);    throw mse;
                    }

                    if (current==null) {current = factory.create("Action");}factory.set(current, "operator",lv_operator);

                    }


                    }

                    match(input,27,FOLLOW_27_in_ruleAction774); 

                    }
                    break;

            }


            }

            match(input,29,FOLLOW_29_in_ruleAction779); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAction


    // $ANTLR start ruleAbstractTerminal
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:249:1: ruleAbstractTerminal returns [Object current=null] : ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) ;
    public final Object ruleAbstractTerminal() throws RecognitionException {
        Object current = null;

        Object this_Keyword = null;

        Object this_RuleCall = null;

        Object this_ParenthesizedElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:249:52: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:249:54: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:251:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_STRING)) ) {
                alt19=1;
            }
            else if ( (LA19_0==30) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("251:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:252:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:252:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_STRING) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==RULE_ID) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("252:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:253:1: this_Keyword= ruleKeyword
                            {
                            pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal802);
                            this_Keyword=ruleKeyword();
                            _fsp--;

                            current = this_Keyword;

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:254:1: this_RuleCall= ruleRuleCall
                            {
                            pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal808);
                            this_RuleCall=ruleRuleCall();
                            _fsp--;

                            current = this_RuleCall;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:255:1: this_ParenthesizedElement= ruleParenthesizedElement
                    {
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal815);
                    this_ParenthesizedElement=ruleParenthesizedElement();
                    _fsp--;

                    current = this_ParenthesizedElement;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAbstractTerminal


    // $ANTLR start ruleParenthesizedElement
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:257:1: ruleParenthesizedElement returns [Object current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public final Object ruleParenthesizedElement() throws RecognitionException {
        Object current = null;

        Object this_Alternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:257:56: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:257:58: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:259:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:260:1: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:260:1: ( '(' this_Alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:261:1: '(' this_Alternatives= ruleAlternatives
            {
            match(input,30,FOLLOW_30_in_ruleParenthesizedElement837); 
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement841);
            this_Alternatives=ruleAlternatives();
            _fsp--;

            current = this_Alternatives;

            }

            match(input,31,FOLLOW_31_in_ruleParenthesizedElement845); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParenthesizedElement


    // $ANTLR start ruleKeyword
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:265:1: ruleKeyword returns [Object current=null] : (lv_value= RULE_STRING ) ;
    public final Object ruleKeyword() throws RecognitionException {
        Object current = null;

        Token lv_value=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:265:43: ( (lv_value= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:265:45: (lv_value= RULE_STRING )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:267:1: (lv_value= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:268:2: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword868); 
            if (current==null) {current = factory.create("Keyword");}factory.set(current, "value",lv_value);

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleKeyword


    // $ANTLR start ruleRuleCall
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:272:1: ruleRuleCall returns [Object current=null] : (lv_name= RULE_ID ) ;
    public final Object ruleRuleCall() throws RecognitionException {
        Object current = null;

        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:272:44: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:272:46: (lv_name= RULE_ID )
            {
            Object temp=null;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:274:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:275:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall894); 
            if (current==null) {current = factory.create("RuleCall");}factory.set(current, "name",lv_name);

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRuleCall


 

    public static final BitSet FOLLOW_ruleGrammar_in_parse43 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar74 = new BitSet(new long[]{0x000000000000A812L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleGrammar87 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_11_in_ruleGrammar99 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleGrammar101 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleGrammar110 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleGeneratedMetamodel196 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel204 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel217 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleGeneratedMetamodel226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleReferencedMetamodel261 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel269 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleReferencedMetamodel278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule319 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLexerRule325 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule369 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule377 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule385 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleParserRule394 = new BitSet(new long[]{0x0000000044000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule403 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParserRule410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef437 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTypeRef443 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives478 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleAlternatives492 = new BitSet(new long[]{0x0000000044000030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives501 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup528 = new BitSet(new long[]{0x0000000044000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup546 = new BitSet(new long[]{0x0000000044000032L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken577 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken583 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken590 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_set_in_ruleAbstractToken600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment644 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_set_in_ruleAssignment656 = new BitSet(new long[]{0x0000000040000030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleAction710 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_27_in_ruleAction714 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleAction716 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction727 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleAction740 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction748 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_set_in_ruleAction761 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleAction774 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAction779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleParenthesizedElement837 = new BitSet(new long[]{0x0000000044000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement841 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleParenthesizedElement845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall894 = new BitSet(new long[]{0x0000000000000002L});

}