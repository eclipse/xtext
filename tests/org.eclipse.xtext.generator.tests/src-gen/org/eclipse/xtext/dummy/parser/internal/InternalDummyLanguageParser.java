// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g 2008-05-15 15:24:05

package org.eclipse.xtext.dummy.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDummyLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_ML_COMMENT", "RULE_INT", "RULE_SL_COMMENT", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'optional'", "'element'", "';'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=6;
    public static final int RULE_INT=8;
    public static final int EOF=-1;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_LEXER_BODY=10;

        public InternalDummyLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g"; }



    private IElementFactory factory;
    public InternalDummyLanguageParser(TokenStream input, IElementFactory factory) {
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
    // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:80:1: parse returns [EObject current] : ruleModel EOF ;
    public EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleModel1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:81:2: ( ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:81:2: ruleModel EOF
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
    // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:84:1: ruleModel returns [EObject current=null] : (lv_elements= ruleElement )* ;
    public EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements = null;


        try {
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:84:44: ( (lv_elements= ruleElement )* )
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:84:44: (lv_elements= ruleElement )*
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:86:1: (lv_elements= ruleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:87:2: lv_elements= ruleElement
            	    {
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel72);
            	    lv_elements=ruleElement();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("Model");}
            	    	factory.add(current, "elements",lv_elements);
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


    // $ANTLR start ruleElement
    // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:96:1: ruleElement returns [EObject current=null] : ( ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* ) ';' ) ;
    public EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_optional=null;
        Token lv_name=null;
        Token lv_descriptions=null;

        try {
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:96:46: ( ( ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* ) ';' ) )
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:96:46: ( ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* ) ';' )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:98:1: ( ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* ) ';' )
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:99:1: ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* ) ';'
            {
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:99:1: ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* )
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:100:1: ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )*
            {
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:100:1: ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:101:1: ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:101:1: ( (lv_optional= 'optional' )? 'element' )
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:102:1: (lv_optional= 'optional' )? 'element'
            {
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:102:1: (lv_optional= 'optional' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:103:2: lv_optional= 'optional'
                    {
                    lv_optional=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleElement110); 
                    if (current==null) {
                    	current = factory.create("Element");}
                    	factory.set(current, "optional",lv_optional);
                    	associateNodeWithAstElement(currentNode, current);
                    createLeafNode(null, currentNode, 
                    "optional");

                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleElement118); 
            createLeafNode(null, currentNode, 
            null);

            }

            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:113:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:114:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElement129); 
            createLeafNode(null, currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("Element");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }


            }

            // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:123:1: (lv_descriptions= RULE_STRING )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_STRING) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/dummy/parser/internal/InternalDummyLanguage.g:124:2: lv_descriptions= RULE_STRING
            	    {
            	    lv_descriptions=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElement144); 
            	    createLeafNode(null, currentNode, 
            	    "descriptions");
            	    if (current==null) {
            	    	current = factory.create("Element");}
            	    	factory.add(current, "descriptions",lv_descriptions);
            	    	associateNodeWithAstElement(currentNode, current);
            	    	

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            match(input,14,FOLLOW_14_in_ruleElement154); 
            createLeafNode(null, currentNode, 
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
    // $ANTLR end ruleElement


 

    public static final BitSet FOLLOW_ruleModel_in_parse43 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel72 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleElement110 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleElement118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElement129 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElement144 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_14_in_ruleElement154 = new BitSet(new long[]{0x0000000000000002L});

}