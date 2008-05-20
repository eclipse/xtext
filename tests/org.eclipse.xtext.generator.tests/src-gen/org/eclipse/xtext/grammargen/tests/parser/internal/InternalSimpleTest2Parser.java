// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g 2008-05-20 17:36:34

package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammargen.tests.parser.internal.SimpleTest2TokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleTest2Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_SL_COMMENT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_LEXER_BODY", "RULE_WS", "RULE_ANY_OTHER", "'optional'", "'keyword'", "'{'", "'}'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=6;
    public static final int RULE_LEXER_BODY=9;

        public InternalSimpleTest2Parser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g"; }



    private IElementFactory factory;
    public InternalSimpleTest2Parser(TokenStream input, IElementFactory factory) {
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
    	LexerRule lexerRule = SimpleTest2TokenTypeResolver.getLexerRule(node, t.getType());
    	if(lexerRule != null) {
    		node.setGrammarElement(lexerRule);
    	}
    }

    private CompositeNode currentNode;

    private org.eclipse.xtext.Grammar grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/grammargen/tests/SimpleTest2").getGrammar();;




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:96:1: parse returns [EObject current] : ruleModel EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleModel1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:96:33: ( ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:97:5: ruleModel EOF
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
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:106:1: ruleModel returns [EObject current=null] : (lv_contents= ruleChild )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_contents = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:107:37: ( (lv_contents= ruleChild )* )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:108:1: (lv_contents= ruleChild )*
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:108:1: (lv_contents= ruleChild )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:110:5: lv_contents= ruleChild
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleChild_in_ruleModel121);
            	    lv_contents=ruleChild();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Model");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "contents", lv_contents);    

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


    // $ANTLR start ruleChild
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:125:1: ruleChild returns [EObject current=null] : ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        Token lv_optional=null;
        Token lv_name=null;
        Token lv_number=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:126:37: ( ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:1: ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:1: ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:2: ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}'
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:2: ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:3: ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{'
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:3: ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:4: ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:4: ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:5: ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:5: ( (lv_optional= 'optional' )? 'keyword' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:6: (lv_optional= 'optional' )? 'keyword'
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:127:6: (lv_optional= 'optional' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:128:5: lv_optional= 'optional'
                    {
                    lv_optional=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleChild171); 

                            if (current==null) {
                                current = factory.create("Child");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "optional", true);        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, currentNode,"optional");    

                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleChild184); 

                    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:141:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:142:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChild203); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Child");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }


            }

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:153:3: (lv_number= RULE_INT )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:154:5: lv_number= RULE_INT
            {
            lv_number=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleChild229); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"number"); 
                

                    if (current==null) {
                        current = factory.create("Child");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "number", lv_number);    

            }


            }

            match(input,14,FOLLOW_14_in_ruleChild247); 

                    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            match(input,15,FOLLOW_15_in_ruleChild258); 

                    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

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
    // $ANTLR end ruleChild


 

    public static final BitSet FOLLOW_ruleModel_in_parse53 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_ruleModel121 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleChild171 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleChild184 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChild203 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleChild229 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleChild247 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleChild258 = new BitSet(new long[]{0x0000000000000002L});

}