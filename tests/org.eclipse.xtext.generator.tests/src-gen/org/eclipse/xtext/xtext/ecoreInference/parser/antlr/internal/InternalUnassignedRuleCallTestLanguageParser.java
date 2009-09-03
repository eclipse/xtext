package org.eclipse.xtext.xtext.ecoreInference.parser.antlr.internal; 

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
import org.eclipse.xtext.xtext.ecoreInference.services.UnassignedRuleCallTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalUnassignedRuleCallTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "'feature'", "';'", "'keyword'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalUnassignedRuleCallTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g"; }


     
     	private UnassignedRuleCallTestLanguageGrammarAccess grammarAccess;
     	
        public InternalUnassignedRuleCallTestLanguageParser(TokenStream input, IAstFactory factory, UnassignedRuleCallTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( 'model' ( RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_modelFeatures_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:85:6: ( ( 'model' ( RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:86:1: ( 'model' ( RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:86:1: ( 'model' ( RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:86:2: 'model' ( RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            {
            match(input,11,FOLLOW_11_in_ruleModel117); 

                    createLeafNode(grammarAccess.getModelAccess().getModelKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:90:1: ( RULE_INT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_INT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:90:2: RULE_INT
            	    {
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleModel127); 
            	     
            	        createLeafNode(grammarAccess.getModelAccess().getINTTerminalRuleCall_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:94:3: ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:95:1: (lv_modelFeatures_2_0= ruleModelFeatures )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:95:1: (lv_modelFeatures_2_0= ruleModelFeatures )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:96:3: lv_modelFeatures_2_0= ruleModelFeatures
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getModelFeaturesModelFeaturesParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleModelFeatures_in_ruleModel149);
            lv_modelFeatures_2_0=ruleModelFeatures();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"modelFeatures",
            	        		lv_modelFeatures_2_0, 
            	        		"ModelFeatures", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleModelFeatures
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:125:1: entryRuleModelFeatures returns [EObject current=null] : iv_ruleModelFeatures= ruleModelFeatures EOF ;
    public final EObject entryRuleModelFeatures() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelFeatures = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:125:55: (iv_ruleModelFeatures= ruleModelFeatures EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:126:2: iv_ruleModelFeatures= ruleModelFeatures EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelFeaturesRule(), currentNode); 
            pushFollow(FOLLOW_ruleModelFeatures_in_entryRuleModelFeatures182);
            iv_ruleModelFeatures=ruleModelFeatures();
            _fsp--;

             current =iv_ruleModelFeatures; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelFeatures192); 

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
    // $ANTLR end entryRuleModelFeatures


    // $ANTLR start ruleModelFeatures
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:133:1: ruleModelFeatures returns [EObject current=null] : ( 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule ';' ) ;
    public final EObject ruleModelFeatures() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:138:6: ( ( 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:139:1: ( 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:139:1: ( 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:139:2: 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule ';'
            {
            match(input,12,FOLLOW_12_in_ruleModelFeatures226); 

                    createLeafNode(grammarAccess.getModelFeaturesAccess().getFeatureKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:143:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:144:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:144:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:145:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelFeatures243); 

            			createLeafNode(grammarAccess.getModelFeaturesAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelFeaturesRule().getType().getClassifier());
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

            pushFollow(FOLLOW_ruleDataTypeRule_in_ruleModelFeatures257);
            ruleDataTypeRule();
            _fsp--;

            match(input,13,FOLLOW_13_in_ruleModelFeatures258); 

                    createLeafNode(grammarAccess.getModelFeaturesAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleModelFeatures


    // $ANTLR start entryRuleDataTypeRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:178:1: entryRuleDataTypeRule returns [String current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final String entryRuleDataTypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:178:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:179:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeRule_in_entryRuleDataTypeRule292);
            iv_ruleDataTypeRule=ruleDataTypeRule();
            _fsp--;

             current =iv_ruleDataTypeRule.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeRule303); 

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
    // $ANTLR end entryRuleDataTypeRule


    // $ANTLR start ruleDataTypeRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:186:1: ruleDataTypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:191:6: ( (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:192:1: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:192:1: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:192:6: this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )?
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDataTypeRule343); 

            		current.merge(this_INT_0);
                
             
                createLeafNode(grammarAccess.getDataTypeRuleAccess().getINTTerminalRuleCall_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleDataTypeRule361); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getDataTypeRuleAccess().getKeywordKeyword_1(), null); 
                
            this_INT_2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDataTypeRule376); 

            		current.merge(this_INT_2);
                
             
                createLeafNode(grammarAccess.getDataTypeRuleAccess().getINTTerminalRuleCall_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:212:1: (this_STRING_3= RULE_STRING )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:212:6: this_STRING_3= RULE_STRING
                    {
                    this_STRING_3=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDataTypeRule397); 

                    		current.merge(this_STRING_3);
                        
                     
                        createLeafNode(grammarAccess.getDataTypeRuleAccess().getSTRINGTerminalRuleCall_3(), null); 
                        

                    }
                    break;

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
    // $ANTLR end ruleDataTypeRule


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleModel127 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleModelFeatures_in_ruleModel149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelFeatures_in_entryRuleModelFeatures182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelFeatures192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleModelFeatures226 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelFeatures243 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDataTypeRule_in_ruleModelFeatures257 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleModelFeatures258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeRule_in_entryRuleDataTypeRule292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeRule303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDataTypeRule343 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleDataTypeRule361 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDataTypeRule376 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDataTypeRule397 = new BitSet(new long[]{0x0000000000000002L});

}