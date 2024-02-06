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
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;



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
public class InternalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'choice'", "'optional'", "'reducible'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTestLanguage.g"; }



     	private TestLanguageGrammarAccess grammarAccess;

        public InternalTestLanguageParser(TokenStream input, TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "EntryRule";
       	}

       	@Override
       	protected TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleEntryRule"
    // InternalTestLanguage.g:69:1: entryRuleEntryRule returns [EObject current=null] : iv_ruleEntryRule= ruleEntryRule EOF ;
    public final EObject entryRuleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryRule = null;


        try {
            // InternalTestLanguage.g:69:50: (iv_ruleEntryRule= ruleEntryRule EOF )
            // InternalTestLanguage.g:70:2: iv_ruleEntryRule= ruleEntryRule EOF
            {
             newCompositeNode(grammarAccess.getEntryRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEntryRule=ruleEntryRule();

            state._fsp--;

             current =iv_ruleEntryRule; 
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
    // $ANTLR end "entryRuleEntryRule"


    // $ANTLR start "ruleEntryRule"
    // InternalTestLanguage.g:76:1: ruleEntryRule returns [EObject current=null] : ( (lv_multiFeature_0_0= ruleAbstractRule ) )* ;
    public final EObject ruleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject lv_multiFeature_0_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:82:2: ( ( (lv_multiFeature_0_0= ruleAbstractRule ) )* )
            // InternalTestLanguage.g:83:2: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            {
            // InternalTestLanguage.g:83:2: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTestLanguage.g:84:3: (lv_multiFeature_0_0= ruleAbstractRule )
            	    {
            	    // InternalTestLanguage.g:84:3: (lv_multiFeature_0_0= ruleAbstractRule )
            	    // InternalTestLanguage.g:85:4: lv_multiFeature_0_0= ruleAbstractRule
            	    {

            	    				newCompositeNode(grammarAccess.getEntryRuleAccess().getMultiFeatureAbstractRuleParserRuleCall_0());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_multiFeature_0_0=ruleAbstractRule();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getEntryRuleRule());
            	    				}
            	    				add(
            	    					current,
            	    					"multiFeature",
            	    					lv_multiFeature_0_0,
            	    					"org.eclipse.xtext.testlanguages.TestLanguage.AbstractRule");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleEntryRule"


    // $ANTLR start "entryRuleAbstractRule"
    // InternalTestLanguage.g:105:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // InternalTestLanguage.g:105:53: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // InternalTestLanguage.g:106:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             newCompositeNode(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractRule=ruleAbstractRule();

            state._fsp--;

             current =iv_ruleAbstractRule; 
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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // InternalTestLanguage.g:112:1: ruleAbstractRule returns [EObject current=null] : (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ChoiceRule_0 = null;

        EObject this_ReducibleRule_1 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:118:2: ( (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule ) )
            // InternalTestLanguage.g:119:2: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )
            {
            // InternalTestLanguage.g:119:2: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTestLanguage.g:120:3: this_ChoiceRule_0= ruleChoiceRule
                    {

                    			newCompositeNode(grammarAccess.getAbstractRuleAccess().getChoiceRuleParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ChoiceRule_0=ruleChoiceRule();

                    state._fsp--;


                    			current = this_ChoiceRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:129:3: this_ReducibleRule_1= ruleReducibleRule
                    {

                    			newCompositeNode(grammarAccess.getAbstractRuleAccess().getReducibleRuleParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReducibleRule_1=ruleReducibleRule();

                    state._fsp--;


                    			current = this_ReducibleRule_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleChoiceRule"
    // InternalTestLanguage.g:141:1: entryRuleChoiceRule returns [EObject current=null] : iv_ruleChoiceRule= ruleChoiceRule EOF ;
    public final EObject entryRuleChoiceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoiceRule = null;


        try {
            // InternalTestLanguage.g:141:51: (iv_ruleChoiceRule= ruleChoiceRule EOF )
            // InternalTestLanguage.g:142:2: iv_ruleChoiceRule= ruleChoiceRule EOF
            {
             newCompositeNode(grammarAccess.getChoiceRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChoiceRule=ruleChoiceRule();

            state._fsp--;

             current =iv_ruleChoiceRule; 
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
    // $ANTLR end "entryRuleChoiceRule"


    // $ANTLR start "ruleChoiceRule"
    // InternalTestLanguage.g:148:1: ruleChoiceRule returns [EObject current=null] : (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleChoiceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_optionalKeyword_1_0=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:154:2: ( (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalTestLanguage.g:155:2: (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalTestLanguage.g:155:2: (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            // InternalTestLanguage.g:156:3: otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getChoiceRuleAccess().getChoiceKeyword_0());
            		
            // InternalTestLanguage.g:160:3: ( (lv_optionalKeyword_1_0= 'optional' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalTestLanguage.g:161:4: (lv_optionalKeyword_1_0= 'optional' )
                    {
                    // InternalTestLanguage.g:161:4: (lv_optionalKeyword_1_0= 'optional' )
                    // InternalTestLanguage.g:162:5: lv_optionalKeyword_1_0= 'optional'
                    {
                    lv_optionalKeyword_1_0=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					newLeafNode(lv_optionalKeyword_1_0, grammarAccess.getChoiceRuleAccess().getOptionalKeywordOptionalKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getChoiceRuleRule());
                    					}
                    					setWithLastConsumed(current, "optionalKeyword", lv_optionalKeyword_1_0 != null, "optional");
                    				

                    }


                    }
                    break;

            }

            // InternalTestLanguage.g:174:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTestLanguage.g:175:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTestLanguage.g:175:4: (lv_name_2_0= RULE_ID )
            // InternalTestLanguage.g:176:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getChoiceRuleAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChoiceRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
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
    // $ANTLR end "ruleChoiceRule"


    // $ANTLR start "entryRuleReducibleRule"
    // InternalTestLanguage.g:196:1: entryRuleReducibleRule returns [EObject current=null] : iv_ruleReducibleRule= ruleReducibleRule EOF ;
    public final EObject entryRuleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReducibleRule = null;


        try {
            // InternalTestLanguage.g:196:54: (iv_ruleReducibleRule= ruleReducibleRule EOF )
            // InternalTestLanguage.g:197:2: iv_ruleReducibleRule= ruleReducibleRule EOF
            {
             newCompositeNode(grammarAccess.getReducibleRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReducibleRule=ruleReducibleRule();

            state._fsp--;

             current =iv_ruleReducibleRule; 
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
    // $ANTLR end "entryRuleReducibleRule"


    // $ANTLR start "ruleReducibleRule"
    // InternalTestLanguage.g:203:1: ruleReducibleRule returns [EObject current=null] : (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) ;
    public final EObject ruleReducibleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TerminalRule_1 = null;

        EObject lv_actionFeature_3_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:209:2: ( (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) )
            // InternalTestLanguage.g:210:2: (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            {
            // InternalTestLanguage.g:210:2: (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            // InternalTestLanguage.g:211:3: otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getReducibleRuleAccess().getReducibleKeyword_0());
            		

            			newCompositeNode(grammarAccess.getReducibleRuleAccess().getTerminalRuleParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            this_TerminalRule_1=ruleTerminalRule();

            state._fsp--;


            			current = this_TerminalRule_1;
            			afterParserOrEnumRuleCall();
            		
            // InternalTestLanguage.g:223:3: ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalTestLanguage.g:224:4: () ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    {
                    // InternalTestLanguage.g:224:4: ()
                    // InternalTestLanguage.g:225:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getReducibleRuleAccess().getReducibleCompositeActionFeatureAction_2_0(),
                    						current);
                    				

                    }

                    // InternalTestLanguage.g:231:4: ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    // InternalTestLanguage.g:232:5: (lv_actionFeature_3_0= ruleTerminalRule )
                    {
                    // InternalTestLanguage.g:232:5: (lv_actionFeature_3_0= ruleTerminalRule )
                    // InternalTestLanguage.g:233:6: lv_actionFeature_3_0= ruleTerminalRule
                    {

                    						newCompositeNode(grammarAccess.getReducibleRuleAccess().getActionFeatureTerminalRuleParserRuleCall_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_actionFeature_3_0=ruleTerminalRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getReducibleRuleRule());
                    						}
                    						add(
                    							current,
                    							"actionFeature",
                    							lv_actionFeature_3_0,
                    							"org.eclipse.xtext.testlanguages.TestLanguage.TerminalRule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


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
    // $ANTLR end "ruleReducibleRule"


    // $ANTLR start "entryRuleTerminalRule"
    // InternalTestLanguage.g:255:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // InternalTestLanguage.g:255:53: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // InternalTestLanguage.g:256:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             newCompositeNode(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalRule=ruleTerminalRule();

            state._fsp--;

             current =iv_ruleTerminalRule; 
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
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // InternalTestLanguage.g:262:1: ruleTerminalRule returns [EObject current=null] : ( (lv_stringFeature_0_0= RULE_STRING ) ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_stringFeature_0_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:268:2: ( ( (lv_stringFeature_0_0= RULE_STRING ) ) )
            // InternalTestLanguage.g:269:2: ( (lv_stringFeature_0_0= RULE_STRING ) )
            {
            // InternalTestLanguage.g:269:2: ( (lv_stringFeature_0_0= RULE_STRING ) )
            // InternalTestLanguage.g:270:3: (lv_stringFeature_0_0= RULE_STRING )
            {
            // InternalTestLanguage.g:270:3: (lv_stringFeature_0_0= RULE_STRING )
            // InternalTestLanguage.g:271:4: lv_stringFeature_0_0= RULE_STRING
            {
            lv_stringFeature_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_stringFeature_0_0, grammarAccess.getTerminalRuleAccess().getStringFeatureSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getTerminalRuleRule());
            				}
            				setWithLastConsumed(
            					current,
            					"stringFeature",
            					lv_stringFeature_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

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
    // $ANTLR end "ruleTerminalRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000022L});
    }


}