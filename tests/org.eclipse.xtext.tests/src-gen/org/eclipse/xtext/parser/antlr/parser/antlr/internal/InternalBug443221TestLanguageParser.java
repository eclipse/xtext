package org.eclipse.xtext.parser.antlr.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.services.Bug443221TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug443221TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KW___dummy___1", "DollarSign_1", "KW___dummy__", "KW__dummy_", "Dummy", "DollarSign", "KW__", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=11;
    public static final int RULE_STRING=13;
    public static final int DollarSign=9;
    public static final int KW__dummy_=7;
    public static final int DollarSign_1=5;
    public static final int RULE_ANY_OTHER=17;
    public static final int Dummy=8;
    public static final int KW__=10;
    public static final int RULE_INT=12;
    public static final int RULE_WS=16;
    public static final int KW___dummy___1=4;
    public static final int RULE_SL_COMMENT=15;
    public static final int EOF=-1;
    public static final int KW___dummy__=6;
    public static final int RULE_ML_COMMENT=14;

    // delegates
    // delegators


        public InternalBug443221TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug443221TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug443221TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g"; }




    	private Bug443221TestLanguageGrammarAccess grammarAccess;
    	 	
    	public InternalBug443221TestLanguageParser(TokenStream input, Bug443221TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Model";	
    	} 
    	   	   	
    	@Override
    	protected Bug443221TestLanguageGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:61:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:62:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:63:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel67);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel77); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:70:1: ruleModel returns [EObject current=null] : ( () otherlv_1= Dummy ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KW__ otherlv_4= KW__dummy_ otherlv_5= KW___dummy__ otherlv_6= KW___dummy___1 otherlv_7= DollarSign otherlv_8= DollarSign_1 ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:73:28: ( ( () otherlv_1= Dummy ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KW__ otherlv_4= KW__dummy_ otherlv_5= KW___dummy__ otherlv_6= KW___dummy___1 otherlv_7= DollarSign otherlv_8= DollarSign_1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:74:1: ( () otherlv_1= Dummy ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KW__ otherlv_4= KW__dummy_ otherlv_5= KW___dummy__ otherlv_6= KW___dummy___1 otherlv_7= DollarSign otherlv_8= DollarSign_1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:74:1: ( () otherlv_1= Dummy ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KW__ otherlv_4= KW__dummy_ otherlv_5= KW___dummy__ otherlv_6= KW___dummy___1 otherlv_7= DollarSign otherlv_8= DollarSign_1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:74:2: () otherlv_1= Dummy ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KW__ otherlv_4= KW__dummy_ otherlv_5= KW___dummy__ otherlv_6= KW___dummy___1 otherlv_7= DollarSign otherlv_8= DollarSign_1
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:74:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:75:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Dummy,FollowSets000.FOLLOW_Dummy_in_ruleModel124); 

                	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getDummyKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:85:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:86:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:86:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug443221TestLanguageParser.g:87:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel140); 

            			newLeafNode(lv_name_2_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModelRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,KW__,FollowSets000.FOLLOW_KW___in_ruleModel158); 

                	newLeafNode(otherlv_3, grammarAccess.getModelAccess().get_Keyword_3());
                
            otherlv_4=(Token)match(input,KW__dummy_,FollowSets000.FOLLOW_KW__dummy__in_ruleModel170); 

                	newLeafNode(otherlv_4, grammarAccess.getModelAccess().get_dummy_Keyword_4());
                
            otherlv_5=(Token)match(input,KW___dummy__,FollowSets000.FOLLOW_KW___dummy___in_ruleModel182); 

                	newLeafNode(otherlv_5, grammarAccess.getModelAccess().get__dummy__Keyword_5());
                
            otherlv_6=(Token)match(input,KW___dummy___1,FollowSets000.FOLLOW_KW___dummy___1_in_ruleModel194); 

                	newLeafNode(otherlv_6, grammarAccess.getModelAccess().get__dummy__Keyword_6());
                
            otherlv_7=(Token)match(input,DollarSign,FollowSets000.FOLLOW_DollarSign_in_ruleModel206); 

                	newLeafNode(otherlv_7, grammarAccess.getModelAccess().getDollarSignKeyword_7());
                
            otherlv_8=(Token)match(input,DollarSign_1,FollowSets000.FOLLOW_DollarSign_1_in_ruleModel218); 

                	newLeafNode(otherlv_8, grammarAccess.getModelAccess().getDollarSignKeyword_8());
                

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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel77 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_Dummy_in_ruleModel124 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel140 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_KW___in_ruleModel158 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_KW__dummy__in_ruleModel170 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_KW___dummy___in_ruleModel182 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_KW___dummy___1_in_ruleModel194 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_DollarSign_in_ruleModel206 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_DollarSign_1_in_ruleModel218 = new BitSet(new long[]{0x0000000000000002L});
    }


}