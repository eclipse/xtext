// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g 2008-05-19 14:09:37

package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_LEXER_BODY", "RULE_INT", "RULE_WS", "RULE_SL_COMMENT", "RULE_ML_COMMENT", "RULE_ANY_OTHER", "'lexing'", "':'", "'generate'", "'as'", "'import'", "'tokentype'", "'returns'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'.'", "'}'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_ID=4;
    public static final int RULE_WS=8;
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
    	if(node.getElement() != null && node.getElement() != astElement) {
    		throw new ParseException(node, "Reassignment of astElement in parse tree node");
    	}
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:85:1: parse returns [EObject current] : ruleGrammar EOF ;
    public EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleGrammar1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:85:35: ( ruleGrammar EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:85:35: ruleGrammar EOF
            {
            currentNode = createCompositeNode(// org.eclipse.xtext.impl.ParserRuleImpl@7555b8 (name: Grammar)
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:92:1: ruleGrammar returns [EObject current=null] : ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) ;
    public EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        EObject lv_metamodelDeclarations = null;

        EObject lv_parserRules = null;

        EObject lv_lexerRules = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:95:1: ( ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:95:1: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:95:1: ( ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:95:2: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:95:2: ( (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:95:3: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* (lv_parserRules= ruleParserRule )*
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:95:3: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14||LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:96:4: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@18d289 (cardinality: null) (name: AbstractMetamodelDeclaration)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode); 
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar93);
            	    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration();
            	    _fsp--;

            	      currentNode = currentNode.getParent();   if (current==null) {
            	          current = factory.create("Grammar");
            	          associateNodeWithAstElement(currentNode, current);
            	       }
            	       factory.add(current, "metamodelDeclarations", lv_metamodelDeclarations);


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:106:3: (lv_parserRules= ruleParserRule )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:107:4: lv_parserRules= ruleParserRule
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@1fff2b (cardinality: null) (name: ParserRule)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode); 
            	    pushFollow(FOLLOW_ruleParserRule_in_ruleGrammar114);
            	    lv_parserRules=ruleParserRule();
            	    _fsp--;

            	      currentNode = currentNode.getParent();   if (current==null) {
            	          current = factory.create("Grammar");
            	          associateNodeWithAstElement(currentNode, current);
            	       }
            	       factory.add(current, "parserRules", lv_parserRules);


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:117:4: ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:117:5: ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:117:5: ( 'lexing' ':' )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:117:6: 'lexing' ':'
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar125); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@3ee73b (cardinality: null) (value: 'lexing')
                    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
                    match(input,13,FOLLOW_13_in_ruleGrammar128); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@bee61a (cardinality: null) (value: ':')
                    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:119:142: (lv_lexerRules= ruleLexerRule )+
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
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:120:4: lv_lexerRules= ruleLexerRule
                    	    {
                    	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@c0b403 (cardinality: null) (name: LexerRule)
                    	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); 
                    	    pushFollow(FOLLOW_ruleLexerRule_in_ruleGrammar145);
                    	    lv_lexerRules=ruleLexerRule();
                    	    _fsp--;

                    	      currentNode = currentNode.getParent();   if (current==null) {
                    	          current = factory.create("Grammar");
                    	          associateNodeWithAstElement(currentNode, current);
                    	       }
                    	       factory.add(current, "lexerRules", lv_lexerRules);


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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:134:1: ruleAbstractRule returns [EObject current=null] : (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) ;
    public EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule = null;

        EObject this_ParserRule = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
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
                            new NoViableAltException("137:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 3, input);

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
                        new NoViableAltException("137:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("137:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:2: this_LexerRule= ruleLexerRule
                    {
                    pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule184);
                    this_LexerRule=ruleLexerRule();
                    _fsp--;

                    current = this_LexerRule;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:138:2: this_ParserRule= ruleParserRule
                    {
                    pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule190);
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:143:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel = null;

        EObject this_ReferencedMetamodel = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:146:1: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:146:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:146:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
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
                    new NoViableAltException("146:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:146:2: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration222);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                    current = this_GeneratedMetamodel;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:147:2: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration228);
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:152:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_nsURI=null;
        Token lv_alias=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:1: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:2: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:2: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:3: ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:3: ( 'generate' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:4: 'generate' (lv_name= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleGeneratedMetamodel260); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@b45826 (cardinality: null) (value: 'generate')
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:156:141: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:158:4: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel274); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@ead9ba (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"name"); 
                 if (current==null) {
                  current = factory.create("GeneratedMetamodel");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "name", lv_name);


            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:167:3: (lv_nsURI= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:169:4: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel294); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@c8590c (cardinality: null) (name: STRING)
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"nsURI"); 
                 if (current==null) {
                  current = factory.create("GeneratedMetamodel");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "nsURI", lv_nsURI);


            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:178:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:178:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleGeneratedMetamodel304); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@275a92 (cardinality: null) (value: 'as')
                    grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode,null); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:179:123: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:181:4: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel318); 
                     createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@af1b50 (cardinality: null) (name: ID)
                    grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"alias"); 
                         if (current==null) {
                          current = factory.create("GeneratedMetamodel");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "alias", lv_alias);


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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:194:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_uri=null;
        Token lv_alias=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:1: ( ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:2: ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:2: ( 'import' (lv_uri= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:197:3: 'import' (lv_uri= RULE_STRING )
            {
            match(input,16,FOLLOW_16_in_ruleReferencedMetamodel356); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@33967b (cardinality: null) (value: 'import')
            grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:198:123: (lv_uri= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:200:4: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel370); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@c3dcdc (cardinality: null) (name: STRING)
            grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"uri"); 
                 if (current==null) {
                  current = factory.create("ReferencedMetamodel");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "uri", lv_uri);


            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:209:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:209:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleReferencedMetamodel380); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@5970bf (cardinality: null) (value: 'as')
                    grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode,null); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:210:123: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:212:4: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel394); 
                     createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@73c718 (cardinality: null) (name: ID)
                    grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"alias"); 
                         if (current==null) {
                          current = factory.create("ReferencedMetamodel");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "alias", lv_alias);


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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:225:1: ruleLexerRule returns [EObject current=null] : ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) ) ;
    public EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_tokenType=null;
        Token lv_body=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:1: ( ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:1: ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:1: ( ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:2: ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' ) (lv_body= RULE_LEXER_BODY )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:2: ( ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:3: ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:3: ( (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:4: (lv_name= RULE_ID ) ( 'tokentype' (lv_tokenType= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:228:4: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:230:4: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule444); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@df7236 (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"name"); 
                 if (current==null) {
                  current = factory.create("LexerRule");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "name", lv_name);


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:239:2: ( 'tokentype' (lv_tokenType= RULE_ID ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:239:3: 'tokentype' (lv_tokenType= RULE_ID )
                    {
                    match(input,17,FOLLOW_17_in_ruleLexerRule453); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@cce1b1 (cardinality: null) (value: 'tokentype')
                    grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:240:159: (lv_tokenType= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:242:4: lv_tokenType= RULE_ID
                    {
                    lv_tokenType=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule467); 
                     createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@2de59c (cardinality: null) (name: ID)
                    grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"tokenType"); 
                         if (current==null) {
                          current = factory.create("LexerRule");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "tokenType", lv_tokenType);


                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleLexerRule478); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@3d8738 (cardinality: null) (value: ':')
            grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:252:124: (lv_body= RULE_LEXER_BODY )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:254:4: lv_body= RULE_LEXER_BODY
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_LEXER_BODY,FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule493); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@7343c7 (cardinality: null) (name: LEXER_BODY)
            grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.1/@terminal"), currentNode,"body"); 
                 if (current==null) {
                  current = factory.create("LexerRule");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "body", lv_body);


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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:267:1: ruleParserRule returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:1: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:2: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:2: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:3: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:3: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:4: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:4: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:5: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:270:5: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:272:4: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule542); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@81a4db (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"name"); 
                 if (current==null) {
                  current = factory.create("ParserRule");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "name", lv_name);


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:281:2: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:281:3: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,18,FOLLOW_18_in_ruleParserRule551); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@a33e9f (cardinality: null) (value: 'returns')
                    grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:282:177: (lv_type= ruleTypeRef )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:283:4: lv_type= ruleTypeRef
                    {
                     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@d62722 (cardinality: null) (name: TypeRef)
                    grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); 
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule567);
                    lv_type=ruleTypeRef();
                    _fsp--;

                      currentNode = currentNode.getParent();   if (current==null) {
                          current = factory.create("ParserRule");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "type", lv_type);


                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleParserRule577); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@a34f90 (cardinality: null) (value: ':')
            grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:294:142: (lv_alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:295:4: lv_alternatives= ruleAlternatives
            {
             currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@ac0466 (cardinality: null) (name: Alternatives)
            grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule594);
            lv_alternatives=ruleAlternatives();
            _fsp--;

              currentNode = currentNode.getParent();   if (current==null) {
                  current = factory.create("ParserRule");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "alternatives", lv_alternatives);


            }


            }

            match(input,19,FOLLOW_19_in_ruleParserRule602); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@54e73f (cardinality: null) (value: ';')
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:310:1: ruleTypeRef returns [EObject current=null] : ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) ;
    public EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;
        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:313:1: ( ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:313:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:313:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:313:2: ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:313:2: ( (lv_alias= RULE_ID ) '::' )?
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
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:313:3: (lv_alias= RULE_ID ) '::'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:313:3: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:315:4: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef644); 
                     createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@7e4017 (cardinality: null) (name: ID)
                    grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"alias"); 
                         if (current==null) {
                          current = factory.create("TypeRef");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "alias", lv_alias);


                    }

                    match(input,20,FOLLOW_20_in_ruleTypeRef652); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@a1bcd3 (cardinality: null) (value: '::')
                    grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:325:125: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:327:4: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef668); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@235025 (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.1/@terminal"), currentNode,"name"); 
                 if (current==null) {
                  current = factory.create("TypeRef");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "name", lv_name);


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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:340:1: ruleAlternatives returns [EObject current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group = null;

        EObject lv_groups = null;


         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:343:1: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:343:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:343:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:343:2: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives709);
            this_Group=ruleGroup();
            _fsp--;

            current = this_Group;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:344:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:344:2: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:344:2: ( () '|' )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:344:3: () '|'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:344:3: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:345:1: 
            	    {
            	     temp=factory.create("Alternatives");
            	      factory.add(temp, "groups",current);
            	      current = temp; 
            	      temp = null;
            	      currentNode=createCompositeNode(// org.eclipse.xtext.impl.ActionImpl@a66e3f (cardinality: null) (operator: +=, feature: groups)
            	    grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"), currentNode); 
            	      associateNodeWithAstElement(currentNode, current); 

            	    }

            	    match(input,21,FOLLOW_21_in_ruleAlternatives719); 
            	     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@96cd9 (cardinality: null) (value: '|')
            	    grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:353:142: (lv_groups= ruleGroup )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:354:4: lv_groups= ruleGroup
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@7ca998 (cardinality: null) (name: Group)
            	    grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); 
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives736);
            	    lv_groups=ruleGroup();
            	    _fsp--;

            	      currentNode = currentNode.getParent();   if (current==null) {
            	          current = factory.create("AbstractElement");
            	          associateNodeWithAstElement(currentNode, current);
            	       }
            	       factory.add(current, "groups", lv_groups);


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

             currentNode = entryNode; 
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:368:1: ruleGroup returns [EObject current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:371:1: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:371:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:371:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:371:2: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup778);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

            current = this_AbstractToken;
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:372:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_STRING)||LA13_0==28||LA13_0==32) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:372:2: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:372:2: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:373:1: 
            	    {
            	     temp=factory.create("Group");
            	      factory.add(temp, "abstractTokens",current);
            	      current = temp; 
            	      temp = null;
            	      currentNode=createCompositeNode(// org.eclipse.xtext.impl.ActionImpl@1c2fab (cardinality: null) (operator: +=, feature: abstractTokens)
            	    grammar.eResource().getEObject("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode); 
            	      associateNodeWithAstElement(currentNode, current); 

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:380:2: (lv_abstractTokens= ruleAbstractToken )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:381:4: lv_abstractTokens= ruleAbstractToken
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@5a4b27 (cardinality: null) (name: AbstractToken)
            	    grammar.eResource().getEObject("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); 
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup800);
            	    lv_abstractTokens=ruleAbstractToken();
            	    _fsp--;

            	      currentNode = currentNode.getParent();   if (current==null) {
            	          current = factory.create("AbstractElement");
            	          associateNodeWithAstElement(currentNode, current);
            	       }
            	       factory.add(current, "abstractTokens", lv_abstractTokens);


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

             currentNode = entryNode; 
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:395:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_Assignment = null;

        EObject this_Action = null;

        EObject this_AbstractTerminal = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:398:1: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:398:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:398:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:398:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:398:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
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
                        new NoViableAltException("398:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 15, 1, input);

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
                    new NoViableAltException("398:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:398:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:398:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
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
                            new NoViableAltException("398:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:398:4: this_Assignment= ruleAssignment
                            {
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken840);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                            current = this_Assignment;

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:399:2: this_Action= ruleAction
                            {
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken846);
                            this_Action=ruleAction();
                            _fsp--;

                            current = this_Action;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:400:3: this_AbstractTerminal= ruleAbstractTerminal
                    {
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken853);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                    current = this_AbstractTerminal;

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:401:2: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=22 && LA16_0<=24)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:403:4: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    lv_cardinality=(Token)input.LT(1);
                    if ( (input.LA(1)>=22 && input.LA(1)<=24) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAbstractToken868);    throw mse;
                    }

                         if (current==null) {
                          current = factory.create("AbstractElement");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "cardinality", lv_cardinality);
                    createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@64813b (cardinality: null)
                    grammar.eResource().getEObject("//@parserRules.10/@alternatives/@abstractTokens.1/@terminal"), currentNode,"cardinality");

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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:415:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_terminal = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:418:1: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:418:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:418:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:418:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:418:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:418:3: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:418:3: (lv_feature= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:420:4: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment925); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@abdf23 (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"feature"); 
                 if (current==null) {
                  current = factory.create("Assignment");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "feature", lv_feature);


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:429:2: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:431:4: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            lv_operator=(Token)input.LT(1);
            if ( (input.LA(1)>=25 && input.LA(1)<=27) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAssignment944);    throw mse;
            }

                 if (current==null) {
                  current = factory.create("Assignment");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "operator", lv_operator);
            createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@912008 (cardinality: null)
            grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"operator");

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:439:3: (lv_terminal= ruleAbstractTerminal )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:440:4: lv_terminal= ruleAbstractTerminal
            {
             currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@d810b (cardinality: null) (name: AbstractTerminal)
            grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.1/@terminal"), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment975);
            lv_terminal=ruleAbstractTerminal();
            _fsp--;

              currentNode = currentNode.getParent();   if (current==null) {
                  current = factory.create("Assignment");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "terminal", lv_terminal);


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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:454:1: ruleAction returns [EObject current=null] : ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) ;
    public EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_typeName = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:457:1: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:457:1: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:457:1: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:457:2: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:457:2: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:457:3: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:457:3: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:457:4: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:457:4: ( '{' ( 'current' '=' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:457:5: '{' ( 'current' '=' )?
            {
            match(input,28,FOLLOW_28_in_ruleAction1012); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@6ea1eb (cardinality: null) (value: '{')
            grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:458:160: ( 'current' '=' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:458:161: 'current' '='
                    {
                    match(input,29,FOLLOW_29_in_ruleAction1016); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@a01125 (cardinality: null) (value: 'current')
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); 
                    match(input,26,FOLLOW_26_in_ruleAction1019); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@c59c26 (cardinality: null) (value: '=')
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1"), currentNode,null); 

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:460:181: (lv_typeName= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:461:4: lv_typeName= ruleTypeRef
            {
             currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@74dd2a (cardinality: null) (name: TypeRef)
            grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction1038);
            lv_typeName=ruleTypeRef();
            _fsp--;

              currentNode = currentNode.getParent();   if (current==null) {
                  current = factory.create("Action");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "typeName", lv_typeName);


            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:471:3: ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:471:4: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:471:4: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:471:5: ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:471:5: ( '.' (lv_feature= RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:471:6: '.' (lv_feature= RULE_ID )
                    {
                    match(input,30,FOLLOW_30_in_ruleAction1049); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@62bb6 (cardinality: null) (value: '.')
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:472:178: (lv_feature= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:474:4: lv_feature= RULE_ID
                    {
                    lv_feature=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction1063); 
                     createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@c682d9 (cardinality: null) (name: ID)
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"feature"); 
                         if (current==null) {
                          current = factory.create("Action");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "feature", lv_feature);


                    }


                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:483:3: (lv_operator= ( '=' | '+=' ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:485:4: lv_operator= ( '=' | '+=' )
                    {
                    lv_operator=(Token)input.LT(1);
                    if ( (input.LA(1)>=25 && input.LA(1)<=26) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAction1083);    throw mse;
                    }

                         if (current==null) {
                          current = factory.create("Action");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "operator", lv_operator);
                    createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@642eab (cardinality: null)
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"operator");

                    }


                    }

                    match(input,29,FOLLOW_29_in_ruleAction1096); 
                     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@201419 (cardinality: null) (value: 'current')
                    grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1"), currentNode,null); 

                    }
                    break;

            }


            }

            match(input,31,FOLLOW_31_in_ruleAction1102); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@77a80 (cardinality: null) (value: '}')
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:499:1: ruleAbstractTerminal returns [EObject current=null] : ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) ;
    public EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedElement = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:502:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:502:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:502:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
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
                    new NoViableAltException("502:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:502:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:502:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
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
                            new NoViableAltException("502:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:502:3: this_Keyword= ruleKeyword
                            {
                            pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal1135);
                            this_Keyword=ruleKeyword();
                            _fsp--;

                            current = this_Keyword;

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:503:2: this_RuleCall= ruleRuleCall
                            {
                            pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal1141);
                            this_RuleCall=ruleRuleCall();
                            _fsp--;

                            current = this_RuleCall;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:504:3: this_ParenthesizedElement= ruleParenthesizedElement
                    {
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal1148);
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:509:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:512:1: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:512:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:512:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:512:2: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:512:2: ( '(' this_Alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:512:3: '(' this_Alternatives= ruleAlternatives
            {
            match(input,32,FOLLOW_32_in_ruleParenthesizedElement1179); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@550a3c (cardinality: null) (value: '(')
            grammar.eResource().getEObject("//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement1184);
            this_Alternatives=ruleAlternatives();
            _fsp--;

            current = this_Alternatives;

            }

            match(input,33,FOLLOW_33_in_ruleParenthesizedElement1188); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@b5168d (cardinality: null) (value: ')')
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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:519:1: ruleKeyword returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:522:1: ( (lv_value= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:522:1: (lv_value= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:522:1: (lv_value= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:524:4: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1228); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@669976 (cardinality: null) (name: STRING)
            grammar.eResource().getEObject("//@parserRules.15/@alternatives/@terminal"), currentNode,"value"); 
                 if (current==null) {
                  current = factory.create("Keyword");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "value", lv_value);


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
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:537:1: ruleRuleCall returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:540:1: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:540:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:540:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:542:4: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall1272); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@80bc43 (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.16/@alternatives/@terminal"), currentNode,"name"); 
                 if (current==null) {
                  current = factory.create("RuleCall");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "name", lv_name);


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
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar93 = new BitSet(new long[]{0x0000000000015012L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleGrammar114 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_12_in_ruleGrammar125 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGrammar128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleGrammar145 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleGeneratedMetamodel260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel274 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel294 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleGeneratedMetamodel304 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleReferencedMetamodel356 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel370 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleReferencedMetamodel380 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule444 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleLexerRule453 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule467 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLexerRule478 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_LEXER_BODY_in_ruleLexerRule493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule542 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_18_in_ruleParserRule551 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule567 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleParserRule577 = new BitSet(new long[]{0x0000000110000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule594 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleParserRule602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef644 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTypeRef652 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives709 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleAlternatives719 = new BitSet(new long[]{0x0000000110000030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives736 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup778 = new BitSet(new long[]{0x0000000110000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup800 = new BitSet(new long[]{0x0000000110000032L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken840 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken846 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken853 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_set_in_ruleAbstractToken868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment925 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_set_in_ruleAssignment944 = new BitSet(new long[]{0x0000000100000030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAction1012 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_29_in_ruleAction1016 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAction1019 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction1038 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleAction1049 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction1063 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_set_in_ruleAction1083 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAction1096 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAction1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleParenthesizedElement1179 = new BitSet(new long[]{0x0000000110000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement1184 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleParenthesizedElement1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall1272 = new BitSet(new long[]{0x0000000000000002L});

}