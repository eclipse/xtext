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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:52:1: entryRuleParserRuleParameters : ruleParserRuleParameters EOF ;
    public final void entryRuleParserRuleParameters() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:52:30: ( ruleParserRuleParameters EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:53:2: ruleParserRuleParameters EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParserRuleParametersElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleParameters_in_entryRuleParserRuleParameters54);
            ruleParserRuleParameters();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRuleParameters57); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:58:1: ruleParserRuleParameters : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:58:25: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:59:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:59:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:60:3: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:60:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:61:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParserRuleParameters_ParserRuleParametersAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:66:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:67:4: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:67:4: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:68:5: otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleParserRuleParameters102); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:75:5: ( (lv_scenario_2_0= ruleScenario1_True ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:76:6: (lv_scenario_2_0= ruleScenario1_True )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:76:6: (lv_scenario_2_0= ruleScenario1_True )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:77:7: lv_scenario_2_0= ruleScenario1_True
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario1_TrueParserRuleCall_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_True_in_ruleParserRuleParameters139);
                    ruleScenario1_True();

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:88:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:88:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:89:5: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleParserRuleParameters193); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:96:5: ( (lv_scenario_4_0= ruleScenario1_False ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:97:6: (lv_scenario_4_0= ruleScenario1_False )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:97:6: (lv_scenario_4_0= ruleScenario1_False )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:98:7: lv_scenario_4_0= ruleScenario1_False
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario1_FalseParserRuleCall_1_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_False_in_ruleParserRuleParameters230);
                    ruleScenario1_False();

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:109:4: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:109:4: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:110:5: otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParserRuleParameters284); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_5);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:117:5: ( (lv_scenario_6_0= ruleScenario2_True ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:118:6: (lv_scenario_6_0= ruleScenario2_True )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:118:6: (lv_scenario_6_0= ruleScenario2_True )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:119:7: lv_scenario_6_0= ruleScenario2_True
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_TrueParserRuleCall_1_2_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_True_in_ruleParserRuleParameters321);
                    ruleScenario2_True();

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:130:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:130:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:131:5: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParserRuleParameters375); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:138:5: ( (lv_scenario_8_0= ruleScenario2_False ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:139:6: (lv_scenario_8_0= ruleScenario2_False )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:139:6: (lv_scenario_8_0= ruleScenario2_False )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:140:7: lv_scenario_8_0= ruleScenario2_False
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_FalseParserRuleCall_1_3_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_False_in_ruleParserRuleParameters412);
                    ruleScenario2_False();

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:151:4: ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:151:4: ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:152:5: ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:161:5: (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:162:6: otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFiveKeyword_1_4_0_0ElementType());
                      					
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParserRuleParameters540); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_9);
                      					
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:169:6: ( (lv_scenario_10_0= ruleScenario2_True ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:170:7: (lv_scenario_10_0= ruleScenario2_True )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:170:7: (lv_scenario_10_0= ruleScenario2_True )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:171:8: lv_scenario_10_0= ruleScenario2_True
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_TrueParserRuleCall_1_4_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_True_in_ruleParserRuleParameters582);
                    ruleScenario2_True();

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:183:4: ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:183:4: ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:184:5: ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:193:5: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:194:6: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSixKeyword_1_5_0_0ElementType());
                      					
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParserRuleParameters719); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_11);
                      					
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:201:6: ( (lv_scenario_12_0= ruleScenario2_False ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:202:7: (lv_scenario_12_0= ruleScenario2_False )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:202:7: (lv_scenario_12_0= ruleScenario2_False )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:203:8: lv_scenario_12_0= ruleScenario2_False
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_FalseParserRuleCall_1_5_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_False_in_ruleParserRuleParameters761);
                    ruleScenario2_False();

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:215:4: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:215:4: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:216:5: otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSevenKeyword_1_6_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleParserRuleParameters824); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:223:5: ( (lv_scenario_14_0= ruleScenario3_True ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:224:6: (lv_scenario_14_0= ruleScenario3_True )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:224:6: (lv_scenario_14_0= ruleScenario3_True )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:225:7: lv_scenario_14_0= ruleScenario3_True
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario3_TrueParserRuleCall_1_6_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario3_True_in_ruleParserRuleParameters861);
                    ruleScenario3_True();

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:236:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:236:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:237:5: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitEightKeyword_1_7_0ElementType());
                      				
                    }
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleParserRuleParameters915); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_15);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:244:5: ( (lv_scenario_16_0= ruleScenario3_False ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:245:6: (lv_scenario_16_0= ruleScenario3_False )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:245:6: (lv_scenario_16_0= ruleScenario3_False )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:246:7: lv_scenario_16_0= ruleScenario3_False
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario3_FalseParserRuleCall_1_7_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario3_False_in_ruleParserRuleParameters952);
                    ruleScenario3_False();

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:257:4: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:257:4: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:258:5: otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitNineKeyword_1_8_0ElementType());
                      				
                    }
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleParserRuleParameters1006); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_17);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:265:5: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) )
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

                            if ( (synpred3_PsiInternalNoParametersTestLanguage()) ) {
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:266:6: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:266:6: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:267:7: ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:271:7: (lv_scenario_18_0= ruleScenario4_True )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:272:8: lv_scenario_18_0= ruleScenario4_True
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4_TrueParserRuleCall_1_8_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_True_in_ruleParserRuleParameters1088);
                            ruleScenario4_True();

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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:282:6: ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:282:6: ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:283:7: ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:283:7: ( (lv_scenario_19_0= ruleScenario2_True ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:284:8: (lv_scenario_19_0= ruleScenario2_True )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:284:8: (lv_scenario_19_0= ruleScenario2_True )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:285:9: lv_scenario_19_0= ruleScenario2_True
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_TrueParserRuleCall_1_8_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_True_in_ruleParserRuleParameters1169);
                            ruleScenario2_True();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:294:7: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:295:8: otherlv_20= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_8_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters1224); if (state.failed) return ;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:307:4: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:307:4: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:308:5: otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitZeroKeyword_1_9_0ElementType());
                      				
                    }
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRuleParameters1288); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_21);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:315:5: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:316:6: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:316:6: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:317:7: ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:321:7: (lv_scenario_22_0= ruleScenario4_True )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:322:8: lv_scenario_22_0= ruleScenario4_True
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4_TrueParserRuleCall_1_9_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_True_in_ruleParserRuleParameters1370);
                            ruleScenario4_True();

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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:332:6: ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:332:6: ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:333:7: ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:333:7: ( (lv_scenario_23_0= ruleScenario2_False ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:334:8: (lv_scenario_23_0= ruleScenario2_False )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:334:8: (lv_scenario_23_0= ruleScenario2_False )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:335:9: lv_scenario_23_0= ruleScenario2_False
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_FalseParserRuleCall_1_9_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_False_in_ruleParserRuleParameters1451);
                            ruleScenario2_False();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:344:7: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:345:8: otherlv_24= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_9_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters1506); if (state.failed) return ;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:357:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:357:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:358:5: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitOneKeyword_1_10_0ElementType());
                      				
                    }
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParserRuleParameters1570); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_25);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:365:5: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:366:6: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:366:6: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:367:7: ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:371:7: (lv_scenario_26_0= ruleScenario4_False )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:372:8: lv_scenario_26_0= ruleScenario4_False
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4_FalseParserRuleCall_1_10_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_False_in_ruleParserRuleParameters1652);
                            ruleScenario4_False();

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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:382:6: ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:382:6: ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:383:7: ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:383:7: ( (lv_scenario_27_0= ruleScenario2_True ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:384:8: (lv_scenario_27_0= ruleScenario2_True )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:384:8: (lv_scenario_27_0= ruleScenario2_True )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:385:9: lv_scenario_27_0= ruleScenario2_True
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_TrueParserRuleCall_1_10_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_True_in_ruleParserRuleParameters1733);
                            ruleScenario2_True();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:394:7: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:395:8: otherlv_28= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_10_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_28=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters1788); if (state.failed) return ;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:407:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:407:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:408:5: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitTwoKeyword_1_11_0ElementType());
                      				
                    }
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRuleParameters1852); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_29);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:415:5: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:416:6: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:416:6: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:417:7: ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:421:7: (lv_scenario_30_0= ruleScenario4_False )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:422:8: lv_scenario_30_0= ruleScenario4_False
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4_FalseParserRuleCall_1_11_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_False_in_ruleParserRuleParameters1934);
                            ruleScenario4_False();

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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:432:6: ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:432:6: ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:433:7: ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:433:7: ( (lv_scenario_31_0= ruleScenario2_False ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:434:8: (lv_scenario_31_0= ruleScenario2_False )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:434:8: (lv_scenario_31_0= ruleScenario2_False )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:435:9: lv_scenario_31_0= ruleScenario2_False
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2_FalseParserRuleCall_1_11_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_False_in_ruleParserRuleParameters2015);
                            ruleScenario2_False();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:444:7: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:445:8: otherlv_32= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_11_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters2070); if (state.failed) return ;
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


    // $ANTLR start "entryRuleScenario1_True"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:461:1: entryRuleScenario1_True : ruleScenario1_True EOF ;
    public final void entryRuleScenario1_True() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:461:24: ( ruleScenario1_True EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:462:2: ruleScenario1_True EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario1_TrueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_True_in_entryRuleScenario1_True2126);
            ruleScenario1_True();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario1_True2129); if (state.failed) return ;

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
    // $ANTLR end "entryRuleScenario1_True"


    // $ANTLR start "ruleScenario1_True"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:467:1: ruleScenario1_True : ( (lv_first_0_0= RULE_ID ) ) ;
    public final void ruleScenario1_True() throws RecognitionException {
        Token lv_first_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:467:19: ( ( (lv_first_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:468:2: ( (lv_first_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:468:2: ( (lv_first_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:469:3: (lv_first_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:469:3: (lv_first_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:470:4: lv_first_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getScenario1_True_FirstIDTerminalRuleCall_0ElementType());
              			
            }
            lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleScenario1_True2154); if (state.failed) return ;
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
    // $ANTLR end "ruleScenario1_True"


    // $ANTLR start "entryRuleScenario1_False"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:482:1: entryRuleScenario1_False : ruleScenario1_False EOF ;
    public final void entryRuleScenario1_False() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:482:25: ( ruleScenario1_False EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:483:2: ruleScenario1_False EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario1_FalseElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_False_in_entryRuleScenario1_False2179);
            ruleScenario1_False();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario1_False2182); if (state.failed) return ;

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
    // $ANTLR end "entryRuleScenario1_False"


    // $ANTLR start "ruleScenario1_False"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:488:1: ruleScenario1_False : ( (lv_second_0_0= RULE_ID ) ) ;
    public final void ruleScenario1_False() throws RecognitionException {
        Token lv_second_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:488:20: ( ( (lv_second_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:489:2: ( (lv_second_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:489:2: ( (lv_second_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:490:3: (lv_second_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:490:3: (lv_second_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:491:4: lv_second_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getScenario1_False_SecondIDTerminalRuleCall_0ElementType());
              			
            }
            lv_second_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleScenario1_False2207); if (state.failed) return ;
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
    // $ANTLR end "ruleScenario1_False"


    // $ANTLR start "entryRuleScenario2_True"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:503:1: entryRuleScenario2_True : ruleScenario2_True EOF ;
    public final void entryRuleScenario2_True() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:503:24: ( ruleScenario2_True EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:504:2: ruleScenario2_True EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario2_TrueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_True_in_entryRuleScenario2_True2232);
            ruleScenario2_True();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_True2235); if (state.failed) return ;

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
    // $ANTLR end "entryRuleScenario2_True"


    // $ANTLR start "ruleScenario2_True"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:509:1: ruleScenario2_True : ( (lv_first_0_0= ruleIdOrKeyword_True ) ) ;
    public final void ruleScenario2_True() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:509:19: ( ( (lv_first_0_0= ruleIdOrKeyword_True ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:510:2: ( (lv_first_0_0= ruleIdOrKeyword_True ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:510:2: ( (lv_first_0_0= ruleIdOrKeyword_True ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:511:3: (lv_first_0_0= ruleIdOrKeyword_True )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:511:3: (lv_first_0_0= ruleIdOrKeyword_True )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:512:4: lv_first_0_0= ruleIdOrKeyword_True
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getScenario2_True_FirstIdOrKeyword_TrueParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_True_in_ruleScenario2_True2260);
            ruleIdOrKeyword_True();

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
    // $ANTLR end "ruleScenario2_True"


    // $ANTLR start "entryRuleScenario2_False"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:524:1: entryRuleScenario2_False : ruleScenario2_False EOF ;
    public final void entryRuleScenario2_False() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:524:25: ( ruleScenario2_False EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:525:2: ruleScenario2_False EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario2_FalseElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_False_in_entryRuleScenario2_False2285);
            ruleScenario2_False();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_False2288); if (state.failed) return ;

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
    // $ANTLR end "entryRuleScenario2_False"


    // $ANTLR start "ruleScenario2_False"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:530:1: ruleScenario2_False : ( (lv_first_0_0= ruleIdOrKeyword_False ) ) ;
    public final void ruleScenario2_False() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:530:20: ( ( (lv_first_0_0= ruleIdOrKeyword_False ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:531:2: ( (lv_first_0_0= ruleIdOrKeyword_False ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:531:2: ( (lv_first_0_0= ruleIdOrKeyword_False ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:532:3: (lv_first_0_0= ruleIdOrKeyword_False )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:532:3: (lv_first_0_0= ruleIdOrKeyword_False )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:533:4: lv_first_0_0= ruleIdOrKeyword_False
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getScenario2_False_FirstIdOrKeyword_FalseParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_False_in_ruleScenario2_False2313);
            ruleIdOrKeyword_False();

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
    // $ANTLR end "ruleScenario2_False"


    // $ANTLR start "entryRuleScenario3_True"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:545:1: entryRuleScenario3_True : ruleScenario3_True EOF ;
    public final void entryRuleScenario3_True() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:545:24: ( ruleScenario3_True EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:546:2: ruleScenario3_True EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario3_TrueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario3_True_in_entryRuleScenario3_True2338);
            ruleScenario3_True();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario3_True2341); if (state.failed) return ;

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
    // $ANTLR end "entryRuleScenario3_True"


    // $ANTLR start "ruleScenario3_True"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:551:1: ruleScenario3_True : ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final void ruleScenario3_True() throws RecognitionException {
        Token lv_second_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:551:19: ( ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:552:2: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:552:2: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) )
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
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA10_0==RULE_ID) && (synpred7_PsiInternalNoParametersTestLanguage())) {
                alt10=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:553:3: ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:553:3: ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:554:4: ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:558:4: (lv_first_0_0= ruleIdOrKeyword_True )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:559:5: lv_first_0_0= ruleIdOrKeyword_True
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getScenario3_True_FirstIdOrKeyword_TrueParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_True_in_ruleScenario3_True2396);
                    ruleIdOrKeyword_True();

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:569:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:569:3: ( (lv_second_1_0= 'keyword' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:570:4: (lv_second_1_0= 'keyword' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:570:4: (lv_second_1_0= 'keyword' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:571:5: lv_second_1_0= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getScenario3_True_SecondKeywordKeyword_1_0ElementType());
                      				
                    }
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScenario3_True2442); if (state.failed) return ;
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
    // $ANTLR end "ruleScenario3_True"


    // $ANTLR start "entryRuleScenario3_False"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:584:1: entryRuleScenario3_False : ruleScenario3_False EOF ;
    public final void entryRuleScenario3_False() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:584:25: ( ruleScenario3_False EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:585:2: ruleScenario3_False EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario3_FalseElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario3_False_in_entryRuleScenario3_False2473);
            ruleScenario3_False();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario3_False2476); if (state.failed) return ;

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
    // $ANTLR end "entryRuleScenario3_False"


    // $ANTLR start "ruleScenario3_False"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:590:1: ruleScenario3_False : ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final void ruleScenario3_False() throws RecognitionException {
        Token lv_second_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:590:20: ( ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:591:2: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:591:2: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) && (synpred8_PsiInternalNoParametersTestLanguage())) {
                alt11=1;
            }
            else if ( (LA11_0==20) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:592:3: ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:592:3: ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:593:4: ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:597:4: (lv_first_0_0= ruleIdOrKeyword_False )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:598:5: lv_first_0_0= ruleIdOrKeyword_False
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getScenario3_False_FirstIdOrKeyword_FalseParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_False_in_ruleScenario3_False2531);
                    ruleIdOrKeyword_False();

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:608:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:608:3: ( (lv_second_1_0= 'keyword' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:609:4: (lv_second_1_0= 'keyword' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:609:4: (lv_second_1_0= 'keyword' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:610:5: lv_second_1_0= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getScenario3_False_SecondKeywordKeyword_1_0ElementType());
                      				
                    }
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScenario3_False2577); if (state.failed) return ;
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
    // $ANTLR end "ruleScenario3_False"


    // $ANTLR start "entryRuleScenario4_True"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:623:1: entryRuleScenario4_True : ruleScenario4_True EOF ;
    public final void entryRuleScenario4_True() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:623:24: ( ruleScenario4_True EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:624:2: ruleScenario4_True EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario4_TrueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario4_True_in_entryRuleScenario4_True2608);
            ruleScenario4_True();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario4_True2611); if (state.failed) return ;

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
    // $ANTLR end "entryRuleScenario4_True"


    // $ANTLR start "ruleScenario4_True"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:629:1: ruleScenario4_True : ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' ) ;
    public final void ruleScenario4_True() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:629:19: ( ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:630:2: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:630:2: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:631:3: ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:631:3: ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:632:4: ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:636:4: (lv_second_0_0= ruleIdOrKeyword_True )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:637:5: lv_second_0_0= ruleIdOrKeyword_True
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getScenario4_True_SecondIdOrKeyword_TrueParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_True_in_ruleScenario4_True2666);
            ruleIdOrKeyword_True();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getScenario4_True_KeywordKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScenario4_True2691); if (state.failed) return ;
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
    // $ANTLR end "ruleScenario4_True"


    // $ANTLR start "entryRuleScenario4_False"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:657:1: entryRuleScenario4_False : ruleScenario4_False EOF ;
    public final void entryRuleScenario4_False() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:657:25: ( ruleScenario4_False EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:658:2: ruleScenario4_False EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario4_FalseElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario4_False_in_entryRuleScenario4_False2711);
            ruleScenario4_False();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario4_False2714); if (state.failed) return ;

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
    // $ANTLR end "entryRuleScenario4_False"


    // $ANTLR start "ruleScenario4_False"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:663:1: ruleScenario4_False : ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' ) ;
    public final void ruleScenario4_False() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:663:20: ( ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:664:2: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:664:2: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:665:3: ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:665:3: ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:666:4: ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:670:4: (lv_second_0_0= ruleIdOrKeyword_False )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:671:5: lv_second_0_0= ruleIdOrKeyword_False
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getScenario4_False_SecondIdOrKeyword_FalseParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_False_in_ruleScenario4_False2769);
            ruleIdOrKeyword_False();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getScenario4_False_KeywordKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScenario4_False2794); if (state.failed) return ;
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
    // $ANTLR end "ruleScenario4_False"


    // $ANTLR start "entryRuleIdOrKeyword_True"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:691:1: entryRuleIdOrKeyword_True : ruleIdOrKeyword_True EOF ;
    public final void entryRuleIdOrKeyword_True() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:691:26: ( ruleIdOrKeyword_True EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:692:2: ruleIdOrKeyword_True EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrKeyword_TrueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_True_in_entryRuleIdOrKeyword_True2814);
            ruleIdOrKeyword_True();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdOrKeyword_True2817); if (state.failed) return ;

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
    // $ANTLR end "entryRuleIdOrKeyword_True"


    // $ANTLR start "ruleIdOrKeyword_True"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:697:1: ruleIdOrKeyword_True : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final void ruleIdOrKeyword_True() throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:697:21: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:698:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:698:2: (kw= 'keyword' | this_ID_1= RULE_ID )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:699:3: kw= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_True_KeywordKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIdOrKeyword_True2836); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:707:3: this_ID_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_True_IDTerminalRuleCall_1ElementType());
                      		
                    }
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdOrKeyword_True2858); if (state.failed) return ;
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
    // $ANTLR end "ruleIdOrKeyword_True"


    // $ANTLR start "entryRuleIdOrKeyword_False"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:718:1: entryRuleIdOrKeyword_False : ruleIdOrKeyword_False EOF ;
    public final void entryRuleIdOrKeyword_False() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:718:27: ( ruleIdOrKeyword_False EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:719:2: ruleIdOrKeyword_False EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrKeyword_FalseElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_False_in_entryRuleIdOrKeyword_False2878);
            ruleIdOrKeyword_False();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdOrKeyword_False2881); if (state.failed) return ;

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
    // $ANTLR end "entryRuleIdOrKeyword_False"


    // $ANTLR start "ruleIdOrKeyword_False"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:724:1: ruleIdOrKeyword_False : this_ID_0= RULE_ID ;
    public final void ruleIdOrKeyword_False() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:724:22: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:725:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getIdOrKeyword_False_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdOrKeyword_False2895); if (state.failed) return ;
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
    // $ANTLR end "ruleIdOrKeyword_False"


    // $ANTLR start "entryRuleIdOrKeyword"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:735:1: entryRuleIdOrKeyword : ruleIdOrKeyword[false] EOF ;
    public final void entryRuleIdOrKeyword() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:735:21: ( ruleIdOrKeyword[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:736:2: ruleIdOrKeyword[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrKeywordElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_entryRuleIdOrKeyword2911);
            ruleIdOrKeyword(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdOrKeyword2915); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:741:1: ruleIdOrKeyword[boolean p_Keyword] : ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID ) ;
    public final void ruleIdOrKeyword(boolean p_Keyword) throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:742:1: ( ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:743:2: ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:743:2: ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( LA13_0 == 20 && p_Keyword ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:744:3: ({...}? => (kw= 'keyword' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:744:3: ({...}? => (kw= 'keyword' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:745:4: {...}? => (kw= 'keyword' )
                    {
                    if ( ! p_Keyword ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "ruleIdOrKeyword", "p_Keyword");
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:745:18: (kw= 'keyword' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:745:19: kw= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getIdOrKeyword_KeywordKeyword_0_0ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIdOrKeyword2946); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:755:3: this_ID_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_IDTerminalRuleCall_1ElementType());
                      		
                    }
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdOrKeyword2978); if (state.failed) return ;
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
    // $ANTLR end "ruleIdOrKeyword"

    // $ANTLR start synpred1_PsiInternalNoParametersTestLanguage
    public final void synpred1_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:152:5: ( ( '#5' ( ( ruleScenario2_True ) ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:152:6: ( '#5' ( ( ruleScenario2_True ) ) )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:152:6: ( '#5' ( ( ruleScenario2_True ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:153:6: '#5' ( ( ruleScenario2_True ) )
        {
        match(input,15,FollowSets000.FOLLOW_15_in_synpred1_PsiInternalNoParametersTestLanguage466); if (state.failed) return ;
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:154:6: ( ( ruleScenario2_True ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:155:7: ( ruleScenario2_True )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:155:7: ( ruleScenario2_True )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:156:8: ruleScenario2_True
        {
        pushFollow(FollowSets000.FOLLOW_ruleScenario2_True_in_synpred1_PsiInternalNoParametersTestLanguage490);
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
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:184:5: ( ( '#6' ( ( ruleScenario2_False ) ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:184:6: ( '#6' ( ( ruleScenario2_False ) ) )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:184:6: ( '#6' ( ( ruleScenario2_False ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:185:6: '#6' ( ( ruleScenario2_False ) )
        {
        match(input,16,FollowSets000.FOLLOW_16_in_synpred2_PsiInternalNoParametersTestLanguage645); if (state.failed) return ;
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:186:6: ( ( ruleScenario2_False ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:187:7: ( ruleScenario2_False )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:187:7: ( ruleScenario2_False )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:188:8: ruleScenario2_False
        {
        pushFollow(FollowSets000.FOLLOW_ruleScenario2_False_in_synpred2_PsiInternalNoParametersTestLanguage669);
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
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:267:7: ( ( ruleIdOrKeyword_True ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:267:8: ( ruleIdOrKeyword_True )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:267:8: ( ruleIdOrKeyword_True )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:268:8: ruleIdOrKeyword_True
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_True_in_synpred3_PsiInternalNoParametersTestLanguage1043);
        ruleIdOrKeyword_True();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred4_PsiInternalNoParametersTestLanguage
    public final void synpred4_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:317:7: ( ( ruleIdOrKeyword_True ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:317:8: ( ruleIdOrKeyword_True )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:317:8: ( ruleIdOrKeyword_True )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:318:8: ruleIdOrKeyword_True
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_True_in_synpred4_PsiInternalNoParametersTestLanguage1325);
        ruleIdOrKeyword_True();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred5_PsiInternalNoParametersTestLanguage
    public final void synpred5_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:367:7: ( ( ruleIdOrKeyword_False ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:367:8: ( ruleIdOrKeyword_False )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:367:8: ( ruleIdOrKeyword_False )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:368:8: ruleIdOrKeyword_False
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_False_in_synpred5_PsiInternalNoParametersTestLanguage1607);
        ruleIdOrKeyword_False();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred6_PsiInternalNoParametersTestLanguage
    public final void synpred6_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:417:7: ( ( ruleIdOrKeyword_False ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:417:8: ( ruleIdOrKeyword_False )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:417:8: ( ruleIdOrKeyword_False )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:418:8: ruleIdOrKeyword_False
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_False_in_synpred6_PsiInternalNoParametersTestLanguage1889);
        ruleIdOrKeyword_False();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred7_PsiInternalNoParametersTestLanguage
    public final void synpred7_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:554:4: ( ( ruleIdOrKeyword_True ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:554:5: ( ruleIdOrKeyword_True )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:554:5: ( ruleIdOrKeyword_True )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:555:5: ruleIdOrKeyword_True
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_True_in_synpred7_PsiInternalNoParametersTestLanguage2366);
        ruleIdOrKeyword_True();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_PsiInternalNoParametersTestLanguage

    // $ANTLR start synpred8_PsiInternalNoParametersTestLanguage
    public final void synpred8_PsiInternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:593:4: ( ( ruleIdOrKeyword_False ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:593:5: ( ruleIdOrKeyword_False )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:593:5: ( ruleIdOrKeyword_False )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalNoParametersTestLanguage.g:594:5: ruleIdOrKeyword_False
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_False_in_synpred8_PsiInternalNoParametersTestLanguage2501);
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
            return "66:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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
        public static final BitSet FOLLOW_ruleParserRuleParameters_in_entryRuleParserRuleParameters54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRuleParameters57 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleParserRuleParameters102 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario1_True_in_ruleParserRuleParameters139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleParserRuleParameters193 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario1_False_in_ruleParserRuleParameters230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleParserRuleParameters284 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_True_in_ruleParserRuleParameters321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleParserRuleParameters375 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario2_False_in_ruleParserRuleParameters412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParserRuleParameters540 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_True_in_ruleParserRuleParameters582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleParserRuleParameters719 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario2_False_in_ruleParserRuleParameters761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleParserRuleParameters824 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario3_True_in_ruleParserRuleParameters861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleParserRuleParameters915 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario3_False_in_ruleParserRuleParameters952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleParserRuleParameters1006 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_True_in_ruleParserRuleParameters1088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_True_in_ruleParserRuleParameters1169 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters1224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleParserRuleParameters1288 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_True_in_ruleParserRuleParameters1370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_False_in_ruleParserRuleParameters1451 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters1506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleParserRuleParameters1570 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_False_in_ruleParserRuleParameters1652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_True_in_ruleParserRuleParameters1733 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters1788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleParserRuleParameters1852 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario4_False_in_ruleParserRuleParameters1934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_False_in_ruleParserRuleParameters2015 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters2070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_True_in_entryRuleScenario1_True2126 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario1_True2129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleScenario1_True2154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_False_in_entryRuleScenario1_False2179 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario1_False2182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleScenario1_False2207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_True_in_entryRuleScenario2_True2232 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_True2235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_True_in_ruleScenario2_True2260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_False_in_entryRuleScenario2_False2285 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_False2288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_False_in_ruleScenario2_False2313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario3_True_in_entryRuleScenario3_True2338 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario3_True2341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_True_in_ruleScenario3_True2396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleScenario3_True2442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario3_False_in_entryRuleScenario3_False2473 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario3_False2476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_False_in_ruleScenario3_False2531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleScenario3_False2577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario4_True_in_entryRuleScenario4_True2608 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario4_True2611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_True_in_ruleScenario4_True2666 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleScenario4_True2691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario4_False_in_entryRuleScenario4_False2711 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario4_False2714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_False_in_ruleScenario4_False2769 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleScenario4_False2794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_True_in_entryRuleIdOrKeyword_True2814 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdOrKeyword_True2817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleIdOrKeyword_True2836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdOrKeyword_True2858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_False_in_entryRuleIdOrKeyword_False2878 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdOrKeyword_False2881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdOrKeyword_False2895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_entryRuleIdOrKeyword2911 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdOrKeyword2915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleIdOrKeyword2946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdOrKeyword2978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_synpred1_PsiInternalNoParametersTestLanguage466 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_True_in_synpred1_PsiInternalNoParametersTestLanguage490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_synpred2_PsiInternalNoParametersTestLanguage645 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario2_False_in_synpred2_PsiInternalNoParametersTestLanguage669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_True_in_synpred3_PsiInternalNoParametersTestLanguage1043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_True_in_synpred4_PsiInternalNoParametersTestLanguage1325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_False_in_synpred5_PsiInternalNoParametersTestLanguage1607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_False_in_synpred6_PsiInternalNoParametersTestLanguage1889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_True_in_synpred7_PsiInternalNoParametersTestLanguage2366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_False_in_synpred8_PsiInternalNoParametersTestLanguage2501 = new BitSet(new long[]{0x0000000000000002L});
    }


}