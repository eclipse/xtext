package org.eclipse.xtext.testlanguages.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyTestLanguageGrammarAccess;



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
public class InternalOptionalEmptyTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'hallo'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalOptionalEmptyTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOptionalEmptyTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOptionalEmptyTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOptionalEmptyTestLanguage.g"; }



     	private OptionalEmptyTestLanguageGrammarAccess grammarAccess;

        public InternalOptionalEmptyTestLanguageParser(TokenStream input, OptionalEmptyTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected OptionalEmptyTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalOptionalEmptyTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalOptionalEmptyTestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalOptionalEmptyTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalOptionalEmptyTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_child_0_0= ruleGreeting ) )? ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_child_0_0 = null;



        	enterRule();

        try {
            // InternalOptionalEmptyTestLanguage.g:82:2: ( ( (lv_child_0_0= ruleGreeting ) )? )
            // InternalOptionalEmptyTestLanguage.g:83:2: ( (lv_child_0_0= ruleGreeting ) )?
            {
            // InternalOptionalEmptyTestLanguage.g:83:2: ( (lv_child_0_0= ruleGreeting ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalOptionalEmptyTestLanguage.g:84:3: (lv_child_0_0= ruleGreeting )
                    {
                    // InternalOptionalEmptyTestLanguage.g:84:3: (lv_child_0_0= ruleGreeting )
                    // InternalOptionalEmptyTestLanguage.g:85:4: lv_child_0_0= ruleGreeting
                    {

                    				newCompositeNode(grammarAccess.getModelAccess().getChildGreetingParserRuleCall_0());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_0_0=ruleGreeting();

                    state._fsp--;


                    				if (current==null) {
                    					current = createModelElementForParent(grammarAccess.getModelRule());
                    				}
                    				set(
                    					current,
                    					"child",
                    					lv_child_0_0,
                    					"org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguage.Greeting");
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;

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


    // $ANTLR start "entryRuleGreeting"
    // InternalOptionalEmptyTestLanguage.g:105:1: entryRuleGreeting returns [EObject current=null] : iv_ruleGreeting= ruleGreeting EOF ;
    public final EObject entryRuleGreeting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreeting = null;


        try {
            // InternalOptionalEmptyTestLanguage.g:105:49: (iv_ruleGreeting= ruleGreeting EOF )
            // InternalOptionalEmptyTestLanguage.g:106:2: iv_ruleGreeting= ruleGreeting EOF
            {
             newCompositeNode(grammarAccess.getGreetingRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGreeting=ruleGreeting();

            state._fsp--;

             current =iv_ruleGreeting; 
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
    // $ANTLR end "entryRuleGreeting"


    // $ANTLR start "ruleGreeting"
    // InternalOptionalEmptyTestLanguage.g:112:1: ruleGreeting returns [EObject current=null] : (otherlv_0= 'hallo' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleGreeting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOptionalEmptyTestLanguage.g:118:2: ( (otherlv_0= 'hallo' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOptionalEmptyTestLanguage.g:119:2: (otherlv_0= 'hallo' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOptionalEmptyTestLanguage.g:119:2: (otherlv_0= 'hallo' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOptionalEmptyTestLanguage.g:120:3: otherlv_0= 'hallo' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGreetingAccess().getHalloKeyword_0());
            		
            // InternalOptionalEmptyTestLanguage.g:124:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOptionalEmptyTestLanguage.g:125:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOptionalEmptyTestLanguage.g:125:4: (lv_name_1_0= RULE_ID )
            // InternalOptionalEmptyTestLanguage.g:126:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGreetingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleGreeting"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    }


}