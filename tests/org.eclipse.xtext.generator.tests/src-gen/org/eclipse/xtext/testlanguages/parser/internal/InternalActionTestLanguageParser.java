// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g 2008-05-20 17:36:40

package org.eclipse.xtext.testlanguages.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parser.internal.ActionTestLanguageTokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalActionTestLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SL_COMMENT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_LEXER_BODY", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_INT=9;
    public static final int EOF=-1;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=5;
    public static final int RULE_LEXER_BODY=8;

        public InternalActionTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g"; }



    private IElementFactory factory;
    public InternalActionTestLanguageParser(TokenStream input, IElementFactory factory) {
        this(input);
        this.factory = factory;
    }

    public CompositeNode createCompositeNode(String grammarElementID, CompositeNode parentNode) {
        CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
        if (parentNode!=null) parentNode.getChildren().add(compositeNode);
        compositeNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
        return compositeNode;
    }

    public Object createLeafNode(String grammarElementID, CompositeNode parentNode, String feature) {
        Token token = input.LT(-1);
        Token tokenBefore = input.LT(-2);
        int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
        if (indexOfTokenBefore+1<token.getTokenIndex()) {
            for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
                Token hidden = input.get(x);
                LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                leafNode.setText(hidden.getText());
                leafNode.setHidden(true);
    		    setLexerRule(leafNode, hidden);
                parentNode.getChildren().add(leafNode);
            }
        }
        LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
        leafNode.setText(token.getText());
        leafNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
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
                setLexerRule(leafNode, hidden);
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
        
    protected void setLexerRule(LeafNode node, Token t) {
    	LexerRule lexerRule = ActionTestLanguageTokenTypeResolver.getLexerRule(node, t.getType());
    	if(lexerRule != null) {
    		node.setGrammarElement(lexerRule);
    	}
    }

    private CompositeNode currentNode;

    private org.eclipse.xtext.Grammar grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/ActionTestLanguage").getGrammar();;




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:96:1: parse returns [EObject current] : ruleModel EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleModel1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:96:33: ( ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:97:5: ruleModel EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_parse53);
            ruleModel1=ruleModel();
            _fsp--;

             current =ruleModel1; 
            match(input,EOF,FOLLOW_EOF_in_parse67); 
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


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:106:1: ruleModel returns [EObject current=null] : (lv_children= ruleElement )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:107:37: ( (lv_children= ruleElement )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:108:1: (lv_children= ruleElement )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:108:1: (lv_children= ruleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:110:5: lv_children= ruleElement
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel121);
            	    lv_children=ruleElement();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Model");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "children", lv_children);    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end ruleModel


    // $ANTLR start ruleElement
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:125:1: ruleElement returns [EObject current=null] : (this_Item= ruleItem ( () (lv_items= ruleItem ) ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Item = null;

        EObject lv_items = null;


         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:126:111: ( (this_Item= ruleItem ( () (lv_items= ruleItem ) ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:127:1: (this_Item= ruleItem ( () (lv_items= ruleItem ) ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:127:1: (this_Item= ruleItem ( () (lv_items= ruleItem ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:127:2: this_Item= ruleItem ( () (lv_items= ruleItem ) )
            {
            pushFollow(FOLLOW_ruleItem_in_ruleElement165);
            this_Item=ruleItem();
            _fsp--;

             
                    current = this_Item; 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:131:1: ( () (lv_items= ruleItem ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:131:2: () (lv_items= ruleItem )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:131:2: ()
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:132:5: 
            {
             
                    temp=factory.create("Item");
                    factory.add(temp, "items",current);
                    current = temp; 
                    temp = null;
                    currentNode=createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode); 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:140:2: (lv_items= ruleItem )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:142:5: lv_items= ruleItem
            {
             
                    currentNode=createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleItem_in_ruleElement202);
            lv_items=ruleItem();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("Type");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.add(current, "items", lv_items);    

            }


            }


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
    // $ANTLR end ruleElement


    // $ANTLR start ruleItem
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:157:1: ruleItem returns [EObject current=null] : ( () (lv_name= RULE_ID ) ) ;
    public final EObject ruleItem() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:158:111: ( ( () (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:159:1: ( () (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:159:1: ( () (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:159:2: () (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:159:2: ()
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:160:5: 
            {
             
                    temp=factory.create("Thing");
                    factory.set(temp, "content",current);
                    current = temp; 
                    temp = null;
                    currentNode=createCompositeNode("//@parserRules.2/@alternatives/@abstractTokens.0" /* xtext::Action */, currentNode); 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:168:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:169:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleItem262); 
             
                createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Type");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }


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
    // $ANTLR end ruleItem


 

    public static final BitSet FOLLOW_ruleModel_in_parse53 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel121 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleItem_in_ruleElement165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleItem_in_ruleElement202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleItem262 = new BitSet(new long[]{0x0000000000000002L});

}