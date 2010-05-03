package org.eclipse.xtext.ui.tests.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.services.FoldingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFoldingTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'", "'end'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalFoldingTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g"; }



     	private FoldingTestLanguageGrammarAccess grammarAccess;
     	
        public InternalFoldingTestLanguageParser(TokenStream input, IAstFactory factory, FoldingTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "FoldingModel";	
       	}
       	
       	@Override
       	protected FoldingTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleFoldingModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:77:1: entryRuleFoldingModel returns [EObject current=null] : iv_ruleFoldingModel= ruleFoldingModel EOF ;
    public final EObject entryRuleFoldingModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoldingModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:78:2: (iv_ruleFoldingModel= ruleFoldingModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:79:2: iv_ruleFoldingModel= ruleFoldingModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFoldingModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFoldingModel_in_entryRuleFoldingModel75);
            iv_ruleFoldingModel=ruleFoldingModel();
            _fsp--;

             current =iv_ruleFoldingModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoldingModel85); 

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
    // $ANTLR end entryRuleFoldingModel


    // $ANTLR start ruleFoldingModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:86:1: ruleFoldingModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleFoldingModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:91:6: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:92:1: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:92:1: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:93:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:93:1: (lv_elements_0_0= ruleElement )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:94:3: lv_elements_0_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFoldingModelAccess().getElementsElementParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleFoldingModel130);
            	    lv_elements_0_0=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFoldingModelRule().getType().getClassifier());
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
    // $ANTLR end ruleFoldingModel


    // $ANTLR start entryRuleElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:124:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:125:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:126:2: iv_ruleElement= ruleElement EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:133:1: ruleElement returns [EObject current=null] : ( 'element' ( (lv_name_1_0= RULE_ID ) ) ( (lv_subelements_2_0= ruleElement ) )* 'end' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_subelements_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:138:6: ( ( 'element' ( (lv_name_1_0= RULE_ID ) ) ( (lv_subelements_2_0= ruleElement ) )* 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:139:1: ( 'element' ( (lv_name_1_0= RULE_ID ) ) ( (lv_subelements_2_0= ruleElement ) )* 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:139:1: ( 'element' ( (lv_name_1_0= RULE_ID ) ) ( (lv_subelements_2_0= ruleElement ) )* 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:139:3: 'element' ( (lv_name_1_0= RULE_ID ) ) ( (lv_subelements_2_0= ruleElement ) )* 'end'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleElement211); 

                    createLeafNode(grammarAccess.getElementAccess().getElementKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:143:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:144:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:144:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:145:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement228); 

            			createLeafNode(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:167:2: ( (lv_subelements_2_0= ruleElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:168:1: (lv_subelements_2_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:168:1: (lv_subelements_2_0= ruleElement )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalFoldingTestLanguage.g:169:3: lv_subelements_2_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getSubelementsElementParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleElement254);
            	    lv_subelements_2_0=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"subelements",
            	    	        		lv_subelements_2_0, 
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
            	    break loop2;
                }
            } while (true);

            match(input,12,FollowSets000.FOLLOW_12_in_ruleElement265); 

                    createLeafNode(grammarAccess.getElementAccess().getEndKeyword_3(), null); 
                

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
        public static final BitSet FOLLOW_ruleFoldingModel_in_entryRuleFoldingModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoldingModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleFoldingModel130 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleElement211 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement228 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_ruleElement_in_ruleElement254 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_12_in_ruleElement265 = new BitSet(new long[]{0x0000000000000002L});
    }


}