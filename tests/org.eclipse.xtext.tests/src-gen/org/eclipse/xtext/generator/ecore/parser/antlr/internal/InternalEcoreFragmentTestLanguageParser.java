package org.eclipse.xtext.generator.ecore.parser.antlr.internal; 

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
import org.eclipse.xtext.generator.ecore.services.EcoreFragmentTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEcoreFragmentTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'first'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalEcoreFragmentTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g"; }



     	private EcoreFragmentTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEcoreFragmentTestLanguageParser(TokenStream input, IAstFactory factory, EcoreFragmentTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Second";	
       	}
       	
       	@Override
       	protected EcoreFragmentTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleSecond
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:77:1: entryRuleSecond returns [EObject current=null] : iv_ruleSecond= ruleSecond EOF ;
    public final EObject entryRuleSecond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecond = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:78:2: (iv_ruleSecond= ruleSecond EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:79:2: iv_ruleSecond= ruleSecond EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSecondRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSecond_in_entryRuleSecond75);
            iv_ruleSecond=ruleSecond();
            _fsp--;

             current =iv_ruleSecond; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecond85); 

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
    // $ANTLR end entryRuleSecond


    // $ANTLR start ruleSecond
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:86:1: ruleSecond returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) 'first' ( ( RULE_ID ) ) ) ;
    public final EObject ruleSecond() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:91:6: ( ( ( (lv_name_0_0= RULE_ID ) ) 'first' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:92:1: ( ( (lv_name_0_0= RULE_ID ) ) 'first' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:92:1: ( ( (lv_name_0_0= RULE_ID ) ) 'first' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:92:2: ( (lv_name_0_0= RULE_ID ) ) 'first' ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:92:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:93:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:93:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:94:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSecond127); 

            			createLeafNode(grammarAccess.getSecondAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSecondRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,11,FollowSets000.FOLLOW_11_in_ruleSecond142); 

                    createLeafNode(grammarAccess.getSecondAccess().getFirstKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:120:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:121:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:121:1: ( RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalEcoreFragmentTestLanguage.g:122:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSecondRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSecond160); 

            		createLeafNode(grammarAccess.getSecondAccess().getFirstFirstCrossReference_2_0(), "first"); 
            	

            }


            }


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
    // $ANTLR end ruleSecond


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSecond_in_entryRuleSecond75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecond85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSecond127 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleSecond142 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSecond160 = new BitSet(new long[]{0x0000000000000002L});
    }


}