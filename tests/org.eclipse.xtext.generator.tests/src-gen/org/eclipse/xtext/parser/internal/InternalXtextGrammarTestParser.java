// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g 2008-05-14 17:54:23

package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.EObject;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_LEXER_BODY", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'lexing'", "':'", "'generate'", "'as'", "'import'", "'returns'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'.'", "'}'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=7;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
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

    private CompositeNode currentParserNode;

    	public CompositeNode createCompositeNode(EObject currentGrammarElement,
    			CompositeNode parentNode) {
    		CompositeNode compositeNode = ParsetreeFactory.eINSTANCE
    				.createCompositeNode();
    		compositeNode.setGrammarElement(currentGrammarElement);
    		parentNode.getChildren().add(compositeNode);
    		return compositeNode;
    	}

    	public Object createLeafNode(String text, EObject currentGrammarElement,
    			CompositeNode parentNode, String feature) {
    		LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
    		leafNode.setText(text);
    		leafNode.setGrammarElement(currentGrammarElement);
    		leafNode.setFeature(feature);
    		parentNode.getChildren().add(leafNode);
    		return leafNode;
    	}
    	
    	public void associateNodeWithAstElement(AbstractParserNode node, Object astElement) {
    		node.setElement(astElement);
    		if(astElement instanceof EObject) {
    			EObject eObject = (EObject) astElement;
    			ParserNodeAdapter adapter = (org.eclipse.xtext.parsetree.ParserNodeAdapter) 
    				org.eclipse.xtext.parsetree.ParserNodeAdapterFactory.INSTANCE.adapt(eObject, 
    					org.eclipse.xtext.parsetree.AbstractParserNode.class);
    			adapter.setParserNode(node); 
    		}
    	}




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:58:1: parse returns [Object current] : ruleGrammar EOF ;
    public Object parse() throws RecognitionException {
        Object current = null;

        Object ruleGrammar1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:59:2: ( ruleGrammar EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:59:2: ruleGrammar EOF
            {
             currentParserNode = ParsetreeFactory.eINSTANCE.createCompositeNode(); 
            pushFollow(FOLLOW_ruleGrammar_in_parse46);
            ruleGrammar1=ruleGrammar();
            _fsp--;

            current =ruleGrammar1;
            match(input,EOF,FOLLOW_EOF_in_parse50); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:63:1: ruleGrammar returns [Object current=null] : ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) ;
    public Object ruleGrammar() throws RecognitionException {
        Object current = null;

        Object lv_metamodelDeclarations = null;

        Object lv_parserRules = null;

        Object lv_lexerRules = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:63:45: ( ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:63:45: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:65:1: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:66:1: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:66:1: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:67:1: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )*
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:67:1: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14||LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:68:2: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar77);
            	    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("Grammar");}
            	    	factory.add(current, "metamodelDeclarations",lv_metamodelDeclarations);
            	    	associateNodeWithAstElement(currentParserNode, current);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:75:1: (lv_parserRules= ruleParserRule )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:76:2: lv_parserRules= ruleParserRule
            	    {
            	    pushFollow(FOLLOW_ruleParserRule_in_ruleGrammar91);
            	    lv_parserRules=ruleParserRule();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("Grammar");}
            	    	factory.add(current, "parserRules",lv_parserRules);
            	    	associateNodeWithAstElement(currentParserNode, current);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:83:1: ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:84:1: ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:84:1: ( 'lexing' ':' )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:85:1: 'lexing' ':'
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar104); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);
                    match(input,13,FOLLOW_13_in_ruleGrammar108); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);

                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:89:1: (lv_lexerRules= ruleLexerRule )+
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:90:2: lv_lexerRules= ruleLexerRule
                    	    {
                    	    pushFollow(FOLLOW_ruleLexerRule_in_ruleGrammar119);
                    	    lv_lexerRules=ruleLexerRule();
                    	    _fsp--;

                    	    if (current==null) {
                    	    	current = factory.create("Grammar");}
                    	    	factory.add(current, "lexerRules",lv_lexerRules);
                    	    	associateNodeWithAstElement(currentParserNode, current);

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

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:98:1: ruleAbstractRule returns [Object current=null] : (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) ;
    public Object ruleAbstractRule() throws RecognitionException {
        Object current = null;

        Object this_LexerRule = null;

        Object this_ParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:98:50: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:98:50: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:100:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==13) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==RULE_LEXER_BODY) ) {
                        alt5=1;
                    }
                    else if ( ((LA5_2>=RULE_ID && LA5_2<=RULE_STRING)||LA5_2==27||LA5_2==31) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("100:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA5_1==17) ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("100:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("100:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:101:1: this_LexerRule= ruleLexerRule
                    {
                    pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule150);
                    this_LexerRule=ruleLexerRule();
                    _fsp--;

                    current = this_LexerRule;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:103:1: this_ParserRule= ruleParserRule
                    {
                    pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule157);
                    this_ParserRule=ruleParserRule();
                    _fsp--;

                    current = this_ParserRule;

                    }
                    break;

            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:106:1: ruleAbstractMetamodelDeclaration returns [Object current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public Object ruleAbstractMetamodelDeclaration() throws RecognitionException {
        Object current = null;

        Object this_GeneratedMetamodel = null;

        Object this_ReferencedMetamodel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:106:66: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:106:66: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:108:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            else if ( (LA6_0==16) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("108:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:109:1: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration182);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                    current = this_GeneratedMetamodel;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:111:1: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration189);
                    this_ReferencedMetamodel=ruleReferencedMetamodel();
                    _fsp--;

                    current = this_ReferencedMetamodel;

                    }
                    break;

            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:114:1: ruleGeneratedMetamodel returns [Object current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public Object ruleGeneratedMetamodel() throws RecognitionException {
        Object current = null;

        Token lv_name=null;
        Token lv_nsURI=null;
        Token lv_alias=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:114:56: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:114:56: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:116:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:117:1: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:117:1: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:118:1: ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:118:1: ( 'generate' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:119:1: 'generate' (lv_name= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleGeneratedMetamodel216); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            null);
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:121:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:122:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel226); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "name");
            if (current==null) {
            	current = factory.create("GeneratedMetamodel");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentParserNode, current);

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:130:1: (lv_nsURI= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:131:2: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel241); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "nsURI");
            if (current==null) {
            	current = factory.create("GeneratedMetamodel");}
            	factory.set(current, "nsURI",lv_nsURI);
            	associateNodeWithAstElement(currentParserNode, current);

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:139:1: ( 'as' (lv_alias= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:140:1: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleGeneratedMetamodel252); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:142:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:143:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel262); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    "alias");
                    if (current==null) {
                    	current = factory.create("GeneratedMetamodel");}
                    	factory.set(current, "alias",lv_alias);
                    	associateNodeWithAstElement(currentParserNode, current);

                    }


                    }
                    break;

            }


            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:152:1: ruleReferencedMetamodel returns [Object current=null] : ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public Object ruleReferencedMetamodel() throws RecognitionException {
        Object current = null;

        Token lv_uri=null;
        Token lv_alias=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:152:57: ( ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:152:57: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:154:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:1: ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:1: ( 'import' (lv_uri= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:156:1: 'import' (lv_uri= RULE_STRING )
            {
            match(input,16,FOLLOW_16_in_ruleReferencedMetamodel293); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            null);
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:158:1: (lv_uri= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:159:2: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel303); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "uri");
            if (current==null) {
            	current = factory.create("ReferencedMetamodel");}
            	factory.set(current, "uri",lv_uri);
            	associateNodeWithAstElement(currentParserNode, current);

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:167:1: ( 'as' (lv_alias= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:168:1: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleReferencedMetamodel314); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:170:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:171:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel324); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    "alias");
                    if (current==null) {
                    	current = factory.create("ReferencedMetamodel");}
                    	factory.set(current, "alias",lv_alias);
                    	associateNodeWithAstElement(currentParserNode, current);

                    }


                    }
                    break;

            }


            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:180:1: ruleLexerRule returns [Object current=null] : ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) ) ;
    public Object ruleLexerRule() throws RecognitionException {
        Object current = null;

        Token lv_name=null;
        Token lv_body=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:180:47: ( ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:180:47: ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:182:1: ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:183:1: ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:183:1: ( (lv_name= RULE_ID ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:184:1: (lv_name= RULE_ID ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:184:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:185:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule361); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "name");
            if (current==null) {
            	current = factory.create("LexerRule");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentParserNode, current);

            }

            match(input,13,FOLLOW_13_in_ruleLexerRule369); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            null);

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:195:1: (lv_body= RULE_LEXER_BODY )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:196:2: lv_body= RULE_LEXER_BODY
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_LEXER_BODY,FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule380); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "body");
            if (current==null) {
            	current = factory.create("LexerRule");}
            	factory.set(current, "body",lv_body);
            	associateNodeWithAstElement(currentParserNode, current);

            }


            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:205:1: ruleParserRule returns [Object current=null] : ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public Object ruleParserRule() throws RecognitionException {
        Object current = null;

        Token lv_name=null;
        Object lv_type = null;

        Object lv_alternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:205:48: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:205:48: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:207:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:208:1: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:208:1: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:209:1: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:209:1: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:210:1: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:210:1: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:211:1: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:211:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:212:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule419); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "name");
            if (current==null) {
            	current = factory.create("ParserRule");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentParserNode, current);

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:220:1: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:221:1: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,17,FOLLOW_17_in_ruleParserRule429); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:223:1: (lv_type= ruleTypeRef )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:224:2: lv_type= ruleTypeRef
                    {
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule439);
                    lv_type=ruleTypeRef();
                    _fsp--;

                    if (current==null) {
                    	current = factory.create("ParserRule");}
                    	factory.set(current, "type",lv_type);
                    	associateNodeWithAstElement(currentParserNode, current);

                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleParserRule449); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            null);

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:233:1: (lv_alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:234:2: lv_alternatives= ruleAlternatives
            {
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule460);
            lv_alternatives=ruleAlternatives();
            _fsp--;

            if (current==null) {
            	current = factory.create("ParserRule");}
            	factory.set(current, "alternatives",lv_alternatives);
            	associateNodeWithAstElement(currentParserNode, current);

            }


            }

            match(input,18,FOLLOW_18_in_ruleParserRule468); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            null);

            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:244:1: ruleTypeRef returns [Object current=null] : ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) ;
    public Object ruleTypeRef() throws RecognitionException {
        Object current = null;

        Token lv_alias=null;
        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:244:45: ( ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:244:45: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:246:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:247:1: ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:247:1: ( (lv_alias= RULE_ID ) '::' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==19) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:248:1: (lv_alias= RULE_ID ) '::'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:248:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:249:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef499); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    "alias");
                    if (current==null) {
                    	current = factory.create("TypeRef");}
                    	factory.set(current, "alias",lv_alias);
                    	associateNodeWithAstElement(currentParserNode, current);

                    }

                    match(input,19,FOLLOW_19_in_ruleTypeRef507); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:259:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:260:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef519); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "name");
            if (current==null) {
            	current = factory.create("TypeRef");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentParserNode, current);

            }


            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:269:1: ruleAlternatives returns [Object current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public Object ruleAlternatives() throws RecognitionException {
        Object current = null;

        Object this_Group = null;

        Object lv_groups = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:269:50: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:269:50: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:271:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:272:1: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives548);
            this_Group=ruleGroup();
            _fsp--;

            current = this_Group;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:274:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:275:1: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:275:1: ( () '|' )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:276:1: () '|'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:276:1: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:277:2: 
            	    {
            	    temp=factory.create("Alternatives");
            	    	 factory.add(temp, "groups",current);
            	    	 current = temp; 
            	    	 temp = null;
            	    	 associateNodeWithAstElement(currentParserNode, current);

            	    }

            	    match(input,20,FOLLOW_20_in_ruleAlternatives563); 
            	    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            	    null);

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:285:1: (lv_groups= ruleGroup )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:286:2: lv_groups= ruleGroup
            	    {
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives574);
            	    lv_groups=ruleGroup();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("AbstractElement");}
            	    	factory.add(current, "groups",lv_groups);
            	    	associateNodeWithAstElement(currentParserNode, current);

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:294:1: ruleGroup returns [Object current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public Object ruleGroup() throws RecognitionException {
        Object current = null;

        Object this_AbstractToken = null;

        Object lv_abstractTokens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:294:43: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:294:43: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:296:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:297:1: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup604);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

            current = this_AbstractToken;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:299:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_STRING)||LA12_0==27||LA12_0==31) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:300:1: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:300:1: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:301:2: 
            	    {
            	    temp=factory.create("Group");
            	    	 factory.add(temp, "abstractTokens",current);
            	    	 current = temp; 
            	    	 temp = null;
            	    	 associateNodeWithAstElement(currentParserNode, current);

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:307:1: (lv_abstractTokens= ruleAbstractToken )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:308:2: lv_abstractTokens= ruleAbstractToken
            	    {
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup623);
            	    lv_abstractTokens=ruleAbstractToken();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("AbstractElement");}
            	    	factory.add(current, "abstractTokens",lv_abstractTokens);
            	    	associateNodeWithAstElement(currentParserNode, current);

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:316:1: ruleAbstractToken returns [Object current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public Object ruleAbstractToken() throws RecognitionException {
        Object current = null;

        Token lv_cardinality=null;
        Object this_Assignment = null;

        Object this_Action = null;

        Object this_AbstractTerminal = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:316:51: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:316:51: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:318:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:319:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:319:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
            int alt14=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA14_1 = input.LA(2);

                if ( ((LA14_1>=24 && LA14_1<=26)) ) {
                    alt14=1;
                }
                else if ( ((LA14_1>=RULE_ID && LA14_1<=RULE_STRING)||LA14_1==18||(LA14_1>=20 && LA14_1<=23)||LA14_1==27||(LA14_1>=31 && LA14_1<=32)) ) {
                    alt14=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("319:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 14, 1, input);

                    throw nvae;
                }
                }
                break;
            case 27:
                {
                alt14=1;
                }
                break;
            case RULE_STRING:
            case 31:
                {
                alt14=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("319:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:320:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:320:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_ID) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==27) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("320:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:321:1: this_Assignment= ruleAssignment
                            {
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken657);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                            current = this_Assignment;

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:323:1: this_Action= ruleAction
                            {
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken664);
                            this_Action=ruleAction();
                            _fsp--;

                            current = this_Action;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:325:1: this_AbstractTerminal= ruleAbstractTerminal
                    {
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken672);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                    current = this_AbstractTerminal;

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:327:1: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=21 && LA17_0<=23)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:328:2: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:329:1: ( ( '?' | '*' ) | '+' )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=21 && LA16_0<=22)) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==23) ) {
                        alt16=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("329:1: ( ( '?' | '*' ) | '+' )", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:330:1: ( '?' | '*' )
                            {
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:330:1: ( '?' | '*' )
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==21) ) {
                                alt15=1;
                            }
                            else if ( (LA15_0==22) ) {
                                alt15=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("330:1: ( '?' | '*' )", 15, 0, input);

                                throw nvae;
                            }
                            switch (alt15) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:331:1: '?'
                                    {
                                    match(input,21,FOLLOW_21_in_ruleAbstractToken687); 
                                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                                    null);

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:333:1: '*'
                                    {
                                    match(input,22,FOLLOW_22_in_ruleAbstractToken692); 
                                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                                    null);

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:335:1: '+'
                            {
                            match(input,23,FOLLOW_23_in_ruleAbstractToken698); 
                            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                            null);

                            }
                            break;

                    }

                    if (current==null) {
                    	current = factory.create("AbstractElement");}
                    	factory.set(current, "cardinality",lv_cardinality);
                    	associateNodeWithAstElement(currentParserNode, current);

                    }
                    break;

            }


            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:342:1: ruleAssignment returns [Object current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public Object ruleAssignment() throws RecognitionException {
        Object current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        Object lv_terminal = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:342:48: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:342:48: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:344:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:345:1: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:345:1: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:346:1: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:346:1: (lv_feature= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:347:2: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment735); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "feature");
            if (current==null) {
            	current = factory.create("Assignment");}
            	factory.set(current, "feature",lv_feature);
            	associateNodeWithAstElement(currentParserNode, current);

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:355:1: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:356:2: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:357:1: ( ( '+=' | '=' ) | '?=' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=24 && LA19_0<=25)) ) {
                alt19=1;
            }
            else if ( (LA19_0==26) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("357:1: ( ( '+=' | '=' ) | '?=' )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:358:1: ( '+=' | '=' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:358:1: ( '+=' | '=' )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==24) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==25) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("358:1: ( '+=' | '=' )", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:359:1: '+='
                            {
                            match(input,24,FOLLOW_24_in_ruleAssignment753); 
                            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                            null);

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:361:1: '='
                            {
                            match(input,25,FOLLOW_25_in_ruleAssignment758); 
                            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                            null);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:363:1: '?='
                    {
                    match(input,26,FOLLOW_26_in_ruleAssignment764); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);

                    }
                    break;

            }

            if (current==null) {
            	current = factory.create("Assignment");}
            	factory.set(current, "operator",lv_operator);
            	associateNodeWithAstElement(currentParserNode, current);

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:369:1: (lv_terminal= ruleAbstractTerminal )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:370:2: lv_terminal= ruleAbstractTerminal
            {
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment780);
            lv_terminal=ruleAbstractTerminal();
            _fsp--;

            if (current==null) {
            	current = factory.create("Assignment");}
            	factory.set(current, "terminal",lv_terminal);
            	associateNodeWithAstElement(currentParserNode, current);

            }


            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:378:1: ruleAction returns [Object current=null] : ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) ;
    public Object ruleAction() throws RecognitionException {
        Object current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        Object lv_typeName = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:378:44: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:378:44: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:380:1: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:381:1: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:381:1: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:382:1: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:382:1: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:383:1: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:383:1: ( '{' ( 'current' '=' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:384:1: '{' ( 'current' '=' )?
            {
            match(input,27,FOLLOW_27_in_ruleAction812); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            null);
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:386:1: ( 'current' '=' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:387:1: 'current' '='
                    {
                    match(input,28,FOLLOW_28_in_ruleAction818); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);
                    match(input,25,FOLLOW_25_in_ruleAction822); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:391:1: (lv_typeName= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:392:2: lv_typeName= ruleTypeRef
            {
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction835);
            lv_typeName=ruleTypeRef();
            _fsp--;

            if (current==null) {
            	current = factory.create("Action");}
            	factory.set(current, "typeName",lv_typeName);
            	associateNodeWithAstElement(currentParserNode, current);

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:399:1: ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==29) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:400:1: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:400:1: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:401:1: ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:401:1: ( '.' (lv_feature= RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:402:1: '.' (lv_feature= RULE_ID )
                    {
                    match(input,29,FOLLOW_29_in_ruleAction849); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:404:1: (lv_feature= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:405:2: lv_feature= RULE_ID
                    {
                    lv_feature=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction859); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    "feature");
                    if (current==null) {
                    	current = factory.create("Action");}
                    	factory.set(current, "feature",lv_feature);
                    	associateNodeWithAstElement(currentParserNode, current);

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:413:1: (lv_operator= ( '=' | '+=' ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:414:2: lv_operator= ( '=' | '+=' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:415:1: ( '=' | '+=' )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==25) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==24) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("415:1: ( '=' | '+=' )", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:416:1: '='
                            {
                            match(input,25,FOLLOW_25_in_ruleAction876); 
                            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                            null);

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:418:1: '+='
                            {
                            match(input,24,FOLLOW_24_in_ruleAction881); 
                            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                            null);

                            }
                            break;

                    }

                    if (current==null) {
                    	current = factory.create("Action");}
                    	factory.set(current, "operator",lv_operator);
                    	associateNodeWithAstElement(currentParserNode, current);

                    }


                    }

                    match(input,28,FOLLOW_28_in_ruleAction891); 
                    createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
                    null);

                    }
                    break;

            }


            }

            match(input,30,FOLLOW_30_in_ruleAction898); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            null);

            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:429:1: ruleAbstractTerminal returns [Object current=null] : ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) ;
    public Object ruleAbstractTerminal() throws RecognitionException {
        Object current = null;

        Object this_Keyword = null;

        Object this_RuleCall = null;

        Object this_ParenthesizedElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:429:54: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:429:54: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:431:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)) ) {
                alt24=1;
            }
            else if ( (LA24_0==31) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("431:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:432:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:432:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==RULE_STRING) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==RULE_ID) ) {
                        alt23=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("432:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:433:1: this_Keyword= ruleKeyword
                            {
                            pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal925);
                            this_Keyword=ruleKeyword();
                            _fsp--;

                            current = this_Keyword;

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:435:1: this_RuleCall= ruleRuleCall
                            {
                            pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal932);
                            this_RuleCall=ruleRuleCall();
                            _fsp--;

                            current = this_RuleCall;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:437:1: this_ParenthesizedElement= ruleParenthesizedElement
                    {
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal940);
                    this_ParenthesizedElement=ruleParenthesizedElement();
                    _fsp--;

                    current = this_ParenthesizedElement;

                    }
                    break;

            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:440:1: ruleParenthesizedElement returns [Object current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public Object ruleParenthesizedElement() throws RecognitionException {
        Object current = null;

        Object this_Alternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:440:58: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:440:58: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:442:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:443:1: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:443:1: ( '(' this_Alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:444:1: '(' this_Alternatives= ruleAlternatives
            {
            match(input,31,FOLLOW_31_in_ruleParenthesizedElement965); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            null);
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement971);
            this_Alternatives=ruleAlternatives();
            _fsp--;

            current = this_Alternatives;

            }

            match(input,32,FOLLOW_32_in_ruleParenthesizedElement976); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            null);

            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:451:1: ruleKeyword returns [Object current=null] : (lv_value= RULE_STRING ) ;
    public Object ruleKeyword() throws RecognitionException {
        Object current = null;

        Token lv_value=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:451:45: ( (lv_value= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:451:45: (lv_value= RULE_STRING )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:453:1: (lv_value= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:454:2: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1003); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "value");
            if (current==null) {
            	current = factory.create("Keyword");}
            	factory.set(current, "value",lv_value);
            	associateNodeWithAstElement(currentParserNode, current);

            }

             currentParserNode = currentParserNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:463:1: ruleRuleCall returns [Object current=null] : (lv_name= RULE_ID ) ;
    public Object ruleRuleCall() throws RecognitionException {
        Object current = null;

        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:463:46: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:463:46: (lv_name= RULE_ID )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:465:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:466:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall1033); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "name");
            if (current==null) {
            	current = factory.create("RuleCall");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentParserNode, current);

            }

             currentParserNode = currentParserNode.getParent(); 

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


 

    public static final BitSet FOLLOW_ruleGrammar_in_parse46 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar77 = new BitSet(new long[]{0x0000000000015012L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleGrammar91 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_12_in_ruleGrammar104 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGrammar108 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleGrammar119 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleGeneratedMetamodel216 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel226 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel241 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleGeneratedMetamodel252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleReferencedMetamodel293 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel303 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleReferencedMetamodel314 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule361 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLexerRule369 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule419 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleParserRule429 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule439 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleParserRule449 = new BitSet(new long[]{0x0000000088000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule460 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleParserRule468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef499 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTypeRef507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives548 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleAlternatives563 = new BitSet(new long[]{0x0000000088000030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives574 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup604 = new BitSet(new long[]{0x0000000088000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup623 = new BitSet(new long[]{0x0000000088000032L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken657 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken664 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken672 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_21_in_ruleAbstractToken687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleAbstractToken692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleAbstractToken698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment735 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_24_in_ruleAssignment753 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_25_in_ruleAssignment758 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_26_in_ruleAssignment764 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleAction812 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_28_in_ruleAction818 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleAction822 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction835 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleAction849 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction859 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleAction876 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_24_in_ruleAction881 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleAction891 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleAction898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleParenthesizedElement965 = new BitSet(new long[]{0x0000000088000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement971 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleParenthesizedElement976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall1033 = new BitSet(new long[]{0x0000000000000002L});

}