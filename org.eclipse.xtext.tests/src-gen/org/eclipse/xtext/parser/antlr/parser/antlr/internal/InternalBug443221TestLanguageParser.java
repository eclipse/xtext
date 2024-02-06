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

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalBug443221TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'dummy'", "'_'", "'_dummy_'", "'__dummy__'", "'$__dummy__'", "'$'", "'DollarSign'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug443221TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug443221TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug443221TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug443221TestLanguage.g"; }



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
    // InternalBug443221TestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug443221TestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalBug443221TestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalBug443221TestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( () otherlv_1= 'dummy' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '_' otherlv_4= '_dummy_' otherlv_5= '__dummy__' otherlv_6= '$__dummy__' otherlv_7= '$' otherlv_8= 'DollarSign' ) ;
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
            // InternalBug443221TestLanguage.g:82:2: ( ( () otherlv_1= 'dummy' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '_' otherlv_4= '_dummy_' otherlv_5= '__dummy__' otherlv_6= '$__dummy__' otherlv_7= '$' otherlv_8= 'DollarSign' ) )
            // InternalBug443221TestLanguage.g:83:2: ( () otherlv_1= 'dummy' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '_' otherlv_4= '_dummy_' otherlv_5= '__dummy__' otherlv_6= '$__dummy__' otherlv_7= '$' otherlv_8= 'DollarSign' )
            {
            // InternalBug443221TestLanguage.g:83:2: ( () otherlv_1= 'dummy' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '_' otherlv_4= '_dummy_' otherlv_5= '__dummy__' otherlv_6= '$__dummy__' otherlv_7= '$' otherlv_8= 'DollarSign' )
            // InternalBug443221TestLanguage.g:84:3: () otherlv_1= 'dummy' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '_' otherlv_4= '_dummy_' otherlv_5= '__dummy__' otherlv_6= '$__dummy__' otherlv_7= '$' otherlv_8= 'DollarSign'
            {
            // InternalBug443221TestLanguage.g:84:3: ()
            // InternalBug443221TestLanguage.g:85:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getModelAccess().getModelAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getModelAccess().getDummyKeyword_1());
            		
            // InternalBug443221TestLanguage.g:95:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug443221TestLanguage.g:96:4: (lv_name_2_0= RULE_ID )
            {
            // InternalBug443221TestLanguage.g:96:4: (lv_name_2_0= RULE_ID )
            // InternalBug443221TestLanguage.g:97:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

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

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getModelAccess().get_Keyword_3());
            		
            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getModelAccess().get_dummy_Keyword_4());
            		
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getModelAccess().get__dummy__Keyword_5());
            		
            otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getModelAccess().get__dummy__Keyword_6());
            		
            otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_7, grammarAccess.getModelAccess().getDollarSignKeyword_7());
            		
            otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_2); 

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    }


}