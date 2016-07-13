package org.eclipse.xtext.parser.parameters.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.parameters.services.TwoParametersTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalTwoParametersTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#6'", "'#7'", "'#8'", "'#9'", "'keyword'", "'#10'", "'#11'", "'#12'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalTwoParametersTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTwoParametersTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTwoParametersTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTwoParametersTestLanguage.g"; }



     	private TwoParametersTestLanguageGrammarAccess grammarAccess;

        public InternalTwoParametersTestLanguageParser(TokenStream input, TwoParametersTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ParserRuleParameters";
       	}

       	@Override
       	protected TwoParametersTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleParserRuleParameters"
    // InternalTwoParametersTestLanguage.g:64:1: entryRuleParserRuleParameters returns [EObject current=null] : iv_ruleParserRuleParameters= ruleParserRuleParameters EOF ;
    public final EObject entryRuleParserRuleParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleParameters = null;


        try {
            // InternalTwoParametersTestLanguage.g:64:61: (iv_ruleParserRuleParameters= ruleParserRuleParameters EOF )
            // InternalTwoParametersTestLanguage.g:65:2: iv_ruleParserRuleParameters= ruleParserRuleParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParserRuleParametersRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParserRuleParameters=ruleParserRuleParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParserRuleParameters; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleParserRuleParameters"


    // $ANTLR start "ruleParserRuleParameters"
    // InternalTwoParametersTestLanguage.g:71:1: ruleParserRuleParameters returns [EObject current=null] : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm3_Scenario5 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm3_Scenario6 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= norm2_Scenario6 ) ) ) | ( ( ( '#5' ( ( norm3_Scenario6 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm3_Scenario7 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= norm2_Scenario7 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
    public final EObject ruleParserRuleParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_32=null;
        EObject lv_scenario_2_0 = null;

        EObject lv_scenario_4_0 = null;

        EObject lv_scenario_6_0 = null;

        EObject lv_scenario_8_0 = null;

        EObject lv_scenario_10_0 = null;

        EObject lv_scenario_12_0 = null;

        EObject lv_scenario_14_0 = null;

        EObject lv_scenario_16_0 = null;

        EObject lv_scenario_18_0 = null;

        EObject lv_scenario_19_0 = null;

        EObject lv_scenario_22_0 = null;

        EObject lv_scenario_23_0 = null;

        EObject lv_scenario_26_0 = null;

        EObject lv_scenario_27_0 = null;

        EObject lv_scenario_30_0 = null;

        EObject lv_scenario_31_0 = null;



        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:77:2: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm3_Scenario5 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm3_Scenario6 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= norm2_Scenario6 ) ) ) | ( ( ( '#5' ( ( norm3_Scenario6 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm3_Scenario7 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= norm2_Scenario7 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // InternalTwoParametersTestLanguage.g:78:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm3_Scenario5 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm3_Scenario6 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= norm2_Scenario6 ) ) ) | ( ( ( '#5' ( ( norm3_Scenario6 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm3_Scenario7 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= norm2_Scenario7 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // InternalTwoParametersTestLanguage.g:78:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm3_Scenario5 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm3_Scenario6 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= norm2_Scenario6 ) ) ) | ( ( ( '#5' ( ( norm3_Scenario6 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm3_Scenario7 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= norm2_Scenario7 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // InternalTwoParametersTestLanguage.g:79:3: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm3_Scenario5 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm3_Scenario6 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= norm2_Scenario6 ) ) ) | ( ( ( '#5' ( ( norm3_Scenario6 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm3_Scenario7 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= norm2_Scenario7 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // InternalTwoParametersTestLanguage.g:79:3: ()
            // InternalTwoParametersTestLanguage.g:80:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParserRuleParametersAccess().getParserRuleParametersAction_0(),
              					current);
              			
            }

            }

            // InternalTwoParametersTestLanguage.g:86:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm3_Scenario5 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm3_Scenario6 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= norm2_Scenario6 ) ) ) | ( ( ( '#5' ( ( norm3_Scenario6 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm3_Scenario7 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= norm2_Scenario7 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalTwoParametersTestLanguage.g:87:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm3_Scenario5 ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:87:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm3_Scenario5 ) ) )
                    // InternalTwoParametersTestLanguage.g:88:5: otherlv_1= '#1' ( (lv_scenario_2_0= norm3_Scenario5 ) )
                    {
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneKeyword_1_0_0());
                      				
                    }
                    // InternalTwoParametersTestLanguage.g:92:5: ( (lv_scenario_2_0= norm3_Scenario5 ) )
                    // InternalTwoParametersTestLanguage.g:93:6: (lv_scenario_2_0= norm3_Scenario5 )
                    {
                    // InternalTwoParametersTestLanguage.g:93:6: (lv_scenario_2_0= norm3_Scenario5 )
                    // InternalTwoParametersTestLanguage.g:94:7: lv_scenario_2_0= norm3_Scenario5
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario5ParserRuleCall_1_0_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_2_0=norm3_Scenario5();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                      							}
                      							set(
                      								current,
                      								"scenario",
                      								lv_scenario_2_0,
                      								"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario5");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTwoParametersTestLanguage.g:113:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5 ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:113:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5 ) ) )
                    // InternalTwoParametersTestLanguage.g:114:5: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5 ) )
                    {
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitTwoKeyword_1_1_0());
                      				
                    }
                    // InternalTwoParametersTestLanguage.g:118:5: ( (lv_scenario_4_0= ruleScenario5 ) )
                    // InternalTwoParametersTestLanguage.g:119:6: (lv_scenario_4_0= ruleScenario5 )
                    {
                    // InternalTwoParametersTestLanguage.g:119:6: (lv_scenario_4_0= ruleScenario5 )
                    // InternalTwoParametersTestLanguage.g:120:7: lv_scenario_4_0= ruleScenario5
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario5ParserRuleCall_1_1_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_4_0=ruleScenario5();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                      							}
                      							set(
                      								current,
                      								"scenario",
                      								lv_scenario_4_0,
                      								"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario5");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalTwoParametersTestLanguage.g:139:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm3_Scenario6 ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:139:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm3_Scenario6 ) ) )
                    // InternalTwoParametersTestLanguage.g:140:5: otherlv_5= '#3' ( (lv_scenario_6_0= norm3_Scenario6 ) )
                    {
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitThreeKeyword_1_2_0());
                      				
                    }
                    // InternalTwoParametersTestLanguage.g:144:5: ( (lv_scenario_6_0= norm3_Scenario6 ) )
                    // InternalTwoParametersTestLanguage.g:145:6: (lv_scenario_6_0= norm3_Scenario6 )
                    {
                    // InternalTwoParametersTestLanguage.g:145:6: (lv_scenario_6_0= norm3_Scenario6 )
                    // InternalTwoParametersTestLanguage.g:146:7: lv_scenario_6_0= norm3_Scenario6
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_2_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_6_0=norm3_Scenario6();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                      							}
                      							set(
                      								current,
                      								"scenario",
                      								lv_scenario_6_0,
                      								"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario6");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalTwoParametersTestLanguage.g:165:4: (otherlv_7= '#4' ( (lv_scenario_8_0= norm2_Scenario6 ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:165:4: (otherlv_7= '#4' ( (lv_scenario_8_0= norm2_Scenario6 ) ) )
                    // InternalTwoParametersTestLanguage.g:166:5: otherlv_7= '#4' ( (lv_scenario_8_0= norm2_Scenario6 ) )
                    {
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFourKeyword_1_3_0());
                      				
                    }
                    // InternalTwoParametersTestLanguage.g:170:5: ( (lv_scenario_8_0= norm2_Scenario6 ) )
                    // InternalTwoParametersTestLanguage.g:171:6: (lv_scenario_8_0= norm2_Scenario6 )
                    {
                    // InternalTwoParametersTestLanguage.g:171:6: (lv_scenario_8_0= norm2_Scenario6 )
                    // InternalTwoParametersTestLanguage.g:172:7: lv_scenario_8_0= norm2_Scenario6
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_3_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_8_0=norm2_Scenario6();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                      							}
                      							set(
                      								current,
                      								"scenario",
                      								lv_scenario_8_0,
                      								"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario6");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalTwoParametersTestLanguage.g:191:4: ( ( ( '#5' ( ( norm3_Scenario6 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:191:4: ( ( ( '#5' ( ( norm3_Scenario6 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) ) )
                    // InternalTwoParametersTestLanguage.g:192:5: ( ( '#5' ( ( norm3_Scenario6 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:201:5: (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) )
                    // InternalTwoParametersTestLanguage.g:202:6: otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) )
                    {
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_9, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFiveKeyword_1_4_0_0());
                      					
                    }
                    // InternalTwoParametersTestLanguage.g:206:6: ( (lv_scenario_10_0= norm3_Scenario6 ) )
                    // InternalTwoParametersTestLanguage.g:207:7: (lv_scenario_10_0= norm3_Scenario6 )
                    {
                    // InternalTwoParametersTestLanguage.g:207:7: (lv_scenario_10_0= norm3_Scenario6 )
                    // InternalTwoParametersTestLanguage.g:208:8: lv_scenario_10_0= norm3_Scenario6
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_4_0_1_0());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_10_0=norm3_Scenario6();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                      								}
                      								set(
                      									current,
                      									"scenario",
                      									lv_scenario_10_0,
                      									"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario6");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalTwoParametersTestLanguage.g:228:4: ( ( ( '#6' ( ( ruleScenario6 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:228:4: ( ( ( '#6' ( ( ruleScenario6 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) ) )
                    // InternalTwoParametersTestLanguage.g:229:5: ( ( '#6' ( ( ruleScenario6 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:238:5: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) )
                    // InternalTwoParametersTestLanguage.g:239:6: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) )
                    {
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_11, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSixKeyword_1_5_0_0());
                      					
                    }
                    // InternalTwoParametersTestLanguage.g:243:6: ( (lv_scenario_12_0= ruleScenario6 ) )
                    // InternalTwoParametersTestLanguage.g:244:7: (lv_scenario_12_0= ruleScenario6 )
                    {
                    // InternalTwoParametersTestLanguage.g:244:7: (lv_scenario_12_0= ruleScenario6 )
                    // InternalTwoParametersTestLanguage.g:245:8: lv_scenario_12_0= ruleScenario6
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_5_0_1_0());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_12_0=ruleScenario6();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                      								}
                      								set(
                      									current,
                      									"scenario",
                      									lv_scenario_12_0,
                      									"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario6");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalTwoParametersTestLanguage.g:265:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm3_Scenario7 ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:265:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm3_Scenario7 ) ) )
                    // InternalTwoParametersTestLanguage.g:266:5: otherlv_13= '#7' ( (lv_scenario_14_0= norm3_Scenario7 ) )
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_13, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSevenKeyword_1_6_0());
                      				
                    }
                    // InternalTwoParametersTestLanguage.g:270:5: ( (lv_scenario_14_0= norm3_Scenario7 ) )
                    // InternalTwoParametersTestLanguage.g:271:6: (lv_scenario_14_0= norm3_Scenario7 )
                    {
                    // InternalTwoParametersTestLanguage.g:271:6: (lv_scenario_14_0= norm3_Scenario7 )
                    // InternalTwoParametersTestLanguage.g:272:7: lv_scenario_14_0= norm3_Scenario7
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario7ParserRuleCall_1_6_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_14_0=norm3_Scenario7();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                      							}
                      							set(
                      								current,
                      								"scenario",
                      								lv_scenario_14_0,
                      								"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario7");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalTwoParametersTestLanguage.g:291:4: (otherlv_15= '#8' ( (lv_scenario_16_0= norm2_Scenario7 ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:291:4: (otherlv_15= '#8' ( (lv_scenario_16_0= norm2_Scenario7 ) ) )
                    // InternalTwoParametersTestLanguage.g:292:5: otherlv_15= '#8' ( (lv_scenario_16_0= norm2_Scenario7 ) )
                    {
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_15, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitEightKeyword_1_7_0());
                      				
                    }
                    // InternalTwoParametersTestLanguage.g:296:5: ( (lv_scenario_16_0= norm2_Scenario7 ) )
                    // InternalTwoParametersTestLanguage.g:297:6: (lv_scenario_16_0= norm2_Scenario7 )
                    {
                    // InternalTwoParametersTestLanguage.g:297:6: (lv_scenario_16_0= norm2_Scenario7 )
                    // InternalTwoParametersTestLanguage.g:298:7: lv_scenario_16_0= norm2_Scenario7
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario7ParserRuleCall_1_7_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_16_0=norm2_Scenario7();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                      							}
                      							set(
                      								current,
                      								"scenario",
                      								lv_scenario_16_0,
                      								"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario7");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalTwoParametersTestLanguage.g:317:4: (otherlv_17= '#9' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:317:4: (otherlv_17= '#9' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) ) )
                    // InternalTwoParametersTestLanguage.g:318:5: otherlv_17= '#9' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_17, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitNineKeyword_1_8_0());
                      				
                    }
                    // InternalTwoParametersTestLanguage.g:322:5: ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==20) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==20) ) {
                            int LA2_3 = input.LA(3);

                            if ( (synpred3_InternalTwoParametersTestLanguage()) ) {
                                alt2=1;
                            }
                            else if ( (true) ) {
                                alt2=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA2_1==EOF) ) {
                            alt2=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA2_0==RULE_ID) ) {
                        int LA2_2 = input.LA(2);

                        if ( (LA2_2==20) ) {
                            int LA2_3 = input.LA(3);

                            if ( (synpred3_InternalTwoParametersTestLanguage()) ) {
                                alt2=1;
                            }
                            else if ( (true) ) {
                                alt2=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA2_2==EOF) ) {
                            alt2=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalTwoParametersTestLanguage.g:323:6: ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) )
                            {
                            // InternalTwoParametersTestLanguage.g:323:6: ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) )
                            // InternalTwoParametersTestLanguage.g:324:7: ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 )
                            {
                            // InternalTwoParametersTestLanguage.g:328:7: (lv_scenario_18_0= norm3_Scenario8 )
                            // InternalTwoParametersTestLanguage.g:329:8: lv_scenario_18_0= norm3_Scenario8
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario8ParserRuleCall_1_8_1_0_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_18_0=norm3_Scenario8();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                              								}
                              								set(
                              									current,
                              									"scenario",
                              									lv_scenario_18_0,
                              									"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario8");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTwoParametersTestLanguage.g:347:6: ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? )
                            {
                            // InternalTwoParametersTestLanguage.g:347:6: ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? )
                            // InternalTwoParametersTestLanguage.g:348:7: ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )?
                            {
                            // InternalTwoParametersTestLanguage.g:348:7: ( (lv_scenario_19_0= norm3_Scenario6 ) )
                            // InternalTwoParametersTestLanguage.g:349:8: (lv_scenario_19_0= norm3_Scenario6 )
                            {
                            // InternalTwoParametersTestLanguage.g:349:8: (lv_scenario_19_0= norm3_Scenario6 )
                            // InternalTwoParametersTestLanguage.g:350:9: lv_scenario_19_0= norm3_Scenario6
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_8_1_1_0_0());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_19_0=norm3_Scenario6();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                              									}
                              									set(
                              										current,
                              										"scenario",
                              										lv_scenario_19_0,
                              										"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario6");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            // InternalTwoParametersTestLanguage.g:367:7: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // InternalTwoParametersTestLanguage.g:368:8: otherlv_20= 'keyword'
                                    {
                                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								newLeafNode(otherlv_20, grammarAccess.getParserRuleParametersAccess().getKeywordKeyword_1_8_1_1_1());
                                      							
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalTwoParametersTestLanguage.g:377:4: (otherlv_21= '#10' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:377:4: (otherlv_21= '#10' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) ) )
                    // InternalTwoParametersTestLanguage.g:378:5: otherlv_21= '#10' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_21, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitZeroKeyword_1_9_0());
                      				
                    }
                    // InternalTwoParametersTestLanguage.g:382:5: ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) && (synpred4_InternalTwoParametersTestLanguage())) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_ID) ) {
                        int LA4_2 = input.LA(2);

                        if ( (LA4_2==20) ) {
                            int LA4_3 = input.LA(3);

                            if ( (synpred4_InternalTwoParametersTestLanguage()) ) {
                                alt4=1;
                            }
                            else if ( (true) ) {
                                alt4=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA4_2==EOF) ) {
                            alt4=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalTwoParametersTestLanguage.g:383:6: ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) )
                            {
                            // InternalTwoParametersTestLanguage.g:383:6: ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) )
                            // InternalTwoParametersTestLanguage.g:384:7: ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 )
                            {
                            // InternalTwoParametersTestLanguage.g:388:7: (lv_scenario_22_0= norm3_Scenario8 )
                            // InternalTwoParametersTestLanguage.g:389:8: lv_scenario_22_0= norm3_Scenario8
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario8ParserRuleCall_1_9_1_0_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_22_0=norm3_Scenario8();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                              								}
                              								set(
                              									current,
                              									"scenario",
                              									lv_scenario_22_0,
                              									"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario8");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTwoParametersTestLanguage.g:407:6: ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? )
                            {
                            // InternalTwoParametersTestLanguage.g:407:6: ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? )
                            // InternalTwoParametersTestLanguage.g:408:7: ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )?
                            {
                            // InternalTwoParametersTestLanguage.g:408:7: ( (lv_scenario_23_0= ruleScenario6 ) )
                            // InternalTwoParametersTestLanguage.g:409:8: (lv_scenario_23_0= ruleScenario6 )
                            {
                            // InternalTwoParametersTestLanguage.g:409:8: (lv_scenario_23_0= ruleScenario6 )
                            // InternalTwoParametersTestLanguage.g:410:9: lv_scenario_23_0= ruleScenario6
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_9_1_1_0_0());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_23_0=ruleScenario6();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                              									}
                              									set(
                              										current,
                              										"scenario",
                              										lv_scenario_23_0,
                              										"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario6");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            // InternalTwoParametersTestLanguage.g:427:7: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // InternalTwoParametersTestLanguage.g:428:8: otherlv_24= 'keyword'
                                    {
                                    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								newLeafNode(otherlv_24, grammarAccess.getParserRuleParametersAccess().getKeywordKeyword_1_9_1_1_1());
                                      							
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalTwoParametersTestLanguage.g:437:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:437:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) ) )
                    // InternalTwoParametersTestLanguage.g:438:5: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_25, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitOneKeyword_1_10_0());
                      				
                    }
                    // InternalTwoParametersTestLanguage.g:442:5: ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==20) ) {
                            int LA6_3 = input.LA(3);

                            if ( (synpred5_InternalTwoParametersTestLanguage()) ) {
                                alt6=1;
                            }
                            else if ( (true) ) {
                                alt6=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA6_1==EOF) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA6_0==20) ) {
                        alt6=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalTwoParametersTestLanguage.g:443:6: ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) )
                            {
                            // InternalTwoParametersTestLanguage.g:443:6: ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) )
                            // InternalTwoParametersTestLanguage.g:444:7: ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 )
                            {
                            // InternalTwoParametersTestLanguage.g:448:7: (lv_scenario_26_0= ruleScenario8 )
                            // InternalTwoParametersTestLanguage.g:449:8: lv_scenario_26_0= ruleScenario8
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario8ParserRuleCall_1_10_1_0_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_26_0=ruleScenario8();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                              								}
                              								set(
                              									current,
                              									"scenario",
                              									lv_scenario_26_0,
                              									"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario8");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTwoParametersTestLanguage.g:467:6: ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? )
                            {
                            // InternalTwoParametersTestLanguage.g:467:6: ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? )
                            // InternalTwoParametersTestLanguage.g:468:7: ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )?
                            {
                            // InternalTwoParametersTestLanguage.g:468:7: ( (lv_scenario_27_0= norm3_Scenario6 ) )
                            // InternalTwoParametersTestLanguage.g:469:8: (lv_scenario_27_0= norm3_Scenario6 )
                            {
                            // InternalTwoParametersTestLanguage.g:469:8: (lv_scenario_27_0= norm3_Scenario6 )
                            // InternalTwoParametersTestLanguage.g:470:9: lv_scenario_27_0= norm3_Scenario6
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_10_1_1_0_0());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_27_0=norm3_Scenario6();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                              									}
                              									set(
                              										current,
                              										"scenario",
                              										lv_scenario_27_0,
                              										"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario6");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            // InternalTwoParametersTestLanguage.g:487:7: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // InternalTwoParametersTestLanguage.g:488:8: otherlv_28= 'keyword'
                                    {
                                    otherlv_28=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								newLeafNode(otherlv_28, grammarAccess.getParserRuleParametersAccess().getKeywordKeyword_1_10_1_1_1());
                                      							
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalTwoParametersTestLanguage.g:497:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // InternalTwoParametersTestLanguage.g:497:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) ) )
                    // InternalTwoParametersTestLanguage.g:498:5: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_29, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitTwoKeyword_1_11_0());
                      				
                    }
                    // InternalTwoParametersTestLanguage.g:502:5: ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_2 = input.LA(3);

                            if ( (synpred6_InternalTwoParametersTestLanguage()) ) {
                                alt8=1;
                            }
                            else if ( (true) ) {
                                alt8=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 2, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA8_1==EOF) ) {
                            alt8=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalTwoParametersTestLanguage.g:503:6: ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) )
                            {
                            // InternalTwoParametersTestLanguage.g:503:6: ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) )
                            // InternalTwoParametersTestLanguage.g:504:7: ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 )
                            {
                            // InternalTwoParametersTestLanguage.g:508:7: (lv_scenario_30_0= ruleScenario8 )
                            // InternalTwoParametersTestLanguage.g:509:8: lv_scenario_30_0= ruleScenario8
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario8ParserRuleCall_1_11_1_0_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_30_0=ruleScenario8();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                              								}
                              								set(
                              									current,
                              									"scenario",
                              									lv_scenario_30_0,
                              									"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario8");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTwoParametersTestLanguage.g:527:6: ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? )
                            {
                            // InternalTwoParametersTestLanguage.g:527:6: ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? )
                            // InternalTwoParametersTestLanguage.g:528:7: ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )?
                            {
                            // InternalTwoParametersTestLanguage.g:528:7: ( (lv_scenario_31_0= ruleScenario6 ) )
                            // InternalTwoParametersTestLanguage.g:529:8: (lv_scenario_31_0= ruleScenario6 )
                            {
                            // InternalTwoParametersTestLanguage.g:529:8: (lv_scenario_31_0= ruleScenario6 )
                            // InternalTwoParametersTestLanguage.g:530:9: lv_scenario_31_0= ruleScenario6
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_11_1_1_0_0());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_31_0=ruleScenario6();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getParserRuleParametersRule());
                              									}
                              									set(
                              										current,
                              										"scenario",
                              										lv_scenario_31_0,
                              										"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.Scenario6");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            // InternalTwoParametersTestLanguage.g:547:7: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // InternalTwoParametersTestLanguage.g:548:8: otherlv_32= 'keyword'
                                    {
                                    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								newLeafNode(otherlv_32, grammarAccess.getParserRuleParametersAccess().getKeywordKeyword_1_11_1_1_1());
                                      							
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleParserRuleParameters"


    // $ANTLR start "entryRuleScenario5"
    // InternalTwoParametersTestLanguage.g:561:1: entryRuleScenario5 returns [EObject current=null] : iv_ruleScenario5= ruleScenario5 EOF ;
    public final EObject entryRuleScenario5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario5 = null;


        try {
            // InternalTwoParametersTestLanguage.g:561:50: (iv_ruleScenario5= ruleScenario5 EOF )
            // InternalTwoParametersTestLanguage.g:562:2: iv_ruleScenario5= ruleScenario5 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario5Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario5=ruleScenario5();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario5; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScenario5"


    // $ANTLR start "ruleScenario5"
    // InternalTwoParametersTestLanguage.g:568:1: ruleScenario5 returns [EObject current=null] : ( (lv_second_0_0= RULE_ID ) ) ;
    public final EObject ruleScenario5() throws RecognitionException {
        EObject current = null;

        Token lv_second_0_0=null;


        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:574:2: ( ( (lv_second_0_0= RULE_ID ) ) )
            // InternalTwoParametersTestLanguage.g:575:2: ( (lv_second_0_0= RULE_ID ) )
            {
            // InternalTwoParametersTestLanguage.g:575:2: ( (lv_second_0_0= RULE_ID ) )
            // InternalTwoParametersTestLanguage.g:576:3: (lv_second_0_0= RULE_ID )
            {
            // InternalTwoParametersTestLanguage.g:576:3: (lv_second_0_0= RULE_ID )
            // InternalTwoParametersTestLanguage.g:577:4: lv_second_0_0= RULE_ID
            {
            lv_second_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_second_0_0, grammarAccess.getScenario5Access().getSecondIDTerminalRuleCall_1_0_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getScenario5Rule());
              				}
              				setWithLastConsumed(
              					current,
              					"second",
              					lv_second_0_0,
              					"org.eclipse.xtext.common.Terminals.ID");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleScenario5"


    // $ANTLR start "norm3_Scenario5"
    // InternalTwoParametersTestLanguage.g:597:1: norm3_Scenario5 returns [EObject current=null] : ( (lv_first_0_0= RULE_ID ) ) ;
    public final EObject norm3_Scenario5() throws RecognitionException {
        EObject current = null;

        Token lv_first_0_0=null;


        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:603:2: ( ( (lv_first_0_0= RULE_ID ) ) )
            // InternalTwoParametersTestLanguage.g:604:2: ( (lv_first_0_0= RULE_ID ) )
            {
            // InternalTwoParametersTestLanguage.g:604:2: ( (lv_first_0_0= RULE_ID ) )
            // InternalTwoParametersTestLanguage.g:605:3: (lv_first_0_0= RULE_ID )
            {
            // InternalTwoParametersTestLanguage.g:605:3: (lv_first_0_0= RULE_ID )
            // InternalTwoParametersTestLanguage.g:606:4: lv_first_0_0= RULE_ID
            {
            lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_first_0_0, grammarAccess.getScenario5Access().getFirstIDTerminalRuleCall_0_0_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getScenario5Rule());
              				}
              				setWithLastConsumed(
              					current,
              					"first",
              					lv_first_0_0,
              					"org.eclipse.xtext.common.Terminals.ID");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm3_Scenario5"


    // $ANTLR start "entryRuleScenario6"
    // InternalTwoParametersTestLanguage.g:625:1: entryRuleScenario6 returns [EObject current=null] : iv_ruleScenario6= ruleScenario6 EOF ;
    public final EObject entryRuleScenario6() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario6 = null;


        try {
            // InternalTwoParametersTestLanguage.g:625:50: (iv_ruleScenario6= ruleScenario6 EOF )
            // InternalTwoParametersTestLanguage.g:626:2: iv_ruleScenario6= ruleScenario6 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario6Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario6=ruleScenario6();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario6; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScenario6"


    // $ANTLR start "ruleScenario6"
    // InternalTwoParametersTestLanguage.g:632:1: ruleScenario6 returns [EObject current=null] : ( (lv_first_0_0= ruleIdOrKeyword2 ) ) ;
    public final EObject ruleScenario6() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;



        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:638:2: ( ( (lv_first_0_0= ruleIdOrKeyword2 ) ) )
            // InternalTwoParametersTestLanguage.g:639:2: ( (lv_first_0_0= ruleIdOrKeyword2 ) )
            {
            // InternalTwoParametersTestLanguage.g:639:2: ( (lv_first_0_0= ruleIdOrKeyword2 ) )
            // InternalTwoParametersTestLanguage.g:640:3: (lv_first_0_0= ruleIdOrKeyword2 )
            {
            // InternalTwoParametersTestLanguage.g:640:3: (lv_first_0_0= ruleIdOrKeyword2 )
            // InternalTwoParametersTestLanguage.g:641:4: lv_first_0_0= ruleIdOrKeyword2
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getScenario6Access().getFirstIdOrKeyword2ParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=ruleIdOrKeyword2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getScenario6Rule());
              				}
              				set(
              					current,
              					"first",
              					lv_first_0_0,
              					"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.IdOrKeyword2");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleScenario6"


    // $ANTLR start "norm2_Scenario6"
    // InternalTwoParametersTestLanguage.g:662:1: norm2_Scenario6 returns [EObject current=null] : ( (lv_first_0_0= norm2_IdOrKeyword2 ) ) ;
    public final EObject norm2_Scenario6() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;



        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:668:2: ( ( (lv_first_0_0= norm2_IdOrKeyword2 ) ) )
            // InternalTwoParametersTestLanguage.g:669:2: ( (lv_first_0_0= norm2_IdOrKeyword2 ) )
            {
            // InternalTwoParametersTestLanguage.g:669:2: ( (lv_first_0_0= norm2_IdOrKeyword2 ) )
            // InternalTwoParametersTestLanguage.g:670:3: (lv_first_0_0= norm2_IdOrKeyword2 )
            {
            // InternalTwoParametersTestLanguage.g:670:3: (lv_first_0_0= norm2_IdOrKeyword2 )
            // InternalTwoParametersTestLanguage.g:671:4: lv_first_0_0= norm2_IdOrKeyword2
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getScenario6Access().getFirstIdOrKeyword2ParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=norm2_IdOrKeyword2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getScenario6Rule());
              				}
              				set(
              					current,
              					"first",
              					lv_first_0_0,
              					"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.IdOrKeyword2");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm2_Scenario6"


    // $ANTLR start "norm3_Scenario6"
    // InternalTwoParametersTestLanguage.g:692:1: norm3_Scenario6 returns [EObject current=null] : ( (lv_first_0_0= norm7_IdOrKeyword2 ) ) ;
    public final EObject norm3_Scenario6() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;



        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:698:2: ( ( (lv_first_0_0= norm7_IdOrKeyword2 ) ) )
            // InternalTwoParametersTestLanguage.g:699:2: ( (lv_first_0_0= norm7_IdOrKeyword2 ) )
            {
            // InternalTwoParametersTestLanguage.g:699:2: ( (lv_first_0_0= norm7_IdOrKeyword2 ) )
            // InternalTwoParametersTestLanguage.g:700:3: (lv_first_0_0= norm7_IdOrKeyword2 )
            {
            // InternalTwoParametersTestLanguage.g:700:3: (lv_first_0_0= norm7_IdOrKeyword2 )
            // InternalTwoParametersTestLanguage.g:701:4: lv_first_0_0= norm7_IdOrKeyword2
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getScenario6Access().getFirstIdOrKeyword2ParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=norm7_IdOrKeyword2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getScenario6Rule());
              				}
              				set(
              					current,
              					"first",
              					lv_first_0_0,
              					"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.IdOrKeyword2");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm3_Scenario6"


    // $ANTLR start "norm2_Scenario7"
    // InternalTwoParametersTestLanguage.g:722:1: norm2_Scenario7 returns [EObject current=null] : ( ( ( ( norm2_IdOrKeyword2 ) )=> (lv_first_0_0= norm2_IdOrKeyword2 ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final EObject norm2_Scenario7() throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;



        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:728:2: ( ( ( ( ( norm2_IdOrKeyword2 ) )=> (lv_first_0_0= norm2_IdOrKeyword2 ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // InternalTwoParametersTestLanguage.g:729:2: ( ( ( ( norm2_IdOrKeyword2 ) )=> (lv_first_0_0= norm2_IdOrKeyword2 ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // InternalTwoParametersTestLanguage.g:729:2: ( ( ( ( norm2_IdOrKeyword2 ) )=> (lv_first_0_0= norm2_IdOrKeyword2 ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) && (synpred7_InternalTwoParametersTestLanguage())) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalTwoParametersTestLanguage.g:730:3: ( ( ( norm2_IdOrKeyword2 ) )=> (lv_first_0_0= norm2_IdOrKeyword2 ) )
                    {
                    // InternalTwoParametersTestLanguage.g:730:3: ( ( ( norm2_IdOrKeyword2 ) )=> (lv_first_0_0= norm2_IdOrKeyword2 ) )
                    // InternalTwoParametersTestLanguage.g:731:4: ( ( norm2_IdOrKeyword2 ) )=> (lv_first_0_0= norm2_IdOrKeyword2 )
                    {
                    // InternalTwoParametersTestLanguage.g:735:4: (lv_first_0_0= norm2_IdOrKeyword2 )
                    // InternalTwoParametersTestLanguage.g:736:5: lv_first_0_0= norm2_IdOrKeyword2
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getScenario7Access().getFirstIdOrKeyword2ParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=norm2_IdOrKeyword2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getScenario7Rule());
                      					}
                      					set(
                      						current,
                      						"first",
                      						lv_first_0_0,
                      						"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.IdOrKeyword2");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTwoParametersTestLanguage.g:754:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // InternalTwoParametersTestLanguage.g:754:3: ( (lv_second_1_0= 'keyword' ) )
                    // InternalTwoParametersTestLanguage.g:755:4: (lv_second_1_0= 'keyword' )
                    {
                    // InternalTwoParametersTestLanguage.g:755:4: (lv_second_1_0= 'keyword' )
                    // InternalTwoParametersTestLanguage.g:756:5: lv_second_1_0= 'keyword'
                    {
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_second_1_0, grammarAccess.getScenario7Access().getSecondKeywordKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getScenario7Rule());
                      					}
                      					setWithLastConsumed(current, "second", lv_second_1_0, "keyword");
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm2_Scenario7"


    // $ANTLR start "norm3_Scenario7"
    // InternalTwoParametersTestLanguage.g:773:1: norm3_Scenario7 returns [EObject current=null] : ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_first_0_0= norm7_IdOrKeyword2 ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final EObject norm3_Scenario7() throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;



        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:779:2: ( ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_first_0_0= norm7_IdOrKeyword2 ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // InternalTwoParametersTestLanguage.g:780:2: ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_first_0_0= norm7_IdOrKeyword2 ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // InternalTwoParametersTestLanguage.g:780:2: ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_first_0_0= norm7_IdOrKeyword2 ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred8_InternalTwoParametersTestLanguage()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA11_0==RULE_ID) && (synpred8_InternalTwoParametersTestLanguage())) {
                alt11=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalTwoParametersTestLanguage.g:781:3: ( ( ( norm7_IdOrKeyword2 ) )=> (lv_first_0_0= norm7_IdOrKeyword2 ) )
                    {
                    // InternalTwoParametersTestLanguage.g:781:3: ( ( ( norm7_IdOrKeyword2 ) )=> (lv_first_0_0= norm7_IdOrKeyword2 ) )
                    // InternalTwoParametersTestLanguage.g:782:4: ( ( norm7_IdOrKeyword2 ) )=> (lv_first_0_0= norm7_IdOrKeyword2 )
                    {
                    // InternalTwoParametersTestLanguage.g:786:4: (lv_first_0_0= norm7_IdOrKeyword2 )
                    // InternalTwoParametersTestLanguage.g:787:5: lv_first_0_0= norm7_IdOrKeyword2
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getScenario7Access().getFirstIdOrKeyword2ParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=norm7_IdOrKeyword2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getScenario7Rule());
                      					}
                      					set(
                      						current,
                      						"first",
                      						lv_first_0_0,
                      						"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.IdOrKeyword2");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTwoParametersTestLanguage.g:805:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // InternalTwoParametersTestLanguage.g:805:3: ( (lv_second_1_0= 'keyword' ) )
                    // InternalTwoParametersTestLanguage.g:806:4: (lv_second_1_0= 'keyword' )
                    {
                    // InternalTwoParametersTestLanguage.g:806:4: (lv_second_1_0= 'keyword' )
                    // InternalTwoParametersTestLanguage.g:807:5: lv_second_1_0= 'keyword'
                    {
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_second_1_0, grammarAccess.getScenario7Access().getSecondKeywordKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getScenario7Rule());
                      					}
                      					setWithLastConsumed(current, "second", lv_second_1_0, "keyword");
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm3_Scenario7"


    // $ANTLR start "entryRuleScenario8"
    // InternalTwoParametersTestLanguage.g:823:1: entryRuleScenario8 returns [EObject current=null] : iv_ruleScenario8= ruleScenario8 EOF ;
    public final EObject entryRuleScenario8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario8 = null;


        try {
            // InternalTwoParametersTestLanguage.g:823:50: (iv_ruleScenario8= ruleScenario8 EOF )
            // InternalTwoParametersTestLanguage.g:824:2: iv_ruleScenario8= ruleScenario8 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario8Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario8=ruleScenario8();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario8; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScenario8"


    // $ANTLR start "ruleScenario8"
    // InternalTwoParametersTestLanguage.g:830:1: ruleScenario8 returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_second_0_0= ruleIdOrKeyword2 ) ) otherlv_1= 'keyword' ) ;
    public final EObject ruleScenario8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;



        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:836:2: ( ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_second_0_0= ruleIdOrKeyword2 ) ) otherlv_1= 'keyword' ) )
            // InternalTwoParametersTestLanguage.g:837:2: ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_second_0_0= ruleIdOrKeyword2 ) ) otherlv_1= 'keyword' )
            {
            // InternalTwoParametersTestLanguage.g:837:2: ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_second_0_0= ruleIdOrKeyword2 ) ) otherlv_1= 'keyword' )
            // InternalTwoParametersTestLanguage.g:838:3: ( ( ( ruleIdOrKeyword2 ) )=> (lv_second_0_0= ruleIdOrKeyword2 ) ) otherlv_1= 'keyword'
            {
            // InternalTwoParametersTestLanguage.g:838:3: ( ( ( ruleIdOrKeyword2 ) )=> (lv_second_0_0= ruleIdOrKeyword2 ) )
            // InternalTwoParametersTestLanguage.g:839:4: ( ( ruleIdOrKeyword2 ) )=> (lv_second_0_0= ruleIdOrKeyword2 )
            {
            // InternalTwoParametersTestLanguage.g:843:4: (lv_second_0_0= ruleIdOrKeyword2 )
            // InternalTwoParametersTestLanguage.g:844:5: lv_second_0_0= ruleIdOrKeyword2
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getScenario8Access().getSecondIdOrKeyword2ParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=ruleIdOrKeyword2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getScenario8Rule());
              					}
              					set(
              						current,
              						"second",
              						lv_second_0_0,
              						"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.IdOrKeyword2");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getScenario8Access().getKeywordKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleScenario8"


    // $ANTLR start "norm3_Scenario8"
    // InternalTwoParametersTestLanguage.g:870:1: norm3_Scenario8 returns [EObject current=null] : ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_second_0_0= norm7_IdOrKeyword2 ) ) otherlv_1= 'keyword' ) ;
    public final EObject norm3_Scenario8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;



        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:876:2: ( ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_second_0_0= norm7_IdOrKeyword2 ) ) otherlv_1= 'keyword' ) )
            // InternalTwoParametersTestLanguage.g:877:2: ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_second_0_0= norm7_IdOrKeyword2 ) ) otherlv_1= 'keyword' )
            {
            // InternalTwoParametersTestLanguage.g:877:2: ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_second_0_0= norm7_IdOrKeyword2 ) ) otherlv_1= 'keyword' )
            // InternalTwoParametersTestLanguage.g:878:3: ( ( ( norm7_IdOrKeyword2 ) )=> (lv_second_0_0= norm7_IdOrKeyword2 ) ) otherlv_1= 'keyword'
            {
            // InternalTwoParametersTestLanguage.g:878:3: ( ( ( norm7_IdOrKeyword2 ) )=> (lv_second_0_0= norm7_IdOrKeyword2 ) )
            // InternalTwoParametersTestLanguage.g:879:4: ( ( norm7_IdOrKeyword2 ) )=> (lv_second_0_0= norm7_IdOrKeyword2 )
            {
            // InternalTwoParametersTestLanguage.g:883:4: (lv_second_0_0= norm7_IdOrKeyword2 )
            // InternalTwoParametersTestLanguage.g:884:5: lv_second_0_0= norm7_IdOrKeyword2
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getScenario8Access().getSecondIdOrKeyword2ParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=norm7_IdOrKeyword2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getScenario8Rule());
              					}
              					set(
              						current,
              						"second",
              						lv_second_0_0,
              						"org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage.IdOrKeyword2");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getScenario8Access().getKeywordKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm3_Scenario8"


    // $ANTLR start "entryRuleIdOrKeyword2"
    // InternalTwoParametersTestLanguage.g:909:1: entryRuleIdOrKeyword2 returns [String current=null] : iv_ruleIdOrKeyword2= ruleIdOrKeyword2 EOF ;
    public final String entryRuleIdOrKeyword2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword2 = null;


        try {
            // InternalTwoParametersTestLanguage.g:909:52: (iv_ruleIdOrKeyword2= ruleIdOrKeyword2 EOF )
            // InternalTwoParametersTestLanguage.g:910:2: iv_ruleIdOrKeyword2= ruleIdOrKeyword2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrKeyword2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdOrKeyword2=ruleIdOrKeyword2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKeyword2.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIdOrKeyword2"


    // $ANTLR start "ruleIdOrKeyword2"
    // InternalTwoParametersTestLanguage.g:916:1: ruleIdOrKeyword2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:922:2: (this_ID_0= RULE_ID )
            // InternalTwoParametersTestLanguage.g:923:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_ID_0, grammarAccess.getIdOrKeyword2Access().getIDTerminalRuleCall_1());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIdOrKeyword2"


    // $ANTLR start "norm1_IdOrKeyword2"
    // InternalTwoParametersTestLanguage.g:934:1: norm1_IdOrKeyword2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken norm1_IdOrKeyword2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:940:2: (this_ID_0= RULE_ID )
            // InternalTwoParametersTestLanguage.g:941:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_ID_0, grammarAccess.getIdOrKeyword2Access().getIDTerminalRuleCall_1());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_IdOrKeyword2"


    // $ANTLR start "norm2_IdOrKeyword2"
    // InternalTwoParametersTestLanguage.g:952:1: norm2_IdOrKeyword2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken norm2_IdOrKeyword2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:958:2: (this_ID_0= RULE_ID )
            // InternalTwoParametersTestLanguage.g:959:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_ID_0, grammarAccess.getIdOrKeyword2Access().getIDTerminalRuleCall_1());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm2_IdOrKeyword2"


    // $ANTLR start "norm5_IdOrKeyword2"
    // InternalTwoParametersTestLanguage.g:970:1: norm5_IdOrKeyword2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken norm5_IdOrKeyword2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:976:2: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // InternalTwoParametersTestLanguage.g:977:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // InternalTwoParametersTestLanguage.g:977:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalTwoParametersTestLanguage.g:978:3: kw= 'keyword'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdOrKeyword2Access().getKeywordKeyword_0_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTwoParametersTestLanguage.g:984:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_1, grammarAccess.getIdOrKeyword2Access().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm5_IdOrKeyword2"


    // $ANTLR start "norm6_IdOrKeyword2"
    // InternalTwoParametersTestLanguage.g:996:1: norm6_IdOrKeyword2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken norm6_IdOrKeyword2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:1002:2: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // InternalTwoParametersTestLanguage.g:1003:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // InternalTwoParametersTestLanguage.g:1003:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalTwoParametersTestLanguage.g:1004:3: kw= 'keyword'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdOrKeyword2Access().getKeywordKeyword_0_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTwoParametersTestLanguage.g:1010:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_1, grammarAccess.getIdOrKeyword2Access().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm6_IdOrKeyword2"


    // $ANTLR start "norm7_IdOrKeyword2"
    // InternalTwoParametersTestLanguage.g:1022:1: norm7_IdOrKeyword2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken norm7_IdOrKeyword2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:1028:2: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // InternalTwoParametersTestLanguage.g:1029:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // InternalTwoParametersTestLanguage.g:1029:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalTwoParametersTestLanguage.g:1030:3: kw= 'keyword'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdOrKeyword2Access().getKeywordKeyword_0_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTwoParametersTestLanguage.g:1036:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_1, grammarAccess.getIdOrKeyword2Access().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm7_IdOrKeyword2"


    // $ANTLR start "entryRuleIdOrKeyword"
    // InternalTwoParametersTestLanguage.g:1047:1: entryRuleIdOrKeyword returns [String current=null] : iv_ruleIdOrKeyword= ruleIdOrKeyword EOF ;
    public final String entryRuleIdOrKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword = null;


        try {
            // InternalTwoParametersTestLanguage.g:1047:51: (iv_ruleIdOrKeyword= ruleIdOrKeyword EOF )
            // InternalTwoParametersTestLanguage.g:1048:2: iv_ruleIdOrKeyword= ruleIdOrKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrKeywordRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdOrKeyword=ruleIdOrKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKeyword.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIdOrKeyword"


    // $ANTLR start "ruleIdOrKeyword"
    // InternalTwoParametersTestLanguage.g:1054:1: ruleIdOrKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:1060:2: (this_ID_0= RULE_ID )
            // InternalTwoParametersTestLanguage.g:1061:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_ID_0, grammarAccess.getIdOrKeywordAccess().getIDTerminalRuleCall_1());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIdOrKeyword"


    // $ANTLR start "norm1_IdOrKeyword"
    // InternalTwoParametersTestLanguage.g:1072:1: norm1_IdOrKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken norm1_IdOrKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalTwoParametersTestLanguage.g:1078:2: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // InternalTwoParametersTestLanguage.g:1079:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // InternalTwoParametersTestLanguage.g:1079:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalTwoParametersTestLanguage.g:1080:3: kw= 'keyword'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdOrKeywordAccess().getKeywordKeyword_0_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTwoParametersTestLanguage.g:1086:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_1, grammarAccess.getIdOrKeywordAccess().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_IdOrKeyword"

    // $ANTLR start synpred1_InternalTwoParametersTestLanguage
    public final void synpred1_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalTwoParametersTestLanguage.g:192:5: ( ( '#5' ( ( norm3_Scenario6 ) ) ) )
        // InternalTwoParametersTestLanguage.g:192:6: ( '#5' ( ( norm3_Scenario6 ) ) )
        {
        // InternalTwoParametersTestLanguage.g:192:6: ( '#5' ( ( norm3_Scenario6 ) ) )
        // InternalTwoParametersTestLanguage.g:193:6: '#5' ( ( norm3_Scenario6 ) )
        {
        match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // InternalTwoParametersTestLanguage.g:194:6: ( ( norm3_Scenario6 ) )
        // InternalTwoParametersTestLanguage.g:195:7: ( norm3_Scenario6 )
        {
        // InternalTwoParametersTestLanguage.g:195:7: ( norm3_Scenario6 )
        // InternalTwoParametersTestLanguage.g:196:8: norm3_Scenario6
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm3_Scenario6();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalTwoParametersTestLanguage

    // $ANTLR start synpred2_InternalTwoParametersTestLanguage
    public final void synpred2_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalTwoParametersTestLanguage.g:229:5: ( ( '#6' ( ( ruleScenario6 ) ) ) )
        // InternalTwoParametersTestLanguage.g:229:6: ( '#6' ( ( ruleScenario6 ) ) )
        {
        // InternalTwoParametersTestLanguage.g:229:6: ( '#6' ( ( ruleScenario6 ) ) )
        // InternalTwoParametersTestLanguage.g:230:6: '#6' ( ( ruleScenario6 ) )
        {
        match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
        // InternalTwoParametersTestLanguage.g:231:6: ( ( ruleScenario6 ) )
        // InternalTwoParametersTestLanguage.g:232:7: ( ruleScenario6 )
        {
        // InternalTwoParametersTestLanguage.g:232:7: ( ruleScenario6 )
        // InternalTwoParametersTestLanguage.g:233:8: ruleScenario6
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleScenario6();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalTwoParametersTestLanguage

    // $ANTLR start synpred3_InternalTwoParametersTestLanguage
    public final void synpred3_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalTwoParametersTestLanguage.g:324:7: ( ( norm7_IdOrKeyword2 ) )
        // InternalTwoParametersTestLanguage.g:324:8: ( norm7_IdOrKeyword2 )
        {
        // InternalTwoParametersTestLanguage.g:324:8: ( norm7_IdOrKeyword2 )
        // InternalTwoParametersTestLanguage.g:325:8: norm7_IdOrKeyword2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm7_IdOrKeyword2();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalTwoParametersTestLanguage

    // $ANTLR start synpred4_InternalTwoParametersTestLanguage
    public final void synpred4_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalTwoParametersTestLanguage.g:384:7: ( ( norm7_IdOrKeyword2 ) )
        // InternalTwoParametersTestLanguage.g:384:8: ( norm7_IdOrKeyword2 )
        {
        // InternalTwoParametersTestLanguage.g:384:8: ( norm7_IdOrKeyword2 )
        // InternalTwoParametersTestLanguage.g:385:8: norm7_IdOrKeyword2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm7_IdOrKeyword2();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalTwoParametersTestLanguage

    // $ANTLR start synpred5_InternalTwoParametersTestLanguage
    public final void synpred5_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalTwoParametersTestLanguage.g:444:7: ( ( ruleIdOrKeyword2 ) )
        // InternalTwoParametersTestLanguage.g:444:8: ( ruleIdOrKeyword2 )
        {
        // InternalTwoParametersTestLanguage.g:444:8: ( ruleIdOrKeyword2 )
        // InternalTwoParametersTestLanguage.g:445:8: ruleIdOrKeyword2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword2();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalTwoParametersTestLanguage

    // $ANTLR start synpred6_InternalTwoParametersTestLanguage
    public final void synpred6_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalTwoParametersTestLanguage.g:504:7: ( ( ruleIdOrKeyword2 ) )
        // InternalTwoParametersTestLanguage.g:504:8: ( ruleIdOrKeyword2 )
        {
        // InternalTwoParametersTestLanguage.g:504:8: ( ruleIdOrKeyword2 )
        // InternalTwoParametersTestLanguage.g:505:8: ruleIdOrKeyword2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword2();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalTwoParametersTestLanguage

    // $ANTLR start synpred7_InternalTwoParametersTestLanguage
    public final void synpred7_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalTwoParametersTestLanguage.g:731:4: ( ( norm2_IdOrKeyword2 ) )
        // InternalTwoParametersTestLanguage.g:731:5: ( norm2_IdOrKeyword2 )
        {
        // InternalTwoParametersTestLanguage.g:731:5: ( norm2_IdOrKeyword2 )
        // InternalTwoParametersTestLanguage.g:732:5: norm2_IdOrKeyword2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm2_IdOrKeyword2();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalTwoParametersTestLanguage

    // $ANTLR start synpred8_InternalTwoParametersTestLanguage
    public final void synpred8_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalTwoParametersTestLanguage.g:782:4: ( ( norm7_IdOrKeyword2 ) )
        // InternalTwoParametersTestLanguage.g:782:5: ( norm7_IdOrKeyword2 )
        {
        // InternalTwoParametersTestLanguage.g:782:5: ( norm7_IdOrKeyword2 )
        // InternalTwoParametersTestLanguage.g:783:5: norm7_IdOrKeyword2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm7_IdOrKeyword2();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalTwoParametersTestLanguage

    // Delegated rules

    public final boolean synpred2_InternalTwoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalTwoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalTwoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalTwoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalTwoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalTwoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalTwoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalTwoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalTwoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalTwoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalTwoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalTwoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalTwoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalTwoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalTwoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalTwoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\13\14\uffff";
    static final String dfa_3s = "\1\27\14\uffff";
    static final String dfa_4s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14";
    static final String dfa_5s = "\1\0\14\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\12\1\13\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "86:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm3_Scenario5 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm3_Scenario6 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= norm2_Scenario6 ) ) ) | ( ( ( '#5' ( ( norm3_Scenario6 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm3_Scenario6 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm3_Scenario7 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= norm2_Scenario7 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_18_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_19_0= norm3_Scenario6 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm7_IdOrKeyword2 ) )=> (lv_scenario_22_0= norm3_Scenario8 ) ) | ( ( (lv_scenario_23_0= ruleScenario6 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_26_0= ruleScenario8 ) ) | ( ( (lv_scenario_27_0= norm3_Scenario6 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2 ) )=> (lv_scenario_30_0= ruleScenario8 ) ) | ( ( (lv_scenario_31_0= ruleScenario6 ) ) (otherlv_32= 'keyword' )? ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_0 = input.LA(1);

                         
                        int index9_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA9_0==11) ) {s = 1;}

                        else if ( (LA9_0==12) ) {s = 2;}

                        else if ( (LA9_0==13) ) {s = 3;}

                        else if ( (LA9_0==14) ) {s = 4;}

                        else if ( (LA9_0==15) && (synpred1_InternalTwoParametersTestLanguage())) {s = 5;}

                        else if ( (LA9_0==16) && (synpred2_InternalTwoParametersTestLanguage())) {s = 6;}

                        else if ( (LA9_0==17) ) {s = 7;}

                        else if ( (LA9_0==18) ) {s = 8;}

                        else if ( (LA9_0==19) ) {s = 9;}

                        else if ( (LA9_0==21) ) {s = 10;}

                        else if ( (LA9_0==22) ) {s = 11;}

                        else if ( (LA9_0==23) ) {s = 12;}

                         
                        input.seek(index9_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000100000L});
    }


}