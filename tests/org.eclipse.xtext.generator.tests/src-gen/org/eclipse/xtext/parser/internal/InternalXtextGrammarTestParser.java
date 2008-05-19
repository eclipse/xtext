// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g 2008-05-19 12:04:46

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_LEXER_BODY", "RULE_INT", "RULE_SL_COMMENT", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'lexing'", "':'", "'generate'", "'as'", "'import'", "'tokentype'", "'returns'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'.'", "'}'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=9;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=7;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
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

    public CompositeNode createCompositeNode(EObject grammarElement, CompositeNode parentNode) {
    	CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
    	if (parentNode!=null) parentNode.getChildren().add(compositeNode);
    	compositeNode.setGrammarElement(grammarElement);
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
    	assert node.getElement() == null || node.getElement() == astElement;
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:82:1: parse returns [EObject current] : ruleGrammar EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleGrammar1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:82:33: ( ruleGrammar EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:82:35: ruleGrammar EOF
            {
            currentNode = createCompositeNode(// org.eclipse.xtext.impl.ParserRuleImpl@b35e79 (name: Grammar)
            grammar.eResource().getEObject("//@parserRules.0"), currentNode);
            pushFollow(FOLLOW_ruleGrammar_in_parse45);
            ruleGrammar1=ruleGrammar();
            _fsp--;

            current =ruleGrammar1;
            match(input,EOF,FOLLOW_EOF_in_parse49); 
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:89:1: ruleGrammar returns [EObject current=null] : ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        EObject lv_metamodelDeclarations = null;

        EObject lv_parserRules = null;

        EObject lv_lexerRules = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:89:44: ( ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:89:46: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:90:1: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:90:2: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:90:2: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:90:3: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )*
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:90:3: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14||LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:91:2: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@3a82f5 (cardinality: null) (name: AbstractMetamodelDeclaration)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode);
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar79);
            	    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration();
            	    _fsp--;

            	     if (current==null) {
            	         current = factory.create("Grammar");
            	      }
            	      factory.add(current, "metamodelDeclarations", lv_metamodelDeclarations);
            	      currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
            	      associateNodeWithAstElement(currentNode, current); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:101:3: (lv_parserRules= ruleParserRule )*
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
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@585a88 (cardinality: null) (name: ParserRule)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode);
            	    pushFollow(FOLLOW_ruleParserRule_in_ruleGrammar96);
            	    lv_parserRules=ruleParserRule();
            	    _fsp--;

            	     if (current==null) {
            	         current = factory.create("Grammar");
            	      }
            	      factory.add(current, "parserRules", lv_parserRules);
            	      currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
            	      associateNodeWithAstElement(currentNode, current); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:112:4: ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:112:5: ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:112:5: ( 'lexing' ':' )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:112:6: 'lexing' ':'
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar107); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@822cd2 (cardinality: null) (value: 'lexing')
                    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
                    match(input,13,FOLLOW_13_in_ruleGrammar110); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@494678 (cardinality: null) (value: ':')
                    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:114:142: (lv_lexerRules= ruleLexerRule )+
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:115:2: lv_lexerRules= ruleLexerRule
                    	    {
                    	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@fa8ddf (cardinality: null) (name: LexerRule)
                    	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode);
                    	    pushFollow(FOLLOW_ruleLexerRule_in_ruleGrammar123);
                    	    lv_lexerRules=ruleLexerRule();
                    	    _fsp--;

                    	     if (current==null) {
                    	         current = factory.create("Grammar");
                    	      }
                    	      factory.add(current, "lexerRules", lv_lexerRules);
                    	      currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:129:1: ruleAbstractRule returns [EObject current=null] : (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule = null;

        EObject this_ParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:129:49: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:129:51: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:130:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
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
                            new NoViableAltException("130:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 3, input);

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
                        new NoViableAltException("130:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("130:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:130:2: this_LexerRule= ruleLexerRule
                    {
                    pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule153);
                    this_LexerRule=ruleLexerRule();
                    _fsp--;

                    current = this_LexerRule;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:131:2: this_ParserRule= ruleParserRule
                    {
                    pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule159);
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:136:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel = null;

        EObject this_ReferencedMetamodel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:136:65: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:136:67: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
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
                    new NoViableAltException("137:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:2: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration182);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                    current = this_GeneratedMetamodel;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:138:2: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration188);
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:143:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_nsURI=null;
        Token lv_alias=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:143:55: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:143:57: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:144:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:144:2: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:144:2: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:144:3: ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:144:3: ( 'generate' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:144:4: 'generate' (lv_name= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleGeneratedMetamodel211); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@19ac71 (cardinality: null) (value: 'generate')
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:145:141: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:147:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel221); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@92acdc (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"name"); 
             if (current==null) {
                 current = factory.create("GeneratedMetamodel");
              }
              factory.set(current, "name", lv_name);
              
              associateNodeWithAstElement(currentNode, current); 

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:156:3: (lv_nsURI= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:158:2: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel237); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@c09980 (cardinality: null) (name: STRING)
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"nsURI"); 
             if (current==null) {
                 current = factory.create("GeneratedMetamodel");
              }
              factory.set(current, "nsURI", lv_nsURI);
              
              associateNodeWithAstElement(currentNode, current); 

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:167:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:167:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleGeneratedMetamodel247); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@23fca5 (cardinality: null) (value: 'as')
                    grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode,null); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:168:123: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:170:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel257); 
                     createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@94c37c (cardinality: null) (name: ID)
                    grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"alias"); 
                     if (current==null) {
                         current = factory.create("GeneratedMetamodel");
                      }
                      factory.set(current, "alias", lv_alias);
                      
                      associateNodeWithAstElement(currentNode, current); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:183:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_uri=null;
        Token lv_alias=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:183:56: ( ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:183:58: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:184:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:184:2: ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:184:2: ( 'import' (lv_uri= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:184:3: 'import' (lv_uri= RULE_STRING )
            {
            match(input,16,FOLLOW_16_in_ruleReferencedMetamodel286); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@14a519 (cardinality: null) (value: 'import')
            grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:185:123: (lv_uri= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:187:2: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel296); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@9838d9 (cardinality: null) (name: STRING)
            grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"uri"); 
             if (current==null) {
                 current = factory.create("ReferencedMetamodel");
              }
              factory.set(current, "uri", lv_uri);
              
              associateNodeWithAstElement(currentNode, current); 

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:196:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:196:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleReferencedMetamodel306); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@85d94 (cardinality: null) (value: 'as')
                    grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode,null); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:123: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:199:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel316); 
                     createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@edb080 (cardinality: null) (name: ID)
                    grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"alias"); 
                     if (current==null) {
                         current = factory.create("ReferencedMetamodel");
                      }
                      factory.set(current, "alias", lv_alias);
                      
                      associateNodeWithAstElement(currentNode, current); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:212:1: ruleLexerRule returns [EObject current=null] : ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_tokenType=null;
        Token lv_body=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:212:46: ( ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:212:48: ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:213:1: ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:213:2: ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:213:2: ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:213:3: ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:213:3: ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:213:4: (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:213:4: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:215:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule353); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@588de9 (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"name"); 
             if (current==null) {
                 current = factory.create("LexerRule");
              }
              factory.set(current, "name", lv_name);
              
              associateNodeWithAstElement(currentNode, current); 

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:224:2: ( 'tokentype' (lv_tokenType= RULE_ID ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:224:3: 'tokentype' (lv_tokenType= RULE_ID )
                    {
                    match(input,17,FOLLOW_17_in_ruleLexerRule362); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@c85b3 (cardinality: null) (value: 'tokentype')
                    grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:225:159: (lv_tokenType= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:227:2: lv_tokenType= RULE_ID
                    {
                    lv_tokenType=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule372); 
                     createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@5b642c (cardinality: null) (name: ID)
                    grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"tokenType"); 
                     if (current==null) {
                         current = factory.create("LexerRule");
                      }
                      factory.set(current, "tokenType", lv_tokenType);
                      
                      associateNodeWithAstElement(currentNode, current); 

                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleLexerRule383); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@23c852 (cardinality: null) (value: ':')
            grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:237:124: (lv_body= RULE_LEXER_BODY )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:239:2: lv_body= RULE_LEXER_BODY
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_LEXER_BODY,FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule394); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@fd84ec (cardinality: null) (name: LEXER_BODY)
            grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.1/@terminal"), currentNode,"body"); 
             if (current==null) {
                 current = factory.create("LexerRule");
              }
              factory.set(current, "body", lv_body);
              
              associateNodeWithAstElement(currentNode, current); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:252:1: ruleParserRule returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:252:47: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:252:49: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:253:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:253:2: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:253:2: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:253:3: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:253:3: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:253:4: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:253:4: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:253:5: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:253:5: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:255:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule430); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@838550 (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"name"); 
             if (current==null) {
                 current = factory.create("ParserRule");
              }
              factory.set(current, "name", lv_name);
              
              associateNodeWithAstElement(currentNode, current); 

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:264:2: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:264:3: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,18,FOLLOW_18_in_ruleParserRule439); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@59e008 (cardinality: null) (value: 'returns')
                    grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:265:177: (lv_type= ruleTypeRef )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:266:2: lv_type= ruleTypeRef
                    {
                     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@ebfb58 (cardinality: null) (name: TypeRef)
                    grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode);
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule451);
                    lv_type=ruleTypeRef();
                    _fsp--;

                     if (current==null) {
                         current = factory.create("ParserRule");
                      }
                      factory.set(current, "type", lv_type);
                      currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
                      associateNodeWithAstElement(currentNode, current); 

                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleParserRule461); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@c2da48 (cardinality: null) (value: ':')
            grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:277:142: (lv_alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:278:2: lv_alternatives= ruleAlternatives
            {
             currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@dd9928 (cardinality: null) (name: Alternatives)
            grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode);
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule474);
            lv_alternatives=ruleAlternatives();
            _fsp--;

             if (current==null) {
                 current = factory.create("ParserRule");
              }
              factory.set(current, "alternatives", lv_alternatives);
              currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
              associateNodeWithAstElement(currentNode, current); 

            }


            }

            match(input,19,FOLLOW_19_in_ruleParserRule482); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@a92be6 (cardinality: null) (value: ';')
            grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.1"), currentNode,null); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:293:1: ruleTypeRef returns [EObject current=null] : ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;
        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:293:44: ( ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:293:46: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:294:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:294:2: ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:294:2: ( (lv_alias= RULE_ID ) '::' )?
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
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:294:3: (lv_alias= RULE_ID ) '::'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:294:3: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:296:2: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef511); 
                     createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@54884c (cardinality: null) (name: ID)
                    grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"alias"); 
                     if (current==null) {
                         current = factory.create("TypeRef");
                      }
                      factory.set(current, "alias", lv_alias);
                      
                      associateNodeWithAstElement(currentNode, current); 

                    }

                    match(input,20,FOLLOW_20_in_ruleTypeRef519); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@1e897 (cardinality: null) (value: '::')
                    grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:306:125: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:308:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef531); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@843d62 (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.1/@terminal"), currentNode,"name"); 
             if (current==null) {
                 current = factory.create("TypeRef");
              }
              factory.set(current, "name", lv_name);
              
              associateNodeWithAstElement(currentNode, current); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:321:1: ruleAlternatives returns [EObject current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group = null;

        EObject lv_groups = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:321:49: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:321:51: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:322:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:322:2: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives559);
            this_Group=ruleGroup();
            _fsp--;

            current = this_Group;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:323:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:323:2: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:323:2: ( () '|' )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:323:3: () '|'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:323:3: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:324:1: 
            	    {
            	     temp=factory.create("Alternatives");
            	      factory.add(temp, "groups",current);
            	      current = temp; 
            	      temp = null;
            	      associateNodeWithAstElement(currentNode, current); 

            	    }

            	    match(input,21,FOLLOW_21_in_ruleAlternatives569); 
            	     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@61f5b0 (cardinality: null) (value: '|')
            	    grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:330:142: (lv_groups= ruleGroup )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:331:2: lv_groups= ruleGroup
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@ba083 (cardinality: null) (name: Group)
            	    grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode);
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives582);
            	    lv_groups=ruleGroup();
            	    _fsp--;

            	     if (current==null) {
            	         current = factory.create("AbstractElement");
            	      }
            	      factory.add(current, "groups", lv_groups);
            	      currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
            	      associateNodeWithAstElement(currentNode, current); 

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
    // $ANTLR end ruleAlternatives


    // $ANTLR start ruleGroup
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:345:1: ruleGroup returns [EObject current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken = null;

        EObject lv_abstractTokens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:345:42: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:345:44: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:346:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:346:2: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup611);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

            current = this_AbstractToken;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:347:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_STRING)||LA13_0==28||LA13_0==32) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:347:2: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:347:2: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:348:1: 
            	    {
            	     temp=factory.create("Group");
            	      factory.add(temp, "abstractTokens",current);
            	      current = temp; 
            	      temp = null;
            	      associateNodeWithAstElement(currentNode, current); 

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:353:2: (lv_abstractTokens= ruleAbstractToken )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:354:2: lv_abstractTokens= ruleAbstractToken
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@f72af3 (cardinality: null) (name: AbstractToken)
            	    grammar.eResource().getEObject("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode);
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup629);
            	    lv_abstractTokens=ruleAbstractToken();
            	    _fsp--;

            	     if (current==null) {
            	         current = factory.create("AbstractElement");
            	      }
            	      factory.add(current, "abstractTokens", lv_abstractTokens);
            	      currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
            	      associateNodeWithAstElement(currentNode, current); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:368:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_Assignment = null;

        EObject this_Action = null;

        EObject this_AbstractTerminal = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:368:50: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:368:52: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:369:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:369:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:369:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
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
                        new NoViableAltException("369:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 15, 1, input);

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
                    new NoViableAltException("369:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:369:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:369:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
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
                            new NoViableAltException("369:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:369:4: this_Assignment= ruleAssignment
                            {
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken660);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                            current = this_Assignment;

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:370:2: this_Action= ruleAction
                            {
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken666);
                            this_Action=ruleAction();
                            _fsp--;

                            current = this_Action;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:371:3: this_AbstractTerminal= ruleAbstractTerminal
                    {
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken673);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                    current = this_AbstractTerminal;

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:372:2: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=22 && LA16_0<=24)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:374:2: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    lv_cardinality=(Token)input.LT(1);
                    if ( (input.LA(1)>=22 && input.LA(1)<=24) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAbstractToken684);    throw mse;
                    }

                     if (current==null) {
                         current = factory.create("AbstractElement");
                      }
                      factory.set(current, "cardinality", lv_cardinality);
                    createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@e3878c (cardinality: null)
                    grammar.eResource().getEObject("//@parserRules.10/@alternatives/@abstractTokens.1/@terminal"), currentNode,"cardinality");  
                      associateNodeWithAstElement(currentNode, current); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:386:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_terminal = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:386:47: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:386:49: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:387:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:387:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:387:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:387:3: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:387:3: (lv_feature= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:389:2: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment728); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@b7b072 (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"feature"); 
             if (current==null) {
                 current = factory.create("Assignment");
              }
              factory.set(current, "feature", lv_feature);
              
              associateNodeWithAstElement(currentNode, current); 

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:398:2: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:400:2: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            lv_operator=(Token)input.LT(1);
            if ( (input.LA(1)>=25 && input.LA(1)<=27) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAssignment743);    throw mse;
            }

             if (current==null) {
                 current = factory.create("Assignment");
              }
              factory.set(current, "operator", lv_operator);
            createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@25dc7 (cardinality: null)
            grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"operator");  
              associateNodeWithAstElement(currentNode, current); 

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:408:3: (lv_terminal= ruleAbstractTerminal )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:409:2: lv_terminal= ruleAbstractTerminal
            {
             currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@3d2386 (cardinality: null) (name: AbstractTerminal)
            grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.1/@terminal"), currentNode);
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment770);
            lv_terminal=ruleAbstractTerminal();
            _fsp--;

             if (current==null) {
                 current = factory.create("Assignment");
              }
              factory.set(current, "terminal", lv_terminal);
              currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
              associateNodeWithAstElement(currentNode, current); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:423:1: ruleAction returns [EObject current=null] : ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_typeName = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:423:43: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:423:45: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:424:1: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:424:2: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:424:2: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:424:3: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:424:3: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:424:4: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:424:4: ( '{' ( 'current' '=' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:424:5: '{' ( 'current' '=' )?
            {
            match(input,28,FOLLOW_28_in_ruleAction798); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@4dbb2f (cardinality: null) (value: '{')
            grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:425:160: ( 'current' '=' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:425:161: 'current' '='
                    {
                    match(input,29,FOLLOW_29_in_ruleAction802); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@736e99 (cardinality: null) (value: 'current')
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); 
                    match(input,26,FOLLOW_26_in_ruleAction805); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@c50164 (cardinality: null) (value: '=')
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1"), currentNode,null); 

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:427:181: (lv_typeName= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:428:2: lv_typeName= ruleTypeRef
            {
             currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@ae176 (cardinality: null) (name: TypeRef)
            grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode);
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction820);
            lv_typeName=ruleTypeRef();
            _fsp--;

             if (current==null) {
                 current = factory.create("Action");
              }
              factory.set(current, "typeName", lv_typeName);
              currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
              associateNodeWithAstElement(currentNode, current); 

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:438:3: ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:438:4: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:438:4: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:438:5: ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:438:5: ( '.' (lv_feature= RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:438:6: '.' (lv_feature= RULE_ID )
                    {
                    match(input,30,FOLLOW_30_in_ruleAction831); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@a73f4b (cardinality: null) (value: '.')
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:439:178: (lv_feature= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:441:2: lv_feature= RULE_ID
                    {
                    lv_feature=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction841); 
                     createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@3caf2d (cardinality: null) (name: ID)
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"feature"); 
                     if (current==null) {
                         current = factory.create("Action");
                      }
                      factory.set(current, "feature", lv_feature);
                      
                      associateNodeWithAstElement(currentNode, current); 

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:450:3: (lv_operator= ( '=' | '+=' ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:452:2: lv_operator= ( '=' | '+=' )
                    {
                    lv_operator=(Token)input.LT(1);
                    if ( (input.LA(1)>=25 && input.LA(1)<=26) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAction857);    throw mse;
                    }

                     if (current==null) {
                         current = factory.create("Action");
                      }
                      factory.set(current, "operator", lv_operator);
                    createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@9ec948 (cardinality: null)
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"operator");  
                      associateNodeWithAstElement(currentNode, current); 

                    }


                    }

                    match(input,29,FOLLOW_29_in_ruleAction870); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@fb67b (cardinality: null) (value: 'current')
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1"), currentNode,null); 

                    }
                    break;

            }


            }

            match(input,31,FOLLOW_31_in_ruleAction876); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@11008e (cardinality: null) (value: '}')
            grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.1"), currentNode,null); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:466:1: ruleAbstractTerminal returns [EObject current=null] : ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:466:53: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:466:55: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:467:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_STRING)) ) {
                alt20=1;
            }
            else if ( (LA20_0==32) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("467:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:467:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:467:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_STRING) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==RULE_ID) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("467:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:467:3: this_Keyword= ruleKeyword
                            {
                            pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal900);
                            this_Keyword=ruleKeyword();
                            _fsp--;

                            current = this_Keyword;

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:468:2: this_RuleCall= ruleRuleCall
                            {
                            pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal906);
                            this_RuleCall=ruleRuleCall();
                            _fsp--;

                            current = this_RuleCall;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:469:3: this_ParenthesizedElement= ruleParenthesizedElement
                    {
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal913);
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:474:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:474:57: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:474:59: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:475:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:475:2: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:475:2: ( '(' this_Alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:475:3: '(' this_Alternatives= ruleAlternatives
            {
            match(input,32,FOLLOW_32_in_ruleParenthesizedElement935); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@93e09 (cardinality: null) (value: '(')
            grammar.eResource().getEObject("//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement940);
            this_Alternatives=ruleAlternatives();
            _fsp--;

            current = this_Alternatives;

            }

            match(input,33,FOLLOW_33_in_ruleParenthesizedElement944); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@d9a6ac (cardinality: null) (value: ')')
            grammar.eResource().getEObject("//@parserRules.14/@alternatives/@abstractTokens.1"), currentNode,null); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:482:1: ruleKeyword returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:482:44: ( (lv_value= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:482:46: (lv_value= RULE_STRING )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:483:1: (lv_value= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:485:2: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword971); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@61bb9b (cardinality: null) (name: STRING)
            grammar.eResource().getEObject("//@parserRules.15/@alternatives/@terminal"), currentNode,"value"); 
             if (current==null) {
                 current = factory.create("Keyword");
              }
              factory.set(current, "value", lv_value);
              
              associateNodeWithAstElement(currentNode, current); 

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:498:1: ruleRuleCall returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:498:45: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:498:47: (lv_name= RULE_ID )
            {
             EObject temp=null; 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:499:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:501:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall1002); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@c19e22 (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.16/@alternatives/@terminal"), currentNode,"name"); 
             if (current==null) {
                 current = factory.create("RuleCall");
              }
              factory.set(current, "name", lv_name);
              
              associateNodeWithAstElement(currentNode, current); 

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


 

    public static final BitSet FOLLOW_ruleGrammar_in_parse45 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar79 = new BitSet(new long[]{0x0000000000015012L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleGrammar96 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_12_in_ruleGrammar107 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGrammar110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleGrammar123 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleGeneratedMetamodel211 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel221 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel237 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleGeneratedMetamodel247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleReferencedMetamodel286 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel296 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleReferencedMetamodel306 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule353 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleLexerRule362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule372 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLexerRule383 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule430 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_18_in_ruleParserRule439 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule451 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleParserRule461 = new BitSet(new long[]{0x0000000110000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule474 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleParserRule482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef511 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTypeRef519 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives559 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleAlternatives569 = new BitSet(new long[]{0x0000000110000030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives582 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup611 = new BitSet(new long[]{0x0000000110000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup629 = new BitSet(new long[]{0x0000000110000032L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken660 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken666 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken673 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_set_in_ruleAbstractToken684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment728 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_set_in_ruleAssignment743 = new BitSet(new long[]{0x0000000100000030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAction798 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_29_in_ruleAction802 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAction805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction820 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleAction831 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction841 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_set_in_ruleAction857 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAction870 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAction876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleParenthesizedElement935 = new BitSet(new long[]{0x0000000110000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement940 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleParenthesizedElement944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall1002 = new BitSet(new long[]{0x0000000000000002L});

}