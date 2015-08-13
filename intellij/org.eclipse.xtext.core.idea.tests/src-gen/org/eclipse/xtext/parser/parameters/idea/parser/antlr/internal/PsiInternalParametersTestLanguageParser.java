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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:52:1: entryRuleParserRuleParameters : ruleParserRuleParameters EOF ;
    public final void entryRuleParserRuleParameters() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:52:30: ( ruleParserRuleParameters EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:53:2: ruleParserRuleParameters EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:58:1: ruleParserRuleParameters : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:58:25: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:59:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:59:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:60:3: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:60:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:61:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParserRuleParameters_ParserRuleParametersAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:66:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:67:4: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:67:4: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:68:5: otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleParserRuleParameters102); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:75:5: ( (lv_scenario_2_0= ruleScenario1[true] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:76:6: (lv_scenario_2_0= ruleScenario1[true] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:76:6: (lv_scenario_2_0= ruleScenario1[true] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:77:7: lv_scenario_2_0= ruleScenario1[true]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario1ParserRuleCall_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_in_ruleParserRuleParameters139);
                    ruleScenario1(true);

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:88:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:88:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:89:5: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleParserRuleParameters194); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:96:5: ( (lv_scenario_4_0= ruleScenario1[false] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:97:6: (lv_scenario_4_0= ruleScenario1[false] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:97:6: (lv_scenario_4_0= ruleScenario1[false] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:98:7: lv_scenario_4_0= ruleScenario1[false]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario1ParserRuleCall_1_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_in_ruleParserRuleParameters231);
                    ruleScenario1(false);

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:109:4: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:109:4: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:110:5: otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParserRuleParameters286); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_5);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:117:5: ( (lv_scenario_6_0= ruleScenario2[true] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:118:6: (lv_scenario_6_0= ruleScenario2[true] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:118:6: (lv_scenario_6_0= ruleScenario2[true] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:119:7: lv_scenario_6_0= ruleScenario2[true]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_2_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters323);
                    ruleScenario2(true);

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:130:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:130:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:131:5: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParserRuleParameters378); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:138:5: ( (lv_scenario_8_0= ruleScenario2[false] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:139:6: (lv_scenario_8_0= ruleScenario2[false] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:139:6: (lv_scenario_8_0= ruleScenario2[false] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:140:7: lv_scenario_8_0= ruleScenario2[false]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_3_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters415);
                    ruleScenario2(false);

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:151:4: ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:151:4: ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:152:5: ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:161:5: (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:162:6: otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFiveKeyword_1_4_0_0ElementType());
                      					
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParserRuleParameters545); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_9);
                      					
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:169:6: ( (lv_scenario_10_0= ruleScenario2[true] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:170:7: (lv_scenario_10_0= ruleScenario2[true] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:170:7: (lv_scenario_10_0= ruleScenario2[true] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:171:8: lv_scenario_10_0= ruleScenario2[true]
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_4_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters587);
                    ruleScenario2(true);

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:183:4: ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:183:4: ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:184:5: ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:193:5: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:194:6: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSixKeyword_1_5_0_0ElementType());
                      					
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParserRuleParameters726); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_11);
                      					
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:201:6: ( (lv_scenario_12_0= ruleScenario2[false] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:202:7: (lv_scenario_12_0= ruleScenario2[false] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:202:7: (lv_scenario_12_0= ruleScenario2[false] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:203:8: lv_scenario_12_0= ruleScenario2[false]
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_5_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters768);
                    ruleScenario2(false);

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:215:4: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:215:4: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:216:5: otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSevenKeyword_1_6_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleParserRuleParameters832); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:223:5: ( (lv_scenario_14_0= ruleScenario3[true] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:224:6: (lv_scenario_14_0= ruleScenario3[true] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:224:6: (lv_scenario_14_0= ruleScenario3[true] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:225:7: lv_scenario_14_0= ruleScenario3[true]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario3ParserRuleCall_1_6_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario3_in_ruleParserRuleParameters869);
                    ruleScenario3(true);

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:236:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:236:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:237:5: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitEightKeyword_1_7_0ElementType());
                      				
                    }
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleParserRuleParameters924); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_15);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:244:5: ( (lv_scenario_16_0= ruleScenario3[false] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:245:6: (lv_scenario_16_0= ruleScenario3[false] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:245:6: (lv_scenario_16_0= ruleScenario3[false] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:246:7: lv_scenario_16_0= ruleScenario3[false]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario3ParserRuleCall_1_7_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario3_in_ruleParserRuleParameters961);
                    ruleScenario3(false);

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:257:4: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:257:4: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:258:5: otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitNineKeyword_1_8_0ElementType());
                      				
                    }
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleParserRuleParameters1016); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_17);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:265:5: ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:266:6: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:266:6: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:267:7: ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:271:7: (lv_scenario_18_0= ruleScenario4[true] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:272:8: lv_scenario_18_0= ruleScenario4[true]
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_8_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters1099);
                            ruleScenario4(true);

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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:282:6: ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:282:6: ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:283:7: ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:283:7: ( (lv_scenario_19_0= ruleScenario2[true] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:284:8: (lv_scenario_19_0= ruleScenario2[true] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:284:8: (lv_scenario_19_0= ruleScenario2[true] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:285:9: lv_scenario_19_0= ruleScenario2[true]
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_8_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters1181);
                            ruleScenario2(true);

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:294:7: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:295:8: otherlv_20= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_8_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters1237); if (state.failed) return ;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:307:4: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:307:4: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:308:5: otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitZeroKeyword_1_9_0ElementType());
                      				
                    }
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRuleParameters1301); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_21);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:315:5: ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1==20) ) {
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
                        else if ( (LA4_1==EOF) ) {
                            alt4=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 1, input);

                            throw nvae;
                        }
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:316:6: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:316:6: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:317:7: ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:321:7: (lv_scenario_22_0= ruleScenario4[true] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:322:8: lv_scenario_22_0= ruleScenario4[true]
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_9_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters1384);
                            ruleScenario4(true);

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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:332:6: ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:332:6: ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:333:7: ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:333:7: ( (lv_scenario_23_0= ruleScenario2[false] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:334:8: (lv_scenario_23_0= ruleScenario2[false] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:334:8: (lv_scenario_23_0= ruleScenario2[false] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:335:9: lv_scenario_23_0= ruleScenario2[false]
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_9_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters1466);
                            ruleScenario2(false);

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:344:7: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:345:8: otherlv_24= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_9_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters1522); if (state.failed) return ;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:357:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:357:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:358:5: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitOneKeyword_1_10_0ElementType());
                      				
                    }
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParserRuleParameters1586); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_25);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:365:5: ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==20) ) {
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
                    else if ( (LA6_0==RULE_ID) ) {
                        int LA6_2 = input.LA(2);

                        if ( (LA6_2==20) ) {
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
                        else if ( (LA6_2==EOF) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:366:6: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:366:6: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:367:7: ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:371:7: (lv_scenario_26_0= ruleScenario4[false] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:372:8: lv_scenario_26_0= ruleScenario4[false]
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_10_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters1669);
                            ruleScenario4(false);

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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:382:6: ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:382:6: ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:383:7: ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:383:7: ( (lv_scenario_27_0= ruleScenario2[true] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:384:8: (lv_scenario_27_0= ruleScenario2[true] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:384:8: (lv_scenario_27_0= ruleScenario2[true] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:385:9: lv_scenario_27_0= ruleScenario2[true]
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_10_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters1751);
                            ruleScenario2(true);

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:394:7: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:395:8: otherlv_28= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_10_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_28=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters1807); if (state.failed) return ;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:407:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:407:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:408:5: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitTwoKeyword_1_11_0ElementType());
                      				
                    }
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRuleParameters1871); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_29);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:415:5: ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==20) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_3 = input.LA(3);

                            if ( (synpred6_PsiInternalParametersTestLanguage()) ) {
                                alt8=1;
                            }
                            else if ( (true) ) {
                                alt8=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 3, input);

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
                    else if ( (LA8_0==RULE_ID) ) {
                        int LA8_2 = input.LA(2);

                        if ( (LA8_2==20) ) {
                            int LA8_3 = input.LA(3);

                            if ( (synpred6_PsiInternalParametersTestLanguage()) ) {
                                alt8=1;
                            }
                            else if ( (true) ) {
                                alt8=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA8_2==EOF) ) {
                            alt8=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 2, input);

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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:416:6: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:416:6: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:417:7: ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:421:7: (lv_scenario_30_0= ruleScenario4[false] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:422:8: lv_scenario_30_0= ruleScenario4[false]
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_11_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters1954);
                            ruleScenario4(false);

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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:432:6: ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:432:6: ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:433:7: ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:433:7: ( (lv_scenario_31_0= ruleScenario2[false] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:434:8: (lv_scenario_31_0= ruleScenario2[false] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:434:8: (lv_scenario_31_0= ruleScenario2[false] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:435:9: lv_scenario_31_0= ruleScenario2[false]
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_11_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters2036);
                            ruleScenario2(false);

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:444:7: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:445:8: otherlv_32= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_11_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters2092); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:461:1: entryRuleScenario1 : ruleScenario1[false] EOF ;
    public final void entryRuleScenario1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:461:19: ( ruleScenario1[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:462:2: ruleScenario1[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_in_entryRuleScenario12148);
            ruleScenario1(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario12152); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:467:1: ruleScenario1[boolean p_Param] : ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) ) ;
    public final void ruleScenario1(boolean p_Param) throws RecognitionException {
        Token lv_first_0_0=null;
        Token lv_second_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:468:1: ( ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:469:2: ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:469:2: ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 == RULE_ID ) {
                int LA10_1 = input.LA(2);

                if ( p_Param ) {
                    alt10=1;
                }
                else if ( ! p_Param ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:470:3: ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:470:3: ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:471:4: {...}? => ( ( (lv_first_0_0= RULE_ID ) ) )
                    {
                    if ( ! p_Param ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "ruleScenario1", "p_Param");
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:471:16: ( ( (lv_first_0_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:471:17: ( (lv_first_0_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:471:17: ( (lv_first_0_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:472:5: (lv_first_0_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:472:5: (lv_first_0_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:473:6: lv_first_0_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getScenario1_FirstIDTerminalRuleCall_0_0_0ElementType());
                      					
                    }
                    lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleScenario12198); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_first_0_0);
                      					
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:485:3: ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:485:3: ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:486:4: {...}? => ( ( (lv_second_1_0= RULE_ID ) ) )
                    {
                    if ( p_Param ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "ruleScenario1", "!p_Param");
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:486:17: ( ( (lv_second_1_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:486:18: ( (lv_second_1_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:486:18: ( (lv_second_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:487:5: (lv_second_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:487:5: (lv_second_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:488:6: lv_second_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getScenario1_SecondIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_second_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleScenario12267); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_second_1_0);
                      					
                    }

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
        return ;
    }
    // $ANTLR end "ruleScenario1"


    // $ANTLR start "entryRuleScenario2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:503:1: entryRuleScenario2 : ruleScenario2[false] EOF ;
    public final void entryRuleScenario2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:503:19: ( ruleScenario2[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:504:2: ruleScenario2[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_entryRuleScenario22310);
            ruleScenario2(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario22314); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:509:1: ruleScenario2[boolean p_AllowKeyword] : ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) ) ;
    public final void ruleScenario2(boolean p_AllowKeyword) throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:510:1: ( ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:511:2: ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:511:2: ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:512:3: (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:512:3: (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:513:4: lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword]
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getScenario2_FirstIdOrKeywordParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_ruleScenario22342);
            ruleIdOrKeyword(p_AllowKeyword);

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


    // $ANTLR start "entryRuleScenario3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:525:1: entryRuleScenario3 : ruleScenario3[false] EOF ;
    public final void entryRuleScenario3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:525:19: ( ruleScenario3[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:526:2: ruleScenario3[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario3ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario3_in_entryRuleScenario32368);
            ruleScenario3(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario32372); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:531:1: ruleScenario3[boolean p_AllowKeyword] : ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final void ruleScenario3(boolean p_AllowKeyword) throws RecognitionException {
        Token lv_second_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:532:1: ( ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:533:2: ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:533:2: ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred7_PsiInternalParametersTestLanguage(p_AllowKeyword)) ) {
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
            else if ( (LA11_0==RULE_ID) && (synpred7_PsiInternalParametersTestLanguage(p_AllowKeyword))) {
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:534:3: ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:534:3: ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:535:4: ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:539:4: (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:540:5: lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword]
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getScenario3_FirstIdOrKeywordParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_ruleScenario32431);
                    ruleIdOrKeyword(p_AllowKeyword);

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:550:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:550:3: ( (lv_second_1_0= 'keyword' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:551:4: (lv_second_1_0= 'keyword' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:551:4: (lv_second_1_0= 'keyword' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:552:5: lv_second_1_0= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getScenario3_SecondKeywordKeyword_1_0ElementType());
                      				
                    }
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScenario32478); if (state.failed) return ;
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


    // $ANTLR start "entryRuleScenario4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:565:1: entryRuleScenario4 : ruleScenario4[false] EOF ;
    public final void entryRuleScenario4() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:565:19: ( ruleScenario4[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:566:2: ruleScenario4[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario4ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_entryRuleScenario42509);
            ruleScenario4(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario42513); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:571:1: ruleScenario4[boolean p_AllowKeyword] : ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= 'keyword' ) ;
    public final void ruleScenario4(boolean p_AllowKeyword) throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:572:1: ( ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= 'keyword' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:573:2: ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= 'keyword' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:573:2: ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= 'keyword' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:574:3: ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= 'keyword'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:574:3: ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:575:4: ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:579:4: (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:580:5: lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword]
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getScenario4_SecondIdOrKeywordParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_ruleScenario42572);
            ruleIdOrKeyword(p_AllowKeyword);

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
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScenario42598); if (state.failed) return ;
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


    // $ANTLR start "entryRuleIdOrKeyword"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:600:1: entryRuleIdOrKeyword : ruleIdOrKeyword[false] EOF ;
    public final void entryRuleIdOrKeyword() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:600:21: ( ruleIdOrKeyword[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:601:2: ruleIdOrKeyword[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrKeywordElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_entryRuleIdOrKeyword2618);
            ruleIdOrKeyword(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdOrKeyword2622); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:606:1: ruleIdOrKeyword[boolean p_Keyword] : ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID ) ;
    public final void ruleIdOrKeyword(boolean p_Keyword) throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:607:1: ( ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:608:2: ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:608:2: ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( LA12_0 == 20 && p_Keyword ) {
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:609:3: ({...}? => (kw= 'keyword' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:609:3: ({...}? => (kw= 'keyword' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:610:4: {...}? => (kw= 'keyword' )
                    {
                    if ( ! p_Keyword ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "ruleIdOrKeyword", "p_Keyword");
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:610:18: (kw= 'keyword' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:610:19: kw= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getIdOrKeyword_KeywordKeyword_0_0ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIdOrKeyword2653); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:620:3: this_ID_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_IDTerminalRuleCall_1ElementType());
                      		
                    }
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdOrKeyword2685); if (state.failed) return ;
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

    // $ANTLR start synpred1_PsiInternalParametersTestLanguage
    public final void synpred1_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:152:5: ( ( '#5' ( ( ruleScenario2[true] ) ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:152:6: ( '#5' ( ( ruleScenario2[true] ) ) )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:152:6: ( '#5' ( ( ruleScenario2[true] ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:153:6: '#5' ( ( ruleScenario2[true] ) )
        {
        match(input,15,FollowSets000.FOLLOW_15_in_synpred1_PsiInternalParametersTestLanguage470); if (state.failed) return ;
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:154:6: ( ( ruleScenario2[true] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:155:7: ( ruleScenario2[true] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:155:7: ( ruleScenario2[true] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:156:8: ruleScenario2[true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_synpred1_PsiInternalParametersTestLanguage494);
        ruleScenario2(true);

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
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:184:5: ( ( '#6' ( ( ruleScenario2[false] ) ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:184:6: ( '#6' ( ( ruleScenario2[false] ) ) )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:184:6: ( '#6' ( ( ruleScenario2[false] ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:185:6: '#6' ( ( ruleScenario2[false] ) )
        {
        match(input,16,FollowSets000.FOLLOW_16_in_synpred2_PsiInternalParametersTestLanguage651); if (state.failed) return ;
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:186:6: ( ( ruleScenario2[false] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:187:7: ( ruleScenario2[false] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:187:7: ( ruleScenario2[false] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:188:8: ruleScenario2[false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_synpred2_PsiInternalParametersTestLanguage675);
        ruleScenario2(false);

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
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:267:7: ( ( ruleIdOrKeyword[true] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:267:8: ( ruleIdOrKeyword[true] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:267:8: ( ruleIdOrKeyword[true] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:268:8: ruleIdOrKeyword[true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred3_PsiInternalParametersTestLanguage1053);
        ruleIdOrKeyword(true);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_PsiInternalParametersTestLanguage

    // $ANTLR start synpred4_PsiInternalParametersTestLanguage
    public final void synpred4_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:317:7: ( ( ruleIdOrKeyword[true] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:317:8: ( ruleIdOrKeyword[true] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:317:8: ( ruleIdOrKeyword[true] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:318:8: ruleIdOrKeyword[true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred4_PsiInternalParametersTestLanguage1338);
        ruleIdOrKeyword(true);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_PsiInternalParametersTestLanguage

    // $ANTLR start synpred5_PsiInternalParametersTestLanguage
    public final void synpred5_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:367:7: ( ( ruleIdOrKeyword[false] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:367:8: ( ruleIdOrKeyword[false] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:367:8: ( ruleIdOrKeyword[false] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:368:8: ruleIdOrKeyword[false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred5_PsiInternalParametersTestLanguage1623);
        ruleIdOrKeyword(false);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_PsiInternalParametersTestLanguage

    // $ANTLR start synpred6_PsiInternalParametersTestLanguage
    public final void synpred6_PsiInternalParametersTestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:417:7: ( ( ruleIdOrKeyword[false] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:417:8: ( ruleIdOrKeyword[false] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:417:8: ( ruleIdOrKeyword[false] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:418:8: ruleIdOrKeyword[false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred6_PsiInternalParametersTestLanguage1908);
        ruleIdOrKeyword(false);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_PsiInternalParametersTestLanguage

    // $ANTLR start synpred7_PsiInternalParametersTestLanguage
    public final void synpred7_PsiInternalParametersTestLanguage_fragment(boolean p_AllowKeyword) throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:535:4: ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:535:5: ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:535:5: ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguage.g:536:5: ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred7_PsiInternalParametersTestLanguage2400);
        ruleIdOrKeyword(p_AllowKeyword);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_PsiInternalParametersTestLanguage

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
    public final boolean synpred7_PsiInternalParametersTestLanguage(boolean p_AllowKeyword) {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalParametersTestLanguage_fragment(p_AllowKeyword); // can never throw exception
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
            return "66:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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
        public static final BitSet FOLLOW_ruleParserRuleParameters_in_entryRuleParserRuleParameters54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRuleParameters57 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleParserRuleParameters102 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario1_in_ruleParserRuleParameters139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleParserRuleParameters194 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario1_in_ruleParserRuleParameters231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleParserRuleParameters286 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleParserRuleParameters378 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParserRuleParameters545 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleParserRuleParameters726 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleParserRuleParameters832 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario3_in_ruleParserRuleParameters869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleParserRuleParameters924 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario3_in_ruleParserRuleParameters961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleParserRuleParameters1016 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters1099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters1181 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters1237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleParserRuleParameters1301 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters1384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters1466 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters1522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleParserRuleParameters1586 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters1669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters1751 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters1807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleParserRuleParameters1871 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters1954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters2036 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters2092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_in_entryRuleScenario12148 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario12152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleScenario12198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleScenario12267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_entryRuleScenario22310 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario22314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_ruleScenario22342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario3_in_entryRuleScenario32368 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario32372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_ruleScenario32431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleScenario32478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario4_in_entryRuleScenario42509 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario42513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_ruleScenario42572 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleScenario42598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_entryRuleIdOrKeyword2618 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdOrKeyword2622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleIdOrKeyword2653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdOrKeyword2685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_synpred1_PsiInternalParametersTestLanguage470 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_synpred1_PsiInternalParametersTestLanguage494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_synpred2_PsiInternalParametersTestLanguage651 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_synpred2_PsiInternalParametersTestLanguage675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred3_PsiInternalParametersTestLanguage1053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred4_PsiInternalParametersTestLanguage1338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred5_PsiInternalParametersTestLanguage1623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred6_PsiInternalParametersTestLanguage1908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred7_PsiInternalParametersTestLanguage2400 = new BitSet(new long[]{0x0000000000000002L});
    }


}