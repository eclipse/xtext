// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g 2008-05-16 10:06:34

package org.eclipse.xtext.metamodelreferencing.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalMetamodelRefTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_LEXER_BODY", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=7;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_LEXER_BODY=10;

        public InternalMetamodelRefTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g"; }



    private IElementFactory factory;
    public InternalMetamodelRefTestParser(TokenStream input, IElementFactory factory) {
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

    private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestConstants.getMetamodelRefTestGrammar();



    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:83:1: parse returns [EObject current] : ruleFoo EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleFoo1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:83:33: ( ruleFoo EOF )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:84:2: ruleFoo EOF
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
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:87:1: ruleFoo returns [EObject current=null] : ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_nameRefs = null;


        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:87:40: ( ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* ) )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:87:42: ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.0")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:90:1: ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:91:1: (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )*
            {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:91:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:92:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFoo74); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@terminal")
            , currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("Foo");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);
            	

            }

            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:102:1: (lv_nameRefs= ruleNameRef )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:103:2: lv_nameRefs= ruleNameRef
            	    {
            	    pushFollow(FOLLOW_ruleNameRef_in_ruleFoo88);
            	    lv_nameRefs=ruleNameRef();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("Foo");}
            	    	factory.add(current, "nameRefs",lv_nameRefs);
            	    	associateNodeWithAstElement(currentNode, current);
            	    	

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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


    // $ANTLR start ruleNameRef
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:112:1: ruleNameRef returns [EObject current=null] : (lv_name= RULE_STRING ) ;
    public final EObject ruleNameRef() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:112:44: ( (lv_name= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:112:46: (lv_name= RULE_STRING )
            {
            EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.1")
            , currentNode); 
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:115:1: (lv_name= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:116:2: lv_name= RULE_STRING
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNameRef119); 
            createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@terminal")
            , currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("xtext::RuleCall");}
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
    // $ANTLR end ruleNameRef


 

    public static final BitSet FOLLOW_ruleFoo_in_parse43 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFoo74 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleNameRef_in_ruleFoo88 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNameRef119 = new BitSet(new long[]{0x0000000000000002L});

}