package org.eclipse.xtext.parser.parameters.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.parameters.services.NoParametersTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalNoParametersTestLanguageParser extends AbstractPsiAntlrParser {
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


        public PsiInternalNoParametersTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalNoParametersTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalNoParametersTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalNoParametersTestLanguage.g"; }



    	protected NoParametersTestLanguageGrammarAccess grammarAccess;

    	protected NoParametersTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalNoParametersTestLanguageParser(PsiBuilder builder, TokenStream input, NoParametersTestLanguageElementTypeProvider elementTypeProvider, NoParametersTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalNoParametersTestLanguage.g:52:1: entryRuleParserRuleParameters returns [Boolean current=false] : iv_ruleParserRuleParameters= ruleParserRuleParameters EOF ;
    public final Boolean entryRuleParserRuleParameters() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParserRuleParameters = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:52:62: (iv_ruleParserRuleParameters= ruleParserRuleParameters EOF )
            // PsiInternalNoParametersTestLanguage.g:53:2: iv_ruleParserRuleParameters= ruleParserRuleParameters EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParserRuleParametersElementType()); 
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParserRuleParameters"


    // $ANTLR start "ruleParserRuleParameters"
    // PsiInternalNoParametersTestLanguage.g:59:1: ruleParserRuleParameters returns [Boolean current=false] : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
    public final Boolean ruleParserRuleParameters() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_scenario_2_0 = null;

        Boolean lv_scenario_4_0 = null;

        Boolean lv_scenario_6_0 = null;

        Boolean lv_scenario_8_0 = null;

        Boolean lv_scenario_10_0 = null;

        Boolean lv_scenario_12_0 = null;

        Boolean lv_scenario_14_0 = null;

        Boolean lv_scenario_16_0 = null;

        Boolean lv_scenario_18_0 = null;

        Boolean lv_scenario_19_0 = null;

        Boolean lv_scenario_22_0 = null;

        Boolean lv_scenario_23_0 = null;

        Boolean lv_scenario_26_0 = null;

        Boolean lv_scenario_27_0 = null;

        Boolean lv_scenario_30_0 = null;

        Boolean lv_scenario_31_0 = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:60:1: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // PsiInternalNoParametersTestLanguage.g:61:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // PsiInternalNoParametersTestLanguage.g:61:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // PsiInternalNoParametersTestLanguage.g:62:3: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // PsiInternalNoParametersTestLanguage.g:62:3: ()
            // PsiInternalNoParametersTestLanguage.g:63:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParserRuleParameters_ParserRuleParametersAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalNoParametersTestLanguage.g:69:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // PsiInternalNoParametersTestLanguage.g:70:4: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:70:4: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) )
                    // PsiInternalNoParametersTestLanguage.g:71:5: otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalNoParametersTestLanguage.g:78:5: ( (lv_scenario_2_0= ruleScenario1_True ) )
                    // PsiInternalNoParametersTestLanguage.g:79:6: (lv_scenario_2_0= ruleScenario1_True )
                    {
                    // PsiInternalNoParametersTestLanguage.g:79:6: (lv_scenario_2_0= ruleScenario1_True )
                    // PsiInternalNoParametersTestLanguage.g:80:7: lv_scenario_2_0= ruleScenario1_True
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario1_TrueParserRuleCall_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_2_0=ruleScenario1_True();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalNoParametersTestLanguage.g:95:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:95:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) )
                    // PsiInternalNoParametersTestLanguage.g:96:5: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // PsiInternalNoParametersTestLanguage.g:103:5: ( (lv_scenario_4_0= ruleScenario1_False ) )
                    // PsiInternalNoParametersTestLanguage.g:104:6: (lv_scenario_4_0= ruleScenario1_False )
                    {
                    // PsiInternalNoParametersTestLanguage.g:104:6: (lv_scenario_4_0= ruleScenario1_False )
                    // PsiInternalNoParametersTestLanguage.g:105:7: lv_scenario_4_0= ruleScenario1_False
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario1_FalseParserRuleCall_1_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_4_0=ruleScenario1_False();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalNoParametersTestLanguage.g:120:4: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:120:4: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) )
                    // PsiInternalNoParametersTestLanguage.g:121:5: otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_5);
                      				
                    }
                    // PsiInternalNoParametersTestLanguage.g:128:5: ( (lv_scenario_6_0= ruleScenario2_True ) )
                    // PsiInternalNoParametersTestLanguage.g:129:6: (lv_scenario_6_0= ruleScenario2_True )
                    {
                    // PsiInternalNoParametersTestLanguage.g:129:6: (lv_scenario_6_0= ruleScenario2_True )
                    // PsiInternalNoParametersTestLanguage.g:130:7: lv_scenario_6_0= ruleScenario2_True
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_TrueParserRuleCall_1_2_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_6_0=ruleScenario2_True();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalNoParametersTestLanguage.g:145:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:145:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) )
                    // PsiInternalNoParametersTestLanguage.g:146:5: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // PsiInternalNoParametersTestLanguage.g:153:5: ( (lv_scenario_8_0= ruleScenario2_False ) )
                    // PsiInternalNoParametersTestLanguage.g:154:6: (lv_scenario_8_0= ruleScenario2_False )
                    {
                    // PsiInternalNoParametersTestLanguage.g:154:6: (lv_scenario_8_0= ruleScenario2_False )
                    // PsiInternalNoParametersTestLanguage.g:155:7: lv_scenario_8_0= ruleScenario2_False
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_FalseParserRuleCall_1_3_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_8_0=ruleScenario2_False();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalNoParametersTestLanguage.g:170:4: ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:170:4: ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) )
                    // PsiInternalNoParametersTestLanguage.g:171:5: ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:180:5: (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) )
                    // PsiInternalNoParametersTestLanguage.g:181:6: otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFiveKeyword_1_4_0_0ElementType());
                      					
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_9);
                      					
                    }
                    // PsiInternalNoParametersTestLanguage.g:188:6: ( (lv_scenario_10_0= ruleScenario2_True ) )
                    // PsiInternalNoParametersTestLanguage.g:189:7: (lv_scenario_10_0= ruleScenario2_True )
                    {
                    // PsiInternalNoParametersTestLanguage.g:189:7: (lv_scenario_10_0= ruleScenario2_True )
                    // PsiInternalNoParametersTestLanguage.g:190:8: lv_scenario_10_0= ruleScenario2_True
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_TrueParserRuleCall_1_4_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_10_0=ruleScenario2_True();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      								if(!current) {
                      									associateWithSemanticElement();
                      									current = true;
                      								}
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalNoParametersTestLanguage.g:206:4: ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:206:4: ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) )
                    // PsiInternalNoParametersTestLanguage.g:207:5: ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:216:5: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) )
                    // PsiInternalNoParametersTestLanguage.g:217:6: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSixKeyword_1_5_0_0ElementType());
                      					
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_11);
                      					
                    }
                    // PsiInternalNoParametersTestLanguage.g:224:6: ( (lv_scenario_12_0= ruleScenario2_False ) )
                    // PsiInternalNoParametersTestLanguage.g:225:7: (lv_scenario_12_0= ruleScenario2_False )
                    {
                    // PsiInternalNoParametersTestLanguage.g:225:7: (lv_scenario_12_0= ruleScenario2_False )
                    // PsiInternalNoParametersTestLanguage.g:226:8: lv_scenario_12_0= ruleScenario2_False
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_FalseParserRuleCall_1_5_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_12_0=ruleScenario2_False();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      								if(!current) {
                      									associateWithSemanticElement();
                      									current = true;
                      								}
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalNoParametersTestLanguage.g:242:4: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:242:4: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) )
                    // PsiInternalNoParametersTestLanguage.g:243:5: otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSevenKeyword_1_6_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // PsiInternalNoParametersTestLanguage.g:250:5: ( (lv_scenario_14_0= ruleScenario3_True ) )
                    // PsiInternalNoParametersTestLanguage.g:251:6: (lv_scenario_14_0= ruleScenario3_True )
                    {
                    // PsiInternalNoParametersTestLanguage.g:251:6: (lv_scenario_14_0= ruleScenario3_True )
                    // PsiInternalNoParametersTestLanguage.g:252:7: lv_scenario_14_0= ruleScenario3_True
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario3_TrueParserRuleCall_1_6_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_14_0=ruleScenario3_True();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalNoParametersTestLanguage.g:267:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:267:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) )
                    // PsiInternalNoParametersTestLanguage.g:268:5: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitEightKeyword_1_7_0ElementType());
                      				
                    }
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_15);
                      				
                    }
                    // PsiInternalNoParametersTestLanguage.g:275:5: ( (lv_scenario_16_0= ruleScenario3_False ) )
                    // PsiInternalNoParametersTestLanguage.g:276:6: (lv_scenario_16_0= ruleScenario3_False )
                    {
                    // PsiInternalNoParametersTestLanguage.g:276:6: (lv_scenario_16_0= ruleScenario3_False )
                    // PsiInternalNoParametersTestLanguage.g:277:7: lv_scenario_16_0= ruleScenario3_False
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario3_FalseParserRuleCall_1_7_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_16_0=ruleScenario3_False();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // PsiInternalNoParametersTestLanguage.g:292:4: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:292:4: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) )
                    // PsiInternalNoParametersTestLanguage.g:293:5: otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitNineKeyword_1_8_0ElementType());
                      				
                    }
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_17);
                      				
                    }
                    // PsiInternalNoParametersTestLanguage.g:300:5: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==20) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==20) ) {
                            int LA2_3 = input.LA(3);

                            if ( (synpred3_PsiInternalNoParametersTestLanguage()) ) {
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

                            if ( (synpred3_PsiInternalNoParametersTestLanguage()) ) {
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
                            // PsiInternalNoParametersTestLanguage.g:301:6: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) )
                            {
                            // PsiInternalNoParametersTestLanguage.g:301:6: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) )
                            // PsiInternalNoParametersTestLanguage.g:302:7: ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True )
                            {
                            // PsiInternalNoParametersTestLanguage.g:306:7: (lv_scenario_18_0= ruleScenario4_True )
                            // PsiInternalNoParametersTestLanguage.g:307:8: lv_scenario_18_0= ruleScenario4_True
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4_TrueParserRuleCall_1_8_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_18_0=ruleScenario4_True();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalNoParametersTestLanguage.g:321:6: ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? )
                            {
                            // PsiInternalNoParametersTestLanguage.g:321:6: ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? )
                            // PsiInternalNoParametersTestLanguage.g:322:7: ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )?
                            {
                            // PsiInternalNoParametersTestLanguage.g:322:7: ( (lv_scenario_19_0= ruleScenario2_True ) )
                            // PsiInternalNoParametersTestLanguage.g:323:8: (lv_scenario_19_0= ruleScenario2_True )
                            {
                            // PsiInternalNoParametersTestLanguage.g:323:8: (lv_scenario_19_0= ruleScenario2_True )
                            // PsiInternalNoParametersTestLanguage.g:324:9: lv_scenario_19_0= ruleScenario2_True
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_TrueParserRuleCall_1_8_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_19_0=ruleScenario2_True();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              									if(!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }

                            }


                            }

                            // PsiInternalNoParametersTestLanguage.g:337:7: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // PsiInternalNoParametersTestLanguage.g:338:8: otherlv_20= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_8_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // PsiInternalNoParametersTestLanguage.g:350:4: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:350:4: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) )
                    // PsiInternalNoParametersTestLanguage.g:351:5: otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitZeroKeyword_1_9_0ElementType());
                      				
                    }
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_21);
                      				
                    }
                    // PsiInternalNoParametersTestLanguage.g:358:5: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) && (synpred4_PsiInternalNoParametersTestLanguage())) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_ID) ) {
                        int LA4_2 = input.LA(2);

                        if ( (LA4_2==20) ) {
                            int LA4_3 = input.LA(3);

                            if ( (synpred4_PsiInternalNoParametersTestLanguage()) ) {
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
                            // PsiInternalNoParametersTestLanguage.g:359:6: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) )
                            {
                            // PsiInternalNoParametersTestLanguage.g:359:6: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) )
                            // PsiInternalNoParametersTestLanguage.g:360:7: ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True )
                            {
                            // PsiInternalNoParametersTestLanguage.g:364:7: (lv_scenario_22_0= ruleScenario4_True )
                            // PsiInternalNoParametersTestLanguage.g:365:8: lv_scenario_22_0= ruleScenario4_True
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4_TrueParserRuleCall_1_9_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_22_0=ruleScenario4_True();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalNoParametersTestLanguage.g:379:6: ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? )
                            {
                            // PsiInternalNoParametersTestLanguage.g:379:6: ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? )
                            // PsiInternalNoParametersTestLanguage.g:380:7: ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )?
                            {
                            // PsiInternalNoParametersTestLanguage.g:380:7: ( (lv_scenario_23_0= ruleScenario2_False ) )
                            // PsiInternalNoParametersTestLanguage.g:381:8: (lv_scenario_23_0= ruleScenario2_False )
                            {
                            // PsiInternalNoParametersTestLanguage.g:381:8: (lv_scenario_23_0= ruleScenario2_False )
                            // PsiInternalNoParametersTestLanguage.g:382:9: lv_scenario_23_0= ruleScenario2_False
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_FalseParserRuleCall_1_9_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_23_0=ruleScenario2_False();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              									if(!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }

                            }


                            }

                            // PsiInternalNoParametersTestLanguage.g:395:7: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // PsiInternalNoParametersTestLanguage.g:396:8: otherlv_24= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_9_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // PsiInternalNoParametersTestLanguage.g:408:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:408:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) )
                    // PsiInternalNoParametersTestLanguage.g:409:5: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitOneKeyword_1_10_0ElementType());
                      				
                    }
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_25);
                      				
                    }
                    // PsiInternalNoParametersTestLanguage.g:416:5: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==20) ) {
                            int LA6_3 = input.LA(3);

                            if ( (synpred5_PsiInternalNoParametersTestLanguage()) ) {
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
                            // PsiInternalNoParametersTestLanguage.g:417:6: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) )
                            {
                            // PsiInternalNoParametersTestLanguage.g:417:6: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) )
                            // PsiInternalNoParametersTestLanguage.g:418:7: ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False )
                            {
                            // PsiInternalNoParametersTestLanguage.g:422:7: (lv_scenario_26_0= ruleScenario4_False )
                            // PsiInternalNoParametersTestLanguage.g:423:8: lv_scenario_26_0= ruleScenario4_False
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4_FalseParserRuleCall_1_10_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_26_0=ruleScenario4_False();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalNoParametersTestLanguage.g:437:6: ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? )
                            {
                            // PsiInternalNoParametersTestLanguage.g:437:6: ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? )
                            // PsiInternalNoParametersTestLanguage.g:438:7: ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )?
                            {
                            // PsiInternalNoParametersTestLanguage.g:438:7: ( (lv_scenario_27_0= ruleScenario2_True ) )
                            // PsiInternalNoParametersTestLanguage.g:439:8: (lv_scenario_27_0= ruleScenario2_True )
                            {
                            // PsiInternalNoParametersTestLanguage.g:439:8: (lv_scenario_27_0= ruleScenario2_True )
                            // PsiInternalNoParametersTestLanguage.g:440:9: lv_scenario_27_0= ruleScenario2_True
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_TrueParserRuleCall_1_10_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_27_0=ruleScenario2_True();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              									if(!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }

                            }


                            }

                            // PsiInternalNoParametersTestLanguage.g:453:7: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // PsiInternalNoParametersTestLanguage.g:454:8: otherlv_28= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_10_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_28=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // PsiInternalNoParametersTestLanguage.g:466:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:466:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) )
                    // PsiInternalNoParametersTestLanguage.g:467:5: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitTwoKeyword_1_11_0ElementType());
                      				
                    }
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_29);
                      				
                    }
                    // PsiInternalNoParametersTestLanguage.g:474:5: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_2 = input.LA(3);

                            if ( (synpred6_PsiInternalNoParametersTestLanguage()) ) {
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
                            // PsiInternalNoParametersTestLanguage.g:475:6: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) )
                            {
                            // PsiInternalNoParametersTestLanguage.g:475:6: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) )
                            // PsiInternalNoParametersTestLanguage.g:476:7: ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False )
                            {
                            // PsiInternalNoParametersTestLanguage.g:480:7: (lv_scenario_30_0= ruleScenario4_False )
                            // PsiInternalNoParametersTestLanguage.g:481:8: lv_scenario_30_0= ruleScenario4_False
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4_FalseParserRuleCall_1_11_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_30_0=ruleScenario4_False();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalNoParametersTestLanguage.g:495:6: ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? )
                            {
                            // PsiInternalNoParametersTestLanguage.g:495:6: ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? )
                            // PsiInternalNoParametersTestLanguage.g:496:7: ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )?
                            {
                            // PsiInternalNoParametersTestLanguage.g:496:7: ( (lv_scenario_31_0= ruleScenario2_False ) )
                            // PsiInternalNoParametersTestLanguage.g:497:8: (lv_scenario_31_0= ruleScenario2_False )
                            {
                            // PsiInternalNoParametersTestLanguage.g:497:8: (lv_scenario_31_0= ruleScenario2_False )
                            // PsiInternalNoParametersTestLanguage.g:498:9: lv_scenario_31_0= ruleScenario2_False
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_FalseParserRuleCall_1_11_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_31_0=ruleScenario2_False();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              									if(!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }

                            }


                            }

                            // PsiInternalNoParametersTestLanguage.g:511:7: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // PsiInternalNoParametersTestLanguage.g:512:8: otherlv_32= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_11_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleParserRuleParameters"


    // $ANTLR start "entryRuleScenario1_True"
    // PsiInternalNoParametersTestLanguage.g:528:1: entryRuleScenario1_True returns [Boolean current=false] : iv_ruleScenario1_True= ruleScenario1_True EOF ;
    public final Boolean entryRuleScenario1_True() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario1_True = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:528:56: (iv_ruleScenario1_True= ruleScenario1_True EOF )
            // PsiInternalNoParametersTestLanguage.g:529:2: iv_ruleScenario1_True= ruleScenario1_True EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario1_TrueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario1_True=ruleScenario1_True();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario1_True; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario1_True"


    // $ANTLR start "ruleScenario1_True"
    // PsiInternalNoParametersTestLanguage.g:535:1: ruleScenario1_True returns [Boolean current=false] : ( (lv_first_0_0= RULE_ID ) ) ;
    public final Boolean ruleScenario1_True() throws RecognitionException {
        Boolean current = false;

        Token lv_first_0_0=null;

        try {
            // PsiInternalNoParametersTestLanguage.g:536:1: ( ( (lv_first_0_0= RULE_ID ) ) )
            // PsiInternalNoParametersTestLanguage.g:537:2: ( (lv_first_0_0= RULE_ID ) )
            {
            // PsiInternalNoParametersTestLanguage.g:537:2: ( (lv_first_0_0= RULE_ID ) )
            // PsiInternalNoParametersTestLanguage.g:538:3: (lv_first_0_0= RULE_ID )
            {
            // PsiInternalNoParametersTestLanguage.g:538:3: (lv_first_0_0= RULE_ID )
            // PsiInternalNoParametersTestLanguage.g:539:4: lv_first_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getScenario1_True_FirstIDTerminalRuleCall_0ElementType());
              			
            }
            if ( state.backtracking==0 ) {

              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
            }
            lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleScenario1_True"


    // $ANTLR start "entryRuleScenario1_False"
    // PsiInternalNoParametersTestLanguage.g:557:1: entryRuleScenario1_False returns [Boolean current=false] : iv_ruleScenario1_False= ruleScenario1_False EOF ;
    public final Boolean entryRuleScenario1_False() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario1_False = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:557:57: (iv_ruleScenario1_False= ruleScenario1_False EOF )
            // PsiInternalNoParametersTestLanguage.g:558:2: iv_ruleScenario1_False= ruleScenario1_False EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario1_FalseElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario1_False=ruleScenario1_False();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario1_False; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario1_False"


    // $ANTLR start "ruleScenario1_False"
    // PsiInternalNoParametersTestLanguage.g:564:1: ruleScenario1_False returns [Boolean current=false] : ( (lv_second_0_0= RULE_ID ) ) ;
    public final Boolean ruleScenario1_False() throws RecognitionException {
        Boolean current = false;

        Token lv_second_0_0=null;

        try {
            // PsiInternalNoParametersTestLanguage.g:565:1: ( ( (lv_second_0_0= RULE_ID ) ) )
            // PsiInternalNoParametersTestLanguage.g:566:2: ( (lv_second_0_0= RULE_ID ) )
            {
            // PsiInternalNoParametersTestLanguage.g:566:2: ( (lv_second_0_0= RULE_ID ) )
            // PsiInternalNoParametersTestLanguage.g:567:3: (lv_second_0_0= RULE_ID )
            {
            // PsiInternalNoParametersTestLanguage.g:567:3: (lv_second_0_0= RULE_ID )
            // PsiInternalNoParametersTestLanguage.g:568:4: lv_second_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getScenario1_False_SecondIDTerminalRuleCall_0ElementType());
              			
            }
            if ( state.backtracking==0 ) {

              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
            }
            lv_second_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleScenario1_False"


    // $ANTLR start "entryRuleScenario2_True"
    // PsiInternalNoParametersTestLanguage.g:586:1: entryRuleScenario2_True returns [Boolean current=false] : iv_ruleScenario2_True= ruleScenario2_True EOF ;
    public final Boolean entryRuleScenario2_True() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario2_True = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:586:56: (iv_ruleScenario2_True= ruleScenario2_True EOF )
            // PsiInternalNoParametersTestLanguage.g:587:2: iv_ruleScenario2_True= ruleScenario2_True EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario2_TrueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario2_True=ruleScenario2_True();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario2_True; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario2_True"


    // $ANTLR start "ruleScenario2_True"
    // PsiInternalNoParametersTestLanguage.g:593:1: ruleScenario2_True returns [Boolean current=false] : ( (lv_first_0_0= ruleIdOrKeyword_True ) ) ;
    public final Boolean ruleScenario2_True() throws RecognitionException {
        Boolean current = false;

        Boolean lv_first_0_0 = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:594:1: ( ( (lv_first_0_0= ruleIdOrKeyword_True ) ) )
            // PsiInternalNoParametersTestLanguage.g:595:2: ( (lv_first_0_0= ruleIdOrKeyword_True ) )
            {
            // PsiInternalNoParametersTestLanguage.g:595:2: ( (lv_first_0_0= ruleIdOrKeyword_True ) )
            // PsiInternalNoParametersTestLanguage.g:596:3: (lv_first_0_0= ruleIdOrKeyword_True )
            {
            // PsiInternalNoParametersTestLanguage.g:596:3: (lv_first_0_0= ruleIdOrKeyword_True )
            // PsiInternalNoParametersTestLanguage.g:597:4: lv_first_0_0= ruleIdOrKeyword_True
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getScenario2_True_FirstIdOrKeyword_TrueParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=ruleIdOrKeyword_True();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneComposite();
              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
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
        return current;
    }
    // $ANTLR end "ruleScenario2_True"


    // $ANTLR start "entryRuleScenario2_False"
    // PsiInternalNoParametersTestLanguage.g:613:1: entryRuleScenario2_False returns [Boolean current=false] : iv_ruleScenario2_False= ruleScenario2_False EOF ;
    public final Boolean entryRuleScenario2_False() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario2_False = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:613:57: (iv_ruleScenario2_False= ruleScenario2_False EOF )
            // PsiInternalNoParametersTestLanguage.g:614:2: iv_ruleScenario2_False= ruleScenario2_False EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario2_FalseElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario2_False=ruleScenario2_False();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario2_False; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario2_False"


    // $ANTLR start "ruleScenario2_False"
    // PsiInternalNoParametersTestLanguage.g:620:1: ruleScenario2_False returns [Boolean current=false] : ( (lv_first_0_0= ruleIdOrKeyword_False ) ) ;
    public final Boolean ruleScenario2_False() throws RecognitionException {
        Boolean current = false;

        Boolean lv_first_0_0 = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:621:1: ( ( (lv_first_0_0= ruleIdOrKeyword_False ) ) )
            // PsiInternalNoParametersTestLanguage.g:622:2: ( (lv_first_0_0= ruleIdOrKeyword_False ) )
            {
            // PsiInternalNoParametersTestLanguage.g:622:2: ( (lv_first_0_0= ruleIdOrKeyword_False ) )
            // PsiInternalNoParametersTestLanguage.g:623:3: (lv_first_0_0= ruleIdOrKeyword_False )
            {
            // PsiInternalNoParametersTestLanguage.g:623:3: (lv_first_0_0= ruleIdOrKeyword_False )
            // PsiInternalNoParametersTestLanguage.g:624:4: lv_first_0_0= ruleIdOrKeyword_False
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getScenario2_False_FirstIdOrKeyword_FalseParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=ruleIdOrKeyword_False();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneComposite();
              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
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
        return current;
    }
    // $ANTLR end "ruleScenario2_False"


    // $ANTLR start "entryRuleScenario3_True"
    // PsiInternalNoParametersTestLanguage.g:640:1: entryRuleScenario3_True returns [Boolean current=false] : iv_ruleScenario3_True= ruleScenario3_True EOF ;
    public final Boolean entryRuleScenario3_True() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario3_True = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:640:56: (iv_ruleScenario3_True= ruleScenario3_True EOF )
            // PsiInternalNoParametersTestLanguage.g:641:2: iv_ruleScenario3_True= ruleScenario3_True EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario3_TrueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario3_True=ruleScenario3_True();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario3_True; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario3_True"


    // $ANTLR start "ruleScenario3_True"
    // PsiInternalNoParametersTestLanguage.g:647:1: ruleScenario3_True returns [Boolean current=false] : ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final Boolean ruleScenario3_True() throws RecognitionException {
        Boolean current = false;

        Token lv_second_1_0=null;
        Boolean lv_first_0_0 = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:648:1: ( ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // PsiInternalNoParametersTestLanguage.g:649:2: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // PsiInternalNoParametersTestLanguage.g:649:2: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                int LA10_1 = input.LA(2);

                if ( (synpred7_PsiInternalNoParametersTestLanguage()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA10_0==RULE_ID) && (synpred7_PsiInternalNoParametersTestLanguage())) {
                alt10=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalNoParametersTestLanguage.g:650:3: ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:650:3: ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) )
                    // PsiInternalNoParametersTestLanguage.g:651:4: ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True )
                    {
                    // PsiInternalNoParametersTestLanguage.g:655:4: (lv_first_0_0= ruleIdOrKeyword_True )
                    // PsiInternalNoParametersTestLanguage.g:656:5: lv_first_0_0= ruleIdOrKeyword_True
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getScenario3_True_FirstIdOrKeyword_TrueParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=ruleIdOrKeyword_True();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalNoParametersTestLanguage.g:670:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:670:3: ( (lv_second_1_0= 'keyword' ) )
                    // PsiInternalNoParametersTestLanguage.g:671:4: (lv_second_1_0= 'keyword' )
                    {
                    // PsiInternalNoParametersTestLanguage.g:671:4: (lv_second_1_0= 'keyword' )
                    // PsiInternalNoParametersTestLanguage.g:672:5: lv_second_1_0= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getScenario3_True_SecondKeywordKeyword_1_0ElementType());
                      				
                    }
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_second_1_0);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
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
        return current;
    }
    // $ANTLR end "ruleScenario3_True"


    // $ANTLR start "entryRuleScenario3_False"
    // PsiInternalNoParametersTestLanguage.g:691:1: entryRuleScenario3_False returns [Boolean current=false] : iv_ruleScenario3_False= ruleScenario3_False EOF ;
    public final Boolean entryRuleScenario3_False() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario3_False = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:691:57: (iv_ruleScenario3_False= ruleScenario3_False EOF )
            // PsiInternalNoParametersTestLanguage.g:692:2: iv_ruleScenario3_False= ruleScenario3_False EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario3_FalseElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario3_False=ruleScenario3_False();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario3_False; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario3_False"


    // $ANTLR start "ruleScenario3_False"
    // PsiInternalNoParametersTestLanguage.g:698:1: ruleScenario3_False returns [Boolean current=false] : ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final Boolean ruleScenario3_False() throws RecognitionException {
        Boolean current = false;

        Token lv_second_1_0=null;
        Boolean lv_first_0_0 = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:699:1: ( ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // PsiInternalNoParametersTestLanguage.g:700:2: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // PsiInternalNoParametersTestLanguage.g:700:2: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) && (synpred8_PsiInternalNoParametersTestLanguage())) {
                alt11=1;
            }
            else if ( (LA11_0==20) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalNoParametersTestLanguage.g:701:3: ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:701:3: ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) )
                    // PsiInternalNoParametersTestLanguage.g:702:4: ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False )
                    {
                    // PsiInternalNoParametersTestLanguage.g:706:4: (lv_first_0_0= ruleIdOrKeyword_False )
                    // PsiInternalNoParametersTestLanguage.g:707:5: lv_first_0_0= ruleIdOrKeyword_False
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getScenario3_False_FirstIdOrKeyword_FalseParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=ruleIdOrKeyword_False();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalNoParametersTestLanguage.g:721:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // PsiInternalNoParametersTestLanguage.g:721:3: ( (lv_second_1_0= 'keyword' ) )
                    // PsiInternalNoParametersTestLanguage.g:722:4: (lv_second_1_0= 'keyword' )
                    {
                    // PsiInternalNoParametersTestLanguage.g:722:4: (lv_second_1_0= 'keyword' )
                    // PsiInternalNoParametersTestLanguage.g:723:5: lv_second_1_0= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getScenario3_False_SecondKeywordKeyword_1_0ElementType());
                      				
                    }
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_second_1_0);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
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
        return current;
    }
    // $ANTLR end "ruleScenario3_False"


    // $ANTLR start "entryRuleScenario4_True"
    // PsiInternalNoParametersTestLanguage.g:742:1: entryRuleScenario4_True returns [Boolean current=false] : iv_ruleScenario4_True= ruleScenario4_True EOF ;
    public final Boolean entryRuleScenario4_True() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario4_True = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:742:56: (iv_ruleScenario4_True= ruleScenario4_True EOF )
            // PsiInternalNoParametersTestLanguage.g:743:2: iv_ruleScenario4_True= ruleScenario4_True EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario4_TrueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario4_True=ruleScenario4_True();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario4_True; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario4_True"


    // $ANTLR start "ruleScenario4_True"
    // PsiInternalNoParametersTestLanguage.g:749:1: ruleScenario4_True returns [Boolean current=false] : ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' ) ;
    public final Boolean ruleScenario4_True() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_second_0_0 = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:750:1: ( ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' ) )
            // PsiInternalNoParametersTestLanguage.g:751:2: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' )
            {
            // PsiInternalNoParametersTestLanguage.g:751:2: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' )
            // PsiInternalNoParametersTestLanguage.g:752:3: ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword'
            {
            // PsiInternalNoParametersTestLanguage.g:752:3: ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) )
            // PsiInternalNoParametersTestLanguage.g:753:4: ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True )
            {
            // PsiInternalNoParametersTestLanguage.g:757:4: (lv_second_0_0= ruleIdOrKeyword_True )
            // PsiInternalNoParametersTestLanguage.g:758:5: lv_second_0_0= ruleIdOrKeyword_True
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getScenario4_True_SecondIdOrKeyword_TrueParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=ruleIdOrKeyword_True();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getScenario4_True_KeywordKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleScenario4_True"


    // $ANTLR start "entryRuleScenario4_False"
    // PsiInternalNoParametersTestLanguage.g:782:1: entryRuleScenario4_False returns [Boolean current=false] : iv_ruleScenario4_False= ruleScenario4_False EOF ;
    public final Boolean entryRuleScenario4_False() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario4_False = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:782:57: (iv_ruleScenario4_False= ruleScenario4_False EOF )
            // PsiInternalNoParametersTestLanguage.g:783:2: iv_ruleScenario4_False= ruleScenario4_False EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario4_FalseElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario4_False=ruleScenario4_False();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario4_False; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario4_False"


    // $ANTLR start "ruleScenario4_False"
    // PsiInternalNoParametersTestLanguage.g:789:1: ruleScenario4_False returns [Boolean current=false] : ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' ) ;
    public final Boolean ruleScenario4_False() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_second_0_0 = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:790:1: ( ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' ) )
            // PsiInternalNoParametersTestLanguage.g:791:2: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' )
            {
            // PsiInternalNoParametersTestLanguage.g:791:2: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' )
            // PsiInternalNoParametersTestLanguage.g:792:3: ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword'
            {
            // PsiInternalNoParametersTestLanguage.g:792:3: ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) )
            // PsiInternalNoParametersTestLanguage.g:793:4: ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False )
            {
            // PsiInternalNoParametersTestLanguage.g:797:4: (lv_second_0_0= ruleIdOrKeyword_False )
            // PsiInternalNoParametersTestLanguage.g:798:5: lv_second_0_0= ruleIdOrKeyword_False
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getScenario4_False_SecondIdOrKeyword_FalseParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=ruleIdOrKeyword_False();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getScenario4_False_KeywordKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleScenario4_False"


    // $ANTLR start "entryRuleIdOrKeyword_True"
    // PsiInternalNoParametersTestLanguage.g:822:1: entryRuleIdOrKeyword_True returns [Boolean current=false] : iv_ruleIdOrKeyword_True= ruleIdOrKeyword_True EOF ;
    public final Boolean entryRuleIdOrKeyword_True() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIdOrKeyword_True = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:822:58: (iv_ruleIdOrKeyword_True= ruleIdOrKeyword_True EOF )
            // PsiInternalNoParametersTestLanguage.g:823:2: iv_ruleIdOrKeyword_True= ruleIdOrKeyword_True EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrKeyword_TrueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdOrKeyword_True=ruleIdOrKeyword_True();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKeyword_True; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdOrKeyword_True"


    // $ANTLR start "ruleIdOrKeyword_True"
    // PsiInternalNoParametersTestLanguage.g:829:1: ruleIdOrKeyword_True returns [Boolean current=false] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final Boolean ruleIdOrKeyword_True() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalNoParametersTestLanguage.g:830:1: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // PsiInternalNoParametersTestLanguage.g:831:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // PsiInternalNoParametersTestLanguage.g:831:2: (kw= 'keyword' | this_ID_1= RULE_ID )
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
                    // PsiInternalNoParametersTestLanguage.g:832:3: kw= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_True_KeywordKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalNoParametersTestLanguage.g:840:3: this_ID_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_True_IDTerminalRuleCall_1ElementType());
                      		
                    }
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleIdOrKeyword_True"


    // $ANTLR start "entryRuleIdOrKeyword_False"
    // PsiInternalNoParametersTestLanguage.g:851:1: entryRuleIdOrKeyword_False returns [Boolean current=false] : iv_ruleIdOrKeyword_False= ruleIdOrKeyword_False EOF ;
    public final Boolean entryRuleIdOrKeyword_False() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIdOrKeyword_False = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:851:59: (iv_ruleIdOrKeyword_False= ruleIdOrKeyword_False EOF )
            // PsiInternalNoParametersTestLanguage.g:852:2: iv_ruleIdOrKeyword_False= ruleIdOrKeyword_False EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrKeyword_FalseElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdOrKeyword_False=ruleIdOrKeyword_False();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKeyword_False; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdOrKeyword_False"


    // $ANTLR start "ruleIdOrKeyword_False"
    // PsiInternalNoParametersTestLanguage.g:858:1: ruleIdOrKeyword_False returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleIdOrKeyword_False() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalNoParametersTestLanguage.g:859:1: (this_ID_0= RULE_ID )
            // PsiInternalNoParametersTestLanguage.g:860:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getIdOrKeyword_False_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleIdOrKeyword_False"


    // $ANTLR start "entryRuleIdOrKeyword"
    // PsiInternalNoParametersTestLanguage.g:870:1: entryRuleIdOrKeyword returns [Boolean current=false] : iv_ruleIdOrKeyword= ruleIdOrKeyword EOF ;
    public final Boolean entryRuleIdOrKeyword() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIdOrKeyword = null;


        try {
            // PsiInternalNoParametersTestLanguage.g:870:53: (iv_ruleIdOrKeyword= ruleIdOrKeyword EOF )
            // PsiInternalNoParametersTestLanguage.g:871:2: iv_ruleIdOrKeyword= ruleIdOrKeyword EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrKeywordElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdOrKeyword=ruleIdOrKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKeyword; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdOrKeyword"


    // $ANTLR start "ruleIdOrKeyword"
    // PsiInternalNoParametersTestLanguage.g:877:1: ruleIdOrKeyword returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleIdOrKeyword() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalNoParametersTestLanguage.g:878:1: (this_ID_0= RULE_ID )
            // PsiInternalNoParametersTestLanguage.g:879:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getIdOrKeyword_IDTerminalRuleCall_1ElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleIdOrKeyword"


    // $ANTLR start "norm1_IdOrKeyword"
    // PsiInternalNoParametersTestLanguage.g:890:1: norm1_IdOrKeyword returns [Boolean current=false] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final Boolean norm1_IdOrKeyword() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalNoParametersTestLanguage.g:891:1: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // PsiInternalNoParametersTestLanguage.g:892:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // PsiInternalNoParametersTestLanguage.g:892:2: (kw= 'keyword' | this_ID_1= RULE_ID )
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
                    // PsiInternalNoParametersTestLanguage.g:893:3: kw= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_KeywordKeyword_0_0ElementType());
                      		
                    }
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalNoParametersTestLanguage.g:901:3: this_ID_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_IDTerminalRuleCall_1ElementType());
                      		
                    }
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "norm1_IdOrKeyword"

    // $ANTLR start synpred1_PsiInternalNoParametersTestLanguage
    public final void synpred1_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalNoParametersTestLanguage.g:171:5: ( ( '#5' ( ( ruleScenario2_True ) ) ) )
        // PsiInternalNoParametersTestLanguage.g:171:6: ( '#5' ( ( ruleScenario2_True ) ) )
        {
        // PsiInternalNoParametersTestLanguage.g:171:6: ( '#5' ( ( ruleScenario2_True ) ) )
        // PsiInternalNoParametersTestLanguage.g:172:6: '#5' ( ( ruleScenario2_True ) )
        {
        match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // PsiInternalNoParametersTestLanguage.g:173:6: ( ( ruleScenario2_True ) )
        // PsiInternalNoParametersTestLanguage.g:174:7: ( ruleScenario2_True )
        {
        // PsiInternalNoParametersTestLanguage.g:174:7: ( ruleScenario2_True )
        // PsiInternalNoParametersTestLanguage.g:175:8: ruleScenario2_True
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleScenario2_True();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred2_PsiInternalNoParametersTestLanguage
    public final void synpred2_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalNoParametersTestLanguage.g:207:5: ( ( '#6' ( ( ruleScenario2_False ) ) ) )
        // PsiInternalNoParametersTestLanguage.g:207:6: ( '#6' ( ( ruleScenario2_False ) ) )
        {
        // PsiInternalNoParametersTestLanguage.g:207:6: ( '#6' ( ( ruleScenario2_False ) ) )
        // PsiInternalNoParametersTestLanguage.g:208:6: '#6' ( ( ruleScenario2_False ) )
        {
        match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
        // PsiInternalNoParametersTestLanguage.g:209:6: ( ( ruleScenario2_False ) )
        // PsiInternalNoParametersTestLanguage.g:210:7: ( ruleScenario2_False )
        {
        // PsiInternalNoParametersTestLanguage.g:210:7: ( ruleScenario2_False )
        // PsiInternalNoParametersTestLanguage.g:211:8: ruleScenario2_False
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleScenario2_False();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred3_PsiInternalNoParametersTestLanguage
    public final void synpred3_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalNoParametersTestLanguage.g:302:7: ( ( ruleIdOrKeyword_True ) )
        // PsiInternalNoParametersTestLanguage.g:302:8: ( ruleIdOrKeyword_True )
        {
        // PsiInternalNoParametersTestLanguage.g:302:8: ( ruleIdOrKeyword_True )
        // PsiInternalNoParametersTestLanguage.g:303:8: ruleIdOrKeyword_True
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_True();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred4_PsiInternalNoParametersTestLanguage
    public final void synpred4_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalNoParametersTestLanguage.g:360:7: ( ( ruleIdOrKeyword_True ) )
        // PsiInternalNoParametersTestLanguage.g:360:8: ( ruleIdOrKeyword_True )
        {
        // PsiInternalNoParametersTestLanguage.g:360:8: ( ruleIdOrKeyword_True )
        // PsiInternalNoParametersTestLanguage.g:361:8: ruleIdOrKeyword_True
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_True();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred5_PsiInternalNoParametersTestLanguage
    public final void synpred5_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalNoParametersTestLanguage.g:418:7: ( ( ruleIdOrKeyword_False ) )
        // PsiInternalNoParametersTestLanguage.g:418:8: ( ruleIdOrKeyword_False )
        {
        // PsiInternalNoParametersTestLanguage.g:418:8: ( ruleIdOrKeyword_False )
        // PsiInternalNoParametersTestLanguage.g:419:8: ruleIdOrKeyword_False
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_False();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred6_PsiInternalNoParametersTestLanguage
    public final void synpred6_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalNoParametersTestLanguage.g:476:7: ( ( ruleIdOrKeyword_False ) )
        // PsiInternalNoParametersTestLanguage.g:476:8: ( ruleIdOrKeyword_False )
        {
        // PsiInternalNoParametersTestLanguage.g:476:8: ( ruleIdOrKeyword_False )
        // PsiInternalNoParametersTestLanguage.g:477:8: ruleIdOrKeyword_False
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_False();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred7_PsiInternalNoParametersTestLanguage
    public final void synpred7_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalNoParametersTestLanguage.g:651:4: ( ( ruleIdOrKeyword_True ) )
        // PsiInternalNoParametersTestLanguage.g:651:5: ( ruleIdOrKeyword_True )
        {
        // PsiInternalNoParametersTestLanguage.g:651:5: ( ruleIdOrKeyword_True )
        // PsiInternalNoParametersTestLanguage.g:652:5: ruleIdOrKeyword_True
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_True();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred8_PsiInternalNoParametersTestLanguage
    public final void synpred8_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalNoParametersTestLanguage.g:702:4: ( ( ruleIdOrKeyword_False ) )
        // PsiInternalNoParametersTestLanguage.g:702:5: ( ruleIdOrKeyword_False )
        {
        // PsiInternalNoParametersTestLanguage.g:702:5: ( ruleIdOrKeyword_False )
        // PsiInternalNoParametersTestLanguage.g:703:5: ruleIdOrKeyword_False
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_False();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_PsiInternalNoParametersTestLanguage

    // Delegated rules

    public final boolean synpred4_PsiInternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PsiInternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_PsiInternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PsiInternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_PsiInternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_PsiInternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_PsiInternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_PsiInternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PsiInternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_PsiInternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_PsiInternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_PsiInternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PsiInternalNoParametersTestLanguage_fragment(); // can never throw exception
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
            return "69:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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

                        else if ( (LA9_0==15) && (synpred1_PsiInternalNoParametersTestLanguage())) {s = 5;}

                        else if ( (LA9_0==16) && (synpred2_PsiInternalNoParametersTestLanguage())) {s = 6;}

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