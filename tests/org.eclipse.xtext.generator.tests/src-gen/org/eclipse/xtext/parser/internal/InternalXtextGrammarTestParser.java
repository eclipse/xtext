// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g 2008-05-15 17:51:03

package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_LEXER_BODY", "RULE_SL_COMMENT", "RULE_ML_COMMENT", "RULE_WS", "RULE_INT", "RULE_ANY_OTHER", "'lexing'", "':'", "'generate'", "'as'", "'import'", "'returns'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'.'", "'}'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_INT=10;
    public static final int EOF=-1;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=7;
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

    public CompositeNode createCompositeNode(EObject currentGrammarElement,
    		CompositeNode parentNode) {
    	CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
    	compositeNode.setGrammarElement(currentGrammarElement);
    	if (parentNode!=null) parentNode.getChildren().add(compositeNode);
    	compositeNode.setGrammarElement(currentGrammarElement);
    	return compositeNode;
    }

    public Object createLeafNode(EObject currentGrammarElement, CompositeNode parentNode, String feature) {
    	Token token = input.LT(-1);
    	Token tokenBefore = input.LT(-2);
    	int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
    	if (indexOfTokenBefore+1<token.getTokenIndex()) {
    		for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
    			Token hidden = input.get(x);
    			LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
    			leafNode.setText(hidden.getText());
    			leafNode.setHidden(true);
    			parentNode.getChildren().add(leafNode);
    		}
    	}
    	LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
    		leafNode.setText(token.getText());
    	leafNode.setGrammarElement(currentGrammarElement);
    	leafNode.setFeature(feature);
    	parentNode.getChildren().add(leafNode);
    	return leafNode;
    }

    private void appendTrailingHiddenTokens(CompositeNode parentNode) {
    	Token tokenBefore = input.LT(-1);
    	int size = input.size();
    	if (tokenBefore!=null && tokenBefore.getTokenIndex()<size) {
    		for (int x = tokenBefore.getTokenIndex()+1; x<size;x++) {
    			Token hidden = input.get(x);
    			LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
    			leafNode.setText(hidden.getText());
    			leafNode.setHidden(true);
    			parentNode.getChildren().add(leafNode);
    		}
    	}
    }
    	
    public void associateNodeWithAstElement(AbstractNode node, EObject astElement) {
    	node.setElement(astElement);
    	if(astElement instanceof EObject) {
    		EObject eObject = (EObject) astElement;
    		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
    		adapter.setParserNode(node); 
    	}
    }
    	
    private CompositeNode currentNode;

    private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.XtextGrammarTestConstants.getXtextGrammarTestGrammar();



    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:83:1: parse returns [EObject current] : ruleGrammar EOF ;
    public EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleGrammar1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:84:2: ( ruleGrammar EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:84:2: ruleGrammar EOF
            {
            pushFollow(FOLLOW_ruleGrammar_in_parse43);
            ruleGrammar1=ruleGrammar();
            _fsp--;

            current =ruleGrammar1;
            match(input,EOF,FOLLOW_EOF_in_parse47); 
            appendTrailingHiddenTokens(currentNode);

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:87:1: ruleGrammar returns [EObject current=null] : ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) ;
    public EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        EObject lv_metamodelDeclarations = null;

        EObject lv_parserRules = null;

        EObject lv_lexerRules = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:87:46: ( ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:87:46: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.0")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:90:1: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:91:1: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:91:1: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:92:1: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )*
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:92:1: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14||LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:93:2: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar76);
            	    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("Grammar");}
            	    	factory.add(current, "metamodelDeclarations",lv_metamodelDeclarations);
            	    	associateNodeWithAstElement(currentNode, current);
            	    	

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:101:1: (lv_parserRules= ruleParserRule )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:102:2: lv_parserRules= ruleParserRule
            	    {
            	    pushFollow(FOLLOW_ruleParserRule_in_ruleGrammar90);
            	    lv_parserRules=ruleParserRule();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("Grammar");}
            	    	factory.add(current, "parserRules",lv_parserRules);
            	    	associateNodeWithAstElement(currentNode, current);
            	    	

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:110:1: ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:111:1: ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:111:1: ( 'lexing' ':' )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:112:1: 'lexing' ':'
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar103); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0")
                    , currentNode, 
                    null);
                    match(input,13,FOLLOW_13_in_ruleGrammar107); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1")
                    , currentNode, 
                    null);

                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:118:1: (lv_lexerRules= ruleLexerRule )+
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:119:2: lv_lexerRules= ruleLexerRule
                    	    {
                    	    pushFollow(FOLLOW_ruleLexerRule_in_ruleGrammar118);
                    	    lv_lexerRules=ruleLexerRule();
                    	    _fsp--;

                    	    if (current==null) {
                    	    	current = factory.create("Grammar");}
                    	    	factory.add(current, "lexerRules",lv_lexerRules);
                    	    	associateNodeWithAstElement(currentNode, current);
                    	    	

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

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:128:1: ruleAbstractRule returns [EObject current=null] : (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) ;
    public EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule = null;

        EObject this_ParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:128:51: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:128:51: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.1")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:131:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
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
                            new NoViableAltException("131:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA5_1==17) ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("131:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("131:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:132:1: this_LexerRule= ruleLexerRule
                    {
                    pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule149);
                    this_LexerRule=ruleLexerRule();
                    _fsp--;

                    current = this_LexerRule;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:134:1: this_ParserRule= ruleParserRule
                    {
                    pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule156);
                    this_ParserRule=ruleParserRule();
                    _fsp--;

                    current = this_ParserRule;

                    }
                    break;

            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel = null;

        EObject this_ReferencedMetamodel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:67: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:67: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.2")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:140:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
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
                    new NoViableAltException("140:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:141:1: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration181);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                    current = this_GeneratedMetamodel;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:143:1: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration188);
                    this_ReferencedMetamodel=ruleReferencedMetamodel();
                    _fsp--;

                    current = this_ReferencedMetamodel;

                    }
                    break;

            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:146:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_nsURI=null;
        Token lv_alias=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:146:57: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:146:57: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.3")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:149:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:150:1: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:150:1: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:151:1: ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:151:1: ( 'generate' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:152:1: 'generate' (lv_name= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleGeneratedMetamodel215); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0")
            , currentNode, 
            null);
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:156:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel225); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal")
            , currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("GeneratedMetamodel");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:166:1: (lv_nsURI= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:167:2: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel240); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal")
            , currentNode, 
            "nsURI");
            if (current==null) {
            	current = factory.create("GeneratedMetamodel");}
            	factory.set(current, "nsURI",lv_nsURI);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:177:1: ( 'as' (lv_alias= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:178:1: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleGeneratedMetamodel251); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0")
                    , currentNode, 
                    null);
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:181:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:182:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel261); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal")
                    , currentNode, 
                    "alias");
                    if (current==null) {
                    	current = factory.create("GeneratedMetamodel");}
                    	factory.set(current, "alias",lv_alias);
                    	associateNodeWithAstElement(currentNode, current);
                    	

                    }


                    }
                    break;

            }


            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:193:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_uri=null;
        Token lv_alias=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:193:58: ( ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:193:58: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.4")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:196:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:1: ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:1: ( 'import' (lv_uri= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:198:1: 'import' (lv_uri= RULE_STRING )
            {
            match(input,16,FOLLOW_16_in_ruleReferencedMetamodel292); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0")
            , currentNode, 
            null);
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:201:1: (lv_uri= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:202:2: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel302); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal")
            , currentNode, 
            "uri");
            if (current==null) {
            	current = factory.create("ReferencedMetamodel");}
            	factory.set(current, "uri",lv_uri);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:212:1: ( 'as' (lv_alias= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:213:1: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleReferencedMetamodel313); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.0")
                    , currentNode, 
                    null);
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:216:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:217:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel323); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal")
                    , currentNode, 
                    "alias");
                    if (current==null) {
                    	current = factory.create("ReferencedMetamodel");}
                    	factory.set(current, "alias",lv_alias);
                    	associateNodeWithAstElement(currentNode, current);
                    	

                    }


                    }
                    break;

            }


            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:1: ruleLexerRule returns [EObject current=null] : ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) ) ;
    public EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_body=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:48: ( ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:48: ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.5")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:231:1: ( ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:232:1: ( (lv_name= RULE_ID ) ':' ) (lv_body= RULE_LEXER_BODY )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:232:1: ( (lv_name= RULE_ID ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:233:1: (lv_name= RULE_ID ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:233:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:234:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule360); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal")
            , currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("LexerRule");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }

            match(input,13,FOLLOW_13_in_ruleLexerRule368); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1")
            , currentNode, 
            null);

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:247:1: (lv_body= RULE_LEXER_BODY )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:248:2: lv_body= RULE_LEXER_BODY
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_LEXER_BODY,FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule379); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.1/@terminal")
            , currentNode, 
            "body");
            if (current==null) {
            	current = factory.create("LexerRule");}
            	factory.set(current, "body",lv_body);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:259:1: ruleParserRule returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:259:49: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:259:49: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.6")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:262:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:263:1: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:263:1: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:264:1: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:264:1: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:265:1: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:265:1: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:266:1: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:266:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:267:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule418); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal")
            , currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("ParserRule");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:277:1: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:278:1: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,17,FOLLOW_17_in_ruleParserRule428); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0")
                    , currentNode, 
                    null);
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:281:1: (lv_type= ruleTypeRef )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:282:2: lv_type= ruleTypeRef
                    {
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule438);
                    lv_type=ruleTypeRef();
                    _fsp--;

                    if (current==null) {
                    	current = factory.create("ParserRule");}
                    	factory.set(current, "type",lv_type);
                    	associateNodeWithAstElement(currentNode, current);
                    	

                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleParserRule448); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1")
            , currentNode, 
            null);

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:293:1: (lv_alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:294:2: lv_alternatives= ruleAlternatives
            {
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule459);
            lv_alternatives=ruleAlternatives();
            _fsp--;

            if (current==null) {
            	current = factory.create("ParserRule");}
            	factory.set(current, "alternatives",lv_alternatives);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            match(input,18,FOLLOW_18_in_ruleParserRule467); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.1")
            , currentNode, 
            null);

            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:306:1: ruleTypeRef returns [EObject current=null] : ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) ;
    public EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;
        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:306:46: ( ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:306:46: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.7")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:309:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:310:1: ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:310:1: ( (lv_alias= RULE_ID ) '::' )?
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
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:311:1: (lv_alias= RULE_ID ) '::'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:311:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:312:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef498); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal")
                    , currentNode, 
                    "alias");
                    if (current==null) {
                    	current = factory.create("TypeRef");}
                    	factory.set(current, "alias",lv_alias);
                    	associateNodeWithAstElement(currentNode, current);
                    	

                    }

                    match(input,19,FOLLOW_19_in_ruleTypeRef506); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1")
                    , currentNode, 
                    null);

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:325:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:326:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef518); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.1/@terminal")
            , currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("TypeRef");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:337:1: ruleAlternatives returns [EObject current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group = null;

        EObject lv_groups = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:337:51: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:337:51: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.8")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:340:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:341:1: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives547);
            this_Group=ruleGroup();
            _fsp--;

            current = this_Group;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:343:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:344:1: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:344:1: ( () '|' )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:345:1: () '|'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:345:1: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:346:2: 
            	    {
            	    temp=factory.create("Alternatives");
            	    	 factory.add(temp, "groups",current);
            	    	 current = temp; 
            	    	 temp = null;
            	    	 associateNodeWithAstElement(currentNode, current);

            	    }

            	    match(input,20,FOLLOW_20_in_ruleAlternatives562); 
            	    createLeafNode(grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1")
            	    , currentNode, 
            	    null);

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:355:1: (lv_groups= ruleGroup )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:356:2: lv_groups= ruleGroup
            	    {
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives573);
            	    lv_groups=ruleGroup();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("AbstractElement");}
            	    	factory.add(current, "groups",lv_groups);
            	    	associateNodeWithAstElement(currentNode, current);
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:365:1: ruleGroup returns [EObject current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken = null;

        EObject lv_abstractTokens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:365:44: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:365:44: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.9")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:368:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:369:1: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup603);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

            current = this_AbstractToken;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:371:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_STRING)||LA12_0==27||LA12_0==31) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:372:1: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:372:1: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:373:2: 
            	    {
            	    temp=factory.create("Group");
            	    	 factory.add(temp, "abstractTokens",current);
            	    	 current = temp; 
            	    	 temp = null;
            	    	 associateNodeWithAstElement(currentNode, current);

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:379:1: (lv_abstractTokens= ruleAbstractToken )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:380:2: lv_abstractTokens= ruleAbstractToken
            	    {
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup622);
            	    lv_abstractTokens=ruleAbstractToken();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("AbstractElement");}
            	    	factory.add(current, "abstractTokens",lv_abstractTokens);
            	    	associateNodeWithAstElement(currentNode, current);
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:389:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_Assignment = null;

        EObject this_Action = null;

        EObject this_AbstractTerminal = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:389:52: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:389:52: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.10")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:392:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:393:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:393:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
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
                        new NoViableAltException("393:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 14, 1, input);

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
                    new NoViableAltException("393:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:394:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:394:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )
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
                            new NoViableAltException("394:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:395:1: this_Assignment= ruleAssignment
                            {
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken656);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                            current = this_Assignment;

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:397:1: this_Action= ruleAction
                            {
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken663);
                            this_Action=ruleAction();
                            _fsp--;

                            current = this_Action;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:399:1: this_AbstractTerminal= ruleAbstractTerminal
                    {
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken671);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                    current = this_AbstractTerminal;

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:401:1: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=21 && LA15_0<=23)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:402:2: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    lv_cardinality=(Token)input.LT(1);
                    if ( (input.LA(1)>=21 && input.LA(1)<=23) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAbstractToken682);    throw mse;
                    }

                    if (current==null) {
                    	current = factory.create("AbstractElement");}
                    	factory.set(current, "cardinality",lv_cardinality);
                    	associateNodeWithAstElement(currentNode, current);
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.10/@alternatives/@abstractTokens.1")
                    , currentNode, 
                    "cardinality");

                    }
                    break;

            }


            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:416:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_terminal = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:416:49: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:416:49: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.11")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:419:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:420:1: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:420:1: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:421:1: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:421:1: (lv_feature= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:422:2: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment731); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal")
            , currentNode, 
            "feature");
            if (current==null) {
            	current = factory.create("Assignment");}
            	factory.set(current, "feature",lv_feature);
            	associateNodeWithAstElement(currentNode, current);
            	

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:432:1: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:433:2: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            lv_operator=(Token)input.LT(1);
            if ( (input.LA(1)>=24 && input.LA(1)<=26) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAssignment745);    throw mse;
            }

            if (current==null) {
            	current = factory.create("Assignment");}
            	factory.set(current, "operator",lv_operator);
            	associateNodeWithAstElement(currentNode, current);
            createLeafNode(grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1")
            , currentNode, 
            "operator");

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:446:1: (lv_terminal= ruleAbstractTerminal )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:447:2: lv_terminal= ruleAbstractTerminal
            {
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment773);
            lv_terminal=ruleAbstractTerminal();
            _fsp--;

            if (current==null) {
            	current = factory.create("Assignment");}
            	factory.set(current, "terminal",lv_terminal);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:456:1: ruleAction returns [EObject current=null] : ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) ;
    public EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_typeName = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:456:45: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:456:45: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.12")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:459:1: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:460:1: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:460:1: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:461:1: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:461:1: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:462:1: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:462:1: ( '{' ( 'current' '=' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:463:1: '{' ( 'current' '=' )?
            {
            match(input,27,FOLLOW_27_in_ruleAction805); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0")
            , currentNode, 
            null);
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:466:1: ( 'current' '=' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:467:1: 'current' '='
                    {
                    match(input,28,FOLLOW_28_in_ruleAction811); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0")
                    , currentNode, 
                    null);
                    match(input,25,FOLLOW_25_in_ruleAction815); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1")
                    , currentNode, 
                    null);

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:473:1: (lv_typeName= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:474:2: lv_typeName= ruleTypeRef
            {
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction828);
            lv_typeName=ruleTypeRef();
            _fsp--;

            if (current==null) {
            	current = factory.create("Action");}
            	factory.set(current, "typeName",lv_typeName);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:482:1: ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:483:1: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:483:1: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:1: ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:1: ( '.' (lv_feature= RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:485:1: '.' (lv_feature= RULE_ID )
                    {
                    match(input,29,FOLLOW_29_in_ruleAction842); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0")
                    , currentNode, 
                    null);
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:488:1: (lv_feature= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:489:2: lv_feature= RULE_ID
                    {
                    lv_feature=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction852); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal")
                    , currentNode, 
                    "feature");
                    if (current==null) {
                    	current = factory.create("Action");}
                    	factory.set(current, "feature",lv_feature);
                    	associateNodeWithAstElement(currentNode, current);
                    	

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:499:1: (lv_operator= ( '=' | '+=' ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:500:2: lv_operator= ( '=' | '+=' )
                    {
                    lv_operator=(Token)input.LT(1);
                    if ( (input.LA(1)>=24 && input.LA(1)<=25) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAction867);    throw mse;
                    }

                    if (current==null) {
                    	current = factory.create("Action");}
                    	factory.set(current, "operator",lv_operator);
                    	associateNodeWithAstElement(currentNode, current);
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1")
                    , currentNode, 
                    "operator");

                    }


                    }

                    match(input,28,FOLLOW_28_in_ruleAction882); 
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1")
                    , currentNode, 
                    null);

                    }
                    break;

            }


            }

            match(input,30,FOLLOW_30_in_ruleAction889); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.1")
            , currentNode, 
            null);

            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:518:1: ruleAbstractTerminal returns [EObject current=null] : ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) ;
    public EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:518:55: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:518:55: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.13")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:521:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_STRING)) ) {
                alt19=1;
            }
            else if ( (LA19_0==31) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("521:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:522:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:522:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
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
                            new NoViableAltException("522:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:523:1: this_Keyword= ruleKeyword
                            {
                            pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal916);
                            this_Keyword=ruleKeyword();
                            _fsp--;

                            current = this_Keyword;

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:525:1: this_RuleCall= ruleRuleCall
                            {
                            pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal923);
                            this_RuleCall=ruleRuleCall();
                            _fsp--;

                            current = this_RuleCall;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:527:1: this_ParenthesizedElement= ruleParenthesizedElement
                    {
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal931);
                    this_ParenthesizedElement=ruleParenthesizedElement();
                    _fsp--;

                    current = this_ParenthesizedElement;

                    }
                    break;

            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:530:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:530:59: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:530:59: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.14")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:533:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:534:1: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:534:1: ( '(' this_Alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:535:1: '(' this_Alternatives= ruleAlternatives
            {
            match(input,31,FOLLOW_31_in_ruleParenthesizedElement956); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0")
            , currentNode, 
            null);
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement962);
            this_Alternatives=ruleAlternatives();
            _fsp--;

            current = this_Alternatives;

            }

            match(input,32,FOLLOW_32_in_ruleParenthesizedElement967); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.14/@alternatives/@abstractTokens.1")
            , currentNode, 
            null);

            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:544:1: ruleKeyword returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:544:46: ( (lv_value= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:544:46: (lv_value= RULE_STRING )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.15")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:547:1: (lv_value= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:548:2: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword994); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.15/@alternatives/@terminal")
            , currentNode, 
            "value");
            if (current==null) {
            	current = factory.create("Keyword");}
            	factory.set(current, "value",lv_value);
            	associateNodeWithAstElement(currentNode, current);
            	

            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:559:1: ruleRuleCall returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:559:47: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:559:47: (lv_name= RULE_ID )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.16")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:562:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:563:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall1024); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.16/@alternatives/@terminal")
            , currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("RuleCall");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }

             currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; 

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
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar76 = new BitSet(new long[]{0x0000000000015012L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleGrammar90 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_12_in_ruleGrammar103 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGrammar107 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleGrammar118 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleGeneratedMetamodel215 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel225 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel240 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleGeneratedMetamodel251 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleReferencedMetamodel292 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel302 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleReferencedMetamodel313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule360 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLexerRule368 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule418 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleParserRule428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule438 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleParserRule448 = new BitSet(new long[]{0x0000000088000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule459 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleParserRule467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef498 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTypeRef506 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives547 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleAlternatives562 = new BitSet(new long[]{0x0000000088000030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives573 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup603 = new BitSet(new long[]{0x0000000088000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup622 = new BitSet(new long[]{0x0000000088000032L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken656 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken663 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken671 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_set_in_ruleAbstractToken682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment731 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_set_in_ruleAssignment745 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleAction805 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_28_in_ruleAction811 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleAction815 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction828 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleAction842 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction852 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_set_in_ruleAction867 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleAction882 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleAction889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleParenthesizedElement956 = new BitSet(new long[]{0x0000000088000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement962 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleParenthesizedElement967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall1024 = new BitSet(new long[]{0x0000000000000002L});

}