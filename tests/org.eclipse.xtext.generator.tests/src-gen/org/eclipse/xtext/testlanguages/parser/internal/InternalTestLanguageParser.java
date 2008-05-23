// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g 2008-05-23 10:24:32

package org.eclipse.xtext.testlanguages.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parser.internal.TestLanguageTokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTestLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_SL_COMMENT", "RULE_LEXER_BODY", "RULE_INT", "RULE_ANY_OTHER", "'choice'", "'optional'", "'reducible'"
    };
    public static final int RULE_ML_COMMENT=6;
    public static final int RULE_ID=4;
    public static final int RULE_WS=7;
    public static final int RULE_INT=10;
    public static final int EOF=-1;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=9;

        public InternalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g"; }



    	private IElementFactory factory;
    	public InternalTestLanguageParser(TokenStream input, IElementFactory factory) {
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
    		LexerRule lexerRule = TestLanguageTokenTypeResolver.getLexerRule(node, t.getType());
    		if(lexerRule != null) {
    			node.setGrammarElement(lexerRule);
    		}
    	}
    	
    	private CompositeNode currentNode;
    	public CompositeNode getCurrentNode() {
    		return currentNode;
    	}
    	
    	private org.eclipse.xtext.Grammar grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/TestLanguage").getGrammar();;




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:160:1: parse returns [EObject current] : ruleEntryRule EOF ;
    public EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleEntryRule1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:161:5: ( ruleEntryRule EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:161:5: ruleEntryRule EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleEntryRule_in_parse59);
            ruleEntryRule1=ruleEntryRule();
            _fsp--;

             current =ruleEntryRule1; 
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


    // $ANTLR start ruleEntryRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:171:1: ruleEntryRule returns [EObject current=null] : (lv_multiFeature= ruleAbstractRule )* ;
    public EObject ruleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject lv_multiFeature = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:173:1: ( (lv_multiFeature= ruleAbstractRule )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:173:1: (lv_multiFeature= ruleAbstractRule )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:173:1: (lv_multiFeature= ruleAbstractRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:175:5: lv_multiFeature= ruleAbstractRule
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleEntryRule136);
            	    lv_multiFeature=ruleAbstractRule();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Model");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "multiFeature", lv_multiFeature);    

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
    // $ANTLR end ruleEntryRule


    // $ANTLR start ruleAbstractRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:190:1: ruleAbstractRule returns [EObject current=null] : (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule ) ;
    public EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ChoiceRule = null;

        EObject this_ReducibleRule = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:192:1: ( (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:192:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:192:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("192:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:192:2: this_ChoiceRule= ruleChoiceRule
                    {
                    pushFollow(FOLLOW_ruleChoiceRule_in_ruleAbstractRule176);
                    this_ChoiceRule=ruleChoiceRule();
                    _fsp--;

                     
                            current = this_ChoiceRule; 
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:197:6: this_ReducibleRule= ruleReducibleRule
                    {
                    pushFollow(FOLLOW_ruleReducibleRule_in_ruleAbstractRule192);
                    this_ReducibleRule=ruleReducibleRule();
                    _fsp--;

                     
                            current = this_ReducibleRule; 
                        

                    }
                    break;

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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start ruleChoiceRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:205:1: ruleChoiceRule returns [EObject current=null] : ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) ) ;
    public EObject ruleChoiceRule() throws RecognitionException {
        EObject current = null;

        Token lv_optionalKeyword=null;
        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:207:1: ( ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:207:1: ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:207:1: ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:207:2: ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:207:2: ( 'choice' (lv_optionalKeyword= 'optional' )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:207:3: 'choice' (lv_optionalKeyword= 'optional' )?
            {
            match(input,12,FOLLOW_12_in_ruleChoiceRule229); 

                    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:212:1: (lv_optionalKeyword= 'optional' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:213:5: lv_optionalKeyword= 'optional'
                    {
                    lv_optionalKeyword=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleChoiceRule247); 

                            if (current==null) {
                                current = factory.create("ChoiceElement");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "optionalKeyword", true);        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"optionalKeyword");    

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:221:4: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:222:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoiceRule269); 
             
                createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("ChoiceElement");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

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
    // $ANTLR end ruleChoiceRule


    // $ANTLR start ruleReducibleRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:237:1: ruleReducibleRule returns [EObject current=null] : ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? ) ;
    public EObject ruleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalRule = null;

        EObject lv_actionFeature = null;


         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:1: ( ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:1: ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:1: ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:2: ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:2: ( 'reducible' this_TerminalRule= ruleTerminalRule )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:239:3: 'reducible' this_TerminalRule= ruleTerminalRule
            {
            match(input,14,FOLLOW_14_in_ruleReducibleRule319); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            pushFollow(FOLLOW_ruleTerminalRule_in_ruleReducibleRule331);
            this_TerminalRule=ruleTerminalRule();
            _fsp--;

             
                    current = this_TerminalRule; 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:248:2: ( () (lv_actionFeature= ruleTerminalRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:248:3: () (lv_actionFeature= ruleTerminalRule )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:248:3: ()
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:249:5: 
                    {
                     
                            temp=factory.create("ReducibleComposite");
                            factory.add(temp, "actionFeature",current);
                            current = temp; 
                            temp = null;
                            currentNode=createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode); 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:257:2: (lv_actionFeature= ruleTerminalRule )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:259:5: lv_actionFeature= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleReducibleRule369);
                    lv_actionFeature=ruleTerminalRule();
                    _fsp--;


                            currentNode = currentNode.getParent();
                            if (current==null) {
                                current = factory.create("ReducibleElement");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.add(current, "actionFeature", lv_actionFeature);    

                    }


                    }
                    break;

            }


            }


            }

             currentNode = entryNode; 
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
    // $ANTLR end ruleReducibleRule


    // $ANTLR start ruleTerminalRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:274:1: ruleTerminalRule returns [EObject current=null] : (lv_stringFeature= RULE_STRING ) ;
    public EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_stringFeature=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:276:1: ( (lv_stringFeature= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:276:1: (lv_stringFeature= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:276:1: (lv_stringFeature= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.g:277:5: lv_stringFeature= RULE_STRING
            {
            lv_stringFeature=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTerminalRule416); 
             
                createLeafNode("//@parserRules.4/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"stringFeature"); 
                

                    if (current==null) {
                        current = factory.create("TerminalElement");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "stringFeature", lv_stringFeature);    

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
    // $ANTLR end ruleTerminalRule


 

    public static final BitSet FOLLOW_ruleEntryRule_in_parse59 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleEntryRule136 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleChoiceRule_in_ruleAbstractRule176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReducibleRule_in_ruleAbstractRule192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleChoiceRule229 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_13_in_ruleChoiceRule247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoiceRule269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleReducibleRule319 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule331 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTerminalRule416 = new BitSet(new long[]{0x0000000000000002L});

}