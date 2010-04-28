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
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.dummy.services.DummyTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDummyTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'optional'", "'element'", "';'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalDummyTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g"; }



     	private DummyTestLanguageGrammarAccess grammarAccess;
     	
        public InternalDummyTestLanguageParser(TokenStream input, IAstFactory factory, DummyTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected DummyTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:91:6: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:92:1: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:92:1: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:93:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:93:1: (lv_elements_0_0= ruleElement )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:94:3: lv_elements_0_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleModel130);
            	    lv_elements_0_0=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_0_0, 
            	    	        		"Element", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:124:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:125:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:126:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement166);
            iv_ruleElement=ruleElement();
            _fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement176); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:133:1: ruleElement returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? 'element' ( (lv_name_2_0= RULE_ID ) ) ( (lv_descriptions_3_0= RULE_STRING ) )* ';' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token lv_name_2_0=null;
        Token lv_descriptions_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:138:6: ( ( ( (lv_optional_0_0= 'optional' ) )? 'element' ( (lv_name_2_0= RULE_ID ) ) ( (lv_descriptions_3_0= RULE_STRING ) )* ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:139:1: ( ( (lv_optional_0_0= 'optional' ) )? 'element' ( (lv_name_2_0= RULE_ID ) ) ( (lv_descriptions_3_0= RULE_STRING ) )* ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:139:1: ( ( (lv_optional_0_0= 'optional' ) )? 'element' ( (lv_name_2_0= RULE_ID ) ) ( (lv_descriptions_3_0= RULE_STRING ) )* ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:139:2: ( (lv_optional_0_0= 'optional' ) )? 'element' ( (lv_name_2_0= RULE_ID ) ) ( (lv_descriptions_3_0= RULE_STRING ) )* ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:139:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:140:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:140:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:141:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)input.LT(1);
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleElement219); 

                            createLeafNode(grammarAccess.getElementAccess().getOptionalOptionalKeyword_0_0(), "optional"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "optional", true, "optional", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,12,FollowSets000.FOLLOW_12_in_ruleElement243); 

                    createLeafNode(grammarAccess.getElementAccess().getElementKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:164:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:165:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:165:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:166:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement260); 

            			createLeafNode(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:188:2: ( (lv_descriptions_3_0= RULE_STRING ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_STRING) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:189:1: (lv_descriptions_3_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:189:1: (lv_descriptions_3_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:190:3: lv_descriptions_3_0= RULE_STRING
            	    {
            	    lv_descriptions_3_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleElement282); 

            	    			createLeafNode(grammarAccess.getElementAccess().getDescriptionsSTRINGTerminalRuleCall_3_0(), "descriptions"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"descriptions",
            	    	        		lv_descriptions_3_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,13,FollowSets000.FOLLOW_13_in_ruleElement298); 

                    createLeafNode(grammarAccess.getElementAccess().getSemicolonKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleModel130 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleElement219 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleElement243 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement260 = new BitSet(new long[]{0x0000000000002020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleElement282 = new BitSet(new long[]{0x0000000000002020L});
        public static final BitSet FOLLOW_13_in_ruleElement298 = new BitSet(new long[]{0x0000000000000002L});
    }


}