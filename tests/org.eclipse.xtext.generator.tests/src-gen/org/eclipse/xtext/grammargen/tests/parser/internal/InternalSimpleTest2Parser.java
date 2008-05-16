// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g 2008-05-16 10:06:32

package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleTest2Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_STRING", "RULE_ANY_OTHER", "'optional'", "'keyword'", "'{'", "'}'"
    };
    public static final int RULE_ML_COMMENT=6;
    public static final int RULE_ID=4;
    public static final int RULE_WS=8;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=7;
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
    	
    public void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
    	node.setElement(astElement);
    	if(astElement instanceof EObject) {
    		EObject eObject = (EObject) astElement;
    		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
    		adapter.setParserNode(node); 
    	}
    }
    	
    private CompositeNode currentNode;

    private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.grammargen.tests.SimpleTest2Constants.getSimpleTest2Grammar();



    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:83:1: parse returns [EObject current] : ruleModel EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleModel1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:83:33: ( ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:84:2: ruleModel EOF
            {
            pushFollow(FOLLOW_ruleModel_in_parse43);
            ruleModel1=ruleModel();
            _fsp--;

            current =ruleModel1;
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


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:87:1: ruleModel returns [EObject current=null] : (lv_contents= ruleChild )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_contents = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:87:42: ( (lv_contents= ruleChild )* )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:87:44: (lv_contents= ruleChild )*
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.0")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:90:1: (lv_contents= ruleChild )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:91:2: lv_contents= ruleChild
            	    {
            	    pushFollow(FOLLOW_ruleChild_in_ruleModel72);
            	    lv_contents=ruleChild();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("Model");}
            	    	factory.add(current, "contents",lv_contents);
            	    	associateNodeWithAstElement(currentNode, current);
            	    	

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

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
    // $ANTLR end ruleModel


    // $ANTLR start ruleChild
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:100:1: ruleChild returns [EObject current=null] : ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        Token lv_optional=null;
        Token lv_name=null;
        Token lv_number=null;

        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:100:42: ( ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:100:44: ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.1")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:103:1: ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:104:1: ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}'
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:104:1: ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:105:1: ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{'
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:105:1: ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:106:1: ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:106:1: ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:107:1: ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:107:1: ( (lv_optional= 'optional' )? 'keyword' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:108:1: (lv_optional= 'optional' )? 'keyword'
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:108:1: (lv_optional= 'optional' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:109:2: lv_optional= 'optional'
                    {
                    lv_optional=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleChild112); 
                    if (current==null) {
                    	current = factory.create("Child");}
                    	factory.set(current, "optional",lv_optional);
                    	associateNodeWithAstElement(currentNode, current);
                    createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0")
                    , currentNode, 
                    "optional");

                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleChild120); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1")
            , currentNode, 
            null);

            }

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:121:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:122:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChild131); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal")
            , currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("Child");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:132:1: (lv_number= RULE_INT )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:133:2: lv_number= RULE_INT
            {
            lv_number=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleChild146); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal")
            , currentNode, 
            "number");
            if (current==null) {
            	current = factory.create("Child");}
            	factory.set(current, "number",lv_number);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            match(input,14,FOLLOW_14_in_ruleChild155); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1")
            , currentNode, 
            null);

            }

            match(input,15,FOLLOW_15_in_ruleChild160); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.1")
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
    // $ANTLR end ruleChild


 

    public static final BitSet FOLLOW_ruleModel_in_parse43 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_ruleModel72 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleChild112 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleChild120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChild131 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleChild146 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleChild155 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleChild160 = new BitSet(new long[]{0x0000000000000002L});

}