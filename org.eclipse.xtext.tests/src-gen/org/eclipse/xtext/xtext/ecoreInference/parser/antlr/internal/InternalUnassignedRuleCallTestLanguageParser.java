package org.eclipse.xtext.xtext.ecoreInference.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
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
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=4;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalUnassignedRuleCallTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUnassignedRuleCallTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUnassignedRuleCallTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalUnassignedRuleCallTestLanguage.g"; }



     	private UnassignedRuleCallTestLanguageGrammarAccess grammarAccess;
     	
        public InternalUnassignedRuleCallTestLanguageParser(TokenStream input, UnassignedRuleCallTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // InternalUnassignedRuleCallTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalUnassignedRuleCallTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalUnassignedRuleCallTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalUnassignedRuleCallTestLanguage.g:76:1: ruleModel returns [EObject current=null] : (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_INT_1=null;
        EObject lv_modelFeatures_2_0 = null;


         enterRule(); 
            
        try {
            // InternalUnassignedRuleCallTestLanguage.g:79:28: ( (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) )
            // InternalUnassignedRuleCallTestLanguage.g:80:1: (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            {
            // InternalUnassignedRuleCallTestLanguage.g:80:1: (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            // InternalUnassignedRuleCallTestLanguage.g:80:3: otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0());
                
            // InternalUnassignedRuleCallTestLanguage.g:84:1: (this_INT_1= RULE_INT )+
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
            	    // InternalUnassignedRuleCallTestLanguage.g:84:2: this_INT_1= RULE_INT
            	    {
            	    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 
            	     
            	        newLeafNode(this_INT_1, grammarAccess.getModelAccess().getINTTerminalRuleCall_1()); 
            	        

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

            // InternalUnassignedRuleCallTestLanguage.g:88:3: ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            // InternalUnassignedRuleCallTestLanguage.g:89:1: (lv_modelFeatures_2_0= ruleModelFeatures )
            {
            // InternalUnassignedRuleCallTestLanguage.g:89:1: (lv_modelFeatures_2_0= ruleModelFeatures )
            // InternalUnassignedRuleCallTestLanguage.g:90:3: lv_modelFeatures_2_0= ruleModelFeatures
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getModelFeaturesModelFeaturesParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_modelFeatures_2_0=ruleModelFeatures();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"modelFeatures",
                    		lv_modelFeatures_2_0, 
                    		"org.eclipse.xtext.xtext.ecoreInference.UnassignedRuleCallTestLanguage.ModelFeatures");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
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
    // InternalUnassignedRuleCallTestLanguage.g:114:1: entryRuleModelFeatures returns [EObject current=null] : iv_ruleModelFeatures= ruleModelFeatures EOF ;
    public final EObject entryRuleModelFeatures() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelFeatures = null;


        try {
            // InternalUnassignedRuleCallTestLanguage.g:115:2: (iv_ruleModelFeatures= ruleModelFeatures EOF )
            // InternalUnassignedRuleCallTestLanguage.g:116:2: iv_ruleModelFeatures= ruleModelFeatures EOF
            {
             newCompositeNode(grammarAccess.getModelFeaturesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModelFeatures=ruleModelFeatures();

            state._fsp--;

             current =iv_ruleModelFeatures; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalUnassignedRuleCallTestLanguage.g:123:1: ruleModelFeatures returns [EObject current=null] : (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' ) ;
    public final EObject ruleModelFeatures() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalUnassignedRuleCallTestLanguage.g:126:28: ( (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' ) )
            // InternalUnassignedRuleCallTestLanguage.g:127:1: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' )
            {
            // InternalUnassignedRuleCallTestLanguage.g:127:1: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' )
            // InternalUnassignedRuleCallTestLanguage.g:127:3: otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getModelFeaturesAccess().getFeatureKeyword_0());
                
            // InternalUnassignedRuleCallTestLanguage.g:131:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalUnassignedRuleCallTestLanguage.g:132:1: (lv_name_1_0= RULE_ID )
            {
            // InternalUnassignedRuleCallTestLanguage.g:132:1: (lv_name_1_0= RULE_ID )
            // InternalUnassignedRuleCallTestLanguage.g:133:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            			newLeafNode(lv_name_1_0, grammarAccess.getModelFeaturesAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModelFeaturesRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getModelFeaturesAccess().getDataTypeRuleParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_6);
            ruleDataTypeRule();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getModelFeaturesAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
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
    // InternalUnassignedRuleCallTestLanguage.g:169:1: entryRuleDataTypeRule returns [String current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final String entryRuleDataTypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeRule = null;


        try {
            // InternalUnassignedRuleCallTestLanguage.g:170:2: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalUnassignedRuleCallTestLanguage.g:171:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypeRule=ruleDataTypeRule();

            state._fsp--;

             current =iv_ruleDataTypeRule.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalUnassignedRuleCallTestLanguage.g:178:1: ruleDataTypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;

         enterRule(); 
            
        try {
            // InternalUnassignedRuleCallTestLanguage.g:181:28: ( (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) )
            // InternalUnassignedRuleCallTestLanguage.g:182:1: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            {
            // InternalUnassignedRuleCallTestLanguage.g:182:1: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            // InternalUnassignedRuleCallTestLanguage.g:182:6: this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_7); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getDataTypeRuleAccess().getINTTerminalRuleCall_0()); 
                
            kw=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDataTypeRuleAccess().getKeywordKeyword_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_8); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDataTypeRuleAccess().getINTTerminalRuleCall_2()); 
                
            // InternalUnassignedRuleCallTestLanguage.g:202:1: (this_STRING_3= RULE_STRING )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalUnassignedRuleCallTestLanguage.g:202:6: this_STRING_3= RULE_STRING
                    {
                    this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    		current.merge(this_STRING_3);
                        
                     
                        newLeafNode(this_STRING_3, grammarAccess.getDataTypeRuleAccess().getSTRINGTerminalRuleCall_3()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000042L});
    }


}