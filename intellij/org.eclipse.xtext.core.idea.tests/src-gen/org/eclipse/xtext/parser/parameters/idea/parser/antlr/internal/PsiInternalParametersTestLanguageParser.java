package org.eclipse.xtext.parser.parameters.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.parameters.services.ParametersTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalParametersTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#6'", "'#7'", "'#8'", "'#9'", "'keyword'", "'#10'", "'#11'", "'#12'"
    };
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalParametersTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalParametersTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalParametersTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalParametersTestLanguage.g"; }



    	protected ParametersTestLanguageGrammarAccess grammarAccess;

    	protected ParametersTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalParametersTestLanguageParser(PsiBuilder builder, TokenStream input, ParametersTestLanguageElementTypeProvider elementTypeProvider, ParametersTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "ParserRuleParameters";
    	}




    // $ANTLR start "entryRuleParserRuleParameters"
    // PsiInternalParametersTestLanguage.g:52:1: entryRuleParserRuleParameters : ruleParserRuleParameters EOF ;
    public final void entryRuleParserRuleParameters() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguage.g:52:30: ( ruleParserRuleParameters EOF )
            // PsiInternalParametersTestLanguage.g:53:2: ruleParserRuleParameters EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParserRuleParametersElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParserRuleParameters();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParserRuleParameters"


    // $ANTLR start "ruleParserRuleParameters"
    // PsiInternalParametersTestLanguage.g:58:1: ruleParserRuleParameters : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
    public final void ruleParserRuleParameters() throws RecognitionException {
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

        try {
            // PsiInternalParametersTestLanguage.g:58:25: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // PsiInternalParametersTestLanguage.g:59:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // PsiInternalParametersTestLanguage.g:59:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // PsiInternalParametersTestLanguage.g:60:3: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // PsiInternalParametersTestLanguage.g:60:3: ()
            // PsiInternalParametersTestLanguage.g:61:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParserRuleParameters_ParserRuleParametersAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalParametersTestLanguage.g:66:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // PsiInternalParametersTestLanguage.g:67:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:67:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    // PsiInternalParametersTestLanguage.g:68:5: otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalParametersTestLanguage.g:75:5: ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    // PsiInternalParametersTestLanguage.g:76:6: (lv_scenario_2_0= norm1_Scenario1 )
                    {
                    // PsiInternalParametersTestLanguage.g:76:6: (lv_scenario_2_0= norm1_Scenario1 )
                    // PsiInternalParametersTestLanguage.g:77:7: lv_scenario_2_0= norm1_Scenario1
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario1ParserRuleCall_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    norm1_Scenario1();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalParametersTestLanguage.g:88:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:88:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    // PsiInternalParametersTestLanguage.g:89:5: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // PsiInternalParametersTestLanguage.g:96:5: ( (lv_scenario_4_0= ruleScenario1 ) )
                    // PsiInternalParametersTestLanguage.g:97:6: (lv_scenario_4_0= ruleScenario1 )
                    {
                    // PsiInternalParametersTestLanguage.g:97:6: (lv_scenario_4_0= ruleScenario1 )
                    // PsiInternalParametersTestLanguage.g:98:7: lv_scenario_4_0= ruleScenario1
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario1ParserRuleCall_1_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleScenario1();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalParametersTestLanguage.g:109:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:109:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    // PsiInternalParametersTestLanguage.g:110:5: otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_5);
                      				
                    }
                    // PsiInternalParametersTestLanguage.g:117:5: ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    // PsiInternalParametersTestLanguage.g:118:6: (lv_scenario_6_0= norm1_Scenario2 )
                    {
                    // PsiInternalParametersTestLanguage.g:118:6: (lv_scenario_6_0= norm1_Scenario2 )
                    // PsiInternalParametersTestLanguage.g:119:7: lv_scenario_6_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_2_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    norm1_Scenario2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalParametersTestLanguage.g:130:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:130:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    // PsiInternalParametersTestLanguage.g:131:5: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // PsiInternalParametersTestLanguage.g:138:5: ( (lv_scenario_8_0= ruleScenario2 ) )
                    // PsiInternalParametersTestLanguage.g:139:6: (lv_scenario_8_0= ruleScenario2 )
                    {
                    // PsiInternalParametersTestLanguage.g:139:6: (lv_scenario_8_0= ruleScenario2 )
                    // PsiInternalParametersTestLanguage.g:140:7: lv_scenario_8_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_3_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleScenario2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalParametersTestLanguage.g:151:4: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:151:4: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    // PsiInternalParametersTestLanguage.g:152:5: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:161:5: (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    // PsiInternalParametersTestLanguage.g:162:6: otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFiveKeyword_1_4_0_0ElementType());
                      					
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_9);
                      					
                    }
                    // PsiInternalParametersTestLanguage.g:169:6: ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    // PsiInternalParametersTestLanguage.g:170:7: (lv_scenario_10_0= norm1_Scenario2 )
                    {
                    // PsiInternalParametersTestLanguage.g:170:7: (lv_scenario_10_0= norm1_Scenario2 )
                    // PsiInternalParametersTestLanguage.g:171:8: lv_scenario_10_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_4_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    norm1_Scenario2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalParametersTestLanguage.g:183:4: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:183:4: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    // PsiInternalParametersTestLanguage.g:184:5: ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:193:5: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    // PsiInternalParametersTestLanguage.g:194:6: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSixKeyword_1_5_0_0ElementType());
                      					
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_11);
                      					
                    }
                    // PsiInternalParametersTestLanguage.g:201:6: ( (lv_scenario_12_0= ruleScenario2 ) )
                    // PsiInternalParametersTestLanguage.g:202:7: (lv_scenario_12_0= ruleScenario2 )
                    {
                    // PsiInternalParametersTestLanguage.g:202:7: (lv_scenario_12_0= ruleScenario2 )
                    // PsiInternalParametersTestLanguage.g:203:8: lv_scenario_12_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_5_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleScenario2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalParametersTestLanguage.g:215:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:215:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    // PsiInternalParametersTestLanguage.g:216:5: otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSevenKeyword_1_6_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // PsiInternalParametersTestLanguage.g:223:5: ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    // PsiInternalParametersTestLanguage.g:224:6: (lv_scenario_14_0= norm1_Scenario3 )
                    {
                    // PsiInternalParametersTestLanguage.g:224:6: (lv_scenario_14_0= norm1_Scenario3 )
                    // PsiInternalParametersTestLanguage.g:225:7: lv_scenario_14_0= norm1_Scenario3
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario3ParserRuleCall_1_6_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    norm1_Scenario3();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalParametersTestLanguage.g:236:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:236:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    // PsiInternalParametersTestLanguage.g:237:5: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitEightKeyword_1_7_0ElementType());
                      				
                    }
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_15);
                      				
                    }
                    // PsiInternalParametersTestLanguage.g:244:5: ( (lv_scenario_16_0= ruleScenario3 ) )
                    // PsiInternalParametersTestLanguage.g:245:6: (lv_scenario_16_0= ruleScenario3 )
                    {
                    // PsiInternalParametersTestLanguage.g:245:6: (lv_scenario_16_0= ruleScenario3 )
                    // PsiInternalParametersTestLanguage.g:246:7: lv_scenario_16_0= ruleScenario3
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario3ParserRuleCall_1_7_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleScenario3();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // PsiInternalParametersTestLanguage.g:257:4: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:257:4: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguage.g:258:5: otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitNineKeyword_1_8_0ElementType());
                      				
                    }
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_17);
                      				
                    }
                    // PsiInternalParametersTestLanguage.g:265:5: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==20) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==20) ) {
                            int LA2_3 = input.LA(3);

                            if ( (synpred3_PsiInternalParametersTestLanguage()) ) {
                                alt2=1;
                            }
                            else if ( (true) ) {
                                alt2=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA2_1==EOF) ) {
                            alt2=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA2_0==RULE_ID) ) {
                        int LA2_2 = input.LA(2);

                        if ( (LA2_2==20) ) {
                            int LA2_3 = input.LA(3);

                            if ( (synpred3_PsiInternalParametersTestLanguage()) ) {
                                alt2=1;
                            }
                            else if ( (true) ) {
                                alt2=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA2_2==EOF) ) {
                            alt2=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // PsiInternalParametersTestLanguage.g:266:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            {
                            // PsiInternalParametersTestLanguage.g:266:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            // PsiInternalParametersTestLanguage.g:267:7: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 )
                            {
                            // PsiInternalParametersTestLanguage.g:271:7: (lv_scenario_18_0= norm1_Scenario4 )
                            // PsiInternalParametersTestLanguage.g:272:8: lv_scenario_18_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_8_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            norm1_Scenario4();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalParametersTestLanguage.g:282:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguage.g:282:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? )
                            // PsiInternalParametersTestLanguage.g:283:7: ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguage.g:283:7: ( (lv_scenario_19_0= norm1_Scenario2 ) )
                            // PsiInternalParametersTestLanguage.g:284:8: (lv_scenario_19_0= norm1_Scenario2 )
                            {
                            // PsiInternalParametersTestLanguage.g:284:8: (lv_scenario_19_0= norm1_Scenario2 )
                            // PsiInternalParametersTestLanguage.g:285:9: lv_scenario_19_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_8_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            norm1_Scenario2();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // PsiInternalParametersTestLanguage.g:294:7: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // PsiInternalParametersTestLanguage.g:295:8: otherlv_20= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_8_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
                                    if ( state.backtracking==0 ) {

                                      								doneLeaf(otherlv_20);
                                      							
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
                    // PsiInternalParametersTestLanguage.g:307:4: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:307:4: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguage.g:308:5: otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitZeroKeyword_1_9_0ElementType());
                      				
                    }
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_21);
                      				
                    }
                    // PsiInternalParametersTestLanguage.g:315:5: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) && (synpred4_PsiInternalParametersTestLanguage())) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_ID) ) {
                        int LA4_2 = input.LA(2);

                        if ( (LA4_2==20) ) {
                            int LA4_3 = input.LA(3);

                            if ( (synpred4_PsiInternalParametersTestLanguage()) ) {
                                alt4=1;
                            }
                            else if ( (true) ) {
                                alt4=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA4_2==EOF) ) {
                            alt4=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // PsiInternalParametersTestLanguage.g:316:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            {
                            // PsiInternalParametersTestLanguage.g:316:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            // PsiInternalParametersTestLanguage.g:317:7: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 )
                            {
                            // PsiInternalParametersTestLanguage.g:321:7: (lv_scenario_22_0= norm1_Scenario4 )
                            // PsiInternalParametersTestLanguage.g:322:8: lv_scenario_22_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_9_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            norm1_Scenario4();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalParametersTestLanguage.g:332:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguage.g:332:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? )
                            // PsiInternalParametersTestLanguage.g:333:7: ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguage.g:333:7: ( (lv_scenario_23_0= ruleScenario2 ) )
                            // PsiInternalParametersTestLanguage.g:334:8: (lv_scenario_23_0= ruleScenario2 )
                            {
                            // PsiInternalParametersTestLanguage.g:334:8: (lv_scenario_23_0= ruleScenario2 )
                            // PsiInternalParametersTestLanguage.g:335:9: lv_scenario_23_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_9_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            ruleScenario2();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // PsiInternalParametersTestLanguage.g:344:7: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // PsiInternalParametersTestLanguage.g:345:8: otherlv_24= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_9_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
                                    if ( state.backtracking==0 ) {

                                      								doneLeaf(otherlv_24);
                                      							
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
                    // PsiInternalParametersTestLanguage.g:357:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:357:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguage.g:358:5: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitOneKeyword_1_10_0ElementType());
                      				
                    }
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_25);
                      				
                    }
                    // PsiInternalParametersTestLanguage.g:365:5: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==20) ) {
                            int LA6_3 = input.LA(3);

                            if ( (synpred5_PsiInternalParametersTestLanguage()) ) {
                                alt6=1;
                            }
                            else if ( (true) ) {
                                alt6=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA6_1==EOF) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA6_0==20) ) {
                        alt6=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // PsiInternalParametersTestLanguage.g:366:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            {
                            // PsiInternalParametersTestLanguage.g:366:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            // PsiInternalParametersTestLanguage.g:367:7: ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 )
                            {
                            // PsiInternalParametersTestLanguage.g:371:7: (lv_scenario_26_0= ruleScenario4 )
                            // PsiInternalParametersTestLanguage.g:372:8: lv_scenario_26_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_10_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleScenario4();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalParametersTestLanguage.g:382:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguage.g:382:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? )
                            // PsiInternalParametersTestLanguage.g:383:7: ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguage.g:383:7: ( (lv_scenario_27_0= norm1_Scenario2 ) )
                            // PsiInternalParametersTestLanguage.g:384:8: (lv_scenario_27_0= norm1_Scenario2 )
                            {
                            // PsiInternalParametersTestLanguage.g:384:8: (lv_scenario_27_0= norm1_Scenario2 )
                            // PsiInternalParametersTestLanguage.g:385:9: lv_scenario_27_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_10_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            norm1_Scenario2();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // PsiInternalParametersTestLanguage.g:394:7: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // PsiInternalParametersTestLanguage.g:395:8: otherlv_28= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_10_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_28=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
                                    if ( state.backtracking==0 ) {

                                      								doneLeaf(otherlv_28);
                                      							
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
                    // PsiInternalParametersTestLanguage.g:407:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguage.g:407:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguage.g:408:5: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitTwoKeyword_1_11_0ElementType());
                      				
                    }
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_29);
                      				
                    }
                    // PsiInternalParametersTestLanguage.g:415:5: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_2 = input.LA(3);

                            if ( (synpred6_PsiInternalParametersTestLanguage()) ) {
                                alt8=1;
                            }
                            else if ( (true) ) {
                                alt8=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 2, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA8_1==EOF) ) {
                            alt8=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // PsiInternalParametersTestLanguage.g:416:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            {
                            // PsiInternalParametersTestLanguage.g:416:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            // PsiInternalParametersTestLanguage.g:417:7: ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 )
                            {
                            // PsiInternalParametersTestLanguage.g:421:7: (lv_scenario_30_0= ruleScenario4 )
                            // PsiInternalParametersTestLanguage.g:422:8: lv_scenario_30_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_11_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleScenario4();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalParametersTestLanguage.g:432:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguage.g:432:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? )
                            // PsiInternalParametersTestLanguage.g:433:7: ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguage.g:433:7: ( (lv_scenario_31_0= ruleScenario2 ) )
                            // PsiInternalParametersTestLanguage.g:434:8: (lv_scenario_31_0= ruleScenario2 )
                            {
                            // PsiInternalParametersTestLanguage.g:434:8: (lv_scenario_31_0= ruleScenario2 )
                            // PsiInternalParametersTestLanguage.g:435:9: lv_scenario_31_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_11_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            ruleScenario2();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // PsiInternalParametersTestLanguage.g:444:7: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // PsiInternalParametersTestLanguage.g:445:8: otherlv_32= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_11_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
                                    if ( state.backtracking==0 ) {

                                      								doneLeaf(otherlv_32);
                                      							
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleParserRuleParameters"


    // $ANTLR start "entryRuleScenario1"
    // PsiInternalParametersTestLanguage.g:461:1: entryRuleScenario1 : ruleScenario1 EOF ;
    public final void entryRuleScenario1() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguage.g:461:19: ( ruleScenario1 EOF )
            // PsiInternalParametersTestLanguage.g:462:2: ruleScenario1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario1();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScenario1"


    // $ANTLR start "ruleScenario1"
    // PsiInternalParametersTestLanguage.g:467:1: ruleScenario1 : ( (lv_second_0_0= RULE_ID ) ) ;
    public final void ruleScenario1() throws RecognitionException {
        Token lv_second_0_0=null;

        try {
            // PsiInternalParametersTestLanguage.g:467:14: ( ( (lv_second_0_0= RULE_ID ) ) )
            // PsiInternalParametersTestLanguage.g:468:2: ( (lv_second_0_0= RULE_ID ) )
            {
            // PsiInternalParametersTestLanguage.g:468:2: ( (lv_second_0_0= RULE_ID ) )
            // PsiInternalParametersTestLanguage.g:469:3: (lv_second_0_0= RULE_ID )
            {
            // PsiInternalParametersTestLanguage.g:469:3: (lv_second_0_0= RULE_ID )
            // PsiInternalParametersTestLanguage.g:470:4: lv_second_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getScenario1_SecondIDTerminalRuleCall_1_0_0ElementType());
              			
            }
            lv_second_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(lv_second_0_0);
              			
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleScenario1"


    // $ANTLR start "norm1_Scenario1"
    // PsiInternalParametersTestLanguage.g:483:1: norm1_Scenario1 : ( (lv_first_0_0= RULE_ID ) ) ;
    public final void norm1_Scenario1() throws RecognitionException {
        Token lv_first_0_0=null;

        try {
            // PsiInternalParametersTestLanguage.g:483:16: ( ( (lv_first_0_0= RULE_ID ) ) )
            // PsiInternalParametersTestLanguage.g:484:2: ( (lv_first_0_0= RULE_ID ) )
            {
            // PsiInternalParametersTestLanguage.g:484:2: ( (lv_first_0_0= RULE_ID ) )
            // PsiInternalParametersTestLanguage.g:485:3: (lv_first_0_0= RULE_ID )
            {
            // PsiInternalParametersTestLanguage.g:485:3: (lv_first_0_0= RULE_ID )
            // PsiInternalParametersTestLanguage.g:486:4: lv_first_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getScenario1_FirstIDTerminalRuleCall_0_0_0ElementType());
              			
            }
            lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(lv_first_0_0);
              			
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "norm1_Scenario1"


    // $ANTLR start "entryRuleScenario2"
    // PsiInternalParametersTestLanguage.g:498:1: entryRuleScenario2 : ruleScenario2 EOF ;
    public final void entryRuleScenario2() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguage.g:498:19: ( ruleScenario2 EOF )
            // PsiInternalParametersTestLanguage.g:499:2: ruleScenario2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario2();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScenario2"


    // $ANTLR start "ruleScenario2"
    // PsiInternalParametersTestLanguage.g:504:1: ruleScenario2 : ( (lv_first_0_0= ruleIdOrKeyword ) ) ;
    public final void ruleScenario2() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguage.g:504:14: ( ( (lv_first_0_0= ruleIdOrKeyword ) ) )
            // PsiInternalParametersTestLanguage.g:505:2: ( (lv_first_0_0= ruleIdOrKeyword ) )
            {
            // PsiInternalParametersTestLanguage.g:505:2: ( (lv_first_0_0= ruleIdOrKeyword ) )
            // PsiInternalParametersTestLanguage.g:506:3: (lv_first_0_0= ruleIdOrKeyword )
            {
            // PsiInternalParametersTestLanguage.g:506:3: (lv_first_0_0= ruleIdOrKeyword )
            // PsiInternalParametersTestLanguage.g:507:4: lv_first_0_0= ruleIdOrKeyword
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getScenario2_FirstIdOrKeywordParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleIdOrKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneComposite();
              			
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleScenario2"


    // $ANTLR start "norm1_Scenario2"
    // PsiInternalParametersTestLanguage.g:520:1: norm1_Scenario2 : ( (lv_first_0_0= norm1_IdOrKeyword ) ) ;
    public final void norm1_Scenario2() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguage.g:520:16: ( ( (lv_first_0_0= norm1_IdOrKeyword ) ) )
            // PsiInternalParametersTestLanguage.g:521:2: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            {
            // PsiInternalParametersTestLanguage.g:521:2: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            // PsiInternalParametersTestLanguage.g:522:3: (lv_first_0_0= norm1_IdOrKeyword )
            {
            // PsiInternalParametersTestLanguage.g:522:3: (lv_first_0_0= norm1_IdOrKeyword )
            // PsiInternalParametersTestLanguage.g:523:4: lv_first_0_0= norm1_IdOrKeyword
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getScenario2_FirstIdOrKeywordParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            norm1_IdOrKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneComposite();
              			
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "norm1_Scenario2"


    // $ANTLR start "entryRuleScenario3"
    // PsiInternalParametersTestLanguage.g:535:1: entryRuleScenario3 : ruleScenario3 EOF ;
    public final void entryRuleScenario3() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguage.g:535:19: ( ruleScenario3 EOF )
            // PsiInternalParametersTestLanguage.g:536:2: ruleScenario3 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario3ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario3();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScenario3"


    // $ANTLR start "ruleScenario3"
    // PsiInternalParametersTestLanguage.g:541:1: ruleScenario3 : ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final void ruleScenario3() throws RecognitionException {
        Token lv_second_1_0=null;

        try {
            // PsiInternalParametersTestLanguage.g:541:14: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // PsiInternalParametersTestLanguage.g:542:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // PsiInternalParametersTestLanguage.g:542:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) && (synpred7_PsiInternalParametersTestLanguage())) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalParametersTestLanguage.g:543:3: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    {
                    // PsiInternalParametersTestLanguage.g:543:3: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    // PsiInternalParametersTestLanguage.g:544:4: ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword )
                    {
                    // PsiInternalParametersTestLanguage.g:548:4: (lv_first_0_0= ruleIdOrKeyword )
                    // PsiInternalParametersTestLanguage.g:549:5: lv_first_0_0= ruleIdOrKeyword
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getScenario3_FirstIdOrKeywordParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleIdOrKeyword();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalParametersTestLanguage.g:559:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // PsiInternalParametersTestLanguage.g:559:3: ( (lv_second_1_0= 'keyword' ) )
                    // PsiInternalParametersTestLanguage.g:560:4: (lv_second_1_0= 'keyword' )
                    {
                    // PsiInternalParametersTestLanguage.g:560:4: (lv_second_1_0= 'keyword' )
                    // PsiInternalParametersTestLanguage.g:561:5: lv_second_1_0= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getScenario3_SecondKeywordKeyword_1_0ElementType());
                      				
                    }
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_second_1_0);
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleScenario3"


    // $ANTLR start "norm1_Scenario3"
    // PsiInternalParametersTestLanguage.g:575:1: norm1_Scenario3 : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final void norm1_Scenario3() throws RecognitionException {
        Token lv_second_1_0=null;

        try {
            // PsiInternalParametersTestLanguage.g:575:16: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // PsiInternalParametersTestLanguage.g:576:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // PsiInternalParametersTestLanguage.g:576:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred8_PsiInternalParametersTestLanguage()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA11_0==RULE_ID) && (synpred8_PsiInternalParametersTestLanguage())) {
                alt11=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalParametersTestLanguage.g:577:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    {
                    // PsiInternalParametersTestLanguage.g:577:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    // PsiInternalParametersTestLanguage.g:578:4: ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword )
                    {
                    // PsiInternalParametersTestLanguage.g:582:4: (lv_first_0_0= norm1_IdOrKeyword )
                    // PsiInternalParametersTestLanguage.g:583:5: lv_first_0_0= norm1_IdOrKeyword
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getScenario3_FirstIdOrKeywordParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    norm1_IdOrKeyword();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalParametersTestLanguage.g:593:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // PsiInternalParametersTestLanguage.g:593:3: ( (lv_second_1_0= 'keyword' ) )
                    // PsiInternalParametersTestLanguage.g:594:4: (lv_second_1_0= 'keyword' )
                    {
                    // PsiInternalParametersTestLanguage.g:594:4: (lv_second_1_0= 'keyword' )
                    // PsiInternalParametersTestLanguage.g:595:5: lv_second_1_0= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getScenario3_SecondKeywordKeyword_1_0ElementType());
                      				
                    }
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_second_1_0);
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "norm1_Scenario3"


    // $ANTLR start "entryRuleScenario4"
    // PsiInternalParametersTestLanguage.g:608:1: entryRuleScenario4 : ruleScenario4 EOF ;
    public final void entryRuleScenario4() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguage.g:608:19: ( ruleScenario4 EOF )
            // PsiInternalParametersTestLanguage.g:609:2: ruleScenario4 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario4ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario4();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScenario4"


    // $ANTLR start "ruleScenario4"
    // PsiInternalParametersTestLanguage.g:614:1: ruleScenario4 : ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' ) ;
    public final void ruleScenario4() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalParametersTestLanguage.g:614:14: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' ) )
            // PsiInternalParametersTestLanguage.g:615:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' )
            {
            // PsiInternalParametersTestLanguage.g:615:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' )
            // PsiInternalParametersTestLanguage.g:616:3: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword'
            {
            // PsiInternalParametersTestLanguage.g:616:3: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) )
            // PsiInternalParametersTestLanguage.g:617:4: ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword )
            {
            // PsiInternalParametersTestLanguage.g:621:4: (lv_second_0_0= ruleIdOrKeyword )
            // PsiInternalParametersTestLanguage.g:622:5: lv_second_0_0= ruleIdOrKeyword
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getScenario4_SecondIdOrKeywordParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            ruleIdOrKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getScenario4_KeywordKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleScenario4"


    // $ANTLR start "norm1_Scenario4"
    // PsiInternalParametersTestLanguage.g:643:1: norm1_Scenario4 : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' ) ;
    public final void norm1_Scenario4() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalParametersTestLanguage.g:643:16: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' ) )
            // PsiInternalParametersTestLanguage.g:644:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' )
            {
            // PsiInternalParametersTestLanguage.g:644:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' )
            // PsiInternalParametersTestLanguage.g:645:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword'
            {
            // PsiInternalParametersTestLanguage.g:645:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) )
            // PsiInternalParametersTestLanguage.g:646:4: ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword )
            {
            // PsiInternalParametersTestLanguage.g:650:4: (lv_second_0_0= norm1_IdOrKeyword )
            // PsiInternalParametersTestLanguage.g:651:5: lv_second_0_0= norm1_IdOrKeyword
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getScenario4_SecondIdOrKeywordParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            norm1_IdOrKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getScenario4_KeywordKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "norm1_Scenario4"


    // $ANTLR start "entryRuleIdOrKeyword"
    // PsiInternalParametersTestLanguage.g:671:1: entryRuleIdOrKeyword : ruleIdOrKeyword EOF ;
    public final void entryRuleIdOrKeyword() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguage.g:671:21: ( ruleIdOrKeyword EOF )
            // PsiInternalParametersTestLanguage.g:672:2: ruleIdOrKeyword EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrKeywordElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleIdOrKeyword();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdOrKeyword"


    // $ANTLR start "ruleIdOrKeyword"
    // PsiInternalParametersTestLanguage.g:677:1: ruleIdOrKeyword : this_ID_0= RULE_ID ;
    public final void ruleIdOrKeyword() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalParametersTestLanguage.g:677:16: (this_ID_0= RULE_ID )
            // PsiInternalParametersTestLanguage.g:678:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getIdOrKeyword_IDTerminalRuleCall_1ElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              		doneLeaf(this_ID_0);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleIdOrKeyword"


    // $ANTLR start "norm1_IdOrKeyword"
    // PsiInternalParametersTestLanguage.g:689:1: norm1_IdOrKeyword : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final void norm1_IdOrKeyword() throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalParametersTestLanguage.g:689:18: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // PsiInternalParametersTestLanguage.g:690:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // PsiInternalParametersTestLanguage.g:690:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalParametersTestLanguage.g:691:3: kw= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_KeywordKeyword_0_0ElementType());
                      		
                    }
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalParametersTestLanguage.g:699:3: this_ID_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_IDTerminalRuleCall_1ElementType());
                      		
                    }
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(this_ID_1);
                      		
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "norm1_IdOrKeyword"

    // $ANTLR start synpred1_PsiInternalParametersTestLanguage
    public final void synpred1_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguage.g:152:5: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )
        // PsiInternalParametersTestLanguage.g:152:6: ( '#5' ( ( norm1_Scenario2 ) ) )
        {
        // PsiInternalParametersTestLanguage.g:152:6: ( '#5' ( ( norm1_Scenario2 ) ) )
        // PsiInternalParametersTestLanguage.g:153:6: '#5' ( ( norm1_Scenario2 ) )
        {
        match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // PsiInternalParametersTestLanguage.g:154:6: ( ( norm1_Scenario2 ) )
        // PsiInternalParametersTestLanguage.g:155:7: ( norm1_Scenario2 )
        {
        // PsiInternalParametersTestLanguage.g:155:7: ( norm1_Scenario2 )
        // PsiInternalParametersTestLanguage.g:156:8: norm1_Scenario2
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
    // $ANTLR end synpred1_PsiInternalParametersTestLanguage

    // $ANTLR start synpred2_PsiInternalParametersTestLanguage
    public final void synpred2_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguage.g:184:5: ( ( '#6' ( ( ruleScenario2 ) ) ) )
        // PsiInternalParametersTestLanguage.g:184:6: ( '#6' ( ( ruleScenario2 ) ) )
        {
        // PsiInternalParametersTestLanguage.g:184:6: ( '#6' ( ( ruleScenario2 ) ) )
        // PsiInternalParametersTestLanguage.g:185:6: '#6' ( ( ruleScenario2 ) )
        {
        match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
        // PsiInternalParametersTestLanguage.g:186:6: ( ( ruleScenario2 ) )
        // PsiInternalParametersTestLanguage.g:187:7: ( ruleScenario2 )
        {
        // PsiInternalParametersTestLanguage.g:187:7: ( ruleScenario2 )
        // PsiInternalParametersTestLanguage.g:188:8: ruleScenario2
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
    // $ANTLR end synpred2_PsiInternalParametersTestLanguage

    // $ANTLR start synpred3_PsiInternalParametersTestLanguage
    public final void synpred3_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguage.g:267:7: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguage.g:267:8: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguage.g:267:8: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguage.g:268:8: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_PsiInternalParametersTestLanguage

    // $ANTLR start synpred4_PsiInternalParametersTestLanguage
    public final void synpred4_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguage.g:317:7: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguage.g:317:8: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguage.g:317:8: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguage.g:318:8: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_PsiInternalParametersTestLanguage

    // $ANTLR start synpred5_PsiInternalParametersTestLanguage
    public final void synpred5_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguage.g:367:7: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguage.g:367:8: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguage.g:367:8: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguage.g:368:8: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_PsiInternalParametersTestLanguage

    // $ANTLR start synpred6_PsiInternalParametersTestLanguage
    public final void synpred6_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguage.g:417:7: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguage.g:417:8: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguage.g:417:8: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguage.g:418:8: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_PsiInternalParametersTestLanguage

    // $ANTLR start synpred7_PsiInternalParametersTestLanguage
    public final void synpred7_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguage.g:544:4: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguage.g:544:5: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguage.g:544:5: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguage.g:545:5: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_PsiInternalParametersTestLanguage

    // $ANTLR start synpred8_PsiInternalParametersTestLanguage
    public final void synpred8_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguage.g:578:4: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguage.g:578:5: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguage.g:578:5: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguage.g:579:5: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_PsiInternalParametersTestLanguage

    // Delegated rules

    public final boolean synpred6_PsiInternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_PsiInternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PsiInternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_PsiInternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PsiInternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_PsiInternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PsiInternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_PsiInternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PsiInternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_PsiInternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_PsiInternalParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_PsiInternalParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_PsiInternalParametersTestLanguage_fragment(); // can never throw exception
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
    static final String DFA9_eotS =
        "\15\uffff";
    static final String DFA9_eofS =
        "\15\uffff";
    static final String DFA9_minS =
        "\1\13\14\uffff";
    static final String DFA9_maxS =
        "\1\27\14\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14";
    static final String DFA9_specialS =
        "\1\0\14\uffff}>";
    static final String[] DFA9_transitionS = {
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

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "66:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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

                        else if ( (LA9_0==15) && (synpred1_PsiInternalParametersTestLanguage())) {s = 5;}

                        else if ( (LA9_0==16) && (synpred2_PsiInternalParametersTestLanguage())) {s = 6;}

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