// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g 2008-05-15 14:54:05

package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_LEXER_BODY", "RULE_WS", "RULE_ML_COMMENT", "RULE_STRING", "RULE_SL_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=7;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=9;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_LEXER_BODY=6;

        public InternalSimpleTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g"; }



    private IElementFactory factory;
    public InternalSimpleTestParser(TokenStream input, IElementFactory factory) {
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
    	
    public void associateNodeWithAstElement(AbstractNode node, EObject astElement) {
    	node.setElement(astElement);
    	if(astElement instanceof EObject) {
    		EObject eObject = (EObject) astElement;
    		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
    		adapter.setParserNode(node); 
    	}
    }
    	
    private CompositeNode currentNode;




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:80:1: parse returns [EObject current] : ruleFoo EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleFoo1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:80:33: ( ruleFoo EOF )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:81:2: ruleFoo EOF
            {
            pushFollow(FOLLOW_ruleFoo_in_parse43);
            ruleFoo1=ruleFoo();
            _fsp--;

            current =ruleFoo1;
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


    // $ANTLR start ruleFoo
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:84:1: ruleFoo returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:84:40: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:84:42: (lv_name= RULE_ID )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:86:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:87:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFoo72); 
            createLeafNode(null, currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("Foo");}
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
    // $ANTLR end ruleFoo


 

    public static final BitSet FOLLOW_ruleFoo_in_parse43 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFoo72 = new BitSet(new long[]{0x0000000000000002L});

}