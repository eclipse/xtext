// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g 2008-05-15 08:40:58

package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.parsetree.*;
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

    private CompositeNode currentParserNode;

    	public CompositeNode createCompositeNode(EObject currentGrammarElement,
    			CompositeNode parentNode) {
    		CompositeNode compositeNode = ParsetreeFactory.eINSTANCE
    				.createCompositeNode();
    		compositeNode.setGrammarElement(currentGrammarElement);
    		parentNode.getChildren().add(compositeNode);
    		return compositeNode;
    	}

    	public Object createLeafNode(String text, EObject currentGrammarElement,
    			CompositeNode parentNode, String feature) {
    		LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
    		leafNode.setText(text);
    		leafNode.setGrammarElement(currentGrammarElement);
    		leafNode.setFeature(feature);
    		parentNode.getChildren().add(leafNode);
    		return leafNode;
    	}
    	
    	public void associateNodeWithAstElement(AbstractParserNode node, Object astElement) {
    		node.setElement(astElement);
    		if(astElement instanceof EObject) {
    			EObject eObject = (EObject) astElement;
    			ParserNodeAdapter adapter = (org.eclipse.xtext.parsetree.ParserNodeAdapter) 
    				org.eclipse.xtext.parsetree.ParserNodeAdapterFactory.INSTANCE.adapt(eObject, 
    					org.eclipse.xtext.parsetree.AbstractParserNode.class);
    			adapter.setParserNode(node); 
    		}
    	}




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:58:1: parse returns [Object current] : ruleFoo EOF ;
    public final Object parse() throws RecognitionException {
        Object current = null;

        Object ruleFoo1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:58:32: ( ruleFoo EOF )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:59:2: ruleFoo EOF
            {
             currentParserNode = ParsetreeFactory.eINSTANCE.createCompositeNode(); 
            pushFollow(FOLLOW_ruleFoo_in_parse46);
            ruleFoo1=ruleFoo();
            _fsp--;

            current =ruleFoo1;
            match(input,EOF,FOLLOW_EOF_in_parse50); 

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
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:63:1: ruleFoo returns [Object current=null] : (lv_name= RULE_ID ) ;
    public final Object ruleFoo() throws RecognitionException {
        Object current = null;

        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:63:39: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:63:41: (lv_name= RULE_ID )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:65:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:66:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFoo73); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "name");
            if (current==null) {
            	current = factory.create("Foo");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentParserNode, current);

            }

             currentParserNode = currentParserNode.getParent(); 

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


 

    public static final BitSet FOLLOW_ruleFoo_in_parse46 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFoo73 = new BitSet(new long[]{0x0000000000000002L});

}