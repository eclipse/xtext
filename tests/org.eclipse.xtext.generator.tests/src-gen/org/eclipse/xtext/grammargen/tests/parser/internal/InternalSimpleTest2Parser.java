// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g 2008-05-15 13:37:14

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

    private CompositeNode currentNode;

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
    	
    	public void associateNodeWithAstElement(AbstractNode node, Object astElement) {
    		node.setElement(astElement);
    		if(astElement instanceof EObject) {
    			EObject eObject = (EObject) astElement;
    			NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
    			adapter.setParserNode(node); 
    		}
    	}




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:56:1: parse returns [Object current] : ruleModel EOF ;
    public final Object parse() throws RecognitionException {
        Object current = null;

        Object ruleModel1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:56:32: ( ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:57:2: ruleModel EOF
            {
             currentNode = ParsetreeFactory.eINSTANCE.createCompositeNode(); 
            pushFollow(FOLLOW_ruleModel_in_parse46);
            ruleModel1=ruleModel();
            _fsp--;

            current =ruleModel1;
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


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:61:1: ruleModel returns [Object current=null] : (lv_contents= ruleChild )* ;
    public final Object ruleModel() throws RecognitionException {
        Object current = null;

        Object lv_contents = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:61:41: ( (lv_contents= ruleChild )* )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:61:43: (lv_contents= ruleChild )*
            {
            Object temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:63:1: (lv_contents= ruleChild )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:64:2: lv_contents= ruleChild
            	    {
            	    pushFollow(FOLLOW_ruleChild_in_ruleModel73);
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

             currentNode = currentNode.getParent(); 

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
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:72:1: ruleChild returns [Object current=null] : ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' ) ;
    public final Object ruleChild() throws RecognitionException {
        Object current = null;

        Token lv_optional=null;
        Token lv_name=null;
        Token lv_number=null;

        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:72:41: ( ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:72:43: ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' )
            {
            Object temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:74:1: ( ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:75:1: ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' ) '}'
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:75:1: ( ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:76:1: ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) ) '{'
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:76:1: ( ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:77:1: ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) ) (lv_number= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:77:1: ( ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:78:1: ( (lv_optional= 'optional' )? 'keyword' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:78:1: ( (lv_optional= 'optional' )? 'keyword' )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:79:1: (lv_optional= 'optional' )? 'keyword'
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:79:1: (lv_optional= 'optional' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:80:2: lv_optional= 'optional'
                    {
                    lv_optional=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleChild113); 
                    createLeafNode(input.LT(-1).getText(), null, currentNode, 
                    null);
                    if (current==null) {
                    	current = factory.create("Child");}
                    	factory.set(current, "optional",lv_optional);
                    	associateNodeWithAstElement(currentNode, current);

                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleChild122); 
            createLeafNode(input.LT(-1).getText(), null, currentNode, 
            null);

            }

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:89:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:90:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChild133); 
            createLeafNode(input.LT(-1).getText(), null, currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("Child");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);

            }


            }

            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:98:1: (lv_number= RULE_INT )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest2.g:99:2: lv_number= RULE_INT
            {
            lv_number=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleChild148); 
            createLeafNode(input.LT(-1).getText(), null, currentNode, 
            "number");
            if (current==null) {
            	current = factory.create("Child");}
            	factory.set(current, "number",lv_number);
            	associateNodeWithAstElement(currentNode, current);

            }


            }

            match(input,14,FOLLOW_14_in_ruleChild157); 
            createLeafNode(input.LT(-1).getText(), null, currentNode, 
            null);

            }

            match(input,15,FOLLOW_15_in_ruleChild162); 
            createLeafNode(input.LT(-1).getText(), null, currentNode, 
            null);

            }

             currentNode = currentNode.getParent(); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_parse46 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_ruleModel73 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleChild113 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleChild122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChild133 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleChild148 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleChild157 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleChild162 = new BitSet(new long[]{0x0000000000000002L});

}