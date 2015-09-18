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
    		return "ParserRuleParameters";
    	}




    // $ANTLR start "entryRuleParserRuleParameters"
    // PsiInternalParametersTestLanguageEx.g:52:1: entryRuleParserRuleParameters : ruleParserRuleParameters EOF ;
    public final void entryRuleParserRuleParameters() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:52:30: ( ruleParserRuleParameters EOF )
            // PsiInternalParametersTestLanguageEx.g:53:2: ruleParserRuleParameters EOF
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
    // PsiInternalParametersTestLanguageEx.g:58:1: ruleParserRuleParameters : superParserRuleParameters ;
    public final void ruleParserRuleParameters() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:58:25: ( superParserRuleParameters )
            // PsiInternalParametersTestLanguageEx.g:59:2: superParserRuleParameters
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getParserRuleParameters_ParserRuleParametersParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            superParserRuleParameters();

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
    // $ANTLR end "ruleParserRuleParameters"


    // $ANTLR start "entryRuleScenario1"
    // PsiInternalParametersTestLanguageEx.g:69:1: entryRuleScenario1 : ruleScenario1 EOF ;
    public final void entryRuleScenario1() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:69:19: ( ruleScenario1 EOF )
            // PsiInternalParametersTestLanguageEx.g:70:2: ruleScenario1 EOF
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
    // PsiInternalParametersTestLanguageEx.g:75:1: ruleScenario1 : superScenario1 ;
    public final void ruleScenario1() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:75:14: ( superScenario1 )
            // PsiInternalParametersTestLanguageEx.g:76:2: superScenario1
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getScenario1_Scenario1ParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            superScenario1();

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
    // $ANTLR end "ruleScenario1"


    // $ANTLR start "norm1_Scenario1"
    // PsiInternalParametersTestLanguageEx.g:87:1: norm1_Scenario1 : normSuper1_Scenario1 ;
    public final void norm1_Scenario1() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:87:16: ( normSuper1_Scenario1 )
            // PsiInternalParametersTestLanguageEx.g:88:2: normSuper1_Scenario1
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getScenario1_Scenario1ParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            normSuper1_Scenario1();

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
    // $ANTLR end "norm1_Scenario1"


    // $ANTLR start "entrySuperParserRuleParameters"
    // PsiInternalParametersTestLanguageEx.g:98:1: entrySuperParserRuleParameters : superParserRuleParameters EOF ;
    public final void entrySuperParserRuleParameters() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:98:31: ( superParserRuleParameters EOF )
            // PsiInternalParametersTestLanguageEx.g:99:2: superParserRuleParameters EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParametersElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            superParserRuleParameters();

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
    // $ANTLR end "entrySuperParserRuleParameters"


    // $ANTLR start "superParserRuleParameters"
    // PsiInternalParametersTestLanguageEx.g:104:1: superParserRuleParameters : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
    public final void superParserRuleParameters() throws RecognitionException {
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
            // PsiInternalParametersTestLanguageEx.g:104:26: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:105:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:105:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:106:3: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:106:3: ()
            // PsiInternalParametersTestLanguageEx.g:107:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ParserRuleParametersAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalParametersTestLanguageEx.g:112:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // PsiInternalParametersTestLanguageEx.g:113:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:113:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:114:5: otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:121:5: ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    // PsiInternalParametersTestLanguageEx.g:122:6: (lv_scenario_2_0= norm1_Scenario1 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:122:6: (lv_scenario_2_0= norm1_Scenario1 )
                    // PsiInternalParametersTestLanguageEx.g:123:7: lv_scenario_2_0= norm1_Scenario1
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario1ParserRuleCall_1_0_1_0ElementType());
                      						
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
                    // PsiInternalParametersTestLanguageEx.g:134:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:134:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:135:5: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:142:5: ( (lv_scenario_4_0= ruleScenario1 ) )
                    // PsiInternalParametersTestLanguageEx.g:143:6: (lv_scenario_4_0= ruleScenario1 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:143:6: (lv_scenario_4_0= ruleScenario1 )
                    // PsiInternalParametersTestLanguageEx.g:144:7: lv_scenario_4_0= ruleScenario1
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario1ParserRuleCall_1_1_1_0ElementType());
                      						
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
                    // PsiInternalParametersTestLanguageEx.g:155:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:155:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:156:5: otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_5);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:163:5: ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:164:6: (lv_scenario_6_0= norm1_Scenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:164:6: (lv_scenario_6_0= norm1_Scenario2 )
                    // PsiInternalParametersTestLanguageEx.g:165:7: lv_scenario_6_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_2_1_0ElementType());
                      						
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
                    // PsiInternalParametersTestLanguageEx.g:176:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:176:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:177:5: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:184:5: ( (lv_scenario_8_0= ruleScenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:185:6: (lv_scenario_8_0= ruleScenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:185:6: (lv_scenario_8_0= ruleScenario2 )
                    // PsiInternalParametersTestLanguageEx.g:186:7: lv_scenario_8_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_3_1_0ElementType());
                      						
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
                    // PsiInternalParametersTestLanguageEx.g:197:4: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:197:4: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    // PsiInternalParametersTestLanguageEx.g:198:5: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:207:5: (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:208:6: otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitFiveKeyword_1_4_0_0ElementType());
                      					
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_9);
                      					
                    }
                    // PsiInternalParametersTestLanguageEx.g:215:6: ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:216:7: (lv_scenario_10_0= norm1_Scenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:216:7: (lv_scenario_10_0= norm1_Scenario2 )
                    // PsiInternalParametersTestLanguageEx.g:217:8: lv_scenario_10_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_4_0_1_0ElementType());
                      							
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
                    // PsiInternalParametersTestLanguageEx.g:229:4: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:229:4: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    // PsiInternalParametersTestLanguageEx.g:230:5: ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:239:5: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:240:6: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitSixKeyword_1_5_0_0ElementType());
                      					
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_11);
                      					
                    }
                    // PsiInternalParametersTestLanguageEx.g:247:6: ( (lv_scenario_12_0= ruleScenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:248:7: (lv_scenario_12_0= ruleScenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:248:7: (lv_scenario_12_0= ruleScenario2 )
                    // PsiInternalParametersTestLanguageEx.g:249:8: lv_scenario_12_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_5_0_1_0ElementType());
                      							
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
                    // PsiInternalParametersTestLanguageEx.g:261:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:261:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:262:5: otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitSevenKeyword_1_6_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:269:5: ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    // PsiInternalParametersTestLanguageEx.g:270:6: (lv_scenario_14_0= norm1_Scenario3 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:270:6: (lv_scenario_14_0= norm1_Scenario3 )
                    // PsiInternalParametersTestLanguageEx.g:271:7: lv_scenario_14_0= norm1_Scenario3
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario3ParserRuleCall_1_6_1_0ElementType());
                      						
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
                    // PsiInternalParametersTestLanguageEx.g:282:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:282:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:283:5: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitEightKeyword_1_7_0ElementType());
                      				
                    }
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_15);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:290:5: ( (lv_scenario_16_0= ruleScenario3 ) )
                    // PsiInternalParametersTestLanguageEx.g:291:6: (lv_scenario_16_0= ruleScenario3 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:291:6: (lv_scenario_16_0= ruleScenario3 )
                    // PsiInternalParametersTestLanguageEx.g:292:7: lv_scenario_16_0= ruleScenario3
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario3ParserRuleCall_1_7_1_0ElementType());
                      						
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
                    // PsiInternalParametersTestLanguageEx.g:303:4: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:303:4: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:304:5: otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitNineKeyword_1_8_0ElementType());
                      				
                    }
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_17);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:311:5: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) )
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
                            // PsiInternalParametersTestLanguageEx.g:312:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:312:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:313:7: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:317:7: (lv_scenario_18_0= norm1_Scenario4 )
                            // PsiInternalParametersTestLanguageEx.g:318:8: lv_scenario_18_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_8_1_0_0ElementType());
                              							
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
                            // PsiInternalParametersTestLanguageEx.g:328:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:328:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:329:7: ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:329:7: ( (lv_scenario_19_0= norm1_Scenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:330:8: (lv_scenario_19_0= norm1_Scenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:330:8: (lv_scenario_19_0= norm1_Scenario2 )
                            // PsiInternalParametersTestLanguageEx.g:331:9: lv_scenario_19_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_8_1_1_0_0ElementType());
                              								
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

                            // PsiInternalParametersTestLanguageEx.g:340:7: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:341:8: otherlv_20= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_KeywordKeyword_1_8_1_1_1ElementType());
                                      							
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
                    // PsiInternalParametersTestLanguageEx.g:353:4: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:353:4: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:354:5: otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitOneDigitZeroKeyword_1_9_0ElementType());
                      				
                    }
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_21);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:361:5: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) )
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
                            // PsiInternalParametersTestLanguageEx.g:362:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:362:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:363:7: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:367:7: (lv_scenario_22_0= norm1_Scenario4 )
                            // PsiInternalParametersTestLanguageEx.g:368:8: lv_scenario_22_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_9_1_0_0ElementType());
                              							
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
                            // PsiInternalParametersTestLanguageEx.g:378:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:378:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:379:7: ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:379:7: ( (lv_scenario_23_0= ruleScenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:380:8: (lv_scenario_23_0= ruleScenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:380:8: (lv_scenario_23_0= ruleScenario2 )
                            // PsiInternalParametersTestLanguageEx.g:381:9: lv_scenario_23_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_9_1_1_0_0ElementType());
                              								
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

                            // PsiInternalParametersTestLanguageEx.g:390:7: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:391:8: otherlv_24= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_KeywordKeyword_1_9_1_1_1ElementType());
                                      							
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
                    // PsiInternalParametersTestLanguageEx.g:403:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:403:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:404:5: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitOneDigitOneKeyword_1_10_0ElementType());
                      				
                    }
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_25);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:411:5: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) )
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
                            // PsiInternalParametersTestLanguageEx.g:412:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:412:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:413:7: ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:417:7: (lv_scenario_26_0= ruleScenario4 )
                            // PsiInternalParametersTestLanguageEx.g:418:8: lv_scenario_26_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_10_1_0_0ElementType());
                              							
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
                            // PsiInternalParametersTestLanguageEx.g:428:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:428:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:429:7: ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:429:7: ( (lv_scenario_27_0= norm1_Scenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:430:8: (lv_scenario_27_0= norm1_Scenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:430:8: (lv_scenario_27_0= norm1_Scenario2 )
                            // PsiInternalParametersTestLanguageEx.g:431:9: lv_scenario_27_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_10_1_1_0_0ElementType());
                              								
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

                            // PsiInternalParametersTestLanguageEx.g:440:7: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:441:8: otherlv_28= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_KeywordKeyword_1_10_1_1_1ElementType());
                                      							
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
                    // PsiInternalParametersTestLanguageEx.g:453:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:453:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:454:5: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitOneDigitTwoKeyword_1_11_0ElementType());
                      				
                    }
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_29);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:461:5: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) )
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
                            // PsiInternalParametersTestLanguageEx.g:462:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:462:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:463:7: ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:467:7: (lv_scenario_30_0= ruleScenario4 )
                            // PsiInternalParametersTestLanguageEx.g:468:8: lv_scenario_30_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_11_1_0_0ElementType());
                              							
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
                            // PsiInternalParametersTestLanguageEx.g:478:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:478:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:479:7: ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:479:7: ( (lv_scenario_31_0= ruleScenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:480:8: (lv_scenario_31_0= ruleScenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:480:8: (lv_scenario_31_0= ruleScenario2 )
                            // PsiInternalParametersTestLanguageEx.g:481:9: lv_scenario_31_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_11_1_1_0_0ElementType());
                              								
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

                            // PsiInternalParametersTestLanguageEx.g:490:7: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:491:8: otherlv_32= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_KeywordKeyword_1_11_1_1_1ElementType());
                                      							
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
    // $ANTLR end "superParserRuleParameters"


    // $ANTLR start "entrySuperScenario1"
    // PsiInternalParametersTestLanguageEx.g:507:1: entrySuperScenario1 : superScenario1 EOF ;
    public final void entrySuperScenario1() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:507:20: ( superScenario1 EOF )
            // PsiInternalParametersTestLanguageEx.g:508:2: superScenario1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParametersTestLanguageScenario1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            superScenario1();

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
    // $ANTLR end "entrySuperScenario1"


    // $ANTLR start "superScenario1"
    // PsiInternalParametersTestLanguageEx.g:513:1: superScenario1 : ( (lv_second_0_0= RULE_ID ) ) ;
    public final void superScenario1() throws RecognitionException {
        Token lv_second_0_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:513:15: ( ( (lv_second_0_0= RULE_ID ) ) )
            // PsiInternalParametersTestLanguageEx.g:514:2: ( (lv_second_0_0= RULE_ID ) )
            {
            // PsiInternalParametersTestLanguageEx.g:514:2: ( (lv_second_0_0= RULE_ID ) )
            // PsiInternalParametersTestLanguageEx.g:515:3: (lv_second_0_0= RULE_ID )
            {
            // PsiInternalParametersTestLanguageEx.g:515:3: (lv_second_0_0= RULE_ID )
            // PsiInternalParametersTestLanguageEx.g:516:4: lv_second_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getParametersTestLanguageScenario1_SecondIDTerminalRuleCall_1_0_0ElementType());
              			
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
    // $ANTLR end "superScenario1"


    // $ANTLR start "normSuper1_Scenario1"
    // PsiInternalParametersTestLanguageEx.g:529:1: normSuper1_Scenario1 : ( (lv_first_0_0= RULE_ID ) ) ;
    public final void normSuper1_Scenario1() throws RecognitionException {
        Token lv_first_0_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:529:21: ( ( (lv_first_0_0= RULE_ID ) ) )
            // PsiInternalParametersTestLanguageEx.g:530:2: ( (lv_first_0_0= RULE_ID ) )
            {
            // PsiInternalParametersTestLanguageEx.g:530:2: ( (lv_first_0_0= RULE_ID ) )
            // PsiInternalParametersTestLanguageEx.g:531:3: (lv_first_0_0= RULE_ID )
            {
            // PsiInternalParametersTestLanguageEx.g:531:3: (lv_first_0_0= RULE_ID )
            // PsiInternalParametersTestLanguageEx.g:532:4: lv_first_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getParametersTestLanguageScenario1_FirstIDTerminalRuleCall_0_0_0ElementType());
              			
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
    // $ANTLR end "normSuper1_Scenario1"


    // $ANTLR start "entryRuleScenario2"
    // PsiInternalParametersTestLanguageEx.g:544:1: entryRuleScenario2 : ruleScenario2 EOF ;
    public final void entryRuleScenario2() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:544:19: ( ruleScenario2 EOF )
            // PsiInternalParametersTestLanguageEx.g:545:2: ruleScenario2 EOF
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
    // PsiInternalParametersTestLanguageEx.g:550:1: ruleScenario2 : ( (lv_first_0_0= ruleIdOrKeyword ) ) ;
    public final void ruleScenario2() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:550:14: ( ( (lv_first_0_0= ruleIdOrKeyword ) ) )
            // PsiInternalParametersTestLanguageEx.g:551:2: ( (lv_first_0_0= ruleIdOrKeyword ) )
            {
            // PsiInternalParametersTestLanguageEx.g:551:2: ( (lv_first_0_0= ruleIdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:552:3: (lv_first_0_0= ruleIdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:552:3: (lv_first_0_0= ruleIdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:553:4: lv_first_0_0= ruleIdOrKeyword
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
    // PsiInternalParametersTestLanguageEx.g:566:1: norm1_Scenario2 : ( (lv_first_0_0= norm1_IdOrKeyword ) ) ;
    public final void norm1_Scenario2() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:566:16: ( ( (lv_first_0_0= norm1_IdOrKeyword ) ) )
            // PsiInternalParametersTestLanguageEx.g:567:2: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            {
            // PsiInternalParametersTestLanguageEx.g:567:2: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:568:3: (lv_first_0_0= norm1_IdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:568:3: (lv_first_0_0= norm1_IdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:569:4: lv_first_0_0= norm1_IdOrKeyword
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
    // PsiInternalParametersTestLanguageEx.g:581:1: entryRuleScenario3 : ruleScenario3 EOF ;
    public final void entryRuleScenario3() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:581:19: ( ruleScenario3 EOF )
            // PsiInternalParametersTestLanguageEx.g:582:2: ruleScenario3 EOF
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
    // PsiInternalParametersTestLanguageEx.g:587:1: ruleScenario3 : ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final void ruleScenario3() throws RecognitionException {
        Token lv_second_1_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:587:14: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:588:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:588:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
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
                    // PsiInternalParametersTestLanguageEx.g:589:3: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:589:3: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    // PsiInternalParametersTestLanguageEx.g:590:4: ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword )
                    {
                    // PsiInternalParametersTestLanguageEx.g:594:4: (lv_first_0_0= ruleIdOrKeyword )
                    // PsiInternalParametersTestLanguageEx.g:595:5: lv_first_0_0= ruleIdOrKeyword
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
                    // PsiInternalParametersTestLanguageEx.g:605:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:605:3: ( (lv_second_1_0= 'keyword' ) )
                    // PsiInternalParametersTestLanguageEx.g:606:4: (lv_second_1_0= 'keyword' )
                    {
                    // PsiInternalParametersTestLanguageEx.g:606:4: (lv_second_1_0= 'keyword' )
                    // PsiInternalParametersTestLanguageEx.g:607:5: lv_second_1_0= 'keyword'
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
    // PsiInternalParametersTestLanguageEx.g:621:1: norm1_Scenario3 : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final void norm1_Scenario3() throws RecognitionException {
        Token lv_second_1_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:621:16: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:622:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:622:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
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
                    // PsiInternalParametersTestLanguageEx.g:623:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:623:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    // PsiInternalParametersTestLanguageEx.g:624:4: ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword )
                    {
                    // PsiInternalParametersTestLanguageEx.g:628:4: (lv_first_0_0= norm1_IdOrKeyword )
                    // PsiInternalParametersTestLanguageEx.g:629:5: lv_first_0_0= norm1_IdOrKeyword
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
                    // PsiInternalParametersTestLanguageEx.g:639:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:639:3: ( (lv_second_1_0= 'keyword' ) )
                    // PsiInternalParametersTestLanguageEx.g:640:4: (lv_second_1_0= 'keyword' )
                    {
                    // PsiInternalParametersTestLanguageEx.g:640:4: (lv_second_1_0= 'keyword' )
                    // PsiInternalParametersTestLanguageEx.g:641:5: lv_second_1_0= 'keyword'
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
    // PsiInternalParametersTestLanguageEx.g:654:1: entryRuleScenario4 : ruleScenario4 EOF ;
    public final void entryRuleScenario4() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:654:19: ( ruleScenario4 EOF )
            // PsiInternalParametersTestLanguageEx.g:655:2: ruleScenario4 EOF
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
    // PsiInternalParametersTestLanguageEx.g:660:1: ruleScenario4 : ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' ) ;
    public final void ruleScenario4() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:660:14: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' ) )
            // PsiInternalParametersTestLanguageEx.g:661:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' )
            {
            // PsiInternalParametersTestLanguageEx.g:661:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' )
            // PsiInternalParametersTestLanguageEx.g:662:3: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword'
            {
            // PsiInternalParametersTestLanguageEx.g:662:3: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:663:4: ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:667:4: (lv_second_0_0= ruleIdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:668:5: lv_second_0_0= ruleIdOrKeyword
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
    // PsiInternalParametersTestLanguageEx.g:689:1: norm1_Scenario4 : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' ) ;
    public final void norm1_Scenario4() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:689:16: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' ) )
            // PsiInternalParametersTestLanguageEx.g:690:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' )
            {
            // PsiInternalParametersTestLanguageEx.g:690:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' )
            // PsiInternalParametersTestLanguageEx.g:691:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword'
            {
            // PsiInternalParametersTestLanguageEx.g:691:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:692:4: ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:696:4: (lv_second_0_0= norm1_IdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:697:5: lv_second_0_0= norm1_IdOrKeyword
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
    // PsiInternalParametersTestLanguageEx.g:717:1: entryRuleIdOrKeyword : ruleIdOrKeyword EOF ;
    public final void entryRuleIdOrKeyword() throws RecognitionException {
        try {
            // PsiInternalParametersTestLanguageEx.g:717:21: ( ruleIdOrKeyword EOF )
            // PsiInternalParametersTestLanguageEx.g:718:2: ruleIdOrKeyword EOF
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
    // PsiInternalParametersTestLanguageEx.g:723:1: ruleIdOrKeyword : this_ID_0= RULE_ID ;
    public final void ruleIdOrKeyword() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:723:16: (this_ID_0= RULE_ID )
            // PsiInternalParametersTestLanguageEx.g:724:2: this_ID_0= RULE_ID
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
    // PsiInternalParametersTestLanguageEx.g:735:1: norm1_IdOrKeyword : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final void norm1_IdOrKeyword() throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:735:18: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // PsiInternalParametersTestLanguageEx.g:736:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // PsiInternalParametersTestLanguageEx.g:736:2: (kw= 'keyword' | this_ID_1= RULE_ID )
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
                    // PsiInternalParametersTestLanguageEx.g:737:3: kw= 'keyword'
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
                    // PsiInternalParametersTestLanguageEx.g:745:3: this_ID_1= RULE_ID
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
        // PsiInternalParametersTestLanguageEx.g:198:5: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )
        // PsiInternalParametersTestLanguageEx.g:198:6: ( '#5' ( ( norm1_Scenario2 ) ) )
        {
        // PsiInternalParametersTestLanguageEx.g:198:6: ( '#5' ( ( norm1_Scenario2 ) ) )
        // PsiInternalParametersTestLanguageEx.g:199:6: '#5' ( ( norm1_Scenario2 ) )
        {
        match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // PsiInternalParametersTestLanguageEx.g:200:6: ( ( norm1_Scenario2 ) )
        // PsiInternalParametersTestLanguageEx.g:201:7: ( norm1_Scenario2 )
        {
        // PsiInternalParametersTestLanguageEx.g:201:7: ( norm1_Scenario2 )
        // PsiInternalParametersTestLanguageEx.g:202:8: norm1_Scenario2
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
        // PsiInternalParametersTestLanguageEx.g:230:5: ( ( '#6' ( ( ruleScenario2 ) ) ) )
        // PsiInternalParametersTestLanguageEx.g:230:6: ( '#6' ( ( ruleScenario2 ) ) )
        {
        // PsiInternalParametersTestLanguageEx.g:230:6: ( '#6' ( ( ruleScenario2 ) ) )
        // PsiInternalParametersTestLanguageEx.g:231:6: '#6' ( ( ruleScenario2 ) )
        {
        match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
        // PsiInternalParametersTestLanguageEx.g:232:6: ( ( ruleScenario2 ) )
        // PsiInternalParametersTestLanguageEx.g:233:7: ( ruleScenario2 )
        {
        // PsiInternalParametersTestLanguageEx.g:233:7: ( ruleScenario2 )
        // PsiInternalParametersTestLanguageEx.g:234:8: ruleScenario2
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
        // PsiInternalParametersTestLanguageEx.g:313:7: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:313:8: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:313:8: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:314:8: norm1_IdOrKeyword
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
        // PsiInternalParametersTestLanguageEx.g:363:7: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:363:8: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:363:8: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:364:8: norm1_IdOrKeyword
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
        // PsiInternalParametersTestLanguageEx.g:413:7: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:413:8: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:413:8: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:414:8: ruleIdOrKeyword
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
        // PsiInternalParametersTestLanguageEx.g:463:7: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:463:8: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:463:8: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:464:8: ruleIdOrKeyword
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
        // PsiInternalParametersTestLanguageEx.g:590:4: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:590:5: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:590:5: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:591:5: ruleIdOrKeyword
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
        // PsiInternalParametersTestLanguageEx.g:624:4: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:624:5: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:624:5: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:625:5: norm1_IdOrKeyword
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
            return "112:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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