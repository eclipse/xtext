// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g 2008-05-15 08:41:01

package org.eclipse.xtext.metamodelreferencing.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.EObject;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalMetamodelRefTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_LEXER_BODY", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=6;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_INT=9;
    public static final int EOF=-1;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=7;
    public static final int RULE_LEXER_BODY=8;

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
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:58:1: parse returns [Object current] : ruleFoo EOF ;
    public final Object parse() throws RecognitionException {
        Object current = null;

        Object ruleFoo1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:58:32: ( ruleFoo EOF )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:59:2: ruleFoo EOF
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
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:63:1: ruleFoo returns [Object current=null] : ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* ) ;
    public final Object ruleFoo() throws RecognitionException {
        Object current = null;

        Token lv_name=null;
        Object lv_nameRefs = null;


        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:63:39: ( ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* ) )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:63:41: ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:65:1: ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:66:1: (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )*
            {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:66:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:67:2: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFoo75); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "name");
            if (current==null) {
            	current = factory.create("Foo");}
            	factory.set(current, "name",lv_name);
            	associateNodeWithAstElement(currentParserNode, current);

            }

            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:75:1: (lv_nameRefs= ruleNameRef )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:76:2: lv_nameRefs= ruleNameRef
            	    {
            	    pushFollow(FOLLOW_ruleNameRef_in_ruleFoo89);
            	    lv_nameRefs=ruleNameRef();
            	    _fsp--;

            	    if (current==null) {
            	    	current = factory.create("Foo");}
            	    	factory.add(current, "nameRefs",lv_nameRefs);
            	    	associateNodeWithAstElement(currentParserNode, current);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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


    // $ANTLR start ruleNameRef
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:84:1: ruleNameRef returns [Object current=null] : (lv_name= RULE_STRING ) ;
    public final Object ruleNameRef() throws RecognitionException {
        Object current = null;

        Token lv_name=null;

        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:84:43: ( (lv_name= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:84:45: (lv_name= RULE_STRING )
            {
            Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); 
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:86:1: (lv_name= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.g:87:2: lv_name= RULE_STRING
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNameRef120); 
            createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
            "name");
            if (current==null) {
            	current = factory.create("xtext::RuleCall");}
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
    // $ANTLR end ruleNameRef


 

    public static final BitSet FOLLOW_ruleFoo_in_parse46 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFoo75 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleNameRef_in_ruleFoo89 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNameRef120 = new BitSet(new long[]{0x0000000000000002L});

}