// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g 2008-05-23 10:24:33

package org.eclipse.xtext.parsetree.reconstr.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.parser.internal.ComplexReconstrTestTokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalComplexReconstrTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_SL_COMMENT", "RULE_LEXER_BODY", "RULE_INT", "RULE_ANY_OTHER", "'+'", "'-'", "'('", "')'", "'!'"
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

        public InternalComplexReconstrTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g"; }



    	private IElementFactory factory;
    	public InternalComplexReconstrTestParser(TokenStream input, IElementFactory factory) {
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
    		LexerRule lexerRule = ComplexReconstrTestTokenTypeResolver.getLexerRule(node, t.getType());
    		if(lexerRule != null) {
    			node.setGrammarElement(lexerRule);
    		}
    	}
    	
    	private CompositeNode currentNode;
    	public CompositeNode getCurrentNode() {
    		return currentNode;
    	}
    	
    	private org.eclipse.xtext.Grammar grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest").getGrammar();;




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:160:1: parse returns [EObject current] : ruleOp EOF ;
    public EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleOp1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:161:5: ( ruleOp EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:161:5: ruleOp EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleOp_in_parse59);
            ruleOp1=ruleOp();
            _fsp--;

             current =ruleOp1; 
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


    // $ANTLR start ruleOp
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:171:1: ruleOp returns [EObject current=null] : (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* ) ;
    public EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term = null;

        EObject lv_addOperands = null;

        EObject lv_minusOperands = null;


         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:173:1: ( (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:173:1: (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:173:1: (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:173:2: this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )*
            {
            pushFollow(FOLLOW_ruleTerm_in_ruleOp124);
            this_Term=ruleTerm();
            _fsp--;

             
                    current = this_Term; 
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:177:1: ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }
                else if ( (LA1_0==13) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:177:2: ( ( () '+' ) (lv_addOperands= ruleTerm ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:177:2: ( ( () '+' ) (lv_addOperands= ruleTerm ) )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:177:3: ( () '+' ) (lv_addOperands= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:177:3: ( () '+' )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:177:4: () '+'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:177:4: ()
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:178:5: 
            	    {
            	     
            	            temp=factory.create("Add");
            	            factory.add(temp, "addOperands",current);
            	            current = temp; 
            	            temp = null;
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode); 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,12,FOLLOW_12_in_ruleOp144); 

            	            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:191:2: (lv_addOperands= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:193:5: lv_addOperands= ruleTerm
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp174);
            	    lv_addOperands=ruleTerm();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "addOperands", lv_addOperands);    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:205:6: ( ( () '-' ) (lv_minusOperands= ruleTerm ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:205:6: ( ( () '-' ) (lv_minusOperands= ruleTerm ) )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:205:7: ( () '-' ) (lv_minusOperands= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:205:7: ( () '-' )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:205:8: () '-'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:205:8: ()
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:206:5: 
            	    {
            	     
            	            temp=factory.create("Minus");
            	            factory.add(temp, "minusOperands",current);
            	            current = temp; 
            	            temp = null;
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode); 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,13,FOLLOW_13_in_ruleOp202); 

            	            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:219:2: (lv_minusOperands= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:221:5: lv_minusOperands= ruleTerm
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp232);
            	    lv_minusOperands=ruleTerm();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "minusOperands", lv_minusOperands);    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end ruleOp


    // $ANTLR start ruleTerm
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:236:1: ruleTerm returns [EObject current=null] : (this_Atom= ruleAtom | this_Parens= ruleParens ) ;
    public EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom = null;

        EObject this_Parens = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:238:1: ( (this_Atom= ruleAtom | this_Parens= ruleParens ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:238:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:238:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("238:1: (this_Atom= ruleAtom | this_Parens= ruleParens )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:238:2: this_Atom= ruleAtom
                    {
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm275);
                    this_Atom=ruleAtom();
                    _fsp--;

                     
                            current = this_Atom; 
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:243:6: this_Parens= ruleParens
                    {
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm291);
                    this_Parens=ruleParens();
                    _fsp--;

                     
                            current = this_Parens; 
                        

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
    // $ANTLR end ruleTerm


    // $ANTLR start ruleAtom
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:251:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:253:1: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:253:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:253:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:254:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom334); 
             
                createLeafNode("//@parserRules.2/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Atom");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

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
    // $ANTLR end ruleAtom


    // $ANTLR start ruleParens
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:269:1: ruleParens returns [EObject current=null] : ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) ;
    public EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token lv_em=null;
        EObject this_Op = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:271:1: ( ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:271:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:271:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:271:2: ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )?
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:271:2: ( ( '(' this_Op= ruleOp ) ')' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:271:3: ( '(' this_Op= ruleOp ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:271:3: ( '(' this_Op= ruleOp )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:271:4: '(' this_Op= ruleOp
            {
            match(input,14,FOLLOW_14_in_ruleParens380); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            pushFollow(FOLLOW_ruleOp_in_ruleParens392);
            this_Op=ruleOp();
            _fsp--;

             
                    current = this_Op; 
                

            }

            match(input,15,FOLLOW_15_in_ruleParens401); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:285:2: (lv_em= '!' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:286:5: lv_em= '!'
                    {
                    lv_em=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleParens420); 

                            if (current==null) {
                                current = factory.create("Expression");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "em", lv_em);        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"em");    

                    }
                    break;

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
    // $ANTLR end ruleParens


 

    public static final BitSet FOLLOW_ruleOp_in_parse59 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp124 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleOp144 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp174 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_13_in_ruleOp202 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp232 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleParens380 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleOp_in_ruleParens392 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParens401 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleParens420 = new BitSet(new long[]{0x0000000000000002L});

}