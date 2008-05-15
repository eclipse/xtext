// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g 2008-05-15 14:11:04

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_LEXER_BODY", "RULE_WS", "RULE_ML_COMMENT", "RULE_INT", "RULE_SL_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=7;
    public static final int RULE_INT=9;
    public static final int EOF=-1;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_LEXER_BODY=6;

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
    	parentNode.getChildren().add(compositeNode);
    	return compositeNode;
    }

    	public Object createLeafNode(EObject currentGrammarElement,
    		CompositeNode parentNode, String feature) {
    		Token token = input.LT(-1);
    		Token tokenBefore = input.LT(-2);
    		int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : 0;
    		if (indexOfTokenBefore+1<token.getTokenIndex()) {
    			for (int x = token.getTokenIndex()-1; x>indexOfTokenBefore;x--) {
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
    	
    public void associateNodeWithAstElement(AbstractNode node, Object astElement) {
    	node.setElement(astElement);
    	if(astElement instanceof EObject) {
    		EObject eObject = (EObject) astElement;
    		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
    		adapter.setParserNode(node); 
    	}
    }
    	
    private CompositeNode currentNode;
    private CompositeNode rootNode;

    public CompositeNode getRootNode() {
    	return rootNode;
    }




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:72:1: parse returns [EObject current] : ruleFoo EOF ;
    public EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleFoo1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:73:2: ( ruleFoo EOF )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:73:2: ruleFoo EOF
            {
             rootNode = ParsetreeFactory.eINSTANCE.createCompositeNode(); 
            	currentNode = rootNode; 
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
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:78:1: ruleFoo returns [EObject current=null] : ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* ) ;
    public EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_nameRefs = null;


        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:78:42: ( ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* ) )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:78:42: ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:80:1: ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:81:1: (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )*
            {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:81:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:82:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFoo75); 
            createLeafNode(null, currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("Foo");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);

            }

            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:90:1: (lv_nameRefs= ruleNameRef )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:91:2: lv_nameRefs= ruleNameRef
            	    {
            	    pushFollow(FOLLOW_ruleNameRef_in_ruleFoo89);
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
    // $ANTLR end ruleFoo


    // $ANTLR start ruleNameRef
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:99:1: ruleNameRef returns [EObject current=null] : (lv_name= RULE_STRING ) ;
    public EObject ruleNameRef() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:99:46: ( (lv_name= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:99:46: (lv_name= RULE_STRING )
            {
            EObject temp=null; currentNode=createCompositeNode(null, currentNode); 
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:101:1: (lv_name= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:102:2: lv_name= RULE_STRING
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNameRef120); 
            createLeafNode(null, currentNode, 
            "name");
            if (current==null) {
            	current = factory.create("xtext::RuleCall");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentNode, current);

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
    // $ANTLR end ruleNameRef


 

    public static final BitSet FOLLOW_ruleFoo_in_parse46 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFoo75 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleNameRef_in_ruleFoo89 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNameRef120 = new BitSet(new long[]{0x0000000000000002L});

}