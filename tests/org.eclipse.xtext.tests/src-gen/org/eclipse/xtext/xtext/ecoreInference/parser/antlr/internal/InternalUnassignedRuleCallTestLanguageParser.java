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

@SuppressWarnings("all")
public class InternalUnassignedRuleCallTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "'feature'", "';'", "'keyword'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=4;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalUnassignedRuleCallTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUnassignedRuleCallTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUnassignedRuleCallTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g"; }



     	private UnassignedRuleCallTestLanguageGrammarAccess grammarAccess;
     	
        public InternalUnassignedRuleCallTestLanguageParser(TokenStream input, IAstFactory factory, UnassignedRuleCallTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected UnassignedRuleCallTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:80:1: ruleModel returns [EObject current=null] : (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_INT_1=null;
        EObject lv_modelFeatures_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:85:6: ( (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:86:1: (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:86:1: (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:86:3: otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel122); 

                	createLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:90:1: (this_INT_1= RULE_INT )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:90:2: this_INT_1= RULE_INT
            	    {
            	    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleModel134); 
            	     
            	        createLeafNode(this_INT_1, grammarAccess.getModelAccess().getINTTerminalRuleCall_1(), null); 
            	        

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:94:3: ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:95:1: (lv_modelFeatures_2_0= ruleModelFeatures )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:95:1: (lv_modelFeatures_2_0= ruleModelFeatures )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:96:3: lv_modelFeatures_2_0= ruleModelFeatures
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getModelFeaturesModelFeaturesParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleModelFeatures_in_ruleModel156);
            lv_modelFeatures_2_0=ruleModelFeatures();

            state._fsp--;


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModelFeatures"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:126:1: entryRuleModelFeatures returns [EObject current=null] : iv_ruleModelFeatures= ruleModelFeatures EOF ;
    public final EObject entryRuleModelFeatures() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelFeatures = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:127:2: (iv_ruleModelFeatures= ruleModelFeatures EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:128:2: iv_ruleModelFeatures= ruleModelFeatures EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelFeaturesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModelFeatures_in_entryRuleModelFeatures192);
            iv_ruleModelFeatures=ruleModelFeatures();

            state._fsp--;

             current =iv_ruleModelFeatures; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelFeatures202); 

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
    // $ANTLR end "entryRuleModelFeatures"


    // $ANTLR start "ruleModelFeatures"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:135:1: ruleModelFeatures returns [EObject current=null] : (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' ) ;
    public final EObject ruleModelFeatures() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:140:6: ( (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:141:1: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:141:1: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:141:3: otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModelFeatures239); 

                	createLeafNode(otherlv_0, grammarAccess.getModelFeaturesAccess().getFeatureKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:145:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:146:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:146:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:147:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelFeatures256); 

            			createLeafNode(lv_name_1_0, grammarAccess.getModelFeaturesAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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

             
                    currentNode=createCompositeNode(grammarAccess.getModelFeaturesAccess().getDataTypeRuleParserRuleCall_2(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeRule_in_ruleModelFeatures277);
            ruleDataTypeRule();

            state._fsp--;

             
                    currentNode = currentNode.getParent();
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModelFeatures288); 

                	createLeafNode(otherlv_3, grammarAccess.getModelFeaturesAccess().getSemicolonKeyword_3(), null);
                

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
    // $ANTLR end "ruleModelFeatures"


    // $ANTLR start "entryRuleDataTypeRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:189:1: entryRuleDataTypeRule returns [String current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final String entryRuleDataTypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:190:2: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:191:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeRule_in_entryRuleDataTypeRule325);
            iv_ruleDataTypeRule=ruleDataTypeRule();

            state._fsp--;

             current =iv_ruleDataTypeRule.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypeRule336); 

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
    // $ANTLR end "entryRuleDataTypeRule"


    // $ANTLR start "ruleDataTypeRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:198:1: ruleDataTypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:203:6: ( (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:204:1: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:204:1: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:204:6: this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDataTypeRule376); 

            		current.merge(this_INT_0);
                
             
                createLeafNode(this_INT_0, grammarAccess.getDataTypeRuleAccess().getINTTerminalRuleCall_0(), null); 
                
            kw=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDataTypeRule394); 

                    current.merge(kw);
                    createLeafNode(kw, grammarAccess.getDataTypeRuleAccess().getKeywordKeyword_1(), null); 
                
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDataTypeRule409); 

            		current.merge(this_INT_2);
                
             
                createLeafNode(this_INT_2, grammarAccess.getDataTypeRuleAccess().getINTTerminalRuleCall_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:224:1: (this_STRING_3= RULE_STRING )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/parser/antlr/internal/InternalUnassignedRuleCallTestLanguage.g:224:6: this_STRING_3= RULE_STRING
                    {
                    this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleDataTypeRule430); 

                    		current.merge(this_STRING_3);
                        
                     
                        createLeafNode(this_STRING_3, grammarAccess.getDataTypeRuleAccess().getSTRINGTerminalRuleCall_3(), null); 
                        

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
    // $ANTLR end "ruleDataTypeRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleModel134 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleModelFeatures_in_ruleModel156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelFeatures_in_entryRuleModelFeatures192 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelFeatures202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModelFeatures239 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelFeatures256 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDataTypeRule_in_ruleModelFeatures277 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleModelFeatures288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypeRule_in_entryRuleDataTypeRule325 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeRule336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDataTypeRule376 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleDataTypeRule394 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDataTypeRule409 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleDataTypeRule430 = new BitSet(new long[]{0x0000000000000002L});
    }


}