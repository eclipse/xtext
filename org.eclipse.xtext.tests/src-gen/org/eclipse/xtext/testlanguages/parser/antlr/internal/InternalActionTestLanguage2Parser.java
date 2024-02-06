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
import org.eclipse.xtext.testlanguages.services.ActionTestLanguage2GrammarAccess;



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
public class InternalActionTestLanguage2Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'|'", "'a'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalActionTestLanguage2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalActionTestLanguage2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalActionTestLanguage2Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalActionTestLanguage2.g"; }



     	private ActionTestLanguage2GrammarAccess grammarAccess;

        public InternalActionTestLanguage2Parser(TokenStream input, ActionTestLanguage2GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ORing";
       	}

       	@Override
       	protected ActionTestLanguage2GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleORing"
    // InternalActionTestLanguage2.g:69:1: entryRuleORing returns [EObject current=null] : iv_ruleORing= ruleORing EOF ;
    public final EObject entryRuleORing() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleORing = null;


        try {
            // InternalActionTestLanguage2.g:69:46: (iv_ruleORing= ruleORing EOF )
            // InternalActionTestLanguage2.g:70:2: iv_ruleORing= ruleORing EOF
            {
             newCompositeNode(grammarAccess.getORingRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleORing=ruleORing();

            state._fsp--;

             current =iv_ruleORing; 
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
    // $ANTLR end "entryRuleORing"


    // $ANTLR start "ruleORing"
    // InternalActionTestLanguage2.g:76:1: ruleORing returns [EObject current=null] : (this_Value_0= ruleValue ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )* ) ;
    public final EObject ruleORing() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Value_0 = null;

        EObject lv_disjuncts_3_0 = null;



        	enterRule();

        try {
            // InternalActionTestLanguage2.g:82:2: ( (this_Value_0= ruleValue ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )* ) )
            // InternalActionTestLanguage2.g:83:2: (this_Value_0= ruleValue ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )* )
            {
            // InternalActionTestLanguage2.g:83:2: (this_Value_0= ruleValue ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )* )
            // InternalActionTestLanguage2.g:84:3: this_Value_0= ruleValue ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )*
            {

            			newCompositeNode(grammarAccess.getORingAccess().getValueParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_Value_0=ruleValue();

            state._fsp--;


            			current = this_Value_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalActionTestLanguage2.g:92:3: ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalActionTestLanguage2.g:93:4: () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) )
            	    {
            	    // InternalActionTestLanguage2.g:93:4: ()
            	    // InternalActionTestLanguage2.g:94:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getORingAccess().getORingDisjunctsAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getORingAccess().getVerticalLineKeyword_1_1());
            	    			
            	    // InternalActionTestLanguage2.g:104:4: ( (lv_disjuncts_3_0= ruleValue ) )
            	    // InternalActionTestLanguage2.g:105:5: (lv_disjuncts_3_0= ruleValue )
            	    {
            	    // InternalActionTestLanguage2.g:105:5: (lv_disjuncts_3_0= ruleValue )
            	    // InternalActionTestLanguage2.g:106:6: lv_disjuncts_3_0= ruleValue
            	    {

            	    						newCompositeNode(grammarAccess.getORingAccess().getDisjunctsValueParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_disjuncts_3_0=ruleValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getORingRule());
            	    						}
            	    						add(
            	    							current,
            	    							"disjuncts",
            	    							lv_disjuncts_3_0,
            	    							"org.eclipse.xtext.testlanguages.ActionTestLanguage2.Value");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleORing"


    // $ANTLR start "entryRuleValue"
    // InternalActionTestLanguage2.g:128:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalActionTestLanguage2.g:128:46: (iv_ruleValue= ruleValue EOF )
            // InternalActionTestLanguage2.g:129:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalActionTestLanguage2.g:135:1: ruleValue returns [EObject current=null] : ( (lv_value_0_0= 'a' ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalActionTestLanguage2.g:141:2: ( ( (lv_value_0_0= 'a' ) ) )
            // InternalActionTestLanguage2.g:142:2: ( (lv_value_0_0= 'a' ) )
            {
            // InternalActionTestLanguage2.g:142:2: ( (lv_value_0_0= 'a' ) )
            // InternalActionTestLanguage2.g:143:3: (lv_value_0_0= 'a' )
            {
            // InternalActionTestLanguage2.g:143:3: (lv_value_0_0= 'a' )
            // InternalActionTestLanguage2.g:144:4: lv_value_0_0= 'a'
            {
            lv_value_0_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getValueAccess().getValueAKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getValueRule());
            				}
            				setWithLastConsumed(current, "value", lv_value_0_0, "a");
            			

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
    // $ANTLR end "ruleValue"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    }


}