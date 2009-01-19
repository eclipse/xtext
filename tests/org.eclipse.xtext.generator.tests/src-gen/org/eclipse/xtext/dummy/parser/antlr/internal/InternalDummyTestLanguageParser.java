// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g 2009-01-19 15:13:52

package org.eclipse.xtext.dummy.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDummyTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'optional'", "'element'", "';'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalDummyTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g"; }


     
        public InternalDummyTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalDummyTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:67:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:68:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/dummy/DummyTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel72);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel82); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:75:1: ruleModel returns [EObject current=null] : (lv_elements= ruleElement )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:77:33: ( (lv_elements= ruleElement )* )
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:78:1: (lv_elements= ruleElement )*
            {
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:78:1: (lv_elements= ruleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:81:6: lv_elements= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/dummy/DummyTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel140);
            	    lv_elements=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Model");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "elements", lv_elements, "Element", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleElement
    // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:108:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:108:49: (iv_ruleElement= ruleElement EOF )
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:109:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/dummy/DummyTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement179);
            iv_ruleElement=ruleElement();
            _fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement189); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleElement


    // $ANTLR start ruleElement
    // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:116:1: ruleElement returns [EObject current=null] : ( ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* ) ';' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_optional=null;
        Token lv_name=null;
        Token lv_descriptions=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:118:33: ( ( ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* ) ';' ) )
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:1: ( ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:1: ( ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* ) ';' )
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:2: ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* ) ';'
            {
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:2: ( ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )* )
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:3: ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) ) (lv_descriptions= RULE_STRING )*
            {
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:3: ( ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:4: ( (lv_optional= 'optional' )? 'element' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:4: ( (lv_optional= 'optional' )? 'element' )
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:5: (lv_optional= 'optional' )? 'element'
            {
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:5: (lv_optional= 'optional' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:121:6: lv_optional= 'optional'
                    {
                    lv_optional=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleElement238); 

                            createLeafNode("classpath:/org/eclipse/xtext/dummy/DummyTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "optional"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Element");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "optional", true, "optional", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleElement260); 

                    createLeafNode("classpath:/org/eclipse/xtext/dummy/DummyTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:143:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:145:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElement282); 
             
                createLeafNode("classpath:/org/eclipse/xtext/dummy/DummyTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Element");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:163:3: (lv_descriptions= RULE_STRING )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_STRING) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:165:6: lv_descriptions= RULE_STRING
            	    {
            	    lv_descriptions=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElement315); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/dummy/DummyTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "descriptions"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("Element");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "descriptions", lv_descriptions, "STRING", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            match(input,13,FOLLOW_13_in_ruleElement337); 

                    createLeafNode("classpath:/org/eclipse/xtext/dummy/DummyTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleElement


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel140 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleElement238 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleElement260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElement282 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElement315 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_13_in_ruleElement337 = new BitSet(new long[]{0x0000000000000002L});

}