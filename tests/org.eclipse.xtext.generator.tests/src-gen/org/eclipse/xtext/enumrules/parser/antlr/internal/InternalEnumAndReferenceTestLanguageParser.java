package org.eclipse.xtext.enumrules.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.enumrules.services.EnumAndReferenceTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEnumAndReferenceTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'kindOfKeyword'", "'reference'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalEnumAndReferenceTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g"; }


     
     	private EnumAndReferenceTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEnumAndReferenceTestLanguageParser(TokenStream input, IAstFactory factory, EnumAndReferenceTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EntityWithEnumAndReference";	
       	} 



    // $ANTLR start entryRuleEntityWithEnumAndReference
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:70:1: entryRuleEntityWithEnumAndReference returns [EObject current=null] : iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF ;
    public final EObject entryRuleEntityWithEnumAndReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityWithEnumAndReference = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:70:68: (iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:71:2: iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntityWithEnumAndReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntityWithEnumAndReference_in_entryRuleEntityWithEnumAndReference71);
            iv_ruleEntityWithEnumAndReference=ruleEntityWithEnumAndReference();
            _fsp--;

             current =iv_ruleEntityWithEnumAndReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntityWithEnumAndReference81); 

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
    // $ANTLR end entryRuleEntityWithEnumAndReference


    // $ANTLR start ruleEntityWithEnumAndReference
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:78:1: ruleEntityWithEnumAndReference returns [EObject current=null] : ( 'kindOfKeyword' (lv_name_1= RULE_ID ) 'reference' ( RULE_ID ) ) ;
    public final EObject ruleEntityWithEnumAndReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:83:6: ( ( 'kindOfKeyword' (lv_name_1= RULE_ID ) 'reference' ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:84:1: ( 'kindOfKeyword' (lv_name_1= RULE_ID ) 'reference' ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:84:1: ( 'kindOfKeyword' (lv_name_1= RULE_ID ) 'reference' ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:84:2: 'kindOfKeyword' (lv_name_1= RULE_ID ) 'reference' ( RULE_ID )
            {
            match(input,11,FOLLOW_11_in_ruleEntityWithEnumAndReference115); 

                    createLeafNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getKindOfKeywordKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:88:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:90:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference137); 

            		createLeafNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntityWithEnumAndReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,12,FOLLOW_12_in_ruleEntityWithEnumAndReference154); 

                    createLeafNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getReferenceKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:112:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:115:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getEntityWithEnumAndReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference176); 

            		createLeafNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getRefEntityWithEnumAndReferenceCrossReference_3_0(), "ref"); 
            	

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
    // $ANTLR end ruleEntityWithEnumAndReference


 

    public static final BitSet FOLLOW_ruleEntityWithEnumAndReference_in_entryRuleEntityWithEnumAndReference71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntityWithEnumAndReference81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleEntityWithEnumAndReference115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference137 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleEntityWithEnumAndReference154 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference176 = new BitSet(new long[]{0x0000000000000002L});

}