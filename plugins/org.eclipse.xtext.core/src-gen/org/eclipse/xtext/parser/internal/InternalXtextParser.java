// $ANTLR 3.0.1 ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g 2008-05-16 09:21:19

package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_LEXER_BODY", "RULE_WS", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'lexing'", "':'", "'generate'", "'as'", "'import'", "'tokentype'", "'returns'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'.'", "'}'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=9;
    public static final int RULE_ID=4;
    public static final int RULE_WS=7;
    public static final int RULE_INT=8;
    public static final int EOF=-1;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_LEXER_BODY=6;

        public InternalXtextParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g"; }



    private IElementFactory factory;
    public InternalXtextParser(TokenStream input, IElementFactory factory) {
    	this(input);
    	this.factory = factory;
    }

    public CompositeNode createCompositeNode(EObject currentGrammarElement,
    		CompositeNode parentNode) {
    	CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
    	compositeNode.setGrammarElement(currentGrammarElement);
    	if (parentNode!=null) parentNode.getChildren().add(compositeNode);
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
    	
    public void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
    	node.setElement(astElement);
    	if(astElement instanceof EObject) {
    		EObject eObject = (EObject) astElement;
    		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
    		adapter.setParserNode(node); 
    	}
    }
    	
    private CompositeNode currentNode;




    // $ANTLR start parse
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:80:1: parse returns [EObject current] : ruleGrammar EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleGrammar1 = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:80:33: ( ruleGrammar EOF )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:81:2: ruleGrammar EOF
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:84:1: ruleGrammar returns [EObject current=null] : ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        EObject lv_metamodelDeclarations = null;

        EObject lv_parserRules = null;

        EObject lv_lexerRules = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:84:44: ( ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:84:46: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:86:1: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:87:1: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:87:1: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:88:1: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )*
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:88:1: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14||LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:89:2: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
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

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:97:1: (lv_parserRules= ruleParserRule )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:98:2: lv_parserRules= ruleParserRule
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

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:106:1: ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:107:1: ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+
                    {
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:107:1: ( 'lexing' ':' )
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:108:1: 'lexing' ':'
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar103); 
                    createLeafNode(null, currentNode, 
                    null);
                    match(input,13,FOLLOW_13_in_ruleGrammar107); 
                    createLeafNode(null, currentNode, 
                    null);

                    }

                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:112:1: (lv_lexerRules= ruleLexerRule )+
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
                    	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:113:2: lv_lexerRules= ruleLexerRule
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:122:1: ruleAbstractRule returns [EObject current=null] : (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule = null;

        EObject this_ParserRule = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:122:49: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:122:51: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:124:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 18:
                    {
                    alt5=2;
                    }
                    break;
                case 13:
                    {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==RULE_LEXER_BODY) ) {
                        alt5=1;
                    }
                    else if ( ((LA5_3>=RULE_ID && LA5_3<=RULE_STRING)||LA5_3==28||LA5_3==32) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("124:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 17:
                    {
                    alt5=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("124:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("124:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:125:1: this_LexerRule= ruleLexerRule
                    {
                    pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule149);
                    this_LexerRule=ruleLexerRule();
                    _fsp--;

                    current = this_LexerRule;

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:127:1: this_ParserRule= ruleParserRule
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:130:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel = null;

        EObject this_ReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:130:65: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:130:67: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:132:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
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
                    new NoViableAltException("132:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:133:1: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration181);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                    current = this_GeneratedMetamodel;

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:135:1: this_ReferencedMetamodel= ruleReferencedMetamodel
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:138:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_nsURI=null;
        Token lv_alias=null;

        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:138:55: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:138:57: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:140:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:141:1: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:141:1: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:142:1: ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING )
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:142:1: ( 'generate' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:143:1: 'generate' (lv_name= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleGeneratedMetamodel215); 
            createLeafNode(null, currentNode, 
            null);
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:145:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:146:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel225); 
            createLeafNode(null, currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("GeneratedMetamodel");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:155:1: (lv_nsURI= RULE_STRING )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:156:2: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel240); 
            createLeafNode(null, currentNode, 
            "nsURI");
            if (current==null) {
            	current = factory.create("GeneratedMetamodel");}
            	factory.set(current, "nsURI",lv_nsURI);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:165:1: ( 'as' (lv_alias= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:166:1: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleGeneratedMetamodel251); 
                    createLeafNode(null, currentNode, 
                    null);
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:168:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:169:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel261); 
                    createLeafNode(null, currentNode, 
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:179:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_uri=null;
        Token lv_alias=null;

        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:179:56: ( ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:179:58: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:181:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:182:1: ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:182:1: ( 'import' (lv_uri= RULE_STRING ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:183:1: 'import' (lv_uri= RULE_STRING )
            {
            match(input,16,FOLLOW_16_in_ruleReferencedMetamodel292); 
            createLeafNode(null, currentNode, 
            null);
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:185:1: (lv_uri= RULE_STRING )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:186:2: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel302); 
            createLeafNode(null, currentNode, 
            "uri");
            if (current==null) {
            	current = factory.create("ReferencedMetamodel");}
            	factory.set(current, "uri",lv_uri);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:195:1: ( 'as' (lv_alias= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:196:1: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleReferencedMetamodel313); 
                    createLeafNode(null, currentNode, 
                    null);
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:198:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:199:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel323); 
                    createLeafNode(null, currentNode, 
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:209:1: ruleLexerRule returns [EObject current=null] : ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_tokenType=null;
        Token lv_body=null;

        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:209:46: ( ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:209:48: ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:211:1: ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:212:1: ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY )
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:212:1: ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:213:1: ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':'
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:213:1: ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:214:1: (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:214:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:215:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule362); 
            createLeafNode(null, currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("LexerRule");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:224:1: ( 'tokentype' (lv_tokenType= RULE_ID ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:225:1: 'tokentype' (lv_tokenType= RULE_ID )
                    {
                    match(input,17,FOLLOW_17_in_ruleLexerRule372); 
                    createLeafNode(null, currentNode, 
                    null);
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:227:1: (lv_tokenType= RULE_ID )
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:228:2: lv_tokenType= RULE_ID
                    {
                    lv_tokenType=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule382); 
                    createLeafNode(null, currentNode, 
                    "tokenType");
                    if (current==null) {
                    	current = factory.create("LexerRule");}
                    	factory.set(current, "tokenType",lv_tokenType);
                    	associateNodeWithAstElement(currentNode, current);
                    	

                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleLexerRule393); 
            createLeafNode(null, currentNode, 
            null);

            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:239:1: (lv_body= RULE_LEXER_BODY )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:240:2: lv_body= RULE_LEXER_BODY
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_LEXER_BODY,FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule404); 
            createLeafNode(null, currentNode, 
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:250:1: ruleParserRule returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:250:47: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:250:49: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:252:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:253:1: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:253:1: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:254:1: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:254:1: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:255:1: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:255:1: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:256:1: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:256:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:257:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule443); 
            createLeafNode(null, currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("ParserRule");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:266:1: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:267:1: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,18,FOLLOW_18_in_ruleParserRule453); 
                    createLeafNode(null, currentNode, 
                    null);
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:269:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:270:2: lv_type= ruleTypeRef
                    {
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule463);
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

            match(input,13,FOLLOW_13_in_ruleParserRule473); 
            createLeafNode(null, currentNode, 
            null);

            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:280:1: (lv_alternatives= ruleAlternatives )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:281:2: lv_alternatives= ruleAlternatives
            {
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule484);
            lv_alternatives=ruleAlternatives();
            _fsp--;

            if (current==null) {
            	current = factory.create("ParserRule");}
            	factory.set(current, "alternatives",lv_alternatives);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            match(input,19,FOLLOW_19_in_ruleParserRule492); 
            createLeafNode(null, currentNode, 
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:292:1: ruleTypeRef returns [EObject current=null] : ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;
        Token lv_name=null;

        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:292:44: ( ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:292:46: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:294:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:295:1: ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:295:1: ( (lv_alias= RULE_ID ) '::' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==20) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:296:1: (lv_alias= RULE_ID ) '::'
                    {
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:296:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:297:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef523); 
                    createLeafNode(null, currentNode, 
                    "alias");
                    if (current==null) {
                    	current = factory.create("TypeRef");}
                    	factory.set(current, "alias",lv_alias);
                    	associateNodeWithAstElement(currentNode, current);
                    	

                    }

                    match(input,20,FOLLOW_20_in_ruleTypeRef531); 
                    createLeafNode(null, currentNode, 
                    null);

                    }
                    break;

            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:308:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:309:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef543); 
            createLeafNode(null, currentNode, 
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:319:1: ruleAlternatives returns [EObject current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group = null;

        EObject lv_groups = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:319:49: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:319:51: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:321:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:322:1: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives572);
            this_Group=ruleGroup();
            _fsp--;

            current = this_Group;
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:324:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:325:1: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:325:1: ( () '|' )
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:326:1: () '|'
            	    {
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:326:1: ()
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:327:2: 
            	    {
            	    temp=factory.create("Alternatives");
            	    	 factory.add(temp, "groups",current);
            	    	 current = temp; 
            	    	 temp = null;
            	    	 associateNodeWithAstElement(currentNode, current);

            	    }

            	    match(input,21,FOLLOW_21_in_ruleAlternatives587); 
            	    createLeafNode(null, currentNode, 
            	    null);

            	    }

            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:335:1: (lv_groups= ruleGroup )
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:336:2: lv_groups= ruleGroup
            	    {
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives598);
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
    // $ANTLR end ruleAlternatives


    // $ANTLR start ruleGroup
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:345:1: ruleGroup returns [EObject current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken = null;

        EObject lv_abstractTokens = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:345:42: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:345:44: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:347:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:348:1: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup628);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

            current = this_AbstractToken;
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:350:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_STRING)||LA13_0==28||LA13_0==32) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:351:1: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:351:1: ()
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:352:2: 
            	    {
            	    temp=factory.create("Group");
            	    	 factory.add(temp, "abstractTokens",current);
            	    	 current = temp; 
            	    	 temp = null;
            	    	 associateNodeWithAstElement(currentNode, current);

            	    }

            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:358:1: (lv_abstractTokens= ruleAbstractToken )
            	    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:359:2: lv_abstractTokens= ruleAbstractToken
            	    {
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup647);
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
            	    break loop13;
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:368:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_Assignment = null;

        EObject this_Action = null;

        EObject this_AbstractTerminal = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:368:50: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:368:52: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:370:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:371:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:371:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
            int alt15=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA15_1 = input.LA(2);

                if ( ((LA15_1>=25 && LA15_1<=27)) ) {
                    alt15=1;
                }
                else if ( ((LA15_1>=RULE_ID && LA15_1<=RULE_STRING)||LA15_1==19||(LA15_1>=21 && LA15_1<=24)||LA15_1==28||(LA15_1>=32 && LA15_1<=33)) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("371:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 15, 1, input);

                    throw nvae;
                }
                }
                break;
            case 28:
                {
                alt15=1;
                }
                break;
            case RULE_STRING:
            case 32:
                {
                alt15=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("371:1: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:372:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:372:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_ID) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==28) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("372:1: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:373:1: this_Assignment= ruleAssignment
                            {
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken681);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                            current = this_Assignment;

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:375:1: this_Action= ruleAction
                            {
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken688);
                            this_Action=ruleAction();
                            _fsp--;

                            current = this_Action;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:377:1: this_AbstractTerminal= ruleAbstractTerminal
                    {
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken696);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                    current = this_AbstractTerminal;

                    }
                    break;

            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:379:1: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=22 && LA16_0<=24)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:380:2: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    lv_cardinality=(Token)input.LT(1);
                    if ( (input.LA(1)>=22 && input.LA(1)<=24) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAbstractToken707);    throw mse;
                    }

                    if (current==null) {
                    	current = factory.create("AbstractElement");}
                    	factory.set(current, "cardinality",lv_cardinality);
                    	associateNodeWithAstElement(currentNode, current);
                    createLeafNode(null, currentNode, 
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:393:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_terminal = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:393:47: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:393:49: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:395:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:396:1: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:396:1: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:397:1: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:397:1: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:398:2: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment756); 
            createLeafNode(null, currentNode, 
            "feature");
            if (current==null) {
            	current = factory.create("Assignment");}
            	factory.set(current, "feature",lv_feature);
            	associateNodeWithAstElement(currentNode, current);
            	

            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:407:1: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:408:2: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            lv_operator=(Token)input.LT(1);
            if ( (input.LA(1)>=25 && input.LA(1)<=27) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAssignment770);    throw mse;
            }

            if (current==null) {
            	current = factory.create("Assignment");}
            	factory.set(current, "operator",lv_operator);
            	associateNodeWithAstElement(currentNode, current);
            createLeafNode(null, currentNode, 
            "operator");

            }


            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:420:1: (lv_terminal= ruleAbstractTerminal )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:421:2: lv_terminal= ruleAbstractTerminal
            {
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment798);
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:430:1: ruleAction returns [EObject current=null] : ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_typeName = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:430:43: ( ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:430:45: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:432:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:433:1: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}'
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:433:1: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:434:1: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:434:1: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:435:1: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:435:1: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:436:1: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID )
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:436:1: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:437:1: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.'
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:437:1: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:438:1: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:438:1: ( '{' ( 'current' '=' )? )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:439:1: '{' ( 'current' '=' )?
            {
            match(input,28,FOLLOW_28_in_ruleAction836); 
            createLeafNode(null, currentNode, 
            null);
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:441:1: ( 'current' '=' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:442:1: 'current' '='
                    {
                    match(input,29,FOLLOW_29_in_ruleAction842); 
                    createLeafNode(null, currentNode, 
                    null);
                    match(input,26,FOLLOW_26_in_ruleAction846); 
                    createLeafNode(null, currentNode, 
                    null);

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:446:1: (lv_typeName= ruleTypeRef )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:447:2: lv_typeName= ruleTypeRef
            {
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction859);
            lv_typeName=ruleTypeRef();
            _fsp--;

            if (current==null) {
            	current = factory.create("Action");}
            	factory.set(current, "typeName",lv_typeName);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            match(input,30,FOLLOW_30_in_ruleAction867); 
            createLeafNode(null, currentNode, 
            null);

            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:457:1: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:458:2: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction878); 
            createLeafNode(null, currentNode, 
            "feature");
            if (current==null) {
            	current = factory.create("Action");}
            	factory.set(current, "feature",lv_feature);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:467:1: (lv_operator= ( '=' | '+=' ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:468:2: lv_operator= ( '=' | '+=' )
            {
            lv_operator=(Token)input.LT(1);
            if ( (input.LA(1)>=25 && input.LA(1)<=26) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAction893);    throw mse;
            }

            if (current==null) {
            	current = factory.create("Action");}
            	factory.set(current, "operator",lv_operator);
            	associateNodeWithAstElement(currentNode, current);
            createLeafNode(null, currentNode, 
            "operator");

            }


            }

            match(input,29,FOLLOW_29_in_ruleAction908); 
            createLeafNode(null, currentNode, 
            null);

            }

            match(input,31,FOLLOW_31_in_ruleAction913); 
            createLeafNode(null, currentNode, 
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:483:1: ruleAbstractTerminal returns [EObject current=null] : ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:483:53: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:483:55: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:485:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_STRING)) ) {
                alt19=1;
            }
            else if ( (LA19_0==32) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("485:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:486:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:486:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
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
                            new NoViableAltException("486:1: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:487:1: this_Keyword= ruleKeyword
                            {
                            pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal940);
                            this_Keyword=ruleKeyword();
                            _fsp--;

                            current = this_Keyword;

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:489:1: this_RuleCall= ruleRuleCall
                            {
                            pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal947);
                            this_RuleCall=ruleRuleCall();
                            _fsp--;

                            current = this_RuleCall;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:491:1: this_ParenthesizedElement= ruleParenthesizedElement
                    {
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal955);
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:494:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives = null;


        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:494:57: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:494:59: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:496:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:497:1: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:497:1: ( '(' this_Alternatives= ruleAlternatives )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:498:1: '(' this_Alternatives= ruleAlternatives
            {
            match(input,32,FOLLOW_32_in_ruleParenthesizedElement980); 
            createLeafNode(null, currentNode, 
            null);
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement986);
            this_Alternatives=ruleAlternatives();
            _fsp--;

            current = this_Alternatives;

            }

            match(input,33,FOLLOW_33_in_ruleParenthesizedElement991); 
            createLeafNode(null, currentNode, 
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:505:1: ruleKeyword returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:505:44: ( (lv_value= RULE_STRING ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:505:46: (lv_value= RULE_STRING )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:507:1: (lv_value= RULE_STRING )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:508:2: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1018); 
            createLeafNode(null, currentNode, 
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
    // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:518:1: ruleRuleCall returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

        try {
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:518:45: ( (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:518:47: (lv_name= RULE_ID )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:520:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.core/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:521:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall1048); 
            createLeafNode(null, currentNode, 
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
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule362 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleLexerRule372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule382 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLexerRule393 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule443 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_18_in_ruleParserRule453 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule463 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleParserRule473 = new BitSet(new long[]{0x0000000110000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule484 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleParserRule492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef523 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTypeRef531 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives572 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleAlternatives587 = new BitSet(new long[]{0x0000000110000030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives598 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup628 = new BitSet(new long[]{0x0000000110000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup647 = new BitSet(new long[]{0x0000000110000032L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken681 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken688 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken696 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_set_in_ruleAbstractToken707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment756 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_set_in_ruleAssignment770 = new BitSet(new long[]{0x0000000100000030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAction836 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_29_in_ruleAction842 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAction846 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction859 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleAction867 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction878 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_set_in_ruleAction893 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAction908 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAction913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleParenthesizedElement980 = new BitSet(new long[]{0x0000000110000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement986 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleParenthesizedElement991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall1048 = new BitSet(new long[]{0x0000000000000002L});

}