package org.eclipse.xtext.parser.parameters.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.parameters.services.ParametersTestLanguageExGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalParametersTestLanguageExParser extends AbstractPsiAntlrParser {
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


        public PsiInternalParametersTestLanguageExParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalParametersTestLanguageExParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalParametersTestLanguageExParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalParametersTestLanguageEx.g"; }



    	protected ParametersTestLanguageExGrammarAccess grammarAccess;

    	protected ParametersTestLanguageExElementTypeProvider elementTypeProvider;

    	public PsiInternalParametersTestLanguageExParser(PsiBuilder builder, TokenStream input, ParametersTestLanguageExElementTypeProvider elementTypeProvider, ParametersTestLanguageExGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "ParserRuleFragmentsEx";
    	}




    // $ANTLR start "entryRuleParserRuleFragmentsEx"
    // PsiInternalParametersTestLanguageEx.g:52:1: entryRuleParserRuleFragmentsEx : ruleParserRuleFragmentsEx EOF ;
    public final void entryRuleParserRuleFragmentsEx() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:52:31: ( ruleParserRuleFragmentsEx EOF )
            // PsiInternalParametersTestLanguageEx.g:53:2: ruleParserRuleFragmentsEx EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParserRuleFragmentsExElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParserRuleFragmentsEx();

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
    // $ANTLR end "entryRuleParserRuleFragmentsEx"


    // $ANTLR start "ruleParserRuleFragmentsEx"
    // PsiInternalParametersTestLanguageEx.g:58:1: ruleParserRuleFragmentsEx : ruleParserRuleParameters ;
    public final void ruleParserRuleFragmentsEx() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:58:26: ( ruleParserRuleParameters )
            // PsiInternalParametersTestLanguageEx.g:59:2: ruleParserRuleParameters
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getParserRuleFragmentsEx_ParserRuleParametersParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleParserRuleParameters();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              		doneComposite();
              	
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
    // $ANTLR end "ruleParserRuleFragmentsEx"


    // $ANTLR start "entryRuleParserRuleParameters"
    // PsiInternalParametersTestLanguageEx.g:69:1: entryRuleParserRuleParameters : ruleParserRuleParameters EOF ;
    public final void entryRuleParserRuleParameters() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:69:30: ( ruleParserRuleParameters EOF )
            // PsiInternalParametersTestLanguageEx.g:70:2: ruleParserRuleParameters EOF
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
    // PsiInternalParametersTestLanguageEx.g:75:1: ruleParserRuleParameters : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
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
            // PsiInternalParametersTestLanguageEx.g:75:25: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:76:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:76:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:77:3: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:77:3: ()
            // PsiInternalParametersTestLanguageEx.g:78:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParserRuleParameters_ParserRuleParametersAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalParametersTestLanguageEx.g:83:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // PsiInternalParametersTestLanguageEx.g:84:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:84:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:85:5: otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:92:5: ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    // PsiInternalParametersTestLanguageEx.g:93:6: (lv_scenario_2_0= norm1_Scenario1 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:93:6: (lv_scenario_2_0= norm1_Scenario1 )
                    // PsiInternalParametersTestLanguageEx.g:94:7: lv_scenario_2_0= norm1_Scenario1
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
                    // PsiInternalParametersTestLanguageEx.g:105:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:105:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:106:5: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:113:5: ( (lv_scenario_4_0= ruleScenario1 ) )
                    // PsiInternalParametersTestLanguageEx.g:114:6: (lv_scenario_4_0= ruleScenario1 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:114:6: (lv_scenario_4_0= ruleScenario1 )
                    // PsiInternalParametersTestLanguageEx.g:115:7: lv_scenario_4_0= ruleScenario1
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
                    // PsiInternalParametersTestLanguageEx.g:126:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:126:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:127:5: otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_5);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:134:5: ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:135:6: (lv_scenario_6_0= norm1_Scenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:135:6: (lv_scenario_6_0= norm1_Scenario2 )
                    // PsiInternalParametersTestLanguageEx.g:136:7: lv_scenario_6_0= norm1_Scenario2
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
                    // PsiInternalParametersTestLanguageEx.g:147:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:147:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:148:5: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:155:5: ( (lv_scenario_8_0= ruleScenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:156:6: (lv_scenario_8_0= ruleScenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:156:6: (lv_scenario_8_0= ruleScenario2 )
                    // PsiInternalParametersTestLanguageEx.g:157:7: lv_scenario_8_0= ruleScenario2
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
                    // PsiInternalParametersTestLanguageEx.g:168:4: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:168:4: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    // PsiInternalParametersTestLanguageEx.g:169:5: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:178:5: (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:179:6: otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFiveKeyword_1_4_0_0ElementType());
                      					
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_9);
                      					
                    }
                    // PsiInternalParametersTestLanguageEx.g:186:6: ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:187:7: (lv_scenario_10_0= norm1_Scenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:187:7: (lv_scenario_10_0= norm1_Scenario2 )
                    // PsiInternalParametersTestLanguageEx.g:188:8: lv_scenario_10_0= norm1_Scenario2
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
                    // PsiInternalParametersTestLanguageEx.g:200:4: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:200:4: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    // PsiInternalParametersTestLanguageEx.g:201:5: ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:210:5: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:211:6: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSixKeyword_1_5_0_0ElementType());
                      					
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_11);
                      					
                    }
                    // PsiInternalParametersTestLanguageEx.g:218:6: ( (lv_scenario_12_0= ruleScenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:219:7: (lv_scenario_12_0= ruleScenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:219:7: (lv_scenario_12_0= ruleScenario2 )
                    // PsiInternalParametersTestLanguageEx.g:220:8: lv_scenario_12_0= ruleScenario2
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
                    // PsiInternalParametersTestLanguageEx.g:232:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:232:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:233:5: otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSevenKeyword_1_6_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:240:5: ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    // PsiInternalParametersTestLanguageEx.g:241:6: (lv_scenario_14_0= norm1_Scenario3 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:241:6: (lv_scenario_14_0= norm1_Scenario3 )
                    // PsiInternalParametersTestLanguageEx.g:242:7: lv_scenario_14_0= norm1_Scenario3
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
                    // PsiInternalParametersTestLanguageEx.g:253:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:253:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:254:5: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitEightKeyword_1_7_0ElementType());
                      				
                    }
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_15);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:261:5: ( (lv_scenario_16_0= ruleScenario3 ) )
                    // PsiInternalParametersTestLanguageEx.g:262:6: (lv_scenario_16_0= ruleScenario3 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:262:6: (lv_scenario_16_0= ruleScenario3 )
                    // PsiInternalParametersTestLanguageEx.g:263:7: lv_scenario_16_0= ruleScenario3
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
                    // PsiInternalParametersTestLanguageEx.g:274:4: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:274:4: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:275:5: otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitNineKeyword_1_8_0ElementType());
                      				
                    }
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_17);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:282:5: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==20) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==20) ) {
                            int LA2_3 = input.LA(3);

                            if ( (synpred3_PsiInternalParametersTestLanguageEx()) ) {
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

                            if ( (synpred3_PsiInternalParametersTestLanguageEx()) ) {
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
                            // PsiInternalParametersTestLanguageEx.g:283:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:283:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:284:7: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:288:7: (lv_scenario_18_0= norm1_Scenario4 )
                            // PsiInternalParametersTestLanguageEx.g:289:8: lv_scenario_18_0= norm1_Scenario4
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
                            // PsiInternalParametersTestLanguageEx.g:299:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:299:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:300:7: ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:300:7: ( (lv_scenario_19_0= norm1_Scenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:301:8: (lv_scenario_19_0= norm1_Scenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:301:8: (lv_scenario_19_0= norm1_Scenario2 )
                            // PsiInternalParametersTestLanguageEx.g:302:9: lv_scenario_19_0= norm1_Scenario2
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

                            // PsiInternalParametersTestLanguageEx.g:311:7: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:312:8: otherlv_20= 'keyword'
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
                    // PsiInternalParametersTestLanguageEx.g:324:4: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:324:4: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:325:5: otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitZeroKeyword_1_9_0ElementType());
                      				
                    }
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_21);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:332:5: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) && (synpred4_PsiInternalParametersTestLanguageEx())) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_ID) ) {
                        int LA4_2 = input.LA(2);

                        if ( (LA4_2==20) ) {
                            int LA4_3 = input.LA(3);

                            if ( (synpred4_PsiInternalParametersTestLanguageEx()) ) {
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
                            // PsiInternalParametersTestLanguageEx.g:333:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:333:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:334:7: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:338:7: (lv_scenario_22_0= norm1_Scenario4 )
                            // PsiInternalParametersTestLanguageEx.g:339:8: lv_scenario_22_0= norm1_Scenario4
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
                            // PsiInternalParametersTestLanguageEx.g:349:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:349:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:350:7: ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:350:7: ( (lv_scenario_23_0= ruleScenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:351:8: (lv_scenario_23_0= ruleScenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:351:8: (lv_scenario_23_0= ruleScenario2 )
                            // PsiInternalParametersTestLanguageEx.g:352:9: lv_scenario_23_0= ruleScenario2
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

                            // PsiInternalParametersTestLanguageEx.g:361:7: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:362:8: otherlv_24= 'keyword'
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
                    // PsiInternalParametersTestLanguageEx.g:374:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:374:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:375:5: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitOneKeyword_1_10_0ElementType());
                      				
                    }
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_25);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:382:5: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==20) ) {
                            int LA6_3 = input.LA(3);

                            if ( (synpred5_PsiInternalParametersTestLanguageEx()) ) {
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
                            // PsiInternalParametersTestLanguageEx.g:383:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:383:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:384:7: ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:388:7: (lv_scenario_26_0= ruleScenario4 )
                            // PsiInternalParametersTestLanguageEx.g:389:8: lv_scenario_26_0= ruleScenario4
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
                            // PsiInternalParametersTestLanguageEx.g:399:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:399:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:400:7: ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:400:7: ( (lv_scenario_27_0= norm1_Scenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:401:8: (lv_scenario_27_0= norm1_Scenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:401:8: (lv_scenario_27_0= norm1_Scenario2 )
                            // PsiInternalParametersTestLanguageEx.g:402:9: lv_scenario_27_0= norm1_Scenario2
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

                            // PsiInternalParametersTestLanguageEx.g:411:7: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:412:8: otherlv_28= 'keyword'
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
                    // PsiInternalParametersTestLanguageEx.g:424:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:424:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:425:5: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitTwoKeyword_1_11_0ElementType());
                      				
                    }
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_29);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:432:5: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_2 = input.LA(3);

                            if ( (synpred6_PsiInternalParametersTestLanguageEx()) ) {
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
                            // PsiInternalParametersTestLanguageEx.g:433:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:433:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:434:7: ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:438:7: (lv_scenario_30_0= ruleScenario4 )
                            // PsiInternalParametersTestLanguageEx.g:439:8: lv_scenario_30_0= ruleScenario4
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
                            // PsiInternalParametersTestLanguageEx.g:449:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:449:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:450:7: ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:450:7: ( (lv_scenario_31_0= ruleScenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:451:8: (lv_scenario_31_0= ruleScenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:451:8: (lv_scenario_31_0= ruleScenario2 )
                            // PsiInternalParametersTestLanguageEx.g:452:9: lv_scenario_31_0= ruleScenario2
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

                            // PsiInternalParametersTestLanguageEx.g:461:7: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:462:8: otherlv_32= 'keyword'
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
    // PsiInternalParametersTestLanguageEx.g:478:1: entryRuleScenario1 : ruleScenario1 EOF ;
    public final void entryRuleScenario1() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:478:19: ( ruleScenario1 EOF )
            // PsiInternalParametersTestLanguageEx.g:479:2: ruleScenario1 EOF
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
    // PsiInternalParametersTestLanguageEx.g:484:1: ruleScenario1 : ( (lv_second_0_0= RULE_ID ) ) ;
    public final void ruleScenario1() throws RecognitionException {
        Token lv_second_0_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:484:14: ( ( (lv_second_0_0= RULE_ID ) ) )
            // PsiInternalParametersTestLanguageEx.g:485:2: ( (lv_second_0_0= RULE_ID ) )
            {
            // PsiInternalParametersTestLanguageEx.g:485:2: ( (lv_second_0_0= RULE_ID ) )
            // PsiInternalParametersTestLanguageEx.g:486:3: (lv_second_0_0= RULE_ID )
            {
            // PsiInternalParametersTestLanguageEx.g:486:3: (lv_second_0_0= RULE_ID )
            // PsiInternalParametersTestLanguageEx.g:487:4: lv_second_0_0= RULE_ID
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
    // PsiInternalParametersTestLanguageEx.g:500:1: norm1_Scenario1 : ( (lv_first_0_0= RULE_ID ) ) ;
    public final void norm1_Scenario1() throws RecognitionException {
        Token lv_first_0_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:500:16: ( ( (lv_first_0_0= RULE_ID ) ) )
            // PsiInternalParametersTestLanguageEx.g:501:2: ( (lv_first_0_0= RULE_ID ) )
            {
            // PsiInternalParametersTestLanguageEx.g:501:2: ( (lv_first_0_0= RULE_ID ) )
            // PsiInternalParametersTestLanguageEx.g:502:3: (lv_first_0_0= RULE_ID )
            {
            // PsiInternalParametersTestLanguageEx.g:502:3: (lv_first_0_0= RULE_ID )
            // PsiInternalParametersTestLanguageEx.g:503:4: lv_first_0_0= RULE_ID
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
    // PsiInternalParametersTestLanguageEx.g:515:1: entryRuleScenario2 : ruleScenario2 EOF ;
    public final void entryRuleScenario2() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:515:19: ( ruleScenario2 EOF )
            // PsiInternalParametersTestLanguageEx.g:516:2: ruleScenario2 EOF
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
    // PsiInternalParametersTestLanguageEx.g:521:1: ruleScenario2 : ( (lv_first_0_0= ruleIdOrKeyword ) ) ;
    public final void ruleScenario2() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:521:14: ( ( (lv_first_0_0= ruleIdOrKeyword ) ) )
            // PsiInternalParametersTestLanguageEx.g:522:2: ( (lv_first_0_0= ruleIdOrKeyword ) )
            {
            // PsiInternalParametersTestLanguageEx.g:522:2: ( (lv_first_0_0= ruleIdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:523:3: (lv_first_0_0= ruleIdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:523:3: (lv_first_0_0= ruleIdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:524:4: lv_first_0_0= ruleIdOrKeyword
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
    // PsiInternalParametersTestLanguageEx.g:537:1: norm1_Scenario2 : ( (lv_first_0_0= norm1_IdOrKeyword ) ) ;
    public final void norm1_Scenario2() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:537:16: ( ( (lv_first_0_0= norm1_IdOrKeyword ) ) )
            // PsiInternalParametersTestLanguageEx.g:538:2: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            {
            // PsiInternalParametersTestLanguageEx.g:538:2: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:539:3: (lv_first_0_0= norm1_IdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:539:3: (lv_first_0_0= norm1_IdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:540:4: lv_first_0_0= norm1_IdOrKeyword
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
    // PsiInternalParametersTestLanguageEx.g:552:1: entryRuleScenario3 : ruleScenario3 EOF ;
    public final void entryRuleScenario3() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:552:19: ( ruleScenario3 EOF )
            // PsiInternalParametersTestLanguageEx.g:553:2: ruleScenario3 EOF
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
    // PsiInternalParametersTestLanguageEx.g:558:1: ruleScenario3 : ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final void ruleScenario3() throws RecognitionException {
        Token lv_second_1_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:558:14: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:559:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:559:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) && (synpred7_PsiInternalParametersTestLanguageEx())) {
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
                    // PsiInternalParametersTestLanguageEx.g:560:3: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:560:3: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    // PsiInternalParametersTestLanguageEx.g:561:4: ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword )
                    {
                    // PsiInternalParametersTestLanguageEx.g:565:4: (lv_first_0_0= ruleIdOrKeyword )
                    // PsiInternalParametersTestLanguageEx.g:566:5: lv_first_0_0= ruleIdOrKeyword
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
                    // PsiInternalParametersTestLanguageEx.g:576:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:576:3: ( (lv_second_1_0= 'keyword' ) )
                    // PsiInternalParametersTestLanguageEx.g:577:4: (lv_second_1_0= 'keyword' )
                    {
                    // PsiInternalParametersTestLanguageEx.g:577:4: (lv_second_1_0= 'keyword' )
                    // PsiInternalParametersTestLanguageEx.g:578:5: lv_second_1_0= 'keyword'
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
    // PsiInternalParametersTestLanguageEx.g:592:1: norm1_Scenario3 : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final void norm1_Scenario3() throws RecognitionException {
        Token lv_second_1_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:592:16: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:593:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:593:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred8_PsiInternalParametersTestLanguageEx()) ) {
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
            else if ( (LA11_0==RULE_ID) && (synpred8_PsiInternalParametersTestLanguageEx())) {
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
                    // PsiInternalParametersTestLanguageEx.g:594:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:594:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    // PsiInternalParametersTestLanguageEx.g:595:4: ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword )
                    {
                    // PsiInternalParametersTestLanguageEx.g:599:4: (lv_first_0_0= norm1_IdOrKeyword )
                    // PsiInternalParametersTestLanguageEx.g:600:5: lv_first_0_0= norm1_IdOrKeyword
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
                    // PsiInternalParametersTestLanguageEx.g:610:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:610:3: ( (lv_second_1_0= 'keyword' ) )
                    // PsiInternalParametersTestLanguageEx.g:611:4: (lv_second_1_0= 'keyword' )
                    {
                    // PsiInternalParametersTestLanguageEx.g:611:4: (lv_second_1_0= 'keyword' )
                    // PsiInternalParametersTestLanguageEx.g:612:5: lv_second_1_0= 'keyword'
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
    // PsiInternalParametersTestLanguageEx.g:625:1: entryRuleScenario4 : ruleScenario4 EOF ;
    public final void entryRuleScenario4() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:625:19: ( ruleScenario4 EOF )
            // PsiInternalParametersTestLanguageEx.g:626:2: ruleScenario4 EOF
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
    // PsiInternalParametersTestLanguageEx.g:631:1: ruleScenario4 : ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' ) ;
    public final void ruleScenario4() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:631:14: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' ) )
            // PsiInternalParametersTestLanguageEx.g:632:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' )
            {
            // PsiInternalParametersTestLanguageEx.g:632:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' )
            // PsiInternalParametersTestLanguageEx.g:633:3: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword'
            {
            // PsiInternalParametersTestLanguageEx.g:633:3: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:634:4: ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:638:4: (lv_second_0_0= ruleIdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:639:5: lv_second_0_0= ruleIdOrKeyword
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
    // PsiInternalParametersTestLanguageEx.g:660:1: norm1_Scenario4 : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' ) ;
    public final void norm1_Scenario4() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:660:16: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' ) )
            // PsiInternalParametersTestLanguageEx.g:661:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' )
            {
            // PsiInternalParametersTestLanguageEx.g:661:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' )
            // PsiInternalParametersTestLanguageEx.g:662:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword'
            {
            // PsiInternalParametersTestLanguageEx.g:662:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:663:4: ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:667:4: (lv_second_0_0= norm1_IdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:668:5: lv_second_0_0= norm1_IdOrKeyword
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
    // PsiInternalParametersTestLanguageEx.g:688:1: entryRuleIdOrKeyword : ruleIdOrKeyword EOF ;
    public final void entryRuleIdOrKeyword() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:688:21: ( ruleIdOrKeyword EOF )
            // PsiInternalParametersTestLanguageEx.g:689:2: ruleIdOrKeyword EOF
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
    // PsiInternalParametersTestLanguageEx.g:694:1: ruleIdOrKeyword : this_ID_0= RULE_ID ;
    public final void ruleIdOrKeyword() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:694:16: (this_ID_0= RULE_ID )
            // PsiInternalParametersTestLanguageEx.g:695:2: this_ID_0= RULE_ID
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
    // PsiInternalParametersTestLanguageEx.g:706:1: norm1_IdOrKeyword : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final void norm1_IdOrKeyword() throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:706:18: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // PsiInternalParametersTestLanguageEx.g:707:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // PsiInternalParametersTestLanguageEx.g:707:2: (kw= 'keyword' | this_ID_1= RULE_ID )
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
                    // PsiInternalParametersTestLanguageEx.g:708:3: kw= 'keyword'
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
                    // PsiInternalParametersTestLanguageEx.g:716:3: this_ID_1= RULE_ID
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

    // $ANTLR start synpred1_PsiInternalParametersTestLanguageEx
    public final void synpred1_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguageEx.g:169:5: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )
        // PsiInternalParametersTestLanguageEx.g:169:6: ( '#5' ( ( norm1_Scenario2 ) ) )
        {
        // PsiInternalParametersTestLanguageEx.g:169:6: ( '#5' ( ( norm1_Scenario2 ) ) )
        // PsiInternalParametersTestLanguageEx.g:170:6: '#5' ( ( norm1_Scenario2 ) )
        {
        match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // PsiInternalParametersTestLanguageEx.g:171:6: ( ( norm1_Scenario2 ) )
        // PsiInternalParametersTestLanguageEx.g:172:7: ( norm1_Scenario2 )
        {
        // PsiInternalParametersTestLanguageEx.g:172:7: ( norm1_Scenario2 )
        // PsiInternalParametersTestLanguageEx.g:173:8: norm1_Scenario2
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
    // $ANTLR end synpred1_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred2_PsiInternalParametersTestLanguageEx
    public final void synpred2_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguageEx.g:201:5: ( ( '#6' ( ( ruleScenario2 ) ) ) )
        // PsiInternalParametersTestLanguageEx.g:201:6: ( '#6' ( ( ruleScenario2 ) ) )
        {
        // PsiInternalParametersTestLanguageEx.g:201:6: ( '#6' ( ( ruleScenario2 ) ) )
        // PsiInternalParametersTestLanguageEx.g:202:6: '#6' ( ( ruleScenario2 ) )
        {
        match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
        // PsiInternalParametersTestLanguageEx.g:203:6: ( ( ruleScenario2 ) )
        // PsiInternalParametersTestLanguageEx.g:204:7: ( ruleScenario2 )
        {
        // PsiInternalParametersTestLanguageEx.g:204:7: ( ruleScenario2 )
        // PsiInternalParametersTestLanguageEx.g:205:8: ruleScenario2
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
    // $ANTLR end synpred2_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred3_PsiInternalParametersTestLanguageEx
    public final void synpred3_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguageEx.g:284:7: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:284:8: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:284:8: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:285:8: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred4_PsiInternalParametersTestLanguageEx
    public final void synpred4_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguageEx.g:334:7: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:334:8: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:334:8: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:335:8: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred5_PsiInternalParametersTestLanguageEx
    public final void synpred5_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguageEx.g:384:7: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:384:8: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:384:8: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:385:8: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred6_PsiInternalParametersTestLanguageEx
    public final void synpred6_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguageEx.g:434:7: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:434:8: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:434:8: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:435:8: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred7_PsiInternalParametersTestLanguageEx
    public final void synpred7_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguageEx.g:561:4: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:561:5: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:561:5: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:562:5: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred8_PsiInternalParametersTestLanguageEx
    public final void synpred8_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguageEx.g:595:4: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:595:5: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:595:5: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:596:5: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_PsiInternalParametersTestLanguageEx

    // Delegated rules

    public final boolean synpred2_PsiInternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_PsiInternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_PsiInternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_PsiInternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PsiInternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_PsiInternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PsiInternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_PsiInternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_PsiInternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PsiInternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_PsiInternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PsiInternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_PsiInternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_PsiInternalParametersTestLanguageEx_fragment(); // can never throw exception
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
            return "83:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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

                        else if ( (LA9_0==15) && (synpred1_PsiInternalParametersTestLanguageEx())) {s = 5;}

                        else if ( (LA9_0==16) && (synpred2_PsiInternalParametersTestLanguageEx())) {s = 6;}

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