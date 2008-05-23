// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g 2008-05-23 10:24:33

package org.eclipse.xtext.testlanguages.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parser.internal.LexerLanguageTokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLexerLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_EXPLICITTOKENTYPE", "RULE_IMPLICITTOKENTYPE", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_SL_COMMENT", "RULE_LEXER_BODY", "RULE_INT", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_INT=12;
    public static final int EOF=-1;
    public static final int RULE_IMPLICITTOKENTYPE=6;
    public static final int RULE_STRING=7;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_EXPLICITTOKENTYPE=5;
    public static final int RULE_LEXER_BODY=11;

        public InternalLexerLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g"; }



    	private IElementFactory factory;
    	public InternalLexerLanguageParser(TokenStream input, IElementFactory factory) {
    	    this(input);
    	    this.factory = factory;
    	}
    	
    	protected void reportError(RecognitionException re, LeafNode ln) {
            	reportError(re);
        	}
        		
        		private int lastConsumedIndex = -1;
        	
        	 	private void appendAllTokens() {
            		for (int x = lastConsumedIndex+1; input.size()>x;input.consume(),x++) {
        		        Token hidden = input.get(x);
        		        LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
        		        leafNode.setText(hidden.getText());
        		        leafNode.setHidden(true);
        		        setLexerRule(leafNode, hidden);
        		        currentNode.getChildren().add(leafNode);
        		    }
            	}

             	public List<LeafNode> appendSkippedTokens() {
            		List<LeafNode> skipped = new ArrayList<LeafNode>();
            		Token token = input.LT(-1);
            		Token tokenBefore = input.get(lastConsumedIndex);
            		int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
            		if (indexOfTokenBefore+1<token.getTokenIndex()) {
            		    for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
            		        Token hidden = input.get(x);
            		        LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
            		        leafNode.setText(hidden.getText());
            		        leafNode.setHidden(true);
            		        setLexerRule(leafNode, hidden);
            		        currentNode.getChildren().add(leafNode);
            		        skipped.add(leafNode);
            		    }
            		}
            		LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
    		        leafNode.setText(token.getText());
    		        leafNode.setHidden(true);
    		        setLexerRule(leafNode, token);
    		        currentNode.getChildren().add(leafNode);
    		        skipped.add(leafNode);
            		lastConsumedIndex = token.getTokenIndex();
            		return skipped;
            	}
            	
                public CompositeNode createCompositeNode(String grammarElementID, CompositeNode parentNode) {
                    CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
                    if (parentNode!=null) parentNode.getChildren().add(compositeNode);
                    compositeNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
                    return compositeNode;
                }
                

                public Object createLeafNode(String grammarElementID, CompositeNode parentNode, String feature) {
                    Token token = input.LT(-1);
                    int indexOfTokenBefore = lastConsumedIndex;
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
                    lastConsumedIndex = token.getTokenIndex();
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
                            lastConsumedIndex = hidden.getTokenIndex();
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
    		LexerRule lexerRule = LexerLanguageTokenTypeResolver.getLexerRule(node, t.getType());
    		if(lexerRule != null) {
    			node.setGrammarElement(lexerRule);
    		}
    	}
    	
    	private CompositeNode currentNode;
    	public CompositeNode getCurrentNode() {
    		return currentNode;
    	}
    	
    	private org.eclipse.xtext.Grammar grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/LexerLanguage").getGrammar();;




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:160:1: parse returns [EObject current] : ruleModel EOF ;
    public EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleModel1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:161:5: ( ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:161:5: ruleModel EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_parse59);
            ruleModel1=ruleModel();
            _fsp--;

             current =ruleModel1; 
            match(input,EOF,FOLLOW_EOF_in_parse73); 
             appendTrailingHiddenTokens(currentNode); 

            }

        }
         
        	catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                LeafNode ln = null;
                if (currentNode!=null) {
        	        CompositeNode root = (CompositeNode) EcoreUtil.getRootContainer(currentNode);
        	        List<LeafNode> list = root.getLeafNodes();
        	        if (list.size()>lastErrorIndex)
        	        	ln = list.get(lastErrorIndex);
                }
        		reportError(re, ln);
        	} 
        finally {
             appendAllTokens(); 
        }
        return current;
    }
    // $ANTLR end parse


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:171:1: ruleModel returns [EObject current=null] : (lv_children= ruleElement )* ;
    public EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:173:1: ( (lv_children= ruleElement )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:173:1: (lv_children= ruleElement )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:173:1: (lv_children= ruleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:175:5: lv_children= ruleElement
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel136);
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
                recover(input,re); 
                appendSkippedTokens();
                LeafNode ln = null;
                if (currentNode!=null) {
        	        CompositeNode root = (CompositeNode) EcoreUtil.getRootContainer(currentNode);
        	        List<LeafNode> list = root.getLeafNodes();
        	        if (list.size()>lastErrorIndex)
        	        	ln = list.get(lastErrorIndex);
                }
        		reportError(re, ln);
        	} 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start ruleElement
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:190:1: ruleElement returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) ) ) ;
    public EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_f=null;
        Token lv_g=null;
        Token lv_h=null;
        Token lv_i=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:1: ( ( ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:1: ( ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:1: ( ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:2: ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:2: ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:3: ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:3: ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:4: ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:4: ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:5: (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:192:5: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:193:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElement185); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:204:2: (lv_f= RULE_EXPLICITTOKENTYPE )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:205:5: lv_f= RULE_EXPLICITTOKENTYPE
            {
            lv_f=(Token)input.LT(1);
            match(input,RULE_EXPLICITTOKENTYPE,FOLLOW_RULE_EXPLICITTOKENTYPE_in_ruleElement210); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"f"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "f", lv_f);    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:216:3: (lv_g= RULE_IMPLICITTOKENTYPE )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:217:5: lv_g= RULE_IMPLICITTOKENTYPE
            {
            lv_g=(Token)input.LT(1);
            match(input,RULE_IMPLICITTOKENTYPE,FOLLOW_RULE_IMPLICITTOKENTYPE_in_ruleElement236); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"g"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "g", lv_g);    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:228:3: (lv_h= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:229:5: lv_h= RULE_STRING
            {
            lv_h=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElement262); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"h"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "h", lv_h);    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:240:3: (lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:241:5: lv_i= ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:241:10: ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_EXPLICITTOKENTYPE) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_IMPLICITTOKENTYPE) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("241:10: ( RULE_EXPLICITTOKENTYPE | RULE_IMPLICITTOKENTYPE )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:241:11: RULE_EXPLICITTOKENTYPE
                    {
                    match(input,RULE_EXPLICITTOKENTYPE,FOLLOW_RULE_EXPLICITTOKENTYPE_in_ruleElement289); 
                     
                        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@terminal/@groups.0" /* xtext::RuleCall */, currentNode,"i"); 
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLexerLanguage.g:246:6: RULE_IMPLICITTOKENTYPE
                    {
                    match(input,RULE_IMPLICITTOKENTYPE,FOLLOW_RULE_IMPLICITTOKENTYPE_in_ruleElement303); 
                     
                        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::RuleCall */, currentNode,"i"); 
                        

                    }
                    break;

            }


                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "i", lv_i);    

            }


            }


            }

        }
         
        	catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                LeafNode ln = null;
                if (currentNode!=null) {
        	        CompositeNode root = (CompositeNode) EcoreUtil.getRootContainer(currentNode);
        	        List<LeafNode> list = root.getLeafNodes();
        	        if (list.size()>lastErrorIndex)
        	        	ln = list.get(lastErrorIndex);
                }
        		reportError(re, ln);
        	} 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleElement


 

    public static final BitSet FOLLOW_ruleModel_in_parse59 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel136 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElement185 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_EXPLICITTOKENTYPE_in_ruleElement210 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_IMPLICITTOKENTYPE_in_ruleElement236 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElement262 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_EXPLICITTOKENTYPE_in_ruleElement289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IMPLICITTOKENTYPE_in_ruleElement303 = new BitSet(new long[]{0x0000000000000002L});

}