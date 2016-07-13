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
import org.eclipse.xtext.parser.parameters.services.ParametersTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalParametersTestLanguageParser extends AbstractInternalAntlrParser {
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


        public InternalParametersTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalParametersTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalParametersTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalParametersTestLanguage.g"; }



     	private ParametersTestLanguageGrammarAccess grammarAccess;

        public InternalParametersTestLanguageParser(TokenStream input, ParametersTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ParserRuleParameters";
       	}

       	@Override
       	protected ParametersTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleParserRuleParameters"
    // InternalParametersTestLanguage.g:64:1: entryRuleParserRuleParameters returns [EObject current=null] : iv_ruleParserRuleParameters= ruleParserRuleParameters EOF ;
    public final EObject entryRuleParserRuleParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleParameters = null;


        try {
            // InternalParametersTestLanguage.g:64:61: (iv_ruleParserRuleParameters= ruleParserRuleParameters EOF )
            // InternalParametersTestLanguage.g:65:2: iv_ruleParserRuleParameters= ruleParserRuleParameters EOF
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
    // InternalParametersTestLanguage.g:71:1: ruleParserRuleParameters returns [EObject current=null] : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
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
            // InternalParametersTestLanguage.g:77:2: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // InternalParametersTestLanguage.g:78:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // InternalParametersTestLanguage.g:78:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // InternalParametersTestLanguage.g:79:3: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // InternalParametersTestLanguage.g:79:3: ()
            // InternalParametersTestLanguage.g:80:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParserRuleParametersAccess().getParserRuleParametersAction_0(),
              					current);
              			
            }

            }

            // InternalParametersTestLanguage.g:86:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalParametersTestLanguage.g:87:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    {
                    // InternalParametersTestLanguage.g:87:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    // InternalParametersTestLanguage.g:88:5: otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    {
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneKeyword_1_0_0());
                      				
                    }
                    // InternalParametersTestLanguage.g:92:5: ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    // InternalParametersTestLanguage.g:93:6: (lv_scenario_2_0= norm1_Scenario1 )
                    {
                    // InternalParametersTestLanguage.g:93:6: (lv_scenario_2_0= norm1_Scenario1 )
                    // InternalParametersTestLanguage.g:94:7: lv_scenario_2_0= norm1_Scenario1
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_0_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_2_0=norm1_Scenario1();

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
                      								"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario1");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguage.g:113:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    {
                    // InternalParametersTestLanguage.g:113:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    // InternalParametersTestLanguage.g:114:5: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) )
                    {
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitTwoKeyword_1_1_0());
                      				
                    }
                    // InternalParametersTestLanguage.g:118:5: ( (lv_scenario_4_0= ruleScenario1 ) )
                    // InternalParametersTestLanguage.g:119:6: (lv_scenario_4_0= ruleScenario1 )
                    {
                    // InternalParametersTestLanguage.g:119:6: (lv_scenario_4_0= ruleScenario1 )
                    // InternalParametersTestLanguage.g:120:7: lv_scenario_4_0= ruleScenario1
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_1_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_4_0=ruleScenario1();

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
                      								"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario1");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalParametersTestLanguage.g:139:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    {
                    // InternalParametersTestLanguage.g:139:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    // InternalParametersTestLanguage.g:140:5: otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    {
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitThreeKeyword_1_2_0());
                      				
                    }
                    // InternalParametersTestLanguage.g:144:5: ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    // InternalParametersTestLanguage.g:145:6: (lv_scenario_6_0= norm1_Scenario2 )
                    {
                    // InternalParametersTestLanguage.g:145:6: (lv_scenario_6_0= norm1_Scenario2 )
                    // InternalParametersTestLanguage.g:146:7: lv_scenario_6_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_2_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_6_0=norm1_Scenario2();

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
                      								"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalParametersTestLanguage.g:165:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    {
                    // InternalParametersTestLanguage.g:165:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    // InternalParametersTestLanguage.g:166:5: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) )
                    {
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFourKeyword_1_3_0());
                      				
                    }
                    // InternalParametersTestLanguage.g:170:5: ( (lv_scenario_8_0= ruleScenario2 ) )
                    // InternalParametersTestLanguage.g:171:6: (lv_scenario_8_0= ruleScenario2 )
                    {
                    // InternalParametersTestLanguage.g:171:6: (lv_scenario_8_0= ruleScenario2 )
                    // InternalParametersTestLanguage.g:172:7: lv_scenario_8_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_3_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_8_0=ruleScenario2();

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
                      								"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalParametersTestLanguage.g:191:4: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    {
                    // InternalParametersTestLanguage.g:191:4: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    // InternalParametersTestLanguage.g:192:5: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    {
                    // InternalParametersTestLanguage.g:201:5: (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    // InternalParametersTestLanguage.g:202:6: otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    {
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_9, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFiveKeyword_1_4_0_0());
                      					
                    }
                    // InternalParametersTestLanguage.g:206:6: ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    // InternalParametersTestLanguage.g:207:7: (lv_scenario_10_0= norm1_Scenario2 )
                    {
                    // InternalParametersTestLanguage.g:207:7: (lv_scenario_10_0= norm1_Scenario2 )
                    // InternalParametersTestLanguage.g:208:8: lv_scenario_10_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_4_0_1_0());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_10_0=norm1_Scenario2();

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
                      									"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalParametersTestLanguage.g:228:4: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    {
                    // InternalParametersTestLanguage.g:228:4: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    // InternalParametersTestLanguage.g:229:5: ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    {
                    // InternalParametersTestLanguage.g:238:5: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    // InternalParametersTestLanguage.g:239:6: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) )
                    {
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_11, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSixKeyword_1_5_0_0());
                      					
                    }
                    // InternalParametersTestLanguage.g:243:6: ( (lv_scenario_12_0= ruleScenario2 ) )
                    // InternalParametersTestLanguage.g:244:7: (lv_scenario_12_0= ruleScenario2 )
                    {
                    // InternalParametersTestLanguage.g:244:7: (lv_scenario_12_0= ruleScenario2 )
                    // InternalParametersTestLanguage.g:245:8: lv_scenario_12_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_5_0_1_0());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_12_0=ruleScenario2();

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
                      									"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalParametersTestLanguage.g:265:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    {
                    // InternalParametersTestLanguage.g:265:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    // InternalParametersTestLanguage.g:266:5: otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_13, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSevenKeyword_1_6_0());
                      				
                    }
                    // InternalParametersTestLanguage.g:270:5: ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    // InternalParametersTestLanguage.g:271:6: (lv_scenario_14_0= norm1_Scenario3 )
                    {
                    // InternalParametersTestLanguage.g:271:6: (lv_scenario_14_0= norm1_Scenario3 )
                    // InternalParametersTestLanguage.g:272:7: lv_scenario_14_0= norm1_Scenario3
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_6_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_14_0=norm1_Scenario3();

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
                      								"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario3");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalParametersTestLanguage.g:291:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    {
                    // InternalParametersTestLanguage.g:291:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    // InternalParametersTestLanguage.g:292:5: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) )
                    {
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_15, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitEightKeyword_1_7_0());
                      				
                    }
                    // InternalParametersTestLanguage.g:296:5: ( (lv_scenario_16_0= ruleScenario3 ) )
                    // InternalParametersTestLanguage.g:297:6: (lv_scenario_16_0= ruleScenario3 )
                    {
                    // InternalParametersTestLanguage.g:297:6: (lv_scenario_16_0= ruleScenario3 )
                    // InternalParametersTestLanguage.g:298:7: lv_scenario_16_0= ruleScenario3
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_7_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_16_0=ruleScenario3();

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
                      								"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario3");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalParametersTestLanguage.g:317:4: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // InternalParametersTestLanguage.g:317:4: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) )
                    // InternalParametersTestLanguage.g:318:5: otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_17, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitNineKeyword_1_8_0());
                      				
                    }
                    // InternalParametersTestLanguage.g:322:5: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==20) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==20) ) {
                            int LA2_3 = input.LA(3);

                            if ( (synpred3_InternalParametersTestLanguage()) ) {
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

                            if ( (synpred3_InternalParametersTestLanguage()) ) {
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
                            // InternalParametersTestLanguage.g:323:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            {
                            // InternalParametersTestLanguage.g:323:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            // InternalParametersTestLanguage.g:324:7: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 )
                            {
                            // InternalParametersTestLanguage.g:328:7: (lv_scenario_18_0= norm1_Scenario4 )
                            // InternalParametersTestLanguage.g:329:8: lv_scenario_18_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_8_1_0_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_18_0=norm1_Scenario4();

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
                              									"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario4");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguage.g:347:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? )
                            {
                            // InternalParametersTestLanguage.g:347:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? )
                            // InternalParametersTestLanguage.g:348:7: ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )?
                            {
                            // InternalParametersTestLanguage.g:348:7: ( (lv_scenario_19_0= norm1_Scenario2 ) )
                            // InternalParametersTestLanguage.g:349:8: (lv_scenario_19_0= norm1_Scenario2 )
                            {
                            // InternalParametersTestLanguage.g:349:8: (lv_scenario_19_0= norm1_Scenario2 )
                            // InternalParametersTestLanguage.g:350:9: lv_scenario_19_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_8_1_1_0_0());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_19_0=norm1_Scenario2();

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
                              										"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            // InternalParametersTestLanguage.g:367:7: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // InternalParametersTestLanguage.g:368:8: otherlv_20= 'keyword'
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
                    // InternalParametersTestLanguage.g:377:4: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // InternalParametersTestLanguage.g:377:4: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) )
                    // InternalParametersTestLanguage.g:378:5: otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_21, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitZeroKeyword_1_9_0());
                      				
                    }
                    // InternalParametersTestLanguage.g:382:5: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) && (synpred4_InternalParametersTestLanguage())) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_ID) ) {
                        int LA4_2 = input.LA(2);

                        if ( (LA4_2==20) ) {
                            int LA4_3 = input.LA(3);

                            if ( (synpred4_InternalParametersTestLanguage()) ) {
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
                            // InternalParametersTestLanguage.g:383:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            {
                            // InternalParametersTestLanguage.g:383:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            // InternalParametersTestLanguage.g:384:7: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 )
                            {
                            // InternalParametersTestLanguage.g:388:7: (lv_scenario_22_0= norm1_Scenario4 )
                            // InternalParametersTestLanguage.g:389:8: lv_scenario_22_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_9_1_0_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_22_0=norm1_Scenario4();

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
                              									"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario4");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguage.g:407:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? )
                            {
                            // InternalParametersTestLanguage.g:407:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? )
                            // InternalParametersTestLanguage.g:408:7: ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )?
                            {
                            // InternalParametersTestLanguage.g:408:7: ( (lv_scenario_23_0= ruleScenario2 ) )
                            // InternalParametersTestLanguage.g:409:8: (lv_scenario_23_0= ruleScenario2 )
                            {
                            // InternalParametersTestLanguage.g:409:8: (lv_scenario_23_0= ruleScenario2 )
                            // InternalParametersTestLanguage.g:410:9: lv_scenario_23_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_9_1_1_0_0());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_23_0=ruleScenario2();

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
                              										"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            // InternalParametersTestLanguage.g:427:7: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // InternalParametersTestLanguage.g:428:8: otherlv_24= 'keyword'
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
                    // InternalParametersTestLanguage.g:437:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // InternalParametersTestLanguage.g:437:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) )
                    // InternalParametersTestLanguage.g:438:5: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_25, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitOneKeyword_1_10_0());
                      				
                    }
                    // InternalParametersTestLanguage.g:442:5: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==20) ) {
                            int LA6_3 = input.LA(3);

                            if ( (synpred5_InternalParametersTestLanguage()) ) {
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
                            // InternalParametersTestLanguage.g:443:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            {
                            // InternalParametersTestLanguage.g:443:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            // InternalParametersTestLanguage.g:444:7: ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 )
                            {
                            // InternalParametersTestLanguage.g:448:7: (lv_scenario_26_0= ruleScenario4 )
                            // InternalParametersTestLanguage.g:449:8: lv_scenario_26_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_10_1_0_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_26_0=ruleScenario4();

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
                              									"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario4");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguage.g:467:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? )
                            {
                            // InternalParametersTestLanguage.g:467:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? )
                            // InternalParametersTestLanguage.g:468:7: ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )?
                            {
                            // InternalParametersTestLanguage.g:468:7: ( (lv_scenario_27_0= norm1_Scenario2 ) )
                            // InternalParametersTestLanguage.g:469:8: (lv_scenario_27_0= norm1_Scenario2 )
                            {
                            // InternalParametersTestLanguage.g:469:8: (lv_scenario_27_0= norm1_Scenario2 )
                            // InternalParametersTestLanguage.g:470:9: lv_scenario_27_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_10_1_1_0_0());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_27_0=norm1_Scenario2();

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
                              										"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            // InternalParametersTestLanguage.g:487:7: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // InternalParametersTestLanguage.g:488:8: otherlv_28= 'keyword'
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
                    // InternalParametersTestLanguage.g:497:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // InternalParametersTestLanguage.g:497:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) )
                    // InternalParametersTestLanguage.g:498:5: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_29, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitTwoKeyword_1_11_0());
                      				
                    }
                    // InternalParametersTestLanguage.g:502:5: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_2 = input.LA(3);

                            if ( (synpred6_InternalParametersTestLanguage()) ) {
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
                            // InternalParametersTestLanguage.g:503:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            {
                            // InternalParametersTestLanguage.g:503:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            // InternalParametersTestLanguage.g:504:7: ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 )
                            {
                            // InternalParametersTestLanguage.g:508:7: (lv_scenario_30_0= ruleScenario4 )
                            // InternalParametersTestLanguage.g:509:8: lv_scenario_30_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_11_1_0_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_30_0=ruleScenario4();

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
                              									"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario4");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguage.g:527:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? )
                            {
                            // InternalParametersTestLanguage.g:527:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? )
                            // InternalParametersTestLanguage.g:528:7: ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )?
                            {
                            // InternalParametersTestLanguage.g:528:7: ( (lv_scenario_31_0= ruleScenario2 ) )
                            // InternalParametersTestLanguage.g:529:8: (lv_scenario_31_0= ruleScenario2 )
                            {
                            // InternalParametersTestLanguage.g:529:8: (lv_scenario_31_0= ruleScenario2 )
                            // InternalParametersTestLanguage.g:530:9: lv_scenario_31_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_11_1_1_0_0());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_31_0=ruleScenario2();

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
                              										"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            // InternalParametersTestLanguage.g:547:7: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // InternalParametersTestLanguage.g:548:8: otherlv_32= 'keyword'
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


    // $ANTLR start "entryRuleScenario1"
    // InternalParametersTestLanguage.g:561:1: entryRuleScenario1 returns [EObject current=null] : iv_ruleScenario1= ruleScenario1 EOF ;
    public final EObject entryRuleScenario1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario1 = null;


        try {
            // InternalParametersTestLanguage.g:561:50: (iv_ruleScenario1= ruleScenario1 EOF )
            // InternalParametersTestLanguage.g:562:2: iv_ruleScenario1= ruleScenario1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario1Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario1=ruleScenario1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario1; 
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
    // $ANTLR end "entryRuleScenario1"


    // $ANTLR start "ruleScenario1"
    // InternalParametersTestLanguage.g:568:1: ruleScenario1 returns [EObject current=null] : ( (lv_second_0_0= RULE_ID ) ) ;
    public final EObject ruleScenario1() throws RecognitionException {
        EObject current = null;

        Token lv_second_0_0=null;


        	enterRule();

        try {
            // InternalParametersTestLanguage.g:574:2: ( ( (lv_second_0_0= RULE_ID ) ) )
            // InternalParametersTestLanguage.g:575:2: ( (lv_second_0_0= RULE_ID ) )
            {
            // InternalParametersTestLanguage.g:575:2: ( (lv_second_0_0= RULE_ID ) )
            // InternalParametersTestLanguage.g:576:3: (lv_second_0_0= RULE_ID )
            {
            // InternalParametersTestLanguage.g:576:3: (lv_second_0_0= RULE_ID )
            // InternalParametersTestLanguage.g:577:4: lv_second_0_0= RULE_ID
            {
            lv_second_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_second_0_0, grammarAccess.getScenario1Access().getSecondIDTerminalRuleCall_1_0_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getScenario1Rule());
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
    // $ANTLR end "ruleScenario1"


    // $ANTLR start "norm1_Scenario1"
    // InternalParametersTestLanguage.g:597:1: norm1_Scenario1 returns [EObject current=null] : ( (lv_first_0_0= RULE_ID ) ) ;
    public final EObject norm1_Scenario1() throws RecognitionException {
        EObject current = null;

        Token lv_first_0_0=null;


        	enterRule();

        try {
            // InternalParametersTestLanguage.g:603:2: ( ( (lv_first_0_0= RULE_ID ) ) )
            // InternalParametersTestLanguage.g:604:2: ( (lv_first_0_0= RULE_ID ) )
            {
            // InternalParametersTestLanguage.g:604:2: ( (lv_first_0_0= RULE_ID ) )
            // InternalParametersTestLanguage.g:605:3: (lv_first_0_0= RULE_ID )
            {
            // InternalParametersTestLanguage.g:605:3: (lv_first_0_0= RULE_ID )
            // InternalParametersTestLanguage.g:606:4: lv_first_0_0= RULE_ID
            {
            lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_first_0_0, grammarAccess.getScenario1Access().getFirstIDTerminalRuleCall_0_0_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getScenario1Rule());
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
    // $ANTLR end "norm1_Scenario1"


    // $ANTLR start "entryRuleScenario2"
    // InternalParametersTestLanguage.g:625:1: entryRuleScenario2 returns [EObject current=null] : iv_ruleScenario2= ruleScenario2 EOF ;
    public final EObject entryRuleScenario2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2 = null;


        try {
            // InternalParametersTestLanguage.g:625:50: (iv_ruleScenario2= ruleScenario2 EOF )
            // InternalParametersTestLanguage.g:626:2: iv_ruleScenario2= ruleScenario2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario2=ruleScenario2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario2; 
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
    // $ANTLR end "entryRuleScenario2"


    // $ANTLR start "ruleScenario2"
    // InternalParametersTestLanguage.g:632:1: ruleScenario2 returns [EObject current=null] : ( (lv_first_0_0= ruleIdOrKeyword ) ) ;
    public final EObject ruleScenario2() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;



        	enterRule();

        try {
            // InternalParametersTestLanguage.g:638:2: ( ( (lv_first_0_0= ruleIdOrKeyword ) ) )
            // InternalParametersTestLanguage.g:639:2: ( (lv_first_0_0= ruleIdOrKeyword ) )
            {
            // InternalParametersTestLanguage.g:639:2: ( (lv_first_0_0= ruleIdOrKeyword ) )
            // InternalParametersTestLanguage.g:640:3: (lv_first_0_0= ruleIdOrKeyword )
            {
            // InternalParametersTestLanguage.g:640:3: (lv_first_0_0= ruleIdOrKeyword )
            // InternalParametersTestLanguage.g:641:4: lv_first_0_0= ruleIdOrKeyword
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getScenario2Access().getFirstIdOrKeywordParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=ruleIdOrKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getScenario2Rule());
              				}
              				set(
              					current,
              					"first",
              					lv_first_0_0,
              					"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
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
    // $ANTLR end "ruleScenario2"


    // $ANTLR start "norm1_Scenario2"
    // InternalParametersTestLanguage.g:662:1: norm1_Scenario2 returns [EObject current=null] : ( (lv_first_0_0= norm1_IdOrKeyword ) ) ;
    public final EObject norm1_Scenario2() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;



        	enterRule();

        try {
            // InternalParametersTestLanguage.g:668:2: ( ( (lv_first_0_0= norm1_IdOrKeyword ) ) )
            // InternalParametersTestLanguage.g:669:2: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            {
            // InternalParametersTestLanguage.g:669:2: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            // InternalParametersTestLanguage.g:670:3: (lv_first_0_0= norm1_IdOrKeyword )
            {
            // InternalParametersTestLanguage.g:670:3: (lv_first_0_0= norm1_IdOrKeyword )
            // InternalParametersTestLanguage.g:671:4: lv_first_0_0= norm1_IdOrKeyword
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getScenario2Access().getFirstIdOrKeywordParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=norm1_IdOrKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getScenario2Rule());
              				}
              				set(
              					current,
              					"first",
              					lv_first_0_0,
              					"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
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
    // $ANTLR end "norm1_Scenario2"


    // $ANTLR start "entryRuleScenario3"
    // InternalParametersTestLanguage.g:691:1: entryRuleScenario3 returns [EObject current=null] : iv_ruleScenario3= ruleScenario3 EOF ;
    public final EObject entryRuleScenario3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario3 = null;


        try {
            // InternalParametersTestLanguage.g:691:50: (iv_ruleScenario3= ruleScenario3 EOF )
            // InternalParametersTestLanguage.g:692:2: iv_ruleScenario3= ruleScenario3 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario3Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario3=ruleScenario3();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario3; 
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
    // $ANTLR end "entryRuleScenario3"


    // $ANTLR start "ruleScenario3"
    // InternalParametersTestLanguage.g:698:1: ruleScenario3 returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final EObject ruleScenario3() throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;



        	enterRule();

        try {
            // InternalParametersTestLanguage.g:704:2: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // InternalParametersTestLanguage.g:705:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // InternalParametersTestLanguage.g:705:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) && (synpred7_InternalParametersTestLanguage())) {
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
                    // InternalParametersTestLanguage.g:706:3: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    {
                    // InternalParametersTestLanguage.g:706:3: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    // InternalParametersTestLanguage.g:707:4: ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword )
                    {
                    // InternalParametersTestLanguage.g:711:4: (lv_first_0_0= ruleIdOrKeyword )
                    // InternalParametersTestLanguage.g:712:5: lv_first_0_0= ruleIdOrKeyword
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getScenario3Access().getFirstIdOrKeywordParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=ruleIdOrKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getScenario3Rule());
                      					}
                      					set(
                      						current,
                      						"first",
                      						lv_first_0_0,
                      						"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguage.g:730:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // InternalParametersTestLanguage.g:730:3: ( (lv_second_1_0= 'keyword' ) )
                    // InternalParametersTestLanguage.g:731:4: (lv_second_1_0= 'keyword' )
                    {
                    // InternalParametersTestLanguage.g:731:4: (lv_second_1_0= 'keyword' )
                    // InternalParametersTestLanguage.g:732:5: lv_second_1_0= 'keyword'
                    {
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_second_1_0, grammarAccess.getScenario3Access().getSecondKeywordKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getScenario3Rule());
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
    // $ANTLR end "ruleScenario3"


    // $ANTLR start "norm1_Scenario3"
    // InternalParametersTestLanguage.g:749:1: norm1_Scenario3 returns [EObject current=null] : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final EObject norm1_Scenario3() throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;



        	enterRule();

        try {
            // InternalParametersTestLanguage.g:755:2: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // InternalParametersTestLanguage.g:756:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // InternalParametersTestLanguage.g:756:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred8_InternalParametersTestLanguage()) ) {
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
            else if ( (LA11_0==RULE_ID) && (synpred8_InternalParametersTestLanguage())) {
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
                    // InternalParametersTestLanguage.g:757:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    {
                    // InternalParametersTestLanguage.g:757:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    // InternalParametersTestLanguage.g:758:4: ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword )
                    {
                    // InternalParametersTestLanguage.g:762:4: (lv_first_0_0= norm1_IdOrKeyword )
                    // InternalParametersTestLanguage.g:763:5: lv_first_0_0= norm1_IdOrKeyword
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getScenario3Access().getFirstIdOrKeywordParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=norm1_IdOrKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getScenario3Rule());
                      					}
                      					set(
                      						current,
                      						"first",
                      						lv_first_0_0,
                      						"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguage.g:781:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // InternalParametersTestLanguage.g:781:3: ( (lv_second_1_0= 'keyword' ) )
                    // InternalParametersTestLanguage.g:782:4: (lv_second_1_0= 'keyword' )
                    {
                    // InternalParametersTestLanguage.g:782:4: (lv_second_1_0= 'keyword' )
                    // InternalParametersTestLanguage.g:783:5: lv_second_1_0= 'keyword'
                    {
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_second_1_0, grammarAccess.getScenario3Access().getSecondKeywordKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getScenario3Rule());
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
    // $ANTLR end "norm1_Scenario3"


    // $ANTLR start "entryRuleScenario4"
    // InternalParametersTestLanguage.g:799:1: entryRuleScenario4 returns [EObject current=null] : iv_ruleScenario4= ruleScenario4 EOF ;
    public final EObject entryRuleScenario4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario4 = null;


        try {
            // InternalParametersTestLanguage.g:799:50: (iv_ruleScenario4= ruleScenario4 EOF )
            // InternalParametersTestLanguage.g:800:2: iv_ruleScenario4= ruleScenario4 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario4Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario4=ruleScenario4();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario4; 
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
    // $ANTLR end "entryRuleScenario4"


    // $ANTLR start "ruleScenario4"
    // InternalParametersTestLanguage.g:806:1: ruleScenario4 returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' ) ;
    public final EObject ruleScenario4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;



        	enterRule();

        try {
            // InternalParametersTestLanguage.g:812:2: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' ) )
            // InternalParametersTestLanguage.g:813:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' )
            {
            // InternalParametersTestLanguage.g:813:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' )
            // InternalParametersTestLanguage.g:814:3: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword'
            {
            // InternalParametersTestLanguage.g:814:3: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) )
            // InternalParametersTestLanguage.g:815:4: ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword )
            {
            // InternalParametersTestLanguage.g:819:4: (lv_second_0_0= ruleIdOrKeyword )
            // InternalParametersTestLanguage.g:820:5: lv_second_0_0= ruleIdOrKeyword
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=ruleIdOrKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getScenario4Rule());
              					}
              					set(
              						current,
              						"second",
              						lv_second_0_0,
              						"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getScenario4Access().getKeywordKeyword_1());
              		
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
    // $ANTLR end "ruleScenario4"


    // $ANTLR start "norm1_Scenario4"
    // InternalParametersTestLanguage.g:846:1: norm1_Scenario4 returns [EObject current=null] : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' ) ;
    public final EObject norm1_Scenario4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;



        	enterRule();

        try {
            // InternalParametersTestLanguage.g:852:2: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' ) )
            // InternalParametersTestLanguage.g:853:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' )
            {
            // InternalParametersTestLanguage.g:853:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' )
            // InternalParametersTestLanguage.g:854:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword'
            {
            // InternalParametersTestLanguage.g:854:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) )
            // InternalParametersTestLanguage.g:855:4: ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword )
            {
            // InternalParametersTestLanguage.g:859:4: (lv_second_0_0= norm1_IdOrKeyword )
            // InternalParametersTestLanguage.g:860:5: lv_second_0_0= norm1_IdOrKeyword
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=norm1_IdOrKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getScenario4Rule());
              					}
              					set(
              						current,
              						"second",
              						lv_second_0_0,
              						"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getScenario4Access().getKeywordKeyword_1());
              		
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
    // $ANTLR end "norm1_Scenario4"


    // $ANTLR start "entryRuleIdOrKeyword"
    // InternalParametersTestLanguage.g:885:1: entryRuleIdOrKeyword returns [String current=null] : iv_ruleIdOrKeyword= ruleIdOrKeyword EOF ;
    public final String entryRuleIdOrKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword = null;


        try {
            // InternalParametersTestLanguage.g:885:51: (iv_ruleIdOrKeyword= ruleIdOrKeyword EOF )
            // InternalParametersTestLanguage.g:886:2: iv_ruleIdOrKeyword= ruleIdOrKeyword EOF
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
    // InternalParametersTestLanguage.g:892:1: ruleIdOrKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalParametersTestLanguage.g:898:2: (this_ID_0= RULE_ID )
            // InternalParametersTestLanguage.g:899:2: this_ID_0= RULE_ID
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
    // InternalParametersTestLanguage.g:910:1: norm1_IdOrKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken norm1_IdOrKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalParametersTestLanguage.g:916:2: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // InternalParametersTestLanguage.g:917:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // InternalParametersTestLanguage.g:917:2: (kw= 'keyword' | this_ID_1= RULE_ID )
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
                    // InternalParametersTestLanguage.g:918:3: kw= 'keyword'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdOrKeywordAccess().getKeywordKeyword_0_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguage.g:924:3: this_ID_1= RULE_ID
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

    // $ANTLR start synpred1_InternalParametersTestLanguage
    public final void synpred1_InternalParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalParametersTestLanguage.g:192:5: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )
        // InternalParametersTestLanguage.g:192:6: ( '#5' ( ( norm1_Scenario2 ) ) )
        {
        // InternalParametersTestLanguage.g:192:6: ( '#5' ( ( norm1_Scenario2 ) ) )
        // InternalParametersTestLanguage.g:193:6: '#5' ( ( norm1_Scenario2 ) )
        {
        match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // InternalParametersTestLanguage.g:194:6: ( ( norm1_Scenario2 ) )
        // InternalParametersTestLanguage.g:195:7: ( norm1_Scenario2 )
        {
        // InternalParametersTestLanguage.g:195:7: ( norm1_Scenario2 )
        // InternalParametersTestLanguage.g:196:8: norm1_Scenario2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_Scenario2();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalParametersTestLanguage

    // $ANTLR start synpred2_InternalParametersTestLanguage
    public final void synpred2_InternalParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalParametersTestLanguage.g:229:5: ( ( '#6' ( ( ruleScenario2 ) ) ) )
        // InternalParametersTestLanguage.g:229:6: ( '#6' ( ( ruleScenario2 ) ) )
        {
        // InternalParametersTestLanguage.g:229:6: ( '#6' ( ( ruleScenario2 ) ) )
        // InternalParametersTestLanguage.g:230:6: '#6' ( ( ruleScenario2 ) )
        {
        match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
        // InternalParametersTestLanguage.g:231:6: ( ( ruleScenario2 ) )
        // InternalParametersTestLanguage.g:232:7: ( ruleScenario2 )
        {
        // InternalParametersTestLanguage.g:232:7: ( ruleScenario2 )
        // InternalParametersTestLanguage.g:233:8: ruleScenario2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleScenario2();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalParametersTestLanguage

    // $ANTLR start synpred3_InternalParametersTestLanguage
    public final void synpred3_InternalParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalParametersTestLanguage.g:324:7: ( ( norm1_IdOrKeyword ) )
        // InternalParametersTestLanguage.g:324:8: ( norm1_IdOrKeyword )
        {
        // InternalParametersTestLanguage.g:324:8: ( norm1_IdOrKeyword )
        // InternalParametersTestLanguage.g:325:8: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalParametersTestLanguage

    // $ANTLR start synpred4_InternalParametersTestLanguage
    public final void synpred4_InternalParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalParametersTestLanguage.g:384:7: ( ( norm1_IdOrKeyword ) )
        // InternalParametersTestLanguage.g:384:8: ( norm1_IdOrKeyword )
        {
        // InternalParametersTestLanguage.g:384:8: ( norm1_IdOrKeyword )
        // InternalParametersTestLanguage.g:385:8: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalParametersTestLanguage

    // $ANTLR start synpred5_InternalParametersTestLanguage
    public final void synpred5_InternalParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalParametersTestLanguage.g:444:7: ( ( ruleIdOrKeyword ) )
        // InternalParametersTestLanguage.g:444:8: ( ruleIdOrKeyword )
        {
        // InternalParametersTestLanguage.g:444:8: ( ruleIdOrKeyword )
        // InternalParametersTestLanguage.g:445:8: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalParametersTestLanguage

    // $ANTLR start synpred6_InternalParametersTestLanguage
    public final void synpred6_InternalParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalParametersTestLanguage.g:504:7: ( ( ruleIdOrKeyword ) )
        // InternalParametersTestLanguage.g:504:8: ( ruleIdOrKeyword )
        {
        // InternalParametersTestLanguage.g:504:8: ( ruleIdOrKeyword )
        // InternalParametersTestLanguage.g:505:8: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalParametersTestLanguage

    // $ANTLR start synpred7_InternalParametersTestLanguage
    public final void synpred7_InternalParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalParametersTestLanguage.g:707:4: ( ( ruleIdOrKeyword ) )
        // InternalParametersTestLanguage.g:707:5: ( ruleIdOrKeyword )
        {
        // InternalParametersTestLanguage.g:707:5: ( ruleIdOrKeyword )
        // InternalParametersTestLanguage.g:708:5: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalParametersTestLanguage

    // $ANTLR start synpred8_InternalParametersTestLanguage
    public final void synpred8_InternalParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalParametersTestLanguage.g:758:4: ( ( norm1_IdOrKeyword ) )
        // InternalParametersTestLanguage.g:758:5: ( norm1_IdOrKeyword )
        {
        // InternalParametersTestLanguage.g:758:5: ( norm1_IdOrKeyword )
        // InternalParametersTestLanguage.g:759:5: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalParametersTestLanguage

    // Delegated rules

    public final boolean synpred8_InternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalParametersTestLanguage_fragment(); // can never throw exception
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
            return "86:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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

                        else if ( (LA9_0==15) && (synpred1_InternalParametersTestLanguage())) {s = 5;}

                        else if ( (LA9_0==16) && (synpred2_InternalParametersTestLanguage())) {s = 6;}

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